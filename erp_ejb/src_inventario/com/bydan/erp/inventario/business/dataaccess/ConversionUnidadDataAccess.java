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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//ConversionUnidadConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ConversionUnidadDataAccess extends  ConversionUnidadDataAccessAdditional{ //ConversionUnidadDataAccessAdditional,DataAccessHelper<ConversionUnidad>
	//static Logger logger = Logger.getLogger(ConversionUnidadDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="conversion_unidad";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_unidad_desde,id_unidad_hasta,valor,relacion)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_unidad_desde=?,id_unidad_hasta=?,valor=?,relacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select conversionunidad from "+ConversionUnidadConstantesFunciones.SPERSISTENCENAME+" conversionunidad";
	public static String QUERYSELECTNATIVE="select "+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".id,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".version_row,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".id_empresa,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".id_unidad_desde,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".id_unidad_hasta,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".valor,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".relacion from "+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME;//+" as "+ConversionUnidadConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".id,"+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+".version_row from "+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME;//+" as "+ConversionUnidadConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ConversionUnidadConstantesFunciones.SCHEMA+"."+ConversionUnidadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_unidad_desde=?,id_unidad_hasta=?,valor=?,relacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CONVERSIONUNIDAD_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CONVERSIONUNIDAD_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CONVERSIONUNIDAD_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CONVERSIONUNIDAD_SELECT(?,?)";
	
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
	
	
	protected ConversionUnidadDataAccessAdditional conversionunidadDataAccessAdditional=null;
	
	public ConversionUnidadDataAccessAdditional getConversionUnidadDataAccessAdditional() {
		return this.conversionunidadDataAccessAdditional;
	}
	
	public void setConversionUnidadDataAccessAdditional(ConversionUnidadDataAccessAdditional conversionunidadDataAccessAdditional) {
		try {
			this.conversionunidadDataAccessAdditional=conversionunidadDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ConversionUnidadDataAccess() {
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
		ConversionUnidadDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ConversionUnidadDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ConversionUnidadDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setConversionUnidadOriginal(ConversionUnidad conversionunidad)throws Exception  {
		conversionunidad.setConversionUnidadOriginal((ConversionUnidad)conversionunidad.clone());		
	}
	
	public void setConversionUnidadsOriginal(List<ConversionUnidad> conversionunidads)throws Exception  {
		
		for(ConversionUnidad conversionunidad:conversionunidads){
			conversionunidad.setConversionUnidadOriginal((ConversionUnidad)conversionunidad.clone());
		}
	}
	
	public static void setConversionUnidadOriginalStatic(ConversionUnidad conversionunidad)throws Exception  {
		conversionunidad.setConversionUnidadOriginal((ConversionUnidad)conversionunidad.clone());		
	}
	
	public static void setConversionUnidadsOriginalStatic(List<ConversionUnidad> conversionunidads)throws Exception  {
		
		for(ConversionUnidad conversionunidad:conversionunidads){
			conversionunidad.setConversionUnidadOriginal((ConversionUnidad)conversionunidad.clone());
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
	
	public  ConversionUnidad getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ConversionUnidad entity = new ConversionUnidad();		
		
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
	
	public  ConversionUnidad getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ConversionUnidad entity = new ConversionUnidad();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.ConversionUnidad.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setConversionUnidadOriginal(new ConversionUnidad());
      	    	entity=super.getEntity("",entity,resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityConversionUnidad("",entity,resultSet); 
				
				//entity.setConversionUnidadOriginal(super.getEntity("",entity.getConversionUnidadOriginal(),resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConversionUnidadOriginal(this.getEntityConversionUnidad("",entity.getConversionUnidadOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseConversionUnidad(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ConversionUnidad getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ConversionUnidad entity = new ConversionUnidad();
				
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
	
	public  ConversionUnidad getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ConversionUnidad entity = new ConversionUnidad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConversionUnidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ConversionUnidad.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setConversionUnidadOriginal(new ConversionUnidad());
      	    	entity=super.getEntity("",entity,resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityConversionUnidad("",entity,resultSet);    
				
				//entity.setConversionUnidadOriginal(super.getEntity("",entity.getConversionUnidadOriginal(),resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConversionUnidadOriginal(this.getEntityConversionUnidad("",entity.getConversionUnidadOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseConversionUnidad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ConversionUnidad
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ConversionUnidad entity = new ConversionUnidad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConversionUnidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ConversionUnidad.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseConversionUnidad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ConversionUnidad> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ConversionUnidad> entities = new  ArrayList<ConversionUnidad>();
		ConversionUnidad entity = new ConversionUnidad();		  
		
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
	
	public  List<ConversionUnidad> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ConversionUnidad> entities = new  ArrayList<ConversionUnidad>();
		ConversionUnidad entity = new ConversionUnidad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConversionUnidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConversionUnidad();
      	    	entity=super.getEntity("",entity,resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityConversionUnidad("",entity,resultSet);
      	    	
				//entity.setConversionUnidadOriginal( new ConversionUnidad());
      	    	//entity.setConversionUnidadOriginal(super.getEntity("",entity.getConversionUnidadOriginal(),resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConversionUnidadOriginal(this.getEntityConversionUnidad("",entity.getConversionUnidadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseConversionUnidads(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConversionUnidad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ConversionUnidad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConversionUnidad> entities = new  ArrayList<ConversionUnidad>();
		ConversionUnidad entity = new ConversionUnidad();		  
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
	
	public  List<ConversionUnidad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConversionUnidad> entities = new  ArrayList<ConversionUnidad>();
		ConversionUnidad entity = new ConversionUnidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConversionUnidad();
				
				if(conMapGenerico) {
					entity.inicializarMapConversionUnidad();
					//entity.setMapConversionUnidad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapConversionUnidadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapConversionUnidad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA);         		
					entity=ConversionUnidadDataAccess.getEntityConversionUnidad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setConversionUnidadOriginal( new ConversionUnidad());
					////entity.setConversionUnidadOriginal(super.getEntity("",entity.getConversionUnidadOriginal(),resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA));         		
					////entity.setConversionUnidadOriginal(this.getEntityConversionUnidad("",entity.getConversionUnidadOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseConversionUnidads(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConversionUnidad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ConversionUnidad getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ConversionUnidad entity = new ConversionUnidad();		  
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
	
	public  ConversionUnidad getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ConversionUnidad entity = new ConversionUnidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConversionUnidad();
				
				if(conMapGenerico) {
					entity.inicializarMapConversionUnidad();
					//entity.setMapConversionUnidad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapConversionUnidadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapConversionUnidad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA);         		
					entity=ConversionUnidadDataAccess.getEntityConversionUnidad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setConversionUnidadOriginal( new ConversionUnidad());
					////entity.setConversionUnidadOriginal(super.getEntity("",entity.getConversionUnidadOriginal(),resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA));         		
					////entity.setConversionUnidadOriginal(this.getEntityConversionUnidad("",entity.getConversionUnidadOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseConversionUnidad(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConversionUnidad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ConversionUnidad getEntityConversionUnidad(String strPrefijo,ConversionUnidad entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ConversionUnidad.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ConversionUnidad.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ConversionUnidadDataAccess.setFieldReflectionConversionUnidad(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasConversionUnidad=ConversionUnidadConstantesFunciones.getTodosTiposColumnasConversionUnidad();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasConversionUnidad) {
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
							field = ConversionUnidad.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ConversionUnidad.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ConversionUnidadDataAccess.setFieldReflectionConversionUnidad(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionConversionUnidad(Field field,String strPrefijo,String sColumn,ConversionUnidad entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ConversionUnidadConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConversionUnidadConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConversionUnidadConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConversionUnidadConstantesFunciones.IDUNIDADDESDE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConversionUnidadConstantesFunciones.IDUNIDADHASTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConversionUnidadConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConversionUnidadConstantesFunciones.RELACION:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ConversionUnidad>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ConversionUnidad> entities = new  ArrayList<ConversionUnidad>();
		ConversionUnidad entity = new ConversionUnidad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConversionUnidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ConversionUnidad();
					entity=super.getEntity("",entity,resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityConversionUnidad("",entity,resultSet);
					
					//entity.setConversionUnidadOriginal( new ConversionUnidad());
					//entity.setConversionUnidadOriginal(super.getEntity("",entity.getConversionUnidadOriginal(),resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA));         		
					//entity.setConversionUnidadOriginal(this.getEntityConversionUnidad("",entity.getConversionUnidadOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseConversionUnidads(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConversionUnidad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ConversionUnidad>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ConversionUnidad> entities = new  ArrayList<ConversionUnidad>();
		ConversionUnidad entity = new ConversionUnidad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConversionUnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConversionUnidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ConversionUnidad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConversionUnidad> entities = new  ArrayList<ConversionUnidad>();
		ConversionUnidad entity = new ConversionUnidad();		  
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
	
	public  List<ConversionUnidad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConversionUnidad> entities = new  ArrayList<ConversionUnidad>();
		ConversionUnidad entity = new ConversionUnidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConversionUnidad();
      	    	entity=super.getEntity("",entity,resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityConversionUnidad("",entity,resultSet);
      	    	
				//entity.setConversionUnidadOriginal( new ConversionUnidad());
      	    	//entity.setConversionUnidadOriginal(super.getEntity("",entity.getConversionUnidadOriginal(),resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConversionUnidadOriginal(this.getEntityConversionUnidad("",entity.getConversionUnidadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseConversionUnidads(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConversionUnidad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ConversionUnidad> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConversionUnidad> entities = new  ArrayList<ConversionUnidad>();
		ConversionUnidad entity = new ConversionUnidad();		  
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
	
	public  List<ConversionUnidad> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConversionUnidad> entities = new  ArrayList<ConversionUnidad>();
		ConversionUnidad entity = new ConversionUnidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConversionUnidad();
      	    	entity=super.getEntity("",entity,resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityConversionUnidad("",entity,resultSet);
      	    	
				//entity.setConversionUnidadOriginal( new ConversionUnidad());
      	    	//entity.setConversionUnidadOriginal(super.getEntity("",entity.getConversionUnidadOriginal(),resultSet,ConversionUnidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConversionUnidadOriginal(this.getEntityConversionUnidad("",entity.getConversionUnidadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseConversionUnidads(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ConversionUnidad getEntityConversionUnidad(String strPrefijo,ConversionUnidad entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ConversionUnidadConstantesFunciones.IDEMPRESA));
				entity.setid_unidad_desde(resultSet.getLong(strPrefijo+ConversionUnidadConstantesFunciones.IDUNIDADDESDE));
				entity.setid_unidad_hasta(resultSet.getLong(strPrefijo+ConversionUnidadConstantesFunciones.IDUNIDADHASTA));
				entity.setvalor(resultSet.getDouble(strPrefijo+ConversionUnidadConstantesFunciones.VALOR));
				entity.setrelacion(resultSet.getDouble(strPrefijo+ConversionUnidadConstantesFunciones.RELACION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowConversionUnidad(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ConversionUnidad entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ConversionUnidadDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ConversionUnidadDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ConversionUnidadDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ConversionUnidadDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ConversionUnidadConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ConversionUnidadDataAccess.TABLENAME,ConversionUnidadDataAccess.ISWITHSTOREPROCEDURES);
			
			ConversionUnidadDataAccess.setConversionUnidadOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ConversionUnidad relconversionunidad)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relconversionunidad.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Unidad getUnidadDesde(Connexion connexion,ConversionUnidad relconversionunidad)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relconversionunidad.getid_unidad_desde());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public Unidad getUnidadHasta(Connexion connexion,ConversionUnidad relconversionunidad)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relconversionunidad.getid_unidad_hasta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ConversionUnidad conversionunidad) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!conversionunidad.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(conversionunidad.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad_desde=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad_desde.setValue(conversionunidad.getid_unidad_desde());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad_desde);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad_hasta=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad_hasta.setValue(conversionunidad.getid_unidad_hasta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad_hasta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(conversionunidad.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuerelacion=new ParameterValue<Double>();
					parameterMaintenanceValuerelacion.setValue(conversionunidad.getrelacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerelacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!conversionunidad.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(conversionunidad.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(conversionunidad.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(conversionunidad.getId());
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
	
	public void setIsNewIsChangedFalseConversionUnidad(ConversionUnidad conversionunidad)throws Exception  {		
		conversionunidad.setIsNew(false);
		conversionunidad.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseConversionUnidads(List<ConversionUnidad> conversionunidads)throws Exception  {				
		for(ConversionUnidad conversionunidad:conversionunidads) {
			conversionunidad.setIsNew(false);
			conversionunidad.setIsChanged(false);
		}
	}
	
	public void generarExportarConversionUnidad(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
