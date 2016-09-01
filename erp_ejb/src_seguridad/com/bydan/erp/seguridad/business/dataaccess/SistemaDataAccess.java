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
import com.bydan.erp.seguridad.util.*;//SistemaConstantesFunciones;










@SuppressWarnings("unused")
final public class SistemaDataAccess extends  SistemaDataAccessAdditional{ //SistemaDataAccessAdditional,DataAccessHelper<Sistema>
	//static Logger logger = Logger.getLogger(SistemaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="sistema";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+"(version_row,codigo,nombre_principal,nombre_secundario,estado)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,nombre_principal=?,nombre_secundario=?,estado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select sistema from "+SistemaConstantesFunciones.SPERSISTENCENAME+" sistema";
	public static String QUERYSELECTNATIVE="select "+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".id,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".version_row,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".codigo,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".nombre_principal,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".nombre_secundario,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".estado from "+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME;//+" as "+SistemaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".id,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".version_row,"+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+".nombre_principal from "+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME;//+" as "+SistemaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+SistemaConstantesFunciones.SCHEMA+"."+SistemaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,nombre_principal=?,nombre_secundario=?,estado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SISTEMA_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SISTEMA_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SISTEMA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SISTEMA_SELECT(?,?)";
	
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
	
	
	protected SistemaDataAccessAdditional sistemaDataAccessAdditional=null;
	
	public SistemaDataAccessAdditional getSistemaDataAccessAdditional() {
		return this.sistemaDataAccessAdditional;
	}
	
	public void setSistemaDataAccessAdditional(SistemaDataAccessAdditional sistemaDataAccessAdditional) {
		try {
			this.sistemaDataAccessAdditional=sistemaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public SistemaDataAccess() {
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
		SistemaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		SistemaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		SistemaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setSistemaOriginal(Sistema sistema)throws Exception  {
		sistema.setSistemaOriginal((Sistema)sistema.clone());		
	}
	
	public void setSistemasOriginal(List<Sistema> sistemas)throws Exception  {
		
		for(Sistema sistema:sistemas){
			sistema.setSistemaOriginal((Sistema)sistema.clone());
		}
	}
	
	public static void setSistemaOriginalStatic(Sistema sistema)throws Exception  {
		sistema.setSistemaOriginal((Sistema)sistema.clone());		
	}
	
	public static void setSistemasOriginalStatic(List<Sistema> sistemas)throws Exception  {
		
		for(Sistema sistema:sistemas){
			sistema.setSistemaOriginal((Sistema)sistema.clone());
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
	
	public  Sistema getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Sistema entity = new Sistema();		
		
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
	
	public  Sistema getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Sistema entity = new Sistema();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.Sistema.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setSistemaOriginal(new Sistema());
      	    	entity=super.getEntity("",entity,resultSet,SistemaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySistema("",entity,resultSet); 
				
				entity.setSistemaOriginal(super.getEntity("",entity.getSistemaOriginal(),resultSet,SistemaDataAccess.ISWITHSCHEMA));         		
      	    	entity.setSistemaOriginal(this.getEntitySistema("",entity.getSistemaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseSistema(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Sistema getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Sistema entity = new Sistema();
				
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
	
	public  Sistema getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Sistema entity = new Sistema();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SistemaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Sistema.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setSistemaOriginal(new Sistema());
      	    	entity=super.getEntity("",entity,resultSet,SistemaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySistema("",entity,resultSet);    
				
				entity.setSistemaOriginal(super.getEntity("",entity.getSistemaOriginal(),resultSet,SistemaDataAccess.ISWITHSCHEMA));         		
      	    	entity.setSistemaOriginal(this.getEntitySistema("",entity.getSistemaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseSistema(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Sistema
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Sistema entity = new Sistema();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SistemaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Sistema.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseSistema(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Sistema> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Sistema> entities = new  ArrayList<Sistema>();
		Sistema entity = new Sistema();		  
		
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
	
	public  List<Sistema> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Sistema> entities = new  ArrayList<Sistema>();
		Sistema entity = new Sistema();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SistemaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Sistema();
      	    	entity=super.getEntity("",entity,resultSet,SistemaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySistema("",entity,resultSet);
      	    	
				entity.setSistemaOriginal( new Sistema());
      	    	entity.setSistemaOriginal(super.getEntity("",entity.getSistemaOriginal(),resultSet,SistemaDataAccess.ISWITHSCHEMA));         		
      	    	entity.setSistemaOriginal(this.getEntitySistema("",entity.getSistemaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSistemas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSistema(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Sistema> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Sistema> entities = new  ArrayList<Sistema>();
		Sistema entity = new Sistema();		  
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
	
	public  List<Sistema> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Sistema> entities = new  ArrayList<Sistema>();
		Sistema entity = new Sistema();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Sistema();
				
				if(conMapGenerico) {
					entity.inicializarMapSistema();
					//entity.setMapSistema(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapSistemaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSistema().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SistemaDataAccess.ISWITHSCHEMA);         		
					entity=SistemaDataAccess.getEntitySistema("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setSistemaOriginal( new Sistema());
					//entity.setSistemaOriginal(super.getEntity("",entity.getSistemaOriginal(),resultSet,SistemaDataAccess.ISWITHSCHEMA));         		
					//entity.setSistemaOriginal(this.getEntitySistema("",entity.getSistemaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSistemas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSistema(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Sistema getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Sistema entity = new Sistema();		  
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
	
	public  Sistema getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Sistema entity = new Sistema();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Sistema();
				
				if(conMapGenerico) {
					entity.inicializarMapSistema();
					//entity.setMapSistema(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapSistemaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSistema().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SistemaDataAccess.ISWITHSCHEMA);         		
					entity=SistemaDataAccess.getEntitySistema("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setSistemaOriginal( new Sistema());
					//entity.setSistemaOriginal(super.getEntity("",entity.getSistemaOriginal(),resultSet,SistemaDataAccess.ISWITHSCHEMA));         		
					//entity.setSistemaOriginal(this.getEntitySistema("",entity.getSistemaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseSistema(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSistema(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Sistema getEntitySistema(String strPrefijo,Sistema entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Sistema.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Sistema.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					SistemaDataAccess.setFieldReflectionSistema(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasSistema=SistemaConstantesFunciones.getTodosTiposColumnasSistema();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasSistema) {
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
							field = Sistema.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Sistema.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						SistemaDataAccess.setFieldReflectionSistema(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSistema(Field field,String strPrefijo,String sColumn,Sistema entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SistemaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SistemaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SistemaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SistemaConstantesFunciones.NOMBREPRINCIPAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SistemaConstantesFunciones.NOMBRESECUNDARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SistemaConstantesFunciones.ESTADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Sistema>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Sistema> entities = new  ArrayList<Sistema>();
		Sistema entity = new Sistema();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SistemaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Sistema();
					entity=super.getEntity("",entity,resultSet,SistemaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntitySistema("",entity,resultSet);
					
					entity.setSistemaOriginal( new Sistema());
					entity.setSistemaOriginal(super.getEntity("",entity.getSistemaOriginal(),resultSet,SistemaDataAccess.ISWITHSCHEMA));         		
					entity.setSistemaOriginal(this.getEntitySistema("",entity.getSistemaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseSistemas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSistema(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Sistema>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Sistema> entities = new  ArrayList<Sistema>();
		Sistema entity = new Sistema();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SistemaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SistemaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Sistema> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Sistema> entities = new  ArrayList<Sistema>();
		Sistema entity = new Sistema();		  
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
	
	public  List<Sistema> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Sistema> entities = new  ArrayList<Sistema>();
		Sistema entity = new Sistema();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Sistema();
      	    	entity=super.getEntity("",entity,resultSet,SistemaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySistema("",entity,resultSet);
      	    	
				entity.setSistemaOriginal( new Sistema());
      	    	entity.setSistemaOriginal(super.getEntity("",entity.getSistemaOriginal(),resultSet,SistemaDataAccess.ISWITHSCHEMA));         		
      	    	entity.setSistemaOriginal(this.getEntitySistema("",entity.getSistemaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseSistemas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSistema(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Sistema> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Sistema> entities = new  ArrayList<Sistema>();
		Sistema entity = new Sistema();		  
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
	
	public  List<Sistema> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Sistema> entities = new  ArrayList<Sistema>();
		Sistema entity = new Sistema();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Sistema();
      	    	entity=super.getEntity("",entity,resultSet,SistemaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySistema("",entity,resultSet);
      	    	
				entity.setSistemaOriginal( new Sistema());
      	    	entity.setSistemaOriginal(super.getEntity("",entity.getSistemaOriginal(),resultSet,SistemaDataAccess.ISWITHSCHEMA));         		
      	    	entity.setSistemaOriginal(this.getEntitySistema("",entity.getSistemaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSistemas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Sistema getEntitySistema(String strPrefijo,Sistema entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+SistemaConstantesFunciones.CODIGO));
				entity.setnombre_principal(resultSet.getString(strPrefijo+SistemaConstantesFunciones.NOMBREPRINCIPAL));
				entity.setnombre_secundario(resultSet.getString(strPrefijo+SistemaConstantesFunciones.NOMBRESECUNDARIO));
				entity.setestado(resultSet.getBoolean(strPrefijo+SistemaConstantesFunciones.ESTADO));
			} else {
				entity.setnombre_principal(resultSet.getString(strPrefijo+SistemaConstantesFunciones.NOMBREPRINCIPAL));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowSistema(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Sistema entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SistemaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SistemaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SistemaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SistemaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SistemaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SistemaDataAccess.TABLENAME,SistemaDataAccess.ISWITHSTOREPROCEDURES);
			
			SistemaDataAccess.setSistemaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<Perfil> getPerfils(Connexion connexion,Sistema sistema)throws SQLException,Exception {

		List<Perfil> perfils= new ArrayList<Perfil>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SistemaConstantesFunciones.SCHEMA+".sistema ON "+PerfilConstantesFunciones.SCHEMA+".perfil.id_sistema="+SistemaConstantesFunciones.SCHEMA+".sistema.id WHERE "+SistemaConstantesFunciones.SCHEMA+".sistema.id="+String.valueOf(sistema.getId());
			} else {
				sQuery=" INNER JOIN perfil.Sistema WHERE perfil.Sistema.id="+String.valueOf(sistema.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PerfilDataAccess perfilDataAccess=new PerfilDataAccess();

			perfilDataAccess.setConnexionType(this.connexionType);
			perfilDataAccess.setParameterDbType(this.parameterDbType);
			perfils=perfilDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfils;

	}

	public List<PerfilOpcion> getPerfilOpcions(Connexion connexion,Sistema sistema)throws SQLException,Exception {

		List<PerfilOpcion> perfilopcions= new ArrayList<PerfilOpcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SistemaConstantesFunciones.SCHEMA+".sistema ON "+PerfilOpcionConstantesFunciones.SCHEMA+".perfil_opcion.id_sistema="+SistemaConstantesFunciones.SCHEMA+".sistema.id WHERE "+SistemaConstantesFunciones.SCHEMA+".sistema.id="+String.valueOf(sistema.getId());
			} else {
				sQuery=" INNER JOIN perfilopcion.Sistema WHERE perfilopcion.Sistema.id="+String.valueOf(sistema.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PerfilOpcionDataAccess perfilopcionDataAccess=new PerfilOpcionDataAccess();

			perfilopcionDataAccess.setConnexionType(this.connexionType);
			perfilopcionDataAccess.setParameterDbType(this.parameterDbType);
			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfilopcions;

	}

	public List<UsuarioOpcion> getUsuarioOpcions(Connexion connexion,Sistema sistema)throws SQLException,Exception {

		List<UsuarioOpcion> usuarioopcions= new ArrayList<UsuarioOpcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SistemaConstantesFunciones.SCHEMA+".sistema ON "+UsuarioOpcionConstantesFunciones.SCHEMA+".usuario_opcion.id_sistema="+SistemaConstantesFunciones.SCHEMA+".sistema.id WHERE "+SistemaConstantesFunciones.SCHEMA+".sistema.id="+String.valueOf(sistema.getId());
			} else {
				sQuery=" INNER JOIN usuarioopcion.Sistema WHERE usuarioopcion.Sistema.id="+String.valueOf(sistema.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			UsuarioOpcionDataAccess usuarioopcionDataAccess=new UsuarioOpcionDataAccess();

			usuarioopcionDataAccess.setConnexionType(this.connexionType);
			usuarioopcionDataAccess.setParameterDbType(this.parameterDbType);
			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuarioopcions;

	}

	public List<Opcion> getOpcions(Connexion connexion,Sistema sistema)throws SQLException,Exception {

		List<Opcion> opcions= new ArrayList<Opcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SistemaConstantesFunciones.SCHEMA+".sistema ON "+OpcionConstantesFunciones.SCHEMA+".opcion.id_sistema="+SistemaConstantesFunciones.SCHEMA+".sistema.id WHERE "+SistemaConstantesFunciones.SCHEMA+".sistema.id="+String.valueOf(sistema.getId());
			} else {
				sQuery=" INNER JOIN opcion.Sistema WHERE opcion.Sistema.id="+String.valueOf(sistema.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OpcionDataAccess opcionDataAccess=new OpcionDataAccess();

			opcionDataAccess.setConnexionType(this.connexionType);
			opcionDataAccess.setParameterDbType(this.parameterDbType);
			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return opcions;

	}

	public List<Paquete> getPaquetes(Connexion connexion,Sistema sistema)throws SQLException,Exception {

		List<Paquete> paquetes= new ArrayList<Paquete>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SistemaConstantesFunciones.SCHEMA+".sistema ON "+PaqueteConstantesFunciones.SCHEMA+".paquete.id_sistema="+SistemaConstantesFunciones.SCHEMA+".sistema.id WHERE "+SistemaConstantesFunciones.SCHEMA+".sistema.id="+String.valueOf(sistema.getId());
			} else {
				sQuery=" INNER JOIN paquete.Sistema WHERE paquete.Sistema.id="+String.valueOf(sistema.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PaqueteDataAccess paqueteDataAccess=new PaqueteDataAccess();

			paqueteDataAccess.setConnexionType(this.connexionType);
			paqueteDataAccess.setParameterDbType(this.parameterDbType);
			paquetes=paqueteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return paquetes;

	}

	public List<Modulo> getModulos(Connexion connexion,Sistema sistema)throws SQLException,Exception {

		List<Modulo> modulos= new ArrayList<Modulo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SistemaConstantesFunciones.SCHEMA+".sistema ON "+ModuloConstantesFunciones.SCHEMA+".modulo.id_sistema="+SistemaConstantesFunciones.SCHEMA+".sistema.id WHERE "+SistemaConstantesFunciones.SCHEMA+".sistema.id="+String.valueOf(sistema.getId());
			} else {
				sQuery=" INNER JOIN modulo.Sistema WHERE modulo.Sistema.id="+String.valueOf(sistema.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);
			modulos=moduloDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Sistema sistema) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!sistema.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(sistema.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_principal=new ParameterValue<String>();
					parameterMaintenanceValuenombre_principal.setValue(sistema.getnombre_principal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_principal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_secundario=new ParameterValue<String>();
					parameterMaintenanceValuenombre_secundario.setValue(sistema.getnombre_secundario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_secundario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueestado=new ParameterValue<Boolean>();
					parameterMaintenanceValueestado.setValue(sistema.getestado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestado);
					parametersTemp.add(parameterMaintenance);
					
						if(!sistema.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(sistema.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(sistema.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(sistema.getId());
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
	
	public void setIsNewIsChangedFalseSistema(Sistema sistema)throws Exception  {		
		sistema.setIsNew(false);
		sistema.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseSistemas(List<Sistema> sistemas)throws Exception  {				
		for(Sistema sistema:sistemas) {
			sistema.setIsNew(false);
			sistema.setIsChanged(false);
		}
	}
	
	public void generarExportarSistema(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
