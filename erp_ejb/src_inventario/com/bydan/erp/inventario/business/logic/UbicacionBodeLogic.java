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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.UbicacionBodeConstantesFunciones;
import com.bydan.erp.inventario.util.UbicacionBodeParameterReturnGeneral;
//import com.bydan.erp.inventario.util.UbicacionBodeParameterGeneral;
import com.bydan.erp.inventario.business.entity.UbicacionBode;
import com.bydan.erp.inventario.business.logic.UbicacionBodeLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class UbicacionBodeLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(UbicacionBodeLogic.class);
	
	protected UbicacionBodeDataAccess ubicacionbodeDataAccess; 	
	protected UbicacionBode ubicacionbode;
	protected List<UbicacionBode> ubicacionbodes;
	protected Object ubicacionbodeObject;	
	protected List<Object> ubicacionbodesObject;
	
	public static ClassValidator<UbicacionBode> ubicacionbodeValidator = new ClassValidator<UbicacionBode>(UbicacionBode.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected UbicacionBodeLogicAdditional ubicacionbodeLogicAdditional=null;
	
	public UbicacionBodeLogicAdditional getUbicacionBodeLogicAdditional() {
		return this.ubicacionbodeLogicAdditional;
	}
	
	public void setUbicacionBodeLogicAdditional(UbicacionBodeLogicAdditional ubicacionbodeLogicAdditional) {
		try {
			this.ubicacionbodeLogicAdditional=ubicacionbodeLogicAdditional;
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
	
	
	
	
	public  UbicacionBodeLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.ubicacionbodeDataAccess = new UbicacionBodeDataAccess();
			
			this.ubicacionbodes= new ArrayList<UbicacionBode>();
			this.ubicacionbode= new UbicacionBode();
			
			this.ubicacionbodeObject=new Object();
			this.ubicacionbodesObject=new ArrayList<Object>();
				
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
			
			this.ubicacionbodeDataAccess.setConnexionType(this.connexionType);
			this.ubicacionbodeDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  UbicacionBodeLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.ubicacionbodeDataAccess = new UbicacionBodeDataAccess();
			this.ubicacionbodes= new ArrayList<UbicacionBode>();
			this.ubicacionbode= new UbicacionBode();
			this.ubicacionbodeObject=new Object();
			this.ubicacionbodesObject=new ArrayList<Object>();
			
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
			
			this.ubicacionbodeDataAccess.setConnexionType(this.connexionType);
			this.ubicacionbodeDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public UbicacionBode getUbicacionBode() throws Exception {	
		UbicacionBodeLogicAdditional.checkUbicacionBodeToGet(ubicacionbode,this.datosCliente,this.arrDatoGeneral);
		UbicacionBodeLogicAdditional.updateUbicacionBodeToGet(ubicacionbode,this.arrDatoGeneral);
		
		return ubicacionbode;
	}
		
	public void setUbicacionBode(UbicacionBode newUbicacionBode) {
		this.ubicacionbode = newUbicacionBode;
	}
	
	public UbicacionBodeDataAccess getUbicacionBodeDataAccess() {
		return ubicacionbodeDataAccess;
	}
	
	public void setUbicacionBodeDataAccess(UbicacionBodeDataAccess newubicacionbodeDataAccess) {
		this.ubicacionbodeDataAccess = newubicacionbodeDataAccess;
	}
	
	public List<UbicacionBode> getUbicacionBodes() throws Exception {		
		this.quitarUbicacionBodesNulos();
		
		UbicacionBodeLogicAdditional.checkUbicacionBodeToGets(ubicacionbodes,this.datosCliente,this.arrDatoGeneral);
		
		for (UbicacionBode ubicacionbodeLocal: ubicacionbodes ) {
			UbicacionBodeLogicAdditional.updateUbicacionBodeToGet(ubicacionbodeLocal,this.arrDatoGeneral);
		}
		
		return ubicacionbodes;
	}
	
	public void setUbicacionBodes(List<UbicacionBode> newUbicacionBodes) {
		this.ubicacionbodes = newUbicacionBodes;
	}
	
	public Object getUbicacionBodeObject() {	
		this.ubicacionbodeObject=this.ubicacionbodeDataAccess.getEntityObject();
		return this.ubicacionbodeObject;
	}
		
	public void setUbicacionBodeObject(Object newUbicacionBodeObject) {
		this.ubicacionbodeObject = newUbicacionBodeObject;
	}
	
	public List<Object> getUbicacionBodesObject() {		
		this.ubicacionbodesObject=this.ubicacionbodeDataAccess.getEntitiesObject();
		return this.ubicacionbodesObject;
	}
		
	public void setUbicacionBodesObject(List<Object> newUbicacionBodesObject) {
		this.ubicacionbodesObject = newUbicacionBodesObject;
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
		
		if(this.ubicacionbodeDataAccess!=null) {
			this.ubicacionbodeDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			ubicacionbodeDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			ubicacionbodeDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		ubicacionbode = new  UbicacionBode();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ubicacionbode=ubicacionbodeDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ubicacionbode,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbode);
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
		ubicacionbode = new  UbicacionBode();
		  		  
        try {
			
			ubicacionbode=ubicacionbodeDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ubicacionbode,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbode);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		ubicacionbode = new  UbicacionBode();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ubicacionbode=ubicacionbodeDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ubicacionbode,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbode);
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
		ubicacionbode = new  UbicacionBode();
		  		  
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
		ubicacionbode = new  UbicacionBode();
		  		  
        try {
			
			ubicacionbode=ubicacionbodeDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ubicacionbode,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbode);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		ubicacionbode = new  UbicacionBode();
		  		  
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
		ubicacionbode = new  UbicacionBode();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =ubicacionbodeDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ubicacionbode = new  UbicacionBode();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=ubicacionbodeDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ubicacionbode = new  UbicacionBode();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =ubicacionbodeDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ubicacionbode = new  UbicacionBode();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=ubicacionbodeDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ubicacionbode = new  UbicacionBode();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =ubicacionbodeDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ubicacionbode = new  UbicacionBode();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=ubicacionbodeDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUbicacionBode(ubicacionbodes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
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
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		  		  
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
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		  		  
        try {			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarUbicacionBode(ubicacionbodes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		  		  
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
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUbicacionBode(ubicacionbodes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
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
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		  		  
        try {
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUbicacionBode(ubicacionbodes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
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
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUbicacionBode(ubicacionbodes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
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
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUbicacionBode(ubicacionbodes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		ubicacionbode = new  UbicacionBode();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbode=ubicacionbodeDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUbicacionBode(ubicacionbode);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbode);
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
		ubicacionbode = new  UbicacionBode();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbode=ubicacionbodeDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUbicacionBode(ubicacionbode);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbode);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbodes=ubicacionbodeDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUbicacionBode(ubicacionbodes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
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
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		  		  
        try {
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbodes=ubicacionbodeDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUbicacionBode(ubicacionbodes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosUbicacionBodesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getTodosUbicacionBodesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUbicacionBode(ubicacionbodes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
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
	
	public  void  getTodosUbicacionBodes(String sFinalQuery,Pagination pagination)throws Exception {
		ubicacionbodes = new  ArrayList<UbicacionBode>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUbicacionBode(ubicacionbodes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarUbicacionBode(UbicacionBode ubicacionbode) throws Exception {
		Boolean estaValidado=false;
		
		if(ubicacionbode.getIsNew() || ubicacionbode.getIsChanged()) { 
			this.invalidValues = ubicacionbodeValidator.getInvalidValues(ubicacionbode);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(ubicacionbode);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarUbicacionBode(List<UbicacionBode> UbicacionBodes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(UbicacionBode ubicacionbodeLocal:ubicacionbodes) {				
			estaValidadoObjeto=this.validarGuardarUbicacionBode(ubicacionbodeLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarUbicacionBode(List<UbicacionBode> UbicacionBodes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUbicacionBode(ubicacionbodes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarUbicacionBode(UbicacionBode UbicacionBode) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUbicacionBode(ubicacionbode)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(UbicacionBode ubicacionbode) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+ubicacionbode.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=UbicacionBodeConstantesFunciones.getUbicacionBodeLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"ubicacionbode","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(UbicacionBodeConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(UbicacionBodeConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveUbicacionBodeWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-saveUbicacionBodeWithConnection");connexion.begin();			
			
			UbicacionBodeLogicAdditional.checkUbicacionBodeToSave(this.ubicacionbode,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UbicacionBodeLogicAdditional.updateUbicacionBodeToSave(this.ubicacionbode,this.arrDatoGeneral);
			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ubicacionbode,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowUbicacionBode();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUbicacionBode(this.ubicacionbode)) {
				UbicacionBodeDataAccess.save(this.ubicacionbode, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.ubicacionbode,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UbicacionBodeLogicAdditional.checkUbicacionBodeToSaveAfter(this.ubicacionbode,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUbicacionBode();
			
			connexion.commit();			
			
			if(this.ubicacionbode.getIsDeleted()) {
				this.ubicacionbode=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveUbicacionBode()throws Exception {	
		try {	
			
			UbicacionBodeLogicAdditional.checkUbicacionBodeToSave(this.ubicacionbode,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UbicacionBodeLogicAdditional.updateUbicacionBodeToSave(this.ubicacionbode,this.arrDatoGeneral);
			
			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ubicacionbode,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUbicacionBode(this.ubicacionbode)) {			
				UbicacionBodeDataAccess.save(this.ubicacionbode, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.ubicacionbode,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UbicacionBodeLogicAdditional.checkUbicacionBodeToSaveAfter(this.ubicacionbode,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.ubicacionbode.getIsDeleted()) {
				this.ubicacionbode=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveUbicacionBodesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-saveUbicacionBodesWithConnection");connexion.begin();			
			
			UbicacionBodeLogicAdditional.checkUbicacionBodeToSaves(ubicacionbodes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowUbicacionBodes();
			
			Boolean validadoTodosUbicacionBode=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UbicacionBode ubicacionbodeLocal:ubicacionbodes) {		
				if(ubicacionbodeLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UbicacionBodeLogicAdditional.updateUbicacionBodeToSave(ubicacionbodeLocal,this.arrDatoGeneral);
	        	
				UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ubicacionbodeLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUbicacionBode(ubicacionbodeLocal)) {
					UbicacionBodeDataAccess.save(ubicacionbodeLocal, connexion);				
				} else {
					validadoTodosUbicacionBode=false;
				}
			}
			
			if(!validadoTodosUbicacionBode) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UbicacionBodeLogicAdditional.checkUbicacionBodeToSavesAfter(ubicacionbodes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUbicacionBodes();
			
			connexion.commit();		
			
			this.quitarUbicacionBodesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveUbicacionBodes()throws Exception {				
		 try {	
			UbicacionBodeLogicAdditional.checkUbicacionBodeToSaves(ubicacionbodes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosUbicacionBode=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UbicacionBode ubicacionbodeLocal:ubicacionbodes) {				
				if(ubicacionbodeLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UbicacionBodeLogicAdditional.updateUbicacionBodeToSave(ubicacionbodeLocal,this.arrDatoGeneral);
	        	
				UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ubicacionbodeLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUbicacionBode(ubicacionbodeLocal)) {				
					UbicacionBodeDataAccess.save(ubicacionbodeLocal, connexion);				
				} else {
					validadoTodosUbicacionBode=false;
				}
			}
			
			if(!validadoTodosUbicacionBode) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UbicacionBodeLogicAdditional.checkUbicacionBodeToSavesAfter(ubicacionbodes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarUbicacionBodesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UbicacionBodeParameterReturnGeneral procesarAccionUbicacionBodes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UbicacionBode> ubicacionbodes,UbicacionBodeParameterReturnGeneral ubicacionbodeParameterGeneral)throws Exception {
		 try {	
			UbicacionBodeParameterReturnGeneral ubicacionbodeReturnGeneral=new UbicacionBodeParameterReturnGeneral();
	
			UbicacionBodeLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ubicacionbodes,ubicacionbodeParameterGeneral,ubicacionbodeReturnGeneral);
			
			return ubicacionbodeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UbicacionBodeParameterReturnGeneral procesarAccionUbicacionBodesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UbicacionBode> ubicacionbodes,UbicacionBodeParameterReturnGeneral ubicacionbodeParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-procesarAccionUbicacionBodesWithConnection");connexion.begin();			
			
			UbicacionBodeParameterReturnGeneral ubicacionbodeReturnGeneral=new UbicacionBodeParameterReturnGeneral();
	
			UbicacionBodeLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ubicacionbodes,ubicacionbodeParameterGeneral,ubicacionbodeReturnGeneral);
			
			this.connexion.commit();
			
			return ubicacionbodeReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UbicacionBodeParameterReturnGeneral procesarEventosUbicacionBodes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UbicacionBode> ubicacionbodes,UbicacionBode ubicacionbode,UbicacionBodeParameterReturnGeneral ubicacionbodeParameterGeneral,Boolean isEsNuevoUbicacionBode,ArrayList<Classe> clases)throws Exception {
		 try {	
			UbicacionBodeParameterReturnGeneral ubicacionbodeReturnGeneral=new UbicacionBodeParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ubicacionbodeReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UbicacionBodeLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ubicacionbodes,ubicacionbode,ubicacionbodeParameterGeneral,ubicacionbodeReturnGeneral,isEsNuevoUbicacionBode,clases);
			
			return ubicacionbodeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public UbicacionBodeParameterReturnGeneral procesarEventosUbicacionBodesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UbicacionBode> ubicacionbodes,UbicacionBode ubicacionbode,UbicacionBodeParameterReturnGeneral ubicacionbodeParameterGeneral,Boolean isEsNuevoUbicacionBode,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-procesarEventosUbicacionBodesWithConnection");connexion.begin();			
			
			UbicacionBodeParameterReturnGeneral ubicacionbodeReturnGeneral=new UbicacionBodeParameterReturnGeneral();
	
			ubicacionbodeReturnGeneral.setUbicacionBode(ubicacionbode);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ubicacionbodeReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UbicacionBodeLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ubicacionbodes,ubicacionbode,ubicacionbodeParameterGeneral,ubicacionbodeReturnGeneral,isEsNuevoUbicacionBode,clases);
			
			this.connexion.commit();
			
			return ubicacionbodeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UbicacionBodeParameterReturnGeneral procesarImportacionUbicacionBodesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,UbicacionBodeParameterReturnGeneral ubicacionbodeParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-procesarImportacionUbicacionBodesWithConnection");connexion.begin();			
			
			UbicacionBodeParameterReturnGeneral ubicacionbodeReturnGeneral=new UbicacionBodeParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.ubicacionbodes=new ArrayList<UbicacionBode>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.ubicacionbode=new UbicacionBode();
				
				
				if(conColumnasBase) {this.ubicacionbode.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.ubicacionbode.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.ubicacionbode.setnombre(arrColumnas[iColumn++]);
				this.ubicacionbode.setnivel(Integer.parseInt(arrColumnas[iColumn++]));
				this.ubicacionbode.setorden(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.ubicacionbodes.add(this.ubicacionbode);
			}
			
			this.saveUbicacionBodes();
			
			this.connexion.commit();
			
			ubicacionbodeReturnGeneral.setConRetornoEstaProcesado(true);
			ubicacionbodeReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return ubicacionbodeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarUbicacionBodesEliminados() throws Exception {				
		
		List<UbicacionBode> ubicacionbodesAux= new ArrayList<UbicacionBode>();
		
		for(UbicacionBode ubicacionbode:ubicacionbodes) {
			if(!ubicacionbode.getIsDeleted()) {
				ubicacionbodesAux.add(ubicacionbode);
			}
		}
		
		ubicacionbodes=ubicacionbodesAux;
	}
	
	public void quitarUbicacionBodesNulos() throws Exception {				
		
		List<UbicacionBode> ubicacionbodesAux= new ArrayList<UbicacionBode>();
		
		for(UbicacionBode ubicacionbode : this.ubicacionbodes) {
			if(ubicacionbode==null) {
				ubicacionbodesAux.add(ubicacionbode);
			}
		}
		
		//this.ubicacionbodes=ubicacionbodesAux;
		
		this.ubicacionbodes.removeAll(ubicacionbodesAux);
	}
	
	public void getSetVersionRowUbicacionBodeWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(ubicacionbode.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((ubicacionbode.getIsDeleted() || (ubicacionbode.getIsChanged()&&!ubicacionbode.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=ubicacionbodeDataAccess.getSetVersionRowUbicacionBode(connexion,ubicacionbode.getId());
				
				if(!ubicacionbode.getVersionRow().equals(timestamp)) {	
					ubicacionbode.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				ubicacionbode.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowUbicacionBode()throws Exception {	
		
		if(ubicacionbode.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((ubicacionbode.getIsDeleted() || (ubicacionbode.getIsChanged()&&!ubicacionbode.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=ubicacionbodeDataAccess.getSetVersionRowUbicacionBode(connexion,ubicacionbode.getId());
			
			try {							
				if(!ubicacionbode.getVersionRow().equals(timestamp)) {	
					ubicacionbode.setVersionRow(timestamp);
				}
				
				ubicacionbode.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowUbicacionBodesWithConnection()throws Exception {	
		if(ubicacionbodes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(UbicacionBode ubicacionbodeAux:ubicacionbodes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(ubicacionbodeAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ubicacionbodeAux.getIsDeleted() || (ubicacionbodeAux.getIsChanged()&&!ubicacionbodeAux.getIsNew())) {
						
						timestamp=ubicacionbodeDataAccess.getSetVersionRowUbicacionBode(connexion,ubicacionbodeAux.getId());
						
						if(!ubicacionbode.getVersionRow().equals(timestamp)) {	
							ubicacionbodeAux.setVersionRow(timestamp);
						}
								
						ubicacionbodeAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowUbicacionBodes()throws Exception {	
		if(ubicacionbodes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(UbicacionBode ubicacionbodeAux:ubicacionbodes) {
					if(ubicacionbodeAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ubicacionbodeAux.getIsDeleted() || (ubicacionbodeAux.getIsChanged()&&!ubicacionbodeAux.getIsNew())) {
						
						timestamp=ubicacionbodeDataAccess.getSetVersionRowUbicacionBode(connexion,ubicacionbodeAux.getId());
						
						if(!ubicacionbodeAux.getVersionRow().equals(timestamp)) {	
							ubicacionbodeAux.setVersionRow(timestamp);
						}
						
													
						ubicacionbodeAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public UbicacionBodeParameterReturnGeneral cargarCombosLoteForeignKeyUbicacionBodeWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalUbicacionBode) throws Exception {
		UbicacionBodeParameterReturnGeneral  ubicacionbodeReturnGeneral =new UbicacionBodeParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-cargarCombosLoteForeignKeyUbicacionBodeWithConnection");connexion.begin();
			
			ubicacionbodeReturnGeneral =new UbicacionBodeParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ubicacionbodeReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ubicacionbodeReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			ubicacionbodeReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<UbicacionBode> ubicacionbodesForeignKey=new ArrayList<UbicacionBode>();
			UbicacionBodeLogic ubicacionbodeLogic=new UbicacionBodeLogic();
			ubicacionbodeLogic.setConnexion(this.connexion);
			ubicacionbodeLogic.getUbicacionBodeDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUbicacionBode.equals("NONE")) {
				ubicacionbodeLogic.getTodosUbicacionBodes(finalQueryGlobalUbicacionBode,new Pagination());
				ubicacionbodesForeignKey=ubicacionbodeLogic.getUbicacionBodes();
			}

			ubicacionbodeReturnGeneral.setubicacionbodesForeignKey(ubicacionbodesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return ubicacionbodeReturnGeneral;
	}
	
	public UbicacionBodeParameterReturnGeneral cargarCombosLoteForeignKeyUbicacionBode(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalUbicacionBode) throws Exception {
		UbicacionBodeParameterReturnGeneral  ubicacionbodeReturnGeneral =new UbicacionBodeParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			ubicacionbodeReturnGeneral =new UbicacionBodeParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ubicacionbodeReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ubicacionbodeReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			ubicacionbodeReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<UbicacionBode> ubicacionbodesForeignKey=new ArrayList<UbicacionBode>();
			UbicacionBodeLogic ubicacionbodeLogic=new UbicacionBodeLogic();
			ubicacionbodeLogic.setConnexion(this.connexion);
			ubicacionbodeLogic.getUbicacionBodeDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUbicacionBode.equals("NONE")) {
				ubicacionbodeLogic.getTodosUbicacionBodes(finalQueryGlobalUbicacionBode,new Pagination());
				ubicacionbodesForeignKey=ubicacionbodeLogic.getUbicacionBodes();
			}

			ubicacionbodeReturnGeneral.setubicacionbodesForeignKey(ubicacionbodesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return ubicacionbodeReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyUbicacionBodeWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			UbicacionBodeLogic ubicacionbodeLogic=new UbicacionBodeLogic();
			UbicacionProduLogic ubicacionproduLogic=new UbicacionProduLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyUbicacionBodeWithConnection");connexion.begin();
			
			
			classes.add(new Classe(UbicacionBode.class));
			classes.add(new Classe(UbicacionProdu.class));
											
			

			ubicacionbodeLogic.setConnexion(this.getConnexion());
			ubicacionbodeLogic.setDatosCliente(this.datosCliente);
			ubicacionbodeLogic.setIsConRefrescarForeignKeys(true);

			ubicacionproduLogic.setConnexion(this.getConnexion());
			ubicacionproduLogic.setDatosCliente(this.datosCliente);
			ubicacionproduLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(UbicacionBode ubicacionbode:this.ubicacionbodes) {
				

				classes=new ArrayList<Classe>();
				classes=UbicacionBodeConstantesFunciones.getClassesForeignKeysOfUbicacionBode(new ArrayList<Classe>(),DeepLoadType.NONE);

				ubicacionbodeLogic.setUbicacionBodes(ubicacionbode.ubicacionbodes);
				ubicacionbodeLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=UbicacionProduConstantesFunciones.getClassesForeignKeysOfUbicacionProdu(new ArrayList<Classe>(),DeepLoadType.NONE);

				ubicacionproduLogic.setUbicacionProdus(ubicacionbode.ubicacionprodus);
				ubicacionproduLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(UbicacionBode ubicacionbode,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			UbicacionBodeLogicAdditional.updateUbicacionBodeToGet(ubicacionbode,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ubicacionbode.setEmpresa(ubicacionbodeDataAccess.getEmpresa(connexion,ubicacionbode));
		ubicacionbode.setSucursal(ubicacionbodeDataAccess.getSucursal(connexion,ubicacionbode));
		ubicacionbode.setBodega(ubicacionbodeDataAccess.getBodega(connexion,ubicacionbode));
		ubicacionbode.setUbicacionBode(ubicacionbodeDataAccess.getUbicacionBode(connexion,ubicacionbode));
		ubicacionbode.setUbicacionBodes(ubicacionbodeDataAccess.getUbicacionBodes(connexion,ubicacionbode));
		ubicacionbode.setUbicacionProdus(ubicacionbodeDataAccess.getUbicacionProdus(connexion,ubicacionbode));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ubicacionbode.setEmpresa(ubicacionbodeDataAccess.getEmpresa(connexion,ubicacionbode));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ubicacionbode.setSucursal(ubicacionbodeDataAccess.getSucursal(connexion,ubicacionbode));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ubicacionbode.setBodega(ubicacionbodeDataAccess.getBodega(connexion,ubicacionbode));
				continue;
			}

			if(clas.clas.equals(UbicacionBode.class)) {
				ubicacionbode.setUbicacionBode(ubicacionbodeDataAccess.getUbicacionBode(connexion,ubicacionbode));
				continue;
			}

			if(clas.clas.equals(UbicacionBode.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ubicacionbode.setUbicacionBodes(ubicacionbodeDataAccess.getUbicacionBodes(connexion,ubicacionbode));

				if(this.isConDeep) {
					UbicacionBodeLogic ubicacionbodeLogic= new UbicacionBodeLogic(this.connexion);
					ubicacionbodeLogic.setUbicacionBodes(ubicacionbode.getUbicacionBodes());
					ArrayList<Classe> classesLocal=UbicacionBodeConstantesFunciones.getClassesForeignKeysOfUbicacionBode(new ArrayList<Classe>(),DeepLoadType.NONE);
					ubicacionbodeLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(ubicacionbodeLogic.getUbicacionBodes());
					ubicacionbode.setUbicacionBodes(ubicacionbodeLogic.getUbicacionBodes());
				}

				continue;
			}

			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ubicacionbode.setUbicacionProdus(ubicacionbodeDataAccess.getUbicacionProdus(connexion,ubicacionbode));

				if(this.isConDeep) {
					UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(this.connexion);
					ubicacionproduLogic.setUbicacionProdus(ubicacionbode.getUbicacionProdus());
					ArrayList<Classe> classesLocal=UbicacionProduConstantesFunciones.getClassesForeignKeysOfUbicacionProdu(new ArrayList<Classe>(),DeepLoadType.NONE);
					ubicacionproduLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					UbicacionProduConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionProdu(ubicacionproduLogic.getUbicacionProdus());
					ubicacionbode.setUbicacionProdus(ubicacionproduLogic.getUbicacionProdus());
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
			ubicacionbode.setEmpresa(ubicacionbodeDataAccess.getEmpresa(connexion,ubicacionbode));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionbode.setSucursal(ubicacionbodeDataAccess.getSucursal(connexion,ubicacionbode));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionbode.setBodega(ubicacionbodeDataAccess.getBodega(connexion,ubicacionbode));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UbicacionBode.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionbode.setUbicacionBode(ubicacionbodeDataAccess.getUbicacionBode(connexion,ubicacionbode));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UbicacionBode.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UbicacionBode.class));
			ubicacionbode.setUbicacionBodes(ubicacionbodeDataAccess.getUbicacionBodes(connexion,ubicacionbode));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UbicacionProdu.class));
			ubicacionbode.setUbicacionProdus(ubicacionbodeDataAccess.getUbicacionProdus(connexion,ubicacionbode));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ubicacionbode.setEmpresa(ubicacionbodeDataAccess.getEmpresa(connexion,ubicacionbode));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ubicacionbode.getEmpresa(),isDeep,deepLoadType,clases);
				
		ubicacionbode.setSucursal(ubicacionbodeDataAccess.getSucursal(connexion,ubicacionbode));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ubicacionbode.getSucursal(),isDeep,deepLoadType,clases);
				
		ubicacionbode.setBodega(ubicacionbodeDataAccess.getBodega(connexion,ubicacionbode));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(ubicacionbode.getBodega(),isDeep,deepLoadType,clases);
				
		ubicacionbode.setUbicacionBode(ubicacionbodeDataAccess.getUbicacionBode(connexion,ubicacionbode));
		UbicacionBodeLogic ubicacionbodeLogic= new UbicacionBodeLogic(connexion);
		ubicacionbodeLogic.deepLoad(ubicacionbode.getUbicacionBode(),isDeep,deepLoadType,clases);
				

		ubicacionbode.setUbicacionBodes(ubicacionbodeDataAccess.getUbicacionBodes(connexion,ubicacionbode));

		for(UbicacionBode ubicacionbodeRecursivo:ubicacionbode.getUbicacionBodes()) {
			UbicacionBodeLogic ubicacionbodeRecursivoLogic= new UbicacionBodeLogic(connexion);
			ubicacionbodeRecursivoLogic.deepLoad(ubicacionbodeRecursivo,isDeep,deepLoadType,clases);
		}

		ubicacionbode.setUbicacionProdus(ubicacionbodeDataAccess.getUbicacionProdus(connexion,ubicacionbode));

		for(UbicacionProdu ubicacionprodu:ubicacionbode.getUbicacionProdus()) {
			UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(connexion);
			ubicacionproduLogic.deepLoad(ubicacionprodu,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ubicacionbode.setEmpresa(ubicacionbodeDataAccess.getEmpresa(connexion,ubicacionbode));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(ubicacionbode.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ubicacionbode.setSucursal(ubicacionbodeDataAccess.getSucursal(connexion,ubicacionbode));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(ubicacionbode.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ubicacionbode.setBodega(ubicacionbodeDataAccess.getBodega(connexion,ubicacionbode));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(ubicacionbode.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(UbicacionBode.class)) {
				ubicacionbode.setUbicacionBode(ubicacionbodeDataAccess.getUbicacionBode(connexion,ubicacionbode));
				UbicacionBodeLogic ubicacionbodeLogic= new UbicacionBodeLogic(connexion);
				ubicacionbodeLogic.deepLoad(ubicacionbode.getUbicacionBode(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(UbicacionBode.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ubicacionbode.setUbicacionBodes(ubicacionbodeDataAccess.getUbicacionBodes(connexion,ubicacionbode));

				for(UbicacionBode ubicacionbodeRecursivo:ubicacionbode.getUbicacionBodes()) {
					UbicacionBodeLogic ubicacionbodeRecursivoLogic= new UbicacionBodeLogic(connexion);
					ubicacionbodeRecursivoLogic.deepLoad(ubicacionbodeRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				ubicacionbode.setUbicacionProdus(ubicacionbodeDataAccess.getUbicacionProdus(connexion,ubicacionbode));

				for(UbicacionProdu ubicacionprodu:ubicacionbode.getUbicacionProdus()) {
					UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(connexion);
					ubicacionproduLogic.deepLoad(ubicacionprodu,isDeep,deepLoadType,clases);
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
			ubicacionbode.setEmpresa(ubicacionbodeDataAccess.getEmpresa(connexion,ubicacionbode));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(ubicacionbode.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionbode.setSucursal(ubicacionbodeDataAccess.getSucursal(connexion,ubicacionbode));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(ubicacionbode.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionbode.setBodega(ubicacionbodeDataAccess.getBodega(connexion,ubicacionbode));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(ubicacionbode.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(UbicacionBode.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ubicacionbode.setUbicacionBode(ubicacionbodeDataAccess.getUbicacionBode(connexion,ubicacionbode));
			UbicacionBodeLogic ubicacionbodeLogic= new UbicacionBodeLogic(connexion);
			ubicacionbodeLogic.deepLoad(ubicacionbode.getUbicacionBode(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UbicacionBode.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UbicacionBode.class));
			ubicacionbode.setUbicacionBodes(ubicacionbodeDataAccess.getUbicacionBodes(connexion,ubicacionbode));

			for(UbicacionBode ubicacionbodeRecursivo:ubicacionbode.getUbicacionBodes()) {
				UbicacionBodeLogic ubicacionbodeRecursivoLogic= new UbicacionBodeLogic(connexion);
				ubicacionbodeRecursivoLogic.deepLoad(ubicacionbodeRecursivo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UbicacionProdu.class));
			ubicacionbode.setUbicacionProdus(ubicacionbodeDataAccess.getUbicacionProdus(connexion,ubicacionbode));

			for(UbicacionProdu ubicacionprodu:ubicacionbode.getUbicacionProdus()) {
				UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(connexion);
				ubicacionproduLogic.deepLoad(ubicacionprodu,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(UbicacionBode ubicacionbode,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			UbicacionBodeLogicAdditional.updateUbicacionBodeToSave(ubicacionbode,this.arrDatoGeneral);
			
UbicacionBodeDataAccess.save(ubicacionbode, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ubicacionbode.getEmpresa(),connexion);

		SucursalDataAccess.save(ubicacionbode.getSucursal(),connexion);

		BodegaDataAccess.save(ubicacionbode.getBodega(),connexion);

		UbicacionBodeDataAccess.save(ubicacionbode.getUbicacionBode(),connexion);

		for(UbicacionBode ubicacionbodeRecursivo:ubicacionbode.getUbicacionBodes()) {
			ubicacionbodeRecursivo.setid_ubicacion_bode(ubicacionbode.getId());
			UbicacionBodeDataAccess.save(ubicacionbodeRecursivo,connexion);
		}

		for(UbicacionProdu ubicacionprodu:ubicacionbode.getUbicacionProdus()) {
			ubicacionprodu.setid_ubicacion_bode(ubicacionbode.getId());
			UbicacionProduDataAccess.save(ubicacionprodu,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ubicacionbode.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ubicacionbode.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ubicacionbode.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(UbicacionBode.class)) {
				UbicacionBodeDataAccess.save(ubicacionbode.getUbicacionBode(),connexion);
				continue;
			}


			if(clas.clas.equals(UbicacionBode.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UbicacionBode ubicacionbodeRecursivo:ubicacionbode.getUbicacionBodes()) {
					ubicacionbodeRecursivo.setid_ubicacion_bode(ubicacionbode.getId());
					UbicacionBodeDataAccess.save(ubicacionbodeRecursivo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UbicacionProdu ubicacionprodu:ubicacionbode.getUbicacionProdus()) {
					ubicacionprodu.setid_ubicacion_bode(ubicacionbode.getId());
					UbicacionProduDataAccess.save(ubicacionprodu,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ubicacionbode.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ubicacionbode.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(ubicacionbode.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ubicacionbode.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(ubicacionbode.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(ubicacionbode.getBodega(),isDeep,deepLoadType,clases);
				

		UbicacionBodeDataAccess.save(ubicacionbode.getUbicacionBode(),connexion);
		UbicacionBodeLogic ubicacionbodeLogic= new UbicacionBodeLogic(connexion);
		ubicacionbodeLogic.deepLoad(ubicacionbode.getUbicacionBode(),isDeep,deepLoadType,clases);
				

		for(UbicacionBode ubicacionbodeRecursivo:ubicacionbode.getUbicacionBodes()) {
			UbicacionBodeLogic ubicacionbodeRecursivoLogic= new UbicacionBodeLogic(connexion);
			ubicacionbodeRecursivo.setid_ubicacion_bode(ubicacionbode.getId());
			UbicacionBodeDataAccess.save(ubicacionbodeRecursivo,connexion);
			ubicacionbodeRecursivoLogic.deepSave(ubicacionbodeRecursivo,isDeep,deepLoadType,clases);
		}

		for(UbicacionProdu ubicacionprodu:ubicacionbode.getUbicacionProdus()) {
			UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(connexion);
			ubicacionprodu.setid_ubicacion_bode(ubicacionbode.getId());
			UbicacionProduDataAccess.save(ubicacionprodu,connexion);
			ubicacionproduLogic.deepSave(ubicacionprodu,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ubicacionbode.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(ubicacionbode.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ubicacionbode.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(ubicacionbode.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ubicacionbode.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(ubicacionbode.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(UbicacionBode.class)) {
				UbicacionBodeDataAccess.save(ubicacionbode.getUbicacionBode(),connexion);
				UbicacionBodeLogic ubicacionbodeLogic= new UbicacionBodeLogic(connexion);
				ubicacionbodeLogic.deepSave(ubicacionbode.getUbicacionBode(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(UbicacionBode.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UbicacionBode ubicacionbodeRecursivo:ubicacionbode.getUbicacionBodes()) {
					UbicacionBodeLogic ubicacionbodeRecursivoLogic= new UbicacionBodeLogic(connexion);
					ubicacionbodeRecursivo.setid_ubicacion_bode(ubicacionbode.getId());
					UbicacionBodeDataAccess.save(ubicacionbodeRecursivo,connexion);
					ubicacionbodeRecursivoLogic.deepSave(ubicacionbodeRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(UbicacionProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UbicacionProdu ubicacionprodu:ubicacionbode.getUbicacionProdus()) {
					UbicacionProduLogic ubicacionproduLogic= new UbicacionProduLogic(connexion);
					ubicacionprodu.setid_ubicacion_bode(ubicacionbode.getId());
					UbicacionProduDataAccess.save(ubicacionprodu,connexion);
					ubicacionproduLogic.deepSave(ubicacionprodu,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(UbicacionBode.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(ubicacionbode,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(ubicacionbode);
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
			this.deepLoad(this.ubicacionbode,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbode);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(UbicacionBode.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(ubicacionbodes!=null) {
				for(UbicacionBode ubicacionbode:ubicacionbodes) {
					this.deepLoad(ubicacionbode,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(ubicacionbodes);
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
			if(ubicacionbodes!=null) {
				for(UbicacionBode ubicacionbode:ubicacionbodes) {
					this.deepLoad(ubicacionbode,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(ubicacionbodes);
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
			this.getNewConnexionToDeep(UbicacionBode.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(ubicacionbode,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(UbicacionBode.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(ubicacionbodes!=null) {
				for(UbicacionBode ubicacionbode:ubicacionbodes) {
					this.deepSave(ubicacionbode,isDeep,deepLoadType,clases);
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
			if(ubicacionbodes!=null) {
				for(UbicacionBode ubicacionbode:ubicacionbodes) {
					this.deepSave(ubicacionbode,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getUbicacionBodesFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,UbicacionBodeConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUbicacionBodesFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,UbicacionBodeConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUbicacionBodesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UbicacionBodeConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUbicacionBodesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UbicacionBodeConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUbicacionBodesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,UbicacionBodeConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUbicacionBodesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,UbicacionBodeConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUbicacionBodesFK_IdUbicacionBodeWithConnection(String sFinalQuery,Pagination pagination,Long id_ubicacion_bode)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UbicacionBode.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUbicacionBode= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUbicacionBode.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ubicacion_bode,UbicacionBodeConstantesFunciones.IDUBICACIONBODE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUbicacionBode);

			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUbicacionBode","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUbicacionBodesFK_IdUbicacionBode(String sFinalQuery,Pagination pagination,Long id_ubicacion_bode)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUbicacionBode= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUbicacionBode.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ubicacion_bode,UbicacionBodeConstantesFunciones.IDUBICACIONBODE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUbicacionBode);

			UbicacionBodeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUbicacionBode","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UbicacionBodeConstantesFunciones.refrescarForeignKeysDescripcionesUbicacionBode(this.ubicacionbodes);
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
			if(UbicacionBodeConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,UbicacionBodeDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,UbicacionBode ubicacionbode,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(UbicacionBodeConstantesFunciones.ISCONAUDITORIA) {
				if(ubicacionbode.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UbicacionBodeDataAccess.TABLENAME, ubicacionbode.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UbicacionBodeConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UbicacionBodeLogic.registrarAuditoriaDetallesUbicacionBode(connexion,ubicacionbode,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(ubicacionbode.getIsDeleted()) {
					/*if(!ubicacionbode.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,UbicacionBodeDataAccess.TABLENAME, ubicacionbode.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////UbicacionBodeLogic.registrarAuditoriaDetallesUbicacionBode(connexion,ubicacionbode,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UbicacionBodeDataAccess.TABLENAME, ubicacionbode.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(ubicacionbode.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UbicacionBodeDataAccess.TABLENAME, ubicacionbode.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UbicacionBodeConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UbicacionBodeLogic.registrarAuditoriaDetallesUbicacionBode(connexion,ubicacionbode,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesUbicacionBode(Connexion connexion,UbicacionBode ubicacionbode)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(ubicacionbode.getIsNew()||!ubicacionbode.getid_empresa().equals(ubicacionbode.getUbicacionBodeOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionbode.getUbicacionBodeOriginal().getid_empresa()!=null)
				{
					strValorActual=ubicacionbode.getUbicacionBodeOriginal().getid_empresa().toString();
				}
				if(ubicacionbode.getid_empresa()!=null)
				{
					strValorNuevo=ubicacionbode.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionBodeConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(ubicacionbode.getIsNew()||!ubicacionbode.getid_sucursal().equals(ubicacionbode.getUbicacionBodeOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionbode.getUbicacionBodeOriginal().getid_sucursal()!=null)
				{
					strValorActual=ubicacionbode.getUbicacionBodeOriginal().getid_sucursal().toString();
				}
				if(ubicacionbode.getid_sucursal()!=null)
				{
					strValorNuevo=ubicacionbode.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionBodeConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(ubicacionbode.getIsNew()||!ubicacionbode.getid_bodega().equals(ubicacionbode.getUbicacionBodeOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionbode.getUbicacionBodeOriginal().getid_bodega()!=null)
				{
					strValorActual=ubicacionbode.getUbicacionBodeOriginal().getid_bodega().toString();
				}
				if(ubicacionbode.getid_bodega()!=null)
				{
					strValorNuevo=ubicacionbode.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionBodeConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(ubicacionbode.getIsNew()||!ubicacionbode.getid_ubicacion_bode().equals(ubicacionbode.getUbicacionBodeOriginal().getid_ubicacion_bode()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionbode.getUbicacionBodeOriginal().getid_ubicacion_bode()!=null)
				{
					strValorActual=ubicacionbode.getUbicacionBodeOriginal().getid_ubicacion_bode().toString();
				}
				if(ubicacionbode.getid_ubicacion_bode()!=null)
				{
					strValorNuevo=ubicacionbode.getid_ubicacion_bode().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionBodeConstantesFunciones.IDUBICACIONBODE,strValorActual,strValorNuevo);
			}	
			
			if(ubicacionbode.getIsNew()||!ubicacionbode.getnombre().equals(ubicacionbode.getUbicacionBodeOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionbode.getUbicacionBodeOriginal().getnombre()!=null)
				{
					strValorActual=ubicacionbode.getUbicacionBodeOriginal().getnombre();
				}
				if(ubicacionbode.getnombre()!=null)
				{
					strValorNuevo=ubicacionbode.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionBodeConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(ubicacionbode.getIsNew()||!ubicacionbode.getnivel().equals(ubicacionbode.getUbicacionBodeOriginal().getnivel()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionbode.getUbicacionBodeOriginal().getnivel()!=null)
				{
					strValorActual=ubicacionbode.getUbicacionBodeOriginal().getnivel().toString();
				}
				if(ubicacionbode.getnivel()!=null)
				{
					strValorNuevo=ubicacionbode.getnivel().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionBodeConstantesFunciones.NIVEL,strValorActual,strValorNuevo);
			}	
			
			if(ubicacionbode.getIsNew()||!ubicacionbode.getorden().equals(ubicacionbode.getUbicacionBodeOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ubicacionbode.getUbicacionBodeOriginal().getorden()!=null)
				{
					strValorActual=ubicacionbode.getUbicacionBodeOriginal().getorden().toString();
				}
				if(ubicacionbode.getorden()!=null)
				{
					strValorNuevo=ubicacionbode.getorden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UbicacionBodeConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveUbicacionBodeRelacionesWithConnection(UbicacionBode ubicacionbode,List<UbicacionBode> ubicacionbodes,List<UbicacionProdu> ubicacionprodus) throws Exception {

		if(!ubicacionbode.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUbicacionBodeRelacionesBase(ubicacionbode,ubicacionbodes,ubicacionprodus,true);
		}
	}

	public void saveUbicacionBodeRelaciones(UbicacionBode ubicacionbode,List<UbicacionBode> ubicacionbodes,List<UbicacionProdu> ubicacionprodus)throws Exception {

		if(!ubicacionbode.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUbicacionBodeRelacionesBase(ubicacionbode,ubicacionbodes,ubicacionprodus,false);
		}
	}

	public void saveUbicacionBodeRelacionesBase(UbicacionBode ubicacionbode,List<UbicacionBode> ubicacionbodes,List<UbicacionProdu> ubicacionprodus,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("UbicacionBode-saveRelacionesWithConnection");}
	
			ubicacionbode.setUbicacionBodes(ubicacionbodes);
			ubicacionbode.setUbicacionProdus(ubicacionprodus);

			this.setUbicacionBode(ubicacionbode);

			if(UbicacionBodeLogicAdditional.validarSaveRelaciones(ubicacionbode,this)) {

				UbicacionBodeLogicAdditional.updateRelacionesToSave(ubicacionbode,this);

				if((ubicacionbode.getIsNew()||ubicacionbode.getIsChanged())&&!ubicacionbode.getIsDeleted()) {
					this.saveUbicacionBode();
					this.saveUbicacionBodeRelacionesDetalles(ubicacionbodes,ubicacionprodus);

				} else if(ubicacionbode.getIsDeleted()) {
					this.saveUbicacionBodeRelacionesDetalles(ubicacionbodes,ubicacionprodus);
					this.saveUbicacionBode();
				}

				UbicacionBodeLogicAdditional.updateRelacionesToSaveAfter(ubicacionbode,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			UbicacionBodeConstantesFunciones.InicializarGeneralEntityAuxiliaresUbicacionBodes(ubicacionbodes,true,true);
			UbicacionProduConstantesFunciones.InicializarGeneralEntityAuxiliaresUbicacionProdus(ubicacionprodus,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveUbicacionBodeRelacionesDetalles(List<UbicacionBode> ubicacionbodes,List<UbicacionProdu> ubicacionprodus)throws Exception {
		try {
	

			Long idUbicacionBodeActual=this.getUbicacionBode().getId();

			UbicacionBodeLogic ubicacionbodeLogicHijos_Desde_UbicacionBode=new UbicacionBodeLogic();
			ubicacionbodeLogicHijos_Desde_UbicacionBode.setUbicacionBodes(ubicacionbodes);

			ubicacionbodeLogicHijos_Desde_UbicacionBode.setConnexion(this.getConnexion());
			ubicacionbodeLogicHijos_Desde_UbicacionBode.setDatosCliente(this.datosCliente);

			for(UbicacionBode ubicacionbodeHijos_Desde_UbicacionBode:ubicacionbodeLogicHijos_Desde_UbicacionBode.getUbicacionBodes()) {
				ubicacionbodeHijos_Desde_UbicacionBode.setid_ubicacion_bode(idUbicacionBodeActual);

				ubicacionbodeLogicHijos_Desde_UbicacionBode.setUbicacionBode(ubicacionbodeHijos_Desde_UbicacionBode);
				ubicacionbodeLogicHijos_Desde_UbicacionBode.saveUbicacionBode();
			}


			UbicacionProduLogic ubicacionproduLogic_Desde_UbicacionBode=new UbicacionProduLogic();
			ubicacionproduLogic_Desde_UbicacionBode.setUbicacionProdus(ubicacionprodus);

			ubicacionproduLogic_Desde_UbicacionBode.setConnexion(this.getConnexion());
			ubicacionproduLogic_Desde_UbicacionBode.setDatosCliente(this.datosCliente);

			for(UbicacionProdu ubicacionprodu_Desde_UbicacionBode:ubicacionproduLogic_Desde_UbicacionBode.getUbicacionProdus()) {
				ubicacionprodu_Desde_UbicacionBode.setid_ubicacion_bode(idUbicacionBodeActual);
			}

			ubicacionproduLogic_Desde_UbicacionBode.saveUbicacionProdus();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfUbicacionBode(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UbicacionBodeConstantesFunciones.getClassesForeignKeysOfUbicacionBode(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUbicacionBode(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UbicacionBodeConstantesFunciones.getClassesRelationshipsOfUbicacionBode(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
