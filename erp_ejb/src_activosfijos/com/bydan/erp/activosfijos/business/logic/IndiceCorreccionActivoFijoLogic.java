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
import com.bydan.erp.activosfijos.util.IndiceCorreccionActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.IndiceCorreccionActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.IndiceCorreccionActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.IndiceCorreccionActivoFijo;
import com.bydan.erp.activosfijos.business.logic.IndiceCorreccionActivoFijoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class IndiceCorreccionActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(IndiceCorreccionActivoFijoLogic.class);
	
	protected IndiceCorreccionActivoFijoDataAccess indicecorreccionactivofijoDataAccess; 	
	protected IndiceCorreccionActivoFijo indicecorreccionactivofijo;
	protected List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos;
	protected Object indicecorreccionactivofijoObject;	
	protected List<Object> indicecorreccionactivofijosObject;
	
	public static ClassValidator<IndiceCorreccionActivoFijo> indicecorreccionactivofijoValidator = new ClassValidator<IndiceCorreccionActivoFijo>(IndiceCorreccionActivoFijo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected IndiceCorreccionActivoFijoLogicAdditional indicecorreccionactivofijoLogicAdditional=null;
	
	public IndiceCorreccionActivoFijoLogicAdditional getIndiceCorreccionActivoFijoLogicAdditional() {
		return this.indicecorreccionactivofijoLogicAdditional;
	}
	
	public void setIndiceCorreccionActivoFijoLogicAdditional(IndiceCorreccionActivoFijoLogicAdditional indicecorreccionactivofijoLogicAdditional) {
		try {
			this.indicecorreccionactivofijoLogicAdditional=indicecorreccionactivofijoLogicAdditional;
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
	
	
	
	
	public  IndiceCorreccionActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.indicecorreccionactivofijoDataAccess = new IndiceCorreccionActivoFijoDataAccess();
			
			this.indicecorreccionactivofijos= new ArrayList<IndiceCorreccionActivoFijo>();
			this.indicecorreccionactivofijo= new IndiceCorreccionActivoFijo();
			
			this.indicecorreccionactivofijoObject=new Object();
			this.indicecorreccionactivofijosObject=new ArrayList<Object>();
				
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
			
			this.indicecorreccionactivofijoDataAccess.setConnexionType(this.connexionType);
			this.indicecorreccionactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  IndiceCorreccionActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.indicecorreccionactivofijoDataAccess = new IndiceCorreccionActivoFijoDataAccess();
			this.indicecorreccionactivofijos= new ArrayList<IndiceCorreccionActivoFijo>();
			this.indicecorreccionactivofijo= new IndiceCorreccionActivoFijo();
			this.indicecorreccionactivofijoObject=new Object();
			this.indicecorreccionactivofijosObject=new ArrayList<Object>();
			
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
			
			this.indicecorreccionactivofijoDataAccess.setConnexionType(this.connexionType);
			this.indicecorreccionactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public IndiceCorreccionActivoFijo getIndiceCorreccionActivoFijo() throws Exception {	
		IndiceCorreccionActivoFijoLogicAdditional.checkIndiceCorreccionActivoFijoToGet(indicecorreccionactivofijo,this.datosCliente,this.arrDatoGeneral);
		IndiceCorreccionActivoFijoLogicAdditional.updateIndiceCorreccionActivoFijoToGet(indicecorreccionactivofijo,this.arrDatoGeneral);
		
		return indicecorreccionactivofijo;
	}
		
	public void setIndiceCorreccionActivoFijo(IndiceCorreccionActivoFijo newIndiceCorreccionActivoFijo) {
		this.indicecorreccionactivofijo = newIndiceCorreccionActivoFijo;
	}
	
	public IndiceCorreccionActivoFijoDataAccess getIndiceCorreccionActivoFijoDataAccess() {
		return indicecorreccionactivofijoDataAccess;
	}
	
	public void setIndiceCorreccionActivoFijoDataAccess(IndiceCorreccionActivoFijoDataAccess newindicecorreccionactivofijoDataAccess) {
		this.indicecorreccionactivofijoDataAccess = newindicecorreccionactivofijoDataAccess;
	}
	
	public List<IndiceCorreccionActivoFijo> getIndiceCorreccionActivoFijos() throws Exception {		
		this.quitarIndiceCorreccionActivoFijosNulos();
		
		IndiceCorreccionActivoFijoLogicAdditional.checkIndiceCorreccionActivoFijoToGets(indicecorreccionactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (IndiceCorreccionActivoFijo indicecorreccionactivofijoLocal: indicecorreccionactivofijos ) {
			IndiceCorreccionActivoFijoLogicAdditional.updateIndiceCorreccionActivoFijoToGet(indicecorreccionactivofijoLocal,this.arrDatoGeneral);
		}
		
		return indicecorreccionactivofijos;
	}
	
	public void setIndiceCorreccionActivoFijos(List<IndiceCorreccionActivoFijo> newIndiceCorreccionActivoFijos) {
		this.indicecorreccionactivofijos = newIndiceCorreccionActivoFijos;
	}
	
	public Object getIndiceCorreccionActivoFijoObject() {	
		this.indicecorreccionactivofijoObject=this.indicecorreccionactivofijoDataAccess.getEntityObject();
		return this.indicecorreccionactivofijoObject;
	}
		
	public void setIndiceCorreccionActivoFijoObject(Object newIndiceCorreccionActivoFijoObject) {
		this.indicecorreccionactivofijoObject = newIndiceCorreccionActivoFijoObject;
	}
	
	public List<Object> getIndiceCorreccionActivoFijosObject() {		
		this.indicecorreccionactivofijosObject=this.indicecorreccionactivofijoDataAccess.getEntitiesObject();
		return this.indicecorreccionactivofijosObject;
	}
		
	public void setIndiceCorreccionActivoFijosObject(List<Object> newIndiceCorreccionActivoFijosObject) {
		this.indicecorreccionactivofijosObject = newIndiceCorreccionActivoFijosObject;
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
		
		if(this.indicecorreccionactivofijoDataAccess!=null) {
			this.indicecorreccionactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			indicecorreccionactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			indicecorreccionactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			indicecorreccionactivofijo=indicecorreccionactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.indicecorreccionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijo);
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
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		  		  
        try {
			
			indicecorreccionactivofijo=indicecorreccionactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.indicecorreccionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			indicecorreccionactivofijo=indicecorreccionactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.indicecorreccionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijo);
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
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		  		  
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
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		  		  
        try {
			
			indicecorreccionactivofijo=indicecorreccionactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.indicecorreccionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		  		  
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
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =indicecorreccionactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=indicecorreccionactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =indicecorreccionactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=indicecorreccionactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =indicecorreccionactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=indicecorreccionactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
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
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		  		  
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
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		  		  
        try {			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		  		  
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
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
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
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		  		  
        try {
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
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
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
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
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijo=indicecorreccionactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijo);
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
		indicecorreccionactivofijo = new  IndiceCorreccionActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijo=indicecorreccionactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
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
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		  		  
        try {
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosIndiceCorreccionActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getTodosIndiceCorreccionActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
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
	
	public  void  getTodosIndiceCorreccionActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		indicecorreccionactivofijos = new  ArrayList<IndiceCorreccionActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarIndiceCorreccionActivoFijo(IndiceCorreccionActivoFijo indicecorreccionactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(indicecorreccionactivofijo.getIsNew() || indicecorreccionactivofijo.getIsChanged()) { 
			this.invalidValues = indicecorreccionactivofijoValidator.getInvalidValues(indicecorreccionactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(indicecorreccionactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarIndiceCorreccionActivoFijo(List<IndiceCorreccionActivoFijo> IndiceCorreccionActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijoLocal:indicecorreccionactivofijos) {				
			estaValidadoObjeto=this.validarGuardarIndiceCorreccionActivoFijo(indicecorreccionactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarIndiceCorreccionActivoFijo(List<IndiceCorreccionActivoFijo> IndiceCorreccionActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarIndiceCorreccionActivoFijo(indicecorreccionactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarIndiceCorreccionActivoFijo(IndiceCorreccionActivoFijo IndiceCorreccionActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarIndiceCorreccionActivoFijo(indicecorreccionactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(IndiceCorreccionActivoFijo indicecorreccionactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+indicecorreccionactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=IndiceCorreccionActivoFijoConstantesFunciones.getIndiceCorreccionActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"indicecorreccionactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(IndiceCorreccionActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(IndiceCorreccionActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveIndiceCorreccionActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-saveIndiceCorreccionActivoFijoWithConnection");connexion.begin();			
			
			IndiceCorreccionActivoFijoLogicAdditional.checkIndiceCorreccionActivoFijoToSave(this.indicecorreccionactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			IndiceCorreccionActivoFijoLogicAdditional.updateIndiceCorreccionActivoFijoToSave(this.indicecorreccionactivofijo,this.arrDatoGeneral);
			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.indicecorreccionactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowIndiceCorreccionActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarIndiceCorreccionActivoFijo(this.indicecorreccionactivofijo)) {
				IndiceCorreccionActivoFijoDataAccess.save(this.indicecorreccionactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.indicecorreccionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			IndiceCorreccionActivoFijoLogicAdditional.checkIndiceCorreccionActivoFijoToSaveAfter(this.indicecorreccionactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowIndiceCorreccionActivoFijo();
			
			connexion.commit();			
			
			if(this.indicecorreccionactivofijo.getIsDeleted()) {
				this.indicecorreccionactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveIndiceCorreccionActivoFijo()throws Exception {	
		try {	
			
			IndiceCorreccionActivoFijoLogicAdditional.checkIndiceCorreccionActivoFijoToSave(this.indicecorreccionactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			IndiceCorreccionActivoFijoLogicAdditional.updateIndiceCorreccionActivoFijoToSave(this.indicecorreccionactivofijo,this.arrDatoGeneral);
			
			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.indicecorreccionactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarIndiceCorreccionActivoFijo(this.indicecorreccionactivofijo)) {			
				IndiceCorreccionActivoFijoDataAccess.save(this.indicecorreccionactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.indicecorreccionactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			IndiceCorreccionActivoFijoLogicAdditional.checkIndiceCorreccionActivoFijoToSaveAfter(this.indicecorreccionactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.indicecorreccionactivofijo.getIsDeleted()) {
				this.indicecorreccionactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveIndiceCorreccionActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-saveIndiceCorreccionActivoFijosWithConnection");connexion.begin();			
			
			IndiceCorreccionActivoFijoLogicAdditional.checkIndiceCorreccionActivoFijoToSaves(indicecorreccionactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowIndiceCorreccionActivoFijos();
			
			Boolean validadoTodosIndiceCorreccionActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(IndiceCorreccionActivoFijo indicecorreccionactivofijoLocal:indicecorreccionactivofijos) {		
				if(indicecorreccionactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				IndiceCorreccionActivoFijoLogicAdditional.updateIndiceCorreccionActivoFijoToSave(indicecorreccionactivofijoLocal,this.arrDatoGeneral);
	        	
				IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),indicecorreccionactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarIndiceCorreccionActivoFijo(indicecorreccionactivofijoLocal)) {
					IndiceCorreccionActivoFijoDataAccess.save(indicecorreccionactivofijoLocal, connexion);				
				} else {
					validadoTodosIndiceCorreccionActivoFijo=false;
				}
			}
			
			if(!validadoTodosIndiceCorreccionActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			IndiceCorreccionActivoFijoLogicAdditional.checkIndiceCorreccionActivoFijoToSavesAfter(indicecorreccionactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowIndiceCorreccionActivoFijos();
			
			connexion.commit();		
			
			this.quitarIndiceCorreccionActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveIndiceCorreccionActivoFijos()throws Exception {				
		 try {	
			IndiceCorreccionActivoFijoLogicAdditional.checkIndiceCorreccionActivoFijoToSaves(indicecorreccionactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosIndiceCorreccionActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(IndiceCorreccionActivoFijo indicecorreccionactivofijoLocal:indicecorreccionactivofijos) {				
				if(indicecorreccionactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				IndiceCorreccionActivoFijoLogicAdditional.updateIndiceCorreccionActivoFijoToSave(indicecorreccionactivofijoLocal,this.arrDatoGeneral);
	        	
				IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),indicecorreccionactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarIndiceCorreccionActivoFijo(indicecorreccionactivofijoLocal)) {				
					IndiceCorreccionActivoFijoDataAccess.save(indicecorreccionactivofijoLocal, connexion);				
				} else {
					validadoTodosIndiceCorreccionActivoFijo=false;
				}
			}
			
			if(!validadoTodosIndiceCorreccionActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			IndiceCorreccionActivoFijoLogicAdditional.checkIndiceCorreccionActivoFijoToSavesAfter(indicecorreccionactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarIndiceCorreccionActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public IndiceCorreccionActivoFijoParameterReturnGeneral procesarAccionIndiceCorreccionActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos,IndiceCorreccionActivoFijoParameterReturnGeneral indicecorreccionactivofijoParameterGeneral)throws Exception {
		 try {	
			IndiceCorreccionActivoFijoParameterReturnGeneral indicecorreccionactivofijoReturnGeneral=new IndiceCorreccionActivoFijoParameterReturnGeneral();
	
			IndiceCorreccionActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,indicecorreccionactivofijos,indicecorreccionactivofijoParameterGeneral,indicecorreccionactivofijoReturnGeneral);
			
			return indicecorreccionactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public IndiceCorreccionActivoFijoParameterReturnGeneral procesarAccionIndiceCorreccionActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos,IndiceCorreccionActivoFijoParameterReturnGeneral indicecorreccionactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-procesarAccionIndiceCorreccionActivoFijosWithConnection");connexion.begin();			
			
			IndiceCorreccionActivoFijoParameterReturnGeneral indicecorreccionactivofijoReturnGeneral=new IndiceCorreccionActivoFijoParameterReturnGeneral();
	
			IndiceCorreccionActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,indicecorreccionactivofijos,indicecorreccionactivofijoParameterGeneral,indicecorreccionactivofijoReturnGeneral);
			
			this.connexion.commit();
			
			return indicecorreccionactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public IndiceCorreccionActivoFijoParameterReturnGeneral procesarEventosIndiceCorreccionActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos,IndiceCorreccionActivoFijo indicecorreccionactivofijo,IndiceCorreccionActivoFijoParameterReturnGeneral indicecorreccionactivofijoParameterGeneral,Boolean isEsNuevoIndiceCorreccionActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			IndiceCorreccionActivoFijoParameterReturnGeneral indicecorreccionactivofijoReturnGeneral=new IndiceCorreccionActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				indicecorreccionactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			IndiceCorreccionActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,indicecorreccionactivofijos,indicecorreccionactivofijo,indicecorreccionactivofijoParameterGeneral,indicecorreccionactivofijoReturnGeneral,isEsNuevoIndiceCorreccionActivoFijo,clases);
			
			return indicecorreccionactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public IndiceCorreccionActivoFijoParameterReturnGeneral procesarEventosIndiceCorreccionActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos,IndiceCorreccionActivoFijo indicecorreccionactivofijo,IndiceCorreccionActivoFijoParameterReturnGeneral indicecorreccionactivofijoParameterGeneral,Boolean isEsNuevoIndiceCorreccionActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-procesarEventosIndiceCorreccionActivoFijosWithConnection");connexion.begin();			
			
			IndiceCorreccionActivoFijoParameterReturnGeneral indicecorreccionactivofijoReturnGeneral=new IndiceCorreccionActivoFijoParameterReturnGeneral();
	
			indicecorreccionactivofijoReturnGeneral.setIndiceCorreccionActivoFijo(indicecorreccionactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				indicecorreccionactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			IndiceCorreccionActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,indicecorreccionactivofijos,indicecorreccionactivofijo,indicecorreccionactivofijoParameterGeneral,indicecorreccionactivofijoReturnGeneral,isEsNuevoIndiceCorreccionActivoFijo,clases);
			
			this.connexion.commit();
			
			return indicecorreccionactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public IndiceCorreccionActivoFijoParameterReturnGeneral procesarImportacionIndiceCorreccionActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,IndiceCorreccionActivoFijoParameterReturnGeneral indicecorreccionactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-procesarImportacionIndiceCorreccionActivoFijosWithConnection");connexion.begin();			
			
			IndiceCorreccionActivoFijoParameterReturnGeneral indicecorreccionactivofijoReturnGeneral=new IndiceCorreccionActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.indicecorreccionactivofijos=new ArrayList<IndiceCorreccionActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.indicecorreccionactivofijo=new IndiceCorreccionActivoFijo();
				
				
				if(conColumnasBase) {this.indicecorreccionactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.indicecorreccionactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.indicecorreccionactivofijo.setanio(Integer.parseInt(arrColumnas[iColumn++]));
				this.indicecorreccionactivofijo.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.indicecorreccionactivofijos.add(this.indicecorreccionactivofijo);
			}
			
			this.saveIndiceCorreccionActivoFijos();
			
			this.connexion.commit();
			
			indicecorreccionactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			indicecorreccionactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return indicecorreccionactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarIndiceCorreccionActivoFijosEliminados() throws Exception {				
		
		List<IndiceCorreccionActivoFijo> indicecorreccionactivofijosAux= new ArrayList<IndiceCorreccionActivoFijo>();
		
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijo:indicecorreccionactivofijos) {
			if(!indicecorreccionactivofijo.getIsDeleted()) {
				indicecorreccionactivofijosAux.add(indicecorreccionactivofijo);
			}
		}
		
		indicecorreccionactivofijos=indicecorreccionactivofijosAux;
	}
	
	public void quitarIndiceCorreccionActivoFijosNulos() throws Exception {				
		
		List<IndiceCorreccionActivoFijo> indicecorreccionactivofijosAux= new ArrayList<IndiceCorreccionActivoFijo>();
		
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijo : this.indicecorreccionactivofijos) {
			if(indicecorreccionactivofijo==null) {
				indicecorreccionactivofijosAux.add(indicecorreccionactivofijo);
			}
		}
		
		//this.indicecorreccionactivofijos=indicecorreccionactivofijosAux;
		
		this.indicecorreccionactivofijos.removeAll(indicecorreccionactivofijosAux);
	}
	
	public void getSetVersionRowIndiceCorreccionActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(indicecorreccionactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((indicecorreccionactivofijo.getIsDeleted() || (indicecorreccionactivofijo.getIsChanged()&&!indicecorreccionactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=indicecorreccionactivofijoDataAccess.getSetVersionRowIndiceCorreccionActivoFijo(connexion,indicecorreccionactivofijo.getId());
				
				if(!indicecorreccionactivofijo.getVersionRow().equals(timestamp)) {	
					indicecorreccionactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				indicecorreccionactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowIndiceCorreccionActivoFijo()throws Exception {	
		
		if(indicecorreccionactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((indicecorreccionactivofijo.getIsDeleted() || (indicecorreccionactivofijo.getIsChanged()&&!indicecorreccionactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=indicecorreccionactivofijoDataAccess.getSetVersionRowIndiceCorreccionActivoFijo(connexion,indicecorreccionactivofijo.getId());
			
			try {							
				if(!indicecorreccionactivofijo.getVersionRow().equals(timestamp)) {	
					indicecorreccionactivofijo.setVersionRow(timestamp);
				}
				
				indicecorreccionactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowIndiceCorreccionActivoFijosWithConnection()throws Exception {	
		if(indicecorreccionactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(IndiceCorreccionActivoFijo indicecorreccionactivofijoAux:indicecorreccionactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(indicecorreccionactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(indicecorreccionactivofijoAux.getIsDeleted() || (indicecorreccionactivofijoAux.getIsChanged()&&!indicecorreccionactivofijoAux.getIsNew())) {
						
						timestamp=indicecorreccionactivofijoDataAccess.getSetVersionRowIndiceCorreccionActivoFijo(connexion,indicecorreccionactivofijoAux.getId());
						
						if(!indicecorreccionactivofijo.getVersionRow().equals(timestamp)) {	
							indicecorreccionactivofijoAux.setVersionRow(timestamp);
						}
								
						indicecorreccionactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowIndiceCorreccionActivoFijos()throws Exception {	
		if(indicecorreccionactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(IndiceCorreccionActivoFijo indicecorreccionactivofijoAux:indicecorreccionactivofijos) {
					if(indicecorreccionactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(indicecorreccionactivofijoAux.getIsDeleted() || (indicecorreccionactivofijoAux.getIsChanged()&&!indicecorreccionactivofijoAux.getIsNew())) {
						
						timestamp=indicecorreccionactivofijoDataAccess.getSetVersionRowIndiceCorreccionActivoFijo(connexion,indicecorreccionactivofijoAux.getId());
						
						if(!indicecorreccionactivofijoAux.getVersionRow().equals(timestamp)) {	
							indicecorreccionactivofijoAux.setVersionRow(timestamp);
						}
						
													
						indicecorreccionactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public IndiceCorreccionActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyIndiceCorreccionActivoFijoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		IndiceCorreccionActivoFijoParameterReturnGeneral  indicecorreccionactivofijoReturnGeneral =new IndiceCorreccionActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeyIndiceCorreccionActivoFijoWithConnection");connexion.begin();
			
			indicecorreccionactivofijoReturnGeneral =new IndiceCorreccionActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			indicecorreccionactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return indicecorreccionactivofijoReturnGeneral;
	}
	
	public IndiceCorreccionActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyIndiceCorreccionActivoFijo(String finalQueryGlobalEmpresa) throws Exception {
		IndiceCorreccionActivoFijoParameterReturnGeneral  indicecorreccionactivofijoReturnGeneral =new IndiceCorreccionActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			indicecorreccionactivofijoReturnGeneral =new IndiceCorreccionActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			indicecorreccionactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return indicecorreccionactivofijoReturnGeneral;
	}
	
	
	public void deepLoad(IndiceCorreccionActivoFijo indicecorreccionactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			IndiceCorreccionActivoFijoLogicAdditional.updateIndiceCorreccionActivoFijoToGet(indicecorreccionactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		indicecorreccionactivofijo.setEmpresa(indicecorreccionactivofijoDataAccess.getEmpresa(connexion,indicecorreccionactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				indicecorreccionactivofijo.setEmpresa(indicecorreccionactivofijoDataAccess.getEmpresa(connexion,indicecorreccionactivofijo));
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
			indicecorreccionactivofijo.setEmpresa(indicecorreccionactivofijoDataAccess.getEmpresa(connexion,indicecorreccionactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		indicecorreccionactivofijo.setEmpresa(indicecorreccionactivofijoDataAccess.getEmpresa(connexion,indicecorreccionactivofijo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(indicecorreccionactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				indicecorreccionactivofijo.setEmpresa(indicecorreccionactivofijoDataAccess.getEmpresa(connexion,indicecorreccionactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(indicecorreccionactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
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
			indicecorreccionactivofijo.setEmpresa(indicecorreccionactivofijoDataAccess.getEmpresa(connexion,indicecorreccionactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(indicecorreccionactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(IndiceCorreccionActivoFijo indicecorreccionactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			IndiceCorreccionActivoFijoLogicAdditional.updateIndiceCorreccionActivoFijoToSave(indicecorreccionactivofijo,this.arrDatoGeneral);
			
IndiceCorreccionActivoFijoDataAccess.save(indicecorreccionactivofijo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(indicecorreccionactivofijo.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(indicecorreccionactivofijo.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(indicecorreccionactivofijo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(indicecorreccionactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(indicecorreccionactivofijo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(indicecorreccionactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(IndiceCorreccionActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(indicecorreccionactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(indicecorreccionactivofijo);
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
			this.deepLoad(this.indicecorreccionactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(IndiceCorreccionActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(indicecorreccionactivofijos!=null) {
				for(IndiceCorreccionActivoFijo indicecorreccionactivofijo:indicecorreccionactivofijos) {
					this.deepLoad(indicecorreccionactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
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
			if(indicecorreccionactivofijos!=null) {
				for(IndiceCorreccionActivoFijo indicecorreccionactivofijo:indicecorreccionactivofijos) {
					this.deepLoad(indicecorreccionactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(indicecorreccionactivofijos);
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
			this.getNewConnexionToDeep(IndiceCorreccionActivoFijo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(indicecorreccionactivofijo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(IndiceCorreccionActivoFijo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(indicecorreccionactivofijos!=null) {
				for(IndiceCorreccionActivoFijo indicecorreccionactivofijo:indicecorreccionactivofijos) {
					this.deepSave(indicecorreccionactivofijo,isDeep,deepLoadType,clases);
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
			if(indicecorreccionactivofijos!=null) {
				for(IndiceCorreccionActivoFijo indicecorreccionactivofijo:indicecorreccionactivofijos) {
					this.deepSave(indicecorreccionactivofijo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getIndiceCorreccionActivoFijosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,IndiceCorreccionActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getIndiceCorreccionActivoFijosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			IndiceCorreccionActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			indicecorreccionactivofijos=indicecorreccionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IndiceCorreccionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesIndiceCorreccionActivoFijo(this.indicecorreccionactivofijos);
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
			if(IndiceCorreccionActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,IndiceCorreccionActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,IndiceCorreccionActivoFijo indicecorreccionactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(IndiceCorreccionActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(indicecorreccionactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,IndiceCorreccionActivoFijoDataAccess.TABLENAME, indicecorreccionactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(IndiceCorreccionActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////IndiceCorreccionActivoFijoLogic.registrarAuditoriaDetallesIndiceCorreccionActivoFijo(connexion,indicecorreccionactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(indicecorreccionactivofijo.getIsDeleted()) {
					/*if(!indicecorreccionactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,IndiceCorreccionActivoFijoDataAccess.TABLENAME, indicecorreccionactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////IndiceCorreccionActivoFijoLogic.registrarAuditoriaDetallesIndiceCorreccionActivoFijo(connexion,indicecorreccionactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,IndiceCorreccionActivoFijoDataAccess.TABLENAME, indicecorreccionactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(indicecorreccionactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,IndiceCorreccionActivoFijoDataAccess.TABLENAME, indicecorreccionactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(IndiceCorreccionActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////IndiceCorreccionActivoFijoLogic.registrarAuditoriaDetallesIndiceCorreccionActivoFijo(connexion,indicecorreccionactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesIndiceCorreccionActivoFijo(Connexion connexion,IndiceCorreccionActivoFijo indicecorreccionactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(indicecorreccionactivofijo.getIsNew()||!indicecorreccionactivofijo.getid_empresa().equals(indicecorreccionactivofijo.getIndiceCorreccionActivoFijoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(indicecorreccionactivofijo.getIndiceCorreccionActivoFijoOriginal().getid_empresa()!=null)
				{
					strValorActual=indicecorreccionactivofijo.getIndiceCorreccionActivoFijoOriginal().getid_empresa().toString();
				}
				if(indicecorreccionactivofijo.getid_empresa()!=null)
				{
					strValorNuevo=indicecorreccionactivofijo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(indicecorreccionactivofijo.getIsNew()||!indicecorreccionactivofijo.getanio().equals(indicecorreccionactivofijo.getIndiceCorreccionActivoFijoOriginal().getanio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(indicecorreccionactivofijo.getIndiceCorreccionActivoFijoOriginal().getanio()!=null)
				{
					strValorActual=indicecorreccionactivofijo.getIndiceCorreccionActivoFijoOriginal().getanio().toString();
				}
				if(indicecorreccionactivofijo.getanio()!=null)
				{
					strValorNuevo=indicecorreccionactivofijo.getanio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IndiceCorreccionActivoFijoConstantesFunciones.ANIO,strValorActual,strValorNuevo);
			}	
			
			if(indicecorreccionactivofijo.getIsNew()||!indicecorreccionactivofijo.getvalor().equals(indicecorreccionactivofijo.getIndiceCorreccionActivoFijoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(indicecorreccionactivofijo.getIndiceCorreccionActivoFijoOriginal().getvalor()!=null)
				{
					strValorActual=indicecorreccionactivofijo.getIndiceCorreccionActivoFijoOriginal().getvalor().toString();
				}
				if(indicecorreccionactivofijo.getvalor()!=null)
				{
					strValorNuevo=indicecorreccionactivofijo.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IndiceCorreccionActivoFijoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveIndiceCorreccionActivoFijoRelacionesWithConnection(IndiceCorreccionActivoFijo indicecorreccionactivofijo) throws Exception {

		if(!indicecorreccionactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveIndiceCorreccionActivoFijoRelacionesBase(indicecorreccionactivofijo,true);
		}
	}

	public void saveIndiceCorreccionActivoFijoRelaciones(IndiceCorreccionActivoFijo indicecorreccionactivofijo)throws Exception {

		if(!indicecorreccionactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveIndiceCorreccionActivoFijoRelacionesBase(indicecorreccionactivofijo,false);
		}
	}

	public void saveIndiceCorreccionActivoFijoRelacionesBase(IndiceCorreccionActivoFijo indicecorreccionactivofijo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("IndiceCorreccionActivoFijo-saveRelacionesWithConnection");}
	

			this.setIndiceCorreccionActivoFijo(indicecorreccionactivofijo);

			if(IndiceCorreccionActivoFijoLogicAdditional.validarSaveRelaciones(indicecorreccionactivofijo,this)) {

				IndiceCorreccionActivoFijoLogicAdditional.updateRelacionesToSave(indicecorreccionactivofijo,this);

				if((indicecorreccionactivofijo.getIsNew()||indicecorreccionactivofijo.getIsChanged())&&!indicecorreccionactivofijo.getIsDeleted()) {
					this.saveIndiceCorreccionActivoFijo();
					this.saveIndiceCorreccionActivoFijoRelacionesDetalles();

				} else if(indicecorreccionactivofijo.getIsDeleted()) {
					this.saveIndiceCorreccionActivoFijoRelacionesDetalles();
					this.saveIndiceCorreccionActivoFijo();
				}

				IndiceCorreccionActivoFijoLogicAdditional.updateRelacionesToSaveAfter(indicecorreccionactivofijo,this);

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
	
	
	private void saveIndiceCorreccionActivoFijoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfIndiceCorreccionActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=IndiceCorreccionActivoFijoConstantesFunciones.getClassesForeignKeysOfIndiceCorreccionActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfIndiceCorreccionActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=IndiceCorreccionActivoFijoConstantesFunciones.getClassesRelationshipsOfIndiceCorreccionActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
