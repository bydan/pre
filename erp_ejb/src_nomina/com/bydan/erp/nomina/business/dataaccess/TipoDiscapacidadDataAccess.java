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
import com.bydan.erp.nomina.util.*;//TipoDiscapacidadConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoDiscapacidadDataAccess extends  DataAccessHelper<TipoDiscapacidad>{ //TipoDiscapacidadDataAccessAdditional,DataAccessHelper<TipoDiscapacidad>
	//static Logger logger = Logger.getLogger(TipoDiscapacidadDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_discapacidad";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,porcentaje_inicial,porcentaje_final)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,porcentaje_inicial=?,porcentaje_final=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipodiscapacidad from "+TipoDiscapacidadConstantesFunciones.SPERSISTENCENAME+" tipodiscapacidad";
	public static String QUERYSELECTNATIVE="select "+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".id,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".version_row,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".id_empresa,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".nombre,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".porcentaje_inicial,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".porcentaje_final from "+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME;//+" as "+TipoDiscapacidadConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".id,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".version_row,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".nombre from "+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME;//+" as "+TipoDiscapacidadConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,porcentaje_inicial=?,porcentaje_final=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPODISCAPACIDAD_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPODISCAPACIDAD_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPODISCAPACIDAD_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPODISCAPACIDAD_SELECT(?,?)";
	
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
	
	
	public TipoDiscapacidadDataAccess() {
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
		TipoDiscapacidadDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoDiscapacidadDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoDiscapacidadDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoDiscapacidadOriginal(TipoDiscapacidad tipodiscapacidad)throws Exception  {
		tipodiscapacidad.setTipoDiscapacidadOriginal((TipoDiscapacidad)tipodiscapacidad.clone());		
	}
	
	public void setTipoDiscapacidadsOriginal(List<TipoDiscapacidad> tipodiscapacidads)throws Exception  {
		
		for(TipoDiscapacidad tipodiscapacidad:tipodiscapacidads){
			tipodiscapacidad.setTipoDiscapacidadOriginal((TipoDiscapacidad)tipodiscapacidad.clone());
		}
	}
	
	public static void setTipoDiscapacidadOriginalStatic(TipoDiscapacidad tipodiscapacidad)throws Exception  {
		tipodiscapacidad.setTipoDiscapacidadOriginal((TipoDiscapacidad)tipodiscapacidad.clone());		
	}
	
	public static void setTipoDiscapacidadsOriginalStatic(List<TipoDiscapacidad> tipodiscapacidads)throws Exception  {
		
		for(TipoDiscapacidad tipodiscapacidad:tipodiscapacidads){
			tipodiscapacidad.setTipoDiscapacidadOriginal((TipoDiscapacidad)tipodiscapacidad.clone());
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
	
	public  TipoDiscapacidad getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDiscapacidad entity = new TipoDiscapacidad();		
		
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
	
	public  TipoDiscapacidad getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDiscapacidad entity = new TipoDiscapacidad();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.TipoDiscapacidad.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoDiscapacidadOriginal(new TipoDiscapacidad());
      	    	entity=super.getEntity("",entity,resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDiscapacidad("",entity,resultSet); 
				
				//entity.setTipoDiscapacidadOriginal(super.getEntity("",entity.getTipoDiscapacidadOriginal(),resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDiscapacidadOriginal(this.getEntityTipoDiscapacidad("",entity.getTipoDiscapacidadOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDiscapacidad(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoDiscapacidad getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDiscapacidad entity = new TipoDiscapacidad();
				
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
	
	public  TipoDiscapacidad getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDiscapacidad entity = new TipoDiscapacidad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDiscapacidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoDiscapacidad.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoDiscapacidadOriginal(new TipoDiscapacidad());
      	    	entity=super.getEntity("",entity,resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDiscapacidad("",entity,resultSet);    
				
				//entity.setTipoDiscapacidadOriginal(super.getEntity("",entity.getTipoDiscapacidadOriginal(),resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDiscapacidadOriginal(this.getEntityTipoDiscapacidad("",entity.getTipoDiscapacidadOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDiscapacidad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoDiscapacidad
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoDiscapacidad entity = new TipoDiscapacidad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDiscapacidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoDiscapacidad.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoDiscapacidad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoDiscapacidad> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDiscapacidad> entities = new  ArrayList<TipoDiscapacidad>();
		TipoDiscapacidad entity = new TipoDiscapacidad();		  
		
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
	
	public  List<TipoDiscapacidad> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDiscapacidad> entities = new  ArrayList<TipoDiscapacidad>();
		TipoDiscapacidad entity = new TipoDiscapacidad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDiscapacidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDiscapacidad();
      	    	entity=super.getEntity("",entity,resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDiscapacidad("",entity,resultSet);
      	    	
				//entity.setTipoDiscapacidadOriginal( new TipoDiscapacidad());
      	    	//entity.setTipoDiscapacidadOriginal(super.getEntity("",entity.getTipoDiscapacidadOriginal(),resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDiscapacidadOriginal(this.getEntityTipoDiscapacidad("",entity.getTipoDiscapacidadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDiscapacidads(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDiscapacidad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDiscapacidad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDiscapacidad> entities = new  ArrayList<TipoDiscapacidad>();
		TipoDiscapacidad entity = new TipoDiscapacidad();		  
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
	
	public  List<TipoDiscapacidad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDiscapacidad> entities = new  ArrayList<TipoDiscapacidad>();
		TipoDiscapacidad entity = new TipoDiscapacidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDiscapacidad();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDiscapacidad();
					//entity.setMapTipoDiscapacidad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoDiscapacidadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDiscapacidad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA);         		
					entity=TipoDiscapacidadDataAccess.getEntityTipoDiscapacidad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDiscapacidadOriginal( new TipoDiscapacidad());
					////entity.setTipoDiscapacidadOriginal(super.getEntity("",entity.getTipoDiscapacidadOriginal(),resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDiscapacidadOriginal(this.getEntityTipoDiscapacidad("",entity.getTipoDiscapacidadOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDiscapacidads(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDiscapacidad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoDiscapacidad getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDiscapacidad entity = new TipoDiscapacidad();		  
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
	
	public  TipoDiscapacidad getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDiscapacidad entity = new TipoDiscapacidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDiscapacidad();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDiscapacidad();
					//entity.setMapTipoDiscapacidad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoDiscapacidadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDiscapacidad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA);         		
					entity=TipoDiscapacidadDataAccess.getEntityTipoDiscapacidad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDiscapacidadOriginal( new TipoDiscapacidad());
					////entity.setTipoDiscapacidadOriginal(super.getEntity("",entity.getTipoDiscapacidadOriginal(),resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDiscapacidadOriginal(this.getEntityTipoDiscapacidad("",entity.getTipoDiscapacidadOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoDiscapacidad(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDiscapacidad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoDiscapacidad getEntityTipoDiscapacidad(String strPrefijo,TipoDiscapacidad entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoDiscapacidad.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoDiscapacidad.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoDiscapacidadDataAccess.setFieldReflectionTipoDiscapacidad(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoDiscapacidad=TipoDiscapacidadConstantesFunciones.getTodosTiposColumnasTipoDiscapacidad();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoDiscapacidad) {
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
							field = TipoDiscapacidad.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoDiscapacidad.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoDiscapacidadDataAccess.setFieldReflectionTipoDiscapacidad(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoDiscapacidad(Field field,String strPrefijo,String sColumn,TipoDiscapacidad entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoDiscapacidadConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDiscapacidadConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDiscapacidadConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDiscapacidadConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDiscapacidadConstantesFunciones.PORCENTAJEINICIAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoDiscapacidadConstantesFunciones.PORCENTAJEFINAL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDiscapacidad>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoDiscapacidad> entities = new  ArrayList<TipoDiscapacidad>();
		TipoDiscapacidad entity = new TipoDiscapacidad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDiscapacidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoDiscapacidad();
					entity=super.getEntity("",entity,resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoDiscapacidad("",entity,resultSet);
					
					//entity.setTipoDiscapacidadOriginal( new TipoDiscapacidad());
					//entity.setTipoDiscapacidadOriginal(super.getEntity("",entity.getTipoDiscapacidadOriginal(),resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoDiscapacidadOriginal(this.getEntityTipoDiscapacidad("",entity.getTipoDiscapacidadOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoDiscapacidads(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDiscapacidad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDiscapacidad>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoDiscapacidad> entities = new  ArrayList<TipoDiscapacidad>();
		TipoDiscapacidad entity = new TipoDiscapacidad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDiscapacidadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDiscapacidadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoDiscapacidad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDiscapacidad> entities = new  ArrayList<TipoDiscapacidad>();
		TipoDiscapacidad entity = new TipoDiscapacidad();		  
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
	
	public  List<TipoDiscapacidad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDiscapacidad> entities = new  ArrayList<TipoDiscapacidad>();
		TipoDiscapacidad entity = new TipoDiscapacidad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDiscapacidad();
      	    	entity=super.getEntity("",entity,resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDiscapacidad("",entity,resultSet);
      	    	
				//entity.setTipoDiscapacidadOriginal( new TipoDiscapacidad());
      	    	//entity.setTipoDiscapacidadOriginal(super.getEntity("",entity.getTipoDiscapacidadOriginal(),resultSet,TipoDiscapacidadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDiscapacidadOriginal(this.getEntityTipoDiscapacidad("",entity.getTipoDiscapacidadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoDiscapacidads(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDiscapacidad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoDiscapacidad getEntityTipoDiscapacidad(String strPrefijo,TipoDiscapacidad entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoDiscapacidadConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+TipoDiscapacidadConstantesFunciones.NOMBRE));
				entity.setporcentaje_inicial(resultSet.getDouble(strPrefijo+TipoDiscapacidadConstantesFunciones.PORCENTAJEINICIAL));
				entity.setporcentaje_final(resultSet.getDouble(strPrefijo+TipoDiscapacidadConstantesFunciones.PORCENTAJEFINAL));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoDiscapacidadConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoDiscapacidad(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoDiscapacidad entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoDiscapacidadDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoDiscapacidadDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoDiscapacidadDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoDiscapacidadDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoDiscapacidadConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoDiscapacidadDataAccess.TABLENAME,TipoDiscapacidadDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoDiscapacidadDataAccess.setTipoDiscapacidadOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoDiscapacidad reltipodiscapacidad)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipodiscapacidad.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<EmpleadoDisca> getEmpleadoDiscas(Connexion connexion,TipoDiscapacidad tipodiscapacidad)throws SQLException,Exception {

		List<EmpleadoDisca> empleadodiscas= new ArrayList<EmpleadoDisca>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDiscapacidadConstantesFunciones.SCHEMA+".tipo_discapacidad ON "+EmpleadoDiscaConstantesFunciones.SCHEMA+".empleado_disca.id_tipo_discapacidad="+TipoDiscapacidadConstantesFunciones.SCHEMA+".tipo_discapacidad.id WHERE "+TipoDiscapacidadConstantesFunciones.SCHEMA+".tipo_discapacidad.id="+String.valueOf(tipodiscapacidad.getId());
			} else {
				sQuery=" INNER JOIN empleadodisca.TipoDiscapacidad WHERE empleadodisca.TipoDiscapacidad.id="+String.valueOf(tipodiscapacidad.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoDiscaDataAccess empleadodiscaDataAccess=new EmpleadoDiscaDataAccess();

			empleadodiscaDataAccess.setConnexionType(this.connexionType);
			empleadodiscaDataAccess.setParameterDbType(this.parameterDbType);
			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadodiscas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoDiscapacidad tipodiscapacidad) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipodiscapacidad.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipodiscapacidad.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipodiscapacidad.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_inicial=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_inicial.setValue(tipodiscapacidad.getporcentaje_inicial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_inicial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_final=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_final.setValue(tipodiscapacidad.getporcentaje_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_final);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipodiscapacidad.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipodiscapacidad.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipodiscapacidad.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipodiscapacidad.getId());
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
	
	public void setIsNewIsChangedFalseTipoDiscapacidad(TipoDiscapacidad tipodiscapacidad)throws Exception  {		
		tipodiscapacidad.setIsNew(false);
		tipodiscapacidad.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoDiscapacidads(List<TipoDiscapacidad> tipodiscapacidads)throws Exception  {				
		for(TipoDiscapacidad tipodiscapacidad:tipodiscapacidads) {
			tipodiscapacidad.setIsNew(false);
			tipodiscapacidad.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoDiscapacidad(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
