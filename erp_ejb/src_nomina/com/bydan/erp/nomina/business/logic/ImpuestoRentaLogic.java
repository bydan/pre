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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.ImpuestoRentaConstantesFunciones;
import com.bydan.erp.nomina.util.ImpuestoRentaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ImpuestoRentaParameterGeneral;
import com.bydan.erp.nomina.business.entity.ImpuestoRenta;
import com.bydan.erp.nomina.business.logic.ImpuestoRentaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ImpuestoRentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ImpuestoRentaLogic.class);
	
	protected ImpuestoRentaDataAccess impuestorentaDataAccess; 	
	protected ImpuestoRenta impuestorenta;
	protected List<ImpuestoRenta> impuestorentas;
	protected Object impuestorentaObject;	
	protected List<Object> impuestorentasObject;
	
	public static ClassValidator<ImpuestoRenta> impuestorentaValidator = new ClassValidator<ImpuestoRenta>(ImpuestoRenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ImpuestoRentaLogicAdditional impuestorentaLogicAdditional=null;
	
	public ImpuestoRentaLogicAdditional getImpuestoRentaLogicAdditional() {
		return this.impuestorentaLogicAdditional;
	}
	
	public void setImpuestoRentaLogicAdditional(ImpuestoRentaLogicAdditional impuestorentaLogicAdditional) {
		try {
			this.impuestorentaLogicAdditional=impuestorentaLogicAdditional;
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
	
	
	
	
	public  ImpuestoRentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.impuestorentaDataAccess = new ImpuestoRentaDataAccess();
			
			this.impuestorentas= new ArrayList<ImpuestoRenta>();
			this.impuestorenta= new ImpuestoRenta();
			
			this.impuestorentaObject=new Object();
			this.impuestorentasObject=new ArrayList<Object>();
				
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
			
			this.impuestorentaDataAccess.setConnexionType(this.connexionType);
			this.impuestorentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ImpuestoRentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.impuestorentaDataAccess = new ImpuestoRentaDataAccess();
			this.impuestorentas= new ArrayList<ImpuestoRenta>();
			this.impuestorenta= new ImpuestoRenta();
			this.impuestorentaObject=new Object();
			this.impuestorentasObject=new ArrayList<Object>();
			
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
			
			this.impuestorentaDataAccess.setConnexionType(this.connexionType);
			this.impuestorentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ImpuestoRenta getImpuestoRenta() throws Exception {	
		ImpuestoRentaLogicAdditional.checkImpuestoRentaToGet(impuestorenta,this.datosCliente,this.arrDatoGeneral);
		ImpuestoRentaLogicAdditional.updateImpuestoRentaToGet(impuestorenta,this.arrDatoGeneral);
		
		return impuestorenta;
	}
		
	public void setImpuestoRenta(ImpuestoRenta newImpuestoRenta) {
		this.impuestorenta = newImpuestoRenta;
	}
	
	public ImpuestoRentaDataAccess getImpuestoRentaDataAccess() {
		return impuestorentaDataAccess;
	}
	
	public void setImpuestoRentaDataAccess(ImpuestoRentaDataAccess newimpuestorentaDataAccess) {
		this.impuestorentaDataAccess = newimpuestorentaDataAccess;
	}
	
	public List<ImpuestoRenta> getImpuestoRentas() throws Exception {		
		this.quitarImpuestoRentasNulos();
		
		ImpuestoRentaLogicAdditional.checkImpuestoRentaToGets(impuestorentas,this.datosCliente,this.arrDatoGeneral);
		
		for (ImpuestoRenta impuestorentaLocal: impuestorentas ) {
			ImpuestoRentaLogicAdditional.updateImpuestoRentaToGet(impuestorentaLocal,this.arrDatoGeneral);
		}
		
		return impuestorentas;
	}
	
	public void setImpuestoRentas(List<ImpuestoRenta> newImpuestoRentas) {
		this.impuestorentas = newImpuestoRentas;
	}
	
	public Object getImpuestoRentaObject() {	
		this.impuestorentaObject=this.impuestorentaDataAccess.getEntityObject();
		return this.impuestorentaObject;
	}
		
	public void setImpuestoRentaObject(Object newImpuestoRentaObject) {
		this.impuestorentaObject = newImpuestoRentaObject;
	}
	
	public List<Object> getImpuestoRentasObject() {		
		this.impuestorentasObject=this.impuestorentaDataAccess.getEntitiesObject();
		return this.impuestorentasObject;
	}
		
	public void setImpuestoRentasObject(List<Object> newImpuestoRentasObject) {
		this.impuestorentasObject = newImpuestoRentasObject;
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
		
		if(this.impuestorentaDataAccess!=null) {
			this.impuestorentaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			impuestorentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			impuestorentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		impuestorenta = new  ImpuestoRenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			impuestorenta=impuestorentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.impuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorenta);
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
		impuestorenta = new  ImpuestoRenta();
		  		  
        try {
			
			impuestorenta=impuestorentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.impuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		impuestorenta = new  ImpuestoRenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			impuestorenta=impuestorentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.impuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorenta);
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
		impuestorenta = new  ImpuestoRenta();
		  		  
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
		impuestorenta = new  ImpuestoRenta();
		  		  
        try {
			
			impuestorenta=impuestorentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.impuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		impuestorenta = new  ImpuestoRenta();
		  		  
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
		impuestorenta = new  ImpuestoRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =impuestorentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		impuestorenta = new  ImpuestoRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=impuestorentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		impuestorenta = new  ImpuestoRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =impuestorentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		impuestorenta = new  ImpuestoRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=impuestorentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		impuestorenta = new  ImpuestoRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =impuestorentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		impuestorenta = new  ImpuestoRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=impuestorentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorentas=impuestorentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImpuestoRenta(impuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
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
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		  		  
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
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		  		  
        try {			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorentas=impuestorentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarImpuestoRenta(impuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		  		  
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
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorentas=impuestorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImpuestoRenta(impuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
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
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		  		  
        try {
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorentas=impuestorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImpuestoRenta(impuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
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
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorentas=impuestorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImpuestoRenta(impuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
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
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorentas=impuestorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImpuestoRenta(impuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		impuestorenta = new  ImpuestoRenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorenta=impuestorentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImpuestoRenta(impuestorenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorenta);
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
		impuestorenta = new  ImpuestoRenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorenta=impuestorentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImpuestoRenta(impuestorenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorentas=impuestorentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImpuestoRenta(impuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
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
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		  		  
        try {
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorentas=impuestorentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImpuestoRenta(impuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosImpuestoRentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getTodosImpuestoRentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorentas=impuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarImpuestoRenta(impuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
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
	
	public  void  getTodosImpuestoRentas(String sFinalQuery,Pagination pagination)throws Exception {
		impuestorentas = new  ArrayList<ImpuestoRenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			impuestorentas=impuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarImpuestoRenta(impuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarImpuestoRenta(ImpuestoRenta impuestorenta) throws Exception {
		Boolean estaValidado=false;
		
		if(impuestorenta.getIsNew() || impuestorenta.getIsChanged()) { 
			this.invalidValues = impuestorentaValidator.getInvalidValues(impuestorenta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(impuestorenta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarImpuestoRenta(List<ImpuestoRenta> ImpuestoRentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ImpuestoRenta impuestorentaLocal:impuestorentas) {				
			estaValidadoObjeto=this.validarGuardarImpuestoRenta(impuestorentaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarImpuestoRenta(List<ImpuestoRenta> ImpuestoRentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarImpuestoRenta(impuestorentas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarImpuestoRenta(ImpuestoRenta ImpuestoRenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarImpuestoRenta(impuestorenta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ImpuestoRenta impuestorenta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+impuestorenta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ImpuestoRentaConstantesFunciones.getImpuestoRentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"impuestorenta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ImpuestoRentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ImpuestoRentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveImpuestoRentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-saveImpuestoRentaWithConnection");connexion.begin();			
			
			ImpuestoRentaLogicAdditional.checkImpuestoRentaToSave(this.impuestorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ImpuestoRentaLogicAdditional.updateImpuestoRentaToSave(this.impuestorenta,this.arrDatoGeneral);
			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.impuestorenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowImpuestoRenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarImpuestoRenta(this.impuestorenta)) {
				ImpuestoRentaDataAccess.save(this.impuestorenta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.impuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ImpuestoRentaLogicAdditional.checkImpuestoRentaToSaveAfter(this.impuestorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowImpuestoRenta();
			
			connexion.commit();			
			
			if(this.impuestorenta.getIsDeleted()) {
				this.impuestorenta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveImpuestoRenta()throws Exception {	
		try {	
			
			ImpuestoRentaLogicAdditional.checkImpuestoRentaToSave(this.impuestorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ImpuestoRentaLogicAdditional.updateImpuestoRentaToSave(this.impuestorenta,this.arrDatoGeneral);
			
			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.impuestorenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarImpuestoRenta(this.impuestorenta)) {			
				ImpuestoRentaDataAccess.save(this.impuestorenta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.impuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ImpuestoRentaLogicAdditional.checkImpuestoRentaToSaveAfter(this.impuestorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.impuestorenta.getIsDeleted()) {
				this.impuestorenta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveImpuestoRentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-saveImpuestoRentasWithConnection");connexion.begin();			
			
			ImpuestoRentaLogicAdditional.checkImpuestoRentaToSaves(impuestorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowImpuestoRentas();
			
			Boolean validadoTodosImpuestoRenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ImpuestoRenta impuestorentaLocal:impuestorentas) {		
				if(impuestorentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ImpuestoRentaLogicAdditional.updateImpuestoRentaToSave(impuestorentaLocal,this.arrDatoGeneral);
	        	
				ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),impuestorentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarImpuestoRenta(impuestorentaLocal)) {
					ImpuestoRentaDataAccess.save(impuestorentaLocal, connexion);				
				} else {
					validadoTodosImpuestoRenta=false;
				}
			}
			
			if(!validadoTodosImpuestoRenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ImpuestoRentaLogicAdditional.checkImpuestoRentaToSavesAfter(impuestorentas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowImpuestoRentas();
			
			connexion.commit();		
			
			this.quitarImpuestoRentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveImpuestoRentas()throws Exception {				
		 try {	
			ImpuestoRentaLogicAdditional.checkImpuestoRentaToSaves(impuestorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosImpuestoRenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ImpuestoRenta impuestorentaLocal:impuestorentas) {				
				if(impuestorentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ImpuestoRentaLogicAdditional.updateImpuestoRentaToSave(impuestorentaLocal,this.arrDatoGeneral);
	        	
				ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),impuestorentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarImpuestoRenta(impuestorentaLocal)) {				
					ImpuestoRentaDataAccess.save(impuestorentaLocal, connexion);				
				} else {
					validadoTodosImpuestoRenta=false;
				}
			}
			
			if(!validadoTodosImpuestoRenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ImpuestoRentaLogicAdditional.checkImpuestoRentaToSavesAfter(impuestorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarImpuestoRentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ImpuestoRentaParameterReturnGeneral procesarAccionImpuestoRentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ImpuestoRenta> impuestorentas,ImpuestoRentaParameterReturnGeneral impuestorentaParameterGeneral)throws Exception {
		 try {	
			ImpuestoRentaParameterReturnGeneral impuestorentaReturnGeneral=new ImpuestoRentaParameterReturnGeneral();
	
			ImpuestoRentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,impuestorentas,impuestorentaParameterGeneral,impuestorentaReturnGeneral);
			
			return impuestorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ImpuestoRentaParameterReturnGeneral procesarAccionImpuestoRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ImpuestoRenta> impuestorentas,ImpuestoRentaParameterReturnGeneral impuestorentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-procesarAccionImpuestoRentasWithConnection");connexion.begin();			
			
			ImpuestoRentaParameterReturnGeneral impuestorentaReturnGeneral=new ImpuestoRentaParameterReturnGeneral();
	
			ImpuestoRentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,impuestorentas,impuestorentaParameterGeneral,impuestorentaReturnGeneral);
			
			this.connexion.commit();
			
			return impuestorentaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ImpuestoRentaParameterReturnGeneral procesarEventosImpuestoRentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ImpuestoRenta> impuestorentas,ImpuestoRenta impuestorenta,ImpuestoRentaParameterReturnGeneral impuestorentaParameterGeneral,Boolean isEsNuevoImpuestoRenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			ImpuestoRentaParameterReturnGeneral impuestorentaReturnGeneral=new ImpuestoRentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				impuestorentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ImpuestoRentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,impuestorentas,impuestorenta,impuestorentaParameterGeneral,impuestorentaReturnGeneral,isEsNuevoImpuestoRenta,clases);
			
			return impuestorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ImpuestoRentaParameterReturnGeneral procesarEventosImpuestoRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ImpuestoRenta> impuestorentas,ImpuestoRenta impuestorenta,ImpuestoRentaParameterReturnGeneral impuestorentaParameterGeneral,Boolean isEsNuevoImpuestoRenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-procesarEventosImpuestoRentasWithConnection");connexion.begin();			
			
			ImpuestoRentaParameterReturnGeneral impuestorentaReturnGeneral=new ImpuestoRentaParameterReturnGeneral();
	
			impuestorentaReturnGeneral.setImpuestoRenta(impuestorenta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				impuestorentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ImpuestoRentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,impuestorentas,impuestorenta,impuestorentaParameterGeneral,impuestorentaReturnGeneral,isEsNuevoImpuestoRenta,clases);
			
			this.connexion.commit();
			
			return impuestorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ImpuestoRentaParameterReturnGeneral procesarImportacionImpuestoRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ImpuestoRentaParameterReturnGeneral impuestorentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-procesarImportacionImpuestoRentasWithConnection");connexion.begin();			
			
			ImpuestoRentaParameterReturnGeneral impuestorentaReturnGeneral=new ImpuestoRentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.impuestorentas=new ArrayList<ImpuestoRenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.impuestorenta=new ImpuestoRenta();
				
				
				if(conColumnasBase) {this.impuestorenta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.impuestorenta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.impuestorenta.setdesde(Double.parseDouble(arrColumnas[iColumn++]));
				this.impuestorenta.sethasta(Double.parseDouble(arrColumnas[iColumn++]));
				this.impuestorenta.setimpuesto(Double.parseDouble(arrColumnas[iColumn++]));
				this.impuestorenta.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.impuestorentas.add(this.impuestorenta);
			}
			
			this.saveImpuestoRentas();
			
			this.connexion.commit();
			
			impuestorentaReturnGeneral.setConRetornoEstaProcesado(true);
			impuestorentaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return impuestorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarImpuestoRentasEliminados() throws Exception {				
		
		List<ImpuestoRenta> impuestorentasAux= new ArrayList<ImpuestoRenta>();
		
		for(ImpuestoRenta impuestorenta:impuestorentas) {
			if(!impuestorenta.getIsDeleted()) {
				impuestorentasAux.add(impuestorenta);
			}
		}
		
		impuestorentas=impuestorentasAux;
	}
	
	public void quitarImpuestoRentasNulos() throws Exception {				
		
		List<ImpuestoRenta> impuestorentasAux= new ArrayList<ImpuestoRenta>();
		
		for(ImpuestoRenta impuestorenta : this.impuestorentas) {
			if(impuestorenta==null) {
				impuestorentasAux.add(impuestorenta);
			}
		}
		
		//this.impuestorentas=impuestorentasAux;
		
		this.impuestorentas.removeAll(impuestorentasAux);
	}
	
	public void getSetVersionRowImpuestoRentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(impuestorenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((impuestorenta.getIsDeleted() || (impuestorenta.getIsChanged()&&!impuestorenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=impuestorentaDataAccess.getSetVersionRowImpuestoRenta(connexion,impuestorenta.getId());
				
				if(!impuestorenta.getVersionRow().equals(timestamp)) {	
					impuestorenta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				impuestorenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowImpuestoRenta()throws Exception {	
		
		if(impuestorenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((impuestorenta.getIsDeleted() || (impuestorenta.getIsChanged()&&!impuestorenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=impuestorentaDataAccess.getSetVersionRowImpuestoRenta(connexion,impuestorenta.getId());
			
			try {							
				if(!impuestorenta.getVersionRow().equals(timestamp)) {	
					impuestorenta.setVersionRow(timestamp);
				}
				
				impuestorenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowImpuestoRentasWithConnection()throws Exception {	
		if(impuestorentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ImpuestoRenta impuestorentaAux:impuestorentas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(impuestorentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(impuestorentaAux.getIsDeleted() || (impuestorentaAux.getIsChanged()&&!impuestorentaAux.getIsNew())) {
						
						timestamp=impuestorentaDataAccess.getSetVersionRowImpuestoRenta(connexion,impuestorentaAux.getId());
						
						if(!impuestorenta.getVersionRow().equals(timestamp)) {	
							impuestorentaAux.setVersionRow(timestamp);
						}
								
						impuestorentaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowImpuestoRentas()throws Exception {	
		if(impuestorentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ImpuestoRenta impuestorentaAux:impuestorentas) {
					if(impuestorentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(impuestorentaAux.getIsDeleted() || (impuestorentaAux.getIsChanged()&&!impuestorentaAux.getIsNew())) {
						
						timestamp=impuestorentaDataAccess.getSetVersionRowImpuestoRenta(connexion,impuestorentaAux.getId());
						
						if(!impuestorentaAux.getVersionRow().equals(timestamp)) {	
							impuestorentaAux.setVersionRow(timestamp);
						}
						
													
						impuestorentaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ImpuestoRentaParameterReturnGeneral cargarCombosLoteForeignKeyImpuestoRentaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		ImpuestoRentaParameterReturnGeneral  impuestorentaReturnGeneral =new ImpuestoRentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyImpuestoRentaWithConnection");connexion.begin();
			
			impuestorentaReturnGeneral =new ImpuestoRentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			impuestorentaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return impuestorentaReturnGeneral;
	}
	
	public ImpuestoRentaParameterReturnGeneral cargarCombosLoteForeignKeyImpuestoRenta(String finalQueryGlobalEmpresa) throws Exception {
		ImpuestoRentaParameterReturnGeneral  impuestorentaReturnGeneral =new ImpuestoRentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			impuestorentaReturnGeneral =new ImpuestoRentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			impuestorentaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return impuestorentaReturnGeneral;
	}
	
	
	public void deepLoad(ImpuestoRenta impuestorenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ImpuestoRentaLogicAdditional.updateImpuestoRentaToGet(impuestorenta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		impuestorenta.setEmpresa(impuestorentaDataAccess.getEmpresa(connexion,impuestorenta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				impuestorenta.setEmpresa(impuestorentaDataAccess.getEmpresa(connexion,impuestorenta));
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
			impuestorenta.setEmpresa(impuestorentaDataAccess.getEmpresa(connexion,impuestorenta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		impuestorenta.setEmpresa(impuestorentaDataAccess.getEmpresa(connexion,impuestorenta));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(impuestorenta.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				impuestorenta.setEmpresa(impuestorentaDataAccess.getEmpresa(connexion,impuestorenta));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(impuestorenta.getEmpresa(),isDeep,deepLoadType,clases);				
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
			impuestorenta.setEmpresa(impuestorentaDataAccess.getEmpresa(connexion,impuestorenta));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(impuestorenta.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ImpuestoRenta impuestorenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ImpuestoRentaLogicAdditional.updateImpuestoRentaToSave(impuestorenta,this.arrDatoGeneral);
			
ImpuestoRentaDataAccess.save(impuestorenta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(impuestorenta.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(impuestorenta.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(impuestorenta.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(impuestorenta.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(impuestorenta.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(impuestorenta.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ImpuestoRenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(impuestorenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(impuestorenta);
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
			this.deepLoad(this.impuestorenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ImpuestoRenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(impuestorentas!=null) {
				for(ImpuestoRenta impuestorenta:impuestorentas) {
					this.deepLoad(impuestorenta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(impuestorentas);
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
			if(impuestorentas!=null) {
				for(ImpuestoRenta impuestorenta:impuestorentas) {
					this.deepLoad(impuestorenta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(impuestorentas);
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
			this.getNewConnexionToDeep(ImpuestoRenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(impuestorenta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ImpuestoRenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(impuestorentas!=null) {
				for(ImpuestoRenta impuestorenta:impuestorentas) {
					this.deepSave(impuestorenta,isDeep,deepLoadType,clases);
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
			if(impuestorentas!=null) {
				for(ImpuestoRenta impuestorenta:impuestorentas) {
					this.deepSave(impuestorenta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getImpuestoRentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImpuestoRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ImpuestoRentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			impuestorentas=impuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImpuestoRentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ImpuestoRentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			impuestorentas=impuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesImpuestoRenta(this.impuestorentas);
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
			if(ImpuestoRentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ImpuestoRentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ImpuestoRenta impuestorenta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ImpuestoRentaConstantesFunciones.ISCONAUDITORIA) {
				if(impuestorenta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ImpuestoRentaDataAccess.TABLENAME, impuestorenta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ImpuestoRentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ImpuestoRentaLogic.registrarAuditoriaDetallesImpuestoRenta(connexion,impuestorenta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(impuestorenta.getIsDeleted()) {
					/*if(!impuestorenta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ImpuestoRentaDataAccess.TABLENAME, impuestorenta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ImpuestoRentaLogic.registrarAuditoriaDetallesImpuestoRenta(connexion,impuestorenta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ImpuestoRentaDataAccess.TABLENAME, impuestorenta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(impuestorenta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ImpuestoRentaDataAccess.TABLENAME, impuestorenta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ImpuestoRentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ImpuestoRentaLogic.registrarAuditoriaDetallesImpuestoRenta(connexion,impuestorenta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesImpuestoRenta(Connexion connexion,ImpuestoRenta impuestorenta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(impuestorenta.getIsNew()||!impuestorenta.getid_empresa().equals(impuestorenta.getImpuestoRentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(impuestorenta.getImpuestoRentaOriginal().getid_empresa()!=null)
				{
					strValorActual=impuestorenta.getImpuestoRentaOriginal().getid_empresa().toString();
				}
				if(impuestorenta.getid_empresa()!=null)
				{
					strValorNuevo=impuestorenta.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImpuestoRentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(impuestorenta.getIsNew()||!impuestorenta.getdesde().equals(impuestorenta.getImpuestoRentaOriginal().getdesde()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(impuestorenta.getImpuestoRentaOriginal().getdesde()!=null)
				{
					strValorActual=impuestorenta.getImpuestoRentaOriginal().getdesde().toString();
				}
				if(impuestorenta.getdesde()!=null)
				{
					strValorNuevo=impuestorenta.getdesde().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImpuestoRentaConstantesFunciones.DESDE,strValorActual,strValorNuevo);
			}	
			
			if(impuestorenta.getIsNew()||!impuestorenta.gethasta().equals(impuestorenta.getImpuestoRentaOriginal().gethasta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(impuestorenta.getImpuestoRentaOriginal().gethasta()!=null)
				{
					strValorActual=impuestorenta.getImpuestoRentaOriginal().gethasta().toString();
				}
				if(impuestorenta.gethasta()!=null)
				{
					strValorNuevo=impuestorenta.gethasta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImpuestoRentaConstantesFunciones.HASTA,strValorActual,strValorNuevo);
			}	
			
			if(impuestorenta.getIsNew()||!impuestorenta.getimpuesto().equals(impuestorenta.getImpuestoRentaOriginal().getimpuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(impuestorenta.getImpuestoRentaOriginal().getimpuesto()!=null)
				{
					strValorActual=impuestorenta.getImpuestoRentaOriginal().getimpuesto().toString();
				}
				if(impuestorenta.getimpuesto()!=null)
				{
					strValorNuevo=impuestorenta.getimpuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImpuestoRentaConstantesFunciones.IMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(impuestorenta.getIsNew()||!impuestorenta.getporcentaje().equals(impuestorenta.getImpuestoRentaOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(impuestorenta.getImpuestoRentaOriginal().getporcentaje()!=null)
				{
					strValorActual=impuestorenta.getImpuestoRentaOriginal().getporcentaje().toString();
				}
				if(impuestorenta.getporcentaje()!=null)
				{
					strValorNuevo=impuestorenta.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImpuestoRentaConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveImpuestoRentaRelacionesWithConnection(ImpuestoRenta impuestorenta) throws Exception {

		if(!impuestorenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveImpuestoRentaRelacionesBase(impuestorenta,true);
		}
	}

	public void saveImpuestoRentaRelaciones(ImpuestoRenta impuestorenta)throws Exception {

		if(!impuestorenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveImpuestoRentaRelacionesBase(impuestorenta,false);
		}
	}

	public void saveImpuestoRentaRelacionesBase(ImpuestoRenta impuestorenta,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ImpuestoRenta-saveRelacionesWithConnection");}
	

			this.setImpuestoRenta(impuestorenta);

			if(ImpuestoRentaLogicAdditional.validarSaveRelaciones(impuestorenta,this)) {

				ImpuestoRentaLogicAdditional.updateRelacionesToSave(impuestorenta,this);

				if((impuestorenta.getIsNew()||impuestorenta.getIsChanged())&&!impuestorenta.getIsDeleted()) {
					this.saveImpuestoRenta();
					this.saveImpuestoRentaRelacionesDetalles();

				} else if(impuestorenta.getIsDeleted()) {
					this.saveImpuestoRentaRelacionesDetalles();
					this.saveImpuestoRenta();
				}

				ImpuestoRentaLogicAdditional.updateRelacionesToSaveAfter(impuestorenta,this);

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
	
	
	private void saveImpuestoRentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ImpuestoRentaConstantesFunciones.getClassesForeignKeysOfImpuestoRenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ImpuestoRentaConstantesFunciones.getClassesRelationshipsOfImpuestoRenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
