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
import com.bydan.erp.inventario.util.*;//EmpaqueConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class EmpaqueDataAccess extends  EmpaqueDataAccessAdditional{ //EmpaqueDataAccessAdditional,DataAccessHelper<Empaque>
	//static Logger logger = Logger.getLogger(EmpaqueDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empaque";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+"(version_row,id_empresa,valor,descripcion)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,valor=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empaque from "+EmpaqueConstantesFunciones.SPERSISTENCENAME+" empaque";
	public static String QUERYSELECTNATIVE="select "+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".id,"+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".version_row,"+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".id_empresa,"+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".valor,"+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".descripcion from "+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME;//+" as "+EmpaqueConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".id,"+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".version_row,"+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".descripcion from "+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME;//+" as "+EmpaqueConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,valor=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPAQUE_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPAQUE_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPAQUE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPAQUE_SELECT(?,?)";
	
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
	
	
	protected EmpaqueDataAccessAdditional empaqueDataAccessAdditional=null;
	
	public EmpaqueDataAccessAdditional getEmpaqueDataAccessAdditional() {
		return this.empaqueDataAccessAdditional;
	}
	
	public void setEmpaqueDataAccessAdditional(EmpaqueDataAccessAdditional empaqueDataAccessAdditional) {
		try {
			this.empaqueDataAccessAdditional=empaqueDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpaqueDataAccess() {
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
		EmpaqueDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpaqueDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpaqueDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpaqueOriginal(Empaque empaque)throws Exception  {
		empaque.setEmpaqueOriginal((Empaque)empaque.clone());		
	}
	
	public void setEmpaquesOriginal(List<Empaque> empaques)throws Exception  {
		
		for(Empaque empaque:empaques){
			empaque.setEmpaqueOriginal((Empaque)empaque.clone());
		}
	}
	
	public static void setEmpaqueOriginalStatic(Empaque empaque)throws Exception  {
		empaque.setEmpaqueOriginal((Empaque)empaque.clone());		
	}
	
	public static void setEmpaquesOriginalStatic(List<Empaque> empaques)throws Exception  {
		
		for(Empaque empaque:empaques){
			empaque.setEmpaqueOriginal((Empaque)empaque.clone());
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
	
	public  Empaque getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Empaque entity = new Empaque();		
		
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
	
	public  Empaque getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Empaque entity = new Empaque();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Empaque.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpaqueOriginal(new Empaque());
      	    	entity=super.getEntity("",entity,resultSet,EmpaqueDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpaque("",entity,resultSet); 
				
				//entity.setEmpaqueOriginal(super.getEntity("",entity.getEmpaqueOriginal(),resultSet,EmpaqueDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpaqueOriginal(this.getEntityEmpaque("",entity.getEmpaqueOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpaque(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Empaque getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Empaque entity = new Empaque();
				
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
	
	public  Empaque getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Empaque entity = new Empaque();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpaqueDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Empaque.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpaqueOriginal(new Empaque());
      	    	entity=super.getEntity("",entity,resultSet,EmpaqueDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpaque("",entity,resultSet);    
				
				//entity.setEmpaqueOriginal(super.getEntity("",entity.getEmpaqueOriginal(),resultSet,EmpaqueDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpaqueOriginal(this.getEntityEmpaque("",entity.getEmpaqueOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpaque(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Empaque
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Empaque entity = new Empaque();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpaqueDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Empaque.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpaque(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Empaque> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Empaque> entities = new  ArrayList<Empaque>();
		Empaque entity = new Empaque();		  
		
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
	
	public  List<Empaque> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Empaque> entities = new  ArrayList<Empaque>();
		Empaque entity = new Empaque();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpaqueDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empaque();
      	    	entity=super.getEntity("",entity,resultSet,EmpaqueDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpaque("",entity,resultSet);
      	    	
				//entity.setEmpaqueOriginal( new Empaque());
      	    	//entity.setEmpaqueOriginal(super.getEntity("",entity.getEmpaqueOriginal(),resultSet,EmpaqueDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpaqueOriginal(this.getEntityEmpaque("",entity.getEmpaqueOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpaques(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpaque(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Empaque> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Empaque> entities = new  ArrayList<Empaque>();
		Empaque entity = new Empaque();		  
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
	
	public  List<Empaque> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Empaque> entities = new  ArrayList<Empaque>();
		Empaque entity = new Empaque();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empaque();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpaque();
					//entity.setMapEmpaque(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpaqueValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpaque().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpaqueDataAccess.ISWITHSCHEMA);         		
					entity=EmpaqueDataAccess.getEntityEmpaque("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpaqueOriginal( new Empaque());
					////entity.setEmpaqueOriginal(super.getEntity("",entity.getEmpaqueOriginal(),resultSet,EmpaqueDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpaqueOriginal(this.getEntityEmpaque("",entity.getEmpaqueOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpaques(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpaque(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Empaque getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Empaque entity = new Empaque();		  
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
	
	public  Empaque getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Empaque entity = new Empaque();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empaque();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpaque();
					//entity.setMapEmpaque(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpaqueValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpaque().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpaqueDataAccess.ISWITHSCHEMA);         		
					entity=EmpaqueDataAccess.getEntityEmpaque("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpaqueOriginal( new Empaque());
					////entity.setEmpaqueOriginal(super.getEntity("",entity.getEmpaqueOriginal(),resultSet,EmpaqueDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpaqueOriginal(this.getEntityEmpaque("",entity.getEmpaqueOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpaque(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpaque(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Empaque getEntityEmpaque(String strPrefijo,Empaque entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Empaque.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Empaque.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpaqueDataAccess.setFieldReflectionEmpaque(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpaque=EmpaqueConstantesFunciones.getTodosTiposColumnasEmpaque();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpaque) {
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
							field = Empaque.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Empaque.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpaqueDataAccess.setFieldReflectionEmpaque(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpaque(Field field,String strPrefijo,String sColumn,Empaque entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpaqueConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpaqueConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpaqueConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpaqueConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EmpaqueConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Empaque>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Empaque> entities = new  ArrayList<Empaque>();
		Empaque entity = new Empaque();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpaqueDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Empaque();
					entity=super.getEntity("",entity,resultSet,EmpaqueDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpaque("",entity,resultSet);
					
					//entity.setEmpaqueOriginal( new Empaque());
					//entity.setEmpaqueOriginal(super.getEntity("",entity.getEmpaqueOriginal(),resultSet,EmpaqueDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpaqueOriginal(this.getEntityEmpaque("",entity.getEmpaqueOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpaques(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpaque(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Empaque>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Empaque> entities = new  ArrayList<Empaque>();
		Empaque entity = new Empaque();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpaqueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpaqueDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Empaque> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empaque> entities = new  ArrayList<Empaque>();
		Empaque entity = new Empaque();		  
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
	
	public  List<Empaque> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empaque> entities = new  ArrayList<Empaque>();
		Empaque entity = new Empaque();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empaque();
      	    	entity=super.getEntity("",entity,resultSet,EmpaqueDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpaque("",entity,resultSet);
      	    	
				//entity.setEmpaqueOriginal( new Empaque());
      	    	//entity.setEmpaqueOriginal(super.getEntity("",entity.getEmpaqueOriginal(),resultSet,EmpaqueDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpaqueOriginal(this.getEntityEmpaque("",entity.getEmpaqueOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpaques(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpaque(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Empaque> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empaque> entities = new  ArrayList<Empaque>();
		Empaque entity = new Empaque();		  
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
	
	public  List<Empaque> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empaque> entities = new  ArrayList<Empaque>();
		Empaque entity = new Empaque();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empaque();
      	    	entity=super.getEntity("",entity,resultSet,EmpaqueDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpaque("",entity,resultSet);
      	    	
				//entity.setEmpaqueOriginal( new Empaque());
      	    	//entity.setEmpaqueOriginal(super.getEntity("",entity.getEmpaqueOriginal(),resultSet,EmpaqueDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpaqueOriginal(this.getEntityEmpaque("",entity.getEmpaqueOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpaques(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Empaque getEntityEmpaque(String strPrefijo,Empaque entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmpaqueConstantesFunciones.IDEMPRESA));
				entity.setvalor(resultSet.getDouble(strPrefijo+EmpaqueConstantesFunciones.VALOR));
				entity.setdescripcion(resultSet.getString(strPrefijo+EmpaqueConstantesFunciones.DESCRIPCION));
			} else {
				entity.setdescripcion(resultSet.getString(strPrefijo+EmpaqueConstantesFunciones.DESCRIPCION));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpaque(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Empaque entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpaqueDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpaqueDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpaqueDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpaqueDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpaqueConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpaqueDataAccess.TABLENAME,EmpaqueDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpaqueDataAccess.setEmpaqueOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Empaque relempaque)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relempaque.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<DetaNotaCredito> getDetaNotaCreditos(Connexion connexion,Empaque empaque)throws SQLException,Exception {

		List<DetaNotaCredito> detanotacreditos= new ArrayList<DetaNotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpaqueConstantesFunciones.SCHEMA+".empaque ON "+DetaNotaCreditoConstantesFunciones.SCHEMA+".deta_nota_credito.id_empaque="+EmpaqueConstantesFunciones.SCHEMA+".empaque.id WHERE "+EmpaqueConstantesFunciones.SCHEMA+".empaque.id="+String.valueOf(empaque.getId());
			} else {
				sQuery=" INNER JOIN detanotacredito.Empaque WHERE detanotacredito.Empaque.id="+String.valueOf(empaque.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaNotaCreditoDataAccess detanotacreditoDataAccess=new DetaNotaCreditoDataAccess();

			detanotacreditoDataAccess.setConnexionType(this.connexionType);
			detanotacreditoDataAccess.setParameterDbType(this.parameterDbType);
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detanotacreditos;

	}

	public List<DetalleProforma> getDetalleProformas(Connexion connexion,Empaque empaque)throws SQLException,Exception {

		List<DetalleProforma> detalleproformas= new ArrayList<DetalleProforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpaqueConstantesFunciones.SCHEMA+".empaque ON "+DetalleProformaConstantesFunciones.SCHEMA+".detalle_proforma.id_empaque="+EmpaqueConstantesFunciones.SCHEMA+".empaque.id WHERE "+EmpaqueConstantesFunciones.SCHEMA+".empaque.id="+String.valueOf(empaque.getId());
			} else {
				sQuery=" INNER JOIN detalleproforma.Empaque WHERE detalleproforma.Empaque.id="+String.valueOf(empaque.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleProformaDataAccess detalleproformaDataAccess=new DetalleProformaDataAccess();

			detalleproformaDataAccess.setConnexionType(this.connexionType);
			detalleproformaDataAccess.setParameterDbType(this.parameterDbType);
			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleproformas;

	}

	public List<DetaNotaCreditoSoli> getDetaNotaCreditoSolis(Connexion connexion,Empaque empaque)throws SQLException,Exception {

		List<DetaNotaCreditoSoli> detanotacreditosolis= new ArrayList<DetaNotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpaqueConstantesFunciones.SCHEMA+".empaque ON "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+".deta_nota_credito_soli.id_empaque="+EmpaqueConstantesFunciones.SCHEMA+".empaque.id WHERE "+EmpaqueConstantesFunciones.SCHEMA+".empaque.id="+String.valueOf(empaque.getId());
			} else {
				sQuery=" INNER JOIN detanotacreditosoli.Empaque WHERE detanotacreditosoli.Empaque.id="+String.valueOf(empaque.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaNotaCreditoSoliDataAccess detanotacreditosoliDataAccess=new DetaNotaCreditoSoliDataAccess();

			detanotacreditosoliDataAccess.setConnexionType(this.connexionType);
			detanotacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detanotacreditosolis;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Empaque empaque) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empaque.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(empaque.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(empaque.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(empaque.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!empaque.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empaque.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empaque.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empaque.getId());
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
	
	public void setIsNewIsChangedFalseEmpaque(Empaque empaque)throws Exception  {		
		empaque.setIsNew(false);
		empaque.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpaques(List<Empaque> empaques)throws Exception  {				
		for(Empaque empaque:empaques) {
			empaque.setIsNew(false);
			empaque.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpaque(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
