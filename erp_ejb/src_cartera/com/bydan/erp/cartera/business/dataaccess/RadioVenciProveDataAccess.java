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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//RadioVenciProveConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class RadioVenciProveDataAccess extends  RadioVenciProveDataAccessAdditional{ //RadioVenciProveDataAccessAdditional,DataAccessHelper<RadioVenciProve>
	//static Logger logger = Logger.getLogger(RadioVenciProveDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="radio_venci_prove";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_radio_venci,dia_desde,dia_hasta)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_radio_venci=?,dia_desde=?,dia_hasta=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select radiovenciprove from "+RadioVenciProveConstantesFunciones.SPERSISTENCENAME+" radiovenciprove";
	public static String QUERYSELECTNATIVE="select "+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".id,"+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".version_row,"+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".id_empresa,"+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".id_tipo_radio_venci,"+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".dia_desde,"+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".dia_hasta from "+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME;//+" as "+RadioVenciProveConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".id,"+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+".version_row from "+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME;//+" as "+RadioVenciProveConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RadioVenciProveConstantesFunciones.SCHEMA+"."+RadioVenciProveConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_radio_venci=?,dia_desde=?,dia_hasta=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RADIOVENCIPROVE_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RADIOVENCIPROVE_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RADIOVENCIPROVE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RADIOVENCIPROVE_SELECT(?,?)";
	
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
	
	
	protected RadioVenciProveDataAccessAdditional radiovenciproveDataAccessAdditional=null;
	
	public RadioVenciProveDataAccessAdditional getRadioVenciProveDataAccessAdditional() {
		return this.radiovenciproveDataAccessAdditional;
	}
	
	public void setRadioVenciProveDataAccessAdditional(RadioVenciProveDataAccessAdditional radiovenciproveDataAccessAdditional) {
		try {
			this.radiovenciproveDataAccessAdditional=radiovenciproveDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RadioVenciProveDataAccess() {
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
		RadioVenciProveDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RadioVenciProveDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RadioVenciProveDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRadioVenciProveOriginal(RadioVenciProve radiovenciprove)throws Exception  {
		radiovenciprove.setRadioVenciProveOriginal((RadioVenciProve)radiovenciprove.clone());		
	}
	
	public void setRadioVenciProvesOriginal(List<RadioVenciProve> radiovenciproves)throws Exception  {
		
		for(RadioVenciProve radiovenciprove:radiovenciproves){
			radiovenciprove.setRadioVenciProveOriginal((RadioVenciProve)radiovenciprove.clone());
		}
	}
	
	public static void setRadioVenciProveOriginalStatic(RadioVenciProve radiovenciprove)throws Exception  {
		radiovenciprove.setRadioVenciProveOriginal((RadioVenciProve)radiovenciprove.clone());		
	}
	
	public static void setRadioVenciProvesOriginalStatic(List<RadioVenciProve> radiovenciproves)throws Exception  {
		
		for(RadioVenciProve radiovenciprove:radiovenciproves){
			radiovenciprove.setRadioVenciProveOriginal((RadioVenciProve)radiovenciprove.clone());
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
	
	public  RadioVenciProve getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RadioVenciProve entity = new RadioVenciProve();		
		
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
	
	public  RadioVenciProve getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RadioVenciProve entity = new RadioVenciProve();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.RadioVenciProve.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRadioVenciProveOriginal(new RadioVenciProve());
      	    	entity=super.getEntity("",entity,resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRadioVenciProve("",entity,resultSet); 
				
				//entity.setRadioVenciProveOriginal(super.getEntity("",entity.getRadioVenciProveOriginal(),resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRadioVenciProveOriginal(this.getEntityRadioVenciProve("",entity.getRadioVenciProveOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRadioVenciProve(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RadioVenciProve getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RadioVenciProve entity = new RadioVenciProve();
				
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
	
	public  RadioVenciProve getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RadioVenciProve entity = new RadioVenciProve();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RadioVenciProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.RadioVenciProve.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRadioVenciProveOriginal(new RadioVenciProve());
      	    	entity=super.getEntity("",entity,resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRadioVenciProve("",entity,resultSet);    
				
				//entity.setRadioVenciProveOriginal(super.getEntity("",entity.getRadioVenciProveOriginal(),resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRadioVenciProveOriginal(this.getEntityRadioVenciProve("",entity.getRadioVenciProveOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRadioVenciProve(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RadioVenciProve
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RadioVenciProve entity = new RadioVenciProve();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RadioVenciProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.RadioVenciProve.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRadioVenciProve(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RadioVenciProve> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RadioVenciProve> entities = new  ArrayList<RadioVenciProve>();
		RadioVenciProve entity = new RadioVenciProve();		  
		
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
	
	public  List<RadioVenciProve> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RadioVenciProve> entities = new  ArrayList<RadioVenciProve>();
		RadioVenciProve entity = new RadioVenciProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RadioVenciProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RadioVenciProve();
      	    	entity=super.getEntity("",entity,resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRadioVenciProve("",entity,resultSet);
      	    	
				//entity.setRadioVenciProveOriginal( new RadioVenciProve());
      	    	//entity.setRadioVenciProveOriginal(super.getEntity("",entity.getRadioVenciProveOriginal(),resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRadioVenciProveOriginal(this.getEntityRadioVenciProve("",entity.getRadioVenciProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRadioVenciProves(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRadioVenciProve(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RadioVenciProve> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RadioVenciProve> entities = new  ArrayList<RadioVenciProve>();
		RadioVenciProve entity = new RadioVenciProve();		  
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
	
	public  List<RadioVenciProve> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RadioVenciProve> entities = new  ArrayList<RadioVenciProve>();
		RadioVenciProve entity = new RadioVenciProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RadioVenciProve();
				
				if(conMapGenerico) {
					entity.inicializarMapRadioVenciProve();
					//entity.setMapRadioVenciProve(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRadioVenciProveValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRadioVenciProve().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA);         		
					entity=RadioVenciProveDataAccess.getEntityRadioVenciProve("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRadioVenciProveOriginal( new RadioVenciProve());
					////entity.setRadioVenciProveOriginal(super.getEntity("",entity.getRadioVenciProveOriginal(),resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA));         		
					////entity.setRadioVenciProveOriginal(this.getEntityRadioVenciProve("",entity.getRadioVenciProveOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRadioVenciProves(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRadioVenciProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RadioVenciProve getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RadioVenciProve entity = new RadioVenciProve();		  
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
	
	public  RadioVenciProve getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RadioVenciProve entity = new RadioVenciProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RadioVenciProve();
				
				if(conMapGenerico) {
					entity.inicializarMapRadioVenciProve();
					//entity.setMapRadioVenciProve(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRadioVenciProveValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRadioVenciProve().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA);         		
					entity=RadioVenciProveDataAccess.getEntityRadioVenciProve("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRadioVenciProveOriginal( new RadioVenciProve());
					////entity.setRadioVenciProveOriginal(super.getEntity("",entity.getRadioVenciProveOriginal(),resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA));         		
					////entity.setRadioVenciProveOriginal(this.getEntityRadioVenciProve("",entity.getRadioVenciProveOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRadioVenciProve(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRadioVenciProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RadioVenciProve getEntityRadioVenciProve(String strPrefijo,RadioVenciProve entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RadioVenciProve.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RadioVenciProve.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RadioVenciProveDataAccess.setFieldReflectionRadioVenciProve(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRadioVenciProve=RadioVenciProveConstantesFunciones.getTodosTiposColumnasRadioVenciProve();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRadioVenciProve) {
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
							field = RadioVenciProve.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RadioVenciProve.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RadioVenciProveDataAccess.setFieldReflectionRadioVenciProve(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRadioVenciProve(Field field,String strPrefijo,String sColumn,RadioVenciProve entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RadioVenciProveConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RadioVenciProveConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RadioVenciProveConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RadioVenciProveConstantesFunciones.DIADESDE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case RadioVenciProveConstantesFunciones.DIAHASTA:
					field.set(entity,resultSet.getInt(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RadioVenciProve>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RadioVenciProve> entities = new  ArrayList<RadioVenciProve>();
		RadioVenciProve entity = new RadioVenciProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RadioVenciProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RadioVenciProve();
					entity=super.getEntity("",entity,resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRadioVenciProve("",entity,resultSet);
					
					//entity.setRadioVenciProveOriginal( new RadioVenciProve());
					//entity.setRadioVenciProveOriginal(super.getEntity("",entity.getRadioVenciProveOriginal(),resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA));         		
					//entity.setRadioVenciProveOriginal(this.getEntityRadioVenciProve("",entity.getRadioVenciProveOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRadioVenciProves(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRadioVenciProve(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RadioVenciProve>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RadioVenciProve> entities = new  ArrayList<RadioVenciProve>();
		RadioVenciProve entity = new RadioVenciProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RadioVenciProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RadioVenciProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RadioVenciProve> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RadioVenciProve> entities = new  ArrayList<RadioVenciProve>();
		RadioVenciProve entity = new RadioVenciProve();		  
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
	
	public  List<RadioVenciProve> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RadioVenciProve> entities = new  ArrayList<RadioVenciProve>();
		RadioVenciProve entity = new RadioVenciProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RadioVenciProve();
      	    	entity=super.getEntity("",entity,resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRadioVenciProve("",entity,resultSet);
      	    	
				//entity.setRadioVenciProveOriginal( new RadioVenciProve());
      	    	//entity.setRadioVenciProveOriginal(super.getEntity("",entity.getRadioVenciProveOriginal(),resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRadioVenciProveOriginal(this.getEntityRadioVenciProve("",entity.getRadioVenciProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRadioVenciProves(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRadioVenciProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RadioVenciProve> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RadioVenciProve> entities = new  ArrayList<RadioVenciProve>();
		RadioVenciProve entity = new RadioVenciProve();		  
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
	
	public  List<RadioVenciProve> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RadioVenciProve> entities = new  ArrayList<RadioVenciProve>();
		RadioVenciProve entity = new RadioVenciProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RadioVenciProve();
      	    	entity=super.getEntity("",entity,resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRadioVenciProve("",entity,resultSet);
      	    	
				//entity.setRadioVenciProveOriginal( new RadioVenciProve());
      	    	//entity.setRadioVenciProveOriginal(super.getEntity("",entity.getRadioVenciProveOriginal(),resultSet,RadioVenciProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRadioVenciProveOriginal(this.getEntityRadioVenciProve("",entity.getRadioVenciProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRadioVenciProves(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RadioVenciProve getEntityRadioVenciProve(String strPrefijo,RadioVenciProve entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RadioVenciProveConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_radio_venci(resultSet.getLong(strPrefijo+RadioVenciProveConstantesFunciones.IDTIPORADIOVENCI));
				entity.setdia_desde(resultSet.getInt(strPrefijo+RadioVenciProveConstantesFunciones.DIADESDE));
				entity.setdia_hasta(resultSet.getInt(strPrefijo+RadioVenciProveConstantesFunciones.DIAHASTA));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRadioVenciProve(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RadioVenciProve entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RadioVenciProveDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RadioVenciProveDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RadioVenciProveDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RadioVenciProveDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RadioVenciProveConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RadioVenciProveDataAccess.TABLENAME,RadioVenciProveDataAccess.ISWITHSTOREPROCEDURES);
			
			RadioVenciProveDataAccess.setRadioVenciProveOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,RadioVenciProve relradiovenciprove)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relradiovenciprove.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoRadioVenci getTipoRadioVenci(Connexion connexion,RadioVenciProve relradiovenciprove)throws SQLException,Exception {

		TipoRadioVenci tiporadiovenci= new TipoRadioVenci();

		try {
			TipoRadioVenciDataAccess tiporadiovenciDataAccess=new TipoRadioVenciDataAccess();

			tiporadiovenciDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporadiovenciDataAccess.setConnexionType(this.connexionType);
			tiporadiovenciDataAccess.setParameterDbType(this.parameterDbType);

			tiporadiovenci=tiporadiovenciDataAccess.getEntity(connexion,relradiovenciprove.getid_tipo_radio_venci());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporadiovenci;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RadioVenciProve radiovenciprove) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!radiovenciprove.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(radiovenciprove.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_radio_venci=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_radio_venci.setValue(radiovenciprove.getid_tipo_radio_venci());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_radio_venci);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedia_desde=new ParameterValue<Integer>();
					parameterMaintenanceValuedia_desde.setValue(radiovenciprove.getdia_desde());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedia_desde);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedia_hasta=new ParameterValue<Integer>();
					parameterMaintenanceValuedia_hasta.setValue(radiovenciprove.getdia_hasta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedia_hasta);
					parametersTemp.add(parameterMaintenance);
					
						if(!radiovenciprove.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(radiovenciprove.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(radiovenciprove.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(radiovenciprove.getId());
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
	
	public void setIsNewIsChangedFalseRadioVenciProve(RadioVenciProve radiovenciprove)throws Exception  {		
		radiovenciprove.setIsNew(false);
		radiovenciprove.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRadioVenciProves(List<RadioVenciProve> radiovenciproves)throws Exception  {				
		for(RadioVenciProve radiovenciprove:radiovenciproves) {
			radiovenciprove.setIsNew(false);
			radiovenciprove.setIsChanged(false);
		}
	}
	
	public void generarExportarRadioVenciProve(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
