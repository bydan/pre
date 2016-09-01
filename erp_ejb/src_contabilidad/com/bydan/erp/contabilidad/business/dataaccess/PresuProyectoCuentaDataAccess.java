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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//PresuProyectoCuentaConstantesFunciones;


import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class PresuProyectoCuentaDataAccess extends  PresuProyectoCuentaDataAccessAdditional{ //PresuProyectoCuentaDataAccessAdditional,DataAccessHelper<PresuProyectoCuenta>
	//static Logger logger = Logger.getLogger(PresuProyectoCuentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="presu_proyecto_cuenta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+"(version_row,id_presu_proyecto,id_presu_tipo_cuenta_proyecto,codigo,nombre,id_cuenta_contable,id_empleado,fecha,valor,orden,id_presu_estado,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_presu_proyecto=?,id_presu_tipo_cuenta_proyecto=?,codigo=?,nombre=?,id_cuenta_contable=?,id_empleado=?,fecha=?,valor=?,orden=?,id_presu_estado=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select presuproyectocuenta from "+PresuProyectoCuentaConstantesFunciones.SPERSISTENCENAME+" presuproyectocuenta";
	public static String QUERYSELECTNATIVE="select "+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".version_row,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id_presu_proyecto,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id_presu_tipo_cuenta_proyecto,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".codigo,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".nombre,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id_empleado,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".fecha,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".valor,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".orden,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id_presu_estado,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".descripcion from "+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME;//+" as "+PresuProyectoCuentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".version_row,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".codigo from "+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME;//+" as "+PresuProyectoCuentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_presu_proyecto=?,id_presu_tipo_cuenta_proyecto=?,codigo=?,nombre=?,id_cuenta_contable=?,id_empleado=?,fecha=?,valor=?,orden=?,id_presu_estado=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRESUPROYECTOCUENTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRESUPROYECTOCUENTA_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRESUPROYECTOCUENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRESUPROYECTOCUENTA_SELECT(?,?)";
	
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
	
	
	protected PresuProyectoCuentaDataAccessAdditional presuproyectocuentaDataAccessAdditional=null;
	
	public PresuProyectoCuentaDataAccessAdditional getPresuProyectoCuentaDataAccessAdditional() {
		return this.presuproyectocuentaDataAccessAdditional;
	}
	
	public void setPresuProyectoCuentaDataAccessAdditional(PresuProyectoCuentaDataAccessAdditional presuproyectocuentaDataAccessAdditional) {
		try {
			this.presuproyectocuentaDataAccessAdditional=presuproyectocuentaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PresuProyectoCuentaDataAccess() {
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
		PresuProyectoCuentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PresuProyectoCuentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PresuProyectoCuentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPresuProyectoCuentaOriginal(PresuProyectoCuenta presuproyectocuenta)throws Exception  {
		presuproyectocuenta.setPresuProyectoCuentaOriginal((PresuProyectoCuenta)presuproyectocuenta.clone());		
	}
	
	public void setPresuProyectoCuentasOriginal(List<PresuProyectoCuenta> presuproyectocuentas)throws Exception  {
		
		for(PresuProyectoCuenta presuproyectocuenta:presuproyectocuentas){
			presuproyectocuenta.setPresuProyectoCuentaOriginal((PresuProyectoCuenta)presuproyectocuenta.clone());
		}
	}
	
	public static void setPresuProyectoCuentaOriginalStatic(PresuProyectoCuenta presuproyectocuenta)throws Exception  {
		presuproyectocuenta.setPresuProyectoCuentaOriginal((PresuProyectoCuenta)presuproyectocuenta.clone());		
	}
	
	public static void setPresuProyectoCuentasOriginalStatic(List<PresuProyectoCuenta> presuproyectocuentas)throws Exception  {
		
		for(PresuProyectoCuenta presuproyectocuenta:presuproyectocuentas){
			presuproyectocuenta.setPresuProyectoCuentaOriginal((PresuProyectoCuenta)presuproyectocuenta.clone());
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
	
	public  PresuProyectoCuenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		
		
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
	
	public  PresuProyectoCuenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.PresuProyectoCuenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPresuProyectoCuentaOriginal(new PresuProyectoCuenta());
      	    	entity=super.getEntity("",entity,resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresuProyectoCuenta("",entity,resultSet); 
				
				//entity.setPresuProyectoCuentaOriginal(super.getEntity("",entity.getPresuProyectoCuentaOriginal(),resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuProyectoCuentaOriginal(this.getEntityPresuProyectoCuenta("",entity.getPresuProyectoCuentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePresuProyectoCuenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PresuProyectoCuenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresuProyectoCuenta entity = new PresuProyectoCuenta();
				
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
	
	public  PresuProyectoCuenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresuProyectoCuenta entity = new PresuProyectoCuenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuProyectoCuentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresuProyectoCuenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPresuProyectoCuentaOriginal(new PresuProyectoCuenta());
      	    	entity=super.getEntity("",entity,resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresuProyectoCuenta("",entity,resultSet);    
				
				//entity.setPresuProyectoCuentaOriginal(super.getEntity("",entity.getPresuProyectoCuentaOriginal(),resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuProyectoCuentaOriginal(this.getEntityPresuProyectoCuenta("",entity.getPresuProyectoCuentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePresuProyectoCuenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PresuProyectoCuenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PresuProyectoCuenta entity = new PresuProyectoCuenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuProyectoCuentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresuProyectoCuenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePresuProyectoCuenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PresuProyectoCuenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresuProyectoCuenta> entities = new  ArrayList<PresuProyectoCuenta>();
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
		
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
	
	public  List<PresuProyectoCuenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresuProyectoCuenta> entities = new  ArrayList<PresuProyectoCuenta>();
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuProyectoCuentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuProyectoCuenta();
      	    	entity=super.getEntity("",entity,resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuProyectoCuenta("",entity,resultSet);
      	    	
				//entity.setPresuProyectoCuentaOriginal( new PresuProyectoCuenta());
      	    	//entity.setPresuProyectoCuentaOriginal(super.getEntity("",entity.getPresuProyectoCuentaOriginal(),resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuProyectoCuentaOriginal(this.getEntityPresuProyectoCuenta("",entity.getPresuProyectoCuentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuProyectoCuentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuProyectoCuenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresuProyectoCuenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresuProyectoCuenta> entities = new  ArrayList<PresuProyectoCuenta>();
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
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
	
	public  List<PresuProyectoCuenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresuProyectoCuenta> entities = new  ArrayList<PresuProyectoCuenta>();
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuProyectoCuenta();
				
				if(conMapGenerico) {
					entity.inicializarMapPresuProyectoCuenta();
					//entity.setMapPresuProyectoCuenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPresuProyectoCuentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresuProyectoCuenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA);         		
					entity=PresuProyectoCuentaDataAccess.getEntityPresuProyectoCuenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresuProyectoCuentaOriginal( new PresuProyectoCuenta());
					////entity.setPresuProyectoCuentaOriginal(super.getEntity("",entity.getPresuProyectoCuentaOriginal(),resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA));         		
					////entity.setPresuProyectoCuentaOriginal(this.getEntityPresuProyectoCuenta("",entity.getPresuProyectoCuentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuProyectoCuentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuProyectoCuenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PresuProyectoCuenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
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
	
	public  PresuProyectoCuenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuProyectoCuenta();
				
				if(conMapGenerico) {
					entity.inicializarMapPresuProyectoCuenta();
					//entity.setMapPresuProyectoCuenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPresuProyectoCuentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresuProyectoCuenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA);         		
					entity=PresuProyectoCuentaDataAccess.getEntityPresuProyectoCuenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresuProyectoCuentaOriginal( new PresuProyectoCuenta());
					////entity.setPresuProyectoCuentaOriginal(super.getEntity("",entity.getPresuProyectoCuentaOriginal(),resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA));         		
					////entity.setPresuProyectoCuentaOriginal(this.getEntityPresuProyectoCuenta("",entity.getPresuProyectoCuentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePresuProyectoCuenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuProyectoCuenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PresuProyectoCuenta getEntityPresuProyectoCuenta(String strPrefijo,PresuProyectoCuenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PresuProyectoCuenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PresuProyectoCuenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PresuProyectoCuentaDataAccess.setFieldReflectionPresuProyectoCuenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPresuProyectoCuenta=PresuProyectoCuentaConstantesFunciones.getTodosTiposColumnasPresuProyectoCuenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPresuProyectoCuenta) {
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
							field = PresuProyectoCuenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PresuProyectoCuenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PresuProyectoCuentaDataAccess.setFieldReflectionPresuProyectoCuenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPresuProyectoCuenta(Field field,String strPrefijo,String sColumn,PresuProyectoCuenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PresuProyectoCuentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuProyectoCuentaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresuProyectoCuenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PresuProyectoCuenta> entities = new  ArrayList<PresuProyectoCuenta>();
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuProyectoCuentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PresuProyectoCuenta();
					entity=super.getEntity("",entity,resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPresuProyectoCuenta("",entity,resultSet);
					
					//entity.setPresuProyectoCuentaOriginal( new PresuProyectoCuenta());
					//entity.setPresuProyectoCuentaOriginal(super.getEntity("",entity.getPresuProyectoCuentaOriginal(),resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA));         		
					//entity.setPresuProyectoCuentaOriginal(this.getEntityPresuProyectoCuenta("",entity.getPresuProyectoCuentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePresuProyectoCuentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuProyectoCuenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresuProyectoCuenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PresuProyectoCuenta> entities = new  ArrayList<PresuProyectoCuenta>();
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuProyectoCuentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuProyectoCuentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PresuProyectoCuenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuProyectoCuenta> entities = new  ArrayList<PresuProyectoCuenta>();
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
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
	
	public  List<PresuProyectoCuenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuProyectoCuenta> entities = new  ArrayList<PresuProyectoCuenta>();
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuProyectoCuenta();
      	    	entity=super.getEntity("",entity,resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuProyectoCuenta("",entity,resultSet);
      	    	
				//entity.setPresuProyectoCuentaOriginal( new PresuProyectoCuenta());
      	    	//entity.setPresuProyectoCuentaOriginal(super.getEntity("",entity.getPresuProyectoCuentaOriginal(),resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuProyectoCuentaOriginal(this.getEntityPresuProyectoCuenta("",entity.getPresuProyectoCuentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePresuProyectoCuentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuProyectoCuenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresuProyectoCuenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuProyectoCuenta> entities = new  ArrayList<PresuProyectoCuenta>();
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
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
	
	public  List<PresuProyectoCuenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuProyectoCuenta> entities = new  ArrayList<PresuProyectoCuenta>();
		PresuProyectoCuenta entity = new PresuProyectoCuenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuProyectoCuenta();
      	    	entity=super.getEntity("",entity,resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuProyectoCuenta("",entity,resultSet);
      	    	
				//entity.setPresuProyectoCuentaOriginal( new PresuProyectoCuenta());
      	    	//entity.setPresuProyectoCuentaOriginal(super.getEntity("",entity.getPresuProyectoCuentaOriginal(),resultSet,PresuProyectoCuentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuProyectoCuentaOriginal(this.getEntityPresuProyectoCuenta("",entity.getPresuProyectoCuentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuProyectoCuentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PresuProyectoCuenta getEntityPresuProyectoCuenta(String strPrefijo,PresuProyectoCuenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_presu_proyecto(resultSet.getLong(strPrefijo+PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO));
				entity.setid_presu_tipo_cuenta_proyecto(resultSet.getLong(strPrefijo+PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO));
				entity.setcodigo(resultSet.getString(strPrefijo+PresuProyectoCuentaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+PresuProyectoCuentaConstantesFunciones.NOMBRE));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_empleado(resultSet.getLong(strPrefijo+PresuProyectoCuentaConstantesFunciones.IDEMPLEADO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PresuProyectoCuentaConstantesFunciones.FECHA).getTime()));
				entity.setvalor(resultSet.getDouble(strPrefijo+PresuProyectoCuentaConstantesFunciones.VALOR));
				entity.setorden(resultSet.getInt(strPrefijo+PresuProyectoCuentaConstantesFunciones.ORDEN));
				entity.setid_presu_estado(resultSet.getLong(strPrefijo+PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO));
				entity.setdescripcion(resultSet.getString(strPrefijo+PresuProyectoCuentaConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+PresuProyectoCuentaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPresuProyectoCuenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PresuProyectoCuenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PresuProyectoCuentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PresuProyectoCuentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PresuProyectoCuentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PresuProyectoCuentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PresuProyectoCuentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PresuProyectoCuentaDataAccess.TABLENAME,PresuProyectoCuentaDataAccess.ISWITHSTOREPROCEDURES);
			
			PresuProyectoCuentaDataAccess.setPresuProyectoCuentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public PresuProyecto getPresuProyecto(Connexion connexion,PresuProyectoCuenta relpresuproyectocuenta)throws SQLException,Exception {

		PresuProyecto presuproyecto= new PresuProyecto();

		try {
			PresuProyectoDataAccess presuproyectoDataAccess=new PresuProyectoDataAccess();

			presuproyectoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			presuproyectoDataAccess.setConnexionType(this.connexionType);
			presuproyectoDataAccess.setParameterDbType(this.parameterDbType);

			presuproyecto=presuproyectoDataAccess.getEntity(connexion,relpresuproyectocuenta.getid_presu_proyecto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presuproyecto;

	}

	public PresuTipoCuentaProyecto getPresuTipoCuentaProyecto(Connexion connexion,PresuProyectoCuenta relpresuproyectocuenta)throws SQLException,Exception {

		PresuTipoCuentaProyecto presutipocuentaproyecto= new PresuTipoCuentaProyecto();

		try {
			PresuTipoCuentaProyectoDataAccess presutipocuentaproyectoDataAccess=new PresuTipoCuentaProyectoDataAccess();

			presutipocuentaproyectoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			presutipocuentaproyectoDataAccess.setConnexionType(this.connexionType);
			presutipocuentaproyectoDataAccess.setParameterDbType(this.parameterDbType);

			presutipocuentaproyecto=presutipocuentaproyectoDataAccess.getEntity(connexion,relpresuproyectocuenta.getid_presu_tipo_cuenta_proyecto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presutipocuentaproyecto;

	}

	public CuentaContable getCuentaContable(Connexion connexion,PresuProyectoCuenta relpresuproyectocuenta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relpresuproyectocuenta.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Empleado getEmpleado(Connexion connexion,PresuProyectoCuenta relpresuproyectocuenta)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relpresuproyectocuenta.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public PresuEstado getPresuEstado(Connexion connexion,PresuProyectoCuenta relpresuproyectocuenta)throws SQLException,Exception {

		PresuEstado presuestado= new PresuEstado();

		try {
			PresuEstadoDataAccess presuestadoDataAccess=new PresuEstadoDataAccess();

			presuestadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			presuestadoDataAccess.setConnexionType(this.connexionType);
			presuestadoDataAccess.setParameterDbType(this.parameterDbType);

			presuestado=presuestadoDataAccess.getEntity(connexion,relpresuproyectocuenta.getid_presu_estado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presuestado;

	}


		
		public List<PresuAsignacion> getPresuAsignacions(Connexion connexion,PresuProyectoCuenta presuproyectocuenta)throws SQLException,Exception {

		List<PresuAsignacion> presuasignacions= new ArrayList<PresuAsignacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PresuProyectoCuentaConstantesFunciones.SCHEMA+".presu_proyecto_cuenta ON "+PresuAsignacionConstantesFunciones.SCHEMA+".presu_asignacion.id_presu_proyecto_cuenta="+PresuProyectoCuentaConstantesFunciones.SCHEMA+".presu_proyecto_cuenta.id WHERE "+PresuProyectoCuentaConstantesFunciones.SCHEMA+".presu_proyecto_cuenta.id="+String.valueOf(presuproyectocuenta.getId());
			} else {
				sQuery=" INNER JOIN presuasignacion.PresuProyectoCuenta WHERE presuasignacion.PresuProyectoCuenta.id="+String.valueOf(presuproyectocuenta.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresuAsignacionDataAccess presuasignacionDataAccess=new PresuAsignacionDataAccess();

			presuasignacionDataAccess.setConnexionType(this.connexionType);
			presuasignacionDataAccess.setParameterDbType(this.parameterDbType);
			presuasignacions=presuasignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presuasignacions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PresuProyectoCuenta presuproyectocuenta) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!presuproyectocuenta.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_presu_proyecto=new ParameterValue<Long>();
					parameterMaintenanceValueid_presu_proyecto.setValue(presuproyectocuenta.getid_presu_proyecto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_presu_proyecto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_presu_tipo_cuenta_proyecto=new ParameterValue<Long>();
					parameterMaintenanceValueid_presu_tipo_cuenta_proyecto.setValue(presuproyectocuenta.getid_presu_tipo_cuenta_proyecto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_presu_tipo_cuenta_proyecto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(presuproyectocuenta.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(presuproyectocuenta.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(presuproyectocuenta.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(presuproyectocuenta.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(presuproyectocuenta.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(presuproyectocuenta.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueorden=new ParameterValue<Integer>();
					parameterMaintenanceValueorden.setValue(presuproyectocuenta.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_presu_estado=new ParameterValue<Long>();
					parameterMaintenanceValueid_presu_estado.setValue(presuproyectocuenta.getid_presu_estado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_presu_estado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(presuproyectocuenta.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!presuproyectocuenta.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(presuproyectocuenta.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(presuproyectocuenta.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(presuproyectocuenta.getId());
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
	
	public void setIsNewIsChangedFalsePresuProyectoCuenta(PresuProyectoCuenta presuproyectocuenta)throws Exception  {		
		presuproyectocuenta.setIsNew(false);
		presuproyectocuenta.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePresuProyectoCuentas(List<PresuProyectoCuenta> presuproyectocuentas)throws Exception  {				
		for(PresuProyectoCuenta presuproyectocuenta:presuproyectocuentas) {
			presuproyectocuenta.setIsNew(false);
			presuproyectocuenta.setIsChanged(false);
		}
	}
	
	public void generarExportarPresuProyectoCuenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
