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
import com.bydan.erp.nomina.util.*;//RasgoPersonalConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class RasgoPersonalDataAccess extends  RasgoPersonalDataAccessAdditional{ //RasgoPersonalDataAccessAdditional,DataAccessHelper<RasgoPersonal>
	//static Logger logger = Logger.getLogger(RasgoPersonalDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="rasgo_personal";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_tipo_rasgo_personal,descripcion)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_tipo_rasgo_personal=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select rasgopersonal from "+RasgoPersonalConstantesFunciones.SPERSISTENCENAME+" rasgopersonal";
	public static String QUERYSELECTNATIVE="select "+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".id,"+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".version_row,"+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".id_empresa,"+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".id_empleado,"+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".id_tipo_rasgo_personal,"+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".descripcion from "+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME;//+" as "+RasgoPersonalConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".id,"+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".version_row from "+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME;//+" as "+RasgoPersonalConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_tipo_rasgo_personal=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RASGOPERSONAL_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RASGOPERSONAL_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RASGOPERSONAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RASGOPERSONAL_SELECT(?,?)";
	
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
	
	
	protected RasgoPersonalDataAccessAdditional rasgopersonalDataAccessAdditional=null;
	
	public RasgoPersonalDataAccessAdditional getRasgoPersonalDataAccessAdditional() {
		return this.rasgopersonalDataAccessAdditional;
	}
	
	public void setRasgoPersonalDataAccessAdditional(RasgoPersonalDataAccessAdditional rasgopersonalDataAccessAdditional) {
		try {
			this.rasgopersonalDataAccessAdditional=rasgopersonalDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RasgoPersonalDataAccess() {
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
		RasgoPersonalDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RasgoPersonalDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RasgoPersonalDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRasgoPersonalOriginal(RasgoPersonal rasgopersonal)throws Exception  {
		rasgopersonal.setRasgoPersonalOriginal((RasgoPersonal)rasgopersonal.clone());		
	}
	
	public void setRasgoPersonalsOriginal(List<RasgoPersonal> rasgopersonals)throws Exception  {
		
		for(RasgoPersonal rasgopersonal:rasgopersonals){
			rasgopersonal.setRasgoPersonalOriginal((RasgoPersonal)rasgopersonal.clone());
		}
	}
	
	public static void setRasgoPersonalOriginalStatic(RasgoPersonal rasgopersonal)throws Exception  {
		rasgopersonal.setRasgoPersonalOriginal((RasgoPersonal)rasgopersonal.clone());		
	}
	
	public static void setRasgoPersonalsOriginalStatic(List<RasgoPersonal> rasgopersonals)throws Exception  {
		
		for(RasgoPersonal rasgopersonal:rasgopersonals){
			rasgopersonal.setRasgoPersonalOriginal((RasgoPersonal)rasgopersonal.clone());
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
	
	public  RasgoPersonal getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RasgoPersonal entity = new RasgoPersonal();		
		
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
	
	public  RasgoPersonal getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RasgoPersonal entity = new RasgoPersonal();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.RasgoPersonal.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRasgoPersonalOriginal(new RasgoPersonal());
      	    	entity=super.getEntity("",entity,resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRasgoPersonal("",entity,resultSet); 
				
				//entity.setRasgoPersonalOriginal(super.getEntity("",entity.getRasgoPersonalOriginal(),resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRasgoPersonalOriginal(this.getEntityRasgoPersonal("",entity.getRasgoPersonalOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRasgoPersonal(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RasgoPersonal getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RasgoPersonal entity = new RasgoPersonal();
				
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
	
	public  RasgoPersonal getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RasgoPersonal entity = new RasgoPersonal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RasgoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.RasgoPersonal.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRasgoPersonalOriginal(new RasgoPersonal());
      	    	entity=super.getEntity("",entity,resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRasgoPersonal("",entity,resultSet);    
				
				//entity.setRasgoPersonalOriginal(super.getEntity("",entity.getRasgoPersonalOriginal(),resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRasgoPersonalOriginal(this.getEntityRasgoPersonal("",entity.getRasgoPersonalOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRasgoPersonal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RasgoPersonal
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RasgoPersonal entity = new RasgoPersonal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RasgoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.RasgoPersonal.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRasgoPersonal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RasgoPersonal> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RasgoPersonal> entities = new  ArrayList<RasgoPersonal>();
		RasgoPersonal entity = new RasgoPersonal();		  
		
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
	
	public  List<RasgoPersonal> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RasgoPersonal> entities = new  ArrayList<RasgoPersonal>();
		RasgoPersonal entity = new RasgoPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RasgoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RasgoPersonal();
      	    	entity=super.getEntity("",entity,resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRasgoPersonal("",entity,resultSet);
      	    	
				//entity.setRasgoPersonalOriginal( new RasgoPersonal());
      	    	//entity.setRasgoPersonalOriginal(super.getEntity("",entity.getRasgoPersonalOriginal(),resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRasgoPersonalOriginal(this.getEntityRasgoPersonal("",entity.getRasgoPersonalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRasgoPersonals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRasgoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RasgoPersonal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RasgoPersonal> entities = new  ArrayList<RasgoPersonal>();
		RasgoPersonal entity = new RasgoPersonal();		  
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
	
	public  List<RasgoPersonal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RasgoPersonal> entities = new  ArrayList<RasgoPersonal>();
		RasgoPersonal entity = new RasgoPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RasgoPersonal();
				
				if(conMapGenerico) {
					entity.inicializarMapRasgoPersonal();
					//entity.setMapRasgoPersonal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRasgoPersonalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRasgoPersonal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA);         		
					entity=RasgoPersonalDataAccess.getEntityRasgoPersonal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRasgoPersonalOriginal( new RasgoPersonal());
					////entity.setRasgoPersonalOriginal(super.getEntity("",entity.getRasgoPersonalOriginal(),resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA));         		
					////entity.setRasgoPersonalOriginal(this.getEntityRasgoPersonal("",entity.getRasgoPersonalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRasgoPersonals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRasgoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RasgoPersonal getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RasgoPersonal entity = new RasgoPersonal();		  
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
	
	public  RasgoPersonal getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RasgoPersonal entity = new RasgoPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RasgoPersonal();
				
				if(conMapGenerico) {
					entity.inicializarMapRasgoPersonal();
					//entity.setMapRasgoPersonal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRasgoPersonalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRasgoPersonal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA);         		
					entity=RasgoPersonalDataAccess.getEntityRasgoPersonal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRasgoPersonalOriginal( new RasgoPersonal());
					////entity.setRasgoPersonalOriginal(super.getEntity("",entity.getRasgoPersonalOriginal(),resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA));         		
					////entity.setRasgoPersonalOriginal(this.getEntityRasgoPersonal("",entity.getRasgoPersonalOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRasgoPersonal(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRasgoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RasgoPersonal getEntityRasgoPersonal(String strPrefijo,RasgoPersonal entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RasgoPersonal.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RasgoPersonal.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RasgoPersonalDataAccess.setFieldReflectionRasgoPersonal(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRasgoPersonal=RasgoPersonalConstantesFunciones.getTodosTiposColumnasRasgoPersonal();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRasgoPersonal) {
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
							field = RasgoPersonal.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RasgoPersonal.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RasgoPersonalDataAccess.setFieldReflectionRasgoPersonal(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRasgoPersonal(Field field,String strPrefijo,String sColumn,RasgoPersonal entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RasgoPersonalConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RasgoPersonalConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RasgoPersonalConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RasgoPersonalConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RasgoPersonalConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RasgoPersonal>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RasgoPersonal> entities = new  ArrayList<RasgoPersonal>();
		RasgoPersonal entity = new RasgoPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RasgoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RasgoPersonal();
					entity=super.getEntity("",entity,resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRasgoPersonal("",entity,resultSet);
					
					//entity.setRasgoPersonalOriginal( new RasgoPersonal());
					//entity.setRasgoPersonalOriginal(super.getEntity("",entity.getRasgoPersonalOriginal(),resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA));         		
					//entity.setRasgoPersonalOriginal(this.getEntityRasgoPersonal("",entity.getRasgoPersonalOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRasgoPersonals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRasgoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RasgoPersonal>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RasgoPersonal> entities = new  ArrayList<RasgoPersonal>();
		RasgoPersonal entity = new RasgoPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RasgoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RasgoPersonal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RasgoPersonal> entities = new  ArrayList<RasgoPersonal>();
		RasgoPersonal entity = new RasgoPersonal();		  
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
	
	public  List<RasgoPersonal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RasgoPersonal> entities = new  ArrayList<RasgoPersonal>();
		RasgoPersonal entity = new RasgoPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RasgoPersonal();
      	    	entity=super.getEntity("",entity,resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRasgoPersonal("",entity,resultSet);
      	    	
				//entity.setRasgoPersonalOriginal( new RasgoPersonal());
      	    	//entity.setRasgoPersonalOriginal(super.getEntity("",entity.getRasgoPersonalOriginal(),resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRasgoPersonalOriginal(this.getEntityRasgoPersonal("",entity.getRasgoPersonalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRasgoPersonals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRasgoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RasgoPersonal> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RasgoPersonal> entities = new  ArrayList<RasgoPersonal>();
		RasgoPersonal entity = new RasgoPersonal();		  
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
	
	public  List<RasgoPersonal> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RasgoPersonal> entities = new  ArrayList<RasgoPersonal>();
		RasgoPersonal entity = new RasgoPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RasgoPersonal();
      	    	entity=super.getEntity("",entity,resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRasgoPersonal("",entity,resultSet);
      	    	
				//entity.setRasgoPersonalOriginal( new RasgoPersonal());
      	    	//entity.setRasgoPersonalOriginal(super.getEntity("",entity.getRasgoPersonalOriginal(),resultSet,RasgoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRasgoPersonalOriginal(this.getEntityRasgoPersonal("",entity.getRasgoPersonalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRasgoPersonals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RasgoPersonal getEntityRasgoPersonal(String strPrefijo,RasgoPersonal entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RasgoPersonalConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+RasgoPersonalConstantesFunciones.IDEMPLEADO));
				entity.setid_tipo_rasgo_personal(resultSet.getLong(strPrefijo+RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+RasgoPersonalConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRasgoPersonal(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RasgoPersonal entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RasgoPersonalDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RasgoPersonalDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RasgoPersonalDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RasgoPersonalDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RasgoPersonalConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RasgoPersonalDataAccess.TABLENAME,RasgoPersonalDataAccess.ISWITHSTOREPROCEDURES);
			
			RasgoPersonalDataAccess.setRasgoPersonalOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,RasgoPersonal relrasgopersonal)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relrasgopersonal.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,RasgoPersonal relrasgopersonal)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relrasgopersonal.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoRasgoPersonal getTipoRasgoPersonal(Connexion connexion,RasgoPersonal relrasgopersonal)throws SQLException,Exception {

		TipoRasgoPersonal tiporasgopersonal= new TipoRasgoPersonal();

		try {
			TipoRasgoPersonalDataAccess tiporasgopersonalDataAccess=new TipoRasgoPersonalDataAccess();

			tiporasgopersonalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporasgopersonalDataAccess.setConnexionType(this.connexionType);
			tiporasgopersonalDataAccess.setParameterDbType(this.parameterDbType);

			tiporasgopersonal=tiporasgopersonalDataAccess.getEntity(connexion,relrasgopersonal.getid_tipo_rasgo_personal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporasgopersonal;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RasgoPersonal rasgopersonal) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!rasgopersonal.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(rasgopersonal.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(rasgopersonal.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_rasgo_personal=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_rasgo_personal.setValue(rasgopersonal.getid_tipo_rasgo_personal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_rasgo_personal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(rasgopersonal.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!rasgopersonal.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(rasgopersonal.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(rasgopersonal.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(rasgopersonal.getId());
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
	
	public void setIsNewIsChangedFalseRasgoPersonal(RasgoPersonal rasgopersonal)throws Exception  {		
		rasgopersonal.setIsNew(false);
		rasgopersonal.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRasgoPersonals(List<RasgoPersonal> rasgopersonals)throws Exception  {				
		for(RasgoPersonal rasgopersonal:rasgopersonals) {
			rasgopersonal.setIsNew(false);
			rasgopersonal.setIsChanged(false);
		}
	}
	
	public void generarExportarRasgoPersonal(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
