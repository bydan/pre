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
import com.bydan.erp.facturacion.util.EstadoNotaCreditoConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoNotaCreditoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoNotaCreditoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.EstadoNotaCredito;
//import com.bydan.erp.facturacion.business.logic.EstadoNotaCreditoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoNotaCreditoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoNotaCreditoLogic.class);
	
	protected EstadoNotaCreditoDataAccess estadonotacreditoDataAccess; 	
	protected EstadoNotaCredito estadonotacredito;
	protected List<EstadoNotaCredito> estadonotacreditos;
	protected Object estadonotacreditoObject;	
	protected List<Object> estadonotacreditosObject;
	
	public static ClassValidator<EstadoNotaCredito> estadonotacreditoValidator = new ClassValidator<EstadoNotaCredito>(EstadoNotaCredito.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  EstadoNotaCreditoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadonotacreditoDataAccess = new EstadoNotaCreditoDataAccess();
			
			this.estadonotacreditos= new ArrayList<EstadoNotaCredito>();
			this.estadonotacredito= new EstadoNotaCredito();
			
			this.estadonotacreditoObject=new Object();
			this.estadonotacreditosObject=new ArrayList<Object>();
				
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
			
			this.estadonotacreditoDataAccess.setConnexionType(this.connexionType);
			this.estadonotacreditoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoNotaCreditoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadonotacreditoDataAccess = new EstadoNotaCreditoDataAccess();
			this.estadonotacreditos= new ArrayList<EstadoNotaCredito>();
			this.estadonotacredito= new EstadoNotaCredito();
			this.estadonotacreditoObject=new Object();
			this.estadonotacreditosObject=new ArrayList<Object>();
			
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
			
			this.estadonotacreditoDataAccess.setConnexionType(this.connexionType);
			this.estadonotacreditoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoNotaCredito getEstadoNotaCredito() throws Exception {	
		//EstadoNotaCreditoLogicAdditional.checkEstadoNotaCreditoToGet(estadonotacredito,this.datosCliente,this.arrDatoGeneral);
		//EstadoNotaCreditoLogicAdditional.updateEstadoNotaCreditoToGet(estadonotacredito,this.arrDatoGeneral);
		
		return estadonotacredito;
	}
		
	public void setEstadoNotaCredito(EstadoNotaCredito newEstadoNotaCredito) {
		this.estadonotacredito = newEstadoNotaCredito;
	}
	
	public EstadoNotaCreditoDataAccess getEstadoNotaCreditoDataAccess() {
		return estadonotacreditoDataAccess;
	}
	
	public void setEstadoNotaCreditoDataAccess(EstadoNotaCreditoDataAccess newestadonotacreditoDataAccess) {
		this.estadonotacreditoDataAccess = newestadonotacreditoDataAccess;
	}
	
	public List<EstadoNotaCredito> getEstadoNotaCreditos() throws Exception {		
		this.quitarEstadoNotaCreditosNulos();
		
		//EstadoNotaCreditoLogicAdditional.checkEstadoNotaCreditoToGets(estadonotacreditos,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoNotaCredito estadonotacreditoLocal: estadonotacreditos ) {
			//EstadoNotaCreditoLogicAdditional.updateEstadoNotaCreditoToGet(estadonotacreditoLocal,this.arrDatoGeneral);
		}
		
		return estadonotacreditos;
	}
	
	public void setEstadoNotaCreditos(List<EstadoNotaCredito> newEstadoNotaCreditos) {
		this.estadonotacreditos = newEstadoNotaCreditos;
	}
	
	public Object getEstadoNotaCreditoObject() {	
		this.estadonotacreditoObject=this.estadonotacreditoDataAccess.getEntityObject();
		return this.estadonotacreditoObject;
	}
		
	public void setEstadoNotaCreditoObject(Object newEstadoNotaCreditoObject) {
		this.estadonotacreditoObject = newEstadoNotaCreditoObject;
	}
	
	public List<Object> getEstadoNotaCreditosObject() {		
		this.estadonotacreditosObject=this.estadonotacreditoDataAccess.getEntitiesObject();
		return this.estadonotacreditosObject;
	}
		
	public void setEstadoNotaCreditosObject(List<Object> newEstadoNotaCreditosObject) {
		this.estadonotacreditosObject = newEstadoNotaCreditosObject;
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
		
		if(this.estadonotacreditoDataAccess!=null) {
			this.estadonotacreditoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadonotacreditoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadonotacreditoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadonotacredito = new  EstadoNotaCredito();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadonotacredito=estadonotacreditoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacredito);
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
		estadonotacredito = new  EstadoNotaCredito();
		  		  
        try {
			
			estadonotacredito=estadonotacreditoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadonotacredito = new  EstadoNotaCredito();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadonotacredito=estadonotacreditoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacredito);
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
		estadonotacredito = new  EstadoNotaCredito();
		  		  
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
		estadonotacredito = new  EstadoNotaCredito();
		  		  
        try {
			
			estadonotacredito=estadonotacreditoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadonotacredito = new  EstadoNotaCredito();
		  		  
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
		estadonotacredito = new  EstadoNotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadonotacreditoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadonotacredito = new  EstadoNotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadonotacreditoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadonotacredito = new  EstadoNotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadonotacreditoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadonotacredito = new  EstadoNotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadonotacreditoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadonotacredito = new  EstadoNotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadonotacreditoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadonotacredito = new  EstadoNotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadonotacreditoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadonotacreditos = new  ArrayList<EstadoNotaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonotacreditos=estadonotacreditoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoNotaCredito(estadonotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacreditos);
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
		estadonotacreditos = new  ArrayList<EstadoNotaCredito>();
		  		  
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
		estadonotacreditos = new  ArrayList<EstadoNotaCredito>();
		  		  
        try {			
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonotacreditos=estadonotacreditoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoNotaCredito(estadonotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacreditos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadonotacreditos = new  ArrayList<EstadoNotaCredito>();
		  		  
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
		estadonotacreditos = new  ArrayList<EstadoNotaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonotacreditos=estadonotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoNotaCredito(estadonotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacreditos);
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
		estadonotacreditos = new  ArrayList<EstadoNotaCredito>();
		  		  
        try {
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonotacreditos=estadonotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoNotaCredito(estadonotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacreditos);
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
		estadonotacreditos = new  ArrayList<EstadoNotaCredito>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonotacreditos=estadonotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNotaCredito(estadonotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacreditos);
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
		estadonotacreditos = new  ArrayList<EstadoNotaCredito>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonotacreditos=estadonotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNotaCredito(estadonotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacreditos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadonotacredito = new  EstadoNotaCredito();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonotacredito=estadonotacreditoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNotaCredito(estadonotacredito);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacredito);
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
		estadonotacredito = new  EstadoNotaCredito();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonotacredito=estadonotacreditoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNotaCredito(estadonotacredito);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoNotaCreditosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadonotacreditos = new  ArrayList<EstadoNotaCredito>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-getTodosEstadoNotaCreditosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonotacreditos=estadonotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoNotaCredito(estadonotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacreditos);
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
	
	public  void  getTodosEstadoNotaCreditos(String sFinalQuery,Pagination pagination)throws Exception {
		estadonotacreditos = new  ArrayList<EstadoNotaCredito>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonotacreditos=estadonotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoNotaCredito(estadonotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacreditos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoNotaCredito(EstadoNotaCredito estadonotacredito) throws Exception {
		Boolean estaValidado=false;
		
		if(estadonotacredito.getIsNew() || estadonotacredito.getIsChanged()) { 
			this.invalidValues = estadonotacreditoValidator.getInvalidValues(estadonotacredito);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadonotacredito);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoNotaCredito(List<EstadoNotaCredito> EstadoNotaCreditos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoNotaCredito estadonotacreditoLocal:estadonotacreditos) {				
			estaValidadoObjeto=this.validarGuardarEstadoNotaCredito(estadonotacreditoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoNotaCredito(List<EstadoNotaCredito> EstadoNotaCreditos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoNotaCredito(estadonotacreditos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoNotaCredito(EstadoNotaCredito EstadoNotaCredito) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoNotaCredito(estadonotacredito)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoNotaCredito estadonotacredito) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadonotacredito.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoNotaCreditoConstantesFunciones.getEstadoNotaCreditoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadonotacredito","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoNotaCreditoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoNotaCreditoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoNotaCreditoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-saveEstadoNotaCreditoWithConnection");connexion.begin();			
			
			//EstadoNotaCreditoLogicAdditional.checkEstadoNotaCreditoToSave(this.estadonotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoNotaCreditoLogicAdditional.updateEstadoNotaCreditoToSave(this.estadonotacredito,this.arrDatoGeneral);
			
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadonotacredito,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoNotaCredito();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoNotaCredito(this.estadonotacredito)) {
				EstadoNotaCreditoDataAccess.save(this.estadonotacredito, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadonotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoNotaCreditoLogicAdditional.checkEstadoNotaCreditoToSaveAfter(this.estadonotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoNotaCredito();
			
			connexion.commit();			
			
			if(this.estadonotacredito.getIsDeleted()) {
				this.estadonotacredito=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoNotaCredito()throws Exception {	
		try {	
			
			//EstadoNotaCreditoLogicAdditional.checkEstadoNotaCreditoToSave(this.estadonotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoNotaCreditoLogicAdditional.updateEstadoNotaCreditoToSave(this.estadonotacredito,this.arrDatoGeneral);
			
			EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadonotacredito,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoNotaCredito(this.estadonotacredito)) {			
				EstadoNotaCreditoDataAccess.save(this.estadonotacredito, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadonotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoNotaCreditoLogicAdditional.checkEstadoNotaCreditoToSaveAfter(this.estadonotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadonotacredito.getIsDeleted()) {
				this.estadonotacredito=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoNotaCreditosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-saveEstadoNotaCreditosWithConnection");connexion.begin();			
			
			//EstadoNotaCreditoLogicAdditional.checkEstadoNotaCreditoToSaves(estadonotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoNotaCreditos();
			
			Boolean validadoTodosEstadoNotaCredito=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoNotaCredito estadonotacreditoLocal:estadonotacreditos) {		
				if(estadonotacreditoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoNotaCreditoLogicAdditional.updateEstadoNotaCreditoToSave(estadonotacreditoLocal,this.arrDatoGeneral);
	        	
				EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadonotacreditoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoNotaCredito(estadonotacreditoLocal)) {
					EstadoNotaCreditoDataAccess.save(estadonotacreditoLocal, connexion);				
				} else {
					validadoTodosEstadoNotaCredito=false;
				}
			}
			
			if(!validadoTodosEstadoNotaCredito) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoNotaCreditoLogicAdditional.checkEstadoNotaCreditoToSavesAfter(estadonotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoNotaCreditos();
			
			connexion.commit();		
			
			this.quitarEstadoNotaCreditosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoNotaCreditos()throws Exception {				
		 try {	
			//EstadoNotaCreditoLogicAdditional.checkEstadoNotaCreditoToSaves(estadonotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoNotaCredito=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoNotaCredito estadonotacreditoLocal:estadonotacreditos) {				
				if(estadonotacreditoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoNotaCreditoLogicAdditional.updateEstadoNotaCreditoToSave(estadonotacreditoLocal,this.arrDatoGeneral);
	        	
				EstadoNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadonotacreditoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoNotaCredito(estadonotacreditoLocal)) {				
					EstadoNotaCreditoDataAccess.save(estadonotacreditoLocal, connexion);				
				} else {
					validadoTodosEstadoNotaCredito=false;
				}
			}
			
			if(!validadoTodosEstadoNotaCredito) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoNotaCreditoLogicAdditional.checkEstadoNotaCreditoToSavesAfter(estadonotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoNotaCreditosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoNotaCreditoParameterReturnGeneral procesarAccionEstadoNotaCreditos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoNotaCredito> estadonotacreditos,EstadoNotaCreditoParameterReturnGeneral estadonotacreditoParameterGeneral)throws Exception {
		 try {	
			EstadoNotaCreditoParameterReturnGeneral estadonotacreditoReturnGeneral=new EstadoNotaCreditoParameterReturnGeneral();
	
			
			return estadonotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoNotaCreditoParameterReturnGeneral procesarAccionEstadoNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoNotaCredito> estadonotacreditos,EstadoNotaCreditoParameterReturnGeneral estadonotacreditoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-procesarAccionEstadoNotaCreditosWithConnection");connexion.begin();			
			
			EstadoNotaCreditoParameterReturnGeneral estadonotacreditoReturnGeneral=new EstadoNotaCreditoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadonotacreditoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoNotaCreditoParameterReturnGeneral procesarEventosEstadoNotaCreditos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoNotaCredito> estadonotacreditos,EstadoNotaCredito estadonotacredito,EstadoNotaCreditoParameterReturnGeneral estadonotacreditoParameterGeneral,Boolean isEsNuevoEstadoNotaCredito,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoNotaCreditoParameterReturnGeneral estadonotacreditoReturnGeneral=new EstadoNotaCreditoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadonotacreditoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadonotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoNotaCreditoParameterReturnGeneral procesarEventosEstadoNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoNotaCredito> estadonotacreditos,EstadoNotaCredito estadonotacredito,EstadoNotaCreditoParameterReturnGeneral estadonotacreditoParameterGeneral,Boolean isEsNuevoEstadoNotaCredito,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-procesarEventosEstadoNotaCreditosWithConnection");connexion.begin();			
			
			EstadoNotaCreditoParameterReturnGeneral estadonotacreditoReturnGeneral=new EstadoNotaCreditoParameterReturnGeneral();
	
			estadonotacreditoReturnGeneral.setEstadoNotaCredito(estadonotacredito);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadonotacreditoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadonotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoNotaCreditoParameterReturnGeneral procesarImportacionEstadoNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoNotaCreditoParameterReturnGeneral estadonotacreditoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-procesarImportacionEstadoNotaCreditosWithConnection");connexion.begin();			
			
			EstadoNotaCreditoParameterReturnGeneral estadonotacreditoReturnGeneral=new EstadoNotaCreditoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadonotacreditos=new ArrayList<EstadoNotaCredito>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadonotacredito=new EstadoNotaCredito();
				
				
				if(conColumnasBase) {this.estadonotacredito.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadonotacredito.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadonotacredito.setcodigo(arrColumnas[iColumn++]);
				this.estadonotacredito.setnombre(arrColumnas[iColumn++]);
				
				this.estadonotacreditos.add(this.estadonotacredito);
			}
			
			this.saveEstadoNotaCreditos();
			
			this.connexion.commit();
			
			estadonotacreditoReturnGeneral.setConRetornoEstaProcesado(true);
			estadonotacreditoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadonotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoNotaCreditosEliminados() throws Exception {				
		
		List<EstadoNotaCredito> estadonotacreditosAux= new ArrayList<EstadoNotaCredito>();
		
		for(EstadoNotaCredito estadonotacredito:estadonotacreditos) {
			if(!estadonotacredito.getIsDeleted()) {
				estadonotacreditosAux.add(estadonotacredito);
			}
		}
		
		estadonotacreditos=estadonotacreditosAux;
	}
	
	public void quitarEstadoNotaCreditosNulos() throws Exception {				
		
		List<EstadoNotaCredito> estadonotacreditosAux= new ArrayList<EstadoNotaCredito>();
		
		for(EstadoNotaCredito estadonotacredito : this.estadonotacreditos) {
			if(estadonotacredito==null) {
				estadonotacreditosAux.add(estadonotacredito);
			}
		}
		
		//this.estadonotacreditos=estadonotacreditosAux;
		
		this.estadonotacreditos.removeAll(estadonotacreditosAux);
	}
	
	public void getSetVersionRowEstadoNotaCreditoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadonotacredito.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadonotacredito.getIsDeleted() || (estadonotacredito.getIsChanged()&&!estadonotacredito.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadonotacreditoDataAccess.getSetVersionRowEstadoNotaCredito(connexion,estadonotacredito.getId());
				
				if(!estadonotacredito.getVersionRow().equals(timestamp)) {	
					estadonotacredito.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadonotacredito.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoNotaCredito()throws Exception {	
		
		if(estadonotacredito.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadonotacredito.getIsDeleted() || (estadonotacredito.getIsChanged()&&!estadonotacredito.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadonotacreditoDataAccess.getSetVersionRowEstadoNotaCredito(connexion,estadonotacredito.getId());
			
			try {							
				if(!estadonotacredito.getVersionRow().equals(timestamp)) {	
					estadonotacredito.setVersionRow(timestamp);
				}
				
				estadonotacredito.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoNotaCreditosWithConnection()throws Exception {	
		if(estadonotacreditos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoNotaCredito estadonotacreditoAux:estadonotacreditos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadonotacreditoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadonotacreditoAux.getIsDeleted() || (estadonotacreditoAux.getIsChanged()&&!estadonotacreditoAux.getIsNew())) {
						
						timestamp=estadonotacreditoDataAccess.getSetVersionRowEstadoNotaCredito(connexion,estadonotacreditoAux.getId());
						
						if(!estadonotacredito.getVersionRow().equals(timestamp)) {	
							estadonotacreditoAux.setVersionRow(timestamp);
						}
								
						estadonotacreditoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoNotaCreditos()throws Exception {	
		if(estadonotacreditos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoNotaCredito estadonotacreditoAux:estadonotacreditos) {
					if(estadonotacreditoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadonotacreditoAux.getIsDeleted() || (estadonotacreditoAux.getIsChanged()&&!estadonotacreditoAux.getIsNew())) {
						
						timestamp=estadonotacreditoDataAccess.getSetVersionRowEstadoNotaCredito(connexion,estadonotacreditoAux.getId());
						
						if(!estadonotacreditoAux.getVersionRow().equals(timestamp)) {	
							estadonotacreditoAux.setVersionRow(timestamp);
						}
						
													
						estadonotacreditoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoNotaCreditoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			NotaCreditoSoliLogic notacreditosoliLogic=new NotaCreditoSoliLogic();
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic=new NotaCreditoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoNotaCreditoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(NotaCreditoSoli.class));
			classes.add(new Classe(NotaCreditoPuntoVenta.class));
											
			

			notacreditosoliLogic.setConnexion(this.getConnexion());
			notacreditosoliLogic.setDatosCliente(this.datosCliente);
			notacreditosoliLogic.setIsConRefrescarForeignKeys(true);

			notacreditopuntoventaLogic.setConnexion(this.getConnexion());
			notacreditopuntoventaLogic.setDatosCliente(this.datosCliente);
			notacreditopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoNotaCredito estadonotacredito:this.estadonotacreditos) {
				

				classes=new ArrayList<Classe>();
				classes=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditosoliLogic.setNotaCreditoSolis(estadonotacredito.notacreditosoliSolis);
				notacreditosoliLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(estadonotacredito.notacreditopuntoventaPuntoVentas);
				notacreditopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoNotaCredito estadonotacredito,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoNotaCreditoLogicAdditional.updateEstadoNotaCreditoToGet(estadonotacredito,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadonotacredito.setNotaCreditoSoliSolis(estadonotacreditoDataAccess.getNotaCreditoSoliSolis(connexion,estadonotacredito));
		estadonotacredito.setNotaCreditoPuntoVentaPuntoVentas(estadonotacreditoDataAccess.getNotaCreditoPuntoVentaPuntoVentas(connexion,estadonotacredito));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadonotacredito.setNotaCreditoSoliSolis(estadonotacreditoDataAccess.getNotaCreditoSoliSolis(connexion,estadonotacredito));

				if(this.isConDeep) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(this.connexion);
					notacreditosoliLogic.setNotaCreditoSolis(estadonotacredito.getNotaCreditoSoliSolis());
					ArrayList<Classe> classesLocal=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditosoliLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(notacreditosoliLogic.getNotaCreditoSolis());
					estadonotacredito.setNotaCreditoSoliSolis(notacreditosoliLogic.getNotaCreditoSolis());
				}

				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadonotacredito.setNotaCreditoPuntoVentaPuntoVentas(estadonotacreditoDataAccess.getNotaCreditoPuntoVentaPuntoVentas(connexion,estadonotacredito));

				if(this.isConDeep) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(this.connexion);
					notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(estadonotacredito.getNotaCreditoPuntoVentaPuntoVentas());
					ArrayList<Classe> classesLocal=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
					estadonotacredito.setNotaCreditoPuntoVentaPuntoVentas(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			estadonotacredito.setNotaCreditoSoliSolis(estadonotacreditoDataAccess.getNotaCreditoSoliSolis(connexion,estadonotacredito));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoPuntoVenta.class));
			estadonotacredito.setNotaCreditoPuntoVentaPuntoVentas(estadonotacreditoDataAccess.getNotaCreditoPuntoVentaPuntoVentas(connexion,estadonotacredito));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadonotacredito.setNotaCreditoSoliSolis(estadonotacreditoDataAccess.getNotaCreditoSoliSolis(connexion,estadonotacredito));

		for(NotaCreditoSoli notacreditosoli:estadonotacredito.getNotaCreditoSoliSolis()) {
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
		}

		estadonotacredito.setNotaCreditoPuntoVentaPuntoVentas(estadonotacreditoDataAccess.getNotaCreditoPuntoVentaPuntoVentas(connexion,estadonotacredito));

		for(NotaCreditoPuntoVenta notacreditopuntoventa:estadonotacredito.getNotaCreditoPuntoVentaPuntoVentas()) {
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
			notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadonotacredito.setNotaCreditoSoliSolis(estadonotacreditoDataAccess.getNotaCreditoSoliSolis(connexion,estadonotacredito));

				for(NotaCreditoSoli notacreditosoli:estadonotacredito.getNotaCreditoSoliSolis()) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
					notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadonotacredito.setNotaCreditoPuntoVentaPuntoVentas(estadonotacreditoDataAccess.getNotaCreditoPuntoVentaPuntoVentas(connexion,estadonotacredito));

				for(NotaCreditoPuntoVenta notacreditopuntoventa:estadonotacredito.getNotaCreditoPuntoVentaPuntoVentas()) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
					notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			estadonotacredito.setNotaCreditoSoliSolis(estadonotacreditoDataAccess.getNotaCreditoSoliSolis(connexion,estadonotacredito));

			for(NotaCreditoSoli notacreditosoli:estadonotacredito.getNotaCreditoSoliSolis()) {
				NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
				notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoPuntoVenta.class));
			estadonotacredito.setNotaCreditoPuntoVentaPuntoVentas(estadonotacreditoDataAccess.getNotaCreditoPuntoVentaPuntoVentas(connexion,estadonotacredito));

			for(NotaCreditoPuntoVenta notacreditopuntoventa:estadonotacredito.getNotaCreditoPuntoVentaPuntoVentas()) {
				NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
				notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoNotaCredito estadonotacredito,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoNotaCredito.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadonotacredito,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(estadonotacredito);
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
			this.deepLoad(this.estadonotacredito,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoNotaCredito.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadonotacreditos!=null) {
				for(EstadoNotaCredito estadonotacredito:estadonotacreditos) {
					this.deepLoad(estadonotacredito,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(estadonotacreditos);
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
			if(estadonotacreditos!=null) {
				for(EstadoNotaCredito estadonotacredito:estadonotacreditos) {
					this.deepLoad(estadonotacredito,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(estadonotacreditos);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoNotaCreditoPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoNotaCreditoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadonotacredito=estadonotacreditoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadonotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacredito);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoNotaCreditoPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoNotaCreditoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadonotacredito=estadonotacreditoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadonotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNotaCredito(this.estadonotacredito);
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
			if(EstadoNotaCreditoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNotaCreditoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoNotaCredito estadonotacredito,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoNotaCreditoConstantesFunciones.ISCONAUDITORIA) {
				if(estadonotacredito.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNotaCreditoDataAccess.TABLENAME, estadonotacredito.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoNotaCreditoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoNotaCreditoLogic.registrarAuditoriaDetallesEstadoNotaCredito(connexion,estadonotacredito,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadonotacredito.getIsDeleted()) {
					/*if(!estadonotacredito.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoNotaCreditoDataAccess.TABLENAME, estadonotacredito.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoNotaCreditoLogic.registrarAuditoriaDetallesEstadoNotaCredito(connexion,estadonotacredito,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNotaCreditoDataAccess.TABLENAME, estadonotacredito.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadonotacredito.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNotaCreditoDataAccess.TABLENAME, estadonotacredito.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoNotaCreditoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoNotaCreditoLogic.registrarAuditoriaDetallesEstadoNotaCredito(connexion,estadonotacredito,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoNotaCredito(Connexion connexion,EstadoNotaCredito estadonotacredito)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadonotacredito.getIsNew()||!estadonotacredito.getcodigo().equals(estadonotacredito.getEstadoNotaCreditoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadonotacredito.getEstadoNotaCreditoOriginal().getcodigo()!=null)
				{
					strValorActual=estadonotacredito.getEstadoNotaCreditoOriginal().getcodigo();
				}
				if(estadonotacredito.getcodigo()!=null)
				{
					strValorNuevo=estadonotacredito.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoNotaCreditoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadonotacredito.getIsNew()||!estadonotacredito.getnombre().equals(estadonotacredito.getEstadoNotaCreditoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadonotacredito.getEstadoNotaCreditoOriginal().getnombre()!=null)
				{
					strValorActual=estadonotacredito.getEstadoNotaCreditoOriginal().getnombre();
				}
				if(estadonotacredito.getnombre()!=null)
				{
					strValorNuevo=estadonotacredito.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoNotaCreditoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoNotaCreditoConstantesFunciones.getClassesForeignKeysOfEstadoNotaCredito(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoNotaCreditoConstantesFunciones.getClassesRelationshipsOfEstadoNotaCredito(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
