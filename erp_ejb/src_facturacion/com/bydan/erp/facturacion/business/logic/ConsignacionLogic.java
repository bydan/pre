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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.ConsignacionConstantesFunciones;
import com.bydan.erp.facturacion.util.ConsignacionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ConsignacionParameterGeneral;
import com.bydan.erp.facturacion.business.entity.Consignacion;
import com.bydan.erp.facturacion.business.logic.ConsignacionLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;








@SuppressWarnings("unused")
public class ConsignacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ConsignacionLogic.class);
	
	protected ConsignacionDataAccess consignacionDataAccess; 	
	protected Consignacion consignacion;
	protected List<Consignacion> consignacions;
	protected Object consignacionObject;	
	protected List<Object> consignacionsObject;
	
	public static ClassValidator<Consignacion> consignacionValidator = new ClassValidator<Consignacion>(Consignacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ConsignacionLogicAdditional consignacionLogicAdditional=null;
	
	public ConsignacionLogicAdditional getConsignacionLogicAdditional() {
		return this.consignacionLogicAdditional;
	}
	
	public void setConsignacionLogicAdditional(ConsignacionLogicAdditional consignacionLogicAdditional) {
		try {
			this.consignacionLogicAdditional=consignacionLogicAdditional;
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
	
	
	
	
	public  ConsignacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.consignacionDataAccess = new ConsignacionDataAccess();
			
			this.consignacions= new ArrayList<Consignacion>();
			this.consignacion= new Consignacion();
			
			this.consignacionObject=new Object();
			this.consignacionsObject=new ArrayList<Object>();
				
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
			
			this.consignacionDataAccess.setConnexionType(this.connexionType);
			this.consignacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConsignacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.consignacionDataAccess = new ConsignacionDataAccess();
			this.consignacions= new ArrayList<Consignacion>();
			this.consignacion= new Consignacion();
			this.consignacionObject=new Object();
			this.consignacionsObject=new ArrayList<Object>();
			
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
			
			this.consignacionDataAccess.setConnexionType(this.connexionType);
			this.consignacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Consignacion getConsignacion() throws Exception {	
		ConsignacionLogicAdditional.checkConsignacionToGet(consignacion,this.datosCliente,this.arrDatoGeneral);
		ConsignacionLogicAdditional.updateConsignacionToGet(consignacion,this.arrDatoGeneral);
		
		return consignacion;
	}
		
	public void setConsignacion(Consignacion newConsignacion) {
		this.consignacion = newConsignacion;
	}
	
	public ConsignacionDataAccess getConsignacionDataAccess() {
		return consignacionDataAccess;
	}
	
	public void setConsignacionDataAccess(ConsignacionDataAccess newconsignacionDataAccess) {
		this.consignacionDataAccess = newconsignacionDataAccess;
	}
	
	public List<Consignacion> getConsignacions() throws Exception {		
		this.quitarConsignacionsNulos();
		
		ConsignacionLogicAdditional.checkConsignacionToGets(consignacions,this.datosCliente,this.arrDatoGeneral);
		
		for (Consignacion consignacionLocal: consignacions ) {
			ConsignacionLogicAdditional.updateConsignacionToGet(consignacionLocal,this.arrDatoGeneral);
		}
		
		return consignacions;
	}
	
	public void setConsignacions(List<Consignacion> newConsignacions) {
		this.consignacions = newConsignacions;
	}
	
	public Object getConsignacionObject() {	
		this.consignacionObject=this.consignacionDataAccess.getEntityObject();
		return this.consignacionObject;
	}
		
	public void setConsignacionObject(Object newConsignacionObject) {
		this.consignacionObject = newConsignacionObject;
	}
	
	public List<Object> getConsignacionsObject() {		
		this.consignacionsObject=this.consignacionDataAccess.getEntitiesObject();
		return this.consignacionsObject;
	}
		
	public void setConsignacionsObject(List<Object> newConsignacionsObject) {
		this.consignacionsObject = newConsignacionsObject;
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
		
		if(this.consignacionDataAccess!=null) {
			this.consignacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			consignacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			consignacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		consignacion = new  Consignacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			consignacion=consignacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacion);
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
		consignacion = new  Consignacion();
		  		  
        try {
			
			consignacion=consignacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		consignacion = new  Consignacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			consignacion=consignacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacion);
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
		consignacion = new  Consignacion();
		  		  
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
		consignacion = new  Consignacion();
		  		  
        try {
			
			consignacion=consignacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		consignacion = new  Consignacion();
		  		  
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
		consignacion = new  Consignacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =consignacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		consignacion = new  Consignacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=consignacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		consignacion = new  Consignacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =consignacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		consignacion = new  Consignacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=consignacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		consignacion = new  Consignacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =consignacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		consignacion = new  Consignacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=consignacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		consignacions = new  ArrayList<Consignacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacions=consignacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsignacion(consignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
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
		consignacions = new  ArrayList<Consignacion>();
		  		  
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
		consignacions = new  ArrayList<Consignacion>();
		  		  
        try {			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacions=consignacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarConsignacion(consignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		consignacions = new  ArrayList<Consignacion>();
		  		  
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
		consignacions = new  ArrayList<Consignacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacions=consignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsignacion(consignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
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
		consignacions = new  ArrayList<Consignacion>();
		  		  
        try {
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacions=consignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsignacion(consignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
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
		consignacions = new  ArrayList<Consignacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacions=consignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsignacion(consignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
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
		consignacions = new  ArrayList<Consignacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacions=consignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsignacion(consignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		consignacion = new  Consignacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacion=consignacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsignacion(consignacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacion);
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
		consignacion = new  Consignacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacion=consignacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsignacion(consignacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		consignacions = new  ArrayList<Consignacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacions=consignacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsignacion(consignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
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
		consignacions = new  ArrayList<Consignacion>();
		  		  
        try {
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacions=consignacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsignacion(consignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosConsignacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		consignacions = new  ArrayList<Consignacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getTodosConsignacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConsignacion(consignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
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
	
	public  void  getTodosConsignacions(String sFinalQuery,Pagination pagination)throws Exception {
		consignacions = new  ArrayList<Consignacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConsignacion(consignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarConsignacion(Consignacion consignacion) throws Exception {
		Boolean estaValidado=false;
		
		if(consignacion.getIsNew() || consignacion.getIsChanged()) { 
			this.invalidValues = consignacionValidator.getInvalidValues(consignacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(consignacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarConsignacion(List<Consignacion> Consignacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Consignacion consignacionLocal:consignacions) {				
			estaValidadoObjeto=this.validarGuardarConsignacion(consignacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarConsignacion(List<Consignacion> Consignacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConsignacion(consignacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarConsignacion(Consignacion Consignacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConsignacion(consignacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Consignacion consignacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+consignacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ConsignacionConstantesFunciones.getConsignacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"consignacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ConsignacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ConsignacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveConsignacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-saveConsignacionWithConnection");connexion.begin();			
			
			ConsignacionLogicAdditional.checkConsignacionToSave(this.consignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConsignacionLogicAdditional.updateConsignacionToSave(this.consignacion,this.arrDatoGeneral);
			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.consignacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowConsignacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConsignacion(this.consignacion)) {
				ConsignacionDataAccess.save(this.consignacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.consignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConsignacionLogicAdditional.checkConsignacionToSaveAfter(this.consignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConsignacion();
			
			connexion.commit();			
			
			if(this.consignacion.getIsDeleted()) {
				this.consignacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveConsignacion()throws Exception {	
		try {	
			
			ConsignacionLogicAdditional.checkConsignacionToSave(this.consignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConsignacionLogicAdditional.updateConsignacionToSave(this.consignacion,this.arrDatoGeneral);
			
			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.consignacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConsignacion(this.consignacion)) {			
				ConsignacionDataAccess.save(this.consignacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.consignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConsignacionLogicAdditional.checkConsignacionToSaveAfter(this.consignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.consignacion.getIsDeleted()) {
				this.consignacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveConsignacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-saveConsignacionsWithConnection");connexion.begin();			
			
			ConsignacionLogicAdditional.checkConsignacionToSaves(consignacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowConsignacions();
			
			Boolean validadoTodosConsignacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Consignacion consignacionLocal:consignacions) {		
				if(consignacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConsignacionLogicAdditional.updateConsignacionToSave(consignacionLocal,this.arrDatoGeneral);
	        	
				ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),consignacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConsignacion(consignacionLocal)) {
					ConsignacionDataAccess.save(consignacionLocal, connexion);				
				} else {
					validadoTodosConsignacion=false;
				}
			}
			
			if(!validadoTodosConsignacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConsignacionLogicAdditional.checkConsignacionToSavesAfter(consignacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConsignacions();
			
			connexion.commit();		
			
			this.quitarConsignacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveConsignacions()throws Exception {				
		 try {	
			ConsignacionLogicAdditional.checkConsignacionToSaves(consignacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosConsignacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Consignacion consignacionLocal:consignacions) {				
				if(consignacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConsignacionLogicAdditional.updateConsignacionToSave(consignacionLocal,this.arrDatoGeneral);
	        	
				ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),consignacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConsignacion(consignacionLocal)) {				
					ConsignacionDataAccess.save(consignacionLocal, connexion);				
				} else {
					validadoTodosConsignacion=false;
				}
			}
			
			if(!validadoTodosConsignacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConsignacionLogicAdditional.checkConsignacionToSavesAfter(consignacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarConsignacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConsignacionParameterReturnGeneral procesarAccionConsignacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Consignacion> consignacions,ConsignacionParameterReturnGeneral consignacionParameterGeneral)throws Exception {
		 try {	
			ConsignacionParameterReturnGeneral consignacionReturnGeneral=new ConsignacionParameterReturnGeneral();
	
			ConsignacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consignacions,consignacionParameterGeneral,consignacionReturnGeneral);
			
			return consignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConsignacionParameterReturnGeneral procesarAccionConsignacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Consignacion> consignacions,ConsignacionParameterReturnGeneral consignacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-procesarAccionConsignacionsWithConnection");connexion.begin();			
			
			ConsignacionParameterReturnGeneral consignacionReturnGeneral=new ConsignacionParameterReturnGeneral();
	
			ConsignacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consignacions,consignacionParameterGeneral,consignacionReturnGeneral);
			
			this.connexion.commit();
			
			return consignacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConsignacionParameterReturnGeneral procesarEventosConsignacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Consignacion> consignacions,Consignacion consignacion,ConsignacionParameterReturnGeneral consignacionParameterGeneral,Boolean isEsNuevoConsignacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			ConsignacionParameterReturnGeneral consignacionReturnGeneral=new ConsignacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				consignacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConsignacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,consignacions,consignacion,consignacionParameterGeneral,consignacionReturnGeneral,isEsNuevoConsignacion,clases);
			
			return consignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ConsignacionParameterReturnGeneral procesarEventosConsignacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Consignacion> consignacions,Consignacion consignacion,ConsignacionParameterReturnGeneral consignacionParameterGeneral,Boolean isEsNuevoConsignacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-procesarEventosConsignacionsWithConnection");connexion.begin();			
			
			ConsignacionParameterReturnGeneral consignacionReturnGeneral=new ConsignacionParameterReturnGeneral();
	
			consignacionReturnGeneral.setConsignacion(consignacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				consignacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConsignacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,consignacions,consignacion,consignacionParameterGeneral,consignacionReturnGeneral,isEsNuevoConsignacion,clases);
			
			this.connexion.commit();
			
			return consignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConsignacionParameterReturnGeneral procesarImportacionConsignacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ConsignacionParameterReturnGeneral consignacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-procesarImportacionConsignacionsWithConnection");connexion.begin();			
			
			ConsignacionParameterReturnGeneral consignacionReturnGeneral=new ConsignacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.consignacions=new ArrayList<Consignacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.consignacion=new Consignacion();
				
				
				if(conColumnasBase) {this.consignacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.consignacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.consignacion.setnumero(arrColumnas[iColumn++]);
				this.consignacion.setnumero_autorizacion(arrColumnas[iColumn++]);
				this.consignacion.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.consignacion.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.consignacion.setcotizacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.consignacion.setdireccion(arrColumnas[iColumn++]);
				this.consignacion.settelefono(arrColumnas[iColumn++]);
				this.consignacion.setruc(arrColumnas[iColumn++]);
				this.consignacion.setdescripcion(arrColumnas[iColumn++]);
				this.consignacion.setdescuento_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.consignacion.settotal_con_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.consignacion.setsuman(Double.parseDouble(arrColumnas[iColumn++]));
				this.consignacion.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.consignacion.settotal_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.consignacion.settotal_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.consignacion.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.consignacion.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.consignacion.setsubtotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.consignacion.setotro(Double.parseDouble(arrColumnas[iColumn++]));
				this.consignacion.setfinanciamiento(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.consignacions.add(this.consignacion);
			}
			
			this.saveConsignacions();
			
			this.connexion.commit();
			
			consignacionReturnGeneral.setConRetornoEstaProcesado(true);
			consignacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return consignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarConsignacionsEliminados() throws Exception {				
		
		List<Consignacion> consignacionsAux= new ArrayList<Consignacion>();
		
		for(Consignacion consignacion:consignacions) {
			if(!consignacion.getIsDeleted()) {
				consignacionsAux.add(consignacion);
			}
		}
		
		consignacions=consignacionsAux;
	}
	
	public void quitarConsignacionsNulos() throws Exception {				
		
		List<Consignacion> consignacionsAux= new ArrayList<Consignacion>();
		
		for(Consignacion consignacion : this.consignacions) {
			if(consignacion==null) {
				consignacionsAux.add(consignacion);
			}
		}
		
		//this.consignacions=consignacionsAux;
		
		this.consignacions.removeAll(consignacionsAux);
	}
	
	public void getSetVersionRowConsignacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(consignacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((consignacion.getIsDeleted() || (consignacion.getIsChanged()&&!consignacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=consignacionDataAccess.getSetVersionRowConsignacion(connexion,consignacion.getId());
				
				if(!consignacion.getVersionRow().equals(timestamp)) {	
					consignacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				consignacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowConsignacion()throws Exception {	
		
		if(consignacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((consignacion.getIsDeleted() || (consignacion.getIsChanged()&&!consignacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=consignacionDataAccess.getSetVersionRowConsignacion(connexion,consignacion.getId());
			
			try {							
				if(!consignacion.getVersionRow().equals(timestamp)) {	
					consignacion.setVersionRow(timestamp);
				}
				
				consignacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowConsignacionsWithConnection()throws Exception {	
		if(consignacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Consignacion consignacionAux:consignacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(consignacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(consignacionAux.getIsDeleted() || (consignacionAux.getIsChanged()&&!consignacionAux.getIsNew())) {
						
						timestamp=consignacionDataAccess.getSetVersionRowConsignacion(connexion,consignacionAux.getId());
						
						if(!consignacion.getVersionRow().equals(timestamp)) {	
							consignacionAux.setVersionRow(timestamp);
						}
								
						consignacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowConsignacions()throws Exception {	
		if(consignacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Consignacion consignacionAux:consignacions) {
					if(consignacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(consignacionAux.getIsDeleted() || (consignacionAux.getIsChanged()&&!consignacionAux.getIsNew())) {
						
						timestamp=consignacionDataAccess.getSetVersionRowConsignacion(connexion,consignacionAux.getId());
						
						if(!consignacionAux.getVersionRow().equals(timestamp)) {	
							consignacionAux.setVersionRow(timestamp);
						}
						
													
						consignacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ConsignacionParameterReturnGeneral cargarCombosLoteForeignKeyConsignacionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoPrecio,String finalQueryGlobalFormato,String finalQueryGlobalCliente,String finalQueryGlobalSubCliente,String finalQueryGlobalConsignatario,String finalQueryGlobalVendedor,String finalQueryGlobalEstadoPedido,String finalQueryGlobalTipoCambio,String finalQueryGlobalZona,String finalQueryGlobalCentroCosto,String finalQueryGlobalResponsable,String finalQueryGlobalTransportista,String finalQueryGlobalTransporte) throws Exception {
		ConsignacionParameterReturnGeneral  consignacionReturnGeneral =new ConsignacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-cargarCombosLoteForeignKeyConsignacionWithConnection");connexion.begin();
			
			consignacionReturnGeneral =new ConsignacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			consignacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			consignacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			consignacionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			consignacionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			consignacionReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			consignacionReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			consignacionReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			consignacionReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			consignacionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			consignacionReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			consignacionReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			consignacionReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			consignacionReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<Consignatario> consignatariosForeignKey=new ArrayList<Consignatario>();
			ConsignatarioLogic consignatarioLogic=new ConsignatarioLogic();
			consignatarioLogic.setConnexion(this.connexion);
			consignatarioLogic.getConsignatarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsignatario.equals("NONE")) {
				consignatarioLogic.getTodosConsignatarios(finalQueryGlobalConsignatario,new Pagination());
				consignatariosForeignKey=consignatarioLogic.getConsignatarios();
			}

			consignacionReturnGeneral.setconsignatariosForeignKey(consignatariosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			consignacionReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<EstadoPedido> estadopedidosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoLogic=new EstadoPedidoLogic();
			estadopedidoLogic.setConnexion(this.connexion);
			estadopedidoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedido.equals("NONE")) {
				estadopedidoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedido,new Pagination());
				estadopedidosForeignKey=estadopedidoLogic.getEstadoPedidos();
			}

			consignacionReturnGeneral.setestadopedidosForeignKey(estadopedidosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			consignacionReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			consignacionReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			consignacionReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			consignacionReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			consignacionReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			consignacionReturnGeneral.settransportesForeignKey(transportesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return consignacionReturnGeneral;
	}
	
	public ConsignacionParameterReturnGeneral cargarCombosLoteForeignKeyConsignacion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoPrecio,String finalQueryGlobalFormato,String finalQueryGlobalCliente,String finalQueryGlobalSubCliente,String finalQueryGlobalConsignatario,String finalQueryGlobalVendedor,String finalQueryGlobalEstadoPedido,String finalQueryGlobalTipoCambio,String finalQueryGlobalZona,String finalQueryGlobalCentroCosto,String finalQueryGlobalResponsable,String finalQueryGlobalTransportista,String finalQueryGlobalTransporte) throws Exception {
		ConsignacionParameterReturnGeneral  consignacionReturnGeneral =new ConsignacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			consignacionReturnGeneral =new ConsignacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			consignacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			consignacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			consignacionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			consignacionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			consignacionReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			consignacionReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			consignacionReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			consignacionReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			consignacionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			consignacionReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			consignacionReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			consignacionReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			consignacionReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<Consignatario> consignatariosForeignKey=new ArrayList<Consignatario>();
			ConsignatarioLogic consignatarioLogic=new ConsignatarioLogic();
			consignatarioLogic.setConnexion(this.connexion);
			consignatarioLogic.getConsignatarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsignatario.equals("NONE")) {
				consignatarioLogic.getTodosConsignatarios(finalQueryGlobalConsignatario,new Pagination());
				consignatariosForeignKey=consignatarioLogic.getConsignatarios();
			}

			consignacionReturnGeneral.setconsignatariosForeignKey(consignatariosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			consignacionReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<EstadoPedido> estadopedidosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoLogic=new EstadoPedidoLogic();
			estadopedidoLogic.setConnexion(this.connexion);
			estadopedidoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedido.equals("NONE")) {
				estadopedidoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedido,new Pagination());
				estadopedidosForeignKey=estadopedidoLogic.getEstadoPedidos();
			}

			consignacionReturnGeneral.setestadopedidosForeignKey(estadopedidosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			consignacionReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			consignacionReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			consignacionReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			consignacionReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			consignacionReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			consignacionReturnGeneral.settransportesForeignKey(transportesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return consignacionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyConsignacionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleConsignacionLogic detalleconsignacionLogic=new DetalleConsignacionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyConsignacionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleConsignacion.class));
											
			

			detalleconsignacionLogic.setConnexion(this.getConnexion());
			detalleconsignacionLogic.setDatosCliente(this.datosCliente);
			detalleconsignacionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Consignacion consignacion:this.consignacions) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleConsignacionConstantesFunciones.getClassesForeignKeysOfDetalleConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleconsignacionLogic.setDetalleConsignacions(consignacion.detalleconsignacions);
				detalleconsignacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Consignacion consignacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConsignacionLogicAdditional.updateConsignacionToGet(consignacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consignacion.setEmpresa(consignacionDataAccess.getEmpresa(connexion,consignacion));
		consignacion.setSucursal(consignacionDataAccess.getSucursal(connexion,consignacion));
		consignacion.setEjercicio(consignacionDataAccess.getEjercicio(connexion,consignacion));
		consignacion.setPeriodo(consignacionDataAccess.getPeriodo(connexion,consignacion));
		consignacion.setAnio(consignacionDataAccess.getAnio(connexion,consignacion));
		consignacion.setMes(consignacionDataAccess.getMes(connexion,consignacion));
		consignacion.setUsuario(consignacionDataAccess.getUsuario(connexion,consignacion));
		consignacion.setMoneda(consignacionDataAccess.getMoneda(connexion,consignacion));
		consignacion.setEmpleado(consignacionDataAccess.getEmpleado(connexion,consignacion));
		consignacion.setTipoPrecio(consignacionDataAccess.getTipoPrecio(connexion,consignacion));
		consignacion.setFormato(consignacionDataAccess.getFormato(connexion,consignacion));
		consignacion.setCliente(consignacionDataAccess.getCliente(connexion,consignacion));
		consignacion.setSubCliente(consignacionDataAccess.getSubCliente(connexion,consignacion));
		consignacion.setConsignatario(consignacionDataAccess.getConsignatario(connexion,consignacion));
		consignacion.setVendedor(consignacionDataAccess.getVendedor(connexion,consignacion));
		consignacion.setEstadoPedido(consignacionDataAccess.getEstadoPedido(connexion,consignacion));
		consignacion.setTipoCambio(consignacionDataAccess.getTipoCambio(connexion,consignacion));
		consignacion.setZona(consignacionDataAccess.getZona(connexion,consignacion));
		consignacion.setCentroCosto(consignacionDataAccess.getCentroCosto(connexion,consignacion));
		consignacion.setResponsable(consignacionDataAccess.getResponsable(connexion,consignacion));
		consignacion.setTransportista(consignacionDataAccess.getTransportista(connexion,consignacion));
		consignacion.setTransporte(consignacionDataAccess.getTransporte(connexion,consignacion));
		consignacion.setDetalleConsignacions(consignacionDataAccess.getDetalleConsignacions(connexion,consignacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consignacion.setEmpresa(consignacionDataAccess.getEmpresa(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				consignacion.setSucursal(consignacionDataAccess.getSucursal(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				consignacion.setEjercicio(consignacionDataAccess.getEjercicio(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				consignacion.setPeriodo(consignacionDataAccess.getPeriodo(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				consignacion.setAnio(consignacionDataAccess.getAnio(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				consignacion.setMes(consignacionDataAccess.getMes(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				consignacion.setUsuario(consignacionDataAccess.getUsuario(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				consignacion.setMoneda(consignacionDataAccess.getMoneda(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				consignacion.setEmpleado(consignacionDataAccess.getEmpleado(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				consignacion.setTipoPrecio(consignacionDataAccess.getTipoPrecio(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				consignacion.setFormato(consignacionDataAccess.getFormato(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				consignacion.setCliente(consignacionDataAccess.getCliente(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				consignacion.setSubCliente(consignacionDataAccess.getSubCliente(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				consignacion.setConsignatario(consignacionDataAccess.getConsignatario(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				consignacion.setVendedor(consignacionDataAccess.getVendedor(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				consignacion.setEstadoPedido(consignacionDataAccess.getEstadoPedido(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				consignacion.setTipoCambio(consignacionDataAccess.getTipoCambio(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				consignacion.setZona(consignacionDataAccess.getZona(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				consignacion.setCentroCosto(consignacionDataAccess.getCentroCosto(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				consignacion.setResponsable(consignacionDataAccess.getResponsable(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				consignacion.setTransportista(consignacionDataAccess.getTransportista(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				consignacion.setTransporte(consignacionDataAccess.getTransporte(connexion,consignacion));
				continue;
			}

			if(clas.clas.equals(DetalleConsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consignacion.setDetalleConsignacions(consignacionDataAccess.getDetalleConsignacions(connexion,consignacion));

				if(this.isConDeep) {
					DetalleConsignacionLogic detalleconsignacionLogic= new DetalleConsignacionLogic(this.connexion);
					detalleconsignacionLogic.setDetalleConsignacions(consignacion.getDetalleConsignacions());
					ArrayList<Classe> classesLocal=DetalleConsignacionConstantesFunciones.getClassesForeignKeysOfDetalleConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleconsignacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(detalleconsignacionLogic.getDetalleConsignacions());
					consignacion.setDetalleConsignacions(detalleconsignacionLogic.getDetalleConsignacions());
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
			consignacion.setEmpresa(consignacionDataAccess.getEmpresa(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setSucursal(consignacionDataAccess.getSucursal(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setEjercicio(consignacionDataAccess.getEjercicio(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setPeriodo(consignacionDataAccess.getPeriodo(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setAnio(consignacionDataAccess.getAnio(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setMes(consignacionDataAccess.getMes(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setUsuario(consignacionDataAccess.getUsuario(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setMoneda(consignacionDataAccess.getMoneda(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setEmpleado(consignacionDataAccess.getEmpleado(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setTipoPrecio(consignacionDataAccess.getTipoPrecio(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setFormato(consignacionDataAccess.getFormato(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setCliente(consignacionDataAccess.getCliente(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setSubCliente(consignacionDataAccess.getSubCliente(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignatario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setConsignatario(consignacionDataAccess.getConsignatario(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setVendedor(consignacionDataAccess.getVendedor(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setEstadoPedido(consignacionDataAccess.getEstadoPedido(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setTipoCambio(consignacionDataAccess.getTipoCambio(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setZona(consignacionDataAccess.getZona(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setCentroCosto(consignacionDataAccess.getCentroCosto(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setResponsable(consignacionDataAccess.getResponsable(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setTransportista(consignacionDataAccess.getTransportista(connexion,consignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setTransporte(consignacionDataAccess.getTransporte(connexion,consignacion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleConsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleConsignacion.class));
			consignacion.setDetalleConsignacions(consignacionDataAccess.getDetalleConsignacions(connexion,consignacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consignacion.setEmpresa(consignacionDataAccess.getEmpresa(connexion,consignacion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(consignacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		consignacion.setSucursal(consignacionDataAccess.getSucursal(connexion,consignacion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(consignacion.getSucursal(),isDeep,deepLoadType,clases);
				
		consignacion.setEjercicio(consignacionDataAccess.getEjercicio(connexion,consignacion));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(consignacion.getEjercicio(),isDeep,deepLoadType,clases);
				
		consignacion.setPeriodo(consignacionDataAccess.getPeriodo(connexion,consignacion));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(consignacion.getPeriodo(),isDeep,deepLoadType,clases);
				
		consignacion.setAnio(consignacionDataAccess.getAnio(connexion,consignacion));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(consignacion.getAnio(),isDeep,deepLoadType,clases);
				
		consignacion.setMes(consignacionDataAccess.getMes(connexion,consignacion));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(consignacion.getMes(),isDeep,deepLoadType,clases);
				
		consignacion.setUsuario(consignacionDataAccess.getUsuario(connexion,consignacion));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(consignacion.getUsuario(),isDeep,deepLoadType,clases);
				
		consignacion.setMoneda(consignacionDataAccess.getMoneda(connexion,consignacion));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(consignacion.getMoneda(),isDeep,deepLoadType,clases);
				
		consignacion.setEmpleado(consignacionDataAccess.getEmpleado(connexion,consignacion));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(consignacion.getEmpleado(),isDeep,deepLoadType,clases);
				
		consignacion.setTipoPrecio(consignacionDataAccess.getTipoPrecio(connexion,consignacion));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(consignacion.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		consignacion.setFormato(consignacionDataAccess.getFormato(connexion,consignacion));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(consignacion.getFormato(),isDeep,deepLoadType,clases);
				
		consignacion.setCliente(consignacionDataAccess.getCliente(connexion,consignacion));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(consignacion.getCliente(),isDeep,deepLoadType,clases);
				
		consignacion.setSubCliente(consignacionDataAccess.getSubCliente(connexion,consignacion));
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(consignacion.getSubCliente(),isDeep,deepLoadType,clases);
				
		consignacion.setConsignatario(consignacionDataAccess.getConsignatario(connexion,consignacion));
		ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
		consignatarioLogic.deepLoad(consignacion.getConsignatario(),isDeep,deepLoadType,clases);
				
		consignacion.setVendedor(consignacionDataAccess.getVendedor(connexion,consignacion));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(consignacion.getVendedor(),isDeep,deepLoadType,clases);
				
		consignacion.setEstadoPedido(consignacionDataAccess.getEstadoPedido(connexion,consignacion));
		EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
		estadopedidoLogic.deepLoad(consignacion.getEstadoPedido(),isDeep,deepLoadType,clases);
				
		consignacion.setTipoCambio(consignacionDataAccess.getTipoCambio(connexion,consignacion));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(consignacion.getTipoCambio(),isDeep,deepLoadType,clases);
				
		consignacion.setZona(consignacionDataAccess.getZona(connexion,consignacion));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(consignacion.getZona(),isDeep,deepLoadType,clases);
				
		consignacion.setCentroCosto(consignacionDataAccess.getCentroCosto(connexion,consignacion));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(consignacion.getCentroCosto(),isDeep,deepLoadType,clases);
				
		consignacion.setResponsable(consignacionDataAccess.getResponsable(connexion,consignacion));
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(consignacion.getResponsable(),isDeep,deepLoadType,clases);
				
		consignacion.setTransportista(consignacionDataAccess.getTransportista(connexion,consignacion));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(consignacion.getTransportista(),isDeep,deepLoadType,clases);
				
		consignacion.setTransporte(consignacionDataAccess.getTransporte(connexion,consignacion));
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(consignacion.getTransporte(),isDeep,deepLoadType,clases);
				

		consignacion.setDetalleConsignacions(consignacionDataAccess.getDetalleConsignacions(connexion,consignacion));

		for(DetalleConsignacion detalleconsignacion:consignacion.getDetalleConsignacions()) {
			DetalleConsignacionLogic detalleconsignacionLogic= new DetalleConsignacionLogic(connexion);
			detalleconsignacionLogic.deepLoad(detalleconsignacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consignacion.setEmpresa(consignacionDataAccess.getEmpresa(connexion,consignacion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(consignacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				consignacion.setSucursal(consignacionDataAccess.getSucursal(connexion,consignacion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(consignacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				consignacion.setEjercicio(consignacionDataAccess.getEjercicio(connexion,consignacion));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(consignacion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				consignacion.setPeriodo(consignacionDataAccess.getPeriodo(connexion,consignacion));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(consignacion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				consignacion.setAnio(consignacionDataAccess.getAnio(connexion,consignacion));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(consignacion.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				consignacion.setMes(consignacionDataAccess.getMes(connexion,consignacion));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(consignacion.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				consignacion.setUsuario(consignacionDataAccess.getUsuario(connexion,consignacion));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(consignacion.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				consignacion.setMoneda(consignacionDataAccess.getMoneda(connexion,consignacion));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(consignacion.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				consignacion.setEmpleado(consignacionDataAccess.getEmpleado(connexion,consignacion));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(consignacion.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				consignacion.setTipoPrecio(consignacionDataAccess.getTipoPrecio(connexion,consignacion));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(consignacion.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				consignacion.setFormato(consignacionDataAccess.getFormato(connexion,consignacion));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(consignacion.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				consignacion.setCliente(consignacionDataAccess.getCliente(connexion,consignacion));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(consignacion.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				consignacion.setSubCliente(consignacionDataAccess.getSubCliente(connexion,consignacion));
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(consignacion.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				consignacion.setConsignatario(consignacionDataAccess.getConsignatario(connexion,consignacion));
				ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
				consignatarioLogic.deepLoad(consignacion.getConsignatario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				consignacion.setVendedor(consignacionDataAccess.getVendedor(connexion,consignacion));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(consignacion.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				consignacion.setEstadoPedido(consignacionDataAccess.getEstadoPedido(connexion,consignacion));
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepLoad(consignacion.getEstadoPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				consignacion.setTipoCambio(consignacionDataAccess.getTipoCambio(connexion,consignacion));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(consignacion.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				consignacion.setZona(consignacionDataAccess.getZona(connexion,consignacion));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(consignacion.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				consignacion.setCentroCosto(consignacionDataAccess.getCentroCosto(connexion,consignacion));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(consignacion.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				consignacion.setResponsable(consignacionDataAccess.getResponsable(connexion,consignacion));
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepLoad(consignacion.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				consignacion.setTransportista(consignacionDataAccess.getTransportista(connexion,consignacion));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(consignacion.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				consignacion.setTransporte(consignacionDataAccess.getTransporte(connexion,consignacion));
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepLoad(consignacion.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleConsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consignacion.setDetalleConsignacions(consignacionDataAccess.getDetalleConsignacions(connexion,consignacion));

				for(DetalleConsignacion detalleconsignacion:consignacion.getDetalleConsignacions()) {
					DetalleConsignacionLogic detalleconsignacionLogic= new DetalleConsignacionLogic(connexion);
					detalleconsignacionLogic.deepLoad(detalleconsignacion,isDeep,deepLoadType,clases);
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
			consignacion.setEmpresa(consignacionDataAccess.getEmpresa(connexion,consignacion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(consignacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setSucursal(consignacionDataAccess.getSucursal(connexion,consignacion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(consignacion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setEjercicio(consignacionDataAccess.getEjercicio(connexion,consignacion));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(consignacion.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setPeriodo(consignacionDataAccess.getPeriodo(connexion,consignacion));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(consignacion.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setAnio(consignacionDataAccess.getAnio(connexion,consignacion));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(consignacion.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setMes(consignacionDataAccess.getMes(connexion,consignacion));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(consignacion.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setUsuario(consignacionDataAccess.getUsuario(connexion,consignacion));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(consignacion.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setMoneda(consignacionDataAccess.getMoneda(connexion,consignacion));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(consignacion.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setEmpleado(consignacionDataAccess.getEmpleado(connexion,consignacion));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(consignacion.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setTipoPrecio(consignacionDataAccess.getTipoPrecio(connexion,consignacion));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(consignacion.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setFormato(consignacionDataAccess.getFormato(connexion,consignacion));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(consignacion.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setCliente(consignacionDataAccess.getCliente(connexion,consignacion));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(consignacion.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setSubCliente(consignacionDataAccess.getSubCliente(connexion,consignacion));
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(consignacion.getSubCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Consignatario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setConsignatario(consignacionDataAccess.getConsignatario(connexion,consignacion));
			ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
			consignatarioLogic.deepLoad(consignacion.getConsignatario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setVendedor(consignacionDataAccess.getVendedor(connexion,consignacion));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(consignacion.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setEstadoPedido(consignacionDataAccess.getEstadoPedido(connexion,consignacion));
			EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
			estadopedidoLogic.deepLoad(consignacion.getEstadoPedido(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setTipoCambio(consignacionDataAccess.getTipoCambio(connexion,consignacion));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(consignacion.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setZona(consignacionDataAccess.getZona(connexion,consignacion));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(consignacion.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setCentroCosto(consignacionDataAccess.getCentroCosto(connexion,consignacion));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(consignacion.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setResponsable(consignacionDataAccess.getResponsable(connexion,consignacion));
			ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
			responsableLogic.deepLoad(consignacion.getResponsable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setTransportista(consignacionDataAccess.getTransportista(connexion,consignacion));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(consignacion.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignacion.setTransporte(consignacionDataAccess.getTransporte(connexion,consignacion));
			TransporteLogic transporteLogic= new TransporteLogic(connexion);
			transporteLogic.deepLoad(consignacion.getTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleConsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleConsignacion.class));
			consignacion.setDetalleConsignacions(consignacionDataAccess.getDetalleConsignacions(connexion,consignacion));

			for(DetalleConsignacion detalleconsignacion:consignacion.getDetalleConsignacions()) {
				DetalleConsignacionLogic detalleconsignacionLogic= new DetalleConsignacionLogic(connexion);
				detalleconsignacionLogic.deepLoad(detalleconsignacion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Consignacion consignacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ConsignacionLogicAdditional.updateConsignacionToSave(consignacion,this.arrDatoGeneral);
			
ConsignacionDataAccess.save(consignacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(consignacion.getEmpresa(),connexion);

		SucursalDataAccess.save(consignacion.getSucursal(),connexion);

		EjercicioDataAccess.save(consignacion.getEjercicio(),connexion);

		PeriodoDataAccess.save(consignacion.getPeriodo(),connexion);

		AnioDataAccess.save(consignacion.getAnio(),connexion);

		MesDataAccess.save(consignacion.getMes(),connexion);

		UsuarioDataAccess.save(consignacion.getUsuario(),connexion);

		MonedaDataAccess.save(consignacion.getMoneda(),connexion);

		EmpleadoDataAccess.save(consignacion.getEmpleado(),connexion);

		TipoPrecioDataAccess.save(consignacion.getTipoPrecio(),connexion);

		FormatoDataAccess.save(consignacion.getFormato(),connexion);

		ClienteDataAccess.save(consignacion.getCliente(),connexion);

		SubClienteDataAccess.save(consignacion.getSubCliente(),connexion);

		ConsignatarioDataAccess.save(consignacion.getConsignatario(),connexion);

		VendedorDataAccess.save(consignacion.getVendedor(),connexion);

		EstadoPedidoDataAccess.save(consignacion.getEstadoPedido(),connexion);

		TipoCambioDataAccess.save(consignacion.getTipoCambio(),connexion);

		ZonaDataAccess.save(consignacion.getZona(),connexion);

		CentroCostoDataAccess.save(consignacion.getCentroCosto(),connexion);

		ResponsableDataAccess.save(consignacion.getResponsable(),connexion);

		TransportistaDataAccess.save(consignacion.getTransportista(),connexion);

		TransporteDataAccess.save(consignacion.getTransporte(),connexion);

		for(DetalleConsignacion detalleconsignacion:consignacion.getDetalleConsignacions()) {
			detalleconsignacion.setid_consignacion(consignacion.getId());
			DetalleConsignacionDataAccess.save(detalleconsignacion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(consignacion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(consignacion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(consignacion.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(consignacion.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(consignacion.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(consignacion.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(consignacion.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(consignacion.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(consignacion.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(consignacion.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(consignacion.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(consignacion.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(consignacion.getSubCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				ConsignatarioDataAccess.save(consignacion.getConsignatario(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(consignacion.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(consignacion.getEstadoPedido(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(consignacion.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(consignacion.getZona(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(consignacion.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(consignacion.getResponsable(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(consignacion.getTransportista(),connexion);
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(consignacion.getTransporte(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleConsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleConsignacion detalleconsignacion:consignacion.getDetalleConsignacions()) {
					detalleconsignacion.setid_consignacion(consignacion.getId());
					DetalleConsignacionDataAccess.save(detalleconsignacion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(consignacion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(consignacion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(consignacion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(consignacion.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(consignacion.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(consignacion.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(consignacion.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(consignacion.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(consignacion.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(consignacion.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(consignacion.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(consignacion.getMes(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(consignacion.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(consignacion.getUsuario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(consignacion.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(consignacion.getMoneda(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(consignacion.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(consignacion.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(consignacion.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(consignacion.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(consignacion.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(consignacion.getFormato(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(consignacion.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(consignacion.getCliente(),isDeep,deepLoadType,clases);
				

		SubClienteDataAccess.save(consignacion.getSubCliente(),connexion);
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(consignacion.getSubCliente(),isDeep,deepLoadType,clases);
				

		ConsignatarioDataAccess.save(consignacion.getConsignatario(),connexion);
		ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
		consignatarioLogic.deepLoad(consignacion.getConsignatario(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(consignacion.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(consignacion.getVendedor(),isDeep,deepLoadType,clases);
				

		EstadoPedidoDataAccess.save(consignacion.getEstadoPedido(),connexion);
		EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
		estadopedidoLogic.deepLoad(consignacion.getEstadoPedido(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(consignacion.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(consignacion.getTipoCambio(),isDeep,deepLoadType,clases);
				

		ZonaDataAccess.save(consignacion.getZona(),connexion);
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(consignacion.getZona(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(consignacion.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(consignacion.getCentroCosto(),isDeep,deepLoadType,clases);
				

		ResponsableDataAccess.save(consignacion.getResponsable(),connexion);
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(consignacion.getResponsable(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(consignacion.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(consignacion.getTransportista(),isDeep,deepLoadType,clases);
				

		TransporteDataAccess.save(consignacion.getTransporte(),connexion);
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(consignacion.getTransporte(),isDeep,deepLoadType,clases);
				

		for(DetalleConsignacion detalleconsignacion:consignacion.getDetalleConsignacions()) {
			DetalleConsignacionLogic detalleconsignacionLogic= new DetalleConsignacionLogic(connexion);
			detalleconsignacion.setid_consignacion(consignacion.getId());
			DetalleConsignacionDataAccess.save(detalleconsignacion,connexion);
			detalleconsignacionLogic.deepSave(detalleconsignacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(consignacion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(consignacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(consignacion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(consignacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(consignacion.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(consignacion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(consignacion.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(consignacion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(consignacion.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(consignacion.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(consignacion.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(consignacion.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(consignacion.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(consignacion.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(consignacion.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(consignacion.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(consignacion.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(consignacion.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(consignacion.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(consignacion.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(consignacion.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(consignacion.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(consignacion.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(consignacion.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(consignacion.getSubCliente(),connexion);
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepSave(consignacion.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				ConsignatarioDataAccess.save(consignacion.getConsignatario(),connexion);
				ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
				consignatarioLogic.deepSave(consignacion.getConsignatario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(consignacion.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(consignacion.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(consignacion.getEstadoPedido(),connexion);
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepSave(consignacion.getEstadoPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(consignacion.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(consignacion.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(consignacion.getZona(),connexion);
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepSave(consignacion.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(consignacion.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(consignacion.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(consignacion.getResponsable(),connexion);
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepSave(consignacion.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(consignacion.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(consignacion.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(consignacion.getTransporte(),connexion);
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepSave(consignacion.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleConsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleConsignacion detalleconsignacion:consignacion.getDetalleConsignacions()) {
					DetalleConsignacionLogic detalleconsignacionLogic= new DetalleConsignacionLogic(connexion);
					detalleconsignacion.setid_consignacion(consignacion.getId());
					DetalleConsignacionDataAccess.save(detalleconsignacion,connexion);
					detalleconsignacionLogic.deepSave(detalleconsignacion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Consignacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(consignacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(consignacion);
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
			this.deepLoad(this.consignacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Consignacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(consignacions!=null) {
				for(Consignacion consignacion:consignacions) {
					this.deepLoad(consignacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(consignacions);
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
			if(consignacions!=null) {
				for(Consignacion consignacion:consignacions) {
					this.deepLoad(consignacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(consignacions);
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
			this.getNewConnexionToDeep(Consignacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(consignacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Consignacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(consignacions!=null) {
				for(Consignacion consignacion:consignacions) {
					this.deepSave(consignacion,isDeep,deepLoadType,clases);
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
			if(consignacions!=null) {
				for(Consignacion consignacion:consignacions) {
					this.deepSave(consignacion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getConsignacionsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ConsignacionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ConsignacionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,ConsignacionConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,ConsignacionConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ConsignacionConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ConsignacionConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdConsignatarioWithConnection(String sFinalQuery,Pagination pagination,Long id_consignatario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsignatario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsignatario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consignatario,ConsignacionConstantesFunciones.IDCONSIGNATARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsignatario);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsignatario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdConsignatario(String sFinalQuery,Pagination pagination,Long id_consignatario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsignatario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsignatario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consignatario,ConsignacionConstantesFunciones.IDCONSIGNATARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsignatario);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsignatario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ConsignacionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ConsignacionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ConsignacionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ConsignacionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConsignacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConsignacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdEstadoPedidoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido,ConsignacionConstantesFunciones.IDESTADOPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedido);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdEstadoPedido(String sFinalQuery,Pagination pagination,Long id_estado_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido,ConsignacionConstantesFunciones.IDESTADOPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedido);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,ConsignacionConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,ConsignacionConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ConsignacionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ConsignacionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ConsignacionConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ConsignacionConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ConsignacionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ConsignacionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdResponsableWithConnection(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,ConsignacionConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdResponsable(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,ConsignacionConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdSubClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,ConsignacionConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdSubCliente(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,ConsignacionConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ConsignacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ConsignacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,ConsignacionConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,ConsignacionConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,ConsignacionConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,ConsignacionConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,ConsignacionConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdTransporte(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,ConsignacionConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,ConsignacionConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,ConsignacionConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ConsignacionConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ConsignacionConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ConsignacionConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ConsignacionConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignacionsFK_IdZonaWithConnection(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,ConsignacionConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignacionsFK_IdZona(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,ConsignacionConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			ConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(this.consignacions);
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
			if(ConsignacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsignacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Consignacion consignacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ConsignacionConstantesFunciones.ISCONAUDITORIA) {
				if(consignacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsignacionDataAccess.TABLENAME, consignacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConsignacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConsignacionLogic.registrarAuditoriaDetallesConsignacion(connexion,consignacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(consignacion.getIsDeleted()) {
					/*if(!consignacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ConsignacionDataAccess.TABLENAME, consignacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ConsignacionLogic.registrarAuditoriaDetallesConsignacion(connexion,consignacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsignacionDataAccess.TABLENAME, consignacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(consignacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsignacionDataAccess.TABLENAME, consignacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConsignacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConsignacionLogic.registrarAuditoriaDetallesConsignacion(connexion,consignacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesConsignacion(Connexion connexion,Consignacion consignacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(consignacion.getIsNew()||!consignacion.getid_empresa().equals(consignacion.getConsignacionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_empresa()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_empresa().toString();
				}
				if(consignacion.getid_empresa()!=null)
				{
					strValorNuevo=consignacion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_sucursal().equals(consignacion.getConsignacionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_sucursal()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_sucursal().toString();
				}
				if(consignacion.getid_sucursal()!=null)
				{
					strValorNuevo=consignacion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_ejercicio().equals(consignacion.getConsignacionOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_ejercicio()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_ejercicio().toString();
				}
				if(consignacion.getid_ejercicio()!=null)
				{
					strValorNuevo=consignacion.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_periodo().equals(consignacion.getConsignacionOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_periodo()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_periodo().toString();
				}
				if(consignacion.getid_periodo()!=null)
				{
					strValorNuevo=consignacion.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_anio().equals(consignacion.getConsignacionOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_anio()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_anio().toString();
				}
				if(consignacion.getid_anio()!=null)
				{
					strValorNuevo=consignacion.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_mes().equals(consignacion.getConsignacionOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_mes()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_mes().toString();
				}
				if(consignacion.getid_mes()!=null)
				{
					strValorNuevo=consignacion.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_usuario().equals(consignacion.getConsignacionOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_usuario()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_usuario().toString();
				}
				if(consignacion.getid_usuario()!=null)
				{
					strValorNuevo=consignacion.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getnumero().equals(consignacion.getConsignacionOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getnumero()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getnumero();
				}
				if(consignacion.getnumero()!=null)
				{
					strValorNuevo=consignacion.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getnumero_autorizacion().equals(consignacion.getConsignacionOriginal().getnumero_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getnumero_autorizacion()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getnumero_autorizacion();
				}
				if(consignacion.getnumero_autorizacion()!=null)
				{
					strValorNuevo=consignacion.getnumero_autorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.NUMEROAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getfecha_emision().equals(consignacion.getConsignacionOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getfecha_emision()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getfecha_emision().toString();
				}
				if(consignacion.getfecha_emision()!=null)
				{
					strValorNuevo=consignacion.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getfecha_vencimiento().equals(consignacion.getConsignacionOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getfecha_vencimiento().toString();
				}
				if(consignacion.getfecha_vencimiento()!=null)
				{
					strValorNuevo=consignacion.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_moneda().equals(consignacion.getConsignacionOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_moneda()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_moneda().toString();
				}
				if(consignacion.getid_moneda()!=null)
				{
					strValorNuevo=consignacion.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getcotizacion().equals(consignacion.getConsignacionOriginal().getcotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getcotizacion()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getcotizacion().toString();
				}
				if(consignacion.getcotizacion()!=null)
				{
					strValorNuevo=consignacion.getcotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.COTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_empleado().equals(consignacion.getConsignacionOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_empleado()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_empleado().toString();
				}
				if(consignacion.getid_empleado()!=null)
				{
					strValorNuevo=consignacion.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_tipo_precio().equals(consignacion.getConsignacionOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_tipo_precio().toString();
				}
				if(consignacion.getid_tipo_precio()!=null)
				{
					strValorNuevo=consignacion.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_formato().equals(consignacion.getConsignacionOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_formato()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_formato().toString();
				}
				if(consignacion.getid_formato()!=null)
				{
					strValorNuevo=consignacion.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getdireccion().equals(consignacion.getConsignacionOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getdireccion()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getdireccion();
				}
				if(consignacion.getdireccion()!=null)
				{
					strValorNuevo=consignacion.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_cliente().equals(consignacion.getConsignacionOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_cliente()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_cliente().toString();
				}
				if(consignacion.getid_cliente()!=null)
				{
					strValorNuevo=consignacion.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.gettelefono().equals(consignacion.getConsignacionOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().gettelefono()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().gettelefono();
				}
				if(consignacion.gettelefono()!=null)
				{
					strValorNuevo=consignacion.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getruc().equals(consignacion.getConsignacionOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getruc()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getruc();
				}
				if(consignacion.getruc()!=null)
				{
					strValorNuevo=consignacion.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_sub_cliente().equals(consignacion.getConsignacionOriginal().getid_sub_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_sub_cliente()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_sub_cliente().toString();
				}
				if(consignacion.getid_sub_cliente()!=null)
				{
					strValorNuevo=consignacion.getid_sub_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDSUBCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_consignatario().equals(consignacion.getConsignacionOriginal().getid_consignatario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_consignatario()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_consignatario().toString();
				}
				if(consignacion.getid_consignatario()!=null)
				{
					strValorNuevo=consignacion.getid_consignatario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDCONSIGNATARIO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_vendedor().equals(consignacion.getConsignacionOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_vendedor()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_vendedor().toString();
				}
				if(consignacion.getid_vendedor()!=null)
				{
					strValorNuevo=consignacion.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getdescripcion().equals(consignacion.getConsignacionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getdescripcion()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getdescripcion();
				}
				if(consignacion.getdescripcion()!=null)
				{
					strValorNuevo=consignacion.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_estado_pedido().equals(consignacion.getConsignacionOriginal().getid_estado_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_estado_pedido()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_estado_pedido().toString();
				}
				if(consignacion.getid_estado_pedido()!=null)
				{
					strValorNuevo=consignacion.getid_estado_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDESTADOPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getdescuento_porcentaje().equals(consignacion.getConsignacionOriginal().getdescuento_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getdescuento_porcentaje()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getdescuento_porcentaje().toString();
				}
				if(consignacion.getdescuento_porcentaje()!=null)
				{
					strValorNuevo=consignacion.getdescuento_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.DESCUENTOPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.gettotal_con_iva().equals(consignacion.getConsignacionOriginal().gettotal_con_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().gettotal_con_iva()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().gettotal_con_iva().toString();
				}
				if(consignacion.gettotal_con_iva()!=null)
				{
					strValorNuevo=consignacion.gettotal_con_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.TOTALCONIVA,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getsuman().equals(consignacion.getConsignacionOriginal().getsuman()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getsuman()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getsuman().toString();
				}
				if(consignacion.getsuman()!=null)
				{
					strValorNuevo=consignacion.getsuman().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.SUMAN,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getdescuento_valor().equals(consignacion.getConsignacionOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getdescuento_valor()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getdescuento_valor().toString();
				}
				if(consignacion.getdescuento_valor()!=null)
				{
					strValorNuevo=consignacion.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.gettotal_sin_iva().equals(consignacion.getConsignacionOriginal().gettotal_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().gettotal_sin_iva()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().gettotal_sin_iva().toString();
				}
				if(consignacion.gettotal_sin_iva()!=null)
				{
					strValorNuevo=consignacion.gettotal_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.TOTALSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.gettotal_descuento().equals(consignacion.getConsignacionOriginal().gettotal_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().gettotal_descuento()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().gettotal_descuento().toString();
				}
				if(consignacion.gettotal_descuento()!=null)
				{
					strValorNuevo=consignacion.gettotal_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.TOTALDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getflete().equals(consignacion.getConsignacionOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getflete()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getflete().toString();
				}
				if(consignacion.getflete()!=null)
				{
					strValorNuevo=consignacion.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.gettotal().equals(consignacion.getConsignacionOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().gettotal()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().gettotal().toString();
				}
				if(consignacion.gettotal()!=null)
				{
					strValorNuevo=consignacion.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getsubtotal().equals(consignacion.getConsignacionOriginal().getsubtotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getsubtotal()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getsubtotal().toString();
				}
				if(consignacion.getsubtotal()!=null)
				{
					strValorNuevo=consignacion.getsubtotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getotro().equals(consignacion.getConsignacionOriginal().getotro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getotro()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getotro().toString();
				}
				if(consignacion.getotro()!=null)
				{
					strValorNuevo=consignacion.getotro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.OTRO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getfinanciamiento().equals(consignacion.getConsignacionOriginal().getfinanciamiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getfinanciamiento()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getfinanciamiento().toString();
				}
				if(consignacion.getfinanciamiento()!=null)
				{
					strValorNuevo=consignacion.getfinanciamiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.FINANCIAMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getiva().equals(consignacion.getConsignacionOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getiva()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getiva().toString();
				}
				if(consignacion.getiva()!=null)
				{
					strValorNuevo=consignacion.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getice().equals(consignacion.getConsignacionOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getice()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getice().toString();
				}
				if(consignacion.getice()!=null)
				{
					strValorNuevo=consignacion.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getmonto_retencion().equals(consignacion.getConsignacionOriginal().getmonto_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getmonto_retencion()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getmonto_retencion().toString();
				}
				if(consignacion.getmonto_retencion()!=null)
				{
					strValorNuevo=consignacion.getmonto_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.MONTORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_tipo_cambio().equals(consignacion.getConsignacionOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_tipo_cambio().toString();
				}
				if(consignacion.getid_tipo_cambio()!=null)
				{
					strValorNuevo=consignacion.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getnumero_fue().equals(consignacion.getConsignacionOriginal().getnumero_fue()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getnumero_fue()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getnumero_fue();
				}
				if(consignacion.getnumero_fue()!=null)
				{
					strValorNuevo=consignacion.getnumero_fue() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.NUMEROFUE,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_zona().equals(consignacion.getConsignacionOriginal().getid_zona()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_zona()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_zona().toString();
				}
				if(consignacion.getid_zona()!=null)
				{
					strValorNuevo=consignacion.getid_zona().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDZONA,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getfecha().equals(consignacion.getConsignacionOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getfecha()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getfecha().toString();
				}
				if(consignacion.getfecha()!=null)
				{
					strValorNuevo=consignacion.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_centro_costo().equals(consignacion.getConsignacionOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_centro_costo()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_centro_costo().toString();
				}
				if(consignacion.getid_centro_costo()!=null)
				{
					strValorNuevo=consignacion.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getfecha_servidor().equals(consignacion.getConsignacionOriginal().getfecha_servidor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getfecha_servidor()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getfecha_servidor().toString();
				}
				if(consignacion.getfecha_servidor()!=null)
				{
					strValorNuevo=consignacion.getfecha_servidor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.FECHASERVIDOR,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_responsable().equals(consignacion.getConsignacionOriginal().getid_responsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_responsable()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_responsable().toString();
				}
				if(consignacion.getid_responsable()!=null)
				{
					strValorNuevo=consignacion.getid_responsable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDRESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.gethora_inicio().equals(consignacion.getConsignacionOriginal().gethora_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().gethora_inicio()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().gethora_inicio().toString();
				}
				if(consignacion.gethora_inicio()!=null)
				{
					strValorNuevo=consignacion.gethora_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.HORAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.gethora_fin().equals(consignacion.getConsignacionOriginal().gethora_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().gethora_fin()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().gethora_fin().toString();
				}
				if(consignacion.gethora_fin()!=null)
				{
					strValorNuevo=consignacion.gethora_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.HORAFIN,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_transportista().equals(consignacion.getConsignacionOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_transportista()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_transportista().toString();
				}
				if(consignacion.getid_transportista()!=null)
				{
					strValorNuevo=consignacion.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
			
			if(consignacion.getIsNew()||!consignacion.getid_transporte().equals(consignacion.getConsignacionOriginal().getid_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignacion.getConsignacionOriginal().getid_transporte()!=null)
				{
					strValorActual=consignacion.getConsignacionOriginal().getid_transporte().toString();
				}
				if(consignacion.getid_transporte()!=null)
				{
					strValorNuevo=consignacion.getid_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignacionConstantesFunciones.IDTRANSPORTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveConsignacionRelacionesWithConnection(Consignacion consignacion,List<DetalleConsignacion> detalleconsignacions) throws Exception {

		if(!consignacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConsignacionRelacionesBase(consignacion,detalleconsignacions,true);
		}
	}

	public void saveConsignacionRelaciones(Consignacion consignacion,List<DetalleConsignacion> detalleconsignacions)throws Exception {

		if(!consignacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConsignacionRelacionesBase(consignacion,detalleconsignacions,false);
		}
	}

	public void saveConsignacionRelacionesBase(Consignacion consignacion,List<DetalleConsignacion> detalleconsignacions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Consignacion-saveRelacionesWithConnection");}
	
			consignacion.setDetalleConsignacions(detalleconsignacions);

			this.setConsignacion(consignacion);

			if(ConsignacionLogicAdditional.validarSaveRelaciones(consignacion,this)) {

				ConsignacionLogicAdditional.updateRelacionesToSave(consignacion,this);

				if((consignacion.getIsNew()||consignacion.getIsChanged())&&!consignacion.getIsDeleted()) {
					this.saveConsignacion();
					this.saveConsignacionRelacionesDetalles(detalleconsignacions);

				} else if(consignacion.getIsDeleted()) {
					this.saveConsignacionRelacionesDetalles(detalleconsignacions);
					this.saveConsignacion();
				}

				ConsignacionLogicAdditional.updateRelacionesToSaveAfter(consignacion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleConsignacionConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleConsignacions(detalleconsignacions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveConsignacionRelacionesDetalles(List<DetalleConsignacion> detalleconsignacions)throws Exception {
		try {
	

			Long idConsignacionActual=this.getConsignacion().getId();

			DetalleConsignacionLogic detalleconsignacionLogic_Desde_Consignacion=new DetalleConsignacionLogic();
			detalleconsignacionLogic_Desde_Consignacion.setDetalleConsignacions(detalleconsignacions);

			detalleconsignacionLogic_Desde_Consignacion.setConnexion(this.getConnexion());
			detalleconsignacionLogic_Desde_Consignacion.setDatosCliente(this.datosCliente);

			for(DetalleConsignacion detalleconsignacion_Desde_Consignacion:detalleconsignacionLogic_Desde_Consignacion.getDetalleConsignacions()) {
				detalleconsignacion_Desde_Consignacion.setid_consignacion(idConsignacionActual);
			}

			detalleconsignacionLogic_Desde_Consignacion.saveDetalleConsignacions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfConsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConsignacionConstantesFunciones.getClassesRelationshipsOfConsignacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
