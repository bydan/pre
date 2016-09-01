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
import com.bydan.erp.inventario.util.*;//UnidadConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.importaciones.util.*;




@SuppressWarnings("unused")
final public class UnidadDataAccess extends  UnidadDataAccessAdditional{ //UnidadDataAccessAdditional,DataAccessHelper<Unidad>
	//static Logger logger = Logger.getLogger(UnidadDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="unidad";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_unidad,nombre,siglas)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_unidad=?,nombre=?,siglas=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select unidad from "+UnidadConstantesFunciones.SPERSISTENCENAME+" unidad";
	public static String QUERYSELECTNATIVE="select "+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".id,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".version_row,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".id_empresa,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".id_tipo_unidad,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".nombre,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".siglas from "+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME;//+" as "+UnidadConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".id,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".version_row,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".nombre from "+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME;//+" as "+UnidadConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_unidad=?,nombre=?,siglas=?";
	
	public static String STOREPROCEDUREINSERT="call SP_UNIDAD_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_UNIDAD_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_UNIDAD_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_UNIDAD_SELECT(?,?)";
	
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
	
	
	protected UnidadDataAccessAdditional unidadDataAccessAdditional=null;
	
	public UnidadDataAccessAdditional getUnidadDataAccessAdditional() {
		return this.unidadDataAccessAdditional;
	}
	
	public void setUnidadDataAccessAdditional(UnidadDataAccessAdditional unidadDataAccessAdditional) {
		try {
			this.unidadDataAccessAdditional=unidadDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public UnidadDataAccess() {
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
		UnidadDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		UnidadDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		UnidadDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setUnidadOriginal(Unidad unidad)throws Exception  {
		unidad.setUnidadOriginal((Unidad)unidad.clone());		
	}
	
	public void setUnidadsOriginal(List<Unidad> unidads)throws Exception  {
		
		for(Unidad unidad:unidads){
			unidad.setUnidadOriginal((Unidad)unidad.clone());
		}
	}
	
	public static void setUnidadOriginalStatic(Unidad unidad)throws Exception  {
		unidad.setUnidadOriginal((Unidad)unidad.clone());		
	}
	
	public static void setUnidadsOriginalStatic(List<Unidad> unidads)throws Exception  {
		
		for(Unidad unidad:unidads){
			unidad.setUnidadOriginal((Unidad)unidad.clone());
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
	
	public  Unidad getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Unidad entity = new Unidad();		
		
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
	
	public  Unidad getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Unidad entity = new Unidad();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Unidad.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setUnidadOriginal(new Unidad());
      	    	entity=super.getEntity("",entity,resultSet,UnidadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUnidad("",entity,resultSet); 
				
				//entity.setUnidadOriginal(super.getEntity("",entity.getUnidadOriginal(),resultSet,UnidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUnidadOriginal(this.getEntityUnidad("",entity.getUnidadOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseUnidad(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Unidad getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Unidad entity = new Unidad();
				
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
	
	public  Unidad getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Unidad entity = new Unidad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UnidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Unidad.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setUnidadOriginal(new Unidad());
      	    	entity=super.getEntity("",entity,resultSet,UnidadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUnidad("",entity,resultSet);    
				
				//entity.setUnidadOriginal(super.getEntity("",entity.getUnidadOriginal(),resultSet,UnidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUnidadOriginal(this.getEntityUnidad("",entity.getUnidadOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseUnidad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Unidad
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Unidad entity = new Unidad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UnidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Unidad.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseUnidad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Unidad> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Unidad> entities = new  ArrayList<Unidad>();
		Unidad entity = new Unidad();		  
		
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
	
	public  List<Unidad> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Unidad> entities = new  ArrayList<Unidad>();
		Unidad entity = new Unidad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UnidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Unidad();
      	    	entity=super.getEntity("",entity,resultSet,UnidadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUnidad("",entity,resultSet);
      	    	
				//entity.setUnidadOriginal( new Unidad());
      	    	//entity.setUnidadOriginal(super.getEntity("",entity.getUnidadOriginal(),resultSet,UnidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUnidadOriginal(this.getEntityUnidad("",entity.getUnidadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUnidads(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUnidad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Unidad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Unidad> entities = new  ArrayList<Unidad>();
		Unidad entity = new Unidad();		  
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
	
	public  List<Unidad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Unidad> entities = new  ArrayList<Unidad>();
		Unidad entity = new Unidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Unidad();
				
				if(conMapGenerico) {
					entity.inicializarMapUnidad();
					//entity.setMapUnidad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapUnidadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUnidad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UnidadDataAccess.ISWITHSCHEMA);         		
					entity=UnidadDataAccess.getEntityUnidad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUnidadOriginal( new Unidad());
					////entity.setUnidadOriginal(super.getEntity("",entity.getUnidadOriginal(),resultSet,UnidadDataAccess.ISWITHSCHEMA));         		
					////entity.setUnidadOriginal(this.getEntityUnidad("",entity.getUnidadOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUnidads(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUnidad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Unidad getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Unidad entity = new Unidad();		  
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
	
	public  Unidad getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Unidad entity = new Unidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Unidad();
				
				if(conMapGenerico) {
					entity.inicializarMapUnidad();
					//entity.setMapUnidad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapUnidadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUnidad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UnidadDataAccess.ISWITHSCHEMA);         		
					entity=UnidadDataAccess.getEntityUnidad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUnidadOriginal( new Unidad());
					////entity.setUnidadOriginal(super.getEntity("",entity.getUnidadOriginal(),resultSet,UnidadDataAccess.ISWITHSCHEMA));         		
					////entity.setUnidadOriginal(this.getEntityUnidad("",entity.getUnidadOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseUnidad(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUnidad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Unidad getEntityUnidad(String strPrefijo,Unidad entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Unidad.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Unidad.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					UnidadDataAccess.setFieldReflectionUnidad(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasUnidad=UnidadConstantesFunciones.getTodosTiposColumnasUnidad();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasUnidad) {
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
							field = Unidad.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Unidad.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						UnidadDataAccess.setFieldReflectionUnidad(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionUnidad(Field field,String strPrefijo,String sColumn,Unidad entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case UnidadConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UnidadConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UnidadConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UnidadConstantesFunciones.IDTIPOUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UnidadConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UnidadConstantesFunciones.SIGLAS:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Unidad>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Unidad> entities = new  ArrayList<Unidad>();
		Unidad entity = new Unidad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UnidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Unidad();
					entity=super.getEntity("",entity,resultSet,UnidadDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityUnidad("",entity,resultSet);
					
					//entity.setUnidadOriginal( new Unidad());
					//entity.setUnidadOriginal(super.getEntity("",entity.getUnidadOriginal(),resultSet,UnidadDataAccess.ISWITHSCHEMA));         		
					//entity.setUnidadOriginal(this.getEntityUnidad("",entity.getUnidadOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseUnidads(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUnidad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Unidad>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Unidad> entities = new  ArrayList<Unidad>();
		Unidad entity = new Unidad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UnidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UnidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Unidad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Unidad> entities = new  ArrayList<Unidad>();
		Unidad entity = new Unidad();		  
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
	
	public  List<Unidad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Unidad> entities = new  ArrayList<Unidad>();
		Unidad entity = new Unidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Unidad();
      	    	entity=super.getEntity("",entity,resultSet,UnidadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUnidad("",entity,resultSet);
      	    	
				//entity.setUnidadOriginal( new Unidad());
      	    	//entity.setUnidadOriginal(super.getEntity("",entity.getUnidadOriginal(),resultSet,UnidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUnidadOriginal(this.getEntityUnidad("",entity.getUnidadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseUnidads(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUnidad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Unidad> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Unidad> entities = new  ArrayList<Unidad>();
		Unidad entity = new Unidad();		  
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
	
	public  List<Unidad> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Unidad> entities = new  ArrayList<Unidad>();
		Unidad entity = new Unidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Unidad();
      	    	entity=super.getEntity("",entity,resultSet,UnidadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUnidad("",entity,resultSet);
      	    	
				//entity.setUnidadOriginal( new Unidad());
      	    	//entity.setUnidadOriginal(super.getEntity("",entity.getUnidadOriginal(),resultSet,UnidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUnidadOriginal(this.getEntityUnidad("",entity.getUnidadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUnidads(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Unidad getEntityUnidad(String strPrefijo,Unidad entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+UnidadConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_unidad(resultSet.getLong(strPrefijo+UnidadConstantesFunciones.IDTIPOUNIDAD));
				entity.setnombre(resultSet.getString(strPrefijo+UnidadConstantesFunciones.NOMBRE));
				entity.setsiglas(resultSet.getString(strPrefijo+UnidadConstantesFunciones.SIGLAS));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+UnidadConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowUnidad(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Unidad entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=UnidadDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=UnidadDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=UnidadDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=UnidadDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(UnidadConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,UnidadDataAccess.TABLENAME,UnidadDataAccess.ISWITHSTOREPROCEDURES);
			
			UnidadDataAccess.setUnidadOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Unidad relunidad)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relunidad.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoUnidad getTipoUnidad(Connexion connexion,Unidad relunidad)throws SQLException,Exception {

		TipoUnidad tipounidad= new TipoUnidad();

		try {
			TipoUnidadDataAccess tipounidadDataAccess=new TipoUnidadDataAccess();

			tipounidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipounidadDataAccess.setConnexionType(this.connexionType);
			tipounidadDataAccess.setParameterDbType(this.parameterDbType);

			tipounidad=tipounidadDataAccess.getEntity(connexion,relunidad.getid_tipo_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipounidad;

	}


		
		public List<Producto> getProductos(Connexion connexion,Unidad unidad)throws SQLException,Exception {

		List<Producto> productos= new ArrayList<Producto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UnidadConstantesFunciones.SCHEMA+".unidad ON "+ProductoConstantesFunciones.SCHEMA+".producto.id_unidad="+UnidadConstantesFunciones.SCHEMA+".unidad.id WHERE "+UnidadConstantesFunciones.SCHEMA+".unidad.id="+String.valueOf(unidad.getId());
			} else {
				sQuery=" INNER JOIN producto.Unidad WHERE producto.Unidad.id="+String.valueOf(unidad.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productos;

	}

	public List<ConversionInven> getConversionInvenConversions(Connexion connexion,Unidad unidad)throws SQLException,Exception {

		List<ConversionInven> conversioninvenconversions= new ArrayList<ConversionInven>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UnidadConstantesFunciones.SCHEMA+".unidad ON "+ConversionInvenConstantesFunciones.SCHEMA+".conversion_inven.id_unidad="+UnidadConstantesFunciones.SCHEMA+".unidad.id WHERE "+UnidadConstantesFunciones.SCHEMA+".unidad.id="+String.valueOf(unidad.getId());
			} else {
				sQuery=" INNER JOIN conversioninven.UnidadConversion WHERE conversioninven.UnidadConversion.id="+String.valueOf(unidad.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConversionInvenDataAccess conversioninvenDataAccess=new ConversionInvenDataAccess();

			conversioninvenDataAccess.setConnexionType(this.connexionType);
			conversioninvenDataAccess.setParameterDbType(this.parameterDbType);
			conversioninvenconversions=conversioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return conversioninvenconversions;

	}

	public List<RangoUnidadVenta> getRangoUnidadVentas(Connexion connexion,Unidad unidad)throws SQLException,Exception {

		List<RangoUnidadVenta> rangounidadventas= new ArrayList<RangoUnidadVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UnidadConstantesFunciones.SCHEMA+".unidad ON "+RangoUnidadVentaConstantesFunciones.SCHEMA+".rango_unidad_venta.id_unidad="+UnidadConstantesFunciones.SCHEMA+".unidad.id WHERE "+UnidadConstantesFunciones.SCHEMA+".unidad.id="+String.valueOf(unidad.getId());
			} else {
				sQuery=" INNER JOIN rangounidadventa.Unidad WHERE rangounidadventa.Unidad.id="+String.valueOf(unidad.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RangoUnidadVentaDataAccess rangounidadventaDataAccess=new RangoUnidadVentaDataAccess();

			rangounidadventaDataAccess.setConnexionType(this.connexionType);
			rangounidadventaDataAccess.setParameterDbType(this.parameterDbType);
			rangounidadventas=rangounidadventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rangounidadventas;

	}

	public List<ValorPorUnidad> getValorPorUnidads(Connexion connexion,Unidad unidad)throws SQLException,Exception {

		List<ValorPorUnidad> valorporunidads= new ArrayList<ValorPorUnidad>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UnidadConstantesFunciones.SCHEMA+".unidad ON "+ValorPorUnidadConstantesFunciones.SCHEMA+".valor_por_unidad.id_unidad="+UnidadConstantesFunciones.SCHEMA+".unidad.id WHERE "+UnidadConstantesFunciones.SCHEMA+".unidad.id="+String.valueOf(unidad.getId());
			} else {
				sQuery=" INNER JOIN valorporunidad.Unidad WHERE valorporunidad.Unidad.id="+String.valueOf(unidad.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ValorPorUnidadDataAccess valorporunidadDataAccess=new ValorPorUnidadDataAccess();

			valorporunidadDataAccess.setConnexionType(this.connexionType);
			valorporunidadDataAccess.setParameterDbType(this.parameterDbType);
			valorporunidads=valorporunidadDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return valorporunidads;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Unidad unidad) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!unidad.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(unidad.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_unidad.setValue(unidad.getid_tipo_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(unidad.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesiglas=new ParameterValue<String>();
					parameterMaintenanceValuesiglas.setValue(unidad.getsiglas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesiglas);
					parametersTemp.add(parameterMaintenance);
					
						if(!unidad.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(unidad.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(unidad.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(unidad.getId());
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
	
	public void setIsNewIsChangedFalseUnidad(Unidad unidad)throws Exception  {		
		unidad.setIsNew(false);
		unidad.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseUnidads(List<Unidad> unidads)throws Exception  {				
		for(Unidad unidad:unidads) {
			unidad.setIsNew(false);
			unidad.setIsChanged(false);
		}
	}
	
	public void generarExportarUnidad(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
