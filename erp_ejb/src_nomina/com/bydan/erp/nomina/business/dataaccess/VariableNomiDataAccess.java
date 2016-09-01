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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//VariableNomiConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class VariableNomiDataAccess extends  VariableNomiDataAccessAdditional{ //VariableNomiDataAccessAdditional,DataAccessHelper<VariableNomi>
	//static Logger logger = Logger.getLogger(VariableNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="variable_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_modulo,id_tipo_variable_nomi,id_tipo_valor_variable_nomi,codigo,nombre,sql1,sql2,sql3,valor)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,id_tipo_variable_nomi=?,id_tipo_valor_variable_nomi=?,codigo=?,nombre=?,sql1=?,sql2=?,sql3=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select variablenomi from "+VariableNomiConstantesFunciones.SPERSISTENCENAME+" variablenomi";
	public static String QUERYSELECTNATIVE="select "+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".id,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".version_row,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".id_empresa,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".id_modulo,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".id_tipo_variable_nomi,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".id_tipo_valor_variable_nomi,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".codigo,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".nombre,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".sql1,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".sql2,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".sql3,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".valor from "+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME;//+" as "+VariableNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".id,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".version_row,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".codigo,"+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+".nombre from "+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME;//+" as "+VariableNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+VariableNomiConstantesFunciones.SCHEMA+"."+VariableNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,id_tipo_variable_nomi=?,id_tipo_valor_variable_nomi=?,codigo=?,nombre=?,sql1=?,sql2=?,sql3=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_VARIABLENOMI_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_VARIABLENOMI_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_VARIABLENOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_VARIABLENOMI_SELECT(?,?)";
	
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
	
	
	protected VariableNomiDataAccessAdditional variablenomiDataAccessAdditional=null;
	
	public VariableNomiDataAccessAdditional getVariableNomiDataAccessAdditional() {
		return this.variablenomiDataAccessAdditional;
	}
	
	public void setVariableNomiDataAccessAdditional(VariableNomiDataAccessAdditional variablenomiDataAccessAdditional) {
		try {
			this.variablenomiDataAccessAdditional=variablenomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public VariableNomiDataAccess() {
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
		VariableNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		VariableNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		VariableNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setVariableNomiOriginal(VariableNomi variablenomi)throws Exception  {
		variablenomi.setVariableNomiOriginal((VariableNomi)variablenomi.clone());		
	}
	
	public void setVariableNomisOriginal(List<VariableNomi> variablenomis)throws Exception  {
		
		for(VariableNomi variablenomi:variablenomis){
			variablenomi.setVariableNomiOriginal((VariableNomi)variablenomi.clone());
		}
	}
	
	public static void setVariableNomiOriginalStatic(VariableNomi variablenomi)throws Exception  {
		variablenomi.setVariableNomiOriginal((VariableNomi)variablenomi.clone());		
	}
	
	public static void setVariableNomisOriginalStatic(List<VariableNomi> variablenomis)throws Exception  {
		
		for(VariableNomi variablenomi:variablenomis){
			variablenomi.setVariableNomiOriginal((VariableNomi)variablenomi.clone());
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
	
	public  VariableNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		VariableNomi entity = new VariableNomi();		
		
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
	
	public  VariableNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		VariableNomi entity = new VariableNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.VariableNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setVariableNomiOriginal(new VariableNomi());
      	    	entity=super.getEntity("",entity,resultSet,VariableNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVariableNomi("",entity,resultSet); 
				
				//entity.setVariableNomiOriginal(super.getEntity("",entity.getVariableNomiOriginal(),resultSet,VariableNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVariableNomiOriginal(this.getEntityVariableNomi("",entity.getVariableNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseVariableNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  VariableNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		VariableNomi entity = new VariableNomi();
				
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
	
	public  VariableNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		VariableNomi entity = new VariableNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VariableNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.VariableNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setVariableNomiOriginal(new VariableNomi());
      	    	entity=super.getEntity("",entity,resultSet,VariableNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVariableNomi("",entity,resultSet);    
				
				//entity.setVariableNomiOriginal(super.getEntity("",entity.getVariableNomiOriginal(),resultSet,VariableNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVariableNomiOriginal(this.getEntityVariableNomi("",entity.getVariableNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseVariableNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //VariableNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		VariableNomi entity = new VariableNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VariableNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.VariableNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseVariableNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<VariableNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<VariableNomi> entities = new  ArrayList<VariableNomi>();
		VariableNomi entity = new VariableNomi();		  
		
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
	
	public  List<VariableNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<VariableNomi> entities = new  ArrayList<VariableNomi>();
		VariableNomi entity = new VariableNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VariableNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VariableNomi();
      	    	entity=super.getEntity("",entity,resultSet,VariableNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVariableNomi("",entity,resultSet);
      	    	
				//entity.setVariableNomiOriginal( new VariableNomi());
      	    	//entity.setVariableNomiOriginal(super.getEntity("",entity.getVariableNomiOriginal(),resultSet,VariableNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVariableNomiOriginal(this.getEntityVariableNomi("",entity.getVariableNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVariableNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVariableNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<VariableNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<VariableNomi> entities = new  ArrayList<VariableNomi>();
		VariableNomi entity = new VariableNomi();		  
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
	
	public  List<VariableNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<VariableNomi> entities = new  ArrayList<VariableNomi>();
		VariableNomi entity = new VariableNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VariableNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapVariableNomi();
					//entity.setMapVariableNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapVariableNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVariableNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VariableNomiDataAccess.ISWITHSCHEMA);         		
					entity=VariableNomiDataAccess.getEntityVariableNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVariableNomiOriginal( new VariableNomi());
					////entity.setVariableNomiOriginal(super.getEntity("",entity.getVariableNomiOriginal(),resultSet,VariableNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setVariableNomiOriginal(this.getEntityVariableNomi("",entity.getVariableNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVariableNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVariableNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public VariableNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		VariableNomi entity = new VariableNomi();		  
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
	
	public  VariableNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		VariableNomi entity = new VariableNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VariableNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapVariableNomi();
					//entity.setMapVariableNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapVariableNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVariableNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VariableNomiDataAccess.ISWITHSCHEMA);         		
					entity=VariableNomiDataAccess.getEntityVariableNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVariableNomiOriginal( new VariableNomi());
					////entity.setVariableNomiOriginal(super.getEntity("",entity.getVariableNomiOriginal(),resultSet,VariableNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setVariableNomiOriginal(this.getEntityVariableNomi("",entity.getVariableNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseVariableNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVariableNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static VariableNomi getEntityVariableNomi(String strPrefijo,VariableNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = VariableNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = VariableNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					VariableNomiDataAccess.setFieldReflectionVariableNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasVariableNomi=VariableNomiConstantesFunciones.getTodosTiposColumnasVariableNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasVariableNomi) {
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
							field = VariableNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = VariableNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						VariableNomiDataAccess.setFieldReflectionVariableNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionVariableNomi(Field field,String strPrefijo,String sColumn,VariableNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case VariableNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VariableNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VariableNomiConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VariableNomiConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VariableNomiConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VariableNomiConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VariableNomiConstantesFunciones.SQL1:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VariableNomiConstantesFunciones.SQL2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VariableNomiConstantesFunciones.SQL3:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VariableNomiConstantesFunciones.VALOR:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<VariableNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<VariableNomi> entities = new  ArrayList<VariableNomi>();
		VariableNomi entity = new VariableNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VariableNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new VariableNomi();
					entity=super.getEntity("",entity,resultSet,VariableNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityVariableNomi("",entity,resultSet);
					
					//entity.setVariableNomiOriginal( new VariableNomi());
					//entity.setVariableNomiOriginal(super.getEntity("",entity.getVariableNomiOriginal(),resultSet,VariableNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setVariableNomiOriginal(this.getEntityVariableNomi("",entity.getVariableNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseVariableNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVariableNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<VariableNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<VariableNomi> entities = new  ArrayList<VariableNomi>();
		VariableNomi entity = new VariableNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VariableNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VariableNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<VariableNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VariableNomi> entities = new  ArrayList<VariableNomi>();
		VariableNomi entity = new VariableNomi();		  
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
	
	public  List<VariableNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VariableNomi> entities = new  ArrayList<VariableNomi>();
		VariableNomi entity = new VariableNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VariableNomi();
      	    	entity=super.getEntity("",entity,resultSet,VariableNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVariableNomi("",entity,resultSet);
      	    	
				//entity.setVariableNomiOriginal( new VariableNomi());
      	    	//entity.setVariableNomiOriginal(super.getEntity("",entity.getVariableNomiOriginal(),resultSet,VariableNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVariableNomiOriginal(this.getEntityVariableNomi("",entity.getVariableNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseVariableNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVariableNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<VariableNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VariableNomi> entities = new  ArrayList<VariableNomi>();
		VariableNomi entity = new VariableNomi();		  
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
	
	public  List<VariableNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VariableNomi> entities = new  ArrayList<VariableNomi>();
		VariableNomi entity = new VariableNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VariableNomi();
      	    	entity=super.getEntity("",entity,resultSet,VariableNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVariableNomi("",entity,resultSet);
      	    	
				//entity.setVariableNomiOriginal( new VariableNomi());
      	    	//entity.setVariableNomiOriginal(super.getEntity("",entity.getVariableNomiOriginal(),resultSet,VariableNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVariableNomiOriginal(this.getEntityVariableNomi("",entity.getVariableNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVariableNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public VariableNomi getEntityVariableNomi(String strPrefijo,VariableNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+VariableNomiConstantesFunciones.IDEMPRESA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+VariableNomiConstantesFunciones.IDMODULO));
				entity.setid_tipo_variable_nomi(resultSet.getLong(strPrefijo+VariableNomiConstantesFunciones.IDTIPOVARIABLENOMI));
				entity.setid_tipo_valor_variable_nomi(resultSet.getLong(strPrefijo+VariableNomiConstantesFunciones.IDTIPOVALORVARIABLENOMI));
				entity.setcodigo(resultSet.getString(strPrefijo+VariableNomiConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+VariableNomiConstantesFunciones.NOMBRE));
				entity.setsql1(resultSet.getString(strPrefijo+VariableNomiConstantesFunciones.SQL1));
				entity.setsql2(resultSet.getString(strPrefijo+VariableNomiConstantesFunciones.SQL2));
				entity.setsql3(resultSet.getString(strPrefijo+VariableNomiConstantesFunciones.SQL3));
				entity.setvalor(resultSet.getDouble(strPrefijo+VariableNomiConstantesFunciones.VALOR));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+VariableNomiConstantesFunciones.CODIGO));entity.setnombre(resultSet.getString(strPrefijo+VariableNomiConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowVariableNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(VariableNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=VariableNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=VariableNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=VariableNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=VariableNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(VariableNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,VariableNomiDataAccess.TABLENAME,VariableNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			VariableNomiDataAccess.setVariableNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,VariableNomi relvariablenomi)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relvariablenomi.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Modulo getModulo(Connexion connexion,VariableNomi relvariablenomi)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relvariablenomi.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoVariableNomi getTipoVariableNomi(Connexion connexion,VariableNomi relvariablenomi)throws SQLException,Exception {

		TipoVariableNomi tipovariablenomi= new TipoVariableNomi();

		try {
			TipoVariableNomiDataAccess tipovariablenomiDataAccess=new TipoVariableNomiDataAccess();

			tipovariablenomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipovariablenomiDataAccess.setConnexionType(this.connexionType);
			tipovariablenomiDataAccess.setParameterDbType(this.parameterDbType);

			tipovariablenomi=tipovariablenomiDataAccess.getEntity(connexion,relvariablenomi.getid_tipo_variable_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipovariablenomi;

	}

	public TipoValorVariableNomi getTipoValorVariableNomi(Connexion connexion,VariableNomi relvariablenomi)throws SQLException,Exception {

		TipoValorVariableNomi tipovalorvariablenomi= new TipoValorVariableNomi();

		try {
			TipoValorVariableNomiDataAccess tipovalorvariablenomiDataAccess=new TipoValorVariableNomiDataAccess();

			tipovalorvariablenomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipovalorvariablenomiDataAccess.setConnexionType(this.connexionType);
			tipovalorvariablenomiDataAccess.setParameterDbType(this.parameterDbType);

			tipovalorvariablenomi=tipovalorvariablenomiDataAccess.getEntity(connexion,relvariablenomi.getid_tipo_valor_variable_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipovalorvariablenomi;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,VariableNomi variablenomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!variablenomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(variablenomi.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(variablenomi.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_variable_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_variable_nomi.setValue(variablenomi.getid_tipo_variable_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_variable_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_valor_variable_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_valor_variable_nomi.setValue(variablenomi.getid_tipo_valor_variable_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_valor_variable_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(variablenomi.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(variablenomi.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesql1=new ParameterValue<String>();
					parameterMaintenanceValuesql1.setValue(variablenomi.getsql1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesql1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesql2=new ParameterValue<String>();
					parameterMaintenanceValuesql2.setValue(variablenomi.getsql2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesql2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesql3=new ParameterValue<String>();
					parameterMaintenanceValuesql3.setValue(variablenomi.getsql3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesql3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(variablenomi.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!variablenomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(variablenomi.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(variablenomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(variablenomi.getId());
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
	
	public void setIsNewIsChangedFalseVariableNomi(VariableNomi variablenomi)throws Exception  {		
		variablenomi.setIsNew(false);
		variablenomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseVariableNomis(List<VariableNomi> variablenomis)throws Exception  {				
		for(VariableNomi variablenomi:variablenomis) {
			variablenomi.setIsNew(false);
			variablenomi.setIsChanged(false);
		}
	}
	
	public void generarExportarVariableNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
