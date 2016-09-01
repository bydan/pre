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
package com.bydan.erp.sris.business.dataaccess;

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

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.util.*;//AutoriRetencionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class AutoriRetencionDataAccess extends  AutoriRetencionDataAccessAdditional{ //AutoriRetencionDataAccessAdditional,DataAccessHelper<AutoriRetencion>
	//static Logger logger = Logger.getLogger(AutoriRetencionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="autori_retencion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_usuario,numero_serie,numero_autorizacion,numero_inicial,numero_final,fecha_caducidad,esta_activo)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,numero_serie=?,numero_autorizacion=?,numero_inicial=?,numero_final=?,fecha_caducidad=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select autoriretencion from "+AutoriRetencionConstantesFunciones.SPERSISTENCENAME+" autoriretencion";
	public static String QUERYSELECTNATIVE="select "+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".id,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".version_row,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".id_empresa,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".id_sucursal,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".id_usuario,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".numero_serie,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".numero_autorizacion,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".numero_inicial,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".numero_final,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".fecha_caducidad,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".esta_activo from "+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME;//+" as "+AutoriRetencionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".id,"+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+".version_row from "+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME;//+" as "+AutoriRetencionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AutoriRetencionConstantesFunciones.SCHEMA+"."+AutoriRetencionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,numero_serie=?,numero_autorizacion=?,numero_inicial=?,numero_final=?,fecha_caducidad=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_AUTORIRETENCION_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_AUTORIRETENCION_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_AUTORIRETENCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_AUTORIRETENCION_SELECT(?,?)";
	
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
	
	
	protected AutoriRetencionDataAccessAdditional autoriretencionDataAccessAdditional=null;
	
	public AutoriRetencionDataAccessAdditional getAutoriRetencionDataAccessAdditional() {
		return this.autoriretencionDataAccessAdditional;
	}
	
	public void setAutoriRetencionDataAccessAdditional(AutoriRetencionDataAccessAdditional autoriretencionDataAccessAdditional) {
		try {
			this.autoriretencionDataAccessAdditional=autoriretencionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AutoriRetencionDataAccess() {
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
		AutoriRetencionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AutoriRetencionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AutoriRetencionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAutoriRetencionOriginal(AutoriRetencion autoriretencion)throws Exception  {
		autoriretencion.setAutoriRetencionOriginal((AutoriRetencion)autoriretencion.clone());		
	}
	
	public void setAutoriRetencionsOriginal(List<AutoriRetencion> autoriretencions)throws Exception  {
		
		for(AutoriRetencion autoriretencion:autoriretencions){
			autoriretencion.setAutoriRetencionOriginal((AutoriRetencion)autoriretencion.clone());
		}
	}
	
	public static void setAutoriRetencionOriginalStatic(AutoriRetencion autoriretencion)throws Exception  {
		autoriretencion.setAutoriRetencionOriginal((AutoriRetencion)autoriretencion.clone());		
	}
	
	public static void setAutoriRetencionsOriginalStatic(List<AutoriRetencion> autoriretencions)throws Exception  {
		
		for(AutoriRetencion autoriretencion:autoriretencions){
			autoriretencion.setAutoriRetencionOriginal((AutoriRetencion)autoriretencion.clone());
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
	
	public  AutoriRetencion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AutoriRetencion entity = new AutoriRetencion();		
		
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
	
	public  AutoriRetencion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AutoriRetencion entity = new AutoriRetencion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Sris.AutoriRetencion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAutoriRetencionOriginal(new AutoriRetencion());
      	    	entity=super.getEntity("",entity,resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAutoriRetencion("",entity,resultSet); 
				
				//entity.setAutoriRetencionOriginal(super.getEntity("",entity.getAutoriRetencionOriginal(),resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriRetencionOriginal(this.getEntityAutoriRetencion("",entity.getAutoriRetencionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAutoriRetencion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AutoriRetencion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AutoriRetencion entity = new AutoriRetencion();
				
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
	
	public  AutoriRetencion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AutoriRetencion entity = new AutoriRetencion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.AutoriRetencion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAutoriRetencionOriginal(new AutoriRetencion());
      	    	entity=super.getEntity("",entity,resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAutoriRetencion("",entity,resultSet);    
				
				//entity.setAutoriRetencionOriginal(super.getEntity("",entity.getAutoriRetencionOriginal(),resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriRetencionOriginal(this.getEntityAutoriRetencion("",entity.getAutoriRetencionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAutoriRetencion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AutoriRetencion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AutoriRetencion entity = new AutoriRetencion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.AutoriRetencion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAutoriRetencion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AutoriRetencion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AutoriRetencion> entities = new  ArrayList<AutoriRetencion>();
		AutoriRetencion entity = new AutoriRetencion();		  
		
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
	
	public  List<AutoriRetencion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AutoriRetencion> entities = new  ArrayList<AutoriRetencion>();
		AutoriRetencion entity = new AutoriRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriRetencion();
      	    	entity=super.getEntity("",entity,resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriRetencion("",entity,resultSet);
      	    	
				//entity.setAutoriRetencionOriginal( new AutoriRetencion());
      	    	//entity.setAutoriRetencionOriginal(super.getEntity("",entity.getAutoriRetencionOriginal(),resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriRetencionOriginal(this.getEntityAutoriRetencion("",entity.getAutoriRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriRetencions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriRetencion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AutoriRetencion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AutoriRetencion> entities = new  ArrayList<AutoriRetencion>();
		AutoriRetencion entity = new AutoriRetencion();		  
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
	
	public  List<AutoriRetencion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AutoriRetencion> entities = new  ArrayList<AutoriRetencion>();
		AutoriRetencion entity = new AutoriRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriRetencion();
				
				if(conMapGenerico) {
					entity.inicializarMapAutoriRetencion();
					//entity.setMapAutoriRetencion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAutoriRetencionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAutoriRetencion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA);         		
					entity=AutoriRetencionDataAccess.getEntityAutoriRetencion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAutoriRetencionOriginal( new AutoriRetencion());
					////entity.setAutoriRetencionOriginal(super.getEntity("",entity.getAutoriRetencionOriginal(),resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA));         		
					////entity.setAutoriRetencionOriginal(this.getEntityAutoriRetencion("",entity.getAutoriRetencionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriRetencions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AutoriRetencion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AutoriRetencion entity = new AutoriRetencion();		  
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
	
	public  AutoriRetencion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AutoriRetencion entity = new AutoriRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriRetencion();
				
				if(conMapGenerico) {
					entity.inicializarMapAutoriRetencion();
					//entity.setMapAutoriRetencion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAutoriRetencionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAutoriRetencion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA);         		
					entity=AutoriRetencionDataAccess.getEntityAutoriRetencion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAutoriRetencionOriginal( new AutoriRetencion());
					////entity.setAutoriRetencionOriginal(super.getEntity("",entity.getAutoriRetencionOriginal(),resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA));         		
					////entity.setAutoriRetencionOriginal(this.getEntityAutoriRetencion("",entity.getAutoriRetencionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAutoriRetencion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AutoriRetencion getEntityAutoriRetencion(String strPrefijo,AutoriRetencion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AutoriRetencion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AutoriRetencion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AutoriRetencionDataAccess.setFieldReflectionAutoriRetencion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAutoriRetencion=AutoriRetencionConstantesFunciones.getTodosTiposColumnasAutoriRetencion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAutoriRetencion) {
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
							field = AutoriRetencion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AutoriRetencion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AutoriRetencionDataAccess.setFieldReflectionAutoriRetencion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAutoriRetencion(Field field,String strPrefijo,String sColumn,AutoriRetencion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AutoriRetencionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriRetencionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriRetencionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriRetencionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriRetencionConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriRetencionConstantesFunciones.NUMEROSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriRetencionConstantesFunciones.NUMEROAUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriRetencionConstantesFunciones.NUMEROINICIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriRetencionConstantesFunciones.NUMEROFINAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriRetencionConstantesFunciones.FECHACADUCIDAD:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriRetencionConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AutoriRetencion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AutoriRetencion> entities = new  ArrayList<AutoriRetencion>();
		AutoriRetencion entity = new AutoriRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AutoriRetencion();
					entity=super.getEntity("",entity,resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAutoriRetencion("",entity,resultSet);
					
					//entity.setAutoriRetencionOriginal( new AutoriRetencion());
					//entity.setAutoriRetencionOriginal(super.getEntity("",entity.getAutoriRetencionOriginal(),resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA));         		
					//entity.setAutoriRetencionOriginal(this.getEntityAutoriRetencion("",entity.getAutoriRetencionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAutoriRetencions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriRetencion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AutoriRetencion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AutoriRetencion> entities = new  ArrayList<AutoriRetencion>();
		AutoriRetencion entity = new AutoriRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AutoriRetencion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriRetencion> entities = new  ArrayList<AutoriRetencion>();
		AutoriRetencion entity = new AutoriRetencion();		  
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
	
	public  List<AutoriRetencion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriRetencion> entities = new  ArrayList<AutoriRetencion>();
		AutoriRetencion entity = new AutoriRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriRetencion();
      	    	entity=super.getEntity("",entity,resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriRetencion("",entity,resultSet);
      	    	
				//entity.setAutoriRetencionOriginal( new AutoriRetencion());
      	    	//entity.setAutoriRetencionOriginal(super.getEntity("",entity.getAutoriRetencionOriginal(),resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriRetencionOriginal(this.getEntityAutoriRetencion("",entity.getAutoriRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAutoriRetencions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AutoriRetencion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriRetencion> entities = new  ArrayList<AutoriRetencion>();
		AutoriRetencion entity = new AutoriRetencion();		  
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
	
	public  List<AutoriRetencion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriRetencion> entities = new  ArrayList<AutoriRetencion>();
		AutoriRetencion entity = new AutoriRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriRetencion();
      	    	entity=super.getEntity("",entity,resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriRetencion("",entity,resultSet);
      	    	
				//entity.setAutoriRetencionOriginal( new AutoriRetencion());
      	    	//entity.setAutoriRetencionOriginal(super.getEntity("",entity.getAutoriRetencionOriginal(),resultSet,AutoriRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriRetencionOriginal(this.getEntityAutoriRetencion("",entity.getAutoriRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriRetencions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AutoriRetencion getEntityAutoriRetencion(String strPrefijo,AutoriRetencion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+AutoriRetencionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+AutoriRetencionConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+AutoriRetencionConstantesFunciones.IDUSUARIO));
				entity.setnumero_serie(resultSet.getString(strPrefijo+AutoriRetencionConstantesFunciones.NUMEROSERIE));
				entity.setnumero_autorizacion(resultSet.getString(strPrefijo+AutoriRetencionConstantesFunciones.NUMEROAUTORIZACION));
				entity.setnumero_inicial(resultSet.getString(strPrefijo+AutoriRetencionConstantesFunciones.NUMEROINICIAL));
				entity.setnumero_final(resultSet.getString(strPrefijo+AutoriRetencionConstantesFunciones.NUMEROFINAL));
				entity.setfecha_caducidad(new Date(resultSet.getDate(strPrefijo+AutoriRetencionConstantesFunciones.FECHACADUCIDAD).getTime()));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+AutoriRetencionConstantesFunciones.ESTAACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAutoriRetencion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AutoriRetencion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AutoriRetencionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AutoriRetencionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AutoriRetencionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AutoriRetencionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AutoriRetencionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AutoriRetencionDataAccess.TABLENAME,AutoriRetencionDataAccess.ISWITHSTOREPROCEDURES);
			
			AutoriRetencionDataAccess.setAutoriRetencionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,AutoriRetencion relautoriretencion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relautoriretencion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,AutoriRetencion relautoriretencion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relautoriretencion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,AutoriRetencion relautoriretencion)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relautoriretencion.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AutoriRetencion autoriretencion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!autoriretencion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(autoriretencion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(autoriretencion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(autoriretencion.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_serie=new ParameterValue<String>();
					parameterMaintenanceValuenumero_serie.setValue(autoriretencion.getnumero_serie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_serie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_autorizacion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_autorizacion.setValue(autoriretencion.getnumero_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_inicial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_inicial.setValue(autoriretencion.getnumero_inicial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_inicial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_final=new ParameterValue<String>();
					parameterMaintenanceValuenumero_final.setValue(autoriretencion.getnumero_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_caducidad=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_caducidad.setValue(autoriretencion.getfecha_caducidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_caducidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(autoriretencion.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!autoriretencion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(autoriretencion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(autoriretencion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(autoriretencion.getId());
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
	
	public void setIsNewIsChangedFalseAutoriRetencion(AutoriRetencion autoriretencion)throws Exception  {		
		autoriretencion.setIsNew(false);
		autoriretencion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAutoriRetencions(List<AutoriRetencion> autoriretencions)throws Exception  {				
		for(AutoriRetencion autoriretencion:autoriretencions) {
			autoriretencion.setIsNew(false);
			autoriretencion.setIsChanged(false);
		}
	}
	
	public void generarExportarAutoriRetencion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
