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
import com.bydan.erp.contabilidad.util.*;//PresuAsignacionConstantesFunciones;


import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class PresuAsignacionDataAccess extends  PresuAsignacionDataAccessAdditional{ //PresuAsignacionDataAccessAdditional,DataAccessHelper<PresuAsignacion>
	//static Logger logger = Logger.getLogger(PresuAsignacionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="presu_asignacion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+"(version_row,id_presu_proyecto_cuenta,id_empleado,codigo_secuencial,valor,fecha,id_presu_estado,descripcion)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_presu_proyecto_cuenta=?,id_empleado=?,codigo_secuencial=?,valor=?,fecha=?,id_presu_estado=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select presuasignacion from "+PresuAsignacionConstantesFunciones.SPERSISTENCENAME+" presuasignacion";
	public static String QUERYSELECTNATIVE="select "+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".id,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".version_row,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".id_presu_proyecto_cuenta,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".id_empleado,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".codigo_secuencial,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".valor,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".fecha,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".id_presu_estado,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".descripcion from "+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME;//+" as "+PresuAsignacionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".id,"+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+".version_row from "+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME;//+" as "+PresuAsignacionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PresuAsignacionConstantesFunciones.SCHEMA+"."+PresuAsignacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_presu_proyecto_cuenta=?,id_empleado=?,codigo_secuencial=?,valor=?,fecha=?,id_presu_estado=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRESUASIGNACION_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRESUASIGNACION_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRESUASIGNACION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRESUASIGNACION_SELECT(?,?)";
	
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
	
	
	protected PresuAsignacionDataAccessAdditional presuasignacionDataAccessAdditional=null;
	
	public PresuAsignacionDataAccessAdditional getPresuAsignacionDataAccessAdditional() {
		return this.presuasignacionDataAccessAdditional;
	}
	
	public void setPresuAsignacionDataAccessAdditional(PresuAsignacionDataAccessAdditional presuasignacionDataAccessAdditional) {
		try {
			this.presuasignacionDataAccessAdditional=presuasignacionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PresuAsignacionDataAccess() {
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
		PresuAsignacionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PresuAsignacionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PresuAsignacionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPresuAsignacionOriginal(PresuAsignacion presuasignacion)throws Exception  {
		presuasignacion.setPresuAsignacionOriginal((PresuAsignacion)presuasignacion.clone());		
	}
	
	public void setPresuAsignacionsOriginal(List<PresuAsignacion> presuasignacions)throws Exception  {
		
		for(PresuAsignacion presuasignacion:presuasignacions){
			presuasignacion.setPresuAsignacionOriginal((PresuAsignacion)presuasignacion.clone());
		}
	}
	
	public static void setPresuAsignacionOriginalStatic(PresuAsignacion presuasignacion)throws Exception  {
		presuasignacion.setPresuAsignacionOriginal((PresuAsignacion)presuasignacion.clone());		
	}
	
	public static void setPresuAsignacionsOriginalStatic(List<PresuAsignacion> presuasignacions)throws Exception  {
		
		for(PresuAsignacion presuasignacion:presuasignacions){
			presuasignacion.setPresuAsignacionOriginal((PresuAsignacion)presuasignacion.clone());
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
	
	public  PresuAsignacion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PresuAsignacion entity = new PresuAsignacion();		
		
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
	
	public  PresuAsignacion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PresuAsignacion entity = new PresuAsignacion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.PresuAsignacion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPresuAsignacionOriginal(new PresuAsignacion());
      	    	entity=super.getEntity("",entity,resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresuAsignacion("",entity,resultSet); 
				
				//entity.setPresuAsignacionOriginal(super.getEntity("",entity.getPresuAsignacionOriginal(),resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuAsignacionOriginal(this.getEntityPresuAsignacion("",entity.getPresuAsignacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePresuAsignacion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PresuAsignacion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresuAsignacion entity = new PresuAsignacion();
				
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
	
	public  PresuAsignacion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresuAsignacion entity = new PresuAsignacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuAsignacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresuAsignacion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPresuAsignacionOriginal(new PresuAsignacion());
      	    	entity=super.getEntity("",entity,resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresuAsignacion("",entity,resultSet);    
				
				//entity.setPresuAsignacionOriginal(super.getEntity("",entity.getPresuAsignacionOriginal(),resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuAsignacionOriginal(this.getEntityPresuAsignacion("",entity.getPresuAsignacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePresuAsignacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PresuAsignacion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PresuAsignacion entity = new PresuAsignacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuAsignacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresuAsignacion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePresuAsignacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PresuAsignacion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresuAsignacion> entities = new  ArrayList<PresuAsignacion>();
		PresuAsignacion entity = new PresuAsignacion();		  
		
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
	
	public  List<PresuAsignacion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresuAsignacion> entities = new  ArrayList<PresuAsignacion>();
		PresuAsignacion entity = new PresuAsignacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuAsignacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuAsignacion();
      	    	entity=super.getEntity("",entity,resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuAsignacion("",entity,resultSet);
      	    	
				//entity.setPresuAsignacionOriginal( new PresuAsignacion());
      	    	//entity.setPresuAsignacionOriginal(super.getEntity("",entity.getPresuAsignacionOriginal(),resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuAsignacionOriginal(this.getEntityPresuAsignacion("",entity.getPresuAsignacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuAsignacions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuAsignacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresuAsignacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresuAsignacion> entities = new  ArrayList<PresuAsignacion>();
		PresuAsignacion entity = new PresuAsignacion();		  
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
	
	public  List<PresuAsignacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresuAsignacion> entities = new  ArrayList<PresuAsignacion>();
		PresuAsignacion entity = new PresuAsignacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuAsignacion();
				
				if(conMapGenerico) {
					entity.inicializarMapPresuAsignacion();
					//entity.setMapPresuAsignacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPresuAsignacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresuAsignacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA);         		
					entity=PresuAsignacionDataAccess.getEntityPresuAsignacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresuAsignacionOriginal( new PresuAsignacion());
					////entity.setPresuAsignacionOriginal(super.getEntity("",entity.getPresuAsignacionOriginal(),resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA));         		
					////entity.setPresuAsignacionOriginal(this.getEntityPresuAsignacion("",entity.getPresuAsignacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuAsignacions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuAsignacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PresuAsignacion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresuAsignacion entity = new PresuAsignacion();		  
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
	
	public  PresuAsignacion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresuAsignacion entity = new PresuAsignacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuAsignacion();
				
				if(conMapGenerico) {
					entity.inicializarMapPresuAsignacion();
					//entity.setMapPresuAsignacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPresuAsignacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresuAsignacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA);         		
					entity=PresuAsignacionDataAccess.getEntityPresuAsignacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresuAsignacionOriginal( new PresuAsignacion());
					////entity.setPresuAsignacionOriginal(super.getEntity("",entity.getPresuAsignacionOriginal(),resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA));         		
					////entity.setPresuAsignacionOriginal(this.getEntityPresuAsignacion("",entity.getPresuAsignacionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePresuAsignacion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuAsignacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PresuAsignacion getEntityPresuAsignacion(String strPrefijo,PresuAsignacion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PresuAsignacion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PresuAsignacion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PresuAsignacionDataAccess.setFieldReflectionPresuAsignacion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPresuAsignacion=PresuAsignacionConstantesFunciones.getTodosTiposColumnasPresuAsignacion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPresuAsignacion) {
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
							field = PresuAsignacion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PresuAsignacion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PresuAsignacionDataAccess.setFieldReflectionPresuAsignacion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPresuAsignacion(Field field,String strPrefijo,String sColumn,PresuAsignacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PresuAsignacionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuAsignacionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuAsignacionConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuAsignacionConstantesFunciones.CODIGOSECUENCIAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuAsignacionConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresuAsignacionConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PresuAsignacionConstantesFunciones.IDPRESUESTADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuAsignacionConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresuAsignacion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PresuAsignacion> entities = new  ArrayList<PresuAsignacion>();
		PresuAsignacion entity = new PresuAsignacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuAsignacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PresuAsignacion();
					entity=super.getEntity("",entity,resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPresuAsignacion("",entity,resultSet);
					
					//entity.setPresuAsignacionOriginal( new PresuAsignacion());
					//entity.setPresuAsignacionOriginal(super.getEntity("",entity.getPresuAsignacionOriginal(),resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA));         		
					//entity.setPresuAsignacionOriginal(this.getEntityPresuAsignacion("",entity.getPresuAsignacionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePresuAsignacions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuAsignacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresuAsignacion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PresuAsignacion> entities = new  ArrayList<PresuAsignacion>();
		PresuAsignacion entity = new PresuAsignacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuAsignacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuAsignacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PresuAsignacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuAsignacion> entities = new  ArrayList<PresuAsignacion>();
		PresuAsignacion entity = new PresuAsignacion();		  
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
	
	public  List<PresuAsignacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuAsignacion> entities = new  ArrayList<PresuAsignacion>();
		PresuAsignacion entity = new PresuAsignacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuAsignacion();
      	    	entity=super.getEntity("",entity,resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuAsignacion("",entity,resultSet);
      	    	
				//entity.setPresuAsignacionOriginal( new PresuAsignacion());
      	    	//entity.setPresuAsignacionOriginal(super.getEntity("",entity.getPresuAsignacionOriginal(),resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuAsignacionOriginal(this.getEntityPresuAsignacion("",entity.getPresuAsignacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePresuAsignacions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuAsignacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresuAsignacion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuAsignacion> entities = new  ArrayList<PresuAsignacion>();
		PresuAsignacion entity = new PresuAsignacion();		  
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
	
	public  List<PresuAsignacion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuAsignacion> entities = new  ArrayList<PresuAsignacion>();
		PresuAsignacion entity = new PresuAsignacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuAsignacion();
      	    	entity=super.getEntity("",entity,resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuAsignacion("",entity,resultSet);
      	    	
				//entity.setPresuAsignacionOriginal( new PresuAsignacion());
      	    	//entity.setPresuAsignacionOriginal(super.getEntity("",entity.getPresuAsignacionOriginal(),resultSet,PresuAsignacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuAsignacionOriginal(this.getEntityPresuAsignacion("",entity.getPresuAsignacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuAsignacions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PresuAsignacion getEntityPresuAsignacion(String strPrefijo,PresuAsignacion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_presu_proyecto_cuenta(resultSet.getLong(strPrefijo+PresuAsignacionConstantesFunciones.IDPRESUPROYECTOCUENTA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+PresuAsignacionConstantesFunciones.IDEMPLEADO));
				entity.setcodigo_secuencial(resultSet.getLong(strPrefijo+PresuAsignacionConstantesFunciones.CODIGOSECUENCIAL));
				entity.setvalor(resultSet.getDouble(strPrefijo+PresuAsignacionConstantesFunciones.VALOR));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PresuAsignacionConstantesFunciones.FECHA).getTime()));
				entity.setid_presu_estado(resultSet.getLong(strPrefijo+PresuAsignacionConstantesFunciones.IDPRESUESTADO));
				entity.setdescripcion(resultSet.getString(strPrefijo+PresuAsignacionConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPresuAsignacion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PresuAsignacion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PresuAsignacionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PresuAsignacionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PresuAsignacionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PresuAsignacionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PresuAsignacionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PresuAsignacionDataAccess.TABLENAME,PresuAsignacionDataAccess.ISWITHSTOREPROCEDURES);
			
			PresuAsignacionDataAccess.setPresuAsignacionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public PresuProyectoCuenta getPresuProyectoCuenta(Connexion connexion,PresuAsignacion relpresuasignacion)throws SQLException,Exception {

		PresuProyectoCuenta presuproyectocuenta= new PresuProyectoCuenta();

		try {
			PresuProyectoCuentaDataAccess presuproyectocuentaDataAccess=new PresuProyectoCuentaDataAccess();

			presuproyectocuentaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			presuproyectocuentaDataAccess.setConnexionType(this.connexionType);
			presuproyectocuentaDataAccess.setParameterDbType(this.parameterDbType);

			presuproyectocuenta=presuproyectocuentaDataAccess.getEntity(connexion,relpresuasignacion.getid_presu_proyecto_cuenta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presuproyectocuenta;

	}

	public Empleado getEmpleado(Connexion connexion,PresuAsignacion relpresuasignacion)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relpresuasignacion.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public PresuEstado getPresuEstado(Connexion connexion,PresuAsignacion relpresuasignacion)throws SQLException,Exception {

		PresuEstado presuestado= new PresuEstado();

		try {
			PresuEstadoDataAccess presuestadoDataAccess=new PresuEstadoDataAccess();

			presuestadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			presuestadoDataAccess.setConnexionType(this.connexionType);
			presuestadoDataAccess.setParameterDbType(this.parameterDbType);

			presuestado=presuestadoDataAccess.getEntity(connexion,relpresuasignacion.getid_presu_estado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presuestado;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PresuAsignacion presuasignacion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!presuasignacion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_presu_proyecto_cuenta=new ParameterValue<Long>();
					parameterMaintenanceValueid_presu_proyecto_cuenta.setValue(presuasignacion.getid_presu_proyecto_cuenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_presu_proyecto_cuenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(presuasignacion.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuecodigo_secuencial=new ParameterValue<Long>();
					parameterMaintenanceValuecodigo_secuencial.setValue(presuasignacion.getcodigo_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(presuasignacion.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(presuasignacion.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_presu_estado=new ParameterValue<Long>();
					parameterMaintenanceValueid_presu_estado.setValue(presuasignacion.getid_presu_estado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_presu_estado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(presuasignacion.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!presuasignacion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(presuasignacion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(presuasignacion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(presuasignacion.getId());
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
	
	public void setIsNewIsChangedFalsePresuAsignacion(PresuAsignacion presuasignacion)throws Exception  {		
		presuasignacion.setIsNew(false);
		presuasignacion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePresuAsignacions(List<PresuAsignacion> presuasignacions)throws Exception  {				
		for(PresuAsignacion presuasignacion:presuasignacions) {
			presuasignacion.setIsNew(false);
			presuasignacion.setIsChanged(false);
		}
	}
	
	public void generarExportarPresuAsignacion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
