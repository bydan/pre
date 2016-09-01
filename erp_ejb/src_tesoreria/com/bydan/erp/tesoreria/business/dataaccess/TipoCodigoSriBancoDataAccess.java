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
package com.bydan.erp.tesoreria.business.dataaccess;

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

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//TipoCodigoSriBancoConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoCodigoSriBancoDataAccess extends  TipoCodigoSriBancoDataAccessAdditional{ //TipoCodigoSriBancoDataAccessAdditional,DataAccessHelper<TipoCodigoSriBanco>
	//static Logger logger = Logger.getLogger(TipoCodigoSriBancoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_codigo_sri_banco";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocodigosribanco from "+TipoCodigoSriBancoConstantesFunciones.SPERSISTENCENAME+" tipocodigosribanco";
	public static String QUERYSELECTNATIVE="select "+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+".id,"+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+".version_row,"+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+".codigo,"+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+".nombre from "+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME;//+" as "+TipoCodigoSriBancoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+".id,"+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+".version_row,"+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+".codigo from "+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME;//+" as "+TipoCodigoSriBancoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCODIGOSRIBANCO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCODIGOSRIBANCO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCODIGOSRIBANCO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCODIGOSRIBANCO_SELECT(?,?)";
	
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
	
	
	protected TipoCodigoSriBancoDataAccessAdditional tipocodigosribancoDataAccessAdditional=null;
	
	public TipoCodigoSriBancoDataAccessAdditional getTipoCodigoSriBancoDataAccessAdditional() {
		return this.tipocodigosribancoDataAccessAdditional;
	}
	
	public void setTipoCodigoSriBancoDataAccessAdditional(TipoCodigoSriBancoDataAccessAdditional tipocodigosribancoDataAccessAdditional) {
		try {
			this.tipocodigosribancoDataAccessAdditional=tipocodigosribancoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoCodigoSriBancoDataAccess() {
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
		TipoCodigoSriBancoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoCodigoSriBancoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoCodigoSriBancoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoCodigoSriBancoOriginal(TipoCodigoSriBanco tipocodigosribanco)throws Exception  {
		tipocodigosribanco.setTipoCodigoSriBancoOriginal((TipoCodigoSriBanco)tipocodigosribanco.clone());		
	}
	
	public void setTipoCodigoSriBancosOriginal(List<TipoCodigoSriBanco> tipocodigosribancos)throws Exception  {
		
		for(TipoCodigoSriBanco tipocodigosribanco:tipocodigosribancos){
			tipocodigosribanco.setTipoCodigoSriBancoOriginal((TipoCodigoSriBanco)tipocodigosribanco.clone());
		}
	}
	
	public static void setTipoCodigoSriBancoOriginalStatic(TipoCodigoSriBanco tipocodigosribanco)throws Exception  {
		tipocodigosribanco.setTipoCodigoSriBancoOriginal((TipoCodigoSriBanco)tipocodigosribanco.clone());		
	}
	
	public static void setTipoCodigoSriBancosOriginalStatic(List<TipoCodigoSriBanco> tipocodigosribancos)throws Exception  {
		
		for(TipoCodigoSriBanco tipocodigosribanco:tipocodigosribancos){
			tipocodigosribanco.setTipoCodigoSriBancoOriginal((TipoCodigoSriBanco)tipocodigosribanco.clone());
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
	
	public  TipoCodigoSriBanco getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		
		
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
	
	public  TipoCodigoSriBanco getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.TipoCodigoSriBanco.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoCodigoSriBancoOriginal(new TipoCodigoSriBanco());
      	    	entity=super.getEntity("",entity,resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCodigoSriBanco("",entity,resultSet); 
				
				//entity.setTipoCodigoSriBancoOriginal(super.getEntity("",entity.getTipoCodigoSriBancoOriginal(),resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCodigoSriBancoOriginal(this.getEntityTipoCodigoSriBanco("",entity.getTipoCodigoSriBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCodigoSriBanco(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoCodigoSriBanco getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();
				
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
	
	public  TipoCodigoSriBanco getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCodigoSriBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoCodigoSriBanco.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoCodigoSriBancoOriginal(new TipoCodigoSriBanco());
      	    	entity=super.getEntity("",entity,resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCodigoSriBanco("",entity,resultSet);    
				
				//entity.setTipoCodigoSriBancoOriginal(super.getEntity("",entity.getTipoCodigoSriBancoOriginal(),resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCodigoSriBancoOriginal(this.getEntityTipoCodigoSriBanco("",entity.getTipoCodigoSriBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCodigoSriBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoCodigoSriBanco
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCodigoSriBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoCodigoSriBanco.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoCodigoSriBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoCodigoSriBanco> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCodigoSriBanco> entities = new  ArrayList<TipoCodigoSriBanco>();
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
		
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
	
	public  List<TipoCodigoSriBanco> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCodigoSriBanco> entities = new  ArrayList<TipoCodigoSriBanco>();
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCodigoSriBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCodigoSriBanco();
      	    	entity=super.getEntity("",entity,resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCodigoSriBanco("",entity,resultSet);
      	    	
				//entity.setTipoCodigoSriBancoOriginal( new TipoCodigoSriBanco());
      	    	//entity.setTipoCodigoSriBancoOriginal(super.getEntity("",entity.getTipoCodigoSriBancoOriginal(),resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCodigoSriBancoOriginal(this.getEntityTipoCodigoSriBanco("",entity.getTipoCodigoSriBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCodigoSriBancos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCodigoSriBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCodigoSriBanco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCodigoSriBanco> entities = new  ArrayList<TipoCodigoSriBanco>();
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
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
	
	public  List<TipoCodigoSriBanco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCodigoSriBanco> entities = new  ArrayList<TipoCodigoSriBanco>();
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCodigoSriBanco();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCodigoSriBanco();
					//entity.setMapTipoCodigoSriBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoCodigoSriBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCodigoSriBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA);         		
					entity=TipoCodigoSriBancoDataAccess.getEntityTipoCodigoSriBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCodigoSriBancoOriginal( new TipoCodigoSriBanco());
					////entity.setTipoCodigoSriBancoOriginal(super.getEntity("",entity.getTipoCodigoSriBancoOriginal(),resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCodigoSriBancoOriginal(this.getEntityTipoCodigoSriBanco("",entity.getTipoCodigoSriBancoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCodigoSriBancos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCodigoSriBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoCodigoSriBanco getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
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
	
	public  TipoCodigoSriBanco getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCodigoSriBanco();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCodigoSriBanco();
					//entity.setMapTipoCodigoSriBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoCodigoSriBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCodigoSriBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA);         		
					entity=TipoCodigoSriBancoDataAccess.getEntityTipoCodigoSriBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCodigoSriBancoOriginal( new TipoCodigoSriBanco());
					////entity.setTipoCodigoSriBancoOriginal(super.getEntity("",entity.getTipoCodigoSriBancoOriginal(),resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCodigoSriBancoOriginal(this.getEntityTipoCodigoSriBanco("",entity.getTipoCodigoSriBancoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoCodigoSriBanco(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCodigoSriBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoCodigoSriBanco getEntityTipoCodigoSriBanco(String strPrefijo,TipoCodigoSriBanco entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoCodigoSriBanco.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoCodigoSriBanco.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoCodigoSriBancoDataAccess.setFieldReflectionTipoCodigoSriBanco(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoCodigoSriBanco=TipoCodigoSriBancoConstantesFunciones.getTodosTiposColumnasTipoCodigoSriBanco();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoCodigoSriBanco) {
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
							field = TipoCodigoSriBanco.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoCodigoSriBanco.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoCodigoSriBancoDataAccess.setFieldReflectionTipoCodigoSriBanco(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoCodigoSriBanco(Field field,String strPrefijo,String sColumn,TipoCodigoSriBanco entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoCodigoSriBancoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCodigoSriBancoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCodigoSriBancoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCodigoSriBancoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCodigoSriBanco>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoCodigoSriBanco> entities = new  ArrayList<TipoCodigoSriBanco>();
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCodigoSriBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoCodigoSriBanco();
					entity=super.getEntity("",entity,resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoCodigoSriBanco("",entity,resultSet);
					
					//entity.setTipoCodigoSriBancoOriginal( new TipoCodigoSriBanco());
					//entity.setTipoCodigoSriBancoOriginal(super.getEntity("",entity.getTipoCodigoSriBancoOriginal(),resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoCodigoSriBancoOriginal(this.getEntityTipoCodigoSriBanco("",entity.getTipoCodigoSriBancoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoCodigoSriBancos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCodigoSriBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCodigoSriBanco>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoCodigoSriBanco> entities = new  ArrayList<TipoCodigoSriBanco>();
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCodigoSriBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCodigoSriBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoCodigoSriBanco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCodigoSriBanco> entities = new  ArrayList<TipoCodigoSriBanco>();
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
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
	
	public  List<TipoCodigoSriBanco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCodigoSriBanco> entities = new  ArrayList<TipoCodigoSriBanco>();
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCodigoSriBanco();
      	    	entity=super.getEntity("",entity,resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCodigoSriBanco("",entity,resultSet);
      	    	
				//entity.setTipoCodigoSriBancoOriginal( new TipoCodigoSriBanco());
      	    	//entity.setTipoCodigoSriBancoOriginal(super.getEntity("",entity.getTipoCodigoSriBancoOriginal(),resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCodigoSriBancoOriginal(this.getEntityTipoCodigoSriBanco("",entity.getTipoCodigoSriBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoCodigoSriBancos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCodigoSriBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCodigoSriBanco> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCodigoSriBanco> entities = new  ArrayList<TipoCodigoSriBanco>();
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
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
	
	public  List<TipoCodigoSriBanco> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCodigoSriBanco> entities = new  ArrayList<TipoCodigoSriBanco>();
		TipoCodigoSriBanco entity = new TipoCodigoSriBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCodigoSriBanco();
      	    	entity=super.getEntity("",entity,resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCodigoSriBanco("",entity,resultSet);
      	    	
				//entity.setTipoCodigoSriBancoOriginal( new TipoCodigoSriBanco());
      	    	//entity.setTipoCodigoSriBancoOriginal(super.getEntity("",entity.getTipoCodigoSriBancoOriginal(),resultSet,TipoCodigoSriBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCodigoSriBancoOriginal(this.getEntityTipoCodigoSriBanco("",entity.getTipoCodigoSriBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCodigoSriBancos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoCodigoSriBanco getEntityTipoCodigoSriBanco(String strPrefijo,TipoCodigoSriBanco entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCodigoSriBancoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoCodigoSriBancoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCodigoSriBancoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoCodigoSriBanco(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoCodigoSriBanco entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoCodigoSriBancoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoCodigoSriBancoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoCodigoSriBancoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoCodigoSriBancoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoCodigoSriBancoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoCodigoSriBancoDataAccess.TABLENAME,TipoCodigoSriBancoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoCodigoSriBancoDataAccess.setTipoCodigoSriBancoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoCodigoSriBanco tipocodigosribanco) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocodigosribanco.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipocodigosribanco.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipocodigosribanco.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipocodigosribanco.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocodigosribanco.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocodigosribanco.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocodigosribanco.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocodigosribanco.getId());
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
	
	public void setIsNewIsChangedFalseTipoCodigoSriBanco(TipoCodigoSriBanco tipocodigosribanco)throws Exception  {		
		tipocodigosribanco.setIsNew(false);
		tipocodigosribanco.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoCodigoSriBancos(List<TipoCodigoSriBanco> tipocodigosribancos)throws Exception  {				
		for(TipoCodigoSriBanco tipocodigosribanco:tipocodigosribancos) {
			tipocodigosribanco.setIsNew(false);
			tipocodigosribanco.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoCodigoSriBanco(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
