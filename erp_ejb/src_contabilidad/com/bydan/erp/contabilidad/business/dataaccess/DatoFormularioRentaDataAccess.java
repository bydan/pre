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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//DatoFormularioRentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DatoFormularioRentaDataAccess extends  DatoFormularioRentaDataAccessAdditional{ //DatoFormularioRentaDataAccessAdditional,DataAccessHelper<DatoFormularioRenta>
	//static Logger logger = Logger.getLogger(DatoFormularioRentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="dato_formulario_renta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+"(version_row,id_anio,id_mes,es_sustitutiva,numero_formulario,cedula_representante,numero_fiscal)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_anio=?,id_mes=?,es_sustitutiva=?,numero_formulario=?,cedula_representante=?,numero_fiscal=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select datoformulariorenta from "+DatoFormularioRentaConstantesFunciones.SPERSISTENCENAME+" datoformulariorenta";
	public static String QUERYSELECTNATIVE="select "+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".id,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".version_row,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".id_anio,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".id_mes,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".es_sustitutiva,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".numero_formulario,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".cedula_representante,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".numero_fiscal from "+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME;//+" as "+DatoFormularioRentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".id,"+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+".version_row from "+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME;//+" as "+DatoFormularioRentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DatoFormularioRentaConstantesFunciones.SCHEMA+"."+DatoFormularioRentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_anio=?,id_mes=?,es_sustitutiva=?,numero_formulario=?,cedula_representante=?,numero_fiscal=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DATOFORMULARIORENTA_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DATOFORMULARIORENTA_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DATOFORMULARIORENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DATOFORMULARIORENTA_SELECT(?,?)";
	
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
	
	
	protected DatoFormularioRentaDataAccessAdditional datoformulariorentaDataAccessAdditional=null;
	
	public DatoFormularioRentaDataAccessAdditional getDatoFormularioRentaDataAccessAdditional() {
		return this.datoformulariorentaDataAccessAdditional;
	}
	
	public void setDatoFormularioRentaDataAccessAdditional(DatoFormularioRentaDataAccessAdditional datoformulariorentaDataAccessAdditional) {
		try {
			this.datoformulariorentaDataAccessAdditional=datoformulariorentaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DatoFormularioRentaDataAccess() {
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
		DatoFormularioRentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DatoFormularioRentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DatoFormularioRentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDatoFormularioRentaOriginal(DatoFormularioRenta datoformulariorenta)throws Exception  {
		datoformulariorenta.setDatoFormularioRentaOriginal((DatoFormularioRenta)datoformulariorenta.clone());		
	}
	
	public void setDatoFormularioRentasOriginal(List<DatoFormularioRenta> datoformulariorentas)throws Exception  {
		
		for(DatoFormularioRenta datoformulariorenta:datoformulariorentas){
			datoformulariorenta.setDatoFormularioRentaOriginal((DatoFormularioRenta)datoformulariorenta.clone());
		}
	}
	
	public static void setDatoFormularioRentaOriginalStatic(DatoFormularioRenta datoformulariorenta)throws Exception  {
		datoformulariorenta.setDatoFormularioRentaOriginal((DatoFormularioRenta)datoformulariorenta.clone());		
	}
	
	public static void setDatoFormularioRentasOriginalStatic(List<DatoFormularioRenta> datoformulariorentas)throws Exception  {
		
		for(DatoFormularioRenta datoformulariorenta:datoformulariorentas){
			datoformulariorenta.setDatoFormularioRentaOriginal((DatoFormularioRenta)datoformulariorenta.clone());
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
	
	public  DatoFormularioRenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DatoFormularioRenta entity = new DatoFormularioRenta();		
		
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
	
	public  DatoFormularioRenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DatoFormularioRenta entity = new DatoFormularioRenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.DatoFormularioRenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDatoFormularioRentaOriginal(new DatoFormularioRenta());
      	    	entity=super.getEntity("",entity,resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDatoFormularioRenta("",entity,resultSet); 
				
				//entity.setDatoFormularioRentaOriginal(super.getEntity("",entity.getDatoFormularioRentaOriginal(),resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoFormularioRentaOriginal(this.getEntityDatoFormularioRenta("",entity.getDatoFormularioRentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDatoFormularioRenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DatoFormularioRenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DatoFormularioRenta entity = new DatoFormularioRenta();
				
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
	
	public  DatoFormularioRenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DatoFormularioRenta entity = new DatoFormularioRenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoFormularioRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DatoFormularioRenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDatoFormularioRentaOriginal(new DatoFormularioRenta());
      	    	entity=super.getEntity("",entity,resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDatoFormularioRenta("",entity,resultSet);    
				
				//entity.setDatoFormularioRentaOriginal(super.getEntity("",entity.getDatoFormularioRentaOriginal(),resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoFormularioRentaOriginal(this.getEntityDatoFormularioRenta("",entity.getDatoFormularioRentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDatoFormularioRenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DatoFormularioRenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DatoFormularioRenta entity = new DatoFormularioRenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoFormularioRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DatoFormularioRenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDatoFormularioRenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DatoFormularioRenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DatoFormularioRenta> entities = new  ArrayList<DatoFormularioRenta>();
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
		
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
	
	public  List<DatoFormularioRenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DatoFormularioRenta> entities = new  ArrayList<DatoFormularioRenta>();
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoFormularioRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoFormularioRenta();
      	    	entity=super.getEntity("",entity,resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoFormularioRenta("",entity,resultSet);
      	    	
				//entity.setDatoFormularioRentaOriginal( new DatoFormularioRenta());
      	    	//entity.setDatoFormularioRentaOriginal(super.getEntity("",entity.getDatoFormularioRentaOriginal(),resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoFormularioRentaOriginal(this.getEntityDatoFormularioRenta("",entity.getDatoFormularioRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoFormularioRentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoFormularioRenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DatoFormularioRenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DatoFormularioRenta> entities = new  ArrayList<DatoFormularioRenta>();
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
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
	
	public  List<DatoFormularioRenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DatoFormularioRenta> entities = new  ArrayList<DatoFormularioRenta>();
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoFormularioRenta();
				
				if(conMapGenerico) {
					entity.inicializarMapDatoFormularioRenta();
					//entity.setMapDatoFormularioRenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDatoFormularioRentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDatoFormularioRenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA);         		
					entity=DatoFormularioRentaDataAccess.getEntityDatoFormularioRenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDatoFormularioRentaOriginal( new DatoFormularioRenta());
					////entity.setDatoFormularioRentaOriginal(super.getEntity("",entity.getDatoFormularioRentaOriginal(),resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA));         		
					////entity.setDatoFormularioRentaOriginal(this.getEntityDatoFormularioRenta("",entity.getDatoFormularioRentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoFormularioRentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoFormularioRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DatoFormularioRenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
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
	
	public  DatoFormularioRenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoFormularioRenta();
				
				if(conMapGenerico) {
					entity.inicializarMapDatoFormularioRenta();
					//entity.setMapDatoFormularioRenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDatoFormularioRentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDatoFormularioRenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA);         		
					entity=DatoFormularioRentaDataAccess.getEntityDatoFormularioRenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDatoFormularioRentaOriginal( new DatoFormularioRenta());
					////entity.setDatoFormularioRentaOriginal(super.getEntity("",entity.getDatoFormularioRentaOriginal(),resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA));         		
					////entity.setDatoFormularioRentaOriginal(this.getEntityDatoFormularioRenta("",entity.getDatoFormularioRentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDatoFormularioRenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoFormularioRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DatoFormularioRenta getEntityDatoFormularioRenta(String strPrefijo,DatoFormularioRenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DatoFormularioRenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DatoFormularioRenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DatoFormularioRentaDataAccess.setFieldReflectionDatoFormularioRenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDatoFormularioRenta=DatoFormularioRentaConstantesFunciones.getTodosTiposColumnasDatoFormularioRenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDatoFormularioRenta) {
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
							field = DatoFormularioRenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DatoFormularioRenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DatoFormularioRentaDataAccess.setFieldReflectionDatoFormularioRenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDatoFormularioRenta(Field field,String strPrefijo,String sColumn,DatoFormularioRenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DatoFormularioRentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoFormularioRentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoFormularioRentaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoFormularioRentaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoFormularioRentaConstantesFunciones.ESSUSTITUTIVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DatoFormularioRentaConstantesFunciones.NUMEROFORMULARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoFormularioRentaConstantesFunciones.CEDULAREPRESENTANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoFormularioRentaConstantesFunciones.NUMEROFISCAL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DatoFormularioRenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DatoFormularioRenta> entities = new  ArrayList<DatoFormularioRenta>();
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoFormularioRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DatoFormularioRenta();
					entity=super.getEntity("",entity,resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDatoFormularioRenta("",entity,resultSet);
					
					//entity.setDatoFormularioRentaOriginal( new DatoFormularioRenta());
					//entity.setDatoFormularioRentaOriginal(super.getEntity("",entity.getDatoFormularioRentaOriginal(),resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA));         		
					//entity.setDatoFormularioRentaOriginal(this.getEntityDatoFormularioRenta("",entity.getDatoFormularioRentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDatoFormularioRentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoFormularioRenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DatoFormularioRenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DatoFormularioRenta> entities = new  ArrayList<DatoFormularioRenta>();
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoFormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoFormularioRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DatoFormularioRenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoFormularioRenta> entities = new  ArrayList<DatoFormularioRenta>();
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
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
	
	public  List<DatoFormularioRenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoFormularioRenta> entities = new  ArrayList<DatoFormularioRenta>();
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoFormularioRenta();
      	    	entity=super.getEntity("",entity,resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoFormularioRenta("",entity,resultSet);
      	    	
				//entity.setDatoFormularioRentaOriginal( new DatoFormularioRenta());
      	    	//entity.setDatoFormularioRentaOriginal(super.getEntity("",entity.getDatoFormularioRentaOriginal(),resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoFormularioRentaOriginal(this.getEntityDatoFormularioRenta("",entity.getDatoFormularioRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDatoFormularioRentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoFormularioRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DatoFormularioRenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoFormularioRenta> entities = new  ArrayList<DatoFormularioRenta>();
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
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
	
	public  List<DatoFormularioRenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoFormularioRenta> entities = new  ArrayList<DatoFormularioRenta>();
		DatoFormularioRenta entity = new DatoFormularioRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoFormularioRenta();
      	    	entity=super.getEntity("",entity,resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoFormularioRenta("",entity,resultSet);
      	    	
				//entity.setDatoFormularioRentaOriginal( new DatoFormularioRenta());
      	    	//entity.setDatoFormularioRentaOriginal(super.getEntity("",entity.getDatoFormularioRentaOriginal(),resultSet,DatoFormularioRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoFormularioRentaOriginal(this.getEntityDatoFormularioRenta("",entity.getDatoFormularioRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoFormularioRentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DatoFormularioRenta getEntityDatoFormularioRenta(String strPrefijo,DatoFormularioRenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_anio(resultSet.getLong(strPrefijo+DatoFormularioRentaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DatoFormularioRentaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setes_sustitutiva(resultSet.getBoolean(strPrefijo+DatoFormularioRentaConstantesFunciones.ESSUSTITUTIVA));
				entity.setnumero_formulario(resultSet.getString(strPrefijo+DatoFormularioRentaConstantesFunciones.NUMEROFORMULARIO));
				entity.setcedula_representante(resultSet.getString(strPrefijo+DatoFormularioRentaConstantesFunciones.CEDULAREPRESENTANTE));
				entity.setnumero_fiscal(resultSet.getString(strPrefijo+DatoFormularioRentaConstantesFunciones.NUMEROFISCAL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDatoFormularioRenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DatoFormularioRenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DatoFormularioRentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DatoFormularioRentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DatoFormularioRentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DatoFormularioRentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DatoFormularioRentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DatoFormularioRentaDataAccess.TABLENAME,DatoFormularioRentaDataAccess.ISWITHSTOREPROCEDURES);
			
			DatoFormularioRentaDataAccess.setDatoFormularioRentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Anio getAnio(Connexion connexion,DatoFormularioRenta reldatoformulariorenta)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldatoformulariorenta.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DatoFormularioRenta reldatoformulariorenta)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldatoformulariorenta.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
		public List<FormularioRenta> getFormularioRentas(Connexion connexion,DatoFormularioRenta datoformulariorenta)throws SQLException,Exception {

		List<FormularioRenta> formulariorentas= new ArrayList<FormularioRenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DatoFormularioRentaConstantesFunciones.SCHEMA+".dato_formulario_renta ON "+FormularioRentaConstantesFunciones.SCHEMA+".formulario_renta.id_dato_formulario_renta="+DatoFormularioRentaConstantesFunciones.SCHEMA+".dato_formulario_renta.id WHERE "+DatoFormularioRentaConstantesFunciones.SCHEMA+".dato_formulario_renta.id="+String.valueOf(datoformulariorenta.getId());
			} else {
				sQuery=" INNER JOIN formulariorenta.DatoFormularioRenta WHERE formulariorenta.DatoFormularioRenta.id="+String.valueOf(datoformulariorenta.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormularioRentaDataAccess formulariorentaDataAccess=new FormularioRentaDataAccess();

			formulariorentaDataAccess.setConnexionType(this.connexionType);
			formulariorentaDataAccess.setParameterDbType(this.parameterDbType);
			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formulariorentas;

	}

	public List<FormularioRentaExtra> getFormularioRentaExtras(Connexion connexion,DatoFormularioRenta datoformulariorenta)throws SQLException,Exception {

		List<FormularioRentaExtra> formulariorentaextras= new ArrayList<FormularioRentaExtra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DatoFormularioRentaConstantesFunciones.SCHEMA+".dato_formulario_renta ON "+FormularioRentaExtraConstantesFunciones.SCHEMA+".formulario_renta_extra.id_dato_formulario_renta="+DatoFormularioRentaConstantesFunciones.SCHEMA+".dato_formulario_renta.id WHERE "+DatoFormularioRentaConstantesFunciones.SCHEMA+".dato_formulario_renta.id="+String.valueOf(datoformulariorenta.getId());
			} else {
				sQuery=" INNER JOIN formulariorentaextra.DatoFormularioRenta WHERE formulariorentaextra.DatoFormularioRenta.id="+String.valueOf(datoformulariorenta.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormularioRentaExtraDataAccess formulariorentaextraDataAccess=new FormularioRentaExtraDataAccess();

			formulariorentaextraDataAccess.setConnexionType(this.connexionType);
			formulariorentaextraDataAccess.setParameterDbType(this.parameterDbType);
			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formulariorentaextras;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DatoFormularioRenta datoformulariorenta) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!datoformulariorenta.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(datoformulariorenta.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(datoformulariorenta.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_sustitutiva=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_sustitutiva.setValue(datoformulariorenta.getes_sustitutiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_sustitutiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_formulario=new ParameterValue<String>();
					parameterMaintenanceValuenumero_formulario.setValue(datoformulariorenta.getnumero_formulario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_formulario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecedula_representante=new ParameterValue<String>();
					parameterMaintenanceValuecedula_representante.setValue(datoformulariorenta.getcedula_representante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecedula_representante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_fiscal=new ParameterValue<String>();
					parameterMaintenanceValuenumero_fiscal.setValue(datoformulariorenta.getnumero_fiscal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_fiscal);
					parametersTemp.add(parameterMaintenance);
					
						if(!datoformulariorenta.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(datoformulariorenta.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(datoformulariorenta.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(datoformulariorenta.getId());
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
	
	public void setIsNewIsChangedFalseDatoFormularioRenta(DatoFormularioRenta datoformulariorenta)throws Exception  {		
		datoformulariorenta.setIsNew(false);
		datoformulariorenta.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDatoFormularioRentas(List<DatoFormularioRenta> datoformulariorentas)throws Exception  {				
		for(DatoFormularioRenta datoformulariorenta:datoformulariorentas) {
			datoformulariorenta.setIsNew(false);
			datoformulariorenta.setIsChanged(false);
		}
	}
	
	public void generarExportarDatoFormularioRenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
