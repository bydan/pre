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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.PagoAutoConstantesFunciones;
import com.bydan.erp.tesoreria.util.PagoAutoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.PagoAutoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.PagoAuto;
import com.bydan.erp.tesoreria.business.logic.PagoAutoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class PagoAutoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PagoAutoLogic.class);
	
	protected PagoAutoDataAccess pagoautoDataAccess; 	
	protected PagoAuto pagoauto;
	protected List<PagoAuto> pagoautos;
	protected Object pagoautoObject;	
	protected List<Object> pagoautosObject;
	
	public static ClassValidator<PagoAuto> pagoautoValidator = new ClassValidator<PagoAuto>(PagoAuto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PagoAutoLogicAdditional pagoautoLogicAdditional=null;
	
	public PagoAutoLogicAdditional getPagoAutoLogicAdditional() {
		return this.pagoautoLogicAdditional;
	}
	
	public void setPagoAutoLogicAdditional(PagoAutoLogicAdditional pagoautoLogicAdditional) {
		try {
			this.pagoautoLogicAdditional=pagoautoLogicAdditional;
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
	
	
	
	
	public  PagoAutoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.pagoautoDataAccess = new PagoAutoDataAccess();
			
			this.pagoautos= new ArrayList<PagoAuto>();
			this.pagoauto= new PagoAuto();
			
			this.pagoautoObject=new Object();
			this.pagoautosObject=new ArrayList<Object>();
				
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
			
			this.pagoautoDataAccess.setConnexionType(this.connexionType);
			this.pagoautoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PagoAutoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.pagoautoDataAccess = new PagoAutoDataAccess();
			this.pagoautos= new ArrayList<PagoAuto>();
			this.pagoauto= new PagoAuto();
			this.pagoautoObject=new Object();
			this.pagoautosObject=new ArrayList<Object>();
			
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
			
			this.pagoautoDataAccess.setConnexionType(this.connexionType);
			this.pagoautoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PagoAuto getPagoAuto() throws Exception {	
		PagoAutoLogicAdditional.checkPagoAutoToGet(pagoauto,this.datosCliente,this.arrDatoGeneral);
		PagoAutoLogicAdditional.updatePagoAutoToGet(pagoauto,this.arrDatoGeneral);
		
		return pagoauto;
	}
		
	public void setPagoAuto(PagoAuto newPagoAuto) {
		this.pagoauto = newPagoAuto;
	}
	
	public PagoAutoDataAccess getPagoAutoDataAccess() {
		return pagoautoDataAccess;
	}
	
	public void setPagoAutoDataAccess(PagoAutoDataAccess newpagoautoDataAccess) {
		this.pagoautoDataAccess = newpagoautoDataAccess;
	}
	
	public List<PagoAuto> getPagoAutos() throws Exception {		
		this.quitarPagoAutosNulos();
		
		PagoAutoLogicAdditional.checkPagoAutoToGets(pagoautos,this.datosCliente,this.arrDatoGeneral);
		
		for (PagoAuto pagoautoLocal: pagoautos ) {
			PagoAutoLogicAdditional.updatePagoAutoToGet(pagoautoLocal,this.arrDatoGeneral);
		}
		
		return pagoautos;
	}
	
	public void setPagoAutos(List<PagoAuto> newPagoAutos) {
		this.pagoautos = newPagoAutos;
	}
	
	public Object getPagoAutoObject() {	
		this.pagoautoObject=this.pagoautoDataAccess.getEntityObject();
		return this.pagoautoObject;
	}
		
	public void setPagoAutoObject(Object newPagoAutoObject) {
		this.pagoautoObject = newPagoAutoObject;
	}
	
	public List<Object> getPagoAutosObject() {		
		this.pagoautosObject=this.pagoautoDataAccess.getEntitiesObject();
		return this.pagoautosObject;
	}
		
	public void setPagoAutosObject(List<Object> newPagoAutosObject) {
		this.pagoautosObject = newPagoAutosObject;
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
		
		if(this.pagoautoDataAccess!=null) {
			this.pagoautoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			pagoautoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			pagoautoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		pagoauto = new  PagoAuto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pagoauto=pagoautoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoauto);
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
		pagoauto = new  PagoAuto();
		  		  
        try {
			
			pagoauto=pagoautoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoauto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		pagoauto = new  PagoAuto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pagoauto=pagoautoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoauto);
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
		pagoauto = new  PagoAuto();
		  		  
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
		pagoauto = new  PagoAuto();
		  		  
        try {
			
			pagoauto=pagoautoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoauto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		pagoauto = new  PagoAuto();
		  		  
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
		pagoauto = new  PagoAuto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =pagoautoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pagoauto = new  PagoAuto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=pagoautoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pagoauto = new  PagoAuto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =pagoautoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pagoauto = new  PagoAuto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=pagoautoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pagoauto = new  PagoAuto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =pagoautoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pagoauto = new  PagoAuto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=pagoautoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pagoautos = new  ArrayList<PagoAuto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoautos=pagoautoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPagoAuto(pagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
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
		pagoautos = new  ArrayList<PagoAuto>();
		  		  
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
		pagoautos = new  ArrayList<PagoAuto>();
		  		  
        try {			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoautos=pagoautoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPagoAuto(pagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		pagoautos = new  ArrayList<PagoAuto>();
		  		  
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
		pagoautos = new  ArrayList<PagoAuto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoautos=pagoautoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPagoAuto(pagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
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
		pagoautos = new  ArrayList<PagoAuto>();
		  		  
        try {
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoautos=pagoautoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPagoAuto(pagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
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
		pagoautos = new  ArrayList<PagoAuto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoautos=pagoautoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPagoAuto(pagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
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
		pagoautos = new  ArrayList<PagoAuto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoautos=pagoautoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPagoAuto(pagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		pagoauto = new  PagoAuto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoauto=pagoautoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPagoAuto(pagoauto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoauto);
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
		pagoauto = new  PagoAuto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoauto=pagoautoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPagoAuto(pagoauto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoauto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pagoautos = new  ArrayList<PagoAuto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoautos=pagoautoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPagoAuto(pagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
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
		pagoautos = new  ArrayList<PagoAuto>();
		  		  
        try {
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoautos=pagoautoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPagoAuto(pagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPagoAutosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		pagoautos = new  ArrayList<PagoAuto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getTodosPagoAutosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPagoAuto(pagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
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
	
	public  void  getTodosPagoAutos(String sFinalQuery,Pagination pagination)throws Exception {
		pagoautos = new  ArrayList<PagoAuto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPagoAuto(pagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPagoAuto(PagoAuto pagoauto) throws Exception {
		Boolean estaValidado=false;
		
		if(pagoauto.getIsNew() || pagoauto.getIsChanged()) { 
			this.invalidValues = pagoautoValidator.getInvalidValues(pagoauto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(pagoauto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPagoAuto(List<PagoAuto> PagoAutos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PagoAuto pagoautoLocal:pagoautos) {				
			estaValidadoObjeto=this.validarGuardarPagoAuto(pagoautoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPagoAuto(List<PagoAuto> PagoAutos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPagoAuto(pagoautos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPagoAuto(PagoAuto PagoAuto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPagoAuto(pagoauto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PagoAuto pagoauto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+pagoauto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PagoAutoConstantesFunciones.getPagoAutoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"pagoauto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PagoAutoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PagoAutoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePagoAutoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-savePagoAutoWithConnection");connexion.begin();			
			
			PagoAutoLogicAdditional.checkPagoAutoToSave(this.pagoauto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PagoAutoLogicAdditional.updatePagoAutoToSave(this.pagoauto,this.arrDatoGeneral);
			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pagoauto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPagoAuto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPagoAuto(this.pagoauto)) {
				PagoAutoDataAccess.save(this.pagoauto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.pagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PagoAutoLogicAdditional.checkPagoAutoToSaveAfter(this.pagoauto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPagoAuto();
			
			connexion.commit();			
			
			if(this.pagoauto.getIsDeleted()) {
				this.pagoauto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePagoAuto()throws Exception {	
		try {	
			
			PagoAutoLogicAdditional.checkPagoAutoToSave(this.pagoauto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PagoAutoLogicAdditional.updatePagoAutoToSave(this.pagoauto,this.arrDatoGeneral);
			
			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pagoauto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPagoAuto(this.pagoauto)) {			
				PagoAutoDataAccess.save(this.pagoauto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.pagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PagoAutoLogicAdditional.checkPagoAutoToSaveAfter(this.pagoauto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.pagoauto.getIsDeleted()) {
				this.pagoauto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePagoAutosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-savePagoAutosWithConnection");connexion.begin();			
			
			PagoAutoLogicAdditional.checkPagoAutoToSaves(pagoautos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPagoAutos();
			
			Boolean validadoTodosPagoAuto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PagoAuto pagoautoLocal:pagoautos) {		
				if(pagoautoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PagoAutoLogicAdditional.updatePagoAutoToSave(pagoautoLocal,this.arrDatoGeneral);
	        	
				PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pagoautoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPagoAuto(pagoautoLocal)) {
					PagoAutoDataAccess.save(pagoautoLocal, connexion);				
				} else {
					validadoTodosPagoAuto=false;
				}
			}
			
			if(!validadoTodosPagoAuto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PagoAutoLogicAdditional.checkPagoAutoToSavesAfter(pagoautos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPagoAutos();
			
			connexion.commit();		
			
			this.quitarPagoAutosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePagoAutos()throws Exception {				
		 try {	
			PagoAutoLogicAdditional.checkPagoAutoToSaves(pagoautos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPagoAuto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PagoAuto pagoautoLocal:pagoautos) {				
				if(pagoautoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PagoAutoLogicAdditional.updatePagoAutoToSave(pagoautoLocal,this.arrDatoGeneral);
	        	
				PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pagoautoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPagoAuto(pagoautoLocal)) {				
					PagoAutoDataAccess.save(pagoautoLocal, connexion);				
				} else {
					validadoTodosPagoAuto=false;
				}
			}
			
			if(!validadoTodosPagoAuto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PagoAutoLogicAdditional.checkPagoAutoToSavesAfter(pagoautos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPagoAutosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PagoAutoParameterReturnGeneral procesarAccionPagoAutos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PagoAuto> pagoautos,PagoAutoParameterReturnGeneral pagoautoParameterGeneral)throws Exception {
		 try {	
			PagoAutoParameterReturnGeneral pagoautoReturnGeneral=new PagoAutoParameterReturnGeneral();
	
			PagoAutoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pagoautos,pagoautoParameterGeneral,pagoautoReturnGeneral);
			
			return pagoautoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PagoAutoParameterReturnGeneral procesarAccionPagoAutosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PagoAuto> pagoautos,PagoAutoParameterReturnGeneral pagoautoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-procesarAccionPagoAutosWithConnection");connexion.begin();			
			
			PagoAutoParameterReturnGeneral pagoautoReturnGeneral=new PagoAutoParameterReturnGeneral();
	
			PagoAutoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pagoautos,pagoautoParameterGeneral,pagoautoReturnGeneral);
			
			this.connexion.commit();
			
			return pagoautoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PagoAutoParameterReturnGeneral procesarEventosPagoAutos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PagoAuto> pagoautos,PagoAuto pagoauto,PagoAutoParameterReturnGeneral pagoautoParameterGeneral,Boolean isEsNuevoPagoAuto,ArrayList<Classe> clases)throws Exception {
		 try {	
			PagoAutoParameterReturnGeneral pagoautoReturnGeneral=new PagoAutoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pagoautoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PagoAutoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pagoautos,pagoauto,pagoautoParameterGeneral,pagoautoReturnGeneral,isEsNuevoPagoAuto,clases);
			
			return pagoautoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PagoAutoParameterReturnGeneral procesarEventosPagoAutosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PagoAuto> pagoautos,PagoAuto pagoauto,PagoAutoParameterReturnGeneral pagoautoParameterGeneral,Boolean isEsNuevoPagoAuto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-procesarEventosPagoAutosWithConnection");connexion.begin();			
			
			PagoAutoParameterReturnGeneral pagoautoReturnGeneral=new PagoAutoParameterReturnGeneral();
	
			pagoautoReturnGeneral.setPagoAuto(pagoauto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pagoautoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PagoAutoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pagoautos,pagoauto,pagoautoParameterGeneral,pagoautoReturnGeneral,isEsNuevoPagoAuto,clases);
			
			this.connexion.commit();
			
			return pagoautoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PagoAutoParameterReturnGeneral procesarImportacionPagoAutosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PagoAutoParameterReturnGeneral pagoautoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-procesarImportacionPagoAutosWithConnection");connexion.begin();			
			
			PagoAutoParameterReturnGeneral pagoautoReturnGeneral=new PagoAutoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.pagoautos=new ArrayList<PagoAuto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.pagoauto=new PagoAuto();
				
				
				if(conColumnasBase) {this.pagoauto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.pagoauto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.pagoauto.setnumero_factura(arrColumnas[iColumn++]);
				this.pagoauto.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pagoauto.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pagoauto.setfecha_corte(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pagoauto.setvalor_por_pagar(Double.parseDouble(arrColumnas[iColumn++]));
				this.pagoauto.setvalor_cancelado(Double.parseDouble(arrColumnas[iColumn++]));
				this.pagoauto.setesta_autorizado(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.pagoauto.setdescripcion(arrColumnas[iColumn++]);
				
				this.pagoautos.add(this.pagoauto);
			}
			
			this.savePagoAutos();
			
			this.connexion.commit();
			
			pagoautoReturnGeneral.setConRetornoEstaProcesado(true);
			pagoautoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return pagoautoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPagoAutosEliminados() throws Exception {				
		
		List<PagoAuto> pagoautosAux= new ArrayList<PagoAuto>();
		
		for(PagoAuto pagoauto:pagoautos) {
			if(!pagoauto.getIsDeleted()) {
				pagoautosAux.add(pagoauto);
			}
		}
		
		pagoautos=pagoautosAux;
	}
	
	public void quitarPagoAutosNulos() throws Exception {				
		
		List<PagoAuto> pagoautosAux= new ArrayList<PagoAuto>();
		
		for(PagoAuto pagoauto : this.pagoautos) {
			if(pagoauto==null) {
				pagoautosAux.add(pagoauto);
			}
		}
		
		//this.pagoautos=pagoautosAux;
		
		this.pagoautos.removeAll(pagoautosAux);
	}
	
	public void getSetVersionRowPagoAutoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(pagoauto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((pagoauto.getIsDeleted() || (pagoauto.getIsChanged()&&!pagoauto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=pagoautoDataAccess.getSetVersionRowPagoAuto(connexion,pagoauto.getId());
				
				if(!pagoauto.getVersionRow().equals(timestamp)) {	
					pagoauto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				pagoauto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPagoAuto()throws Exception {	
		
		if(pagoauto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((pagoauto.getIsDeleted() || (pagoauto.getIsChanged()&&!pagoauto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=pagoautoDataAccess.getSetVersionRowPagoAuto(connexion,pagoauto.getId());
			
			try {							
				if(!pagoauto.getVersionRow().equals(timestamp)) {	
					pagoauto.setVersionRow(timestamp);
				}
				
				pagoauto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPagoAutosWithConnection()throws Exception {	
		if(pagoautos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PagoAuto pagoautoAux:pagoautos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(pagoautoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pagoautoAux.getIsDeleted() || (pagoautoAux.getIsChanged()&&!pagoautoAux.getIsNew())) {
						
						timestamp=pagoautoDataAccess.getSetVersionRowPagoAuto(connexion,pagoautoAux.getId());
						
						if(!pagoauto.getVersionRow().equals(timestamp)) {	
							pagoautoAux.setVersionRow(timestamp);
						}
								
						pagoautoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPagoAutos()throws Exception {	
		if(pagoautos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PagoAuto pagoautoAux:pagoautos) {
					if(pagoautoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pagoautoAux.getIsDeleted() || (pagoautoAux.getIsChanged()&&!pagoautoAux.getIsNew())) {
						
						timestamp=pagoautoDataAccess.getSetVersionRowPagoAuto(connexion,pagoautoAux.getId());
						
						if(!pagoautoAux.getVersionRow().equals(timestamp)) {	
							pagoautoAux.setVersionRow(timestamp);
						}
						
													
						pagoautoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PagoAutoParameterReturnGeneral cargarCombosLoteForeignKeyPagoAutoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalCliente,String finalQueryGlobalAsientoContable,String finalQueryGlobalCentroCosto,String finalQueryGlobalCentroActividad,String finalQueryGlobalFactura,String finalQueryGlobalDetalleProve,String finalQueryGlobalCuentaBanco,String finalQueryGlobalTransaccion,String finalQueryGlobalEstadoPagoAuto) throws Exception {
		PagoAutoParameterReturnGeneral  pagoautoReturnGeneral =new PagoAutoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-cargarCombosLoteForeignKeyPagoAutoWithConnection");connexion.begin();
			
			pagoautoReturnGeneral =new PagoAutoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pagoautoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pagoautoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pagoautoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pagoautoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			pagoautoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			pagoautoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CentroActividad> centroactividadsForeignKey=new ArrayList<CentroActividad>();
			CentroActividadLogic centroactividadLogic=new CentroActividadLogic();
			centroactividadLogic.setConnexion(this.connexion);
			centroactividadLogic.getCentroActividadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroActividad.equals("NONE")) {
				centroactividadLogic.getTodosCentroActividads(finalQueryGlobalCentroActividad,new Pagination());
				centroactividadsForeignKey=centroactividadLogic.getCentroActividads();
			}

			pagoautoReturnGeneral.setcentroactividadsForeignKey(centroactividadsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			pagoautoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<DetalleProve> detalleprovesForeignKey=new ArrayList<DetalleProve>();
			DetalleProveLogic detalleproveLogic=new DetalleProveLogic();
			detalleproveLogic.setConnexion(this.connexion);
			detalleproveLogic.getDetalleProveDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleProve.equals("NONE")) {
				detalleproveLogic.getTodosDetalleProves(finalQueryGlobalDetalleProve,new Pagination());
				detalleprovesForeignKey=detalleproveLogic.getDetalleProves();
			}

			pagoautoReturnGeneral.setdetalleprovesForeignKey(detalleprovesForeignKey);


			List<CuentaBanco> cuentabancosForeignKey=new ArrayList<CuentaBanco>();
			CuentaBancoLogic cuentabancoLogic=new CuentaBancoLogic();
			cuentabancoLogic.setConnexion(this.connexion);
			cuentabancoLogic.getCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaBanco.equals("NONE")) {
				cuentabancoLogic.getTodosCuentaBancos(finalQueryGlobalCuentaBanco,new Pagination());
				cuentabancosForeignKey=cuentabancoLogic.getCuentaBancos();
			}

			pagoautoReturnGeneral.setcuentabancosForeignKey(cuentabancosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			pagoautoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<EstadoPagoAuto> estadopagoautosForeignKey=new ArrayList<EstadoPagoAuto>();
			EstadoPagoAutoLogic estadopagoautoLogic=new EstadoPagoAutoLogic();
			estadopagoautoLogic.setConnexion(this.connexion);
			estadopagoautoLogic.getEstadoPagoAutoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPagoAuto.equals("NONE")) {
				estadopagoautoLogic.getTodosEstadoPagoAutos(finalQueryGlobalEstadoPagoAuto,new Pagination());
				estadopagoautosForeignKey=estadopagoautoLogic.getEstadoPagoAutos();
			}

			pagoautoReturnGeneral.setestadopagoautosForeignKey(estadopagoautosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return pagoautoReturnGeneral;
	}
	
	public PagoAutoParameterReturnGeneral cargarCombosLoteForeignKeyPagoAuto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalCliente,String finalQueryGlobalAsientoContable,String finalQueryGlobalCentroCosto,String finalQueryGlobalCentroActividad,String finalQueryGlobalFactura,String finalQueryGlobalDetalleProve,String finalQueryGlobalCuentaBanco,String finalQueryGlobalTransaccion,String finalQueryGlobalEstadoPagoAuto) throws Exception {
		PagoAutoParameterReturnGeneral  pagoautoReturnGeneral =new PagoAutoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			pagoautoReturnGeneral =new PagoAutoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pagoautoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pagoautoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pagoautoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pagoautoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			pagoautoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			pagoautoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CentroActividad> centroactividadsForeignKey=new ArrayList<CentroActividad>();
			CentroActividadLogic centroactividadLogic=new CentroActividadLogic();
			centroactividadLogic.setConnexion(this.connexion);
			centroactividadLogic.getCentroActividadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroActividad.equals("NONE")) {
				centroactividadLogic.getTodosCentroActividads(finalQueryGlobalCentroActividad,new Pagination());
				centroactividadsForeignKey=centroactividadLogic.getCentroActividads();
			}

			pagoautoReturnGeneral.setcentroactividadsForeignKey(centroactividadsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			pagoautoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<DetalleProve> detalleprovesForeignKey=new ArrayList<DetalleProve>();
			DetalleProveLogic detalleproveLogic=new DetalleProveLogic();
			detalleproveLogic.setConnexion(this.connexion);
			detalleproveLogic.getDetalleProveDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleProve.equals("NONE")) {
				detalleproveLogic.getTodosDetalleProves(finalQueryGlobalDetalleProve,new Pagination());
				detalleprovesForeignKey=detalleproveLogic.getDetalleProves();
			}

			pagoautoReturnGeneral.setdetalleprovesForeignKey(detalleprovesForeignKey);


			List<CuentaBanco> cuentabancosForeignKey=new ArrayList<CuentaBanco>();
			CuentaBancoLogic cuentabancoLogic=new CuentaBancoLogic();
			cuentabancoLogic.setConnexion(this.connexion);
			cuentabancoLogic.getCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaBanco.equals("NONE")) {
				cuentabancoLogic.getTodosCuentaBancos(finalQueryGlobalCuentaBanco,new Pagination());
				cuentabancosForeignKey=cuentabancoLogic.getCuentaBancos();
			}

			pagoautoReturnGeneral.setcuentabancosForeignKey(cuentabancosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			pagoautoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<EstadoPagoAuto> estadopagoautosForeignKey=new ArrayList<EstadoPagoAuto>();
			EstadoPagoAutoLogic estadopagoautoLogic=new EstadoPagoAutoLogic();
			estadopagoautoLogic.setConnexion(this.connexion);
			estadopagoautoLogic.getEstadoPagoAutoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPagoAuto.equals("NONE")) {
				estadopagoautoLogic.getTodosEstadoPagoAutos(finalQueryGlobalEstadoPagoAuto,new Pagination());
				estadopagoautosForeignKey=estadopagoautoLogic.getEstadoPagoAutos();
			}

			pagoautoReturnGeneral.setestadopagoautosForeignKey(estadopagoautosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return pagoautoReturnGeneral;
	}
	
	
	public void deepLoad(PagoAuto pagoauto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PagoAutoLogicAdditional.updatePagoAutoToGet(pagoauto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pagoauto.setEmpresa(pagoautoDataAccess.getEmpresa(connexion,pagoauto));
		pagoauto.setSucursal(pagoautoDataAccess.getSucursal(connexion,pagoauto));
		pagoauto.setEjercicio(pagoautoDataAccess.getEjercicio(connexion,pagoauto));
		pagoauto.setCliente(pagoautoDataAccess.getCliente(connexion,pagoauto));
		pagoauto.setAsientoContable(pagoautoDataAccess.getAsientoContable(connexion,pagoauto));
		pagoauto.setCentroCosto(pagoautoDataAccess.getCentroCosto(connexion,pagoauto));
		pagoauto.setCentroActividad(pagoautoDataAccess.getCentroActividad(connexion,pagoauto));
		pagoauto.setFactura(pagoautoDataAccess.getFactura(connexion,pagoauto));
		pagoauto.setDetalleProve(pagoautoDataAccess.getDetalleProve(connexion,pagoauto));
		pagoauto.setCuentaBanco(pagoautoDataAccess.getCuentaBanco(connexion,pagoauto));
		pagoauto.setTransaccion(pagoautoDataAccess.getTransaccion(connexion,pagoauto));
		pagoauto.setEstadoPagoAuto(pagoautoDataAccess.getEstadoPagoAuto(connexion,pagoauto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pagoauto.setEmpresa(pagoautoDataAccess.getEmpresa(connexion,pagoauto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pagoauto.setSucursal(pagoautoDataAccess.getSucursal(connexion,pagoauto));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pagoauto.setEjercicio(pagoautoDataAccess.getEjercicio(connexion,pagoauto));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pagoauto.setCliente(pagoautoDataAccess.getCliente(connexion,pagoauto));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				pagoauto.setAsientoContable(pagoautoDataAccess.getAsientoContable(connexion,pagoauto));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				pagoauto.setCentroCosto(pagoautoDataAccess.getCentroCosto(connexion,pagoauto));
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				pagoauto.setCentroActividad(pagoautoDataAccess.getCentroActividad(connexion,pagoauto));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				pagoauto.setFactura(pagoautoDataAccess.getFactura(connexion,pagoauto));
				continue;
			}

			if(clas.clas.equals(DetalleProve.class)) {
				pagoauto.setDetalleProve(pagoautoDataAccess.getDetalleProve(connexion,pagoauto));
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				pagoauto.setCuentaBanco(pagoautoDataAccess.getCuentaBanco(connexion,pagoauto));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				pagoauto.setTransaccion(pagoautoDataAccess.getTransaccion(connexion,pagoauto));
				continue;
			}

			if(clas.clas.equals(EstadoPagoAuto.class)) {
				pagoauto.setEstadoPagoAuto(pagoautoDataAccess.getEstadoPagoAuto(connexion,pagoauto));
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
			pagoauto.setEmpresa(pagoautoDataAccess.getEmpresa(connexion,pagoauto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setSucursal(pagoautoDataAccess.getSucursal(connexion,pagoauto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setEjercicio(pagoautoDataAccess.getEjercicio(connexion,pagoauto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setCliente(pagoautoDataAccess.getCliente(connexion,pagoauto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setAsientoContable(pagoautoDataAccess.getAsientoContable(connexion,pagoauto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setCentroCosto(pagoautoDataAccess.getCentroCosto(connexion,pagoauto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setCentroActividad(pagoautoDataAccess.getCentroActividad(connexion,pagoauto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setFactura(pagoautoDataAccess.getFactura(connexion,pagoauto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProve.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setDetalleProve(pagoautoDataAccess.getDetalleProve(connexion,pagoauto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setCuentaBanco(pagoautoDataAccess.getCuentaBanco(connexion,pagoauto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setTransaccion(pagoautoDataAccess.getTransaccion(connexion,pagoauto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPagoAuto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setEstadoPagoAuto(pagoautoDataAccess.getEstadoPagoAuto(connexion,pagoauto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pagoauto.setEmpresa(pagoautoDataAccess.getEmpresa(connexion,pagoauto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pagoauto.getEmpresa(),isDeep,deepLoadType,clases);
				
		pagoauto.setSucursal(pagoautoDataAccess.getSucursal(connexion,pagoauto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pagoauto.getSucursal(),isDeep,deepLoadType,clases);
				
		pagoauto.setEjercicio(pagoautoDataAccess.getEjercicio(connexion,pagoauto));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pagoauto.getEjercicio(),isDeep,deepLoadType,clases);
				
		pagoauto.setCliente(pagoautoDataAccess.getCliente(connexion,pagoauto));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pagoauto.getCliente(),isDeep,deepLoadType,clases);
				
		pagoauto.setAsientoContable(pagoautoDataAccess.getAsientoContable(connexion,pagoauto));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(pagoauto.getAsientoContable(),isDeep,deepLoadType,clases);
				
		pagoauto.setCentroCosto(pagoautoDataAccess.getCentroCosto(connexion,pagoauto));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(pagoauto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		pagoauto.setCentroActividad(pagoautoDataAccess.getCentroActividad(connexion,pagoauto));
		CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
		centroactividadLogic.deepLoad(pagoauto.getCentroActividad(),isDeep,deepLoadType,clases);
				
		pagoauto.setFactura(pagoautoDataAccess.getFactura(connexion,pagoauto));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(pagoauto.getFactura(),isDeep,deepLoadType,clases);
				
		pagoauto.setDetalleProve(pagoautoDataAccess.getDetalleProve(connexion,pagoauto));
		DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
		detalleproveLogic.deepLoad(pagoauto.getDetalleProve(),isDeep,deepLoadType,clases);
				
		pagoauto.setCuentaBanco(pagoautoDataAccess.getCuentaBanco(connexion,pagoauto));
		CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
		cuentabancoLogic.deepLoad(pagoauto.getCuentaBanco(),isDeep,deepLoadType,clases);
				
		pagoauto.setTransaccion(pagoautoDataAccess.getTransaccion(connexion,pagoauto));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(pagoauto.getTransaccion(),isDeep,deepLoadType,clases);
				
		pagoauto.setEstadoPagoAuto(pagoautoDataAccess.getEstadoPagoAuto(connexion,pagoauto));
		EstadoPagoAutoLogic estadopagoautoLogic= new EstadoPagoAutoLogic(connexion);
		estadopagoautoLogic.deepLoad(pagoauto.getEstadoPagoAuto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pagoauto.setEmpresa(pagoautoDataAccess.getEmpresa(connexion,pagoauto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pagoauto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pagoauto.setSucursal(pagoautoDataAccess.getSucursal(connexion,pagoauto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(pagoauto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pagoauto.setEjercicio(pagoautoDataAccess.getEjercicio(connexion,pagoauto));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(pagoauto.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pagoauto.setCliente(pagoautoDataAccess.getCliente(connexion,pagoauto));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(pagoauto.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				pagoauto.setAsientoContable(pagoautoDataAccess.getAsientoContable(connexion,pagoauto));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(pagoauto.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				pagoauto.setCentroCosto(pagoautoDataAccess.getCentroCosto(connexion,pagoauto));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(pagoauto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				pagoauto.setCentroActividad(pagoautoDataAccess.getCentroActividad(connexion,pagoauto));
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepLoad(pagoauto.getCentroActividad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				pagoauto.setFactura(pagoautoDataAccess.getFactura(connexion,pagoauto));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(pagoauto.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleProve.class)) {
				pagoauto.setDetalleProve(pagoautoDataAccess.getDetalleProve(connexion,pagoauto));
				DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
				detalleproveLogic.deepLoad(pagoauto.getDetalleProve(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				pagoauto.setCuentaBanco(pagoautoDataAccess.getCuentaBanco(connexion,pagoauto));
				CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
				cuentabancoLogic.deepLoad(pagoauto.getCuentaBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				pagoauto.setTransaccion(pagoautoDataAccess.getTransaccion(connexion,pagoauto));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(pagoauto.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPagoAuto.class)) {
				pagoauto.setEstadoPagoAuto(pagoautoDataAccess.getEstadoPagoAuto(connexion,pagoauto));
				EstadoPagoAutoLogic estadopagoautoLogic= new EstadoPagoAutoLogic(connexion);
				estadopagoautoLogic.deepLoad(pagoauto.getEstadoPagoAuto(),isDeep,deepLoadType,clases);				
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
			pagoauto.setEmpresa(pagoautoDataAccess.getEmpresa(connexion,pagoauto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pagoauto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setSucursal(pagoautoDataAccess.getSucursal(connexion,pagoauto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(pagoauto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setEjercicio(pagoautoDataAccess.getEjercicio(connexion,pagoauto));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(pagoauto.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setCliente(pagoautoDataAccess.getCliente(connexion,pagoauto));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(pagoauto.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setAsientoContable(pagoautoDataAccess.getAsientoContable(connexion,pagoauto));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(pagoauto.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setCentroCosto(pagoautoDataAccess.getCentroCosto(connexion,pagoauto));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(pagoauto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setCentroActividad(pagoautoDataAccess.getCentroActividad(connexion,pagoauto));
			CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
			centroactividadLogic.deepLoad(pagoauto.getCentroActividad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setFactura(pagoautoDataAccess.getFactura(connexion,pagoauto));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(pagoauto.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProve.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setDetalleProve(pagoautoDataAccess.getDetalleProve(connexion,pagoauto));
			DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
			detalleproveLogic.deepLoad(pagoauto.getDetalleProve(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setCuentaBanco(pagoautoDataAccess.getCuentaBanco(connexion,pagoauto));
			CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
			cuentabancoLogic.deepLoad(pagoauto.getCuentaBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setTransaccion(pagoautoDataAccess.getTransaccion(connexion,pagoauto));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(pagoauto.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPagoAuto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pagoauto.setEstadoPagoAuto(pagoautoDataAccess.getEstadoPagoAuto(connexion,pagoauto));
			EstadoPagoAutoLogic estadopagoautoLogic= new EstadoPagoAutoLogic(connexion);
			estadopagoautoLogic.deepLoad(pagoauto.getEstadoPagoAuto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PagoAuto pagoauto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PagoAutoLogicAdditional.updatePagoAutoToSave(pagoauto,this.arrDatoGeneral);
			
PagoAutoDataAccess.save(pagoauto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pagoauto.getEmpresa(),connexion);

		SucursalDataAccess.save(pagoauto.getSucursal(),connexion);

		EjercicioDataAccess.save(pagoauto.getEjercicio(),connexion);

		ClienteDataAccess.save(pagoauto.getCliente(),connexion);

		AsientoContableDataAccess.save(pagoauto.getAsientoContable(),connexion);

		CentroCostoDataAccess.save(pagoauto.getCentroCosto(),connexion);

		CentroActividadDataAccess.save(pagoauto.getCentroActividad(),connexion);

		FacturaDataAccess.save(pagoauto.getFactura(),connexion);

		DetalleProveDataAccess.save(pagoauto.getDetalleProve(),connexion);

		CuentaBancoDataAccess.save(pagoauto.getCuentaBanco(),connexion);

		TransaccionDataAccess.save(pagoauto.getTransaccion(),connexion);

		EstadoPagoAutoDataAccess.save(pagoauto.getEstadoPagoAuto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pagoauto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pagoauto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pagoauto.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pagoauto.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(pagoauto.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(pagoauto.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				CentroActividadDataAccess.save(pagoauto.getCentroActividad(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(pagoauto.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleProve.class)) {
				DetalleProveDataAccess.save(pagoauto.getDetalleProve(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				CuentaBancoDataAccess.save(pagoauto.getCuentaBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(pagoauto.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPagoAuto.class)) {
				EstadoPagoAutoDataAccess.save(pagoauto.getEstadoPagoAuto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pagoauto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pagoauto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(pagoauto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pagoauto.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(pagoauto.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pagoauto.getEjercicio(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(pagoauto.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pagoauto.getCliente(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(pagoauto.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(pagoauto.getAsientoContable(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(pagoauto.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(pagoauto.getCentroCosto(),isDeep,deepLoadType,clases);
				

		CentroActividadDataAccess.save(pagoauto.getCentroActividad(),connexion);
		CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
		centroactividadLogic.deepLoad(pagoauto.getCentroActividad(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(pagoauto.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(pagoauto.getFactura(),isDeep,deepLoadType,clases);
				

		DetalleProveDataAccess.save(pagoauto.getDetalleProve(),connexion);
		DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
		detalleproveLogic.deepLoad(pagoauto.getDetalleProve(),isDeep,deepLoadType,clases);
				

		CuentaBancoDataAccess.save(pagoauto.getCuentaBanco(),connexion);
		CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
		cuentabancoLogic.deepLoad(pagoauto.getCuentaBanco(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(pagoauto.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(pagoauto.getTransaccion(),isDeep,deepLoadType,clases);
				

		EstadoPagoAutoDataAccess.save(pagoauto.getEstadoPagoAuto(),connexion);
		EstadoPagoAutoLogic estadopagoautoLogic= new EstadoPagoAutoLogic(connexion);
		estadopagoautoLogic.deepLoad(pagoauto.getEstadoPagoAuto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pagoauto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(pagoauto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pagoauto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(pagoauto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pagoauto.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(pagoauto.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pagoauto.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(pagoauto.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(pagoauto.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(pagoauto.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(pagoauto.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(pagoauto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				CentroActividadDataAccess.save(pagoauto.getCentroActividad(),connexion);
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepSave(pagoauto.getCentroActividad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(pagoauto.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(pagoauto.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleProve.class)) {
				DetalleProveDataAccess.save(pagoauto.getDetalleProve(),connexion);
				DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
				detalleproveLogic.deepSave(pagoauto.getDetalleProve(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				CuentaBancoDataAccess.save(pagoauto.getCuentaBanco(),connexion);
				CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
				cuentabancoLogic.deepSave(pagoauto.getCuentaBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(pagoauto.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(pagoauto.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPagoAuto.class)) {
				EstadoPagoAutoDataAccess.save(pagoauto.getEstadoPagoAuto(),connexion);
				EstadoPagoAutoLogic estadopagoautoLogic= new EstadoPagoAutoLogic(connexion);
				estadopagoautoLogic.deepSave(pagoauto.getEstadoPagoAuto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PagoAuto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(pagoauto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(pagoauto);
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
			this.deepLoad(this.pagoauto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoauto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PagoAuto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(pagoautos!=null) {
				for(PagoAuto pagoauto:pagoautos) {
					this.deepLoad(pagoauto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(pagoautos);
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
			if(pagoautos!=null) {
				for(PagoAuto pagoauto:pagoautos) {
					this.deepLoad(pagoauto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(pagoautos);
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
			this.getNewConnexionToDeep(PagoAuto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(pagoauto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PagoAuto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(pagoautos!=null) {
				for(PagoAuto pagoauto:pagoautos) {
					this.deepSave(pagoauto,isDeep,deepLoadType,clases);
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
			if(pagoautos!=null) {
				for(PagoAuto pagoauto:pagoautos) {
					this.deepSave(pagoauto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPagoAutosFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,PagoAutoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,PagoAutoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPagoAutosFK_IdCentroActividadWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_actividad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroActividad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroActividad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_actividad,PagoAutoConstantesFunciones.IDCENTROACTIVIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroActividad);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroActividad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdCentroActividad(String sFinalQuery,Pagination pagination,Long id_centro_actividad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroActividad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroActividad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_actividad,PagoAutoConstantesFunciones.IDCENTROACTIVIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroActividad);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroActividad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPagoAutosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PagoAutoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PagoAutoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPagoAutosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PagoAutoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PagoAutoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPagoAutosFK_IdCuentaBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_banco,PagoAutoConstantesFunciones.IDCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaBanco);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdCuentaBanco(String sFinalQuery,Pagination pagination,Long id_cuenta_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_banco,PagoAutoConstantesFunciones.IDCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaBanco);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPagoAutosFK_IdDetalleProveWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_prove)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleProve= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleProve.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_prove,PagoAutoConstantesFunciones.IDDETALLEPROVE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleProve);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleProve","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdDetalleProve(String sFinalQuery,Pagination pagination,Long id_detalle_prove)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleProve= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleProve.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_prove,PagoAutoConstantesFunciones.IDDETALLEPROVE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleProve);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleProve","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPagoAutosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PagoAutoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PagoAutoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPagoAutosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PagoAutoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PagoAutoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPagoAutosFK_IdEstadoPagoAutoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pago_auto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPagoAuto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPagoAuto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pago_auto,PagoAutoConstantesFunciones.IDESTADOPAGOAUTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPagoAuto);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPagoAuto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdEstadoPagoAuto(String sFinalQuery,Pagination pagination,Long id_estado_pago_auto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPagoAuto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPagoAuto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pago_auto,PagoAutoConstantesFunciones.IDESTADOPAGOAUTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPagoAuto);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPagoAuto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPagoAutosFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,PagoAutoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,PagoAutoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPagoAutosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PagoAutoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PagoAutoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPagoAutosFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PagoAuto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,PagoAutoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPagoAutosFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,PagoAutoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			PagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(this.pagoautos);
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
			if(PagoAutoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PagoAutoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PagoAuto pagoauto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PagoAutoConstantesFunciones.ISCONAUDITORIA) {
				if(pagoauto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PagoAutoDataAccess.TABLENAME, pagoauto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PagoAutoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PagoAutoLogic.registrarAuditoriaDetallesPagoAuto(connexion,pagoauto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(pagoauto.getIsDeleted()) {
					/*if(!pagoauto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PagoAutoDataAccess.TABLENAME, pagoauto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PagoAutoLogic.registrarAuditoriaDetallesPagoAuto(connexion,pagoauto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PagoAutoDataAccess.TABLENAME, pagoauto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(pagoauto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PagoAutoDataAccess.TABLENAME, pagoauto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PagoAutoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PagoAutoLogic.registrarAuditoriaDetallesPagoAuto(connexion,pagoauto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPagoAuto(Connexion connexion,PagoAuto pagoauto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(pagoauto.getIsNew()||!pagoauto.getid_empresa().equals(pagoauto.getPagoAutoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_empresa()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_empresa().toString();
				}
				if(pagoauto.getid_empresa()!=null)
				{
					strValorNuevo=pagoauto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getid_sucursal().equals(pagoauto.getPagoAutoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_sucursal()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_sucursal().toString();
				}
				if(pagoauto.getid_sucursal()!=null)
				{
					strValorNuevo=pagoauto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getid_ejercicio().equals(pagoauto.getPagoAutoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_ejercicio().toString();
				}
				if(pagoauto.getid_ejercicio()!=null)
				{
					strValorNuevo=pagoauto.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getid_cliente().equals(pagoauto.getPagoAutoOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_cliente()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_cliente().toString();
				}
				if(pagoauto.getid_cliente()!=null)
				{
					strValorNuevo=pagoauto.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getid_asiento_contable().equals(pagoauto.getPagoAutoOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_asiento_contable().toString();
				}
				if(pagoauto.getid_asiento_contable()!=null)
				{
					strValorNuevo=pagoauto.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getid_centro_costo().equals(pagoauto.getPagoAutoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_centro_costo().toString();
				}
				if(pagoauto.getid_centro_costo()!=null)
				{
					strValorNuevo=pagoauto.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getid_centro_actividad().equals(pagoauto.getPagoAutoOriginal().getid_centro_actividad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_centro_actividad()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_centro_actividad().toString();
				}
				if(pagoauto.getid_centro_actividad()!=null)
				{
					strValorNuevo=pagoauto.getid_centro_actividad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDCENTROACTIVIDAD,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getid_factura().equals(pagoauto.getPagoAutoOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_factura()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_factura().toString();
				}
				if(pagoauto.getid_factura()!=null)
				{
					strValorNuevo=pagoauto.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getid_detalle_prove().equals(pagoauto.getPagoAutoOriginal().getid_detalle_prove()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_detalle_prove()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_detalle_prove().toString();
				}
				if(pagoauto.getid_detalle_prove()!=null)
				{
					strValorNuevo=pagoauto.getid_detalle_prove().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDDETALLEPROVE,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getid_cuenta_banco().equals(pagoauto.getPagoAutoOriginal().getid_cuenta_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_cuenta_banco()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_cuenta_banco().toString();
				}
				if(pagoauto.getid_cuenta_banco()!=null)
				{
					strValorNuevo=pagoauto.getid_cuenta_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDCUENTABANCO,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getid_transaccion().equals(pagoauto.getPagoAutoOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_transaccion()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_transaccion().toString();
				}
				if(pagoauto.getid_transaccion()!=null)
				{
					strValorNuevo=pagoauto.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getid_estado_pago_auto().equals(pagoauto.getPagoAutoOriginal().getid_estado_pago_auto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getid_estado_pago_auto()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getid_estado_pago_auto().toString();
				}
				if(pagoauto.getid_estado_pago_auto()!=null)
				{
					strValorNuevo=pagoauto.getid_estado_pago_auto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.IDESTADOPAGOAUTO,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getnumero_factura().equals(pagoauto.getPagoAutoOriginal().getnumero_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getnumero_factura()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getnumero_factura();
				}
				if(pagoauto.getnumero_factura()!=null)
				{
					strValorNuevo=pagoauto.getnumero_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.NUMEROFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getfecha_emision().equals(pagoauto.getPagoAutoOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getfecha_emision()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getfecha_emision().toString();
				}
				if(pagoauto.getfecha_emision()!=null)
				{
					strValorNuevo=pagoauto.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getfecha_vencimiento().equals(pagoauto.getPagoAutoOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getfecha_vencimiento().toString();
				}
				if(pagoauto.getfecha_vencimiento()!=null)
				{
					strValorNuevo=pagoauto.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getfecha_corte().equals(pagoauto.getPagoAutoOriginal().getfecha_corte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getfecha_corte()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getfecha_corte().toString();
				}
				if(pagoauto.getfecha_corte()!=null)
				{
					strValorNuevo=pagoauto.getfecha_corte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.FECHACORTE,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getvalor_por_pagar().equals(pagoauto.getPagoAutoOriginal().getvalor_por_pagar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getvalor_por_pagar()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getvalor_por_pagar().toString();
				}
				if(pagoauto.getvalor_por_pagar()!=null)
				{
					strValorNuevo=pagoauto.getvalor_por_pagar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.VALORPORPAGAR,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getvalor_cancelado().equals(pagoauto.getPagoAutoOriginal().getvalor_cancelado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getvalor_cancelado()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getvalor_cancelado().toString();
				}
				if(pagoauto.getvalor_cancelado()!=null)
				{
					strValorNuevo=pagoauto.getvalor_cancelado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.VALORCANCELADO,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getesta_autorizado().equals(pagoauto.getPagoAutoOriginal().getesta_autorizado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getesta_autorizado()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getesta_autorizado().toString();
				}
				if(pagoauto.getesta_autorizado()!=null)
				{
					strValorNuevo=pagoauto.getesta_autorizado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.ESTAAUTORIZADO,strValorActual,strValorNuevo);
			}	
			
			if(pagoauto.getIsNew()||!pagoauto.getdescripcion().equals(pagoauto.getPagoAutoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pagoauto.getPagoAutoOriginal().getdescripcion()!=null)
				{
					strValorActual=pagoauto.getPagoAutoOriginal().getdescripcion();
				}
				if(pagoauto.getdescripcion()!=null)
				{
					strValorNuevo=pagoauto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PagoAutoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePagoAutoRelacionesWithConnection(PagoAuto pagoauto) throws Exception {

		if(!pagoauto.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePagoAutoRelacionesBase(pagoauto,true);
		}
	}

	public void savePagoAutoRelaciones(PagoAuto pagoauto)throws Exception {

		if(!pagoauto.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePagoAutoRelacionesBase(pagoauto,false);
		}
	}

	public void savePagoAutoRelacionesBase(PagoAuto pagoauto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PagoAuto-saveRelacionesWithConnection");}
	

			this.setPagoAuto(pagoauto);

			if(PagoAutoLogicAdditional.validarSaveRelaciones(pagoauto,this)) {

				PagoAutoLogicAdditional.updateRelacionesToSave(pagoauto,this);

				if((pagoauto.getIsNew()||pagoauto.getIsChanged())&&!pagoauto.getIsDeleted()) {
					this.savePagoAuto();
					this.savePagoAutoRelacionesDetalles();

				} else if(pagoauto.getIsDeleted()) {
					this.savePagoAutoRelacionesDetalles();
					this.savePagoAuto();
				}

				PagoAutoLogicAdditional.updateRelacionesToSaveAfter(pagoauto,this);

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
	
	
	private void savePagoAutoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPagoAuto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PagoAutoConstantesFunciones.getClassesForeignKeysOfPagoAuto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPagoAuto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PagoAutoConstantesFunciones.getClassesRelationshipsOfPagoAuto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
