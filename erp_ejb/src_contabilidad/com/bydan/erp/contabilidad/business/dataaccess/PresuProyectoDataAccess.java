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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//PresuProyectoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class PresuProyectoDataAccess extends  PresuProyectoDataAccessAdditional{ //PresuProyectoDataAccessAdditional,DataAccessHelper<PresuProyecto>
	//static Logger logger = Logger.getLogger(PresuProyectoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="presu_proyecto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,codigo,nombre,id_presu_tipo_proyecto,id_centro_costo,fecha,valor,id_presu_estado,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,codigo=?,nombre=?,id_presu_tipo_proyecto=?,id_centro_costo=?,fecha=?,valor=?,id_presu_estado=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select presuproyecto from "+PresuProyectoConstantesFunciones.SPERSISTENCENAME+" presuproyecto";
	public static String QUERYSELECTNATIVE="select "+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".version_row,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_empresa,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_sucursal,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_ejercicio,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".codigo,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".nombre,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_presu_tipo_proyecto,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_centro_costo,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".fecha,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".valor,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_presu_estado,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".descripcion from "+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME;//+" as "+PresuProyectoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".version_row,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".codigo from "+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME;//+" as "+PresuProyectoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,codigo=?,nombre=?,id_presu_tipo_proyecto=?,id_centro_costo=?,fecha=?,valor=?,id_presu_estado=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRESUPROYECTO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRESUPROYECTO_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRESUPROYECTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRESUPROYECTO_SELECT(?,?)";
	
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
	
	
	protected PresuProyectoDataAccessAdditional presuproyectoDataAccessAdditional=null;
	
	public PresuProyectoDataAccessAdditional getPresuProyectoDataAccessAdditional() {
		return this.presuproyectoDataAccessAdditional;
	}
	
	public void setPresuProyectoDataAccessAdditional(PresuProyectoDataAccessAdditional presuproyectoDataAccessAdditional) {
		try {
			this.presuproyectoDataAccessAdditional=presuproyectoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PresuProyectoDataAccess() {
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
		PresuProyectoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PresuProyectoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PresuProyectoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPresuProyectoOriginal(PresuProyecto presuproyecto)throws Exception  {
		presuproyecto.setPresuProyectoOriginal((PresuProyecto)presuproyecto.clone());		
	}
	
	public void setPresuProyectosOriginal(List<PresuProyecto> presuproyectos)throws Exception  {
		
		for(PresuProyecto presuproyecto:presuproyectos){
			presuproyecto.setPresuProyectoOriginal((PresuProyecto)presuproyecto.clone());
		}
	}
	
	public static void setPresuProyectoOriginalStatic(PresuProyecto presuproyecto)throws Exception  {
		presuproyecto.setPresuProyectoOriginal((PresuProyecto)presuproyecto.clone());		
	}
	
	public static void setPresuProyectosOriginalStatic(List<PresuProyecto> presuproyectos)throws Exception  {
		
		for(PresuProyecto presuproyecto:presuproyectos){
			presuproyecto.setPresuProyectoOriginal((PresuProyecto)presuproyecto.clone());
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
	
	public  PresuProyecto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PresuProyecto entity = new PresuProyecto();		
		
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
	
	public  PresuProyecto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PresuProyecto entity = new PresuProyecto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.PresuProyecto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPresuProyectoOriginal(new PresuProyecto());
      	    	entity=super.getEntity("",entity,resultSet,PresuProyectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresuProyecto("",entity,resultSet); 
				
				//entity.setPresuProyectoOriginal(super.getEntity("",entity.getPresuProyectoOriginal(),resultSet,PresuProyectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuProyectoOriginal(this.getEntityPresuProyecto("",entity.getPresuProyectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePresuProyecto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PresuProyecto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresuProyecto entity = new PresuProyecto();
				
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
	
	public  PresuProyecto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresuProyecto entity = new PresuProyecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuProyectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresuProyecto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPresuProyectoOriginal(new PresuProyecto());
      	    	entity=super.getEntity("",entity,resultSet,PresuProyectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresuProyecto("",entity,resultSet);    
				
				//entity.setPresuProyectoOriginal(super.getEntity("",entity.getPresuProyectoOriginal(),resultSet,PresuProyectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuProyectoOriginal(this.getEntityPresuProyecto("",entity.getPresuProyectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePresuProyecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PresuProyecto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PresuProyecto entity = new PresuProyecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuProyectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresuProyecto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePresuProyecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PresuProyecto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresuProyecto> entities = new  ArrayList<PresuProyecto>();
		PresuProyecto entity = new PresuProyecto();		  
		
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
	
	public  List<PresuProyecto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresuProyecto> entities = new  ArrayList<PresuProyecto>();
		PresuProyecto entity = new PresuProyecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuProyectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuProyecto();
      	    	entity=super.getEntity("",entity,resultSet,PresuProyectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuProyecto("",entity,resultSet);
      	    	
				//entity.setPresuProyectoOriginal( new PresuProyecto());
      	    	//entity.setPresuProyectoOriginal(super.getEntity("",entity.getPresuProyectoOriginal(),resultSet,PresuProyectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuProyectoOriginal(this.getEntityPresuProyecto("",entity.getPresuProyectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuProyectos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuProyecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresuProyecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresuProyecto> entities = new  ArrayList<PresuProyecto>();
		PresuProyecto entity = new PresuProyecto();		  
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
	
	public  List<PresuProyecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresuProyecto> entities = new  ArrayList<PresuProyecto>();
		PresuProyecto entity = new PresuProyecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuProyecto();
				
				if(conMapGenerico) {
					entity.inicializarMapPresuProyecto();
					//entity.setMapPresuProyecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPresuProyectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresuProyecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresuProyectoDataAccess.ISWITHSCHEMA);         		
					entity=PresuProyectoDataAccess.getEntityPresuProyecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresuProyectoOriginal( new PresuProyecto());
					////entity.setPresuProyectoOriginal(super.getEntity("",entity.getPresuProyectoOriginal(),resultSet,PresuProyectoDataAccess.ISWITHSCHEMA));         		
					////entity.setPresuProyectoOriginal(this.getEntityPresuProyecto("",entity.getPresuProyectoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuProyectos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuProyecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PresuProyecto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresuProyecto entity = new PresuProyecto();		  
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
	
	public  PresuProyecto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresuProyecto entity = new PresuProyecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuProyecto();
				
				if(conMapGenerico) {
					entity.inicializarMapPresuProyecto();
					//entity.setMapPresuProyecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPresuProyectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresuProyecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresuProyectoDataAccess.ISWITHSCHEMA);         		
					entity=PresuProyectoDataAccess.getEntityPresuProyecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresuProyectoOriginal( new PresuProyecto());
					////entity.setPresuProyectoOriginal(super.getEntity("",entity.getPresuProyectoOriginal(),resultSet,PresuProyectoDataAccess.ISWITHSCHEMA));         		
					////entity.setPresuProyectoOriginal(this.getEntityPresuProyecto("",entity.getPresuProyectoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePresuProyecto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuProyecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PresuProyecto getEntityPresuProyecto(String strPrefijo,PresuProyecto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PresuProyecto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PresuProyecto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PresuProyectoDataAccess.setFieldReflectionPresuProyecto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPresuProyecto=PresuProyectoConstantesFunciones.getTodosTiposColumnasPresuProyecto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPresuProyecto) {
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
							field = PresuProyecto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PresuProyecto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PresuProyectoDataAccess.setFieldReflectionPresuProyecto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPresuProyecto(Field field,String strPrefijo,String sColumn,PresuProyecto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PresuProyectoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresuProyectoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresuProyectoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PresuProyectoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresuProyectoConstantesFunciones.IDPRESUESTADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresuProyecto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PresuProyecto> entities = new  ArrayList<PresuProyecto>();
		PresuProyecto entity = new PresuProyecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuProyectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PresuProyecto();
					entity=super.getEntity("",entity,resultSet,PresuProyectoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPresuProyecto("",entity,resultSet);
					
					//entity.setPresuProyectoOriginal( new PresuProyecto());
					//entity.setPresuProyectoOriginal(super.getEntity("",entity.getPresuProyectoOriginal(),resultSet,PresuProyectoDataAccess.ISWITHSCHEMA));         		
					//entity.setPresuProyectoOriginal(this.getEntityPresuProyecto("",entity.getPresuProyectoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePresuProyectos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuProyecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresuProyecto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PresuProyecto> entities = new  ArrayList<PresuProyecto>();
		PresuProyecto entity = new PresuProyecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuProyectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PresuProyecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuProyecto> entities = new  ArrayList<PresuProyecto>();
		PresuProyecto entity = new PresuProyecto();		  
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
	
	public  List<PresuProyecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuProyecto> entities = new  ArrayList<PresuProyecto>();
		PresuProyecto entity = new PresuProyecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuProyecto();
      	    	entity=super.getEntity("",entity,resultSet,PresuProyectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuProyecto("",entity,resultSet);
      	    	
				//entity.setPresuProyectoOriginal( new PresuProyecto());
      	    	//entity.setPresuProyectoOriginal(super.getEntity("",entity.getPresuProyectoOriginal(),resultSet,PresuProyectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuProyectoOriginal(this.getEntityPresuProyecto("",entity.getPresuProyectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePresuProyectos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuProyecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresuProyecto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuProyecto> entities = new  ArrayList<PresuProyecto>();
		PresuProyecto entity = new PresuProyecto();		  
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
	
	public  List<PresuProyecto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuProyecto> entities = new  ArrayList<PresuProyecto>();
		PresuProyecto entity = new PresuProyecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuProyecto();
      	    	entity=super.getEntity("",entity,resultSet,PresuProyectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuProyecto("",entity,resultSet);
      	    	
				//entity.setPresuProyectoOriginal( new PresuProyecto());
      	    	//entity.setPresuProyectoOriginal(super.getEntity("",entity.getPresuProyectoOriginal(),resultSet,PresuProyectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuProyectoOriginal(this.getEntityPresuProyecto("",entity.getPresuProyectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuProyectos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PresuProyecto getEntityPresuProyecto(String strPrefijo,PresuProyecto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PresuProyectoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PresuProyectoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PresuProyectoConstantesFunciones.IDEJERCICIO));
				entity.setcodigo(resultSet.getString(strPrefijo+PresuProyectoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+PresuProyectoConstantesFunciones.NOMBRE));
				entity.setid_presu_tipo_proyecto(resultSet.getLong(strPrefijo+PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+PresuProyectoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PresuProyectoConstantesFunciones.FECHA).getTime()));
				entity.setvalor(resultSet.getDouble(strPrefijo+PresuProyectoConstantesFunciones.VALOR));
				entity.setid_presu_estado(resultSet.getLong(strPrefijo+PresuProyectoConstantesFunciones.IDPRESUESTADO));
				entity.setdescripcion(resultSet.getString(strPrefijo+PresuProyectoConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+PresuProyectoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPresuProyecto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PresuProyecto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PresuProyectoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PresuProyectoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PresuProyectoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PresuProyectoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PresuProyectoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PresuProyectoDataAccess.TABLENAME,PresuProyectoDataAccess.ISWITHSTOREPROCEDURES);
			
			PresuProyectoDataAccess.setPresuProyectoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PresuProyecto relpresuproyecto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpresuproyecto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PresuProyecto relpresuproyecto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpresuproyecto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PresuProyecto relpresuproyecto)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpresuproyecto.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public PresuTipoProyecto getPresuTipoProyecto(Connexion connexion,PresuProyecto relpresuproyecto)throws SQLException,Exception {

		PresuTipoProyecto presutipoproyecto= new PresuTipoProyecto();

		try {
			PresuTipoProyectoDataAccess presutipoproyectoDataAccess=new PresuTipoProyectoDataAccess();

			presutipoproyectoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			presutipoproyectoDataAccess.setConnexionType(this.connexionType);
			presutipoproyectoDataAccess.setParameterDbType(this.parameterDbType);

			presutipoproyecto=presutipoproyectoDataAccess.getEntity(connexion,relpresuproyecto.getid_presu_tipo_proyecto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presutipoproyecto;

	}

	public CentroCosto getCentroCosto(Connexion connexion,PresuProyecto relpresuproyecto)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relpresuproyecto.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public PresuEstado getPresuEstado(Connexion connexion,PresuProyecto relpresuproyecto)throws SQLException,Exception {

		PresuEstado presuestado= new PresuEstado();

		try {
			PresuEstadoDataAccess presuestadoDataAccess=new PresuEstadoDataAccess();

			presuestadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			presuestadoDataAccess.setConnexionType(this.connexionType);
			presuestadoDataAccess.setParameterDbType(this.parameterDbType);

			presuestado=presuestadoDataAccess.getEntity(connexion,relpresuproyecto.getid_presu_estado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presuestado;

	}


		
		public List<PresuTransferencia> getPresuTransferencias(Connexion connexion,PresuProyecto presuproyecto)throws SQLException,Exception {

		List<PresuTransferencia> presutransferencias= new ArrayList<PresuTransferencia>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PresuProyectoConstantesFunciones.SCHEMA+".presu_proyecto ON "+PresuTransferenciaConstantesFunciones.SCHEMA+".presu_transferencia.id_presu_proyecto="+PresuProyectoConstantesFunciones.SCHEMA+".presu_proyecto.id WHERE "+PresuProyectoConstantesFunciones.SCHEMA+".presu_proyecto.id="+String.valueOf(presuproyecto.getId());
			} else {
				sQuery=" INNER JOIN presutransferencia.PresuProyecto WHERE presutransferencia.PresuProyecto.id="+String.valueOf(presuproyecto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresuTransferenciaDataAccess presutransferenciaDataAccess=new PresuTransferenciaDataAccess();

			presutransferenciaDataAccess.setConnexionType(this.connexionType);
			presutransferenciaDataAccess.setParameterDbType(this.parameterDbType);
			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presutransferencias;

	}

	public List<PresuProyectoCuenta> getPresuProyectoCuentas(Connexion connexion,PresuProyecto presuproyecto)throws SQLException,Exception {

		List<PresuProyectoCuenta> presuproyectocuentas= new ArrayList<PresuProyectoCuenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PresuProyectoConstantesFunciones.SCHEMA+".presu_proyecto ON "+PresuProyectoCuentaConstantesFunciones.SCHEMA+".presu_proyecto_cuenta.id_presu_proyecto="+PresuProyectoConstantesFunciones.SCHEMA+".presu_proyecto.id WHERE "+PresuProyectoConstantesFunciones.SCHEMA+".presu_proyecto.id="+String.valueOf(presuproyecto.getId());
			} else {
				sQuery=" INNER JOIN presuproyectocuenta.PresuProyecto WHERE presuproyectocuenta.PresuProyecto.id="+String.valueOf(presuproyecto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresuProyectoCuentaDataAccess presuproyectocuentaDataAccess=new PresuProyectoCuentaDataAccess();

			presuproyectocuentaDataAccess.setConnexionType(this.connexionType);
			presuproyectocuentaDataAccess.setParameterDbType(this.parameterDbType);
			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presuproyectocuentas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PresuProyecto presuproyecto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!presuproyecto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(presuproyecto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(presuproyecto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(presuproyecto.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(presuproyecto.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(presuproyecto.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_presu_tipo_proyecto=new ParameterValue<Long>();
					parameterMaintenanceValueid_presu_tipo_proyecto.setValue(presuproyecto.getid_presu_tipo_proyecto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_presu_tipo_proyecto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(presuproyecto.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(presuproyecto.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(presuproyecto.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_presu_estado=new ParameterValue<Long>();
					parameterMaintenanceValueid_presu_estado.setValue(presuproyecto.getid_presu_estado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_presu_estado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(presuproyecto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!presuproyecto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(presuproyecto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(presuproyecto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(presuproyecto.getId());
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
	
	public void setIsNewIsChangedFalsePresuProyecto(PresuProyecto presuproyecto)throws Exception  {		
		presuproyecto.setIsNew(false);
		presuproyecto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePresuProyectos(List<PresuProyecto> presuproyectos)throws Exception  {				
		for(PresuProyecto presuproyecto:presuproyectos) {
			presuproyecto.setIsNew(false);
			presuproyecto.setIsChanged(false);
		}
	}
	
	public void generarExportarPresuProyecto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
