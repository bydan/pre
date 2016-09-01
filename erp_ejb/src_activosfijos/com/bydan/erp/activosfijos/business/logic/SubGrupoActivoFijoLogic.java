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
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.util.SubGrupoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.SubGrupoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.SubGrupoActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.SubGrupoActivoFijo;
import com.bydan.erp.activosfijos.business.logic.SubGrupoActivoFijoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class SubGrupoActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SubGrupoActivoFijoLogic.class);
	
	protected SubGrupoActivoFijoDataAccess subgrupoactivofijoDataAccess; 	
	protected SubGrupoActivoFijo subgrupoactivofijo;
	protected List<SubGrupoActivoFijo> subgrupoactivofijos;
	protected Object subgrupoactivofijoObject;	
	protected List<Object> subgrupoactivofijosObject;
	
	public static ClassValidator<SubGrupoActivoFijo> subgrupoactivofijoValidator = new ClassValidator<SubGrupoActivoFijo>(SubGrupoActivoFijo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SubGrupoActivoFijoLogicAdditional subgrupoactivofijoLogicAdditional=null;
	
	public SubGrupoActivoFijoLogicAdditional getSubGrupoActivoFijoLogicAdditional() {
		return this.subgrupoactivofijoLogicAdditional;
	}
	
	public void setSubGrupoActivoFijoLogicAdditional(SubGrupoActivoFijoLogicAdditional subgrupoactivofijoLogicAdditional) {
		try {
			this.subgrupoactivofijoLogicAdditional=subgrupoactivofijoLogicAdditional;
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
	
	
	
	
	public  SubGrupoActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.subgrupoactivofijoDataAccess = new SubGrupoActivoFijoDataAccess();
			
			this.subgrupoactivofijos= new ArrayList<SubGrupoActivoFijo>();
			this.subgrupoactivofijo= new SubGrupoActivoFijo();
			
			this.subgrupoactivofijoObject=new Object();
			this.subgrupoactivofijosObject=new ArrayList<Object>();
				
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
			
			this.subgrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.subgrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SubGrupoActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.subgrupoactivofijoDataAccess = new SubGrupoActivoFijoDataAccess();
			this.subgrupoactivofijos= new ArrayList<SubGrupoActivoFijo>();
			this.subgrupoactivofijo= new SubGrupoActivoFijo();
			this.subgrupoactivofijoObject=new Object();
			this.subgrupoactivofijosObject=new ArrayList<Object>();
			
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
			
			this.subgrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.subgrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SubGrupoActivoFijo getSubGrupoActivoFijo() throws Exception {	
		SubGrupoActivoFijoLogicAdditional.checkSubGrupoActivoFijoToGet(subgrupoactivofijo,this.datosCliente,this.arrDatoGeneral);
		SubGrupoActivoFijoLogicAdditional.updateSubGrupoActivoFijoToGet(subgrupoactivofijo,this.arrDatoGeneral);
		
		return subgrupoactivofijo;
	}
		
	public void setSubGrupoActivoFijo(SubGrupoActivoFijo newSubGrupoActivoFijo) {
		this.subgrupoactivofijo = newSubGrupoActivoFijo;
	}
	
	public SubGrupoActivoFijoDataAccess getSubGrupoActivoFijoDataAccess() {
		return subgrupoactivofijoDataAccess;
	}
	
	public void setSubGrupoActivoFijoDataAccess(SubGrupoActivoFijoDataAccess newsubgrupoactivofijoDataAccess) {
		this.subgrupoactivofijoDataAccess = newsubgrupoactivofijoDataAccess;
	}
	
	public List<SubGrupoActivoFijo> getSubGrupoActivoFijos() throws Exception {		
		this.quitarSubGrupoActivoFijosNulos();
		
		SubGrupoActivoFijoLogicAdditional.checkSubGrupoActivoFijoToGets(subgrupoactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (SubGrupoActivoFijo subgrupoactivofijoLocal: subgrupoactivofijos ) {
			SubGrupoActivoFijoLogicAdditional.updateSubGrupoActivoFijoToGet(subgrupoactivofijoLocal,this.arrDatoGeneral);
		}
		
		return subgrupoactivofijos;
	}
	
	public void setSubGrupoActivoFijos(List<SubGrupoActivoFijo> newSubGrupoActivoFijos) {
		this.subgrupoactivofijos = newSubGrupoActivoFijos;
	}
	
	public Object getSubGrupoActivoFijoObject() {	
		this.subgrupoactivofijoObject=this.subgrupoactivofijoDataAccess.getEntityObject();
		return this.subgrupoactivofijoObject;
	}
		
	public void setSubGrupoActivoFijoObject(Object newSubGrupoActivoFijoObject) {
		this.subgrupoactivofijoObject = newSubGrupoActivoFijoObject;
	}
	
	public List<Object> getSubGrupoActivoFijosObject() {		
		this.subgrupoactivofijosObject=this.subgrupoactivofijoDataAccess.getEntitiesObject();
		return this.subgrupoactivofijosObject;
	}
		
	public void setSubGrupoActivoFijosObject(List<Object> newSubGrupoActivoFijosObject) {
		this.subgrupoactivofijosObject = newSubGrupoActivoFijosObject;
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
		
		if(this.subgrupoactivofijoDataAccess!=null) {
			this.subgrupoactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			subgrupoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			subgrupoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			subgrupoactivofijo=subgrupoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subgrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijo);
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
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		  		  
        try {
			
			subgrupoactivofijo=subgrupoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subgrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			subgrupoactivofijo=subgrupoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subgrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijo);
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
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		  		  
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
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		  		  
        try {
			
			subgrupoactivofijo=subgrupoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subgrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		  		  
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
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =subgrupoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=subgrupoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =subgrupoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=subgrupoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =subgrupoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=subgrupoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
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
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		  		  
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
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		  		  
        try {			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		  		  
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
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
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
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		  		  
        try {
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
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
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
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
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijo=subgrupoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijo);
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
		subgrupoactivofijo = new  SubGrupoActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijo=subgrupoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
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
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		  		  
        try {
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSubGrupoActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getTodosSubGrupoActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
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
	
	public  void  getTodosSubGrupoActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		subgrupoactivofijos = new  ArrayList<SubGrupoActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSubGrupoActivoFijo(subgrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSubGrupoActivoFijo(SubGrupoActivoFijo subgrupoactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(subgrupoactivofijo.getIsNew() || subgrupoactivofijo.getIsChanged()) { 
			this.invalidValues = subgrupoactivofijoValidator.getInvalidValues(subgrupoactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(subgrupoactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSubGrupoActivoFijo(List<SubGrupoActivoFijo> SubGrupoActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SubGrupoActivoFijo subgrupoactivofijoLocal:subgrupoactivofijos) {				
			estaValidadoObjeto=this.validarGuardarSubGrupoActivoFijo(subgrupoactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSubGrupoActivoFijo(List<SubGrupoActivoFijo> SubGrupoActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSubGrupoActivoFijo(subgrupoactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSubGrupoActivoFijo(SubGrupoActivoFijo SubGrupoActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSubGrupoActivoFijo(subgrupoactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SubGrupoActivoFijo subgrupoactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+subgrupoactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SubGrupoActivoFijoConstantesFunciones.getSubGrupoActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"subgrupoactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SubGrupoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SubGrupoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSubGrupoActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-saveSubGrupoActivoFijoWithConnection");connexion.begin();			
			
			SubGrupoActivoFijoLogicAdditional.checkSubGrupoActivoFijoToSave(this.subgrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SubGrupoActivoFijoLogicAdditional.updateSubGrupoActivoFijoToSave(this.subgrupoactivofijo,this.arrDatoGeneral);
			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.subgrupoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSubGrupoActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSubGrupoActivoFijo(this.subgrupoactivofijo)) {
				SubGrupoActivoFijoDataAccess.save(this.subgrupoactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.subgrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SubGrupoActivoFijoLogicAdditional.checkSubGrupoActivoFijoToSaveAfter(this.subgrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSubGrupoActivoFijo();
			
			connexion.commit();			
			
			if(this.subgrupoactivofijo.getIsDeleted()) {
				this.subgrupoactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSubGrupoActivoFijo()throws Exception {	
		try {	
			
			SubGrupoActivoFijoLogicAdditional.checkSubGrupoActivoFijoToSave(this.subgrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SubGrupoActivoFijoLogicAdditional.updateSubGrupoActivoFijoToSave(this.subgrupoactivofijo,this.arrDatoGeneral);
			
			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.subgrupoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSubGrupoActivoFijo(this.subgrupoactivofijo)) {			
				SubGrupoActivoFijoDataAccess.save(this.subgrupoactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.subgrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SubGrupoActivoFijoLogicAdditional.checkSubGrupoActivoFijoToSaveAfter(this.subgrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.subgrupoactivofijo.getIsDeleted()) {
				this.subgrupoactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSubGrupoActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-saveSubGrupoActivoFijosWithConnection");connexion.begin();			
			
			SubGrupoActivoFijoLogicAdditional.checkSubGrupoActivoFijoToSaves(subgrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSubGrupoActivoFijos();
			
			Boolean validadoTodosSubGrupoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SubGrupoActivoFijo subgrupoactivofijoLocal:subgrupoactivofijos) {		
				if(subgrupoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SubGrupoActivoFijoLogicAdditional.updateSubGrupoActivoFijoToSave(subgrupoactivofijoLocal,this.arrDatoGeneral);
	        	
				SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),subgrupoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSubGrupoActivoFijo(subgrupoactivofijoLocal)) {
					SubGrupoActivoFijoDataAccess.save(subgrupoactivofijoLocal, connexion);				
				} else {
					validadoTodosSubGrupoActivoFijo=false;
				}
			}
			
			if(!validadoTodosSubGrupoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SubGrupoActivoFijoLogicAdditional.checkSubGrupoActivoFijoToSavesAfter(subgrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSubGrupoActivoFijos();
			
			connexion.commit();		
			
			this.quitarSubGrupoActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSubGrupoActivoFijos()throws Exception {				
		 try {	
			SubGrupoActivoFijoLogicAdditional.checkSubGrupoActivoFijoToSaves(subgrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSubGrupoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SubGrupoActivoFijo subgrupoactivofijoLocal:subgrupoactivofijos) {				
				if(subgrupoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SubGrupoActivoFijoLogicAdditional.updateSubGrupoActivoFijoToSave(subgrupoactivofijoLocal,this.arrDatoGeneral);
	        	
				SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),subgrupoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSubGrupoActivoFijo(subgrupoactivofijoLocal)) {				
					SubGrupoActivoFijoDataAccess.save(subgrupoactivofijoLocal, connexion);				
				} else {
					validadoTodosSubGrupoActivoFijo=false;
				}
			}
			
			if(!validadoTodosSubGrupoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SubGrupoActivoFijoLogicAdditional.checkSubGrupoActivoFijoToSavesAfter(subgrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSubGrupoActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SubGrupoActivoFijoParameterReturnGeneral procesarAccionSubGrupoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SubGrupoActivoFijo> subgrupoactivofijos,SubGrupoActivoFijoParameterReturnGeneral subgrupoactivofijoParameterGeneral)throws Exception {
		 try {	
			SubGrupoActivoFijoParameterReturnGeneral subgrupoactivofijoReturnGeneral=new SubGrupoActivoFijoParameterReturnGeneral();
	
			SubGrupoActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,subgrupoactivofijos,subgrupoactivofijoParameterGeneral,subgrupoactivofijoReturnGeneral);
			
			return subgrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SubGrupoActivoFijoParameterReturnGeneral procesarAccionSubGrupoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SubGrupoActivoFijo> subgrupoactivofijos,SubGrupoActivoFijoParameterReturnGeneral subgrupoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-procesarAccionSubGrupoActivoFijosWithConnection");connexion.begin();			
			
			SubGrupoActivoFijoParameterReturnGeneral subgrupoactivofijoReturnGeneral=new SubGrupoActivoFijoParameterReturnGeneral();
	
			SubGrupoActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,subgrupoactivofijos,subgrupoactivofijoParameterGeneral,subgrupoactivofijoReturnGeneral);
			
			this.connexion.commit();
			
			return subgrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SubGrupoActivoFijoParameterReturnGeneral procesarEventosSubGrupoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SubGrupoActivoFijo> subgrupoactivofijos,SubGrupoActivoFijo subgrupoactivofijo,SubGrupoActivoFijoParameterReturnGeneral subgrupoactivofijoParameterGeneral,Boolean isEsNuevoSubGrupoActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			SubGrupoActivoFijoParameterReturnGeneral subgrupoactivofijoReturnGeneral=new SubGrupoActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				subgrupoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SubGrupoActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,subgrupoactivofijos,subgrupoactivofijo,subgrupoactivofijoParameterGeneral,subgrupoactivofijoReturnGeneral,isEsNuevoSubGrupoActivoFijo,clases);
			
			return subgrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SubGrupoActivoFijoParameterReturnGeneral procesarEventosSubGrupoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SubGrupoActivoFijo> subgrupoactivofijos,SubGrupoActivoFijo subgrupoactivofijo,SubGrupoActivoFijoParameterReturnGeneral subgrupoactivofijoParameterGeneral,Boolean isEsNuevoSubGrupoActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-procesarEventosSubGrupoActivoFijosWithConnection");connexion.begin();			
			
			SubGrupoActivoFijoParameterReturnGeneral subgrupoactivofijoReturnGeneral=new SubGrupoActivoFijoParameterReturnGeneral();
	
			subgrupoactivofijoReturnGeneral.setSubGrupoActivoFijo(subgrupoactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				subgrupoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SubGrupoActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,subgrupoactivofijos,subgrupoactivofijo,subgrupoactivofijoParameterGeneral,subgrupoactivofijoReturnGeneral,isEsNuevoSubGrupoActivoFijo,clases);
			
			this.connexion.commit();
			
			return subgrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SubGrupoActivoFijoParameterReturnGeneral procesarImportacionSubGrupoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SubGrupoActivoFijoParameterReturnGeneral subgrupoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-procesarImportacionSubGrupoActivoFijosWithConnection");connexion.begin();			
			
			SubGrupoActivoFijoParameterReturnGeneral subgrupoactivofijoReturnGeneral=new SubGrupoActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.subgrupoactivofijos=new ArrayList<SubGrupoActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.subgrupoactivofijo=new SubGrupoActivoFijo();
				
				
				if(conColumnasBase) {this.subgrupoactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.subgrupoactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.subgrupoactivofijo.setcodigo(arrColumnas[iColumn++]);
				this.subgrupoactivofijo.setnombre(arrColumnas[iColumn++]);
				this.subgrupoactivofijo.setsiglas(arrColumnas[iColumn++]);
				this.subgrupoactivofijo.setes_vehiculo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.subgrupoactivofijos.add(this.subgrupoactivofijo);
			}
			
			this.saveSubGrupoActivoFijos();
			
			this.connexion.commit();
			
			subgrupoactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			subgrupoactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return subgrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSubGrupoActivoFijosEliminados() throws Exception {				
		
		List<SubGrupoActivoFijo> subgrupoactivofijosAux= new ArrayList<SubGrupoActivoFijo>();
		
		for(SubGrupoActivoFijo subgrupoactivofijo:subgrupoactivofijos) {
			if(!subgrupoactivofijo.getIsDeleted()) {
				subgrupoactivofijosAux.add(subgrupoactivofijo);
			}
		}
		
		subgrupoactivofijos=subgrupoactivofijosAux;
	}
	
	public void quitarSubGrupoActivoFijosNulos() throws Exception {				
		
		List<SubGrupoActivoFijo> subgrupoactivofijosAux= new ArrayList<SubGrupoActivoFijo>();
		
		for(SubGrupoActivoFijo subgrupoactivofijo : this.subgrupoactivofijos) {
			if(subgrupoactivofijo==null) {
				subgrupoactivofijosAux.add(subgrupoactivofijo);
			}
		}
		
		//this.subgrupoactivofijos=subgrupoactivofijosAux;
		
		this.subgrupoactivofijos.removeAll(subgrupoactivofijosAux);
	}
	
	public void getSetVersionRowSubGrupoActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(subgrupoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((subgrupoactivofijo.getIsDeleted() || (subgrupoactivofijo.getIsChanged()&&!subgrupoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=subgrupoactivofijoDataAccess.getSetVersionRowSubGrupoActivoFijo(connexion,subgrupoactivofijo.getId());
				
				if(!subgrupoactivofijo.getVersionRow().equals(timestamp)) {	
					subgrupoactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				subgrupoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSubGrupoActivoFijo()throws Exception {	
		
		if(subgrupoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((subgrupoactivofijo.getIsDeleted() || (subgrupoactivofijo.getIsChanged()&&!subgrupoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=subgrupoactivofijoDataAccess.getSetVersionRowSubGrupoActivoFijo(connexion,subgrupoactivofijo.getId());
			
			try {							
				if(!subgrupoactivofijo.getVersionRow().equals(timestamp)) {	
					subgrupoactivofijo.setVersionRow(timestamp);
				}
				
				subgrupoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSubGrupoActivoFijosWithConnection()throws Exception {	
		if(subgrupoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SubGrupoActivoFijo subgrupoactivofijoAux:subgrupoactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(subgrupoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(subgrupoactivofijoAux.getIsDeleted() || (subgrupoactivofijoAux.getIsChanged()&&!subgrupoactivofijoAux.getIsNew())) {
						
						timestamp=subgrupoactivofijoDataAccess.getSetVersionRowSubGrupoActivoFijo(connexion,subgrupoactivofijoAux.getId());
						
						if(!subgrupoactivofijo.getVersionRow().equals(timestamp)) {	
							subgrupoactivofijoAux.setVersionRow(timestamp);
						}
								
						subgrupoactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSubGrupoActivoFijos()throws Exception {	
		if(subgrupoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SubGrupoActivoFijo subgrupoactivofijoAux:subgrupoactivofijos) {
					if(subgrupoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(subgrupoactivofijoAux.getIsDeleted() || (subgrupoactivofijoAux.getIsChanged()&&!subgrupoactivofijoAux.getIsNew())) {
						
						timestamp=subgrupoactivofijoDataAccess.getSetVersionRowSubGrupoActivoFijo(connexion,subgrupoactivofijoAux.getId());
						
						if(!subgrupoactivofijoAux.getVersionRow().equals(timestamp)) {	
							subgrupoactivofijoAux.setVersionRow(timestamp);
						}
						
													
						subgrupoactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SubGrupoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeySubGrupoActivoFijoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalDetalleGrupoActivoFijo) throws Exception {
		SubGrupoActivoFijoParameterReturnGeneral  subgrupoactivofijoReturnGeneral =new SubGrupoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeySubGrupoActivoFijoWithConnection");connexion.begin();
			
			subgrupoactivofijoReturnGeneral =new SubGrupoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			subgrupoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic=new DetalleGrupoActivoFijoLogic();
			detallegrupoactivofijoLogic.setConnexion(this.connexion);
			detallegrupoactivofijoLogic.getDetalleGrupoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleGrupoActivoFijo.equals("NONE")) {
				detallegrupoactivofijoLogic.getTodosDetalleGrupoActivoFijos(finalQueryGlobalDetalleGrupoActivoFijo,new Pagination());
				detallegrupoactivofijosForeignKey=detallegrupoactivofijoLogic.getDetalleGrupoActivoFijos();
			}

			subgrupoactivofijoReturnGeneral.setdetallegrupoactivofijosForeignKey(detallegrupoactivofijosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return subgrupoactivofijoReturnGeneral;
	}
	
	public SubGrupoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeySubGrupoActivoFijo(String finalQueryGlobalEmpresa,String finalQueryGlobalDetalleGrupoActivoFijo) throws Exception {
		SubGrupoActivoFijoParameterReturnGeneral  subgrupoactivofijoReturnGeneral =new SubGrupoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			subgrupoactivofijoReturnGeneral =new SubGrupoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			subgrupoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic=new DetalleGrupoActivoFijoLogic();
			detallegrupoactivofijoLogic.setConnexion(this.connexion);
			detallegrupoactivofijoLogic.getDetalleGrupoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleGrupoActivoFijo.equals("NONE")) {
				detallegrupoactivofijoLogic.getTodosDetalleGrupoActivoFijos(finalQueryGlobalDetalleGrupoActivoFijo,new Pagination());
				detallegrupoactivofijosForeignKey=detallegrupoactivofijoLogic.getDetalleGrupoActivoFijos();
			}

			subgrupoactivofijoReturnGeneral.setdetallegrupoactivofijosForeignKey(detallegrupoactivofijosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return subgrupoactivofijoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeySubGrupoActivoFijoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeySubGrupoActivoFijoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleActivoFijo.class));
											
			

			detalleactivofijoLogic.setConnexion(this.getConnexion());
			detalleactivofijoLogic.setDatosCliente(this.datosCliente);
			detalleactivofijoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(SubGrupoActivoFijo subgrupoactivofijo:this.subgrupoactivofijos) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleactivofijoLogic.setDetalleActivoFijos(subgrupoactivofijo.detalleactivofijos);
				detalleactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(SubGrupoActivoFijo subgrupoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SubGrupoActivoFijoLogicAdditional.updateSubGrupoActivoFijoToGet(subgrupoactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		subgrupoactivofijo.setEmpresa(subgrupoactivofijoDataAccess.getEmpresa(connexion,subgrupoactivofijo));
		subgrupoactivofijo.setDetalleGrupoActivoFijo(subgrupoactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,subgrupoactivofijo));
		subgrupoactivofijo.setDetalleActivoFijos(subgrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,subgrupoactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				subgrupoactivofijo.setEmpresa(subgrupoactivofijoDataAccess.getEmpresa(connexion,subgrupoactivofijo));
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				subgrupoactivofijo.setDetalleGrupoActivoFijo(subgrupoactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,subgrupoactivofijo));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subgrupoactivofijo.setDetalleActivoFijos(subgrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,subgrupoactivofijo));

				if(this.isConDeep) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(this.connexion);
					detalleactivofijoLogic.setDetalleActivoFijos(subgrupoactivofijo.getDetalleActivoFijos());
					ArrayList<Classe> classesLocal=DetalleActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(detalleactivofijoLogic.getDetalleActivoFijos());
					subgrupoactivofijo.setDetalleActivoFijos(detalleactivofijoLogic.getDetalleActivoFijos());
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
			subgrupoactivofijo.setEmpresa(subgrupoactivofijoDataAccess.getEmpresa(connexion,subgrupoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subgrupoactivofijo.setDetalleGrupoActivoFijo(subgrupoactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,subgrupoactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleActivoFijo.class));
			subgrupoactivofijo.setDetalleActivoFijos(subgrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,subgrupoactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		subgrupoactivofijo.setEmpresa(subgrupoactivofijoDataAccess.getEmpresa(connexion,subgrupoactivofijo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(subgrupoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		subgrupoactivofijo.setDetalleGrupoActivoFijo(subgrupoactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,subgrupoactivofijo));
		DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
		detallegrupoactivofijoLogic.deepLoad(subgrupoactivofijo.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				

		subgrupoactivofijo.setDetalleActivoFijos(subgrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,subgrupoactivofijo));

		for(DetalleActivoFijo detalleactivofijo:subgrupoactivofijo.getDetalleActivoFijos()) {
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				subgrupoactivofijo.setEmpresa(subgrupoactivofijoDataAccess.getEmpresa(connexion,subgrupoactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(subgrupoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				subgrupoactivofijo.setDetalleGrupoActivoFijo(subgrupoactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,subgrupoactivofijo));
				DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
				detallegrupoactivofijoLogic.deepLoad(subgrupoactivofijo.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subgrupoactivofijo.setDetalleActivoFijos(subgrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,subgrupoactivofijo));

				for(DetalleActivoFijo detalleactivofijo:subgrupoactivofijo.getDetalleActivoFijos()) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
					detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
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
			subgrupoactivofijo.setEmpresa(subgrupoactivofijoDataAccess.getEmpresa(connexion,subgrupoactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(subgrupoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subgrupoactivofijo.setDetalleGrupoActivoFijo(subgrupoactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,subgrupoactivofijo));
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
			detallegrupoactivofijoLogic.deepLoad(subgrupoactivofijo.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleActivoFijo.class));
			subgrupoactivofijo.setDetalleActivoFijos(subgrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,subgrupoactivofijo));

			for(DetalleActivoFijo detalleactivofijo:subgrupoactivofijo.getDetalleActivoFijos()) {
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SubGrupoActivoFijo subgrupoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SubGrupoActivoFijoLogicAdditional.updateSubGrupoActivoFijoToSave(subgrupoactivofijo,this.arrDatoGeneral);
			
SubGrupoActivoFijoDataAccess.save(subgrupoactivofijo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(subgrupoactivofijo.getEmpresa(),connexion);

		DetalleGrupoActivoFijoDataAccess.save(subgrupoactivofijo.getDetalleGrupoActivoFijo(),connexion);

		for(DetalleActivoFijo detalleactivofijo:subgrupoactivofijo.getDetalleActivoFijos()) {
			detalleactivofijo.setid_sub_grupo_activo_fijo(subgrupoactivofijo.getId());
			DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(subgrupoactivofijo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				DetalleGrupoActivoFijoDataAccess.save(subgrupoactivofijo.getDetalleGrupoActivoFijo(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleActivoFijo detalleactivofijo:subgrupoactivofijo.getDetalleActivoFijos()) {
					detalleactivofijo.setid_sub_grupo_activo_fijo(subgrupoactivofijo.getId());
					DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(subgrupoactivofijo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(subgrupoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				

		DetalleGrupoActivoFijoDataAccess.save(subgrupoactivofijo.getDetalleGrupoActivoFijo(),connexion);
		DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
		detallegrupoactivofijoLogic.deepLoad(subgrupoactivofijo.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				

		for(DetalleActivoFijo detalleactivofijo:subgrupoactivofijo.getDetalleActivoFijos()) {
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijo.setid_sub_grupo_activo_fijo(subgrupoactivofijo.getId());
			DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
			detalleactivofijoLogic.deepSave(detalleactivofijo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(subgrupoactivofijo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(subgrupoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				DetalleGrupoActivoFijoDataAccess.save(subgrupoactivofijo.getDetalleGrupoActivoFijo(),connexion);
				DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
				detallegrupoactivofijoLogic.deepSave(subgrupoactivofijo.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleActivoFijo detalleactivofijo:subgrupoactivofijo.getDetalleActivoFijos()) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
					detalleactivofijo.setid_sub_grupo_activo_fijo(subgrupoactivofijo.getId());
					DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
					detalleactivofijoLogic.deepSave(detalleactivofijo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(SubGrupoActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(subgrupoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(subgrupoactivofijo);
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
			this.deepLoad(this.subgrupoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SubGrupoActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(subgrupoactivofijos!=null) {
				for(SubGrupoActivoFijo subgrupoactivofijo:subgrupoactivofijos) {
					this.deepLoad(subgrupoactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(subgrupoactivofijos);
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
			if(subgrupoactivofijos!=null) {
				for(SubGrupoActivoFijo subgrupoactivofijo:subgrupoactivofijos) {
					this.deepLoad(subgrupoactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(subgrupoactivofijos);
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
			this.getNewConnexionToDeep(SubGrupoActivoFijo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(subgrupoactivofijo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SubGrupoActivoFijo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(subgrupoactivofijos!=null) {
				for(SubGrupoActivoFijo subgrupoactivofijo:subgrupoactivofijos) {
					this.deepSave(subgrupoactivofijo,isDeep,deepLoadType,clases);
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
			if(subgrupoactivofijos!=null) {
				for(SubGrupoActivoFijo subgrupoactivofijo:subgrupoactivofijos) {
					this.deepSave(subgrupoactivofijo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSubGrupoActivoFijosFK_IdDetalleGrupoActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_grupo_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleGrupoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleGrupoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_grupo_activo_fijo,SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleGrupoActivoFijo);

			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleGrupoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubGrupoActivoFijosFK_IdDetalleGrupoActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_grupo_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleGrupoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleGrupoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_grupo_activo_fijo,SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleGrupoActivoFijo);

			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleGrupoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubGrupoActivoFijosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubGrupoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SubGrupoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubGrupoActivoFijosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SubGrupoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SubGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(this.subgrupoactivofijos);
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
			if(SubGrupoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SubGrupoActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SubGrupoActivoFijo subgrupoactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SubGrupoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(subgrupoactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubGrupoActivoFijoDataAccess.TABLENAME, subgrupoactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SubGrupoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SubGrupoActivoFijoLogic.registrarAuditoriaDetallesSubGrupoActivoFijo(connexion,subgrupoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(subgrupoactivofijo.getIsDeleted()) {
					/*if(!subgrupoactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SubGrupoActivoFijoDataAccess.TABLENAME, subgrupoactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SubGrupoActivoFijoLogic.registrarAuditoriaDetallesSubGrupoActivoFijo(connexion,subgrupoactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubGrupoActivoFijoDataAccess.TABLENAME, subgrupoactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(subgrupoactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubGrupoActivoFijoDataAccess.TABLENAME, subgrupoactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SubGrupoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SubGrupoActivoFijoLogic.registrarAuditoriaDetallesSubGrupoActivoFijo(connexion,subgrupoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSubGrupoActivoFijo(Connexion connexion,SubGrupoActivoFijo subgrupoactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(subgrupoactivofijo.getIsNew()||!subgrupoactivofijo.getid_empresa().equals(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getid_empresa()!=null)
				{
					strValorActual=subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getid_empresa().toString();
				}
				if(subgrupoactivofijo.getid_empresa()!=null)
				{
					strValorNuevo=subgrupoactivofijo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubGrupoActivoFijoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(subgrupoactivofijo.getIsNew()||!subgrupoactivofijo.getid_detalle_grupo_activo_fijo().equals(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getid_detalle_grupo_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getid_detalle_grupo_activo_fijo()!=null)
				{
					strValorActual=subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getid_detalle_grupo_activo_fijo().toString();
				}
				if(subgrupoactivofijo.getid_detalle_grupo_activo_fijo()!=null)
				{
					strValorNuevo=subgrupoactivofijo.getid_detalle_grupo_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(subgrupoactivofijo.getIsNew()||!subgrupoactivofijo.getcodigo().equals(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getcodigo()!=null)
				{
					strValorActual=subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getcodigo();
				}
				if(subgrupoactivofijo.getcodigo()!=null)
				{
					strValorNuevo=subgrupoactivofijo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubGrupoActivoFijoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(subgrupoactivofijo.getIsNew()||!subgrupoactivofijo.getnombre().equals(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getnombre()!=null)
				{
					strValorActual=subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getnombre();
				}
				if(subgrupoactivofijo.getnombre()!=null)
				{
					strValorNuevo=subgrupoactivofijo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubGrupoActivoFijoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(subgrupoactivofijo.getIsNew()||!subgrupoactivofijo.getsiglas().equals(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getsiglas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getsiglas()!=null)
				{
					strValorActual=subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getsiglas();
				}
				if(subgrupoactivofijo.getsiglas()!=null)
				{
					strValorNuevo=subgrupoactivofijo.getsiglas() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubGrupoActivoFijoConstantesFunciones.SIGLAS,strValorActual,strValorNuevo);
			}	
			
			if(subgrupoactivofijo.getIsNew()||!subgrupoactivofijo.getes_vehiculo().equals(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getes_vehiculo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getes_vehiculo()!=null)
				{
					strValorActual=subgrupoactivofijo.getSubGrupoActivoFijoOriginal().getes_vehiculo().toString();
				}
				if(subgrupoactivofijo.getes_vehiculo()!=null)
				{
					strValorNuevo=subgrupoactivofijo.getes_vehiculo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubGrupoActivoFijoConstantesFunciones.ESVEHICULO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSubGrupoActivoFijoRelacionesWithConnection(SubGrupoActivoFijo subgrupoactivofijo,List<DetalleActivoFijo> detalleactivofijos) throws Exception {

		if(!subgrupoactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSubGrupoActivoFijoRelacionesBase(subgrupoactivofijo,detalleactivofijos,true);
		}
	}

	public void saveSubGrupoActivoFijoRelaciones(SubGrupoActivoFijo subgrupoactivofijo,List<DetalleActivoFijo> detalleactivofijos)throws Exception {

		if(!subgrupoactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSubGrupoActivoFijoRelacionesBase(subgrupoactivofijo,detalleactivofijos,false);
		}
	}

	public void saveSubGrupoActivoFijoRelacionesBase(SubGrupoActivoFijo subgrupoactivofijo,List<DetalleActivoFijo> detalleactivofijos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SubGrupoActivoFijo-saveRelacionesWithConnection");}
	
			subgrupoactivofijo.setDetalleActivoFijos(detalleactivofijos);

			this.setSubGrupoActivoFijo(subgrupoactivofijo);

			if(SubGrupoActivoFijoLogicAdditional.validarSaveRelaciones(subgrupoactivofijo,this)) {

				SubGrupoActivoFijoLogicAdditional.updateRelacionesToSave(subgrupoactivofijo,this);

				if((subgrupoactivofijo.getIsNew()||subgrupoactivofijo.getIsChanged())&&!subgrupoactivofijo.getIsDeleted()) {
					this.saveSubGrupoActivoFijo();
					this.saveSubGrupoActivoFijoRelacionesDetalles(detalleactivofijos);

				} else if(subgrupoactivofijo.getIsDeleted()) {
					this.saveSubGrupoActivoFijoRelacionesDetalles(detalleactivofijos);
					this.saveSubGrupoActivoFijo();
				}

				SubGrupoActivoFijoLogicAdditional.updateRelacionesToSaveAfter(subgrupoactivofijo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleActivoFijos(detalleactivofijos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveSubGrupoActivoFijoRelacionesDetalles(List<DetalleActivoFijo> detalleactivofijos)throws Exception {
		try {
	

			Long idSubGrupoActivoFijoActual=this.getSubGrupoActivoFijo().getId();

			DetalleActivoFijoLogic detalleactivofijoLogic_Desde_SubGrupoActivoFijo=new DetalleActivoFijoLogic();
			detalleactivofijoLogic_Desde_SubGrupoActivoFijo.setDetalleActivoFijos(detalleactivofijos);

			detalleactivofijoLogic_Desde_SubGrupoActivoFijo.setConnexion(this.getConnexion());
			detalleactivofijoLogic_Desde_SubGrupoActivoFijo.setDatosCliente(this.datosCliente);

			for(DetalleActivoFijo detalleactivofijo_Desde_SubGrupoActivoFijo:detalleactivofijoLogic_Desde_SubGrupoActivoFijo.getDetalleActivoFijos()) {
				detalleactivofijo_Desde_SubGrupoActivoFijo.setid_sub_grupo_activo_fijo(idSubGrupoActivoFijoActual);

				detalleactivofijoLogic_Desde_SubGrupoActivoFijo.setDetalleActivoFijo(detalleactivofijo_Desde_SubGrupoActivoFijo);
				detalleactivofijoLogic_Desde_SubGrupoActivoFijo.saveDetalleActivoFijo();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSubGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SubGrupoActivoFijoConstantesFunciones.getClassesForeignKeysOfSubGrupoActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SubGrupoActivoFijoConstantesFunciones.getClassesRelationshipsOfSubGrupoActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
