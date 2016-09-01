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
import com.bydan.erp.facturacion.util.PresupuestoVentasLineasConstantesFunciones;
import com.bydan.erp.facturacion.util.PresupuestoVentasLineasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PresupuestoVentasLineasParameterGeneral;
import com.bydan.erp.facturacion.business.entity.PresupuestoVentasLineas;
import com.bydan.erp.facturacion.business.logic.PresupuestoVentasLineasLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class PresupuestoVentasLineasLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresupuestoVentasLineasLogic.class);
	
	protected PresupuestoVentasLineasDataAccess presupuestoventaslineasDataAccess; 	
	protected PresupuestoVentasLineas presupuestoventaslineas;
	protected List<PresupuestoVentasLineas> presupuestoventaslineass;
	protected Object presupuestoventaslineasObject;	
	protected List<Object> presupuestoventaslineassObject;
	
	public static ClassValidator<PresupuestoVentasLineas> presupuestoventaslineasValidator = new ClassValidator<PresupuestoVentasLineas>(PresupuestoVentasLineas.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresupuestoVentasLineasLogicAdditional presupuestoventaslineasLogicAdditional=null;
	
	public PresupuestoVentasLineasLogicAdditional getPresupuestoVentasLineasLogicAdditional() {
		return this.presupuestoventaslineasLogicAdditional;
	}
	
	public void setPresupuestoVentasLineasLogicAdditional(PresupuestoVentasLineasLogicAdditional presupuestoventaslineasLogicAdditional) {
		try {
			this.presupuestoventaslineasLogicAdditional=presupuestoventaslineasLogicAdditional;
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
	
	
	
	
	public  PresupuestoVentasLineasLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presupuestoventaslineasDataAccess = new PresupuestoVentasLineasDataAccess();
			
			this.presupuestoventaslineass= new ArrayList<PresupuestoVentasLineas>();
			this.presupuestoventaslineas= new PresupuestoVentasLineas();
			
			this.presupuestoventaslineasObject=new Object();
			this.presupuestoventaslineassObject=new ArrayList<Object>();
				
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
			
			this.presupuestoventaslineasDataAccess.setConnexionType(this.connexionType);
			this.presupuestoventaslineasDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresupuestoVentasLineasLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presupuestoventaslineasDataAccess = new PresupuestoVentasLineasDataAccess();
			this.presupuestoventaslineass= new ArrayList<PresupuestoVentasLineas>();
			this.presupuestoventaslineas= new PresupuestoVentasLineas();
			this.presupuestoventaslineasObject=new Object();
			this.presupuestoventaslineassObject=new ArrayList<Object>();
			
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
			
			this.presupuestoventaslineasDataAccess.setConnexionType(this.connexionType);
			this.presupuestoventaslineasDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresupuestoVentasLineas getPresupuestoVentasLineas() throws Exception {	
		PresupuestoVentasLineasLogicAdditional.checkPresupuestoVentasLineasToGet(presupuestoventaslineas,this.datosCliente,this.arrDatoGeneral);
		PresupuestoVentasLineasLogicAdditional.updatePresupuestoVentasLineasToGet(presupuestoventaslineas,this.arrDatoGeneral);
		
		return presupuestoventaslineas;
	}
		
	public void setPresupuestoVentasLineas(PresupuestoVentasLineas newPresupuestoVentasLineas) {
		this.presupuestoventaslineas = newPresupuestoVentasLineas;
	}
	
	public PresupuestoVentasLineasDataAccess getPresupuestoVentasLineasDataAccess() {
		return presupuestoventaslineasDataAccess;
	}
	
	public void setPresupuestoVentasLineasDataAccess(PresupuestoVentasLineasDataAccess newpresupuestoventaslineasDataAccess) {
		this.presupuestoventaslineasDataAccess = newpresupuestoventaslineasDataAccess;
	}
	
	public List<PresupuestoVentasLineas> getPresupuestoVentasLineass() throws Exception {		
		this.quitarPresupuestoVentasLineassNulos();
		
		PresupuestoVentasLineasLogicAdditional.checkPresupuestoVentasLineasToGets(presupuestoventaslineass,this.datosCliente,this.arrDatoGeneral);
		
		for (PresupuestoVentasLineas presupuestoventaslineasLocal: presupuestoventaslineass ) {
			PresupuestoVentasLineasLogicAdditional.updatePresupuestoVentasLineasToGet(presupuestoventaslineasLocal,this.arrDatoGeneral);
		}
		
		return presupuestoventaslineass;
	}
	
	public void setPresupuestoVentasLineass(List<PresupuestoVentasLineas> newPresupuestoVentasLineass) {
		this.presupuestoventaslineass = newPresupuestoVentasLineass;
	}
	
	public Object getPresupuestoVentasLineasObject() {	
		this.presupuestoventaslineasObject=this.presupuestoventaslineasDataAccess.getEntityObject();
		return this.presupuestoventaslineasObject;
	}
		
	public void setPresupuestoVentasLineasObject(Object newPresupuestoVentasLineasObject) {
		this.presupuestoventaslineasObject = newPresupuestoVentasLineasObject;
	}
	
	public List<Object> getPresupuestoVentasLineassObject() {		
		this.presupuestoventaslineassObject=this.presupuestoventaslineasDataAccess.getEntitiesObject();
		return this.presupuestoventaslineassObject;
	}
		
	public void setPresupuestoVentasLineassObject(List<Object> newPresupuestoVentasLineassObject) {
		this.presupuestoventaslineassObject = newPresupuestoVentasLineassObject;
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
		
		if(this.presupuestoventaslineasDataAccess!=null) {
			this.presupuestoventaslineasDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presupuestoventaslineasDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presupuestoventaslineasDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestoventaslineas=presupuestoventaslineasDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventaslineas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineas);
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
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		  		  
        try {
			
			presupuestoventaslineas=presupuestoventaslineasDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventaslineas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestoventaslineas=presupuestoventaslineasDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventaslineas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineas);
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
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		  		  
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
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		  		  
        try {
			
			presupuestoventaslineas=presupuestoventaslineasDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventaslineas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		  		  
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
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presupuestoventaslineasDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presupuestoventaslineasDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presupuestoventaslineasDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presupuestoventaslineasDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presupuestoventaslineasDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presupuestoventaslineasDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
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
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		  		  
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
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		  		  
        try {			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		  		  
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
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
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
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		  		  
        try {
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
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
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
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
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineas=presupuestoventaslineasDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineas);
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
		presupuestoventaslineas = new  PresupuestoVentasLineas();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineas=presupuestoventaslineasDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
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
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		  		  
        try {
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresupuestoVentasLineassWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getTodosPresupuestoVentasLineassWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
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
	
	public  void  getTodosPresupuestoVentasLineass(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestoventaslineass = new  ArrayList<PresupuestoVentasLineas>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoVentasLineas(presupuestoventaslineass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresupuestoVentasLineas(PresupuestoVentasLineas presupuestoventaslineas) throws Exception {
		Boolean estaValidado=false;
		
		if(presupuestoventaslineas.getIsNew() || presupuestoventaslineas.getIsChanged()) { 
			this.invalidValues = presupuestoventaslineasValidator.getInvalidValues(presupuestoventaslineas);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presupuestoventaslineas);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresupuestoVentasLineas(List<PresupuestoVentasLineas> PresupuestoVentasLineass) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresupuestoVentasLineas presupuestoventaslineasLocal:presupuestoventaslineass) {				
			estaValidadoObjeto=this.validarGuardarPresupuestoVentasLineas(presupuestoventaslineasLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresupuestoVentasLineas(List<PresupuestoVentasLineas> PresupuestoVentasLineass) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoVentasLineas(presupuestoventaslineass)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresupuestoVentasLineas(PresupuestoVentasLineas PresupuestoVentasLineas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoVentasLineas(presupuestoventaslineas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresupuestoVentasLineas presupuestoventaslineas) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presupuestoventaslineas.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresupuestoVentasLineasConstantesFunciones.getPresupuestoVentasLineasLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presupuestoventaslineas","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresupuestoVentasLineasConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresupuestoVentasLineasConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresupuestoVentasLineasWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-savePresupuestoVentasLineasWithConnection");connexion.begin();			
			
			PresupuestoVentasLineasLogicAdditional.checkPresupuestoVentasLineasToSave(this.presupuestoventaslineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoVentasLineasLogicAdditional.updatePresupuestoVentasLineasToSave(this.presupuestoventaslineas,this.arrDatoGeneral);
			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestoventaslineas,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoVentasLineas();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoVentasLineas(this.presupuestoventaslineas)) {
				PresupuestoVentasLineasDataAccess.save(this.presupuestoventaslineas, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presupuestoventaslineas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoVentasLineasLogicAdditional.checkPresupuestoVentasLineasToSaveAfter(this.presupuestoventaslineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoVentasLineas();
			
			connexion.commit();			
			
			if(this.presupuestoventaslineas.getIsDeleted()) {
				this.presupuestoventaslineas=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresupuestoVentasLineas()throws Exception {	
		try {	
			
			PresupuestoVentasLineasLogicAdditional.checkPresupuestoVentasLineasToSave(this.presupuestoventaslineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoVentasLineasLogicAdditional.updatePresupuestoVentasLineasToSave(this.presupuestoventaslineas,this.arrDatoGeneral);
			
			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestoventaslineas,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoVentasLineas(this.presupuestoventaslineas)) {			
				PresupuestoVentasLineasDataAccess.save(this.presupuestoventaslineas, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presupuestoventaslineas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoVentasLineasLogicAdditional.checkPresupuestoVentasLineasToSaveAfter(this.presupuestoventaslineas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presupuestoventaslineas.getIsDeleted()) {
				this.presupuestoventaslineas=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresupuestoVentasLineassWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-savePresupuestoVentasLineassWithConnection");connexion.begin();			
			
			PresupuestoVentasLineasLogicAdditional.checkPresupuestoVentasLineasToSaves(presupuestoventaslineass,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoVentasLineass();
			
			Boolean validadoTodosPresupuestoVentasLineas=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoVentasLineas presupuestoventaslineasLocal:presupuestoventaslineass) {		
				if(presupuestoventaslineasLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoVentasLineasLogicAdditional.updatePresupuestoVentasLineasToSave(presupuestoventaslineasLocal,this.arrDatoGeneral);
	        	
				PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestoventaslineasLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoVentasLineas(presupuestoventaslineasLocal)) {
					PresupuestoVentasLineasDataAccess.save(presupuestoventaslineasLocal, connexion);				
				} else {
					validadoTodosPresupuestoVentasLineas=false;
				}
			}
			
			if(!validadoTodosPresupuestoVentasLineas) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoVentasLineasLogicAdditional.checkPresupuestoVentasLineasToSavesAfter(presupuestoventaslineass,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoVentasLineass();
			
			connexion.commit();		
			
			this.quitarPresupuestoVentasLineassEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresupuestoVentasLineass()throws Exception {				
		 try {	
			PresupuestoVentasLineasLogicAdditional.checkPresupuestoVentasLineasToSaves(presupuestoventaslineass,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresupuestoVentasLineas=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoVentasLineas presupuestoventaslineasLocal:presupuestoventaslineass) {				
				if(presupuestoventaslineasLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoVentasLineasLogicAdditional.updatePresupuestoVentasLineasToSave(presupuestoventaslineasLocal,this.arrDatoGeneral);
	        	
				PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestoventaslineasLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoVentasLineas(presupuestoventaslineasLocal)) {				
					PresupuestoVentasLineasDataAccess.save(presupuestoventaslineasLocal, connexion);				
				} else {
					validadoTodosPresupuestoVentasLineas=false;
				}
			}
			
			if(!validadoTodosPresupuestoVentasLineas) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoVentasLineasLogicAdditional.checkPresupuestoVentasLineasToSavesAfter(presupuestoventaslineass,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresupuestoVentasLineassEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoVentasLineasParameterReturnGeneral procesarAccionPresupuestoVentasLineass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoVentasLineas> presupuestoventaslineass,PresupuestoVentasLineasParameterReturnGeneral presupuestoventaslineasParameterGeneral)throws Exception {
		 try {	
			PresupuestoVentasLineasParameterReturnGeneral presupuestoventaslineasReturnGeneral=new PresupuestoVentasLineasParameterReturnGeneral();
	
			PresupuestoVentasLineasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestoventaslineass,presupuestoventaslineasParameterGeneral,presupuestoventaslineasReturnGeneral);
			
			return presupuestoventaslineasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoVentasLineasParameterReturnGeneral procesarAccionPresupuestoVentasLineassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoVentasLineas> presupuestoventaslineass,PresupuestoVentasLineasParameterReturnGeneral presupuestoventaslineasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-procesarAccionPresupuestoVentasLineassWithConnection");connexion.begin();			
			
			PresupuestoVentasLineasParameterReturnGeneral presupuestoventaslineasReturnGeneral=new PresupuestoVentasLineasParameterReturnGeneral();
	
			PresupuestoVentasLineasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestoventaslineass,presupuestoventaslineasParameterGeneral,presupuestoventaslineasReturnGeneral);
			
			this.connexion.commit();
			
			return presupuestoventaslineasReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoVentasLineasParameterReturnGeneral procesarEventosPresupuestoVentasLineass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoVentasLineas> presupuestoventaslineass,PresupuestoVentasLineas presupuestoventaslineas,PresupuestoVentasLineasParameterReturnGeneral presupuestoventaslineasParameterGeneral,Boolean isEsNuevoPresupuestoVentasLineas,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresupuestoVentasLineasParameterReturnGeneral presupuestoventaslineasReturnGeneral=new PresupuestoVentasLineasParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestoventaslineasReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoVentasLineasLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestoventaslineass,presupuestoventaslineas,presupuestoventaslineasParameterGeneral,presupuestoventaslineasReturnGeneral,isEsNuevoPresupuestoVentasLineas,clases);
			
			return presupuestoventaslineasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresupuestoVentasLineasParameterReturnGeneral procesarEventosPresupuestoVentasLineassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoVentasLineas> presupuestoventaslineass,PresupuestoVentasLineas presupuestoventaslineas,PresupuestoVentasLineasParameterReturnGeneral presupuestoventaslineasParameterGeneral,Boolean isEsNuevoPresupuestoVentasLineas,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-procesarEventosPresupuestoVentasLineassWithConnection");connexion.begin();			
			
			PresupuestoVentasLineasParameterReturnGeneral presupuestoventaslineasReturnGeneral=new PresupuestoVentasLineasParameterReturnGeneral();
	
			presupuestoventaslineasReturnGeneral.setPresupuestoVentasLineas(presupuestoventaslineas);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestoventaslineasReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoVentasLineasLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestoventaslineass,presupuestoventaslineas,presupuestoventaslineasParameterGeneral,presupuestoventaslineasReturnGeneral,isEsNuevoPresupuestoVentasLineas,clases);
			
			this.connexion.commit();
			
			return presupuestoventaslineasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoVentasLineasParameterReturnGeneral procesarImportacionPresupuestoVentasLineassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresupuestoVentasLineasParameterReturnGeneral presupuestoventaslineasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-procesarImportacionPresupuestoVentasLineassWithConnection");connexion.begin();			
			
			PresupuestoVentasLineasParameterReturnGeneral presupuestoventaslineasReturnGeneral=new PresupuestoVentasLineasParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presupuestoventaslineass=new ArrayList<PresupuestoVentasLineas>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presupuestoventaslineas=new PresupuestoVentasLineas();
				
				
				if(conColumnasBase) {this.presupuestoventaslineas.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presupuestoventaslineas.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presupuestoventaslineas.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoventaslineas.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.presupuestoventaslineas.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoventaslineas.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoventaslineas.setcantidad_total(Integer.parseInt(arrColumnas[iColumn++]));
				this.presupuestoventaslineas.setvalor_total(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.presupuestoventaslineass.add(this.presupuestoventaslineas);
			}
			
			this.savePresupuestoVentasLineass();
			
			this.connexion.commit();
			
			presupuestoventaslineasReturnGeneral.setConRetornoEstaProcesado(true);
			presupuestoventaslineasReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presupuestoventaslineasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresupuestoVentasLineassEliminados() throws Exception {				
		
		List<PresupuestoVentasLineas> presupuestoventaslineassAux= new ArrayList<PresupuestoVentasLineas>();
		
		for(PresupuestoVentasLineas presupuestoventaslineas:presupuestoventaslineass) {
			if(!presupuestoventaslineas.getIsDeleted()) {
				presupuestoventaslineassAux.add(presupuestoventaslineas);
			}
		}
		
		presupuestoventaslineass=presupuestoventaslineassAux;
	}
	
	public void quitarPresupuestoVentasLineassNulos() throws Exception {				
		
		List<PresupuestoVentasLineas> presupuestoventaslineassAux= new ArrayList<PresupuestoVentasLineas>();
		
		for(PresupuestoVentasLineas presupuestoventaslineas : this.presupuestoventaslineass) {
			if(presupuestoventaslineas==null) {
				presupuestoventaslineassAux.add(presupuestoventaslineas);
			}
		}
		
		//this.presupuestoventaslineass=presupuestoventaslineassAux;
		
		this.presupuestoventaslineass.removeAll(presupuestoventaslineassAux);
	}
	
	public void getSetVersionRowPresupuestoVentasLineasWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presupuestoventaslineas.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presupuestoventaslineas.getIsDeleted() || (presupuestoventaslineas.getIsChanged()&&!presupuestoventaslineas.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presupuestoventaslineasDataAccess.getSetVersionRowPresupuestoVentasLineas(connexion,presupuestoventaslineas.getId());
				
				if(!presupuestoventaslineas.getVersionRow().equals(timestamp)) {	
					presupuestoventaslineas.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presupuestoventaslineas.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresupuestoVentasLineas()throws Exception {	
		
		if(presupuestoventaslineas.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presupuestoventaslineas.getIsDeleted() || (presupuestoventaslineas.getIsChanged()&&!presupuestoventaslineas.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presupuestoventaslineasDataAccess.getSetVersionRowPresupuestoVentasLineas(connexion,presupuestoventaslineas.getId());
			
			try {							
				if(!presupuestoventaslineas.getVersionRow().equals(timestamp)) {	
					presupuestoventaslineas.setVersionRow(timestamp);
				}
				
				presupuestoventaslineas.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresupuestoVentasLineassWithConnection()throws Exception {	
		if(presupuestoventaslineass!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresupuestoVentasLineas presupuestoventaslineasAux:presupuestoventaslineass) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presupuestoventaslineasAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestoventaslineasAux.getIsDeleted() || (presupuestoventaslineasAux.getIsChanged()&&!presupuestoventaslineasAux.getIsNew())) {
						
						timestamp=presupuestoventaslineasDataAccess.getSetVersionRowPresupuestoVentasLineas(connexion,presupuestoventaslineasAux.getId());
						
						if(!presupuestoventaslineas.getVersionRow().equals(timestamp)) {	
							presupuestoventaslineasAux.setVersionRow(timestamp);
						}
								
						presupuestoventaslineasAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresupuestoVentasLineass()throws Exception {	
		if(presupuestoventaslineass!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresupuestoVentasLineas presupuestoventaslineasAux:presupuestoventaslineass) {
					if(presupuestoventaslineasAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestoventaslineasAux.getIsDeleted() || (presupuestoventaslineasAux.getIsChanged()&&!presupuestoventaslineasAux.getIsNew())) {
						
						timestamp=presupuestoventaslineasDataAccess.getSetVersionRowPresupuestoVentasLineas(connexion,presupuestoventaslineasAux.getId());
						
						if(!presupuestoventaslineasAux.getVersionRow().equals(timestamp)) {	
							presupuestoventaslineasAux.setVersionRow(timestamp);
						}
						
													
						presupuestoventaslineasAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresupuestoVentasLineasParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoVentasLineasWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalVendedor,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalZona,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca) throws Exception {
		PresupuestoVentasLineasParameterReturnGeneral  presupuestoventaslineasReturnGeneral =new PresupuestoVentasLineasParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresupuestoVentasLineasWithConnection");connexion.begin();
			
			presupuestoventaslineasReturnGeneral =new PresupuestoVentasLineasParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestoventaslineasReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			presupuestoventaslineasReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presupuestoventaslineasReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			presupuestoventaslineasReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			presupuestoventaslineasReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			presupuestoventaslineasReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			presupuestoventaslineasReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			presupuestoventaslineasReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			presupuestoventaslineasReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			presupuestoventaslineasReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			presupuestoventaslineasReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			presupuestoventaslineasReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presupuestoventaslineasReturnGeneral;
	}
	
	public PresupuestoVentasLineasParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoVentasLineas(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalVendedor,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalZona,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca) throws Exception {
		PresupuestoVentasLineasParameterReturnGeneral  presupuestoventaslineasReturnGeneral =new PresupuestoVentasLineasParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presupuestoventaslineasReturnGeneral =new PresupuestoVentasLineasParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestoventaslineasReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			presupuestoventaslineasReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presupuestoventaslineasReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			presupuestoventaslineasReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			presupuestoventaslineasReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			presupuestoventaslineasReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			presupuestoventaslineasReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			presupuestoventaslineasReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			presupuestoventaslineasReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			presupuestoventaslineasReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			presupuestoventaslineasReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			presupuestoventaslineasReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presupuestoventaslineasReturnGeneral;
	}
	
	
	public void deepLoad(PresupuestoVentasLineas presupuestoventaslineas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresupuestoVentasLineasLogicAdditional.updatePresupuestoVentasLineasToGet(presupuestoventaslineas,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestoventaslineas.setEmpresa(presupuestoventaslineasDataAccess.getEmpresa(connexion,presupuestoventaslineas));
		presupuestoventaslineas.setSucursal(presupuestoventaslineasDataAccess.getSucursal(connexion,presupuestoventaslineas));
		presupuestoventaslineas.setEjercicio(presupuestoventaslineasDataAccess.getEjercicio(connexion,presupuestoventaslineas));
		presupuestoventaslineas.setPeriodo(presupuestoventaslineasDataAccess.getPeriodo(connexion,presupuestoventaslineas));
		presupuestoventaslineas.setVendedor(presupuestoventaslineasDataAccess.getVendedor(connexion,presupuestoventaslineas));
		presupuestoventaslineas.setPais(presupuestoventaslineasDataAccess.getPais(connexion,presupuestoventaslineas));
		presupuestoventaslineas.setCiudad(presupuestoventaslineasDataAccess.getCiudad(connexion,presupuestoventaslineas));
		presupuestoventaslineas.setZona(presupuestoventaslineasDataAccess.getZona(connexion,presupuestoventaslineas));
		presupuestoventaslineas.setLinea(presupuestoventaslineasDataAccess.getLinea(connexion,presupuestoventaslineas));
		presupuestoventaslineas.setLineaGrupo(presupuestoventaslineasDataAccess.getLineaGrupo(connexion,presupuestoventaslineas));
		presupuestoventaslineas.setLineaCategoria(presupuestoventaslineasDataAccess.getLineaCategoria(connexion,presupuestoventaslineas));
		presupuestoventaslineas.setLineaMarca(presupuestoventaslineasDataAccess.getLineaMarca(connexion,presupuestoventaslineas));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestoventaslineas.setEmpresa(presupuestoventaslineasDataAccess.getEmpresa(connexion,presupuestoventaslineas));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				presupuestoventaslineas.setSucursal(presupuestoventaslineasDataAccess.getSucursal(connexion,presupuestoventaslineas));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presupuestoventaslineas.setEjercicio(presupuestoventaslineasDataAccess.getEjercicio(connexion,presupuestoventaslineas));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				presupuestoventaslineas.setPeriodo(presupuestoventaslineasDataAccess.getPeriodo(connexion,presupuestoventaslineas));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				presupuestoventaslineas.setVendedor(presupuestoventaslineasDataAccess.getVendedor(connexion,presupuestoventaslineas));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				presupuestoventaslineas.setPais(presupuestoventaslineasDataAccess.getPais(connexion,presupuestoventaslineas));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				presupuestoventaslineas.setCiudad(presupuestoventaslineasDataAccess.getCiudad(connexion,presupuestoventaslineas));
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				presupuestoventaslineas.setZona(presupuestoventaslineasDataAccess.getZona(connexion,presupuestoventaslineas));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				presupuestoventaslineas.setLinea(presupuestoventaslineasDataAccess.getLinea(connexion,presupuestoventaslineas));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				presupuestoventaslineas.setLineaGrupo(presupuestoventaslineasDataAccess.getLineaGrupo(connexion,presupuestoventaslineas));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				presupuestoventaslineas.setLineaCategoria(presupuestoventaslineasDataAccess.getLineaCategoria(connexion,presupuestoventaslineas));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				presupuestoventaslineas.setLineaMarca(presupuestoventaslineasDataAccess.getLineaMarca(connexion,presupuestoventaslineas));
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
			presupuestoventaslineas.setEmpresa(presupuestoventaslineasDataAccess.getEmpresa(connexion,presupuestoventaslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setSucursal(presupuestoventaslineasDataAccess.getSucursal(connexion,presupuestoventaslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setEjercicio(presupuestoventaslineasDataAccess.getEjercicio(connexion,presupuestoventaslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setPeriodo(presupuestoventaslineasDataAccess.getPeriodo(connexion,presupuestoventaslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setVendedor(presupuestoventaslineasDataAccess.getVendedor(connexion,presupuestoventaslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setPais(presupuestoventaslineasDataAccess.getPais(connexion,presupuestoventaslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setCiudad(presupuestoventaslineasDataAccess.getCiudad(connexion,presupuestoventaslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setZona(presupuestoventaslineasDataAccess.getZona(connexion,presupuestoventaslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setLinea(presupuestoventaslineasDataAccess.getLinea(connexion,presupuestoventaslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setLineaGrupo(presupuestoventaslineasDataAccess.getLineaGrupo(connexion,presupuestoventaslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setLineaCategoria(presupuestoventaslineasDataAccess.getLineaCategoria(connexion,presupuestoventaslineas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setLineaMarca(presupuestoventaslineasDataAccess.getLineaMarca(connexion,presupuestoventaslineas));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestoventaslineas.setEmpresa(presupuestoventaslineasDataAccess.getEmpresa(connexion,presupuestoventaslineas));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestoventaslineas.getEmpresa(),isDeep,deepLoadType,clases);
				
		presupuestoventaslineas.setSucursal(presupuestoventaslineasDataAccess.getSucursal(connexion,presupuestoventaslineas));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(presupuestoventaslineas.getSucursal(),isDeep,deepLoadType,clases);
				
		presupuestoventaslineas.setEjercicio(presupuestoventaslineasDataAccess.getEjercicio(connexion,presupuestoventaslineas));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presupuestoventaslineas.getEjercicio(),isDeep,deepLoadType,clases);
				
		presupuestoventaslineas.setPeriodo(presupuestoventaslineasDataAccess.getPeriodo(connexion,presupuestoventaslineas));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(presupuestoventaslineas.getPeriodo(),isDeep,deepLoadType,clases);
				
		presupuestoventaslineas.setVendedor(presupuestoventaslineasDataAccess.getVendedor(connexion,presupuestoventaslineas));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(presupuestoventaslineas.getVendedor(),isDeep,deepLoadType,clases);
				
		presupuestoventaslineas.setPais(presupuestoventaslineasDataAccess.getPais(connexion,presupuestoventaslineas));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(presupuestoventaslineas.getPais(),isDeep,deepLoadType,clases);
				
		presupuestoventaslineas.setCiudad(presupuestoventaslineasDataAccess.getCiudad(connexion,presupuestoventaslineas));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(presupuestoventaslineas.getCiudad(),isDeep,deepLoadType,clases);
				
		presupuestoventaslineas.setZona(presupuestoventaslineasDataAccess.getZona(connexion,presupuestoventaslineas));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(presupuestoventaslineas.getZona(),isDeep,deepLoadType,clases);
				
		presupuestoventaslineas.setLinea(presupuestoventaslineasDataAccess.getLinea(connexion,presupuestoventaslineas));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(presupuestoventaslineas.getLinea(),isDeep,deepLoadType,clases);
				
		presupuestoventaslineas.setLineaGrupo(presupuestoventaslineasDataAccess.getLineaGrupo(connexion,presupuestoventaslineas));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(presupuestoventaslineas.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		presupuestoventaslineas.setLineaCategoria(presupuestoventaslineasDataAccess.getLineaCategoria(connexion,presupuestoventaslineas));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(presupuestoventaslineas.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		presupuestoventaslineas.setLineaMarca(presupuestoventaslineasDataAccess.getLineaMarca(connexion,presupuestoventaslineas));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(presupuestoventaslineas.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestoventaslineas.setEmpresa(presupuestoventaslineasDataAccess.getEmpresa(connexion,presupuestoventaslineas));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(presupuestoventaslineas.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				presupuestoventaslineas.setSucursal(presupuestoventaslineasDataAccess.getSucursal(connexion,presupuestoventaslineas));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(presupuestoventaslineas.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presupuestoventaslineas.setEjercicio(presupuestoventaslineasDataAccess.getEjercicio(connexion,presupuestoventaslineas));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(presupuestoventaslineas.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				presupuestoventaslineas.setPeriodo(presupuestoventaslineasDataAccess.getPeriodo(connexion,presupuestoventaslineas));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(presupuestoventaslineas.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				presupuestoventaslineas.setVendedor(presupuestoventaslineasDataAccess.getVendedor(connexion,presupuestoventaslineas));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(presupuestoventaslineas.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				presupuestoventaslineas.setPais(presupuestoventaslineasDataAccess.getPais(connexion,presupuestoventaslineas));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(presupuestoventaslineas.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				presupuestoventaslineas.setCiudad(presupuestoventaslineasDataAccess.getCiudad(connexion,presupuestoventaslineas));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(presupuestoventaslineas.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				presupuestoventaslineas.setZona(presupuestoventaslineasDataAccess.getZona(connexion,presupuestoventaslineas));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(presupuestoventaslineas.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				presupuestoventaslineas.setLinea(presupuestoventaslineasDataAccess.getLinea(connexion,presupuestoventaslineas));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(presupuestoventaslineas.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				presupuestoventaslineas.setLineaGrupo(presupuestoventaslineasDataAccess.getLineaGrupo(connexion,presupuestoventaslineas));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(presupuestoventaslineas.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				presupuestoventaslineas.setLineaCategoria(presupuestoventaslineasDataAccess.getLineaCategoria(connexion,presupuestoventaslineas));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(presupuestoventaslineas.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				presupuestoventaslineas.setLineaMarca(presupuestoventaslineasDataAccess.getLineaMarca(connexion,presupuestoventaslineas));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(presupuestoventaslineas.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			presupuestoventaslineas.setEmpresa(presupuestoventaslineasDataAccess.getEmpresa(connexion,presupuestoventaslineas));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(presupuestoventaslineas.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setSucursal(presupuestoventaslineasDataAccess.getSucursal(connexion,presupuestoventaslineas));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(presupuestoventaslineas.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setEjercicio(presupuestoventaslineasDataAccess.getEjercicio(connexion,presupuestoventaslineas));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(presupuestoventaslineas.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setPeriodo(presupuestoventaslineasDataAccess.getPeriodo(connexion,presupuestoventaslineas));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(presupuestoventaslineas.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setVendedor(presupuestoventaslineasDataAccess.getVendedor(connexion,presupuestoventaslineas));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(presupuestoventaslineas.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setPais(presupuestoventaslineasDataAccess.getPais(connexion,presupuestoventaslineas));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(presupuestoventaslineas.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setCiudad(presupuestoventaslineasDataAccess.getCiudad(connexion,presupuestoventaslineas));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(presupuestoventaslineas.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setZona(presupuestoventaslineasDataAccess.getZona(connexion,presupuestoventaslineas));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(presupuestoventaslineas.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setLinea(presupuestoventaslineasDataAccess.getLinea(connexion,presupuestoventaslineas));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(presupuestoventaslineas.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setLineaGrupo(presupuestoventaslineasDataAccess.getLineaGrupo(connexion,presupuestoventaslineas));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(presupuestoventaslineas.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setLineaCategoria(presupuestoventaslineasDataAccess.getLineaCategoria(connexion,presupuestoventaslineas));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(presupuestoventaslineas.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventaslineas.setLineaMarca(presupuestoventaslineasDataAccess.getLineaMarca(connexion,presupuestoventaslineas));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(presupuestoventaslineas.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresupuestoVentasLineas presupuestoventaslineas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresupuestoVentasLineasLogicAdditional.updatePresupuestoVentasLineasToSave(presupuestoventaslineas,this.arrDatoGeneral);
			
PresupuestoVentasLineasDataAccess.save(presupuestoventaslineas, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestoventaslineas.getEmpresa(),connexion);

		SucursalDataAccess.save(presupuestoventaslineas.getSucursal(),connexion);

		EjercicioDataAccess.save(presupuestoventaslineas.getEjercicio(),connexion);

		PeriodoDataAccess.save(presupuestoventaslineas.getPeriodo(),connexion);

		VendedorDataAccess.save(presupuestoventaslineas.getVendedor(),connexion);

		PaisDataAccess.save(presupuestoventaslineas.getPais(),connexion);

		CiudadDataAccess.save(presupuestoventaslineas.getCiudad(),connexion);

		ZonaDataAccess.save(presupuestoventaslineas.getZona(),connexion);

		LineaDataAccess.save(presupuestoventaslineas.getLinea(),connexion);

		LineaDataAccess.save(presupuestoventaslineas.getLineaGrupo(),connexion);

		LineaDataAccess.save(presupuestoventaslineas.getLineaCategoria(),connexion);

		LineaDataAccess.save(presupuestoventaslineas.getLineaMarca(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestoventaslineas.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(presupuestoventaslineas.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presupuestoventaslineas.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(presupuestoventaslineas.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(presupuestoventaslineas.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(presupuestoventaslineas.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(presupuestoventaslineas.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(presupuestoventaslineas.getZona(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(presupuestoventaslineas.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(presupuestoventaslineas.getLineaGrupo(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(presupuestoventaslineas.getLineaCategoria(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(presupuestoventaslineas.getLineaMarca(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestoventaslineas.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestoventaslineas.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(presupuestoventaslineas.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(presupuestoventaslineas.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(presupuestoventaslineas.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presupuestoventaslineas.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(presupuestoventaslineas.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(presupuestoventaslineas.getPeriodo(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(presupuestoventaslineas.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(presupuestoventaslineas.getVendedor(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(presupuestoventaslineas.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(presupuestoventaslineas.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(presupuestoventaslineas.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(presupuestoventaslineas.getCiudad(),isDeep,deepLoadType,clases);
				

		ZonaDataAccess.save(presupuestoventaslineas.getZona(),connexion);
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(presupuestoventaslineas.getZona(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(presupuestoventaslineas.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(presupuestoventaslineas.getLinea(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(presupuestoventaslineas.getLineaGrupo(),connexion);
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(presupuestoventaslineas.getLineaGrupo(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(presupuestoventaslineas.getLineaCategoria(),connexion);
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(presupuestoventaslineas.getLineaCategoria(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(presupuestoventaslineas.getLineaMarca(),connexion);
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(presupuestoventaslineas.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestoventaslineas.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(presupuestoventaslineas.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(presupuestoventaslineas.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(presupuestoventaslineas.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presupuestoventaslineas.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(presupuestoventaslineas.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(presupuestoventaslineas.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(presupuestoventaslineas.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(presupuestoventaslineas.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(presupuestoventaslineas.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(presupuestoventaslineas.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(presupuestoventaslineas.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(presupuestoventaslineas.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(presupuestoventaslineas.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(presupuestoventaslineas.getZona(),connexion);
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepSave(presupuestoventaslineas.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(presupuestoventaslineas.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(presupuestoventaslineas.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(presupuestoventaslineas.getLineaGrupo(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(presupuestoventaslineas.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(presupuestoventaslineas.getLineaCategoria(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(presupuestoventaslineas.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(presupuestoventaslineas.getLineaMarca(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(presupuestoventaslineas.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PresupuestoVentasLineas.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(presupuestoventaslineas);
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
			this.deepLoad(this.presupuestoventaslineas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresupuestoVentasLineas.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presupuestoventaslineass!=null) {
				for(PresupuestoVentasLineas presupuestoventaslineas:presupuestoventaslineass) {
					this.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(presupuestoventaslineass);
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
			if(presupuestoventaslineass!=null) {
				for(PresupuestoVentasLineas presupuestoventaslineas:presupuestoventaslineass) {
					this.deepLoad(presupuestoventaslineas,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(presupuestoventaslineass);
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
			this.getNewConnexionToDeep(PresupuestoVentasLineas.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presupuestoventaslineas,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresupuestoVentasLineas.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presupuestoventaslineass!=null) {
				for(PresupuestoVentasLineas presupuestoventaslineas:presupuestoventaslineass) {
					this.deepSave(presupuestoventaslineas,isDeep,deepLoadType,clases);
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
			if(presupuestoventaslineass!=null) {
				for(PresupuestoVentasLineas presupuestoventaslineas:presupuestoventaslineass) {
					this.deepSave(presupuestoventaslineas,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresupuestoVentasLineassFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,PresupuestoVentasLineasConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,PresupuestoVentasLineasConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasLineassFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasLineassFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoVentasLineasConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoVentasLineasConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasLineassFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,PresupuestoVentasLineasConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,PresupuestoVentasLineasConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasLineassFK_IdLineaCategoriaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdLineaCategoria(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasLineassFK_IdLineaGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdLineaGrupo(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasLineassFK_IdLineaMarcaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdLineaMarca(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasLineassFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PresupuestoVentasLineasConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PresupuestoVentasLineasConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasLineassFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PresupuestoVentasLineasConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PresupuestoVentasLineasConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasLineassFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasLineassFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentasLineassFK_IdZonaWithConnection(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentasLineas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,PresupuestoVentasLineasConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentasLineassFK_IdZona(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,PresupuestoVentasLineasConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			PresupuestoVentasLineasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasLineasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasLineas(this.presupuestoventaslineass);
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
			if(PresupuestoVentasLineasConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasLineasDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresupuestoVentasLineas presupuestoventaslineas,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresupuestoVentasLineasConstantesFunciones.ISCONAUDITORIA) {
				if(presupuestoventaslineas.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasLineasDataAccess.TABLENAME, presupuestoventaslineas.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoVentasLineasConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoVentasLineasLogic.registrarAuditoriaDetallesPresupuestoVentasLineas(connexion,presupuestoventaslineas,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presupuestoventaslineas.getIsDeleted()) {
					/*if(!presupuestoventaslineas.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresupuestoVentasLineasDataAccess.TABLENAME, presupuestoventaslineas.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresupuestoVentasLineasLogic.registrarAuditoriaDetallesPresupuestoVentasLineas(connexion,presupuestoventaslineas,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasLineasDataAccess.TABLENAME, presupuestoventaslineas.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presupuestoventaslineas.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasLineasDataAccess.TABLENAME, presupuestoventaslineas.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoVentasLineasConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoVentasLineasLogic.registrarAuditoriaDetallesPresupuestoVentasLineas(connexion,presupuestoventaslineas,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresupuestoVentasLineas(Connexion connexion,PresupuestoVentasLineas presupuestoventaslineas)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_empresa().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_empresa()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_empresa().toString();
				}
				if(presupuestoventaslineas.getid_empresa()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_sucursal().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_sucursal()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_sucursal().toString();
				}
				if(presupuestoventaslineas.getid_sucursal()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_ejercicio().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_ejercicio()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_ejercicio().toString();
				}
				if(presupuestoventaslineas.getid_ejercicio()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_periodo().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_periodo()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_periodo().toString();
				}
				if(presupuestoventaslineas.getid_periodo()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_vendedor().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_vendedor()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_vendedor().toString();
				}
				if(presupuestoventaslineas.getid_vendedor()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_pais().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_pais()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_pais().toString();
				}
				if(presupuestoventaslineas.getid_pais()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_ciudad().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_ciudad()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_ciudad().toString();
				}
				if(presupuestoventaslineas.getid_ciudad()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_zona().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_zona()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_zona()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_zona().toString();
				}
				if(presupuestoventaslineas.getid_zona()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_zona().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDZONA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_linea().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea().toString();
				}
				if(presupuestoventaslineas.getid_linea()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_linea_grupo().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea_grupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea_grupo()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea_grupo().toString();
				}
				if(presupuestoventaslineas.getid_linea_grupo()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_linea_grupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_linea_categoria().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea_categoria()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea_categoria()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea_categoria().toString();
				}
				if(presupuestoventaslineas.getid_linea_categoria()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_linea_categoria().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getid_linea_marca().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea_marca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea_marca()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getid_linea_marca().toString();
				}
				if(presupuestoventaslineas.getid_linea_marca()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getid_linea_marca().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getprecio().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getprecio()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getprecio().toString();
				}
				if(presupuestoventaslineas.getprecio()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getcantidad().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getcantidad()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getcantidad().toString();
				}
				if(presupuestoventaslineas.getcantidad()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getvalor().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getvalor()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getvalor().toString();
				}
				if(presupuestoventaslineas.getvalor()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getporcentaje().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getporcentaje()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getporcentaje().toString();
				}
				if(presupuestoventaslineas.getporcentaje()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getcantidad_total().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getcantidad_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getcantidad_total()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getcantidad_total().toString();
				}
				if(presupuestoventaslineas.getcantidad_total()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getcantidad_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.CANTIDADTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventaslineas.getIsNew()||!presupuestoventaslineas.getvalor_total().equals(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getvalor_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getvalor_total()!=null)
				{
					strValorActual=presupuestoventaslineas.getPresupuestoVentasLineasOriginal().getvalor_total().toString();
				}
				if(presupuestoventaslineas.getvalor_total()!=null)
				{
					strValorNuevo=presupuestoventaslineas.getvalor_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasLineasConstantesFunciones.VALORTOTAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresupuestoVentasLineasRelacionesWithConnection(PresupuestoVentasLineas presupuestoventaslineas) throws Exception {

		if(!presupuestoventaslineas.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoVentasLineasRelacionesBase(presupuestoventaslineas,true);
		}
	}

	public void savePresupuestoVentasLineasRelaciones(PresupuestoVentasLineas presupuestoventaslineas)throws Exception {

		if(!presupuestoventaslineas.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoVentasLineasRelacionesBase(presupuestoventaslineas,false);
		}
	}

	public void savePresupuestoVentasLineasRelacionesBase(PresupuestoVentasLineas presupuestoventaslineas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresupuestoVentasLineas-saveRelacionesWithConnection");}
	

			this.setPresupuestoVentasLineas(presupuestoventaslineas);

			if(PresupuestoVentasLineasLogicAdditional.validarSaveRelaciones(presupuestoventaslineas,this)) {

				PresupuestoVentasLineasLogicAdditional.updateRelacionesToSave(presupuestoventaslineas,this);

				if((presupuestoventaslineas.getIsNew()||presupuestoventaslineas.getIsChanged())&&!presupuestoventaslineas.getIsDeleted()) {
					this.savePresupuestoVentasLineas();
					this.savePresupuestoVentasLineasRelacionesDetalles();

				} else if(presupuestoventaslineas.getIsDeleted()) {
					this.savePresupuestoVentasLineasRelacionesDetalles();
					this.savePresupuestoVentasLineas();
				}

				PresupuestoVentasLineasLogicAdditional.updateRelacionesToSaveAfter(presupuestoventaslineas,this);

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
	
	
	private void savePresupuestoVentasLineasRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoVentasLineas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoVentasLineasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentasLineas(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoVentasLineas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoVentasLineasConstantesFunciones.getClassesRelationshipsOfPresupuestoVentasLineas(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
