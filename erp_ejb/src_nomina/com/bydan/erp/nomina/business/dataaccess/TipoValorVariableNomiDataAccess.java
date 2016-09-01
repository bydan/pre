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
package com.bydan.erp.nomina.business.dataaccess;

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

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//TipoValorVariableNomiConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoValorVariableNomiDataAccess extends  TipoValorVariableNomiDataAccessAdditional{ //TipoValorVariableNomiDataAccessAdditional,DataAccessHelper<TipoValorVariableNomi>
	//static Logger logger = Logger.getLogger(TipoValorVariableNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_valor_variable_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipovalorvariablenomi from "+TipoValorVariableNomiConstantesFunciones.SPERSISTENCENAME+" tipovalorvariablenomi";
	public static String QUERYSELECTNATIVE="select "+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+".id,"+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+".version_row,"+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+".codigo,"+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+".nombre from "+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME;//+" as "+TipoValorVariableNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+".id,"+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+".version_row,"+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+".codigo from "+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME;//+" as "+TipoValorVariableNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoValorVariableNomiConstantesFunciones.SCHEMA+"."+TipoValorVariableNomiConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOVALORVARIABLENOMI_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOVALORVARIABLENOMI_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOVALORVARIABLENOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOVALORVARIABLENOMI_SELECT(?,?)";
	
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
	
	
	protected TipoValorVariableNomiDataAccessAdditional tipovalorvariablenomiDataAccessAdditional=null;
	
	public TipoValorVariableNomiDataAccessAdditional getTipoValorVariableNomiDataAccessAdditional() {
		return this.tipovalorvariablenomiDataAccessAdditional;
	}
	
	public void setTipoValorVariableNomiDataAccessAdditional(TipoValorVariableNomiDataAccessAdditional tipovalorvariablenomiDataAccessAdditional) {
		try {
			this.tipovalorvariablenomiDataAccessAdditional=tipovalorvariablenomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoValorVariableNomiDataAccess() {
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
		TipoValorVariableNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoValorVariableNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoValorVariableNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoValorVariableNomiOriginal(TipoValorVariableNomi tipovalorvariablenomi)throws Exception  {
		tipovalorvariablenomi.setTipoValorVariableNomiOriginal((TipoValorVariableNomi)tipovalorvariablenomi.clone());		
	}
	
	public void setTipoValorVariableNomisOriginal(List<TipoValorVariableNomi> tipovalorvariablenomis)throws Exception  {
		
		for(TipoValorVariableNomi tipovalorvariablenomi:tipovalorvariablenomis){
			tipovalorvariablenomi.setTipoValorVariableNomiOriginal((TipoValorVariableNomi)tipovalorvariablenomi.clone());
		}
	}
	
	public static void setTipoValorVariableNomiOriginalStatic(TipoValorVariableNomi tipovalorvariablenomi)throws Exception  {
		tipovalorvariablenomi.setTipoValorVariableNomiOriginal((TipoValorVariableNomi)tipovalorvariablenomi.clone());		
	}
	
	public static void setTipoValorVariableNomisOriginalStatic(List<TipoValorVariableNomi> tipovalorvariablenomis)throws Exception  {
		
		for(TipoValorVariableNomi tipovalorvariablenomi:tipovalorvariablenomis){
			tipovalorvariablenomi.setTipoValorVariableNomiOriginal((TipoValorVariableNomi)tipovalorvariablenomi.clone());
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
	
	public  TipoValorVariableNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		
		
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
	
	public  TipoValorVariableNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.TipoValorVariableNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoValorVariableNomiOriginal(new TipoValorVariableNomi());
      	    	entity=super.getEntity("",entity,resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoValorVariableNomi("",entity,resultSet); 
				
				//entity.setTipoValorVariableNomiOriginal(super.getEntity("",entity.getTipoValorVariableNomiOriginal(),resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoValorVariableNomiOriginal(this.getEntityTipoValorVariableNomi("",entity.getTipoValorVariableNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoValorVariableNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoValorVariableNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoValorVariableNomi entity = new TipoValorVariableNomi();
				
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
	
	public  TipoValorVariableNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoValorVariableNomi entity = new TipoValorVariableNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoValorVariableNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoValorVariableNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoValorVariableNomiOriginal(new TipoValorVariableNomi());
      	    	entity=super.getEntity("",entity,resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoValorVariableNomi("",entity,resultSet);    
				
				//entity.setTipoValorVariableNomiOriginal(super.getEntity("",entity.getTipoValorVariableNomiOriginal(),resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoValorVariableNomiOriginal(this.getEntityTipoValorVariableNomi("",entity.getTipoValorVariableNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoValorVariableNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoValorVariableNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoValorVariableNomi entity = new TipoValorVariableNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoValorVariableNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoValorVariableNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoValorVariableNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoValorVariableNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoValorVariableNomi> entities = new  ArrayList<TipoValorVariableNomi>();
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
		
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
	
	public  List<TipoValorVariableNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoValorVariableNomi> entities = new  ArrayList<TipoValorVariableNomi>();
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoValorVariableNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoValorVariableNomi();
      	    	entity=super.getEntity("",entity,resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoValorVariableNomi("",entity,resultSet);
      	    	
				//entity.setTipoValorVariableNomiOriginal( new TipoValorVariableNomi());
      	    	//entity.setTipoValorVariableNomiOriginal(super.getEntity("",entity.getTipoValorVariableNomiOriginal(),resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoValorVariableNomiOriginal(this.getEntityTipoValorVariableNomi("",entity.getTipoValorVariableNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoValorVariableNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoValorVariableNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoValorVariableNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoValorVariableNomi> entities = new  ArrayList<TipoValorVariableNomi>();
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
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
	
	public  List<TipoValorVariableNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoValorVariableNomi> entities = new  ArrayList<TipoValorVariableNomi>();
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoValorVariableNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoValorVariableNomi();
					//entity.setMapTipoValorVariableNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoValorVariableNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoValorVariableNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA);         		
					entity=TipoValorVariableNomiDataAccess.getEntityTipoValorVariableNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoValorVariableNomiOriginal( new TipoValorVariableNomi());
					////entity.setTipoValorVariableNomiOriginal(super.getEntity("",entity.getTipoValorVariableNomiOriginal(),resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoValorVariableNomiOriginal(this.getEntityTipoValorVariableNomi("",entity.getTipoValorVariableNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoValorVariableNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoValorVariableNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoValorVariableNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
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
	
	public  TipoValorVariableNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoValorVariableNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoValorVariableNomi();
					//entity.setMapTipoValorVariableNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoValorVariableNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoValorVariableNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA);         		
					entity=TipoValorVariableNomiDataAccess.getEntityTipoValorVariableNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoValorVariableNomiOriginal( new TipoValorVariableNomi());
					////entity.setTipoValorVariableNomiOriginal(super.getEntity("",entity.getTipoValorVariableNomiOriginal(),resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoValorVariableNomiOriginal(this.getEntityTipoValorVariableNomi("",entity.getTipoValorVariableNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoValorVariableNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoValorVariableNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoValorVariableNomi getEntityTipoValorVariableNomi(String strPrefijo,TipoValorVariableNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoValorVariableNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoValorVariableNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoValorVariableNomiDataAccess.setFieldReflectionTipoValorVariableNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoValorVariableNomi=TipoValorVariableNomiConstantesFunciones.getTodosTiposColumnasTipoValorVariableNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoValorVariableNomi) {
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
							field = TipoValorVariableNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoValorVariableNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoValorVariableNomiDataAccess.setFieldReflectionTipoValorVariableNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoValorVariableNomi(Field field,String strPrefijo,String sColumn,TipoValorVariableNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoValorVariableNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoValorVariableNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoValorVariableNomiConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoValorVariableNomiConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoValorVariableNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoValorVariableNomi> entities = new  ArrayList<TipoValorVariableNomi>();
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoValorVariableNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoValorVariableNomi();
					entity=super.getEntity("",entity,resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoValorVariableNomi("",entity,resultSet);
					
					//entity.setTipoValorVariableNomiOriginal( new TipoValorVariableNomi());
					//entity.setTipoValorVariableNomiOriginal(super.getEntity("",entity.getTipoValorVariableNomiOriginal(),resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoValorVariableNomiOriginal(this.getEntityTipoValorVariableNomi("",entity.getTipoValorVariableNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoValorVariableNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoValorVariableNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoValorVariableNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoValorVariableNomi> entities = new  ArrayList<TipoValorVariableNomi>();
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoValorVariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoValorVariableNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoValorVariableNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoValorVariableNomi> entities = new  ArrayList<TipoValorVariableNomi>();
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
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
	
	public  List<TipoValorVariableNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoValorVariableNomi> entities = new  ArrayList<TipoValorVariableNomi>();
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoValorVariableNomi();
      	    	entity=super.getEntity("",entity,resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoValorVariableNomi("",entity,resultSet);
      	    	
				//entity.setTipoValorVariableNomiOriginal( new TipoValorVariableNomi());
      	    	//entity.setTipoValorVariableNomiOriginal(super.getEntity("",entity.getTipoValorVariableNomiOriginal(),resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoValorVariableNomiOriginal(this.getEntityTipoValorVariableNomi("",entity.getTipoValorVariableNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoValorVariableNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoValorVariableNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoValorVariableNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoValorVariableNomi> entities = new  ArrayList<TipoValorVariableNomi>();
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
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
	
	public  List<TipoValorVariableNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoValorVariableNomi> entities = new  ArrayList<TipoValorVariableNomi>();
		TipoValorVariableNomi entity = new TipoValorVariableNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoValorVariableNomi();
      	    	entity=super.getEntity("",entity,resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoValorVariableNomi("",entity,resultSet);
      	    	
				//entity.setTipoValorVariableNomiOriginal( new TipoValorVariableNomi());
      	    	//entity.setTipoValorVariableNomiOriginal(super.getEntity("",entity.getTipoValorVariableNomiOriginal(),resultSet,TipoValorVariableNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoValorVariableNomiOriginal(this.getEntityTipoValorVariableNomi("",entity.getTipoValorVariableNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoValorVariableNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoValorVariableNomi getEntityTipoValorVariableNomi(String strPrefijo,TipoValorVariableNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoValorVariableNomiConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoValorVariableNomiConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoValorVariableNomiConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoValorVariableNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoValorVariableNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoValorVariableNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoValorVariableNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoValorVariableNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoValorVariableNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoValorVariableNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoValorVariableNomiDataAccess.TABLENAME,TipoValorVariableNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoValorVariableNomiDataAccess.setTipoValorVariableNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<VariableNomi> getVariableNomis(Connexion connexion,TipoValorVariableNomi tipovalorvariablenomi)throws SQLException,Exception {

		List<VariableNomi> variablenomis= new ArrayList<VariableNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoValorVariableNomiConstantesFunciones.SCHEMA+".tipo_valor_variable_nomi ON "+VariableNomiConstantesFunciones.SCHEMA+".variable_nomi.id_tipo_valor_variable_nomi="+TipoValorVariableNomiConstantesFunciones.SCHEMA+".tipo_valor_variable_nomi.id WHERE "+TipoValorVariableNomiConstantesFunciones.SCHEMA+".tipo_valor_variable_nomi.id="+String.valueOf(tipovalorvariablenomi.getId());
			} else {
				sQuery=" INNER JOIN variablenomi.TipoValorVariableNomi WHERE variablenomi.TipoValorVariableNomi.id="+String.valueOf(tipovalorvariablenomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			VariableNomiDataAccess variablenomiDataAccess=new VariableNomiDataAccess();

			variablenomiDataAccess.setConnexionType(this.connexionType);
			variablenomiDataAccess.setParameterDbType(this.parameterDbType);
			variablenomis=variablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return variablenomis;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoValorVariableNomi tipovalorvariablenomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipovalorvariablenomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipovalorvariablenomi.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipovalorvariablenomi.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipovalorvariablenomi.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipovalorvariablenomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipovalorvariablenomi.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipovalorvariablenomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipovalorvariablenomi.getId());
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
	
	public void setIsNewIsChangedFalseTipoValorVariableNomi(TipoValorVariableNomi tipovalorvariablenomi)throws Exception  {		
		tipovalorvariablenomi.setIsNew(false);
		tipovalorvariablenomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoValorVariableNomis(List<TipoValorVariableNomi> tipovalorvariablenomis)throws Exception  {				
		for(TipoValorVariableNomi tipovalorvariablenomi:tipovalorvariablenomis) {
			tipovalorvariablenomi.setIsNew(false);
			tipovalorvariablenomi.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoValorVariableNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
