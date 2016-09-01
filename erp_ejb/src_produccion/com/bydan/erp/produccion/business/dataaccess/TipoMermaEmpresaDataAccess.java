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
package com.bydan.erp.produccion.business.dataaccess;

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

import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.produccion.util.*;//TipoMermaEmpresaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoMermaEmpresaDataAccess extends  TipoMermaEmpresaDataAccessAdditional{ //TipoMermaEmpresaDataAccessAdditional,DataAccessHelper<TipoMermaEmpresa>
	//static Logger logger = Logger.getLogger(TipoMermaEmpresaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_merma_empresa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,descripcion)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipomermaempresa from "+TipoMermaEmpresaConstantesFunciones.SPERSISTENCENAME+" tipomermaempresa";
	public static String QUERYSELECTNATIVE="select "+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".id,"+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".descripcion from "+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoMermaEmpresaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".id,"+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".nombre from "+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoMermaEmpresaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOMERMAEMPRESA_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOMERMAEMPRESA_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOMERMAEMPRESA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOMERMAEMPRESA_SELECT(?,?)";
	
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
	
	
	protected TipoMermaEmpresaDataAccessAdditional tipomermaempresaDataAccessAdditional=null;
	
	public TipoMermaEmpresaDataAccessAdditional getTipoMermaEmpresaDataAccessAdditional() {
		return this.tipomermaempresaDataAccessAdditional;
	}
	
	public void setTipoMermaEmpresaDataAccessAdditional(TipoMermaEmpresaDataAccessAdditional tipomermaempresaDataAccessAdditional) {
		try {
			this.tipomermaempresaDataAccessAdditional=tipomermaempresaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoMermaEmpresaDataAccess() {
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
		TipoMermaEmpresaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoMermaEmpresaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoMermaEmpresaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoMermaEmpresaOriginal(TipoMermaEmpresa tipomermaempresa)throws Exception  {
		tipomermaempresa.setTipoMermaEmpresaOriginal((TipoMermaEmpresa)tipomermaempresa.clone());		
	}
	
	public void setTipoMermaEmpresasOriginal(List<TipoMermaEmpresa> tipomermaempresas)throws Exception  {
		
		for(TipoMermaEmpresa tipomermaempresa:tipomermaempresas){
			tipomermaempresa.setTipoMermaEmpresaOriginal((TipoMermaEmpresa)tipomermaempresa.clone());
		}
	}
	
	public static void setTipoMermaEmpresaOriginalStatic(TipoMermaEmpresa tipomermaempresa)throws Exception  {
		tipomermaempresa.setTipoMermaEmpresaOriginal((TipoMermaEmpresa)tipomermaempresa.clone());		
	}
	
	public static void setTipoMermaEmpresasOriginalStatic(List<TipoMermaEmpresa> tipomermaempresas)throws Exception  {
		
		for(TipoMermaEmpresa tipomermaempresa:tipomermaempresas){
			tipomermaempresa.setTipoMermaEmpresaOriginal((TipoMermaEmpresa)tipomermaempresa.clone());
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
	
	public  TipoMermaEmpresa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		
		
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
	
	public  TipoMermaEmpresa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.TipoMermaEmpresa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoMermaEmpresaOriginal(new TipoMermaEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMermaEmpresa("",entity,resultSet); 
				
				//entity.setTipoMermaEmpresaOriginal(super.getEntity("",entity.getTipoMermaEmpresaOriginal(),resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMermaEmpresaOriginal(this.getEntityTipoMermaEmpresa("",entity.getTipoMermaEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMermaEmpresa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoMermaEmpresa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMermaEmpresa entity = new TipoMermaEmpresa();
				
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
	
	public  TipoMermaEmpresa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMermaEmpresa entity = new TipoMermaEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMermaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoMermaEmpresa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoMermaEmpresaOriginal(new TipoMermaEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMermaEmpresa("",entity,resultSet);    
				
				//entity.setTipoMermaEmpresaOriginal(super.getEntity("",entity.getTipoMermaEmpresaOriginal(),resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMermaEmpresaOriginal(this.getEntityTipoMermaEmpresa("",entity.getTipoMermaEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMermaEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoMermaEmpresa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoMermaEmpresa entity = new TipoMermaEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMermaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoMermaEmpresa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoMermaEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoMermaEmpresa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMermaEmpresa> entities = new  ArrayList<TipoMermaEmpresa>();
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
		
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
	
	public  List<TipoMermaEmpresa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMermaEmpresa> entities = new  ArrayList<TipoMermaEmpresa>();
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMermaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMermaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMermaEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoMermaEmpresaOriginal( new TipoMermaEmpresa());
      	    	//entity.setTipoMermaEmpresaOriginal(super.getEntity("",entity.getTipoMermaEmpresaOriginal(),resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMermaEmpresaOriginal(this.getEntityTipoMermaEmpresa("",entity.getTipoMermaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMermaEmpresas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMermaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoMermaEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMermaEmpresa> entities = new  ArrayList<TipoMermaEmpresa>();
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
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
	
	public  List<TipoMermaEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMermaEmpresa> entities = new  ArrayList<TipoMermaEmpresa>();
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMermaEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMermaEmpresa();
					//entity.setMapTipoMermaEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoMermaEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMermaEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoMermaEmpresaDataAccess.getEntityTipoMermaEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMermaEmpresaOriginal( new TipoMermaEmpresa());
					////entity.setTipoMermaEmpresaOriginal(super.getEntity("",entity.getTipoMermaEmpresaOriginal(),resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMermaEmpresaOriginal(this.getEntityTipoMermaEmpresa("",entity.getTipoMermaEmpresaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMermaEmpresas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMermaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoMermaEmpresa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
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
	
	public  TipoMermaEmpresa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMermaEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMermaEmpresa();
					//entity.setMapTipoMermaEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoMermaEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMermaEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoMermaEmpresaDataAccess.getEntityTipoMermaEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMermaEmpresaOriginal( new TipoMermaEmpresa());
					////entity.setTipoMermaEmpresaOriginal(super.getEntity("",entity.getTipoMermaEmpresaOriginal(),resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMermaEmpresaOriginal(this.getEntityTipoMermaEmpresa("",entity.getTipoMermaEmpresaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoMermaEmpresa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMermaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoMermaEmpresa getEntityTipoMermaEmpresa(String strPrefijo,TipoMermaEmpresa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoMermaEmpresa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoMermaEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoMermaEmpresaDataAccess.setFieldReflectionTipoMermaEmpresa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoMermaEmpresa=TipoMermaEmpresaConstantesFunciones.getTodosTiposColumnasTipoMermaEmpresa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoMermaEmpresa) {
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
							field = TipoMermaEmpresa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoMermaEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoMermaEmpresaDataAccess.setFieldReflectionTipoMermaEmpresa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoMermaEmpresa(Field field,String strPrefijo,String sColumn,TipoMermaEmpresa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoMermaEmpresaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMermaEmpresaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMermaEmpresaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMermaEmpresaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMermaEmpresaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMermaEmpresa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoMermaEmpresa> entities = new  ArrayList<TipoMermaEmpresa>();
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMermaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoMermaEmpresa();
					entity=super.getEntity("",entity,resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoMermaEmpresa("",entity,resultSet);
					
					//entity.setTipoMermaEmpresaOriginal( new TipoMermaEmpresa());
					//entity.setTipoMermaEmpresaOriginal(super.getEntity("",entity.getTipoMermaEmpresaOriginal(),resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoMermaEmpresaOriginal(this.getEntityTipoMermaEmpresa("",entity.getTipoMermaEmpresaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoMermaEmpresas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMermaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMermaEmpresa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoMermaEmpresa> entities = new  ArrayList<TipoMermaEmpresa>();
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMermaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMermaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoMermaEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMermaEmpresa> entities = new  ArrayList<TipoMermaEmpresa>();
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
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
	
	public  List<TipoMermaEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMermaEmpresa> entities = new  ArrayList<TipoMermaEmpresa>();
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMermaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMermaEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoMermaEmpresaOriginal( new TipoMermaEmpresa());
      	    	//entity.setTipoMermaEmpresaOriginal(super.getEntity("",entity.getTipoMermaEmpresaOriginal(),resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMermaEmpresaOriginal(this.getEntityTipoMermaEmpresa("",entity.getTipoMermaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoMermaEmpresas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMermaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoMermaEmpresa> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMermaEmpresa> entities = new  ArrayList<TipoMermaEmpresa>();
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
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
	
	public  List<TipoMermaEmpresa> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMermaEmpresa> entities = new  ArrayList<TipoMermaEmpresa>();
		TipoMermaEmpresa entity = new TipoMermaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMermaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMermaEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoMermaEmpresaOriginal( new TipoMermaEmpresa());
      	    	//entity.setTipoMermaEmpresaOriginal(super.getEntity("",entity.getTipoMermaEmpresaOriginal(),resultSet,TipoMermaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMermaEmpresaOriginal(this.getEntityTipoMermaEmpresa("",entity.getTipoMermaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMermaEmpresas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoMermaEmpresa getEntityTipoMermaEmpresa(String strPrefijo,TipoMermaEmpresa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoMermaEmpresaConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+TipoMermaEmpresaConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoMermaEmpresaConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoMermaEmpresaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoMermaEmpresa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoMermaEmpresa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoMermaEmpresaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoMermaEmpresaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoMermaEmpresaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoMermaEmpresaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoMermaEmpresaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoMermaEmpresaDataAccess.TABLENAME,TipoMermaEmpresaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoMermaEmpresaDataAccess.setTipoMermaEmpresaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoMermaEmpresa reltipomermaempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipomermaempresa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<ProductoOrdenDetaProduMerma> getProductoOrdenDetaProduMermas(Connexion connexion,TipoMermaEmpresa tipomermaempresa)throws SQLException,Exception {

		List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas= new ArrayList<ProductoOrdenDetaProduMerma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMermaEmpresaConstantesFunciones.SCHEMA+".tipo_merma_empresa ON "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+".producto_orden_deta_produ_merma.id_tipo_merma_empresa="+TipoMermaEmpresaConstantesFunciones.SCHEMA+".tipo_merma_empresa.id WHERE "+TipoMermaEmpresaConstantesFunciones.SCHEMA+".tipo_merma_empresa.id="+String.valueOf(tipomermaempresa.getId());
			} else {
				sQuery=" INNER JOIN productoordendetaprodumerma.TipoMermaEmpresa WHERE productoordendetaprodumerma.TipoMermaEmpresa.id="+String.valueOf(tipomermaempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoOrdenDetaProduMermaDataAccess productoordendetaprodumermaDataAccess=new ProductoOrdenDetaProduMermaDataAccess();

			productoordendetaprodumermaDataAccess.setConnexionType(this.connexionType);
			productoordendetaprodumermaDataAccess.setParameterDbType(this.parameterDbType);
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoordendetaprodumermas;

	}

	public List<ProductoProduMerma> getProductoProduMermas(Connexion connexion,TipoMermaEmpresa tipomermaempresa)throws SQLException,Exception {

		List<ProductoProduMerma> productoprodumermas= new ArrayList<ProductoProduMerma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMermaEmpresaConstantesFunciones.SCHEMA+".tipo_merma_empresa ON "+ProductoProduMermaConstantesFunciones.SCHEMA+".producto_produ_merma.id_tipo_merma_empresa="+TipoMermaEmpresaConstantesFunciones.SCHEMA+".tipo_merma_empresa.id WHERE "+TipoMermaEmpresaConstantesFunciones.SCHEMA+".tipo_merma_empresa.id="+String.valueOf(tipomermaempresa.getId());
			} else {
				sQuery=" INNER JOIN productoprodumerma.TipoMermaEmpresa WHERE productoprodumerma.TipoMermaEmpresa.id="+String.valueOf(tipomermaempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProduMermaDataAccess productoprodumermaDataAccess=new ProductoProduMermaDataAccess();

			productoprodumermaDataAccess.setConnexionType(this.connexionType);
			productoprodumermaDataAccess.setParameterDbType(this.parameterDbType);
			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoprodumermas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoMermaEmpresa tipomermaempresa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipomermaempresa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipomermaempresa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipomermaempresa.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipomermaempresa.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipomermaempresa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipomermaempresa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipomermaempresa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipomermaempresa.getId());
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
	
	public void setIsNewIsChangedFalseTipoMermaEmpresa(TipoMermaEmpresa tipomermaempresa)throws Exception  {		
		tipomermaempresa.setIsNew(false);
		tipomermaempresa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoMermaEmpresas(List<TipoMermaEmpresa> tipomermaempresas)throws Exception  {				
		for(TipoMermaEmpresa tipomermaempresa:tipomermaempresas) {
			tipomermaempresa.setIsNew(false);
			tipomermaempresa.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoMermaEmpresa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
