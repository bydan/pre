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
import com.bydan.erp.facturacion.util.PresupuestoVentasConstantesFunciones;
import com.bydan.erp.facturacion.util.PresupuestoVentasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PresupuestoVentasParameterGeneral;
import com.bydan.erp.facturacion.business.entity.PresupuestoVentas;
import com.bydan.erp.facturacion.business.logic.PresupuestoVentasLogicAdditional;
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
public class PresupuestoVentasLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresupuestoVentasLogic.class);
	
	protected PresupuestoVentasDataAccess presupuestoventasDataAccess; 	
	protected PresupuestoVentas presupuestoventas;
	protected List<PresupuestoVentas> presupuestoventass;
	protected Object presupuestoventasObject;	
	protected List<Object> presupuestoventassObject;
	
	public static ClassValidator<PresupuestoVentas> presupuestoventasValidator = new ClassValidator<PresupuestoVentas>(PresupuestoVentas.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresupuestoVentasLogicAdditional presupuestoventasLogicAdditional=null;
	
	public PresupuestoVentasLogicAdditional getPresupuestoVentasLogicAdditional() {
		return this.presupuestoventasLogicAdditional;
	}
	
	public void setPresupuestoVentasLogicAdditional(PresupuestoVentasLogicAdditional presupuestoventasLogicAdditional) {
		try {
			this.presupuestoventasLogicAdditional=presupuestoventasLogicAdditional;
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
	
	
	
	
	public  PresupuestoVentasLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presupuestoventasDataAccess = new PresupuestoVentasDataAccess();
			
			this.presupuestoventass= new ArrayList<PresupuestoVentas>();
			this.presupuestoventas= new PresupuestoVentas();
			
			this.presupuestoventasObject=new Object();
			this.presupuestoventassObject=new ArrayList<Object>();
				
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
			
			this.presupuestoventasDataAccess.setConnexionType(this.connexionType);
			this.presupuestoventasDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresupuestoVentasLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presupuestoventasDataAccess = new PresupuestoVentasDataAccess();
			this.presupuestoventass= new ArrayList<PresupuestoVentas>();
			this.presupuestoventas= new PresupuestoVentas();
			this.presupuestoventasObject=new Object();
			this.presupuestoventassObject=new ArrayList<Object>();
			
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
			
			this.presupuestoventasDataAccess.setConnexionType(this.connexionType);
			this.presupuestoventasDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresupuestoVentas getPresupuestoVentas() throws Exception {	
		PresupuestoVentasLogicAdditional.checkPresupuestoVentasToGet(presupuestoventas,this.datosCliente,this.arrDatoGeneral);
		PresupuestoVentasLogicAdditional.updatePresupuestoVentasToGet(presupuestoventas,this.arrDatoGeneral);
		
		return presupuestoventas;
	}
		
	public void setPresupuestoVentas(PresupuestoVentas newPresupuestoVentas) {
		this.presupuestoventas = newPresupuestoVentas;
	}
	
	public PresupuestoVentasDataAccess getPresupuestoVentasDataAccess() {
		return presupuestoventasDataAccess;
	}
	
	public void setPresupuestoVentasDataAccess(PresupuestoVentasDataAccess newpresupuestoventasDataAccess) {
		this.presupuestoventasDataAccess = newpresupuestoventasDataAccess;
	}
	
	public List<PresupuestoVentas> getPresupuestoVentass() throws Exception {		
		this.quitarPresupuestoVentassNulos();
		
		PresupuestoVentasLogicAdditional.checkPresupuestoVentasToGets(presupuestoventass,this.datosCliente,this.arrDatoGeneral);
		
		for (PresupuestoVentas presupuestoventasLocal: presupuestoventass ) {
			PresupuestoVentasLogicAdditional.updatePresupuestoVentasToGet(presupuestoventasLocal,this.arrDatoGeneral);
		}
		
		return presupuestoventass;
	}
	
	public void setPresupuestoVentass(List<PresupuestoVentas> newPresupuestoVentass) {
		this.presupuestoventass = newPresupuestoVentass;
	}
	
	public Object getPresupuestoVentasObject() {	
		this.presupuestoventasObject=this.presupuestoventasDataAccess.getEntityObject();
		return this.presupuestoventasObject;
	}
		
	public void setPresupuestoVentasObject(Object newPresupuestoVentasObject) {
		this.presupuestoventasObject = newPresupuestoVentasObject;
	}
	
	public List<Object> getPresupuestoVentassObject() {		
		this.presupuestoventassObject=this.presupuestoventasDataAccess.getEntitiesObject();
		return this.presupuestoventassObject;
	}
		
	public void setPresupuestoVentassObject(List<Object> newPresupuestoVentassObject) {
		this.presupuestoventassObject = newPresupuestoVentassObject;
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
		
		if(this.presupuestoventasDataAccess!=null) {
			this.presupuestoventasDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presupuestoventasDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presupuestoventasDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presupuestoventas = new  PresupuestoVentas();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestoventas=presupuestoventasDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventas);
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
		presupuestoventas = new  PresupuestoVentas();
		  		  
        try {
			
			presupuestoventas=presupuestoventasDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presupuestoventas = new  PresupuestoVentas();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presupuestoventas=presupuestoventasDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventas);
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
		presupuestoventas = new  PresupuestoVentas();
		  		  
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
		presupuestoventas = new  PresupuestoVentas();
		  		  
        try {
			
			presupuestoventas=presupuestoventasDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presupuestoventas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presupuestoventas = new  PresupuestoVentas();
		  		  
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
		presupuestoventas = new  PresupuestoVentas();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presupuestoventasDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoventas = new  PresupuestoVentas();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presupuestoventasDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestoventas = new  PresupuestoVentas();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presupuestoventasDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoventas = new  PresupuestoVentas();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presupuestoventasDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presupuestoventas = new  PresupuestoVentas();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presupuestoventasDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presupuestoventas = new  PresupuestoVentas();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presupuestoventasDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentas(presupuestoventass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
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
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		  		  
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
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		  		  
        try {			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresupuestoVentas(presupuestoventass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		  		  
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
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentas(presupuestoventass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
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
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		  		  
        try {
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentas(presupuestoventass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
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
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentas(presupuestoventass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
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
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentas(presupuestoventass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presupuestoventas = new  PresupuestoVentas();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventas=presupuestoventasDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentas(presupuestoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventas);
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
		presupuestoventas = new  PresupuestoVentas();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventas=presupuestoventasDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresupuestoVentas(presupuestoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventass=presupuestoventasDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentas(presupuestoventass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
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
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		  		  
        try {
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventass=presupuestoventasDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresupuestoVentas(presupuestoventass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresupuestoVentassWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getTodosPresupuestoVentassWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoVentas(presupuestoventass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
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
	
	public  void  getTodosPresupuestoVentass(String sFinalQuery,Pagination pagination)throws Exception {
		presupuestoventass = new  ArrayList<PresupuestoVentas>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresupuestoVentas(presupuestoventass);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresupuestoVentas(PresupuestoVentas presupuestoventas) throws Exception {
		Boolean estaValidado=false;
		
		if(presupuestoventas.getIsNew() || presupuestoventas.getIsChanged()) { 
			this.invalidValues = presupuestoventasValidator.getInvalidValues(presupuestoventas);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presupuestoventas);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresupuestoVentas(List<PresupuestoVentas> PresupuestoVentass) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresupuestoVentas presupuestoventasLocal:presupuestoventass) {				
			estaValidadoObjeto=this.validarGuardarPresupuestoVentas(presupuestoventasLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresupuestoVentas(List<PresupuestoVentas> PresupuestoVentass) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoVentas(presupuestoventass)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresupuestoVentas(PresupuestoVentas PresupuestoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresupuestoVentas(presupuestoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresupuestoVentas presupuestoventas) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presupuestoventas.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresupuestoVentasConstantesFunciones.getPresupuestoVentasLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presupuestoventas","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresupuestoVentasConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresupuestoVentasConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresupuestoVentasWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-savePresupuestoVentasWithConnection");connexion.begin();			
			
			PresupuestoVentasLogicAdditional.checkPresupuestoVentasToSave(this.presupuestoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoVentasLogicAdditional.updatePresupuestoVentasToSave(this.presupuestoventas,this.arrDatoGeneral);
			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestoventas,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoVentas();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoVentas(this.presupuestoventas)) {
				PresupuestoVentasDataAccess.save(this.presupuestoventas, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presupuestoventas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoVentasLogicAdditional.checkPresupuestoVentasToSaveAfter(this.presupuestoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoVentas();
			
			connexion.commit();			
			
			if(this.presupuestoventas.getIsDeleted()) {
				this.presupuestoventas=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresupuestoVentas()throws Exception {	
		try {	
			
			PresupuestoVentasLogicAdditional.checkPresupuestoVentasToSave(this.presupuestoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresupuestoVentasLogicAdditional.updatePresupuestoVentasToSave(this.presupuestoventas,this.arrDatoGeneral);
			
			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presupuestoventas,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresupuestoVentas(this.presupuestoventas)) {			
				PresupuestoVentasDataAccess.save(this.presupuestoventas, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presupuestoventas,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresupuestoVentasLogicAdditional.checkPresupuestoVentasToSaveAfter(this.presupuestoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presupuestoventas.getIsDeleted()) {
				this.presupuestoventas=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresupuestoVentassWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-savePresupuestoVentassWithConnection");connexion.begin();			
			
			PresupuestoVentasLogicAdditional.checkPresupuestoVentasToSaves(presupuestoventass,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresupuestoVentass();
			
			Boolean validadoTodosPresupuestoVentas=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoVentas presupuestoventasLocal:presupuestoventass) {		
				if(presupuestoventasLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoVentasLogicAdditional.updatePresupuestoVentasToSave(presupuestoventasLocal,this.arrDatoGeneral);
	        	
				PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestoventasLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoVentas(presupuestoventasLocal)) {
					PresupuestoVentasDataAccess.save(presupuestoventasLocal, connexion);				
				} else {
					validadoTodosPresupuestoVentas=false;
				}
			}
			
			if(!validadoTodosPresupuestoVentas) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoVentasLogicAdditional.checkPresupuestoVentasToSavesAfter(presupuestoventass,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresupuestoVentass();
			
			connexion.commit();		
			
			this.quitarPresupuestoVentassEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresupuestoVentass()throws Exception {				
		 try {	
			PresupuestoVentasLogicAdditional.checkPresupuestoVentasToSaves(presupuestoventass,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresupuestoVentas=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresupuestoVentas presupuestoventasLocal:presupuestoventass) {				
				if(presupuestoventasLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresupuestoVentasLogicAdditional.updatePresupuestoVentasToSave(presupuestoventasLocal,this.arrDatoGeneral);
	        	
				PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presupuestoventasLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresupuestoVentas(presupuestoventasLocal)) {				
					PresupuestoVentasDataAccess.save(presupuestoventasLocal, connexion);				
				} else {
					validadoTodosPresupuestoVentas=false;
				}
			}
			
			if(!validadoTodosPresupuestoVentas) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresupuestoVentasLogicAdditional.checkPresupuestoVentasToSavesAfter(presupuestoventass,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresupuestoVentassEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoVentasParameterReturnGeneral procesarAccionPresupuestoVentass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoVentas> presupuestoventass,PresupuestoVentasParameterReturnGeneral presupuestoventasParameterGeneral)throws Exception {
		 try {	
			PresupuestoVentasParameterReturnGeneral presupuestoventasReturnGeneral=new PresupuestoVentasParameterReturnGeneral();
	
			PresupuestoVentasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestoventass,presupuestoventasParameterGeneral,presupuestoventasReturnGeneral);
			
			return presupuestoventasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresupuestoVentasParameterReturnGeneral procesarAccionPresupuestoVentassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresupuestoVentas> presupuestoventass,PresupuestoVentasParameterReturnGeneral presupuestoventasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-procesarAccionPresupuestoVentassWithConnection");connexion.begin();			
			
			PresupuestoVentasParameterReturnGeneral presupuestoventasReturnGeneral=new PresupuestoVentasParameterReturnGeneral();
	
			PresupuestoVentasLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presupuestoventass,presupuestoventasParameterGeneral,presupuestoventasReturnGeneral);
			
			this.connexion.commit();
			
			return presupuestoventasReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoVentasParameterReturnGeneral procesarEventosPresupuestoVentass(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoVentas> presupuestoventass,PresupuestoVentas presupuestoventas,PresupuestoVentasParameterReturnGeneral presupuestoventasParameterGeneral,Boolean isEsNuevoPresupuestoVentas,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresupuestoVentasParameterReturnGeneral presupuestoventasReturnGeneral=new PresupuestoVentasParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestoventasReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoVentasLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestoventass,presupuestoventas,presupuestoventasParameterGeneral,presupuestoventasReturnGeneral,isEsNuevoPresupuestoVentas,clases);
			
			return presupuestoventasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresupuestoVentasParameterReturnGeneral procesarEventosPresupuestoVentassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresupuestoVentas> presupuestoventass,PresupuestoVentas presupuestoventas,PresupuestoVentasParameterReturnGeneral presupuestoventasParameterGeneral,Boolean isEsNuevoPresupuestoVentas,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-procesarEventosPresupuestoVentassWithConnection");connexion.begin();			
			
			PresupuestoVentasParameterReturnGeneral presupuestoventasReturnGeneral=new PresupuestoVentasParameterReturnGeneral();
	
			presupuestoventasReturnGeneral.setPresupuestoVentas(presupuestoventas);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presupuestoventasReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresupuestoVentasLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presupuestoventass,presupuestoventas,presupuestoventasParameterGeneral,presupuestoventasReturnGeneral,isEsNuevoPresupuestoVentas,clases);
			
			this.connexion.commit();
			
			return presupuestoventasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresupuestoVentasParameterReturnGeneral procesarImportacionPresupuestoVentassWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresupuestoVentasParameterReturnGeneral presupuestoventasParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-procesarImportacionPresupuestoVentassWithConnection");connexion.begin();			
			
			PresupuestoVentasParameterReturnGeneral presupuestoventasReturnGeneral=new PresupuestoVentasParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presupuestoventass=new ArrayList<PresupuestoVentas>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presupuestoventas=new PresupuestoVentas();
				
				
				if(conColumnasBase) {this.presupuestoventas.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presupuestoventas.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presupuestoventas.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoventas.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.presupuestoventas.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoventas.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.presupuestoventas.setcantidad_total(Integer.parseInt(arrColumnas[iColumn++]));
				this.presupuestoventas.setvalor_total(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.presupuestoventass.add(this.presupuestoventas);
			}
			
			this.savePresupuestoVentass();
			
			this.connexion.commit();
			
			presupuestoventasReturnGeneral.setConRetornoEstaProcesado(true);
			presupuestoventasReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presupuestoventasReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresupuestoVentassEliminados() throws Exception {				
		
		List<PresupuestoVentas> presupuestoventassAux= new ArrayList<PresupuestoVentas>();
		
		for(PresupuestoVentas presupuestoventas:presupuestoventass) {
			if(!presupuestoventas.getIsDeleted()) {
				presupuestoventassAux.add(presupuestoventas);
			}
		}
		
		presupuestoventass=presupuestoventassAux;
	}
	
	public void quitarPresupuestoVentassNulos() throws Exception {				
		
		List<PresupuestoVentas> presupuestoventassAux= new ArrayList<PresupuestoVentas>();
		
		for(PresupuestoVentas presupuestoventas : this.presupuestoventass) {
			if(presupuestoventas==null) {
				presupuestoventassAux.add(presupuestoventas);
			}
		}
		
		//this.presupuestoventass=presupuestoventassAux;
		
		this.presupuestoventass.removeAll(presupuestoventassAux);
	}
	
	public void getSetVersionRowPresupuestoVentasWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presupuestoventas.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presupuestoventas.getIsDeleted() || (presupuestoventas.getIsChanged()&&!presupuestoventas.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presupuestoventasDataAccess.getSetVersionRowPresupuestoVentas(connexion,presupuestoventas.getId());
				
				if(!presupuestoventas.getVersionRow().equals(timestamp)) {	
					presupuestoventas.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presupuestoventas.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresupuestoVentas()throws Exception {	
		
		if(presupuestoventas.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presupuestoventas.getIsDeleted() || (presupuestoventas.getIsChanged()&&!presupuestoventas.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presupuestoventasDataAccess.getSetVersionRowPresupuestoVentas(connexion,presupuestoventas.getId());
			
			try {							
				if(!presupuestoventas.getVersionRow().equals(timestamp)) {	
					presupuestoventas.setVersionRow(timestamp);
				}
				
				presupuestoventas.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresupuestoVentassWithConnection()throws Exception {	
		if(presupuestoventass!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresupuestoVentas presupuestoventasAux:presupuestoventass) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presupuestoventasAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestoventasAux.getIsDeleted() || (presupuestoventasAux.getIsChanged()&&!presupuestoventasAux.getIsNew())) {
						
						timestamp=presupuestoventasDataAccess.getSetVersionRowPresupuestoVentas(connexion,presupuestoventasAux.getId());
						
						if(!presupuestoventas.getVersionRow().equals(timestamp)) {	
							presupuestoventasAux.setVersionRow(timestamp);
						}
								
						presupuestoventasAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresupuestoVentass()throws Exception {	
		if(presupuestoventass!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresupuestoVentas presupuestoventasAux:presupuestoventass) {
					if(presupuestoventasAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presupuestoventasAux.getIsDeleted() || (presupuestoventasAux.getIsChanged()&&!presupuestoventasAux.getIsNew())) {
						
						timestamp=presupuestoventasDataAccess.getSetVersionRowPresupuestoVentas(connexion,presupuestoventasAux.getId());
						
						if(!presupuestoventasAux.getVersionRow().equals(timestamp)) {	
							presupuestoventasAux.setVersionRow(timestamp);
						}
						
													
						presupuestoventasAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresupuestoVentasParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoVentasWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalVendedor,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalZona,String finalQueryGlobalProducto) throws Exception {
		PresupuestoVentasParameterReturnGeneral  presupuestoventasReturnGeneral =new PresupuestoVentasParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresupuestoVentasWithConnection");connexion.begin();
			
			presupuestoventasReturnGeneral =new PresupuestoVentasParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestoventasReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			presupuestoventasReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presupuestoventasReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			presupuestoventasReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			presupuestoventasReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			presupuestoventasReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			presupuestoventasReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			presupuestoventasReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			presupuestoventasReturnGeneral.setproductosForeignKey(productosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presupuestoventasReturnGeneral;
	}
	
	public PresupuestoVentasParameterReturnGeneral cargarCombosLoteForeignKeyPresupuestoVentas(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalVendedor,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalZona,String finalQueryGlobalProducto) throws Exception {
		PresupuestoVentasParameterReturnGeneral  presupuestoventasReturnGeneral =new PresupuestoVentasParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presupuestoventasReturnGeneral =new PresupuestoVentasParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presupuestoventasReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			presupuestoventasReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presupuestoventasReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			presupuestoventasReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			presupuestoventasReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			presupuestoventasReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			presupuestoventasReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			presupuestoventasReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			presupuestoventasReturnGeneral.setproductosForeignKey(productosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presupuestoventasReturnGeneral;
	}
	
	
	public void deepLoad(PresupuestoVentas presupuestoventas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresupuestoVentasLogicAdditional.updatePresupuestoVentasToGet(presupuestoventas,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestoventas.setEmpresa(presupuestoventasDataAccess.getEmpresa(connexion,presupuestoventas));
		presupuestoventas.setSucursal(presupuestoventasDataAccess.getSucursal(connexion,presupuestoventas));
		presupuestoventas.setEjercicio(presupuestoventasDataAccess.getEjercicio(connexion,presupuestoventas));
		presupuestoventas.setPeriodo(presupuestoventasDataAccess.getPeriodo(connexion,presupuestoventas));
		presupuestoventas.setVendedor(presupuestoventasDataAccess.getVendedor(connexion,presupuestoventas));
		presupuestoventas.setPais(presupuestoventasDataAccess.getPais(connexion,presupuestoventas));
		presupuestoventas.setCiudad(presupuestoventasDataAccess.getCiudad(connexion,presupuestoventas));
		presupuestoventas.setZona(presupuestoventasDataAccess.getZona(connexion,presupuestoventas));
		presupuestoventas.setProducto(presupuestoventasDataAccess.getProducto(connexion,presupuestoventas));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestoventas.setEmpresa(presupuestoventasDataAccess.getEmpresa(connexion,presupuestoventas));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				presupuestoventas.setSucursal(presupuestoventasDataAccess.getSucursal(connexion,presupuestoventas));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presupuestoventas.setEjercicio(presupuestoventasDataAccess.getEjercicio(connexion,presupuestoventas));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				presupuestoventas.setPeriodo(presupuestoventasDataAccess.getPeriodo(connexion,presupuestoventas));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				presupuestoventas.setVendedor(presupuestoventasDataAccess.getVendedor(connexion,presupuestoventas));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				presupuestoventas.setPais(presupuestoventasDataAccess.getPais(connexion,presupuestoventas));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				presupuestoventas.setCiudad(presupuestoventasDataAccess.getCiudad(connexion,presupuestoventas));
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				presupuestoventas.setZona(presupuestoventasDataAccess.getZona(connexion,presupuestoventas));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				presupuestoventas.setProducto(presupuestoventasDataAccess.getProducto(connexion,presupuestoventas));
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
			presupuestoventas.setEmpresa(presupuestoventasDataAccess.getEmpresa(connexion,presupuestoventas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setSucursal(presupuestoventasDataAccess.getSucursal(connexion,presupuestoventas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setEjercicio(presupuestoventasDataAccess.getEjercicio(connexion,presupuestoventas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setPeriodo(presupuestoventasDataAccess.getPeriodo(connexion,presupuestoventas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setVendedor(presupuestoventasDataAccess.getVendedor(connexion,presupuestoventas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setPais(presupuestoventasDataAccess.getPais(connexion,presupuestoventas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setCiudad(presupuestoventasDataAccess.getCiudad(connexion,presupuestoventas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setZona(presupuestoventasDataAccess.getZona(connexion,presupuestoventas));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setProducto(presupuestoventasDataAccess.getProducto(connexion,presupuestoventas));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presupuestoventas.setEmpresa(presupuestoventasDataAccess.getEmpresa(connexion,presupuestoventas));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestoventas.getEmpresa(),isDeep,deepLoadType,clases);
				
		presupuestoventas.setSucursal(presupuestoventasDataAccess.getSucursal(connexion,presupuestoventas));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(presupuestoventas.getSucursal(),isDeep,deepLoadType,clases);
				
		presupuestoventas.setEjercicio(presupuestoventasDataAccess.getEjercicio(connexion,presupuestoventas));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presupuestoventas.getEjercicio(),isDeep,deepLoadType,clases);
				
		presupuestoventas.setPeriodo(presupuestoventasDataAccess.getPeriodo(connexion,presupuestoventas));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(presupuestoventas.getPeriodo(),isDeep,deepLoadType,clases);
				
		presupuestoventas.setVendedor(presupuestoventasDataAccess.getVendedor(connexion,presupuestoventas));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(presupuestoventas.getVendedor(),isDeep,deepLoadType,clases);
				
		presupuestoventas.setPais(presupuestoventasDataAccess.getPais(connexion,presupuestoventas));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(presupuestoventas.getPais(),isDeep,deepLoadType,clases);
				
		presupuestoventas.setCiudad(presupuestoventasDataAccess.getCiudad(connexion,presupuestoventas));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(presupuestoventas.getCiudad(),isDeep,deepLoadType,clases);
				
		presupuestoventas.setZona(presupuestoventasDataAccess.getZona(connexion,presupuestoventas));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(presupuestoventas.getZona(),isDeep,deepLoadType,clases);
				
		presupuestoventas.setProducto(presupuestoventasDataAccess.getProducto(connexion,presupuestoventas));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(presupuestoventas.getProducto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presupuestoventas.setEmpresa(presupuestoventasDataAccess.getEmpresa(connexion,presupuestoventas));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(presupuestoventas.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				presupuestoventas.setSucursal(presupuestoventasDataAccess.getSucursal(connexion,presupuestoventas));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(presupuestoventas.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presupuestoventas.setEjercicio(presupuestoventasDataAccess.getEjercicio(connexion,presupuestoventas));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(presupuestoventas.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				presupuestoventas.setPeriodo(presupuestoventasDataAccess.getPeriodo(connexion,presupuestoventas));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(presupuestoventas.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				presupuestoventas.setVendedor(presupuestoventasDataAccess.getVendedor(connexion,presupuestoventas));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(presupuestoventas.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				presupuestoventas.setPais(presupuestoventasDataAccess.getPais(connexion,presupuestoventas));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(presupuestoventas.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				presupuestoventas.setCiudad(presupuestoventasDataAccess.getCiudad(connexion,presupuestoventas));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(presupuestoventas.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				presupuestoventas.setZona(presupuestoventasDataAccess.getZona(connexion,presupuestoventas));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(presupuestoventas.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				presupuestoventas.setProducto(presupuestoventasDataAccess.getProducto(connexion,presupuestoventas));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(presupuestoventas.getProducto(),isDeep,deepLoadType,clases);				
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
			presupuestoventas.setEmpresa(presupuestoventasDataAccess.getEmpresa(connexion,presupuestoventas));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(presupuestoventas.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setSucursal(presupuestoventasDataAccess.getSucursal(connexion,presupuestoventas));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(presupuestoventas.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setEjercicio(presupuestoventasDataAccess.getEjercicio(connexion,presupuestoventas));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(presupuestoventas.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setPeriodo(presupuestoventasDataAccess.getPeriodo(connexion,presupuestoventas));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(presupuestoventas.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setVendedor(presupuestoventasDataAccess.getVendedor(connexion,presupuestoventas));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(presupuestoventas.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setPais(presupuestoventasDataAccess.getPais(connexion,presupuestoventas));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(presupuestoventas.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setCiudad(presupuestoventasDataAccess.getCiudad(connexion,presupuestoventas));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(presupuestoventas.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setZona(presupuestoventasDataAccess.getZona(connexion,presupuestoventas));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(presupuestoventas.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presupuestoventas.setProducto(presupuestoventasDataAccess.getProducto(connexion,presupuestoventas));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(presupuestoventas.getProducto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresupuestoVentas presupuestoventas,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresupuestoVentasLogicAdditional.updatePresupuestoVentasToSave(presupuestoventas,this.arrDatoGeneral);
			
PresupuestoVentasDataAccess.save(presupuestoventas, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestoventas.getEmpresa(),connexion);

		SucursalDataAccess.save(presupuestoventas.getSucursal(),connexion);

		EjercicioDataAccess.save(presupuestoventas.getEjercicio(),connexion);

		PeriodoDataAccess.save(presupuestoventas.getPeriodo(),connexion);

		VendedorDataAccess.save(presupuestoventas.getVendedor(),connexion);

		PaisDataAccess.save(presupuestoventas.getPais(),connexion);

		CiudadDataAccess.save(presupuestoventas.getCiudad(),connexion);

		ZonaDataAccess.save(presupuestoventas.getZona(),connexion);

		ProductoDataAccess.save(presupuestoventas.getProducto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestoventas.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(presupuestoventas.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presupuestoventas.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(presupuestoventas.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(presupuestoventas.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(presupuestoventas.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(presupuestoventas.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(presupuestoventas.getZona(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(presupuestoventas.getProducto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presupuestoventas.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presupuestoventas.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(presupuestoventas.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(presupuestoventas.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(presupuestoventas.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presupuestoventas.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(presupuestoventas.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(presupuestoventas.getPeriodo(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(presupuestoventas.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(presupuestoventas.getVendedor(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(presupuestoventas.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(presupuestoventas.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(presupuestoventas.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(presupuestoventas.getCiudad(),isDeep,deepLoadType,clases);
				

		ZonaDataAccess.save(presupuestoventas.getZona(),connexion);
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(presupuestoventas.getZona(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(presupuestoventas.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(presupuestoventas.getProducto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presupuestoventas.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(presupuestoventas.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(presupuestoventas.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(presupuestoventas.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presupuestoventas.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(presupuestoventas.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(presupuestoventas.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(presupuestoventas.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(presupuestoventas.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(presupuestoventas.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(presupuestoventas.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(presupuestoventas.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(presupuestoventas.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(presupuestoventas.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(presupuestoventas.getZona(),connexion);
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepSave(presupuestoventas.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(presupuestoventas.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(presupuestoventas.getProducto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PresupuestoVentas.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(presupuestoventas);
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
			this.deepLoad(this.presupuestoventas,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresupuestoVentas.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presupuestoventass!=null) {
				for(PresupuestoVentas presupuestoventas:presupuestoventass) {
					this.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(presupuestoventass);
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
			if(presupuestoventass!=null) {
				for(PresupuestoVentas presupuestoventas:presupuestoventass) {
					this.deepLoad(presupuestoventas,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(presupuestoventass);
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
			this.getNewConnexionToDeep(PresupuestoVentas.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presupuestoventas,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresupuestoVentas.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presupuestoventass!=null) {
				for(PresupuestoVentas presupuestoventas:presupuestoventass) {
					this.deepSave(presupuestoventas,isDeep,deepLoadType,clases);
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
			if(presupuestoventass!=null) {
				for(PresupuestoVentas presupuestoventas:presupuestoventass) {
					this.deepSave(presupuestoventas,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresupuestoVentassFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,PresupuestoVentasConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentassFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,PresupuestoVentasConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentassFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresupuestoVentasConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentassFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresupuestoVentasConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentassFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoVentasConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentassFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresupuestoVentasConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentassFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PresupuestoVentasConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentassFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PresupuestoVentasConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentassFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PresupuestoVentasConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentassFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PresupuestoVentasConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentassFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PresupuestoVentasConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentassFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PresupuestoVentasConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentassFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PresupuestoVentasConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentassFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PresupuestoVentasConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentassFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,PresupuestoVentasConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentassFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,PresupuestoVentasConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresupuestoVentassFK_IdZonaWithConnection(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresupuestoVentas.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,PresupuestoVentasConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresupuestoVentassFK_IdZona(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,PresupuestoVentasConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			PresupuestoVentasLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresupuestoVentasConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentas(this.presupuestoventass);
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
			if(PresupuestoVentasConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresupuestoVentas presupuestoventas,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresupuestoVentasConstantesFunciones.ISCONAUDITORIA) {
				if(presupuestoventas.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasDataAccess.TABLENAME, presupuestoventas.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoVentasConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoVentasLogic.registrarAuditoriaDetallesPresupuestoVentas(connexion,presupuestoventas,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presupuestoventas.getIsDeleted()) {
					/*if(!presupuestoventas.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresupuestoVentasDataAccess.TABLENAME, presupuestoventas.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresupuestoVentasLogic.registrarAuditoriaDetallesPresupuestoVentas(connexion,presupuestoventas,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasDataAccess.TABLENAME, presupuestoventas.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presupuestoventas.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresupuestoVentasDataAccess.TABLENAME, presupuestoventas.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresupuestoVentasConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresupuestoVentasLogic.registrarAuditoriaDetallesPresupuestoVentas(connexion,presupuestoventas,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresupuestoVentas(Connexion connexion,PresupuestoVentas presupuestoventas)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getid_empresa().equals(presupuestoventas.getPresupuestoVentasOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getid_empresa()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getid_empresa().toString();
				}
				if(presupuestoventas.getid_empresa()!=null)
				{
					strValorNuevo=presupuestoventas.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getid_sucursal().equals(presupuestoventas.getPresupuestoVentasOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getid_sucursal()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getid_sucursal().toString();
				}
				if(presupuestoventas.getid_sucursal()!=null)
				{
					strValorNuevo=presupuestoventas.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getid_ejercicio().equals(presupuestoventas.getPresupuestoVentasOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getid_ejercicio()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getid_ejercicio().toString();
				}
				if(presupuestoventas.getid_ejercicio()!=null)
				{
					strValorNuevo=presupuestoventas.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getid_periodo().equals(presupuestoventas.getPresupuestoVentasOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getid_periodo()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getid_periodo().toString();
				}
				if(presupuestoventas.getid_periodo()!=null)
				{
					strValorNuevo=presupuestoventas.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getid_vendedor().equals(presupuestoventas.getPresupuestoVentasOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getid_vendedor()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getid_vendedor().toString();
				}
				if(presupuestoventas.getid_vendedor()!=null)
				{
					strValorNuevo=presupuestoventas.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getid_pais().equals(presupuestoventas.getPresupuestoVentasOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getid_pais()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getid_pais().toString();
				}
				if(presupuestoventas.getid_pais()!=null)
				{
					strValorNuevo=presupuestoventas.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getid_ciudad().equals(presupuestoventas.getPresupuestoVentasOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getid_ciudad()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getid_ciudad().toString();
				}
				if(presupuestoventas.getid_ciudad()!=null)
				{
					strValorNuevo=presupuestoventas.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getid_zona().equals(presupuestoventas.getPresupuestoVentasOriginal().getid_zona()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getid_zona()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getid_zona().toString();
				}
				if(presupuestoventas.getid_zona()!=null)
				{
					strValorNuevo=presupuestoventas.getid_zona().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.IDZONA,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getid_producto().equals(presupuestoventas.getPresupuestoVentasOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getid_producto()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getid_producto().toString();
				}
				if(presupuestoventas.getid_producto()!=null)
				{
					strValorNuevo=presupuestoventas.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getprecio().equals(presupuestoventas.getPresupuestoVentasOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getprecio()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getprecio().toString();
				}
				if(presupuestoventas.getprecio()!=null)
				{
					strValorNuevo=presupuestoventas.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getcantidad().equals(presupuestoventas.getPresupuestoVentasOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getcantidad()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getcantidad().toString();
				}
				if(presupuestoventas.getcantidad()!=null)
				{
					strValorNuevo=presupuestoventas.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getvalor().equals(presupuestoventas.getPresupuestoVentasOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getvalor()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getvalor().toString();
				}
				if(presupuestoventas.getvalor()!=null)
				{
					strValorNuevo=presupuestoventas.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getporcentaje().equals(presupuestoventas.getPresupuestoVentasOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getporcentaje()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getporcentaje().toString();
				}
				if(presupuestoventas.getporcentaje()!=null)
				{
					strValorNuevo=presupuestoventas.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getcantidad_total().equals(presupuestoventas.getPresupuestoVentasOriginal().getcantidad_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getcantidad_total()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getcantidad_total().toString();
				}
				if(presupuestoventas.getcantidad_total()!=null)
				{
					strValorNuevo=presupuestoventas.getcantidad_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.CANTIDADTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(presupuestoventas.getIsNew()||!presupuestoventas.getvalor_total().equals(presupuestoventas.getPresupuestoVentasOriginal().getvalor_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presupuestoventas.getPresupuestoVentasOriginal().getvalor_total()!=null)
				{
					strValorActual=presupuestoventas.getPresupuestoVentasOriginal().getvalor_total().toString();
				}
				if(presupuestoventas.getvalor_total()!=null)
				{
					strValorNuevo=presupuestoventas.getvalor_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresupuestoVentasConstantesFunciones.VALORTOTAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresupuestoVentasRelacionesWithConnection(PresupuestoVentas presupuestoventas) throws Exception {

		if(!presupuestoventas.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoVentasRelacionesBase(presupuestoventas,true);
		}
	}

	public void savePresupuestoVentasRelaciones(PresupuestoVentas presupuestoventas)throws Exception {

		if(!presupuestoventas.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresupuestoVentasRelacionesBase(presupuestoventas,false);
		}
	}

	public void savePresupuestoVentasRelacionesBase(PresupuestoVentas presupuestoventas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresupuestoVentas-saveRelacionesWithConnection");}
	

			this.setPresupuestoVentas(presupuestoventas);

			if(PresupuestoVentasLogicAdditional.validarSaveRelaciones(presupuestoventas,this)) {

				PresupuestoVentasLogicAdditional.updateRelacionesToSave(presupuestoventas,this);

				if((presupuestoventas.getIsNew()||presupuestoventas.getIsChanged())&&!presupuestoventas.getIsDeleted()) {
					this.savePresupuestoVentas();
					this.savePresupuestoVentasRelacionesDetalles();

				} else if(presupuestoventas.getIsDeleted()) {
					this.savePresupuestoVentasRelacionesDetalles();
					this.savePresupuestoVentas();
				}

				PresupuestoVentasLogicAdditional.updateRelacionesToSaveAfter(presupuestoventas,this);

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
	
	
	private void savePresupuestoVentasRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoVentasConstantesFunciones.getClassesForeignKeysOfPresupuestoVentas(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresupuestoVentasConstantesFunciones.getClassesRelationshipsOfPresupuestoVentas(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
