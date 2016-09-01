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
import com.bydan.erp.puntoventa.util.CajaIngresoConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaIngresoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaIngresoParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.CajaIngreso;
import com.bydan.erp.puntoventa.business.logic.CajaIngresoLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CajaIngresoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CajaIngresoLogic.class);
	
	protected CajaIngresoDataAccess cajaingresoDataAccess; 	
	protected CajaIngreso cajaingreso;
	protected List<CajaIngreso> cajaingresos;
	protected Object cajaingresoObject;	
	protected List<Object> cajaingresosObject;
	
	public static ClassValidator<CajaIngreso> cajaingresoValidator = new ClassValidator<CajaIngreso>(CajaIngreso.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CajaIngresoLogicAdditional cajaingresoLogicAdditional=null;
	
	public CajaIngresoLogicAdditional getCajaIngresoLogicAdditional() {
		return this.cajaingresoLogicAdditional;
	}
	
	public void setCajaIngresoLogicAdditional(CajaIngresoLogicAdditional cajaingresoLogicAdditional) {
		try {
			this.cajaingresoLogicAdditional=cajaingresoLogicAdditional;
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
	
	
	
	
	public  CajaIngresoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cajaingresoDataAccess = new CajaIngresoDataAccess();
			
			this.cajaingresos= new ArrayList<CajaIngreso>();
			this.cajaingreso= new CajaIngreso();
			
			this.cajaingresoObject=new Object();
			this.cajaingresosObject=new ArrayList<Object>();
				
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
			
			this.cajaingresoDataAccess.setConnexionType(this.connexionType);
			this.cajaingresoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CajaIngresoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cajaingresoDataAccess = new CajaIngresoDataAccess();
			this.cajaingresos= new ArrayList<CajaIngreso>();
			this.cajaingreso= new CajaIngreso();
			this.cajaingresoObject=new Object();
			this.cajaingresosObject=new ArrayList<Object>();
			
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
			
			this.cajaingresoDataAccess.setConnexionType(this.connexionType);
			this.cajaingresoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CajaIngreso getCajaIngreso() throws Exception {	
		CajaIngresoLogicAdditional.checkCajaIngresoToGet(cajaingreso,this.datosCliente,this.arrDatoGeneral);
		CajaIngresoLogicAdditional.updateCajaIngresoToGet(cajaingreso,this.arrDatoGeneral);
		
		return cajaingreso;
	}
		
	public void setCajaIngreso(CajaIngreso newCajaIngreso) {
		this.cajaingreso = newCajaIngreso;
	}
	
	public CajaIngresoDataAccess getCajaIngresoDataAccess() {
		return cajaingresoDataAccess;
	}
	
	public void setCajaIngresoDataAccess(CajaIngresoDataAccess newcajaingresoDataAccess) {
		this.cajaingresoDataAccess = newcajaingresoDataAccess;
	}
	
	public List<CajaIngreso> getCajaIngresos() throws Exception {		
		this.quitarCajaIngresosNulos();
		
		CajaIngresoLogicAdditional.checkCajaIngresoToGets(cajaingresos,this.datosCliente,this.arrDatoGeneral);
		
		for (CajaIngreso cajaingresoLocal: cajaingresos ) {
			CajaIngresoLogicAdditional.updateCajaIngresoToGet(cajaingresoLocal,this.arrDatoGeneral);
		}
		
		return cajaingresos;
	}
	
	public void setCajaIngresos(List<CajaIngreso> newCajaIngresos) {
		this.cajaingresos = newCajaIngresos;
	}
	
	public Object getCajaIngresoObject() {	
		this.cajaingresoObject=this.cajaingresoDataAccess.getEntityObject();
		return this.cajaingresoObject;
	}
		
	public void setCajaIngresoObject(Object newCajaIngresoObject) {
		this.cajaingresoObject = newCajaIngresoObject;
	}
	
	public List<Object> getCajaIngresosObject() {		
		this.cajaingresosObject=this.cajaingresoDataAccess.getEntitiesObject();
		return this.cajaingresosObject;
	}
		
	public void setCajaIngresosObject(List<Object> newCajaIngresosObject) {
		this.cajaingresosObject = newCajaIngresosObject;
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
		
		if(this.cajaingresoDataAccess!=null) {
			this.cajaingresoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cajaingresoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cajaingresoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cajaingreso = new  CajaIngreso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajaingreso=cajaingresoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaingreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingreso);
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
		cajaingreso = new  CajaIngreso();
		  		  
        try {
			
			cajaingreso=cajaingresoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaingreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cajaingreso = new  CajaIngreso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajaingreso=cajaingresoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaingreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingreso);
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
		cajaingreso = new  CajaIngreso();
		  		  
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
		cajaingreso = new  CajaIngreso();
		  		  
        try {
			
			cajaingreso=cajaingresoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaingreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cajaingreso = new  CajaIngreso();
		  		  
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
		cajaingreso = new  CajaIngreso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cajaingresoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaingreso = new  CajaIngreso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cajaingresoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajaingreso = new  CajaIngreso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cajaingresoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaingreso = new  CajaIngreso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cajaingresoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajaingreso = new  CajaIngreso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cajaingresoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaingreso = new  CajaIngreso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cajaingresoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajaingresos = new  ArrayList<CajaIngreso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresos=cajaingresoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaIngreso(cajaingresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
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
		cajaingresos = new  ArrayList<CajaIngreso>();
		  		  
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
		cajaingresos = new  ArrayList<CajaIngreso>();
		  		  
        try {			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresos=cajaingresoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCajaIngreso(cajaingresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cajaingresos = new  ArrayList<CajaIngreso>();
		  		  
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
		cajaingresos = new  ArrayList<CajaIngreso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresos=cajaingresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaIngreso(cajaingresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
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
		cajaingresos = new  ArrayList<CajaIngreso>();
		  		  
        try {
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresos=cajaingresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaIngreso(cajaingresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
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
		cajaingresos = new  ArrayList<CajaIngreso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresos=cajaingresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaIngreso(cajaingresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
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
		cajaingresos = new  ArrayList<CajaIngreso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresos=cajaingresoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaIngreso(cajaingresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cajaingreso = new  CajaIngreso();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingreso=cajaingresoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaIngreso(cajaingreso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingreso);
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
		cajaingreso = new  CajaIngreso();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingreso=cajaingresoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaIngreso(cajaingreso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajaingresos = new  ArrayList<CajaIngreso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresos=cajaingresoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaIngreso(cajaingresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
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
		cajaingresos = new  ArrayList<CajaIngreso>();
		  		  
        try {
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresos=cajaingresoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaIngreso(cajaingresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCajaIngresosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cajaingresos = new  ArrayList<CajaIngreso>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getTodosCajaIngresosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajaIngreso(cajaingresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
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
	
	public  void  getTodosCajaIngresos(String sFinalQuery,Pagination pagination)throws Exception {
		cajaingresos = new  ArrayList<CajaIngreso>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajaIngreso(cajaingresos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCajaIngreso(CajaIngreso cajaingreso) throws Exception {
		Boolean estaValidado=false;
		
		if(cajaingreso.getIsNew() || cajaingreso.getIsChanged()) { 
			this.invalidValues = cajaingresoValidator.getInvalidValues(cajaingreso);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cajaingreso);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCajaIngreso(List<CajaIngreso> CajaIngresos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CajaIngreso cajaingresoLocal:cajaingresos) {				
			estaValidadoObjeto=this.validarGuardarCajaIngreso(cajaingresoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCajaIngreso(List<CajaIngreso> CajaIngresos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajaIngreso(cajaingresos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCajaIngreso(CajaIngreso CajaIngreso) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajaIngreso(cajaingreso)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CajaIngreso cajaingreso) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cajaingreso.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CajaIngresoConstantesFunciones.getCajaIngresoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cajaingreso","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CajaIngresoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CajaIngresoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCajaIngresoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-saveCajaIngresoWithConnection");connexion.begin();			
			
			CajaIngresoLogicAdditional.checkCajaIngresoToSave(this.cajaingreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajaIngresoLogicAdditional.updateCajaIngresoToSave(this.cajaingreso,this.arrDatoGeneral);
			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajaingreso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCajaIngreso();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajaIngreso(this.cajaingreso)) {
				CajaIngresoDataAccess.save(this.cajaingreso, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cajaingreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajaIngresoLogicAdditional.checkCajaIngresoToSaveAfter(this.cajaingreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajaIngreso();
			
			connexion.commit();			
			
			if(this.cajaingreso.getIsDeleted()) {
				this.cajaingreso=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCajaIngreso()throws Exception {	
		try {	
			
			CajaIngresoLogicAdditional.checkCajaIngresoToSave(this.cajaingreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajaIngresoLogicAdditional.updateCajaIngresoToSave(this.cajaingreso,this.arrDatoGeneral);
			
			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajaingreso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajaIngreso(this.cajaingreso)) {			
				CajaIngresoDataAccess.save(this.cajaingreso, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cajaingreso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajaIngresoLogicAdditional.checkCajaIngresoToSaveAfter(this.cajaingreso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cajaingreso.getIsDeleted()) {
				this.cajaingreso=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCajaIngresosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-saveCajaIngresosWithConnection");connexion.begin();			
			
			CajaIngresoLogicAdditional.checkCajaIngresoToSaves(cajaingresos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCajaIngresos();
			
			Boolean validadoTodosCajaIngreso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajaIngreso cajaingresoLocal:cajaingresos) {		
				if(cajaingresoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajaIngresoLogicAdditional.updateCajaIngresoToSave(cajaingresoLocal,this.arrDatoGeneral);
	        	
				CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajaingresoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajaIngreso(cajaingresoLocal)) {
					CajaIngresoDataAccess.save(cajaingresoLocal, connexion);				
				} else {
					validadoTodosCajaIngreso=false;
				}
			}
			
			if(!validadoTodosCajaIngreso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajaIngresoLogicAdditional.checkCajaIngresoToSavesAfter(cajaingresos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajaIngresos();
			
			connexion.commit();		
			
			this.quitarCajaIngresosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCajaIngresos()throws Exception {				
		 try {	
			CajaIngresoLogicAdditional.checkCajaIngresoToSaves(cajaingresos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCajaIngreso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajaIngreso cajaingresoLocal:cajaingresos) {				
				if(cajaingresoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajaIngresoLogicAdditional.updateCajaIngresoToSave(cajaingresoLocal,this.arrDatoGeneral);
	        	
				CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajaingresoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajaIngreso(cajaingresoLocal)) {				
					CajaIngresoDataAccess.save(cajaingresoLocal, connexion);				
				} else {
					validadoTodosCajaIngreso=false;
				}
			}
			
			if(!validadoTodosCajaIngreso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajaIngresoLogicAdditional.checkCajaIngresoToSavesAfter(cajaingresos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCajaIngresosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaIngresoParameterReturnGeneral procesarAccionCajaIngresos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaIngreso> cajaingresos,CajaIngresoParameterReturnGeneral cajaingresoParameterGeneral)throws Exception {
		 try {	
			CajaIngresoParameterReturnGeneral cajaingresoReturnGeneral=new CajaIngresoParameterReturnGeneral();
	
			CajaIngresoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajaingresos,cajaingresoParameterGeneral,cajaingresoReturnGeneral);
			
			return cajaingresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaIngresoParameterReturnGeneral procesarAccionCajaIngresosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaIngreso> cajaingresos,CajaIngresoParameterReturnGeneral cajaingresoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-procesarAccionCajaIngresosWithConnection");connexion.begin();			
			
			CajaIngresoParameterReturnGeneral cajaingresoReturnGeneral=new CajaIngresoParameterReturnGeneral();
	
			CajaIngresoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajaingresos,cajaingresoParameterGeneral,cajaingresoReturnGeneral);
			
			this.connexion.commit();
			
			return cajaingresoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaIngresoParameterReturnGeneral procesarEventosCajaIngresos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajaIngreso> cajaingresos,CajaIngreso cajaingreso,CajaIngresoParameterReturnGeneral cajaingresoParameterGeneral,Boolean isEsNuevoCajaIngreso,ArrayList<Classe> clases)throws Exception {
		 try {	
			CajaIngresoParameterReturnGeneral cajaingresoReturnGeneral=new CajaIngresoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajaingresoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajaIngresoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajaingresos,cajaingreso,cajaingresoParameterGeneral,cajaingresoReturnGeneral,isEsNuevoCajaIngreso,clases);
			
			return cajaingresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CajaIngresoParameterReturnGeneral procesarEventosCajaIngresosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajaIngreso> cajaingresos,CajaIngreso cajaingreso,CajaIngresoParameterReturnGeneral cajaingresoParameterGeneral,Boolean isEsNuevoCajaIngreso,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-procesarEventosCajaIngresosWithConnection");connexion.begin();			
			
			CajaIngresoParameterReturnGeneral cajaingresoReturnGeneral=new CajaIngresoParameterReturnGeneral();
	
			cajaingresoReturnGeneral.setCajaIngreso(cajaingreso);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajaingresoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajaIngresoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajaingresos,cajaingreso,cajaingresoParameterGeneral,cajaingresoReturnGeneral,isEsNuevoCajaIngreso,clases);
			
			this.connexion.commit();
			
			return cajaingresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaIngresoParameterReturnGeneral procesarImportacionCajaIngresosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CajaIngresoParameterReturnGeneral cajaingresoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-procesarImportacionCajaIngresosWithConnection");connexion.begin();			
			
			CajaIngresoParameterReturnGeneral cajaingresoReturnGeneral=new CajaIngresoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cajaingresos=new ArrayList<CajaIngreso>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cajaingreso=new CajaIngreso();
				
				
				if(conColumnasBase) {this.cajaingreso.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cajaingreso.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cajaingreso.setsecuencial(arrColumnas[iColumn++]);
				this.cajaingreso.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				//this.cajaingreso.sethora(arrColumnas[iColumn++]);
				
				this.cajaingresos.add(this.cajaingreso);
			}
			
			this.saveCajaIngresos();
			
			this.connexion.commit();
			
			cajaingresoReturnGeneral.setConRetornoEstaProcesado(true);
			cajaingresoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cajaingresoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCajaIngresosEliminados() throws Exception {				
		
		List<CajaIngreso> cajaingresosAux= new ArrayList<CajaIngreso>();
		
		for(CajaIngreso cajaingreso:cajaingresos) {
			if(!cajaingreso.getIsDeleted()) {
				cajaingresosAux.add(cajaingreso);
			}
		}
		
		cajaingresos=cajaingresosAux;
	}
	
	public void quitarCajaIngresosNulos() throws Exception {				
		
		List<CajaIngreso> cajaingresosAux= new ArrayList<CajaIngreso>();
		
		for(CajaIngreso cajaingreso : this.cajaingresos) {
			if(cajaingreso==null) {
				cajaingresosAux.add(cajaingreso);
			}
		}
		
		//this.cajaingresos=cajaingresosAux;
		
		this.cajaingresos.removeAll(cajaingresosAux);
	}
	
	public void getSetVersionRowCajaIngresoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cajaingreso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cajaingreso.getIsDeleted() || (cajaingreso.getIsChanged()&&!cajaingreso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cajaingresoDataAccess.getSetVersionRowCajaIngreso(connexion,cajaingreso.getId());
				
				if(!cajaingreso.getVersionRow().equals(timestamp)) {	
					cajaingreso.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cajaingreso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCajaIngreso()throws Exception {	
		
		if(cajaingreso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cajaingreso.getIsDeleted() || (cajaingreso.getIsChanged()&&!cajaingreso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cajaingresoDataAccess.getSetVersionRowCajaIngreso(connexion,cajaingreso.getId());
			
			try {							
				if(!cajaingreso.getVersionRow().equals(timestamp)) {	
					cajaingreso.setVersionRow(timestamp);
				}
				
				cajaingreso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCajaIngresosWithConnection()throws Exception {	
		if(cajaingresos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CajaIngreso cajaingresoAux:cajaingresos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cajaingresoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajaingresoAux.getIsDeleted() || (cajaingresoAux.getIsChanged()&&!cajaingresoAux.getIsNew())) {
						
						timestamp=cajaingresoDataAccess.getSetVersionRowCajaIngreso(connexion,cajaingresoAux.getId());
						
						if(!cajaingreso.getVersionRow().equals(timestamp)) {	
							cajaingresoAux.setVersionRow(timestamp);
						}
								
						cajaingresoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCajaIngresos()throws Exception {	
		if(cajaingresos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CajaIngreso cajaingresoAux:cajaingresos) {
					if(cajaingresoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajaingresoAux.getIsDeleted() || (cajaingresoAux.getIsChanged()&&!cajaingresoAux.getIsNew())) {
						
						timestamp=cajaingresoDataAccess.getSetVersionRowCajaIngreso(connexion,cajaingresoAux.getId());
						
						if(!cajaingresoAux.getVersionRow().equals(timestamp)) {	
							cajaingresoAux.setVersionRow(timestamp);
						}
						
													
						cajaingresoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CajaIngresoParameterReturnGeneral cargarCombosLoteForeignKeyCajaIngresoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalCaja,String finalQueryGlobalTurnoPunVen) throws Exception {
		CajaIngresoParameterReturnGeneral  cajaingresoReturnGeneral =new CajaIngresoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-cargarCombosLoteForeignKeyCajaIngresoWithConnection");connexion.begin();
			
			cajaingresoReturnGeneral =new CajaIngresoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajaingresoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajaingresoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			cajaingresoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			cajaingresoReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<TurnoPunVen> turnopunvensForeignKey=new ArrayList<TurnoPunVen>();
			TurnoPunVenLogic turnopunvenLogic=new TurnoPunVenLogic();
			turnopunvenLogic.setConnexion(this.connexion);
			turnopunvenLogic.getTurnoPunVenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTurnoPunVen.equals("NONE")) {
				turnopunvenLogic.getTodosTurnoPunVens(finalQueryGlobalTurnoPunVen,new Pagination());
				turnopunvensForeignKey=turnopunvenLogic.getTurnoPunVens();
			}

			cajaingresoReturnGeneral.setturnopunvensForeignKey(turnopunvensForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cajaingresoReturnGeneral;
	}
	
	public CajaIngresoParameterReturnGeneral cargarCombosLoteForeignKeyCajaIngreso(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalCaja,String finalQueryGlobalTurnoPunVen) throws Exception {
		CajaIngresoParameterReturnGeneral  cajaingresoReturnGeneral =new CajaIngresoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cajaingresoReturnGeneral =new CajaIngresoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajaingresoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajaingresoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			cajaingresoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			cajaingresoReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<TurnoPunVen> turnopunvensForeignKey=new ArrayList<TurnoPunVen>();
			TurnoPunVenLogic turnopunvenLogic=new TurnoPunVenLogic();
			turnopunvenLogic.setConnexion(this.connexion);
			turnopunvenLogic.getTurnoPunVenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTurnoPunVen.equals("NONE")) {
				turnopunvenLogic.getTodosTurnoPunVens(finalQueryGlobalTurnoPunVen,new Pagination());
				turnopunvensForeignKey=turnopunvenLogic.getTurnoPunVens();
			}

			cajaingresoReturnGeneral.setturnopunvensForeignKey(turnopunvensForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cajaingresoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCajaIngresoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CajaIngresoDetalleLogic cajaingresodetalleLogic=new CajaIngresoDetalleLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCajaIngresoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CajaIngresoDetalle.class));
											
			

			cajaingresodetalleLogic.setConnexion(this.getConnexion());
			cajaingresodetalleLogic.setDatosCliente(this.datosCliente);
			cajaingresodetalleLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(CajaIngreso cajaingreso:this.cajaingresos) {
				

				classes=new ArrayList<Classe>();
				classes=CajaIngresoDetalleConstantesFunciones.getClassesForeignKeysOfCajaIngresoDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajaingresodetalleLogic.setCajaIngresoDetalles(cajaingreso.cajaingresodetalles);
				cajaingresodetalleLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(CajaIngreso cajaingreso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CajaIngresoLogicAdditional.updateCajaIngresoToGet(cajaingreso,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajaingreso.setEmpresa(cajaingresoDataAccess.getEmpresa(connexion,cajaingreso));
		cajaingreso.setSucursal(cajaingresoDataAccess.getSucursal(connexion,cajaingreso));
		cajaingreso.setUsuario(cajaingresoDataAccess.getUsuario(connexion,cajaingreso));
		cajaingreso.setCaja(cajaingresoDataAccess.getCaja(connexion,cajaingreso));
		cajaingreso.setTurnoPunVen(cajaingresoDataAccess.getTurnoPunVen(connexion,cajaingreso));
		cajaingreso.setCajaIngresoDetalles(cajaingresoDataAccess.getCajaIngresoDetalles(connexion,cajaingreso));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajaingreso.setEmpresa(cajaingresoDataAccess.getEmpresa(connexion,cajaingreso));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajaingreso.setSucursal(cajaingresoDataAccess.getSucursal(connexion,cajaingreso));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				cajaingreso.setUsuario(cajaingresoDataAccess.getUsuario(connexion,cajaingreso));
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				cajaingreso.setCaja(cajaingresoDataAccess.getCaja(connexion,cajaingreso));
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				cajaingreso.setTurnoPunVen(cajaingresoDataAccess.getTurnoPunVen(connexion,cajaingreso));
				continue;
			}

			if(clas.clas.equals(CajaIngresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cajaingreso.setCajaIngresoDetalles(cajaingresoDataAccess.getCajaIngresoDetalles(connexion,cajaingreso));

				if(this.isConDeep) {
					CajaIngresoDetalleLogic cajaingresodetalleLogic= new CajaIngresoDetalleLogic(this.connexion);
					cajaingresodetalleLogic.setCajaIngresoDetalles(cajaingreso.getCajaIngresoDetalles());
					ArrayList<Classe> classesLocal=CajaIngresoDetalleConstantesFunciones.getClassesForeignKeysOfCajaIngresoDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajaingresodetalleLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(cajaingresodetalleLogic.getCajaIngresoDetalles());
					cajaingreso.setCajaIngresoDetalles(cajaingresodetalleLogic.getCajaIngresoDetalles());
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
			cajaingreso.setEmpresa(cajaingresoDataAccess.getEmpresa(connexion,cajaingreso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingreso.setSucursal(cajaingresoDataAccess.getSucursal(connexion,cajaingreso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingreso.setUsuario(cajaingresoDataAccess.getUsuario(connexion,cajaingreso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingreso.setCaja(cajaingresoDataAccess.getCaja(connexion,cajaingreso));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TurnoPunVen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingreso.setTurnoPunVen(cajaingresoDataAccess.getTurnoPunVen(connexion,cajaingreso));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaIngresoDetalle.class));
			cajaingreso.setCajaIngresoDetalles(cajaingresoDataAccess.getCajaIngresoDetalles(connexion,cajaingreso));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajaingreso.setEmpresa(cajaingresoDataAccess.getEmpresa(connexion,cajaingreso));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajaingreso.getEmpresa(),isDeep,deepLoadType,clases);
				
		cajaingreso.setSucursal(cajaingresoDataAccess.getSucursal(connexion,cajaingreso));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajaingreso.getSucursal(),isDeep,deepLoadType,clases);
				
		cajaingreso.setUsuario(cajaingresoDataAccess.getUsuario(connexion,cajaingreso));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(cajaingreso.getUsuario(),isDeep,deepLoadType,clases);
				
		cajaingreso.setCaja(cajaingresoDataAccess.getCaja(connexion,cajaingreso));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(cajaingreso.getCaja(),isDeep,deepLoadType,clases);
				
		cajaingreso.setTurnoPunVen(cajaingresoDataAccess.getTurnoPunVen(connexion,cajaingreso));
		TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
		turnopunvenLogic.deepLoad(cajaingreso.getTurnoPunVen(),isDeep,deepLoadType,clases);
				

		cajaingreso.setCajaIngresoDetalles(cajaingresoDataAccess.getCajaIngresoDetalles(connexion,cajaingreso));

		for(CajaIngresoDetalle cajaingresodetalle:cajaingreso.getCajaIngresoDetalles()) {
			CajaIngresoDetalleLogic cajaingresodetalleLogic= new CajaIngresoDetalleLogic(connexion);
			cajaingresodetalleLogic.deepLoad(cajaingresodetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajaingreso.setEmpresa(cajaingresoDataAccess.getEmpresa(connexion,cajaingreso));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cajaingreso.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajaingreso.setSucursal(cajaingresoDataAccess.getSucursal(connexion,cajaingreso));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cajaingreso.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				cajaingreso.setUsuario(cajaingresoDataAccess.getUsuario(connexion,cajaingreso));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(cajaingreso.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				cajaingreso.setCaja(cajaingresoDataAccess.getCaja(connexion,cajaingreso));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(cajaingreso.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				cajaingreso.setTurnoPunVen(cajaingresoDataAccess.getTurnoPunVen(connexion,cajaingreso));
				TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
				turnopunvenLogic.deepLoad(cajaingreso.getTurnoPunVen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CajaIngresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cajaingreso.setCajaIngresoDetalles(cajaingresoDataAccess.getCajaIngresoDetalles(connexion,cajaingreso));

				for(CajaIngresoDetalle cajaingresodetalle:cajaingreso.getCajaIngresoDetalles()) {
					CajaIngresoDetalleLogic cajaingresodetalleLogic= new CajaIngresoDetalleLogic(connexion);
					cajaingresodetalleLogic.deepLoad(cajaingresodetalle,isDeep,deepLoadType,clases);
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
			cajaingreso.setEmpresa(cajaingresoDataAccess.getEmpresa(connexion,cajaingreso));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cajaingreso.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingreso.setSucursal(cajaingresoDataAccess.getSucursal(connexion,cajaingreso));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cajaingreso.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingreso.setUsuario(cajaingresoDataAccess.getUsuario(connexion,cajaingreso));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(cajaingreso.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingreso.setCaja(cajaingresoDataAccess.getCaja(connexion,cajaingreso));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(cajaingreso.getCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TurnoPunVen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingreso.setTurnoPunVen(cajaingresoDataAccess.getTurnoPunVen(connexion,cajaingreso));
			TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
			turnopunvenLogic.deepLoad(cajaingreso.getTurnoPunVen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaIngresoDetalle.class));
			cajaingreso.setCajaIngresoDetalles(cajaingresoDataAccess.getCajaIngresoDetalles(connexion,cajaingreso));

			for(CajaIngresoDetalle cajaingresodetalle:cajaingreso.getCajaIngresoDetalles()) {
				CajaIngresoDetalleLogic cajaingresodetalleLogic= new CajaIngresoDetalleLogic(connexion);
				cajaingresodetalleLogic.deepLoad(cajaingresodetalle,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CajaIngreso cajaingreso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CajaIngresoLogicAdditional.updateCajaIngresoToSave(cajaingreso,this.arrDatoGeneral);
			
CajaIngresoDataAccess.save(cajaingreso, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cajaingreso.getEmpresa(),connexion);

		SucursalDataAccess.save(cajaingreso.getSucursal(),connexion);

		UsuarioDataAccess.save(cajaingreso.getUsuario(),connexion);

		CajaDataAccess.save(cajaingreso.getCaja(),connexion);

		TurnoPunVenDataAccess.save(cajaingreso.getTurnoPunVen(),connexion);

		for(CajaIngresoDetalle cajaingresodetalle:cajaingreso.getCajaIngresoDetalles()) {
			cajaingresodetalle.setid_caja_ingreso(cajaingreso.getId());
			CajaIngresoDetalleDataAccess.save(cajaingresodetalle,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajaingreso.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajaingreso.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(cajaingreso.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(cajaingreso.getCaja(),connexion);
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				TurnoPunVenDataAccess.save(cajaingreso.getTurnoPunVen(),connexion);
				continue;
			}


			if(clas.clas.equals(CajaIngresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaIngresoDetalle cajaingresodetalle:cajaingreso.getCajaIngresoDetalles()) {
					cajaingresodetalle.setid_caja_ingreso(cajaingreso.getId());
					CajaIngresoDetalleDataAccess.save(cajaingresodetalle,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cajaingreso.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajaingreso.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(cajaingreso.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajaingreso.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(cajaingreso.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(cajaingreso.getUsuario(),isDeep,deepLoadType,clases);
				

		CajaDataAccess.save(cajaingreso.getCaja(),connexion);
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(cajaingreso.getCaja(),isDeep,deepLoadType,clases);
				

		TurnoPunVenDataAccess.save(cajaingreso.getTurnoPunVen(),connexion);
		TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
		turnopunvenLogic.deepLoad(cajaingreso.getTurnoPunVen(),isDeep,deepLoadType,clases);
				

		for(CajaIngresoDetalle cajaingresodetalle:cajaingreso.getCajaIngresoDetalles()) {
			CajaIngresoDetalleLogic cajaingresodetalleLogic= new CajaIngresoDetalleLogic(connexion);
			cajaingresodetalle.setid_caja_ingreso(cajaingreso.getId());
			CajaIngresoDetalleDataAccess.save(cajaingresodetalle,connexion);
			cajaingresodetalleLogic.deepSave(cajaingresodetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajaingreso.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cajaingreso.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajaingreso.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(cajaingreso.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(cajaingreso.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(cajaingreso.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(cajaingreso.getCaja(),connexion);
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepSave(cajaingreso.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				TurnoPunVenDataAccess.save(cajaingreso.getTurnoPunVen(),connexion);
				TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
				turnopunvenLogic.deepSave(cajaingreso.getTurnoPunVen(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(CajaIngresoDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaIngresoDetalle cajaingresodetalle:cajaingreso.getCajaIngresoDetalles()) {
					CajaIngresoDetalleLogic cajaingresodetalleLogic= new CajaIngresoDetalleLogic(connexion);
					cajaingresodetalle.setid_caja_ingreso(cajaingreso.getId());
					CajaIngresoDetalleDataAccess.save(cajaingresodetalle,connexion);
					cajaingresodetalleLogic.deepSave(cajaingresodetalle,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(CajaIngreso.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cajaingreso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(cajaingreso);
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
			this.deepLoad(this.cajaingreso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingreso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CajaIngreso.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cajaingresos!=null) {
				for(CajaIngreso cajaingreso:cajaingresos) {
					this.deepLoad(cajaingreso,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(cajaingresos);
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
			if(cajaingresos!=null) {
				for(CajaIngreso cajaingreso:cajaingresos) {
					this.deepLoad(cajaingreso,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(cajaingresos);
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
			this.getNewConnexionToDeep(CajaIngreso.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cajaingreso,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CajaIngreso.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cajaingresos!=null) {
				for(CajaIngreso cajaingreso:cajaingresos) {
					this.deepSave(cajaingreso,isDeep,deepLoadType,clases);
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
			if(cajaingresos!=null) {
				for(CajaIngreso cajaingreso:cajaingresos) {
					this.deepSave(cajaingreso,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCajaIngresosFK_IdCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,CajaIngresoConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaIngresosFK_IdCaja(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,CajaIngresoConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaIngresosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaIngresoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaIngresosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaIngresoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaIngresosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaIngresoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaIngresosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaIngresoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaIngresosFK_IdTurnoPunVenWithConnection(String sFinalQuery,Pagination pagination,Long id_turno_pun_ven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTurnoPunVen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTurnoPunVen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_turno_pun_ven,CajaIngresoConstantesFunciones.IDTURNOPUNVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTurnoPunVen);

			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTurnoPunVen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaIngresosFK_IdTurnoPunVen(String sFinalQuery,Pagination pagination,Long id_turno_pun_ven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTurnoPunVen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTurnoPunVen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_turno_pun_ven,CajaIngresoConstantesFunciones.IDTURNOPUNVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTurnoPunVen);

			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTurnoPunVen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaIngresosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngreso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,CajaIngresoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaIngresosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,CajaIngresoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			CajaIngresoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(this.cajaingresos);
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
			if(CajaIngresoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaIngresoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CajaIngreso cajaingreso,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CajaIngresoConstantesFunciones.ISCONAUDITORIA) {
				if(cajaingreso.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaIngresoDataAccess.TABLENAME, cajaingreso.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaIngresoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaIngresoLogic.registrarAuditoriaDetallesCajaIngreso(connexion,cajaingreso,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cajaingreso.getIsDeleted()) {
					/*if(!cajaingreso.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CajaIngresoDataAccess.TABLENAME, cajaingreso.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CajaIngresoLogic.registrarAuditoriaDetallesCajaIngreso(connexion,cajaingreso,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaIngresoDataAccess.TABLENAME, cajaingreso.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cajaingreso.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaIngresoDataAccess.TABLENAME, cajaingreso.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaIngresoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaIngresoLogic.registrarAuditoriaDetallesCajaIngreso(connexion,cajaingreso,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCajaIngreso(Connexion connexion,CajaIngreso cajaingreso)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cajaingreso.getIsNew()||!cajaingreso.getid_empresa().equals(cajaingreso.getCajaIngresoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingreso.getCajaIngresoOriginal().getid_empresa()!=null)
				{
					strValorActual=cajaingreso.getCajaIngresoOriginal().getid_empresa().toString();
				}
				if(cajaingreso.getid_empresa()!=null)
				{
					strValorNuevo=cajaingreso.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cajaingreso.getIsNew()||!cajaingreso.getid_sucursal().equals(cajaingreso.getCajaIngresoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingreso.getCajaIngresoOriginal().getid_sucursal()!=null)
				{
					strValorActual=cajaingreso.getCajaIngresoOriginal().getid_sucursal().toString();
				}
				if(cajaingreso.getid_sucursal()!=null)
				{
					strValorNuevo=cajaingreso.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(cajaingreso.getIsNew()||!cajaingreso.getid_usuario().equals(cajaingreso.getCajaIngresoOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingreso.getCajaIngresoOriginal().getid_usuario()!=null)
				{
					strValorActual=cajaingreso.getCajaIngresoOriginal().getid_usuario().toString();
				}
				if(cajaingreso.getid_usuario()!=null)
				{
					strValorNuevo=cajaingreso.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(cajaingreso.getIsNew()||!cajaingreso.getid_caja().equals(cajaingreso.getCajaIngresoOriginal().getid_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingreso.getCajaIngresoOriginal().getid_caja()!=null)
				{
					strValorActual=cajaingreso.getCajaIngresoOriginal().getid_caja().toString();
				}
				if(cajaingreso.getid_caja()!=null)
				{
					strValorNuevo=cajaingreso.getid_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoConstantesFunciones.IDCAJA,strValorActual,strValorNuevo);
			}	
			
			if(cajaingreso.getIsNew()||!cajaingreso.getid_turno_pun_ven().equals(cajaingreso.getCajaIngresoOriginal().getid_turno_pun_ven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingreso.getCajaIngresoOriginal().getid_turno_pun_ven()!=null)
				{
					strValorActual=cajaingreso.getCajaIngresoOriginal().getid_turno_pun_ven().toString();
				}
				if(cajaingreso.getid_turno_pun_ven()!=null)
				{
					strValorNuevo=cajaingreso.getid_turno_pun_ven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoConstantesFunciones.IDTURNOPUNVEN,strValorActual,strValorNuevo);
			}	
			
			if(cajaingreso.getIsNew()||!cajaingreso.getsecuencial().equals(cajaingreso.getCajaIngresoOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingreso.getCajaIngresoOriginal().getsecuencial()!=null)
				{
					strValorActual=cajaingreso.getCajaIngresoOriginal().getsecuencial();
				}
				if(cajaingreso.getsecuencial()!=null)
				{
					strValorNuevo=cajaingreso.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(cajaingreso.getIsNew()||!cajaingreso.getfecha().equals(cajaingreso.getCajaIngresoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingreso.getCajaIngresoOriginal().getfecha()!=null)
				{
					strValorActual=cajaingreso.getCajaIngresoOriginal().getfecha().toString();
				}
				if(cajaingreso.getfecha()!=null)
				{
					strValorNuevo=cajaingreso.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(cajaingreso.getIsNew()||!cajaingreso.gethora().equals(cajaingreso.getCajaIngresoOriginal().gethora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingreso.getCajaIngresoOriginal().gethora()!=null)
				{
					strValorActual=cajaingreso.getCajaIngresoOriginal().gethora().toString();
				}
				if(cajaingreso.gethora()!=null)
				{
					strValorNuevo=cajaingreso.gethora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoConstantesFunciones.HORA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCajaIngresoRelacionesWithConnection(CajaIngreso cajaingreso,List<CajaIngresoDetalle> cajaingresodetalles) throws Exception {

		if(!cajaingreso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajaIngresoRelacionesBase(cajaingreso,cajaingresodetalles,true);
		}
	}

	public void saveCajaIngresoRelaciones(CajaIngreso cajaingreso,List<CajaIngresoDetalle> cajaingresodetalles)throws Exception {

		if(!cajaingreso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajaIngresoRelacionesBase(cajaingreso,cajaingresodetalles,false);
		}
	}

	public void saveCajaIngresoRelacionesBase(CajaIngreso cajaingreso,List<CajaIngresoDetalle> cajaingresodetalles,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CajaIngreso-saveRelacionesWithConnection");}
	
			cajaingreso.setCajaIngresoDetalles(cajaingresodetalles);

			this.setCajaIngreso(cajaingreso);

			if(CajaIngresoLogicAdditional.validarSaveRelaciones(cajaingreso,this)) {

				CajaIngresoLogicAdditional.updateRelacionesToSave(cajaingreso,this);

				if((cajaingreso.getIsNew()||cajaingreso.getIsChanged())&&!cajaingreso.getIsDeleted()) {
					this.saveCajaIngreso();
					this.saveCajaIngresoRelacionesDetalles(cajaingresodetalles);

				} else if(cajaingreso.getIsDeleted()) {
					this.saveCajaIngresoRelacionesDetalles(cajaingresodetalles);
					this.saveCajaIngreso();
				}

				CajaIngresoLogicAdditional.updateRelacionesToSaveAfter(cajaingreso,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CajaIngresoDetalleConstantesFunciones.InicializarGeneralEntityAuxiliaresCajaIngresoDetalles(cajaingresodetalles,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCajaIngresoRelacionesDetalles(List<CajaIngresoDetalle> cajaingresodetalles)throws Exception {
		try {
	

			Long idCajaIngresoActual=this.getCajaIngreso().getId();

			CajaIngresoDetalleLogic cajaingresodetalleLogic_Desde_CajaIngreso=new CajaIngresoDetalleLogic();
			cajaingresodetalleLogic_Desde_CajaIngreso.setCajaIngresoDetalles(cajaingresodetalles);

			cajaingresodetalleLogic_Desde_CajaIngreso.setConnexion(this.getConnexion());
			cajaingresodetalleLogic_Desde_CajaIngreso.setDatosCliente(this.datosCliente);

			for(CajaIngresoDetalle cajaingresodetalle_Desde_CajaIngreso:cajaingresodetalleLogic_Desde_CajaIngreso.getCajaIngresoDetalles()) {
				cajaingresodetalle_Desde_CajaIngreso.setid_caja_ingreso(idCajaIngresoActual);
			}

			cajaingresodetalleLogic_Desde_CajaIngreso.saveCajaIngresoDetalles();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCajaIngreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaIngresoConstantesFunciones.getClassesForeignKeysOfCajaIngreso(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaIngreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaIngresoConstantesFunciones.getClassesRelationshipsOfCajaIngreso(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
