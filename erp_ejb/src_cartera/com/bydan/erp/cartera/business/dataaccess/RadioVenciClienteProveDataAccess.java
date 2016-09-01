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
import com.bydan.erp.cartera.util.*;//RadioVenciClienteProveConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class RadioVenciClienteProveDataAccess extends  RadioVenciClienteProveDataAccessAdditional{ //RadioVenciClienteProveDataAccessAdditional,DataAccessHelper<RadioVenciClienteProve>
	//static Logger logger = Logger.getLogger(RadioVenciClienteProveDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="radio_venci_cliente_prove";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_radio_venci,dia_desde,dia_hasta)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_radio_venci=?,dia_desde=?,dia_hasta=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select radiovenciclienteprove from "+RadioVenciClienteProveConstantesFunciones.SPERSISTENCENAME+" radiovenciclienteprove";
	public static String QUERYSELECTNATIVE="select "+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".id,"+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".version_row,"+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".id_empresa,"+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".id_tipo_radio_venci,"+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".dia_desde,"+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".dia_hasta from "+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME;//+" as "+RadioVenciClienteProveConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".id,"+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+".version_row from "+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME;//+" as "+RadioVenciClienteProveConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RadioVenciClienteProveConstantesFunciones.SCHEMA+"."+RadioVenciClienteProveConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_radio_venci=?,dia_desde=?,dia_hasta=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RADIOVENCICLIENTEPROVE_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RADIOVENCICLIENTEPROVE_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RADIOVENCICLIENTEPROVE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RADIOVENCICLIENTEPROVE_SELECT(?,?)";
	
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
	
	
	protected RadioVenciClienteProveDataAccessAdditional radiovenciclienteproveDataAccessAdditional=null;
	
	public RadioVenciClienteProveDataAccessAdditional getRadioVenciClienteProveDataAccessAdditional() {
		return this.radiovenciclienteproveDataAccessAdditional;
	}
	
	public void setRadioVenciClienteProveDataAccessAdditional(RadioVenciClienteProveDataAccessAdditional radiovenciclienteproveDataAccessAdditional) {
		try {
			this.radiovenciclienteproveDataAccessAdditional=radiovenciclienteproveDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RadioVenciClienteProveDataAccess() {
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
		RadioVenciClienteProveDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RadioVenciClienteProveDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RadioVenciClienteProveDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRadioVenciClienteProveOriginal(RadioVenciClienteProve radiovenciclienteprove)throws Exception  {
		radiovenciclienteprove.setRadioVenciClienteProveOriginal((RadioVenciClienteProve)radiovenciclienteprove.clone());		
	}
	
	public void setRadioVenciClienteProvesOriginal(List<RadioVenciClienteProve> radiovenciclienteproves)throws Exception  {
		
		for(RadioVenciClienteProve radiovenciclienteprove:radiovenciclienteproves){
			radiovenciclienteprove.setRadioVenciClienteProveOriginal((RadioVenciClienteProve)radiovenciclienteprove.clone());
		}
	}
	
	public static void setRadioVenciClienteProveOriginalStatic(RadioVenciClienteProve radiovenciclienteprove)throws Exception  {
		radiovenciclienteprove.setRadioVenciClienteProveOriginal((RadioVenciClienteProve)radiovenciclienteprove.clone());		
	}
	
	public static void setRadioVenciClienteProvesOriginalStatic(List<RadioVenciClienteProve> radiovenciclienteproves)throws Exception  {
		
		for(RadioVenciClienteProve radiovenciclienteprove:radiovenciclienteproves){
			radiovenciclienteprove.setRadioVenciClienteProveOriginal((RadioVenciClienteProve)radiovenciclienteprove.clone());
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
	
	public  RadioVenciClienteProve getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		
		
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
	
	public  RadioVenciClienteProve getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.RadioVenciClienteProve.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRadioVenciClienteProveOriginal(new RadioVenciClienteProve());
      	    	entity=super.getEntity("",entity,resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRadioVenciClienteProve("",entity,resultSet); 
				
				//entity.setRadioVenciClienteProveOriginal(super.getEntity("",entity.getRadioVenciClienteProveOriginal(),resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRadioVenciClienteProveOriginal(this.getEntityRadioVenciClienteProve("",entity.getRadioVenciClienteProveOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRadioVenciClienteProve(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RadioVenciClienteProve getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RadioVenciClienteProve entity = new RadioVenciClienteProve();
				
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
	
	public  RadioVenciClienteProve getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RadioVenciClienteProve entity = new RadioVenciClienteProve();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RadioVenciClienteProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.RadioVenciClienteProve.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRadioVenciClienteProveOriginal(new RadioVenciClienteProve());
      	    	entity=super.getEntity("",entity,resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRadioVenciClienteProve("",entity,resultSet);    
				
				//entity.setRadioVenciClienteProveOriginal(super.getEntity("",entity.getRadioVenciClienteProveOriginal(),resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRadioVenciClienteProveOriginal(this.getEntityRadioVenciClienteProve("",entity.getRadioVenciClienteProveOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRadioVenciClienteProve(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RadioVenciClienteProve
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RadioVenciClienteProve entity = new RadioVenciClienteProve();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RadioVenciClienteProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.RadioVenciClienteProve.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRadioVenciClienteProve(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RadioVenciClienteProve> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RadioVenciClienteProve> entities = new  ArrayList<RadioVenciClienteProve>();
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
		
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
	
	public  List<RadioVenciClienteProve> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RadioVenciClienteProve> entities = new  ArrayList<RadioVenciClienteProve>();
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RadioVenciClienteProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RadioVenciClienteProve();
      	    	entity=super.getEntity("",entity,resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRadioVenciClienteProve("",entity,resultSet);
      	    	
				//entity.setRadioVenciClienteProveOriginal( new RadioVenciClienteProve());
      	    	//entity.setRadioVenciClienteProveOriginal(super.getEntity("",entity.getRadioVenciClienteProveOriginal(),resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRadioVenciClienteProveOriginal(this.getEntityRadioVenciClienteProve("",entity.getRadioVenciClienteProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRadioVenciClienteProves(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRadioVenciClienteProve(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RadioVenciClienteProve> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RadioVenciClienteProve> entities = new  ArrayList<RadioVenciClienteProve>();
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
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
	
	public  List<RadioVenciClienteProve> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RadioVenciClienteProve> entities = new  ArrayList<RadioVenciClienteProve>();
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RadioVenciClienteProve();
				
				if(conMapGenerico) {
					entity.inicializarMapRadioVenciClienteProve();
					//entity.setMapRadioVenciClienteProve(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRadioVenciClienteProveValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRadioVenciClienteProve().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA);         		
					entity=RadioVenciClienteProveDataAccess.getEntityRadioVenciClienteProve("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRadioVenciClienteProveOriginal( new RadioVenciClienteProve());
					////entity.setRadioVenciClienteProveOriginal(super.getEntity("",entity.getRadioVenciClienteProveOriginal(),resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA));         		
					////entity.setRadioVenciClienteProveOriginal(this.getEntityRadioVenciClienteProve("",entity.getRadioVenciClienteProveOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRadioVenciClienteProves(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRadioVenciClienteProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RadioVenciClienteProve getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
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
	
	public  RadioVenciClienteProve getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RadioVenciClienteProve();
				
				if(conMapGenerico) {
					entity.inicializarMapRadioVenciClienteProve();
					//entity.setMapRadioVenciClienteProve(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRadioVenciClienteProveValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRadioVenciClienteProve().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA);         		
					entity=RadioVenciClienteProveDataAccess.getEntityRadioVenciClienteProve("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRadioVenciClienteProveOriginal( new RadioVenciClienteProve());
					////entity.setRadioVenciClienteProveOriginal(super.getEntity("",entity.getRadioVenciClienteProveOriginal(),resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA));         		
					////entity.setRadioVenciClienteProveOriginal(this.getEntityRadioVenciClienteProve("",entity.getRadioVenciClienteProveOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRadioVenciClienteProve(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRadioVenciClienteProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RadioVenciClienteProve getEntityRadioVenciClienteProve(String strPrefijo,RadioVenciClienteProve entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RadioVenciClienteProve.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RadioVenciClienteProve.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RadioVenciClienteProveDataAccess.setFieldReflectionRadioVenciClienteProve(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRadioVenciClienteProve=RadioVenciClienteProveConstantesFunciones.getTodosTiposColumnasRadioVenciClienteProve();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRadioVenciClienteProve) {
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
							field = RadioVenciClienteProve.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RadioVenciClienteProve.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RadioVenciClienteProveDataAccess.setFieldReflectionRadioVenciClienteProve(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRadioVenciClienteProve(Field field,String strPrefijo,String sColumn,RadioVenciClienteProve entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RadioVenciClienteProveConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RadioVenciClienteProveConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RadioVenciClienteProveConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RadioVenciClienteProveConstantesFunciones.DIADESDE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case RadioVenciClienteProveConstantesFunciones.DIAHASTA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RadioVenciClienteProve>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RadioVenciClienteProve> entities = new  ArrayList<RadioVenciClienteProve>();
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RadioVenciClienteProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RadioVenciClienteProve();
					entity=super.getEntity("",entity,resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRadioVenciClienteProve("",entity,resultSet);
					
					//entity.setRadioVenciClienteProveOriginal( new RadioVenciClienteProve());
					//entity.setRadioVenciClienteProveOriginal(super.getEntity("",entity.getRadioVenciClienteProveOriginal(),resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA));         		
					//entity.setRadioVenciClienteProveOriginal(this.getEntityRadioVenciClienteProve("",entity.getRadioVenciClienteProveOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRadioVenciClienteProves(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRadioVenciClienteProve(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RadioVenciClienteProve>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RadioVenciClienteProve> entities = new  ArrayList<RadioVenciClienteProve>();
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RadioVenciClienteProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RadioVenciClienteProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RadioVenciClienteProve> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RadioVenciClienteProve> entities = new  ArrayList<RadioVenciClienteProve>();
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
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
	
	public  List<RadioVenciClienteProve> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RadioVenciClienteProve> entities = new  ArrayList<RadioVenciClienteProve>();
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RadioVenciClienteProve();
      	    	entity=super.getEntity("",entity,resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRadioVenciClienteProve("",entity,resultSet);
      	    	
				//entity.setRadioVenciClienteProveOriginal( new RadioVenciClienteProve());
      	    	//entity.setRadioVenciClienteProveOriginal(super.getEntity("",entity.getRadioVenciClienteProveOriginal(),resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRadioVenciClienteProveOriginal(this.getEntityRadioVenciClienteProve("",entity.getRadioVenciClienteProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRadioVenciClienteProves(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRadioVenciClienteProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RadioVenciClienteProve> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RadioVenciClienteProve> entities = new  ArrayList<RadioVenciClienteProve>();
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
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
	
	public  List<RadioVenciClienteProve> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RadioVenciClienteProve> entities = new  ArrayList<RadioVenciClienteProve>();
		RadioVenciClienteProve entity = new RadioVenciClienteProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RadioVenciClienteProve();
      	    	entity=super.getEntity("",entity,resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRadioVenciClienteProve("",entity,resultSet);
      	    	
				//entity.setRadioVenciClienteProveOriginal( new RadioVenciClienteProve());
      	    	//entity.setRadioVenciClienteProveOriginal(super.getEntity("",entity.getRadioVenciClienteProveOriginal(),resultSet,RadioVenciClienteProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRadioVenciClienteProveOriginal(this.getEntityRadioVenciClienteProve("",entity.getRadioVenciClienteProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRadioVenciClienteProves(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RadioVenciClienteProve getEntityRadioVenciClienteProve(String strPrefijo,RadioVenciClienteProve entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RadioVenciClienteProveConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_radio_venci(resultSet.getLong(strPrefijo+RadioVenciClienteProveConstantesFunciones.IDTIPORADIOVENCI));
				entity.setdia_desde(resultSet.getInt(strPrefijo+RadioVenciClienteProveConstantesFunciones.DIADESDE));
				entity.setdia_hasta(resultSet.getInt(strPrefijo+RadioVenciClienteProveConstantesFunciones.DIAHASTA));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRadioVenciClienteProve(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RadioVenciClienteProve entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RadioVenciClienteProveDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RadioVenciClienteProveDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RadioVenciClienteProveDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RadioVenciClienteProveDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RadioVenciClienteProveConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RadioVenciClienteProveDataAccess.TABLENAME,RadioVenciClienteProveDataAccess.ISWITHSTOREPROCEDURES);
			
			RadioVenciClienteProveDataAccess.setRadioVenciClienteProveOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,RadioVenciClienteProve relradiovenciclienteprove)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relradiovenciclienteprove.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoRadioVenci getTipoRadioVenci(Connexion connexion,RadioVenciClienteProve relradiovenciclienteprove)throws SQLException,Exception {

		TipoRadioVenci tiporadiovenci= new TipoRadioVenci();

		try {
			TipoRadioVenciDataAccess tiporadiovenciDataAccess=new TipoRadioVenciDataAccess();

			tiporadiovenciDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporadiovenciDataAccess.setConnexionType(this.connexionType);
			tiporadiovenciDataAccess.setParameterDbType(this.parameterDbType);

			tiporadiovenci=tiporadiovenciDataAccess.getEntity(connexion,relradiovenciclienteprove.getid_tipo_radio_venci());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporadiovenci;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RadioVenciClienteProve radiovenciclienteprove) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!radiovenciclienteprove.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(radiovenciclienteprove.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_radio_venci=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_radio_venci.setValue(radiovenciclienteprove.getid_tipo_radio_venci());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_radio_venci);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedia_desde=new ParameterValue<Integer>();
					parameterMaintenanceValuedia_desde.setValue(radiovenciclienteprove.getdia_desde());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedia_desde);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedia_hasta=new ParameterValue<Integer>();
					parameterMaintenanceValuedia_hasta.setValue(radiovenciclienteprove.getdia_hasta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedia_hasta);
					parametersTemp.add(parameterMaintenance);
					
						if(!radiovenciclienteprove.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(radiovenciclienteprove.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(radiovenciclienteprove.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(radiovenciclienteprove.getId());
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
	
	public void setIsNewIsChangedFalseRadioVenciClienteProve(RadioVenciClienteProve radiovenciclienteprove)throws Exception  {		
		radiovenciclienteprove.setIsNew(false);
		radiovenciclienteprove.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRadioVenciClienteProves(List<RadioVenciClienteProve> radiovenciclienteproves)throws Exception  {				
		for(RadioVenciClienteProve radiovenciclienteprove:radiovenciclienteproves) {
			radiovenciclienteprove.setIsNew(false);
			radiovenciclienteprove.setIsChanged(false);
		}
	}
	
	public void generarExportarRadioVenciClienteProve(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
