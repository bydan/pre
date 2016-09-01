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
import com.bydan.erp.seguridad.util.*;//ProvinciaConstantesFunciones;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;




@SuppressWarnings("unused")
final public class ProvinciaDataAccess extends  ProvinciaDataAccessAdditional{ //ProvinciaDataAccessAdditional,DataAccessHelper<Provincia>
	//static Logger logger = Logger.getLogger(ProvinciaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="provincia";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+"(version_row,id_pais,id_region,codigo,nombre)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,id_region=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select provincia from "+ProvinciaConstantesFunciones.SPERSISTENCENAME+" provincia";
	public static String QUERYSELECTNATIVE="select "+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".id,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".version_row,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".id_pais,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".id_region,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".codigo,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".nombre from "+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME;//+" as "+ProvinciaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".id,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".version_row,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".nombre from "+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME;//+" as "+ProvinciaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,id_region=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PROVINCIA_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PROVINCIA_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PROVINCIA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PROVINCIA_SELECT(?,?)";
	
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
	
	
	protected ProvinciaDataAccessAdditional provinciaDataAccessAdditional=null;
	
	public ProvinciaDataAccessAdditional getProvinciaDataAccessAdditional() {
		return this.provinciaDataAccessAdditional;
	}
	
	public void setProvinciaDataAccessAdditional(ProvinciaDataAccessAdditional provinciaDataAccessAdditional) {
		try {
			this.provinciaDataAccessAdditional=provinciaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProvinciaDataAccess() {
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
		ProvinciaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProvinciaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProvinciaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProvinciaOriginal(Provincia provincia)throws Exception  {
		provincia.setProvinciaOriginal((Provincia)provincia.clone());		
	}
	
	public void setProvinciasOriginal(List<Provincia> provincias)throws Exception  {
		
		for(Provincia provincia:provincias){
			provincia.setProvinciaOriginal((Provincia)provincia.clone());
		}
	}
	
	public static void setProvinciaOriginalStatic(Provincia provincia)throws Exception  {
		provincia.setProvinciaOriginal((Provincia)provincia.clone());		
	}
	
	public static void setProvinciasOriginalStatic(List<Provincia> provincias)throws Exception  {
		
		for(Provincia provincia:provincias){
			provincia.setProvinciaOriginal((Provincia)provincia.clone());
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
	
	public  Provincia getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Provincia entity = new Provincia();		
		
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
	
	public  Provincia getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Provincia entity = new Provincia();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.Provincia.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProvinciaOriginal(new Provincia());
      	    	entity=super.getEntity("",entity,resultSet,ProvinciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProvincia("",entity,resultSet); 
				
				//entity.setProvinciaOriginal(super.getEntity("",entity.getProvinciaOriginal(),resultSet,ProvinciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProvinciaOriginal(this.getEntityProvincia("",entity.getProvinciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProvincia(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Provincia getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Provincia entity = new Provincia();
				
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
	
	public  Provincia getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Provincia entity = new Provincia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProvinciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Provincia.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProvinciaOriginal(new Provincia());
      	    	entity=super.getEntity("",entity,resultSet,ProvinciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProvincia("",entity,resultSet);    
				
				//entity.setProvinciaOriginal(super.getEntity("",entity.getProvinciaOriginal(),resultSet,ProvinciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProvinciaOriginal(this.getEntityProvincia("",entity.getProvinciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProvincia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Provincia
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Provincia entity = new Provincia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProvinciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Provincia.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProvincia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Provincia> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Provincia> entities = new  ArrayList<Provincia>();
		Provincia entity = new Provincia();		  
		
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
	
	public  List<Provincia> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Provincia> entities = new  ArrayList<Provincia>();
		Provincia entity = new Provincia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProvinciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Provincia();
      	    	entity=super.getEntity("",entity,resultSet,ProvinciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProvincia("",entity,resultSet);
      	    	
				//entity.setProvinciaOriginal( new Provincia());
      	    	//entity.setProvinciaOriginal(super.getEntity("",entity.getProvinciaOriginal(),resultSet,ProvinciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProvinciaOriginal(this.getEntityProvincia("",entity.getProvinciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProvincias(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProvincia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Provincia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Provincia> entities = new  ArrayList<Provincia>();
		Provincia entity = new Provincia();		  
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
	
	public  List<Provincia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Provincia> entities = new  ArrayList<Provincia>();
		Provincia entity = new Provincia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Provincia();
				
				if(conMapGenerico) {
					entity.inicializarMapProvincia();
					//entity.setMapProvincia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProvinciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProvincia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProvinciaDataAccess.ISWITHSCHEMA);         		
					entity=ProvinciaDataAccess.getEntityProvincia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProvinciaOriginal( new Provincia());
					////entity.setProvinciaOriginal(super.getEntity("",entity.getProvinciaOriginal(),resultSet,ProvinciaDataAccess.ISWITHSCHEMA));         		
					////entity.setProvinciaOriginal(this.getEntityProvincia("",entity.getProvinciaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProvincias(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProvincia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Provincia getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Provincia entity = new Provincia();		  
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
	
	public  Provincia getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Provincia entity = new Provincia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Provincia();
				
				if(conMapGenerico) {
					entity.inicializarMapProvincia();
					//entity.setMapProvincia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProvinciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProvincia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProvinciaDataAccess.ISWITHSCHEMA);         		
					entity=ProvinciaDataAccess.getEntityProvincia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProvinciaOriginal( new Provincia());
					////entity.setProvinciaOriginal(super.getEntity("",entity.getProvinciaOriginal(),resultSet,ProvinciaDataAccess.ISWITHSCHEMA));         		
					////entity.setProvinciaOriginal(this.getEntityProvincia("",entity.getProvinciaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProvincia(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProvincia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Provincia getEntityProvincia(String strPrefijo,Provincia entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Provincia.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Provincia.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProvinciaDataAccess.setFieldReflectionProvincia(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProvincia=ProvinciaConstantesFunciones.getTodosTiposColumnasProvincia();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProvincia) {
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
							field = Provincia.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Provincia.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProvinciaDataAccess.setFieldReflectionProvincia(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProvincia(Field field,String strPrefijo,String sColumn,Provincia entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProvinciaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProvinciaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProvinciaConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProvinciaConstantesFunciones.IDREGION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProvinciaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProvinciaConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Provincia>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Provincia> entities = new  ArrayList<Provincia>();
		Provincia entity = new Provincia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProvinciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Provincia();
					entity=super.getEntity("",entity,resultSet,ProvinciaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProvincia("",entity,resultSet);
					
					//entity.setProvinciaOriginal( new Provincia());
					//entity.setProvinciaOriginal(super.getEntity("",entity.getProvinciaOriginal(),resultSet,ProvinciaDataAccess.ISWITHSCHEMA));         		
					//entity.setProvinciaOriginal(this.getEntityProvincia("",entity.getProvinciaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProvincias(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProvincia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Provincia>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Provincia> entities = new  ArrayList<Provincia>();
		Provincia entity = new Provincia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProvinciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProvinciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Provincia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Provincia> entities = new  ArrayList<Provincia>();
		Provincia entity = new Provincia();		  
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
	
	public  List<Provincia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Provincia> entities = new  ArrayList<Provincia>();
		Provincia entity = new Provincia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Provincia();
      	    	entity=super.getEntity("",entity,resultSet,ProvinciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProvincia("",entity,resultSet);
      	    	
				//entity.setProvinciaOriginal( new Provincia());
      	    	//entity.setProvinciaOriginal(super.getEntity("",entity.getProvinciaOriginal(),resultSet,ProvinciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProvinciaOriginal(this.getEntityProvincia("",entity.getProvinciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProvincias(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProvincia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Provincia> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Provincia> entities = new  ArrayList<Provincia>();
		Provincia entity = new Provincia();		  
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
	
	public  List<Provincia> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Provincia> entities = new  ArrayList<Provincia>();
		Provincia entity = new Provincia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Provincia();
      	    	entity=super.getEntity("",entity,resultSet,ProvinciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProvincia("",entity,resultSet);
      	    	
				//entity.setProvinciaOriginal( new Provincia());
      	    	//entity.setProvinciaOriginal(super.getEntity("",entity.getProvinciaOriginal(),resultSet,ProvinciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProvinciaOriginal(this.getEntityProvincia("",entity.getProvinciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProvincias(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Provincia getEntityProvincia(String strPrefijo,Provincia entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pais(resultSet.getLong(strPrefijo+ProvinciaConstantesFunciones.IDPAIS));
				entity.setid_region(resultSet.getLong(strPrefijo+ProvinciaConstantesFunciones.IDREGION));
				entity.setcodigo(resultSet.getString(strPrefijo+ProvinciaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+ProvinciaConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+ProvinciaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProvincia(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Provincia entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProvinciaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProvinciaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProvinciaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProvinciaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProvinciaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProvinciaDataAccess.TABLENAME,ProvinciaDataAccess.ISWITHSTOREPROCEDURES);
			
			ProvinciaDataAccess.setProvinciaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Pais getPais(Connexion connexion,Provincia relprovincia)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relprovincia.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Region getRegion(Connexion connexion,Provincia relprovincia)throws SQLException,Exception {

		Region region= new Region();

		try {
			RegionDataAccess regionDataAccess=new RegionDataAccess();

			regionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			regionDataAccess.setConnexionType(this.connexionType);
			regionDataAccess.setParameterDbType(this.parameterDbType);

			region=regionDataAccess.getEntity(connexion,relprovincia.getid_region());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return region;

	}


		
		public List<Barrio> getBarrios(Connexion connexion,Provincia provincia)throws SQLException,Exception {

		List<Barrio> barrios= new ArrayList<Barrio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProvinciaConstantesFunciones.SCHEMA+".provincia ON "+BarrioConstantesFunciones.SCHEMA+".barrio.id_provincia="+ProvinciaConstantesFunciones.SCHEMA+".provincia.id WHERE "+ProvinciaConstantesFunciones.SCHEMA+".provincia.id="+String.valueOf(provincia.getId());
			} else {
				sQuery=" INNER JOIN barrio.Provincia WHERE barrio.Provincia.id="+String.valueOf(provincia.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			BarrioDataAccess barrioDataAccess=new BarrioDataAccess();

			barrioDataAccess.setConnexionType(this.connexionType);
			barrioDataAccess.setParameterDbType(this.parameterDbType);
			barrios=barrioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return barrios;

	}

	public List<Canton> getCantons(Connexion connexion,Provincia provincia)throws SQLException,Exception {

		List<Canton> cantons= new ArrayList<Canton>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProvinciaConstantesFunciones.SCHEMA+".provincia ON "+CantonConstantesFunciones.SCHEMA+".canton.id_provincia="+ProvinciaConstantesFunciones.SCHEMA+".provincia.id WHERE "+ProvinciaConstantesFunciones.SCHEMA+".provincia.id="+String.valueOf(provincia.getId());
			} else {
				sQuery=" INNER JOIN canton.Provincia WHERE canton.Provincia.id="+String.valueOf(provincia.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CantonDataAccess cantonDataAccess=new CantonDataAccess();

			cantonDataAccess.setConnexionType(this.connexionType);
			cantonDataAccess.setParameterDbType(this.parameterDbType);
			cantons=cantonDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cantons;

	}

	public List<NumeroPatronal> getNumeroPatronals(Connexion connexion,Provincia provincia)throws SQLException,Exception {

		List<NumeroPatronal> numeropatronals= new ArrayList<NumeroPatronal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProvinciaConstantesFunciones.SCHEMA+".provincia ON "+NumeroPatronalConstantesFunciones.SCHEMA+".numero_patronal.id_provincia="+ProvinciaConstantesFunciones.SCHEMA+".provincia.id WHERE "+ProvinciaConstantesFunciones.SCHEMA+".provincia.id="+String.valueOf(provincia.getId());
			} else {
				sQuery=" INNER JOIN numeropatronal.Provincia WHERE numeropatronal.Provincia.id="+String.valueOf(provincia.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NumeroPatronalDataAccess numeropatronalDataAccess=new NumeroPatronalDataAccess();

			numeropatronalDataAccess.setConnexionType(this.connexionType);
			numeropatronalDataAccess.setParameterDbType(this.parameterDbType);
			numeropatronals=numeropatronalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return numeropatronals;

	}

	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados(Connexion connexion,Provincia provincia)throws SQLException,Exception {

		List<DatoGeneralEmpleado> datogeneralempleados= new ArrayList<DatoGeneralEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProvinciaConstantesFunciones.SCHEMA+".provincia ON "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+".dato_general_empleado.id_provincia="+ProvinciaConstantesFunciones.SCHEMA+".provincia.id WHERE "+ProvinciaConstantesFunciones.SCHEMA+".provincia.id="+String.valueOf(provincia.getId());
			} else {
				sQuery=" INNER JOIN datogeneralempleado.Provincia WHERE datogeneralempleado.Provincia.id="+String.valueOf(provincia.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DatoGeneralEmpleadoDataAccess datogeneralempleadoDataAccess=new DatoGeneralEmpleadoDataAccess();

			datogeneralempleadoDataAccess.setConnexionType(this.connexionType);
			datogeneralempleadoDataAccess.setParameterDbType(this.parameterDbType);
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datogeneralempleados;

	}

	public List<Empleado> getEmpleados(Connexion connexion,Provincia provincia)throws SQLException,Exception {

		List<Empleado> empleados= new ArrayList<Empleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProvinciaConstantesFunciones.SCHEMA+".provincia ON "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id_provincia="+ProvinciaConstantesFunciones.SCHEMA+".provincia.id WHERE "+ProvinciaConstantesFunciones.SCHEMA+".provincia.id="+String.valueOf(provincia.getId());
			} else {
				sQuery=" INNER JOIN empleado.Provincia WHERE empleado.Provincia.id="+String.valueOf(provincia.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);
			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleados;

	}

	public List<DatoGeneralUsuario> getDatoGeneralUsuarios(Connexion connexion,Provincia provincia)throws SQLException,Exception {

		List<DatoGeneralUsuario> datogeneralusuarios= new ArrayList<DatoGeneralUsuario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProvinciaConstantesFunciones.SCHEMA+".provincia ON "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+".dato_general_usuario.id_provincia="+ProvinciaConstantesFunciones.SCHEMA+".provincia.id WHERE "+ProvinciaConstantesFunciones.SCHEMA+".provincia.id="+String.valueOf(provincia.getId());
			} else {
				sQuery=" INNER JOIN datogeneralusuario.Provincia WHERE datogeneralusuario.Provincia.id="+String.valueOf(provincia.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DatoGeneralUsuarioDataAccess datogeneralusuarioDataAccess=new DatoGeneralUsuarioDataAccess();

			datogeneralusuarioDataAccess.setConnexionType(this.connexionType);
			datogeneralusuarioDataAccess.setParameterDbType(this.parameterDbType);
			datogeneralusuarios=datogeneralusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datogeneralusuarios;

	}

	public List<Cliente> getClientes(Connexion connexion,Provincia provincia)throws SQLException,Exception {

		List<Cliente> clientes= new ArrayList<Cliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProvinciaConstantesFunciones.SCHEMA+".provincia ON "+ClienteConstantesFunciones.SCHEMA+".cliente.id_provincia="+ProvinciaConstantesFunciones.SCHEMA+".provincia.id WHERE "+ProvinciaConstantesFunciones.SCHEMA+".provincia.id="+String.valueOf(provincia.getId());
			} else {
				sQuery=" INNER JOIN cliente.Provincia WHERE cliente.Provincia.id="+String.valueOf(provincia.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clientes;

	}

	public List<ParametroCarteraDefecto> getParametroCarteraDefectos(Connexion connexion,Provincia provincia)throws SQLException,Exception {

		List<ParametroCarteraDefecto> parametrocarteradefectos= new ArrayList<ParametroCarteraDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProvinciaConstantesFunciones.SCHEMA+".provincia ON "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+".parametro_cartera_defecto.id_provincia="+ProvinciaConstantesFunciones.SCHEMA+".provincia.id WHERE "+ProvinciaConstantesFunciones.SCHEMA+".provincia.id="+String.valueOf(provincia.getId());
			} else {
				sQuery=" INNER JOIN parametrocarteradefecto.Provincia WHERE parametrocarteradefecto.Provincia.id="+String.valueOf(provincia.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCarteraDefectoDataAccess parametrocarteradefectoDataAccess=new ParametroCarteraDefectoDataAccess();

			parametrocarteradefectoDataAccess.setConnexionType(this.connexionType);
			parametrocarteradefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocarteradefectos;

	}

	public List<Ciudad> getCiudads(Connexion connexion,Provincia provincia)throws SQLException,Exception {

		List<Ciudad> ciudads= new ArrayList<Ciudad>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProvinciaConstantesFunciones.SCHEMA+".provincia ON "+CiudadConstantesFunciones.SCHEMA+".ciudad.id_provincia="+ProvinciaConstantesFunciones.SCHEMA+".provincia.id WHERE "+ProvinciaConstantesFunciones.SCHEMA+".provincia.id="+String.valueOf(provincia.getId());
			} else {
				sQuery=" INNER JOIN ciudad.Provincia WHERE ciudad.Provincia.id="+String.valueOf(provincia.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);
			ciudads=ciudadDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudads;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Provincia provincia) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!provincia.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(provincia.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_region=new ParameterValue<Long>();
					parameterMaintenanceValueid_region.setValue(provincia.getid_region());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_region);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(provincia.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(provincia.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!provincia.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(provincia.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(provincia.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(provincia.getId());
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
	
	public void setIsNewIsChangedFalseProvincia(Provincia provincia)throws Exception  {		
		provincia.setIsNew(false);
		provincia.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProvincias(List<Provincia> provincias)throws Exception  {				
		for(Provincia provincia:provincias) {
			provincia.setIsNew(false);
			provincia.setIsChanged(false);
		}
	}
	
	public void generarExportarProvincia(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
