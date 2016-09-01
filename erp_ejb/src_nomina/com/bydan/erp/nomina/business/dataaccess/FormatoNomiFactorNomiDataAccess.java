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
import com.bydan.erp.nomina.util.*;//FormatoNomiFactorNomiConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class FormatoNomiFactorNomiDataAccess extends  FormatoNomiFactorNomiDataAccessAdditional{ //FormatoNomiFactorNomiDataAccessAdditional,DataAccessHelper<FormatoNomiFactorNomi>
	//static Logger logger = Logger.getLogger(FormatoNomiFactorNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="formato_nomi_factor_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_formato_nomi,id_factor_nomi,ponderacion,esta_activo)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_formato_nomi=?,id_factor_nomi=?,ponderacion=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select formatonomifactornomi from "+FormatoNomiFactorNomiConstantesFunciones.SPERSISTENCENAME+" formatonomifactornomi";
	public static String QUERYSELECTNATIVE="select "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".id,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".version_row,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".id_empresa,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".id_sucursal,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".id_formato_nomi,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".id_factor_nomi,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".ponderacion,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".esta_activo from "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME;//+" as "+FormatoNomiFactorNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".id,"+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+".version_row from "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME;//+" as "+FormatoNomiFactorNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+"."+FormatoNomiFactorNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_formato_nomi=?,id_factor_nomi=?,ponderacion=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FORMATONOMIFACTORNOMI_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FORMATONOMIFACTORNOMI_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FORMATONOMIFACTORNOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FORMATONOMIFACTORNOMI_SELECT(?,?)";
	
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
	
	
	protected FormatoNomiFactorNomiDataAccessAdditional formatonomifactornomiDataAccessAdditional=null;
	
	public FormatoNomiFactorNomiDataAccessAdditional getFormatoNomiFactorNomiDataAccessAdditional() {
		return this.formatonomifactornomiDataAccessAdditional;
	}
	
	public void setFormatoNomiFactorNomiDataAccessAdditional(FormatoNomiFactorNomiDataAccessAdditional formatonomifactornomiDataAccessAdditional) {
		try {
			this.formatonomifactornomiDataAccessAdditional=formatonomifactornomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FormatoNomiFactorNomiDataAccess() {
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
		FormatoNomiFactorNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FormatoNomiFactorNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FormatoNomiFactorNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFormatoNomiFactorNomiOriginal(FormatoNomiFactorNomi formatonomifactornomi)throws Exception  {
		formatonomifactornomi.setFormatoNomiFactorNomiOriginal((FormatoNomiFactorNomi)formatonomifactornomi.clone());		
	}
	
	public void setFormatoNomiFactorNomisOriginal(List<FormatoNomiFactorNomi> formatonomifactornomis)throws Exception  {
		
		for(FormatoNomiFactorNomi formatonomifactornomi:formatonomifactornomis){
			formatonomifactornomi.setFormatoNomiFactorNomiOriginal((FormatoNomiFactorNomi)formatonomifactornomi.clone());
		}
	}
	
	public static void setFormatoNomiFactorNomiOriginalStatic(FormatoNomiFactorNomi formatonomifactornomi)throws Exception  {
		formatonomifactornomi.setFormatoNomiFactorNomiOriginal((FormatoNomiFactorNomi)formatonomifactornomi.clone());		
	}
	
	public static void setFormatoNomiFactorNomisOriginalStatic(List<FormatoNomiFactorNomi> formatonomifactornomis)throws Exception  {
		
		for(FormatoNomiFactorNomi formatonomifactornomi:formatonomifactornomis){
			formatonomifactornomi.setFormatoNomiFactorNomiOriginal((FormatoNomiFactorNomi)formatonomifactornomi.clone());
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
	
	public  FormatoNomiFactorNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		
		
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
	
	public  FormatoNomiFactorNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.FormatoNomiFactorNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFormatoNomiFactorNomiOriginal(new FormatoNomiFactorNomi());
      	    	entity=super.getEntity("",entity,resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormatoNomiFactorNomi("",entity,resultSet); 
				
				//entity.setFormatoNomiFactorNomiOriginal(super.getEntity("",entity.getFormatoNomiFactorNomiOriginal(),resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoNomiFactorNomiOriginal(this.getEntityFormatoNomiFactorNomi("",entity.getFormatoNomiFactorNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFormatoNomiFactorNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FormatoNomiFactorNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();
				
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
	
	public  FormatoNomiFactorNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoNomiFactorNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.FormatoNomiFactorNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFormatoNomiFactorNomiOriginal(new FormatoNomiFactorNomi());
      	    	entity=super.getEntity("",entity,resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormatoNomiFactorNomi("",entity,resultSet);    
				
				//entity.setFormatoNomiFactorNomiOriginal(super.getEntity("",entity.getFormatoNomiFactorNomiOriginal(),resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoNomiFactorNomiOriginal(this.getEntityFormatoNomiFactorNomi("",entity.getFormatoNomiFactorNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFormatoNomiFactorNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FormatoNomiFactorNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoNomiFactorNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.FormatoNomiFactorNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFormatoNomiFactorNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FormatoNomiFactorNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormatoNomiFactorNomi> entities = new  ArrayList<FormatoNomiFactorNomi>();
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
		
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
	
	public  List<FormatoNomiFactorNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormatoNomiFactorNomi> entities = new  ArrayList<FormatoNomiFactorNomi>();
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoNomiFactorNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormatoNomiFactorNomi();
      	    	entity=super.getEntity("",entity,resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormatoNomiFactorNomi("",entity,resultSet);
      	    	
				//entity.setFormatoNomiFactorNomiOriginal( new FormatoNomiFactorNomi());
      	    	//entity.setFormatoNomiFactorNomiOriginal(super.getEntity("",entity.getFormatoNomiFactorNomiOriginal(),resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoNomiFactorNomiOriginal(this.getEntityFormatoNomiFactorNomi("",entity.getFormatoNomiFactorNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormatoNomiFactorNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormatoNomiFactorNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormatoNomiFactorNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormatoNomiFactorNomi> entities = new  ArrayList<FormatoNomiFactorNomi>();
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
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
	
	public  List<FormatoNomiFactorNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormatoNomiFactorNomi> entities = new  ArrayList<FormatoNomiFactorNomi>();
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormatoNomiFactorNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapFormatoNomiFactorNomi();
					//entity.setMapFormatoNomiFactorNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFormatoNomiFactorNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormatoNomiFactorNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA);         		
					entity=FormatoNomiFactorNomiDataAccess.getEntityFormatoNomiFactorNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormatoNomiFactorNomiOriginal( new FormatoNomiFactorNomi());
					////entity.setFormatoNomiFactorNomiOriginal(super.getEntity("",entity.getFormatoNomiFactorNomiOriginal(),resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setFormatoNomiFactorNomiOriginal(this.getEntityFormatoNomiFactorNomi("",entity.getFormatoNomiFactorNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormatoNomiFactorNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormatoNomiFactorNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FormatoNomiFactorNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
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
	
	public  FormatoNomiFactorNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormatoNomiFactorNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapFormatoNomiFactorNomi();
					//entity.setMapFormatoNomiFactorNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFormatoNomiFactorNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormatoNomiFactorNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA);         		
					entity=FormatoNomiFactorNomiDataAccess.getEntityFormatoNomiFactorNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormatoNomiFactorNomiOriginal( new FormatoNomiFactorNomi());
					////entity.setFormatoNomiFactorNomiOriginal(super.getEntity("",entity.getFormatoNomiFactorNomiOriginal(),resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setFormatoNomiFactorNomiOriginal(this.getEntityFormatoNomiFactorNomi("",entity.getFormatoNomiFactorNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFormatoNomiFactorNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormatoNomiFactorNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FormatoNomiFactorNomi getEntityFormatoNomiFactorNomi(String strPrefijo,FormatoNomiFactorNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FormatoNomiFactorNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FormatoNomiFactorNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FormatoNomiFactorNomiDataAccess.setFieldReflectionFormatoNomiFactorNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFormatoNomiFactorNomi=FormatoNomiFactorNomiConstantesFunciones.getTodosTiposColumnasFormatoNomiFactorNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFormatoNomiFactorNomi) {
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
							field = FormatoNomiFactorNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FormatoNomiFactorNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FormatoNomiFactorNomiDataAccess.setFieldReflectionFormatoNomiFactorNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFormatoNomiFactorNomi(Field field,String strPrefijo,String sColumn,FormatoNomiFactorNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FormatoNomiFactorNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoNomiFactorNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoNomiFactorNomiConstantesFunciones.PONDERACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormatoNomiFactorNomiConstantesFunciones.ESTAACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormatoNomiFactorNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FormatoNomiFactorNomi> entities = new  ArrayList<FormatoNomiFactorNomi>();
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoNomiFactorNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FormatoNomiFactorNomi();
					entity=super.getEntity("",entity,resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFormatoNomiFactorNomi("",entity,resultSet);
					
					//entity.setFormatoNomiFactorNomiOriginal( new FormatoNomiFactorNomi());
					//entity.setFormatoNomiFactorNomiOriginal(super.getEntity("",entity.getFormatoNomiFactorNomiOriginal(),resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setFormatoNomiFactorNomiOriginal(this.getEntityFormatoNomiFactorNomi("",entity.getFormatoNomiFactorNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFormatoNomiFactorNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormatoNomiFactorNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormatoNomiFactorNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FormatoNomiFactorNomi> entities = new  ArrayList<FormatoNomiFactorNomi>();
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormatoNomiFactorNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoNomiFactorNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FormatoNomiFactorNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormatoNomiFactorNomi> entities = new  ArrayList<FormatoNomiFactorNomi>();
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
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
	
	public  List<FormatoNomiFactorNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormatoNomiFactorNomi> entities = new  ArrayList<FormatoNomiFactorNomi>();
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormatoNomiFactorNomi();
      	    	entity=super.getEntity("",entity,resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormatoNomiFactorNomi("",entity,resultSet);
      	    	
				//entity.setFormatoNomiFactorNomiOriginal( new FormatoNomiFactorNomi());
      	    	//entity.setFormatoNomiFactorNomiOriginal(super.getEntity("",entity.getFormatoNomiFactorNomiOriginal(),resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoNomiFactorNomiOriginal(this.getEntityFormatoNomiFactorNomi("",entity.getFormatoNomiFactorNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFormatoNomiFactorNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormatoNomiFactorNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormatoNomiFactorNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormatoNomiFactorNomi> entities = new  ArrayList<FormatoNomiFactorNomi>();
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
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
	
	public  List<FormatoNomiFactorNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormatoNomiFactorNomi> entities = new  ArrayList<FormatoNomiFactorNomi>();
		FormatoNomiFactorNomi entity = new FormatoNomiFactorNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormatoNomiFactorNomi();
      	    	entity=super.getEntity("",entity,resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormatoNomiFactorNomi("",entity,resultSet);
      	    	
				//entity.setFormatoNomiFactorNomiOriginal( new FormatoNomiFactorNomi());
      	    	//entity.setFormatoNomiFactorNomiOriginal(super.getEntity("",entity.getFormatoNomiFactorNomiOriginal(),resultSet,FormatoNomiFactorNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoNomiFactorNomiOriginal(this.getEntityFormatoNomiFactorNomi("",entity.getFormatoNomiFactorNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormatoNomiFactorNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FormatoNomiFactorNomi getEntityFormatoNomiFactorNomi(String strPrefijo,FormatoNomiFactorNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FormatoNomiFactorNomiConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+FormatoNomiFactorNomiConstantesFunciones.IDSUCURSAL));
				entity.setid_formato_nomi(resultSet.getLong(strPrefijo+FormatoNomiFactorNomiConstantesFunciones.IDFORMATONOMI));
				entity.setid_factor_nomi(resultSet.getLong(strPrefijo+FormatoNomiFactorNomiConstantesFunciones.IDFACTORNOMI));
				entity.setponderacion(resultSet.getDouble(strPrefijo+FormatoNomiFactorNomiConstantesFunciones.PONDERACION));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+FormatoNomiFactorNomiConstantesFunciones.ESTAACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFormatoNomiFactorNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FormatoNomiFactorNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FormatoNomiFactorNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FormatoNomiFactorNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FormatoNomiFactorNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FormatoNomiFactorNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FormatoNomiFactorNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FormatoNomiFactorNomiDataAccess.TABLENAME,FormatoNomiFactorNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			FormatoNomiFactorNomiDataAccess.setFormatoNomiFactorNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FormatoNomiFactorNomi relformatonomifactornomi)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relformatonomifactornomi.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,FormatoNomiFactorNomi relformatonomifactornomi)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relformatonomifactornomi.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public FormatoNomi getFormatoNomi(Connexion connexion,FormatoNomiFactorNomi relformatonomifactornomi)throws SQLException,Exception {

		FormatoNomi formatonomi= new FormatoNomi();

		try {
			FormatoNomiDataAccess formatonomiDataAccess=new FormatoNomiDataAccess();

			formatonomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatonomiDataAccess.setConnexionType(this.connexionType);
			formatonomiDataAccess.setParameterDbType(this.parameterDbType);

			formatonomi=formatonomiDataAccess.getEntity(connexion,relformatonomifactornomi.getid_formato_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatonomi;

	}

	public FactorNomi getFactorNomi(Connexion connexion,FormatoNomiFactorNomi relformatonomifactornomi)throws SQLException,Exception {

		FactorNomi factornomi= new FactorNomi();

		try {
			FactorNomiDataAccess factornomiDataAccess=new FactorNomiDataAccess();

			factornomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			factornomiDataAccess.setConnexionType(this.connexionType);
			factornomiDataAccess.setParameterDbType(this.parameterDbType);

			factornomi=factornomiDataAccess.getEntity(connexion,relformatonomifactornomi.getid_factor_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factornomi;

	}


		
		public List<CalificacionEmpleado> getCalificacionEmpleados(Connexion connexion,FormatoNomiFactorNomi formatonomifactornomi)throws SQLException,Exception {

		List<CalificacionEmpleado> calificacionempleados= new ArrayList<CalificacionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+".formato_nomi_factor_nomi ON "+CalificacionEmpleadoConstantesFunciones.SCHEMA+".calificacion_empleado.id_formato_nomi_factor_nomi="+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+".formato_nomi_factor_nomi.id WHERE "+FormatoNomiFactorNomiConstantesFunciones.SCHEMA+".formato_nomi_factor_nomi.id="+String.valueOf(formatonomifactornomi.getId());
			} else {
				sQuery=" INNER JOIN calificacionempleado.FormatoNomiFactorNomi WHERE calificacionempleado.FormatoNomiFactorNomi.id="+String.valueOf(formatonomifactornomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CalificacionEmpleadoDataAccess calificacionempleadoDataAccess=new CalificacionEmpleadoDataAccess();

			calificacionempleadoDataAccess.setConnexionType(this.connexionType);
			calificacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return calificacionempleados;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FormatoNomiFactorNomi formatonomifactornomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!formatonomifactornomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(formatonomifactornomi.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(formatonomifactornomi.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_nomi.setValue(formatonomifactornomi.getid_formato_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factor_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_factor_nomi.setValue(formatonomifactornomi.getid_factor_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factor_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueponderacion=new ParameterValue<Double>();
					parameterMaintenanceValueponderacion.setValue(formatonomifactornomi.getponderacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueponderacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(formatonomifactornomi.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!formatonomifactornomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(formatonomifactornomi.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(formatonomifactornomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(formatonomifactornomi.getId());
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
	
	public void setIsNewIsChangedFalseFormatoNomiFactorNomi(FormatoNomiFactorNomi formatonomifactornomi)throws Exception  {		
		formatonomifactornomi.setIsNew(false);
		formatonomifactornomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFormatoNomiFactorNomis(List<FormatoNomiFactorNomi> formatonomifactornomis)throws Exception  {				
		for(FormatoNomiFactorNomi formatonomifactornomi:formatonomifactornomis) {
			formatonomifactornomi.setIsNew(false);
			formatonomifactornomi.setIsChanged(false);
		}
	}
	
	public void generarExportarFormatoNomiFactorNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
