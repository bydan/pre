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
package com.bydan.erp.seguridad.business.dataaccess;

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

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.*;//ResumenUsuarioConstantesFunciones;










@SuppressWarnings("unused")
final public class ResumenUsuarioDataAccess extends  ResumenUsuarioDataAccessAdditional{ //ResumenUsuarioDataAccessAdditional,DataAccessHelper<ResumenUsuario>
	//static Logger logger = Logger.getLogger(ResumenUsuarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="resumen_usuario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+"(version_row,id_usuario,numero_ingresos,numero_error_ingreso,numero_intentos,numero_cierres,numero_reinicios,numero_ingreso_actual,fecha_ultimo_ingreso,fecha_ultimo_error_ingreso,fecha_ultimo_intento,fecha_ultimo_cierre)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_usuario=?,numero_ingresos=?,numero_error_ingreso=?,numero_intentos=?,numero_cierres=?,numero_reinicios=?,numero_ingreso_actual=?,fecha_ultimo_ingreso=?,fecha_ultimo_error_ingreso=?,fecha_ultimo_intento=?,fecha_ultimo_cierre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select resumenusuario from "+ResumenUsuarioConstantesFunciones.SPERSISTENCENAME+" resumenusuario";
	public static String QUERYSELECTNATIVE="select "+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".id,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".version_row,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".id_usuario,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_ingresos,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_error_ingreso,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_intentos,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_cierres,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_reinicios,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".numero_ingreso_actual,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".fecha_ultimo_ingreso,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".fecha_ultimo_error_ingreso,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".fecha_ultimo_intento,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".fecha_ultimo_cierre from "+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME;//+" as "+ResumenUsuarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".id,"+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+".version_row from "+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME;//+" as "+ResumenUsuarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ResumenUsuarioConstantesFunciones.SCHEMA+"."+ResumenUsuarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_usuario=?,numero_ingresos=?,numero_error_ingreso=?,numero_intentos=?,numero_cierres=?,numero_reinicios=?,numero_ingreso_actual=?,fecha_ultimo_ingreso=?,fecha_ultimo_error_ingreso=?,fecha_ultimo_intento=?,fecha_ultimo_cierre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RESUMENUSUARIO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RESUMENUSUARIO_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RESUMENUSUARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RESUMENUSUARIO_SELECT(?,?)";
	
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
	
	
	protected ResumenUsuarioDataAccessAdditional resumenusuarioDataAccessAdditional=null;
	
	public ResumenUsuarioDataAccessAdditional getResumenUsuarioDataAccessAdditional() {
		return this.resumenusuarioDataAccessAdditional;
	}
	
	public void setResumenUsuarioDataAccessAdditional(ResumenUsuarioDataAccessAdditional resumenusuarioDataAccessAdditional) {
		try {
			this.resumenusuarioDataAccessAdditional=resumenusuarioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ResumenUsuarioDataAccess() {
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
		ResumenUsuarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ResumenUsuarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ResumenUsuarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setResumenUsuarioOriginal(ResumenUsuario resumenusuario)throws Exception  {
		resumenusuario.setResumenUsuarioOriginal((ResumenUsuario)resumenusuario.clone());		
	}
	
	public void setResumenUsuariosOriginal(List<ResumenUsuario> resumenusuarios)throws Exception  {
		
		for(ResumenUsuario resumenusuario:resumenusuarios){
			resumenusuario.setResumenUsuarioOriginal((ResumenUsuario)resumenusuario.clone());
		}
	}
	
	public static void setResumenUsuarioOriginalStatic(ResumenUsuario resumenusuario)throws Exception  {
		resumenusuario.setResumenUsuarioOriginal((ResumenUsuario)resumenusuario.clone());		
	}
	
	public static void setResumenUsuariosOriginalStatic(List<ResumenUsuario> resumenusuarios)throws Exception  {
		
		for(ResumenUsuario resumenusuario:resumenusuarios){
			resumenusuario.setResumenUsuarioOriginal((ResumenUsuario)resumenusuario.clone());
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
	
	public  ResumenUsuario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ResumenUsuario entity = new ResumenUsuario();		
		
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
	
	public  ResumenUsuario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ResumenUsuario entity = new ResumenUsuario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.ResumenUsuario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setResumenUsuarioOriginal(new ResumenUsuario());
      	    	entity=super.getEntity("",entity,resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityResumenUsuario("",entity,resultSet); 
				
				//entity.setResumenUsuarioOriginal(super.getEntity("",entity.getResumenUsuarioOriginal(),resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResumenUsuarioOriginal(this.getEntityResumenUsuario("",entity.getResumenUsuarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseResumenUsuario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ResumenUsuario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ResumenUsuario entity = new ResumenUsuario();
				
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
	
	public  ResumenUsuario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ResumenUsuario entity = new ResumenUsuario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResumenUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.ResumenUsuario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setResumenUsuarioOriginal(new ResumenUsuario());
      	    	entity=super.getEntity("",entity,resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityResumenUsuario("",entity,resultSet);    
				
				//entity.setResumenUsuarioOriginal(super.getEntity("",entity.getResumenUsuarioOriginal(),resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResumenUsuarioOriginal(this.getEntityResumenUsuario("",entity.getResumenUsuarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseResumenUsuario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ResumenUsuario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ResumenUsuario entity = new ResumenUsuario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResumenUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.ResumenUsuario.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseResumenUsuario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ResumenUsuario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ResumenUsuario> entities = new  ArrayList<ResumenUsuario>();
		ResumenUsuario entity = new ResumenUsuario();		  
		
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
	
	public  List<ResumenUsuario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ResumenUsuario> entities = new  ArrayList<ResumenUsuario>();
		ResumenUsuario entity = new ResumenUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResumenUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResumenUsuario();
      	    	entity=super.getEntity("",entity,resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityResumenUsuario("",entity,resultSet);
      	    	
				//entity.setResumenUsuarioOriginal( new ResumenUsuario());
      	    	//entity.setResumenUsuarioOriginal(super.getEntity("",entity.getResumenUsuarioOriginal(),resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResumenUsuarioOriginal(this.getEntityResumenUsuario("",entity.getResumenUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseResumenUsuarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResumenUsuario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ResumenUsuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ResumenUsuario> entities = new  ArrayList<ResumenUsuario>();
		ResumenUsuario entity = new ResumenUsuario();		  
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
	
	public  List<ResumenUsuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ResumenUsuario> entities = new  ArrayList<ResumenUsuario>();
		ResumenUsuario entity = new ResumenUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResumenUsuario();
				
				if(conMapGenerico) {
					entity.inicializarMapResumenUsuario();
					//entity.setMapResumenUsuario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapResumenUsuarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapResumenUsuario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=ResumenUsuarioDataAccess.getEntityResumenUsuario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setResumenUsuarioOriginal( new ResumenUsuario());
					////entity.setResumenUsuarioOriginal(super.getEntity("",entity.getResumenUsuarioOriginal(),resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA));         		
					////entity.setResumenUsuarioOriginal(this.getEntityResumenUsuario("",entity.getResumenUsuarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseResumenUsuarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResumenUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ResumenUsuario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ResumenUsuario entity = new ResumenUsuario();		  
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
	
	public  ResumenUsuario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ResumenUsuario entity = new ResumenUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResumenUsuario();
				
				if(conMapGenerico) {
					entity.inicializarMapResumenUsuario();
					//entity.setMapResumenUsuario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapResumenUsuarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapResumenUsuario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=ResumenUsuarioDataAccess.getEntityResumenUsuario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setResumenUsuarioOriginal( new ResumenUsuario());
					////entity.setResumenUsuarioOriginal(super.getEntity("",entity.getResumenUsuarioOriginal(),resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA));         		
					////entity.setResumenUsuarioOriginal(this.getEntityResumenUsuario("",entity.getResumenUsuarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseResumenUsuario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResumenUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ResumenUsuario getEntityResumenUsuario(String strPrefijo,ResumenUsuario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ResumenUsuario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ResumenUsuario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ResumenUsuarioDataAccess.setFieldReflectionResumenUsuario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasResumenUsuario=ResumenUsuarioConstantesFunciones.getTodosTiposColumnasResumenUsuario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasResumenUsuario) {
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
							field = ResumenUsuario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ResumenUsuario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ResumenUsuarioDataAccess.setFieldReflectionResumenUsuario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionResumenUsuario(Field field,String strPrefijo,String sColumn,ResumenUsuario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ResumenUsuarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResumenUsuarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ResumenUsuarioConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResumenUsuarioConstantesFunciones.NUMEROINGRESOS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResumenUsuarioConstantesFunciones.NUMEROERRORINGRESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResumenUsuarioConstantesFunciones.NUMEROINTENTOS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResumenUsuarioConstantesFunciones.NUMEROCIERRES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResumenUsuarioConstantesFunciones.NUMEROREINICIOS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResumenUsuarioConstantesFunciones.NUMEROINGRESOACTUAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResumenUsuarioConstantesFunciones.FECHAULTIMOINGRESO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ResumenUsuarioConstantesFunciones.FECHAULTIMOERRORINGRESO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ResumenUsuarioConstantesFunciones.FECHAULTIMOINTENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ResumenUsuarioConstantesFunciones.FECHAULTIMOCIERRE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ResumenUsuario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ResumenUsuario> entities = new  ArrayList<ResumenUsuario>();
		ResumenUsuario entity = new ResumenUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResumenUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ResumenUsuario();
					entity=super.getEntity("",entity,resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityResumenUsuario("",entity,resultSet);
					
					//entity.setResumenUsuarioOriginal( new ResumenUsuario());
					//entity.setResumenUsuarioOriginal(super.getEntity("",entity.getResumenUsuarioOriginal(),resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA));         		
					//entity.setResumenUsuarioOriginal(this.getEntityResumenUsuario("",entity.getResumenUsuarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseResumenUsuarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResumenUsuario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ResumenUsuario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ResumenUsuario> entities = new  ArrayList<ResumenUsuario>();
		ResumenUsuario entity = new ResumenUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ResumenUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResumenUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ResumenUsuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResumenUsuario> entities = new  ArrayList<ResumenUsuario>();
		ResumenUsuario entity = new ResumenUsuario();		  
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
	
	public  List<ResumenUsuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResumenUsuario> entities = new  ArrayList<ResumenUsuario>();
		ResumenUsuario entity = new ResumenUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResumenUsuario();
      	    	entity=super.getEntity("",entity,resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityResumenUsuario("",entity,resultSet);
      	    	
				//entity.setResumenUsuarioOriginal( new ResumenUsuario());
      	    	//entity.setResumenUsuarioOriginal(super.getEntity("",entity.getResumenUsuarioOriginal(),resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResumenUsuarioOriginal(this.getEntityResumenUsuario("",entity.getResumenUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseResumenUsuarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResumenUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ResumenUsuario> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResumenUsuario> entities = new  ArrayList<ResumenUsuario>();
		ResumenUsuario entity = new ResumenUsuario();		  
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
	
	public  List<ResumenUsuario> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResumenUsuario> entities = new  ArrayList<ResumenUsuario>();
		ResumenUsuario entity = new ResumenUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResumenUsuario();
      	    	entity=super.getEntity("",entity,resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityResumenUsuario("",entity,resultSet);
      	    	
				//entity.setResumenUsuarioOriginal( new ResumenUsuario());
      	    	//entity.setResumenUsuarioOriginal(super.getEntity("",entity.getResumenUsuarioOriginal(),resultSet,ResumenUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResumenUsuarioOriginal(this.getEntityResumenUsuario("",entity.getResumenUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseResumenUsuarios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ResumenUsuario getEntityResumenUsuario(String strPrefijo,ResumenUsuario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_usuario(resultSet.getLong(strPrefijo+ResumenUsuarioConstantesFunciones.IDUSUARIO));
				entity.setnumero_ingresos(resultSet.getLong(strPrefijo+ResumenUsuarioConstantesFunciones.NUMEROINGRESOS));
				entity.setnumero_error_ingreso(resultSet.getLong(strPrefijo+ResumenUsuarioConstantesFunciones.NUMEROERRORINGRESO));
				entity.setnumero_intentos(resultSet.getLong(strPrefijo+ResumenUsuarioConstantesFunciones.NUMEROINTENTOS));
				entity.setnumero_cierres(resultSet.getLong(strPrefijo+ResumenUsuarioConstantesFunciones.NUMEROCIERRES));
				entity.setnumero_reinicios(resultSet.getLong(strPrefijo+ResumenUsuarioConstantesFunciones.NUMEROREINICIOS));
				entity.setnumero_ingreso_actual(resultSet.getLong(strPrefijo+ResumenUsuarioConstantesFunciones.NUMEROINGRESOACTUAL));
				entity.setfecha_ultimo_ingreso(new Date(resultSet.getDate(strPrefijo+ResumenUsuarioConstantesFunciones.FECHAULTIMOINGRESO).getTime()));
				entity.setfecha_ultimo_error_ingreso(new Date(resultSet.getDate(strPrefijo+ResumenUsuarioConstantesFunciones.FECHAULTIMOERRORINGRESO).getTime()));
				entity.setfecha_ultimo_intento(new Date(resultSet.getDate(strPrefijo+ResumenUsuarioConstantesFunciones.FECHAULTIMOINTENTO).getTime()));
				entity.setfecha_ultimo_cierre(new Date(resultSet.getDate(strPrefijo+ResumenUsuarioConstantesFunciones.FECHAULTIMOCIERRE).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowResumenUsuario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ResumenUsuario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ResumenUsuarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ResumenUsuarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ResumenUsuarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ResumenUsuarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ResumenUsuarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ResumenUsuarioDataAccess.TABLENAME,ResumenUsuarioDataAccess.ISWITHSTOREPROCEDURES);
			
			ResumenUsuarioDataAccess.setResumenUsuarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Usuario getUsuario(Connexion connexion,ResumenUsuario relresumenusuario)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relresumenusuario.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ResumenUsuario resumenusuario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!resumenusuario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(resumenusuario.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_ingresos=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_ingresos.setValue(resumenusuario.getnumero_ingresos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_ingresos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_error_ingreso=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_error_ingreso.setValue(resumenusuario.getnumero_error_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_error_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_intentos=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_intentos.setValue(resumenusuario.getnumero_intentos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_intentos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_cierres=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_cierres.setValue(resumenusuario.getnumero_cierres());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cierres);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_reinicios=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_reinicios.setValue(resumenusuario.getnumero_reinicios());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_reinicios);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuenumero_ingreso_actual=new ParameterValue<Long>();
					parameterMaintenanceValuenumero_ingreso_actual.setValue(resumenusuario.getnumero_ingreso_actual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_ingreso_actual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultimo_ingreso=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultimo_ingreso.setValue(resumenusuario.getfecha_ultimo_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultimo_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultimo_error_ingreso=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultimo_error_ingreso.setValue(resumenusuario.getfecha_ultimo_error_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultimo_error_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultimo_intento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultimo_intento.setValue(resumenusuario.getfecha_ultimo_intento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultimo_intento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultimo_cierre=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultimo_cierre.setValue(resumenusuario.getfecha_ultimo_cierre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultimo_cierre);
					parametersTemp.add(parameterMaintenance);
					
						if(!resumenusuario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(resumenusuario.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(resumenusuario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(resumenusuario.getId());
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
	
	public void setIsNewIsChangedFalseResumenUsuario(ResumenUsuario resumenusuario)throws Exception  {		
		resumenusuario.setIsNew(false);
		resumenusuario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseResumenUsuarios(List<ResumenUsuario> resumenusuarios)throws Exception  {				
		for(ResumenUsuario resumenusuario:resumenusuarios) {
			resumenusuario.setIsNew(false);
			resumenusuario.setIsChanged(false);
		}
	}
	
	public void generarExportarResumenUsuario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
