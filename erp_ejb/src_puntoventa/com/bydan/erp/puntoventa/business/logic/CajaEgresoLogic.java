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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.CajaEgresoConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaEgresoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaEgresoParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.CajaEgreso;
import com.bydan.erp.puntoventa.business.logic.CajaEgresoLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CajaEgresoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CajaEgresoLogic.class);
	
	protected CajaEgresoDataAccess cajaegresoDataAccess; 	
	protected CajaEgreso cajaegreso;
	protected List<CajaEgreso> cajaegresos;
	protected Object cajaegresoObject;	
	protected List<Object> cajaegresosObject;
	
	public static ClassValidator<CajaEgreso> cajaegresoValidator = new ClassValidator<CajaEgreso>(CajaEgreso.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CajaEgresoLogicAdditional cajaegresoLogicAdditional=null;
	
	public CajaEgresoLogicAdditional getCajaEgresoLogicAdditional() {
		return this.cajaegresoLogicAdditional;
	}
	
	public void setCajaEgresoLogicAdditional(CajaEgresoLogicAdditional cajaegresoLogicAdditional) {
		try {
			this.cajaegresoLogicAdditional=cajaegresoLogicAdditional;
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
	
	
	
	
	public  CajaEgresoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cajaegresoDataAccess = new CajaEgresoDataAccess();
			
			this.cajaegresos= new ArrayList<CajaEgreso>();
			this.cajaegreso= new CajaEgreso();
			
			this.cajaegresoObject=new Object();
			this.cajaegresosObject=new ArrayList<Object>();
				
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
			
			this.cajaegresoDataAccess.setConnexionType(this.connexionType);
			this.cajaegresoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CajaEgresoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cajaegresoDataAccess = new CajaEgresoDataAccess();
			this.cajaegresos= new ArrayList<CajaEgreso>();
			this.cajaegreso= new CajaEgreso();
			this.cajaegresoObject=new Object();
			this.cajaegresosObject=new ArrayList<Object>();
			
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
			
			this.cajaegresoDataAccess.setConnexionType(this.connexionType);
			this.cajaegresoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CajaEgreso getCajaEgreso() throws Exception {	
		CajaEgresoLogicAdditional.checkCajaEgresoToGet(cajaegreso,this.datosCliente,this.arrDatoGeneral);
		CajaEgresoLogicAdditional.updateCajaEgresoToGet(cajaegreso,this.arrDatoGeneral);
		
		return cajaegreso;
	}
		
	public void setCajaEgreso(CajaEgreso newCajaEgreso) {
		this.cajaegreso = newCajaEgreso;
	}
	
	public CajaEgresoDataAccess getCajaEgresoDataAccess() {
		return cajaegresoDataAccess;
	}
	
	public void setCajaEgresoDataAccess(CajaEgresoDataAccess newcajaegresoDataAccess) {
		this.cajaegresoDataAccess = newcajaegresoDataAccess;
	}
	
	public List<CajaEgreso> getCajaEgresos() throws Exception {		
		this.quitarCajaEgresosNulos();
		
		CajaEgresoLogicAdditional.checkCajaEgresoToGets(cajaegresos,this.datosCliente,this.arrDatoGeneral);
		
		for (CajaEgreso cajaegresoLocal: cajaegresos ) {
			CajaEgresoLogicAdditional.updateCajaEgresoToGet(cajaegresoLocal,this.arrDatoGeneral);
		}
		
		return cajaegresos;
	}
	
	public void setCajaEgresos(List<CajaEgreso> newCajaEgresos) {
		this.cajaegresos = newCajaEgresos;
	}
	
	public Object getCajaEgresoObject() {	
		this.cajaegresoObject=this.cajaegresoDataAccess.getEntityObject();
		return this.cajaegresoObject;
	}
		
	public void setCajaEgresoObject(Object newCajaEgresoObject) {
		this.cajaegresoObject = newCajaEgresoObject;
	}
	
	public List<Object> getCajaEgresosObject() {		
		this.cajaegresosObject=this.cajaegresoDataAccess.getEntitiesObject();
		return this.cajaegresosObject;
	}
		
	public void setCajaEgresosObject(List<Object> newCajaEgresosObject) {
		this.cajaegresosObject = newCajaEgresosObject;
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
		
		if(this.cajaegresoDataAccess!=null) {
			this.cajaegresoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cajaegresoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cajaegresoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cajaegreso = new  CajaEgreso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajaegreso=cajaegresoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegreso);
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
		cajaegreso = new  CajaEgreso();
		  		  
        try {
			
			cajaegreso=cajaegresoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cajaegreso = new  CajaEgreso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajaegreso=cajaegresoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegreso);
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
		cajaegreso = new  CajaEgreso();
		  		  
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
		cajaegreso = new  CajaEgreso();
		  		  
        try {
			
			cajaegreso=cajaegresoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cajaegreso = new  CajaEgreso();
		  		  
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
		cajaegreso = new  CajaEgreso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cajaegresoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaegreso = new  CajaEgreso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cajaegresoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajaegreso = new  CajaEgreso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cajaegresoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaegreso = new  CajaEgreso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cajaegresoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajaegreso = new  CajaEgreso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cajaegresoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaegreso = new  CajaEgreso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cajaegresoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajaegresos = new  ArrayList<CajaEgreso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresos=cajaegresoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaEgreso(cajaegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
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
		cajaegresos = new  ArrayList<CajaEgreso>();
		  		  
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
		cajaegresos = new  ArrayList<CajaEgreso>();
		  		  
        try {			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresos=cajaegresoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCajaEgreso(cajaegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cajaegresos = new  ArrayList<CajaEgreso>();
		  		  
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
		cajaegresos = new  ArrayList<CajaEgreso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresos=cajaegresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaEgreso(cajaegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
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
		cajaegresos = new  ArrayList<CajaEgreso>();
		  		  
        try {
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresos=cajaegresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaEgreso(cajaegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
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
		cajaegresos = new  ArrayList<CajaEgreso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresos=cajaegresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaEgreso(cajaegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
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
		cajaegresos = new  ArrayList<CajaEgreso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresos=cajaegresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaEgreso(cajaegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cajaegreso = new  CajaEgreso();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegreso=cajaegresoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaEgreso(cajaegreso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegreso);
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
		cajaegreso = new  CajaEgreso();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegreso=cajaegresoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaEgreso(cajaegreso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajaegresos = new  ArrayList<CajaEgreso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresos=cajaegresoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaEgreso(cajaegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
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
		cajaegresos = new  ArrayList<CajaEgreso>();
		  		  
        try {
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresos=cajaegresoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaEgreso(cajaegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCajaEgresosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cajaegresos = new  ArrayList<CajaEgreso>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getTodosCajaEgresosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajaEgreso(cajaegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
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
	
	public  void  getTodosCajaEgresos(String sFinalQuery,Pagination pagination)throws Exception {
		cajaegresos = new  ArrayList<CajaEgreso>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajaEgreso(cajaegresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCajaEgreso(CajaEgreso cajaegreso) throws Exception {
		Boolean estaValidado=false;
		
		if(cajaegreso.getIsNew() || cajaegreso.getIsChanged()) { 
			this.invalidValues = cajaegresoValidator.getInvalidValues(cajaegreso);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cajaegreso);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCajaEgreso(List<CajaEgreso> CajaEgresos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CajaEgreso cajaegresoLocal:cajaegresos) {				
			estaValidadoObjeto=this.validarGuardarCajaEgreso(cajaegresoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCajaEgreso(List<CajaEgreso> CajaEgresos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajaEgreso(cajaegresos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCajaEgreso(CajaEgreso CajaEgreso) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajaEgreso(cajaegreso)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CajaEgreso cajaegreso) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cajaegreso.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CajaEgresoConstantesFunciones.getCajaEgresoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cajaegreso","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CajaEgresoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CajaEgresoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCajaEgresoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-saveCajaEgresoWithConnection");connexion.begin();			
			
			CajaEgresoLogicAdditional.checkCajaEgresoToSave(this.cajaegreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajaEgresoLogicAdditional.updateCajaEgresoToSave(this.cajaegreso,this.arrDatoGeneral);
			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajaegreso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCajaEgreso();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajaEgreso(this.cajaegreso)) {
				CajaEgresoDataAccess.save(this.cajaegreso, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cajaegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajaEgresoLogicAdditional.checkCajaEgresoToSaveAfter(this.cajaegreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajaEgreso();
			
			connexion.commit();			
			
			if(this.cajaegreso.getIsDeleted()) {
				this.cajaegreso=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCajaEgreso()throws Exception {	
		try {	
			
			CajaEgresoLogicAdditional.checkCajaEgresoToSave(this.cajaegreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajaEgresoLogicAdditional.updateCajaEgresoToSave(this.cajaegreso,this.arrDatoGeneral);
			
			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajaegreso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajaEgreso(this.cajaegreso)) {			
				CajaEgresoDataAccess.save(this.cajaegreso, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cajaegreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajaEgresoLogicAdditional.checkCajaEgresoToSaveAfter(this.cajaegreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cajaegreso.getIsDeleted()) {
				this.cajaegreso=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCajaEgresosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-saveCajaEgresosWithConnection");connexion.begin();			
			
			CajaEgresoLogicAdditional.checkCajaEgresoToSaves(cajaegresos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCajaEgresos();
			
			Boolean validadoTodosCajaEgreso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajaEgreso cajaegresoLocal:cajaegresos) {		
				if(cajaegresoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajaEgresoLogicAdditional.updateCajaEgresoToSave(cajaegresoLocal,this.arrDatoGeneral);
	        	
				CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajaegresoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajaEgreso(cajaegresoLocal)) {
					CajaEgresoDataAccess.save(cajaegresoLocal, connexion);				
				} else {
					validadoTodosCajaEgreso=false;
				}
			}
			
			if(!validadoTodosCajaEgreso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajaEgresoLogicAdditional.checkCajaEgresoToSavesAfter(cajaegresos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajaEgresos();
			
			connexion.commit();		
			
			this.quitarCajaEgresosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCajaEgresos()throws Exception {				
		 try {	
			CajaEgresoLogicAdditional.checkCajaEgresoToSaves(cajaegresos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCajaEgreso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajaEgreso cajaegresoLocal:cajaegresos) {				
				if(cajaegresoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajaEgresoLogicAdditional.updateCajaEgresoToSave(cajaegresoLocal,this.arrDatoGeneral);
	        	
				CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajaegresoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajaEgreso(cajaegresoLocal)) {				
					CajaEgresoDataAccess.save(cajaegresoLocal, connexion);				
				} else {
					validadoTodosCajaEgreso=false;
				}
			}
			
			if(!validadoTodosCajaEgreso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajaEgresoLogicAdditional.checkCajaEgresoToSavesAfter(cajaegresos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCajaEgresosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaEgresoParameterReturnGeneral procesarAccionCajaEgresos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaEgreso> cajaegresos,CajaEgresoParameterReturnGeneral cajaegresoParameterGeneral)throws Exception {
		 try {	
			CajaEgresoParameterReturnGeneral cajaegresoReturnGeneral=new CajaEgresoParameterReturnGeneral();
	
			CajaEgresoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajaegresos,cajaegresoParameterGeneral,cajaegresoReturnGeneral);
			
			return cajaegresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaEgresoParameterReturnGeneral procesarAccionCajaEgresosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaEgreso> cajaegresos,CajaEgresoParameterReturnGeneral cajaegresoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-procesarAccionCajaEgresosWithConnection");connexion.begin();			
			
			CajaEgresoParameterReturnGeneral cajaegresoReturnGeneral=new CajaEgresoParameterReturnGeneral();
	
			CajaEgresoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajaegresos,cajaegresoParameterGeneral,cajaegresoReturnGeneral);
			
			this.connexion.commit();
			
			return cajaegresoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaEgresoParameterReturnGeneral procesarEventosCajaEgresos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajaEgreso> cajaegresos,CajaEgreso cajaegreso,CajaEgresoParameterReturnGeneral cajaegresoParameterGeneral,Boolean isEsNuevoCajaEgreso,ArrayList<Classe> clases)throws Exception {
		 try {	
			CajaEgresoParameterReturnGeneral cajaegresoReturnGeneral=new CajaEgresoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajaegresoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajaEgresoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajaegresos,cajaegreso,cajaegresoParameterGeneral,cajaegresoReturnGeneral,isEsNuevoCajaEgreso,clases);
			
			return cajaegresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CajaEgresoParameterReturnGeneral procesarEventosCajaEgresosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajaEgreso> cajaegresos,CajaEgreso cajaegreso,CajaEgresoParameterReturnGeneral cajaegresoParameterGeneral,Boolean isEsNuevoCajaEgreso,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-procesarEventosCajaEgresosWithConnection");connexion.begin();			
			
			CajaEgresoParameterReturnGeneral cajaegresoReturnGeneral=new CajaEgresoParameterReturnGeneral();
	
			cajaegresoReturnGeneral.setCajaEgreso(cajaegreso);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajaegresoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajaEgresoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajaegresos,cajaegreso,cajaegresoParameterGeneral,cajaegresoReturnGeneral,isEsNuevoCajaEgreso,clases);
			
			this.connexion.commit();
			
			return cajaegresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaEgresoParameterReturnGeneral procesarImportacionCajaEgresosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CajaEgresoParameterReturnGeneral cajaegresoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-procesarImportacionCajaEgresosWithConnection");connexion.begin();			
			
			CajaEgresoParameterReturnGeneral cajaegresoReturnGeneral=new CajaEgresoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cajaegresos=new ArrayList<CajaEgreso>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cajaegreso=new CajaEgreso();
				
				
				if(conColumnasBase) {this.cajaegreso.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cajaegreso.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cajaegreso.setsecuencial(arrColumnas[iColumn++]);
				this.cajaegreso.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				//this.cajaegreso.sethora(arrColumnas[iColumn++]);
				this.cajaegreso.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.cajaegresos.add(this.cajaegreso);
			}
			
			this.saveCajaEgresos();
			
			this.connexion.commit();
			
			cajaegresoReturnGeneral.setConRetornoEstaProcesado(true);
			cajaegresoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cajaegresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCajaEgresosEliminados() throws Exception {				
		
		List<CajaEgreso> cajaegresosAux= new ArrayList<CajaEgreso>();
		
		for(CajaEgreso cajaegreso:cajaegresos) {
			if(!cajaegreso.getIsDeleted()) {
				cajaegresosAux.add(cajaegreso);
			}
		}
		
		cajaegresos=cajaegresosAux;
	}
	
	public void quitarCajaEgresosNulos() throws Exception {				
		
		List<CajaEgreso> cajaegresosAux= new ArrayList<CajaEgreso>();
		
		for(CajaEgreso cajaegreso : this.cajaegresos) {
			if(cajaegreso==null) {
				cajaegresosAux.add(cajaegreso);
			}
		}
		
		//this.cajaegresos=cajaegresosAux;
		
		this.cajaegresos.removeAll(cajaegresosAux);
	}
	
	public void getSetVersionRowCajaEgresoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cajaegreso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cajaegreso.getIsDeleted() || (cajaegreso.getIsChanged()&&!cajaegreso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cajaegresoDataAccess.getSetVersionRowCajaEgreso(connexion,cajaegreso.getId());
				
				if(!cajaegreso.getVersionRow().equals(timestamp)) {	
					cajaegreso.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cajaegreso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCajaEgreso()throws Exception {	
		
		if(cajaegreso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cajaegreso.getIsDeleted() || (cajaegreso.getIsChanged()&&!cajaegreso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cajaegresoDataAccess.getSetVersionRowCajaEgreso(connexion,cajaegreso.getId());
			
			try {							
				if(!cajaegreso.getVersionRow().equals(timestamp)) {	
					cajaegreso.setVersionRow(timestamp);
				}
				
				cajaegreso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCajaEgresosWithConnection()throws Exception {	
		if(cajaegresos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CajaEgreso cajaegresoAux:cajaegresos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cajaegresoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajaegresoAux.getIsDeleted() || (cajaegresoAux.getIsChanged()&&!cajaegresoAux.getIsNew())) {
						
						timestamp=cajaegresoDataAccess.getSetVersionRowCajaEgreso(connexion,cajaegresoAux.getId());
						
						if(!cajaegreso.getVersionRow().equals(timestamp)) {	
							cajaegresoAux.setVersionRow(timestamp);
						}
								
						cajaegresoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCajaEgresos()throws Exception {	
		if(cajaegresos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CajaEgreso cajaegresoAux:cajaegresos) {
					if(cajaegresoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajaegresoAux.getIsDeleted() || (cajaegresoAux.getIsChanged()&&!cajaegresoAux.getIsNew())) {
						
						timestamp=cajaegresoDataAccess.getSetVersionRowCajaEgreso(connexion,cajaegresoAux.getId());
						
						if(!cajaegresoAux.getVersionRow().equals(timestamp)) {	
							cajaegresoAux.setVersionRow(timestamp);
						}
						
													
						cajaegresoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CajaEgresoParameterReturnGeneral cargarCombosLoteForeignKeyCajaEgresoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalCaja,String finalQueryGlobalTurnoPunVen) throws Exception {
		CajaEgresoParameterReturnGeneral  cajaegresoReturnGeneral =new CajaEgresoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-cargarCombosLoteForeignKeyCajaEgresoWithConnection");connexion.begin();
			
			cajaegresoReturnGeneral =new CajaEgresoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajaegresoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajaegresoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			cajaegresoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			cajaegresoReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<TurnoPunVen> turnopunvensForeignKey=new ArrayList<TurnoPunVen>();
			TurnoPunVenLogic turnopunvenLogic=new TurnoPunVenLogic();
			turnopunvenLogic.setConnexion(this.connexion);
			turnopunvenLogic.getTurnoPunVenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTurnoPunVen.equals("NONE")) {
				turnopunvenLogic.getTodosTurnoPunVens(finalQueryGlobalTurnoPunVen,new Pagination());
				turnopunvensForeignKey=turnopunvenLogic.getTurnoPunVens();
			}

			cajaegresoReturnGeneral.setturnopunvensForeignKey(turnopunvensForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cajaegresoReturnGeneral;
	}
	
	public CajaEgresoParameterReturnGeneral cargarCombosLoteForeignKeyCajaEgreso(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalCaja,String finalQueryGlobalTurnoPunVen) throws Exception {
		CajaEgresoParameterReturnGeneral  cajaegresoReturnGeneral =new CajaEgresoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cajaegresoReturnGeneral =new CajaEgresoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajaegresoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajaegresoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			cajaegresoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			cajaegresoReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<TurnoPunVen> turnopunvensForeignKey=new ArrayList<TurnoPunVen>();
			TurnoPunVenLogic turnopunvenLogic=new TurnoPunVenLogic();
			turnopunvenLogic.setConnexion(this.connexion);
			turnopunvenLogic.getTurnoPunVenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTurnoPunVen.equals("NONE")) {
				turnopunvenLogic.getTodosTurnoPunVens(finalQueryGlobalTurnoPunVen,new Pagination());
				turnopunvensForeignKey=turnopunvenLogic.getTurnoPunVens();
			}

			cajaegresoReturnGeneral.setturnopunvensForeignKey(turnopunvensForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cajaegresoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCajaEgresoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CajaEgresoDetalleLogic cajaegresodetalleLogic=new CajaEgresoDetalleLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCajaEgresoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CajaEgresoDetalle.class));
											
			

			cajaegresodetalleLogic.setConnexion(this.getConnexion());
			cajaegresodetalleLogic.setDatosCliente(this.datosCliente);
			cajaegresodetalleLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(CajaEgreso cajaegreso:this.cajaegresos) {
				

				classes=new ArrayList<Classe>();
				classes=CajaEgresoDetalleConstantesFunciones.getClassesForeignKeysOfCajaEgresoDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajaegresodetalleLogic.setCajaEgresoDetalles(cajaegreso.cajaegresodetalles);
				cajaegresodetalleLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(CajaEgreso cajaegreso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CajaEgresoLogicAdditional.updateCajaEgresoToGet(cajaegreso,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajaegreso.setEmpresa(cajaegresoDataAccess.getEmpresa(connexion,cajaegreso));
		cajaegreso.setSucursal(cajaegresoDataAccess.getSucursal(connexion,cajaegreso));
		cajaegreso.setUsuario(cajaegresoDataAccess.getUsuario(connexion,cajaegreso));
		cajaegreso.setCaja(cajaegresoDataAccess.getCaja(connexion,cajaegreso));
		cajaegreso.setTurnoPunVen(cajaegresoDataAccess.getTurnoPunVen(connexion,cajaegreso));
		cajaegreso.setCajaEgresoDetalles(cajaegresoDataAccess.getCajaEgresoDetalles(connexion,cajaegreso));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajaegreso.setEmpresa(cajaegresoDataAccess.getEmpresa(connexion,cajaegreso));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajaegreso.setSucursal(cajaegresoDataAccess.getSucursal(connexion,cajaegreso));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				cajaegreso.setUsuario(cajaegresoDataAccess.getUsuario(connexion,cajaegreso));
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				cajaegreso.setCaja(cajaegresoDataAccess.getCaja(connexion,cajaegreso));
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				cajaegreso.setTurnoPunVen(cajaegresoDataAccess.getTurnoPunVen(connexion,cajaegreso));
				continue;
			}

			if(clas.clas.equals(CajaEgresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cajaegreso.setCajaEgresoDetalles(cajaegresoDataAccess.getCajaEgresoDetalles(connexion,cajaegreso));

				if(this.isConDeep) {
					CajaEgresoDetalleLogic cajaegresodetalleLogic= new CajaEgresoDetalleLogic(this.connexion);
					cajaegresodetalleLogic.setCajaEgresoDetalles(cajaegreso.getCajaEgresoDetalles());
					ArrayList<Classe> classesLocal=CajaEgresoDetalleConstantesFunciones.getClassesForeignKeysOfCajaEgresoDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajaegresodetalleLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(cajaegresodetalleLogic.getCajaEgresoDetalles());
					cajaegreso.setCajaEgresoDetalles(cajaegresodetalleLogic.getCajaEgresoDetalles());
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
			cajaegreso.setEmpresa(cajaegresoDataAccess.getEmpresa(connexion,cajaegreso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegreso.setSucursal(cajaegresoDataAccess.getSucursal(connexion,cajaegreso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegreso.setUsuario(cajaegresoDataAccess.getUsuario(connexion,cajaegreso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegreso.setCaja(cajaegresoDataAccess.getCaja(connexion,cajaegreso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TurnoPunVen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegreso.setTurnoPunVen(cajaegresoDataAccess.getTurnoPunVen(connexion,cajaegreso));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaEgresoDetalle.class));
			cajaegreso.setCajaEgresoDetalles(cajaegresoDataAccess.getCajaEgresoDetalles(connexion,cajaegreso));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajaegreso.setEmpresa(cajaegresoDataAccess.getEmpresa(connexion,cajaegreso));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajaegreso.getEmpresa(),isDeep,deepLoadType,clases);
				
		cajaegreso.setSucursal(cajaegresoDataAccess.getSucursal(connexion,cajaegreso));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajaegreso.getSucursal(),isDeep,deepLoadType,clases);
				
		cajaegreso.setUsuario(cajaegresoDataAccess.getUsuario(connexion,cajaegreso));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(cajaegreso.getUsuario(),isDeep,deepLoadType,clases);
				
		cajaegreso.setCaja(cajaegresoDataAccess.getCaja(connexion,cajaegreso));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(cajaegreso.getCaja(),isDeep,deepLoadType,clases);
				
		cajaegreso.setTurnoPunVen(cajaegresoDataAccess.getTurnoPunVen(connexion,cajaegreso));
		TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
		turnopunvenLogic.deepLoad(cajaegreso.getTurnoPunVen(),isDeep,deepLoadType,clases);
				

		cajaegreso.setCajaEgresoDetalles(cajaegresoDataAccess.getCajaEgresoDetalles(connexion,cajaegreso));

		for(CajaEgresoDetalle cajaegresodetalle:cajaegreso.getCajaEgresoDetalles()) {
			CajaEgresoDetalleLogic cajaegresodetalleLogic= new CajaEgresoDetalleLogic(connexion);
			cajaegresodetalleLogic.deepLoad(cajaegresodetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajaegreso.setEmpresa(cajaegresoDataAccess.getEmpresa(connexion,cajaegreso));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cajaegreso.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajaegreso.setSucursal(cajaegresoDataAccess.getSucursal(connexion,cajaegreso));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cajaegreso.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				cajaegreso.setUsuario(cajaegresoDataAccess.getUsuario(connexion,cajaegreso));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(cajaegreso.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				cajaegreso.setCaja(cajaegresoDataAccess.getCaja(connexion,cajaegreso));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(cajaegreso.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				cajaegreso.setTurnoPunVen(cajaegresoDataAccess.getTurnoPunVen(connexion,cajaegreso));
				TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
				turnopunvenLogic.deepLoad(cajaegreso.getTurnoPunVen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CajaEgresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cajaegreso.setCajaEgresoDetalles(cajaegresoDataAccess.getCajaEgresoDetalles(connexion,cajaegreso));

				for(CajaEgresoDetalle cajaegresodetalle:cajaegreso.getCajaEgresoDetalles()) {
					CajaEgresoDetalleLogic cajaegresodetalleLogic= new CajaEgresoDetalleLogic(connexion);
					cajaegresodetalleLogic.deepLoad(cajaegresodetalle,isDeep,deepLoadType,clases);
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
			cajaegreso.setEmpresa(cajaegresoDataAccess.getEmpresa(connexion,cajaegreso));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cajaegreso.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegreso.setSucursal(cajaegresoDataAccess.getSucursal(connexion,cajaegreso));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cajaegreso.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegreso.setUsuario(cajaegresoDataAccess.getUsuario(connexion,cajaegreso));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(cajaegreso.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegreso.setCaja(cajaegresoDataAccess.getCaja(connexion,cajaegreso));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(cajaegreso.getCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TurnoPunVen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegreso.setTurnoPunVen(cajaegresoDataAccess.getTurnoPunVen(connexion,cajaegreso));
			TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
			turnopunvenLogic.deepLoad(cajaegreso.getTurnoPunVen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaEgresoDetalle.class));
			cajaegreso.setCajaEgresoDetalles(cajaegresoDataAccess.getCajaEgresoDetalles(connexion,cajaegreso));

			for(CajaEgresoDetalle cajaegresodetalle:cajaegreso.getCajaEgresoDetalles()) {
				CajaEgresoDetalleLogic cajaegresodetalleLogic= new CajaEgresoDetalleLogic(connexion);
				cajaegresodetalleLogic.deepLoad(cajaegresodetalle,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CajaEgreso cajaegreso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CajaEgresoLogicAdditional.updateCajaEgresoToSave(cajaegreso,this.arrDatoGeneral);
			
CajaEgresoDataAccess.save(cajaegreso, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cajaegreso.getEmpresa(),connexion);

		SucursalDataAccess.save(cajaegreso.getSucursal(),connexion);

		UsuarioDataAccess.save(cajaegreso.getUsuario(),connexion);

		CajaDataAccess.save(cajaegreso.getCaja(),connexion);

		TurnoPunVenDataAccess.save(cajaegreso.getTurnoPunVen(),connexion);

		for(CajaEgresoDetalle cajaegresodetalle:cajaegreso.getCajaEgresoDetalles()) {
			cajaegresodetalle.setid_caja_egreso(cajaegreso.getId());
			CajaEgresoDetalleDataAccess.save(cajaegresodetalle,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajaegreso.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajaegreso.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(cajaegreso.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(cajaegreso.getCaja(),connexion);
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				TurnoPunVenDataAccess.save(cajaegreso.getTurnoPunVen(),connexion);
				continue;
			}


			if(clas.clas.equals(CajaEgresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaEgresoDetalle cajaegresodetalle:cajaegreso.getCajaEgresoDetalles()) {
					cajaegresodetalle.setid_caja_egreso(cajaegreso.getId());
					CajaEgresoDetalleDataAccess.save(cajaegresodetalle,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cajaegreso.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajaegreso.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(cajaegreso.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajaegreso.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(cajaegreso.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(cajaegreso.getUsuario(),isDeep,deepLoadType,clases);
				

		CajaDataAccess.save(cajaegreso.getCaja(),connexion);
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(cajaegreso.getCaja(),isDeep,deepLoadType,clases);
				

		TurnoPunVenDataAccess.save(cajaegreso.getTurnoPunVen(),connexion);
		TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
		turnopunvenLogic.deepLoad(cajaegreso.getTurnoPunVen(),isDeep,deepLoadType,clases);
				

		for(CajaEgresoDetalle cajaegresodetalle:cajaegreso.getCajaEgresoDetalles()) {
			CajaEgresoDetalleLogic cajaegresodetalleLogic= new CajaEgresoDetalleLogic(connexion);
			cajaegresodetalle.setid_caja_egreso(cajaegreso.getId());
			CajaEgresoDetalleDataAccess.save(cajaegresodetalle,connexion);
			cajaegresodetalleLogic.deepSave(cajaegresodetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajaegreso.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cajaegreso.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajaegreso.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(cajaegreso.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(cajaegreso.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(cajaegreso.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(cajaegreso.getCaja(),connexion);
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepSave(cajaegreso.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				TurnoPunVenDataAccess.save(cajaegreso.getTurnoPunVen(),connexion);
				TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
				turnopunvenLogic.deepSave(cajaegreso.getTurnoPunVen(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(CajaEgresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaEgresoDetalle cajaegresodetalle:cajaegreso.getCajaEgresoDetalles()) {
					CajaEgresoDetalleLogic cajaegresodetalleLogic= new CajaEgresoDetalleLogic(connexion);
					cajaegresodetalle.setid_caja_egreso(cajaegreso.getId());
					CajaEgresoDetalleDataAccess.save(cajaegresodetalle,connexion);
					cajaegresodetalleLogic.deepSave(cajaegresodetalle,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(CajaEgreso.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cajaegreso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(cajaegreso);
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
			this.deepLoad(this.cajaegreso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CajaEgreso.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cajaegresos!=null) {
				for(CajaEgreso cajaegreso:cajaegresos) {
					this.deepLoad(cajaegreso,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(cajaegresos);
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
			if(cajaegresos!=null) {
				for(CajaEgreso cajaegreso:cajaegresos) {
					this.deepLoad(cajaegreso,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(cajaegresos);
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
			this.getNewConnexionToDeep(CajaEgreso.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cajaegreso,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CajaEgreso.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cajaegresos!=null) {
				for(CajaEgreso cajaegreso:cajaegresos) {
					this.deepSave(cajaegreso,isDeep,deepLoadType,clases);
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
			if(cajaegresos!=null) {
				for(CajaEgreso cajaegreso:cajaegresos) {
					this.deepSave(cajaegreso,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCajaEgresosFK_IdCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,CajaEgresoConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaEgresosFK_IdCaja(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,CajaEgresoConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaEgresosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaEgresoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaEgresosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaEgresoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaEgresosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaEgresoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaEgresosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaEgresoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaEgresosFK_IdTurnoPunVenWithConnection(String sFinalQuery,Pagination pagination,Long id_turno_pun_ven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTurnoPunVen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTurnoPunVen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_turno_pun_ven,CajaEgresoConstantesFunciones.IDTURNOPUNVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTurnoPunVen);

			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTurnoPunVen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaEgresosFK_IdTurnoPunVen(String sFinalQuery,Pagination pagination,Long id_turno_pun_ven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTurnoPunVen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTurnoPunVen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_turno_pun_ven,CajaEgresoConstantesFunciones.IDTURNOPUNVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTurnoPunVen);

			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTurnoPunVen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaEgresosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,CajaEgresoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaEgresosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,CajaEgresoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			CajaEgresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(this.cajaegresos);
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
			if(CajaEgresoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaEgresoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CajaEgreso cajaegreso,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CajaEgresoConstantesFunciones.ISCONAUDITORIA) {
				if(cajaegreso.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaEgresoDataAccess.TABLENAME, cajaegreso.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaEgresoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaEgresoLogic.registrarAuditoriaDetallesCajaEgreso(connexion,cajaegreso,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cajaegreso.getIsDeleted()) {
					/*if(!cajaegreso.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CajaEgresoDataAccess.TABLENAME, cajaegreso.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CajaEgresoLogic.registrarAuditoriaDetallesCajaEgreso(connexion,cajaegreso,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaEgresoDataAccess.TABLENAME, cajaegreso.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cajaegreso.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaEgresoDataAccess.TABLENAME, cajaegreso.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaEgresoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaEgresoLogic.registrarAuditoriaDetallesCajaEgreso(connexion,cajaegreso,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCajaEgreso(Connexion connexion,CajaEgreso cajaegreso)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cajaegreso.getIsNew()||!cajaegreso.getid_empresa().equals(cajaegreso.getCajaEgresoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegreso.getCajaEgresoOriginal().getid_empresa()!=null)
				{
					strValorActual=cajaegreso.getCajaEgresoOriginal().getid_empresa().toString();
				}
				if(cajaegreso.getid_empresa()!=null)
				{
					strValorNuevo=cajaegreso.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cajaegreso.getIsNew()||!cajaegreso.getid_sucursal().equals(cajaegreso.getCajaEgresoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegreso.getCajaEgresoOriginal().getid_sucursal()!=null)
				{
					strValorActual=cajaegreso.getCajaEgresoOriginal().getid_sucursal().toString();
				}
				if(cajaegreso.getid_sucursal()!=null)
				{
					strValorNuevo=cajaegreso.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(cajaegreso.getIsNew()||!cajaegreso.getid_usuario().equals(cajaegreso.getCajaEgresoOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegreso.getCajaEgresoOriginal().getid_usuario()!=null)
				{
					strValorActual=cajaegreso.getCajaEgresoOriginal().getid_usuario().toString();
				}
				if(cajaegreso.getid_usuario()!=null)
				{
					strValorNuevo=cajaegreso.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(cajaegreso.getIsNew()||!cajaegreso.getid_caja().equals(cajaegreso.getCajaEgresoOriginal().getid_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegreso.getCajaEgresoOriginal().getid_caja()!=null)
				{
					strValorActual=cajaegreso.getCajaEgresoOriginal().getid_caja().toString();
				}
				if(cajaegreso.getid_caja()!=null)
				{
					strValorNuevo=cajaegreso.getid_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoConstantesFunciones.IDCAJA,strValorActual,strValorNuevo);
			}	
			
			if(cajaegreso.getIsNew()||!cajaegreso.getid_turno_pun_ven().equals(cajaegreso.getCajaEgresoOriginal().getid_turno_pun_ven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegreso.getCajaEgresoOriginal().getid_turno_pun_ven()!=null)
				{
					strValorActual=cajaegreso.getCajaEgresoOriginal().getid_turno_pun_ven().toString();
				}
				if(cajaegreso.getid_turno_pun_ven()!=null)
				{
					strValorNuevo=cajaegreso.getid_turno_pun_ven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoConstantesFunciones.IDTURNOPUNVEN,strValorActual,strValorNuevo);
			}	
			
			if(cajaegreso.getIsNew()||!cajaegreso.getsecuencial().equals(cajaegreso.getCajaEgresoOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegreso.getCajaEgresoOriginal().getsecuencial()!=null)
				{
					strValorActual=cajaegreso.getCajaEgresoOriginal().getsecuencial();
				}
				if(cajaegreso.getsecuencial()!=null)
				{
					strValorNuevo=cajaegreso.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(cajaegreso.getIsNew()||!cajaegreso.getfecha().equals(cajaegreso.getCajaEgresoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegreso.getCajaEgresoOriginal().getfecha()!=null)
				{
					strValorActual=cajaegreso.getCajaEgresoOriginal().getfecha().toString();
				}
				if(cajaegreso.getfecha()!=null)
				{
					strValorNuevo=cajaegreso.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(cajaegreso.getIsNew()||!cajaegreso.gethora().equals(cajaegreso.getCajaEgresoOriginal().gethora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegreso.getCajaEgresoOriginal().gethora()!=null)
				{
					strValorActual=cajaegreso.getCajaEgresoOriginal().gethora().toString();
				}
				if(cajaegreso.gethora()!=null)
				{
					strValorNuevo=cajaegreso.gethora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoConstantesFunciones.HORA,strValorActual,strValorNuevo);
			}	
			
			if(cajaegreso.getIsNew()||!cajaegreso.getvalor().equals(cajaegreso.getCajaEgresoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegreso.getCajaEgresoOriginal().getvalor()!=null)
				{
					strValorActual=cajaegreso.getCajaEgresoOriginal().getvalor().toString();
				}
				if(cajaegreso.getvalor()!=null)
				{
					strValorNuevo=cajaegreso.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCajaEgresoRelacionesWithConnection(CajaEgreso cajaegreso,List<CajaEgresoDetalle> cajaegresodetalles) throws Exception {

		if(!cajaegreso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajaEgresoRelacionesBase(cajaegreso,cajaegresodetalles,true);
		}
	}

	public void saveCajaEgresoRelaciones(CajaEgreso cajaegreso,List<CajaEgresoDetalle> cajaegresodetalles)throws Exception {

		if(!cajaegreso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajaEgresoRelacionesBase(cajaegreso,cajaegresodetalles,false);
		}
	}

	public void saveCajaEgresoRelacionesBase(CajaEgreso cajaegreso,List<CajaEgresoDetalle> cajaegresodetalles,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CajaEgreso-saveRelacionesWithConnection");}
	
			cajaegreso.setCajaEgresoDetalles(cajaegresodetalles);

			this.setCajaEgreso(cajaegreso);

			if(CajaEgresoLogicAdditional.validarSaveRelaciones(cajaegreso,this)) {

				CajaEgresoLogicAdditional.updateRelacionesToSave(cajaegreso,this);

				if((cajaegreso.getIsNew()||cajaegreso.getIsChanged())&&!cajaegreso.getIsDeleted()) {
					this.saveCajaEgreso();
					this.saveCajaEgresoRelacionesDetalles(cajaegresodetalles);

				} else if(cajaegreso.getIsDeleted()) {
					this.saveCajaEgresoRelacionesDetalles(cajaegresodetalles);
					this.saveCajaEgreso();
				}

				CajaEgresoLogicAdditional.updateRelacionesToSaveAfter(cajaegreso,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CajaEgresoDetalleConstantesFunciones.InicializarGeneralEntityAuxiliaresCajaEgresoDetalles(cajaegresodetalles,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCajaEgresoRelacionesDetalles(List<CajaEgresoDetalle> cajaegresodetalles)throws Exception {
		try {
	

			Long idCajaEgresoActual=this.getCajaEgreso().getId();

			CajaEgresoDetalleLogic cajaegresodetalleLogic_Desde_CajaEgreso=new CajaEgresoDetalleLogic();
			cajaegresodetalleLogic_Desde_CajaEgreso.setCajaEgresoDetalles(cajaegresodetalles);

			cajaegresodetalleLogic_Desde_CajaEgreso.setConnexion(this.getConnexion());
			cajaegresodetalleLogic_Desde_CajaEgreso.setDatosCliente(this.datosCliente);

			for(CajaEgresoDetalle cajaegresodetalle_Desde_CajaEgreso:cajaegresodetalleLogic_Desde_CajaEgreso.getCajaEgresoDetalles()) {
				cajaegresodetalle_Desde_CajaEgreso.setid_caja_egreso(idCajaEgresoActual);
			}

			cajaegresodetalleLogic_Desde_CajaEgreso.saveCajaEgresoDetalles();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCajaEgreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaEgresoConstantesFunciones.getClassesForeignKeysOfCajaEgreso(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaEgreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaEgresoConstantesFunciones.getClassesRelationshipsOfCajaEgreso(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
