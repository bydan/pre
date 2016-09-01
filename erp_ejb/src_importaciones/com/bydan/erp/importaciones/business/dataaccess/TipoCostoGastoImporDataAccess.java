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
package com.bydan.erp.importaciones.business.dataaccess;

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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.importaciones.util.*;//TipoCostoGastoImporConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoCostoGastoImporDataAccess extends  DataAccessHelperSinIdGenerated<TipoCostoGastoImpor>{ //TipoCostoGastoImporDataAccessAdditional,DataAccessHelper<TipoCostoGastoImpor>
	//static Logger logger = Logger.getLogger(TipoCostoGastoImporDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_costo_gasto_impor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocostogastoimpor from "+TipoCostoGastoImporConstantesFunciones.SPERSISTENCENAME+" tipocostogastoimpor";
	public static String QUERYSELECTNATIVE="select "+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+".id,"+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+".version_row,"+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+".codigo,"+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+".nombre from "+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME;//+" as "+TipoCostoGastoImporConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+".id,"+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+".version_row,"+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+".codigo from "+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME;//+" as "+TipoCostoGastoImporConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCOSTOGASTOIMPOR_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCOSTOGASTOIMPOR_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCOSTOGASTOIMPOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCOSTOGASTOIMPOR_SELECT(?,?)";
	
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
	
	
	public TipoCostoGastoImporDataAccess() {
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
		TipoCostoGastoImporDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoCostoGastoImporDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoCostoGastoImporDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoCostoGastoImporOriginal(TipoCostoGastoImpor tipocostogastoimpor)throws Exception  {
		tipocostogastoimpor.setTipoCostoGastoImporOriginal((TipoCostoGastoImpor)tipocostogastoimpor.clone());		
	}
	
	public void setTipoCostoGastoImporsOriginal(List<TipoCostoGastoImpor> tipocostogastoimpors)throws Exception  {
		
		for(TipoCostoGastoImpor tipocostogastoimpor:tipocostogastoimpors){
			tipocostogastoimpor.setTipoCostoGastoImporOriginal((TipoCostoGastoImpor)tipocostogastoimpor.clone());
		}
	}
	
	public static void setTipoCostoGastoImporOriginalStatic(TipoCostoGastoImpor tipocostogastoimpor)throws Exception  {
		tipocostogastoimpor.setTipoCostoGastoImporOriginal((TipoCostoGastoImpor)tipocostogastoimpor.clone());		
	}
	
	public static void setTipoCostoGastoImporsOriginalStatic(List<TipoCostoGastoImpor> tipocostogastoimpors)throws Exception  {
		
		for(TipoCostoGastoImpor tipocostogastoimpor:tipocostogastoimpors){
			tipocostogastoimpor.setTipoCostoGastoImporOriginal((TipoCostoGastoImpor)tipocostogastoimpor.clone());
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
	
	public  TipoCostoGastoImpor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		
		
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
	
	public  TipoCostoGastoImpor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Importaciones.TipoCostoGastoImpor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoCostoGastoImporOriginal(new TipoCostoGastoImpor());
      	    	entity=super.getEntity("",entity,resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCostoGastoImpor("",entity,resultSet); 
				
				//entity.setTipoCostoGastoImporOriginal(super.getEntity("",entity.getTipoCostoGastoImporOriginal(),resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCostoGastoImporOriginal(this.getEntityTipoCostoGastoImpor("",entity.getTipoCostoGastoImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCostoGastoImpor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoCostoGastoImpor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();
				
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
	
	public  TipoCostoGastoImpor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCostoGastoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.TipoCostoGastoImpor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoCostoGastoImporOriginal(new TipoCostoGastoImpor());
      	    	entity=super.getEntity("",entity,resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCostoGastoImpor("",entity,resultSet);    
				
				//entity.setTipoCostoGastoImporOriginal(super.getEntity("",entity.getTipoCostoGastoImporOriginal(),resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCostoGastoImporOriginal(this.getEntityTipoCostoGastoImpor("",entity.getTipoCostoGastoImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCostoGastoImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoCostoGastoImpor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCostoGastoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.TipoCostoGastoImpor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoCostoGastoImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoCostoGastoImpor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCostoGastoImpor> entities = new  ArrayList<TipoCostoGastoImpor>();
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		  
		
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
	
	public  List<TipoCostoGastoImpor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCostoGastoImpor> entities = new  ArrayList<TipoCostoGastoImpor>();
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCostoGastoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCostoGastoImpor();
      	    	entity=super.getEntity("",entity,resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCostoGastoImpor("",entity,resultSet);
      	    	
				//entity.setTipoCostoGastoImporOriginal( new TipoCostoGastoImpor());
      	    	//entity.setTipoCostoGastoImporOriginal(super.getEntity("",entity.getTipoCostoGastoImporOriginal(),resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCostoGastoImporOriginal(this.getEntityTipoCostoGastoImpor("",entity.getTipoCostoGastoImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCostoGastoImpors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCostoGastoImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCostoGastoImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCostoGastoImpor> entities = new  ArrayList<TipoCostoGastoImpor>();
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		  
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
	
	public  List<TipoCostoGastoImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCostoGastoImpor> entities = new  ArrayList<TipoCostoGastoImpor>();
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCostoGastoImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCostoGastoImpor();
					//entity.setMapTipoCostoGastoImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoCostoGastoImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCostoGastoImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA);         		
					entity=TipoCostoGastoImporDataAccess.getEntityTipoCostoGastoImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCostoGastoImporOriginal( new TipoCostoGastoImpor());
					////entity.setTipoCostoGastoImporOriginal(super.getEntity("",entity.getTipoCostoGastoImporOriginal(),resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCostoGastoImporOriginal(this.getEntityTipoCostoGastoImpor("",entity.getTipoCostoGastoImporOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCostoGastoImpors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCostoGastoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoCostoGastoImpor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		  
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
	
	public  TipoCostoGastoImpor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCostoGastoImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCostoGastoImpor();
					//entity.setMapTipoCostoGastoImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoCostoGastoImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCostoGastoImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA);         		
					entity=TipoCostoGastoImporDataAccess.getEntityTipoCostoGastoImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCostoGastoImporOriginal( new TipoCostoGastoImpor());
					////entity.setTipoCostoGastoImporOriginal(super.getEntity("",entity.getTipoCostoGastoImporOriginal(),resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCostoGastoImporOriginal(this.getEntityTipoCostoGastoImpor("",entity.getTipoCostoGastoImporOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoCostoGastoImpor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCostoGastoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoCostoGastoImpor getEntityTipoCostoGastoImpor(String strPrefijo,TipoCostoGastoImpor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoCostoGastoImpor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoCostoGastoImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoCostoGastoImporDataAccess.setFieldReflectionTipoCostoGastoImpor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoCostoGastoImpor=TipoCostoGastoImporConstantesFunciones.getTodosTiposColumnasTipoCostoGastoImpor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoCostoGastoImpor) {
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
							field = TipoCostoGastoImpor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoCostoGastoImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoCostoGastoImporDataAccess.setFieldReflectionTipoCostoGastoImpor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoCostoGastoImpor(Field field,String strPrefijo,String sColumn,TipoCostoGastoImpor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoCostoGastoImporConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCostoGastoImporConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCostoGastoImporConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCostoGastoImporConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCostoGastoImpor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoCostoGastoImpor> entities = new  ArrayList<TipoCostoGastoImpor>();
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCostoGastoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoCostoGastoImpor();
					entity=super.getEntity("",entity,resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoCostoGastoImpor("",entity,resultSet);
					
					//entity.setTipoCostoGastoImporOriginal( new TipoCostoGastoImpor());
					//entity.setTipoCostoGastoImporOriginal(super.getEntity("",entity.getTipoCostoGastoImporOriginal(),resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoCostoGastoImporOriginal(this.getEntityTipoCostoGastoImpor("",entity.getTipoCostoGastoImporOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoCostoGastoImpors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCostoGastoImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCostoGastoImpor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoCostoGastoImpor> entities = new  ArrayList<TipoCostoGastoImpor>();
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCostoGastoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoCostoGastoImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCostoGastoImpor> entities = new  ArrayList<TipoCostoGastoImpor>();
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		  
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
	
	public  List<TipoCostoGastoImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCostoGastoImpor> entities = new  ArrayList<TipoCostoGastoImpor>();
		TipoCostoGastoImpor entity = new TipoCostoGastoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCostoGastoImpor();
      	    	entity=super.getEntity("",entity,resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCostoGastoImpor("",entity,resultSet);
      	    	
				//entity.setTipoCostoGastoImporOriginal( new TipoCostoGastoImpor());
      	    	//entity.setTipoCostoGastoImporOriginal(super.getEntity("",entity.getTipoCostoGastoImporOriginal(),resultSet,TipoCostoGastoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCostoGastoImporOriginal(this.getEntityTipoCostoGastoImpor("",entity.getTipoCostoGastoImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoCostoGastoImpors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCostoGastoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoCostoGastoImpor getEntityTipoCostoGastoImpor(String strPrefijo,TipoCostoGastoImpor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCostoGastoImporConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoCostoGastoImporConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCostoGastoImporConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoCostoGastoImpor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoCostoGastoImpor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoCostoGastoImporDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoCostoGastoImporDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoCostoGastoImporDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoCostoGastoImporDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoCostoGastoImporConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoCostoGastoImporDataAccess.TABLENAME,TipoCostoGastoImporDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoCostoGastoImporDataAccess.setTipoCostoGastoImporOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<CostoGastoImpor> getCostoGastoImpors(Connexion connexion,TipoCostoGastoImpor tipocostogastoimpor)throws SQLException,Exception {

		List<CostoGastoImpor> costogastoimpors= new ArrayList<CostoGastoImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCostoGastoImporConstantesFunciones.SCHEMA+".tipo_costo_gasto_impor ON "+CostoGastoImporConstantesFunciones.SCHEMA+".costo_gasto_impor.id_tipo_costo_gasto_impor="+TipoCostoGastoImporConstantesFunciones.SCHEMA+".tipo_costo_gasto_impor.id WHERE "+TipoCostoGastoImporConstantesFunciones.SCHEMA+".tipo_costo_gasto_impor.id="+String.valueOf(tipocostogastoimpor.getId());
			} else {
				sQuery=" INNER JOIN costogastoimpor.TipoCostoGastoImpor WHERE costogastoimpor.TipoCostoGastoImpor.id="+String.valueOf(tipocostogastoimpor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CostoGastoImporDataAccess costogastoimporDataAccess=new CostoGastoImporDataAccess();

			costogastoimporDataAccess.setConnexionType(this.connexionType);
			costogastoimporDataAccess.setParameterDbType(this.parameterDbType);
			costogastoimpors=costogastoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return costogastoimpors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoCostoGastoImpor tipocostogastoimpor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocostogastoimpor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipocostogastoimpor.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipocostogastoimpor.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipocostogastoimpor.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocostogastoimpor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocostogastoimpor.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocostogastoimpor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocostogastoimpor.getId());
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
	
	public void setIsNewIsChangedFalseTipoCostoGastoImpor(TipoCostoGastoImpor tipocostogastoimpor)throws Exception  {		
		tipocostogastoimpor.setIsNew(false);
		tipocostogastoimpor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoCostoGastoImpors(List<TipoCostoGastoImpor> tipocostogastoimpors)throws Exception  {				
		for(TipoCostoGastoImpor tipocostogastoimpor:tipocostogastoimpors) {
			tipocostogastoimpor.setIsNew(false);
			tipocostogastoimpor.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoCostoGastoImpor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
