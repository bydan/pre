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
import com.bydan.erp.nomina.util.*;//UtilidadEmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class UtilidadEmpleadoDataAccess extends  UtilidadEmpleadoDataAccessAdditional{ //UtilidadEmpleadoDataAccessAdditional,DataAccessHelper<UtilidadEmpleado>
	//static Logger logger = Logger.getLogger(UtilidadEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="utilidad_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_anio,fecha_ingreso,fecha_salida,valor,numero_dias,numero_cargas,numero_factor10,valor_factor10,utilidad_factor10,numero_factor5,valor_factor5,utilidad_factor5,total)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_anio=?,fecha_ingreso=?,fecha_salida=?,valor=?,numero_dias=?,numero_cargas=?,numero_factor10=?,valor_factor10=?,utilidad_factor10=?,numero_factor5=?,valor_factor5=?,utilidad_factor5=?,total=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select utilidadempleado from "+UtilidadEmpleadoConstantesFunciones.SPERSISTENCENAME+" utilidadempleado";
	public static String QUERYSELECTNATIVE="select "+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".id,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".version_row,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".id_anio,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".fecha_ingreso,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".fecha_salida,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".valor,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".numero_dias,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".numero_cargas,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".numero_factor10,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".valor_factor10,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".utilidad_factor10,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".numero_factor5,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".valor_factor5,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".utilidad_factor5,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".total from "+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME;//+" as "+UtilidadEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".id,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".version_row from "+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME;//+" as "+UtilidadEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_anio=?,fecha_ingreso=?,fecha_salida=?,valor=?,numero_dias=?,numero_cargas=?,numero_factor10=?,valor_factor10=?,utilidad_factor10=?,numero_factor5=?,valor_factor5=?,utilidad_factor5=?,total=?";
	
	public static String STOREPROCEDUREINSERT="call SP_UTILIDADEMPLEADO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_UTILIDADEMPLEADO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_UTILIDADEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_UTILIDADEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected UtilidadEmpleadoDataAccessAdditional utilidadempleadoDataAccessAdditional=null;
	
	public UtilidadEmpleadoDataAccessAdditional getUtilidadEmpleadoDataAccessAdditional() {
		return this.utilidadempleadoDataAccessAdditional;
	}
	
	public void setUtilidadEmpleadoDataAccessAdditional(UtilidadEmpleadoDataAccessAdditional utilidadempleadoDataAccessAdditional) {
		try {
			this.utilidadempleadoDataAccessAdditional=utilidadempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public UtilidadEmpleadoDataAccess() {
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
		UtilidadEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		UtilidadEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		UtilidadEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setUtilidadEmpleadoOriginal(UtilidadEmpleado utilidadempleado)throws Exception  {
		utilidadempleado.setUtilidadEmpleadoOriginal((UtilidadEmpleado)utilidadempleado.clone());		
	}
	
	public void setUtilidadEmpleadosOriginal(List<UtilidadEmpleado> utilidadempleados)throws Exception  {
		
		for(UtilidadEmpleado utilidadempleado:utilidadempleados){
			utilidadempleado.setUtilidadEmpleadoOriginal((UtilidadEmpleado)utilidadempleado.clone());
		}
	}
	
	public static void setUtilidadEmpleadoOriginalStatic(UtilidadEmpleado utilidadempleado)throws Exception  {
		utilidadempleado.setUtilidadEmpleadoOriginal((UtilidadEmpleado)utilidadempleado.clone());		
	}
	
	public static void setUtilidadEmpleadosOriginalStatic(List<UtilidadEmpleado> utilidadempleados)throws Exception  {
		
		for(UtilidadEmpleado utilidadempleado:utilidadempleados){
			utilidadempleado.setUtilidadEmpleadoOriginal((UtilidadEmpleado)utilidadempleado.clone());
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
	
	public  UtilidadEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		UtilidadEmpleado entity = new UtilidadEmpleado();		
		
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
	
	public  UtilidadEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		UtilidadEmpleado entity = new UtilidadEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.UtilidadEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setUtilidadEmpleadoOriginal(new UtilidadEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUtilidadEmpleado("",entity,resultSet); 
				
				//entity.setUtilidadEmpleadoOriginal(super.getEntity("",entity.getUtilidadEmpleadoOriginal(),resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUtilidadEmpleadoOriginal(this.getEntityUtilidadEmpleado("",entity.getUtilidadEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseUtilidadEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  UtilidadEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UtilidadEmpleado entity = new UtilidadEmpleado();
				
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
	
	public  UtilidadEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UtilidadEmpleado entity = new UtilidadEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UtilidadEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.UtilidadEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setUtilidadEmpleadoOriginal(new UtilidadEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUtilidadEmpleado("",entity,resultSet);    
				
				//entity.setUtilidadEmpleadoOriginal(super.getEntity("",entity.getUtilidadEmpleadoOriginal(),resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUtilidadEmpleadoOriginal(this.getEntityUtilidadEmpleado("",entity.getUtilidadEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseUtilidadEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //UtilidadEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		UtilidadEmpleado entity = new UtilidadEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UtilidadEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.UtilidadEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseUtilidadEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<UtilidadEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UtilidadEmpleado> entities = new  ArrayList<UtilidadEmpleado>();
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
		
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
	
	public  List<UtilidadEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UtilidadEmpleado> entities = new  ArrayList<UtilidadEmpleado>();
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UtilidadEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UtilidadEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUtilidadEmpleado("",entity,resultSet);
      	    	
				//entity.setUtilidadEmpleadoOriginal( new UtilidadEmpleado());
      	    	//entity.setUtilidadEmpleadoOriginal(super.getEntity("",entity.getUtilidadEmpleadoOriginal(),resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUtilidadEmpleadoOriginal(this.getEntityUtilidadEmpleado("",entity.getUtilidadEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUtilidadEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUtilidadEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<UtilidadEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UtilidadEmpleado> entities = new  ArrayList<UtilidadEmpleado>();
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
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
	
	public  List<UtilidadEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UtilidadEmpleado> entities = new  ArrayList<UtilidadEmpleado>();
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UtilidadEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapUtilidadEmpleado();
					//entity.setMapUtilidadEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapUtilidadEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUtilidadEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=UtilidadEmpleadoDataAccess.getEntityUtilidadEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUtilidadEmpleadoOriginal( new UtilidadEmpleado());
					////entity.setUtilidadEmpleadoOriginal(super.getEntity("",entity.getUtilidadEmpleadoOriginal(),resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setUtilidadEmpleadoOriginal(this.getEntityUtilidadEmpleado("",entity.getUtilidadEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUtilidadEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUtilidadEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public UtilidadEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
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
	
	public  UtilidadEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UtilidadEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapUtilidadEmpleado();
					//entity.setMapUtilidadEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapUtilidadEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUtilidadEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=UtilidadEmpleadoDataAccess.getEntityUtilidadEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUtilidadEmpleadoOriginal( new UtilidadEmpleado());
					////entity.setUtilidadEmpleadoOriginal(super.getEntity("",entity.getUtilidadEmpleadoOriginal(),resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setUtilidadEmpleadoOriginal(this.getEntityUtilidadEmpleado("",entity.getUtilidadEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseUtilidadEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUtilidadEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static UtilidadEmpleado getEntityUtilidadEmpleado(String strPrefijo,UtilidadEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = UtilidadEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = UtilidadEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					UtilidadEmpleadoDataAccess.setFieldReflectionUtilidadEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasUtilidadEmpleado=UtilidadEmpleadoConstantesFunciones.getTodosTiposColumnasUtilidadEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasUtilidadEmpleado) {
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
							field = UtilidadEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = UtilidadEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						UtilidadEmpleadoDataAccess.setFieldReflectionUtilidadEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionUtilidadEmpleado(Field field,String strPrefijo,String sColumn,UtilidadEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case UtilidadEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.FECHAINGRESO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.FECHASALIDA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.NUMERODIAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.NUMEROCARGAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR10:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.VALORFACTOR10:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR10:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR5:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.VALORFACTOR5:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR5:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case UtilidadEmpleadoConstantesFunciones.TOTAL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UtilidadEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<UtilidadEmpleado> entities = new  ArrayList<UtilidadEmpleado>();
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UtilidadEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new UtilidadEmpleado();
					entity=super.getEntity("",entity,resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityUtilidadEmpleado("",entity,resultSet);
					
					//entity.setUtilidadEmpleadoOriginal( new UtilidadEmpleado());
					//entity.setUtilidadEmpleadoOriginal(super.getEntity("",entity.getUtilidadEmpleadoOriginal(),resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setUtilidadEmpleadoOriginal(this.getEntityUtilidadEmpleado("",entity.getUtilidadEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseUtilidadEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUtilidadEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UtilidadEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<UtilidadEmpleado> entities = new  ArrayList<UtilidadEmpleado>();
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UtilidadEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UtilidadEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<UtilidadEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UtilidadEmpleado> entities = new  ArrayList<UtilidadEmpleado>();
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
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
	
	public  List<UtilidadEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UtilidadEmpleado> entities = new  ArrayList<UtilidadEmpleado>();
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UtilidadEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUtilidadEmpleado("",entity,resultSet);
      	    	
				//entity.setUtilidadEmpleadoOriginal( new UtilidadEmpleado());
      	    	//entity.setUtilidadEmpleadoOriginal(super.getEntity("",entity.getUtilidadEmpleadoOriginal(),resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUtilidadEmpleadoOriginal(this.getEntityUtilidadEmpleado("",entity.getUtilidadEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseUtilidadEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUtilidadEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<UtilidadEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UtilidadEmpleado> entities = new  ArrayList<UtilidadEmpleado>();
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
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
	
	public  List<UtilidadEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UtilidadEmpleado> entities = new  ArrayList<UtilidadEmpleado>();
		UtilidadEmpleado entity = new UtilidadEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UtilidadEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUtilidadEmpleado("",entity,resultSet);
      	    	
				//entity.setUtilidadEmpleadoOriginal( new UtilidadEmpleado());
      	    	//entity.setUtilidadEmpleadoOriginal(super.getEntity("",entity.getUtilidadEmpleadoOriginal(),resultSet,UtilidadEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUtilidadEmpleadoOriginal(this.getEntityUtilidadEmpleado("",entity.getUtilidadEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUtilidadEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public UtilidadEmpleado getEntityUtilidadEmpleado(String strPrefijo,UtilidadEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+UtilidadEmpleadoConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+UtilidadEmpleadoConstantesFunciones.IDEMPLEADO));
				entity.setid_anio(resultSet.getLong(strPrefijo+UtilidadEmpleadoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setfecha_ingreso(new Date(resultSet.getDate(strPrefijo+UtilidadEmpleadoConstantesFunciones.FECHAINGRESO).getTime()));
				entity.setfecha_salida(new Date(resultSet.getDate(strPrefijo+UtilidadEmpleadoConstantesFunciones.FECHASALIDA).getTime()));
				entity.setvalor(resultSet.getDouble(strPrefijo+UtilidadEmpleadoConstantesFunciones.VALOR));
				entity.setnumero_dias(resultSet.getInt(strPrefijo+UtilidadEmpleadoConstantesFunciones.NUMERODIAS));
				entity.setnumero_cargas(resultSet.getInt(strPrefijo+UtilidadEmpleadoConstantesFunciones.NUMEROCARGAS));
				entity.setnumero_factor10(resultSet.getDouble(strPrefijo+UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR10));
				entity.setvalor_factor10(resultSet.getDouble(strPrefijo+UtilidadEmpleadoConstantesFunciones.VALORFACTOR10));
				entity.setutilidad_factor10(resultSet.getDouble(strPrefijo+UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR10));
				entity.setnumero_factor5(resultSet.getDouble(strPrefijo+UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR5));
				entity.setvalor_factor5(resultSet.getDouble(strPrefijo+UtilidadEmpleadoConstantesFunciones.VALORFACTOR5));
				entity.setutilidad_factor5(resultSet.getDouble(strPrefijo+UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR5));
				entity.settotal(resultSet.getDouble(strPrefijo+UtilidadEmpleadoConstantesFunciones.TOTAL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowUtilidadEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(UtilidadEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=UtilidadEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=UtilidadEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=UtilidadEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=UtilidadEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(UtilidadEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,UtilidadEmpleadoDataAccess.TABLENAME,UtilidadEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			UtilidadEmpleadoDataAccess.setUtilidadEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,UtilidadEmpleado relutilidadempleado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relutilidadempleado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,UtilidadEmpleado relutilidadempleado)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relutilidadempleado.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Anio getAnio(Connexion connexion,UtilidadEmpleado relutilidadempleado)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relutilidadempleado.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,UtilidadEmpleado utilidadempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!utilidadempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(utilidadempleado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(utilidadempleado.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(utilidadempleado.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ingreso=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ingreso.setValue(utilidadempleado.getfecha_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_salida=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_salida.setValue(utilidadempleado.getfecha_salida());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_salida);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(utilidadempleado.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_dias=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_dias.setValue(utilidadempleado.getnumero_dias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_cargas=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_cargas.setValue(utilidadempleado.getnumero_cargas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cargas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuenumero_factor10=new ParameterValue<Double>();
					parameterMaintenanceValuenumero_factor10.setValue(utilidadempleado.getnumero_factor10());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factor10);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_factor10=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_factor10.setValue(utilidadempleado.getvalor_factor10());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_factor10);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueutilidad_factor10=new ParameterValue<Double>();
					parameterMaintenanceValueutilidad_factor10.setValue(utilidadempleado.getutilidad_factor10());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueutilidad_factor10);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuenumero_factor5=new ParameterValue<Double>();
					parameterMaintenanceValuenumero_factor5.setValue(utilidadempleado.getnumero_factor5());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factor5);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_factor5=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_factor5.setValue(utilidadempleado.getvalor_factor5());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_factor5);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueutilidad_factor5=new ParameterValue<Double>();
					parameterMaintenanceValueutilidad_factor5.setValue(utilidadempleado.getutilidad_factor5());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueutilidad_factor5);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(utilidadempleado.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
						if(!utilidadempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(utilidadempleado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(utilidadempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(utilidadempleado.getId());
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
	
	public void setIsNewIsChangedFalseUtilidadEmpleado(UtilidadEmpleado utilidadempleado)throws Exception  {		
		utilidadempleado.setIsNew(false);
		utilidadempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseUtilidadEmpleados(List<UtilidadEmpleado> utilidadempleados)throws Exception  {				
		for(UtilidadEmpleado utilidadempleado:utilidadempleados) {
			utilidadempleado.setIsNew(false);
			utilidadempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarUtilidadEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
