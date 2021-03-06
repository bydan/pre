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
import com.bydan.erp.nomina.util.*;//ValorRubroVariableConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ValorRubroVariableDataAccess extends  ValorRubroVariableDataAccessAdditional{ //ValorRubroVariableDataAccessAdditional,DataAccessHelper<ValorRubroVariable>
	//static Logger logger = Logger.getLogger(ValorRubroVariableDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="valor_rubro_variable";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_rubro_emplea,fecha,valor)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_rubro_emplea=?,fecha=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select valorrubrovariable from "+ValorRubroVariableConstantesFunciones.SPERSISTENCENAME+" valorrubrovariable";
	public static String QUERYSELECTNATIVE="select "+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".id,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".version_row,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".id_empresa,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".id_empleado,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".id_rubro_emplea,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".fecha,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".valor from "+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME;//+" as "+ValorRubroVariableConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".id,"+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+".version_row from "+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME;//+" as "+ValorRubroVariableConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ValorRubroVariableConstantesFunciones.SCHEMA+"."+ValorRubroVariableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_rubro_emplea=?,fecha=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_VALORRUBROVARIABLE_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_VALORRUBROVARIABLE_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_VALORRUBROVARIABLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_VALORRUBROVARIABLE_SELECT(?,?)";
	
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
	
	
	protected ValorRubroVariableDataAccessAdditional valorrubrovariableDataAccessAdditional=null;
	
	public ValorRubroVariableDataAccessAdditional getValorRubroVariableDataAccessAdditional() {
		return this.valorrubrovariableDataAccessAdditional;
	}
	
	public void setValorRubroVariableDataAccessAdditional(ValorRubroVariableDataAccessAdditional valorrubrovariableDataAccessAdditional) {
		try {
			this.valorrubrovariableDataAccessAdditional=valorrubrovariableDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ValorRubroVariableDataAccess() {
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
		ValorRubroVariableDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ValorRubroVariableDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ValorRubroVariableDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setValorRubroVariableOriginal(ValorRubroVariable valorrubrovariable)throws Exception  {
		valorrubrovariable.setValorRubroVariableOriginal((ValorRubroVariable)valorrubrovariable.clone());		
	}
	
	public void setValorRubroVariablesOriginal(List<ValorRubroVariable> valorrubrovariables)throws Exception  {
		
		for(ValorRubroVariable valorrubrovariable:valorrubrovariables){
			valorrubrovariable.setValorRubroVariableOriginal((ValorRubroVariable)valorrubrovariable.clone());
		}
	}
	
	public static void setValorRubroVariableOriginalStatic(ValorRubroVariable valorrubrovariable)throws Exception  {
		valorrubrovariable.setValorRubroVariableOriginal((ValorRubroVariable)valorrubrovariable.clone());		
	}
	
	public static void setValorRubroVariablesOriginalStatic(List<ValorRubroVariable> valorrubrovariables)throws Exception  {
		
		for(ValorRubroVariable valorrubrovariable:valorrubrovariables){
			valorrubrovariable.setValorRubroVariableOriginal((ValorRubroVariable)valorrubrovariable.clone());
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
	
	public  ValorRubroVariable getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ValorRubroVariable entity = new ValorRubroVariable();		
		
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
	
	public  ValorRubroVariable getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ValorRubroVariable entity = new ValorRubroVariable();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.ValorRubroVariable.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setValorRubroVariableOriginal(new ValorRubroVariable());
      	    	entity=super.getEntity("",entity,resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityValorRubroVariable("",entity,resultSet); 
				
				//entity.setValorRubroVariableOriginal(super.getEntity("",entity.getValorRubroVariableOriginal(),resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setValorRubroVariableOriginal(this.getEntityValorRubroVariable("",entity.getValorRubroVariableOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseValorRubroVariable(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ValorRubroVariable getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ValorRubroVariable entity = new ValorRubroVariable();
				
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
	
	public  ValorRubroVariable getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ValorRubroVariable entity = new ValorRubroVariable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ValorRubroVariableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.ValorRubroVariable.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setValorRubroVariableOriginal(new ValorRubroVariable());
      	    	entity=super.getEntity("",entity,resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityValorRubroVariable("",entity,resultSet);    
				
				//entity.setValorRubroVariableOriginal(super.getEntity("",entity.getValorRubroVariableOriginal(),resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setValorRubroVariableOriginal(this.getEntityValorRubroVariable("",entity.getValorRubroVariableOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseValorRubroVariable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ValorRubroVariable
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ValorRubroVariable entity = new ValorRubroVariable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ValorRubroVariableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.ValorRubroVariable.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseValorRubroVariable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ValorRubroVariable> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ValorRubroVariable> entities = new  ArrayList<ValorRubroVariable>();
		ValorRubroVariable entity = new ValorRubroVariable();		  
		
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
	
	public  List<ValorRubroVariable> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ValorRubroVariable> entities = new  ArrayList<ValorRubroVariable>();
		ValorRubroVariable entity = new ValorRubroVariable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ValorRubroVariableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ValorRubroVariable();
      	    	entity=super.getEntity("",entity,resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityValorRubroVariable("",entity,resultSet);
      	    	
				//entity.setValorRubroVariableOriginal( new ValorRubroVariable());
      	    	//entity.setValorRubroVariableOriginal(super.getEntity("",entity.getValorRubroVariableOriginal(),resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setValorRubroVariableOriginal(this.getEntityValorRubroVariable("",entity.getValorRubroVariableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseValorRubroVariables(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarValorRubroVariable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ValorRubroVariable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ValorRubroVariable> entities = new  ArrayList<ValorRubroVariable>();
		ValorRubroVariable entity = new ValorRubroVariable();		  
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
	
	public  List<ValorRubroVariable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ValorRubroVariable> entities = new  ArrayList<ValorRubroVariable>();
		ValorRubroVariable entity = new ValorRubroVariable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ValorRubroVariable();
				
				if(conMapGenerico) {
					entity.inicializarMapValorRubroVariable();
					//entity.setMapValorRubroVariable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapValorRubroVariableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapValorRubroVariable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA);         		
					entity=ValorRubroVariableDataAccess.getEntityValorRubroVariable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setValorRubroVariableOriginal( new ValorRubroVariable());
					////entity.setValorRubroVariableOriginal(super.getEntity("",entity.getValorRubroVariableOriginal(),resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA));         		
					////entity.setValorRubroVariableOriginal(this.getEntityValorRubroVariable("",entity.getValorRubroVariableOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseValorRubroVariables(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarValorRubroVariable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ValorRubroVariable getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ValorRubroVariable entity = new ValorRubroVariable();		  
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
	
	public  ValorRubroVariable getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ValorRubroVariable entity = new ValorRubroVariable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ValorRubroVariable();
				
				if(conMapGenerico) {
					entity.inicializarMapValorRubroVariable();
					//entity.setMapValorRubroVariable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapValorRubroVariableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapValorRubroVariable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA);         		
					entity=ValorRubroVariableDataAccess.getEntityValorRubroVariable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setValorRubroVariableOriginal( new ValorRubroVariable());
					////entity.setValorRubroVariableOriginal(super.getEntity("",entity.getValorRubroVariableOriginal(),resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA));         		
					////entity.setValorRubroVariableOriginal(this.getEntityValorRubroVariable("",entity.getValorRubroVariableOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseValorRubroVariable(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarValorRubroVariable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ValorRubroVariable getEntityValorRubroVariable(String strPrefijo,ValorRubroVariable entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ValorRubroVariable.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ValorRubroVariable.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ValorRubroVariableDataAccess.setFieldReflectionValorRubroVariable(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasValorRubroVariable=ValorRubroVariableConstantesFunciones.getTodosTiposColumnasValorRubroVariable();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasValorRubroVariable) {
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
							field = ValorRubroVariable.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ValorRubroVariable.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ValorRubroVariableDataAccess.setFieldReflectionValorRubroVariable(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionValorRubroVariable(Field field,String strPrefijo,String sColumn,ValorRubroVariable entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ValorRubroVariableConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ValorRubroVariableConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ValorRubroVariableConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ValorRubroVariableConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ValorRubroVariableConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ValorRubroVariableConstantesFunciones.VALOR:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ValorRubroVariable>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ValorRubroVariable> entities = new  ArrayList<ValorRubroVariable>();
		ValorRubroVariable entity = new ValorRubroVariable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ValorRubroVariableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ValorRubroVariable();
					entity=super.getEntity("",entity,resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityValorRubroVariable("",entity,resultSet);
					
					//entity.setValorRubroVariableOriginal( new ValorRubroVariable());
					//entity.setValorRubroVariableOriginal(super.getEntity("",entity.getValorRubroVariableOriginal(),resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA));         		
					//entity.setValorRubroVariableOriginal(this.getEntityValorRubroVariable("",entity.getValorRubroVariableOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseValorRubroVariables(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarValorRubroVariable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ValorRubroVariable>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ValorRubroVariable> entities = new  ArrayList<ValorRubroVariable>();
		ValorRubroVariable entity = new ValorRubroVariable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ValorRubroVariableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ValorRubroVariableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ValorRubroVariable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ValorRubroVariable> entities = new  ArrayList<ValorRubroVariable>();
		ValorRubroVariable entity = new ValorRubroVariable();		  
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
	
	public  List<ValorRubroVariable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ValorRubroVariable> entities = new  ArrayList<ValorRubroVariable>();
		ValorRubroVariable entity = new ValorRubroVariable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ValorRubroVariable();
      	    	entity=super.getEntity("",entity,resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityValorRubroVariable("",entity,resultSet);
      	    	
				//entity.setValorRubroVariableOriginal( new ValorRubroVariable());
      	    	//entity.setValorRubroVariableOriginal(super.getEntity("",entity.getValorRubroVariableOriginal(),resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setValorRubroVariableOriginal(this.getEntityValorRubroVariable("",entity.getValorRubroVariableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseValorRubroVariables(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarValorRubroVariable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ValorRubroVariable> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ValorRubroVariable> entities = new  ArrayList<ValorRubroVariable>();
		ValorRubroVariable entity = new ValorRubroVariable();		  
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
	
	public  List<ValorRubroVariable> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ValorRubroVariable> entities = new  ArrayList<ValorRubroVariable>();
		ValorRubroVariable entity = new ValorRubroVariable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ValorRubroVariable();
      	    	entity=super.getEntity("",entity,resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityValorRubroVariable("",entity,resultSet);
      	    	
				//entity.setValorRubroVariableOriginal( new ValorRubroVariable());
      	    	//entity.setValorRubroVariableOriginal(super.getEntity("",entity.getValorRubroVariableOriginal(),resultSet,ValorRubroVariableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setValorRubroVariableOriginal(this.getEntityValorRubroVariable("",entity.getValorRubroVariableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseValorRubroVariables(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ValorRubroVariable getEntityValorRubroVariable(String strPrefijo,ValorRubroVariable entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ValorRubroVariableConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+ValorRubroVariableConstantesFunciones.IDEMPLEADO));
				entity.setid_rubro_emplea(resultSet.getLong(strPrefijo+ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+ValorRubroVariableConstantesFunciones.FECHA).getTime()));
				entity.setvalor(resultSet.getDouble(strPrefijo+ValorRubroVariableConstantesFunciones.VALOR));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowValorRubroVariable(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ValorRubroVariable entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ValorRubroVariableDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ValorRubroVariableDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ValorRubroVariableDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ValorRubroVariableDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ValorRubroVariableConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ValorRubroVariableDataAccess.TABLENAME,ValorRubroVariableDataAccess.ISWITHSTOREPROCEDURES);
			
			ValorRubroVariableDataAccess.setValorRubroVariableOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ValorRubroVariable relvalorrubrovariable)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relvalorrubrovariable.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,ValorRubroVariable relvalorrubrovariable)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relvalorrubrovariable.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public RubroEmplea getRubroEmplea(Connexion connexion,ValorRubroVariable relvalorrubrovariable)throws SQLException,Exception {

		RubroEmplea rubroemplea= new RubroEmplea();

		try {
			RubroEmpleaDataAccess rubroempleaDataAccess=new RubroEmpleaDataAccess();

			rubroempleaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rubroempleaDataAccess.setConnexionType(this.connexionType);
			rubroempleaDataAccess.setParameterDbType(this.parameterDbType);

			rubroemplea=rubroempleaDataAccess.getEntity(connexion,relvalorrubrovariable.getid_rubro_emplea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroemplea;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ValorRubroVariable valorrubrovariable) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!valorrubrovariable.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(valorrubrovariable.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(valorrubrovariable.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_rubro_emplea=new ParameterValue<Long>();
					parameterMaintenanceValueid_rubro_emplea.setValue(valorrubrovariable.getid_rubro_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_rubro_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(valorrubrovariable.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(valorrubrovariable.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!valorrubrovariable.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(valorrubrovariable.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(valorrubrovariable.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(valorrubrovariable.getId());
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
	
	public void setIsNewIsChangedFalseValorRubroVariable(ValorRubroVariable valorrubrovariable)throws Exception  {		
		valorrubrovariable.setIsNew(false);
		valorrubrovariable.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseValorRubroVariables(List<ValorRubroVariable> valorrubrovariables)throws Exception  {				
		for(ValorRubroVariable valorrubrovariable:valorrubrovariables) {
			valorrubrovariable.setIsNew(false);
			valorrubrovariable.setIsChanged(false);
		}
	}
	
	public void generarExportarValorRubroVariable(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
