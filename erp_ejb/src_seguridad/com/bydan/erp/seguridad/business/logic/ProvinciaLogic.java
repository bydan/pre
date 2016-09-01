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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.ProvinciaConstantesFunciones;
import com.bydan.erp.seguridad.util.ProvinciaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ProvinciaParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Provincia;
import com.bydan.erp.seguridad.business.logic.ProvinciaLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProvinciaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProvinciaLogic.class);
	
	protected ProvinciaDataAccess provinciaDataAccess; 	
	protected Provincia provincia;
	protected List<Provincia> provincias;
	protected Object provinciaObject;	
	protected List<Object> provinciasObject;
	
	public static ClassValidator<Provincia> provinciaValidator = new ClassValidator<Provincia>(Provincia.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProvinciaLogicAdditional provinciaLogicAdditional=null;
	
	public ProvinciaLogicAdditional getProvinciaLogicAdditional() {
		return this.provinciaLogicAdditional;
	}
	
	public void setProvinciaLogicAdditional(ProvinciaLogicAdditional provinciaLogicAdditional) {
		try {
			this.provinciaLogicAdditional=provinciaLogicAdditional;
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
	
	
	
	
	public  ProvinciaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.provinciaDataAccess = new ProvinciaDataAccess();
			
			this.provincias= new ArrayList<Provincia>();
			this.provincia= new Provincia();
			
			this.provinciaObject=new Object();
			this.provinciasObject=new ArrayList<Object>();
				
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
			
			this.provinciaDataAccess.setConnexionType(this.connexionType);
			this.provinciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProvinciaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.provinciaDataAccess = new ProvinciaDataAccess();
			this.provincias= new ArrayList<Provincia>();
			this.provincia= new Provincia();
			this.provinciaObject=new Object();
			this.provinciasObject=new ArrayList<Object>();
			
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
			
			this.provinciaDataAccess.setConnexionType(this.connexionType);
			this.provinciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Provincia getProvincia() throws Exception {	
		ProvinciaLogicAdditional.checkProvinciaToGet(provincia,this.datosCliente,this.arrDatoGeneral);
		ProvinciaLogicAdditional.updateProvinciaToGet(provincia,this.arrDatoGeneral);
		
		return provincia;
	}
		
	public void setProvincia(Provincia newProvincia) {
		this.provincia = newProvincia;
	}
	
	public ProvinciaDataAccess getProvinciaDataAccess() {
		return provinciaDataAccess;
	}
	
	public void setProvinciaDataAccess(ProvinciaDataAccess newprovinciaDataAccess) {
		this.provinciaDataAccess = newprovinciaDataAccess;
	}
	
	public List<Provincia> getProvincias() throws Exception {		
		this.quitarProvinciasNulos();
		
		ProvinciaLogicAdditional.checkProvinciaToGets(provincias,this.datosCliente,this.arrDatoGeneral);
		
		for (Provincia provinciaLocal: provincias ) {
			ProvinciaLogicAdditional.updateProvinciaToGet(provinciaLocal,this.arrDatoGeneral);
		}
		
		return provincias;
	}
	
	public void setProvincias(List<Provincia> newProvincias) {
		this.provincias = newProvincias;
	}
	
	public Object getProvinciaObject() {	
		this.provinciaObject=this.provinciaDataAccess.getEntityObject();
		return this.provinciaObject;
	}
		
	public void setProvinciaObject(Object newProvinciaObject) {
		this.provinciaObject = newProvinciaObject;
	}
	
	public List<Object> getProvinciasObject() {		
		this.provinciasObject=this.provinciaDataAccess.getEntitiesObject();
		return this.provinciasObject;
	}
		
	public void setProvinciasObject(List<Object> newProvinciasObject) {
		this.provinciasObject = newProvinciasObject;
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
		
		if(this.provinciaDataAccess!=null) {
			this.provinciaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			provinciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			provinciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		provincia = new  Provincia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			provincia=provinciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.provincia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincia);
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
		provincia = new  Provincia();
		  		  
        try {
			
			provincia=provinciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.provincia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		provincia = new  Provincia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			provincia=provinciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.provincia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincia);
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
		provincia = new  Provincia();
		  		  
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
		provincia = new  Provincia();
		  		  
        try {
			
			provincia=provinciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.provincia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		provincia = new  Provincia();
		  		  
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
		provincia = new  Provincia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =provinciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		provincia = new  Provincia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=provinciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		provincia = new  Provincia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =provinciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		provincia = new  Provincia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=provinciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		provincia = new  Provincia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =provinciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		provincia = new  Provincia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=provinciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		provincias = new  ArrayList<Provincia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincias=provinciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProvincia(provincias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
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
		provincias = new  ArrayList<Provincia>();
		  		  
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
		provincias = new  ArrayList<Provincia>();
		  		  
        try {			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincias=provinciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProvincia(provincias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		provincias = new  ArrayList<Provincia>();
		  		  
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
		provincias = new  ArrayList<Provincia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincias=provinciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProvincia(provincias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
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
		provincias = new  ArrayList<Provincia>();
		  		  
        try {
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincias=provinciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProvincia(provincias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
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
		provincias = new  ArrayList<Provincia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincias=provinciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProvincia(provincias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
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
		provincias = new  ArrayList<Provincia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincias=provinciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProvincia(provincias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		provincia = new  Provincia();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincia=provinciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProvincia(provincia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincia);
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
		provincia = new  Provincia();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincia=provinciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProvincia(provincia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		provincias = new  ArrayList<Provincia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincias=provinciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProvincia(provincias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
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
		provincias = new  ArrayList<Provincia>();
		  		  
        try {
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincias=provinciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProvincia(provincias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProvinciasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		provincias = new  ArrayList<Provincia>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getTodosProvinciasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincias=provinciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProvincia(provincias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
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
	
	public  void  getTodosProvincias(String sFinalQuery,Pagination pagination)throws Exception {
		provincias = new  ArrayList<Provincia>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provincias=provinciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProvincia(provincias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProvincia(Provincia provincia) throws Exception {
		Boolean estaValidado=false;
		
		if(provincia.getIsNew() || provincia.getIsChanged()) { 
			this.invalidValues = provinciaValidator.getInvalidValues(provincia);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(provincia);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProvincia(List<Provincia> Provincias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Provincia provinciaLocal:provincias) {				
			estaValidadoObjeto=this.validarGuardarProvincia(provinciaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProvincia(List<Provincia> Provincias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProvincia(provincias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProvincia(Provincia Provincia) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProvincia(provincia)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Provincia provincia) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+provincia.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProvinciaConstantesFunciones.getProvinciaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"provincia","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProvinciaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProvinciaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProvinciaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-saveProvinciaWithConnection");connexion.begin();			
			
			ProvinciaLogicAdditional.checkProvinciaToSave(this.provincia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProvinciaLogicAdditional.updateProvinciaToSave(this.provincia,this.arrDatoGeneral);
			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.provincia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProvincia();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProvincia(this.provincia)) {
				ProvinciaDataAccess.save(this.provincia, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.provincia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProvinciaLogicAdditional.checkProvinciaToSaveAfter(this.provincia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProvincia();
			
			connexion.commit();			
			
			if(this.provincia.getIsDeleted()) {
				this.provincia=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProvincia()throws Exception {	
		try {	
			
			ProvinciaLogicAdditional.checkProvinciaToSave(this.provincia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProvinciaLogicAdditional.updateProvinciaToSave(this.provincia,this.arrDatoGeneral);
			
			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.provincia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProvincia(this.provincia)) {			
				ProvinciaDataAccess.save(this.provincia, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.provincia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProvinciaLogicAdditional.checkProvinciaToSaveAfter(this.provincia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.provincia.getIsDeleted()) {
				this.provincia=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProvinciasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-saveProvinciasWithConnection");connexion.begin();			
			
			ProvinciaLogicAdditional.checkProvinciaToSaves(provincias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProvincias();
			
			Boolean validadoTodosProvincia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Provincia provinciaLocal:provincias) {		
				if(provinciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProvinciaLogicAdditional.updateProvinciaToSave(provinciaLocal,this.arrDatoGeneral);
	        	
				ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),provinciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProvincia(provinciaLocal)) {
					ProvinciaDataAccess.save(provinciaLocal, connexion);				
				} else {
					validadoTodosProvincia=false;
				}
			}
			
			if(!validadoTodosProvincia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProvinciaLogicAdditional.checkProvinciaToSavesAfter(provincias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProvincias();
			
			connexion.commit();		
			
			this.quitarProvinciasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProvincias()throws Exception {				
		 try {	
			ProvinciaLogicAdditional.checkProvinciaToSaves(provincias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProvincia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Provincia provinciaLocal:provincias) {				
				if(provinciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProvinciaLogicAdditional.updateProvinciaToSave(provinciaLocal,this.arrDatoGeneral);
	        	
				ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),provinciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProvincia(provinciaLocal)) {				
					ProvinciaDataAccess.save(provinciaLocal, connexion);				
				} else {
					validadoTodosProvincia=false;
				}
			}
			
			if(!validadoTodosProvincia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProvinciaLogicAdditional.checkProvinciaToSavesAfter(provincias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProvinciasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProvinciaParameterReturnGeneral procesarAccionProvincias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Provincia> provincias,ProvinciaParameterReturnGeneral provinciaParameterGeneral)throws Exception {
		 try {	
			ProvinciaParameterReturnGeneral provinciaReturnGeneral=new ProvinciaParameterReturnGeneral();
	
			ProvinciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,provincias,provinciaParameterGeneral,provinciaReturnGeneral);
			
			return provinciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProvinciaParameterReturnGeneral procesarAccionProvinciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Provincia> provincias,ProvinciaParameterReturnGeneral provinciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-procesarAccionProvinciasWithConnection");connexion.begin();			
			
			ProvinciaParameterReturnGeneral provinciaReturnGeneral=new ProvinciaParameterReturnGeneral();
	
			ProvinciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,provincias,provinciaParameterGeneral,provinciaReturnGeneral);
			
			this.connexion.commit();
			
			return provinciaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProvinciaParameterReturnGeneral procesarEventosProvincias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Provincia> provincias,Provincia provincia,ProvinciaParameterReturnGeneral provinciaParameterGeneral,Boolean isEsNuevoProvincia,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProvinciaParameterReturnGeneral provinciaReturnGeneral=new ProvinciaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				provinciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProvinciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,provincias,provincia,provinciaParameterGeneral,provinciaReturnGeneral,isEsNuevoProvincia,clases);
			
			return provinciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProvinciaParameterReturnGeneral procesarEventosProvinciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Provincia> provincias,Provincia provincia,ProvinciaParameterReturnGeneral provinciaParameterGeneral,Boolean isEsNuevoProvincia,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-procesarEventosProvinciasWithConnection");connexion.begin();			
			
			ProvinciaParameterReturnGeneral provinciaReturnGeneral=new ProvinciaParameterReturnGeneral();
	
			provinciaReturnGeneral.setProvincia(provincia);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				provinciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProvinciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,provincias,provincia,provinciaParameterGeneral,provinciaReturnGeneral,isEsNuevoProvincia,clases);
			
			this.connexion.commit();
			
			return provinciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProvinciaParameterReturnGeneral procesarImportacionProvinciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProvinciaParameterReturnGeneral provinciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-procesarImportacionProvinciasWithConnection");connexion.begin();			
			
			ProvinciaParameterReturnGeneral provinciaReturnGeneral=new ProvinciaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.provincias=new ArrayList<Provincia>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.provincia=new Provincia();
				
				
				if(conColumnasBase) {this.provincia.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.provincia.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.provincia.setcodigo(arrColumnas[iColumn++]);
			this.provincia.setnombre(arrColumnas[iColumn++]);
				
				this.provincias.add(this.provincia);
			}
			
			this.saveProvincias();
			
			this.connexion.commit();
			
			provinciaReturnGeneral.setConRetornoEstaProcesado(true);
			provinciaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return provinciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProvinciasEliminados() throws Exception {				
		
		List<Provincia> provinciasAux= new ArrayList<Provincia>();
		
		for(Provincia provincia:provincias) {
			if(!provincia.getIsDeleted()) {
				provinciasAux.add(provincia);
			}
		}
		
		provincias=provinciasAux;
	}
	
	public void quitarProvinciasNulos() throws Exception {				
		
		List<Provincia> provinciasAux= new ArrayList<Provincia>();
		
		for(Provincia provincia : this.provincias) {
			if(provincia==null) {
				provinciasAux.add(provincia);
			}
		}
		
		//this.provincias=provinciasAux;
		
		this.provincias.removeAll(provinciasAux);
	}
	
	public void getSetVersionRowProvinciaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(provincia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((provincia.getIsDeleted() || (provincia.getIsChanged()&&!provincia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=provinciaDataAccess.getSetVersionRowProvincia(connexion,provincia.getId());
				
				if(!provincia.getVersionRow().equals(timestamp)) {	
					provincia.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				provincia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProvincia()throws Exception {	
		
		if(provincia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((provincia.getIsDeleted() || (provincia.getIsChanged()&&!provincia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=provinciaDataAccess.getSetVersionRowProvincia(connexion,provincia.getId());
			
			try {							
				if(!provincia.getVersionRow().equals(timestamp)) {	
					provincia.setVersionRow(timestamp);
				}
				
				provincia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProvinciasWithConnection()throws Exception {	
		if(provincias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Provincia provinciaAux:provincias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(provinciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(provinciaAux.getIsDeleted() || (provinciaAux.getIsChanged()&&!provinciaAux.getIsNew())) {
						
						timestamp=provinciaDataAccess.getSetVersionRowProvincia(connexion,provinciaAux.getId());
						
						if(!provincia.getVersionRow().equals(timestamp)) {	
							provinciaAux.setVersionRow(timestamp);
						}
								
						provinciaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProvincias()throws Exception {	
		if(provincias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Provincia provinciaAux:provincias) {
					if(provinciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(provinciaAux.getIsDeleted() || (provinciaAux.getIsChanged()&&!provinciaAux.getIsNew())) {
						
						timestamp=provinciaDataAccess.getSetVersionRowProvincia(connexion,provinciaAux.getId());
						
						if(!provinciaAux.getVersionRow().equals(timestamp)) {	
							provinciaAux.setVersionRow(timestamp);
						}
						
													
						provinciaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProvinciaParameterReturnGeneral cargarCombosLoteForeignKeyProvinciaWithConnection(String finalQueryGlobalPais,String finalQueryGlobalRegion) throws Exception {
		ProvinciaParameterReturnGeneral  provinciaReturnGeneral =new ProvinciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-cargarCombosLoteForeignKeyProvinciaWithConnection");connexion.begin();
			
			provinciaReturnGeneral =new ProvinciaParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			provinciaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Region> regionsForeignKey=new ArrayList<Region>();
			RegionLogic regionLogic=new RegionLogic();
			regionLogic.setConnexion(this.connexion);
			regionLogic.getRegionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRegion.equals("NONE")) {
				regionLogic.getTodosRegions(finalQueryGlobalRegion,new Pagination());
				regionsForeignKey=regionLogic.getRegions();
			}

			provinciaReturnGeneral.setregionsForeignKey(regionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return provinciaReturnGeneral;
	}
	
	public ProvinciaParameterReturnGeneral cargarCombosLoteForeignKeyProvincia(String finalQueryGlobalPais,String finalQueryGlobalRegion) throws Exception {
		ProvinciaParameterReturnGeneral  provinciaReturnGeneral =new ProvinciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			provinciaReturnGeneral =new ProvinciaParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			provinciaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Region> regionsForeignKey=new ArrayList<Region>();
			RegionLogic regionLogic=new RegionLogic();
			regionLogic.setConnexion(this.connexion);
			regionLogic.getRegionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRegion.equals("NONE")) {
				regionLogic.getTodosRegions(finalQueryGlobalRegion,new Pagination());
				regionsForeignKey=regionLogic.getRegions();
			}

			provinciaReturnGeneral.setregionsForeignKey(regionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return provinciaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyProvinciaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			BarrioLogic barrioLogic=new BarrioLogic();
			CantonLogic cantonLogic=new CantonLogic();
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic=new DatoGeneralEmpleadoLogic();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			ClienteLogic clienteLogic=new ClienteLogic();
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic=new ParametroCarteraDefectoLogic();
			CiudadLogic ciudadLogic=new CiudadLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyProvinciaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Barrio.class));
			classes.add(new Classe(Canton.class));
			classes.add(new Classe(DatoGeneralEmpleado.class));
			classes.add(new Classe(Empleado.class));
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(ParametroCarteraDefecto.class));
			classes.add(new Classe(Ciudad.class));
											
			

			barrioLogic.setConnexion(this.getConnexion());
			barrioLogic.setDatosCliente(this.datosCliente);
			barrioLogic.setIsConRefrescarForeignKeys(true);

			cantonLogic.setConnexion(this.getConnexion());
			cantonLogic.setDatosCliente(this.datosCliente);
			cantonLogic.setIsConRefrescarForeignKeys(true);

			datogeneralempleadoLogic.setConnexion(this.getConnexion());
			datogeneralempleadoLogic.setDatosCliente(this.datosCliente);
			datogeneralempleadoLogic.setIsConRefrescarForeignKeys(true);

			empleadoLogic.setConnexion(this.getConnexion());
			empleadoLogic.setDatosCliente(this.datosCliente);
			empleadoLogic.setIsConRefrescarForeignKeys(true);

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			parametrocarteradefectoLogic.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic.setDatosCliente(this.datosCliente);
			parametrocarteradefectoLogic.setIsConRefrescarForeignKeys(true);

			ciudadLogic.setConnexion(this.getConnexion());
			ciudadLogic.setDatosCliente(this.datosCliente);
			ciudadLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Provincia provincia:this.provincias) {
				

				classes=new ArrayList<Classe>();
				classes=BarrioConstantesFunciones.getClassesForeignKeysOfBarrio(new ArrayList<Classe>(),DeepLoadType.NONE);

				barrioLogic.setBarrios(provincia.barrios);
				barrioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CantonConstantesFunciones.getClassesForeignKeysOfCanton(new ArrayList<Classe>(),DeepLoadType.NONE);

				cantonLogic.setCantons(provincia.cantons);
				cantonLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				datogeneralempleadoLogic.setDatoGeneralEmpleados(provincia.datogeneralempleados);
				datogeneralempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoLogic.setEmpleados(provincia.empleados);
				empleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(provincia.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocarteradefectoLogic.setParametroCarteraDefectos(provincia.parametrocarteradefectos);
				parametrocarteradefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CiudadConstantesFunciones.getClassesForeignKeysOfCiudad(new ArrayList<Classe>(),DeepLoadType.NONE);

				ciudadLogic.setCiudads(provincia.ciudads);
				ciudadLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Provincia provincia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProvinciaLogicAdditional.updateProvinciaToGet(provincia,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		provincia.setPais(provinciaDataAccess.getPais(connexion,provincia));
		provincia.setRegion(provinciaDataAccess.getRegion(connexion,provincia));
		provincia.setCiudads(provinciaDataAccess.getCiudads(connexion,provincia));
		provincia.setClientes(provinciaDataAccess.getClientes(connexion,provincia));
		provincia.setCantons(provinciaDataAccess.getCantons(connexion,provincia));
		provincia.setBarrios(provinciaDataAccess.getBarrios(connexion,provincia));
		provincia.setEmpleados(provinciaDataAccess.getEmpleados(connexion,provincia));
		provincia.setDatoGeneralEmpleados(provinciaDataAccess.getDatoGeneralEmpleados(connexion,provincia));
		provincia.setParametroCarteraDefectos(provinciaDataAccess.getParametroCarteraDefectos(connexion,provincia));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				provincia.setPais(provinciaDataAccess.getPais(connexion,provincia));
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				provincia.setRegion(provinciaDataAccess.getRegion(connexion,provincia));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setCiudads(provinciaDataAccess.getCiudads(connexion,provincia));

				if(this.isConDeep) {
					CiudadLogic ciudadLogic= new CiudadLogic(this.connexion);
					ciudadLogic.setCiudads(provincia.getCiudads());
					ArrayList<Classe> classesLocal=CiudadConstantesFunciones.getClassesForeignKeysOfCiudad(new ArrayList<Classe>(),DeepLoadType.NONE);
					ciudadLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(ciudadLogic.getCiudads());
					provincia.setCiudads(ciudadLogic.getCiudads());
				}

				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setClientes(provinciaDataAccess.getClientes(connexion,provincia));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(provincia.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					provincia.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(Canton.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setCantons(provinciaDataAccess.getCantons(connexion,provincia));

				if(this.isConDeep) {
					CantonLogic cantonLogic= new CantonLogic(this.connexion);
					cantonLogic.setCantons(provincia.getCantons());
					ArrayList<Classe> classesLocal=CantonConstantesFunciones.getClassesForeignKeysOfCanton(new ArrayList<Classe>(),DeepLoadType.NONE);
					cantonLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CantonConstantesFunciones.refrescarForeignKeysDescripcionesCanton(cantonLogic.getCantons());
					provincia.setCantons(cantonLogic.getCantons());
				}

				continue;
			}

			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setBarrios(provinciaDataAccess.getBarrios(connexion,provincia));

				if(this.isConDeep) {
					BarrioLogic barrioLogic= new BarrioLogic(this.connexion);
					barrioLogic.setBarrios(provincia.getBarrios());
					ArrayList<Classe> classesLocal=BarrioConstantesFunciones.getClassesForeignKeysOfBarrio(new ArrayList<Classe>(),DeepLoadType.NONE);
					barrioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(barrioLogic.getBarrios());
					provincia.setBarrios(barrioLogic.getBarrios());
				}

				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setEmpleados(provinciaDataAccess.getEmpleados(connexion,provincia));

				if(this.isConDeep) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(this.connexion);
					empleadoLogic.setEmpleados(provincia.getEmpleados());
					ArrayList<Classe> classesLocal=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleadoLogic.getEmpleados());
					provincia.setEmpleados(empleadoLogic.getEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setDatoGeneralEmpleados(provinciaDataAccess.getDatoGeneralEmpleados(connexion,provincia));

				if(this.isConDeep) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(this.connexion);
					datogeneralempleadoLogic.setDatoGeneralEmpleados(provincia.getDatoGeneralEmpleados());
					ArrayList<Classe> classesLocal=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					datogeneralempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleadoLogic.getDatoGeneralEmpleados());
					provincia.setDatoGeneralEmpleados(datogeneralempleadoLogic.getDatoGeneralEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setParametroCarteraDefectos(provinciaDataAccess.getParametroCarteraDefectos(connexion,provincia));

				if(this.isConDeep) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(this.connexion);
					parametrocarteradefectoLogic.setParametroCarteraDefectos(provincia.getParametroCarteraDefectos());
					ArrayList<Classe> classesLocal=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocarteradefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectoLogic.getParametroCarteraDefectos());
					provincia.setParametroCarteraDefectos(parametrocarteradefectoLogic.getParametroCarteraDefectos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provincia.setPais(provinciaDataAccess.getPais(connexion,provincia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provincia.setRegion(provinciaDataAccess.getRegion(connexion,provincia));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Ciudad.class));
			provincia.setCiudads(provinciaDataAccess.getCiudads(connexion,provincia));
		}

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
			provincia.setClientes(provinciaDataAccess.getClientes(connexion,provincia));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Canton.class));
			provincia.setCantons(provinciaDataAccess.getCantons(connexion,provincia));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Barrio.class));
			provincia.setBarrios(provinciaDataAccess.getBarrios(connexion,provincia));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			provincia.setEmpleados(provinciaDataAccess.getEmpleados(connexion,provincia));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			provincia.setDatoGeneralEmpleados(provinciaDataAccess.getDatoGeneralEmpleados(connexion,provincia));
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
			provincia.setParametroCarteraDefectos(provinciaDataAccess.getParametroCarteraDefectos(connexion,provincia));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		provincia.setPais(provinciaDataAccess.getPais(connexion,provincia));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(provincia.getPais(),isDeep,deepLoadType,clases);
				
		provincia.setRegion(provinciaDataAccess.getRegion(connexion,provincia));
		RegionLogic regionLogic= new RegionLogic(connexion);
		regionLogic.deepLoad(provincia.getRegion(),isDeep,deepLoadType,clases);
				

		provincia.setCiudads(provinciaDataAccess.getCiudads(connexion,provincia));

		for(Ciudad ciudad:provincia.getCiudads()) {
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(ciudad,isDeep,deepLoadType,clases);
		}

		provincia.setClientes(provinciaDataAccess.getClientes(connexion,provincia));

		for(Cliente cliente:provincia.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		provincia.setCantons(provinciaDataAccess.getCantons(connexion,provincia));

		for(Canton canton:provincia.getCantons()) {
			CantonLogic cantonLogic= new CantonLogic(connexion);
			cantonLogic.deepLoad(canton,isDeep,deepLoadType,clases);
		}

		provincia.setBarrios(provinciaDataAccess.getBarrios(connexion,provincia));

		for(Barrio barrio:provincia.getBarrios()) {
			BarrioLogic barrioLogic= new BarrioLogic(connexion);
			barrioLogic.deepLoad(barrio,isDeep,deepLoadType,clases);
		}

		provincia.setEmpleados(provinciaDataAccess.getEmpleados(connexion,provincia));

		for(Empleado empleado:provincia.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
		}

		provincia.setDatoGeneralEmpleados(provinciaDataAccess.getDatoGeneralEmpleados(connexion,provincia));

		for(DatoGeneralEmpleado datogeneralempleado:provincia.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
		}

		provincia.setParametroCarteraDefectos(provinciaDataAccess.getParametroCarteraDefectos(connexion,provincia));

		for(ParametroCarteraDefecto parametrocarteradefecto:provincia.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				provincia.setPais(provinciaDataAccess.getPais(connexion,provincia));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(provincia.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				provincia.setRegion(provinciaDataAccess.getRegion(connexion,provincia));
				RegionLogic regionLogic= new RegionLogic(connexion);
				regionLogic.deepLoad(provincia.getRegion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setCiudads(provinciaDataAccess.getCiudads(connexion,provincia));

				for(Ciudad ciudad:provincia.getCiudads()) {
					CiudadLogic ciudadLogic= new CiudadLogic(connexion);
					ciudadLogic.deepLoad(ciudad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setClientes(provinciaDataAccess.getClientes(connexion,provincia));

				for(Cliente cliente:provincia.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Canton.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setCantons(provinciaDataAccess.getCantons(connexion,provincia));

				for(Canton canton:provincia.getCantons()) {
					CantonLogic cantonLogic= new CantonLogic(connexion);
					cantonLogic.deepLoad(canton,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setBarrios(provinciaDataAccess.getBarrios(connexion,provincia));

				for(Barrio barrio:provincia.getBarrios()) {
					BarrioLogic barrioLogic= new BarrioLogic(connexion);
					barrioLogic.deepLoad(barrio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setEmpleados(provinciaDataAccess.getEmpleados(connexion,provincia));

				for(Empleado empleado:provincia.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setDatoGeneralEmpleados(provinciaDataAccess.getDatoGeneralEmpleados(connexion,provincia));

				for(DatoGeneralEmpleado datogeneralempleado:provincia.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				provincia.setParametroCarteraDefectos(provinciaDataAccess.getParametroCarteraDefectos(connexion,provincia));

				for(ParametroCarteraDefecto parametrocarteradefecto:provincia.getParametroCarteraDefectos()) {
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
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provincia.setPais(provinciaDataAccess.getPais(connexion,provincia));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(provincia.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provincia.setRegion(provinciaDataAccess.getRegion(connexion,provincia));
			RegionLogic regionLogic= new RegionLogic(connexion);
			regionLogic.deepLoad(provincia.getRegion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Ciudad.class));
			provincia.setCiudads(provinciaDataAccess.getCiudads(connexion,provincia));

			for(Ciudad ciudad:provincia.getCiudads()) {
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(ciudad,isDeep,deepLoadType,clases);
			}
		}

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
			provincia.setClientes(provinciaDataAccess.getClientes(connexion,provincia));

			for(Cliente cliente:provincia.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Canton.class));
			provincia.setCantons(provinciaDataAccess.getCantons(connexion,provincia));

			for(Canton canton:provincia.getCantons()) {
				CantonLogic cantonLogic= new CantonLogic(connexion);
				cantonLogic.deepLoad(canton,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Barrio.class));
			provincia.setBarrios(provinciaDataAccess.getBarrios(connexion,provincia));

			for(Barrio barrio:provincia.getBarrios()) {
				BarrioLogic barrioLogic= new BarrioLogic(connexion);
				barrioLogic.deepLoad(barrio,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			provincia.setEmpleados(provinciaDataAccess.getEmpleados(connexion,provincia));

			for(Empleado empleado:provincia.getEmpleados()) {
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			provincia.setDatoGeneralEmpleados(provinciaDataAccess.getDatoGeneralEmpleados(connexion,provincia));

			for(DatoGeneralEmpleado datogeneralempleado:provincia.getDatoGeneralEmpleados()) {
				DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
				datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
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
			provincia.setParametroCarteraDefectos(provinciaDataAccess.getParametroCarteraDefectos(connexion,provincia));

			for(ParametroCarteraDefecto parametrocarteradefecto:provincia.getParametroCarteraDefectos()) {
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
	
	public void deepSave(Provincia provincia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProvinciaLogicAdditional.updateProvinciaToSave(provincia,this.arrDatoGeneral);
			
ProvinciaDataAccess.save(provincia, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(provincia.getPais(),connexion);

		RegionDataAccess.save(provincia.getRegion(),connexion);

		for(Ciudad ciudad:provincia.getCiudads()) {
			ciudad.setid_provincia(provincia.getId());
			CiudadDataAccess.save(ciudad,connexion);
		}

		for(Cliente cliente:provincia.getClientes()) {
			cliente.setid_provincia(provincia.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(Canton canton:provincia.getCantons()) {
			canton.setid_provincia(provincia.getId());
			CantonDataAccess.save(canton,connexion);
		}

		for(Barrio barrio:provincia.getBarrios()) {
			barrio.setid_provincia(provincia.getId());
			BarrioDataAccess.save(barrio,connexion);
		}

		for(Empleado empleado:provincia.getEmpleados()) {
			empleado.setid_provincia(provincia.getId());
			EmpleadoDataAccess.save(empleado,connexion);
		}

		for(DatoGeneralEmpleado datogeneralempleado:provincia.getDatoGeneralEmpleados()) {
			datogeneralempleado.setid_provincia(provincia.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:provincia.getParametroCarteraDefectos()) {
			parametrocarteradefecto.setid_provincia(provincia.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(provincia.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				RegionDataAccess.save(provincia.getRegion(),connexion);
				continue;
			}


			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Ciudad ciudad:provincia.getCiudads()) {
					ciudad.setid_provincia(provincia.getId());
					CiudadDataAccess.save(ciudad,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:provincia.getClientes()) {
					cliente.setid_provincia(provincia.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Canton.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Canton canton:provincia.getCantons()) {
					canton.setid_provincia(provincia.getId());
					CantonDataAccess.save(canton,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Barrio barrio:provincia.getBarrios()) {
					barrio.setid_provincia(provincia.getId());
					BarrioDataAccess.save(barrio,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:provincia.getEmpleados()) {
					empleado.setid_provincia(provincia.getId());
					EmpleadoDataAccess.save(empleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:provincia.getDatoGeneralEmpleados()) {
					datogeneralempleado.setid_provincia(provincia.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:provincia.getParametroCarteraDefectos()) {
					parametrocarteradefecto.setid_provincia(provincia.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PaisDataAccess.save(provincia.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(provincia.getPais(),isDeep,deepLoadType,clases);
				

		RegionDataAccess.save(provincia.getRegion(),connexion);
		RegionLogic regionLogic= new RegionLogic(connexion);
		regionLogic.deepLoad(provincia.getRegion(),isDeep,deepLoadType,clases);
				

		for(Ciudad ciudad:provincia.getCiudads()) {
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudad.setid_provincia(provincia.getId());
			CiudadDataAccess.save(ciudad,connexion);
			ciudadLogic.deepSave(ciudad,isDeep,deepLoadType,clases);
		}

		for(Cliente cliente:provincia.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_provincia(provincia.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(Canton canton:provincia.getCantons()) {
			CantonLogic cantonLogic= new CantonLogic(connexion);
			canton.setid_provincia(provincia.getId());
			CantonDataAccess.save(canton,connexion);
			cantonLogic.deepSave(canton,isDeep,deepLoadType,clases);
		}

		for(Barrio barrio:provincia.getBarrios()) {
			BarrioLogic barrioLogic= new BarrioLogic(connexion);
			barrio.setid_provincia(provincia.getId());
			BarrioDataAccess.save(barrio,connexion);
			barrioLogic.deepSave(barrio,isDeep,deepLoadType,clases);
		}

		for(Empleado empleado:provincia.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleado.setid_provincia(provincia.getId());
			EmpleadoDataAccess.save(empleado,connexion);
			empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
		}

		for(DatoGeneralEmpleado datogeneralempleado:provincia.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleado.setid_provincia(provincia.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
			datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:provincia.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefecto.setid_provincia(provincia.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
			parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(provincia.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(provincia.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				RegionDataAccess.save(provincia.getRegion(),connexion);
				RegionLogic regionLogic= new RegionLogic(connexion);
				regionLogic.deepSave(provincia.getRegion(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Ciudad ciudad:provincia.getCiudads()) {
					CiudadLogic ciudadLogic= new CiudadLogic(connexion);
					ciudad.setid_provincia(provincia.getId());
					CiudadDataAccess.save(ciudad,connexion);
					ciudadLogic.deepSave(ciudad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:provincia.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_provincia(provincia.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Canton.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Canton canton:provincia.getCantons()) {
					CantonLogic cantonLogic= new CantonLogic(connexion);
					canton.setid_provincia(provincia.getId());
					CantonDataAccess.save(canton,connexion);
					cantonLogic.deepSave(canton,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Barrio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Barrio barrio:provincia.getBarrios()) {
					BarrioLogic barrioLogic= new BarrioLogic(connexion);
					barrio.setid_provincia(provincia.getId());
					BarrioDataAccess.save(barrio,connexion);
					barrioLogic.deepSave(barrio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:provincia.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleado.setid_provincia(provincia.getId());
					EmpleadoDataAccess.save(empleado,connexion);
					empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:provincia.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleado.setid_provincia(provincia.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
					datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:provincia.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefecto.setid_provincia(provincia.getId());
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
			this.getNewConnexionToDeep(Provincia.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(provincia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(provincia);
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
			this.deepLoad(this.provincia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Provincia.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(provincias!=null) {
				for(Provincia provincia:provincias) {
					this.deepLoad(provincia,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(provincias);
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
			if(provincias!=null) {
				for(Provincia provincia:provincias) {
					this.deepLoad(provincia,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(provincias);
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
			this.getNewConnexionToDeep(Provincia.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(provincia,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Provincia.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(provincias!=null) {
				for(Provincia provincia:provincias) {
					this.deepSave(provincia,isDeep,deepLoadType,clases);
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
			if(provincias!=null) {
				for(Provincia provincia:provincias) {
					this.deepSave(provincia,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProvinciasBusquedaPorIdPaisPorNombreWithConnection(String sFinalQuery,Pagination pagination,Long id_pais,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ProvinciaConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ProvinciaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdPaisPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provincias=provinciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvinciasBusquedaPorIdPaisPorNombre(String sFinalQuery,Pagination pagination,Long id_pais,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ProvinciaConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ProvinciaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdPaisPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provincias=provinciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProvinciasFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ProvinciaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provincias=provinciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvinciasFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ProvinciaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provincias=provinciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProvinciasFK_IdRegionWithConnection(String sFinalQuery,Pagination pagination,Long id_region)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRegion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRegion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_region,ProvinciaConstantesFunciones.IDREGION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRegion);

			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRegion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provincias=provinciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvinciasFK_IdRegion(String sFinalQuery,Pagination pagination,Long id_region)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRegion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRegion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_region,ProvinciaConstantesFunciones.IDREGION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRegion);

			ProvinciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRegion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provincias=provinciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProvinciaPorIdPaisPorNombreWithConnection(Long id_pais,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ProvinciaConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,ProvinciaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			provincia=provinciaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.provincia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincia);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvinciaPorIdPaisPorNombre(Long id_pais,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ProvinciaConstantesFunciones.IDPAIS,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,ProvinciaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			provincia=provinciaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.provincia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincia);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProvinciaPorIdPorIdPaisWithConnection(Long id,Long id_pais)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Provincia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,ProvinciaConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ProvinciaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			provincia=provinciaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.provincia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincia);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvinciaPorIdPorIdPais(Long id,Long id_pais)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,ProvinciaConstantesFunciones.ID,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ProvinciaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			provincia=provinciaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.provincia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(this.provincia);
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
			if(ProvinciaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProvinciaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Provincia provincia,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProvinciaConstantesFunciones.ISCONAUDITORIA) {
				if(provincia.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProvinciaDataAccess.TABLENAME, provincia.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProvinciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProvinciaLogic.registrarAuditoriaDetallesProvincia(connexion,provincia,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(provincia.getIsDeleted()) {
					/*if(!provincia.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProvinciaDataAccess.TABLENAME, provincia.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProvinciaLogic.registrarAuditoriaDetallesProvincia(connexion,provincia,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProvinciaDataAccess.TABLENAME, provincia.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(provincia.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProvinciaDataAccess.TABLENAME, provincia.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProvinciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProvinciaLogic.registrarAuditoriaDetallesProvincia(connexion,provincia,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProvincia(Connexion connexion,Provincia provincia)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(provincia.getIsNew()||!provincia.getid_pais().equals(provincia.getProvinciaOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provincia.getProvinciaOriginal().getid_pais()!=null)
				{
					strValorActual=provincia.getProvinciaOriginal().getid_pais().toString();
				}
				if(provincia.getid_pais()!=null)
				{
					strValorNuevo=provincia.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvinciaConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(provincia.getIsNew()||!provincia.getid_region().equals(provincia.getProvinciaOriginal().getid_region()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provincia.getProvinciaOriginal().getid_region()!=null)
				{
					strValorActual=provincia.getProvinciaOriginal().getid_region().toString();
				}
				if(provincia.getid_region()!=null)
				{
					strValorNuevo=provincia.getid_region().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvinciaConstantesFunciones.IDREGION,strValorActual,strValorNuevo);
			}	
			
			if(provincia.getIsNew()||!provincia.getcodigo().equals(provincia.getProvinciaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provincia.getProvinciaOriginal().getcodigo()!=null)
				{
					strValorActual=provincia.getProvinciaOriginal().getcodigo();
				}
				if(provincia.getcodigo()!=null)
				{
					strValorNuevo=provincia.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvinciaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(provincia.getIsNew()||!provincia.getnombre().equals(provincia.getProvinciaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provincia.getProvinciaOriginal().getnombre()!=null)
				{
					strValorActual=provincia.getProvinciaOriginal().getnombre();
				}
				if(provincia.getnombre()!=null)
				{
					strValorNuevo=provincia.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvinciaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProvinciaRelacionesWithConnection(Provincia provincia,List<Ciudad> ciudads,List<Cliente> clientes,List<Canton> cantons,List<Barrio> barrios,List<Empleado> empleados,List<DatoGeneralEmpleado> datogeneralempleados,List<ParametroCarteraDefecto> parametrocarteradefectos) throws Exception {

		if(!provincia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProvinciaRelacionesBase(provincia,ciudads,clientes,cantons,barrios,empleados,datogeneralempleados,parametrocarteradefectos,true);
		}
	}

	public void saveProvinciaRelaciones(Provincia provincia,List<Ciudad> ciudads,List<Cliente> clientes,List<Canton> cantons,List<Barrio> barrios,List<Empleado> empleados,List<DatoGeneralEmpleado> datogeneralempleados,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {

		if(!provincia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProvinciaRelacionesBase(provincia,ciudads,clientes,cantons,barrios,empleados,datogeneralempleados,parametrocarteradefectos,false);
		}
	}

	public void saveProvinciaRelacionesBase(Provincia provincia,List<Ciudad> ciudads,List<Cliente> clientes,List<Canton> cantons,List<Barrio> barrios,List<Empleado> empleados,List<DatoGeneralEmpleado> datogeneralempleados,List<ParametroCarteraDefecto> parametrocarteradefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Provincia-saveRelacionesWithConnection");}
	
			provincia.setCiudads(ciudads);
			provincia.setClientes(clientes);
			provincia.setCantons(cantons);
			provincia.setBarrios(barrios);
			provincia.setEmpleados(empleados);
			provincia.setDatoGeneralEmpleados(datogeneralempleados);
			provincia.setParametroCarteraDefectos(parametrocarteradefectos);

			this.setProvincia(provincia);

			if(ProvinciaLogicAdditional.validarSaveRelaciones(provincia,this)) {

				ProvinciaLogicAdditional.updateRelacionesToSave(provincia,this);

				if((provincia.getIsNew()||provincia.getIsChanged())&&!provincia.getIsDeleted()) {
					this.saveProvincia();
					this.saveProvinciaRelacionesDetalles(ciudads,clientes,cantons,barrios,empleados,datogeneralempleados,parametrocarteradefectos);

				} else if(provincia.getIsDeleted()) {
					this.saveProvinciaRelacionesDetalles(ciudads,clientes,cantons,barrios,empleados,datogeneralempleados,parametrocarteradefectos);
					this.saveProvincia();
				}

				ProvinciaLogicAdditional.updateRelacionesToSaveAfter(provincia,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CiudadConstantesFunciones.InicializarGeneralEntityAuxiliaresCiudads(ciudads,true,true);
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			CantonConstantesFunciones.InicializarGeneralEntityAuxiliaresCantons(cantons,true,true);
			BarrioConstantesFunciones.InicializarGeneralEntityAuxiliaresBarrios(barrios,true,true);
			EmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleados(empleados,true,true);
			DatoGeneralEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresDatoGeneralEmpleados(datogeneralempleados,true,true);
			ParametroCarteraDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroCarteraDefectos(parametrocarteradefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveProvinciaRelacionesDetalles(List<Ciudad> ciudads,List<Cliente> clientes,List<Canton> cantons,List<Barrio> barrios,List<Empleado> empleados,List<DatoGeneralEmpleado> datogeneralempleados,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {
		try {
	

			Long idProvinciaActual=this.getProvincia().getId();

			CiudadLogic ciudadLogic_Desde_Provincia=new CiudadLogic();
			ciudadLogic_Desde_Provincia.setCiudads(ciudads);

			ciudadLogic_Desde_Provincia.setConnexion(this.getConnexion());
			ciudadLogic_Desde_Provincia.setDatosCliente(this.datosCliente);

			for(Ciudad ciudad_Desde_Provincia:ciudadLogic_Desde_Provincia.getCiudads()) {
				ciudad_Desde_Provincia.setid_provincia(idProvinciaActual);
			}

			ciudadLogic_Desde_Provincia.saveCiudads();

			ClienteLogic clienteLogic_Desde_Provincia=new ClienteLogic();
			clienteLogic_Desde_Provincia.setClientes(clientes);

			clienteLogic_Desde_Provincia.setConnexion(this.getConnexion());
			clienteLogic_Desde_Provincia.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_Provincia:clienteLogic_Desde_Provincia.getClientes()) {
				cliente_Desde_Provincia.setid_provincia(idProvinciaActual);

				clienteLogic_Desde_Provincia.setCliente(cliente_Desde_Provincia);
				clienteLogic_Desde_Provincia.saveCliente();
			}


			CantonLogic cantonLogic_Desde_Provincia=new CantonLogic();
			cantonLogic_Desde_Provincia.setCantons(cantons);

			cantonLogic_Desde_Provincia.setConnexion(this.getConnexion());
			cantonLogic_Desde_Provincia.setDatosCliente(this.datosCliente);

			for(Canton canton_Desde_Provincia:cantonLogic_Desde_Provincia.getCantons()) {
				canton_Desde_Provincia.setid_provincia(idProvinciaActual);

				cantonLogic_Desde_Provincia.setCanton(canton_Desde_Provincia);
				cantonLogic_Desde_Provincia.saveCanton();

				Long idCantonActual=canton_Desde_Provincia.getId();

				BarrioLogic barrioLogic_Desde_Canton=new BarrioLogic();

				if(canton_Desde_Provincia.getBarrios()==null){
					canton_Desde_Provincia.setBarrios(new ArrayList<Barrio>());
				}

				barrioLogic_Desde_Canton.setBarrios(canton_Desde_Provincia.getBarrios());

				barrioLogic_Desde_Canton.setConnexion(this.getConnexion());
				barrioLogic_Desde_Canton.setDatosCliente(this.datosCliente);

				for(Barrio barrio_Desde_Canton:barrioLogic_Desde_Canton.getBarrios()) {
					barrio_Desde_Canton.setid_canton(idCantonActual);
				}

				barrioLogic_Desde_Canton.saveBarrios();

				ParroquiaLogic parroquiaLogic_Desde_Canton=new ParroquiaLogic();

				if(canton_Desde_Provincia.getParroquias()==null){
					canton_Desde_Provincia.setParroquias(new ArrayList<Parroquia>());
				}

				parroquiaLogic_Desde_Canton.setParroquias(canton_Desde_Provincia.getParroquias());

				parroquiaLogic_Desde_Canton.setConnexion(this.getConnexion());
				parroquiaLogic_Desde_Canton.setDatosCliente(this.datosCliente);

				for(Parroquia parroquia_Desde_Canton:parroquiaLogic_Desde_Canton.getParroquias()) {
					parroquia_Desde_Canton.setid_canton(idCantonActual);
				}

				parroquiaLogic_Desde_Canton.saveParroquias();
			}


			BarrioLogic barrioLogic_Desde_Provincia=new BarrioLogic();
			barrioLogic_Desde_Provincia.setBarrios(barrios);

			barrioLogic_Desde_Provincia.setConnexion(this.getConnexion());
			barrioLogic_Desde_Provincia.setDatosCliente(this.datosCliente);

			for(Barrio barrio_Desde_Provincia:barrioLogic_Desde_Provincia.getBarrios()) {
				barrio_Desde_Provincia.setid_provincia(idProvinciaActual);
			}

			barrioLogic_Desde_Provincia.saveBarrios();

			EmpleadoLogic empleadoLogic_Desde_Provincia=new EmpleadoLogic();
			empleadoLogic_Desde_Provincia.setEmpleados(empleados);

			empleadoLogic_Desde_Provincia.setConnexion(this.getConnexion());
			empleadoLogic_Desde_Provincia.setDatosCliente(this.datosCliente);

			for(Empleado empleado_Desde_Provincia:empleadoLogic_Desde_Provincia.getEmpleados()) {
				empleado_Desde_Provincia.setid_provincia(idProvinciaActual);

				empleadoLogic_Desde_Provincia.setEmpleado(empleado_Desde_Provincia);
				empleadoLogic_Desde_Provincia.saveEmpleado();
			}


			DatoGeneralEmpleadoLogic datogeneralempleadoLogic_Desde_Provincia=new DatoGeneralEmpleadoLogic();
			datogeneralempleadoLogic_Desde_Provincia.setDatoGeneralEmpleados(datogeneralempleados);

			datogeneralempleadoLogic_Desde_Provincia.setConnexion(this.getConnexion());
			datogeneralempleadoLogic_Desde_Provincia.setDatosCliente(this.datosCliente);

			for(DatoGeneralEmpleado datogeneralempleado_Desde_Provincia:datogeneralempleadoLogic_Desde_Provincia.getDatoGeneralEmpleados()) {
				datogeneralempleado_Desde_Provincia.setid_provincia(idProvinciaActual);
			}

			datogeneralempleadoLogic_Desde_Provincia.saveDatoGeneralEmpleados();

			ParametroCarteraDefectoLogic parametrocarteradefectoLogic_Desde_Provincia=new ParametroCarteraDefectoLogic();
			parametrocarteradefectoLogic_Desde_Provincia.setParametroCarteraDefectos(parametrocarteradefectos);

			parametrocarteradefectoLogic_Desde_Provincia.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic_Desde_Provincia.setDatosCliente(this.datosCliente);

			for(ParametroCarteraDefecto parametrocarteradefecto_Desde_Provincia:parametrocarteradefectoLogic_Desde_Provincia.getParametroCarteraDefectos()) {
				parametrocarteradefecto_Desde_Provincia.setid_provincia(idProvinciaActual);
			}

			parametrocarteradefectoLogic_Desde_Provincia.saveParametroCarteraDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProvincia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProvinciaConstantesFunciones.getClassesForeignKeysOfProvincia(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProvincia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProvinciaConstantesFunciones.getClassesRelationshipsOfProvincia(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
