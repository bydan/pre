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
package com.bydan.erp.seguridad.business.dataaccess;

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

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.*;//PerfilAccionConstantesFunciones;










@SuppressWarnings("unused")
final public class PerfilAccionDataAccess extends  PerfilAccionDataAccessAdditional{ //PerfilAccionDataAccessAdditional,DataAccessHelper<PerfilAccion>
	//static Logger logger = Logger.getLogger(PerfilAccionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="perfil_accion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+"(version_row,id_perfil,id_accion,ejecusion,estado)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_perfil=?,id_accion=?,ejecusion=?,estado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select perfilaccion from "+PerfilAccionConstantesFunciones.SPERSISTENCENAME+" perfilaccion";
	public static String QUERYSELECTNATIVE="select "+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".id,"+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".version_row,"+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".id_perfil,"+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".id_accion,"+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".ejecusion,"+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".estado from "+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME;//+" as "+PerfilAccionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".id,"+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+".version_row from "+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME;//+" as "+PerfilAccionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_perfil=?,id_accion=?,ejecusion=?,estado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PERFILACCION_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PERFILACCION_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PERFILACCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PERFILACCION_SELECT(?,?)";
	
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
	
	
	protected PerfilAccionDataAccessAdditional perfilaccionDataAccessAdditional=null;
	
	public PerfilAccionDataAccessAdditional getPerfilAccionDataAccessAdditional() {
		return this.perfilaccionDataAccessAdditional;
	}
	
	public void setPerfilAccionDataAccessAdditional(PerfilAccionDataAccessAdditional perfilaccionDataAccessAdditional) {
		try {
			this.perfilaccionDataAccessAdditional=perfilaccionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PerfilAccionDataAccess() {
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
		PerfilAccionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PerfilAccionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PerfilAccionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPerfilAccionOriginal(PerfilAccion perfilaccion)throws Exception  {
		perfilaccion.setPerfilAccionOriginal((PerfilAccion)perfilaccion.clone());		
	}
	
	public void setPerfilAccionsOriginal(List<PerfilAccion> perfilaccions)throws Exception  {
		
		for(PerfilAccion perfilaccion:perfilaccions){
			perfilaccion.setPerfilAccionOriginal((PerfilAccion)perfilaccion.clone());
		}
	}
	
	public static void setPerfilAccionOriginalStatic(PerfilAccion perfilaccion)throws Exception  {
		perfilaccion.setPerfilAccionOriginal((PerfilAccion)perfilaccion.clone());		
	}
	
	public static void setPerfilAccionsOriginalStatic(List<PerfilAccion> perfilaccions)throws Exception  {
		
		for(PerfilAccion perfilaccion:perfilaccions){
			perfilaccion.setPerfilAccionOriginal((PerfilAccion)perfilaccion.clone());
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
	
	public  PerfilAccion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PerfilAccion entity = new PerfilAccion();		
		
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
	
	public  PerfilAccion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PerfilAccion entity = new PerfilAccion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.PerfilAccion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPerfilAccionOriginal(new PerfilAccion());
      	    	entity=super.getEntity("",entity,resultSet,PerfilAccionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPerfilAccion("",entity,resultSet); 
				
				entity.setPerfilAccionOriginal(super.getEntity("",entity.getPerfilAccionOriginal(),resultSet,PerfilAccionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilAccionOriginal(this.getEntityPerfilAccion("",entity.getPerfilAccionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePerfilAccion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PerfilAccion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PerfilAccion entity = new PerfilAccion();
				
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
	
	public  PerfilAccion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PerfilAccion entity = new PerfilAccion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilAccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.PerfilAccion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPerfilAccionOriginal(new PerfilAccion());
      	    	entity=super.getEntity("",entity,resultSet,PerfilAccionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPerfilAccion("",entity,resultSet);    
				
				entity.setPerfilAccionOriginal(super.getEntity("",entity.getPerfilAccionOriginal(),resultSet,PerfilAccionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilAccionOriginal(this.getEntityPerfilAccion("",entity.getPerfilAccionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePerfilAccion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PerfilAccion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PerfilAccion entity = new PerfilAccion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilAccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.PerfilAccion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePerfilAccion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PerfilAccion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PerfilAccion> entities = new  ArrayList<PerfilAccion>();
		PerfilAccion entity = new PerfilAccion();		  
		
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
	
	public  List<PerfilAccion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PerfilAccion> entities = new  ArrayList<PerfilAccion>();
		PerfilAccion entity = new PerfilAccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilAccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilAccion();
      	    	entity=super.getEntity("",entity,resultSet,PerfilAccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfilAccion("",entity,resultSet);
      	    	
				entity.setPerfilAccionOriginal( new PerfilAccion());
      	    	entity.setPerfilAccionOriginal(super.getEntity("",entity.getPerfilAccionOriginal(),resultSet,PerfilAccionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilAccionOriginal(this.getEntityPerfilAccion("",entity.getPerfilAccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfilAccions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilAccion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PerfilAccion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PerfilAccion> entities = new  ArrayList<PerfilAccion>();
		PerfilAccion entity = new PerfilAccion();		  
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
	
	public  List<PerfilAccion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PerfilAccion> entities = new  ArrayList<PerfilAccion>();
		PerfilAccion entity = new PerfilAccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilAccion();
				
				if(conMapGenerico) {
					entity.inicializarMapPerfilAccion();
					//entity.setMapPerfilAccion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPerfilAccionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPerfilAccion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PerfilAccionDataAccess.ISWITHSCHEMA);         		
					entity=PerfilAccionDataAccess.getEntityPerfilAccion("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setPerfilAccionOriginal( new PerfilAccion());
					//entity.setPerfilAccionOriginal(super.getEntity("",entity.getPerfilAccionOriginal(),resultSet,PerfilAccionDataAccess.ISWITHSCHEMA));         		
					//entity.setPerfilAccionOriginal(this.getEntityPerfilAccion("",entity.getPerfilAccionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfilAccions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilAccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PerfilAccion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PerfilAccion entity = new PerfilAccion();		  
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
	
	public  PerfilAccion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PerfilAccion entity = new PerfilAccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilAccion();
				
				if(conMapGenerico) {
					entity.inicializarMapPerfilAccion();
					//entity.setMapPerfilAccion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPerfilAccionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPerfilAccion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PerfilAccionDataAccess.ISWITHSCHEMA);         		
					entity=PerfilAccionDataAccess.getEntityPerfilAccion("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setPerfilAccionOriginal( new PerfilAccion());
					//entity.setPerfilAccionOriginal(super.getEntity("",entity.getPerfilAccionOriginal(),resultSet,PerfilAccionDataAccess.ISWITHSCHEMA));         		
					//entity.setPerfilAccionOriginal(this.getEntityPerfilAccion("",entity.getPerfilAccionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePerfilAccion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilAccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PerfilAccion getEntityPerfilAccion(String strPrefijo,PerfilAccion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PerfilAccion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PerfilAccion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PerfilAccionDataAccess.setFieldReflectionPerfilAccion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPerfilAccion=PerfilAccionConstantesFunciones.getTodosTiposColumnasPerfilAccion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPerfilAccion) {
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
							field = PerfilAccion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PerfilAccion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PerfilAccionDataAccess.setFieldReflectionPerfilAccion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPerfilAccion(Field field,String strPrefijo,String sColumn,PerfilAccion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PerfilAccionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilAccionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PerfilAccionConstantesFunciones.IDPERFIL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilAccionConstantesFunciones.IDACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilAccionConstantesFunciones.EJECUSION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilAccionConstantesFunciones.ESTADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PerfilAccion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PerfilAccion> entities = new  ArrayList<PerfilAccion>();
		PerfilAccion entity = new PerfilAccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilAccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PerfilAccion();
					entity=super.getEntity("",entity,resultSet,PerfilAccionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPerfilAccion("",entity,resultSet);
					
					entity.setPerfilAccionOriginal( new PerfilAccion());
					entity.setPerfilAccionOriginal(super.getEntity("",entity.getPerfilAccionOriginal(),resultSet,PerfilAccionDataAccess.ISWITHSCHEMA));         		
					entity.setPerfilAccionOriginal(this.getEntityPerfilAccion("",entity.getPerfilAccionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePerfilAccions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilAccion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PerfilAccion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PerfilAccion> entities = new  ArrayList<PerfilAccion>();
		PerfilAccion entity = new PerfilAccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilAccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilAccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PerfilAccion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilAccion> entities = new  ArrayList<PerfilAccion>();
		PerfilAccion entity = new PerfilAccion();		  
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
	
	public  List<PerfilAccion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilAccion> entities = new  ArrayList<PerfilAccion>();
		PerfilAccion entity = new PerfilAccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilAccion();
      	    	entity=super.getEntity("",entity,resultSet,PerfilAccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfilAccion("",entity,resultSet);
      	    	
				entity.setPerfilAccionOriginal( new PerfilAccion());
      	    	entity.setPerfilAccionOriginal(super.getEntity("",entity.getPerfilAccionOriginal(),resultSet,PerfilAccionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilAccionOriginal(this.getEntityPerfilAccion("",entity.getPerfilAccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePerfilAccions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilAccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PerfilAccion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilAccion> entities = new  ArrayList<PerfilAccion>();
		PerfilAccion entity = new PerfilAccion();		  
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
	
	public  List<PerfilAccion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilAccion> entities = new  ArrayList<PerfilAccion>();
		PerfilAccion entity = new PerfilAccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilAccion();
      	    	entity=super.getEntity("",entity,resultSet,PerfilAccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfilAccion("",entity,resultSet);
      	    	
				entity.setPerfilAccionOriginal( new PerfilAccion());
      	    	entity.setPerfilAccionOriginal(super.getEntity("",entity.getPerfilAccionOriginal(),resultSet,PerfilAccionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilAccionOriginal(this.getEntityPerfilAccion("",entity.getPerfilAccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfilAccions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PerfilAccion getEntityPerfilAccion(String strPrefijo,PerfilAccion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_perfil(resultSet.getLong(strPrefijo+PerfilAccionConstantesFunciones.IDPERFIL));
				entity.setid_accion(resultSet.getLong(strPrefijo+PerfilAccionConstantesFunciones.IDACCION));
				entity.setejecusion(resultSet.getBoolean(strPrefijo+PerfilAccionConstantesFunciones.EJECUSION));
				entity.setestado(resultSet.getBoolean(strPrefijo+PerfilAccionConstantesFunciones.ESTADO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPerfilAccion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PerfilAccion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PerfilAccionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PerfilAccionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PerfilAccionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PerfilAccionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PerfilAccionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PerfilAccionDataAccess.TABLENAME,PerfilAccionDataAccess.ISWITHSTOREPROCEDURES);
			
			PerfilAccionDataAccess.setPerfilAccionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Perfil getPerfil(Connexion connexion,PerfilAccion relperfilaccion)throws SQLException,Exception {

		Perfil perfil= new Perfil();

		try {
			PerfilDataAccess perfilDataAccess=new PerfilDataAccess();

			perfilDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			perfilDataAccess.setConnexionType(this.connexionType);
			perfilDataAccess.setParameterDbType(this.parameterDbType);

			perfil=perfilDataAccess.getEntity(connexion,relperfilaccion.getid_perfil());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfil;

	}

	public Accion getAccion(Connexion connexion,PerfilAccion relperfilaccion)throws SQLException,Exception {

		Accion accion= new Accion();

		try {
			AccionDataAccess accionDataAccess=new AccionDataAccess();

			accionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			accionDataAccess.setConnexionType(this.connexionType);
			accionDataAccess.setParameterDbType(this.parameterDbType);

			accion=accionDataAccess.getEntity(connexion,relperfilaccion.getid_accion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return accion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PerfilAccion perfilaccion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!perfilaccion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_perfil=new ParameterValue<Long>();
					parameterMaintenanceValueid_perfil.setValue(perfilaccion.getid_perfil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_perfil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_accion=new ParameterValue<Long>();
					parameterMaintenanceValueid_accion.setValue(perfilaccion.getid_accion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_accion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueejecusion=new ParameterValue<Boolean>();
					parameterMaintenanceValueejecusion.setValue(perfilaccion.getejecusion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueejecusion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueestado=new ParameterValue<Boolean>();
					parameterMaintenanceValueestado.setValue(perfilaccion.getestado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestado);
					parametersTemp.add(parameterMaintenance);
					
						if(!perfilaccion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(perfilaccion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(perfilaccion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(perfilaccion.getId());
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
	
	public void setIsNewIsChangedFalsePerfilAccion(PerfilAccion perfilaccion)throws Exception  {		
		perfilaccion.setIsNew(false);
		perfilaccion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePerfilAccions(List<PerfilAccion> perfilaccions)throws Exception  {				
		for(PerfilAccion perfilaccion:perfilaccions) {
			perfilaccion.setIsNew(false);
			perfilaccion.setIsChanged(false);
		}
	}
	
	public void generarExportarPerfilAccion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
