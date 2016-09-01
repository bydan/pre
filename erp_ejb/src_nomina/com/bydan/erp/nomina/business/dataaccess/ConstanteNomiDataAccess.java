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
import com.bydan.erp.nomina.util.*;//ConstanteNomiConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ConstanteNomiDataAccess extends  DataAccessHelper<ConstanteNomi>{ //ConstanteNomiDataAccessAdditional,DataAccessHelper<ConstanteNomi>
	//static Logger logger = Logger.getLogger(ConstanteNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="constante_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_constante_nomi,nombre,valor,es_para_pregunta)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_constante_nomi=?,nombre=?,valor=?,es_para_pregunta=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select constantenomi from "+ConstanteNomiConstantesFunciones.SPERSISTENCENAME+" constantenomi";
	public static String QUERYSELECTNATIVE="select "+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".id,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".version_row,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".id_empresa,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".id_tipo_constante_nomi,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".nombre,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".valor,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".es_para_pregunta from "+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME;//+" as "+ConstanteNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".id,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".version_row,"+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+".nombre from "+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME;//+" as "+ConstanteNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ConstanteNomiConstantesFunciones.SCHEMA+"."+ConstanteNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_constante_nomi=?,nombre=?,valor=?,es_para_pregunta=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CONSTANTENOMI_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CONSTANTENOMI_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CONSTANTENOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CONSTANTENOMI_SELECT(?,?)";
	
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
	
	
	public ConstanteNomiDataAccess() {
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
		ConstanteNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ConstanteNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ConstanteNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setConstanteNomiOriginal(ConstanteNomi constantenomi)throws Exception  {
		constantenomi.setConstanteNomiOriginal((ConstanteNomi)constantenomi.clone());		
	}
	
	public void setConstanteNomisOriginal(List<ConstanteNomi> constantenomis)throws Exception  {
		
		for(ConstanteNomi constantenomi:constantenomis){
			constantenomi.setConstanteNomiOriginal((ConstanteNomi)constantenomi.clone());
		}
	}
	
	public static void setConstanteNomiOriginalStatic(ConstanteNomi constantenomi)throws Exception  {
		constantenomi.setConstanteNomiOriginal((ConstanteNomi)constantenomi.clone());		
	}
	
	public static void setConstanteNomisOriginalStatic(List<ConstanteNomi> constantenomis)throws Exception  {
		
		for(ConstanteNomi constantenomi:constantenomis){
			constantenomi.setConstanteNomiOriginal((ConstanteNomi)constantenomi.clone());
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
	
	public  ConstanteNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ConstanteNomi entity = new ConstanteNomi();		
		
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
	
	public  ConstanteNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ConstanteNomi entity = new ConstanteNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.ConstanteNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setConstanteNomiOriginal(new ConstanteNomi());
      	    	entity=super.getEntity("",entity,resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityConstanteNomi("",entity,resultSet); 
				
				//entity.setConstanteNomiOriginal(super.getEntity("",entity.getConstanteNomiOriginal(),resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConstanteNomiOriginal(this.getEntityConstanteNomi("",entity.getConstanteNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseConstanteNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ConstanteNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ConstanteNomi entity = new ConstanteNomi();
				
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
	
	public  ConstanteNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ConstanteNomi entity = new ConstanteNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConstanteNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.ConstanteNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setConstanteNomiOriginal(new ConstanteNomi());
      	    	entity=super.getEntity("",entity,resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityConstanteNomi("",entity,resultSet);    
				
				//entity.setConstanteNomiOriginal(super.getEntity("",entity.getConstanteNomiOriginal(),resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConstanteNomiOriginal(this.getEntityConstanteNomi("",entity.getConstanteNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseConstanteNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ConstanteNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ConstanteNomi entity = new ConstanteNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConstanteNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.ConstanteNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseConstanteNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ConstanteNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ConstanteNomi> entities = new  ArrayList<ConstanteNomi>();
		ConstanteNomi entity = new ConstanteNomi();		  
		
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
	
	public  List<ConstanteNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ConstanteNomi> entities = new  ArrayList<ConstanteNomi>();
		ConstanteNomi entity = new ConstanteNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConstanteNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConstanteNomi();
      	    	entity=super.getEntity("",entity,resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityConstanteNomi("",entity,resultSet);
      	    	
				//entity.setConstanteNomiOriginal( new ConstanteNomi());
      	    	//entity.setConstanteNomiOriginal(super.getEntity("",entity.getConstanteNomiOriginal(),resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConstanteNomiOriginal(this.getEntityConstanteNomi("",entity.getConstanteNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseConstanteNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConstanteNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ConstanteNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConstanteNomi> entities = new  ArrayList<ConstanteNomi>();
		ConstanteNomi entity = new ConstanteNomi();		  
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
	
	public  List<ConstanteNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConstanteNomi> entities = new  ArrayList<ConstanteNomi>();
		ConstanteNomi entity = new ConstanteNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConstanteNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapConstanteNomi();
					//entity.setMapConstanteNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapConstanteNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapConstanteNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA);         		
					entity=ConstanteNomiDataAccess.getEntityConstanteNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setConstanteNomiOriginal( new ConstanteNomi());
					////entity.setConstanteNomiOriginal(super.getEntity("",entity.getConstanteNomiOriginal(),resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setConstanteNomiOriginal(this.getEntityConstanteNomi("",entity.getConstanteNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseConstanteNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConstanteNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ConstanteNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ConstanteNomi entity = new ConstanteNomi();		  
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
	
	public  ConstanteNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ConstanteNomi entity = new ConstanteNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConstanteNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapConstanteNomi();
					//entity.setMapConstanteNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapConstanteNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapConstanteNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA);         		
					entity=ConstanteNomiDataAccess.getEntityConstanteNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setConstanteNomiOriginal( new ConstanteNomi());
					////entity.setConstanteNomiOriginal(super.getEntity("",entity.getConstanteNomiOriginal(),resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setConstanteNomiOriginal(this.getEntityConstanteNomi("",entity.getConstanteNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseConstanteNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConstanteNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ConstanteNomi getEntityConstanteNomi(String strPrefijo,ConstanteNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ConstanteNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ConstanteNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ConstanteNomiDataAccess.setFieldReflectionConstanteNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasConstanteNomi=ConstanteNomiConstantesFunciones.getTodosTiposColumnasConstanteNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasConstanteNomi) {
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
							field = ConstanteNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ConstanteNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ConstanteNomiDataAccess.setFieldReflectionConstanteNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionConstanteNomi(Field field,String strPrefijo,String sColumn,ConstanteNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ConstanteNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConstanteNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConstanteNomiConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConstanteNomiConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConstanteNomiConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ConstanteNomiConstantesFunciones.ESPARAPREGUNTA:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ConstanteNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ConstanteNomi> entities = new  ArrayList<ConstanteNomi>();
		ConstanteNomi entity = new ConstanteNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConstanteNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ConstanteNomi();
					entity=super.getEntity("",entity,resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityConstanteNomi("",entity,resultSet);
					
					//entity.setConstanteNomiOriginal( new ConstanteNomi());
					//entity.setConstanteNomiOriginal(super.getEntity("",entity.getConstanteNomiOriginal(),resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setConstanteNomiOriginal(this.getEntityConstanteNomi("",entity.getConstanteNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseConstanteNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConstanteNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ConstanteNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ConstanteNomi> entities = new  ArrayList<ConstanteNomi>();
		ConstanteNomi entity = new ConstanteNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConstanteNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConstanteNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ConstanteNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConstanteNomi> entities = new  ArrayList<ConstanteNomi>();
		ConstanteNomi entity = new ConstanteNomi();		  
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
	
	public  List<ConstanteNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConstanteNomi> entities = new  ArrayList<ConstanteNomi>();
		ConstanteNomi entity = new ConstanteNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConstanteNomi();
      	    	entity=super.getEntity("",entity,resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityConstanteNomi("",entity,resultSet);
      	    	
				//entity.setConstanteNomiOriginal( new ConstanteNomi());
      	    	//entity.setConstanteNomiOriginal(super.getEntity("",entity.getConstanteNomiOriginal(),resultSet,ConstanteNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConstanteNomiOriginal(this.getEntityConstanteNomi("",entity.getConstanteNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseConstanteNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConstanteNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public ConstanteNomi getEntityConstanteNomi(String strPrefijo,ConstanteNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ConstanteNomiConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_constante_nomi(resultSet.getLong(strPrefijo+ConstanteNomiConstantesFunciones.IDTIPOCONSTANTENOMI));
				entity.setnombre(resultSet.getString(strPrefijo+ConstanteNomiConstantesFunciones.NOMBRE));
				entity.setvalor(resultSet.getDouble(strPrefijo+ConstanteNomiConstantesFunciones.VALOR));
				entity.setes_para_pregunta(resultSet.getBoolean(strPrefijo+ConstanteNomiConstantesFunciones.ESPARAPREGUNTA));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+ConstanteNomiConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowConstanteNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ConstanteNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ConstanteNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ConstanteNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ConstanteNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ConstanteNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ConstanteNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ConstanteNomiDataAccess.TABLENAME,ConstanteNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			ConstanteNomiDataAccess.setConstanteNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ConstanteNomi relconstantenomi)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relconstantenomi.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoConstanteNomi getTipoConstanteNomi(Connexion connexion,ConstanteNomi relconstantenomi)throws SQLException,Exception {

		TipoConstanteNomi tipoconstantenomi= new TipoConstanteNomi();

		try {
			TipoConstanteNomiDataAccess tipoconstantenomiDataAccess=new TipoConstanteNomiDataAccess();

			tipoconstantenomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoconstantenomiDataAccess.setConnexionType(this.connexionType);
			tipoconstantenomiDataAccess.setParameterDbType(this.parameterDbType);

			tipoconstantenomi=tipoconstantenomiDataAccess.getEntity(connexion,relconstantenomi.getid_tipo_constante_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoconstantenomi;

	}


		
		public List<EmpleadoConstante> getEmpleadoConstantes(Connexion connexion,ConstanteNomi constantenomi)throws SQLException,Exception {

		List<EmpleadoConstante> empleadoconstantes= new ArrayList<EmpleadoConstante>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ConstanteNomiConstantesFunciones.SCHEMA+".constante_nomi ON "+EmpleadoConstanteConstantesFunciones.SCHEMA+".empleado_constante.id_constante_nomi="+ConstanteNomiConstantesFunciones.SCHEMA+".constante_nomi.id WHERE "+ConstanteNomiConstantesFunciones.SCHEMA+".constante_nomi.id="+String.valueOf(constantenomi.getId());
			} else {
				sQuery=" INNER JOIN empleadoconstante.ConstanteNomi WHERE empleadoconstante.ConstanteNomi.id="+String.valueOf(constantenomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoConstanteDataAccess empleadoconstanteDataAccess=new EmpleadoConstanteDataAccess();

			empleadoconstanteDataAccess.setConnexionType(this.connexionType);
			empleadoconstanteDataAccess.setParameterDbType(this.parameterDbType);
			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadoconstantes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ConstanteNomi constantenomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!constantenomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(constantenomi.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_constante_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_constante_nomi.setValue(constantenomi.getid_tipo_constante_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_constante_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(constantenomi.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(constantenomi.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_para_pregunta=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_para_pregunta.setValue(constantenomi.getes_para_pregunta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_para_pregunta);
					parametersTemp.add(parameterMaintenance);
					
						if(!constantenomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(constantenomi.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(constantenomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(constantenomi.getId());
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
	
	public void setIsNewIsChangedFalseConstanteNomi(ConstanteNomi constantenomi)throws Exception  {		
		constantenomi.setIsNew(false);
		constantenomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseConstanteNomis(List<ConstanteNomi> constantenomis)throws Exception  {				
		for(ConstanteNomi constantenomi:constantenomis) {
			constantenomi.setIsNew(false);
			constantenomi.setIsChanged(false);
		}
	}
	
	public void generarExportarConstanteNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
