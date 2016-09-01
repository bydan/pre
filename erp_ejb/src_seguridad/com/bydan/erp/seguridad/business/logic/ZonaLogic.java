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
import com.bydan.erp.seguridad.util.ZonaConstantesFunciones;
import com.bydan.erp.seguridad.util.ZonaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ZonaParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Zona;
import com.bydan.erp.seguridad.business.logic.ZonaLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;








@SuppressWarnings("unused")
public class ZonaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ZonaLogic.class);
	
	protected ZonaDataAccess zonaDataAccess; 	
	protected Zona zona;
	protected List<Zona> zonas;
	protected Object zonaObject;	
	protected List<Object> zonasObject;
	
	public static ClassValidator<Zona> zonaValidator = new ClassValidator<Zona>(Zona.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ZonaLogicAdditional zonaLogicAdditional=null;
	
	public ZonaLogicAdditional getZonaLogicAdditional() {
		return this.zonaLogicAdditional;
	}
	
	public void setZonaLogicAdditional(ZonaLogicAdditional zonaLogicAdditional) {
		try {
			this.zonaLogicAdditional=zonaLogicAdditional;
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
	
	
	
	
	public  ZonaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.zonaDataAccess = new ZonaDataAccess();
			
			this.zonas= new ArrayList<Zona>();
			this.zona= new Zona();
			
			this.zonaObject=new Object();
			this.zonasObject=new ArrayList<Object>();
				
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
			
			this.zonaDataAccess.setConnexionType(this.connexionType);
			this.zonaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ZonaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.zonaDataAccess = new ZonaDataAccess();
			this.zonas= new ArrayList<Zona>();
			this.zona= new Zona();
			this.zonaObject=new Object();
			this.zonasObject=new ArrayList<Object>();
			
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
			
			this.zonaDataAccess.setConnexionType(this.connexionType);
			this.zonaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Zona getZona() throws Exception {	
		ZonaLogicAdditional.checkZonaToGet(zona,this.datosCliente,this.arrDatoGeneral);
		ZonaLogicAdditional.updateZonaToGet(zona,this.arrDatoGeneral);
		
		return zona;
	}
		
	public void setZona(Zona newZona) {
		this.zona = newZona;
	}
	
	public ZonaDataAccess getZonaDataAccess() {
		return zonaDataAccess;
	}
	
	public void setZonaDataAccess(ZonaDataAccess newzonaDataAccess) {
		this.zonaDataAccess = newzonaDataAccess;
	}
	
	public List<Zona> getZonas() throws Exception {		
		this.quitarZonasNulos();
		
		ZonaLogicAdditional.checkZonaToGets(zonas,this.datosCliente,this.arrDatoGeneral);
		
		for (Zona zonaLocal: zonas ) {
			ZonaLogicAdditional.updateZonaToGet(zonaLocal,this.arrDatoGeneral);
		}
		
		return zonas;
	}
	
	public void setZonas(List<Zona> newZonas) {
		this.zonas = newZonas;
	}
	
	public Object getZonaObject() {	
		this.zonaObject=this.zonaDataAccess.getEntityObject();
		return this.zonaObject;
	}
		
	public void setZonaObject(Object newZonaObject) {
		this.zonaObject = newZonaObject;
	}
	
	public List<Object> getZonasObject() {		
		this.zonasObject=this.zonaDataAccess.getEntitiesObject();
		return this.zonasObject;
	}
		
	public void setZonasObject(List<Object> newZonasObject) {
		this.zonasObject = newZonasObject;
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
		
		if(this.zonaDataAccess!=null) {
			this.zonaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			zonaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			zonaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		zona = new  Zona();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			zona=zonaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.zona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zona);
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
		zona = new  Zona();
		  		  
        try {
			
			zona=zonaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.zona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zona);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		zona = new  Zona();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			zona=zonaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.zona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zona);
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
		zona = new  Zona();
		  		  
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
		zona = new  Zona();
		  		  
        try {
			
			zona=zonaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.zona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zona);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		zona = new  Zona();
		  		  
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
		zona = new  Zona();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =zonaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		zona = new  Zona();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=zonaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		zona = new  Zona();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =zonaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		zona = new  Zona();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=zonaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		zona = new  Zona();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =zonaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		zona = new  Zona();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=zonaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		zonas = new  ArrayList<Zona>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zonas=zonaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarZona(zonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
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
		zonas = new  ArrayList<Zona>();
		  		  
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
		zonas = new  ArrayList<Zona>();
		  		  
        try {			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zonas=zonaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarZona(zonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		zonas = new  ArrayList<Zona>();
		  		  
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
		zonas = new  ArrayList<Zona>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zonas=zonaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarZona(zonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
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
		zonas = new  ArrayList<Zona>();
		  		  
        try {
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zonas=zonaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarZona(zonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
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
		zonas = new  ArrayList<Zona>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zonas=zonaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarZona(zonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
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
		zonas = new  ArrayList<Zona>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zonas=zonaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarZona(zonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		zona = new  Zona();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zona=zonaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarZona(zona);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zona);
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
		zona = new  Zona();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zona=zonaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarZona(zona);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zona);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		zonas = new  ArrayList<Zona>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zonas=zonaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarZona(zonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
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
		zonas = new  ArrayList<Zona>();
		  		  
        try {
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zonas=zonaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarZona(zonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosZonasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		zonas = new  ArrayList<Zona>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getTodosZonasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zonas=zonaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarZona(zonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
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
	
	public  void  getTodosZonas(String sFinalQuery,Pagination pagination)throws Exception {
		zonas = new  ArrayList<Zona>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			zonas=zonaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarZona(zonas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarZona(Zona zona) throws Exception {
		Boolean estaValidado=false;
		
		if(zona.getIsNew() || zona.getIsChanged()) { 
			this.invalidValues = zonaValidator.getInvalidValues(zona);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(zona);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarZona(List<Zona> Zonas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Zona zonaLocal:zonas) {				
			estaValidadoObjeto=this.validarGuardarZona(zonaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarZona(List<Zona> Zonas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarZona(zonas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarZona(Zona Zona) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarZona(zona)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Zona zona) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+zona.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ZonaConstantesFunciones.getZonaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"zona","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ZonaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ZonaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveZonaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-saveZonaWithConnection");connexion.begin();			
			
			ZonaLogicAdditional.checkZonaToSave(this.zona,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ZonaLogicAdditional.updateZonaToSave(this.zona,this.arrDatoGeneral);
			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.zona,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowZona();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarZona(this.zona)) {
				ZonaDataAccess.save(this.zona, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.zona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ZonaLogicAdditional.checkZonaToSaveAfter(this.zona,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowZona();
			
			connexion.commit();			
			
			if(this.zona.getIsDeleted()) {
				this.zona=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveZona()throws Exception {	
		try {	
			
			ZonaLogicAdditional.checkZonaToSave(this.zona,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ZonaLogicAdditional.updateZonaToSave(this.zona,this.arrDatoGeneral);
			
			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.zona,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarZona(this.zona)) {			
				ZonaDataAccess.save(this.zona, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.zona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ZonaLogicAdditional.checkZonaToSaveAfter(this.zona,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.zona.getIsDeleted()) {
				this.zona=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveZonasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-saveZonasWithConnection");connexion.begin();			
			
			ZonaLogicAdditional.checkZonaToSaves(zonas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowZonas();
			
			Boolean validadoTodosZona=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Zona zonaLocal:zonas) {		
				if(zonaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ZonaLogicAdditional.updateZonaToSave(zonaLocal,this.arrDatoGeneral);
	        	
				ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),zonaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarZona(zonaLocal)) {
					ZonaDataAccess.save(zonaLocal, connexion);				
				} else {
					validadoTodosZona=false;
				}
			}
			
			if(!validadoTodosZona) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ZonaLogicAdditional.checkZonaToSavesAfter(zonas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowZonas();
			
			connexion.commit();		
			
			this.quitarZonasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveZonas()throws Exception {				
		 try {	
			ZonaLogicAdditional.checkZonaToSaves(zonas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosZona=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Zona zonaLocal:zonas) {				
				if(zonaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ZonaLogicAdditional.updateZonaToSave(zonaLocal,this.arrDatoGeneral);
	        	
				ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),zonaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarZona(zonaLocal)) {				
					ZonaDataAccess.save(zonaLocal, connexion);				
				} else {
					validadoTodosZona=false;
				}
			}
			
			if(!validadoTodosZona) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ZonaLogicAdditional.checkZonaToSavesAfter(zonas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarZonasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ZonaParameterReturnGeneral procesarAccionZonas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Zona> zonas,ZonaParameterReturnGeneral zonaParameterGeneral)throws Exception {
		 try {	
			ZonaParameterReturnGeneral zonaReturnGeneral=new ZonaParameterReturnGeneral();
	
			ZonaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,zonas,zonaParameterGeneral,zonaReturnGeneral);
			
			return zonaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ZonaParameterReturnGeneral procesarAccionZonasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Zona> zonas,ZonaParameterReturnGeneral zonaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-procesarAccionZonasWithConnection");connexion.begin();			
			
			ZonaParameterReturnGeneral zonaReturnGeneral=new ZonaParameterReturnGeneral();
	
			ZonaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,zonas,zonaParameterGeneral,zonaReturnGeneral);
			
			this.connexion.commit();
			
			return zonaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ZonaParameterReturnGeneral procesarEventosZonas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Zona> zonas,Zona zona,ZonaParameterReturnGeneral zonaParameterGeneral,Boolean isEsNuevoZona,ArrayList<Classe> clases)throws Exception {
		 try {	
			ZonaParameterReturnGeneral zonaReturnGeneral=new ZonaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				zonaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ZonaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,zonas,zona,zonaParameterGeneral,zonaReturnGeneral,isEsNuevoZona,clases);
			
			return zonaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ZonaParameterReturnGeneral procesarEventosZonasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Zona> zonas,Zona zona,ZonaParameterReturnGeneral zonaParameterGeneral,Boolean isEsNuevoZona,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-procesarEventosZonasWithConnection");connexion.begin();			
			
			ZonaParameterReturnGeneral zonaReturnGeneral=new ZonaParameterReturnGeneral();
	
			zonaReturnGeneral.setZona(zona);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				zonaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ZonaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,zonas,zona,zonaParameterGeneral,zonaReturnGeneral,isEsNuevoZona,clases);
			
			this.connexion.commit();
			
			return zonaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ZonaParameterReturnGeneral procesarImportacionZonasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ZonaParameterReturnGeneral zonaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-procesarImportacionZonasWithConnection");connexion.begin();			
			
			ZonaParameterReturnGeneral zonaReturnGeneral=new ZonaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.zonas=new ArrayList<Zona>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.zona=new Zona();
				
				
				if(conColumnasBase) {this.zona.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.zona.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.zona.setnombre(arrColumnas[iColumn++]);
				
				this.zonas.add(this.zona);
			}
			
			this.saveZonas();
			
			this.connexion.commit();
			
			zonaReturnGeneral.setConRetornoEstaProcesado(true);
			zonaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return zonaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarZonasEliminados() throws Exception {				
		
		List<Zona> zonasAux= new ArrayList<Zona>();
		
		for(Zona zona:zonas) {
			if(!zona.getIsDeleted()) {
				zonasAux.add(zona);
			}
		}
		
		zonas=zonasAux;
	}
	
	public void quitarZonasNulos() throws Exception {				
		
		List<Zona> zonasAux= new ArrayList<Zona>();
		
		for(Zona zona : this.zonas) {
			if(zona==null) {
				zonasAux.add(zona);
			}
		}
		
		//this.zonas=zonasAux;
		
		this.zonas.removeAll(zonasAux);
	}
	
	public void getSetVersionRowZonaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(zona.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((zona.getIsDeleted() || (zona.getIsChanged()&&!zona.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=zonaDataAccess.getSetVersionRowZona(connexion,zona.getId());
				
				if(!zona.getVersionRow().equals(timestamp)) {	
					zona.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				zona.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowZona()throws Exception {	
		
		if(zona.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((zona.getIsDeleted() || (zona.getIsChanged()&&!zona.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=zonaDataAccess.getSetVersionRowZona(connexion,zona.getId());
			
			try {							
				if(!zona.getVersionRow().equals(timestamp)) {	
					zona.setVersionRow(timestamp);
				}
				
				zona.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowZonasWithConnection()throws Exception {	
		if(zonas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Zona zonaAux:zonas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(zonaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(zonaAux.getIsDeleted() || (zonaAux.getIsChanged()&&!zonaAux.getIsNew())) {
						
						timestamp=zonaDataAccess.getSetVersionRowZona(connexion,zonaAux.getId());
						
						if(!zona.getVersionRow().equals(timestamp)) {	
							zonaAux.setVersionRow(timestamp);
						}
								
						zonaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowZonas()throws Exception {	
		if(zonas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Zona zonaAux:zonas) {
					if(zonaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(zonaAux.getIsDeleted() || (zonaAux.getIsChanged()&&!zonaAux.getIsNew())) {
						
						timestamp=zonaDataAccess.getSetVersionRowZona(connexion,zonaAux.getId());
						
						if(!zonaAux.getVersionRow().equals(timestamp)) {	
							zonaAux.setVersionRow(timestamp);
						}
						
													
						zonaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ZonaParameterReturnGeneral cargarCombosLoteForeignKeyZonaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal) throws Exception {
		ZonaParameterReturnGeneral  zonaReturnGeneral =new ZonaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-cargarCombosLoteForeignKeyZonaWithConnection");connexion.begin();
			
			zonaReturnGeneral =new ZonaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			zonaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			zonaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return zonaReturnGeneral;
	}
	
	public ZonaParameterReturnGeneral cargarCombosLoteForeignKeyZona(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal) throws Exception {
		ZonaParameterReturnGeneral  zonaReturnGeneral =new ZonaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			zonaReturnGeneral =new ZonaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			zonaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			zonaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return zonaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyZonaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			VendedorLogic vendedorLogic=new VendedorLogic();
			ClienteLogic clienteLogic=new ClienteLogic();
			VendedorZonaLogic vendedorzonaLogic=new VendedorZonaLogic();
			PresupuestoVentasLogic presupuestoventasLogic=new PresupuestoVentasLogic();
			PresupuestoVentasLineasLogic presupuestoventaslineasLogic=new PresupuestoVentasLineasLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyZonaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(SubCliente.class));
			classes.add(new Classe(Vendedor.class));
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(VendedorZona.class));
			classes.add(new Classe(PresupuestoVentas.class));
			classes.add(new Classe(PresupuestoVentasLineas.class));
											
			

			subclienteLogic.setConnexion(this.getConnexion());
			subclienteLogic.setDatosCliente(this.datosCliente);
			subclienteLogic.setIsConRefrescarForeignKeys(true);

			vendedorLogic.setConnexion(this.getConnexion());
			vendedorLogic.setDatosCliente(this.datosCliente);
			vendedorLogic.setIsConRefrescarForeignKeys(true);

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			vendedorzonaLogic.setConnexion(this.getConnexion());
			vendedorzonaLogic.setDatosCliente(this.datosCliente);
			vendedorzonaLogic.setIsConRefrescarForeignKeys(true);

			presupuestoventasLogic.setConnexion(this.getConnexion());
			presupuestoventasLogic.setDatosCliente(this.datosCliente);
			presupuestoventasLogic.setIsConRefrescarForeignKeys(true);

			presupuestoventaslineasLogic.setConnexion(this.getConnexion());
			presupuestoventaslineasLogic.setDatosCliente(this.datosCliente);
			presupuestoventaslineasLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Zona zona:this.zonas) {
				

				classes=new ArrayList<Classe>();
				classes=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				subclienteLogic.setSubClientes(zona.subclientes);
				subclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=VendedorConstantesFunciones.getClassesForeignKeysOfVendedor(new ArrayList<Classe>(),DeepLoadType.NONE);

				vendedorLogic.setVendedors(zona.vendedors);
				vendedorLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(zona.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=VendedorZonaConstantesFunciones.getClassesForeignKeysOfVendedorZona(new ArrayList<Classe>(),DeepLoadType.NONE);

				vendedorzonaLogic.setVendedorZonas(zona.vendedorzonas);
				vendedorzonaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PresupuestoVentasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentas(new ArrayList<Classe>(),DeepLoadType.NONE);

				presupuestoventasLogic.setPresupuestoVentass(zona.presupuestoventass);
				presupuestoventasLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PresupuestoVentasLineasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentasLineas(new ArrayList<Classe>(),DeepLoadType.NONE);

				presupuestoventaslineasLogic.setPresupuestoVentasLineass(zona.presupuestoventaslineass);
				presupuestoventaslineasLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Zona zona,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ZonaLogicAdditional.updateZonaToGet(zona,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		zona.setEmpresa(zonaDataAccess.getEmpresa(connexion,zona));
		zona.setSucursal(zonaDataAccess.getSucursal(connexion,zona));
		zona.setPresupuestoVentasLineass(zonaDataAccess.getPresupuestoVentasLineass(connexion,zona));
		zona.setVendedors(zonaDataAccess.getVendedors(connexion,zona));
		zona.setClientes(zonaDataAccess.getClientes(connexion,zona));
		zona.setSubClientes(zonaDataAccess.getSubClientes(connexion,zona));
		zona.setPresupuestoVentass(zonaDataAccess.getPresupuestoVentass(connexion,zona));
		zona.setVendedorZonas(zonaDataAccess.getVendedorZonas(connexion,zona));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				zona.setEmpresa(zonaDataAccess.getEmpresa(connexion,zona));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				zona.setSucursal(zonaDataAccess.getSucursal(connexion,zona));
				continue;
			}

			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setPresupuestoVentasLineass(zonaDataAccess.getPresupuestoVentasLineass(connexion,zona));

				if(this.isConDeep) {
					PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(this.connexion);
					presupuestoventaslineasLogic.setPresupuestoVentasLineass(zona.getPresupuestoVentasLineass());
					ArrayList<Classe> classesLocal=PresupuestoVentasLineasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentasLineas(new ArrayList<Classe>(),DeepLoadType.NONE);
					presupuestoventaslineasLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(presupuestoventaslineasLogic.getPresupuestoVentasLineass());
					zona.setPresupuestoVentasLineass(presupuestoventaslineasLogic.getPresupuestoVentasLineass());
				}

				continue;
			}

			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setVendedors(zonaDataAccess.getVendedors(connexion,zona));

				if(this.isConDeep) {
					VendedorLogic vendedorLogic= new VendedorLogic(this.connexion);
					vendedorLogic.setVendedors(zona.getVendedors());
					ArrayList<Classe> classesLocal=VendedorConstantesFunciones.getClassesForeignKeysOfVendedor(new ArrayList<Classe>(),DeepLoadType.NONE);
					vendedorLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					VendedorConstantesFunciones.refrescarForeignKeysDescripcionesVendedor(vendedorLogic.getVendedors());
					zona.setVendedors(vendedorLogic.getVendedors());
				}

				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setClientes(zonaDataAccess.getClientes(connexion,zona));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(zona.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					zona.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setSubClientes(zonaDataAccess.getSubClientes(connexion,zona));

				if(this.isConDeep) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(this.connexion);
					subclienteLogic.setSubClientes(zona.getSubClientes());
					ArrayList<Classe> classesLocal=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					subclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(subclienteLogic.getSubClientes());
					zona.setSubClientes(subclienteLogic.getSubClientes());
				}

				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setPresupuestoVentass(zonaDataAccess.getPresupuestoVentass(connexion,zona));

				if(this.isConDeep) {
					PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(this.connexion);
					presupuestoventasLogic.setPresupuestoVentass(zona.getPresupuestoVentass());
					ArrayList<Classe> classesLocal=PresupuestoVentasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentas(new ArrayList<Classe>(),DeepLoadType.NONE);
					presupuestoventasLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(presupuestoventasLogic.getPresupuestoVentass());
					zona.setPresupuestoVentass(presupuestoventasLogic.getPresupuestoVentass());
				}

				continue;
			}

			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setVendedorZonas(zonaDataAccess.getVendedorZonas(connexion,zona));

				if(this.isConDeep) {
					VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(this.connexion);
					vendedorzonaLogic.setVendedorZonas(zona.getVendedorZonas());
					ArrayList<Classe> classesLocal=VendedorZonaConstantesFunciones.getClassesForeignKeysOfVendedorZona(new ArrayList<Classe>(),DeepLoadType.NONE);
					vendedorzonaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					VendedorZonaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorZona(vendedorzonaLogic.getVendedorZonas());
					zona.setVendedorZonas(vendedorzonaLogic.getVendedorZonas());
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
			zona.setEmpresa(zonaDataAccess.getEmpresa(connexion,zona));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			zona.setSucursal(zonaDataAccess.getSucursal(connexion,zona));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentasLineas.class));
			zona.setPresupuestoVentasLineass(zonaDataAccess.getPresupuestoVentasLineass(connexion,zona));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Vendedor.class));
			zona.setVendedors(zonaDataAccess.getVendedors(connexion,zona));
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
			zona.setClientes(zonaDataAccess.getClientes(connexion,zona));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubCliente.class));
			zona.setSubClientes(zonaDataAccess.getSubClientes(connexion,zona));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentas.class));
			zona.setPresupuestoVentass(zonaDataAccess.getPresupuestoVentass(connexion,zona));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(VendedorZona.class));
			zona.setVendedorZonas(zonaDataAccess.getVendedorZonas(connexion,zona));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		zona.setEmpresa(zonaDataAccess.getEmpresa(connexion,zona));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(zona.getEmpresa(),isDeep,deepLoadType,clases);
				
		zona.setSucursal(zonaDataAccess.getSucursal(connexion,zona));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(zona.getSucursal(),isDeep,deepLoadType,clases);
				

		zona.setPresupuestoVentasLineass(zonaDataAccess.getPresupuestoVentasLineass(connexion,zona));

		for(PresupuestoVentasLineas presupuestoventaslineas:zona.getPresupuestoVentasLineass()) {
			PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
			presupuestoventaslineasLogic.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);
		}

		zona.setVendedors(zonaDataAccess.getVendedors(connexion,zona));

		for(Vendedor vendedor:zona.getVendedors()) {
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(vendedor,isDeep,deepLoadType,clases);
		}

		zona.setClientes(zonaDataAccess.getClientes(connexion,zona));

		for(Cliente cliente:zona.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		zona.setSubClientes(zonaDataAccess.getSubClientes(connexion,zona));

		for(SubCliente subcliente:zona.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
		}

		zona.setPresupuestoVentass(zonaDataAccess.getPresupuestoVentass(connexion,zona));

		for(PresupuestoVentas presupuestoventas:zona.getPresupuestoVentass()) {
			PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
			presupuestoventasLogic.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);
		}

		zona.setVendedorZonas(zonaDataAccess.getVendedorZonas(connexion,zona));

		for(VendedorZona vendedorzona:zona.getVendedorZonas()) {
			VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(connexion);
			vendedorzonaLogic.deepLoad(vendedorzona,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				zona.setEmpresa(zonaDataAccess.getEmpresa(connexion,zona));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(zona.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				zona.setSucursal(zonaDataAccess.getSucursal(connexion,zona));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(zona.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setPresupuestoVentasLineass(zonaDataAccess.getPresupuestoVentasLineass(connexion,zona));

				for(PresupuestoVentasLineas presupuestoventaslineas:zona.getPresupuestoVentasLineass()) {
					PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
					presupuestoventaslineasLogic.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setVendedors(zonaDataAccess.getVendedors(connexion,zona));

				for(Vendedor vendedor:zona.getVendedors()) {
					VendedorLogic vendedorLogic= new VendedorLogic(connexion);
					vendedorLogic.deepLoad(vendedor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setClientes(zonaDataAccess.getClientes(connexion,zona));

				for(Cliente cliente:zona.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setSubClientes(zonaDataAccess.getSubClientes(connexion,zona));

				for(SubCliente subcliente:zona.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setPresupuestoVentass(zonaDataAccess.getPresupuestoVentass(connexion,zona));

				for(PresupuestoVentas presupuestoventas:zona.getPresupuestoVentass()) {
					PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
					presupuestoventasLogic.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				zona.setVendedorZonas(zonaDataAccess.getVendedorZonas(connexion,zona));

				for(VendedorZona vendedorzona:zona.getVendedorZonas()) {
					VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(connexion);
					vendedorzonaLogic.deepLoad(vendedorzona,isDeep,deepLoadType,clases);
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
			zona.setEmpresa(zonaDataAccess.getEmpresa(connexion,zona));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(zona.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			zona.setSucursal(zonaDataAccess.getSucursal(connexion,zona));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(zona.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentasLineas.class));
			zona.setPresupuestoVentasLineass(zonaDataAccess.getPresupuestoVentasLineass(connexion,zona));

			for(PresupuestoVentasLineas presupuestoventaslineas:zona.getPresupuestoVentasLineass()) {
				PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
				presupuestoventaslineasLogic.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Vendedor.class));
			zona.setVendedors(zonaDataAccess.getVendedors(connexion,zona));

			for(Vendedor vendedor:zona.getVendedors()) {
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(vendedor,isDeep,deepLoadType,clases);
			}
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
			zona.setClientes(zonaDataAccess.getClientes(connexion,zona));

			for(Cliente cliente:zona.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubCliente.class));
			zona.setSubClientes(zonaDataAccess.getSubClientes(connexion,zona));

			for(SubCliente subcliente:zona.getSubClientes()) {
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentas.class));
			zona.setPresupuestoVentass(zonaDataAccess.getPresupuestoVentass(connexion,zona));

			for(PresupuestoVentas presupuestoventas:zona.getPresupuestoVentass()) {
				PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
				presupuestoventasLogic.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(VendedorZona.class));
			zona.setVendedorZonas(zonaDataAccess.getVendedorZonas(connexion,zona));

			for(VendedorZona vendedorzona:zona.getVendedorZonas()) {
				VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(connexion);
				vendedorzonaLogic.deepLoad(vendedorzona,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Zona zona,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ZonaLogicAdditional.updateZonaToSave(zona,this.arrDatoGeneral);
			
ZonaDataAccess.save(zona, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(zona.getEmpresa(),connexion);

		SucursalDataAccess.save(zona.getSucursal(),connexion);

		for(PresupuestoVentasLineas presupuestoventaslineas:zona.getPresupuestoVentasLineass()) {
			presupuestoventaslineas.setid_zona(zona.getId());
			PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
		}

		for(Vendedor vendedor:zona.getVendedors()) {
			vendedor.setid_zona(zona.getId());
			VendedorDataAccess.save(vendedor,connexion);
		}

		for(Cliente cliente:zona.getClientes()) {
			cliente.setid_zona(zona.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(SubCliente subcliente:zona.getSubClientes()) {
			subcliente.setid_zona(zona.getId());
			SubClienteDataAccess.save(subcliente,connexion);
		}

		for(PresupuestoVentas presupuestoventas:zona.getPresupuestoVentass()) {
			presupuestoventas.setid_zona(zona.getId());
			PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
		}

		for(VendedorZona vendedorzona:zona.getVendedorZonas()) {
			vendedorzona.setid_zona(zona.getId());
			VendedorZonaDataAccess.save(vendedorzona,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(zona.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(zona.getSucursal(),connexion);
				continue;
			}


			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentasLineas presupuestoventaslineas:zona.getPresupuestoVentasLineass()) {
					presupuestoventaslineas.setid_zona(zona.getId());
					PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Vendedor vendedor:zona.getVendedors()) {
					vendedor.setid_zona(zona.getId());
					VendedorDataAccess.save(vendedor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:zona.getClientes()) {
					cliente.setid_zona(zona.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:zona.getSubClientes()) {
					subcliente.setid_zona(zona.getId());
					SubClienteDataAccess.save(subcliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentas presupuestoventas:zona.getPresupuestoVentass()) {
					presupuestoventas.setid_zona(zona.getId());
					PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
				}
				continue;
			}

			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(VendedorZona vendedorzona:zona.getVendedorZonas()) {
					vendedorzona.setid_zona(zona.getId());
					VendedorZonaDataAccess.save(vendedorzona,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(zona.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(zona.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(zona.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(zona.getSucursal(),isDeep,deepLoadType,clases);
				

		for(PresupuestoVentasLineas presupuestoventaslineas:zona.getPresupuestoVentasLineass()) {
			PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
			presupuestoventaslineas.setid_zona(zona.getId());
			PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
			presupuestoventaslineasLogic.deepSave(presupuestoventaslineas,isDeep,deepLoadType,clases);
		}

		for(Vendedor vendedor:zona.getVendedors()) {
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedor.setid_zona(zona.getId());
			VendedorDataAccess.save(vendedor,connexion);
			vendedorLogic.deepSave(vendedor,isDeep,deepLoadType,clases);
		}

		for(Cliente cliente:zona.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_zona(zona.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(SubCliente subcliente:zona.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subcliente.setid_zona(zona.getId());
			SubClienteDataAccess.save(subcliente,connexion);
			subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
		}

		for(PresupuestoVentas presupuestoventas:zona.getPresupuestoVentass()) {
			PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
			presupuestoventas.setid_zona(zona.getId());
			PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
			presupuestoventasLogic.deepSave(presupuestoventas,isDeep,deepLoadType,clases);
		}

		for(VendedorZona vendedorzona:zona.getVendedorZonas()) {
			VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(connexion);
			vendedorzona.setid_zona(zona.getId());
			VendedorZonaDataAccess.save(vendedorzona,connexion);
			vendedorzonaLogic.deepSave(vendedorzona,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(zona.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(zona.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(zona.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(zona.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PresupuestoVentasLineas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentasLineas presupuestoventaslineas:zona.getPresupuestoVentasLineass()) {
					PresupuestoVentasLineasLogic presupuestoventaslineasLogic= new PresupuestoVentasLineasLogic(connexion);
					presupuestoventaslineas.setid_zona(zona.getId());
					PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas,connexion);
					presupuestoventaslineasLogic.deepSave(presupuestoventaslineas,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Vendedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Vendedor vendedor:zona.getVendedors()) {
					VendedorLogic vendedorLogic= new VendedorLogic(connexion);
					vendedor.setid_zona(zona.getId());
					VendedorDataAccess.save(vendedor,connexion);
					vendedorLogic.deepSave(vendedor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:zona.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_zona(zona.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:zona.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subcliente.setid_zona(zona.getId());
					SubClienteDataAccess.save(subcliente,connexion);
					subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentas.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresupuestoVentas presupuestoventas:zona.getPresupuestoVentass()) {
					PresupuestoVentasLogic presupuestoventasLogic= new PresupuestoVentasLogic(connexion);
					presupuestoventas.setid_zona(zona.getId());
					PresupuestoVentasDataAccess.save(presupuestoventas,connexion);
					presupuestoventasLogic.deepSave(presupuestoventas,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(VendedorZona.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(VendedorZona vendedorzona:zona.getVendedorZonas()) {
					VendedorZonaLogic vendedorzonaLogic= new VendedorZonaLogic(connexion);
					vendedorzona.setid_zona(zona.getId());
					VendedorZonaDataAccess.save(vendedorzona,connexion);
					vendedorzonaLogic.deepSave(vendedorzona,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Zona.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(zona,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(zona);
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
			this.deepLoad(this.zona,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zona);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Zona.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(zonas!=null) {
				for(Zona zona:zonas) {
					this.deepLoad(zona,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(zonas);
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
			if(zonas!=null) {
				for(Zona zona:zonas) {
					this.deepLoad(zona,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(zonas);
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
			this.getNewConnexionToDeep(Zona.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(zona,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Zona.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(zonas!=null) {
				for(Zona zona:zonas) {
					this.deepSave(zona,isDeep,deepLoadType,clases);
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
			if(zonas!=null) {
				for(Zona zona:zonas) {
					this.deepSave(zona,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getZonasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ZonaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			zonas=zonaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getZonasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ZonaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			zonas=zonaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getZonasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ZonaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			zonas=zonaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getZonasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ZonaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			zonas=zonaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getZonasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ZonaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			zonas=zonaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getZonasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ZonaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ZonaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			zonas=zonaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zonas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getZonaPorIdEmpresaPorIdSucursalPorNombreWithConnection(Long id_empresa,Long id_sucursal,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ZonaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ZonaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,ZonaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			zona=zonaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.zona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zona);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getZonaPorIdEmpresaPorIdSucursalPorNombre(Long id_empresa,Long id_sucursal,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ZonaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ZonaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,ZonaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			zona=zonaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.zona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zona);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getZonaPorIdPorIdEmpresaPorIdSucursalWithConnection(Long id,Long id_empresa,Long id_sucursal)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Zona.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,ZonaConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ZonaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ZonaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			zona=zonaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.zona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zona);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getZonaPorIdPorIdEmpresaPorIdSucursal(Long id,Long id_empresa,Long id_sucursal)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,ZonaConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ZonaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ZonaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			zona=zonaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.zona,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ZonaConstantesFunciones.refrescarForeignKeysDescripcionesZona(this.zona);
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
			if(ZonaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ZonaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Zona zona,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ZonaConstantesFunciones.ISCONAUDITORIA) {
				if(zona.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ZonaDataAccess.TABLENAME, zona.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ZonaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ZonaLogic.registrarAuditoriaDetallesZona(connexion,zona,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(zona.getIsDeleted()) {
					/*if(!zona.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ZonaDataAccess.TABLENAME, zona.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ZonaLogic.registrarAuditoriaDetallesZona(connexion,zona,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ZonaDataAccess.TABLENAME, zona.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(zona.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ZonaDataAccess.TABLENAME, zona.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ZonaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ZonaLogic.registrarAuditoriaDetallesZona(connexion,zona,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesZona(Connexion connexion,Zona zona)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(zona.getIsNew()||!zona.getid_empresa().equals(zona.getZonaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(zona.getZonaOriginal().getid_empresa()!=null)
				{
					strValorActual=zona.getZonaOriginal().getid_empresa().toString();
				}
				if(zona.getid_empresa()!=null)
				{
					strValorNuevo=zona.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ZonaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(zona.getIsNew()||!zona.getid_sucursal().equals(zona.getZonaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(zona.getZonaOriginal().getid_sucursal()!=null)
				{
					strValorActual=zona.getZonaOriginal().getid_sucursal().toString();
				}
				if(zona.getid_sucursal()!=null)
				{
					strValorNuevo=zona.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ZonaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(zona.getIsNew()||!zona.getnombre().equals(zona.getZonaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(zona.getZonaOriginal().getnombre()!=null)
				{
					strValorActual=zona.getZonaOriginal().getnombre();
				}
				if(zona.getnombre()!=null)
				{
					strValorNuevo=zona.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ZonaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveZonaRelacionesWithConnection(Zona zona,List<PresupuestoVentasLineas> presupuestoventaslineass,List<Vendedor> vendedors,List<Cliente> clientes,List<SubCliente> subclientes,List<PresupuestoVentas> presupuestoventass,List<VendedorZona> vendedorzonas) throws Exception {

		if(!zona.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveZonaRelacionesBase(zona,presupuestoventaslineass,vendedors,clientes,subclientes,presupuestoventass,vendedorzonas,true);
		}
	}

	public void saveZonaRelaciones(Zona zona,List<PresupuestoVentasLineas> presupuestoventaslineass,List<Vendedor> vendedors,List<Cliente> clientes,List<SubCliente> subclientes,List<PresupuestoVentas> presupuestoventass,List<VendedorZona> vendedorzonas)throws Exception {

		if(!zona.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveZonaRelacionesBase(zona,presupuestoventaslineass,vendedors,clientes,subclientes,presupuestoventass,vendedorzonas,false);
		}
	}

	public void saveZonaRelacionesBase(Zona zona,List<PresupuestoVentasLineas> presupuestoventaslineass,List<Vendedor> vendedors,List<Cliente> clientes,List<SubCliente> subclientes,List<PresupuestoVentas> presupuestoventass,List<VendedorZona> vendedorzonas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Zona-saveRelacionesWithConnection");}
	
			zona.setPresupuestoVentasLineass(presupuestoventaslineass);
			zona.setVendedors(vendedors);
			zona.setClientes(clientes);
			zona.setSubClientes(subclientes);
			zona.setPresupuestoVentass(presupuestoventass);
			zona.setVendedorZonas(vendedorzonas);

			this.setZona(zona);

			if(ZonaLogicAdditional.validarSaveRelaciones(zona,this)) {

				ZonaLogicAdditional.updateRelacionesToSave(zona,this);

				if((zona.getIsNew()||zona.getIsChanged())&&!zona.getIsDeleted()) {
					this.saveZona();
					this.saveZonaRelacionesDetalles(presupuestoventaslineass,vendedors,clientes,subclientes,presupuestoventass,vendedorzonas);

				} else if(zona.getIsDeleted()) {
					this.saveZonaRelacionesDetalles(presupuestoventaslineass,vendedors,clientes,subclientes,presupuestoventass,vendedorzonas);
					this.saveZona();
				}

				ZonaLogicAdditional.updateRelacionesToSaveAfter(zona,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PresupuestoVentasLineasConstantesFunciones.InicializarGeneralEntityAuxiliaresPresupuestoVentasLineass(presupuestoventaslineass,true,true);
			VendedorConstantesFunciones.InicializarGeneralEntityAuxiliaresVendedors(vendedors,true,true);
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			SubClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresSubClientes(subclientes,true,true);
			PresupuestoVentasConstantesFunciones.InicializarGeneralEntityAuxiliaresPresupuestoVentass(presupuestoventass,true,true);
			VendedorZonaConstantesFunciones.InicializarGeneralEntityAuxiliaresVendedorZonas(vendedorzonas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveZonaRelacionesDetalles(List<PresupuestoVentasLineas> presupuestoventaslineass,List<Vendedor> vendedors,List<Cliente> clientes,List<SubCliente> subclientes,List<PresupuestoVentas> presupuestoventass,List<VendedorZona> vendedorzonas)throws Exception {
		try {
	

			Long idZonaActual=this.getZona().getId();

			PresupuestoVentasLineasLogic presupuestoventaslineasLogic_Desde_Zona=new PresupuestoVentasLineasLogic();
			presupuestoventaslineasLogic_Desde_Zona.setPresupuestoVentasLineass(presupuestoventaslineass);

			presupuestoventaslineasLogic_Desde_Zona.setConnexion(this.getConnexion());
			presupuestoventaslineasLogic_Desde_Zona.setDatosCliente(this.datosCliente);

			for(PresupuestoVentasLineas presupuestoventaslineas_Desde_Zona:presupuestoventaslineasLogic_Desde_Zona.getPresupuestoVentasLineass()) {
				presupuestoventaslineas_Desde_Zona.setid_zona(idZonaActual);
			}

			presupuestoventaslineasLogic_Desde_Zona.savePresupuestoVentasLineass();

			VendedorLogic vendedorLogic_Desde_Zona=new VendedorLogic();
			vendedorLogic_Desde_Zona.setVendedors(vendedors);

			vendedorLogic_Desde_Zona.setConnexion(this.getConnexion());
			vendedorLogic_Desde_Zona.setDatosCliente(this.datosCliente);

			for(Vendedor vendedor_Desde_Zona:vendedorLogic_Desde_Zona.getVendedors()) {
				vendedor_Desde_Zona.setid_zona(idZonaActual);

				vendedorLogic_Desde_Zona.setVendedor(vendedor_Desde_Zona);
				vendedorLogic_Desde_Zona.saveVendedor();
			}


			ClienteLogic clienteLogic_Desde_Zona=new ClienteLogic();
			clienteLogic_Desde_Zona.setClientes(clientes);

			clienteLogic_Desde_Zona.setConnexion(this.getConnexion());
			clienteLogic_Desde_Zona.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_Zona:clienteLogic_Desde_Zona.getClientes()) {
				cliente_Desde_Zona.setid_zona(idZonaActual);

				clienteLogic_Desde_Zona.setCliente(cliente_Desde_Zona);
				clienteLogic_Desde_Zona.saveCliente();
			}


			SubClienteLogic subclienteLogic_Desde_Zona=new SubClienteLogic();
			subclienteLogic_Desde_Zona.setSubClientes(subclientes);

			subclienteLogic_Desde_Zona.setConnexion(this.getConnexion());
			subclienteLogic_Desde_Zona.setDatosCliente(this.datosCliente);

			for(SubCliente subcliente_Desde_Zona:subclienteLogic_Desde_Zona.getSubClientes()) {
				subcliente_Desde_Zona.setid_zona(idZonaActual);

				subclienteLogic_Desde_Zona.setSubCliente(subcliente_Desde_Zona);
				subclienteLogic_Desde_Zona.saveSubCliente();
			}


			PresupuestoVentasLogic presupuestoventasLogic_Desde_Zona=new PresupuestoVentasLogic();
			presupuestoventasLogic_Desde_Zona.setPresupuestoVentass(presupuestoventass);

			presupuestoventasLogic_Desde_Zona.setConnexion(this.getConnexion());
			presupuestoventasLogic_Desde_Zona.setDatosCliente(this.datosCliente);

			for(PresupuestoVentas presupuestoventas_Desde_Zona:presupuestoventasLogic_Desde_Zona.getPresupuestoVentass()) {
				presupuestoventas_Desde_Zona.setid_zona(idZonaActual);
			}

			presupuestoventasLogic_Desde_Zona.savePresupuestoVentass();

			VendedorZonaLogic vendedorzonaLogic_Desde_Zona=new VendedorZonaLogic();
			vendedorzonaLogic_Desde_Zona.setVendedorZonas(vendedorzonas);

			vendedorzonaLogic_Desde_Zona.setConnexion(this.getConnexion());
			vendedorzonaLogic_Desde_Zona.setDatosCliente(this.datosCliente);

			for(VendedorZona vendedorzona_Desde_Zona:vendedorzonaLogic_Desde_Zona.getVendedorZonas()) {
				vendedorzona_Desde_Zona.setid_zona(idZonaActual);
			}

			vendedorzonaLogic_Desde_Zona.saveVendedorZonas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfZona(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ZonaConstantesFunciones.getClassesForeignKeysOfZona(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfZona(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ZonaConstantesFunciones.getClassesRelationshipsOfZona(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
