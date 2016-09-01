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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//PeriodoImportExportConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class PeriodoImportExportDataAccess extends  PeriodoImportExportDataAccessAdditional{ //PeriodoImportExportDataAccessAdditional,DataAccessHelper<PeriodoImportExport>
	//static Logger logger = Logger.getLogger(PeriodoImportExportDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="periodo_import_export";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+"(id,version_row,codigo,id_anio,id_mes)values(?,current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select periodoimportexport from "+PeriodoImportExportConstantesFunciones.SPERSISTENCENAME+" periodoimportexport";
	public static String QUERYSELECTNATIVE="select "+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".id,"+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".version_row,"+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".codigo,"+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".id_anio,"+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".id_mes from "+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME;//+" as "+PeriodoImportExportConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".id,"+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".version_row,"+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+".codigo from "+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME;//+" as "+PeriodoImportExportConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PeriodoImportExportConstantesFunciones.SCHEMA+"."+PeriodoImportExportConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PERIODOIMPORTEXPORT_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PERIODOIMPORTEXPORT_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PERIODOIMPORTEXPORT_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PERIODOIMPORTEXPORT_SELECT(?,?)";
	
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
	
	
	protected PeriodoImportExportDataAccessAdditional periodoimportexportDataAccessAdditional=null;
	
	public PeriodoImportExportDataAccessAdditional getPeriodoImportExportDataAccessAdditional() {
		return this.periodoimportexportDataAccessAdditional;
	}
	
	public void setPeriodoImportExportDataAccessAdditional(PeriodoImportExportDataAccessAdditional periodoimportexportDataAccessAdditional) {
		try {
			this.periodoimportexportDataAccessAdditional=periodoimportexportDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PeriodoImportExportDataAccess() {
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
		PeriodoImportExportDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PeriodoImportExportDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PeriodoImportExportDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPeriodoImportExportOriginal(PeriodoImportExport periodoimportexport)throws Exception  {
		periodoimportexport.setPeriodoImportExportOriginal((PeriodoImportExport)periodoimportexport.clone());		
	}
	
	public void setPeriodoImportExportsOriginal(List<PeriodoImportExport> periodoimportexports)throws Exception  {
		
		for(PeriodoImportExport periodoimportexport:periodoimportexports){
			periodoimportexport.setPeriodoImportExportOriginal((PeriodoImportExport)periodoimportexport.clone());
		}
	}
	
	public static void setPeriodoImportExportOriginalStatic(PeriodoImportExport periodoimportexport)throws Exception  {
		periodoimportexport.setPeriodoImportExportOriginal((PeriodoImportExport)periodoimportexport.clone());		
	}
	
	public static void setPeriodoImportExportsOriginalStatic(List<PeriodoImportExport> periodoimportexports)throws Exception  {
		
		for(PeriodoImportExport periodoimportexport:periodoimportexports){
			periodoimportexport.setPeriodoImportExportOriginal((PeriodoImportExport)periodoimportexport.clone());
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
	
	public  PeriodoImportExport getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PeriodoImportExport entity = new PeriodoImportExport();		
		
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
	
	public  PeriodoImportExport getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PeriodoImportExport entity = new PeriodoImportExport();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.PeriodoImportExport.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPeriodoImportExportOriginal(new PeriodoImportExport());
      	    	entity=super.getEntity("",entity,resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPeriodoImportExport("",entity,resultSet); 
				
				//entity.setPeriodoImportExportOriginal(super.getEntity("",entity.getPeriodoImportExportOriginal(),resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPeriodoImportExportOriginal(this.getEntityPeriodoImportExport("",entity.getPeriodoImportExportOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePeriodoImportExport(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PeriodoImportExport getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PeriodoImportExport entity = new PeriodoImportExport();
				
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
	
	public  PeriodoImportExport getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PeriodoImportExport entity = new PeriodoImportExport();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PeriodoImportExportDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PeriodoImportExport.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPeriodoImportExportOriginal(new PeriodoImportExport());
      	    	entity=super.getEntity("",entity,resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPeriodoImportExport("",entity,resultSet);    
				
				//entity.setPeriodoImportExportOriginal(super.getEntity("",entity.getPeriodoImportExportOriginal(),resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPeriodoImportExportOriginal(this.getEntityPeriodoImportExport("",entity.getPeriodoImportExportOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePeriodoImportExport(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PeriodoImportExport
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PeriodoImportExport entity = new PeriodoImportExport();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PeriodoImportExportDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PeriodoImportExport.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePeriodoImportExport(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PeriodoImportExport> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PeriodoImportExport> entities = new  ArrayList<PeriodoImportExport>();
		PeriodoImportExport entity = new PeriodoImportExport();		  
		
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
	
	public  List<PeriodoImportExport> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PeriodoImportExport> entities = new  ArrayList<PeriodoImportExport>();
		PeriodoImportExport entity = new PeriodoImportExport();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PeriodoImportExportDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PeriodoImportExport();
      	    	entity=super.getEntity("",entity,resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPeriodoImportExport("",entity,resultSet);
      	    	
				//entity.setPeriodoImportExportOriginal( new PeriodoImportExport());
      	    	//entity.setPeriodoImportExportOriginal(super.getEntity("",entity.getPeriodoImportExportOriginal(),resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPeriodoImportExportOriginal(this.getEntityPeriodoImportExport("",entity.getPeriodoImportExportOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePeriodoImportExports(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPeriodoImportExport(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PeriodoImportExport> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PeriodoImportExport> entities = new  ArrayList<PeriodoImportExport>();
		PeriodoImportExport entity = new PeriodoImportExport();		  
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
	
	public  List<PeriodoImportExport> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PeriodoImportExport> entities = new  ArrayList<PeriodoImportExport>();
		PeriodoImportExport entity = new PeriodoImportExport();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PeriodoImportExport();
				
				if(conMapGenerico) {
					entity.inicializarMapPeriodoImportExport();
					//entity.setMapPeriodoImportExport(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPeriodoImportExportValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPeriodoImportExport().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA);         		
					entity=PeriodoImportExportDataAccess.getEntityPeriodoImportExport("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPeriodoImportExportOriginal( new PeriodoImportExport());
					////entity.setPeriodoImportExportOriginal(super.getEntity("",entity.getPeriodoImportExportOriginal(),resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA));         		
					////entity.setPeriodoImportExportOriginal(this.getEntityPeriodoImportExport("",entity.getPeriodoImportExportOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePeriodoImportExports(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPeriodoImportExport(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PeriodoImportExport getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PeriodoImportExport entity = new PeriodoImportExport();		  
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
	
	public  PeriodoImportExport getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PeriodoImportExport entity = new PeriodoImportExport();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PeriodoImportExport();
				
				if(conMapGenerico) {
					entity.inicializarMapPeriodoImportExport();
					//entity.setMapPeriodoImportExport(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPeriodoImportExportValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPeriodoImportExport().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA);         		
					entity=PeriodoImportExportDataAccess.getEntityPeriodoImportExport("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPeriodoImportExportOriginal( new PeriodoImportExport());
					////entity.setPeriodoImportExportOriginal(super.getEntity("",entity.getPeriodoImportExportOriginal(),resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA));         		
					////entity.setPeriodoImportExportOriginal(this.getEntityPeriodoImportExport("",entity.getPeriodoImportExportOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePeriodoImportExport(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPeriodoImportExport(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PeriodoImportExport getEntityPeriodoImportExport(String strPrefijo,PeriodoImportExport entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PeriodoImportExport.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PeriodoImportExport.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PeriodoImportExportDataAccess.setFieldReflectionPeriodoImportExport(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPeriodoImportExport=PeriodoImportExportConstantesFunciones.getTodosTiposColumnasPeriodoImportExport();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPeriodoImportExport) {
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
							field = PeriodoImportExport.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PeriodoImportExport.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PeriodoImportExportDataAccess.setFieldReflectionPeriodoImportExport(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPeriodoImportExport(Field field,String strPrefijo,String sColumn,PeriodoImportExport entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PeriodoImportExportConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PeriodoImportExportConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PeriodoImportExportConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PeriodoImportExportConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PeriodoImportExportConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PeriodoImportExport>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PeriodoImportExport> entities = new  ArrayList<PeriodoImportExport>();
		PeriodoImportExport entity = new PeriodoImportExport();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PeriodoImportExportDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PeriodoImportExport();
					entity=super.getEntity("",entity,resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPeriodoImportExport("",entity,resultSet);
					
					//entity.setPeriodoImportExportOriginal( new PeriodoImportExport());
					//entity.setPeriodoImportExportOriginal(super.getEntity("",entity.getPeriodoImportExportOriginal(),resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA));         		
					//entity.setPeriodoImportExportOriginal(this.getEntityPeriodoImportExport("",entity.getPeriodoImportExportOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePeriodoImportExports(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPeriodoImportExport(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PeriodoImportExport>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PeriodoImportExport> entities = new  ArrayList<PeriodoImportExport>();
		PeriodoImportExport entity = new PeriodoImportExport();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PeriodoImportExportDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PeriodoImportExportDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PeriodoImportExport> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PeriodoImportExport> entities = new  ArrayList<PeriodoImportExport>();
		PeriodoImportExport entity = new PeriodoImportExport();		  
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
	
	public  List<PeriodoImportExport> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PeriodoImportExport> entities = new  ArrayList<PeriodoImportExport>();
		PeriodoImportExport entity = new PeriodoImportExport();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PeriodoImportExport();
      	    	entity=super.getEntity("",entity,resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPeriodoImportExport("",entity,resultSet);
      	    	
				//entity.setPeriodoImportExportOriginal( new PeriodoImportExport());
      	    	//entity.setPeriodoImportExportOriginal(super.getEntity("",entity.getPeriodoImportExportOriginal(),resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPeriodoImportExportOriginal(this.getEntityPeriodoImportExport("",entity.getPeriodoImportExportOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePeriodoImportExports(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPeriodoImportExport(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PeriodoImportExport> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PeriodoImportExport> entities = new  ArrayList<PeriodoImportExport>();
		PeriodoImportExport entity = new PeriodoImportExport();		  
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
	
	public  List<PeriodoImportExport> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PeriodoImportExport> entities = new  ArrayList<PeriodoImportExport>();
		PeriodoImportExport entity = new PeriodoImportExport();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PeriodoImportExport();
      	    	entity=super.getEntity("",entity,resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPeriodoImportExport("",entity,resultSet);
      	    	
				//entity.setPeriodoImportExportOriginal( new PeriodoImportExport());
      	    	//entity.setPeriodoImportExportOriginal(super.getEntity("",entity.getPeriodoImportExportOriginal(),resultSet,PeriodoImportExportDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPeriodoImportExportOriginal(this.getEntityPeriodoImportExport("",entity.getPeriodoImportExportOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePeriodoImportExports(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PeriodoImportExport getEntityPeriodoImportExport(String strPrefijo,PeriodoImportExport entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+PeriodoImportExportConstantesFunciones.CODIGO));
				entity.setid_anio(resultSet.getLong(strPrefijo+PeriodoImportExportConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+PeriodoImportExportConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+PeriodoImportExportConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPeriodoImportExport(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PeriodoImportExport entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PeriodoImportExportDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PeriodoImportExportDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PeriodoImportExportDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PeriodoImportExportDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PeriodoImportExportConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,PeriodoImportExportDataAccess.TABLENAME,PeriodoImportExportDataAccess.ISWITHSTOREPROCEDURES);
			
			PeriodoImportExportDataAccess.setPeriodoImportExportOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Anio getAnio(Connexion connexion,PeriodoImportExport relperiodoimportexport)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relperiodoimportexport.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,PeriodoImportExport relperiodoimportexport)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relperiodoimportexport.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
		public List<ImportarExportar> getImportarExportars(Connexion connexion,PeriodoImportExport periodoimportexport)throws SQLException,Exception {

		List<ImportarExportar> importarexportars= new ArrayList<ImportarExportar>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PeriodoImportExportConstantesFunciones.SCHEMA+".periodo_import_export ON "+ImportarExportarConstantesFunciones.SCHEMA+".importar_exportar.id_periodo_import_export="+PeriodoImportExportConstantesFunciones.SCHEMA+".periodo_import_export.id WHERE "+PeriodoImportExportConstantesFunciones.SCHEMA+".periodo_import_export.id="+String.valueOf(periodoimportexport.getId());
			} else {
				sQuery=" INNER JOIN importarexportar.PeriodoImportExport WHERE importarexportar.PeriodoImportExport.id="+String.valueOf(periodoimportexport.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ImportarExportarDataAccess importarexportarDataAccess=new ImportarExportarDataAccess();

			importarexportarDataAccess.setConnexionType(this.connexionType);
			importarexportarDataAccess.setParameterDbType(this.parameterDbType);
			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return importarexportars;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PeriodoImportExport periodoimportexport) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!periodoimportexport.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(periodoimportexport.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(periodoimportexport.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(periodoimportexport.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(periodoimportexport.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!periodoimportexport.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(periodoimportexport.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(periodoimportexport.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(periodoimportexport.getId());
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
	
	public void setIsNewIsChangedFalsePeriodoImportExport(PeriodoImportExport periodoimportexport)throws Exception  {		
		periodoimportexport.setIsNew(false);
		periodoimportexport.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePeriodoImportExports(List<PeriodoImportExport> periodoimportexports)throws Exception  {				
		for(PeriodoImportExport periodoimportexport:periodoimportexports) {
			periodoimportexport.setIsNew(false);
			periodoimportexport.setIsChanged(false);
		}
	}
	
	public void generarExportarPeriodoImportExport(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
