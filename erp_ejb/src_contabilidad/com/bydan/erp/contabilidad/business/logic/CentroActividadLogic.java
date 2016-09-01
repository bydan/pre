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
import com.bydan.erp.contabilidad.util.CentroActividadConstantesFunciones;
import com.bydan.erp.contabilidad.util.CentroActividadParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.CentroActividadParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.CentroActividad;
import com.bydan.erp.contabilidad.business.logic.CentroActividadLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;








@SuppressWarnings("unused")
public class CentroActividadLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CentroActividadLogic.class);
	
	protected CentroActividadDataAccess centroactividadDataAccess; 	
	protected CentroActividad centroactividad;
	protected List<CentroActividad> centroactividads;
	protected Object centroactividadObject;	
	protected List<Object> centroactividadsObject;
	
	public static ClassValidator<CentroActividad> centroactividadValidator = new ClassValidator<CentroActividad>(CentroActividad.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CentroActividadLogicAdditional centroactividadLogicAdditional=null;
	
	public CentroActividadLogicAdditional getCentroActividadLogicAdditional() {
		return this.centroactividadLogicAdditional;
	}
	
	public void setCentroActividadLogicAdditional(CentroActividadLogicAdditional centroactividadLogicAdditional) {
		try {
			this.centroactividadLogicAdditional=centroactividadLogicAdditional;
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
	
	
	
	
	public  CentroActividadLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.centroactividadDataAccess = new CentroActividadDataAccess();
			
			this.centroactividads= new ArrayList<CentroActividad>();
			this.centroactividad= new CentroActividad();
			
			this.centroactividadObject=new Object();
			this.centroactividadsObject=new ArrayList<Object>();
				
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
			
			this.centroactividadDataAccess.setConnexionType(this.connexionType);
			this.centroactividadDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CentroActividadLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.centroactividadDataAccess = new CentroActividadDataAccess();
			this.centroactividads= new ArrayList<CentroActividad>();
			this.centroactividad= new CentroActividad();
			this.centroactividadObject=new Object();
			this.centroactividadsObject=new ArrayList<Object>();
			
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
			
			this.centroactividadDataAccess.setConnexionType(this.connexionType);
			this.centroactividadDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CentroActividad getCentroActividad() throws Exception {	
		CentroActividadLogicAdditional.checkCentroActividadToGet(centroactividad,this.datosCliente,this.arrDatoGeneral);
		CentroActividadLogicAdditional.updateCentroActividadToGet(centroactividad,this.arrDatoGeneral);
		
		return centroactividad;
	}
		
	public void setCentroActividad(CentroActividad newCentroActividad) {
		this.centroactividad = newCentroActividad;
	}
	
	public CentroActividadDataAccess getCentroActividadDataAccess() {
		return centroactividadDataAccess;
	}
	
	public void setCentroActividadDataAccess(CentroActividadDataAccess newcentroactividadDataAccess) {
		this.centroactividadDataAccess = newcentroactividadDataAccess;
	}
	
	public List<CentroActividad> getCentroActividads() throws Exception {		
		this.quitarCentroActividadsNulos();
		
		CentroActividadLogicAdditional.checkCentroActividadToGets(centroactividads,this.datosCliente,this.arrDatoGeneral);
		
		for (CentroActividad centroactividadLocal: centroactividads ) {
			CentroActividadLogicAdditional.updateCentroActividadToGet(centroactividadLocal,this.arrDatoGeneral);
		}
		
		return centroactividads;
	}
	
	public void setCentroActividads(List<CentroActividad> newCentroActividads) {
		this.centroactividads = newCentroActividads;
	}
	
	public Object getCentroActividadObject() {	
		this.centroactividadObject=this.centroactividadDataAccess.getEntityObject();
		return this.centroactividadObject;
	}
		
	public void setCentroActividadObject(Object newCentroActividadObject) {
		this.centroactividadObject = newCentroActividadObject;
	}
	
	public List<Object> getCentroActividadsObject() {		
		this.centroactividadsObject=this.centroactividadDataAccess.getEntitiesObject();
		return this.centroactividadsObject;
	}
		
	public void setCentroActividadsObject(List<Object> newCentroActividadsObject) {
		this.centroactividadsObject = newCentroActividadsObject;
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
		
		if(this.centroactividadDataAccess!=null) {
			this.centroactividadDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			centroactividadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			centroactividadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		centroactividad = new  CentroActividad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			centroactividad=centroactividadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centroactividad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividad);
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
		centroactividad = new  CentroActividad();
		  		  
        try {
			
			centroactividad=centroactividadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centroactividad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		centroactividad = new  CentroActividad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			centroactividad=centroactividadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centroactividad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividad);
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
		centroactividad = new  CentroActividad();
		  		  
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
		centroactividad = new  CentroActividad();
		  		  
        try {
			
			centroactividad=centroactividadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.centroactividad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		centroactividad = new  CentroActividad();
		  		  
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
		centroactividad = new  CentroActividad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =centroactividadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		centroactividad = new  CentroActividad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=centroactividadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		centroactividad = new  CentroActividad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =centroactividadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		centroactividad = new  CentroActividad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=centroactividadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		centroactividad = new  CentroActividad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =centroactividadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		centroactividad = new  CentroActividad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=centroactividadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		centroactividads = new  ArrayList<CentroActividad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividads=centroactividadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroActividad(centroactividads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
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
		centroactividads = new  ArrayList<CentroActividad>();
		  		  
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
		centroactividads = new  ArrayList<CentroActividad>();
		  		  
        try {			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividads=centroactividadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCentroActividad(centroactividads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		centroactividads = new  ArrayList<CentroActividad>();
		  		  
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
		centroactividads = new  ArrayList<CentroActividad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividads=centroactividadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroActividad(centroactividads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
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
		centroactividads = new  ArrayList<CentroActividad>();
		  		  
        try {
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividads=centroactividadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroActividad(centroactividads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
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
		centroactividads = new  ArrayList<CentroActividad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividads=centroactividadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroActividad(centroactividads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
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
		centroactividads = new  ArrayList<CentroActividad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividads=centroactividadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroActividad(centroactividads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		centroactividad = new  CentroActividad();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividad=centroactividadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroActividad(centroactividad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividad);
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
		centroactividad = new  CentroActividad();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividad=centroactividadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCentroActividad(centroactividad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		centroactividads = new  ArrayList<CentroActividad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividads=centroactividadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroActividad(centroactividads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
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
		centroactividads = new  ArrayList<CentroActividad>();
		  		  
        try {
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividads=centroactividadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCentroActividad(centroactividads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCentroActividadsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		centroactividads = new  ArrayList<CentroActividad>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getTodosCentroActividadsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCentroActividad(centroactividads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
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
	
	public  void  getTodosCentroActividads(String sFinalQuery,Pagination pagination)throws Exception {
		centroactividads = new  ArrayList<CentroActividad>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCentroActividad(centroactividads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCentroActividad(CentroActividad centroactividad) throws Exception {
		Boolean estaValidado=false;
		
		if(centroactividad.getIsNew() || centroactividad.getIsChanged()) { 
			this.invalidValues = centroactividadValidator.getInvalidValues(centroactividad);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(centroactividad);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCentroActividad(List<CentroActividad> CentroActividads) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CentroActividad centroactividadLocal:centroactividads) {				
			estaValidadoObjeto=this.validarGuardarCentroActividad(centroactividadLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCentroActividad(List<CentroActividad> CentroActividads) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCentroActividad(centroactividads)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCentroActividad(CentroActividad CentroActividad) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCentroActividad(centroactividad)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CentroActividad centroactividad) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+centroactividad.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CentroActividadConstantesFunciones.getCentroActividadLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"centroactividad","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CentroActividadConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CentroActividadConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCentroActividadWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-saveCentroActividadWithConnection");connexion.begin();			
			
			CentroActividadLogicAdditional.checkCentroActividadToSave(this.centroactividad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CentroActividadLogicAdditional.updateCentroActividadToSave(this.centroactividad,this.arrDatoGeneral);
			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.centroactividad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCentroActividad();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCentroActividad(this.centroactividad)) {
				CentroActividadDataAccess.save(this.centroactividad, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.centroactividad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CentroActividadLogicAdditional.checkCentroActividadToSaveAfter(this.centroactividad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCentroActividad();
			
			connexion.commit();			
			
			if(this.centroactividad.getIsDeleted()) {
				this.centroactividad=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCentroActividad()throws Exception {	
		try {	
			
			CentroActividadLogicAdditional.checkCentroActividadToSave(this.centroactividad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CentroActividadLogicAdditional.updateCentroActividadToSave(this.centroactividad,this.arrDatoGeneral);
			
			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.centroactividad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCentroActividad(this.centroactividad)) {			
				CentroActividadDataAccess.save(this.centroactividad, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.centroactividad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CentroActividadLogicAdditional.checkCentroActividadToSaveAfter(this.centroactividad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.centroactividad.getIsDeleted()) {
				this.centroactividad=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCentroActividadsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-saveCentroActividadsWithConnection");connexion.begin();			
			
			CentroActividadLogicAdditional.checkCentroActividadToSaves(centroactividads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCentroActividads();
			
			Boolean validadoTodosCentroActividad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CentroActividad centroactividadLocal:centroactividads) {		
				if(centroactividadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CentroActividadLogicAdditional.updateCentroActividadToSave(centroactividadLocal,this.arrDatoGeneral);
	        	
				CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),centroactividadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCentroActividad(centroactividadLocal)) {
					CentroActividadDataAccess.save(centroactividadLocal, connexion);				
				} else {
					validadoTodosCentroActividad=false;
				}
			}
			
			if(!validadoTodosCentroActividad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CentroActividadLogicAdditional.checkCentroActividadToSavesAfter(centroactividads,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCentroActividads();
			
			connexion.commit();		
			
			this.quitarCentroActividadsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCentroActividads()throws Exception {				
		 try {	
			CentroActividadLogicAdditional.checkCentroActividadToSaves(centroactividads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCentroActividad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CentroActividad centroactividadLocal:centroactividads) {				
				if(centroactividadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CentroActividadLogicAdditional.updateCentroActividadToSave(centroactividadLocal,this.arrDatoGeneral);
	        	
				CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),centroactividadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCentroActividad(centroactividadLocal)) {				
					CentroActividadDataAccess.save(centroactividadLocal, connexion);				
				} else {
					validadoTodosCentroActividad=false;
				}
			}
			
			if(!validadoTodosCentroActividad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CentroActividadLogicAdditional.checkCentroActividadToSavesAfter(centroactividads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCentroActividadsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CentroActividadParameterReturnGeneral procesarAccionCentroActividads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CentroActividad> centroactividads,CentroActividadParameterReturnGeneral centroactividadParameterGeneral)throws Exception {
		 try {	
			CentroActividadParameterReturnGeneral centroactividadReturnGeneral=new CentroActividadParameterReturnGeneral();
	
			CentroActividadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,centroactividads,centroactividadParameterGeneral,centroactividadReturnGeneral);
			
			return centroactividadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CentroActividadParameterReturnGeneral procesarAccionCentroActividadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CentroActividad> centroactividads,CentroActividadParameterReturnGeneral centroactividadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-procesarAccionCentroActividadsWithConnection");connexion.begin();			
			
			CentroActividadParameterReturnGeneral centroactividadReturnGeneral=new CentroActividadParameterReturnGeneral();
	
			CentroActividadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,centroactividads,centroactividadParameterGeneral,centroactividadReturnGeneral);
			
			this.connexion.commit();
			
			return centroactividadReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CentroActividadParameterReturnGeneral procesarEventosCentroActividads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CentroActividad> centroactividads,CentroActividad centroactividad,CentroActividadParameterReturnGeneral centroactividadParameterGeneral,Boolean isEsNuevoCentroActividad,ArrayList<Classe> clases)throws Exception {
		 try {	
			CentroActividadParameterReturnGeneral centroactividadReturnGeneral=new CentroActividadParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				centroactividadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CentroActividadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,centroactividads,centroactividad,centroactividadParameterGeneral,centroactividadReturnGeneral,isEsNuevoCentroActividad,clases);
			
			return centroactividadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CentroActividadParameterReturnGeneral procesarEventosCentroActividadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CentroActividad> centroactividads,CentroActividad centroactividad,CentroActividadParameterReturnGeneral centroactividadParameterGeneral,Boolean isEsNuevoCentroActividad,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-procesarEventosCentroActividadsWithConnection");connexion.begin();			
			
			CentroActividadParameterReturnGeneral centroactividadReturnGeneral=new CentroActividadParameterReturnGeneral();
	
			centroactividadReturnGeneral.setCentroActividad(centroactividad);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				centroactividadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CentroActividadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,centroactividads,centroactividad,centroactividadParameterGeneral,centroactividadReturnGeneral,isEsNuevoCentroActividad,clases);
			
			this.connexion.commit();
			
			return centroactividadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CentroActividadParameterReturnGeneral procesarImportacionCentroActividadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CentroActividadParameterReturnGeneral centroactividadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-procesarImportacionCentroActividadsWithConnection");connexion.begin();			
			
			CentroActividadParameterReturnGeneral centroactividadReturnGeneral=new CentroActividadParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.centroactividads=new ArrayList<CentroActividad>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.centroactividad=new CentroActividad();
				
				
				if(conColumnasBase) {this.centroactividad.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.centroactividad.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.centroactividad.setcodigo(arrColumnas[iColumn++]);
				this.centroactividad.setnombre(arrColumnas[iColumn++]);
				this.centroactividad.setconsolidado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.centroactividad.setcon_proyecto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.centroactividad.setobservacion(arrColumnas[iColumn++]);
				
				this.centroactividads.add(this.centroactividad);
			}
			
			this.saveCentroActividads();
			
			this.connexion.commit();
			
			centroactividadReturnGeneral.setConRetornoEstaProcesado(true);
			centroactividadReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return centroactividadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCentroActividadsEliminados() throws Exception {				
		
		List<CentroActividad> centroactividadsAux= new ArrayList<CentroActividad>();
		
		for(CentroActividad centroactividad:centroactividads) {
			if(!centroactividad.getIsDeleted()) {
				centroactividadsAux.add(centroactividad);
			}
		}
		
		centroactividads=centroactividadsAux;
	}
	
	public void quitarCentroActividadsNulos() throws Exception {				
		
		List<CentroActividad> centroactividadsAux= new ArrayList<CentroActividad>();
		
		for(CentroActividad centroactividad : this.centroactividads) {
			if(centroactividad==null) {
				centroactividadsAux.add(centroactividad);
			}
		}
		
		//this.centroactividads=centroactividadsAux;
		
		this.centroactividads.removeAll(centroactividadsAux);
	}
	
	public void getSetVersionRowCentroActividadWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(centroactividad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((centroactividad.getIsDeleted() || (centroactividad.getIsChanged()&&!centroactividad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=centroactividadDataAccess.getSetVersionRowCentroActividad(connexion,centroactividad.getId());
				
				if(!centroactividad.getVersionRow().equals(timestamp)) {	
					centroactividad.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				centroactividad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCentroActividad()throws Exception {	
		
		if(centroactividad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((centroactividad.getIsDeleted() || (centroactividad.getIsChanged()&&!centroactividad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=centroactividadDataAccess.getSetVersionRowCentroActividad(connexion,centroactividad.getId());
			
			try {							
				if(!centroactividad.getVersionRow().equals(timestamp)) {	
					centroactividad.setVersionRow(timestamp);
				}
				
				centroactividad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCentroActividadsWithConnection()throws Exception {	
		if(centroactividads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CentroActividad centroactividadAux:centroactividads) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(centroactividadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(centroactividadAux.getIsDeleted() || (centroactividadAux.getIsChanged()&&!centroactividadAux.getIsNew())) {
						
						timestamp=centroactividadDataAccess.getSetVersionRowCentroActividad(connexion,centroactividadAux.getId());
						
						if(!centroactividad.getVersionRow().equals(timestamp)) {	
							centroactividadAux.setVersionRow(timestamp);
						}
								
						centroactividadAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCentroActividads()throws Exception {	
		if(centroactividads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CentroActividad centroactividadAux:centroactividads) {
					if(centroactividadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(centroactividadAux.getIsDeleted() || (centroactividadAux.getIsChanged()&&!centroactividadAux.getIsNew())) {
						
						timestamp=centroactividadDataAccess.getSetVersionRowCentroActividad(connexion,centroactividadAux.getId());
						
						if(!centroactividadAux.getVersionRow().equals(timestamp)) {	
							centroactividadAux.setVersionRow(timestamp);
						}
						
													
						centroactividadAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CentroActividadParameterReturnGeneral cargarCombosLoteForeignKeyCentroActividadWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoGrupoFlujoCaja) throws Exception {
		CentroActividadParameterReturnGeneral  centroactividadReturnGeneral =new CentroActividadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-cargarCombosLoteForeignKeyCentroActividadWithConnection");connexion.begin();
			
			centroactividadReturnGeneral =new CentroActividadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			centroactividadReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			centroactividadReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoGrupoFlujoCaja> tipogrupoflujocajasForeignKey=new ArrayList<TipoGrupoFlujoCaja>();
			TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic=new TipoGrupoFlujoCajaLogic();
			tipogrupoflujocajaLogic.setConnexion(this.connexion);
			tipogrupoflujocajaLogic.getTipoGrupoFlujoCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoFlujoCaja.equals("NONE")) {
				tipogrupoflujocajaLogic.getTodosTipoGrupoFlujoCajas(finalQueryGlobalTipoGrupoFlujoCaja,new Pagination());
				tipogrupoflujocajasForeignKey=tipogrupoflujocajaLogic.getTipoGrupoFlujoCajas();
			}

			centroactividadReturnGeneral.settipogrupoflujocajasForeignKey(tipogrupoflujocajasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return centroactividadReturnGeneral;
	}
	
	public CentroActividadParameterReturnGeneral cargarCombosLoteForeignKeyCentroActividad(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoGrupoFlujoCaja) throws Exception {
		CentroActividadParameterReturnGeneral  centroactividadReturnGeneral =new CentroActividadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			centroactividadReturnGeneral =new CentroActividadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			centroactividadReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			centroactividadReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoGrupoFlujoCaja> tipogrupoflujocajasForeignKey=new ArrayList<TipoGrupoFlujoCaja>();
			TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic=new TipoGrupoFlujoCajaLogic();
			tipogrupoflujocajaLogic.setConnexion(this.connexion);
			tipogrupoflujocajaLogic.getTipoGrupoFlujoCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoFlujoCaja.equals("NONE")) {
				tipogrupoflujocajaLogic.getTodosTipoGrupoFlujoCajas(finalQueryGlobalTipoGrupoFlujoCaja,new Pagination());
				tipogrupoflujocajasForeignKey=tipogrupoflujocajaLogic.getTipoGrupoFlujoCajas();
			}

			centroactividadReturnGeneral.settipogrupoflujocajasForeignKey(tipogrupoflujocajasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return centroactividadReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCentroActividadWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PagoAutoLogic pagoautoLogic=new PagoAutoLogic();
			ClienteLogic clienteLogic=new ClienteLogic();
			AutoriPagoLogic autoripagoLogic=new AutoriPagoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCentroActividadWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PagoAuto.class));
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(AutoriPago.class));
											
			

			pagoautoLogic.setConnexion(this.getConnexion());
			pagoautoLogic.setDatosCliente(this.datosCliente);
			pagoautoLogic.setIsConRefrescarForeignKeys(true);

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			autoripagoLogic.setConnexion(this.getConnexion());
			autoripagoLogic.setDatosCliente(this.datosCliente);
			autoripagoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(CentroActividad centroactividad:this.centroactividads) {
				

				classes=new ArrayList<Classe>();
				classes=PagoAutoConstantesFunciones.getClassesForeignKeysOfPagoAuto(new ArrayList<Classe>(),DeepLoadType.NONE);

				pagoautoLogic.setPagoAutos(centroactividad.pagoautos);
				pagoautoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(centroactividad.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AutoriPagoConstantesFunciones.getClassesForeignKeysOfAutoriPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				autoripagoLogic.setAutoriPagos(centroactividad.autoripagos);
				autoripagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(CentroActividad centroactividad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CentroActividadLogicAdditional.updateCentroActividadToGet(centroactividad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		centroactividad.setEmpresa(centroactividadDataAccess.getEmpresa(connexion,centroactividad));
		centroactividad.setTipoMovimiento(centroactividadDataAccess.getTipoMovimiento(connexion,centroactividad));
		centroactividad.setTipoGrupoFlujoCaja(centroactividadDataAccess.getTipoGrupoFlujoCaja(connexion,centroactividad));
		centroactividad.setPagoAutos(centroactividadDataAccess.getPagoAutos(connexion,centroactividad));
		centroactividad.setClientes(centroactividadDataAccess.getClientes(connexion,centroactividad));
		centroactividad.setAutoriPagos(centroactividadDataAccess.getAutoriPagos(connexion,centroactividad));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				centroactividad.setEmpresa(centroactividadDataAccess.getEmpresa(connexion,centroactividad));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				centroactividad.setTipoMovimiento(centroactividadDataAccess.getTipoMovimiento(connexion,centroactividad));
				continue;
			}

			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				centroactividad.setTipoGrupoFlujoCaja(centroactividadDataAccess.getTipoGrupoFlujoCaja(connexion,centroactividad));
				continue;
			}

			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				centroactividad.setPagoAutos(centroactividadDataAccess.getPagoAutos(connexion,centroactividad));

				if(this.isConDeep) {
					PagoAutoLogic pagoautoLogic= new PagoAutoLogic(this.connexion);
					pagoautoLogic.setPagoAutos(centroactividad.getPagoAutos());
					ArrayList<Classe> classesLocal=PagoAutoConstantesFunciones.getClassesForeignKeysOfPagoAuto(new ArrayList<Classe>(),DeepLoadType.NONE);
					pagoautoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(pagoautoLogic.getPagoAutos());
					centroactividad.setPagoAutos(pagoautoLogic.getPagoAutos());
				}

				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				centroactividad.setClientes(centroactividadDataAccess.getClientes(connexion,centroactividad));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(centroactividad.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					centroactividad.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				centroactividad.setAutoriPagos(centroactividadDataAccess.getAutoriPagos(connexion,centroactividad));

				if(this.isConDeep) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(this.connexion);
					autoripagoLogic.setAutoriPagos(centroactividad.getAutoriPagos());
					ArrayList<Classe> classesLocal=AutoriPagoConstantesFunciones.getClassesForeignKeysOfAutoriPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					autoripagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(autoripagoLogic.getAutoriPagos());
					centroactividad.setAutoriPagos(autoripagoLogic.getAutoriPagos());
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
			centroactividad.setEmpresa(centroactividadDataAccess.getEmpresa(connexion,centroactividad));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centroactividad.setTipoMovimiento(centroactividadDataAccess.getTipoMovimiento(connexion,centroactividad));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centroactividad.setTipoGrupoFlujoCaja(centroactividadDataAccess.getTipoGrupoFlujoCaja(connexion,centroactividad));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PagoAuto.class));
			centroactividad.setPagoAutos(centroactividadDataAccess.getPagoAutos(connexion,centroactividad));
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
			centroactividad.setClientes(centroactividadDataAccess.getClientes(connexion,centroactividad));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPago.class));
			centroactividad.setAutoriPagos(centroactividadDataAccess.getAutoriPagos(connexion,centroactividad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		centroactividad.setEmpresa(centroactividadDataAccess.getEmpresa(connexion,centroactividad));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(centroactividad.getEmpresa(),isDeep,deepLoadType,clases);
				
		centroactividad.setTipoMovimiento(centroactividadDataAccess.getTipoMovimiento(connexion,centroactividad));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(centroactividad.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		centroactividad.setTipoGrupoFlujoCaja(centroactividadDataAccess.getTipoGrupoFlujoCaja(connexion,centroactividad));
		TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic= new TipoGrupoFlujoCajaLogic(connexion);
		tipogrupoflujocajaLogic.deepLoad(centroactividad.getTipoGrupoFlujoCaja(),isDeep,deepLoadType,clases);
				

		centroactividad.setPagoAutos(centroactividadDataAccess.getPagoAutos(connexion,centroactividad));

		for(PagoAuto pagoauto:centroactividad.getPagoAutos()) {
			PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
			pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
		}

		centroactividad.setClientes(centroactividadDataAccess.getClientes(connexion,centroactividad));

		for(Cliente cliente:centroactividad.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		centroactividad.setAutoriPagos(centroactividadDataAccess.getAutoriPagos(connexion,centroactividad));

		for(AutoriPago autoripago:centroactividad.getAutoriPagos()) {
			AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
			autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				centroactividad.setEmpresa(centroactividadDataAccess.getEmpresa(connexion,centroactividad));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(centroactividad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				centroactividad.setTipoMovimiento(centroactividadDataAccess.getTipoMovimiento(connexion,centroactividad));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(centroactividad.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				centroactividad.setTipoGrupoFlujoCaja(centroactividadDataAccess.getTipoGrupoFlujoCaja(connexion,centroactividad));
				TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic= new TipoGrupoFlujoCajaLogic(connexion);
				tipogrupoflujocajaLogic.deepLoad(centroactividad.getTipoGrupoFlujoCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				centroactividad.setPagoAutos(centroactividadDataAccess.getPagoAutos(connexion,centroactividad));

				for(PagoAuto pagoauto:centroactividad.getPagoAutos()) {
					PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
					pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				centroactividad.setClientes(centroactividadDataAccess.getClientes(connexion,centroactividad));

				for(Cliente cliente:centroactividad.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				centroactividad.setAutoriPagos(centroactividadDataAccess.getAutoriPagos(connexion,centroactividad));

				for(AutoriPago autoripago:centroactividad.getAutoriPagos()) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
					autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
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
			centroactividad.setEmpresa(centroactividadDataAccess.getEmpresa(connexion,centroactividad));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(centroactividad.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centroactividad.setTipoMovimiento(centroactividadDataAccess.getTipoMovimiento(connexion,centroactividad));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(centroactividad.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			centroactividad.setTipoGrupoFlujoCaja(centroactividadDataAccess.getTipoGrupoFlujoCaja(connexion,centroactividad));
			TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic= new TipoGrupoFlujoCajaLogic(connexion);
			tipogrupoflujocajaLogic.deepLoad(centroactividad.getTipoGrupoFlujoCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PagoAuto.class));
			centroactividad.setPagoAutos(centroactividadDataAccess.getPagoAutos(connexion,centroactividad));

			for(PagoAuto pagoauto:centroactividad.getPagoAutos()) {
				PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
				pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
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
			centroactividad.setClientes(centroactividadDataAccess.getClientes(connexion,centroactividad));

			for(Cliente cliente:centroactividad.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPago.class));
			centroactividad.setAutoriPagos(centroactividadDataAccess.getAutoriPagos(connexion,centroactividad));

			for(AutoriPago autoripago:centroactividad.getAutoriPagos()) {
				AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
				autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CentroActividad centroactividad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CentroActividadLogicAdditional.updateCentroActividadToSave(centroactividad,this.arrDatoGeneral);
			
CentroActividadDataAccess.save(centroactividad, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(centroactividad.getEmpresa(),connexion);

		TipoMovimientoDataAccess.save(centroactividad.getTipoMovimiento(),connexion);

		TipoGrupoFlujoCajaDataAccess.save(centroactividad.getTipoGrupoFlujoCaja(),connexion);

		for(PagoAuto pagoauto:centroactividad.getPagoAutos()) {
			pagoauto.setid_centro_actividad(centroactividad.getId());
			PagoAutoDataAccess.save(pagoauto,connexion);
		}

		for(Cliente cliente:centroactividad.getClientes()) {
			cliente.setid_centro_actividad(centroactividad.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(AutoriPago autoripago:centroactividad.getAutoriPagos()) {
			autoripago.setid_centro_actividad(centroactividad.getId());
			AutoriPagoDataAccess.save(autoripago,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(centroactividad.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(centroactividad.getTipoMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				TipoGrupoFlujoCajaDataAccess.save(centroactividad.getTipoGrupoFlujoCaja(),connexion);
				continue;
			}


			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PagoAuto pagoauto:centroactividad.getPagoAutos()) {
					pagoauto.setid_centro_actividad(centroactividad.getId());
					PagoAutoDataAccess.save(pagoauto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:centroactividad.getClientes()) {
					cliente.setid_centro_actividad(centroactividad.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPago autoripago:centroactividad.getAutoriPagos()) {
					autoripago.setid_centro_actividad(centroactividad.getId());
					AutoriPagoDataAccess.save(autoripago,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(centroactividad.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(centroactividad.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(centroactividad.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(centroactividad.getTipoMovimiento(),isDeep,deepLoadType,clases);
				

		TipoGrupoFlujoCajaDataAccess.save(centroactividad.getTipoGrupoFlujoCaja(),connexion);
		TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic= new TipoGrupoFlujoCajaLogic(connexion);
		tipogrupoflujocajaLogic.deepLoad(centroactividad.getTipoGrupoFlujoCaja(),isDeep,deepLoadType,clases);
				

		for(PagoAuto pagoauto:centroactividad.getPagoAutos()) {
			PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
			pagoauto.setid_centro_actividad(centroactividad.getId());
			PagoAutoDataAccess.save(pagoauto,connexion);
			pagoautoLogic.deepSave(pagoauto,isDeep,deepLoadType,clases);
		}

		for(Cliente cliente:centroactividad.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_centro_actividad(centroactividad.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(AutoriPago autoripago:centroactividad.getAutoriPagos()) {
			AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
			autoripago.setid_centro_actividad(centroactividad.getId());
			AutoriPagoDataAccess.save(autoripago,connexion);
			autoripagoLogic.deepSave(autoripago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(centroactividad.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(centroactividad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(centroactividad.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(centroactividad.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				TipoGrupoFlujoCajaDataAccess.save(centroactividad.getTipoGrupoFlujoCaja(),connexion);
				TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic= new TipoGrupoFlujoCajaLogic(connexion);
				tipogrupoflujocajaLogic.deepSave(centroactividad.getTipoGrupoFlujoCaja(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PagoAuto pagoauto:centroactividad.getPagoAutos()) {
					PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
					pagoauto.setid_centro_actividad(centroactividad.getId());
					PagoAutoDataAccess.save(pagoauto,connexion);
					pagoautoLogic.deepSave(pagoauto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:centroactividad.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_centro_actividad(centroactividad.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPago autoripago:centroactividad.getAutoriPagos()) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
					autoripago.setid_centro_actividad(centroactividad.getId());
					AutoriPagoDataAccess.save(autoripago,connexion);
					autoripagoLogic.deepSave(autoripago,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(CentroActividad.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(centroactividad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(centroactividad);
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
			this.deepLoad(this.centroactividad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CentroActividad.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(centroactividads!=null) {
				for(CentroActividad centroactividad:centroactividads) {
					this.deepLoad(centroactividad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(centroactividads);
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
			if(centroactividads!=null) {
				for(CentroActividad centroactividad:centroactividads) {
					this.deepLoad(centroactividad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(centroactividads);
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
			this.getNewConnexionToDeep(CentroActividad.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(centroactividad,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CentroActividad.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(centroactividads!=null) {
				for(CentroActividad centroactividad:centroactividads) {
					this.deepSave(centroactividad,isDeep,deepLoadType,clases);
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
			if(centroactividads!=null) {
				for(CentroActividad centroactividad:centroactividads) {
					this.deepSave(centroactividad,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCentroActividadsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",CentroActividadConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroActividadsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",CentroActividadConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroActividadsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CentroActividadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroActividadsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CentroActividadConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroActividadsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CentroActividadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroActividadsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CentroActividadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroActividadsFK_IdTipoGrupoFlujoCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_flujo_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoFlujoCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoFlujoCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_flujo_caja,CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoFlujoCaja);

			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoFlujoCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroActividadsFK_IdTipoGrupoFlujoCaja(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_flujo_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoFlujoCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoFlujoCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_flujo_caja,CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoFlujoCaja);

			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoFlujoCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCentroActividadsFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CentroActividad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCentroActividadsFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			CentroActividadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(this.centroactividads);
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
			if(CentroActividadConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroActividadDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CentroActividad centroactividad,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CentroActividadConstantesFunciones.ISCONAUDITORIA) {
				if(centroactividad.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroActividadDataAccess.TABLENAME, centroactividad.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CentroActividadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CentroActividadLogic.registrarAuditoriaDetallesCentroActividad(connexion,centroactividad,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(centroactividad.getIsDeleted()) {
					/*if(!centroactividad.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CentroActividadDataAccess.TABLENAME, centroactividad.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CentroActividadLogic.registrarAuditoriaDetallesCentroActividad(connexion,centroactividad,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroActividadDataAccess.TABLENAME, centroactividad.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(centroactividad.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CentroActividadDataAccess.TABLENAME, centroactividad.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CentroActividadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CentroActividadLogic.registrarAuditoriaDetallesCentroActividad(connexion,centroactividad,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCentroActividad(Connexion connexion,CentroActividad centroactividad)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(centroactividad.getIsNew()||!centroactividad.getid_empresa().equals(centroactividad.getCentroActividadOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centroactividad.getCentroActividadOriginal().getid_empresa()!=null)
				{
					strValorActual=centroactividad.getCentroActividadOriginal().getid_empresa().toString();
				}
				if(centroactividad.getid_empresa()!=null)
				{
					strValorNuevo=centroactividad.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroActividadConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(centroactividad.getIsNew()||!centroactividad.getcodigo().equals(centroactividad.getCentroActividadOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centroactividad.getCentroActividadOriginal().getcodigo()!=null)
				{
					strValorActual=centroactividad.getCentroActividadOriginal().getcodigo();
				}
				if(centroactividad.getcodigo()!=null)
				{
					strValorNuevo=centroactividad.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroActividadConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(centroactividad.getIsNew()||!centroactividad.getnombre().equals(centroactividad.getCentroActividadOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centroactividad.getCentroActividadOriginal().getnombre()!=null)
				{
					strValorActual=centroactividad.getCentroActividadOriginal().getnombre();
				}
				if(centroactividad.getnombre()!=null)
				{
					strValorNuevo=centroactividad.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroActividadConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(centroactividad.getIsNew()||!centroactividad.getid_tipo_movimiento().equals(centroactividad.getCentroActividadOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centroactividad.getCentroActividadOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=centroactividad.getCentroActividadOriginal().getid_tipo_movimiento().toString();
				}
				if(centroactividad.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=centroactividad.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(centroactividad.getIsNew()||!centroactividad.getid_tipo_grupo_flujo_caja().equals(centroactividad.getCentroActividadOriginal().getid_tipo_grupo_flujo_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centroactividad.getCentroActividadOriginal().getid_tipo_grupo_flujo_caja()!=null)
				{
					strValorActual=centroactividad.getCentroActividadOriginal().getid_tipo_grupo_flujo_caja().toString();
				}
				if(centroactividad.getid_tipo_grupo_flujo_caja()!=null)
				{
					strValorNuevo=centroactividad.getid_tipo_grupo_flujo_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA,strValorActual,strValorNuevo);
			}	
			
			if(centroactividad.getIsNew()||!centroactividad.getconsolidado().equals(centroactividad.getCentroActividadOriginal().getconsolidado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centroactividad.getCentroActividadOriginal().getconsolidado()!=null)
				{
					strValorActual=centroactividad.getCentroActividadOriginal().getconsolidado().toString();
				}
				if(centroactividad.getconsolidado()!=null)
				{
					strValorNuevo=centroactividad.getconsolidado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroActividadConstantesFunciones.CONSOLIDADO,strValorActual,strValorNuevo);
			}	
			
			if(centroactividad.getIsNew()||!centroactividad.getcon_proyecto().equals(centroactividad.getCentroActividadOriginal().getcon_proyecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centroactividad.getCentroActividadOriginal().getcon_proyecto()!=null)
				{
					strValorActual=centroactividad.getCentroActividadOriginal().getcon_proyecto().toString();
				}
				if(centroactividad.getcon_proyecto()!=null)
				{
					strValorNuevo=centroactividad.getcon_proyecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroActividadConstantesFunciones.CONPROYECTO,strValorActual,strValorNuevo);
			}	
			
			if(centroactividad.getIsNew()||!centroactividad.getobservacion().equals(centroactividad.getCentroActividadOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(centroactividad.getCentroActividadOriginal().getobservacion()!=null)
				{
					strValorActual=centroactividad.getCentroActividadOriginal().getobservacion();
				}
				if(centroactividad.getobservacion()!=null)
				{
					strValorNuevo=centroactividad.getobservacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CentroActividadConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCentroActividadRelacionesWithConnection(CentroActividad centroactividad,List<PagoAuto> pagoautos,List<Cliente> clientes,List<AutoriPago> autoripagos) throws Exception {

		if(!centroactividad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCentroActividadRelacionesBase(centroactividad,pagoautos,clientes,autoripagos,true);
		}
	}

	public void saveCentroActividadRelaciones(CentroActividad centroactividad,List<PagoAuto> pagoautos,List<Cliente> clientes,List<AutoriPago> autoripagos)throws Exception {

		if(!centroactividad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCentroActividadRelacionesBase(centroactividad,pagoautos,clientes,autoripagos,false);
		}
	}

	public void saveCentroActividadRelacionesBase(CentroActividad centroactividad,List<PagoAuto> pagoautos,List<Cliente> clientes,List<AutoriPago> autoripagos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CentroActividad-saveRelacionesWithConnection");}
	
			centroactividad.setPagoAutos(pagoautos);
			centroactividad.setClientes(clientes);
			centroactividad.setAutoriPagos(autoripagos);

			this.setCentroActividad(centroactividad);

			if(CentroActividadLogicAdditional.validarSaveRelaciones(centroactividad,this)) {

				CentroActividadLogicAdditional.updateRelacionesToSave(centroactividad,this);

				if((centroactividad.getIsNew()||centroactividad.getIsChanged())&&!centroactividad.getIsDeleted()) {
					this.saveCentroActividad();
					this.saveCentroActividadRelacionesDetalles(pagoautos,clientes,autoripagos);

				} else if(centroactividad.getIsDeleted()) {
					this.saveCentroActividadRelacionesDetalles(pagoautos,clientes,autoripagos);
					this.saveCentroActividad();
				}

				CentroActividadLogicAdditional.updateRelacionesToSaveAfter(centroactividad,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PagoAutoConstantesFunciones.InicializarGeneralEntityAuxiliaresPagoAutos(pagoautos,true,true);
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			AutoriPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresAutoriPagos(autoripagos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCentroActividadRelacionesDetalles(List<PagoAuto> pagoautos,List<Cliente> clientes,List<AutoriPago> autoripagos)throws Exception {
		try {
	

			Long idCentroActividadActual=this.getCentroActividad().getId();

			PagoAutoLogic pagoautoLogic_Desde_CentroActividad=new PagoAutoLogic();
			pagoautoLogic_Desde_CentroActividad.setPagoAutos(pagoautos);

			pagoautoLogic_Desde_CentroActividad.setConnexion(this.getConnexion());
			pagoautoLogic_Desde_CentroActividad.setDatosCliente(this.datosCliente);

			for(PagoAuto pagoauto_Desde_CentroActividad:pagoautoLogic_Desde_CentroActividad.getPagoAutos()) {
				pagoauto_Desde_CentroActividad.setid_centro_actividad(idCentroActividadActual);
			}

			pagoautoLogic_Desde_CentroActividad.savePagoAutos();

			ClienteLogic clienteLogic_Desde_CentroActividad=new ClienteLogic();
			clienteLogic_Desde_CentroActividad.setClientes(clientes);

			clienteLogic_Desde_CentroActividad.setConnexion(this.getConnexion());
			clienteLogic_Desde_CentroActividad.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_CentroActividad:clienteLogic_Desde_CentroActividad.getClientes()) {
				cliente_Desde_CentroActividad.setid_centro_actividad(idCentroActividadActual);

				clienteLogic_Desde_CentroActividad.setCliente(cliente_Desde_CentroActividad);
				clienteLogic_Desde_CentroActividad.saveCliente();
			}


			AutoriPagoLogic autoripagoLogic_Desde_CentroActividad=new AutoriPagoLogic();
			autoripagoLogic_Desde_CentroActividad.setAutoriPagos(autoripagos);

			autoripagoLogic_Desde_CentroActividad.setConnexion(this.getConnexion());
			autoripagoLogic_Desde_CentroActividad.setDatosCliente(this.datosCliente);

			for(AutoriPago autoripago_Desde_CentroActividad:autoripagoLogic_Desde_CentroActividad.getAutoriPagos()) {
				autoripago_Desde_CentroActividad.setid_centro_actividad(idCentroActividadActual);
			}

			autoripagoLogic_Desde_CentroActividad.saveAutoriPagos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCentroActividad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CentroActividadConstantesFunciones.getClassesForeignKeysOfCentroActividad(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroActividad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CentroActividadConstantesFunciones.getClassesRelationshipsOfCentroActividad(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
