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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.*;//UpdateDetalleConstantesFunciones;










@SuppressWarnings("unused")
final public class UpdateDetalleDataAccess extends  UpdateDetalleDataAccessAdditional{ //UpdateDetalleDataAccessAdditional,DataAccessHelper<UpdateDetalle>
	//static Logger logger = Logger.getLogger(UpdateDetalleDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="update_detalle";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+"(id,version_row,id_update,id_anio,id_mes,codigo,codigo_proceso,query_resumen,numero_intento,fecha_archivo,fecha,orden,ejecutado,esta_activo,descripcion)values(?,current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_update=?,id_anio=?,id_mes=?,codigo=?,codigo_proceso=?,query_resumen=?,numero_intento=?,fecha_archivo=?,fecha=?,orden=?,ejecutado=?,esta_activo=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select updatedetalle from "+UpdateDetalleConstantesFunciones.SPERSISTENCENAME+" updatedetalle";
	public static String QUERYSELECTNATIVE="select "+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".id,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".version_row,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".id_update,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".id_anio,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".id_mes,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".codigo,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".codigo_proceso,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".query_resumen,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".numero_intento,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".fecha_archivo,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".fecha,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".orden,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".ejecutado,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".esta_activo,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".descripcion from "+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME;//+" as "+UpdateDetalleConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".id,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".version_row,"+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+".codigo from "+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME;//+" as "+UpdateDetalleConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+UpdateDetalleConstantesFunciones.SCHEMA+"."+UpdateDetalleConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_update=?,id_anio=?,id_mes=?,codigo=?,codigo_proceso=?,query_resumen=?,numero_intento=?,fecha_archivo=?,fecha=?,orden=?,ejecutado=?,esta_activo=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_UPDATEDETALLE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_UPDATEDETALLE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_UPDATEDETALLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_UPDATEDETALLE_SELECT(?,?)";
	
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
	
	
	protected UpdateDetalleDataAccessAdditional updatedetalleDataAccessAdditional=null;
	
	public UpdateDetalleDataAccessAdditional getUpdateDetalleDataAccessAdditional() {
		return this.updatedetalleDataAccessAdditional;
	}
	
	public void setUpdateDetalleDataAccessAdditional(UpdateDetalleDataAccessAdditional updatedetalleDataAccessAdditional) {
		try {
			this.updatedetalleDataAccessAdditional=updatedetalleDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public UpdateDetalleDataAccess() {
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
		UpdateDetalleDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		UpdateDetalleDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		UpdateDetalleDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setUpdateDetalleOriginal(UpdateDetalle updatedetalle)throws Exception  {
		updatedetalle.setUpdateDetalleOriginal((UpdateDetalle)updatedetalle.clone());		
	}
	
	public void setUpdateDetallesOriginal(List<UpdateDetalle> updatedetalles)throws Exception  {
		
		for(UpdateDetalle updatedetalle:updatedetalles){
			updatedetalle.setUpdateDetalleOriginal((UpdateDetalle)updatedetalle.clone());
		}
	}
	
	public static void setUpdateDetalleOriginalStatic(UpdateDetalle updatedetalle)throws Exception  {
		updatedetalle.setUpdateDetalleOriginal((UpdateDetalle)updatedetalle.clone());		
	}
	
	public static void setUpdateDetallesOriginalStatic(List<UpdateDetalle> updatedetalles)throws Exception  {
		
		for(UpdateDetalle updatedetalle:updatedetalles){
			updatedetalle.setUpdateDetalleOriginal((UpdateDetalle)updatedetalle.clone());
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
	
	public  UpdateDetalle getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		UpdateDetalle entity = new UpdateDetalle();		
		
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
	
	public  UpdateDetalle getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		UpdateDetalle entity = new UpdateDetalle();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.UpdateDetalle.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setUpdateDetalleOriginal(new UpdateDetalle());
      	    	entity=super.getEntity("",entity,resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUpdateDetalle("",entity,resultSet); 
				
				//entity.setUpdateDetalleOriginal(super.getEntity("",entity.getUpdateDetalleOriginal(),resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUpdateDetalleOriginal(this.getEntityUpdateDetalle("",entity.getUpdateDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseUpdateDetalle(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  UpdateDetalle getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UpdateDetalle entity = new UpdateDetalle();
				
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
	
	public  UpdateDetalle getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UpdateDetalle entity = new UpdateDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,UpdateDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.UpdateDetalle.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setUpdateDetalleOriginal(new UpdateDetalle());
      	    	entity=super.getEntity("",entity,resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUpdateDetalle("",entity,resultSet);    
				
				//entity.setUpdateDetalleOriginal(super.getEntity("",entity.getUpdateDetalleOriginal(),resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUpdateDetalleOriginal(this.getEntityUpdateDetalle("",entity.getUpdateDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseUpdateDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //UpdateDetalle
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		UpdateDetalle entity = new UpdateDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,UpdateDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.UpdateDetalle.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseUpdateDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<UpdateDetalle> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UpdateDetalle> entities = new  ArrayList<UpdateDetalle>();
		UpdateDetalle entity = new UpdateDetalle();		  
		
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
	
	public  List<UpdateDetalle> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UpdateDetalle> entities = new  ArrayList<UpdateDetalle>();
		UpdateDetalle entity = new UpdateDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,UpdateDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UpdateDetalle();
      	    	entity=super.getEntity("",entity,resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUpdateDetalle("",entity,resultSet);
      	    	
				//entity.setUpdateDetalleOriginal( new UpdateDetalle());
      	    	//entity.setUpdateDetalleOriginal(super.getEntity("",entity.getUpdateDetalleOriginal(),resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUpdateDetalleOriginal(this.getEntityUpdateDetalle("",entity.getUpdateDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUpdateDetalles(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUpdateDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<UpdateDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UpdateDetalle> entities = new  ArrayList<UpdateDetalle>();
		UpdateDetalle entity = new UpdateDetalle();		  
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
	
	public  List<UpdateDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UpdateDetalle> entities = new  ArrayList<UpdateDetalle>();
		UpdateDetalle entity = new UpdateDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UpdateDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapUpdateDetalle();
					//entity.setMapUpdateDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapUpdateDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUpdateDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA);         		
					entity=UpdateDetalleDataAccess.getEntityUpdateDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUpdateDetalleOriginal( new UpdateDetalle());
					////entity.setUpdateDetalleOriginal(super.getEntity("",entity.getUpdateDetalleOriginal(),resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setUpdateDetalleOriginal(this.getEntityUpdateDetalle("",entity.getUpdateDetalleOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUpdateDetalles(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUpdateDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public UpdateDetalle getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UpdateDetalle entity = new UpdateDetalle();		  
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
	
	public  UpdateDetalle getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UpdateDetalle entity = new UpdateDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UpdateDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapUpdateDetalle();
					//entity.setMapUpdateDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapUpdateDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUpdateDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA);         		
					entity=UpdateDetalleDataAccess.getEntityUpdateDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUpdateDetalleOriginal( new UpdateDetalle());
					////entity.setUpdateDetalleOriginal(super.getEntity("",entity.getUpdateDetalleOriginal(),resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setUpdateDetalleOriginal(this.getEntityUpdateDetalle("",entity.getUpdateDetalleOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseUpdateDetalle(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUpdateDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static UpdateDetalle getEntityUpdateDetalle(String strPrefijo,UpdateDetalle entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = UpdateDetalle.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = UpdateDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					UpdateDetalleDataAccess.setFieldReflectionUpdateDetalle(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasUpdateDetalle=UpdateDetalleConstantesFunciones.getTodosTiposColumnasUpdateDetalle();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasUpdateDetalle) {
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
							field = UpdateDetalle.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = UpdateDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						UpdateDetalleDataAccess.setFieldReflectionUpdateDetalle(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionUpdateDetalle(Field field,String strPrefijo,String sColumn,UpdateDetalle entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case UpdateDetalleConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.IDUPDATE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.CODIGOPROCESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.QUERYRESUMEN:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.NUMEROINTENTO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.FECHAARCHIVO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case UpdateDetalleConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case UpdateDetalleConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.EJECUTADO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case UpdateDetalleConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UpdateDetalle>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<UpdateDetalle> entities = new  ArrayList<UpdateDetalle>();
		UpdateDetalle entity = new UpdateDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,UpdateDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new UpdateDetalle();
					entity=super.getEntity("",entity,resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityUpdateDetalle("",entity,resultSet);
					
					//entity.setUpdateDetalleOriginal( new UpdateDetalle());
					//entity.setUpdateDetalleOriginal(super.getEntity("",entity.getUpdateDetalleOriginal(),resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA));         		
					//entity.setUpdateDetalleOriginal(this.getEntityUpdateDetalle("",entity.getUpdateDetalleOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseUpdateDetalles(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUpdateDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UpdateDetalle>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<UpdateDetalle> entities = new  ArrayList<UpdateDetalle>();
		UpdateDetalle entity = new UpdateDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UpdateDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,UpdateDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<UpdateDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UpdateDetalle> entities = new  ArrayList<UpdateDetalle>();
		UpdateDetalle entity = new UpdateDetalle();		  
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
	
	public  List<UpdateDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UpdateDetalle> entities = new  ArrayList<UpdateDetalle>();
		UpdateDetalle entity = new UpdateDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UpdateDetalle();
      	    	entity=super.getEntity("",entity,resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUpdateDetalle("",entity,resultSet);
      	    	
				//entity.setUpdateDetalleOriginal( new UpdateDetalle());
      	    	//entity.setUpdateDetalleOriginal(super.getEntity("",entity.getUpdateDetalleOriginal(),resultSet,UpdateDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUpdateDetalleOriginal(this.getEntityUpdateDetalle("",entity.getUpdateDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseUpdateDetalles(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUpdateDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public UpdateDetalle getEntityUpdateDetalle(String strPrefijo,UpdateDetalle entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_update(resultSet.getLong(strPrefijo+UpdateDetalleConstantesFunciones.IDUPDATE));
				entity.setid_anio(resultSet.getLong(strPrefijo+UpdateDetalleConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+UpdateDetalleConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setcodigo(resultSet.getString(strPrefijo+UpdateDetalleConstantesFunciones.CODIGO));
				entity.setcodigo_proceso(resultSet.getString(strPrefijo+UpdateDetalleConstantesFunciones.CODIGOPROCESO));
				entity.setquery_resumen(resultSet.getString(strPrefijo+UpdateDetalleConstantesFunciones.QUERYRESUMEN));
				entity.setnumero_intento(resultSet.getInt(strPrefijo+UpdateDetalleConstantesFunciones.NUMEROINTENTO));
				entity.setfecha_archivo(new Date(resultSet.getDate(strPrefijo+UpdateDetalleConstantesFunciones.FECHAARCHIVO).getTime()));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+UpdateDetalleConstantesFunciones.FECHA).getTime()));
				entity.setorden(resultSet.getInt(strPrefijo+UpdateDetalleConstantesFunciones.ORDEN));
				entity.setejecutado(resultSet.getBoolean(strPrefijo+UpdateDetalleConstantesFunciones.EJECUTADO));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+UpdateDetalleConstantesFunciones.ESTAACTIVO));
				entity.setdescripcion(resultSet.getString(strPrefijo+UpdateDetalleConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+UpdateDetalleConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowUpdateDetalle(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(UpdateDetalle entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=UpdateDetalleDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=UpdateDetalleDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=UpdateDetalleDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=UpdateDetalleDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(UpdateDetalleConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,UpdateDetalleDataAccess.TABLENAME,UpdateDetalleDataAccess.ISWITHSTOREPROCEDURES);
			
			UpdateDetalleDataAccess.setUpdateDetalleOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Update getUpdate(Connexion connexion,UpdateDetalle relupdatedetalle)throws SQLException,Exception {

		Update update= new Update();

		try {
			UpdateDataAccess updateDataAccess=new UpdateDataAccess();

			updateDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			updateDataAccess.setConnexionType(this.connexionType);
			updateDataAccess.setParameterDbType(this.parameterDbType);

			update=updateDataAccess.getEntity(connexion,relupdatedetalle.getid_update());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return update;

	}

	public Anio getAnio(Connexion connexion,UpdateDetalle relupdatedetalle)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relupdatedetalle.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,UpdateDetalle relupdatedetalle)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relupdatedetalle.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,UpdateDetalle updatedetalle) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!updatedetalle.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(updatedetalle.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_update=new ParameterValue<Long>();
					parameterMaintenanceValueid_update.setValue(updatedetalle.getid_update());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_update);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(updatedetalle.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(updatedetalle.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(updatedetalle.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_proceso=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_proceso.setValue(updatedetalle.getcodigo_proceso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_proceso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuequery_resumen=new ParameterValue<String>();
					parameterMaintenanceValuequery_resumen.setValue(updatedetalle.getquery_resumen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuequery_resumen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_intento=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_intento.setValue(updatedetalle.getnumero_intento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_intento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_archivo=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_archivo.setValue(updatedetalle.getfecha_archivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_archivo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(updatedetalle.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueorden=new ParameterValue<Integer>();
					parameterMaintenanceValueorden.setValue(updatedetalle.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueejecutado=new ParameterValue<Boolean>();
					parameterMaintenanceValueejecutado.setValue(updatedetalle.getejecutado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueejecutado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(updatedetalle.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(updatedetalle.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!updatedetalle.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(updatedetalle.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(updatedetalle.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(updatedetalle.getId());
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
	
	public void setIsNewIsChangedFalseUpdateDetalle(UpdateDetalle updatedetalle)throws Exception  {		
		updatedetalle.setIsNew(false);
		updatedetalle.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseUpdateDetalles(List<UpdateDetalle> updatedetalles)throws Exception  {				
		for(UpdateDetalle updatedetalle:updatedetalles) {
			updatedetalle.setIsNew(false);
			updatedetalle.setIsChanged(false);
		}
	}
	
	public void generarExportarUpdateDetalle(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
