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
import com.bydan.erp.nomina.util.*;//TipoNovedadNomiConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoNovedadNomiDataAccess extends  TipoNovedadNomiDataAccessAdditional{ //TipoNovedadNomiDataAccessAdditional,DataAccessHelper<TipoNovedadNomi>
	//static Logger logger = Logger.getLogger(TipoNovedadNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_novedad_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tiponovedadnomi from "+TipoNovedadNomiConstantesFunciones.SPERSISTENCENAME+" tiponovedadnomi";
	public static String QUERYSELECTNATIVE="select "+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+".id,"+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+".version_row,"+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+".codigo,"+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+".nombre from "+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME;//+" as "+TipoNovedadNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+".id,"+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+".version_row,"+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+".codigo from "+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME;//+" as "+TipoNovedadNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoNovedadNomiConstantesFunciones.SCHEMA+"."+TipoNovedadNomiConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPONOVEDADNOMI_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPONOVEDADNOMI_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPONOVEDADNOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPONOVEDADNOMI_SELECT(?,?)";
	
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
	
	
	protected TipoNovedadNomiDataAccessAdditional tiponovedadnomiDataAccessAdditional=null;
	
	public TipoNovedadNomiDataAccessAdditional getTipoNovedadNomiDataAccessAdditional() {
		return this.tiponovedadnomiDataAccessAdditional;
	}
	
	public void setTipoNovedadNomiDataAccessAdditional(TipoNovedadNomiDataAccessAdditional tiponovedadnomiDataAccessAdditional) {
		try {
			this.tiponovedadnomiDataAccessAdditional=tiponovedadnomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoNovedadNomiDataAccess() {
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
		TipoNovedadNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoNovedadNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoNovedadNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoNovedadNomiOriginal(TipoNovedadNomi tiponovedadnomi)throws Exception  {
		tiponovedadnomi.setTipoNovedadNomiOriginal((TipoNovedadNomi)tiponovedadnomi.clone());		
	}
	
	public void setTipoNovedadNomisOriginal(List<TipoNovedadNomi> tiponovedadnomis)throws Exception  {
		
		for(TipoNovedadNomi tiponovedadnomi:tiponovedadnomis){
			tiponovedadnomi.setTipoNovedadNomiOriginal((TipoNovedadNomi)tiponovedadnomi.clone());
		}
	}
	
	public static void setTipoNovedadNomiOriginalStatic(TipoNovedadNomi tiponovedadnomi)throws Exception  {
		tiponovedadnomi.setTipoNovedadNomiOriginal((TipoNovedadNomi)tiponovedadnomi.clone());		
	}
	
	public static void setTipoNovedadNomisOriginalStatic(List<TipoNovedadNomi> tiponovedadnomis)throws Exception  {
		
		for(TipoNovedadNomi tiponovedadnomi:tiponovedadnomis){
			tiponovedadnomi.setTipoNovedadNomiOriginal((TipoNovedadNomi)tiponovedadnomi.clone());
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
	
	public  TipoNovedadNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoNovedadNomi entity = new TipoNovedadNomi();		
		
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
	
	public  TipoNovedadNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoNovedadNomi entity = new TipoNovedadNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.TipoNovedadNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoNovedadNomiOriginal(new TipoNovedadNomi());
      	    	entity=super.getEntity("",entity,resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoNovedadNomi("",entity,resultSet); 
				
				//entity.setTipoNovedadNomiOriginal(super.getEntity("",entity.getTipoNovedadNomiOriginal(),resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoNovedadNomiOriginal(this.getEntityTipoNovedadNomi("",entity.getTipoNovedadNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoNovedadNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoNovedadNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoNovedadNomi entity = new TipoNovedadNomi();
				
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
	
	public  TipoNovedadNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoNovedadNomi entity = new TipoNovedadNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoNovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoNovedadNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoNovedadNomiOriginal(new TipoNovedadNomi());
      	    	entity=super.getEntity("",entity,resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoNovedadNomi("",entity,resultSet);    
				
				//entity.setTipoNovedadNomiOriginal(super.getEntity("",entity.getTipoNovedadNomiOriginal(),resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoNovedadNomiOriginal(this.getEntityTipoNovedadNomi("",entity.getTipoNovedadNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoNovedadNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoNovedadNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoNovedadNomi entity = new TipoNovedadNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoNovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoNovedadNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoNovedadNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoNovedadNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoNovedadNomi> entities = new  ArrayList<TipoNovedadNomi>();
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
		
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
	
	public  List<TipoNovedadNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoNovedadNomi> entities = new  ArrayList<TipoNovedadNomi>();
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoNovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoNovedadNomi();
      	    	entity=super.getEntity("",entity,resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoNovedadNomi("",entity,resultSet);
      	    	
				//entity.setTipoNovedadNomiOriginal( new TipoNovedadNomi());
      	    	//entity.setTipoNovedadNomiOriginal(super.getEntity("",entity.getTipoNovedadNomiOriginal(),resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoNovedadNomiOriginal(this.getEntityTipoNovedadNomi("",entity.getTipoNovedadNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoNovedadNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoNovedadNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoNovedadNomi> entities = new  ArrayList<TipoNovedadNomi>();
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
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
	
	public  List<TipoNovedadNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoNovedadNomi> entities = new  ArrayList<TipoNovedadNomi>();
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoNovedadNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoNovedadNomi();
					//entity.setMapTipoNovedadNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoNovedadNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoNovedadNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA);         		
					entity=TipoNovedadNomiDataAccess.getEntityTipoNovedadNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoNovedadNomiOriginal( new TipoNovedadNomi());
					////entity.setTipoNovedadNomiOriginal(super.getEntity("",entity.getTipoNovedadNomiOriginal(),resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoNovedadNomiOriginal(this.getEntityTipoNovedadNomi("",entity.getTipoNovedadNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoNovedadNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoNovedadNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
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
	
	public  TipoNovedadNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoNovedadNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoNovedadNomi();
					//entity.setMapTipoNovedadNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoNovedadNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoNovedadNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA);         		
					entity=TipoNovedadNomiDataAccess.getEntityTipoNovedadNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoNovedadNomiOriginal( new TipoNovedadNomi());
					////entity.setTipoNovedadNomiOriginal(super.getEntity("",entity.getTipoNovedadNomiOriginal(),resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoNovedadNomiOriginal(this.getEntityTipoNovedadNomi("",entity.getTipoNovedadNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoNovedadNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoNovedadNomi getEntityTipoNovedadNomi(String strPrefijo,TipoNovedadNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoNovedadNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoNovedadNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoNovedadNomiDataAccess.setFieldReflectionTipoNovedadNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoNovedadNomi=TipoNovedadNomiConstantesFunciones.getTodosTiposColumnasTipoNovedadNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoNovedadNomi) {
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
							field = TipoNovedadNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoNovedadNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoNovedadNomiDataAccess.setFieldReflectionTipoNovedadNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoNovedadNomi(Field field,String strPrefijo,String sColumn,TipoNovedadNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoNovedadNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoNovedadNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoNovedadNomiConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoNovedadNomiConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoNovedadNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoNovedadNomi> entities = new  ArrayList<TipoNovedadNomi>();
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoNovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoNovedadNomi();
					entity=super.getEntity("",entity,resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoNovedadNomi("",entity,resultSet);
					
					//entity.setTipoNovedadNomiOriginal( new TipoNovedadNomi());
					//entity.setTipoNovedadNomiOriginal(super.getEntity("",entity.getTipoNovedadNomiOriginal(),resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoNovedadNomiOriginal(this.getEntityTipoNovedadNomi("",entity.getTipoNovedadNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoNovedadNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoNovedadNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoNovedadNomi> entities = new  ArrayList<TipoNovedadNomi>();
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoNovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoNovedadNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoNovedadNomi> entities = new  ArrayList<TipoNovedadNomi>();
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
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
	
	public  List<TipoNovedadNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoNovedadNomi> entities = new  ArrayList<TipoNovedadNomi>();
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoNovedadNomi();
      	    	entity=super.getEntity("",entity,resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoNovedadNomi("",entity,resultSet);
      	    	
				//entity.setTipoNovedadNomiOriginal( new TipoNovedadNomi());
      	    	//entity.setTipoNovedadNomiOriginal(super.getEntity("",entity.getTipoNovedadNomiOriginal(),resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoNovedadNomiOriginal(this.getEntityTipoNovedadNomi("",entity.getTipoNovedadNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoNovedadNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoNovedadNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoNovedadNomi> entities = new  ArrayList<TipoNovedadNomi>();
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
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
	
	public  List<TipoNovedadNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoNovedadNomi> entities = new  ArrayList<TipoNovedadNomi>();
		TipoNovedadNomi entity = new TipoNovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoNovedadNomi();
      	    	entity=super.getEntity("",entity,resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoNovedadNomi("",entity,resultSet);
      	    	
				//entity.setTipoNovedadNomiOriginal( new TipoNovedadNomi());
      	    	//entity.setTipoNovedadNomiOriginal(super.getEntity("",entity.getTipoNovedadNomiOriginal(),resultSet,TipoNovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoNovedadNomiOriginal(this.getEntityTipoNovedadNomi("",entity.getTipoNovedadNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoNovedadNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoNovedadNomi getEntityTipoNovedadNomi(String strPrefijo,TipoNovedadNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoNovedadNomiConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoNovedadNomiConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoNovedadNomiConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoNovedadNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoNovedadNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoNovedadNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoNovedadNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoNovedadNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoNovedadNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoNovedadNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoNovedadNomiDataAccess.TABLENAME,TipoNovedadNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoNovedadNomiDataAccess.setTipoNovedadNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<NovedadNomi> getNovedadNomis(Connexion connexion,TipoNovedadNomi tiponovedadnomi)throws SQLException,Exception {

		List<NovedadNomi> novedadnomis= new ArrayList<NovedadNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoNovedadNomiConstantesFunciones.SCHEMA+".tipo_novedad_nomi ON "+NovedadNomiConstantesFunciones.SCHEMA+".novedad_nomi.id_tipo_novedad_nomi="+TipoNovedadNomiConstantesFunciones.SCHEMA+".tipo_novedad_nomi.id WHERE "+TipoNovedadNomiConstantesFunciones.SCHEMA+".tipo_novedad_nomi.id="+String.valueOf(tiponovedadnomi.getId());
			} else {
				sQuery=" INNER JOIN novedadnomi.TipoNovedadNomi WHERE novedadnomi.TipoNovedadNomi.id="+String.valueOf(tiponovedadnomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NovedadNomiDataAccess novedadnomiDataAccess=new NovedadNomiDataAccess();

			novedadnomiDataAccess.setConnexionType(this.connexionType);
			novedadnomiDataAccess.setParameterDbType(this.parameterDbType);
			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadnomis;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoNovedadNomi tiponovedadnomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tiponovedadnomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tiponovedadnomi.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tiponovedadnomi.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tiponovedadnomi.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tiponovedadnomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tiponovedadnomi.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tiponovedadnomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tiponovedadnomi.getId());
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
	
	public void setIsNewIsChangedFalseTipoNovedadNomi(TipoNovedadNomi tiponovedadnomi)throws Exception  {		
		tiponovedadnomi.setIsNew(false);
		tiponovedadnomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoNovedadNomis(List<TipoNovedadNomi> tiponovedadnomis)throws Exception  {				
		for(TipoNovedadNomi tiponovedadnomi:tiponovedadnomis) {
			tiponovedadnomi.setIsNew(false);
			tiponovedadnomi.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoNovedadNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
