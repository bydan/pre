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
import com.bydan.erp.tesoreria.util.AutoriPagoConstantesFunciones;
import com.bydan.erp.tesoreria.util.AutoriPagoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.AutoriPagoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.AutoriPago;
import com.bydan.erp.tesoreria.business.logic.AutoriPagoLogicAdditional;
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
public class AutoriPagoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AutoriPagoLogic.class);
	
	protected AutoriPagoDataAccess autoripagoDataAccess; 	
	protected AutoriPago autoripago;
	protected List<AutoriPago> autoripagos;
	protected Object autoripagoObject;	
	protected List<Object> autoripagosObject;
	
	public static ClassValidator<AutoriPago> autoripagoValidator = new ClassValidator<AutoriPago>(AutoriPago.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AutoriPagoLogicAdditional autoripagoLogicAdditional=null;
	
	public AutoriPagoLogicAdditional getAutoriPagoLogicAdditional() {
		return this.autoripagoLogicAdditional;
	}
	
	public void setAutoriPagoLogicAdditional(AutoriPagoLogicAdditional autoripagoLogicAdditional) {
		try {
			this.autoripagoLogicAdditional=autoripagoLogicAdditional;
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
	
	
	
	
	public  AutoriPagoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.autoripagoDataAccess = new AutoriPagoDataAccess();
			
			this.autoripagos= new ArrayList<AutoriPago>();
			this.autoripago= new AutoriPago();
			
			this.autoripagoObject=new Object();
			this.autoripagosObject=new ArrayList<Object>();
				
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
			
			this.autoripagoDataAccess.setConnexionType(this.connexionType);
			this.autoripagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AutoriPagoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.autoripagoDataAccess = new AutoriPagoDataAccess();
			this.autoripagos= new ArrayList<AutoriPago>();
			this.autoripago= new AutoriPago();
			this.autoripagoObject=new Object();
			this.autoripagosObject=new ArrayList<Object>();
			
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
			
			this.autoripagoDataAccess.setConnexionType(this.connexionType);
			this.autoripagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AutoriPago getAutoriPago() throws Exception {	
		AutoriPagoLogicAdditional.checkAutoriPagoToGet(autoripago,this.datosCliente,this.arrDatoGeneral);
		AutoriPagoLogicAdditional.updateAutoriPagoToGet(autoripago,this.arrDatoGeneral);
		
		return autoripago;
	}
		
	public void setAutoriPago(AutoriPago newAutoriPago) {
		this.autoripago = newAutoriPago;
	}
	
	public AutoriPagoDataAccess getAutoriPagoDataAccess() {
		return autoripagoDataAccess;
	}
	
	public void setAutoriPagoDataAccess(AutoriPagoDataAccess newautoripagoDataAccess) {
		this.autoripagoDataAccess = newautoripagoDataAccess;
	}
	
	public List<AutoriPago> getAutoriPagos() throws Exception {		
		this.quitarAutoriPagosNulos();
		
		AutoriPagoLogicAdditional.checkAutoriPagoToGets(autoripagos,this.datosCliente,this.arrDatoGeneral);
		
		for (AutoriPago autoripagoLocal: autoripagos ) {
			AutoriPagoLogicAdditional.updateAutoriPagoToGet(autoripagoLocal,this.arrDatoGeneral);
		}
		
		return autoripagos;
	}
	
	public void setAutoriPagos(List<AutoriPago> newAutoriPagos) {
		this.autoripagos = newAutoriPagos;
	}
	
	public Object getAutoriPagoObject() {	
		this.autoripagoObject=this.autoripagoDataAccess.getEntityObject();
		return this.autoripagoObject;
	}
		
	public void setAutoriPagoObject(Object newAutoriPagoObject) {
		this.autoripagoObject = newAutoriPagoObject;
	}
	
	public List<Object> getAutoriPagosObject() {		
		this.autoripagosObject=this.autoripagoDataAccess.getEntitiesObject();
		return this.autoripagosObject;
	}
		
	public void setAutoriPagosObject(List<Object> newAutoriPagosObject) {
		this.autoripagosObject = newAutoriPagosObject;
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
		
		if(this.autoripagoDataAccess!=null) {
			this.autoripagoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			autoripagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			autoripagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		autoripago = new  AutoriPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			autoripago=autoripagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoripago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripago);
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
		autoripago = new  AutoriPago();
		  		  
        try {
			
			autoripago=autoripagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoripago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		autoripago = new  AutoriPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			autoripago=autoripagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoripago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripago);
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
		autoripago = new  AutoriPago();
		  		  
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
		autoripago = new  AutoriPago();
		  		  
        try {
			
			autoripago=autoripagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoripago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		autoripago = new  AutoriPago();
		  		  
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
		autoripago = new  AutoriPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =autoripagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoripago = new  AutoriPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=autoripagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		autoripago = new  AutoriPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =autoripagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoripago = new  AutoriPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=autoripagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		autoripago = new  AutoriPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =autoripagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoripago = new  AutoriPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=autoripagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		autoripagos = new  ArrayList<AutoriPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagos=autoripagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriPago(autoripagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
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
		autoripagos = new  ArrayList<AutoriPago>();
		  		  
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
		autoripagos = new  ArrayList<AutoriPago>();
		  		  
        try {			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagos=autoripagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAutoriPago(autoripagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		autoripagos = new  ArrayList<AutoriPago>();
		  		  
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
		autoripagos = new  ArrayList<AutoriPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagos=autoripagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriPago(autoripagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
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
		autoripagos = new  ArrayList<AutoriPago>();
		  		  
        try {
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagos=autoripagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriPago(autoripagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
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
		autoripagos = new  ArrayList<AutoriPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagos=autoripagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriPago(autoripagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
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
		autoripagos = new  ArrayList<AutoriPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagos=autoripagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriPago(autoripagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		autoripago = new  AutoriPago();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripago=autoripagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriPago(autoripago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripago);
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
		autoripago = new  AutoriPago();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripago=autoripagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriPago(autoripago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		autoripagos = new  ArrayList<AutoriPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagos=autoripagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriPago(autoripagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
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
		autoripagos = new  ArrayList<AutoriPago>();
		  		  
        try {
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagos=autoripagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriPago(autoripagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAutoriPagosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		autoripagos = new  ArrayList<AutoriPago>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getTodosAutoriPagosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAutoriPago(autoripagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
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
	
	public  void  getTodosAutoriPagos(String sFinalQuery,Pagination pagination)throws Exception {
		autoripagos = new  ArrayList<AutoriPago>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAutoriPago(autoripagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAutoriPago(AutoriPago autoripago) throws Exception {
		Boolean estaValidado=false;
		
		if(autoripago.getIsNew() || autoripago.getIsChanged()) { 
			this.invalidValues = autoripagoValidator.getInvalidValues(autoripago);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(autoripago);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAutoriPago(List<AutoriPago> AutoriPagos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AutoriPago autoripagoLocal:autoripagos) {				
			estaValidadoObjeto=this.validarGuardarAutoriPago(autoripagoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAutoriPago(List<AutoriPago> AutoriPagos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAutoriPago(autoripagos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAutoriPago(AutoriPago AutoriPago) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAutoriPago(autoripago)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AutoriPago autoripago) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+autoripago.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AutoriPagoConstantesFunciones.getAutoriPagoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"autoripago","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AutoriPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AutoriPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAutoriPagoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-saveAutoriPagoWithConnection");connexion.begin();			
			
			AutoriPagoLogicAdditional.checkAutoriPagoToSave(this.autoripago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AutoriPagoLogicAdditional.updateAutoriPagoToSave(this.autoripago,this.arrDatoGeneral);
			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.autoripago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAutoriPago();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAutoriPago(this.autoripago)) {
				AutoriPagoDataAccess.save(this.autoripago, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.autoripago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AutoriPagoLogicAdditional.checkAutoriPagoToSaveAfter(this.autoripago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAutoriPago();
			
			connexion.commit();			
			
			if(this.autoripago.getIsDeleted()) {
				this.autoripago=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAutoriPago()throws Exception {	
		try {	
			
			AutoriPagoLogicAdditional.checkAutoriPagoToSave(this.autoripago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AutoriPagoLogicAdditional.updateAutoriPagoToSave(this.autoripago,this.arrDatoGeneral);
			
			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.autoripago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAutoriPago(this.autoripago)) {			
				AutoriPagoDataAccess.save(this.autoripago, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.autoripago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AutoriPagoLogicAdditional.checkAutoriPagoToSaveAfter(this.autoripago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.autoripago.getIsDeleted()) {
				this.autoripago=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAutoriPagosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-saveAutoriPagosWithConnection");connexion.begin();			
			
			AutoriPagoLogicAdditional.checkAutoriPagoToSaves(autoripagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAutoriPagos();
			
			Boolean validadoTodosAutoriPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AutoriPago autoripagoLocal:autoripagos) {		
				if(autoripagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AutoriPagoLogicAdditional.updateAutoriPagoToSave(autoripagoLocal,this.arrDatoGeneral);
	        	
				AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),autoripagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAutoriPago(autoripagoLocal)) {
					AutoriPagoDataAccess.save(autoripagoLocal, connexion);				
				} else {
					validadoTodosAutoriPago=false;
				}
			}
			
			if(!validadoTodosAutoriPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AutoriPagoLogicAdditional.checkAutoriPagoToSavesAfter(autoripagos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAutoriPagos();
			
			connexion.commit();		
			
			this.quitarAutoriPagosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAutoriPagos()throws Exception {				
		 try {	
			AutoriPagoLogicAdditional.checkAutoriPagoToSaves(autoripagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAutoriPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AutoriPago autoripagoLocal:autoripagos) {				
				if(autoripagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AutoriPagoLogicAdditional.updateAutoriPagoToSave(autoripagoLocal,this.arrDatoGeneral);
	        	
				AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),autoripagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAutoriPago(autoripagoLocal)) {				
					AutoriPagoDataAccess.save(autoripagoLocal, connexion);				
				} else {
					validadoTodosAutoriPago=false;
				}
			}
			
			if(!validadoTodosAutoriPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AutoriPagoLogicAdditional.checkAutoriPagoToSavesAfter(autoripagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAutoriPagosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AutoriPagoParameterReturnGeneral procesarAccionAutoriPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutoriPago> autoripagos,AutoriPagoParameterReturnGeneral autoripagoParameterGeneral)throws Exception {
		 try {	
			AutoriPagoParameterReturnGeneral autoripagoReturnGeneral=new AutoriPagoParameterReturnGeneral();
	
			AutoriPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autoripagos,autoripagoParameterGeneral,autoripagoReturnGeneral);
			
			return autoripagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AutoriPagoParameterReturnGeneral procesarAccionAutoriPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutoriPago> autoripagos,AutoriPagoParameterReturnGeneral autoripagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-procesarAccionAutoriPagosWithConnection");connexion.begin();			
			
			AutoriPagoParameterReturnGeneral autoripagoReturnGeneral=new AutoriPagoParameterReturnGeneral();
	
			AutoriPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autoripagos,autoripagoParameterGeneral,autoripagoReturnGeneral);
			
			this.connexion.commit();
			
			return autoripagoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AutoriPagoParameterReturnGeneral procesarEventosAutoriPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AutoriPago> autoripagos,AutoriPago autoripago,AutoriPagoParameterReturnGeneral autoripagoParameterGeneral,Boolean isEsNuevoAutoriPago,ArrayList<Classe> clases)throws Exception {
		 try {	
			AutoriPagoParameterReturnGeneral autoripagoReturnGeneral=new AutoriPagoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				autoripagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AutoriPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,autoripagos,autoripago,autoripagoParameterGeneral,autoripagoReturnGeneral,isEsNuevoAutoriPago,clases);
			
			return autoripagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AutoriPagoParameterReturnGeneral procesarEventosAutoriPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AutoriPago> autoripagos,AutoriPago autoripago,AutoriPagoParameterReturnGeneral autoripagoParameterGeneral,Boolean isEsNuevoAutoriPago,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-procesarEventosAutoriPagosWithConnection");connexion.begin();			
			
			AutoriPagoParameterReturnGeneral autoripagoReturnGeneral=new AutoriPagoParameterReturnGeneral();
	
			autoripagoReturnGeneral.setAutoriPago(autoripago);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				autoripagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AutoriPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,autoripagos,autoripago,autoripagoParameterGeneral,autoripagoReturnGeneral,isEsNuevoAutoriPago,clases);
			
			this.connexion.commit();
			
			return autoripagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AutoriPagoParameterReturnGeneral procesarImportacionAutoriPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AutoriPagoParameterReturnGeneral autoripagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-procesarImportacionAutoriPagosWithConnection");connexion.begin();			
			
			AutoriPagoParameterReturnGeneral autoripagoReturnGeneral=new AutoriPagoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.autoripagos=new ArrayList<AutoriPago>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.autoripago=new AutoriPago();
				
				
				if(conColumnasBase) {this.autoripago.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.autoripago.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.autoripago.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoripago.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoripago.setvalor_pago(Double.parseDouble(arrColumnas[iColumn++]));
				this.autoripago.setvalor_cancelado(Double.parseDouble(arrColumnas[iColumn++]));
				this.autoripago.setnumero_factura(arrColumnas[iColumn++]);
			this.autoripago.setdetalle_factura(arrColumnas[iColumn++]);
				this.autoripago.setfecha_corte(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoripago.setdescripcion(arrColumnas[iColumn++]);
				
				this.autoripagos.add(this.autoripago);
			}
			
			this.saveAutoriPagos();
			
			this.connexion.commit();
			
			autoripagoReturnGeneral.setConRetornoEstaProcesado(true);
			autoripagoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return autoripagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAutoriPagosEliminados() throws Exception {				
		
		List<AutoriPago> autoripagosAux= new ArrayList<AutoriPago>();
		
		for(AutoriPago autoripago:autoripagos) {
			if(!autoripago.getIsDeleted()) {
				autoripagosAux.add(autoripago);
			}
		}
		
		autoripagos=autoripagosAux;
	}
	
	public void quitarAutoriPagosNulos() throws Exception {				
		
		List<AutoriPago> autoripagosAux= new ArrayList<AutoriPago>();
		
		for(AutoriPago autoripago : this.autoripagos) {
			if(autoripago==null) {
				autoripagosAux.add(autoripago);
			}
		}
		
		//this.autoripagos=autoripagosAux;
		
		this.autoripagos.removeAll(autoripagosAux);
	}
	
	public void getSetVersionRowAutoriPagoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(autoripago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((autoripago.getIsDeleted() || (autoripago.getIsChanged()&&!autoripago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=autoripagoDataAccess.getSetVersionRowAutoriPago(connexion,autoripago.getId());
				
				if(!autoripago.getVersionRow().equals(timestamp)) {	
					autoripago.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				autoripago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAutoriPago()throws Exception {	
		
		if(autoripago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((autoripago.getIsDeleted() || (autoripago.getIsChanged()&&!autoripago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=autoripagoDataAccess.getSetVersionRowAutoriPago(connexion,autoripago.getId());
			
			try {							
				if(!autoripago.getVersionRow().equals(timestamp)) {	
					autoripago.setVersionRow(timestamp);
				}
				
				autoripago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAutoriPagosWithConnection()throws Exception {	
		if(autoripagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AutoriPago autoripagoAux:autoripagos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(autoripagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(autoripagoAux.getIsDeleted() || (autoripagoAux.getIsChanged()&&!autoripagoAux.getIsNew())) {
						
						timestamp=autoripagoDataAccess.getSetVersionRowAutoriPago(connexion,autoripagoAux.getId());
						
						if(!autoripago.getVersionRow().equals(timestamp)) {	
							autoripagoAux.setVersionRow(timestamp);
						}
								
						autoripagoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAutoriPagos()throws Exception {	
		if(autoripagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AutoriPago autoripagoAux:autoripagos) {
					if(autoripagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(autoripagoAux.getIsDeleted() || (autoripagoAux.getIsChanged()&&!autoripagoAux.getIsNew())) {
						
						timestamp=autoripagoDataAccess.getSetVersionRowAutoriPago(connexion,autoripagoAux.getId());
						
						if(!autoripagoAux.getVersionRow().equals(timestamp)) {	
							autoripagoAux.setVersionRow(timestamp);
						}
						
													
						autoripagoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AutoriPagoParameterReturnGeneral cargarCombosLoteForeignKeyAutoriPagoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalCliente,String finalQueryGlobalFactura,String finalQueryGlobalAsientoContable,String finalQueryGlobalCentroCosto,String finalQueryGlobalCentroActividad,String finalQueryGlobalBanco,String finalQueryGlobalCuentaBanco,String finalQueryGlobalDetalleProve,String finalQueryGlobalTransaccion) throws Exception {
		AutoriPagoParameterReturnGeneral  autoripagoReturnGeneral =new AutoriPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-cargarCombosLoteForeignKeyAutoriPagoWithConnection");connexion.begin();
			
			autoripagoReturnGeneral =new AutoriPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			autoripagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			autoripagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			autoripagoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			autoripagoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			autoripagoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			autoripagoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			autoripagoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CentroActividad> centroactividadsForeignKey=new ArrayList<CentroActividad>();
			CentroActividadLogic centroactividadLogic=new CentroActividadLogic();
			centroactividadLogic.setConnexion(this.connexion);
			centroactividadLogic.getCentroActividadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroActividad.equals("NONE")) {
				centroactividadLogic.getTodosCentroActividads(finalQueryGlobalCentroActividad,new Pagination());
				centroactividadsForeignKey=centroactividadLogic.getCentroActividads();
			}

			autoripagoReturnGeneral.setcentroactividadsForeignKey(centroactividadsForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			autoripagoReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<CuentaBanco> cuentabancosForeignKey=new ArrayList<CuentaBanco>();
			CuentaBancoLogic cuentabancoLogic=new CuentaBancoLogic();
			cuentabancoLogic.setConnexion(this.connexion);
			cuentabancoLogic.getCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaBanco.equals("NONE")) {
				cuentabancoLogic.getTodosCuentaBancos(finalQueryGlobalCuentaBanco,new Pagination());
				cuentabancosForeignKey=cuentabancoLogic.getCuentaBancos();
			}

			autoripagoReturnGeneral.setcuentabancosForeignKey(cuentabancosForeignKey);


			List<DetalleProve> detalleprovesForeignKey=new ArrayList<DetalleProve>();
			DetalleProveLogic detalleproveLogic=new DetalleProveLogic();
			detalleproveLogic.setConnexion(this.connexion);
			detalleproveLogic.getDetalleProveDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleProve.equals("NONE")) {
				detalleproveLogic.getTodosDetalleProves(finalQueryGlobalDetalleProve,new Pagination());
				detalleprovesForeignKey=detalleproveLogic.getDetalleProves();
			}

			autoripagoReturnGeneral.setdetalleprovesForeignKey(detalleprovesForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			autoripagoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return autoripagoReturnGeneral;
	}
	
	public AutoriPagoParameterReturnGeneral cargarCombosLoteForeignKeyAutoriPago(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalCliente,String finalQueryGlobalFactura,String finalQueryGlobalAsientoContable,String finalQueryGlobalCentroCosto,String finalQueryGlobalCentroActividad,String finalQueryGlobalBanco,String finalQueryGlobalCuentaBanco,String finalQueryGlobalDetalleProve,String finalQueryGlobalTransaccion) throws Exception {
		AutoriPagoParameterReturnGeneral  autoripagoReturnGeneral =new AutoriPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			autoripagoReturnGeneral =new AutoriPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			autoripagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			autoripagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			autoripagoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			autoripagoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			autoripagoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			autoripagoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			autoripagoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CentroActividad> centroactividadsForeignKey=new ArrayList<CentroActividad>();
			CentroActividadLogic centroactividadLogic=new CentroActividadLogic();
			centroactividadLogic.setConnexion(this.connexion);
			centroactividadLogic.getCentroActividadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroActividad.equals("NONE")) {
				centroactividadLogic.getTodosCentroActividads(finalQueryGlobalCentroActividad,new Pagination());
				centroactividadsForeignKey=centroactividadLogic.getCentroActividads();
			}

			autoripagoReturnGeneral.setcentroactividadsForeignKey(centroactividadsForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			autoripagoReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<CuentaBanco> cuentabancosForeignKey=new ArrayList<CuentaBanco>();
			CuentaBancoLogic cuentabancoLogic=new CuentaBancoLogic();
			cuentabancoLogic.setConnexion(this.connexion);
			cuentabancoLogic.getCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaBanco.equals("NONE")) {
				cuentabancoLogic.getTodosCuentaBancos(finalQueryGlobalCuentaBanco,new Pagination());
				cuentabancosForeignKey=cuentabancoLogic.getCuentaBancos();
			}

			autoripagoReturnGeneral.setcuentabancosForeignKey(cuentabancosForeignKey);


			List<DetalleProve> detalleprovesForeignKey=new ArrayList<DetalleProve>();
			DetalleProveLogic detalleproveLogic=new DetalleProveLogic();
			detalleproveLogic.setConnexion(this.connexion);
			detalleproveLogic.getDetalleProveDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleProve.equals("NONE")) {
				detalleproveLogic.getTodosDetalleProves(finalQueryGlobalDetalleProve,new Pagination());
				detalleprovesForeignKey=detalleproveLogic.getDetalleProves();
			}

			autoripagoReturnGeneral.setdetalleprovesForeignKey(detalleprovesForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			autoripagoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return autoripagoReturnGeneral;
	}
	
	
	public void deepLoad(AutoriPago autoripago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AutoriPagoLogicAdditional.updateAutoriPagoToGet(autoripago,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autoripago.setEmpresa(autoripagoDataAccess.getEmpresa(connexion,autoripago));
		autoripago.setSucursal(autoripagoDataAccess.getSucursal(connexion,autoripago));
		autoripago.setEjercicio(autoripagoDataAccess.getEjercicio(connexion,autoripago));
		autoripago.setCliente(autoripagoDataAccess.getCliente(connexion,autoripago));
		autoripago.setFactura(autoripagoDataAccess.getFactura(connexion,autoripago));
		autoripago.setAsientoContable(autoripagoDataAccess.getAsientoContable(connexion,autoripago));
		autoripago.setCentroCosto(autoripagoDataAccess.getCentroCosto(connexion,autoripago));
		autoripago.setCentroActividad(autoripagoDataAccess.getCentroActividad(connexion,autoripago));
		autoripago.setBanco(autoripagoDataAccess.getBanco(connexion,autoripago));
		autoripago.setCuentaBanco(autoripagoDataAccess.getCuentaBanco(connexion,autoripago));
		autoripago.setDetalleProve(autoripagoDataAccess.getDetalleProve(connexion,autoripago));
		autoripago.setTransaccion(autoripagoDataAccess.getTransaccion(connexion,autoripago));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				autoripago.setEmpresa(autoripagoDataAccess.getEmpresa(connexion,autoripago));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				autoripago.setSucursal(autoripagoDataAccess.getSucursal(connexion,autoripago));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				autoripago.setEjercicio(autoripagoDataAccess.getEjercicio(connexion,autoripago));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				autoripago.setCliente(autoripagoDataAccess.getCliente(connexion,autoripago));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				autoripago.setFactura(autoripagoDataAccess.getFactura(connexion,autoripago));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				autoripago.setAsientoContable(autoripagoDataAccess.getAsientoContable(connexion,autoripago));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				autoripago.setCentroCosto(autoripagoDataAccess.getCentroCosto(connexion,autoripago));
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				autoripago.setCentroActividad(autoripagoDataAccess.getCentroActividad(connexion,autoripago));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				autoripago.setBanco(autoripagoDataAccess.getBanco(connexion,autoripago));
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				autoripago.setCuentaBanco(autoripagoDataAccess.getCuentaBanco(connexion,autoripago));
				continue;
			}

			if(clas.clas.equals(DetalleProve.class)) {
				autoripago.setDetalleProve(autoripagoDataAccess.getDetalleProve(connexion,autoripago));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				autoripago.setTransaccion(autoripagoDataAccess.getTransaccion(connexion,autoripago));
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
			autoripago.setEmpresa(autoripagoDataAccess.getEmpresa(connexion,autoripago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setSucursal(autoripagoDataAccess.getSucursal(connexion,autoripago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setEjercicio(autoripagoDataAccess.getEjercicio(connexion,autoripago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setCliente(autoripagoDataAccess.getCliente(connexion,autoripago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setFactura(autoripagoDataAccess.getFactura(connexion,autoripago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setAsientoContable(autoripagoDataAccess.getAsientoContable(connexion,autoripago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setCentroCosto(autoripagoDataAccess.getCentroCosto(connexion,autoripago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setCentroActividad(autoripagoDataAccess.getCentroActividad(connexion,autoripago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setBanco(autoripagoDataAccess.getBanco(connexion,autoripago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setCuentaBanco(autoripagoDataAccess.getCuentaBanco(connexion,autoripago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProve.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setDetalleProve(autoripagoDataAccess.getDetalleProve(connexion,autoripago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setTransaccion(autoripagoDataAccess.getTransaccion(connexion,autoripago));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autoripago.setEmpresa(autoripagoDataAccess.getEmpresa(connexion,autoripago));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(autoripago.getEmpresa(),isDeep,deepLoadType,clases);
				
		autoripago.setSucursal(autoripagoDataAccess.getSucursal(connexion,autoripago));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(autoripago.getSucursal(),isDeep,deepLoadType,clases);
				
		autoripago.setEjercicio(autoripagoDataAccess.getEjercicio(connexion,autoripago));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(autoripago.getEjercicio(),isDeep,deepLoadType,clases);
				
		autoripago.setCliente(autoripagoDataAccess.getCliente(connexion,autoripago));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(autoripago.getCliente(),isDeep,deepLoadType,clases);
				
		autoripago.setFactura(autoripagoDataAccess.getFactura(connexion,autoripago));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(autoripago.getFactura(),isDeep,deepLoadType,clases);
				
		autoripago.setAsientoContable(autoripagoDataAccess.getAsientoContable(connexion,autoripago));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(autoripago.getAsientoContable(),isDeep,deepLoadType,clases);
				
		autoripago.setCentroCosto(autoripagoDataAccess.getCentroCosto(connexion,autoripago));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(autoripago.getCentroCosto(),isDeep,deepLoadType,clases);
				
		autoripago.setCentroActividad(autoripagoDataAccess.getCentroActividad(connexion,autoripago));
		CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
		centroactividadLogic.deepLoad(autoripago.getCentroActividad(),isDeep,deepLoadType,clases);
				
		autoripago.setBanco(autoripagoDataAccess.getBanco(connexion,autoripago));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(autoripago.getBanco(),isDeep,deepLoadType,clases);
				
		autoripago.setCuentaBanco(autoripagoDataAccess.getCuentaBanco(connexion,autoripago));
		CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
		cuentabancoLogic.deepLoad(autoripago.getCuentaBanco(),isDeep,deepLoadType,clases);
				
		autoripago.setDetalleProve(autoripagoDataAccess.getDetalleProve(connexion,autoripago));
		DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
		detalleproveLogic.deepLoad(autoripago.getDetalleProve(),isDeep,deepLoadType,clases);
				
		autoripago.setTransaccion(autoripagoDataAccess.getTransaccion(connexion,autoripago));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(autoripago.getTransaccion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				autoripago.setEmpresa(autoripagoDataAccess.getEmpresa(connexion,autoripago));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(autoripago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				autoripago.setSucursal(autoripagoDataAccess.getSucursal(connexion,autoripago));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(autoripago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				autoripago.setEjercicio(autoripagoDataAccess.getEjercicio(connexion,autoripago));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(autoripago.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				autoripago.setCliente(autoripagoDataAccess.getCliente(connexion,autoripago));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(autoripago.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				autoripago.setFactura(autoripagoDataAccess.getFactura(connexion,autoripago));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(autoripago.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				autoripago.setAsientoContable(autoripagoDataAccess.getAsientoContable(connexion,autoripago));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(autoripago.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				autoripago.setCentroCosto(autoripagoDataAccess.getCentroCosto(connexion,autoripago));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(autoripago.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				autoripago.setCentroActividad(autoripagoDataAccess.getCentroActividad(connexion,autoripago));
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepLoad(autoripago.getCentroActividad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				autoripago.setBanco(autoripagoDataAccess.getBanco(connexion,autoripago));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(autoripago.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				autoripago.setCuentaBanco(autoripagoDataAccess.getCuentaBanco(connexion,autoripago));
				CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
				cuentabancoLogic.deepLoad(autoripago.getCuentaBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleProve.class)) {
				autoripago.setDetalleProve(autoripagoDataAccess.getDetalleProve(connexion,autoripago));
				DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
				detalleproveLogic.deepLoad(autoripago.getDetalleProve(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				autoripago.setTransaccion(autoripagoDataAccess.getTransaccion(connexion,autoripago));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(autoripago.getTransaccion(),isDeep,deepLoadType,clases);				
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
			autoripago.setEmpresa(autoripagoDataAccess.getEmpresa(connexion,autoripago));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(autoripago.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setSucursal(autoripagoDataAccess.getSucursal(connexion,autoripago));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(autoripago.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setEjercicio(autoripagoDataAccess.getEjercicio(connexion,autoripago));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(autoripago.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setCliente(autoripagoDataAccess.getCliente(connexion,autoripago));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(autoripago.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setFactura(autoripagoDataAccess.getFactura(connexion,autoripago));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(autoripago.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setAsientoContable(autoripagoDataAccess.getAsientoContable(connexion,autoripago));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(autoripago.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setCentroCosto(autoripagoDataAccess.getCentroCosto(connexion,autoripago));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(autoripago.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setCentroActividad(autoripagoDataAccess.getCentroActividad(connexion,autoripago));
			CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
			centroactividadLogic.deepLoad(autoripago.getCentroActividad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setBanco(autoripagoDataAccess.getBanco(connexion,autoripago));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(autoripago.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setCuentaBanco(autoripagoDataAccess.getCuentaBanco(connexion,autoripago));
			CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
			cuentabancoLogic.deepLoad(autoripago.getCuentaBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProve.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setDetalleProve(autoripagoDataAccess.getDetalleProve(connexion,autoripago));
			DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
			detalleproveLogic.deepLoad(autoripago.getDetalleProve(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripago.setTransaccion(autoripagoDataAccess.getTransaccion(connexion,autoripago));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(autoripago.getTransaccion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AutoriPago autoripago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AutoriPagoLogicAdditional.updateAutoriPagoToSave(autoripago,this.arrDatoGeneral);
			
AutoriPagoDataAccess.save(autoripago, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(autoripago.getEmpresa(),connexion);

		SucursalDataAccess.save(autoripago.getSucursal(),connexion);

		EjercicioDataAccess.save(autoripago.getEjercicio(),connexion);

		ClienteDataAccess.save(autoripago.getCliente(),connexion);

		FacturaDataAccess.save(autoripago.getFactura(),connexion);

		AsientoContableDataAccess.save(autoripago.getAsientoContable(),connexion);

		CentroCostoDataAccess.save(autoripago.getCentroCosto(),connexion);

		CentroActividadDataAccess.save(autoripago.getCentroActividad(),connexion);

		BancoDataAccess.save(autoripago.getBanco(),connexion);

		CuentaBancoDataAccess.save(autoripago.getCuentaBanco(),connexion);

		DetalleProveDataAccess.save(autoripago.getDetalleProve(),connexion);

		TransaccionDataAccess.save(autoripago.getTransaccion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(autoripago.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(autoripago.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(autoripago.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(autoripago.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(autoripago.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(autoripago.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(autoripago.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				CentroActividadDataAccess.save(autoripago.getCentroActividad(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(autoripago.getBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				CuentaBancoDataAccess.save(autoripago.getCuentaBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleProve.class)) {
				DetalleProveDataAccess.save(autoripago.getDetalleProve(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(autoripago.getTransaccion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(autoripago.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(autoripago.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(autoripago.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(autoripago.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(autoripago.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(autoripago.getEjercicio(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(autoripago.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(autoripago.getCliente(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(autoripago.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(autoripago.getFactura(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(autoripago.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(autoripago.getAsientoContable(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(autoripago.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(autoripago.getCentroCosto(),isDeep,deepLoadType,clases);
				

		CentroActividadDataAccess.save(autoripago.getCentroActividad(),connexion);
		CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
		centroactividadLogic.deepLoad(autoripago.getCentroActividad(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(autoripago.getBanco(),connexion);
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(autoripago.getBanco(),isDeep,deepLoadType,clases);
				

		CuentaBancoDataAccess.save(autoripago.getCuentaBanco(),connexion);
		CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
		cuentabancoLogic.deepLoad(autoripago.getCuentaBanco(),isDeep,deepLoadType,clases);
				

		DetalleProveDataAccess.save(autoripago.getDetalleProve(),connexion);
		DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
		detalleproveLogic.deepLoad(autoripago.getDetalleProve(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(autoripago.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(autoripago.getTransaccion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(autoripago.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(autoripago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(autoripago.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(autoripago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(autoripago.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(autoripago.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(autoripago.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(autoripago.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(autoripago.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(autoripago.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(autoripago.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(autoripago.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(autoripago.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(autoripago.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				CentroActividadDataAccess.save(autoripago.getCentroActividad(),connexion);
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepSave(autoripago.getCentroActividad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(autoripago.getBanco(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(autoripago.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				CuentaBancoDataAccess.save(autoripago.getCuentaBanco(),connexion);
				CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
				cuentabancoLogic.deepSave(autoripago.getCuentaBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleProve.class)) {
				DetalleProveDataAccess.save(autoripago.getDetalleProve(),connexion);
				DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
				detalleproveLogic.deepSave(autoripago.getDetalleProve(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(autoripago.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(autoripago.getTransaccion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(AutoriPago.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(autoripago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(autoripago);
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
			this.deepLoad(this.autoripago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AutoriPago.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(autoripagos!=null) {
				for(AutoriPago autoripago:autoripagos) {
					this.deepLoad(autoripago,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(autoripagos);
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
			if(autoripagos!=null) {
				for(AutoriPago autoripago:autoripagos) {
					this.deepLoad(autoripago,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(autoripagos);
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
			this.getNewConnexionToDeep(AutoriPago.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(autoripago,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AutoriPago.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(autoripagos!=null) {
				for(AutoriPago autoripago:autoripagos) {
					this.deepSave(autoripago,isDeep,deepLoadType,clases);
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
			if(autoripagos!=null) {
				for(AutoriPago autoripago:autoripagos) {
					this.deepSave(autoripago,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAutoriPagosFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,AutoriPagoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,AutoriPagoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagosFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,AutoriPagoConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,AutoriPagoConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagosFK_IdCentroActividadWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_actividad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroActividad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroActividad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_actividad,AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroActividad);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroActividad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdCentroActividad(String sFinalQuery,Pagination pagination,Long id_centro_actividad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroActividad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroActividad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_actividad,AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroActividad);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroActividad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,AutoriPagoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,AutoriPagoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,AutoriPagoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,AutoriPagoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagosFK_IdCuentaBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_banco,AutoriPagoConstantesFunciones.IDCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaBanco);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdCuentaBanco(String sFinalQuery,Pagination pagination,Long id_cuenta_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_banco,AutoriPagoConstantesFunciones.IDCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaBanco);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagosFK_IdDetalleProveWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_prove)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleProve= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleProve.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_prove,AutoriPagoConstantesFunciones.IDDETALLEPROVE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleProve);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleProve","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdDetalleProve(String sFinalQuery,Pagination pagination,Long id_detalle_prove)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleProve= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleProve.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_prove,AutoriPagoConstantesFunciones.IDDETALLEPROVE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleProve);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleProve","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,AutoriPagoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,AutoriPagoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AutoriPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AutoriPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagosFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,AutoriPagoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,AutoriPagoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AutoriPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AutoriPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagosFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,AutoriPagoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagosFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,AutoriPagoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			AutoriPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(this.autoripagos);
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
			if(AutoriPagoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriPagoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AutoriPago autoripago,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AutoriPagoConstantesFunciones.ISCONAUDITORIA) {
				if(autoripago.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriPagoDataAccess.TABLENAME, autoripago.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AutoriPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AutoriPagoLogic.registrarAuditoriaDetallesAutoriPago(connexion,autoripago,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(autoripago.getIsDeleted()) {
					/*if(!autoripago.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AutoriPagoDataAccess.TABLENAME, autoripago.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AutoriPagoLogic.registrarAuditoriaDetallesAutoriPago(connexion,autoripago,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriPagoDataAccess.TABLENAME, autoripago.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(autoripago.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriPagoDataAccess.TABLENAME, autoripago.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AutoriPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AutoriPagoLogic.registrarAuditoriaDetallesAutoriPago(connexion,autoripago,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAutoriPago(Connexion connexion,AutoriPago autoripago)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(autoripago.getIsNew()||!autoripago.getid_empresa().equals(autoripago.getAutoriPagoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_empresa()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_empresa().toString();
				}
				if(autoripago.getid_empresa()!=null)
				{
					strValorNuevo=autoripago.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getid_sucursal().equals(autoripago.getAutoriPagoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_sucursal()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_sucursal().toString();
				}
				if(autoripago.getid_sucursal()!=null)
				{
					strValorNuevo=autoripago.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getid_ejercicio().equals(autoripago.getAutoriPagoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_ejercicio().toString();
				}
				if(autoripago.getid_ejercicio()!=null)
				{
					strValorNuevo=autoripago.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getid_cliente().equals(autoripago.getAutoriPagoOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_cliente()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_cliente().toString();
				}
				if(autoripago.getid_cliente()!=null)
				{
					strValorNuevo=autoripago.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getid_factura().equals(autoripago.getAutoriPagoOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_factura()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_factura().toString();
				}
				if(autoripago.getid_factura()!=null)
				{
					strValorNuevo=autoripago.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getid_asiento_contable().equals(autoripago.getAutoriPagoOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_asiento_contable().toString();
				}
				if(autoripago.getid_asiento_contable()!=null)
				{
					strValorNuevo=autoripago.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getid_centro_costo().equals(autoripago.getAutoriPagoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_centro_costo().toString();
				}
				if(autoripago.getid_centro_costo()!=null)
				{
					strValorNuevo=autoripago.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getid_centro_actividad().equals(autoripago.getAutoriPagoOriginal().getid_centro_actividad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_centro_actividad()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_centro_actividad().toString();
				}
				if(autoripago.getid_centro_actividad()!=null)
				{
					strValorNuevo=autoripago.getid_centro_actividad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getid_banco().equals(autoripago.getAutoriPagoOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_banco()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_banco().toString();
				}
				if(autoripago.getid_banco()!=null)
				{
					strValorNuevo=autoripago.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getid_cuenta_banco().equals(autoripago.getAutoriPagoOriginal().getid_cuenta_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_cuenta_banco()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_cuenta_banco().toString();
				}
				if(autoripago.getid_cuenta_banco()!=null)
				{
					strValorNuevo=autoripago.getid_cuenta_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDCUENTABANCO,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getid_detalle_prove().equals(autoripago.getAutoriPagoOriginal().getid_detalle_prove()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_detalle_prove()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_detalle_prove().toString();
				}
				if(autoripago.getid_detalle_prove()!=null)
				{
					strValorNuevo=autoripago.getid_detalle_prove().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDDETALLEPROVE,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getid_transaccion().equals(autoripago.getAutoriPagoOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getid_transaccion()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getid_transaccion().toString();
				}
				if(autoripago.getid_transaccion()!=null)
				{
					strValorNuevo=autoripago.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getfecha_emision().equals(autoripago.getAutoriPagoOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getfecha_emision()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getfecha_emision().toString();
				}
				if(autoripago.getfecha_emision()!=null)
				{
					strValorNuevo=autoripago.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getfecha_vencimiento().equals(autoripago.getAutoriPagoOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getfecha_vencimiento().toString();
				}
				if(autoripago.getfecha_vencimiento()!=null)
				{
					strValorNuevo=autoripago.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getvalor_pago().equals(autoripago.getAutoriPagoOriginal().getvalor_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getvalor_pago()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getvalor_pago().toString();
				}
				if(autoripago.getvalor_pago()!=null)
				{
					strValorNuevo=autoripago.getvalor_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.VALORPAGO,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getvalor_cancelado().equals(autoripago.getAutoriPagoOriginal().getvalor_cancelado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getvalor_cancelado()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getvalor_cancelado().toString();
				}
				if(autoripago.getvalor_cancelado()!=null)
				{
					strValorNuevo=autoripago.getvalor_cancelado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.VALORCANCELADO,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getnumero_factura().equals(autoripago.getAutoriPagoOriginal().getnumero_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getnumero_factura()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getnumero_factura();
				}
				if(autoripago.getnumero_factura()!=null)
				{
					strValorNuevo=autoripago.getnumero_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.NUMEROFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getdetalle_factura().equals(autoripago.getAutoriPagoOriginal().getdetalle_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getdetalle_factura()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getdetalle_factura();
				}
				if(autoripago.getdetalle_factura()!=null)
				{
					strValorNuevo=autoripago.getdetalle_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.DETALLEFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getfecha_corte().equals(autoripago.getAutoriPagoOriginal().getfecha_corte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getfecha_corte()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getfecha_corte().toString();
				}
				if(autoripago.getfecha_corte()!=null)
				{
					strValorNuevo=autoripago.getfecha_corte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.FECHACORTE,strValorActual,strValorNuevo);
			}	
			
			if(autoripago.getIsNew()||!autoripago.getdescripcion().equals(autoripago.getAutoriPagoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripago.getAutoriPagoOriginal().getdescripcion()!=null)
				{
					strValorActual=autoripago.getAutoriPagoOriginal().getdescripcion();
				}
				if(autoripago.getdescripcion()!=null)
				{
					strValorNuevo=autoripago.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAutoriPagoRelacionesWithConnection(AutoriPago autoripago) throws Exception {

		if(!autoripago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAutoriPagoRelacionesBase(autoripago,true);
		}
	}

	public void saveAutoriPagoRelaciones(AutoriPago autoripago)throws Exception {

		if(!autoripago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAutoriPagoRelacionesBase(autoripago,false);
		}
	}

	public void saveAutoriPagoRelacionesBase(AutoriPago autoripago,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AutoriPago-saveRelacionesWithConnection");}
	

			this.setAutoriPago(autoripago);

			if(AutoriPagoLogicAdditional.validarSaveRelaciones(autoripago,this)) {

				AutoriPagoLogicAdditional.updateRelacionesToSave(autoripago,this);

				if((autoripago.getIsNew()||autoripago.getIsChanged())&&!autoripago.getIsDeleted()) {
					this.saveAutoriPago();
					this.saveAutoriPagoRelacionesDetalles();

				} else if(autoripago.getIsDeleted()) {
					this.saveAutoriPagoRelacionesDetalles();
					this.saveAutoriPago();
				}

				AutoriPagoLogicAdditional.updateRelacionesToSaveAfter(autoripago,this);

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
	
	
	private void saveAutoriPagoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAutoriPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AutoriPagoConstantesFunciones.getClassesForeignKeysOfAutoriPago(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AutoriPagoConstantesFunciones.getClassesRelationshipsOfAutoriPago(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
