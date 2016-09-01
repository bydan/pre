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
import com.bydan.erp.nomina.util.*;//EmpleadoIdiomaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class EmpleadoIdiomaDataAccess extends  EmpleadoIdiomaDataAccessAdditional{ //EmpleadoIdiomaDataAccessAdditional,DataAccessHelper<EmpleadoIdioma>
	//static Logger logger = Logger.getLogger(EmpleadoIdiomaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empleado_idioma";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_idioma,es_materna,es_tecnico,porcen_tecnico,es_lectura,porcen_lectura,es_escrito,porcen_escrito,es_hablado,porcen_hablado,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_idioma=?,es_materna=?,es_tecnico=?,porcen_tecnico=?,es_lectura=?,porcen_lectura=?,es_escrito=?,porcen_escrito=?,es_hablado=?,porcen_hablado=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empleadoidioma from "+EmpleadoIdiomaConstantesFunciones.SPERSISTENCENAME+" empleadoidioma";
	public static String QUERYSELECTNATIVE="select "+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".id,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".version_row,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".id_idioma,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".es_materna,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".es_tecnico,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".porcen_tecnico,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".es_lectura,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".porcen_lectura,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".es_escrito,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".porcen_escrito,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".es_hablado,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".porcen_hablado,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".descripcion from "+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME;//+" as "+EmpleadoIdiomaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".id,"+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+".version_row from "+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME;//+" as "+EmpleadoIdiomaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpleadoIdiomaConstantesFunciones.SCHEMA+"."+EmpleadoIdiomaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_idioma=?,es_materna=?,es_tecnico=?,porcen_tecnico=?,es_lectura=?,porcen_lectura=?,es_escrito=?,porcen_escrito=?,es_hablado=?,porcen_hablado=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPLEADOIDIOMA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPLEADOIDIOMA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPLEADOIDIOMA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPLEADOIDIOMA_SELECT(?,?)";
	
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
	
	
	protected EmpleadoIdiomaDataAccessAdditional empleadoidiomaDataAccessAdditional=null;
	
	public EmpleadoIdiomaDataAccessAdditional getEmpleadoIdiomaDataAccessAdditional() {
		return this.empleadoidiomaDataAccessAdditional;
	}
	
	public void setEmpleadoIdiomaDataAccessAdditional(EmpleadoIdiomaDataAccessAdditional empleadoidiomaDataAccessAdditional) {
		try {
			this.empleadoidiomaDataAccessAdditional=empleadoidiomaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpleadoIdiomaDataAccess() {
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
		EmpleadoIdiomaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpleadoIdiomaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpleadoIdiomaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpleadoIdiomaOriginal(EmpleadoIdioma empleadoidioma)throws Exception  {
		empleadoidioma.setEmpleadoIdiomaOriginal((EmpleadoIdioma)empleadoidioma.clone());		
	}
	
	public void setEmpleadoIdiomasOriginal(List<EmpleadoIdioma> empleadoidiomas)throws Exception  {
		
		for(EmpleadoIdioma empleadoidioma:empleadoidiomas){
			empleadoidioma.setEmpleadoIdiomaOriginal((EmpleadoIdioma)empleadoidioma.clone());
		}
	}
	
	public static void setEmpleadoIdiomaOriginalStatic(EmpleadoIdioma empleadoidioma)throws Exception  {
		empleadoidioma.setEmpleadoIdiomaOriginal((EmpleadoIdioma)empleadoidioma.clone());		
	}
	
	public static void setEmpleadoIdiomasOriginalStatic(List<EmpleadoIdioma> empleadoidiomas)throws Exception  {
		
		for(EmpleadoIdioma empleadoidioma:empleadoidiomas){
			empleadoidioma.setEmpleadoIdiomaOriginal((EmpleadoIdioma)empleadoidioma.clone());
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
	
	public  EmpleadoIdioma getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoIdioma entity = new EmpleadoIdioma();		
		
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
	
	public  EmpleadoIdioma getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoIdioma entity = new EmpleadoIdioma();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EmpleadoIdioma.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpleadoIdiomaOriginal(new EmpleadoIdioma());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoIdioma("",entity,resultSet); 
				
				//entity.setEmpleadoIdiomaOriginal(super.getEntity("",entity.getEmpleadoIdiomaOriginal(),resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoIdiomaOriginal(this.getEntityEmpleadoIdioma("",entity.getEmpleadoIdiomaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoIdioma(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EmpleadoIdioma getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoIdioma entity = new EmpleadoIdioma();
				
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
	
	public  EmpleadoIdioma getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoIdioma entity = new EmpleadoIdioma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoIdiomaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoIdioma.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpleadoIdiomaOriginal(new EmpleadoIdioma());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoIdioma("",entity,resultSet);    
				
				//entity.setEmpleadoIdiomaOriginal(super.getEntity("",entity.getEmpleadoIdiomaOriginal(),resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoIdiomaOriginal(this.getEntityEmpleadoIdioma("",entity.getEmpleadoIdiomaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoIdioma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EmpleadoIdioma
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EmpleadoIdioma entity = new EmpleadoIdioma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoIdiomaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoIdioma.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpleadoIdioma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EmpleadoIdioma> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoIdioma> entities = new  ArrayList<EmpleadoIdioma>();
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
		
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
	
	public  List<EmpleadoIdioma> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoIdioma> entities = new  ArrayList<EmpleadoIdioma>();
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoIdiomaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoIdioma();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoIdioma("",entity,resultSet);
      	    	
				//entity.setEmpleadoIdiomaOriginal( new EmpleadoIdioma());
      	    	//entity.setEmpleadoIdiomaOriginal(super.getEntity("",entity.getEmpleadoIdiomaOriginal(),resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoIdiomaOriginal(this.getEntityEmpleadoIdioma("",entity.getEmpleadoIdiomaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoIdiomas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoIdioma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoIdioma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoIdioma> entities = new  ArrayList<EmpleadoIdioma>();
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
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
	
	public  List<EmpleadoIdioma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoIdioma> entities = new  ArrayList<EmpleadoIdioma>();
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoIdioma();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoIdioma();
					//entity.setMapEmpleadoIdioma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpleadoIdiomaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoIdioma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoIdiomaDataAccess.getEntityEmpleadoIdioma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoIdiomaOriginal( new EmpleadoIdioma());
					////entity.setEmpleadoIdiomaOriginal(super.getEntity("",entity.getEmpleadoIdiomaOriginal(),resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoIdiomaOriginal(this.getEntityEmpleadoIdioma("",entity.getEmpleadoIdiomaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoIdiomas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoIdioma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EmpleadoIdioma getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
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
	
	public  EmpleadoIdioma getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoIdioma();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoIdioma();
					//entity.setMapEmpleadoIdioma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpleadoIdiomaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoIdioma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoIdiomaDataAccess.getEntityEmpleadoIdioma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoIdiomaOriginal( new EmpleadoIdioma());
					////entity.setEmpleadoIdiomaOriginal(super.getEntity("",entity.getEmpleadoIdiomaOriginal(),resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoIdiomaOriginal(this.getEntityEmpleadoIdioma("",entity.getEmpleadoIdiomaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpleadoIdioma(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoIdioma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EmpleadoIdioma getEntityEmpleadoIdioma(String strPrefijo,EmpleadoIdioma entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EmpleadoIdioma.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EmpleadoIdioma.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpleadoIdiomaDataAccess.setFieldReflectionEmpleadoIdioma(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpleadoIdioma=EmpleadoIdiomaConstantesFunciones.getTodosTiposColumnasEmpleadoIdioma();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpleadoIdioma) {
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
							field = EmpleadoIdioma.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EmpleadoIdioma.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpleadoIdiomaDataAccess.setFieldReflectionEmpleadoIdioma(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpleadoIdioma(Field field,String strPrefijo,String sColumn,EmpleadoIdioma entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpleadoIdiomaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.IDIDIOMA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.ESMATERNA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.ESTECNICO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.PORCENTECNICO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.ESLECTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.PORCENLECTURA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.ESESCRITO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.PORCENESCRITO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.ESHABLADO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.PORCENHABLADO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case EmpleadoIdiomaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoIdioma>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EmpleadoIdioma> entities = new  ArrayList<EmpleadoIdioma>();
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoIdiomaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EmpleadoIdioma();
					entity=super.getEntity("",entity,resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpleadoIdioma("",entity,resultSet);
					
					//entity.setEmpleadoIdiomaOriginal( new EmpleadoIdioma());
					//entity.setEmpleadoIdiomaOriginal(super.getEntity("",entity.getEmpleadoIdiomaOriginal(),resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpleadoIdiomaOriginal(this.getEntityEmpleadoIdioma("",entity.getEmpleadoIdiomaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpleadoIdiomas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoIdioma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoIdioma>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EmpleadoIdioma> entities = new  ArrayList<EmpleadoIdioma>();
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoIdiomaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoIdiomaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EmpleadoIdioma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoIdioma> entities = new  ArrayList<EmpleadoIdioma>();
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
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
	
	public  List<EmpleadoIdioma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoIdioma> entities = new  ArrayList<EmpleadoIdioma>();
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoIdioma();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoIdioma("",entity,resultSet);
      	    	
				//entity.setEmpleadoIdiomaOriginal( new EmpleadoIdioma());
      	    	//entity.setEmpleadoIdiomaOriginal(super.getEntity("",entity.getEmpleadoIdiomaOriginal(),resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoIdiomaOriginal(this.getEntityEmpleadoIdioma("",entity.getEmpleadoIdiomaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpleadoIdiomas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoIdioma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoIdioma> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoIdioma> entities = new  ArrayList<EmpleadoIdioma>();
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
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
	
	public  List<EmpleadoIdioma> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoIdioma> entities = new  ArrayList<EmpleadoIdioma>();
		EmpleadoIdioma entity = new EmpleadoIdioma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoIdioma();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoIdioma("",entity,resultSet);
      	    	
				//entity.setEmpleadoIdiomaOriginal( new EmpleadoIdioma());
      	    	//entity.setEmpleadoIdiomaOriginal(super.getEntity("",entity.getEmpleadoIdiomaOriginal(),resultSet,EmpleadoIdiomaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoIdiomaOriginal(this.getEntityEmpleadoIdioma("",entity.getEmpleadoIdiomaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoIdiomas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EmpleadoIdioma getEntityEmpleadoIdioma(String strPrefijo,EmpleadoIdioma entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmpleadoIdiomaConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EmpleadoIdiomaConstantesFunciones.IDEMPLEADO));
				entity.setid_idioma(resultSet.getLong(strPrefijo+EmpleadoIdiomaConstantesFunciones.IDIDIOMA));
				entity.setes_materna(resultSet.getBoolean(strPrefijo+EmpleadoIdiomaConstantesFunciones.ESMATERNA));
				entity.setes_tecnico(resultSet.getBoolean(strPrefijo+EmpleadoIdiomaConstantesFunciones.ESTECNICO));
				entity.setporcen_tecnico(resultSet.getInt(strPrefijo+EmpleadoIdiomaConstantesFunciones.PORCENTECNICO));
				entity.setes_lectura(resultSet.getBoolean(strPrefijo+EmpleadoIdiomaConstantesFunciones.ESLECTURA));
				entity.setporcen_lectura(resultSet.getInt(strPrefijo+EmpleadoIdiomaConstantesFunciones.PORCENLECTURA));
				entity.setes_escrito(resultSet.getBoolean(strPrefijo+EmpleadoIdiomaConstantesFunciones.ESESCRITO));
				entity.setporcen_escrito(resultSet.getInt(strPrefijo+EmpleadoIdiomaConstantesFunciones.PORCENESCRITO));
				entity.setes_hablado(resultSet.getBoolean(strPrefijo+EmpleadoIdiomaConstantesFunciones.ESHABLADO));
				entity.setporcen_hablado(resultSet.getInt(strPrefijo+EmpleadoIdiomaConstantesFunciones.PORCENHABLADO));
				entity.setdescripcion(resultSet.getString(strPrefijo+EmpleadoIdiomaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpleadoIdioma(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EmpleadoIdioma entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpleadoIdiomaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpleadoIdiomaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpleadoIdiomaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpleadoIdiomaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpleadoIdiomaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpleadoIdiomaDataAccess.TABLENAME,EmpleadoIdiomaDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpleadoIdiomaDataAccess.setEmpleadoIdiomaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EmpleadoIdioma relempleadoidioma)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relempleadoidioma.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,EmpleadoIdioma relempleadoidioma)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relempleadoidioma.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Idioma getIdioma(Connexion connexion,EmpleadoIdioma relempleadoidioma)throws SQLException,Exception {

		Idioma idioma= new Idioma();

		try {
			IdiomaDataAccess idiomaDataAccess=new IdiomaDataAccess();

			idiomaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			idiomaDataAccess.setConnexionType(this.connexionType);
			idiomaDataAccess.setParameterDbType(this.parameterDbType);

			idioma=idiomaDataAccess.getEntity(connexion,relempleadoidioma.getid_idioma());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return idioma;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EmpleadoIdioma empleadoidioma) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empleadoidioma.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(empleadoidioma.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(empleadoidioma.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_idioma=new ParameterValue<Long>();
					parameterMaintenanceValueid_idioma.setValue(empleadoidioma.getid_idioma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_idioma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_materna=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_materna.setValue(empleadoidioma.getes_materna());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_materna);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_tecnico=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_tecnico.setValue(empleadoidioma.getes_tecnico());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_tecnico);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueporcen_tecnico=new ParameterValue<Integer>();
					parameterMaintenanceValueporcen_tecnico.setValue(empleadoidioma.getporcen_tecnico());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_tecnico);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_lectura=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_lectura.setValue(empleadoidioma.getes_lectura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_lectura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueporcen_lectura=new ParameterValue<Integer>();
					parameterMaintenanceValueporcen_lectura.setValue(empleadoidioma.getporcen_lectura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_lectura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_escrito=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_escrito.setValue(empleadoidioma.getes_escrito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_escrito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueporcen_escrito=new ParameterValue<Integer>();
					parameterMaintenanceValueporcen_escrito.setValue(empleadoidioma.getporcen_escrito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_escrito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_hablado=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_hablado.setValue(empleadoidioma.getes_hablado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_hablado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueporcen_hablado=new ParameterValue<Integer>();
					parameterMaintenanceValueporcen_hablado.setValue(empleadoidioma.getporcen_hablado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_hablado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(empleadoidioma.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!empleadoidioma.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empleadoidioma.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empleadoidioma.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empleadoidioma.getId());
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
	
	public void setIsNewIsChangedFalseEmpleadoIdioma(EmpleadoIdioma empleadoidioma)throws Exception  {		
		empleadoidioma.setIsNew(false);
		empleadoidioma.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpleadoIdiomas(List<EmpleadoIdioma> empleadoidiomas)throws Exception  {				
		for(EmpleadoIdioma empleadoidioma:empleadoidiomas) {
			empleadoidioma.setIsNew(false);
			empleadoidioma.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpleadoIdioma(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
