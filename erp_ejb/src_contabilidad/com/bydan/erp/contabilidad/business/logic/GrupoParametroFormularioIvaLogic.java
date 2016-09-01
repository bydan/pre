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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.GrupoParametroFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.GrupoParametroFormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.GrupoParametroFormularioIvaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.GrupoParametroFormularioIva;
//import com.bydan.erp.contabilidad.business.logic.GrupoParametroFormularioIvaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class GrupoParametroFormularioIvaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(GrupoParametroFormularioIvaLogic.class);
	
	protected GrupoParametroFormularioIvaDataAccess grupoparametroformularioivaDataAccess; 	
	protected GrupoParametroFormularioIva grupoparametroformularioiva;
	protected List<GrupoParametroFormularioIva> grupoparametroformularioivas;
	protected Object grupoparametroformularioivaObject;	
	protected List<Object> grupoparametroformularioivasObject;
	
	public static ClassValidator<GrupoParametroFormularioIva> grupoparametroformularioivaValidator = new ClassValidator<GrupoParametroFormularioIva>(GrupoParametroFormularioIva.class);	
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
	
	
	
	
	public  GrupoParametroFormularioIvaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.grupoparametroformularioivaDataAccess = new GrupoParametroFormularioIvaDataAccess();
			
			this.grupoparametroformularioivas= new ArrayList<GrupoParametroFormularioIva>();
			this.grupoparametroformularioiva= new GrupoParametroFormularioIva();
			
			this.grupoparametroformularioivaObject=new Object();
			this.grupoparametroformularioivasObject=new ArrayList<Object>();
				
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
			
			this.grupoparametroformularioivaDataAccess.setConnexionType(this.connexionType);
			this.grupoparametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GrupoParametroFormularioIvaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.grupoparametroformularioivaDataAccess = new GrupoParametroFormularioIvaDataAccess();
			this.grupoparametroformularioivas= new ArrayList<GrupoParametroFormularioIva>();
			this.grupoparametroformularioiva= new GrupoParametroFormularioIva();
			this.grupoparametroformularioivaObject=new Object();
			this.grupoparametroformularioivasObject=new ArrayList<Object>();
			
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
			
			this.grupoparametroformularioivaDataAccess.setConnexionType(this.connexionType);
			this.grupoparametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GrupoParametroFormularioIva getGrupoParametroFormularioIva() throws Exception {	
		//GrupoParametroFormularioIvaLogicAdditional.checkGrupoParametroFormularioIvaToGet(grupoparametroformularioiva,this.datosCliente,this.arrDatoGeneral);
		//GrupoParametroFormularioIvaLogicAdditional.updateGrupoParametroFormularioIvaToGet(grupoparametroformularioiva,this.arrDatoGeneral);
		
		return grupoparametroformularioiva;
	}
		
	public void setGrupoParametroFormularioIva(GrupoParametroFormularioIva newGrupoParametroFormularioIva) {
		this.grupoparametroformularioiva = newGrupoParametroFormularioIva;
	}
	
	public GrupoParametroFormularioIvaDataAccess getGrupoParametroFormularioIvaDataAccess() {
		return grupoparametroformularioivaDataAccess;
	}
	
	public void setGrupoParametroFormularioIvaDataAccess(GrupoParametroFormularioIvaDataAccess newgrupoparametroformularioivaDataAccess) {
		this.grupoparametroformularioivaDataAccess = newgrupoparametroformularioivaDataAccess;
	}
	
	public List<GrupoParametroFormularioIva> getGrupoParametroFormularioIvas() throws Exception {		
		this.quitarGrupoParametroFormularioIvasNulos();
		
		//GrupoParametroFormularioIvaLogicAdditional.checkGrupoParametroFormularioIvaToGets(grupoparametroformularioivas,this.datosCliente,this.arrDatoGeneral);
		
		for (GrupoParametroFormularioIva grupoparametroformularioivaLocal: grupoparametroformularioivas ) {
			//GrupoParametroFormularioIvaLogicAdditional.updateGrupoParametroFormularioIvaToGet(grupoparametroformularioivaLocal,this.arrDatoGeneral);
		}
		
		return grupoparametroformularioivas;
	}
	
	public void setGrupoParametroFormularioIvas(List<GrupoParametroFormularioIva> newGrupoParametroFormularioIvas) {
		this.grupoparametroformularioivas = newGrupoParametroFormularioIvas;
	}
	
	public Object getGrupoParametroFormularioIvaObject() {	
		this.grupoparametroformularioivaObject=this.grupoparametroformularioivaDataAccess.getEntityObject();
		return this.grupoparametroformularioivaObject;
	}
		
	public void setGrupoParametroFormularioIvaObject(Object newGrupoParametroFormularioIvaObject) {
		this.grupoparametroformularioivaObject = newGrupoParametroFormularioIvaObject;
	}
	
	public List<Object> getGrupoParametroFormularioIvasObject() {		
		this.grupoparametroformularioivasObject=this.grupoparametroformularioivaDataAccess.getEntitiesObject();
		return this.grupoparametroformularioivasObject;
	}
		
	public void setGrupoParametroFormularioIvasObject(List<Object> newGrupoParametroFormularioIvasObject) {
		this.grupoparametroformularioivasObject = newGrupoParametroFormularioIvasObject;
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
		
		if(this.grupoparametroformularioivaDataAccess!=null) {
			this.grupoparametroformularioivaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			grupoparametroformularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			grupoparametroformularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupoparametroformularioiva=grupoparametroformularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioiva);
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
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		  		  
        try {
			
			grupoparametroformularioiva=grupoparametroformularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupoparametroformularioiva=grupoparametroformularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioiva);
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
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		  		  
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
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		  		  
        try {
			
			grupoparametroformularioiva=grupoparametroformularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		  		  
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
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =grupoparametroformularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=grupoparametroformularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =grupoparametroformularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=grupoparametroformularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =grupoparametroformularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=grupoparametroformularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		grupoparametroformularioivas = new  ArrayList<GrupoParametroFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoParametroFormularioIva(grupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
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
		grupoparametroformularioivas = new  ArrayList<GrupoParametroFormularioIva>();
		  		  
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
		grupoparametroformularioivas = new  ArrayList<GrupoParametroFormularioIva>();
		  		  
        try {			
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarGrupoParametroFormularioIva(grupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		grupoparametroformularioivas = new  ArrayList<GrupoParametroFormularioIva>();
		  		  
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
		grupoparametroformularioivas = new  ArrayList<GrupoParametroFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoParametroFormularioIva(grupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
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
		grupoparametroformularioivas = new  ArrayList<GrupoParametroFormularioIva>();
		  		  
        try {
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoParametroFormularioIva(grupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
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
		grupoparametroformularioivas = new  ArrayList<GrupoParametroFormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoParametroFormularioIva(grupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
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
		grupoparametroformularioivas = new  ArrayList<GrupoParametroFormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoParametroFormularioIva(grupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoparametroformularioiva=grupoparametroformularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoParametroFormularioIva(grupoparametroformularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioiva);
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
		grupoparametroformularioiva = new  GrupoParametroFormularioIva();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoparametroformularioiva=grupoparametroformularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoParametroFormularioIva(grupoparametroformularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosGrupoParametroFormularioIvasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		grupoparametroformularioivas = new  ArrayList<GrupoParametroFormularioIva>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getTodosGrupoParametroFormularioIvasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoParametroFormularioIva(grupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
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
	
	public  void  getTodosGrupoParametroFormularioIvas(String sFinalQuery,Pagination pagination)throws Exception {
		grupoparametroformularioivas = new  ArrayList<GrupoParametroFormularioIva>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoParametroFormularioIva(grupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarGrupoParametroFormularioIva(GrupoParametroFormularioIva grupoparametroformularioiva) throws Exception {
		Boolean estaValidado=false;
		
		if(grupoparametroformularioiva.getIsNew() || grupoparametroformularioiva.getIsChanged()) { 
			this.invalidValues = grupoparametroformularioivaValidator.getInvalidValues(grupoparametroformularioiva);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(grupoparametroformularioiva);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarGrupoParametroFormularioIva(List<GrupoParametroFormularioIva> GrupoParametroFormularioIvas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(GrupoParametroFormularioIva grupoparametroformularioivaLocal:grupoparametroformularioivas) {				
			estaValidadoObjeto=this.validarGuardarGrupoParametroFormularioIva(grupoparametroformularioivaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarGrupoParametroFormularioIva(List<GrupoParametroFormularioIva> GrupoParametroFormularioIvas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoParametroFormularioIva(grupoparametroformularioivas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarGrupoParametroFormularioIva(GrupoParametroFormularioIva GrupoParametroFormularioIva) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoParametroFormularioIva(grupoparametroformularioiva)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(GrupoParametroFormularioIva grupoparametroformularioiva) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+grupoparametroformularioiva.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=GrupoParametroFormularioIvaConstantesFunciones.getGrupoParametroFormularioIvaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"grupoparametroformularioiva","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(GrupoParametroFormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(GrupoParametroFormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveGrupoParametroFormularioIvaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-saveGrupoParametroFormularioIvaWithConnection");connexion.begin();			
			
			//GrupoParametroFormularioIvaLogicAdditional.checkGrupoParametroFormularioIvaToSave(this.grupoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//GrupoParametroFormularioIvaLogicAdditional.updateGrupoParametroFormularioIvaToSave(this.grupoparametroformularioiva,this.arrDatoGeneral);
			
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupoparametroformularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowGrupoParametroFormularioIva();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoParametroFormularioIva(this.grupoparametroformularioiva)) {
				GrupoParametroFormularioIvaDataAccess.save(this.grupoparametroformularioiva, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.grupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//GrupoParametroFormularioIvaLogicAdditional.checkGrupoParametroFormularioIvaToSaveAfter(this.grupoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoParametroFormularioIva();
			
			connexion.commit();			
			
			if(this.grupoparametroformularioiva.getIsDeleted()) {
				this.grupoparametroformularioiva=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveGrupoParametroFormularioIva()throws Exception {	
		try {	
			
			//GrupoParametroFormularioIvaLogicAdditional.checkGrupoParametroFormularioIvaToSave(this.grupoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//GrupoParametroFormularioIvaLogicAdditional.updateGrupoParametroFormularioIvaToSave(this.grupoparametroformularioiva,this.arrDatoGeneral);
			
			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupoparametroformularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoParametroFormularioIva(this.grupoparametroformularioiva)) {			
				GrupoParametroFormularioIvaDataAccess.save(this.grupoparametroformularioiva, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.grupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//GrupoParametroFormularioIvaLogicAdditional.checkGrupoParametroFormularioIvaToSaveAfter(this.grupoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.grupoparametroformularioiva.getIsDeleted()) {
				this.grupoparametroformularioiva=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveGrupoParametroFormularioIvasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-saveGrupoParametroFormularioIvasWithConnection");connexion.begin();			
			
			//GrupoParametroFormularioIvaLogicAdditional.checkGrupoParametroFormularioIvaToSaves(grupoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowGrupoParametroFormularioIvas();
			
			Boolean validadoTodosGrupoParametroFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoParametroFormularioIva grupoparametroformularioivaLocal:grupoparametroformularioivas) {		
				if(grupoparametroformularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//GrupoParametroFormularioIvaLogicAdditional.updateGrupoParametroFormularioIvaToSave(grupoparametroformularioivaLocal,this.arrDatoGeneral);
	        	
				GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupoparametroformularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoParametroFormularioIva(grupoparametroformularioivaLocal)) {
					GrupoParametroFormularioIvaDataAccess.save(grupoparametroformularioivaLocal, connexion);				
				} else {
					validadoTodosGrupoParametroFormularioIva=false;
				}
			}
			
			if(!validadoTodosGrupoParametroFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//GrupoParametroFormularioIvaLogicAdditional.checkGrupoParametroFormularioIvaToSavesAfter(grupoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoParametroFormularioIvas();
			
			connexion.commit();		
			
			this.quitarGrupoParametroFormularioIvasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveGrupoParametroFormularioIvas()throws Exception {				
		 try {	
			//GrupoParametroFormularioIvaLogicAdditional.checkGrupoParametroFormularioIvaToSaves(grupoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosGrupoParametroFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoParametroFormularioIva grupoparametroformularioivaLocal:grupoparametroformularioivas) {				
				if(grupoparametroformularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//GrupoParametroFormularioIvaLogicAdditional.updateGrupoParametroFormularioIvaToSave(grupoparametroformularioivaLocal,this.arrDatoGeneral);
	        	
				GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupoparametroformularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoParametroFormularioIva(grupoparametroformularioivaLocal)) {				
					GrupoParametroFormularioIvaDataAccess.save(grupoparametroformularioivaLocal, connexion);				
				} else {
					validadoTodosGrupoParametroFormularioIva=false;
				}
			}
			
			if(!validadoTodosGrupoParametroFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//GrupoParametroFormularioIvaLogicAdditional.checkGrupoParametroFormularioIvaToSavesAfter(grupoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarGrupoParametroFormularioIvasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoParametroFormularioIvaParameterReturnGeneral procesarAccionGrupoParametroFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoParametroFormularioIva> grupoparametroformularioivas,GrupoParametroFormularioIvaParameterReturnGeneral grupoparametroformularioivaParameterGeneral)throws Exception {
		 try {	
			GrupoParametroFormularioIvaParameterReturnGeneral grupoparametroformularioivaReturnGeneral=new GrupoParametroFormularioIvaParameterReturnGeneral();
	
			
			return grupoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoParametroFormularioIvaParameterReturnGeneral procesarAccionGrupoParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoParametroFormularioIva> grupoparametroformularioivas,GrupoParametroFormularioIvaParameterReturnGeneral grupoparametroformularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-procesarAccionGrupoParametroFormularioIvasWithConnection");connexion.begin();			
			
			GrupoParametroFormularioIvaParameterReturnGeneral grupoparametroformularioivaReturnGeneral=new GrupoParametroFormularioIvaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return grupoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoParametroFormularioIvaParameterReturnGeneral procesarEventosGrupoParametroFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoParametroFormularioIva> grupoparametroformularioivas,GrupoParametroFormularioIva grupoparametroformularioiva,GrupoParametroFormularioIvaParameterReturnGeneral grupoparametroformularioivaParameterGeneral,Boolean isEsNuevoGrupoParametroFormularioIva,ArrayList<Classe> clases)throws Exception {
		 try {	
			GrupoParametroFormularioIvaParameterReturnGeneral grupoparametroformularioivaReturnGeneral=new GrupoParametroFormularioIvaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupoparametroformularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return grupoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public GrupoParametroFormularioIvaParameterReturnGeneral procesarEventosGrupoParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoParametroFormularioIva> grupoparametroformularioivas,GrupoParametroFormularioIva grupoparametroformularioiva,GrupoParametroFormularioIvaParameterReturnGeneral grupoparametroformularioivaParameterGeneral,Boolean isEsNuevoGrupoParametroFormularioIva,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-procesarEventosGrupoParametroFormularioIvasWithConnection");connexion.begin();			
			
			GrupoParametroFormularioIvaParameterReturnGeneral grupoparametroformularioivaReturnGeneral=new GrupoParametroFormularioIvaParameterReturnGeneral();
	
			grupoparametroformularioivaReturnGeneral.setGrupoParametroFormularioIva(grupoparametroformularioiva);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupoparametroformularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return grupoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoParametroFormularioIvaParameterReturnGeneral procesarImportacionGrupoParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,GrupoParametroFormularioIvaParameterReturnGeneral grupoparametroformularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-procesarImportacionGrupoParametroFormularioIvasWithConnection");connexion.begin();			
			
			GrupoParametroFormularioIvaParameterReturnGeneral grupoparametroformularioivaReturnGeneral=new GrupoParametroFormularioIvaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.grupoparametroformularioivas=new ArrayList<GrupoParametroFormularioIva>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.grupoparametroformularioiva=new GrupoParametroFormularioIva();
				
				
				if(conColumnasBase) {this.grupoparametroformularioiva.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.grupoparametroformularioiva.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.grupoparametroformularioiva.setnombre(arrColumnas[iColumn++]);
				
				this.grupoparametroformularioivas.add(this.grupoparametroformularioiva);
			}
			
			this.saveGrupoParametroFormularioIvas();
			
			this.connexion.commit();
			
			grupoparametroformularioivaReturnGeneral.setConRetornoEstaProcesado(true);
			grupoparametroformularioivaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return grupoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarGrupoParametroFormularioIvasEliminados() throws Exception {				
		
		List<GrupoParametroFormularioIva> grupoparametroformularioivasAux= new ArrayList<GrupoParametroFormularioIva>();
		
		for(GrupoParametroFormularioIva grupoparametroformularioiva:grupoparametroformularioivas) {
			if(!grupoparametroformularioiva.getIsDeleted()) {
				grupoparametroformularioivasAux.add(grupoparametroformularioiva);
			}
		}
		
		grupoparametroformularioivas=grupoparametroformularioivasAux;
	}
	
	public void quitarGrupoParametroFormularioIvasNulos() throws Exception {				
		
		List<GrupoParametroFormularioIva> grupoparametroformularioivasAux= new ArrayList<GrupoParametroFormularioIva>();
		
		for(GrupoParametroFormularioIva grupoparametroformularioiva : this.grupoparametroformularioivas) {
			if(grupoparametroformularioiva==null) {
				grupoparametroformularioivasAux.add(grupoparametroformularioiva);
			}
		}
		
		//this.grupoparametroformularioivas=grupoparametroformularioivasAux;
		
		this.grupoparametroformularioivas.removeAll(grupoparametroformularioivasAux);
	}
	
	public void getSetVersionRowGrupoParametroFormularioIvaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(grupoparametroformularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((grupoparametroformularioiva.getIsDeleted() || (grupoparametroformularioiva.getIsChanged()&&!grupoparametroformularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=grupoparametroformularioivaDataAccess.getSetVersionRowGrupoParametroFormularioIva(connexion,grupoparametroformularioiva.getId());
				
				if(!grupoparametroformularioiva.getVersionRow().equals(timestamp)) {	
					grupoparametroformularioiva.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				grupoparametroformularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowGrupoParametroFormularioIva()throws Exception {	
		
		if(grupoparametroformularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((grupoparametroformularioiva.getIsDeleted() || (grupoparametroformularioiva.getIsChanged()&&!grupoparametroformularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=grupoparametroformularioivaDataAccess.getSetVersionRowGrupoParametroFormularioIva(connexion,grupoparametroformularioiva.getId());
			
			try {							
				if(!grupoparametroformularioiva.getVersionRow().equals(timestamp)) {	
					grupoparametroformularioiva.setVersionRow(timestamp);
				}
				
				grupoparametroformularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowGrupoParametroFormularioIvasWithConnection()throws Exception {	
		if(grupoparametroformularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(GrupoParametroFormularioIva grupoparametroformularioivaAux:grupoparametroformularioivas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(grupoparametroformularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupoparametroformularioivaAux.getIsDeleted() || (grupoparametroformularioivaAux.getIsChanged()&&!grupoparametroformularioivaAux.getIsNew())) {
						
						timestamp=grupoparametroformularioivaDataAccess.getSetVersionRowGrupoParametroFormularioIva(connexion,grupoparametroformularioivaAux.getId());
						
						if(!grupoparametroformularioiva.getVersionRow().equals(timestamp)) {	
							grupoparametroformularioivaAux.setVersionRow(timestamp);
						}
								
						grupoparametroformularioivaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowGrupoParametroFormularioIvas()throws Exception {	
		if(grupoparametroformularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(GrupoParametroFormularioIva grupoparametroformularioivaAux:grupoparametroformularioivas) {
					if(grupoparametroformularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupoparametroformularioivaAux.getIsDeleted() || (grupoparametroformularioivaAux.getIsChanged()&&!grupoparametroformularioivaAux.getIsNew())) {
						
						timestamp=grupoparametroformularioivaDataAccess.getSetVersionRowGrupoParametroFormularioIva(connexion,grupoparametroformularioivaAux.getId());
						
						if(!grupoparametroformularioivaAux.getVersionRow().equals(timestamp)) {	
							grupoparametroformularioivaAux.setVersionRow(timestamp);
						}
						
													
						grupoparametroformularioivaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public GrupoParametroFormularioIvaParameterReturnGeneral cargarCombosLoteForeignKeyGrupoParametroFormularioIvaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		GrupoParametroFormularioIvaParameterReturnGeneral  grupoparametroformularioivaReturnGeneral =new GrupoParametroFormularioIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-cargarCombosLoteForeignKeyGrupoParametroFormularioIvaWithConnection");connexion.begin();
			
			grupoparametroformularioivaReturnGeneral =new GrupoParametroFormularioIvaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			grupoparametroformularioivaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return grupoparametroformularioivaReturnGeneral;
	}
	
	public GrupoParametroFormularioIvaParameterReturnGeneral cargarCombosLoteForeignKeyGrupoParametroFormularioIva(String finalQueryGlobalEmpresa) throws Exception {
		GrupoParametroFormularioIvaParameterReturnGeneral  grupoparametroformularioivaReturnGeneral =new GrupoParametroFormularioIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			grupoparametroformularioivaReturnGeneral =new GrupoParametroFormularioIvaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			grupoparametroformularioivaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return grupoparametroformularioivaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyGrupoParametroFormularioIvaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ParametroFormularioIvaLogic parametroformularioivaLogic=new ParametroFormularioIvaLogic();
			FormularioIvaLogic formularioivaLogic=new FormularioIvaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyGrupoParametroFormularioIvaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ParametroFormularioIva.class));
			classes.add(new Classe(FormularioIva.class));
											
			

			parametroformularioivaLogic.setConnexion(this.getConnexion());
			parametroformularioivaLogic.setDatosCliente(this.datosCliente);
			parametroformularioivaLogic.setIsConRefrescarForeignKeys(true);

			formularioivaLogic.setConnexion(this.getConnexion());
			formularioivaLogic.setDatosCliente(this.datosCliente);
			formularioivaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(GrupoParametroFormularioIva grupoparametroformularioiva:this.grupoparametroformularioivas) {
				

				classes=new ArrayList<Classe>();
				classes=ParametroFormularioIvaConstantesFunciones.getClassesForeignKeysOfParametroFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroformularioivaLogic.setParametroFormularioIvas(grupoparametroformularioiva.parametroformularioivas);
				parametroformularioivaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormularioIvaConstantesFunciones.getClassesForeignKeysOfFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);

				formularioivaLogic.setFormularioIvas(grupoparametroformularioiva.formularioivas);
				formularioivaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(GrupoParametroFormularioIva grupoparametroformularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//GrupoParametroFormularioIvaLogicAdditional.updateGrupoParametroFormularioIvaToGet(grupoparametroformularioiva,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupoparametroformularioiva.setEmpresa(grupoparametroformularioivaDataAccess.getEmpresa(connexion,grupoparametroformularioiva));
		grupoparametroformularioiva.setParametroFormularioIvas(grupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,grupoparametroformularioiva));
		grupoparametroformularioiva.setFormularioIvas(grupoparametroformularioivaDataAccess.getFormularioIvas(connexion,grupoparametroformularioiva));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				grupoparametroformularioiva.setEmpresa(grupoparametroformularioivaDataAccess.getEmpresa(connexion,grupoparametroformularioiva));
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupoparametroformularioiva.setParametroFormularioIvas(grupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,grupoparametroformularioiva));

				if(this.isConDeep) {
					ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(this.connexion);
					parametroformularioivaLogic.setParametroFormularioIvas(grupoparametroformularioiva.getParametroFormularioIvas());
					ArrayList<Classe> classesLocal=ParametroFormularioIvaConstantesFunciones.getClassesForeignKeysOfParametroFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroformularioivaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(parametroformularioivaLogic.getParametroFormularioIvas());
					grupoparametroformularioiva.setParametroFormularioIvas(parametroformularioivaLogic.getParametroFormularioIvas());
				}

				continue;
			}

			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupoparametroformularioiva.setFormularioIvas(grupoparametroformularioivaDataAccess.getFormularioIvas(connexion,grupoparametroformularioiva));

				if(this.isConDeep) {
					FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(this.connexion);
					formularioivaLogic.setFormularioIvas(grupoparametroformularioiva.getFormularioIvas());
					ArrayList<Classe> classesLocal=FormularioIvaConstantesFunciones.getClassesForeignKeysOfFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);
					formularioivaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(formularioivaLogic.getFormularioIvas());
					grupoparametroformularioiva.setFormularioIvas(formularioivaLogic.getFormularioIvas());
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
			grupoparametroformularioiva.setEmpresa(grupoparametroformularioivaDataAccess.getEmpresa(connexion,grupoparametroformularioiva));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroFormularioIva.class));
			grupoparametroformularioiva.setParametroFormularioIvas(grupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,grupoparametroformularioiva));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioIva.class));
			grupoparametroformularioiva.setFormularioIvas(grupoparametroformularioivaDataAccess.getFormularioIvas(connexion,grupoparametroformularioiva));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupoparametroformularioiva.setEmpresa(grupoparametroformularioivaDataAccess.getEmpresa(connexion,grupoparametroformularioiva));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(grupoparametroformularioiva.getEmpresa(),isDeep,deepLoadType,clases);
				

		grupoparametroformularioiva.setParametroFormularioIvas(grupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,grupoparametroformularioiva));

		for(ParametroFormularioIva parametroformularioiva:grupoparametroformularioiva.getParametroFormularioIvas()) {
			ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
			parametroformularioivaLogic.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);
		}

		grupoparametroformularioiva.setFormularioIvas(grupoparametroformularioivaDataAccess.getFormularioIvas(connexion,grupoparametroformularioiva));

		for(FormularioIva formularioiva:grupoparametroformularioiva.getFormularioIvas()) {
			FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
			formularioivaLogic.deepLoad(formularioiva,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				grupoparametroformularioiva.setEmpresa(grupoparametroformularioivaDataAccess.getEmpresa(connexion,grupoparametroformularioiva));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(grupoparametroformularioiva.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupoparametroformularioiva.setParametroFormularioIvas(grupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,grupoparametroformularioiva));

				for(ParametroFormularioIva parametroformularioiva:grupoparametroformularioiva.getParametroFormularioIvas()) {
					ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
					parametroformularioivaLogic.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupoparametroformularioiva.setFormularioIvas(grupoparametroformularioivaDataAccess.getFormularioIvas(connexion,grupoparametroformularioiva));

				for(FormularioIva formularioiva:grupoparametroformularioiva.getFormularioIvas()) {
					FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
					formularioivaLogic.deepLoad(formularioiva,isDeep,deepLoadType,clases);
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
			grupoparametroformularioiva.setEmpresa(grupoparametroformularioivaDataAccess.getEmpresa(connexion,grupoparametroformularioiva));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(grupoparametroformularioiva.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroFormularioIva.class));
			grupoparametroformularioiva.setParametroFormularioIvas(grupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,grupoparametroformularioiva));

			for(ParametroFormularioIva parametroformularioiva:grupoparametroformularioiva.getParametroFormularioIvas()) {
				ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
				parametroformularioivaLogic.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioIva.class));
			grupoparametroformularioiva.setFormularioIvas(grupoparametroformularioivaDataAccess.getFormularioIvas(connexion,grupoparametroformularioiva));

			for(FormularioIva formularioiva:grupoparametroformularioiva.getFormularioIvas()) {
				FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
				formularioivaLogic.deepLoad(formularioiva,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(GrupoParametroFormularioIva grupoparametroformularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GrupoParametroFormularioIva.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(grupoparametroformularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(grupoparametroformularioiva);
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
			this.deepLoad(this.grupoparametroformularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GrupoParametroFormularioIva.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(grupoparametroformularioivas!=null) {
				for(GrupoParametroFormularioIva grupoparametroformularioiva:grupoparametroformularioivas) {
					this.deepLoad(grupoparametroformularioiva,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(grupoparametroformularioivas);
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
			if(grupoparametroformularioivas!=null) {
				for(GrupoParametroFormularioIva grupoparametroformularioiva:grupoparametroformularioivas) {
					this.deepLoad(grupoparametroformularioiva,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(grupoparametroformularioivas);
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
	
	
	public void getGrupoParametroFormularioIvasBusquedaPorIdWithConnection(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,GrupoParametroFormularioIvaConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoParametroFormularioIvasBusquedaPorId(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,GrupoParametroFormularioIvaConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoParametroFormularioIvasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",GrupoParametroFormularioIvaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoParametroFormularioIvasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",GrupoParametroFormularioIvaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoParametroFormularioIvasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoParametroFormularioIvasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoparametroformularioivas=grupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(this.grupoparametroformularioivas);
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
			if(GrupoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoParametroFormularioIvaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,GrupoParametroFormularioIva grupoparametroformularioiva,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(GrupoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				if(grupoparametroformularioiva.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoParametroFormularioIvaDataAccess.TABLENAME, grupoparametroformularioiva.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GrupoParametroFormularioIvaLogic.registrarAuditoriaDetallesGrupoParametroFormularioIva(connexion,grupoparametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(grupoparametroformularioiva.getIsDeleted()) {
					/*if(!grupoparametroformularioiva.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,GrupoParametroFormularioIvaDataAccess.TABLENAME, grupoparametroformularioiva.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////GrupoParametroFormularioIvaLogic.registrarAuditoriaDetallesGrupoParametroFormularioIva(connexion,grupoparametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoParametroFormularioIvaDataAccess.TABLENAME, grupoparametroformularioiva.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(grupoparametroformularioiva.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoParametroFormularioIvaDataAccess.TABLENAME, grupoparametroformularioiva.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GrupoParametroFormularioIvaLogic.registrarAuditoriaDetallesGrupoParametroFormularioIva(connexion,grupoparametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesGrupoParametroFormularioIva(Connexion connexion,GrupoParametroFormularioIva grupoparametroformularioiva)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(grupoparametroformularioiva.getIsNew()||!grupoparametroformularioiva.getid_empresa().equals(grupoparametroformularioiva.getGrupoParametroFormularioIvaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupoparametroformularioiva.getGrupoParametroFormularioIvaOriginal().getid_empresa()!=null)
				{
					strValorActual=grupoparametroformularioiva.getGrupoParametroFormularioIvaOriginal().getid_empresa().toString();
				}
				if(grupoparametroformularioiva.getid_empresa()!=null)
				{
					strValorNuevo=grupoparametroformularioiva.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(grupoparametroformularioiva.getIsNew()||!grupoparametroformularioiva.getnombre().equals(grupoparametroformularioiva.getGrupoParametroFormularioIvaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupoparametroformularioiva.getGrupoParametroFormularioIvaOriginal().getnombre()!=null)
				{
					strValorActual=grupoparametroformularioiva.getGrupoParametroFormularioIvaOriginal().getnombre();
				}
				if(grupoparametroformularioiva.getnombre()!=null)
				{
					strValorNuevo=grupoparametroformularioiva.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoParametroFormularioIvaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoParametroFormularioIvaConstantesFunciones.getClassesForeignKeysOfGrupoParametroFormularioIva(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoParametroFormularioIvaConstantesFunciones.getClassesRelationshipsOfGrupoParametroFormularioIva(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
