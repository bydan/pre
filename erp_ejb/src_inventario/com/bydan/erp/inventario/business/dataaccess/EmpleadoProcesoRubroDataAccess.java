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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//EmpleadoProcesoRubroConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class EmpleadoProcesoRubroDataAccess extends  EmpleadoProcesoRubroDataAccessAdditional{ //EmpleadoProcesoRubroDataAccessAdditional,DataAccessHelper<EmpleadoProcesoRubro>
	//static Logger logger = Logger.getLogger(EmpleadoProcesoRubroDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empleado_proceso_rubro";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_estructura,id_empleado,fecha_ingreso,fecha_salida,observaciones,numeros_reingreso)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_estructura=?,id_empleado=?,fecha_ingreso=?,fecha_salida=?,observaciones=?,numeros_reingreso=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empleadoprocesorubro from "+EmpleadoProcesoRubroConstantesFunciones.SPERSISTENCENAME+" empleadoprocesorubro";
	public static String QUERYSELECTNATIVE="select "+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".id,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".version_row,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".id_sucursal,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".id_estructura,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".fecha_ingreso,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".fecha_salida,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".observaciones,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".numeros_reingreso from "+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME;//+" as "+EmpleadoProcesoRubroConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".id,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".version_row from "+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME;//+" as "+EmpleadoProcesoRubroConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_estructura=?,id_empleado=?,fecha_ingreso=?,fecha_salida=?,observaciones=?,numeros_reingreso=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPLEADOPROCESORUBRO_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPLEADOPROCESORUBRO_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPLEADOPROCESORUBRO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPLEADOPROCESORUBRO_SELECT(?,?)";
	
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
	
	
	protected EmpleadoProcesoRubroDataAccessAdditional empleadoprocesorubroDataAccessAdditional=null;
	
	public EmpleadoProcesoRubroDataAccessAdditional getEmpleadoProcesoRubroDataAccessAdditional() {
		return this.empleadoprocesorubroDataAccessAdditional;
	}
	
	public void setEmpleadoProcesoRubroDataAccessAdditional(EmpleadoProcesoRubroDataAccessAdditional empleadoprocesorubroDataAccessAdditional) {
		try {
			this.empleadoprocesorubroDataAccessAdditional=empleadoprocesorubroDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpleadoProcesoRubroDataAccess() {
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
		EmpleadoProcesoRubroDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpleadoProcesoRubroDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpleadoProcesoRubroDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpleadoProcesoRubroOriginal(EmpleadoProcesoRubro empleadoprocesorubro)throws Exception  {
		empleadoprocesorubro.setEmpleadoProcesoRubroOriginal((EmpleadoProcesoRubro)empleadoprocesorubro.clone());		
	}
	
	public void setEmpleadoProcesoRubrosOriginal(List<EmpleadoProcesoRubro> empleadoprocesorubros)throws Exception  {
		
		for(EmpleadoProcesoRubro empleadoprocesorubro:empleadoprocesorubros){
			empleadoprocesorubro.setEmpleadoProcesoRubroOriginal((EmpleadoProcesoRubro)empleadoprocesorubro.clone());
		}
	}
	
	public static void setEmpleadoProcesoRubroOriginalStatic(EmpleadoProcesoRubro empleadoprocesorubro)throws Exception  {
		empleadoprocesorubro.setEmpleadoProcesoRubroOriginal((EmpleadoProcesoRubro)empleadoprocesorubro.clone());		
	}
	
	public static void setEmpleadoProcesoRubrosOriginalStatic(List<EmpleadoProcesoRubro> empleadoprocesorubros)throws Exception  {
		
		for(EmpleadoProcesoRubro empleadoprocesorubro:empleadoprocesorubros){
			empleadoprocesorubro.setEmpleadoProcesoRubroOriginal((EmpleadoProcesoRubro)empleadoprocesorubro.clone());
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
	
	public  EmpleadoProcesoRubro getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		
		
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
	
	public  EmpleadoProcesoRubro getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.EmpleadoProcesoRubro.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpleadoProcesoRubroOriginal(new EmpleadoProcesoRubro());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoProcesoRubro("",entity,resultSet); 
				
				//entity.setEmpleadoProcesoRubroOriginal(super.getEntity("",entity.getEmpleadoProcesoRubroOriginal(),resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoProcesoRubroOriginal(this.getEntityEmpleadoProcesoRubro("",entity.getEmpleadoProcesoRubroOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoProcesoRubro(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EmpleadoProcesoRubro getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();
				
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
	
	public  EmpleadoProcesoRubro getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoProcesoRubroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EmpleadoProcesoRubro.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpleadoProcesoRubroOriginal(new EmpleadoProcesoRubro());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoProcesoRubro("",entity,resultSet);    
				
				//entity.setEmpleadoProcesoRubroOriginal(super.getEntity("",entity.getEmpleadoProcesoRubroOriginal(),resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoProcesoRubroOriginal(this.getEntityEmpleadoProcesoRubro("",entity.getEmpleadoProcesoRubroOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoProcesoRubro(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EmpleadoProcesoRubro
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoProcesoRubroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EmpleadoProcesoRubro.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpleadoProcesoRubro(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EmpleadoProcesoRubro> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoProcesoRubro> entities = new  ArrayList<EmpleadoProcesoRubro>();
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
		
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
	
	public  List<EmpleadoProcesoRubro> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoProcesoRubro> entities = new  ArrayList<EmpleadoProcesoRubro>();
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoProcesoRubroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoProcesoRubro();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoProcesoRubro("",entity,resultSet);
      	    	
				//entity.setEmpleadoProcesoRubroOriginal( new EmpleadoProcesoRubro());
      	    	//entity.setEmpleadoProcesoRubroOriginal(super.getEntity("",entity.getEmpleadoProcesoRubroOriginal(),resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoProcesoRubroOriginal(this.getEntityEmpleadoProcesoRubro("",entity.getEmpleadoProcesoRubroOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoProcesoRubros(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoProcesoRubro(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoProcesoRubro> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoProcesoRubro> entities = new  ArrayList<EmpleadoProcesoRubro>();
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
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
	
	public  List<EmpleadoProcesoRubro> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoProcesoRubro> entities = new  ArrayList<EmpleadoProcesoRubro>();
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoProcesoRubro();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoProcesoRubro();
					//entity.setMapEmpleadoProcesoRubro(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpleadoProcesoRubroValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoProcesoRubro().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoProcesoRubroDataAccess.getEntityEmpleadoProcesoRubro("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoProcesoRubroOriginal( new EmpleadoProcesoRubro());
					////entity.setEmpleadoProcesoRubroOriginal(super.getEntity("",entity.getEmpleadoProcesoRubroOriginal(),resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoProcesoRubroOriginal(this.getEntityEmpleadoProcesoRubro("",entity.getEmpleadoProcesoRubroOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoProcesoRubros(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoProcesoRubro(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EmpleadoProcesoRubro getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
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
	
	public  EmpleadoProcesoRubro getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoProcesoRubro();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoProcesoRubro();
					//entity.setMapEmpleadoProcesoRubro(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpleadoProcesoRubroValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoProcesoRubro().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoProcesoRubroDataAccess.getEntityEmpleadoProcesoRubro("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoProcesoRubroOriginal( new EmpleadoProcesoRubro());
					////entity.setEmpleadoProcesoRubroOriginal(super.getEntity("",entity.getEmpleadoProcesoRubroOriginal(),resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoProcesoRubroOriginal(this.getEntityEmpleadoProcesoRubro("",entity.getEmpleadoProcesoRubroOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpleadoProcesoRubro(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoProcesoRubro(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EmpleadoProcesoRubro getEntityEmpleadoProcesoRubro(String strPrefijo,EmpleadoProcesoRubro entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EmpleadoProcesoRubro.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EmpleadoProcesoRubro.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpleadoProcesoRubroDataAccess.setFieldReflectionEmpleadoProcesoRubro(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpleadoProcesoRubro=EmpleadoProcesoRubroConstantesFunciones.getTodosTiposColumnasEmpleadoProcesoRubro();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpleadoProcesoRubro) {
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
							field = EmpleadoProcesoRubro.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EmpleadoProcesoRubro.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpleadoProcesoRubroDataAccess.setFieldReflectionEmpleadoProcesoRubro(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpleadoProcesoRubro(Field field,String strPrefijo,String sColumn,EmpleadoProcesoRubro entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpleadoProcesoRubroConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoProcesoRubroConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoProcesoRubroConstantesFunciones.FECHAINGRESO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case EmpleadoProcesoRubroConstantesFunciones.FECHASALIDA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case EmpleadoProcesoRubroConstantesFunciones.OBSERVACIONES:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoProcesoRubroConstantesFunciones.NUMEROSREINGRESO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoProcesoRubro>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EmpleadoProcesoRubro> entities = new  ArrayList<EmpleadoProcesoRubro>();
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoProcesoRubroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EmpleadoProcesoRubro();
					entity=super.getEntity("",entity,resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpleadoProcesoRubro("",entity,resultSet);
					
					//entity.setEmpleadoProcesoRubroOriginal( new EmpleadoProcesoRubro());
					//entity.setEmpleadoProcesoRubroOriginal(super.getEntity("",entity.getEmpleadoProcesoRubroOriginal(),resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpleadoProcesoRubroOriginal(this.getEntityEmpleadoProcesoRubro("",entity.getEmpleadoProcesoRubroOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpleadoProcesoRubros(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoProcesoRubro(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoProcesoRubro>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EmpleadoProcesoRubro> entities = new  ArrayList<EmpleadoProcesoRubro>();
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoProcesoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoProcesoRubroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EmpleadoProcesoRubro> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoProcesoRubro> entities = new  ArrayList<EmpleadoProcesoRubro>();
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
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
	
	public  List<EmpleadoProcesoRubro> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoProcesoRubro> entities = new  ArrayList<EmpleadoProcesoRubro>();
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoProcesoRubro();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoProcesoRubro("",entity,resultSet);
      	    	
				//entity.setEmpleadoProcesoRubroOriginal( new EmpleadoProcesoRubro());
      	    	//entity.setEmpleadoProcesoRubroOriginal(super.getEntity("",entity.getEmpleadoProcesoRubroOriginal(),resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoProcesoRubroOriginal(this.getEntityEmpleadoProcesoRubro("",entity.getEmpleadoProcesoRubroOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpleadoProcesoRubros(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoProcesoRubro(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoProcesoRubro> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoProcesoRubro> entities = new  ArrayList<EmpleadoProcesoRubro>();
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
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
	
	public  List<EmpleadoProcesoRubro> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoProcesoRubro> entities = new  ArrayList<EmpleadoProcesoRubro>();
		EmpleadoProcesoRubro entity = new EmpleadoProcesoRubro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoProcesoRubro();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoProcesoRubro("",entity,resultSet);
      	    	
				//entity.setEmpleadoProcesoRubroOriginal( new EmpleadoProcesoRubro());
      	    	//entity.setEmpleadoProcesoRubroOriginal(super.getEntity("",entity.getEmpleadoProcesoRubroOriginal(),resultSet,EmpleadoProcesoRubroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoProcesoRubroOriginal(this.getEntityEmpleadoProcesoRubro("",entity.getEmpleadoProcesoRubroOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoProcesoRubros(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EmpleadoProcesoRubro getEntityEmpleadoProcesoRubro(String strPrefijo,EmpleadoProcesoRubro entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL));
				entity.setid_estructura(resultSet.getLong(strPrefijo+EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO));
				entity.setfecha_ingreso(new Date(resultSet.getDate(strPrefijo+EmpleadoProcesoRubroConstantesFunciones.FECHAINGRESO).getTime()));
				entity.setfecha_salida(new Date(resultSet.getDate(strPrefijo+EmpleadoProcesoRubroConstantesFunciones.FECHASALIDA).getTime()));
				entity.setobservaciones(resultSet.getString(strPrefijo+EmpleadoProcesoRubroConstantesFunciones.OBSERVACIONES));
				entity.setnumeros_reingreso(resultSet.getInt(strPrefijo+EmpleadoProcesoRubroConstantesFunciones.NUMEROSREINGRESO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpleadoProcesoRubro(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EmpleadoProcesoRubro entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpleadoProcesoRubroDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpleadoProcesoRubroDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpleadoProcesoRubroDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpleadoProcesoRubroDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpleadoProcesoRubroConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpleadoProcesoRubroDataAccess.TABLENAME,EmpleadoProcesoRubroDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpleadoProcesoRubroDataAccess.setEmpleadoProcesoRubroOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EmpleadoProcesoRubro relempleadoprocesorubro)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relempleadoprocesorubro.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,EmpleadoProcesoRubro relempleadoprocesorubro)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relempleadoprocesorubro.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Estructura getEstructura(Connexion connexion,EmpleadoProcesoRubro relempleadoprocesorubro)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relempleadoprocesorubro.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empleado getEmpleado(Connexion connexion,EmpleadoProcesoRubro relempleadoprocesorubro)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relempleadoprocesorubro.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EmpleadoProcesoRubro empleadoprocesorubro) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empleadoprocesorubro.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(empleadoprocesorubro.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(empleadoprocesorubro.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(empleadoprocesorubro.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(empleadoprocesorubro.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ingreso=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ingreso.setValue(empleadoprocesorubro.getfecha_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_salida=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_salida.setValue(empleadoprocesorubro.getfecha_salida());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_salida);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservaciones=new ParameterValue<String>();
					parameterMaintenanceValueobservaciones.setValue(empleadoprocesorubro.getobservaciones());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservaciones);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumeros_reingreso=new ParameterValue<Integer>();
					parameterMaintenanceValuenumeros_reingreso.setValue(empleadoprocesorubro.getnumeros_reingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumeros_reingreso);
					parametersTemp.add(parameterMaintenance);
					
						if(!empleadoprocesorubro.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empleadoprocesorubro.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empleadoprocesorubro.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empleadoprocesorubro.getId());
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
	
	public void setIsNewIsChangedFalseEmpleadoProcesoRubro(EmpleadoProcesoRubro empleadoprocesorubro)throws Exception  {		
		empleadoprocesorubro.setIsNew(false);
		empleadoprocesorubro.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpleadoProcesoRubros(List<EmpleadoProcesoRubro> empleadoprocesorubros)throws Exception  {				
		for(EmpleadoProcesoRubro empleadoprocesorubro:empleadoprocesorubros) {
			empleadoprocesorubro.setIsNew(false);
			empleadoprocesorubro.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpleadoProcesoRubro(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
