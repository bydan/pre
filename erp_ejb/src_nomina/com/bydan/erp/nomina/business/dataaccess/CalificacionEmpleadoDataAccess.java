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
import com.bydan.erp.nomina.util.*;//CalificacionEmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class CalificacionEmpleadoDataAccess extends  CalificacionEmpleadoDataAccessAdditional{ //CalificacionEmpleadoDataAccessAdditional,DataAccessHelper<CalificacionEmpleado>
	//static Logger logger = Logger.getLogger(CalificacionEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="calificacion_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_empleado,id_evaluacion_empleado,id_formato_nomi_factor_nomi,id_formato_nomi_pregunta_nomi,id_tipo_calificacion_empleado,valor_conocimiento,valor_eficiencia,valor_obtenido,valor_peso,verificado)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_empleado=?,id_evaluacion_empleado=?,id_formato_nomi_factor_nomi=?,id_formato_nomi_pregunta_nomi=?,id_tipo_calificacion_empleado=?,valor_conocimiento=?,valor_eficiencia=?,valor_obtenido=?,valor_peso=?,verificado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select calificacionempleado from "+CalificacionEmpleadoConstantesFunciones.SPERSISTENCENAME+" calificacionempleado";
	public static String QUERYSELECTNATIVE="select "+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_sucursal,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_ejercicio,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_periodo,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_evaluacion_empleado,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_formato_nomi_factor_nomi,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_formato_nomi_pregunta_nomi,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id_tipo_calificacion_empleado,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".valor_conocimiento,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".valor_eficiencia,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".valor_obtenido,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".valor_peso,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".verificado from "+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+CalificacionEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".id,"+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+".version_row from "+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+CalificacionEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CalificacionEmpleadoConstantesFunciones.SCHEMA+"."+CalificacionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_empleado=?,id_evaluacion_empleado=?,id_formato_nomi_factor_nomi=?,id_formato_nomi_pregunta_nomi=?,id_tipo_calificacion_empleado=?,valor_conocimiento=?,valor_eficiencia=?,valor_obtenido=?,valor_peso=?,verificado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CALIFICACIONEMPLEADO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CALIFICACIONEMPLEADO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CALIFICACIONEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CALIFICACIONEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected CalificacionEmpleadoDataAccessAdditional calificacionempleadoDataAccessAdditional=null;
	
	public CalificacionEmpleadoDataAccessAdditional getCalificacionEmpleadoDataAccessAdditional() {
		return this.calificacionempleadoDataAccessAdditional;
	}
	
	public void setCalificacionEmpleadoDataAccessAdditional(CalificacionEmpleadoDataAccessAdditional calificacionempleadoDataAccessAdditional) {
		try {
			this.calificacionempleadoDataAccessAdditional=calificacionempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CalificacionEmpleadoDataAccess() {
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
		CalificacionEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CalificacionEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CalificacionEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCalificacionEmpleadoOriginal(CalificacionEmpleado calificacionempleado)throws Exception  {
		calificacionempleado.setCalificacionEmpleadoOriginal((CalificacionEmpleado)calificacionempleado.clone());		
	}
	
	public void setCalificacionEmpleadosOriginal(List<CalificacionEmpleado> calificacionempleados)throws Exception  {
		
		for(CalificacionEmpleado calificacionempleado:calificacionempleados){
			calificacionempleado.setCalificacionEmpleadoOriginal((CalificacionEmpleado)calificacionempleado.clone());
		}
	}
	
	public static void setCalificacionEmpleadoOriginalStatic(CalificacionEmpleado calificacionempleado)throws Exception  {
		calificacionempleado.setCalificacionEmpleadoOriginal((CalificacionEmpleado)calificacionempleado.clone());		
	}
	
	public static void setCalificacionEmpleadosOriginalStatic(List<CalificacionEmpleado> calificacionempleados)throws Exception  {
		
		for(CalificacionEmpleado calificacionempleado:calificacionempleados){
			calificacionempleado.setCalificacionEmpleadoOriginal((CalificacionEmpleado)calificacionempleado.clone());
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
	
	public  CalificacionEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CalificacionEmpleado entity = new CalificacionEmpleado();		
		
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
	
	public  CalificacionEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CalificacionEmpleado entity = new CalificacionEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.CalificacionEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCalificacionEmpleadoOriginal(new CalificacionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCalificacionEmpleado("",entity,resultSet); 
				
				//entity.setCalificacionEmpleadoOriginal(super.getEntity("",entity.getCalificacionEmpleadoOriginal(),resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCalificacionEmpleadoOriginal(this.getEntityCalificacionEmpleado("",entity.getCalificacionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCalificacionEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CalificacionEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CalificacionEmpleado entity = new CalificacionEmpleado();
				
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
	
	public  CalificacionEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CalificacionEmpleado entity = new CalificacionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CalificacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.CalificacionEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCalificacionEmpleadoOriginal(new CalificacionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCalificacionEmpleado("",entity,resultSet);    
				
				//entity.setCalificacionEmpleadoOriginal(super.getEntity("",entity.getCalificacionEmpleadoOriginal(),resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCalificacionEmpleadoOriginal(this.getEntityCalificacionEmpleado("",entity.getCalificacionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCalificacionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CalificacionEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CalificacionEmpleado entity = new CalificacionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CalificacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.CalificacionEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCalificacionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CalificacionEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CalificacionEmpleado> entities = new  ArrayList<CalificacionEmpleado>();
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
		
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
	
	public  List<CalificacionEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CalificacionEmpleado> entities = new  ArrayList<CalificacionEmpleado>();
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CalificacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CalificacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCalificacionEmpleado("",entity,resultSet);
      	    	
				//entity.setCalificacionEmpleadoOriginal( new CalificacionEmpleado());
      	    	//entity.setCalificacionEmpleadoOriginal(super.getEntity("",entity.getCalificacionEmpleadoOriginal(),resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCalificacionEmpleadoOriginal(this.getEntityCalificacionEmpleado("",entity.getCalificacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCalificacionEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCalificacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CalificacionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CalificacionEmpleado> entities = new  ArrayList<CalificacionEmpleado>();
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
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
	
	public  List<CalificacionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CalificacionEmpleado> entities = new  ArrayList<CalificacionEmpleado>();
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CalificacionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapCalificacionEmpleado();
					//entity.setMapCalificacionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCalificacionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCalificacionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=CalificacionEmpleadoDataAccess.getEntityCalificacionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCalificacionEmpleadoOriginal( new CalificacionEmpleado());
					////entity.setCalificacionEmpleadoOriginal(super.getEntity("",entity.getCalificacionEmpleadoOriginal(),resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setCalificacionEmpleadoOriginal(this.getEntityCalificacionEmpleado("",entity.getCalificacionEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCalificacionEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCalificacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CalificacionEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
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
	
	public  CalificacionEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CalificacionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapCalificacionEmpleado();
					//entity.setMapCalificacionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCalificacionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCalificacionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=CalificacionEmpleadoDataAccess.getEntityCalificacionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCalificacionEmpleadoOriginal( new CalificacionEmpleado());
					////entity.setCalificacionEmpleadoOriginal(super.getEntity("",entity.getCalificacionEmpleadoOriginal(),resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setCalificacionEmpleadoOriginal(this.getEntityCalificacionEmpleado("",entity.getCalificacionEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCalificacionEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCalificacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CalificacionEmpleado getEntityCalificacionEmpleado(String strPrefijo,CalificacionEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CalificacionEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CalificacionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CalificacionEmpleadoDataAccess.setFieldReflectionCalificacionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCalificacionEmpleado=CalificacionEmpleadoConstantesFunciones.getTodosTiposColumnasCalificacionEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCalificacionEmpleado) {
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
							field = CalificacionEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CalificacionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CalificacionEmpleadoDataAccess.setFieldReflectionCalificacionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCalificacionEmpleado(Field field,String strPrefijo,String sColumn,CalificacionEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CalificacionEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.VALORCONOCIMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.VALOREFICIENCIA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.VALOROBTENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.VALORPESO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CalificacionEmpleadoConstantesFunciones.VERIFICADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CalificacionEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CalificacionEmpleado> entities = new  ArrayList<CalificacionEmpleado>();
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CalificacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CalificacionEmpleado();
					entity=super.getEntity("",entity,resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCalificacionEmpleado("",entity,resultSet);
					
					//entity.setCalificacionEmpleadoOriginal( new CalificacionEmpleado());
					//entity.setCalificacionEmpleadoOriginal(super.getEntity("",entity.getCalificacionEmpleadoOriginal(),resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setCalificacionEmpleadoOriginal(this.getEntityCalificacionEmpleado("",entity.getCalificacionEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCalificacionEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCalificacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CalificacionEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CalificacionEmpleado> entities = new  ArrayList<CalificacionEmpleado>();
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CalificacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CalificacionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CalificacionEmpleado> entities = new  ArrayList<CalificacionEmpleado>();
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
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
	
	public  List<CalificacionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CalificacionEmpleado> entities = new  ArrayList<CalificacionEmpleado>();
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CalificacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCalificacionEmpleado("",entity,resultSet);
      	    	
				//entity.setCalificacionEmpleadoOriginal( new CalificacionEmpleado());
      	    	//entity.setCalificacionEmpleadoOriginal(super.getEntity("",entity.getCalificacionEmpleadoOriginal(),resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCalificacionEmpleadoOriginal(this.getEntityCalificacionEmpleado("",entity.getCalificacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCalificacionEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCalificacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CalificacionEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CalificacionEmpleado> entities = new  ArrayList<CalificacionEmpleado>();
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
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
	
	public  List<CalificacionEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CalificacionEmpleado> entities = new  ArrayList<CalificacionEmpleado>();
		CalificacionEmpleado entity = new CalificacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CalificacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCalificacionEmpleado("",entity,resultSet);
      	    	
				//entity.setCalificacionEmpleadoOriginal( new CalificacionEmpleado());
      	    	//entity.setCalificacionEmpleadoOriginal(super.getEntity("",entity.getCalificacionEmpleadoOriginal(),resultSet,CalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCalificacionEmpleadoOriginal(this.getEntityCalificacionEmpleado("",entity.getCalificacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCalificacionEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CalificacionEmpleado getEntityCalificacionEmpleado(String strPrefijo,CalificacionEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CalificacionEmpleadoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CalificacionEmpleadoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+CalificacionEmpleadoConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+CalificacionEmpleadoConstantesFunciones.IDPERIODO));
				entity.setid_empleado(resultSet.getLong(strPrefijo+CalificacionEmpleadoConstantesFunciones.IDEMPLEADO));
				entity.setid_evaluacion_empleado(resultSet.getLong(strPrefijo+CalificacionEmpleadoConstantesFunciones.IDEVALUACIONEMPLEADO));
				entity.setid_formato_nomi_factor_nomi(resultSet.getLong(strPrefijo+CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIFACTORNOMI));
				entity.setid_formato_nomi_pregunta_nomi(resultSet.getLong(strPrefijo+CalificacionEmpleadoConstantesFunciones.IDFORMATONOMIPREGUNTANOMI));
				entity.setid_tipo_calificacion_empleado(resultSet.getLong(strPrefijo+CalificacionEmpleadoConstantesFunciones.IDTIPOCALIFICACIONEMPLEADO));
				entity.setvalor_conocimiento(resultSet.getDouble(strPrefijo+CalificacionEmpleadoConstantesFunciones.VALORCONOCIMIENTO));
				entity.setvalor_eficiencia(resultSet.getDouble(strPrefijo+CalificacionEmpleadoConstantesFunciones.VALOREFICIENCIA));
				entity.setvalor_obtenido(resultSet.getDouble(strPrefijo+CalificacionEmpleadoConstantesFunciones.VALOROBTENIDO));
				entity.setvalor_peso(resultSet.getDouble(strPrefijo+CalificacionEmpleadoConstantesFunciones.VALORPESO));
				entity.setverificado(resultSet.getBoolean(strPrefijo+CalificacionEmpleadoConstantesFunciones.VERIFICADO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCalificacionEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CalificacionEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CalificacionEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CalificacionEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CalificacionEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CalificacionEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CalificacionEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CalificacionEmpleadoDataAccess.TABLENAME,CalificacionEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			CalificacionEmpleadoDataAccess.setCalificacionEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CalificacionEmpleado relcalificacionempleado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcalificacionempleado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CalificacionEmpleado relcalificacionempleado)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcalificacionempleado.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,CalificacionEmpleado relcalificacionempleado)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relcalificacionempleado.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,CalificacionEmpleado relcalificacionempleado)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relcalificacionempleado.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Empleado getEmpleado(Connexion connexion,CalificacionEmpleado relcalificacionempleado)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relcalificacionempleado.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public EvaluacionEmpleado getEvaluacionEmpleado(Connexion connexion,CalificacionEmpleado relcalificacionempleado)throws SQLException,Exception {

		EvaluacionEmpleado evaluacionempleado= new EvaluacionEmpleado();

		try {
			EvaluacionEmpleadoDataAccess evaluacionempleadoDataAccess=new EvaluacionEmpleadoDataAccess();

			evaluacionempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			evaluacionempleadoDataAccess.setConnexionType(this.connexionType);
			evaluacionempleadoDataAccess.setParameterDbType(this.parameterDbType);

			evaluacionempleado=evaluacionempleadoDataAccess.getEntity(connexion,relcalificacionempleado.getid_evaluacion_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return evaluacionempleado;

	}

	public FormatoNomiFactorNomi getFormatoNomiFactorNomi(Connexion connexion,CalificacionEmpleado relcalificacionempleado)throws SQLException,Exception {

		FormatoNomiFactorNomi formatonomifactornomi= new FormatoNomiFactorNomi();

		try {
			FormatoNomiFactorNomiDataAccess formatonomifactornomiDataAccess=new FormatoNomiFactorNomiDataAccess();

			formatonomifactornomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatonomifactornomiDataAccess.setConnexionType(this.connexionType);
			formatonomifactornomiDataAccess.setParameterDbType(this.parameterDbType);

			formatonomifactornomi=formatonomifactornomiDataAccess.getEntity(connexion,relcalificacionempleado.getid_formato_nomi_factor_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatonomifactornomi;

	}

	public FormatoNomiPreguntaNomi getFormatoNomiPreguntaNomi(Connexion connexion,CalificacionEmpleado relcalificacionempleado)throws SQLException,Exception {

		FormatoNomiPreguntaNomi formatonomipreguntanomi= new FormatoNomiPreguntaNomi();

		try {
			FormatoNomiPreguntaNomiDataAccess formatonomipreguntanomiDataAccess=new FormatoNomiPreguntaNomiDataAccess();

			formatonomipreguntanomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatonomipreguntanomiDataAccess.setConnexionType(this.connexionType);
			formatonomipreguntanomiDataAccess.setParameterDbType(this.parameterDbType);

			formatonomipreguntanomi=formatonomipreguntanomiDataAccess.getEntity(connexion,relcalificacionempleado.getid_formato_nomi_pregunta_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatonomipreguntanomi;

	}

	public TipoCalificacionEmpleado getTipoCalificacionEmpleado(Connexion connexion,CalificacionEmpleado relcalificacionempleado)throws SQLException,Exception {

		TipoCalificacionEmpleado tipocalificacionempleado= new TipoCalificacionEmpleado();

		try {
			TipoCalificacionEmpleadoDataAccess tipocalificacionempleadoDataAccess=new TipoCalificacionEmpleadoDataAccess();

			tipocalificacionempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocalificacionempleadoDataAccess.setConnexionType(this.connexionType);
			tipocalificacionempleadoDataAccess.setParameterDbType(this.parameterDbType);

			tipocalificacionempleado=tipocalificacionempleadoDataAccess.getEntity(connexion,relcalificacionempleado.getid_tipo_calificacion_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocalificacionempleado;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CalificacionEmpleado calificacionempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!calificacionempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(calificacionempleado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(calificacionempleado.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(calificacionempleado.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(calificacionempleado.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(calificacionempleado.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_evaluacion_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_evaluacion_empleado.setValue(calificacionempleado.getid_evaluacion_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_evaluacion_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_nomi_factor_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_nomi_factor_nomi.setValue(calificacionempleado.getid_formato_nomi_factor_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_nomi_factor_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_nomi_pregunta_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_nomi_pregunta_nomi.setValue(calificacionempleado.getid_formato_nomi_pregunta_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_nomi_pregunta_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_calificacion_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_calificacion_empleado.setValue(calificacionempleado.getid_tipo_calificacion_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_calificacion_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_conocimiento=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_conocimiento.setValue(calificacionempleado.getvalor_conocimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_conocimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_eficiencia=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_eficiencia.setValue(calificacionempleado.getvalor_eficiencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_eficiencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_obtenido=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_obtenido.setValue(calificacionempleado.getvalor_obtenido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_obtenido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_peso=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_peso.setValue(calificacionempleado.getvalor_peso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_peso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueverificado=new ParameterValue<Boolean>();
					parameterMaintenanceValueverificado.setValue(calificacionempleado.getverificado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueverificado);
					parametersTemp.add(parameterMaintenance);
					
						if(!calificacionempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(calificacionempleado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(calificacionempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(calificacionempleado.getId());
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
	
	public void setIsNewIsChangedFalseCalificacionEmpleado(CalificacionEmpleado calificacionempleado)throws Exception  {		
		calificacionempleado.setIsNew(false);
		calificacionempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCalificacionEmpleados(List<CalificacionEmpleado> calificacionempleados)throws Exception  {				
		for(CalificacionEmpleado calificacionempleado:calificacionempleados) {
			calificacionempleado.setIsNew(false);
			calificacionempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarCalificacionEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
