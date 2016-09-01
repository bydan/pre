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
import com.bydan.erp.contabilidad.util.SubGrupoParametroFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.SubGrupoParametroFormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.SubGrupoParametroFormularioIvaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.SubGrupoParametroFormularioIva;
//import com.bydan.erp.contabilidad.business.logic.SubGrupoParametroFormularioIvaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class SubGrupoParametroFormularioIvaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SubGrupoParametroFormularioIvaLogic.class);
	
	protected SubGrupoParametroFormularioIvaDataAccess subgrupoparametroformularioivaDataAccess; 	
	protected SubGrupoParametroFormularioIva subgrupoparametroformularioiva;
	protected List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas;
	protected Object subgrupoparametroformularioivaObject;	
	protected List<Object> subgrupoparametroformularioivasObject;
	
	public static ClassValidator<SubGrupoParametroFormularioIva> subgrupoparametroformularioivaValidator = new ClassValidator<SubGrupoParametroFormularioIva>(SubGrupoParametroFormularioIva.class);	
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
	
	
	
	
	public  SubGrupoParametroFormularioIvaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.subgrupoparametroformularioivaDataAccess = new SubGrupoParametroFormularioIvaDataAccess();
			
			this.subgrupoparametroformularioivas= new ArrayList<SubGrupoParametroFormularioIva>();
			this.subgrupoparametroformularioiva= new SubGrupoParametroFormularioIva();
			
			this.subgrupoparametroformularioivaObject=new Object();
			this.subgrupoparametroformularioivasObject=new ArrayList<Object>();
				
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
			
			this.subgrupoparametroformularioivaDataAccess.setConnexionType(this.connexionType);
			this.subgrupoparametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SubGrupoParametroFormularioIvaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.subgrupoparametroformularioivaDataAccess = new SubGrupoParametroFormularioIvaDataAccess();
			this.subgrupoparametroformularioivas= new ArrayList<SubGrupoParametroFormularioIva>();
			this.subgrupoparametroformularioiva= new SubGrupoParametroFormularioIva();
			this.subgrupoparametroformularioivaObject=new Object();
			this.subgrupoparametroformularioivasObject=new ArrayList<Object>();
			
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
			
			this.subgrupoparametroformularioivaDataAccess.setConnexionType(this.connexionType);
			this.subgrupoparametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SubGrupoParametroFormularioIva getSubGrupoParametroFormularioIva() throws Exception {	
		//SubGrupoParametroFormularioIvaLogicAdditional.checkSubGrupoParametroFormularioIvaToGet(subgrupoparametroformularioiva,this.datosCliente,this.arrDatoGeneral);
		//SubGrupoParametroFormularioIvaLogicAdditional.updateSubGrupoParametroFormularioIvaToGet(subgrupoparametroformularioiva,this.arrDatoGeneral);
		
		return subgrupoparametroformularioiva;
	}
		
	public void setSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva newSubGrupoParametroFormularioIva) {
		this.subgrupoparametroformularioiva = newSubGrupoParametroFormularioIva;
	}
	
	public SubGrupoParametroFormularioIvaDataAccess getSubGrupoParametroFormularioIvaDataAccess() {
		return subgrupoparametroformularioivaDataAccess;
	}
	
	public void setSubGrupoParametroFormularioIvaDataAccess(SubGrupoParametroFormularioIvaDataAccess newsubgrupoparametroformularioivaDataAccess) {
		this.subgrupoparametroformularioivaDataAccess = newsubgrupoparametroformularioivaDataAccess;
	}
	
	public List<SubGrupoParametroFormularioIva> getSubGrupoParametroFormularioIvas() throws Exception {		
		this.quitarSubGrupoParametroFormularioIvasNulos();
		
		//SubGrupoParametroFormularioIvaLogicAdditional.checkSubGrupoParametroFormularioIvaToGets(subgrupoparametroformularioivas,this.datosCliente,this.arrDatoGeneral);
		
		for (SubGrupoParametroFormularioIva subgrupoparametroformularioivaLocal: subgrupoparametroformularioivas ) {
			//SubGrupoParametroFormularioIvaLogicAdditional.updateSubGrupoParametroFormularioIvaToGet(subgrupoparametroformularioivaLocal,this.arrDatoGeneral);
		}
		
		return subgrupoparametroformularioivas;
	}
	
	public void setSubGrupoParametroFormularioIvas(List<SubGrupoParametroFormularioIva> newSubGrupoParametroFormularioIvas) {
		this.subgrupoparametroformularioivas = newSubGrupoParametroFormularioIvas;
	}
	
	public Object getSubGrupoParametroFormularioIvaObject() {	
		this.subgrupoparametroformularioivaObject=this.subgrupoparametroformularioivaDataAccess.getEntityObject();
		return this.subgrupoparametroformularioivaObject;
	}
		
	public void setSubGrupoParametroFormularioIvaObject(Object newSubGrupoParametroFormularioIvaObject) {
		this.subgrupoparametroformularioivaObject = newSubGrupoParametroFormularioIvaObject;
	}
	
	public List<Object> getSubGrupoParametroFormularioIvasObject() {		
		this.subgrupoparametroformularioivasObject=this.subgrupoparametroformularioivaDataAccess.getEntitiesObject();
		return this.subgrupoparametroformularioivasObject;
	}
		
	public void setSubGrupoParametroFormularioIvasObject(List<Object> newSubGrupoParametroFormularioIvasObject) {
		this.subgrupoparametroformularioivasObject = newSubGrupoParametroFormularioIvasObject;
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
		
		if(this.subgrupoparametroformularioivaDataAccess!=null) {
			this.subgrupoparametroformularioivaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			subgrupoparametroformularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			subgrupoparametroformularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			subgrupoparametroformularioiva=subgrupoparametroformularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subgrupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioiva);
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
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		  		  
        try {
			
			subgrupoparametroformularioiva=subgrupoparametroformularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subgrupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			subgrupoparametroformularioiva=subgrupoparametroformularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subgrupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioiva);
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
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		  		  
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
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		  		  
        try {
			
			subgrupoparametroformularioiva=subgrupoparametroformularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subgrupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		  		  
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
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =subgrupoparametroformularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=subgrupoparametroformularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =subgrupoparametroformularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=subgrupoparametroformularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =subgrupoparametroformularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=subgrupoparametroformularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		subgrupoparametroformularioivas = new  ArrayList<SubGrupoParametroFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubGrupoParametroFormularioIva(subgrupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
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
		subgrupoparametroformularioivas = new  ArrayList<SubGrupoParametroFormularioIva>();
		  		  
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
		subgrupoparametroformularioivas = new  ArrayList<SubGrupoParametroFormularioIva>();
		  		  
        try {			
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSubGrupoParametroFormularioIva(subgrupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		subgrupoparametroformularioivas = new  ArrayList<SubGrupoParametroFormularioIva>();
		  		  
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
		subgrupoparametroformularioivas = new  ArrayList<SubGrupoParametroFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubGrupoParametroFormularioIva(subgrupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
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
		subgrupoparametroformularioivas = new  ArrayList<SubGrupoParametroFormularioIva>();
		  		  
        try {
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubGrupoParametroFormularioIva(subgrupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
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
		subgrupoparametroformularioivas = new  ArrayList<SubGrupoParametroFormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubGrupoParametroFormularioIva(subgrupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
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
		subgrupoparametroformularioivas = new  ArrayList<SubGrupoParametroFormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubGrupoParametroFormularioIva(subgrupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoparametroformularioiva=subgrupoparametroformularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubGrupoParametroFormularioIva(subgrupoparametroformularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioiva);
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
		subgrupoparametroformularioiva = new  SubGrupoParametroFormularioIva();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoparametroformularioiva=subgrupoparametroformularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubGrupoParametroFormularioIva(subgrupoparametroformularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosSubGrupoParametroFormularioIvasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		subgrupoparametroformularioivas = new  ArrayList<SubGrupoParametroFormularioIva>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getTodosSubGrupoParametroFormularioIvasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSubGrupoParametroFormularioIva(subgrupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
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
	
	public  void  getTodosSubGrupoParametroFormularioIvas(String sFinalQuery,Pagination pagination)throws Exception {
		subgrupoparametroformularioivas = new  ArrayList<SubGrupoParametroFormularioIva>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSubGrupoParametroFormularioIva(subgrupoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva subgrupoparametroformularioiva) throws Exception {
		Boolean estaValidado=false;
		
		if(subgrupoparametroformularioiva.getIsNew() || subgrupoparametroformularioiva.getIsChanged()) { 
			this.invalidValues = subgrupoparametroformularioivaValidator.getInvalidValues(subgrupoparametroformularioiva);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(subgrupoparametroformularioiva);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSubGrupoParametroFormularioIva(List<SubGrupoParametroFormularioIva> SubGrupoParametroFormularioIvas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioivaLocal:subgrupoparametroformularioivas) {				
			estaValidadoObjeto=this.validarGuardarSubGrupoParametroFormularioIva(subgrupoparametroformularioivaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSubGrupoParametroFormularioIva(List<SubGrupoParametroFormularioIva> SubGrupoParametroFormularioIvas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSubGrupoParametroFormularioIva(subgrupoparametroformularioivas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva SubGrupoParametroFormularioIva) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSubGrupoParametroFormularioIva(subgrupoparametroformularioiva)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SubGrupoParametroFormularioIva subgrupoparametroformularioiva) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+subgrupoparametroformularioiva.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SubGrupoParametroFormularioIvaConstantesFunciones.getSubGrupoParametroFormularioIvaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"subgrupoparametroformularioiva","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SubGrupoParametroFormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SubGrupoParametroFormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSubGrupoParametroFormularioIvaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-saveSubGrupoParametroFormularioIvaWithConnection");connexion.begin();			
			
			//SubGrupoParametroFormularioIvaLogicAdditional.checkSubGrupoParametroFormularioIvaToSave(this.subgrupoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SubGrupoParametroFormularioIvaLogicAdditional.updateSubGrupoParametroFormularioIvaToSave(this.subgrupoparametroformularioiva,this.arrDatoGeneral);
			
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.subgrupoparametroformularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSubGrupoParametroFormularioIva();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSubGrupoParametroFormularioIva(this.subgrupoparametroformularioiva)) {
				SubGrupoParametroFormularioIvaDataAccess.save(this.subgrupoparametroformularioiva, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.subgrupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//SubGrupoParametroFormularioIvaLogicAdditional.checkSubGrupoParametroFormularioIvaToSaveAfter(this.subgrupoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSubGrupoParametroFormularioIva();
			
			connexion.commit();			
			
			if(this.subgrupoparametroformularioiva.getIsDeleted()) {
				this.subgrupoparametroformularioiva=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSubGrupoParametroFormularioIva()throws Exception {	
		try {	
			
			//SubGrupoParametroFormularioIvaLogicAdditional.checkSubGrupoParametroFormularioIvaToSave(this.subgrupoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SubGrupoParametroFormularioIvaLogicAdditional.updateSubGrupoParametroFormularioIvaToSave(this.subgrupoparametroformularioiva,this.arrDatoGeneral);
			
			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.subgrupoparametroformularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSubGrupoParametroFormularioIva(this.subgrupoparametroformularioiva)) {			
				SubGrupoParametroFormularioIvaDataAccess.save(this.subgrupoparametroformularioiva, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.subgrupoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//SubGrupoParametroFormularioIvaLogicAdditional.checkSubGrupoParametroFormularioIvaToSaveAfter(this.subgrupoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.subgrupoparametroformularioiva.getIsDeleted()) {
				this.subgrupoparametroformularioiva=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSubGrupoParametroFormularioIvasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-saveSubGrupoParametroFormularioIvasWithConnection");connexion.begin();			
			
			//SubGrupoParametroFormularioIvaLogicAdditional.checkSubGrupoParametroFormularioIvaToSaves(subgrupoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSubGrupoParametroFormularioIvas();
			
			Boolean validadoTodosSubGrupoParametroFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SubGrupoParametroFormularioIva subgrupoparametroformularioivaLocal:subgrupoparametroformularioivas) {		
				if(subgrupoparametroformularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//SubGrupoParametroFormularioIvaLogicAdditional.updateSubGrupoParametroFormularioIvaToSave(subgrupoparametroformularioivaLocal,this.arrDatoGeneral);
	        	
				SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),subgrupoparametroformularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSubGrupoParametroFormularioIva(subgrupoparametroformularioivaLocal)) {
					SubGrupoParametroFormularioIvaDataAccess.save(subgrupoparametroformularioivaLocal, connexion);				
				} else {
					validadoTodosSubGrupoParametroFormularioIva=false;
				}
			}
			
			if(!validadoTodosSubGrupoParametroFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//SubGrupoParametroFormularioIvaLogicAdditional.checkSubGrupoParametroFormularioIvaToSavesAfter(subgrupoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSubGrupoParametroFormularioIvas();
			
			connexion.commit();		
			
			this.quitarSubGrupoParametroFormularioIvasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSubGrupoParametroFormularioIvas()throws Exception {				
		 try {	
			//SubGrupoParametroFormularioIvaLogicAdditional.checkSubGrupoParametroFormularioIvaToSaves(subgrupoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSubGrupoParametroFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SubGrupoParametroFormularioIva subgrupoparametroformularioivaLocal:subgrupoparametroformularioivas) {				
				if(subgrupoparametroformularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//SubGrupoParametroFormularioIvaLogicAdditional.updateSubGrupoParametroFormularioIvaToSave(subgrupoparametroformularioivaLocal,this.arrDatoGeneral);
	        	
				SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),subgrupoparametroformularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSubGrupoParametroFormularioIva(subgrupoparametroformularioivaLocal)) {				
					SubGrupoParametroFormularioIvaDataAccess.save(subgrupoparametroformularioivaLocal, connexion);				
				} else {
					validadoTodosSubGrupoParametroFormularioIva=false;
				}
			}
			
			if(!validadoTodosSubGrupoParametroFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//SubGrupoParametroFormularioIvaLogicAdditional.checkSubGrupoParametroFormularioIvaToSavesAfter(subgrupoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSubGrupoParametroFormularioIvasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SubGrupoParametroFormularioIvaParameterReturnGeneral procesarAccionSubGrupoParametroFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas,SubGrupoParametroFormularioIvaParameterReturnGeneral subgrupoparametroformularioivaParameterGeneral)throws Exception {
		 try {	
			SubGrupoParametroFormularioIvaParameterReturnGeneral subgrupoparametroformularioivaReturnGeneral=new SubGrupoParametroFormularioIvaParameterReturnGeneral();
	
			
			return subgrupoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SubGrupoParametroFormularioIvaParameterReturnGeneral procesarAccionSubGrupoParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas,SubGrupoParametroFormularioIvaParameterReturnGeneral subgrupoparametroformularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-procesarAccionSubGrupoParametroFormularioIvasWithConnection");connexion.begin();			
			
			SubGrupoParametroFormularioIvaParameterReturnGeneral subgrupoparametroformularioivaReturnGeneral=new SubGrupoParametroFormularioIvaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return subgrupoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SubGrupoParametroFormularioIvaParameterReturnGeneral procesarEventosSubGrupoParametroFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas,SubGrupoParametroFormularioIva subgrupoparametroformularioiva,SubGrupoParametroFormularioIvaParameterReturnGeneral subgrupoparametroformularioivaParameterGeneral,Boolean isEsNuevoSubGrupoParametroFormularioIva,ArrayList<Classe> clases)throws Exception {
		 try {	
			SubGrupoParametroFormularioIvaParameterReturnGeneral subgrupoparametroformularioivaReturnGeneral=new SubGrupoParametroFormularioIvaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				subgrupoparametroformularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return subgrupoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SubGrupoParametroFormularioIvaParameterReturnGeneral procesarEventosSubGrupoParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas,SubGrupoParametroFormularioIva subgrupoparametroformularioiva,SubGrupoParametroFormularioIvaParameterReturnGeneral subgrupoparametroformularioivaParameterGeneral,Boolean isEsNuevoSubGrupoParametroFormularioIva,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-procesarEventosSubGrupoParametroFormularioIvasWithConnection");connexion.begin();			
			
			SubGrupoParametroFormularioIvaParameterReturnGeneral subgrupoparametroformularioivaReturnGeneral=new SubGrupoParametroFormularioIvaParameterReturnGeneral();
	
			subgrupoparametroformularioivaReturnGeneral.setSubGrupoParametroFormularioIva(subgrupoparametroformularioiva);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				subgrupoparametroformularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return subgrupoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SubGrupoParametroFormularioIvaParameterReturnGeneral procesarImportacionSubGrupoParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SubGrupoParametroFormularioIvaParameterReturnGeneral subgrupoparametroformularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-procesarImportacionSubGrupoParametroFormularioIvasWithConnection");connexion.begin();			
			
			SubGrupoParametroFormularioIvaParameterReturnGeneral subgrupoparametroformularioivaReturnGeneral=new SubGrupoParametroFormularioIvaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.subgrupoparametroformularioivas=new ArrayList<SubGrupoParametroFormularioIva>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.subgrupoparametroformularioiva=new SubGrupoParametroFormularioIva();
				
				
				if(conColumnasBase) {this.subgrupoparametroformularioiva.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.subgrupoparametroformularioiva.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.subgrupoparametroformularioiva.setnombre(arrColumnas[iColumn++]);
				
				this.subgrupoparametroformularioivas.add(this.subgrupoparametroformularioiva);
			}
			
			this.saveSubGrupoParametroFormularioIvas();
			
			this.connexion.commit();
			
			subgrupoparametroformularioivaReturnGeneral.setConRetornoEstaProcesado(true);
			subgrupoparametroformularioivaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return subgrupoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSubGrupoParametroFormularioIvasEliminados() throws Exception {				
		
		List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivasAux= new ArrayList<SubGrupoParametroFormularioIva>();
		
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva:subgrupoparametroformularioivas) {
			if(!subgrupoparametroformularioiva.getIsDeleted()) {
				subgrupoparametroformularioivasAux.add(subgrupoparametroformularioiva);
			}
		}
		
		subgrupoparametroformularioivas=subgrupoparametroformularioivasAux;
	}
	
	public void quitarSubGrupoParametroFormularioIvasNulos() throws Exception {				
		
		List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivasAux= new ArrayList<SubGrupoParametroFormularioIva>();
		
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva : this.subgrupoparametroformularioivas) {
			if(subgrupoparametroformularioiva==null) {
				subgrupoparametroformularioivasAux.add(subgrupoparametroformularioiva);
			}
		}
		
		//this.subgrupoparametroformularioivas=subgrupoparametroformularioivasAux;
		
		this.subgrupoparametroformularioivas.removeAll(subgrupoparametroformularioivasAux);
	}
	
	public void getSetVersionRowSubGrupoParametroFormularioIvaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(subgrupoparametroformularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((subgrupoparametroformularioiva.getIsDeleted() || (subgrupoparametroformularioiva.getIsChanged()&&!subgrupoparametroformularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=subgrupoparametroformularioivaDataAccess.getSetVersionRowSubGrupoParametroFormularioIva(connexion,subgrupoparametroformularioiva.getId());
				
				if(!subgrupoparametroformularioiva.getVersionRow().equals(timestamp)) {	
					subgrupoparametroformularioiva.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				subgrupoparametroformularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSubGrupoParametroFormularioIva()throws Exception {	
		
		if(subgrupoparametroformularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((subgrupoparametroformularioiva.getIsDeleted() || (subgrupoparametroformularioiva.getIsChanged()&&!subgrupoparametroformularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=subgrupoparametroformularioivaDataAccess.getSetVersionRowSubGrupoParametroFormularioIva(connexion,subgrupoparametroformularioiva.getId());
			
			try {							
				if(!subgrupoparametroformularioiva.getVersionRow().equals(timestamp)) {	
					subgrupoparametroformularioiva.setVersionRow(timestamp);
				}
				
				subgrupoparametroformularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSubGrupoParametroFormularioIvasWithConnection()throws Exception {	
		if(subgrupoparametroformularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SubGrupoParametroFormularioIva subgrupoparametroformularioivaAux:subgrupoparametroformularioivas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(subgrupoparametroformularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(subgrupoparametroformularioivaAux.getIsDeleted() || (subgrupoparametroformularioivaAux.getIsChanged()&&!subgrupoparametroformularioivaAux.getIsNew())) {
						
						timestamp=subgrupoparametroformularioivaDataAccess.getSetVersionRowSubGrupoParametroFormularioIva(connexion,subgrupoparametroformularioivaAux.getId());
						
						if(!subgrupoparametroformularioiva.getVersionRow().equals(timestamp)) {	
							subgrupoparametroformularioivaAux.setVersionRow(timestamp);
						}
								
						subgrupoparametroformularioivaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSubGrupoParametroFormularioIvas()throws Exception {	
		if(subgrupoparametroformularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SubGrupoParametroFormularioIva subgrupoparametroformularioivaAux:subgrupoparametroformularioivas) {
					if(subgrupoparametroformularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(subgrupoparametroformularioivaAux.getIsDeleted() || (subgrupoparametroformularioivaAux.getIsChanged()&&!subgrupoparametroformularioivaAux.getIsNew())) {
						
						timestamp=subgrupoparametroformularioivaDataAccess.getSetVersionRowSubGrupoParametroFormularioIva(connexion,subgrupoparametroformularioivaAux.getId());
						
						if(!subgrupoparametroformularioivaAux.getVersionRow().equals(timestamp)) {	
							subgrupoparametroformularioivaAux.setVersionRow(timestamp);
						}
						
													
						subgrupoparametroformularioivaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SubGrupoParametroFormularioIvaParameterReturnGeneral cargarCombosLoteForeignKeySubGrupoParametroFormularioIvaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		SubGrupoParametroFormularioIvaParameterReturnGeneral  subgrupoparametroformularioivaReturnGeneral =new SubGrupoParametroFormularioIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-cargarCombosLoteForeignKeySubGrupoParametroFormularioIvaWithConnection");connexion.begin();
			
			subgrupoparametroformularioivaReturnGeneral =new SubGrupoParametroFormularioIvaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			subgrupoparametroformularioivaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return subgrupoparametroformularioivaReturnGeneral;
	}
	
	public SubGrupoParametroFormularioIvaParameterReturnGeneral cargarCombosLoteForeignKeySubGrupoParametroFormularioIva(String finalQueryGlobalEmpresa) throws Exception {
		SubGrupoParametroFormularioIvaParameterReturnGeneral  subgrupoparametroformularioivaReturnGeneral =new SubGrupoParametroFormularioIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			subgrupoparametroformularioivaReturnGeneral =new SubGrupoParametroFormularioIvaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			subgrupoparametroformularioivaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return subgrupoparametroformularioivaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeySubGrupoParametroFormularioIvaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ParametroFormularioIvaLogic parametroformularioivaLogic=new ParametroFormularioIvaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-cargarRelacionesLoteForeignKeySubGrupoParametroFormularioIvaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ParametroFormularioIva.class));
											
			

			parametroformularioivaLogic.setConnexion(this.getConnexion());
			parametroformularioivaLogic.setDatosCliente(this.datosCliente);
			parametroformularioivaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva:this.subgrupoparametroformularioivas) {
				

				classes=new ArrayList<Classe>();
				classes=ParametroFormularioIvaConstantesFunciones.getClassesForeignKeysOfParametroFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroformularioivaLogic.setParametroFormularioIvas(subgrupoparametroformularioiva.parametroformularioivas);
				parametroformularioivaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(SubGrupoParametroFormularioIva subgrupoparametroformularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//SubGrupoParametroFormularioIvaLogicAdditional.updateSubGrupoParametroFormularioIvaToGet(subgrupoparametroformularioiva,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		subgrupoparametroformularioiva.setEmpresa(subgrupoparametroformularioivaDataAccess.getEmpresa(connexion,subgrupoparametroformularioiva));
		subgrupoparametroformularioiva.setParametroFormularioIvas(subgrupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,subgrupoparametroformularioiva));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				subgrupoparametroformularioiva.setEmpresa(subgrupoparametroformularioivaDataAccess.getEmpresa(connexion,subgrupoparametroformularioiva));
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subgrupoparametroformularioiva.setParametroFormularioIvas(subgrupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,subgrupoparametroformularioiva));

				if(this.isConDeep) {
					ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(this.connexion);
					parametroformularioivaLogic.setParametroFormularioIvas(subgrupoparametroformularioiva.getParametroFormularioIvas());
					ArrayList<Classe> classesLocal=ParametroFormularioIvaConstantesFunciones.getClassesForeignKeysOfParametroFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroformularioivaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(parametroformularioivaLogic.getParametroFormularioIvas());
					subgrupoparametroformularioiva.setParametroFormularioIvas(parametroformularioivaLogic.getParametroFormularioIvas());
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
			subgrupoparametroformularioiva.setEmpresa(subgrupoparametroformularioivaDataAccess.getEmpresa(connexion,subgrupoparametroformularioiva));
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
			subgrupoparametroformularioiva.setParametroFormularioIvas(subgrupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,subgrupoparametroformularioiva));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		subgrupoparametroformularioiva.setEmpresa(subgrupoparametroformularioivaDataAccess.getEmpresa(connexion,subgrupoparametroformularioiva));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(subgrupoparametroformularioiva.getEmpresa(),isDeep,deepLoadType,clases);
				

		subgrupoparametroformularioiva.setParametroFormularioIvas(subgrupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,subgrupoparametroformularioiva));

		for(ParametroFormularioIva parametroformularioiva:subgrupoparametroformularioiva.getParametroFormularioIvas()) {
			ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
			parametroformularioivaLogic.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				subgrupoparametroformularioiva.setEmpresa(subgrupoparametroformularioivaDataAccess.getEmpresa(connexion,subgrupoparametroformularioiva));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(subgrupoparametroformularioiva.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subgrupoparametroformularioiva.setParametroFormularioIvas(subgrupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,subgrupoparametroformularioiva));

				for(ParametroFormularioIva parametroformularioiva:subgrupoparametroformularioiva.getParametroFormularioIvas()) {
					ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
					parametroformularioivaLogic.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);
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
			subgrupoparametroformularioiva.setEmpresa(subgrupoparametroformularioivaDataAccess.getEmpresa(connexion,subgrupoparametroformularioiva));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(subgrupoparametroformularioiva.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			subgrupoparametroformularioiva.setParametroFormularioIvas(subgrupoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,subgrupoparametroformularioiva));

			for(ParametroFormularioIva parametroformularioiva:subgrupoparametroformularioiva.getParametroFormularioIvas()) {
				ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
				parametroformularioivaLogic.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SubGrupoParametroFormularioIva subgrupoparametroformularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SubGrupoParametroFormularioIva.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(subgrupoparametroformularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(subgrupoparametroformularioiva);
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
			this.deepLoad(this.subgrupoparametroformularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SubGrupoParametroFormularioIva.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(subgrupoparametroformularioivas!=null) {
				for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva:subgrupoparametroformularioivas) {
					this.deepLoad(subgrupoparametroformularioiva,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(subgrupoparametroformularioivas);
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
			if(subgrupoparametroformularioivas!=null) {
				for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva:subgrupoparametroformularioivas) {
					this.deepLoad(subgrupoparametroformularioiva,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(subgrupoparametroformularioivas);
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
	
	
	public void getSubGrupoParametroFormularioIvasBusquedaPorIdWithConnection(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,SubGrupoParametroFormularioIvaConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubGrupoParametroFormularioIvasBusquedaPorId(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,SubGrupoParametroFormularioIvaConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubGrupoParametroFormularioIvasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubGrupoParametroFormularioIvasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubGrupoParametroFormularioIvasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubGrupoParametroFormularioIvasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SubGrupoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subgrupoparametroformularioivas=subgrupoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubGrupoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(this.subgrupoparametroformularioivas);
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
			if(SubGrupoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SubGrupoParametroFormularioIvaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SubGrupoParametroFormularioIva subgrupoparametroformularioiva,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SubGrupoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				if(subgrupoparametroformularioiva.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubGrupoParametroFormularioIvaDataAccess.TABLENAME, subgrupoparametroformularioiva.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SubGrupoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SubGrupoParametroFormularioIvaLogic.registrarAuditoriaDetallesSubGrupoParametroFormularioIva(connexion,subgrupoparametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(subgrupoparametroformularioiva.getIsDeleted()) {
					/*if(!subgrupoparametroformularioiva.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SubGrupoParametroFormularioIvaDataAccess.TABLENAME, subgrupoparametroformularioiva.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SubGrupoParametroFormularioIvaLogic.registrarAuditoriaDetallesSubGrupoParametroFormularioIva(connexion,subgrupoparametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubGrupoParametroFormularioIvaDataAccess.TABLENAME, subgrupoparametroformularioiva.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(subgrupoparametroformularioiva.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubGrupoParametroFormularioIvaDataAccess.TABLENAME, subgrupoparametroformularioiva.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SubGrupoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SubGrupoParametroFormularioIvaLogic.registrarAuditoriaDetallesSubGrupoParametroFormularioIva(connexion,subgrupoparametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSubGrupoParametroFormularioIva(Connexion connexion,SubGrupoParametroFormularioIva subgrupoparametroformularioiva)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(subgrupoparametroformularioiva.getIsNew()||!subgrupoparametroformularioiva.getid_empresa().equals(subgrupoparametroformularioiva.getSubGrupoParametroFormularioIvaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subgrupoparametroformularioiva.getSubGrupoParametroFormularioIvaOriginal().getid_empresa()!=null)
				{
					strValorActual=subgrupoparametroformularioiva.getSubGrupoParametroFormularioIvaOriginal().getid_empresa().toString();
				}
				if(subgrupoparametroformularioiva.getid_empresa()!=null)
				{
					strValorNuevo=subgrupoparametroformularioiva.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(subgrupoparametroformularioiva.getIsNew()||!subgrupoparametroformularioiva.getnombre().equals(subgrupoparametroformularioiva.getSubGrupoParametroFormularioIvaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subgrupoparametroformularioiva.getSubGrupoParametroFormularioIvaOriginal().getnombre()!=null)
				{
					strValorActual=subgrupoparametroformularioiva.getSubGrupoParametroFormularioIvaOriginal().getnombre();
				}
				if(subgrupoparametroformularioiva.getnombre()!=null)
				{
					strValorNuevo=subgrupoparametroformularioiva.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSubGrupoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SubGrupoParametroFormularioIvaConstantesFunciones.getClassesForeignKeysOfSubGrupoParametroFormularioIva(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubGrupoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SubGrupoParametroFormularioIvaConstantesFunciones.getClassesRelationshipsOfSubGrupoParametroFormularioIva(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
