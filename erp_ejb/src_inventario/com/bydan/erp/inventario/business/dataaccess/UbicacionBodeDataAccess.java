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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//UbicacionBodeConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class UbicacionBodeDataAccess extends  UbicacionBodeDataAccessAdditional{ //UbicacionBodeDataAccessAdditional,DataAccessHelper<UbicacionBode>
	//static Logger logger = Logger.getLogger(UbicacionBodeDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="ubicacion_bode";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_bodega,id_ubicacion_bode,nombre,nivel,orden)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_ubicacion_bode=?,nombre=?,nivel=?,orden=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select ubicacionbode from "+UbicacionBodeConstantesFunciones.SPERSISTENCENAME+" ubicacionbode";
	public static String QUERYSELECTNATIVE="select "+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".id,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".version_row,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".id_empresa,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".id_sucursal,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".id_bodega,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".id_ubicacion_bode,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".nombre,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".nivel,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".orden from "+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME;//+" as "+UbicacionBodeConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".id,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".version_row,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".nombre from "+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME;//+" as "+UbicacionBodeConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_ubicacion_bode=?,nombre=?,nivel=?,orden=?";
	
	public static String STOREPROCEDUREINSERT="call SP_UBICACIONBODE_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_UBICACIONBODE_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_UBICACIONBODE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_UBICACIONBODE_SELECT(?,?)";
	
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
	
	
	protected UbicacionBodeDataAccessAdditional ubicacionbodeDataAccessAdditional=null;
	
	public UbicacionBodeDataAccessAdditional getUbicacionBodeDataAccessAdditional() {
		return this.ubicacionbodeDataAccessAdditional;
	}
	
	public void setUbicacionBodeDataAccessAdditional(UbicacionBodeDataAccessAdditional ubicacionbodeDataAccessAdditional) {
		try {
			this.ubicacionbodeDataAccessAdditional=ubicacionbodeDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public UbicacionBodeDataAccess() {
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
		UbicacionBodeDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		UbicacionBodeDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		UbicacionBodeDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setUbicacionBodeOriginal(UbicacionBode ubicacionbode)throws Exception  {
		ubicacionbode.setUbicacionBodeOriginal((UbicacionBode)ubicacionbode.clone());		
	}
	
	public void setUbicacionBodesOriginal(List<UbicacionBode> ubicacionbodes)throws Exception  {
		
		for(UbicacionBode ubicacionbode:ubicacionbodes){
			ubicacionbode.setUbicacionBodeOriginal((UbicacionBode)ubicacionbode.clone());
		}
	}
	
	public static void setUbicacionBodeOriginalStatic(UbicacionBode ubicacionbode)throws Exception  {
		ubicacionbode.setUbicacionBodeOriginal((UbicacionBode)ubicacionbode.clone());		
	}
	
	public static void setUbicacionBodesOriginalStatic(List<UbicacionBode> ubicacionbodes)throws Exception  {
		
		for(UbicacionBode ubicacionbode:ubicacionbodes){
			ubicacionbode.setUbicacionBodeOriginal((UbicacionBode)ubicacionbode.clone());
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
	
	public  UbicacionBode getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		UbicacionBode entity = new UbicacionBode();		
		
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
	
	public  UbicacionBode getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		UbicacionBode entity = new UbicacionBode();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.UbicacionBode.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setUbicacionBodeOriginal(new UbicacionBode());
      	    	entity=super.getEntity("",entity,resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUbicacionBode("",entity,resultSet); 
				
				//entity.setUbicacionBodeOriginal(super.getEntity("",entity.getUbicacionBodeOriginal(),resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUbicacionBodeOriginal(this.getEntityUbicacionBode("",entity.getUbicacionBodeOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseUbicacionBode(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  UbicacionBode getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UbicacionBode entity = new UbicacionBode();
				
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
	
	public  UbicacionBode getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UbicacionBode entity = new UbicacionBode();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UbicacionBodeDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.UbicacionBode.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setUbicacionBodeOriginal(new UbicacionBode());
      	    	entity=super.getEntity("",entity,resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUbicacionBode("",entity,resultSet);    
				
				//entity.setUbicacionBodeOriginal(super.getEntity("",entity.getUbicacionBodeOriginal(),resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUbicacionBodeOriginal(this.getEntityUbicacionBode("",entity.getUbicacionBodeOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseUbicacionBode(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //UbicacionBode
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		UbicacionBode entity = new UbicacionBode();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UbicacionBodeDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.UbicacionBode.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseUbicacionBode(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<UbicacionBode> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UbicacionBode> entities = new  ArrayList<UbicacionBode>();
		UbicacionBode entity = new UbicacionBode();		  
		
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
	
	public  List<UbicacionBode> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UbicacionBode> entities = new  ArrayList<UbicacionBode>();
		UbicacionBode entity = new UbicacionBode();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UbicacionBodeDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UbicacionBode();
      	    	entity=super.getEntity("",entity,resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUbicacionBode("",entity,resultSet);
      	    	
				//entity.setUbicacionBodeOriginal( new UbicacionBode());
      	    	//entity.setUbicacionBodeOriginal(super.getEntity("",entity.getUbicacionBodeOriginal(),resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUbicacionBodeOriginal(this.getEntityUbicacionBode("",entity.getUbicacionBodeOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUbicacionBodes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUbicacionBode(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<UbicacionBode> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UbicacionBode> entities = new  ArrayList<UbicacionBode>();
		UbicacionBode entity = new UbicacionBode();		  
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
	
	public  List<UbicacionBode> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UbicacionBode> entities = new  ArrayList<UbicacionBode>();
		UbicacionBode entity = new UbicacionBode();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UbicacionBode();
				
				if(conMapGenerico) {
					entity.inicializarMapUbicacionBode();
					//entity.setMapUbicacionBode(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapUbicacionBodeValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUbicacionBode().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA);         		
					entity=UbicacionBodeDataAccess.getEntityUbicacionBode("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUbicacionBodeOriginal( new UbicacionBode());
					////entity.setUbicacionBodeOriginal(super.getEntity("",entity.getUbicacionBodeOriginal(),resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA));         		
					////entity.setUbicacionBodeOriginal(this.getEntityUbicacionBode("",entity.getUbicacionBodeOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUbicacionBodes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUbicacionBode(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public UbicacionBode getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UbicacionBode entity = new UbicacionBode();		  
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
	
	public  UbicacionBode getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UbicacionBode entity = new UbicacionBode();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UbicacionBode();
				
				if(conMapGenerico) {
					entity.inicializarMapUbicacionBode();
					//entity.setMapUbicacionBode(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapUbicacionBodeValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUbicacionBode().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA);         		
					entity=UbicacionBodeDataAccess.getEntityUbicacionBode("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUbicacionBodeOriginal( new UbicacionBode());
					////entity.setUbicacionBodeOriginal(super.getEntity("",entity.getUbicacionBodeOriginal(),resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA));         		
					////entity.setUbicacionBodeOriginal(this.getEntityUbicacionBode("",entity.getUbicacionBodeOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseUbicacionBode(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUbicacionBode(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static UbicacionBode getEntityUbicacionBode(String strPrefijo,UbicacionBode entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = UbicacionBode.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = UbicacionBode.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					UbicacionBodeDataAccess.setFieldReflectionUbicacionBode(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasUbicacionBode=UbicacionBodeConstantesFunciones.getTodosTiposColumnasUbicacionBode();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasUbicacionBode) {
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
							field = UbicacionBode.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = UbicacionBode.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						UbicacionBodeDataAccess.setFieldReflectionUbicacionBode(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionUbicacionBode(Field field,String strPrefijo,String sColumn,UbicacionBode entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case UbicacionBodeConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UbicacionBodeConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UbicacionBodeConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UbicacionBodeConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UbicacionBodeConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UbicacionBodeConstantesFunciones.IDUBICACIONBODE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UbicacionBodeConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UbicacionBodeConstantesFunciones.NIVEL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case UbicacionBodeConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getInt(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UbicacionBode>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<UbicacionBode> entities = new  ArrayList<UbicacionBode>();
		UbicacionBode entity = new UbicacionBode();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UbicacionBodeDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new UbicacionBode();
					entity=super.getEntity("",entity,resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityUbicacionBode("",entity,resultSet);
					
					//entity.setUbicacionBodeOriginal( new UbicacionBode());
					//entity.setUbicacionBodeOriginal(super.getEntity("",entity.getUbicacionBodeOriginal(),resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA));         		
					//entity.setUbicacionBodeOriginal(this.getEntityUbicacionBode("",entity.getUbicacionBodeOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseUbicacionBodes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUbicacionBode(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UbicacionBode>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<UbicacionBode> entities = new  ArrayList<UbicacionBode>();
		UbicacionBode entity = new UbicacionBode();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UbicacionBodeDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UbicacionBodeDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<UbicacionBode> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UbicacionBode> entities = new  ArrayList<UbicacionBode>();
		UbicacionBode entity = new UbicacionBode();		  
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
	
	public  List<UbicacionBode> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UbicacionBode> entities = new  ArrayList<UbicacionBode>();
		UbicacionBode entity = new UbicacionBode();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UbicacionBode();
      	    	entity=super.getEntity("",entity,resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUbicacionBode("",entity,resultSet);
      	    	
				//entity.setUbicacionBodeOriginal( new UbicacionBode());
      	    	//entity.setUbicacionBodeOriginal(super.getEntity("",entity.getUbicacionBodeOriginal(),resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUbicacionBodeOriginal(this.getEntityUbicacionBode("",entity.getUbicacionBodeOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseUbicacionBodes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUbicacionBode(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<UbicacionBode> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UbicacionBode> entities = new  ArrayList<UbicacionBode>();
		UbicacionBode entity = new UbicacionBode();		  
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
	
	public  List<UbicacionBode> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UbicacionBode> entities = new  ArrayList<UbicacionBode>();
		UbicacionBode entity = new UbicacionBode();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UbicacionBode();
      	    	entity=super.getEntity("",entity,resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUbicacionBode("",entity,resultSet);
      	    	
				//entity.setUbicacionBodeOriginal( new UbicacionBode());
      	    	//entity.setUbicacionBodeOriginal(super.getEntity("",entity.getUbicacionBodeOriginal(),resultSet,UbicacionBodeDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUbicacionBodeOriginal(this.getEntityUbicacionBode("",entity.getUbicacionBodeOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUbicacionBodes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public UbicacionBode getEntityUbicacionBode(String strPrefijo,UbicacionBode entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+UbicacionBodeConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+UbicacionBodeConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+UbicacionBodeConstantesFunciones.IDBODEGA));
				entity.setid_ubicacion_bode(resultSet.getLong(strPrefijo+UbicacionBodeConstantesFunciones.IDUBICACIONBODE));if(resultSet.wasNull()) {entity.setid_ubicacion_bode(null); }
				entity.setnombre(resultSet.getString(strPrefijo+UbicacionBodeConstantesFunciones.NOMBRE));
				entity.setnivel(resultSet.getInt(strPrefijo+UbicacionBodeConstantesFunciones.NIVEL));
				entity.setorden(resultSet.getInt(strPrefijo+UbicacionBodeConstantesFunciones.ORDEN));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+UbicacionBodeConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowUbicacionBode(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(UbicacionBode entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=UbicacionBodeDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=UbicacionBodeDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=UbicacionBodeDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=UbicacionBodeDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(UbicacionBodeConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,UbicacionBodeDataAccess.TABLENAME,UbicacionBodeDataAccess.ISWITHSTOREPROCEDURES);
			
			UbicacionBodeDataAccess.setUbicacionBodeOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,UbicacionBode relubicacionbode)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relubicacionbode.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,UbicacionBode relubicacionbode)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relubicacionbode.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,UbicacionBode relubicacionbode)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relubicacionbode.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public UbicacionBode getUbicacionBode(Connexion connexion,UbicacionBode relubicacionbode)throws SQLException,Exception {

		UbicacionBode ubicacionbode= new UbicacionBode();

		try {
			UbicacionBodeDataAccess ubicacionbodeDataAccess=new UbicacionBodeDataAccess();

			ubicacionbodeDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ubicacionbodeDataAccess.setConnexionType(this.connexionType);
			ubicacionbodeDataAccess.setParameterDbType(this.parameterDbType);

			ubicacionbode=ubicacionbodeDataAccess.getEntity(connexion,relubicacionbode.getid_ubicacion_bode());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ubicacionbode;

	}


		
		public List<UbicacionBode> getUbicacionBodes(Connexion connexion,UbicacionBode ubicacionbode)throws SQLException,Exception {

		List<UbicacionBode> ubicacionbodes= new ArrayList<UbicacionBode>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UbicacionBodeConstantesFunciones.SCHEMA+".ubicacion_bode ON "+UbicacionBodeConstantesFunciones.SCHEMA+".ubicacion_bode.id_ubicacion_bode="+UbicacionBodeConstantesFunciones.SCHEMA+".ubicacion_bode.id WHERE "+UbicacionBodeConstantesFunciones.SCHEMA+".ubicacion_bode.id="+String.valueOf(ubicacionbode.getId());
			} else {
				sQuery=" INNER JOIN ubicacionbode.UbicacionBode WHERE ubicacionbode.UbicacionBode.id="+String.valueOf(ubicacionbode.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			UbicacionBodeDataAccess ubicacionbodeDataAccess=new UbicacionBodeDataAccess();

			ubicacionbodeDataAccess.setConnexionType(this.connexionType);
			ubicacionbodeDataAccess.setParameterDbType(this.parameterDbType);
			ubicacionbodes=ubicacionbodeDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ubicacionbodes;

	}

	public List<UbicacionProdu> getUbicacionProdus(Connexion connexion,UbicacionBode ubicacionbode)throws SQLException,Exception {

		List<UbicacionProdu> ubicacionprodus= new ArrayList<UbicacionProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UbicacionBodeConstantesFunciones.SCHEMA+".ubicacion_bode ON "+UbicacionProduConstantesFunciones.SCHEMA+".ubicacion_produ.id_ubicacion_bode="+UbicacionBodeConstantesFunciones.SCHEMA+".ubicacion_bode.id WHERE "+UbicacionBodeConstantesFunciones.SCHEMA+".ubicacion_bode.id="+String.valueOf(ubicacionbode.getId());
			} else {
				sQuery=" INNER JOIN ubicacionprodu.UbicacionBode WHERE ubicacionprodu.UbicacionBode.id="+String.valueOf(ubicacionbode.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			UbicacionProduDataAccess ubicacionproduDataAccess=new UbicacionProduDataAccess();

			ubicacionproduDataAccess.setConnexionType(this.connexionType);
			ubicacionproduDataAccess.setParameterDbType(this.parameterDbType);
			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ubicacionprodus;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,UbicacionBode ubicacionbode) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!ubicacionbode.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(ubicacionbode.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(ubicacionbode.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(ubicacionbode.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ubicacion_bode=new ParameterValue<Long>();
					parameterMaintenanceValueid_ubicacion_bode.setValue(ubicacionbode.getid_ubicacion_bode());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ubicacion_bode);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(ubicacionbode.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenivel=new ParameterValue<Integer>();
					parameterMaintenanceValuenivel.setValue(ubicacionbode.getnivel());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenivel);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueorden=new ParameterValue<Integer>();
					parameterMaintenanceValueorden.setValue(ubicacionbode.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
						if(!ubicacionbode.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(ubicacionbode.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(ubicacionbode.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(ubicacionbode.getId());
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
	
	public void setIsNewIsChangedFalseUbicacionBode(UbicacionBode ubicacionbode)throws Exception  {		
		ubicacionbode.setIsNew(false);
		ubicacionbode.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseUbicacionBodes(List<UbicacionBode> ubicacionbodes)throws Exception  {				
		for(UbicacionBode ubicacionbode:ubicacionbodes) {
			ubicacionbode.setIsNew(false);
			ubicacionbode.setIsChanged(false);
		}
	}
	
	public void generarExportarUbicacionBode(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
