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
import com.bydan.erp.seguridad.util.*;//AuditoriaDetalleConstantesFunciones;










@SuppressWarnings("unused")
final public class AuditoriaDetalleDataAccess extends  AuditoriaDetalleDataAccessAdditional{ //AuditoriaDetalleDataAccessAdditional,DataAccessHelper<AuditoriaDetalle>
	//static Logger logger = Logger.getLogger(AuditoriaDetalleDataAccess.class);
	
	public static String SCHEMA="auditoria";	
	public static String TABLENAME="auditoria_detalle";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+"(version_row,id_auditoria,nombre_campo,valor_anterior,valor_actual)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_auditoria=?,nombre_campo=?,valor_anterior=?,valor_actual=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select auditoriadetalle from "+AuditoriaDetalleConstantesFunciones.SPERSISTENCENAME+" auditoriadetalle";
	public static String QUERYSELECTNATIVE="select "+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".id,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".version_row,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".id_auditoria,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".nombre_campo,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".valor_anterior,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".valor_actual from "+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME;//+" as "+AuditoriaDetalleConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".id,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".version_row,"+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+".valor_anterior from "+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME;//+" as "+AuditoriaDetalleConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AuditoriaDetalleConstantesFunciones.SCHEMA+"."+AuditoriaDetalleConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_auditoria=?,nombre_campo=?,valor_anterior=?,valor_actual=?";
	
	public static String STOREPROCEDUREINSERT="call SP_AUDITORIADETALLE_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_AUDITORIADETALLE_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_AUDITORIADETALLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_AUDITORIADETALLE_SELECT(?,?)";
	
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
	
	
	protected AuditoriaDetalleDataAccessAdditional auditoriadetalleDataAccessAdditional=null;
	
	public AuditoriaDetalleDataAccessAdditional getAuditoriaDetalleDataAccessAdditional() {
		return this.auditoriadetalleDataAccessAdditional;
	}
	
	public void setAuditoriaDetalleDataAccessAdditional(AuditoriaDetalleDataAccessAdditional auditoriadetalleDataAccessAdditional) {
		try {
			this.auditoriadetalleDataAccessAdditional=auditoriadetalleDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AuditoriaDetalleDataAccess() {
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
		AuditoriaDetalleDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AuditoriaDetalleDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AuditoriaDetalleDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAuditoriaDetalleOriginal(AuditoriaDetalle auditoriadetalle)throws Exception  {
		auditoriadetalle.setAuditoriaDetalleOriginal((AuditoriaDetalle)auditoriadetalle.clone());		
	}
	
	public void setAuditoriaDetallesOriginal(List<AuditoriaDetalle> auditoriadetalles)throws Exception  {
		
		for(AuditoriaDetalle auditoriadetalle:auditoriadetalles){
			auditoriadetalle.setAuditoriaDetalleOriginal((AuditoriaDetalle)auditoriadetalle.clone());
		}
	}
	
	public static void setAuditoriaDetalleOriginalStatic(AuditoriaDetalle auditoriadetalle)throws Exception  {
		auditoriadetalle.setAuditoriaDetalleOriginal((AuditoriaDetalle)auditoriadetalle.clone());		
	}
	
	public static void setAuditoriaDetallesOriginalStatic(List<AuditoriaDetalle> auditoriadetalles)throws Exception  {
		
		for(AuditoriaDetalle auditoriadetalle:auditoriadetalles){
			auditoriadetalle.setAuditoriaDetalleOriginal((AuditoriaDetalle)auditoriadetalle.clone());
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
	
	public  AuditoriaDetalle getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AuditoriaDetalle entity = new AuditoriaDetalle();		
		
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
	
	public  AuditoriaDetalle getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AuditoriaDetalle entity = new AuditoriaDetalle();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.AuditoriaDetalle.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAuditoriaDetalleOriginal(new AuditoriaDetalle());
      	    	entity=super.getEntity("",entity,resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAuditoriaDetalle("",entity,resultSet); 
				
				entity.setAuditoriaDetalleOriginal(super.getEntity("",entity.getAuditoriaDetalleOriginal(),resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA));         		
      	    	entity.setAuditoriaDetalleOriginal(this.getEntityAuditoriaDetalle("",entity.getAuditoriaDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAuditoriaDetalle(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AuditoriaDetalle getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AuditoriaDetalle entity = new AuditoriaDetalle();
				
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
	
	public  AuditoriaDetalle getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AuditoriaDetalle entity = new AuditoriaDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AuditoriaDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.AuditoriaDetalle.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAuditoriaDetalleOriginal(new AuditoriaDetalle());
      	    	entity=super.getEntity("",entity,resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAuditoriaDetalle("",entity,resultSet);    
				
				entity.setAuditoriaDetalleOriginal(super.getEntity("",entity.getAuditoriaDetalleOriginal(),resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA));         		
      	    	entity.setAuditoriaDetalleOriginal(this.getEntityAuditoriaDetalle("",entity.getAuditoriaDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAuditoriaDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AuditoriaDetalle
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AuditoriaDetalle entity = new AuditoriaDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AuditoriaDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.AuditoriaDetalle.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAuditoriaDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AuditoriaDetalle> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AuditoriaDetalle> entities = new  ArrayList<AuditoriaDetalle>();
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
		
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
	
	public  List<AuditoriaDetalle> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AuditoriaDetalle> entities = new  ArrayList<AuditoriaDetalle>();
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AuditoriaDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AuditoriaDetalle();
      	    	entity=super.getEntity("",entity,resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAuditoriaDetalle("",entity,resultSet);
      	    	
				entity.setAuditoriaDetalleOriginal( new AuditoriaDetalle());
      	    	entity.setAuditoriaDetalleOriginal(super.getEntity("",entity.getAuditoriaDetalleOriginal(),resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA));         		
      	    	entity.setAuditoriaDetalleOriginal(this.getEntityAuditoriaDetalle("",entity.getAuditoriaDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAuditoriaDetalles(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAuditoriaDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AuditoriaDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AuditoriaDetalle> entities = new  ArrayList<AuditoriaDetalle>();
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
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
	
	public  List<AuditoriaDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AuditoriaDetalle> entities = new  ArrayList<AuditoriaDetalle>();
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AuditoriaDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapAuditoriaDetalle();
					//entity.setMapAuditoriaDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAuditoriaDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAuditoriaDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA);         		
					entity=AuditoriaDetalleDataAccess.getEntityAuditoriaDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setAuditoriaDetalleOriginal( new AuditoriaDetalle());
					//entity.setAuditoriaDetalleOriginal(super.getEntity("",entity.getAuditoriaDetalleOriginal(),resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA));         		
					//entity.setAuditoriaDetalleOriginal(this.getEntityAuditoriaDetalle("",entity.getAuditoriaDetalleOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAuditoriaDetalles(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAuditoriaDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AuditoriaDetalle getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
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
	
	public  AuditoriaDetalle getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AuditoriaDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapAuditoriaDetalle();
					//entity.setMapAuditoriaDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAuditoriaDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAuditoriaDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA);         		
					entity=AuditoriaDetalleDataAccess.getEntityAuditoriaDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setAuditoriaDetalleOriginal( new AuditoriaDetalle());
					//entity.setAuditoriaDetalleOriginal(super.getEntity("",entity.getAuditoriaDetalleOriginal(),resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA));         		
					//entity.setAuditoriaDetalleOriginal(this.getEntityAuditoriaDetalle("",entity.getAuditoriaDetalleOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAuditoriaDetalle(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAuditoriaDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AuditoriaDetalle getEntityAuditoriaDetalle(String strPrefijo,AuditoriaDetalle entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AuditoriaDetalle.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AuditoriaDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AuditoriaDetalleDataAccess.setFieldReflectionAuditoriaDetalle(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAuditoriaDetalle=AuditoriaDetalleConstantesFunciones.getTodosTiposColumnasAuditoriaDetalle();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAuditoriaDetalle) {
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
							field = AuditoriaDetalle.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AuditoriaDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AuditoriaDetalleDataAccess.setFieldReflectionAuditoriaDetalle(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAuditoriaDetalle(Field field,String strPrefijo,String sColumn,AuditoriaDetalle entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AuditoriaDetalleConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AuditoriaDetalleConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AuditoriaDetalleConstantesFunciones.IDAUDITORIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AuditoriaDetalleConstantesFunciones.NOMBRECAMPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AuditoriaDetalleConstantesFunciones.VALORANTERIOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AuditoriaDetalleConstantesFunciones.VALORACTUAL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AuditoriaDetalle>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AuditoriaDetalle> entities = new  ArrayList<AuditoriaDetalle>();
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AuditoriaDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AuditoriaDetalle();
					entity=super.getEntity("",entity,resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAuditoriaDetalle("",entity,resultSet);
					
					entity.setAuditoriaDetalleOriginal( new AuditoriaDetalle());
					entity.setAuditoriaDetalleOriginal(super.getEntity("",entity.getAuditoriaDetalleOriginal(),resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA));         		
					entity.setAuditoriaDetalleOriginal(this.getEntityAuditoriaDetalle("",entity.getAuditoriaDetalleOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAuditoriaDetalles(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAuditoriaDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AuditoriaDetalle>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AuditoriaDetalle> entities = new  ArrayList<AuditoriaDetalle>();
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AuditoriaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AuditoriaDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AuditoriaDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AuditoriaDetalle> entities = new  ArrayList<AuditoriaDetalle>();
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
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
	
	public  List<AuditoriaDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AuditoriaDetalle> entities = new  ArrayList<AuditoriaDetalle>();
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AuditoriaDetalle();
      	    	entity=super.getEntity("",entity,resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAuditoriaDetalle("",entity,resultSet);
      	    	
				entity.setAuditoriaDetalleOriginal( new AuditoriaDetalle());
      	    	entity.setAuditoriaDetalleOriginal(super.getEntity("",entity.getAuditoriaDetalleOriginal(),resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA));         		
      	    	entity.setAuditoriaDetalleOriginal(this.getEntityAuditoriaDetalle("",entity.getAuditoriaDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAuditoriaDetalles(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAuditoriaDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AuditoriaDetalle> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AuditoriaDetalle> entities = new  ArrayList<AuditoriaDetalle>();
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
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
	
	public  List<AuditoriaDetalle> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AuditoriaDetalle> entities = new  ArrayList<AuditoriaDetalle>();
		AuditoriaDetalle entity = new AuditoriaDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AuditoriaDetalle();
      	    	entity=super.getEntity("",entity,resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAuditoriaDetalle("",entity,resultSet);
      	    	
				entity.setAuditoriaDetalleOriginal( new AuditoriaDetalle());
      	    	entity.setAuditoriaDetalleOriginal(super.getEntity("",entity.getAuditoriaDetalleOriginal(),resultSet,AuditoriaDetalleDataAccess.ISWITHSCHEMA));         		
      	    	entity.setAuditoriaDetalleOriginal(this.getEntityAuditoriaDetalle("",entity.getAuditoriaDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAuditoriaDetalles(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AuditoriaDetalle getEntityAuditoriaDetalle(String strPrefijo,AuditoriaDetalle entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_auditoria(resultSet.getLong(strPrefijo+AuditoriaDetalleConstantesFunciones.IDAUDITORIA));
				entity.setnombre_campo(resultSet.getString(strPrefijo+AuditoriaDetalleConstantesFunciones.NOMBRECAMPO));
				entity.setvalor_anterior(resultSet.getString(strPrefijo+AuditoriaDetalleConstantesFunciones.VALORANTERIOR));
				entity.setvalor_actual(resultSet.getString(strPrefijo+AuditoriaDetalleConstantesFunciones.VALORACTUAL));
			} else {
				entity.setvalor_anterior(resultSet.getString(strPrefijo+AuditoriaDetalleConstantesFunciones.VALORANTERIOR));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAuditoriaDetalle(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AuditoriaDetalle entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AuditoriaDetalleDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AuditoriaDetalleDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AuditoriaDetalleDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AuditoriaDetalleDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AuditoriaDetalleConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AuditoriaDetalleDataAccess.TABLENAME,AuditoriaDetalleDataAccess.ISWITHSTOREPROCEDURES);
			
			AuditoriaDetalleDataAccess.setAuditoriaDetalleOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Auditoria getAuditoria(Connexion connexion,AuditoriaDetalle relauditoriadetalle)throws SQLException,Exception {

		Auditoria auditoria= new Auditoria();

		try {
			AuditoriaDataAccess auditoriaDataAccess=new AuditoriaDataAccess();

			auditoriaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			auditoriaDataAccess.setConnexionType(this.connexionType);
			auditoriaDataAccess.setParameterDbType(this.parameterDbType);

			auditoria=auditoriaDataAccess.getEntity(connexion,relauditoriadetalle.getid_auditoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return auditoria;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AuditoriaDetalle auditoriadetalle) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!auditoriadetalle.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_auditoria=new ParameterValue<Long>();
					parameterMaintenanceValueid_auditoria.setValue(auditoriadetalle.getid_auditoria());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_auditoria);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_campo=new ParameterValue<String>();
					parameterMaintenanceValuenombre_campo.setValue(auditoriadetalle.getnombre_campo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_campo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuevalor_anterior=new ParameterValue<String>();
					parameterMaintenanceValuevalor_anterior.setValue(auditoriadetalle.getvalor_anterior());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_anterior);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuevalor_actual=new ParameterValue<String>();
					parameterMaintenanceValuevalor_actual.setValue(auditoriadetalle.getvalor_actual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_actual);
					parametersTemp.add(parameterMaintenance);
					
						if(!auditoriadetalle.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(auditoriadetalle.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(auditoriadetalle.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(auditoriadetalle.getId());
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
	
	public void setIsNewIsChangedFalseAuditoriaDetalle(AuditoriaDetalle auditoriadetalle)throws Exception  {		
		auditoriadetalle.setIsNew(false);
		auditoriadetalle.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAuditoriaDetalles(List<AuditoriaDetalle> auditoriadetalles)throws Exception  {				
		for(AuditoriaDetalle auditoriadetalle:auditoriadetalles) {
			auditoriadetalle.setIsNew(false);
			auditoriadetalle.setIsChanged(false);
		}
	}
	
	public void generarExportarAuditoriaDetalle(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
