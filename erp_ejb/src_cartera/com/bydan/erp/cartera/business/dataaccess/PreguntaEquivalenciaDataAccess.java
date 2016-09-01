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
package com.bydan.erp.cartera.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//PreguntaEquivalenciaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class PreguntaEquivalenciaDataAccess extends  PreguntaEquivalenciaDataAccessAdditional{ //PreguntaEquivalenciaDataAccessAdditional,DataAccessHelper<PreguntaEquivalencia>
	//static Logger logger = Logger.getLogger(PreguntaEquivalenciaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="pregunta_equivalencia";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,descripcion,desde,hasta,orden,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,descripcion=?,desde=?,hasta=?,orden=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select preguntaequivalencia from "+PreguntaEquivalenciaConstantesFunciones.SPERSISTENCENAME+" preguntaequivalencia";
	public static String QUERYSELECTNATIVE="select "+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".version_row,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_empresa,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_sucursal,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_ejercicio,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_periodo,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".descripcion,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".desde,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".hasta,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".orden,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_anio,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id_mes from "+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME;//+" as "+PreguntaEquivalenciaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".id,"+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+".version_row from "+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME;//+" as "+PreguntaEquivalenciaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PreguntaEquivalenciaConstantesFunciones.SCHEMA+"."+PreguntaEquivalenciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,descripcion=?,desde=?,hasta=?,orden=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PREGUNTAEQUIVALENCIA_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PREGUNTAEQUIVALENCIA_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PREGUNTAEQUIVALENCIA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PREGUNTAEQUIVALENCIA_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected PreguntaEquivalenciaDataAccessAdditional preguntaequivalenciaDataAccessAdditional=null;
	
	public PreguntaEquivalenciaDataAccessAdditional getPreguntaEquivalenciaDataAccessAdditional() {
		return this.preguntaequivalenciaDataAccessAdditional;
	}
	
	public void setPreguntaEquivalenciaDataAccessAdditional(PreguntaEquivalenciaDataAccessAdditional preguntaequivalenciaDataAccessAdditional) {
		try {
			this.preguntaequivalenciaDataAccessAdditional=preguntaequivalenciaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PreguntaEquivalenciaDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		PreguntaEquivalenciaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PreguntaEquivalenciaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PreguntaEquivalenciaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
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

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setPreguntaEquivalenciaOriginal(PreguntaEquivalencia preguntaequivalencia)throws Exception  {
		preguntaequivalencia.setPreguntaEquivalenciaOriginal((PreguntaEquivalencia)preguntaequivalencia.clone());		
	}
	
	public void setPreguntaEquivalenciasOriginal(List<PreguntaEquivalencia> preguntaequivalencias)throws Exception  {
		
		for(PreguntaEquivalencia preguntaequivalencia:preguntaequivalencias){
			preguntaequivalencia.setPreguntaEquivalenciaOriginal((PreguntaEquivalencia)preguntaequivalencia.clone());
		}
	}
	
	public static void setPreguntaEquivalenciaOriginalStatic(PreguntaEquivalencia preguntaequivalencia)throws Exception  {
		preguntaequivalencia.setPreguntaEquivalenciaOriginal((PreguntaEquivalencia)preguntaequivalencia.clone());		
	}
	
	public static void setPreguntaEquivalenciasOriginalStatic(List<PreguntaEquivalencia> preguntaequivalencias)throws Exception  {
		
		for(PreguntaEquivalencia preguntaequivalencia:preguntaequivalencias){
			preguntaequivalencia.setPreguntaEquivalenciaOriginal((PreguntaEquivalencia)preguntaequivalencia.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  PreguntaEquivalencia getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  PreguntaEquivalencia getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.PreguntaEquivalencia.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPreguntaEquivalenciaOriginal(new PreguntaEquivalencia());
      	    	entity=super.getEntity("",entity,resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPreguntaEquivalencia("",entity,resultSet); 
				
				//entity.setPreguntaEquivalenciaOriginal(super.getEntity("",entity.getPreguntaEquivalenciaOriginal(),resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaEquivalenciaOriginal(this.getEntityPreguntaEquivalencia("",entity.getPreguntaEquivalenciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePreguntaEquivalencia(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PreguntaEquivalencia getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PreguntaEquivalencia entity = new PreguntaEquivalencia();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  PreguntaEquivalencia getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PreguntaEquivalencia entity = new PreguntaEquivalencia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaEquivalenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.PreguntaEquivalencia.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPreguntaEquivalenciaOriginal(new PreguntaEquivalencia());
      	    	entity=super.getEntity("",entity,resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPreguntaEquivalencia("",entity,resultSet);    
				
				//entity.setPreguntaEquivalenciaOriginal(super.getEntity("",entity.getPreguntaEquivalenciaOriginal(),resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaEquivalenciaOriginal(this.getEntityPreguntaEquivalencia("",entity.getPreguntaEquivalenciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePreguntaEquivalencia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PreguntaEquivalencia
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PreguntaEquivalencia entity = new PreguntaEquivalencia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaEquivalenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.PreguntaEquivalencia.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalsePreguntaEquivalencia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PreguntaEquivalencia> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PreguntaEquivalencia> entities = new  ArrayList<PreguntaEquivalencia>();
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PreguntaEquivalencia> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PreguntaEquivalencia> entities = new  ArrayList<PreguntaEquivalencia>();
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaEquivalenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaEquivalencia();
      	    	entity=super.getEntity("",entity,resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPreguntaEquivalencia("",entity,resultSet);
      	    	
				//entity.setPreguntaEquivalenciaOriginal( new PreguntaEquivalencia());
      	    	//entity.setPreguntaEquivalenciaOriginal(super.getEntity("",entity.getPreguntaEquivalenciaOriginal(),resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaEquivalenciaOriginal(this.getEntityPreguntaEquivalencia("",entity.getPreguntaEquivalenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePreguntaEquivalencias(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaEquivalencia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PreguntaEquivalencia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PreguntaEquivalencia> entities = new  ArrayList<PreguntaEquivalencia>();
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PreguntaEquivalencia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PreguntaEquivalencia> entities = new  ArrayList<PreguntaEquivalencia>();
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaEquivalencia();
				
				if(conMapGenerico) {
					entity.inicializarMapPreguntaEquivalencia();
					//entity.setMapPreguntaEquivalencia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPreguntaEquivalenciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPreguntaEquivalencia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA);         		
					entity=PreguntaEquivalenciaDataAccess.getEntityPreguntaEquivalencia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPreguntaEquivalenciaOriginal( new PreguntaEquivalencia());
					////entity.setPreguntaEquivalenciaOriginal(super.getEntity("",entity.getPreguntaEquivalenciaOriginal(),resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA));         		
					////entity.setPreguntaEquivalenciaOriginal(this.getEntityPreguntaEquivalencia("",entity.getPreguntaEquivalenciaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePreguntaEquivalencias(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaEquivalencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PreguntaEquivalencia getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  PreguntaEquivalencia getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaEquivalencia();
				
				if(conMapGenerico) {
					entity.inicializarMapPreguntaEquivalencia();
					//entity.setMapPreguntaEquivalencia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPreguntaEquivalenciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPreguntaEquivalencia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA);         		
					entity=PreguntaEquivalenciaDataAccess.getEntityPreguntaEquivalencia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPreguntaEquivalenciaOriginal( new PreguntaEquivalencia());
					////entity.setPreguntaEquivalenciaOriginal(super.getEntity("",entity.getPreguntaEquivalenciaOriginal(),resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA));         		
					////entity.setPreguntaEquivalenciaOriginal(this.getEntityPreguntaEquivalencia("",entity.getPreguntaEquivalenciaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePreguntaEquivalencia(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaEquivalencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PreguntaEquivalencia getEntityPreguntaEquivalencia(String strPrefijo,PreguntaEquivalencia entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PreguntaEquivalencia.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PreguntaEquivalencia.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PreguntaEquivalenciaDataAccess.setFieldReflectionPreguntaEquivalencia(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPreguntaEquivalencia=PreguntaEquivalenciaConstantesFunciones.getTodosTiposColumnasPreguntaEquivalencia();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPreguntaEquivalencia) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = PreguntaEquivalencia.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PreguntaEquivalencia.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PreguntaEquivalenciaDataAccess.setFieldReflectionPreguntaEquivalencia(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPreguntaEquivalencia(Field field,String strPrefijo,String sColumn,PreguntaEquivalencia entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PreguntaEquivalenciaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEquivalenciaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PreguntaEquivalenciaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEquivalenciaConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEquivalenciaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PreguntaEquivalenciaConstantesFunciones.DESDE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PreguntaEquivalenciaConstantesFunciones.HASTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PreguntaEquivalenciaConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PreguntaEquivalenciaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEquivalenciaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PreguntaEquivalencia>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PreguntaEquivalencia> entities = new  ArrayList<PreguntaEquivalencia>();
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaEquivalenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new PreguntaEquivalencia();
					entity=super.getEntity("",entity,resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPreguntaEquivalencia("",entity,resultSet);
					
					//entity.setPreguntaEquivalenciaOriginal( new PreguntaEquivalencia());
					//entity.setPreguntaEquivalenciaOriginal(super.getEntity("",entity.getPreguntaEquivalenciaOriginal(),resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA));         		
					//entity.setPreguntaEquivalenciaOriginal(this.getEntityPreguntaEquivalencia("",entity.getPreguntaEquivalenciaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePreguntaEquivalencias(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaEquivalencia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PreguntaEquivalencia>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PreguntaEquivalencia> entities = new  ArrayList<PreguntaEquivalencia>();
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PreguntaEquivalenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaEquivalenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<PreguntaEquivalencia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaEquivalencia> entities = new  ArrayList<PreguntaEquivalencia>();
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PreguntaEquivalencia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaEquivalencia> entities = new  ArrayList<PreguntaEquivalencia>();
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaEquivalencia();
      	    	entity=super.getEntity("",entity,resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPreguntaEquivalencia("",entity,resultSet);
      	    	
				//entity.setPreguntaEquivalenciaOriginal( new PreguntaEquivalencia());
      	    	//entity.setPreguntaEquivalenciaOriginal(super.getEntity("",entity.getPreguntaEquivalenciaOriginal(),resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaEquivalenciaOriginal(this.getEntityPreguntaEquivalencia("",entity.getPreguntaEquivalenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePreguntaEquivalencias(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaEquivalencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PreguntaEquivalencia> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaEquivalencia> entities = new  ArrayList<PreguntaEquivalencia>();
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PreguntaEquivalencia> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaEquivalencia> entities = new  ArrayList<PreguntaEquivalencia>();
		PreguntaEquivalencia entity = new PreguntaEquivalencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaEquivalencia();
      	    	entity=super.getEntity("",entity,resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPreguntaEquivalencia("",entity,resultSet);
      	    	
				//entity.setPreguntaEquivalenciaOriginal( new PreguntaEquivalencia());
      	    	//entity.setPreguntaEquivalenciaOriginal(super.getEntity("",entity.getPreguntaEquivalenciaOriginal(),resultSet,PreguntaEquivalenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaEquivalenciaOriginal(this.getEntityPreguntaEquivalencia("",entity.getPreguntaEquivalenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePreguntaEquivalencias(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PreguntaEquivalencia getEntityPreguntaEquivalencia(String strPrefijo,PreguntaEquivalencia entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PreguntaEquivalenciaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PreguntaEquivalenciaConstantesFunciones.IDPERIODO));
				entity.setdescripcion(resultSet.getString(strPrefijo+PreguntaEquivalenciaConstantesFunciones.DESCRIPCION));
				entity.setdesde(resultSet.getDouble(strPrefijo+PreguntaEquivalenciaConstantesFunciones.DESDE));
				entity.sethasta(resultSet.getDouble(strPrefijo+PreguntaEquivalenciaConstantesFunciones.HASTA));
				entity.setorden(resultSet.getInt(strPrefijo+PreguntaEquivalenciaConstantesFunciones.ORDEN));
				entity.setid_anio(resultSet.getLong(strPrefijo+PreguntaEquivalenciaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+PreguntaEquivalenciaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPreguntaEquivalencia(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PreguntaEquivalencia entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PreguntaEquivalenciaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PreguntaEquivalenciaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PreguntaEquivalenciaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PreguntaEquivalenciaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PreguntaEquivalenciaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PreguntaEquivalenciaDataAccess.TABLENAME,PreguntaEquivalenciaDataAccess.ISWITHSTOREPROCEDURES);
			
			PreguntaEquivalenciaDataAccess.setPreguntaEquivalenciaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PreguntaEquivalencia relpreguntaequivalencia)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpreguntaequivalencia.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PreguntaEquivalencia relpreguntaequivalencia)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpreguntaequivalencia.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PreguntaEquivalencia relpreguntaequivalencia)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpreguntaequivalencia.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PreguntaEquivalencia relpreguntaequivalencia)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpreguntaequivalencia.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,PreguntaEquivalencia relpreguntaequivalencia)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relpreguntaequivalencia.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,PreguntaEquivalencia relpreguntaequivalencia)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relpreguntaequivalencia.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PreguntaEquivalencia preguntaequivalencia) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!preguntaequivalencia.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(preguntaequivalencia.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(preguntaequivalencia.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(preguntaequivalencia.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(preguntaequivalencia.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(preguntaequivalencia.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedesde=new ParameterValue<Double>();
					parameterMaintenanceValuedesde.setValue(preguntaequivalencia.getdesde());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedesde);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehasta=new ParameterValue<Double>();
					parameterMaintenanceValuehasta.setValue(preguntaequivalencia.gethasta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehasta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueorden=new ParameterValue<Integer>();
					parameterMaintenanceValueorden.setValue(preguntaequivalencia.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(preguntaequivalencia.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(preguntaequivalencia.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!preguntaequivalencia.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(preguntaequivalencia.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(preguntaequivalencia.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(preguntaequivalencia.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalsePreguntaEquivalencia(PreguntaEquivalencia preguntaequivalencia)throws Exception  {		
		preguntaequivalencia.setIsNew(false);
		preguntaequivalencia.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePreguntaEquivalencias(List<PreguntaEquivalencia> preguntaequivalencias)throws Exception  {				
		for(PreguntaEquivalencia preguntaequivalencia:preguntaequivalencias) {
			preguntaequivalencia.setIsNew(false);
			preguntaequivalencia.setIsChanged(false);
		}
	}
	
	public void generarExportarPreguntaEquivalencia(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
