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
import com.bydan.erp.nomina.util.*;//AsistenciaDiariaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class AsistenciaDiariaDataAccess extends  AsistenciaDiariaDataAccessAdditional{ //AsistenciaDiariaDataAccessAdditional,DataAccessHelper<AsistenciaDiaria>
	//static Logger logger = Logger.getLogger(AsistenciaDiariaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="asistencia_diaria";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_estructura,id_estructura_seccion,fecha,hora,horas_atraso,horas_falta,horas_permiso,horas_extra25,horas_extra50,horas_extra100,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_estructura=?,id_estructura_seccion=?,fecha=?,hora=?,horas_atraso=?,horas_falta=?,horas_permiso=?,horas_extra25=?,horas_extra50=?,horas_extra100=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select asistenciadiaria from "+AsistenciaDiariaConstantesFunciones.SPERSISTENCENAME+" asistenciadiaria";
	public static String QUERYSELECTNATIVE="select "+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".id,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".version_row,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".id_empresa,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".id_empleado,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".id_estructura,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".id_estructura_seccion,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".fecha,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".hora,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_atraso,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_falta,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_permiso,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_extra25,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_extra50,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_extra100,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".descripcion from "+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME;//+" as "+AsistenciaDiariaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".id,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".version_row from "+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME;//+" as "+AsistenciaDiariaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_estructura=?,id_estructura_seccion=?,fecha=?,hora=?,horas_atraso=?,horas_falta=?,horas_permiso=?,horas_extra25=?,horas_extra50=?,horas_extra100=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ASISTENCIADIARIA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ASISTENCIADIARIA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ASISTENCIADIARIA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ASISTENCIADIARIA_SELECT(?,?)";
	
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
	
	
	protected AsistenciaDiariaDataAccessAdditional asistenciadiariaDataAccessAdditional=null;
	
	public AsistenciaDiariaDataAccessAdditional getAsistenciaDiariaDataAccessAdditional() {
		return this.asistenciadiariaDataAccessAdditional;
	}
	
	public void setAsistenciaDiariaDataAccessAdditional(AsistenciaDiariaDataAccessAdditional asistenciadiariaDataAccessAdditional) {
		try {
			this.asistenciadiariaDataAccessAdditional=asistenciadiariaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AsistenciaDiariaDataAccess() {
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
		AsistenciaDiariaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AsistenciaDiariaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AsistenciaDiariaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAsistenciaDiariaOriginal(AsistenciaDiaria asistenciadiaria)throws Exception  {
		asistenciadiaria.setAsistenciaDiariaOriginal((AsistenciaDiaria)asistenciadiaria.clone());		
	}
	
	public void setAsistenciaDiariasOriginal(List<AsistenciaDiaria> asistenciadiarias)throws Exception  {
		
		for(AsistenciaDiaria asistenciadiaria:asistenciadiarias){
			asistenciadiaria.setAsistenciaDiariaOriginal((AsistenciaDiaria)asistenciadiaria.clone());
		}
	}
	
	public static void setAsistenciaDiariaOriginalStatic(AsistenciaDiaria asistenciadiaria)throws Exception  {
		asistenciadiaria.setAsistenciaDiariaOriginal((AsistenciaDiaria)asistenciadiaria.clone());		
	}
	
	public static void setAsistenciaDiariasOriginalStatic(List<AsistenciaDiaria> asistenciadiarias)throws Exception  {
		
		for(AsistenciaDiaria asistenciadiaria:asistenciadiarias){
			asistenciadiaria.setAsistenciaDiariaOriginal((AsistenciaDiaria)asistenciadiaria.clone());
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
	
	public  AsistenciaDiaria getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AsistenciaDiaria entity = new AsistenciaDiaria();		
		
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
	
	public  AsistenciaDiaria getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AsistenciaDiaria entity = new AsistenciaDiaria();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.AsistenciaDiaria.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAsistenciaDiariaOriginal(new AsistenciaDiaria());
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAsistenciaDiaria("",entity,resultSet); 
				
				//entity.setAsistenciaDiariaOriginal(super.getEntity("",entity.getAsistenciaDiariaOriginal(),resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaDiariaOriginal(this.getEntityAsistenciaDiaria("",entity.getAsistenciaDiariaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAsistenciaDiaria(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AsistenciaDiaria getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AsistenciaDiaria entity = new AsistenciaDiaria();
				
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
	
	public  AsistenciaDiaria getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AsistenciaDiaria entity = new AsistenciaDiaria();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaDiariaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.AsistenciaDiaria.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAsistenciaDiariaOriginal(new AsistenciaDiaria());
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAsistenciaDiaria("",entity,resultSet);    
				
				//entity.setAsistenciaDiariaOriginal(super.getEntity("",entity.getAsistenciaDiariaOriginal(),resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaDiariaOriginal(this.getEntityAsistenciaDiaria("",entity.getAsistenciaDiariaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAsistenciaDiaria(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AsistenciaDiaria
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AsistenciaDiaria entity = new AsistenciaDiaria();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaDiariaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.AsistenciaDiaria.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAsistenciaDiaria(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AsistenciaDiaria> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AsistenciaDiaria> entities = new  ArrayList<AsistenciaDiaria>();
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
		
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
	
	public  List<AsistenciaDiaria> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AsistenciaDiaria> entities = new  ArrayList<AsistenciaDiaria>();
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaDiariaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaDiaria();
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsistenciaDiaria("",entity,resultSet);
      	    	
				//entity.setAsistenciaDiariaOriginal( new AsistenciaDiaria());
      	    	//entity.setAsistenciaDiariaOriginal(super.getEntity("",entity.getAsistenciaDiariaOriginal(),resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaDiariaOriginal(this.getEntityAsistenciaDiaria("",entity.getAsistenciaDiariaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsistenciaDiarias(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaDiaria(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AsistenciaDiaria> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AsistenciaDiaria> entities = new  ArrayList<AsistenciaDiaria>();
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
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
	
	public  List<AsistenciaDiaria> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AsistenciaDiaria> entities = new  ArrayList<AsistenciaDiaria>();
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaDiaria();
				
				if(conMapGenerico) {
					entity.inicializarMapAsistenciaDiaria();
					//entity.setMapAsistenciaDiaria(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAsistenciaDiariaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAsistenciaDiaria().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA);         		
					entity=AsistenciaDiariaDataAccess.getEntityAsistenciaDiaria("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAsistenciaDiariaOriginal( new AsistenciaDiaria());
					////entity.setAsistenciaDiariaOriginal(super.getEntity("",entity.getAsistenciaDiariaOriginal(),resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA));         		
					////entity.setAsistenciaDiariaOriginal(this.getEntityAsistenciaDiaria("",entity.getAsistenciaDiariaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsistenciaDiarias(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaDiaria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AsistenciaDiaria getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
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
	
	public  AsistenciaDiaria getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaDiaria();
				
				if(conMapGenerico) {
					entity.inicializarMapAsistenciaDiaria();
					//entity.setMapAsistenciaDiaria(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAsistenciaDiariaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAsistenciaDiaria().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA);         		
					entity=AsistenciaDiariaDataAccess.getEntityAsistenciaDiaria("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAsistenciaDiariaOriginal( new AsistenciaDiaria());
					////entity.setAsistenciaDiariaOriginal(super.getEntity("",entity.getAsistenciaDiariaOriginal(),resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA));         		
					////entity.setAsistenciaDiariaOriginal(this.getEntityAsistenciaDiaria("",entity.getAsistenciaDiariaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAsistenciaDiaria(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaDiaria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AsistenciaDiaria getEntityAsistenciaDiaria(String strPrefijo,AsistenciaDiaria entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AsistenciaDiaria.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AsistenciaDiaria.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AsistenciaDiariaDataAccess.setFieldReflectionAsistenciaDiaria(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAsistenciaDiaria=AsistenciaDiariaConstantesFunciones.getTodosTiposColumnasAsistenciaDiaria();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAsistenciaDiaria) {
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
							field = AsistenciaDiaria.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AsistenciaDiaria.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AsistenciaDiariaDataAccess.setFieldReflectionAsistenciaDiaria(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAsistenciaDiaria(Field field,String strPrefijo,String sColumn,AsistenciaDiaria entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AsistenciaDiariaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AsistenciaDiariaConstantesFunciones.HORA:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.HORASATRASO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.HORASFALTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.HORASPERMISO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.HORASEXTRA25:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.HORASEXTRA50:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.HORASEXTRA100:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaDiariaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AsistenciaDiaria>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AsistenciaDiaria> entities = new  ArrayList<AsistenciaDiaria>();
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaDiariaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AsistenciaDiaria();
					entity=super.getEntity("",entity,resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAsistenciaDiaria("",entity,resultSet);
					
					//entity.setAsistenciaDiariaOriginal( new AsistenciaDiaria());
					//entity.setAsistenciaDiariaOriginal(super.getEntity("",entity.getAsistenciaDiariaOriginal(),resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA));         		
					//entity.setAsistenciaDiariaOriginal(this.getEntityAsistenciaDiaria("",entity.getAsistenciaDiariaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAsistenciaDiarias(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaDiaria(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AsistenciaDiaria>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AsistenciaDiaria> entities = new  ArrayList<AsistenciaDiaria>();
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsistenciaDiariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaDiariaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AsistenciaDiaria> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaDiaria> entities = new  ArrayList<AsistenciaDiaria>();
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
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
	
	public  List<AsistenciaDiaria> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaDiaria> entities = new  ArrayList<AsistenciaDiaria>();
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaDiaria();
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsistenciaDiaria("",entity,resultSet);
      	    	
				//entity.setAsistenciaDiariaOriginal( new AsistenciaDiaria());
      	    	//entity.setAsistenciaDiariaOriginal(super.getEntity("",entity.getAsistenciaDiariaOriginal(),resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaDiariaOriginal(this.getEntityAsistenciaDiaria("",entity.getAsistenciaDiariaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAsistenciaDiarias(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaDiaria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AsistenciaDiaria> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaDiaria> entities = new  ArrayList<AsistenciaDiaria>();
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
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
	
	public  List<AsistenciaDiaria> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaDiaria> entities = new  ArrayList<AsistenciaDiaria>();
		AsistenciaDiaria entity = new AsistenciaDiaria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaDiaria();
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsistenciaDiaria("",entity,resultSet);
      	    	
				//entity.setAsistenciaDiariaOriginal( new AsistenciaDiaria());
      	    	//entity.setAsistenciaDiariaOriginal(super.getEntity("",entity.getAsistenciaDiariaOriginal(),resultSet,AsistenciaDiariaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaDiariaOriginal(this.getEntityAsistenciaDiaria("",entity.getAsistenciaDiariaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsistenciaDiarias(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AsistenciaDiaria getEntityAsistenciaDiaria(String strPrefijo,AsistenciaDiaria entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+AsistenciaDiariaConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+AsistenciaDiariaConstantesFunciones.IDEMPLEADO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+AsistenciaDiariaConstantesFunciones.IDESTRUCTURA));
				entity.setid_estructura_seccion(resultSet.getLong(strPrefijo+AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+AsistenciaDiariaConstantesFunciones.FECHA).getTime()));
				entity.sethora(resultSet.getTime(strPrefijo+AsistenciaDiariaConstantesFunciones.HORA));
				entity.sethoras_atraso(resultSet.getDouble(strPrefijo+AsistenciaDiariaConstantesFunciones.HORASATRASO));
				entity.sethoras_falta(resultSet.getDouble(strPrefijo+AsistenciaDiariaConstantesFunciones.HORASFALTA));
				entity.sethoras_permiso(resultSet.getDouble(strPrefijo+AsistenciaDiariaConstantesFunciones.HORASPERMISO));
				entity.sethoras_extra25(resultSet.getDouble(strPrefijo+AsistenciaDiariaConstantesFunciones.HORASEXTRA25));
				entity.sethoras_extra50(resultSet.getDouble(strPrefijo+AsistenciaDiariaConstantesFunciones.HORASEXTRA50));
				entity.sethoras_extra100(resultSet.getDouble(strPrefijo+AsistenciaDiariaConstantesFunciones.HORASEXTRA100));
				entity.setdescripcion(resultSet.getString(strPrefijo+AsistenciaDiariaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAsistenciaDiaria(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AsistenciaDiaria entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AsistenciaDiariaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AsistenciaDiariaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AsistenciaDiariaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AsistenciaDiariaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AsistenciaDiariaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AsistenciaDiariaDataAccess.TABLENAME,AsistenciaDiariaDataAccess.ISWITHSTOREPROCEDURES);
			
			AsistenciaDiariaDataAccess.setAsistenciaDiariaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,AsistenciaDiaria relasistenciadiaria)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relasistenciadiaria.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,AsistenciaDiaria relasistenciadiaria)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relasistenciadiaria.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Estructura getEstructura(Connexion connexion,AsistenciaDiaria relasistenciadiaria)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relasistenciadiaria.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Estructura getEstructuraSeccion(Connexion connexion,AsistenciaDiaria relasistenciadiaria)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relasistenciadiaria.getid_estructura_seccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AsistenciaDiaria asistenciadiaria) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!asistenciadiaria.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(asistenciadiaria.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(asistenciadiaria.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(asistenciadiaria.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura_seccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura_seccion.setValue(asistenciadiaria.getid_estructura_seccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura_seccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(asistenciadiaria.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora=new ParameterValue<Time>();
					parameterMaintenanceValuehora.setValue(asistenciadiaria.gethora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_atraso=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_atraso.setValue(asistenciadiaria.gethoras_atraso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_atraso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_falta=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_falta.setValue(asistenciadiaria.gethoras_falta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_falta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_permiso=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_permiso.setValue(asistenciadiaria.gethoras_permiso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_permiso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_extra25=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_extra25.setValue(asistenciadiaria.gethoras_extra25());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_extra25);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_extra50=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_extra50.setValue(asistenciadiaria.gethoras_extra50());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_extra50);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_extra100=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_extra100.setValue(asistenciadiaria.gethoras_extra100());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_extra100);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(asistenciadiaria.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!asistenciadiaria.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(asistenciadiaria.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(asistenciadiaria.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(asistenciadiaria.getId());
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
	
	public void setIsNewIsChangedFalseAsistenciaDiaria(AsistenciaDiaria asistenciadiaria)throws Exception  {		
		asistenciadiaria.setIsNew(false);
		asistenciadiaria.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAsistenciaDiarias(List<AsistenciaDiaria> asistenciadiarias)throws Exception  {				
		for(AsistenciaDiaria asistenciadiaria:asistenciadiarias) {
			asistenciadiaria.setIsNew(false);
			asistenciadiaria.setIsChanged(false);
		}
	}
	
	public void generarExportarAsistenciaDiaria(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
