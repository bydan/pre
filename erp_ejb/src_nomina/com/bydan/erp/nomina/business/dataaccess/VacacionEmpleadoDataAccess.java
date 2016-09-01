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
import com.bydan.erp.nomina.util.*;//VacacionEmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class VacacionEmpleadoDataAccess extends  VacacionEmpleadoDataAccessAdditional{ //VacacionEmpleadoDataAccessAdditional,DataAccessHelper<VacacionEmpleado>
	//static Logger logger = Logger.getLogger(VacacionEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="vacacion_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_anio_periodo1,id_anio_periodo2,numero_veces,fecha_estimada,horas_vacaciones,horas_tomados,horas_pagados,horas_adicionales)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_anio_periodo1=?,id_anio_periodo2=?,numero_veces=?,fecha_estimada=?,horas_vacaciones=?,horas_tomados=?,horas_pagados=?,horas_adicionales=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select vacacionempleado from "+VacacionEmpleadoConstantesFunciones.SPERSISTENCENAME+" vacacionempleado";
	public static String QUERYSELECTNATIVE="select "+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".id,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".id_anio_periodo1,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".id_anio_periodo2,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".numero_veces,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".fecha_estimada,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".horas_vacaciones,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".horas_tomados,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".horas_pagados,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".horas_adicionales from "+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+VacacionEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".id,"+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+".version_row from "+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+VacacionEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+VacacionEmpleadoConstantesFunciones.SCHEMA+"."+VacacionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_anio_periodo1=?,id_anio_periodo2=?,numero_veces=?,fecha_estimada=?,horas_vacaciones=?,horas_tomados=?,horas_pagados=?,horas_adicionales=?";
	
	public static String STOREPROCEDUREINSERT="call SP_VACACIONEMPLEADO_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_VACACIONEMPLEADO_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_VACACIONEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_VACACIONEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected VacacionEmpleadoDataAccessAdditional vacacionempleadoDataAccessAdditional=null;
	
	public VacacionEmpleadoDataAccessAdditional getVacacionEmpleadoDataAccessAdditional() {
		return this.vacacionempleadoDataAccessAdditional;
	}
	
	public void setVacacionEmpleadoDataAccessAdditional(VacacionEmpleadoDataAccessAdditional vacacionempleadoDataAccessAdditional) {
		try {
			this.vacacionempleadoDataAccessAdditional=vacacionempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public VacacionEmpleadoDataAccess() {
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
		VacacionEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		VacacionEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		VacacionEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setVacacionEmpleadoOriginal(VacacionEmpleado vacacionempleado)throws Exception  {
		vacacionempleado.setVacacionEmpleadoOriginal((VacacionEmpleado)vacacionempleado.clone());		
	}
	
	public void setVacacionEmpleadosOriginal(List<VacacionEmpleado> vacacionempleados)throws Exception  {
		
		for(VacacionEmpleado vacacionempleado:vacacionempleados){
			vacacionempleado.setVacacionEmpleadoOriginal((VacacionEmpleado)vacacionempleado.clone());
		}
	}
	
	public static void setVacacionEmpleadoOriginalStatic(VacacionEmpleado vacacionempleado)throws Exception  {
		vacacionempleado.setVacacionEmpleadoOriginal((VacacionEmpleado)vacacionempleado.clone());		
	}
	
	public static void setVacacionEmpleadosOriginalStatic(List<VacacionEmpleado> vacacionempleados)throws Exception  {
		
		for(VacacionEmpleado vacacionempleado:vacacionempleados){
			vacacionempleado.setVacacionEmpleadoOriginal((VacacionEmpleado)vacacionempleado.clone());
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
	
	public  VacacionEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		VacacionEmpleado entity = new VacacionEmpleado();		
		
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
	
	public  VacacionEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		VacacionEmpleado entity = new VacacionEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.VacacionEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setVacacionEmpleadoOriginal(new VacacionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVacacionEmpleado("",entity,resultSet); 
				
				//entity.setVacacionEmpleadoOriginal(super.getEntity("",entity.getVacacionEmpleadoOriginal(),resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVacacionEmpleadoOriginal(this.getEntityVacacionEmpleado("",entity.getVacacionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseVacacionEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  VacacionEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		VacacionEmpleado entity = new VacacionEmpleado();
				
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
	
	public  VacacionEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		VacacionEmpleado entity = new VacacionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VacacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.VacacionEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setVacacionEmpleadoOriginal(new VacacionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVacacionEmpleado("",entity,resultSet);    
				
				//entity.setVacacionEmpleadoOriginal(super.getEntity("",entity.getVacacionEmpleadoOriginal(),resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVacacionEmpleadoOriginal(this.getEntityVacacionEmpleado("",entity.getVacacionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseVacacionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //VacacionEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		VacacionEmpleado entity = new VacacionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VacacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.VacacionEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseVacacionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<VacacionEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<VacacionEmpleado> entities = new  ArrayList<VacacionEmpleado>();
		VacacionEmpleado entity = new VacacionEmpleado();		  
		
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
	
	public  List<VacacionEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<VacacionEmpleado> entities = new  ArrayList<VacacionEmpleado>();
		VacacionEmpleado entity = new VacacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VacacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VacacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVacacionEmpleado("",entity,resultSet);
      	    	
				//entity.setVacacionEmpleadoOriginal( new VacacionEmpleado());
      	    	//entity.setVacacionEmpleadoOriginal(super.getEntity("",entity.getVacacionEmpleadoOriginal(),resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVacacionEmpleadoOriginal(this.getEntityVacacionEmpleado("",entity.getVacacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVacacionEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVacacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<VacacionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<VacacionEmpleado> entities = new  ArrayList<VacacionEmpleado>();
		VacacionEmpleado entity = new VacacionEmpleado();		  
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
	
	public  List<VacacionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<VacacionEmpleado> entities = new  ArrayList<VacacionEmpleado>();
		VacacionEmpleado entity = new VacacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VacacionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapVacacionEmpleado();
					//entity.setMapVacacionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapVacacionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVacacionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=VacacionEmpleadoDataAccess.getEntityVacacionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVacacionEmpleadoOriginal( new VacacionEmpleado());
					////entity.setVacacionEmpleadoOriginal(super.getEntity("",entity.getVacacionEmpleadoOriginal(),resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setVacacionEmpleadoOriginal(this.getEntityVacacionEmpleado("",entity.getVacacionEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVacacionEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVacacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public VacacionEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		VacacionEmpleado entity = new VacacionEmpleado();		  
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
	
	public  VacacionEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		VacacionEmpleado entity = new VacacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VacacionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapVacacionEmpleado();
					//entity.setMapVacacionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapVacacionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVacacionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=VacacionEmpleadoDataAccess.getEntityVacacionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVacacionEmpleadoOriginal( new VacacionEmpleado());
					////entity.setVacacionEmpleadoOriginal(super.getEntity("",entity.getVacacionEmpleadoOriginal(),resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setVacacionEmpleadoOriginal(this.getEntityVacacionEmpleado("",entity.getVacacionEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseVacacionEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVacacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static VacacionEmpleado getEntityVacacionEmpleado(String strPrefijo,VacacionEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = VacacionEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = VacacionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					VacacionEmpleadoDataAccess.setFieldReflectionVacacionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasVacacionEmpleado=VacacionEmpleadoConstantesFunciones.getTodosTiposColumnasVacacionEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasVacacionEmpleado) {
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
							field = VacacionEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = VacacionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						VacacionEmpleadoDataAccess.setFieldReflectionVacacionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionVacacionEmpleado(Field field,String strPrefijo,String sColumn,VacacionEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case VacacionEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VacacionEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VacacionEmpleadoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VacacionEmpleadoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VacacionEmpleadoConstantesFunciones.NUMEROVECES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case VacacionEmpleadoConstantesFunciones.FECHAESTIMADA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case VacacionEmpleadoConstantesFunciones.HORASVACACIONES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VacacionEmpleadoConstantesFunciones.HORASTOMADOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VacacionEmpleadoConstantesFunciones.HORASPAGADOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VacacionEmpleadoConstantesFunciones.HORASADICIONALES:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<VacacionEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<VacacionEmpleado> entities = new  ArrayList<VacacionEmpleado>();
		VacacionEmpleado entity = new VacacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VacacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new VacacionEmpleado();
					entity=super.getEntity("",entity,resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityVacacionEmpleado("",entity,resultSet);
					
					//entity.setVacacionEmpleadoOriginal( new VacacionEmpleado());
					//entity.setVacacionEmpleadoOriginal(super.getEntity("",entity.getVacacionEmpleadoOriginal(),resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setVacacionEmpleadoOriginal(this.getEntityVacacionEmpleado("",entity.getVacacionEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseVacacionEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVacacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<VacacionEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<VacacionEmpleado> entities = new  ArrayList<VacacionEmpleado>();
		VacacionEmpleado entity = new VacacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VacacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VacacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<VacacionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VacacionEmpleado> entities = new  ArrayList<VacacionEmpleado>();
		VacacionEmpleado entity = new VacacionEmpleado();		  
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
	
	public  List<VacacionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VacacionEmpleado> entities = new  ArrayList<VacacionEmpleado>();
		VacacionEmpleado entity = new VacacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VacacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVacacionEmpleado("",entity,resultSet);
      	    	
				//entity.setVacacionEmpleadoOriginal( new VacacionEmpleado());
      	    	//entity.setVacacionEmpleadoOriginal(super.getEntity("",entity.getVacacionEmpleadoOriginal(),resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVacacionEmpleadoOriginal(this.getEntityVacacionEmpleado("",entity.getVacacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseVacacionEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVacacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<VacacionEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VacacionEmpleado> entities = new  ArrayList<VacacionEmpleado>();
		VacacionEmpleado entity = new VacacionEmpleado();		  
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
	
	public  List<VacacionEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VacacionEmpleado> entities = new  ArrayList<VacacionEmpleado>();
		VacacionEmpleado entity = new VacacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VacacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVacacionEmpleado("",entity,resultSet);
      	    	
				//entity.setVacacionEmpleadoOriginal( new VacacionEmpleado());
      	    	//entity.setVacacionEmpleadoOriginal(super.getEntity("",entity.getVacacionEmpleadoOriginal(),resultSet,VacacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVacacionEmpleadoOriginal(this.getEntityVacacionEmpleado("",entity.getVacacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVacacionEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public VacacionEmpleado getEntityVacacionEmpleado(String strPrefijo,VacacionEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+VacacionEmpleadoConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+VacacionEmpleadoConstantesFunciones.IDEMPLEADO));
				entity.setid_anio_periodo1(resultSet.getLong(strPrefijo+VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1));
				entity.setid_anio_periodo2(resultSet.getLong(strPrefijo+VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2));
				entity.setnumero_veces(resultSet.getInt(strPrefijo+VacacionEmpleadoConstantesFunciones.NUMEROVECES));
				entity.setfecha_estimada(new Date(resultSet.getDate(strPrefijo+VacacionEmpleadoConstantesFunciones.FECHAESTIMADA).getTime()));
				entity.sethoras_vacaciones(resultSet.getDouble(strPrefijo+VacacionEmpleadoConstantesFunciones.HORASVACACIONES));
				entity.sethoras_tomados(resultSet.getDouble(strPrefijo+VacacionEmpleadoConstantesFunciones.HORASTOMADOS));
				entity.sethoras_pagados(resultSet.getDouble(strPrefijo+VacacionEmpleadoConstantesFunciones.HORASPAGADOS));
				entity.sethoras_adicionales(resultSet.getDouble(strPrefijo+VacacionEmpleadoConstantesFunciones.HORASADICIONALES));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowVacacionEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(VacacionEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=VacacionEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=VacacionEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=VacacionEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=VacacionEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(VacacionEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,VacacionEmpleadoDataAccess.TABLENAME,VacacionEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			VacacionEmpleadoDataAccess.setVacacionEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,VacacionEmpleado relvacacionempleado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relvacacionempleado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,VacacionEmpleado relvacacionempleado)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relvacacionempleado.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Anio getAnioPeriodo1(Connexion connexion,VacacionEmpleado relvacacionempleado)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relvacacionempleado.getid_anio_periodo1());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Anio getAnioPeriodo2(Connexion connexion,VacacionEmpleado relvacacionempleado)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relvacacionempleado.getid_anio_periodo2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,VacacionEmpleado vacacionempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!vacacionempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(vacacionempleado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(vacacionempleado.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio_periodo1=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio_periodo1.setValue(vacacionempleado.getid_anio_periodo1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio_periodo1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio_periodo2=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio_periodo2.setValue(vacacionempleado.getid_anio_periodo2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio_periodo2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_veces=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_veces.setValue(vacacionempleado.getnumero_veces());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_veces);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_estimada=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_estimada.setValue(vacacionempleado.getfecha_estimada());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_estimada);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_vacaciones=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_vacaciones.setValue(vacacionempleado.gethoras_vacaciones());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_vacaciones);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_tomados=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_tomados.setValue(vacacionempleado.gethoras_tomados());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_tomados);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_pagados=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_pagados.setValue(vacacionempleado.gethoras_pagados());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_pagados);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_adicionales=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_adicionales.setValue(vacacionempleado.gethoras_adicionales());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_adicionales);
					parametersTemp.add(parameterMaintenance);
					
						if(!vacacionempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(vacacionempleado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(vacacionempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(vacacionempleado.getId());
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
	
	public void setIsNewIsChangedFalseVacacionEmpleado(VacacionEmpleado vacacionempleado)throws Exception  {		
		vacacionempleado.setIsNew(false);
		vacacionempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseVacacionEmpleados(List<VacacionEmpleado> vacacionempleados)throws Exception  {				
		for(VacacionEmpleado vacacionempleado:vacacionempleados) {
			vacacionempleado.setIsNew(false);
			vacacionempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarVacacionEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
