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
import com.bydan.erp.facturacion.util.EstadoProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoProformaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.EstadoProforma;
//import com.bydan.erp.facturacion.business.logic.EstadoProformaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoProformaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoProformaLogic.class);
	
	protected EstadoProformaDataAccess estadoproformaDataAccess; 	
	protected EstadoProforma estadoproforma;
	protected List<EstadoProforma> estadoproformas;
	protected Object estadoproformaObject;	
	protected List<Object> estadoproformasObject;
	
	public static ClassValidator<EstadoProforma> estadoproformaValidator = new ClassValidator<EstadoProforma>(EstadoProforma.class);	
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
	
	
	
	
	public  EstadoProformaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoproformaDataAccess = new EstadoProformaDataAccess();
			
			this.estadoproformas= new ArrayList<EstadoProforma>();
			this.estadoproforma= new EstadoProforma();
			
			this.estadoproformaObject=new Object();
			this.estadoproformasObject=new ArrayList<Object>();
				
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
			
			this.estadoproformaDataAccess.setConnexionType(this.connexionType);
			this.estadoproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoProformaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoproformaDataAccess = new EstadoProformaDataAccess();
			this.estadoproformas= new ArrayList<EstadoProforma>();
			this.estadoproforma= new EstadoProforma();
			this.estadoproformaObject=new Object();
			this.estadoproformasObject=new ArrayList<Object>();
			
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
			
			this.estadoproformaDataAccess.setConnexionType(this.connexionType);
			this.estadoproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoProforma getEstadoProforma() throws Exception {	
		//EstadoProformaLogicAdditional.checkEstadoProformaToGet(estadoproforma,this.datosCliente,this.arrDatoGeneral);
		//EstadoProformaLogicAdditional.updateEstadoProformaToGet(estadoproforma,this.arrDatoGeneral);
		
		return estadoproforma;
	}
		
	public void setEstadoProforma(EstadoProforma newEstadoProforma) {
		this.estadoproforma = newEstadoProforma;
	}
	
	public EstadoProformaDataAccess getEstadoProformaDataAccess() {
		return estadoproformaDataAccess;
	}
	
	public void setEstadoProformaDataAccess(EstadoProformaDataAccess newestadoproformaDataAccess) {
		this.estadoproformaDataAccess = newestadoproformaDataAccess;
	}
	
	public List<EstadoProforma> getEstadoProformas() throws Exception {		
		this.quitarEstadoProformasNulos();
		
		//EstadoProformaLogicAdditional.checkEstadoProformaToGets(estadoproformas,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoProforma estadoproformaLocal: estadoproformas ) {
			//EstadoProformaLogicAdditional.updateEstadoProformaToGet(estadoproformaLocal,this.arrDatoGeneral);
		}
		
		return estadoproformas;
	}
	
	public void setEstadoProformas(List<EstadoProforma> newEstadoProformas) {
		this.estadoproformas = newEstadoProformas;
	}
	
	public Object getEstadoProformaObject() {	
		this.estadoproformaObject=this.estadoproformaDataAccess.getEntityObject();
		return this.estadoproformaObject;
	}
		
	public void setEstadoProformaObject(Object newEstadoProformaObject) {
		this.estadoproformaObject = newEstadoProformaObject;
	}
	
	public List<Object> getEstadoProformasObject() {		
		this.estadoproformasObject=this.estadoproformaDataAccess.getEntitiesObject();
		return this.estadoproformasObject;
	}
		
	public void setEstadoProformasObject(List<Object> newEstadoProformasObject) {
		this.estadoproformasObject = newEstadoProformasObject;
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
		
		if(this.estadoproformaDataAccess!=null) {
			this.estadoproformaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoproforma = new  EstadoProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoproforma=estadoproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproforma);
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
		estadoproforma = new  EstadoProforma();
		  		  
        try {
			
			estadoproforma=estadoproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoproforma = new  EstadoProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoproforma=estadoproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproforma);
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
		estadoproforma = new  EstadoProforma();
		  		  
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
		estadoproforma = new  EstadoProforma();
		  		  
        try {
			
			estadoproforma=estadoproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoproforma = new  EstadoProforma();
		  		  
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
		estadoproforma = new  EstadoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoproforma = new  EstadoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoproforma = new  EstadoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoproforma = new  EstadoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoproforma = new  EstadoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoproforma = new  EstadoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoproformas = new  ArrayList<EstadoProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoproformas=estadoproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoProforma(estadoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
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
		estadoproformas = new  ArrayList<EstadoProforma>();
		  		  
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
		estadoproformas = new  ArrayList<EstadoProforma>();
		  		  
        try {			
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoproformas=estadoproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoProforma(estadoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoproformas = new  ArrayList<EstadoProforma>();
		  		  
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
		estadoproformas = new  ArrayList<EstadoProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoproformas=estadoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoProforma(estadoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
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
		estadoproformas = new  ArrayList<EstadoProforma>();
		  		  
        try {
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoproformas=estadoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoProforma(estadoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
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
		estadoproformas = new  ArrayList<EstadoProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoproformas=estadoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoProforma(estadoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
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
		estadoproformas = new  ArrayList<EstadoProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoproformas=estadoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoProforma(estadoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoproforma = new  EstadoProforma();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoproforma=estadoproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoProforma(estadoproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproforma);
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
		estadoproforma = new  EstadoProforma();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoproforma=estadoproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoProforma(estadoproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoProformasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoproformas = new  ArrayList<EstadoProforma>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getTodosEstadoProformasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoproformas=estadoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoProforma(estadoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
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
	
	public  void  getTodosEstadoProformas(String sFinalQuery,Pagination pagination)throws Exception {
		estadoproformas = new  ArrayList<EstadoProforma>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoproformas=estadoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoProforma(estadoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoProforma(EstadoProforma estadoproforma) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoproforma.getIsNew() || estadoproforma.getIsChanged()) { 
			this.invalidValues = estadoproformaValidator.getInvalidValues(estadoproforma);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoproforma);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoProforma(List<EstadoProforma> EstadoProformas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoProforma estadoproformaLocal:estadoproformas) {				
			estaValidadoObjeto=this.validarGuardarEstadoProforma(estadoproformaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoProforma(List<EstadoProforma> EstadoProformas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoProforma(estadoproformas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoProforma(EstadoProforma EstadoProforma) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoProforma(estadoproforma)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoProforma estadoproforma) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoproforma.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoProformaConstantesFunciones.getEstadoProformaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoproforma","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoProformaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-saveEstadoProformaWithConnection");connexion.begin();			
			
			//EstadoProformaLogicAdditional.checkEstadoProformaToSave(this.estadoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoProformaLogicAdditional.updateEstadoProformaToSave(this.estadoproforma,this.arrDatoGeneral);
			
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoProforma();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoProforma(this.estadoproforma)) {
				EstadoProformaDataAccess.save(this.estadoproforma, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoProformaLogicAdditional.checkEstadoProformaToSaveAfter(this.estadoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoProforma();
			
			connexion.commit();			
			
			if(this.estadoproforma.getIsDeleted()) {
				this.estadoproforma=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoProforma()throws Exception {	
		try {	
			
			//EstadoProformaLogicAdditional.checkEstadoProformaToSave(this.estadoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoProformaLogicAdditional.updateEstadoProformaToSave(this.estadoproforma,this.arrDatoGeneral);
			
			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoProforma(this.estadoproforma)) {			
				EstadoProformaDataAccess.save(this.estadoproforma, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoProformaLogicAdditional.checkEstadoProformaToSaveAfter(this.estadoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoproforma.getIsDeleted()) {
				this.estadoproforma=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoProformasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-saveEstadoProformasWithConnection");connexion.begin();			
			
			//EstadoProformaLogicAdditional.checkEstadoProformaToSaves(estadoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoProformas();
			
			Boolean validadoTodosEstadoProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoProforma estadoproformaLocal:estadoproformas) {		
				if(estadoproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoProformaLogicAdditional.updateEstadoProformaToSave(estadoproformaLocal,this.arrDatoGeneral);
	        	
				EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoProforma(estadoproformaLocal)) {
					EstadoProformaDataAccess.save(estadoproformaLocal, connexion);				
				} else {
					validadoTodosEstadoProforma=false;
				}
			}
			
			if(!validadoTodosEstadoProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoProformaLogicAdditional.checkEstadoProformaToSavesAfter(estadoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoProformas();
			
			connexion.commit();		
			
			this.quitarEstadoProformasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoProformas()throws Exception {				
		 try {	
			//EstadoProformaLogicAdditional.checkEstadoProformaToSaves(estadoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoProforma estadoproformaLocal:estadoproformas) {				
				if(estadoproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoProformaLogicAdditional.updateEstadoProformaToSave(estadoproformaLocal,this.arrDatoGeneral);
	        	
				EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoProforma(estadoproformaLocal)) {				
					EstadoProformaDataAccess.save(estadoproformaLocal, connexion);				
				} else {
					validadoTodosEstadoProforma=false;
				}
			}
			
			if(!validadoTodosEstadoProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoProformaLogicAdditional.checkEstadoProformaToSavesAfter(estadoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoProformasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoProformaParameterReturnGeneral procesarAccionEstadoProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoProforma> estadoproformas,EstadoProformaParameterReturnGeneral estadoproformaParameterGeneral)throws Exception {
		 try {	
			EstadoProformaParameterReturnGeneral estadoproformaReturnGeneral=new EstadoProformaParameterReturnGeneral();
	
			
			return estadoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoProformaParameterReturnGeneral procesarAccionEstadoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoProforma> estadoproformas,EstadoProformaParameterReturnGeneral estadoproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-procesarAccionEstadoProformasWithConnection");connexion.begin();			
			
			EstadoProformaParameterReturnGeneral estadoproformaReturnGeneral=new EstadoProformaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadoproformaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoProformaParameterReturnGeneral procesarEventosEstadoProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoProforma> estadoproformas,EstadoProforma estadoproforma,EstadoProformaParameterReturnGeneral estadoproformaParameterGeneral,Boolean isEsNuevoEstadoProforma,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoProformaParameterReturnGeneral estadoproformaReturnGeneral=new EstadoProformaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoProformaParameterReturnGeneral procesarEventosEstadoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoProforma> estadoproformas,EstadoProforma estadoproforma,EstadoProformaParameterReturnGeneral estadoproformaParameterGeneral,Boolean isEsNuevoEstadoProforma,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-procesarEventosEstadoProformasWithConnection");connexion.begin();			
			
			EstadoProformaParameterReturnGeneral estadoproformaReturnGeneral=new EstadoProformaParameterReturnGeneral();
	
			estadoproformaReturnGeneral.setEstadoProforma(estadoproforma);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoProformaParameterReturnGeneral procesarImportacionEstadoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoProformaParameterReturnGeneral estadoproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-procesarImportacionEstadoProformasWithConnection");connexion.begin();			
			
			EstadoProformaParameterReturnGeneral estadoproformaReturnGeneral=new EstadoProformaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoproformas=new ArrayList<EstadoProforma>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoproforma=new EstadoProforma();
				
				
				if(conColumnasBase) {this.estadoproforma.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoproforma.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoproforma.setcodigo(arrColumnas[iColumn++]);
				this.estadoproforma.setnombre(arrColumnas[iColumn++]);
				
				this.estadoproformas.add(this.estadoproforma);
			}
			
			this.saveEstadoProformas();
			
			this.connexion.commit();
			
			estadoproformaReturnGeneral.setConRetornoEstaProcesado(true);
			estadoproformaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoProformasEliminados() throws Exception {				
		
		List<EstadoProforma> estadoproformasAux= new ArrayList<EstadoProforma>();
		
		for(EstadoProforma estadoproforma:estadoproformas) {
			if(!estadoproforma.getIsDeleted()) {
				estadoproformasAux.add(estadoproforma);
			}
		}
		
		estadoproformas=estadoproformasAux;
	}
	
	public void quitarEstadoProformasNulos() throws Exception {				
		
		List<EstadoProforma> estadoproformasAux= new ArrayList<EstadoProforma>();
		
		for(EstadoProforma estadoproforma : this.estadoproformas) {
			if(estadoproforma==null) {
				estadoproformasAux.add(estadoproforma);
			}
		}
		
		//this.estadoproformas=estadoproformasAux;
		
		this.estadoproformas.removeAll(estadoproformasAux);
	}
	
	public void getSetVersionRowEstadoProformaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoproforma.getIsDeleted() || (estadoproforma.getIsChanged()&&!estadoproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoproformaDataAccess.getSetVersionRowEstadoProforma(connexion,estadoproforma.getId());
				
				if(!estadoproforma.getVersionRow().equals(timestamp)) {	
					estadoproforma.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoProforma()throws Exception {	
		
		if(estadoproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoproforma.getIsDeleted() || (estadoproforma.getIsChanged()&&!estadoproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoproformaDataAccess.getSetVersionRowEstadoProforma(connexion,estadoproforma.getId());
			
			try {							
				if(!estadoproforma.getVersionRow().equals(timestamp)) {	
					estadoproforma.setVersionRow(timestamp);
				}
				
				estadoproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoProformasWithConnection()throws Exception {	
		if(estadoproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoProforma estadoproformaAux:estadoproformas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoproformaAux.getIsDeleted() || (estadoproformaAux.getIsChanged()&&!estadoproformaAux.getIsNew())) {
						
						timestamp=estadoproformaDataAccess.getSetVersionRowEstadoProforma(connexion,estadoproformaAux.getId());
						
						if(!estadoproforma.getVersionRow().equals(timestamp)) {	
							estadoproformaAux.setVersionRow(timestamp);
						}
								
						estadoproformaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoProformas()throws Exception {	
		if(estadoproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoProforma estadoproformaAux:estadoproformas) {
					if(estadoproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoproformaAux.getIsDeleted() || (estadoproformaAux.getIsChanged()&&!estadoproformaAux.getIsNew())) {
						
						timestamp=estadoproformaDataAccess.getSetVersionRowEstadoProforma(connexion,estadoproformaAux.getId());
						
						if(!estadoproformaAux.getVersionRow().equals(timestamp)) {	
							estadoproformaAux.setVersionRow(timestamp);
						}
						
													
						estadoproformaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EstadoProformaParameterReturnGeneral cargarCombosLoteForeignKeyEstadoProformaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalColorGeneral) throws Exception {
		EstadoProformaParameterReturnGeneral  estadoproformaReturnGeneral =new EstadoProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-cargarCombosLoteForeignKeyEstadoProformaWithConnection");connexion.begin();
			
			estadoproformaReturnGeneral =new EstadoProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			estadoproformaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ColorGeneral> colorgeneralsForeignKey=new ArrayList<ColorGeneral>();
			ColorGeneralLogic colorgeneralLogic=new ColorGeneralLogic();
			colorgeneralLogic.setConnexion(this.connexion);
			colorgeneralLogic.getColorGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalColorGeneral.equals("NONE")) {
				colorgeneralLogic.getTodosColorGenerals(finalQueryGlobalColorGeneral,new Pagination());
				colorgeneralsForeignKey=colorgeneralLogic.getColorGenerals();
			}

			estadoproformaReturnGeneral.setcolorgeneralsForeignKey(colorgeneralsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return estadoproformaReturnGeneral;
	}
	
	public EstadoProformaParameterReturnGeneral cargarCombosLoteForeignKeyEstadoProforma(String finalQueryGlobalEmpresa,String finalQueryGlobalColorGeneral) throws Exception {
		EstadoProformaParameterReturnGeneral  estadoproformaReturnGeneral =new EstadoProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			estadoproformaReturnGeneral =new EstadoProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			estadoproformaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<ColorGeneral> colorgeneralsForeignKey=new ArrayList<ColorGeneral>();
			ColorGeneralLogic colorgeneralLogic=new ColorGeneralLogic();
			colorgeneralLogic.setConnexion(this.connexion);
			colorgeneralLogic.getColorGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalColorGeneral.equals("NONE")) {
				colorgeneralLogic.getTodosColorGenerals(finalQueryGlobalColorGeneral,new Pagination());
				colorgeneralsForeignKey=colorgeneralLogic.getColorGenerals();
			}

			estadoproformaReturnGeneral.setcolorgeneralsForeignKey(colorgeneralsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return estadoproformaReturnGeneral;
	}
	
	
	public void deepLoad(EstadoProforma estadoproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoProformaLogicAdditional.updateEstadoProformaToGet(estadoproforma,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoproforma.setEmpresa(estadoproformaDataAccess.getEmpresa(connexion,estadoproforma));
		estadoproforma.setColorGeneral(estadoproformaDataAccess.getColorGeneral(connexion,estadoproforma));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estadoproforma.setEmpresa(estadoproformaDataAccess.getEmpresa(connexion,estadoproforma));
				continue;
			}

			if(clas.clas.equals(ColorGeneral.class)) {
				estadoproforma.setColorGeneral(estadoproformaDataAccess.getColorGeneral(connexion,estadoproforma));
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
			estadoproforma.setEmpresa(estadoproformaDataAccess.getEmpresa(connexion,estadoproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadoproforma.setColorGeneral(estadoproformaDataAccess.getColorGeneral(connexion,estadoproforma));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoproforma.setEmpresa(estadoproformaDataAccess.getEmpresa(connexion,estadoproforma));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(estadoproforma.getEmpresa(),isDeep,deepLoadType,clases);
				
		estadoproforma.setColorGeneral(estadoproformaDataAccess.getColorGeneral(connexion,estadoproforma));
		ColorGeneralLogic colorgeneralLogic= new ColorGeneralLogic(connexion);
		colorgeneralLogic.deepLoad(estadoproforma.getColorGeneral(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estadoproforma.setEmpresa(estadoproformaDataAccess.getEmpresa(connexion,estadoproforma));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(estadoproforma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ColorGeneral.class)) {
				estadoproforma.setColorGeneral(estadoproformaDataAccess.getColorGeneral(connexion,estadoproforma));
				ColorGeneralLogic colorgeneralLogic= new ColorGeneralLogic(connexion);
				colorgeneralLogic.deepLoad(estadoproforma.getColorGeneral(),isDeep,deepLoadType,clases);				
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
			estadoproforma.setEmpresa(estadoproformaDataAccess.getEmpresa(connexion,estadoproforma));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(estadoproforma.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ColorGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadoproforma.setColorGeneral(estadoproformaDataAccess.getColorGeneral(connexion,estadoproforma));
			ColorGeneralLogic colorgeneralLogic= new ColorGeneralLogic(connexion);
			colorgeneralLogic.deepLoad(estadoproforma.getColorGeneral(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoProforma estadoproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoProforma.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(estadoproforma);
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
			this.deepLoad(this.estadoproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoProforma.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoproformas!=null) {
				for(EstadoProforma estadoproforma:estadoproformas) {
					this.deepLoad(estadoproforma,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(estadoproformas);
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
			if(estadoproformas!=null) {
				for(EstadoProforma estadoproforma:estadoproformas) {
					this.deepLoad(estadoproforma,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(estadoproformas);
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
	
	
	public void getEstadoProformasFK_IdColorGeneralWithConnection(String sFinalQuery,Pagination pagination,Long id_color_general)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidColorGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidColorGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_color_general,EstadoProformaConstantesFunciones.IDCOLORGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidColorGeneral);

			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdColorGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadoproformas=estadoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoProformasFK_IdColorGeneral(String sFinalQuery,Pagination pagination,Long id_color_general)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidColorGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidColorGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_color_general,EstadoProformaConstantesFunciones.IDCOLORGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidColorGeneral);

			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdColorGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadoproformas=estadoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEstadoProformasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EstadoProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadoproformas=estadoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoProformasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EstadoProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EstadoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadoproformas=estadoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoProforma(this.estadoproformas);
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
			if(EstadoProformaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoProformaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoProforma estadoproforma,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoProformaConstantesFunciones.ISCONAUDITORIA) {
				if(estadoproforma.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoProformaDataAccess.TABLENAME, estadoproforma.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoProformaLogic.registrarAuditoriaDetallesEstadoProforma(connexion,estadoproforma,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoproforma.getIsDeleted()) {
					/*if(!estadoproforma.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoProformaDataAccess.TABLENAME, estadoproforma.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoProformaLogic.registrarAuditoriaDetallesEstadoProforma(connexion,estadoproforma,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoProformaDataAccess.TABLENAME, estadoproforma.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoproforma.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoProformaDataAccess.TABLENAME, estadoproforma.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoProformaLogic.registrarAuditoriaDetallesEstadoProforma(connexion,estadoproforma,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoProforma(Connexion connexion,EstadoProforma estadoproforma)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoproforma.getIsNew()||!estadoproforma.getid_empresa().equals(estadoproforma.getEstadoProformaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoproforma.getEstadoProformaOriginal().getid_empresa()!=null)
				{
					strValorActual=estadoproforma.getEstadoProformaOriginal().getid_empresa().toString();
				}
				if(estadoproforma.getid_empresa()!=null)
				{
					strValorNuevo=estadoproforma.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoProformaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(estadoproforma.getIsNew()||!estadoproforma.getcodigo().equals(estadoproforma.getEstadoProformaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoproforma.getEstadoProformaOriginal().getcodigo()!=null)
				{
					strValorActual=estadoproforma.getEstadoProformaOriginal().getcodigo();
				}
				if(estadoproforma.getcodigo()!=null)
				{
					strValorNuevo=estadoproforma.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoProformaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadoproforma.getIsNew()||!estadoproforma.getnombre().equals(estadoproforma.getEstadoProformaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoproforma.getEstadoProformaOriginal().getnombre()!=null)
				{
					strValorActual=estadoproforma.getEstadoProformaOriginal().getnombre();
				}
				if(estadoproforma.getnombre()!=null)
				{
					strValorNuevo=estadoproforma.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoProformaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(estadoproforma.getIsNew()||!estadoproforma.getid_color_general().equals(estadoproforma.getEstadoProformaOriginal().getid_color_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoproforma.getEstadoProformaOriginal().getid_color_general()!=null)
				{
					strValorActual=estadoproforma.getEstadoProformaOriginal().getid_color_general().toString();
				}
				if(estadoproforma.getid_color_general()!=null)
				{
					strValorNuevo=estadoproforma.getid_color_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoProformaConstantesFunciones.IDCOLORGENERAL,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoProformaConstantesFunciones.getClassesForeignKeysOfEstadoProforma(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoProformaConstantesFunciones.getClassesRelationshipsOfEstadoProforma(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
