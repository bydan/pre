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
import com.bydan.erp.nomina.util.*;//AsistenciaMensualConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class AsistenciaMensualDataAccess extends  AsistenciaMensualDataAccessAdditional{ //AsistenciaMensualDataAccessAdditional,DataAccessHelper<AsistenciaMensual>
	//static Logger logger = Logger.getLogger(AsistenciaMensualDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="asistencia_mensual";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_cargo,id_estructura,id_anio,id_mes,fecha,horas_trabajo,horas_atraso,horas_faltas,horas_permiso,horas_extra25,horas_extra50,horas_extra100,horas_extra150,horas_extra0,horas_enfermo,horas_maternidad,horas_vacacion,numero_dias,numero_noches,numero_feriados,numero_trabajo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_cargo=?,id_estructura=?,id_anio=?,id_mes=?,fecha=?,horas_trabajo=?,horas_atraso=?,horas_faltas=?,horas_permiso=?,horas_extra25=?,horas_extra50=?,horas_extra100=?,horas_extra150=?,horas_extra0=?,horas_enfermo=?,horas_maternidad=?,horas_vacacion=?,numero_dias=?,numero_noches=?,numero_feriados=?,numero_trabajo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select asistenciamensual from "+AsistenciaMensualConstantesFunciones.SPERSISTENCENAME+" asistenciamensual";
	public static String QUERYSELECTNATIVE="select "+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".version_row,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_empresa,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_empleado,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_cargo,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_estructura,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_anio,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id_mes,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".fecha,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_trabajo,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_atraso,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_faltas,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_permiso,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_extra25,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_extra50,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_extra100,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_extra150,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_extra0,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_enfermo,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_maternidad,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".horas_vacacion,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".numero_dias,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".numero_noches,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".numero_feriados,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".numero_trabajo from "+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME;//+" as "+AsistenciaMensualConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".id,"+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+".version_row from "+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME;//+" as "+AsistenciaMensualConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AsistenciaMensualConstantesFunciones.SCHEMA+"."+AsistenciaMensualConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_cargo=?,id_estructura=?,id_anio=?,id_mes=?,fecha=?,horas_trabajo=?,horas_atraso=?,horas_faltas=?,horas_permiso=?,horas_extra25=?,horas_extra50=?,horas_extra100=?,horas_extra150=?,horas_extra0=?,horas_enfermo=?,horas_maternidad=?,horas_vacacion=?,numero_dias=?,numero_noches=?,numero_feriados=?,numero_trabajo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ASISTENCIAMENSUAL_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ASISTENCIAMENSUAL_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ASISTENCIAMENSUAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ASISTENCIAMENSUAL_SELECT(?,?)";
	
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
	
	
	protected AsistenciaMensualDataAccessAdditional asistenciamensualDataAccessAdditional=null;
	
	public AsistenciaMensualDataAccessAdditional getAsistenciaMensualDataAccessAdditional() {
		return this.asistenciamensualDataAccessAdditional;
	}
	
	public void setAsistenciaMensualDataAccessAdditional(AsistenciaMensualDataAccessAdditional asistenciamensualDataAccessAdditional) {
		try {
			this.asistenciamensualDataAccessAdditional=asistenciamensualDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AsistenciaMensualDataAccess() {
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
		AsistenciaMensualDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AsistenciaMensualDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AsistenciaMensualDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAsistenciaMensualOriginal(AsistenciaMensual asistenciamensual)throws Exception  {
		asistenciamensual.setAsistenciaMensualOriginal((AsistenciaMensual)asistenciamensual.clone());		
	}
	
	public void setAsistenciaMensualsOriginal(List<AsistenciaMensual> asistenciamensuals)throws Exception  {
		
		for(AsistenciaMensual asistenciamensual:asistenciamensuals){
			asistenciamensual.setAsistenciaMensualOriginal((AsistenciaMensual)asistenciamensual.clone());
		}
	}
	
	public static void setAsistenciaMensualOriginalStatic(AsistenciaMensual asistenciamensual)throws Exception  {
		asistenciamensual.setAsistenciaMensualOriginal((AsistenciaMensual)asistenciamensual.clone());		
	}
	
	public static void setAsistenciaMensualsOriginalStatic(List<AsistenciaMensual> asistenciamensuals)throws Exception  {
		
		for(AsistenciaMensual asistenciamensual:asistenciamensuals){
			asistenciamensual.setAsistenciaMensualOriginal((AsistenciaMensual)asistenciamensual.clone());
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
	
	public  AsistenciaMensual getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AsistenciaMensual entity = new AsistenciaMensual();		
		
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
	
	public  AsistenciaMensual getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AsistenciaMensual entity = new AsistenciaMensual();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.AsistenciaMensual.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAsistenciaMensualOriginal(new AsistenciaMensual());
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAsistenciaMensual("",entity,resultSet); 
				
				//entity.setAsistenciaMensualOriginal(super.getEntity("",entity.getAsistenciaMensualOriginal(),resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaMensualOriginal(this.getEntityAsistenciaMensual("",entity.getAsistenciaMensualOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAsistenciaMensual(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AsistenciaMensual getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AsistenciaMensual entity = new AsistenciaMensual();
				
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
	
	public  AsistenciaMensual getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AsistenciaMensual entity = new AsistenciaMensual();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaMensualDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.AsistenciaMensual.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAsistenciaMensualOriginal(new AsistenciaMensual());
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAsistenciaMensual("",entity,resultSet);    
				
				//entity.setAsistenciaMensualOriginal(super.getEntity("",entity.getAsistenciaMensualOriginal(),resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaMensualOriginal(this.getEntityAsistenciaMensual("",entity.getAsistenciaMensualOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAsistenciaMensual(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AsistenciaMensual
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AsistenciaMensual entity = new AsistenciaMensual();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaMensualDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.AsistenciaMensual.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAsistenciaMensual(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AsistenciaMensual> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AsistenciaMensual> entities = new  ArrayList<AsistenciaMensual>();
		AsistenciaMensual entity = new AsistenciaMensual();		  
		
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
	
	public  List<AsistenciaMensual> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AsistenciaMensual> entities = new  ArrayList<AsistenciaMensual>();
		AsistenciaMensual entity = new AsistenciaMensual();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaMensualDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaMensual();
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsistenciaMensual("",entity,resultSet);
      	    	
				//entity.setAsistenciaMensualOriginal( new AsistenciaMensual());
      	    	//entity.setAsistenciaMensualOriginal(super.getEntity("",entity.getAsistenciaMensualOriginal(),resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaMensualOriginal(this.getEntityAsistenciaMensual("",entity.getAsistenciaMensualOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsistenciaMensuals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaMensual(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AsistenciaMensual> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AsistenciaMensual> entities = new  ArrayList<AsistenciaMensual>();
		AsistenciaMensual entity = new AsistenciaMensual();		  
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
	
	public  List<AsistenciaMensual> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AsistenciaMensual> entities = new  ArrayList<AsistenciaMensual>();
		AsistenciaMensual entity = new AsistenciaMensual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaMensual();
				
				if(conMapGenerico) {
					entity.inicializarMapAsistenciaMensual();
					//entity.setMapAsistenciaMensual(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAsistenciaMensualValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAsistenciaMensual().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA);         		
					entity=AsistenciaMensualDataAccess.getEntityAsistenciaMensual("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAsistenciaMensualOriginal( new AsistenciaMensual());
					////entity.setAsistenciaMensualOriginal(super.getEntity("",entity.getAsistenciaMensualOriginal(),resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA));         		
					////entity.setAsistenciaMensualOriginal(this.getEntityAsistenciaMensual("",entity.getAsistenciaMensualOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsistenciaMensuals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaMensual(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AsistenciaMensual getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AsistenciaMensual entity = new AsistenciaMensual();		  
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
	
	public  AsistenciaMensual getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AsistenciaMensual entity = new AsistenciaMensual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaMensual();
				
				if(conMapGenerico) {
					entity.inicializarMapAsistenciaMensual();
					//entity.setMapAsistenciaMensual(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAsistenciaMensualValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAsistenciaMensual().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA);         		
					entity=AsistenciaMensualDataAccess.getEntityAsistenciaMensual("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAsistenciaMensualOriginal( new AsistenciaMensual());
					////entity.setAsistenciaMensualOriginal(super.getEntity("",entity.getAsistenciaMensualOriginal(),resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA));         		
					////entity.setAsistenciaMensualOriginal(this.getEntityAsistenciaMensual("",entity.getAsistenciaMensualOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAsistenciaMensual(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaMensual(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AsistenciaMensual getEntityAsistenciaMensual(String strPrefijo,AsistenciaMensual entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AsistenciaMensual.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AsistenciaMensual.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AsistenciaMensualDataAccess.setFieldReflectionAsistenciaMensual(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAsistenciaMensual=AsistenciaMensualConstantesFunciones.getTodosTiposColumnasAsistenciaMensual();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAsistenciaMensual) {
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
							field = AsistenciaMensual.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AsistenciaMensual.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AsistenciaMensualDataAccess.setFieldReflectionAsistenciaMensual(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAsistenciaMensual(Field field,String strPrefijo,String sColumn,AsistenciaMensual entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AsistenciaMensualConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.IDCARGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASTRABAJO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASATRASO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASFALTAS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASPERMISO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASEXTRA25:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASEXTRA50:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASEXTRA100:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASEXTRA150:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASEXTRA0:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASENFERMO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASMATERNIDAD:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.HORASVACACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.NUMERODIAS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.NUMERONOCHES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.NUMEROFERIADOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaMensualConstantesFunciones.NUMEROTRABAJO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AsistenciaMensual>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AsistenciaMensual> entities = new  ArrayList<AsistenciaMensual>();
		AsistenciaMensual entity = new AsistenciaMensual();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaMensualDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AsistenciaMensual();
					entity=super.getEntity("",entity,resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAsistenciaMensual("",entity,resultSet);
					
					//entity.setAsistenciaMensualOriginal( new AsistenciaMensual());
					//entity.setAsistenciaMensualOriginal(super.getEntity("",entity.getAsistenciaMensualOriginal(),resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA));         		
					//entity.setAsistenciaMensualOriginal(this.getEntityAsistenciaMensual("",entity.getAsistenciaMensualOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAsistenciaMensuals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaMensual(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AsistenciaMensual>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AsistenciaMensual> entities = new  ArrayList<AsistenciaMensual>();
		AsistenciaMensual entity = new AsistenciaMensual();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsistenciaMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaMensualDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AsistenciaMensual> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaMensual> entities = new  ArrayList<AsistenciaMensual>();
		AsistenciaMensual entity = new AsistenciaMensual();		  
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
	
	public  List<AsistenciaMensual> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaMensual> entities = new  ArrayList<AsistenciaMensual>();
		AsistenciaMensual entity = new AsistenciaMensual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaMensual();
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsistenciaMensual("",entity,resultSet);
      	    	
				//entity.setAsistenciaMensualOriginal( new AsistenciaMensual());
      	    	//entity.setAsistenciaMensualOriginal(super.getEntity("",entity.getAsistenciaMensualOriginal(),resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaMensualOriginal(this.getEntityAsistenciaMensual("",entity.getAsistenciaMensualOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAsistenciaMensuals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaMensual(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AsistenciaMensual> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaMensual> entities = new  ArrayList<AsistenciaMensual>();
		AsistenciaMensual entity = new AsistenciaMensual();		  
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
	
	public  List<AsistenciaMensual> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaMensual> entities = new  ArrayList<AsistenciaMensual>();
		AsistenciaMensual entity = new AsistenciaMensual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaMensual();
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsistenciaMensual("",entity,resultSet);
      	    	
				//entity.setAsistenciaMensualOriginal( new AsistenciaMensual());
      	    	//entity.setAsistenciaMensualOriginal(super.getEntity("",entity.getAsistenciaMensualOriginal(),resultSet,AsistenciaMensualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaMensualOriginal(this.getEntityAsistenciaMensual("",entity.getAsistenciaMensualOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsistenciaMensuals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AsistenciaMensual getEntityAsistenciaMensual(String strPrefijo,AsistenciaMensual entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+AsistenciaMensualConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+AsistenciaMensualConstantesFunciones.IDEMPLEADO));
				entity.setid_cargo(resultSet.getLong(strPrefijo+AsistenciaMensualConstantesFunciones.IDCARGO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+AsistenciaMensualConstantesFunciones.IDESTRUCTURA));
				entity.setid_anio(resultSet.getLong(strPrefijo+AsistenciaMensualConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+AsistenciaMensualConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+AsistenciaMensualConstantesFunciones.FECHA).getTime()));
				entity.sethoras_trabajo(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASTRABAJO));
				entity.sethoras_atraso(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASATRASO));
				entity.sethoras_faltas(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASFALTAS));
				entity.sethoras_permiso(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASPERMISO));
				entity.sethoras_extra25(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASEXTRA25));
				entity.sethoras_extra50(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASEXTRA50));
				entity.sethoras_extra100(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASEXTRA100));
				entity.sethoras_extra150(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASEXTRA150));
				entity.sethoras_extra0(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASEXTRA0));
				entity.sethoras_enfermo(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASENFERMO));
				entity.sethoras_maternidad(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASMATERNIDAD));
				entity.sethoras_vacacion(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.HORASVACACION));
				entity.setnumero_dias(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.NUMERODIAS));
				entity.setnumero_noches(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.NUMERONOCHES));
				entity.setnumero_feriados(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.NUMEROFERIADOS));
				entity.setnumero_trabajo(resultSet.getDouble(strPrefijo+AsistenciaMensualConstantesFunciones.NUMEROTRABAJO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAsistenciaMensual(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AsistenciaMensual entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AsistenciaMensualDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AsistenciaMensualDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AsistenciaMensualDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AsistenciaMensualDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AsistenciaMensualConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AsistenciaMensualDataAccess.TABLENAME,AsistenciaMensualDataAccess.ISWITHSTOREPROCEDURES);
			
			AsistenciaMensualDataAccess.setAsistenciaMensualOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,AsistenciaMensual relasistenciamensual)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relasistenciamensual.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,AsistenciaMensual relasistenciamensual)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relasistenciamensual.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Cargo getCargo(Connexion connexion,AsistenciaMensual relasistenciamensual)throws SQLException,Exception {

		Cargo cargo= new Cargo();

		try {
			CargoDataAccess cargoDataAccess=new CargoDataAccess();

			cargoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cargoDataAccess.setConnexionType(this.connexionType);
			cargoDataAccess.setParameterDbType(this.parameterDbType);

			cargo=cargoDataAccess.getEntity(connexion,relasistenciamensual.getid_cargo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargo;

	}

	public Estructura getEstructura(Connexion connexion,AsistenciaMensual relasistenciamensual)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relasistenciamensual.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Anio getAnio(Connexion connexion,AsistenciaMensual relasistenciamensual)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relasistenciamensual.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,AsistenciaMensual relasistenciamensual)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relasistenciamensual.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AsistenciaMensual asistenciamensual) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!asistenciamensual.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(asistenciamensual.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(asistenciamensual.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cargo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cargo.setValue(asistenciamensual.getid_cargo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cargo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(asistenciamensual.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(asistenciamensual.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(asistenciamensual.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(asistenciamensual.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_trabajo=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_trabajo.setValue(asistenciamensual.gethoras_trabajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_trabajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_atraso=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_atraso.setValue(asistenciamensual.gethoras_atraso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_atraso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_faltas=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_faltas.setValue(asistenciamensual.gethoras_faltas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_faltas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_permiso=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_permiso.setValue(asistenciamensual.gethoras_permiso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_permiso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_extra25=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_extra25.setValue(asistenciamensual.gethoras_extra25());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_extra25);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_extra50=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_extra50.setValue(asistenciamensual.gethoras_extra50());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_extra50);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_extra100=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_extra100.setValue(asistenciamensual.gethoras_extra100());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_extra100);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_extra150=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_extra150.setValue(asistenciamensual.gethoras_extra150());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_extra150);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_extra0=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_extra0.setValue(asistenciamensual.gethoras_extra0());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_extra0);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_enfermo=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_enfermo.setValue(asistenciamensual.gethoras_enfermo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_enfermo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_maternidad=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_maternidad.setValue(asistenciamensual.gethoras_maternidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_maternidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehoras_vacacion=new ParameterValue<Double>();
					parameterMaintenanceValuehoras_vacacion.setValue(asistenciamensual.gethoras_vacacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehoras_vacacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuenumero_dias=new ParameterValue<Double>();
					parameterMaintenanceValuenumero_dias.setValue(asistenciamensual.getnumero_dias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuenumero_noches=new ParameterValue<Double>();
					parameterMaintenanceValuenumero_noches.setValue(asistenciamensual.getnumero_noches());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_noches);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuenumero_feriados=new ParameterValue<Double>();
					parameterMaintenanceValuenumero_feriados.setValue(asistenciamensual.getnumero_feriados());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_feriados);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuenumero_trabajo=new ParameterValue<Double>();
					parameterMaintenanceValuenumero_trabajo.setValue(asistenciamensual.getnumero_trabajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_trabajo);
					parametersTemp.add(parameterMaintenance);
					
						if(!asistenciamensual.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(asistenciamensual.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(asistenciamensual.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(asistenciamensual.getId());
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
	
	public void setIsNewIsChangedFalseAsistenciaMensual(AsistenciaMensual asistenciamensual)throws Exception  {		
		asistenciamensual.setIsNew(false);
		asistenciamensual.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAsistenciaMensuals(List<AsistenciaMensual> asistenciamensuals)throws Exception  {				
		for(AsistenciaMensual asistenciamensual:asistenciamensuals) {
			asistenciamensual.setIsNew(false);
			asistenciamensual.setIsChanged(false);
		}
	}
	
	public void generarExportarAsistenciaMensual(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
