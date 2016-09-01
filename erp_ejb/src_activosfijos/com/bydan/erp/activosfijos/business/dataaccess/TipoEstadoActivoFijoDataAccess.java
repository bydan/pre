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
package com.bydan.erp.activosfijos.business.dataaccess;

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

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//TipoEstadoActivoFijoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoEstadoActivoFijoDataAccess extends  DataAccessHelperSinIdGenerated<TipoEstadoActivoFijo>{ //TipoEstadoActivoFijoDataAccessAdditional,DataAccessHelper<TipoEstadoActivoFijo>
	//static Logger logger = Logger.getLogger(TipoEstadoActivoFijoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_estado_activo_fijo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+"(id,version_row,id_pais,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_pais=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoestadoactivofijo from "+TipoEstadoActivoFijoConstantesFunciones.SPERSISTENCENAME+" tipoestadoactivofijo";
	public static String QUERYSELECTNATIVE="select "+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+".id,"+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+".id_pais,"+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+".nombre from "+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME;//+" as "+TipoEstadoActivoFijoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+".id,"+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+".nombre from "+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME;//+" as "+TipoEstadoActivoFijoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoEstadoActivoFijoConstantesFunciones.SCHEMA+"."+TipoEstadoActivoFijoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_pais=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOESTADOACTIVOFIJO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOESTADOACTIVOFIJO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOESTADOACTIVOFIJO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOESTADOACTIVOFIJO_SELECT(?,?)";
	
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
	
	
	public TipoEstadoActivoFijoDataAccess() {
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
		TipoEstadoActivoFijoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoEstadoActivoFijoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoEstadoActivoFijoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoEstadoActivoFijoOriginal(TipoEstadoActivoFijo tipoestadoactivofijo)throws Exception  {
		tipoestadoactivofijo.setTipoEstadoActivoFijoOriginal((TipoEstadoActivoFijo)tipoestadoactivofijo.clone());		
	}
	
	public void setTipoEstadoActivoFijosOriginal(List<TipoEstadoActivoFijo> tipoestadoactivofijos)throws Exception  {
		
		for(TipoEstadoActivoFijo tipoestadoactivofijo:tipoestadoactivofijos){
			tipoestadoactivofijo.setTipoEstadoActivoFijoOriginal((TipoEstadoActivoFijo)tipoestadoactivofijo.clone());
		}
	}
	
	public static void setTipoEstadoActivoFijoOriginalStatic(TipoEstadoActivoFijo tipoestadoactivofijo)throws Exception  {
		tipoestadoactivofijo.setTipoEstadoActivoFijoOriginal((TipoEstadoActivoFijo)tipoestadoactivofijo.clone());		
	}
	
	public static void setTipoEstadoActivoFijosOriginalStatic(List<TipoEstadoActivoFijo> tipoestadoactivofijos)throws Exception  {
		
		for(TipoEstadoActivoFijo tipoestadoactivofijo:tipoestadoactivofijos){
			tipoestadoactivofijo.setTipoEstadoActivoFijoOriginal((TipoEstadoActivoFijo)tipoestadoactivofijo.clone());
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
	
	public  TipoEstadoActivoFijo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		
		
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
	
	public  TipoEstadoActivoFijo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.TipoEstadoActivoFijo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoEstadoActivoFijoOriginal(new TipoEstadoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoEstadoActivoFijo("",entity,resultSet); 
				
				//entity.setTipoEstadoActivoFijoOriginal(super.getEntity("",entity.getTipoEstadoActivoFijoOriginal(),resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEstadoActivoFijoOriginal(this.getEntityTipoEstadoActivoFijo("",entity.getTipoEstadoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoEstadoActivoFijo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoEstadoActivoFijo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();
				
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
	
	public  TipoEstadoActivoFijo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoEstadoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.TipoEstadoActivoFijo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoEstadoActivoFijoOriginal(new TipoEstadoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoEstadoActivoFijo("",entity,resultSet);    
				
				//entity.setTipoEstadoActivoFijoOriginal(super.getEntity("",entity.getTipoEstadoActivoFijoOriginal(),resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEstadoActivoFijoOriginal(this.getEntityTipoEstadoActivoFijo("",entity.getTipoEstadoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoEstadoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoEstadoActivoFijo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoEstadoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.TipoEstadoActivoFijo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoEstadoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoEstadoActivoFijo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoEstadoActivoFijo> entities = new  ArrayList<TipoEstadoActivoFijo>();
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		  
		
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
	
	public  List<TipoEstadoActivoFijo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoEstadoActivoFijo> entities = new  ArrayList<TipoEstadoActivoFijo>();
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoEstadoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEstadoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoEstadoActivoFijo("",entity,resultSet);
      	    	
				//entity.setTipoEstadoActivoFijoOriginal( new TipoEstadoActivoFijo());
      	    	//entity.setTipoEstadoActivoFijoOriginal(super.getEntity("",entity.getTipoEstadoActivoFijoOriginal(),resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEstadoActivoFijoOriginal(this.getEntityTipoEstadoActivoFijo("",entity.getTipoEstadoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoEstadoActivoFijos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEstadoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoEstadoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoEstadoActivoFijo> entities = new  ArrayList<TipoEstadoActivoFijo>();
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		  
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
	
	public  List<TipoEstadoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoEstadoActivoFijo> entities = new  ArrayList<TipoEstadoActivoFijo>();
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEstadoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoEstadoActivoFijo();
					//entity.setMapTipoEstadoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoEstadoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoEstadoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=TipoEstadoActivoFijoDataAccess.getEntityTipoEstadoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoEstadoActivoFijoOriginal( new TipoEstadoActivoFijo());
					////entity.setTipoEstadoActivoFijoOriginal(super.getEntity("",entity.getTipoEstadoActivoFijoOriginal(),resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoEstadoActivoFijoOriginal(this.getEntityTipoEstadoActivoFijo("",entity.getTipoEstadoActivoFijoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoEstadoActivoFijos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEstadoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoEstadoActivoFijo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		  
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
	
	public  TipoEstadoActivoFijo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEstadoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoEstadoActivoFijo();
					//entity.setMapTipoEstadoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoEstadoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoEstadoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=TipoEstadoActivoFijoDataAccess.getEntityTipoEstadoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoEstadoActivoFijoOriginal( new TipoEstadoActivoFijo());
					////entity.setTipoEstadoActivoFijoOriginal(super.getEntity("",entity.getTipoEstadoActivoFijoOriginal(),resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoEstadoActivoFijoOriginal(this.getEntityTipoEstadoActivoFijo("",entity.getTipoEstadoActivoFijoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoEstadoActivoFijo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEstadoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoEstadoActivoFijo getEntityTipoEstadoActivoFijo(String strPrefijo,TipoEstadoActivoFijo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoEstadoActivoFijo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoEstadoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoEstadoActivoFijoDataAccess.setFieldReflectionTipoEstadoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoEstadoActivoFijo=TipoEstadoActivoFijoConstantesFunciones.getTodosTiposColumnasTipoEstadoActivoFijo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoEstadoActivoFijo) {
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
							field = TipoEstadoActivoFijo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoEstadoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoEstadoActivoFijoDataAccess.setFieldReflectionTipoEstadoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoEstadoActivoFijo(Field field,String strPrefijo,String sColumn,TipoEstadoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoEstadoActivoFijoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoEstadoActivoFijoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoEstadoActivoFijoConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoEstadoActivoFijoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoEstadoActivoFijo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoEstadoActivoFijo> entities = new  ArrayList<TipoEstadoActivoFijo>();
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoEstadoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoEstadoActivoFijo();
					entity=super.getEntity("",entity,resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoEstadoActivoFijo("",entity,resultSet);
					
					//entity.setTipoEstadoActivoFijoOriginal( new TipoEstadoActivoFijo());
					//entity.setTipoEstadoActivoFijoOriginal(super.getEntity("",entity.getTipoEstadoActivoFijoOriginal(),resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoEstadoActivoFijoOriginal(this.getEntityTipoEstadoActivoFijo("",entity.getTipoEstadoActivoFijoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoEstadoActivoFijos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEstadoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoEstadoActivoFijo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoEstadoActivoFijo> entities = new  ArrayList<TipoEstadoActivoFijo>();
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoEstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoEstadoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoEstadoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoEstadoActivoFijo> entities = new  ArrayList<TipoEstadoActivoFijo>();
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		  
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
	
	public  List<TipoEstadoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoEstadoActivoFijo> entities = new  ArrayList<TipoEstadoActivoFijo>();
		TipoEstadoActivoFijo entity = new TipoEstadoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEstadoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoEstadoActivoFijo("",entity,resultSet);
      	    	
				//entity.setTipoEstadoActivoFijoOriginal( new TipoEstadoActivoFijo());
      	    	//entity.setTipoEstadoActivoFijoOriginal(super.getEntity("",entity.getTipoEstadoActivoFijoOriginal(),resultSet,TipoEstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEstadoActivoFijoOriginal(this.getEntityTipoEstadoActivoFijo("",entity.getTipoEstadoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoEstadoActivoFijos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEstadoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoEstadoActivoFijo getEntityTipoEstadoActivoFijo(String strPrefijo,TipoEstadoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pais(resultSet.getLong(strPrefijo+TipoEstadoActivoFijoConstantesFunciones.IDPAIS));
				entity.setnombre(resultSet.getString(strPrefijo+TipoEstadoActivoFijoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoEstadoActivoFijoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoEstadoActivoFijo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoEstadoActivoFijo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoEstadoActivoFijoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoEstadoActivoFijoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoEstadoActivoFijoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoEstadoActivoFijoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoEstadoActivoFijoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoEstadoActivoFijoDataAccess.TABLENAME,TipoEstadoActivoFijoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoEstadoActivoFijoDataAccess.setTipoEstadoActivoFijoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Pais getPais(Connexion connexion,TipoEstadoActivoFijo reltipoestadoactivofijo)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,reltipoestadoactivofijo.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoEstadoActivoFijo tipoestadoactivofijo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoestadoactivofijo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoestadoactivofijo.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(tipoestadoactivofijo.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoestadoactivofijo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoestadoactivofijo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoestadoactivofijo.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoestadoactivofijo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoestadoactivofijo.getId());
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
	
	public void setIsNewIsChangedFalseTipoEstadoActivoFijo(TipoEstadoActivoFijo tipoestadoactivofijo)throws Exception  {		
		tipoestadoactivofijo.setIsNew(false);
		tipoestadoactivofijo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoEstadoActivoFijos(List<TipoEstadoActivoFijo> tipoestadoactivofijos)throws Exception  {				
		for(TipoEstadoActivoFijo tipoestadoactivofijo:tipoestadoactivofijos) {
			tipoestadoactivofijo.setIsNew(false);
			tipoestadoactivofijo.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoEstadoActivoFijo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
