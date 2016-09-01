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
import com.bydan.erp.nomina.util.*;//ProvisionEmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ProvisionEmpleadoDataAccess extends  ProvisionEmpleadoDataAccessAdditional{ //ProvisionEmpleadoDataAccessAdditional,DataAccessHelper<ProvisionEmpleado>
	//static Logger logger = Logger.getLogger(ProvisionEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="provision_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_estructura,id_tipo_provision_empleado,id_defi_provision_empleado,id_anio,id_mes,fecha,fecha_liquidacion,valor_mes,valor_paga,valor_vacacion,valor_liquidacion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_estructura=?,id_tipo_provision_empleado=?,id_defi_provision_empleado=?,id_anio=?,id_mes=?,fecha=?,fecha_liquidacion=?,valor_mes=?,valor_paga=?,valor_vacacion=?,valor_liquidacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select provisionempleado from "+ProvisionEmpleadoConstantesFunciones.SPERSISTENCENAME+" provisionempleado";
	public static String QUERYSELECTNATIVE="select "+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_estructura,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_tipo_provision_empleado,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_defi_provision_empleado,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_anio,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id_mes,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".fecha,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".fecha_liquidacion,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".valor_mes,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".valor_paga,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".valor_vacacion,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".valor_liquidacion from "+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME;//+" as "+ProvisionEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".id,"+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+".version_row from "+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME;//+" as "+ProvisionEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProvisionEmpleadoConstantesFunciones.SCHEMA+"."+ProvisionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_estructura=?,id_tipo_provision_empleado=?,id_defi_provision_empleado=?,id_anio=?,id_mes=?,fecha=?,fecha_liquidacion=?,valor_mes=?,valor_paga=?,valor_vacacion=?,valor_liquidacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PROVISIONEMPLEADO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PROVISIONEMPLEADO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PROVISIONEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PROVISIONEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected ProvisionEmpleadoDataAccessAdditional provisionempleadoDataAccessAdditional=null;
	
	public ProvisionEmpleadoDataAccessAdditional getProvisionEmpleadoDataAccessAdditional() {
		return this.provisionempleadoDataAccessAdditional;
	}
	
	public void setProvisionEmpleadoDataAccessAdditional(ProvisionEmpleadoDataAccessAdditional provisionempleadoDataAccessAdditional) {
		try {
			this.provisionempleadoDataAccessAdditional=provisionempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProvisionEmpleadoDataAccess() {
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
		ProvisionEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProvisionEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProvisionEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProvisionEmpleadoOriginal(ProvisionEmpleado provisionempleado)throws Exception  {
		provisionempleado.setProvisionEmpleadoOriginal((ProvisionEmpleado)provisionempleado.clone());		
	}
	
	public void setProvisionEmpleadosOriginal(List<ProvisionEmpleado> provisionempleados)throws Exception  {
		
		for(ProvisionEmpleado provisionempleado:provisionempleados){
			provisionempleado.setProvisionEmpleadoOriginal((ProvisionEmpleado)provisionempleado.clone());
		}
	}
	
	public static void setProvisionEmpleadoOriginalStatic(ProvisionEmpleado provisionempleado)throws Exception  {
		provisionempleado.setProvisionEmpleadoOriginal((ProvisionEmpleado)provisionempleado.clone());		
	}
	
	public static void setProvisionEmpleadosOriginalStatic(List<ProvisionEmpleado> provisionempleados)throws Exception  {
		
		for(ProvisionEmpleado provisionempleado:provisionempleados){
			provisionempleado.setProvisionEmpleadoOriginal((ProvisionEmpleado)provisionempleado.clone());
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
	
	public  ProvisionEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProvisionEmpleado entity = new ProvisionEmpleado();		
		
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
	
	public  ProvisionEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProvisionEmpleado entity = new ProvisionEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.ProvisionEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProvisionEmpleadoOriginal(new ProvisionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProvisionEmpleado("",entity,resultSet); 
				
				//entity.setProvisionEmpleadoOriginal(super.getEntity("",entity.getProvisionEmpleadoOriginal(),resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProvisionEmpleadoOriginal(this.getEntityProvisionEmpleado("",entity.getProvisionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProvisionEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProvisionEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProvisionEmpleado entity = new ProvisionEmpleado();
				
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
	
	public  ProvisionEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProvisionEmpleado entity = new ProvisionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.ProvisionEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProvisionEmpleadoOriginal(new ProvisionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProvisionEmpleado("",entity,resultSet);    
				
				//entity.setProvisionEmpleadoOriginal(super.getEntity("",entity.getProvisionEmpleadoOriginal(),resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProvisionEmpleadoOriginal(this.getEntityProvisionEmpleado("",entity.getProvisionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProvisionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProvisionEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProvisionEmpleado entity = new ProvisionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.ProvisionEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProvisionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProvisionEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProvisionEmpleado> entities = new  ArrayList<ProvisionEmpleado>();
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
		
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
	
	public  List<ProvisionEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProvisionEmpleado> entities = new  ArrayList<ProvisionEmpleado>();
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProvisionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProvisionEmpleado("",entity,resultSet);
      	    	
				//entity.setProvisionEmpleadoOriginal( new ProvisionEmpleado());
      	    	//entity.setProvisionEmpleadoOriginal(super.getEntity("",entity.getProvisionEmpleadoOriginal(),resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProvisionEmpleadoOriginal(this.getEntityProvisionEmpleado("",entity.getProvisionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProvisionEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProvisionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProvisionEmpleado> entities = new  ArrayList<ProvisionEmpleado>();
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
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
	
	public  List<ProvisionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProvisionEmpleado> entities = new  ArrayList<ProvisionEmpleado>();
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProvisionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapProvisionEmpleado();
					//entity.setMapProvisionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProvisionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProvisionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=ProvisionEmpleadoDataAccess.getEntityProvisionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProvisionEmpleadoOriginal( new ProvisionEmpleado());
					////entity.setProvisionEmpleadoOriginal(super.getEntity("",entity.getProvisionEmpleadoOriginal(),resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setProvisionEmpleadoOriginal(this.getEntityProvisionEmpleado("",entity.getProvisionEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProvisionEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProvisionEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
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
	
	public  ProvisionEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProvisionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapProvisionEmpleado();
					//entity.setMapProvisionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProvisionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProvisionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=ProvisionEmpleadoDataAccess.getEntityProvisionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProvisionEmpleadoOriginal( new ProvisionEmpleado());
					////entity.setProvisionEmpleadoOriginal(super.getEntity("",entity.getProvisionEmpleadoOriginal(),resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setProvisionEmpleadoOriginal(this.getEntityProvisionEmpleado("",entity.getProvisionEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProvisionEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProvisionEmpleado getEntityProvisionEmpleado(String strPrefijo,ProvisionEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProvisionEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProvisionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProvisionEmpleadoDataAccess.setFieldReflectionProvisionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProvisionEmpleado=ProvisionEmpleadoConstantesFunciones.getTodosTiposColumnasProvisionEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProvisionEmpleado) {
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
							field = ProvisionEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProvisionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProvisionEmpleadoDataAccess.setFieldReflectionProvisionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProvisionEmpleado(Field field,String strPrefijo,String sColumn,ProvisionEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProvisionEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.FECHALIQUIDACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.VALORMES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.VALORPAGA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.VALORVACACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProvisionEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProvisionEmpleado> entities = new  ArrayList<ProvisionEmpleado>();
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProvisionEmpleado();
					entity=super.getEntity("",entity,resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProvisionEmpleado("",entity,resultSet);
					
					//entity.setProvisionEmpleadoOriginal( new ProvisionEmpleado());
					//entity.setProvisionEmpleadoOriginal(super.getEntity("",entity.getProvisionEmpleadoOriginal(),resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setProvisionEmpleadoOriginal(this.getEntityProvisionEmpleado("",entity.getProvisionEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProvisionEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProvisionEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProvisionEmpleado> entities = new  ArrayList<ProvisionEmpleado>();
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProvisionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProvisionEmpleado> entities = new  ArrayList<ProvisionEmpleado>();
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
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
	
	public  List<ProvisionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProvisionEmpleado> entities = new  ArrayList<ProvisionEmpleado>();
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProvisionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProvisionEmpleado("",entity,resultSet);
      	    	
				//entity.setProvisionEmpleadoOriginal( new ProvisionEmpleado());
      	    	//entity.setProvisionEmpleadoOriginal(super.getEntity("",entity.getProvisionEmpleadoOriginal(),resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProvisionEmpleadoOriginal(this.getEntityProvisionEmpleado("",entity.getProvisionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProvisionEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProvisionEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProvisionEmpleado> entities = new  ArrayList<ProvisionEmpleado>();
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
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
	
	public  List<ProvisionEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProvisionEmpleado> entities = new  ArrayList<ProvisionEmpleado>();
		ProvisionEmpleado entity = new ProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProvisionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProvisionEmpleado("",entity,resultSet);
      	    	
				//entity.setProvisionEmpleadoOriginal( new ProvisionEmpleado());
      	    	//entity.setProvisionEmpleadoOriginal(super.getEntity("",entity.getProvisionEmpleadoOriginal(),resultSet,ProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProvisionEmpleadoOriginal(this.getEntityProvisionEmpleado("",entity.getProvisionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProvisionEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProvisionEmpleado getEntityProvisionEmpleado(String strPrefijo,ProvisionEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ProvisionEmpleadoConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+ProvisionEmpleadoConstantesFunciones.IDEMPLEADO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA));
				entity.setid_tipo_provision_empleado(resultSet.getLong(strPrefijo+ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO));
				entity.setid_defi_provision_empleado(resultSet.getLong(strPrefijo+ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO));
				entity.setid_anio(resultSet.getLong(strPrefijo+ProvisionEmpleadoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+ProvisionEmpleadoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+ProvisionEmpleadoConstantesFunciones.FECHA).getTime()));
				entity.setfecha_liquidacion(new Date(resultSet.getDate(strPrefijo+ProvisionEmpleadoConstantesFunciones.FECHALIQUIDACION).getTime()));
				entity.setvalor_mes(resultSet.getDouble(strPrefijo+ProvisionEmpleadoConstantesFunciones.VALORMES));
				entity.setvalor_paga(resultSet.getDouble(strPrefijo+ProvisionEmpleadoConstantesFunciones.VALORPAGA));
				entity.setvalor_vacacion(resultSet.getDouble(strPrefijo+ProvisionEmpleadoConstantesFunciones.VALORVACACION));
				entity.setvalor_liquidacion(resultSet.getDouble(strPrefijo+ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProvisionEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProvisionEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProvisionEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProvisionEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProvisionEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProvisionEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProvisionEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProvisionEmpleadoDataAccess.TABLENAME,ProvisionEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			ProvisionEmpleadoDataAccess.setProvisionEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ProvisionEmpleado relprovisionempleado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relprovisionempleado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,ProvisionEmpleado relprovisionempleado)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relprovisionempleado.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Estructura getEstructura(Connexion connexion,ProvisionEmpleado relprovisionempleado)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relprovisionempleado.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public TipoProvisionEmpleado getTipoProvisionEmpleado(Connexion connexion,ProvisionEmpleado relprovisionempleado)throws SQLException,Exception {

		TipoProvisionEmpleado tipoprovisionempleado= new TipoProvisionEmpleado();

		try {
			TipoProvisionEmpleadoDataAccess tipoprovisionempleadoDataAccess=new TipoProvisionEmpleadoDataAccess();

			tipoprovisionempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprovisionempleadoDataAccess.setConnexionType(this.connexionType);
			tipoprovisionempleadoDataAccess.setParameterDbType(this.parameterDbType);

			tipoprovisionempleado=tipoprovisionempleadoDataAccess.getEntity(connexion,relprovisionempleado.getid_tipo_provision_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprovisionempleado;

	}

	public DefiProvisionEmpleado getDefiProvisionEmpleado(Connexion connexion,ProvisionEmpleado relprovisionempleado)throws SQLException,Exception {

		DefiProvisionEmpleado defiprovisionempleado= new DefiProvisionEmpleado();

		try {
			DefiProvisionEmpleadoDataAccess defiprovisionempleadoDataAccess=new DefiProvisionEmpleadoDataAccess();

			defiprovisionempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			defiprovisionempleadoDataAccess.setConnexionType(this.connexionType);
			defiprovisionempleadoDataAccess.setParameterDbType(this.parameterDbType);

			defiprovisionempleado=defiprovisionempleadoDataAccess.getEntity(connexion,relprovisionempleado.getid_defi_provision_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return defiprovisionempleado;

	}

	public Anio getAnio(Connexion connexion,ProvisionEmpleado relprovisionempleado)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relprovisionempleado.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,ProvisionEmpleado relprovisionempleado)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relprovisionempleado.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProvisionEmpleado provisionempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!provisionempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(provisionempleado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(provisionempleado.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(provisionempleado.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_provision_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_provision_empleado.setValue(provisionempleado.getid_tipo_provision_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_provision_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_defi_provision_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_defi_provision_empleado.setValue(provisionempleado.getid_defi_provision_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_defi_provision_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(provisionempleado.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(provisionempleado.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(provisionempleado.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_liquidacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_liquidacion.setValue(provisionempleado.getfecha_liquidacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_liquidacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_mes=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_mes.setValue(provisionempleado.getvalor_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_paga=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_paga.setValue(provisionempleado.getvalor_paga());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_paga);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_vacacion=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_vacacion.setValue(provisionempleado.getvalor_vacacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_vacacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_liquidacion=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_liquidacion.setValue(provisionempleado.getvalor_liquidacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_liquidacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!provisionempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(provisionempleado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(provisionempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(provisionempleado.getId());
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
	
	public void setIsNewIsChangedFalseProvisionEmpleado(ProvisionEmpleado provisionempleado)throws Exception  {		
		provisionempleado.setIsNew(false);
		provisionempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProvisionEmpleados(List<ProvisionEmpleado> provisionempleados)throws Exception  {				
		for(ProvisionEmpleado provisionempleado:provisionempleados) {
			provisionempleado.setIsNew(false);
			provisionempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarProvisionEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
