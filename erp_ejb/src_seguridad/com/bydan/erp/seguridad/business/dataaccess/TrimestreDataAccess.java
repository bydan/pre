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
package com.bydan.erp.seguridad.business.dataaccess;

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

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.*;//TrimestreConstantesFunciones;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TrimestreDataAccess extends  DataAccessHelperSinIdGenerated<Trimestre>{ //TrimestreDataAccessAdditional,DataAccessHelper<Trimestre>
	//static Logger logger = Logger.getLogger(TrimestreDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="trimestre";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select trimestre from "+TrimestreConstantesFunciones.SPERSISTENCENAME+" trimestre";
	public static String QUERYSELECTNATIVE="select "+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+".id,"+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+".version_row,"+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+".nombre from "+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME;//+" as "+TrimestreConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+".id,"+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+".version_row,"+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+".nombre from "+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME;//+" as "+TrimestreConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TrimestreConstantesFunciones.SCHEMA+"."+TrimestreConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TRIMESTRE_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TRIMESTRE_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TRIMESTRE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TRIMESTRE_SELECT(?,?)";
	
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
	
	
	public TrimestreDataAccess() {
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
		TrimestreDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TrimestreDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TrimestreDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTrimestreOriginal(Trimestre trimestre)throws Exception  {
		trimestre.setTrimestreOriginal((Trimestre)trimestre.clone());		
	}
	
	public void setTrimestresOriginal(List<Trimestre> trimestres)throws Exception  {
		
		for(Trimestre trimestre:trimestres){
			trimestre.setTrimestreOriginal((Trimestre)trimestre.clone());
		}
	}
	
	public static void setTrimestreOriginalStatic(Trimestre trimestre)throws Exception  {
		trimestre.setTrimestreOriginal((Trimestre)trimestre.clone());		
	}
	
	public static void setTrimestresOriginalStatic(List<Trimestre> trimestres)throws Exception  {
		
		for(Trimestre trimestre:trimestres){
			trimestre.setTrimestreOriginal((Trimestre)trimestre.clone());
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
	
	public  Trimestre getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Trimestre entity = new Trimestre();		
		
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
	
	public  Trimestre getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Trimestre entity = new Trimestre();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.Trimestre.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTrimestreOriginal(new Trimestre());
      	    	entity=super.getEntity("",entity,resultSet,TrimestreDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTrimestre("",entity,resultSet); 
				
				//entity.setTrimestreOriginal(super.getEntity("",entity.getTrimestreOriginal(),resultSet,TrimestreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTrimestreOriginal(this.getEntityTrimestre("",entity.getTrimestreOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTrimestre(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Trimestre getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Trimestre entity = new Trimestre();
				
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
	
	public  Trimestre getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Trimestre entity = new Trimestre();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TrimestreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Trimestre.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTrimestreOriginal(new Trimestre());
      	    	entity=super.getEntity("",entity,resultSet,TrimestreDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTrimestre("",entity,resultSet);    
				
				//entity.setTrimestreOriginal(super.getEntity("",entity.getTrimestreOriginal(),resultSet,TrimestreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTrimestreOriginal(this.getEntityTrimestre("",entity.getTrimestreOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTrimestre(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Trimestre
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Trimestre entity = new Trimestre();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TrimestreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Trimestre.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTrimestre(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Trimestre> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Trimestre> entities = new  ArrayList<Trimestre>();
		Trimestre entity = new Trimestre();		  
		
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
	
	public  List<Trimestre> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Trimestre> entities = new  ArrayList<Trimestre>();
		Trimestre entity = new Trimestre();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TrimestreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Trimestre();
      	    	entity=super.getEntity("",entity,resultSet,TrimestreDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTrimestre("",entity,resultSet);
      	    	
				//entity.setTrimestreOriginal( new Trimestre());
      	    	//entity.setTrimestreOriginal(super.getEntity("",entity.getTrimestreOriginal(),resultSet,TrimestreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTrimestreOriginal(this.getEntityTrimestre("",entity.getTrimestreOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTrimestres(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTrimestre(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Trimestre> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Trimestre> entities = new  ArrayList<Trimestre>();
		Trimestre entity = new Trimestre();		  
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
	
	public  List<Trimestre> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Trimestre> entities = new  ArrayList<Trimestre>();
		Trimestre entity = new Trimestre();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Trimestre();
				
				if(conMapGenerico) {
					entity.inicializarMapTrimestre();
					//entity.setMapTrimestre(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTrimestreValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTrimestre().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TrimestreDataAccess.ISWITHSCHEMA);         		
					entity=TrimestreDataAccess.getEntityTrimestre("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTrimestreOriginal( new Trimestre());
					////entity.setTrimestreOriginal(super.getEntity("",entity.getTrimestreOriginal(),resultSet,TrimestreDataAccess.ISWITHSCHEMA));         		
					////entity.setTrimestreOriginal(this.getEntityTrimestre("",entity.getTrimestreOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTrimestres(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTrimestre(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Trimestre getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Trimestre entity = new Trimestre();		  
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
	
	public  Trimestre getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Trimestre entity = new Trimestre();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Trimestre();
				
				if(conMapGenerico) {
					entity.inicializarMapTrimestre();
					//entity.setMapTrimestre(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTrimestreValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTrimestre().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TrimestreDataAccess.ISWITHSCHEMA);         		
					entity=TrimestreDataAccess.getEntityTrimestre("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTrimestreOriginal( new Trimestre());
					////entity.setTrimestreOriginal(super.getEntity("",entity.getTrimestreOriginal(),resultSet,TrimestreDataAccess.ISWITHSCHEMA));         		
					////entity.setTrimestreOriginal(this.getEntityTrimestre("",entity.getTrimestreOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTrimestre(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTrimestre(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Trimestre getEntityTrimestre(String strPrefijo,Trimestre entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Trimestre.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Trimestre.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TrimestreDataAccess.setFieldReflectionTrimestre(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTrimestre=TrimestreConstantesFunciones.getTodosTiposColumnasTrimestre();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTrimestre) {
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
							field = Trimestre.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Trimestre.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TrimestreDataAccess.setFieldReflectionTrimestre(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTrimestre(Field field,String strPrefijo,String sColumn,Trimestre entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TrimestreConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TrimestreConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TrimestreConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Trimestre>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Trimestre> entities = new  ArrayList<Trimestre>();
		Trimestre entity = new Trimestre();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TrimestreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Trimestre();
					entity=super.getEntity("",entity,resultSet,TrimestreDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTrimestre("",entity,resultSet);
					
					//entity.setTrimestreOriginal( new Trimestre());
					//entity.setTrimestreOriginal(super.getEntity("",entity.getTrimestreOriginal(),resultSet,TrimestreDataAccess.ISWITHSCHEMA));         		
					//entity.setTrimestreOriginal(this.getEntityTrimestre("",entity.getTrimestreOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTrimestres(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTrimestre(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Trimestre>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Trimestre> entities = new  ArrayList<Trimestre>();
		Trimestre entity = new Trimestre();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TrimestreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TrimestreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Trimestre> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Trimestre> entities = new  ArrayList<Trimestre>();
		Trimestre entity = new Trimestre();		  
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
	
	public  List<Trimestre> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Trimestre> entities = new  ArrayList<Trimestre>();
		Trimestre entity = new Trimestre();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Trimestre();
      	    	entity=super.getEntity("",entity,resultSet,TrimestreDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTrimestre("",entity,resultSet);
      	    	
				//entity.setTrimestreOriginal( new Trimestre());
      	    	//entity.setTrimestreOriginal(super.getEntity("",entity.getTrimestreOriginal(),resultSet,TrimestreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTrimestreOriginal(this.getEntityTrimestre("",entity.getTrimestreOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTrimestres(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTrimestre(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public Trimestre getEntityTrimestre(String strPrefijo,Trimestre entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TrimestreConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TrimestreConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTrimestre(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Trimestre entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TrimestreDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TrimestreDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TrimestreDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TrimestreDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TrimestreConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TrimestreDataAccess.TABLENAME,TrimestreDataAccess.ISWITHSTOREPROCEDURES);
			
			TrimestreDataAccess.setTrimestreOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<EvaluacionEmpleado> getEvaluacionEmpleados(Connexion connexion,Trimestre trimestre)throws SQLException,Exception {

		List<EvaluacionEmpleado> evaluacionempleados= new ArrayList<EvaluacionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TrimestreConstantesFunciones.SCHEMA+".trimestre ON "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+".evaluacion_empleado.id_trimestre="+TrimestreConstantesFunciones.SCHEMA+".trimestre.id WHERE "+TrimestreConstantesFunciones.SCHEMA+".trimestre.id="+String.valueOf(trimestre.getId());
			} else {
				sQuery=" INNER JOIN evaluacionempleado.Trimestre WHERE evaluacionempleado.Trimestre.id="+String.valueOf(trimestre.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EvaluacionEmpleadoDataAccess evaluacionempleadoDataAccess=new EvaluacionEmpleadoDataAccess();

			evaluacionempleadoDataAccess.setConnexionType(this.connexionType);
			evaluacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return evaluacionempleados;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Trimestre trimestre) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!trimestre.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(trimestre.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(trimestre.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!trimestre.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(trimestre.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(trimestre.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(trimestre.getId());
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
	
	public void setIsNewIsChangedFalseTrimestre(Trimestre trimestre)throws Exception  {		
		trimestre.setIsNew(false);
		trimestre.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTrimestres(List<Trimestre> trimestres)throws Exception  {				
		for(Trimestre trimestre:trimestres) {
			trimestre.setIsNew(false);
			trimestre.setIsChanged(false);
		}
	}
	
	public void generarExportarTrimestre(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   