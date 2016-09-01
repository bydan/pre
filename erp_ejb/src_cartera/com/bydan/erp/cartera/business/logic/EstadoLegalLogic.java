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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.EstadoLegalConstantesFunciones;
import com.bydan.erp.cartera.util.EstadoLegalParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EstadoLegalParameterGeneral;
import com.bydan.erp.cartera.business.entity.EstadoLegal;
import com.bydan.erp.cartera.business.logic.EstadoLegalLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoLegalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoLegalLogic.class);
	
	protected EstadoLegalDataAccess estadolegalDataAccess; 	
	protected EstadoLegal estadolegal;
	protected List<EstadoLegal> estadolegals;
	protected Object estadolegalObject;	
	protected List<Object> estadolegalsObject;
	
	public static ClassValidator<EstadoLegal> estadolegalValidator = new ClassValidator<EstadoLegal>(EstadoLegal.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoLegalLogicAdditional estadolegalLogicAdditional=null;
	
	public EstadoLegalLogicAdditional getEstadoLegalLogicAdditional() {
		return this.estadolegalLogicAdditional;
	}
	
	public void setEstadoLegalLogicAdditional(EstadoLegalLogicAdditional estadolegalLogicAdditional) {
		try {
			this.estadolegalLogicAdditional=estadolegalLogicAdditional;
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
	
	
	
	
	public  EstadoLegalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadolegalDataAccess = new EstadoLegalDataAccess();
			
			this.estadolegals= new ArrayList<EstadoLegal>();
			this.estadolegal= new EstadoLegal();
			
			this.estadolegalObject=new Object();
			this.estadolegalsObject=new ArrayList<Object>();
				
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
			
			this.estadolegalDataAccess.setConnexionType(this.connexionType);
			this.estadolegalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoLegalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadolegalDataAccess = new EstadoLegalDataAccess();
			this.estadolegals= new ArrayList<EstadoLegal>();
			this.estadolegal= new EstadoLegal();
			this.estadolegalObject=new Object();
			this.estadolegalsObject=new ArrayList<Object>();
			
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
			
			this.estadolegalDataAccess.setConnexionType(this.connexionType);
			this.estadolegalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoLegal getEstadoLegal() throws Exception {	
		EstadoLegalLogicAdditional.checkEstadoLegalToGet(estadolegal,this.datosCliente,this.arrDatoGeneral);
		EstadoLegalLogicAdditional.updateEstadoLegalToGet(estadolegal,this.arrDatoGeneral);
		
		return estadolegal;
	}
		
	public void setEstadoLegal(EstadoLegal newEstadoLegal) {
		this.estadolegal = newEstadoLegal;
	}
	
	public EstadoLegalDataAccess getEstadoLegalDataAccess() {
		return estadolegalDataAccess;
	}
	
	public void setEstadoLegalDataAccess(EstadoLegalDataAccess newestadolegalDataAccess) {
		this.estadolegalDataAccess = newestadolegalDataAccess;
	}
	
	public List<EstadoLegal> getEstadoLegals() throws Exception {		
		this.quitarEstadoLegalsNulos();
		
		EstadoLegalLogicAdditional.checkEstadoLegalToGets(estadolegals,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoLegal estadolegalLocal: estadolegals ) {
			EstadoLegalLogicAdditional.updateEstadoLegalToGet(estadolegalLocal,this.arrDatoGeneral);
		}
		
		return estadolegals;
	}
	
	public void setEstadoLegals(List<EstadoLegal> newEstadoLegals) {
		this.estadolegals = newEstadoLegals;
	}
	
	public Object getEstadoLegalObject() {	
		this.estadolegalObject=this.estadolegalDataAccess.getEntityObject();
		return this.estadolegalObject;
	}
		
	public void setEstadoLegalObject(Object newEstadoLegalObject) {
		this.estadolegalObject = newEstadoLegalObject;
	}
	
	public List<Object> getEstadoLegalsObject() {		
		this.estadolegalsObject=this.estadolegalDataAccess.getEntitiesObject();
		return this.estadolegalsObject;
	}
		
	public void setEstadoLegalsObject(List<Object> newEstadoLegalsObject) {
		this.estadolegalsObject = newEstadoLegalsObject;
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
		
		if(this.estadolegalDataAccess!=null) {
			this.estadolegalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadolegalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadolegalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadolegal = new  EstadoLegal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadolegal=estadolegalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadolegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegal);
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
		estadolegal = new  EstadoLegal();
		  		  
        try {
			
			estadolegal=estadolegalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadolegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadolegal = new  EstadoLegal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadolegal=estadolegalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadolegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegal);
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
		estadolegal = new  EstadoLegal();
		  		  
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
		estadolegal = new  EstadoLegal();
		  		  
        try {
			
			estadolegal=estadolegalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadolegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadolegal = new  EstadoLegal();
		  		  
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
		estadolegal = new  EstadoLegal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadolegalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadolegal = new  EstadoLegal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadolegalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadolegal = new  EstadoLegal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadolegalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadolegal = new  EstadoLegal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadolegalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadolegal = new  EstadoLegal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadolegalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadolegal = new  EstadoLegal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadolegalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadolegals = new  ArrayList<EstadoLegal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegals=estadolegalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoLegal(estadolegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegals);
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
		estadolegals = new  ArrayList<EstadoLegal>();
		  		  
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
		estadolegals = new  ArrayList<EstadoLegal>();
		  		  
        try {			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegals=estadolegalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoLegal(estadolegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadolegals = new  ArrayList<EstadoLegal>();
		  		  
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
		estadolegals = new  ArrayList<EstadoLegal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegals=estadolegalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoLegal(estadolegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegals);
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
		estadolegals = new  ArrayList<EstadoLegal>();
		  		  
        try {
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegals=estadolegalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoLegal(estadolegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegals);
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
		estadolegals = new  ArrayList<EstadoLegal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegals=estadolegalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoLegal(estadolegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegals);
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
		estadolegals = new  ArrayList<EstadoLegal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegals=estadolegalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoLegal(estadolegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadolegal = new  EstadoLegal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegal=estadolegalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoLegal(estadolegal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegal);
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
		estadolegal = new  EstadoLegal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegal=estadolegalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoLegal(estadolegal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadolegals = new  ArrayList<EstadoLegal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegals=estadolegalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoLegal(estadolegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegals);
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
		estadolegals = new  ArrayList<EstadoLegal>();
		  		  
        try {
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegals=estadolegalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoLegal(estadolegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoLegalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadolegals = new  ArrayList<EstadoLegal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getTodosEstadoLegalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegals=estadolegalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoLegal(estadolegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegals);
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
	
	public  void  getTodosEstadoLegals(String sFinalQuery,Pagination pagination)throws Exception {
		estadolegals = new  ArrayList<EstadoLegal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadolegals=estadolegalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoLegal(estadolegals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoLegal(EstadoLegal estadolegal) throws Exception {
		Boolean estaValidado=false;
		
		if(estadolegal.getIsNew() || estadolegal.getIsChanged()) { 
			this.invalidValues = estadolegalValidator.getInvalidValues(estadolegal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadolegal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoLegal(List<EstadoLegal> EstadoLegals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoLegal estadolegalLocal:estadolegals) {				
			estaValidadoObjeto=this.validarGuardarEstadoLegal(estadolegalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoLegal(List<EstadoLegal> EstadoLegals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoLegal(estadolegals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoLegal(EstadoLegal EstadoLegal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoLegal(estadolegal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoLegal estadolegal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadolegal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoLegalConstantesFunciones.getEstadoLegalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadolegal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoLegalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoLegalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoLegalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-saveEstadoLegalWithConnection");connexion.begin();			
			
			EstadoLegalLogicAdditional.checkEstadoLegalToSave(this.estadolegal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoLegalLogicAdditional.updateEstadoLegalToSave(this.estadolegal,this.arrDatoGeneral);
			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadolegal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoLegal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoLegal(this.estadolegal)) {
				EstadoLegalDataAccess.save(this.estadolegal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadolegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoLegalLogicAdditional.checkEstadoLegalToSaveAfter(this.estadolegal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoLegal();
			
			connexion.commit();			
			
			if(this.estadolegal.getIsDeleted()) {
				this.estadolegal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoLegal()throws Exception {	
		try {	
			
			EstadoLegalLogicAdditional.checkEstadoLegalToSave(this.estadolegal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoLegalLogicAdditional.updateEstadoLegalToSave(this.estadolegal,this.arrDatoGeneral);
			
			EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadolegal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoLegal(this.estadolegal)) {			
				EstadoLegalDataAccess.save(this.estadolegal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadolegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoLegalLogicAdditional.checkEstadoLegalToSaveAfter(this.estadolegal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadolegal.getIsDeleted()) {
				this.estadolegal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoLegalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-saveEstadoLegalsWithConnection");connexion.begin();			
			
			EstadoLegalLogicAdditional.checkEstadoLegalToSaves(estadolegals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoLegals();
			
			Boolean validadoTodosEstadoLegal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoLegal estadolegalLocal:estadolegals) {		
				if(estadolegalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoLegalLogicAdditional.updateEstadoLegalToSave(estadolegalLocal,this.arrDatoGeneral);
	        	
				EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadolegalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoLegal(estadolegalLocal)) {
					EstadoLegalDataAccess.save(estadolegalLocal, connexion);				
				} else {
					validadoTodosEstadoLegal=false;
				}
			}
			
			if(!validadoTodosEstadoLegal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoLegalLogicAdditional.checkEstadoLegalToSavesAfter(estadolegals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoLegals();
			
			connexion.commit();		
			
			this.quitarEstadoLegalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoLegals()throws Exception {				
		 try {	
			EstadoLegalLogicAdditional.checkEstadoLegalToSaves(estadolegals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoLegal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoLegal estadolegalLocal:estadolegals) {				
				if(estadolegalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoLegalLogicAdditional.updateEstadoLegalToSave(estadolegalLocal,this.arrDatoGeneral);
	        	
				EstadoLegalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadolegalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoLegal(estadolegalLocal)) {				
					EstadoLegalDataAccess.save(estadolegalLocal, connexion);				
				} else {
					validadoTodosEstadoLegal=false;
				}
			}
			
			if(!validadoTodosEstadoLegal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoLegalLogicAdditional.checkEstadoLegalToSavesAfter(estadolegals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoLegalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoLegalParameterReturnGeneral procesarAccionEstadoLegals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoLegal> estadolegals,EstadoLegalParameterReturnGeneral estadolegalParameterGeneral)throws Exception {
		 try {	
			EstadoLegalParameterReturnGeneral estadolegalReturnGeneral=new EstadoLegalParameterReturnGeneral();
	
			EstadoLegalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadolegals,estadolegalParameterGeneral,estadolegalReturnGeneral);
			
			return estadolegalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoLegalParameterReturnGeneral procesarAccionEstadoLegalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoLegal> estadolegals,EstadoLegalParameterReturnGeneral estadolegalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-procesarAccionEstadoLegalsWithConnection");connexion.begin();			
			
			EstadoLegalParameterReturnGeneral estadolegalReturnGeneral=new EstadoLegalParameterReturnGeneral();
	
			EstadoLegalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadolegals,estadolegalParameterGeneral,estadolegalReturnGeneral);
			
			this.connexion.commit();
			
			return estadolegalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoLegalParameterReturnGeneral procesarEventosEstadoLegals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoLegal> estadolegals,EstadoLegal estadolegal,EstadoLegalParameterReturnGeneral estadolegalParameterGeneral,Boolean isEsNuevoEstadoLegal,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoLegalParameterReturnGeneral estadolegalReturnGeneral=new EstadoLegalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadolegalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoLegalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadolegals,estadolegal,estadolegalParameterGeneral,estadolegalReturnGeneral,isEsNuevoEstadoLegal,clases);
			
			return estadolegalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoLegalParameterReturnGeneral procesarEventosEstadoLegalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoLegal> estadolegals,EstadoLegal estadolegal,EstadoLegalParameterReturnGeneral estadolegalParameterGeneral,Boolean isEsNuevoEstadoLegal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-procesarEventosEstadoLegalsWithConnection");connexion.begin();			
			
			EstadoLegalParameterReturnGeneral estadolegalReturnGeneral=new EstadoLegalParameterReturnGeneral();
	
			estadolegalReturnGeneral.setEstadoLegal(estadolegal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadolegalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoLegalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadolegals,estadolegal,estadolegalParameterGeneral,estadolegalReturnGeneral,isEsNuevoEstadoLegal,clases);
			
			this.connexion.commit();
			
			return estadolegalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoLegalParameterReturnGeneral procesarImportacionEstadoLegalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoLegalParameterReturnGeneral estadolegalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-procesarImportacionEstadoLegalsWithConnection");connexion.begin();			
			
			EstadoLegalParameterReturnGeneral estadolegalReturnGeneral=new EstadoLegalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadolegals=new ArrayList<EstadoLegal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadolegal=new EstadoLegal();
				
				
				if(conColumnasBase) {this.estadolegal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadolegal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadolegal.setcodigo(arrColumnas[iColumn++]);
				this.estadolegal.setnombre(arrColumnas[iColumn++]);
				
				this.estadolegals.add(this.estadolegal);
			}
			
			this.saveEstadoLegals();
			
			this.connexion.commit();
			
			estadolegalReturnGeneral.setConRetornoEstaProcesado(true);
			estadolegalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadolegalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoLegalsEliminados() throws Exception {				
		
		List<EstadoLegal> estadolegalsAux= new ArrayList<EstadoLegal>();
		
		for(EstadoLegal estadolegal:estadolegals) {
			if(!estadolegal.getIsDeleted()) {
				estadolegalsAux.add(estadolegal);
			}
		}
		
		estadolegals=estadolegalsAux;
	}
	
	public void quitarEstadoLegalsNulos() throws Exception {				
		
		List<EstadoLegal> estadolegalsAux= new ArrayList<EstadoLegal>();
		
		for(EstadoLegal estadolegal : this.estadolegals) {
			if(estadolegal==null) {
				estadolegalsAux.add(estadolegal);
			}
		}
		
		//this.estadolegals=estadolegalsAux;
		
		this.estadolegals.removeAll(estadolegalsAux);
	}
	
	public void getSetVersionRowEstadoLegalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadolegal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadolegal.getIsDeleted() || (estadolegal.getIsChanged()&&!estadolegal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadolegalDataAccess.getSetVersionRowEstadoLegal(connexion,estadolegal.getId());
				
				if(!estadolegal.getVersionRow().equals(timestamp)) {	
					estadolegal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadolegal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoLegal()throws Exception {	
		
		if(estadolegal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadolegal.getIsDeleted() || (estadolegal.getIsChanged()&&!estadolegal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadolegalDataAccess.getSetVersionRowEstadoLegal(connexion,estadolegal.getId());
			
			try {							
				if(!estadolegal.getVersionRow().equals(timestamp)) {	
					estadolegal.setVersionRow(timestamp);
				}
				
				estadolegal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoLegalsWithConnection()throws Exception {	
		if(estadolegals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoLegal estadolegalAux:estadolegals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadolegalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadolegalAux.getIsDeleted() || (estadolegalAux.getIsChanged()&&!estadolegalAux.getIsNew())) {
						
						timestamp=estadolegalDataAccess.getSetVersionRowEstadoLegal(connexion,estadolegalAux.getId());
						
						if(!estadolegal.getVersionRow().equals(timestamp)) {	
							estadolegalAux.setVersionRow(timestamp);
						}
								
						estadolegalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoLegals()throws Exception {	
		if(estadolegals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoLegal estadolegalAux:estadolegals) {
					if(estadolegalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadolegalAux.getIsDeleted() || (estadolegalAux.getIsChanged()&&!estadolegalAux.getIsNew())) {
						
						timestamp=estadolegalDataAccess.getSetVersionRowEstadoLegal(connexion,estadolegalAux.getId());
						
						if(!estadolegalAux.getVersionRow().equals(timestamp)) {	
							estadolegalAux.setVersionRow(timestamp);
						}
						
													
						estadolegalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoLegalWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteLogic clienteLogic=new ClienteLogic();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic=new ParametroCarteraDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoLegalWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(SubCliente.class));
			classes.add(new Classe(ParametroCarteraDefecto.class));
											
			

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			subclienteLogic.setConnexion(this.getConnexion());
			subclienteLogic.setDatosCliente(this.datosCliente);
			subclienteLogic.setIsConRefrescarForeignKeys(true);

			parametrocarteradefectoLogic.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic.setDatosCliente(this.datosCliente);
			parametrocarteradefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoLegal estadolegal:this.estadolegals) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(estadolegal.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				subclienteLogic.setSubClientes(estadolegal.subclientes);
				subclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocarteradefectoLogic.setParametroCarteraDefectos(estadolegal.parametrocarteradefectos);
				parametrocarteradefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoLegal estadolegal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoLegalLogicAdditional.updateEstadoLegalToGet(estadolegal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadolegal.setClientes(estadolegalDataAccess.getClientes(connexion,estadolegal));
		estadolegal.setSubClientes(estadolegalDataAccess.getSubClientes(connexion,estadolegal));
		estadolegal.setParametroCarteraDefectos(estadolegalDataAccess.getParametroCarteraDefectos(connexion,estadolegal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadolegal.setClientes(estadolegalDataAccess.getClientes(connexion,estadolegal));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(estadolegal.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					estadolegal.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadolegal.setSubClientes(estadolegalDataAccess.getSubClientes(connexion,estadolegal));

				if(this.isConDeep) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(this.connexion);
					subclienteLogic.setSubClientes(estadolegal.getSubClientes());
					ArrayList<Classe> classesLocal=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					subclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(subclienteLogic.getSubClientes());
					estadolegal.setSubClientes(subclienteLogic.getSubClientes());
				}

				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadolegal.setParametroCarteraDefectos(estadolegalDataAccess.getParametroCarteraDefectos(connexion,estadolegal));

				if(this.isConDeep) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(this.connexion);
					parametrocarteradefectoLogic.setParametroCarteraDefectos(estadolegal.getParametroCarteraDefectos());
					ArrayList<Classe> classesLocal=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocarteradefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectoLogic.getParametroCarteraDefectos());
					estadolegal.setParametroCarteraDefectos(parametrocarteradefectoLogic.getParametroCarteraDefectos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


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
			estadolegal.setClientes(estadolegalDataAccess.getClientes(connexion,estadolegal));
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
			estadolegal.setSubClientes(estadolegalDataAccess.getSubClientes(connexion,estadolegal));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			estadolegal.setParametroCarteraDefectos(estadolegalDataAccess.getParametroCarteraDefectos(connexion,estadolegal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadolegal.setClientes(estadolegalDataAccess.getClientes(connexion,estadolegal));

		for(Cliente cliente:estadolegal.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		estadolegal.setSubClientes(estadolegalDataAccess.getSubClientes(connexion,estadolegal));

		for(SubCliente subcliente:estadolegal.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
		}

		estadolegal.setParametroCarteraDefectos(estadolegalDataAccess.getParametroCarteraDefectos(connexion,estadolegal));

		for(ParametroCarteraDefecto parametrocarteradefecto:estadolegal.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadolegal.setClientes(estadolegalDataAccess.getClientes(connexion,estadolegal));

				for(Cliente cliente:estadolegal.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadolegal.setSubClientes(estadolegalDataAccess.getSubClientes(connexion,estadolegal));

				for(SubCliente subcliente:estadolegal.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadolegal.setParametroCarteraDefectos(estadolegalDataAccess.getParametroCarteraDefectos(connexion,estadolegal));

				for(ParametroCarteraDefecto parametrocarteradefecto:estadolegal.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


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
			estadolegal.setClientes(estadolegalDataAccess.getClientes(connexion,estadolegal));

			for(Cliente cliente:estadolegal.getClientes()) {
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
			estadolegal.setSubClientes(estadolegalDataAccess.getSubClientes(connexion,estadolegal));

			for(SubCliente subcliente:estadolegal.getSubClientes()) {
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			estadolegal.setParametroCarteraDefectos(estadolegalDataAccess.getParametroCarteraDefectos(connexion,estadolegal));

			for(ParametroCarteraDefecto parametrocarteradefecto:estadolegal.getParametroCarteraDefectos()) {
				ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
				parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoLegal estadolegal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoLegalLogicAdditional.updateEstadoLegalToSave(estadolegal,this.arrDatoGeneral);
			
EstadoLegalDataAccess.save(estadolegal, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Cliente cliente:estadolegal.getClientes()) {
			cliente.setid_estado_legal(estadolegal.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(SubCliente subcliente:estadolegal.getSubClientes()) {
			subcliente.setid_estado_legal(estadolegal.getId());
			SubClienteDataAccess.save(subcliente,connexion);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:estadolegal.getParametroCarteraDefectos()) {
			parametrocarteradefecto.setid_estado_legal(estadolegal.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:estadolegal.getClientes()) {
					cliente.setid_estado_legal(estadolegal.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:estadolegal.getSubClientes()) {
					subcliente.setid_estado_legal(estadolegal.getId());
					SubClienteDataAccess.save(subcliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:estadolegal.getParametroCarteraDefectos()) {
					parametrocarteradefecto.setid_estado_legal(estadolegal.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Cliente cliente:estadolegal.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_estado_legal(estadolegal.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(SubCliente subcliente:estadolegal.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subcliente.setid_estado_legal(estadolegal.getId());
			SubClienteDataAccess.save(subcliente,connexion);
			subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:estadolegal.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefecto.setid_estado_legal(estadolegal.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
			parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:estadolegal.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_estado_legal(estadolegal.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:estadolegal.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subcliente.setid_estado_legal(estadolegal.getId());
					SubClienteDataAccess.save(subcliente,connexion);
					subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:estadolegal.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefecto.setid_estado_legal(estadolegal.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
					parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoLegal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadolegal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(estadolegal);
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
			this.deepLoad(this.estadolegal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoLegal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadolegals!=null) {
				for(EstadoLegal estadolegal:estadolegals) {
					this.deepLoad(estadolegal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(estadolegals);
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
			if(estadolegals!=null) {
				for(EstadoLegal estadolegal:estadolegals) {
					this.deepLoad(estadolegal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(estadolegals);
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
			this.getNewConnexionToDeep(EstadoLegal.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadolegal,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoLegal.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadolegals!=null) {
				for(EstadoLegal estadolegal:estadolegals) {
					this.deepSave(estadolegal,isDeep,deepLoadType,clases);
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
			if(estadolegals!=null) {
				for(EstadoLegal estadolegal:estadolegals) {
					this.deepSave(estadolegal,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoLegalPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoLegal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoLegalConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadolegal=estadolegalDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadolegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegal);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoLegalPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoLegalConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadolegal=estadolegalDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadolegal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoLegalConstantesFunciones.refrescarForeignKeysDescripcionesEstadoLegal(this.estadolegal);
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
			if(EstadoLegalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoLegalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoLegal estadolegal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoLegalConstantesFunciones.ISCONAUDITORIA) {
				if(estadolegal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoLegalDataAccess.TABLENAME, estadolegal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoLegalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoLegalLogic.registrarAuditoriaDetallesEstadoLegal(connexion,estadolegal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadolegal.getIsDeleted()) {
					/*if(!estadolegal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoLegalDataAccess.TABLENAME, estadolegal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoLegalLogic.registrarAuditoriaDetallesEstadoLegal(connexion,estadolegal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoLegalDataAccess.TABLENAME, estadolegal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadolegal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoLegalDataAccess.TABLENAME, estadolegal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoLegalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoLegalLogic.registrarAuditoriaDetallesEstadoLegal(connexion,estadolegal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoLegal(Connexion connexion,EstadoLegal estadolegal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadolegal.getIsNew()||!estadolegal.getcodigo().equals(estadolegal.getEstadoLegalOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadolegal.getEstadoLegalOriginal().getcodigo()!=null)
				{
					strValorActual=estadolegal.getEstadoLegalOriginal().getcodigo();
				}
				if(estadolegal.getcodigo()!=null)
				{
					strValorNuevo=estadolegal.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoLegalConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadolegal.getIsNew()||!estadolegal.getnombre().equals(estadolegal.getEstadoLegalOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadolegal.getEstadoLegalOriginal().getnombre()!=null)
				{
					strValorActual=estadolegal.getEstadoLegalOriginal().getnombre();
				}
				if(estadolegal.getnombre()!=null)
				{
					strValorNuevo=estadolegal.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoLegalConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoLegalRelacionesWithConnection(EstadoLegal estadolegal,List<Cliente> clientes,List<SubCliente> subclientes,List<ParametroCarteraDefecto> parametrocarteradefectos) throws Exception {

		if(!estadolegal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoLegalRelacionesBase(estadolegal,clientes,subclientes,parametrocarteradefectos,true);
		}
	}

	public void saveEstadoLegalRelaciones(EstadoLegal estadolegal,List<Cliente> clientes,List<SubCliente> subclientes,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {

		if(!estadolegal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoLegalRelacionesBase(estadolegal,clientes,subclientes,parametrocarteradefectos,false);
		}
	}

	public void saveEstadoLegalRelacionesBase(EstadoLegal estadolegal,List<Cliente> clientes,List<SubCliente> subclientes,List<ParametroCarteraDefecto> parametrocarteradefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoLegal-saveRelacionesWithConnection");}
	
			estadolegal.setClientes(clientes);
			estadolegal.setSubClientes(subclientes);
			estadolegal.setParametroCarteraDefectos(parametrocarteradefectos);

			this.setEstadoLegal(estadolegal);

				if((estadolegal.getIsNew()||estadolegal.getIsChanged())&&!estadolegal.getIsDeleted()) {
					this.saveEstadoLegal();
					this.saveEstadoLegalRelacionesDetalles(clientes,subclientes,parametrocarteradefectos);

				} else if(estadolegal.getIsDeleted()) {
					this.saveEstadoLegalRelacionesDetalles(clientes,subclientes,parametrocarteradefectos);
					this.saveEstadoLegal();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			SubClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresSubClientes(subclientes,true,true);
			ParametroCarteraDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroCarteraDefectos(parametrocarteradefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoLegalRelacionesDetalles(List<Cliente> clientes,List<SubCliente> subclientes,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {
		try {
	

			Long idEstadoLegalActual=this.getEstadoLegal().getId();

			ClienteLogic clienteLogic_Desde_EstadoLegal=new ClienteLogic();
			clienteLogic_Desde_EstadoLegal.setClientes(clientes);

			clienteLogic_Desde_EstadoLegal.setConnexion(this.getConnexion());
			clienteLogic_Desde_EstadoLegal.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_EstadoLegal:clienteLogic_Desde_EstadoLegal.getClientes()) {
				cliente_Desde_EstadoLegal.setid_estado_legal(idEstadoLegalActual);

				clienteLogic_Desde_EstadoLegal.setCliente(cliente_Desde_EstadoLegal);
				clienteLogic_Desde_EstadoLegal.saveCliente();
			}


			SubClienteLogic subclienteLogic_Desde_EstadoLegal=new SubClienteLogic();
			subclienteLogic_Desde_EstadoLegal.setSubClientes(subclientes);

			subclienteLogic_Desde_EstadoLegal.setConnexion(this.getConnexion());
			subclienteLogic_Desde_EstadoLegal.setDatosCliente(this.datosCliente);

			for(SubCliente subcliente_Desde_EstadoLegal:subclienteLogic_Desde_EstadoLegal.getSubClientes()) {
				subcliente_Desde_EstadoLegal.setid_estado_legal(idEstadoLegalActual);

				subclienteLogic_Desde_EstadoLegal.setSubCliente(subcliente_Desde_EstadoLegal);
				subclienteLogic_Desde_EstadoLegal.saveSubCliente();
			}


			ParametroCarteraDefectoLogic parametrocarteradefectoLogic_Desde_EstadoLegal=new ParametroCarteraDefectoLogic();
			parametrocarteradefectoLogic_Desde_EstadoLegal.setParametroCarteraDefectos(parametrocarteradefectos);

			parametrocarteradefectoLogic_Desde_EstadoLegal.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic_Desde_EstadoLegal.setDatosCliente(this.datosCliente);

			for(ParametroCarteraDefecto parametrocarteradefecto_Desde_EstadoLegal:parametrocarteradefectoLogic_Desde_EstadoLegal.getParametroCarteraDefectos()) {
				parametrocarteradefecto_Desde_EstadoLegal.setid_estado_legal(idEstadoLegalActual);
			}

			parametrocarteradefectoLogic_Desde_EstadoLegal.saveParametroCarteraDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoLegal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoLegalConstantesFunciones.getClassesForeignKeysOfEstadoLegal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoLegal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoLegalConstantesFunciones.getClassesRelationshipsOfEstadoLegal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
