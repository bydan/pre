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
import com.bydan.erp.contabilidad.util.*;//PresuTipoProyectoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class PresuTipoProyectoDataAccess extends  PresuTipoProyectoDataAccessAdditional{ //PresuTipoProyectoDataAccessAdditional,DataAccessHelper<PresuTipoProyecto>
	//static Logger logger = Logger.getLogger(PresuTipoProyectoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="presu_tipo_proyecto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select presutipoproyecto from "+PresuTipoProyectoConstantesFunciones.SPERSISTENCENAME+" presutipoproyecto";
	public static String QUERYSELECTNATIVE="select "+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".id,"+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".version_row,"+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".id_empresa,"+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".codigo,"+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".nombre from "+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME;//+" as "+PresuTipoProyectoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".id,"+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".version_row,"+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".codigo from "+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME;//+" as "+PresuTipoProyectoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRESUTIPOPROYECTO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRESUTIPOPROYECTO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRESUTIPOPROYECTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRESUTIPOPROYECTO_SELECT(?,?)";
	
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
	
	
	protected PresuTipoProyectoDataAccessAdditional presutipoproyectoDataAccessAdditional=null;
	
	public PresuTipoProyectoDataAccessAdditional getPresuTipoProyectoDataAccessAdditional() {
		return this.presutipoproyectoDataAccessAdditional;
	}
	
	public void setPresuTipoProyectoDataAccessAdditional(PresuTipoProyectoDataAccessAdditional presutipoproyectoDataAccessAdditional) {
		try {
			this.presutipoproyectoDataAccessAdditional=presutipoproyectoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PresuTipoProyectoDataAccess() {
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
		PresuTipoProyectoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PresuTipoProyectoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PresuTipoProyectoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPresuTipoProyectoOriginal(PresuTipoProyecto presutipoproyecto)throws Exception  {
		presutipoproyecto.setPresuTipoProyectoOriginal((PresuTipoProyecto)presutipoproyecto.clone());		
	}
	
	public void setPresuTipoProyectosOriginal(List<PresuTipoProyecto> presutipoproyectos)throws Exception  {
		
		for(PresuTipoProyecto presutipoproyecto:presutipoproyectos){
			presutipoproyecto.setPresuTipoProyectoOriginal((PresuTipoProyecto)presutipoproyecto.clone());
		}
	}
	
	public static void setPresuTipoProyectoOriginalStatic(PresuTipoProyecto presutipoproyecto)throws Exception  {
		presutipoproyecto.setPresuTipoProyectoOriginal((PresuTipoProyecto)presutipoproyecto.clone());		
	}
	
	public static void setPresuTipoProyectosOriginalStatic(List<PresuTipoProyecto> presutipoproyectos)throws Exception  {
		
		for(PresuTipoProyecto presutipoproyecto:presutipoproyectos){
			presutipoproyecto.setPresuTipoProyectoOriginal((PresuTipoProyecto)presutipoproyecto.clone());
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
	
	public  PresuTipoProyecto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PresuTipoProyecto entity = new PresuTipoProyecto();		
		
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
	
	public  PresuTipoProyecto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PresuTipoProyecto entity = new PresuTipoProyecto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.PresuTipoProyecto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPresuTipoProyectoOriginal(new PresuTipoProyecto());
      	    	entity=super.getEntity("",entity,resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresuTipoProyecto("",entity,resultSet); 
				
				//entity.setPresuTipoProyectoOriginal(super.getEntity("",entity.getPresuTipoProyectoOriginal(),resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuTipoProyectoOriginal(this.getEntityPresuTipoProyecto("",entity.getPresuTipoProyectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePresuTipoProyecto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PresuTipoProyecto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresuTipoProyecto entity = new PresuTipoProyecto();
				
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
	
	public  PresuTipoProyecto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresuTipoProyecto entity = new PresuTipoProyecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuTipoProyectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresuTipoProyecto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPresuTipoProyectoOriginal(new PresuTipoProyecto());
      	    	entity=super.getEntity("",entity,resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresuTipoProyecto("",entity,resultSet);    
				
				//entity.setPresuTipoProyectoOriginal(super.getEntity("",entity.getPresuTipoProyectoOriginal(),resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuTipoProyectoOriginal(this.getEntityPresuTipoProyecto("",entity.getPresuTipoProyectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePresuTipoProyecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PresuTipoProyecto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PresuTipoProyecto entity = new PresuTipoProyecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuTipoProyectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresuTipoProyecto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePresuTipoProyecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PresuTipoProyecto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresuTipoProyecto> entities = new  ArrayList<PresuTipoProyecto>();
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
		
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
	
	public  List<PresuTipoProyecto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresuTipoProyecto> entities = new  ArrayList<PresuTipoProyecto>();
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuTipoProyectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuTipoProyecto();
      	    	entity=super.getEntity("",entity,resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuTipoProyecto("",entity,resultSet);
      	    	
				//entity.setPresuTipoProyectoOriginal( new PresuTipoProyecto());
      	    	//entity.setPresuTipoProyectoOriginal(super.getEntity("",entity.getPresuTipoProyectoOriginal(),resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuTipoProyectoOriginal(this.getEntityPresuTipoProyecto("",entity.getPresuTipoProyectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuTipoProyectos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuTipoProyecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresuTipoProyecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresuTipoProyecto> entities = new  ArrayList<PresuTipoProyecto>();
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
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
	
	public  List<PresuTipoProyecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresuTipoProyecto> entities = new  ArrayList<PresuTipoProyecto>();
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuTipoProyecto();
				
				if(conMapGenerico) {
					entity.inicializarMapPresuTipoProyecto();
					//entity.setMapPresuTipoProyecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPresuTipoProyectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresuTipoProyecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA);         		
					entity=PresuTipoProyectoDataAccess.getEntityPresuTipoProyecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresuTipoProyectoOriginal( new PresuTipoProyecto());
					////entity.setPresuTipoProyectoOriginal(super.getEntity("",entity.getPresuTipoProyectoOriginal(),resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA));         		
					////entity.setPresuTipoProyectoOriginal(this.getEntityPresuTipoProyecto("",entity.getPresuTipoProyectoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuTipoProyectos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuTipoProyecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PresuTipoProyecto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
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
	
	public  PresuTipoProyecto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuTipoProyecto();
				
				if(conMapGenerico) {
					entity.inicializarMapPresuTipoProyecto();
					//entity.setMapPresuTipoProyecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPresuTipoProyectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresuTipoProyecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA);         		
					entity=PresuTipoProyectoDataAccess.getEntityPresuTipoProyecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresuTipoProyectoOriginal( new PresuTipoProyecto());
					////entity.setPresuTipoProyectoOriginal(super.getEntity("",entity.getPresuTipoProyectoOriginal(),resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA));         		
					////entity.setPresuTipoProyectoOriginal(this.getEntityPresuTipoProyecto("",entity.getPresuTipoProyectoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePresuTipoProyecto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuTipoProyecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PresuTipoProyecto getEntityPresuTipoProyecto(String strPrefijo,PresuTipoProyecto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PresuTipoProyecto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PresuTipoProyecto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PresuTipoProyectoDataAccess.setFieldReflectionPresuTipoProyecto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPresuTipoProyecto=PresuTipoProyectoConstantesFunciones.getTodosTiposColumnasPresuTipoProyecto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPresuTipoProyecto) {
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
							field = PresuTipoProyecto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PresuTipoProyecto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PresuTipoProyectoDataAccess.setFieldReflectionPresuTipoProyecto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPresuTipoProyecto(Field field,String strPrefijo,String sColumn,PresuTipoProyecto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PresuTipoProyectoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuTipoProyectoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresuTipoProyectoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuTipoProyectoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresuTipoProyectoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresuTipoProyecto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PresuTipoProyecto> entities = new  ArrayList<PresuTipoProyecto>();
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuTipoProyectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PresuTipoProyecto();
					entity=super.getEntity("",entity,resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPresuTipoProyecto("",entity,resultSet);
					
					//entity.setPresuTipoProyectoOriginal( new PresuTipoProyecto());
					//entity.setPresuTipoProyectoOriginal(super.getEntity("",entity.getPresuTipoProyectoOriginal(),resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA));         		
					//entity.setPresuTipoProyectoOriginal(this.getEntityPresuTipoProyecto("",entity.getPresuTipoProyectoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePresuTipoProyectos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuTipoProyecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresuTipoProyecto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PresuTipoProyecto> entities = new  ArrayList<PresuTipoProyecto>();
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuTipoProyectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuTipoProyectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PresuTipoProyecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuTipoProyecto> entities = new  ArrayList<PresuTipoProyecto>();
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
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
	
	public  List<PresuTipoProyecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuTipoProyecto> entities = new  ArrayList<PresuTipoProyecto>();
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuTipoProyecto();
      	    	entity=super.getEntity("",entity,resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuTipoProyecto("",entity,resultSet);
      	    	
				//entity.setPresuTipoProyectoOriginal( new PresuTipoProyecto());
      	    	//entity.setPresuTipoProyectoOriginal(super.getEntity("",entity.getPresuTipoProyectoOriginal(),resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuTipoProyectoOriginal(this.getEntityPresuTipoProyecto("",entity.getPresuTipoProyectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePresuTipoProyectos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuTipoProyecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresuTipoProyecto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuTipoProyecto> entities = new  ArrayList<PresuTipoProyecto>();
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
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
	
	public  List<PresuTipoProyecto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuTipoProyecto> entities = new  ArrayList<PresuTipoProyecto>();
		PresuTipoProyecto entity = new PresuTipoProyecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuTipoProyecto();
      	    	entity=super.getEntity("",entity,resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuTipoProyecto("",entity,resultSet);
      	    	
				//entity.setPresuTipoProyectoOriginal( new PresuTipoProyecto());
      	    	//entity.setPresuTipoProyectoOriginal(super.getEntity("",entity.getPresuTipoProyectoOriginal(),resultSet,PresuTipoProyectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuTipoProyectoOriginal(this.getEntityPresuTipoProyecto("",entity.getPresuTipoProyectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuTipoProyectos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PresuTipoProyecto getEntityPresuTipoProyecto(String strPrefijo,PresuTipoProyecto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PresuTipoProyectoConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+PresuTipoProyectoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+PresuTipoProyectoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+PresuTipoProyectoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPresuTipoProyecto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PresuTipoProyecto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PresuTipoProyectoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PresuTipoProyectoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PresuTipoProyectoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PresuTipoProyectoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PresuTipoProyectoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PresuTipoProyectoDataAccess.TABLENAME,PresuTipoProyectoDataAccess.ISWITHSTOREPROCEDURES);
			
			PresuTipoProyectoDataAccess.setPresuTipoProyectoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PresuTipoProyecto relpresutipoproyecto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpresutipoproyecto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<PresuProyecto> getPresuProyectos(Connexion connexion,PresuTipoProyecto presutipoproyecto)throws SQLException,Exception {

		List<PresuProyecto> presuproyectos= new ArrayList<PresuProyecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PresuTipoProyectoConstantesFunciones.SCHEMA+".presu_tipo_proyecto ON "+PresuProyectoConstantesFunciones.SCHEMA+".presu_proyecto.id_presu_tipo_proyecto="+PresuTipoProyectoConstantesFunciones.SCHEMA+".presu_tipo_proyecto.id WHERE "+PresuTipoProyectoConstantesFunciones.SCHEMA+".presu_tipo_proyecto.id="+String.valueOf(presutipoproyecto.getId());
			} else {
				sQuery=" INNER JOIN presuproyecto.PresuTipoProyecto WHERE presuproyecto.PresuTipoProyecto.id="+String.valueOf(presutipoproyecto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresuProyectoDataAccess presuproyectoDataAccess=new PresuProyectoDataAccess();

			presuproyectoDataAccess.setConnexionType(this.connexionType);
			presuproyectoDataAccess.setParameterDbType(this.parameterDbType);
			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presuproyectos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PresuTipoProyecto presutipoproyecto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!presutipoproyecto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(presutipoproyecto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(presutipoproyecto.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(presutipoproyecto.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!presutipoproyecto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(presutipoproyecto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(presutipoproyecto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(presutipoproyecto.getId());
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
	
	public void setIsNewIsChangedFalsePresuTipoProyecto(PresuTipoProyecto presutipoproyecto)throws Exception  {		
		presutipoproyecto.setIsNew(false);
		presutipoproyecto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePresuTipoProyectos(List<PresuTipoProyecto> presutipoproyectos)throws Exception  {				
		for(PresuTipoProyecto presutipoproyecto:presutipoproyectos) {
			presutipoproyecto.setIsNew(false);
			presutipoproyecto.setIsChanged(false);
		}
	}
	
	public void generarExportarPresuTipoProyecto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
