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
import com.bydan.erp.nomina.util.*;//PreguntaNomiConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class PreguntaNomiDataAccess extends  PreguntaNomiDataAccessAdditional{ //PreguntaNomiDataAccessAdditional,DataAccessHelper<PreguntaNomi>
	//static Logger logger = Logger.getLogger(PreguntaNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="pregunta_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_factor_nomi,pregunta,orden)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_factor_nomi=?,pregunta=?,orden=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select preguntanomi from "+PreguntaNomiConstantesFunciones.SPERSISTENCENAME+" preguntanomi";
	public static String QUERYSELECTNATIVE="select "+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".id,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".version_row,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".id_empresa,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".id_factor_nomi,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".pregunta,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".orden from "+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME;//+" as "+PreguntaNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".id,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".version_row,"+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+".pregunta from "+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME;//+" as "+PreguntaNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PreguntaNomiConstantesFunciones.SCHEMA+"."+PreguntaNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_factor_nomi=?,pregunta=?,orden=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PREGUNTANOMI_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PREGUNTANOMI_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PREGUNTANOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PREGUNTANOMI_SELECT(?,?)";
	
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
	
	
	protected PreguntaNomiDataAccessAdditional preguntanomiDataAccessAdditional=null;
	
	public PreguntaNomiDataAccessAdditional getPreguntaNomiDataAccessAdditional() {
		return this.preguntanomiDataAccessAdditional;
	}
	
	public void setPreguntaNomiDataAccessAdditional(PreguntaNomiDataAccessAdditional preguntanomiDataAccessAdditional) {
		try {
			this.preguntanomiDataAccessAdditional=preguntanomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PreguntaNomiDataAccess() {
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
		PreguntaNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PreguntaNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PreguntaNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPreguntaNomiOriginal(PreguntaNomi preguntanomi)throws Exception  {
		preguntanomi.setPreguntaNomiOriginal((PreguntaNomi)preguntanomi.clone());		
	}
	
	public void setPreguntaNomisOriginal(List<PreguntaNomi> preguntanomis)throws Exception  {
		
		for(PreguntaNomi preguntanomi:preguntanomis){
			preguntanomi.setPreguntaNomiOriginal((PreguntaNomi)preguntanomi.clone());
		}
	}
	
	public static void setPreguntaNomiOriginalStatic(PreguntaNomi preguntanomi)throws Exception  {
		preguntanomi.setPreguntaNomiOriginal((PreguntaNomi)preguntanomi.clone());		
	}
	
	public static void setPreguntaNomisOriginalStatic(List<PreguntaNomi> preguntanomis)throws Exception  {
		
		for(PreguntaNomi preguntanomi:preguntanomis){
			preguntanomi.setPreguntaNomiOriginal((PreguntaNomi)preguntanomi.clone());
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
	
	public  PreguntaNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PreguntaNomi entity = new PreguntaNomi();		
		
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
	
	public  PreguntaNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PreguntaNomi entity = new PreguntaNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.PreguntaNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPreguntaNomiOriginal(new PreguntaNomi());
      	    	entity=super.getEntity("",entity,resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPreguntaNomi("",entity,resultSet); 
				
				//entity.setPreguntaNomiOriginal(super.getEntity("",entity.getPreguntaNomiOriginal(),resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaNomiOriginal(this.getEntityPreguntaNomi("",entity.getPreguntaNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePreguntaNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PreguntaNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PreguntaNomi entity = new PreguntaNomi();
				
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
	
	public  PreguntaNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PreguntaNomi entity = new PreguntaNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.PreguntaNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPreguntaNomiOriginal(new PreguntaNomi());
      	    	entity=super.getEntity("",entity,resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPreguntaNomi("",entity,resultSet);    
				
				//entity.setPreguntaNomiOriginal(super.getEntity("",entity.getPreguntaNomiOriginal(),resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaNomiOriginal(this.getEntityPreguntaNomi("",entity.getPreguntaNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePreguntaNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PreguntaNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PreguntaNomi entity = new PreguntaNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.PreguntaNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePreguntaNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PreguntaNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PreguntaNomi> entities = new  ArrayList<PreguntaNomi>();
		PreguntaNomi entity = new PreguntaNomi();		  
		
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
	
	public  List<PreguntaNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PreguntaNomi> entities = new  ArrayList<PreguntaNomi>();
		PreguntaNomi entity = new PreguntaNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaNomi();
      	    	entity=super.getEntity("",entity,resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPreguntaNomi("",entity,resultSet);
      	    	
				//entity.setPreguntaNomiOriginal( new PreguntaNomi());
      	    	//entity.setPreguntaNomiOriginal(super.getEntity("",entity.getPreguntaNomiOriginal(),resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaNomiOriginal(this.getEntityPreguntaNomi("",entity.getPreguntaNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePreguntaNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PreguntaNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PreguntaNomi> entities = new  ArrayList<PreguntaNomi>();
		PreguntaNomi entity = new PreguntaNomi();		  
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
	
	public  List<PreguntaNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PreguntaNomi> entities = new  ArrayList<PreguntaNomi>();
		PreguntaNomi entity = new PreguntaNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapPreguntaNomi();
					//entity.setMapPreguntaNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPreguntaNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPreguntaNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA);         		
					entity=PreguntaNomiDataAccess.getEntityPreguntaNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPreguntaNomiOriginal( new PreguntaNomi());
					////entity.setPreguntaNomiOriginal(super.getEntity("",entity.getPreguntaNomiOriginal(),resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setPreguntaNomiOriginal(this.getEntityPreguntaNomi("",entity.getPreguntaNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePreguntaNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PreguntaNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PreguntaNomi entity = new PreguntaNomi();		  
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
	
	public  PreguntaNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PreguntaNomi entity = new PreguntaNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapPreguntaNomi();
					//entity.setMapPreguntaNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPreguntaNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPreguntaNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA);         		
					entity=PreguntaNomiDataAccess.getEntityPreguntaNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPreguntaNomiOriginal( new PreguntaNomi());
					////entity.setPreguntaNomiOriginal(super.getEntity("",entity.getPreguntaNomiOriginal(),resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setPreguntaNomiOriginal(this.getEntityPreguntaNomi("",entity.getPreguntaNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePreguntaNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PreguntaNomi getEntityPreguntaNomi(String strPrefijo,PreguntaNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PreguntaNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PreguntaNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PreguntaNomiDataAccess.setFieldReflectionPreguntaNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPreguntaNomi=PreguntaNomiConstantesFunciones.getTodosTiposColumnasPreguntaNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPreguntaNomi) {
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
							field = PreguntaNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PreguntaNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PreguntaNomiDataAccess.setFieldReflectionPreguntaNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPreguntaNomi(Field field,String strPrefijo,String sColumn,PreguntaNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PreguntaNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PreguntaNomiConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaNomiConstantesFunciones.IDFACTORNOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaNomiConstantesFunciones.PREGUNTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PreguntaNomiConstantesFunciones.ORDEN:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PreguntaNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PreguntaNomi> entities = new  ArrayList<PreguntaNomi>();
		PreguntaNomi entity = new PreguntaNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PreguntaNomi();
					entity=super.getEntity("",entity,resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPreguntaNomi("",entity,resultSet);
					
					//entity.setPreguntaNomiOriginal( new PreguntaNomi());
					//entity.setPreguntaNomiOriginal(super.getEntity("",entity.getPreguntaNomiOriginal(),resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setPreguntaNomiOriginal(this.getEntityPreguntaNomi("",entity.getPreguntaNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePreguntaNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PreguntaNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PreguntaNomi> entities = new  ArrayList<PreguntaNomi>();
		PreguntaNomi entity = new PreguntaNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PreguntaNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaNomi> entities = new  ArrayList<PreguntaNomi>();
		PreguntaNomi entity = new PreguntaNomi();		  
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
	
	public  List<PreguntaNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaNomi> entities = new  ArrayList<PreguntaNomi>();
		PreguntaNomi entity = new PreguntaNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaNomi();
      	    	entity=super.getEntity("",entity,resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPreguntaNomi("",entity,resultSet);
      	    	
				//entity.setPreguntaNomiOriginal( new PreguntaNomi());
      	    	//entity.setPreguntaNomiOriginal(super.getEntity("",entity.getPreguntaNomiOriginal(),resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaNomiOriginal(this.getEntityPreguntaNomi("",entity.getPreguntaNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePreguntaNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PreguntaNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaNomi> entities = new  ArrayList<PreguntaNomi>();
		PreguntaNomi entity = new PreguntaNomi();		  
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
	
	public  List<PreguntaNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaNomi> entities = new  ArrayList<PreguntaNomi>();
		PreguntaNomi entity = new PreguntaNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaNomi();
      	    	entity=super.getEntity("",entity,resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPreguntaNomi("",entity,resultSet);
      	    	
				//entity.setPreguntaNomiOriginal( new PreguntaNomi());
      	    	//entity.setPreguntaNomiOriginal(super.getEntity("",entity.getPreguntaNomiOriginal(),resultSet,PreguntaNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaNomiOriginal(this.getEntityPreguntaNomi("",entity.getPreguntaNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePreguntaNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PreguntaNomi getEntityPreguntaNomi(String strPrefijo,PreguntaNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PreguntaNomiConstantesFunciones.IDEMPRESA));
				entity.setid_factor_nomi(resultSet.getLong(strPrefijo+PreguntaNomiConstantesFunciones.IDFACTORNOMI));
				entity.setpregunta(resultSet.getString(strPrefijo+PreguntaNomiConstantesFunciones.PREGUNTA));
				entity.setorden(resultSet.getInt(strPrefijo+PreguntaNomiConstantesFunciones.ORDEN));
			} else {
				entity.setpregunta(resultSet.getString(strPrefijo+PreguntaNomiConstantesFunciones.PREGUNTA));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPreguntaNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PreguntaNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PreguntaNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PreguntaNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PreguntaNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PreguntaNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PreguntaNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PreguntaNomiDataAccess.TABLENAME,PreguntaNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			PreguntaNomiDataAccess.setPreguntaNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PreguntaNomi relpreguntanomi)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpreguntanomi.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public FactorNomi getFactorNomi(Connexion connexion,PreguntaNomi relpreguntanomi)throws SQLException,Exception {

		FactorNomi factornomi= new FactorNomi();

		try {
			FactorNomiDataAccess factornomiDataAccess=new FactorNomiDataAccess();

			factornomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			factornomiDataAccess.setConnexionType(this.connexionType);
			factornomiDataAccess.setParameterDbType(this.parameterDbType);

			factornomi=factornomiDataAccess.getEntity(connexion,relpreguntanomi.getid_factor_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factornomi;

	}


		
		public List<FormatoNomiPreguntaNomi> getFormatoNomiPreguntaNomis(Connexion connexion,PreguntaNomi preguntanomi)throws SQLException,Exception {

		List<FormatoNomiPreguntaNomi> formatonomipreguntanomis= new ArrayList<FormatoNomiPreguntaNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PreguntaNomiConstantesFunciones.SCHEMA+".pregunta_nomi ON "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+".formato_nomi_pregunta_nomi.id_pregunta_nomi="+PreguntaNomiConstantesFunciones.SCHEMA+".pregunta_nomi.id WHERE "+PreguntaNomiConstantesFunciones.SCHEMA+".pregunta_nomi.id="+String.valueOf(preguntanomi.getId());
			} else {
				sQuery=" INNER JOIN formatonomipreguntanomi.PreguntaNomi WHERE formatonomipreguntanomi.PreguntaNomi.id="+String.valueOf(preguntanomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormatoNomiPreguntaNomiDataAccess formatonomipreguntanomiDataAccess=new FormatoNomiPreguntaNomiDataAccess();

			formatonomipreguntanomiDataAccess.setConnexionType(this.connexionType);
			formatonomipreguntanomiDataAccess.setParameterDbType(this.parameterDbType);
			formatonomipreguntanomis=formatonomipreguntanomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatonomipreguntanomis;

	}

	public List<DetalleEvaluacionNomi> getDetalleEvaluacionNomis(Connexion connexion,PreguntaNomi preguntanomi)throws SQLException,Exception {

		List<DetalleEvaluacionNomi> detalleevaluacionnomis= new ArrayList<DetalleEvaluacionNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PreguntaNomiConstantesFunciones.SCHEMA+".pregunta_nomi ON "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+".detalle_evaluacion_nomi.id_pregunta_nomi="+PreguntaNomiConstantesFunciones.SCHEMA+".pregunta_nomi.id WHERE "+PreguntaNomiConstantesFunciones.SCHEMA+".pregunta_nomi.id="+String.valueOf(preguntanomi.getId());
			} else {
				sQuery=" INNER JOIN detalleevaluacionnomi.PreguntaNomi WHERE detalleevaluacionnomi.PreguntaNomi.id="+String.valueOf(preguntanomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleEvaluacionNomiDataAccess detalleevaluacionnomiDataAccess=new DetalleEvaluacionNomiDataAccess();

			detalleevaluacionnomiDataAccess.setConnexionType(this.connexionType);
			detalleevaluacionnomiDataAccess.setParameterDbType(this.parameterDbType);
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleevaluacionnomis;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PreguntaNomi preguntanomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!preguntanomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(preguntanomi.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factor_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_factor_nomi.setValue(preguntanomi.getid_factor_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factor_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepregunta=new ParameterValue<String>();
					parameterMaintenanceValuepregunta.setValue(preguntanomi.getpregunta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepregunta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueorden=new ParameterValue<Integer>();
					parameterMaintenanceValueorden.setValue(preguntanomi.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
						if(!preguntanomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(preguntanomi.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(preguntanomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(preguntanomi.getId());
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
	
	public void setIsNewIsChangedFalsePreguntaNomi(PreguntaNomi preguntanomi)throws Exception  {		
		preguntanomi.setIsNew(false);
		preguntanomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePreguntaNomis(List<PreguntaNomi> preguntanomis)throws Exception  {				
		for(PreguntaNomi preguntanomi:preguntanomis) {
			preguntanomi.setIsNew(false);
			preguntanomi.setIsChanged(false);
		}
	}
	
	public void generarExportarPreguntaNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
