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
import com.bydan.erp.nomina.util.*;//EnfermedadConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class EnfermedadDataAccess extends  EnfermedadDataAccessAdditional{ //EnfermedadDataAccessAdditional,DataAccessHelper<Enfermedad>
	//static Logger logger = Logger.getLogger(EnfermedadDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="enfermedad";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_enfermedad,nombre,descripcion)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_enfermedad=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select enfermedad from "+EnfermedadConstantesFunciones.SPERSISTENCENAME+" enfermedad";
	public static String QUERYSELECTNATIVE="select "+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".id,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".version_row,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".id_empresa,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".id_tipo_enfermedad,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".nombre,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".descripcion from "+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME;//+" as "+EnfermedadConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".id,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".version_row,"+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+".nombre from "+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME;//+" as "+EnfermedadConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EnfermedadConstantesFunciones.SCHEMA+"."+EnfermedadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_enfermedad=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ENFERMEDAD_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ENFERMEDAD_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ENFERMEDAD_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ENFERMEDAD_SELECT(?,?)";
	
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
	
	
	protected EnfermedadDataAccessAdditional enfermedadDataAccessAdditional=null;
	
	public EnfermedadDataAccessAdditional getEnfermedadDataAccessAdditional() {
		return this.enfermedadDataAccessAdditional;
	}
	
	public void setEnfermedadDataAccessAdditional(EnfermedadDataAccessAdditional enfermedadDataAccessAdditional) {
		try {
			this.enfermedadDataAccessAdditional=enfermedadDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EnfermedadDataAccess() {
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
		EnfermedadDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EnfermedadDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EnfermedadDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEnfermedadOriginal(Enfermedad enfermedad)throws Exception  {
		enfermedad.setEnfermedadOriginal((Enfermedad)enfermedad.clone());		
	}
	
	public void setEnfermedadsOriginal(List<Enfermedad> enfermedads)throws Exception  {
		
		for(Enfermedad enfermedad:enfermedads){
			enfermedad.setEnfermedadOriginal((Enfermedad)enfermedad.clone());
		}
	}
	
	public static void setEnfermedadOriginalStatic(Enfermedad enfermedad)throws Exception  {
		enfermedad.setEnfermedadOriginal((Enfermedad)enfermedad.clone());		
	}
	
	public static void setEnfermedadsOriginalStatic(List<Enfermedad> enfermedads)throws Exception  {
		
		for(Enfermedad enfermedad:enfermedads){
			enfermedad.setEnfermedadOriginal((Enfermedad)enfermedad.clone());
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
	
	public  Enfermedad getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Enfermedad entity = new Enfermedad();		
		
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
	
	public  Enfermedad getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Enfermedad entity = new Enfermedad();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.Enfermedad.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEnfermedadOriginal(new Enfermedad());
      	    	entity=super.getEntity("",entity,resultSet,EnfermedadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEnfermedad("",entity,resultSet); 
				
				//entity.setEnfermedadOriginal(super.getEntity("",entity.getEnfermedadOriginal(),resultSet,EnfermedadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEnfermedadOriginal(this.getEntityEnfermedad("",entity.getEnfermedadOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEnfermedad(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Enfermedad getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Enfermedad entity = new Enfermedad();
				
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
	
	public  Enfermedad getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Enfermedad entity = new Enfermedad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EnfermedadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Enfermedad.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEnfermedadOriginal(new Enfermedad());
      	    	entity=super.getEntity("",entity,resultSet,EnfermedadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEnfermedad("",entity,resultSet);    
				
				//entity.setEnfermedadOriginal(super.getEntity("",entity.getEnfermedadOriginal(),resultSet,EnfermedadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEnfermedadOriginal(this.getEntityEnfermedad("",entity.getEnfermedadOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEnfermedad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Enfermedad
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Enfermedad entity = new Enfermedad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EnfermedadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Enfermedad.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEnfermedad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Enfermedad> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Enfermedad> entities = new  ArrayList<Enfermedad>();
		Enfermedad entity = new Enfermedad();		  
		
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
	
	public  List<Enfermedad> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Enfermedad> entities = new  ArrayList<Enfermedad>();
		Enfermedad entity = new Enfermedad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EnfermedadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Enfermedad();
      	    	entity=super.getEntity("",entity,resultSet,EnfermedadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEnfermedad("",entity,resultSet);
      	    	
				//entity.setEnfermedadOriginal( new Enfermedad());
      	    	//entity.setEnfermedadOriginal(super.getEntity("",entity.getEnfermedadOriginal(),resultSet,EnfermedadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEnfermedadOriginal(this.getEntityEnfermedad("",entity.getEnfermedadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEnfermedads(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEnfermedad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Enfermedad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Enfermedad> entities = new  ArrayList<Enfermedad>();
		Enfermedad entity = new Enfermedad();		  
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
	
	public  List<Enfermedad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Enfermedad> entities = new  ArrayList<Enfermedad>();
		Enfermedad entity = new Enfermedad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Enfermedad();
				
				if(conMapGenerico) {
					entity.inicializarMapEnfermedad();
					//entity.setMapEnfermedad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEnfermedadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEnfermedad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EnfermedadDataAccess.ISWITHSCHEMA);         		
					entity=EnfermedadDataAccess.getEntityEnfermedad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEnfermedadOriginal( new Enfermedad());
					////entity.setEnfermedadOriginal(super.getEntity("",entity.getEnfermedadOriginal(),resultSet,EnfermedadDataAccess.ISWITHSCHEMA));         		
					////entity.setEnfermedadOriginal(this.getEntityEnfermedad("",entity.getEnfermedadOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEnfermedads(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEnfermedad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Enfermedad getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Enfermedad entity = new Enfermedad();		  
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
	
	public  Enfermedad getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Enfermedad entity = new Enfermedad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Enfermedad();
				
				if(conMapGenerico) {
					entity.inicializarMapEnfermedad();
					//entity.setMapEnfermedad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEnfermedadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEnfermedad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EnfermedadDataAccess.ISWITHSCHEMA);         		
					entity=EnfermedadDataAccess.getEntityEnfermedad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEnfermedadOriginal( new Enfermedad());
					////entity.setEnfermedadOriginal(super.getEntity("",entity.getEnfermedadOriginal(),resultSet,EnfermedadDataAccess.ISWITHSCHEMA));         		
					////entity.setEnfermedadOriginal(this.getEntityEnfermedad("",entity.getEnfermedadOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEnfermedad(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEnfermedad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Enfermedad getEntityEnfermedad(String strPrefijo,Enfermedad entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Enfermedad.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Enfermedad.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EnfermedadDataAccess.setFieldReflectionEnfermedad(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEnfermedad=EnfermedadConstantesFunciones.getTodosTiposColumnasEnfermedad();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEnfermedad) {
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
							field = Enfermedad.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Enfermedad.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EnfermedadDataAccess.setFieldReflectionEnfermedad(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEnfermedad(Field field,String strPrefijo,String sColumn,Enfermedad entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EnfermedadConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EnfermedadConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EnfermedadConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EnfermedadConstantesFunciones.IDTIPOENFERMEDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EnfermedadConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EnfermedadConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Enfermedad>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Enfermedad> entities = new  ArrayList<Enfermedad>();
		Enfermedad entity = new Enfermedad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EnfermedadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Enfermedad();
					entity=super.getEntity("",entity,resultSet,EnfermedadDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEnfermedad("",entity,resultSet);
					
					//entity.setEnfermedadOriginal( new Enfermedad());
					//entity.setEnfermedadOriginal(super.getEntity("",entity.getEnfermedadOriginal(),resultSet,EnfermedadDataAccess.ISWITHSCHEMA));         		
					//entity.setEnfermedadOriginal(this.getEntityEnfermedad("",entity.getEnfermedadOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEnfermedads(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEnfermedad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Enfermedad>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Enfermedad> entities = new  ArrayList<Enfermedad>();
		Enfermedad entity = new Enfermedad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EnfermedadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EnfermedadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Enfermedad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Enfermedad> entities = new  ArrayList<Enfermedad>();
		Enfermedad entity = new Enfermedad();		  
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
	
	public  List<Enfermedad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Enfermedad> entities = new  ArrayList<Enfermedad>();
		Enfermedad entity = new Enfermedad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Enfermedad();
      	    	entity=super.getEntity("",entity,resultSet,EnfermedadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEnfermedad("",entity,resultSet);
      	    	
				//entity.setEnfermedadOriginal( new Enfermedad());
      	    	//entity.setEnfermedadOriginal(super.getEntity("",entity.getEnfermedadOriginal(),resultSet,EnfermedadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEnfermedadOriginal(this.getEntityEnfermedad("",entity.getEnfermedadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEnfermedads(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEnfermedad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Enfermedad> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Enfermedad> entities = new  ArrayList<Enfermedad>();
		Enfermedad entity = new Enfermedad();		  
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
	
	public  List<Enfermedad> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Enfermedad> entities = new  ArrayList<Enfermedad>();
		Enfermedad entity = new Enfermedad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Enfermedad();
      	    	entity=super.getEntity("",entity,resultSet,EnfermedadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEnfermedad("",entity,resultSet);
      	    	
				//entity.setEnfermedadOriginal( new Enfermedad());
      	    	//entity.setEnfermedadOriginal(super.getEntity("",entity.getEnfermedadOriginal(),resultSet,EnfermedadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEnfermedadOriginal(this.getEntityEnfermedad("",entity.getEnfermedadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEnfermedads(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Enfermedad getEntityEnfermedad(String strPrefijo,Enfermedad entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EnfermedadConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_enfermedad(resultSet.getLong(strPrefijo+EnfermedadConstantesFunciones.IDTIPOENFERMEDAD));
				entity.setnombre(resultSet.getString(strPrefijo+EnfermedadConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+EnfermedadConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+EnfermedadConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEnfermedad(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Enfermedad entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EnfermedadDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EnfermedadDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EnfermedadDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EnfermedadDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EnfermedadConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EnfermedadDataAccess.TABLENAME,EnfermedadDataAccess.ISWITHSTOREPROCEDURES);
			
			EnfermedadDataAccess.setEnfermedadOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Enfermedad relenfermedad)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relenfermedad.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoEnfermedad getTipoEnfermedad(Connexion connexion,Enfermedad relenfermedad)throws SQLException,Exception {

		TipoEnfermedad tipoenfermedad= new TipoEnfermedad();

		try {
			TipoEnfermedadDataAccess tipoenfermedadDataAccess=new TipoEnfermedadDataAccess();

			tipoenfermedadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoenfermedadDataAccess.setConnexionType(this.connexionType);
			tipoenfermedadDataAccess.setParameterDbType(this.parameterDbType);

			tipoenfermedad=tipoenfermedadDataAccess.getEntity(connexion,relenfermedad.getid_tipo_enfermedad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoenfermedad;

	}


		
		public List<EmpleadoEnfer> getEmpleadoEnfers(Connexion connexion,Enfermedad enfermedad)throws SQLException,Exception {

		List<EmpleadoEnfer> empleadoenfers= new ArrayList<EmpleadoEnfer>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EnfermedadConstantesFunciones.SCHEMA+".enfermedad ON "+EmpleadoEnferConstantesFunciones.SCHEMA+".empleado_enfer.id_enfermedad="+EnfermedadConstantesFunciones.SCHEMA+".enfermedad.id WHERE "+EnfermedadConstantesFunciones.SCHEMA+".enfermedad.id="+String.valueOf(enfermedad.getId());
			} else {
				sQuery=" INNER JOIN empleadoenfer.Enfermedad WHERE empleadoenfer.Enfermedad.id="+String.valueOf(enfermedad.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoEnferDataAccess empleadoenferDataAccess=new EmpleadoEnferDataAccess();

			empleadoenferDataAccess.setConnexionType(this.connexionType);
			empleadoenferDataAccess.setParameterDbType(this.parameterDbType);
			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadoenfers;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Enfermedad enfermedad) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!enfermedad.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(enfermedad.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_enfermedad=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_enfermedad.setValue(enfermedad.getid_tipo_enfermedad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_enfermedad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(enfermedad.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(enfermedad.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!enfermedad.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(enfermedad.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(enfermedad.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(enfermedad.getId());
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
	
	public void setIsNewIsChangedFalseEnfermedad(Enfermedad enfermedad)throws Exception  {		
		enfermedad.setIsNew(false);
		enfermedad.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEnfermedads(List<Enfermedad> enfermedads)throws Exception  {				
		for(Enfermedad enfermedad:enfermedads) {
			enfermedad.setIsNew(false);
			enfermedad.setIsChanged(false);
		}
	}
	
	public void generarExportarEnfermedad(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
