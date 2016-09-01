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
import com.bydan.erp.activosfijos.util.FormatoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.FormatoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.FormatoActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.FormatoActivoFijo;
import com.bydan.erp.activosfijos.business.logic.FormatoActivoFijoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FormatoActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormatoActivoFijoLogic.class);
	
	protected FormatoActivoFijoDataAccess formatoactivofijoDataAccess; 	
	protected FormatoActivoFijo formatoactivofijo;
	protected List<FormatoActivoFijo> formatoactivofijos;
	protected Object formatoactivofijoObject;	
	protected List<Object> formatoactivofijosObject;
	
	public static ClassValidator<FormatoActivoFijo> formatoactivofijoValidator = new ClassValidator<FormatoActivoFijo>(FormatoActivoFijo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormatoActivoFijoLogicAdditional formatoactivofijoLogicAdditional=null;
	
	public FormatoActivoFijoLogicAdditional getFormatoActivoFijoLogicAdditional() {
		return this.formatoactivofijoLogicAdditional;
	}
	
	public void setFormatoActivoFijoLogicAdditional(FormatoActivoFijoLogicAdditional formatoactivofijoLogicAdditional) {
		try {
			this.formatoactivofijoLogicAdditional=formatoactivofijoLogicAdditional;
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
	
	
	
	
	public  FormatoActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formatoactivofijoDataAccess = new FormatoActivoFijoDataAccess();
			
			this.formatoactivofijos= new ArrayList<FormatoActivoFijo>();
			this.formatoactivofijo= new FormatoActivoFijo();
			
			this.formatoactivofijoObject=new Object();
			this.formatoactivofijosObject=new ArrayList<Object>();
				
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
			
			this.formatoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.formatoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormatoActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formatoactivofijoDataAccess = new FormatoActivoFijoDataAccess();
			this.formatoactivofijos= new ArrayList<FormatoActivoFijo>();
			this.formatoactivofijo= new FormatoActivoFijo();
			this.formatoactivofijoObject=new Object();
			this.formatoactivofijosObject=new ArrayList<Object>();
			
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
			
			this.formatoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.formatoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FormatoActivoFijo getFormatoActivoFijo() throws Exception {	
		FormatoActivoFijoLogicAdditional.checkFormatoActivoFijoToGet(formatoactivofijo,this.datosCliente,this.arrDatoGeneral);
		FormatoActivoFijoLogicAdditional.updateFormatoActivoFijoToGet(formatoactivofijo,this.arrDatoGeneral);
		
		return formatoactivofijo;
	}
		
	public void setFormatoActivoFijo(FormatoActivoFijo newFormatoActivoFijo) {
		this.formatoactivofijo = newFormatoActivoFijo;
	}
	
	public FormatoActivoFijoDataAccess getFormatoActivoFijoDataAccess() {
		return formatoactivofijoDataAccess;
	}
	
	public void setFormatoActivoFijoDataAccess(FormatoActivoFijoDataAccess newformatoactivofijoDataAccess) {
		this.formatoactivofijoDataAccess = newformatoactivofijoDataAccess;
	}
	
	public List<FormatoActivoFijo> getFormatoActivoFijos() throws Exception {		
		this.quitarFormatoActivoFijosNulos();
		
		FormatoActivoFijoLogicAdditional.checkFormatoActivoFijoToGets(formatoactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (FormatoActivoFijo formatoactivofijoLocal: formatoactivofijos ) {
			FormatoActivoFijoLogicAdditional.updateFormatoActivoFijoToGet(formatoactivofijoLocal,this.arrDatoGeneral);
		}
		
		return formatoactivofijos;
	}
	
	public void setFormatoActivoFijos(List<FormatoActivoFijo> newFormatoActivoFijos) {
		this.formatoactivofijos = newFormatoActivoFijos;
	}
	
	public Object getFormatoActivoFijoObject() {	
		this.formatoactivofijoObject=this.formatoactivofijoDataAccess.getEntityObject();
		return this.formatoactivofijoObject;
	}
		
	public void setFormatoActivoFijoObject(Object newFormatoActivoFijoObject) {
		this.formatoactivofijoObject = newFormatoActivoFijoObject;
	}
	
	public List<Object> getFormatoActivoFijosObject() {		
		this.formatoactivofijosObject=this.formatoactivofijoDataAccess.getEntitiesObject();
		return this.formatoactivofijosObject;
	}
		
	public void setFormatoActivoFijosObject(List<Object> newFormatoActivoFijosObject) {
		this.formatoactivofijosObject = newFormatoActivoFijosObject;
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
		
		if(this.formatoactivofijoDataAccess!=null) {
			this.formatoactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formatoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formatoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formatoactivofijo = new  FormatoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formatoactivofijo=formatoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijo);
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
		formatoactivofijo = new  FormatoActivoFijo();
		  		  
        try {
			
			formatoactivofijo=formatoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formatoactivofijo = new  FormatoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formatoactivofijo=formatoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijo);
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
		formatoactivofijo = new  FormatoActivoFijo();
		  		  
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
		formatoactivofijo = new  FormatoActivoFijo();
		  		  
        try {
			
			formatoactivofijo=formatoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formatoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formatoactivofijo = new  FormatoActivoFijo();
		  		  
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
		formatoactivofijo = new  FormatoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formatoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatoactivofijo = new  FormatoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formatoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formatoactivofijo = new  FormatoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formatoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatoactivofijo = new  FormatoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formatoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formatoactivofijo = new  FormatoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formatoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formatoactivofijo = new  FormatoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formatoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
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
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		  		  
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
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		  		  
        try {			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		  		  
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
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
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
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		  		  
        try {
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
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
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
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
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formatoactivofijo = new  FormatoActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijo=formatoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijo);
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
		formatoactivofijo = new  FormatoActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijo=formatoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijos=formatoactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
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
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		  		  
        try {
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijos=formatoactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormatoActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getTodosFormatoActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
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
	
	public  void  getTodosFormatoActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		formatoactivofijos = new  ArrayList<FormatoActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormatoActivoFijo(formatoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormatoActivoFijo(FormatoActivoFijo formatoactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(formatoactivofijo.getIsNew() || formatoactivofijo.getIsChanged()) { 
			this.invalidValues = formatoactivofijoValidator.getInvalidValues(formatoactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formatoactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormatoActivoFijo(List<FormatoActivoFijo> FormatoActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FormatoActivoFijo formatoactivofijoLocal:formatoactivofijos) {				
			estaValidadoObjeto=this.validarGuardarFormatoActivoFijo(formatoactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormatoActivoFijo(List<FormatoActivoFijo> FormatoActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormatoActivoFijo(formatoactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormatoActivoFijo(FormatoActivoFijo FormatoActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormatoActivoFijo(formatoactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FormatoActivoFijo formatoactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formatoactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormatoActivoFijoConstantesFunciones.getFormatoActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formatoactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormatoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormatoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormatoActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-saveFormatoActivoFijoWithConnection");connexion.begin();			
			
			FormatoActivoFijoLogicAdditional.checkFormatoActivoFijoToSave(this.formatoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormatoActivoFijoLogicAdditional.updateFormatoActivoFijoToSave(this.formatoactivofijo,this.arrDatoGeneral);
			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formatoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormatoActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormatoActivoFijo(this.formatoactivofijo)) {
				FormatoActivoFijoDataAccess.save(this.formatoactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formatoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormatoActivoFijoLogicAdditional.checkFormatoActivoFijoToSaveAfter(this.formatoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormatoActivoFijo();
			
			connexion.commit();			
			
			if(this.formatoactivofijo.getIsDeleted()) {
				this.formatoactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormatoActivoFijo()throws Exception {	
		try {	
			
			FormatoActivoFijoLogicAdditional.checkFormatoActivoFijoToSave(this.formatoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormatoActivoFijoLogicAdditional.updateFormatoActivoFijoToSave(this.formatoactivofijo,this.arrDatoGeneral);
			
			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formatoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormatoActivoFijo(this.formatoactivofijo)) {			
				FormatoActivoFijoDataAccess.save(this.formatoactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formatoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormatoActivoFijoLogicAdditional.checkFormatoActivoFijoToSaveAfter(this.formatoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formatoactivofijo.getIsDeleted()) {
				this.formatoactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormatoActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-saveFormatoActivoFijosWithConnection");connexion.begin();			
			
			FormatoActivoFijoLogicAdditional.checkFormatoActivoFijoToSaves(formatoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormatoActivoFijos();
			
			Boolean validadoTodosFormatoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormatoActivoFijo formatoactivofijoLocal:formatoactivofijos) {		
				if(formatoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormatoActivoFijoLogicAdditional.updateFormatoActivoFijoToSave(formatoactivofijoLocal,this.arrDatoGeneral);
	        	
				FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formatoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormatoActivoFijo(formatoactivofijoLocal)) {
					FormatoActivoFijoDataAccess.save(formatoactivofijoLocal, connexion);				
				} else {
					validadoTodosFormatoActivoFijo=false;
				}
			}
			
			if(!validadoTodosFormatoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormatoActivoFijoLogicAdditional.checkFormatoActivoFijoToSavesAfter(formatoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormatoActivoFijos();
			
			connexion.commit();		
			
			this.quitarFormatoActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormatoActivoFijos()throws Exception {				
		 try {	
			FormatoActivoFijoLogicAdditional.checkFormatoActivoFijoToSaves(formatoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormatoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormatoActivoFijo formatoactivofijoLocal:formatoactivofijos) {				
				if(formatoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormatoActivoFijoLogicAdditional.updateFormatoActivoFijoToSave(formatoactivofijoLocal,this.arrDatoGeneral);
	        	
				FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formatoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormatoActivoFijo(formatoactivofijoLocal)) {				
					FormatoActivoFijoDataAccess.save(formatoactivofijoLocal, connexion);				
				} else {
					validadoTodosFormatoActivoFijo=false;
				}
			}
			
			if(!validadoTodosFormatoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormatoActivoFijoLogicAdditional.checkFormatoActivoFijoToSavesAfter(formatoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormatoActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormatoActivoFijoParameterReturnGeneral procesarAccionFormatoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormatoActivoFijo> formatoactivofijos,FormatoActivoFijoParameterReturnGeneral formatoactivofijoParameterGeneral)throws Exception {
		 try {	
			FormatoActivoFijoParameterReturnGeneral formatoactivofijoReturnGeneral=new FormatoActivoFijoParameterReturnGeneral();
	
			FormatoActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formatoactivofijos,formatoactivofijoParameterGeneral,formatoactivofijoReturnGeneral);
			
			return formatoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormatoActivoFijoParameterReturnGeneral procesarAccionFormatoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormatoActivoFijo> formatoactivofijos,FormatoActivoFijoParameterReturnGeneral formatoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-procesarAccionFormatoActivoFijosWithConnection");connexion.begin();			
			
			FormatoActivoFijoParameterReturnGeneral formatoactivofijoReturnGeneral=new FormatoActivoFijoParameterReturnGeneral();
	
			FormatoActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formatoactivofijos,formatoactivofijoParameterGeneral,formatoactivofijoReturnGeneral);
			
			this.connexion.commit();
			
			return formatoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormatoActivoFijoParameterReturnGeneral procesarEventosFormatoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormatoActivoFijo> formatoactivofijos,FormatoActivoFijo formatoactivofijo,FormatoActivoFijoParameterReturnGeneral formatoactivofijoParameterGeneral,Boolean isEsNuevoFormatoActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormatoActivoFijoParameterReturnGeneral formatoactivofijoReturnGeneral=new FormatoActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formatoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormatoActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formatoactivofijos,formatoactivofijo,formatoactivofijoParameterGeneral,formatoactivofijoReturnGeneral,isEsNuevoFormatoActivoFijo,clases);
			
			return formatoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormatoActivoFijoParameterReturnGeneral procesarEventosFormatoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormatoActivoFijo> formatoactivofijos,FormatoActivoFijo formatoactivofijo,FormatoActivoFijoParameterReturnGeneral formatoactivofijoParameterGeneral,Boolean isEsNuevoFormatoActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-procesarEventosFormatoActivoFijosWithConnection");connexion.begin();			
			
			FormatoActivoFijoParameterReturnGeneral formatoactivofijoReturnGeneral=new FormatoActivoFijoParameterReturnGeneral();
	
			formatoactivofijoReturnGeneral.setFormatoActivoFijo(formatoactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formatoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormatoActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formatoactivofijos,formatoactivofijo,formatoactivofijoParameterGeneral,formatoactivofijoReturnGeneral,isEsNuevoFormatoActivoFijo,clases);
			
			this.connexion.commit();
			
			return formatoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormatoActivoFijoParameterReturnGeneral procesarImportacionFormatoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormatoActivoFijoParameterReturnGeneral formatoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-procesarImportacionFormatoActivoFijosWithConnection");connexion.begin();			
			
			FormatoActivoFijoParameterReturnGeneral formatoactivofijoReturnGeneral=new FormatoActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formatoactivofijos=new ArrayList<FormatoActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formatoactivofijo=new FormatoActivoFijo();
				
				
				if(conColumnasBase) {this.formatoactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formatoactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.formatoactivofijos.add(this.formatoactivofijo);
			}
			
			this.saveFormatoActivoFijos();
			
			this.connexion.commit();
			
			formatoactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			formatoactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formatoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormatoActivoFijosEliminados() throws Exception {				
		
		List<FormatoActivoFijo> formatoactivofijosAux= new ArrayList<FormatoActivoFijo>();
		
		for(FormatoActivoFijo formatoactivofijo:formatoactivofijos) {
			if(!formatoactivofijo.getIsDeleted()) {
				formatoactivofijosAux.add(formatoactivofijo);
			}
		}
		
		formatoactivofijos=formatoactivofijosAux;
	}
	
	public void quitarFormatoActivoFijosNulos() throws Exception {				
		
		List<FormatoActivoFijo> formatoactivofijosAux= new ArrayList<FormatoActivoFijo>();
		
		for(FormatoActivoFijo formatoactivofijo : this.formatoactivofijos) {
			if(formatoactivofijo==null) {
				formatoactivofijosAux.add(formatoactivofijo);
			}
		}
		
		//this.formatoactivofijos=formatoactivofijosAux;
		
		this.formatoactivofijos.removeAll(formatoactivofijosAux);
	}
	
	public void getSetVersionRowFormatoActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formatoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formatoactivofijo.getIsDeleted() || (formatoactivofijo.getIsChanged()&&!formatoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formatoactivofijoDataAccess.getSetVersionRowFormatoActivoFijo(connexion,formatoactivofijo.getId());
				
				if(!formatoactivofijo.getVersionRow().equals(timestamp)) {	
					formatoactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formatoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormatoActivoFijo()throws Exception {	
		
		if(formatoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formatoactivofijo.getIsDeleted() || (formatoactivofijo.getIsChanged()&&!formatoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formatoactivofijoDataAccess.getSetVersionRowFormatoActivoFijo(connexion,formatoactivofijo.getId());
			
			try {							
				if(!formatoactivofijo.getVersionRow().equals(timestamp)) {	
					formatoactivofijo.setVersionRow(timestamp);
				}
				
				formatoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormatoActivoFijosWithConnection()throws Exception {	
		if(formatoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FormatoActivoFijo formatoactivofijoAux:formatoactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formatoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formatoactivofijoAux.getIsDeleted() || (formatoactivofijoAux.getIsChanged()&&!formatoactivofijoAux.getIsNew())) {
						
						timestamp=formatoactivofijoDataAccess.getSetVersionRowFormatoActivoFijo(connexion,formatoactivofijoAux.getId());
						
						if(!formatoactivofijo.getVersionRow().equals(timestamp)) {	
							formatoactivofijoAux.setVersionRow(timestamp);
						}
								
						formatoactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormatoActivoFijos()throws Exception {	
		if(formatoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FormatoActivoFijo formatoactivofijoAux:formatoactivofijos) {
					if(formatoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formatoactivofijoAux.getIsDeleted() || (formatoactivofijoAux.getIsChanged()&&!formatoactivofijoAux.getIsNew())) {
						
						timestamp=formatoactivofijoDataAccess.getSetVersionRowFormatoActivoFijo(connexion,formatoactivofijoAux.getId());
						
						if(!formatoactivofijoAux.getVersionRow().equals(timestamp)) {	
							formatoactivofijoAux.setVersionRow(timestamp);
						}
						
													
						formatoactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormatoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyFormatoActivoFijoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalFormato,String finalQueryGlobalFormato2) throws Exception {
		FormatoActivoFijoParameterReturnGeneral  formatoactivofijoReturnGeneral =new FormatoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormatoActivoFijoWithConnection");connexion.begin();
			
			formatoactivofijoReturnGeneral =new FormatoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formatoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			formatoactivofijoReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Formato> formato2sForeignKey=new ArrayList<Formato>();
			FormatoLogic formato2Logic=new FormatoLogic();
			formato2Logic.setConnexion(this.connexion);
			formato2Logic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato2.equals("NONE")) {
				formato2Logic.getTodosFormatos(finalQueryGlobalFormato2,new Pagination());
				formato2sForeignKey=formato2Logic.getFormatos();
			}

			formatoactivofijoReturnGeneral.setformato2sForeignKey(formato2sForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formatoactivofijoReturnGeneral;
	}
	
	public FormatoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyFormatoActivoFijo(String finalQueryGlobalEmpresa,String finalQueryGlobalFormato,String finalQueryGlobalFormato2) throws Exception {
		FormatoActivoFijoParameterReturnGeneral  formatoactivofijoReturnGeneral =new FormatoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formatoactivofijoReturnGeneral =new FormatoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formatoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			formatoactivofijoReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Formato> formato2sForeignKey=new ArrayList<Formato>();
			FormatoLogic formato2Logic=new FormatoLogic();
			formato2Logic.setConnexion(this.connexion);
			formato2Logic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato2.equals("NONE")) {
				formato2Logic.getTodosFormatos(finalQueryGlobalFormato2,new Pagination());
				formato2sForeignKey=formato2Logic.getFormatos();
			}

			formatoactivofijoReturnGeneral.setformato2sForeignKey(formato2sForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formatoactivofijoReturnGeneral;
	}
	
	
	public void deepLoad(FormatoActivoFijo formatoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormatoActivoFijoLogicAdditional.updateFormatoActivoFijoToGet(formatoactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formatoactivofijo.setEmpresa(formatoactivofijoDataAccess.getEmpresa(connexion,formatoactivofijo));
		formatoactivofijo.setFormato(formatoactivofijoDataAccess.getFormato(connexion,formatoactivofijo));
		formatoactivofijo.setFormato2(formatoactivofijoDataAccess.getFormato2(connexion,formatoactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formatoactivofijo.setEmpresa(formatoactivofijoDataAccess.getEmpresa(connexion,formatoactivofijo));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				formatoactivofijo.setFormato(formatoactivofijoDataAccess.getFormato(connexion,formatoactivofijo));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				formatoactivofijo.setFormato2(formatoactivofijoDataAccess.getFormato2(connexion,formatoactivofijo));
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
			formatoactivofijo.setEmpresa(formatoactivofijoDataAccess.getEmpresa(connexion,formatoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatoactivofijo.setFormato(formatoactivofijoDataAccess.getFormato(connexion,formatoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatoactivofijo.setFormato2(formatoactivofijoDataAccess.getFormato2(connexion,formatoactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formatoactivofijo.setEmpresa(formatoactivofijoDataAccess.getEmpresa(connexion,formatoactivofijo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formatoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		formatoactivofijo.setFormato(formatoactivofijoDataAccess.getFormato(connexion,formatoactivofijo));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(formatoactivofijo.getFormato(),isDeep,deepLoadType,clases);
				
		formatoactivofijo.setFormato2(formatoactivofijoDataAccess.getFormato2(connexion,formatoactivofijo));
		FormatoLogic formato2Logic= new FormatoLogic(connexion);
		formato2Logic.deepLoad(formatoactivofijo.getFormato2(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formatoactivofijo.setEmpresa(formatoactivofijoDataAccess.getEmpresa(connexion,formatoactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formatoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				formatoactivofijo.setFormato(formatoactivofijoDataAccess.getFormato(connexion,formatoactivofijo));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(formatoactivofijo.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				formatoactivofijo.setFormato2(formatoactivofijoDataAccess.getFormato2(connexion,formatoactivofijo));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(formatoactivofijo.getFormato2(),isDeep,deepLoadType,clases);				
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
			formatoactivofijo.setEmpresa(formatoactivofijoDataAccess.getEmpresa(connexion,formatoactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formatoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatoactivofijo.setFormato(formatoactivofijoDataAccess.getFormato(connexion,formatoactivofijo));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(formatoactivofijo.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formatoactivofijo.setFormato2(formatoactivofijoDataAccess.getFormato2(connexion,formatoactivofijo));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(formatoactivofijo.getFormato2(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FormatoActivoFijo formatoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormatoActivoFijoLogicAdditional.updateFormatoActivoFijoToSave(formatoactivofijo,this.arrDatoGeneral);
			
FormatoActivoFijoDataAccess.save(formatoactivofijo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formatoactivofijo.getEmpresa(),connexion);

		FormatoDataAccess.save(formatoactivofijo.getFormato(),connexion);

		FormatoDataAccess.save(formatoactivofijo.getFormato2(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formatoactivofijo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(formatoactivofijo.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(formatoactivofijo.getFormato2(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formatoactivofijo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formatoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(formatoactivofijo.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(formatoactivofijo.getFormato(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(formatoactivofijo.getFormato2(),connexion);
		FormatoLogic formato2Logic= new FormatoLogic(connexion);
		formato2Logic.deepLoad(formatoactivofijo.getFormato2(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formatoactivofijo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formatoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(formatoactivofijo.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(formatoactivofijo.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(formatoactivofijo.getFormato2(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(formatoactivofijo.getFormato2(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(FormatoActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formatoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(formatoactivofijo);
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
			this.deepLoad(this.formatoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FormatoActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formatoactivofijos!=null) {
				for(FormatoActivoFijo formatoactivofijo:formatoactivofijos) {
					this.deepLoad(formatoactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(formatoactivofijos);
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
			if(formatoactivofijos!=null) {
				for(FormatoActivoFijo formatoactivofijo:formatoactivofijos) {
					this.deepLoad(formatoactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(formatoactivofijos);
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
			this.getNewConnexionToDeep(FormatoActivoFijo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formatoactivofijo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FormatoActivoFijo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formatoactivofijos!=null) {
				for(FormatoActivoFijo formatoactivofijo:formatoactivofijos) {
					this.deepSave(formatoactivofijo,isDeep,deepLoadType,clases);
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
			if(formatoactivofijos!=null) {
				for(FormatoActivoFijo formatoactivofijo:formatoactivofijos) {
					this.deepSave(formatoactivofijo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormatoActivoFijosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormatoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoActivoFijosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormatoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoActivoFijosFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,FormatoActivoFijoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoActivoFijosFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,FormatoActivoFijoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormatoActivoFijosFK_IdFormato2WithConnection(String sFinalQuery,Pagination pagination,Long id_formato2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormatoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato2,FormatoActivoFijoConstantesFunciones.IDFORMATO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato2);

			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormatoActivoFijosFK_IdFormato2(String sFinalQuery,Pagination pagination,Long id_formato2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato2,FormatoActivoFijoConstantesFunciones.IDFORMATO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato2);

			FormatoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormatoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesFormatoActivoFijo(this.formatoactivofijos);
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
			if(FormatoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FormatoActivoFijo formatoactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormatoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(formatoactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoActivoFijoDataAccess.TABLENAME, formatoactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormatoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormatoActivoFijoLogic.registrarAuditoriaDetallesFormatoActivoFijo(connexion,formatoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formatoactivofijo.getIsDeleted()) {
					/*if(!formatoactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormatoActivoFijoDataAccess.TABLENAME, formatoactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormatoActivoFijoLogic.registrarAuditoriaDetallesFormatoActivoFijo(connexion,formatoactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoActivoFijoDataAccess.TABLENAME, formatoactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formatoactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormatoActivoFijoDataAccess.TABLENAME, formatoactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormatoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormatoActivoFijoLogic.registrarAuditoriaDetallesFormatoActivoFijo(connexion,formatoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormatoActivoFijo(Connexion connexion,FormatoActivoFijo formatoactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formatoactivofijo.getIsNew()||!formatoactivofijo.getid_empresa().equals(formatoactivofijo.getFormatoActivoFijoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatoactivofijo.getFormatoActivoFijoOriginal().getid_empresa()!=null)
				{
					strValorActual=formatoactivofijo.getFormatoActivoFijoOriginal().getid_empresa().toString();
				}
				if(formatoactivofijo.getid_empresa()!=null)
				{
					strValorNuevo=formatoactivofijo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoActivoFijoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formatoactivofijo.getIsNew()||!formatoactivofijo.getid_formato().equals(formatoactivofijo.getFormatoActivoFijoOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatoactivofijo.getFormatoActivoFijoOriginal().getid_formato()!=null)
				{
					strValorActual=formatoactivofijo.getFormatoActivoFijoOriginal().getid_formato().toString();
				}
				if(formatoactivofijo.getid_formato()!=null)
				{
					strValorNuevo=formatoactivofijo.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoActivoFijoConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(formatoactivofijo.getIsNew()||!formatoactivofijo.getid_formato2().equals(formatoactivofijo.getFormatoActivoFijoOriginal().getid_formato2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formatoactivofijo.getFormatoActivoFijoOriginal().getid_formato2()!=null)
				{
					strValorActual=formatoactivofijo.getFormatoActivoFijoOriginal().getid_formato2().toString();
				}
				if(formatoactivofijo.getid_formato2()!=null)
				{
					strValorNuevo=formatoactivofijo.getid_formato2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormatoActivoFijoConstantesFunciones.IDFORMATO2,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormatoActivoFijoRelacionesWithConnection(FormatoActivoFijo formatoactivofijo) throws Exception {

		if(!formatoactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormatoActivoFijoRelacionesBase(formatoactivofijo,true);
		}
	}

	public void saveFormatoActivoFijoRelaciones(FormatoActivoFijo formatoactivofijo)throws Exception {

		if(!formatoactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormatoActivoFijoRelacionesBase(formatoactivofijo,false);
		}
	}

	public void saveFormatoActivoFijoRelacionesBase(FormatoActivoFijo formatoactivofijo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FormatoActivoFijo-saveRelacionesWithConnection");}
	

			this.setFormatoActivoFijo(formatoactivofijo);

			if(FormatoActivoFijoLogicAdditional.validarSaveRelaciones(formatoactivofijo,this)) {

				FormatoActivoFijoLogicAdditional.updateRelacionesToSave(formatoactivofijo,this);

				if((formatoactivofijo.getIsNew()||formatoactivofijo.getIsChanged())&&!formatoactivofijo.getIsDeleted()) {
					this.saveFormatoActivoFijo();
					this.saveFormatoActivoFijoRelacionesDetalles();

				} else if(formatoactivofijo.getIsDeleted()) {
					this.saveFormatoActivoFijoRelacionesDetalles();
					this.saveFormatoActivoFijo();
				}

				FormatoActivoFijoLogicAdditional.updateRelacionesToSaveAfter(formatoactivofijo,this);

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
	
	
	private void saveFormatoActivoFijoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormatoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormatoActivoFijoConstantesFunciones.getClassesForeignKeysOfFormatoActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormatoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormatoActivoFijoConstantesFunciones.getClassesRelationshipsOfFormatoActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
