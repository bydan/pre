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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//TipoRadioVenciConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoRadioVenciDataAccess extends  DataAccessHelperSinIdGenerated<TipoRadioVenci>{ //TipoRadioVenciDataAccessAdditional,DataAccessHelper<TipoRadioVenci>
	//static Logger logger = Logger.getLogger(TipoRadioVenciDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_radio_venci";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tiporadiovenci from "+TipoRadioVenciConstantesFunciones.SPERSISTENCENAME+" tiporadiovenci";
	public static String QUERYSELECTNATIVE="select "+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+".id,"+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+".version_row,"+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+".nombre from "+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME;//+" as "+TipoRadioVenciConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+".id,"+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+".version_row,"+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+".nombre from "+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME;//+" as "+TipoRadioVenciConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoRadioVenciConstantesFunciones.SCHEMA+"."+TipoRadioVenciConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPORADIOVENCI_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPORADIOVENCI_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPORADIOVENCI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPORADIOVENCI_SELECT(?,?)";
	
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
	
	
	public TipoRadioVenciDataAccess() {
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
		TipoRadioVenciDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoRadioVenciDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoRadioVenciDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoRadioVenciOriginal(TipoRadioVenci tiporadiovenci)throws Exception  {
		tiporadiovenci.setTipoRadioVenciOriginal((TipoRadioVenci)tiporadiovenci.clone());		
	}
	
	public void setTipoRadioVencisOriginal(List<TipoRadioVenci> tiporadiovencis)throws Exception  {
		
		for(TipoRadioVenci tiporadiovenci:tiporadiovencis){
			tiporadiovenci.setTipoRadioVenciOriginal((TipoRadioVenci)tiporadiovenci.clone());
		}
	}
	
	public static void setTipoRadioVenciOriginalStatic(TipoRadioVenci tiporadiovenci)throws Exception  {
		tiporadiovenci.setTipoRadioVenciOriginal((TipoRadioVenci)tiporadiovenci.clone());		
	}
	
	public static void setTipoRadioVencisOriginalStatic(List<TipoRadioVenci> tiporadiovencis)throws Exception  {
		
		for(TipoRadioVenci tiporadiovenci:tiporadiovencis){
			tiporadiovenci.setTipoRadioVenciOriginal((TipoRadioVenci)tiporadiovenci.clone());
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
	
	public  TipoRadioVenci getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRadioVenci entity = new TipoRadioVenci();		
		
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
	
	public  TipoRadioVenci getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRadioVenci entity = new TipoRadioVenci();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.TipoRadioVenci.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoRadioVenciOriginal(new TipoRadioVenci());
      	    	entity=super.getEntity("",entity,resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRadioVenci("",entity,resultSet); 
				
				//entity.setTipoRadioVenciOriginal(super.getEntity("",entity.getTipoRadioVenciOriginal(),resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRadioVenciOriginal(this.getEntityTipoRadioVenci("",entity.getTipoRadioVenciOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRadioVenci(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoRadioVenci getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRadioVenci entity = new TipoRadioVenci();
				
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
	
	public  TipoRadioVenci getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRadioVenci entity = new TipoRadioVenci();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRadioVenciDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoRadioVenci.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoRadioVenciOriginal(new TipoRadioVenci());
      	    	entity=super.getEntity("",entity,resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRadioVenci("",entity,resultSet);    
				
				//entity.setTipoRadioVenciOriginal(super.getEntity("",entity.getTipoRadioVenciOriginal(),resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRadioVenciOriginal(this.getEntityTipoRadioVenci("",entity.getTipoRadioVenciOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRadioVenci(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoRadioVenci
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoRadioVenci entity = new TipoRadioVenci();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRadioVenciDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoRadioVenci.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoRadioVenci(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoRadioVenci> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRadioVenci> entities = new  ArrayList<TipoRadioVenci>();
		TipoRadioVenci entity = new TipoRadioVenci();		  
		
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
	
	public  List<TipoRadioVenci> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRadioVenci> entities = new  ArrayList<TipoRadioVenci>();
		TipoRadioVenci entity = new TipoRadioVenci();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRadioVenciDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRadioVenci();
      	    	entity=super.getEntity("",entity,resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRadioVenci("",entity,resultSet);
      	    	
				//entity.setTipoRadioVenciOriginal( new TipoRadioVenci());
      	    	//entity.setTipoRadioVenciOriginal(super.getEntity("",entity.getTipoRadioVenciOriginal(),resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRadioVenciOriginal(this.getEntityTipoRadioVenci("",entity.getTipoRadioVenciOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRadioVencis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRadioVenci(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRadioVenci> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRadioVenci> entities = new  ArrayList<TipoRadioVenci>();
		TipoRadioVenci entity = new TipoRadioVenci();		  
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
	
	public  List<TipoRadioVenci> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRadioVenci> entities = new  ArrayList<TipoRadioVenci>();
		TipoRadioVenci entity = new TipoRadioVenci();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRadioVenci();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRadioVenci();
					//entity.setMapTipoRadioVenci(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoRadioVenciValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRadioVenci().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA);         		
					entity=TipoRadioVenciDataAccess.getEntityTipoRadioVenci("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRadioVenciOriginal( new TipoRadioVenci());
					////entity.setTipoRadioVenciOriginal(super.getEntity("",entity.getTipoRadioVenciOriginal(),resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRadioVenciOriginal(this.getEntityTipoRadioVenci("",entity.getTipoRadioVenciOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRadioVencis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRadioVenci(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoRadioVenci getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRadioVenci entity = new TipoRadioVenci();		  
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
	
	public  TipoRadioVenci getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRadioVenci entity = new TipoRadioVenci();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRadioVenci();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRadioVenci();
					//entity.setMapTipoRadioVenci(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoRadioVenciValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRadioVenci().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA);         		
					entity=TipoRadioVenciDataAccess.getEntityTipoRadioVenci("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRadioVenciOriginal( new TipoRadioVenci());
					////entity.setTipoRadioVenciOriginal(super.getEntity("",entity.getTipoRadioVenciOriginal(),resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRadioVenciOriginal(this.getEntityTipoRadioVenci("",entity.getTipoRadioVenciOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoRadioVenci(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRadioVenci(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoRadioVenci getEntityTipoRadioVenci(String strPrefijo,TipoRadioVenci entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoRadioVenci.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoRadioVenci.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoRadioVenciDataAccess.setFieldReflectionTipoRadioVenci(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoRadioVenci=TipoRadioVenciConstantesFunciones.getTodosTiposColumnasTipoRadioVenci();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoRadioVenci) {
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
							field = TipoRadioVenci.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoRadioVenci.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoRadioVenciDataAccess.setFieldReflectionTipoRadioVenci(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoRadioVenci(Field field,String strPrefijo,String sColumn,TipoRadioVenci entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoRadioVenciConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRadioVenciConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRadioVenciConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRadioVenci>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoRadioVenci> entities = new  ArrayList<TipoRadioVenci>();
		TipoRadioVenci entity = new TipoRadioVenci();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRadioVenciDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoRadioVenci();
					entity=super.getEntity("",entity,resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoRadioVenci("",entity,resultSet);
					
					//entity.setTipoRadioVenciOriginal( new TipoRadioVenci());
					//entity.setTipoRadioVenciOriginal(super.getEntity("",entity.getTipoRadioVenciOriginal(),resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoRadioVenciOriginal(this.getEntityTipoRadioVenci("",entity.getTipoRadioVenciOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoRadioVencis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRadioVenci(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRadioVenci>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoRadioVenci> entities = new  ArrayList<TipoRadioVenci>();
		TipoRadioVenci entity = new TipoRadioVenci();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRadioVenciDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRadioVenciDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoRadioVenci> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRadioVenci> entities = new  ArrayList<TipoRadioVenci>();
		TipoRadioVenci entity = new TipoRadioVenci();		  
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
	
	public  List<TipoRadioVenci> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRadioVenci> entities = new  ArrayList<TipoRadioVenci>();
		TipoRadioVenci entity = new TipoRadioVenci();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRadioVenci();
      	    	entity=super.getEntity("",entity,resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRadioVenci("",entity,resultSet);
      	    	
				//entity.setTipoRadioVenciOriginal( new TipoRadioVenci());
      	    	//entity.setTipoRadioVenciOriginal(super.getEntity("",entity.getTipoRadioVenciOriginal(),resultSet,TipoRadioVenciDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRadioVenciOriginal(this.getEntityTipoRadioVenci("",entity.getTipoRadioVenciOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoRadioVencis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRadioVenci(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoRadioVenci getEntityTipoRadioVenci(String strPrefijo,TipoRadioVenci entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoRadioVenciConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoRadioVenciConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoRadioVenci(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoRadioVenci entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoRadioVenciDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoRadioVenciDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoRadioVenciDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoRadioVenciDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoRadioVenciConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoRadioVenciDataAccess.TABLENAME,TipoRadioVenciDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoRadioVenciDataAccess.setTipoRadioVenciOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<RadioVenciProve> getRadioVenciProves(Connexion connexion,TipoRadioVenci tiporadiovenci)throws SQLException,Exception {

		List<RadioVenciProve> radiovenciproves= new ArrayList<RadioVenciProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRadioVenciConstantesFunciones.SCHEMA+".tipo_radio_venci ON "+RadioVenciProveConstantesFunciones.SCHEMA+".radio_venci_prove.id_tipo_radio_venci="+TipoRadioVenciConstantesFunciones.SCHEMA+".tipo_radio_venci.id WHERE "+TipoRadioVenciConstantesFunciones.SCHEMA+".tipo_radio_venci.id="+String.valueOf(tiporadiovenci.getId());
			} else {
				sQuery=" INNER JOIN radiovenciprove.TipoRadioVenci WHERE radiovenciprove.TipoRadioVenci.id="+String.valueOf(tiporadiovenci.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RadioVenciProveDataAccess radiovenciproveDataAccess=new RadioVenciProveDataAccess();

			radiovenciproveDataAccess.setConnexionType(this.connexionType);
			radiovenciproveDataAccess.setParameterDbType(this.parameterDbType);
			radiovenciproves=radiovenciproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return radiovenciproves;

	}

	public List<RadioVenciClienteProve> getRadioVenciClienteProves(Connexion connexion,TipoRadioVenci tiporadiovenci)throws SQLException,Exception {

		List<RadioVenciClienteProve> radiovenciclienteproves= new ArrayList<RadioVenciClienteProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRadioVenciConstantesFunciones.SCHEMA+".tipo_radio_venci ON "+RadioVenciClienteProveConstantesFunciones.SCHEMA+".radio_venci_cliente_prove.id_tipo_radio_venci="+TipoRadioVenciConstantesFunciones.SCHEMA+".tipo_radio_venci.id WHERE "+TipoRadioVenciConstantesFunciones.SCHEMA+".tipo_radio_venci.id="+String.valueOf(tiporadiovenci.getId());
			} else {
				sQuery=" INNER JOIN radiovenciclienteprove.TipoRadioVenci WHERE radiovenciclienteprove.TipoRadioVenci.id="+String.valueOf(tiporadiovenci.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RadioVenciClienteProveDataAccess radiovenciclienteproveDataAccess=new RadioVenciClienteProveDataAccess();

			radiovenciclienteproveDataAccess.setConnexionType(this.connexionType);
			radiovenciclienteproveDataAccess.setParameterDbType(this.parameterDbType);
			radiovenciclienteproves=radiovenciclienteproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return radiovenciclienteproves;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoRadioVenci tiporadiovenci) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tiporadiovenci.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tiporadiovenci.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tiporadiovenci.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tiporadiovenci.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tiporadiovenci.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tiporadiovenci.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tiporadiovenci.getId());
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
	
	public void setIsNewIsChangedFalseTipoRadioVenci(TipoRadioVenci tiporadiovenci)throws Exception  {		
		tiporadiovenci.setIsNew(false);
		tiporadiovenci.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoRadioVencis(List<TipoRadioVenci> tiporadiovencis)throws Exception  {				
		for(TipoRadioVenci tiporadiovenci:tiporadiovencis) {
			tiporadiovenci.setIsNew(false);
			tiporadiovenci.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoRadioVenci(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
