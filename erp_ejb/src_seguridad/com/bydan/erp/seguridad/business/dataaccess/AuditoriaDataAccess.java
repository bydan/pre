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
import com.bydan.erp.seguridad.util.*;//AuditoriaConstantesFunciones;










@SuppressWarnings("unused")
final public class AuditoriaDataAccess extends  AuditoriaDataAccessAdditional{ //AuditoriaDataAccessAdditional,DataAccessHelper<Auditoria>
	//static Logger logger = Logger.getLogger(AuditoriaDataAccess.class);
	
	public static String SCHEMA="auditoria";	
	public static String TABLENAME="auditoria";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+"(version_row,id_usuario,nombre_tabla,id_fila,accion,proceso,nombre_p_c,ip_pc,usuario_p_c,fecha_hora,observacion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_usuario=?,nombre_tabla=?,id_fila=?,accion=?,proceso=?,nombre_p_c=?,ip_pc=?,usuario_p_c=?,fecha_hora=?,observacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select auditoria from "+AuditoriaConstantesFunciones.SPERSISTENCENAME+" auditoria";
	public static String QUERYSELECTNATIVE="select "+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".id,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".version_row,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".id_usuario,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".nombre_tabla,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".id_fila,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".accion,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".proceso,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".nombre_p_c,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".ip_pc,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".usuario_p_c,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".fecha_hora,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".observacion from "+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME;//+" as "+AuditoriaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".id,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".version_row from "+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME;//+" as "+AuditoriaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_usuario=?,nombre_tabla=?,id_fila=?,accion=?,proceso=?,nombre_p_c=?,ip_pc=?,usuario_p_c=?,fecha_hora=?,observacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_AUDITORIA_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_AUDITORIA_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_AUDITORIA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_AUDITORIA_SELECT(?,?)";
	
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
	
	
	protected AuditoriaDataAccessAdditional auditoriaDataAccessAdditional=null;
	
	public AuditoriaDataAccessAdditional getAuditoriaDataAccessAdditional() {
		return this.auditoriaDataAccessAdditional;
	}
	
	public void setAuditoriaDataAccessAdditional(AuditoriaDataAccessAdditional auditoriaDataAccessAdditional) {
		try {
			this.auditoriaDataAccessAdditional=auditoriaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AuditoriaDataAccess() {
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
		AuditoriaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AuditoriaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AuditoriaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAuditoriaOriginal(Auditoria auditoria)throws Exception  {
		auditoria.setAuditoriaOriginal((Auditoria)auditoria.clone());		
	}
	
	public void setAuditoriasOriginal(List<Auditoria> auditorias)throws Exception  {
		
		for(Auditoria auditoria:auditorias){
			auditoria.setAuditoriaOriginal((Auditoria)auditoria.clone());
		}
	}
	
	public static void setAuditoriaOriginalStatic(Auditoria auditoria)throws Exception  {
		auditoria.setAuditoriaOriginal((Auditoria)auditoria.clone());		
	}
	
	public static void setAuditoriasOriginalStatic(List<Auditoria> auditorias)throws Exception  {
		
		for(Auditoria auditoria:auditorias){
			auditoria.setAuditoriaOriginal((Auditoria)auditoria.clone());
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
	
	public  Auditoria getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Auditoria entity = new Auditoria();		
		
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
	
	public  Auditoria getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Auditoria entity = new Auditoria();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.Auditoria.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAuditoriaOriginal(new Auditoria());
      	    	entity=super.getEntity("",entity,resultSet,AuditoriaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAuditoria("",entity,resultSet); 
				
				entity.setAuditoriaOriginal(super.getEntity("",entity.getAuditoriaOriginal(),resultSet,AuditoriaDataAccess.ISWITHSCHEMA));         		
      	    	entity.setAuditoriaOriginal(this.getEntityAuditoria("",entity.getAuditoriaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAuditoria(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Auditoria getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Auditoria entity = new Auditoria();
				
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
	
	public  Auditoria getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Auditoria entity = new Auditoria();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AuditoriaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Auditoria.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAuditoriaOriginal(new Auditoria());
      	    	entity=super.getEntity("",entity,resultSet,AuditoriaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAuditoria("",entity,resultSet);    
				
				entity.setAuditoriaOriginal(super.getEntity("",entity.getAuditoriaOriginal(),resultSet,AuditoriaDataAccess.ISWITHSCHEMA));         		
      	    	entity.setAuditoriaOriginal(this.getEntityAuditoria("",entity.getAuditoriaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAuditoria(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Auditoria
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Auditoria entity = new Auditoria();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AuditoriaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Auditoria.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAuditoria(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Auditoria> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Auditoria> entities = new  ArrayList<Auditoria>();
		Auditoria entity = new Auditoria();		  
		
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
	
	public  List<Auditoria> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Auditoria> entities = new  ArrayList<Auditoria>();
		Auditoria entity = new Auditoria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AuditoriaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Auditoria();
      	    	entity=super.getEntity("",entity,resultSet,AuditoriaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAuditoria("",entity,resultSet);
      	    	
				entity.setAuditoriaOriginal( new Auditoria());
      	    	entity.setAuditoriaOriginal(super.getEntity("",entity.getAuditoriaOriginal(),resultSet,AuditoriaDataAccess.ISWITHSCHEMA));         		
      	    	entity.setAuditoriaOriginal(this.getEntityAuditoria("",entity.getAuditoriaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAuditorias(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAuditoria(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Auditoria> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Auditoria> entities = new  ArrayList<Auditoria>();
		Auditoria entity = new Auditoria();		  
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
	
	public  List<Auditoria> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Auditoria> entities = new  ArrayList<Auditoria>();
		Auditoria entity = new Auditoria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Auditoria();
				
				if(conMapGenerico) {
					entity.inicializarMapAuditoria();
					//entity.setMapAuditoria(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAuditoriaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAuditoria().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AuditoriaDataAccess.ISWITHSCHEMA);         		
					entity=AuditoriaDataAccess.getEntityAuditoria("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setAuditoriaOriginal( new Auditoria());
					//entity.setAuditoriaOriginal(super.getEntity("",entity.getAuditoriaOriginal(),resultSet,AuditoriaDataAccess.ISWITHSCHEMA));         		
					//entity.setAuditoriaOriginal(this.getEntityAuditoria("",entity.getAuditoriaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAuditorias(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAuditoria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Auditoria getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Auditoria entity = new Auditoria();		  
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
	
	public  Auditoria getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Auditoria entity = new Auditoria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Auditoria();
				
				if(conMapGenerico) {
					entity.inicializarMapAuditoria();
					//entity.setMapAuditoria(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAuditoriaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAuditoria().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AuditoriaDataAccess.ISWITHSCHEMA);         		
					entity=AuditoriaDataAccess.getEntityAuditoria("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setAuditoriaOriginal( new Auditoria());
					//entity.setAuditoriaOriginal(super.getEntity("",entity.getAuditoriaOriginal(),resultSet,AuditoriaDataAccess.ISWITHSCHEMA));         		
					//entity.setAuditoriaOriginal(this.getEntityAuditoria("",entity.getAuditoriaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAuditoria(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAuditoria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Auditoria getEntityAuditoria(String strPrefijo,Auditoria entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Auditoria.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Auditoria.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AuditoriaDataAccess.setFieldReflectionAuditoria(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAuditoria=AuditoriaConstantesFunciones.getTodosTiposColumnasAuditoria();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAuditoria) {
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
							field = Auditoria.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Auditoria.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AuditoriaDataAccess.setFieldReflectionAuditoria(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAuditoria(Field field,String strPrefijo,String sColumn,Auditoria entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AuditoriaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AuditoriaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AuditoriaConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AuditoriaConstantesFunciones.NOMBRETABLA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AuditoriaConstantesFunciones.IDFILA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AuditoriaConstantesFunciones.ACCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AuditoriaConstantesFunciones.PROCESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AuditoriaConstantesFunciones.NOMBREPC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AuditoriaConstantesFunciones.IPPC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AuditoriaConstantesFunciones.USUARIOPC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AuditoriaConstantesFunciones.FECHAHORA:
					field.set(entity,resultSet.getTimestamp(sCampo));
					break;
				
				case AuditoriaConstantesFunciones.OBSERVACION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Auditoria>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Auditoria> entities = new  ArrayList<Auditoria>();
		Auditoria entity = new Auditoria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AuditoriaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Auditoria();
					entity=super.getEntity("",entity,resultSet,AuditoriaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAuditoria("",entity,resultSet);
					
					entity.setAuditoriaOriginal( new Auditoria());
					entity.setAuditoriaOriginal(super.getEntity("",entity.getAuditoriaOriginal(),resultSet,AuditoriaDataAccess.ISWITHSCHEMA));         		
					entity.setAuditoriaOriginal(this.getEntityAuditoria("",entity.getAuditoriaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAuditorias(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAuditoria(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Auditoria>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Auditoria> entities = new  ArrayList<Auditoria>();
		Auditoria entity = new Auditoria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AuditoriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AuditoriaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Auditoria> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Auditoria> entities = new  ArrayList<Auditoria>();
		Auditoria entity = new Auditoria();		  
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
	
	public  List<Auditoria> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Auditoria> entities = new  ArrayList<Auditoria>();
		Auditoria entity = new Auditoria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Auditoria();
      	    	entity=super.getEntity("",entity,resultSet,AuditoriaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAuditoria("",entity,resultSet);
      	    	
				entity.setAuditoriaOriginal( new Auditoria());
      	    	entity.setAuditoriaOriginal(super.getEntity("",entity.getAuditoriaOriginal(),resultSet,AuditoriaDataAccess.ISWITHSCHEMA));         		
      	    	entity.setAuditoriaOriginal(this.getEntityAuditoria("",entity.getAuditoriaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAuditorias(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAuditoria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Auditoria> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Auditoria> entities = new  ArrayList<Auditoria>();
		Auditoria entity = new Auditoria();		  
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
	
	public  List<Auditoria> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Auditoria> entities = new  ArrayList<Auditoria>();
		Auditoria entity = new Auditoria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Auditoria();
      	    	entity=super.getEntity("",entity,resultSet,AuditoriaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAuditoria("",entity,resultSet);
      	    	
				entity.setAuditoriaOriginal( new Auditoria());
      	    	entity.setAuditoriaOriginal(super.getEntity("",entity.getAuditoriaOriginal(),resultSet,AuditoriaDataAccess.ISWITHSCHEMA));         		
      	    	entity.setAuditoriaOriginal(this.getEntityAuditoria("",entity.getAuditoriaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAuditorias(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Auditoria getEntityAuditoria(String strPrefijo,Auditoria entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_usuario(resultSet.getLong(strPrefijo+AuditoriaConstantesFunciones.IDUSUARIO));
				entity.setnombre_tabla(resultSet.getString(strPrefijo+AuditoriaConstantesFunciones.NOMBRETABLA));
				entity.setid_fila(resultSet.getLong(strPrefijo+AuditoriaConstantesFunciones.IDFILA));
				entity.setaccion(resultSet.getString(strPrefijo+AuditoriaConstantesFunciones.ACCION));
				entity.setproceso(resultSet.getString(strPrefijo+AuditoriaConstantesFunciones.PROCESO));
				entity.setnombre_p_c(resultSet.getString(strPrefijo+AuditoriaConstantesFunciones.NOMBREPC));
				entity.setip_pc(resultSet.getString(strPrefijo+AuditoriaConstantesFunciones.IPPC));
				entity.setusuario_p_c(resultSet.getString(strPrefijo+AuditoriaConstantesFunciones.USUARIOPC));
				entity.setfecha_hora(resultSet.getTimestamp(strPrefijo+AuditoriaConstantesFunciones.FECHAHORA));
				entity.setobservacion(resultSet.getString(strPrefijo+AuditoriaConstantesFunciones.OBSERVACION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAuditoria(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Auditoria entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AuditoriaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AuditoriaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AuditoriaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AuditoriaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AuditoriaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AuditoriaDataAccess.TABLENAME,AuditoriaDataAccess.ISWITHSTOREPROCEDURES);
			
			AuditoriaDataAccess.setAuditoriaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Usuario getUsuario(Connexion connexion,Auditoria relauditoria)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relauditoria.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}


		
		public List<AuditoriaDetalle> getAuditoriaDetalles(Connexion connexion,Auditoria auditoria)throws SQLException,Exception {

		List<AuditoriaDetalle> auditoriadetalles= new ArrayList<AuditoriaDetalle>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+AuditoriaConstantesFunciones.SCHEMA+".auditoria ON "+AuditoriaDetalleConstantesFunciones.SCHEMA+".auditoria_detalle.id_auditoria="+AuditoriaConstantesFunciones.SCHEMA+".auditoria.id WHERE "+AuditoriaConstantesFunciones.SCHEMA+".auditoria.id="+String.valueOf(auditoria.getId());
			} else {
				sQuery=" INNER JOIN auditoriadetalle.Auditoria WHERE auditoriadetalle.Auditoria.id="+String.valueOf(auditoria.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AuditoriaDetalleDataAccess auditoriadetalleDataAccess=new AuditoriaDetalleDataAccess();

			auditoriadetalleDataAccess.setConnexionType(this.connexionType);
			auditoriadetalleDataAccess.setParameterDbType(this.parameterDbType);
			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return auditoriadetalles;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Auditoria auditoria) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!auditoria.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(auditoria.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_tabla=new ParameterValue<String>();
					parameterMaintenanceValuenombre_tabla.setValue(auditoria.getnombre_tabla());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_tabla);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_fila=new ParameterValue<Long>();
					parameterMaintenanceValueid_fila.setValue(auditoria.getid_fila());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_fila);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueaccion=new ParameterValue<String>();
					parameterMaintenanceValueaccion.setValue(auditoria.getaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueproceso=new ParameterValue<String>();
					parameterMaintenanceValueproceso.setValue(auditoria.getproceso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueproceso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_p_c=new ParameterValue<String>();
					parameterMaintenanceValuenombre_p_c.setValue(auditoria.getnombre_p_c());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_p_c);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueip_pc=new ParameterValue<String>();
					parameterMaintenanceValueip_pc.setValue(auditoria.getip_pc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueip_pc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueusuario_p_c=new ParameterValue<String>();
					parameterMaintenanceValueusuario_p_c.setValue(auditoria.getusuario_p_c());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueusuario_p_c);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
					ParameterValue<Timestamp> parameterMaintenanceValuefecha_hora=new ParameterValue<Timestamp>();
					parameterMaintenanceValuefecha_hora.setValue(auditoria.getfecha_hora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_hora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion=new ParameterValue<String>();
					parameterMaintenanceValueobservacion.setValue(auditoria.getobservacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!auditoria.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(auditoria.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(auditoria.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(auditoria.getId());
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
	
	public void setIsNewIsChangedFalseAuditoria(Auditoria auditoria)throws Exception  {		
		auditoria.setIsNew(false);
		auditoria.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAuditorias(List<Auditoria> auditorias)throws Exception  {				
		for(Auditoria auditoria:auditorias) {
			auditoria.setIsNew(false);
			auditoria.setIsChanged(false);
		}
	}
	
	public void generarExportarAuditoria(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
