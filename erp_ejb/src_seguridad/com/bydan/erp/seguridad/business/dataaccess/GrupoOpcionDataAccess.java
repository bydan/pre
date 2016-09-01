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
import com.bydan.erp.seguridad.util.*;//GrupoOpcionConstantesFunciones;










@SuppressWarnings("unused")
final public class GrupoOpcionDataAccess extends  GrupoOpcionDataAccessAdditional{ //GrupoOpcionDataAccessAdditional,DataAccessHelper<GrupoOpcion>
	//static Logger logger = Logger.getLogger(GrupoOpcionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="grupo_opcion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+"(version_row,id_modulo,codigo,nombre_principal,orden,estado)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_modulo=?,codigo=?,nombre_principal=?,orden=?,estado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select grupoopcion from "+GrupoOpcionConstantesFunciones.SPERSISTENCENAME+" grupoopcion";
	public static String QUERYSELECTNATIVE="select "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".id,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".version_row,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".id_modulo,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".codigo,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".nombre_principal,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".orden,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".estado from "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME;//+" as "+GrupoOpcionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".id,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".version_row,"+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+".nombre_principal from "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME;//+" as "+GrupoOpcionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+GrupoOpcionConstantesFunciones.SCHEMA+"."+GrupoOpcionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_modulo=?,codigo=?,nombre_principal=?,orden=?,estado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_GRUPOOPCION_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_GRUPOOPCION_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_GRUPOOPCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_GRUPOOPCION_SELECT(?,?)";
	
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
	
	
	protected GrupoOpcionDataAccessAdditional grupoopcionDataAccessAdditional=null;
	
	public GrupoOpcionDataAccessAdditional getGrupoOpcionDataAccessAdditional() {
		return this.grupoopcionDataAccessAdditional;
	}
	
	public void setGrupoOpcionDataAccessAdditional(GrupoOpcionDataAccessAdditional grupoopcionDataAccessAdditional) {
		try {
			this.grupoopcionDataAccessAdditional=grupoopcionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public GrupoOpcionDataAccess() {
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
		GrupoOpcionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		GrupoOpcionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		GrupoOpcionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setGrupoOpcionOriginal(GrupoOpcion grupoopcion)throws Exception  {
		grupoopcion.setGrupoOpcionOriginal((GrupoOpcion)grupoopcion.clone());		
	}
	
	public void setGrupoOpcionsOriginal(List<GrupoOpcion> grupoopcions)throws Exception  {
		
		for(GrupoOpcion grupoopcion:grupoopcions){
			grupoopcion.setGrupoOpcionOriginal((GrupoOpcion)grupoopcion.clone());
		}
	}
	
	public static void setGrupoOpcionOriginalStatic(GrupoOpcion grupoopcion)throws Exception  {
		grupoopcion.setGrupoOpcionOriginal((GrupoOpcion)grupoopcion.clone());		
	}
	
	public static void setGrupoOpcionsOriginalStatic(List<GrupoOpcion> grupoopcions)throws Exception  {
		
		for(GrupoOpcion grupoopcion:grupoopcions){
			grupoopcion.setGrupoOpcionOriginal((GrupoOpcion)grupoopcion.clone());
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
	
	public  GrupoOpcion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		GrupoOpcion entity = new GrupoOpcion();		
		
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
	
	public  GrupoOpcion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		GrupoOpcion entity = new GrupoOpcion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.GrupoOpcion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setGrupoOpcionOriginal(new GrupoOpcion());
      	    	entity=super.getEntity("",entity,resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGrupoOpcion("",entity,resultSet); 
				
				entity.setGrupoOpcionOriginal(super.getEntity("",entity.getGrupoOpcionOriginal(),resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setGrupoOpcionOriginal(this.getEntityGrupoOpcion("",entity.getGrupoOpcionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseGrupoOpcion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  GrupoOpcion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GrupoOpcion entity = new GrupoOpcion();
				
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
	
	public  GrupoOpcion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GrupoOpcion entity = new GrupoOpcion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.GrupoOpcion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setGrupoOpcionOriginal(new GrupoOpcion());
      	    	entity=super.getEntity("",entity,resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGrupoOpcion("",entity,resultSet);    
				
				entity.setGrupoOpcionOriginal(super.getEntity("",entity.getGrupoOpcionOriginal(),resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setGrupoOpcionOriginal(this.getEntityGrupoOpcion("",entity.getGrupoOpcionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseGrupoOpcion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //GrupoOpcion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		GrupoOpcion entity = new GrupoOpcion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.GrupoOpcion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseGrupoOpcion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<GrupoOpcion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GrupoOpcion> entities = new  ArrayList<GrupoOpcion>();
		GrupoOpcion entity = new GrupoOpcion();		  
		
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
	
	public  List<GrupoOpcion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GrupoOpcion> entities = new  ArrayList<GrupoOpcion>();
		GrupoOpcion entity = new GrupoOpcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoOpcion();
      	    	entity=super.getEntity("",entity,resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGrupoOpcion("",entity,resultSet);
      	    	
				entity.setGrupoOpcionOriginal( new GrupoOpcion());
      	    	entity.setGrupoOpcionOriginal(super.getEntity("",entity.getGrupoOpcionOriginal(),resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setGrupoOpcionOriginal(this.getEntityGrupoOpcion("",entity.getGrupoOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGrupoOpcions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoOpcion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GrupoOpcion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GrupoOpcion> entities = new  ArrayList<GrupoOpcion>();
		GrupoOpcion entity = new GrupoOpcion();		  
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
	
	public  List<GrupoOpcion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GrupoOpcion> entities = new  ArrayList<GrupoOpcion>();
		GrupoOpcion entity = new GrupoOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoOpcion();
				
				if(conMapGenerico) {
					entity.inicializarMapGrupoOpcion();
					//entity.setMapGrupoOpcion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapGrupoOpcionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGrupoOpcion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA);         		
					entity=GrupoOpcionDataAccess.getEntityGrupoOpcion("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setGrupoOpcionOriginal( new GrupoOpcion());
					//entity.setGrupoOpcionOriginal(super.getEntity("",entity.getGrupoOpcionOriginal(),resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA));         		
					//entity.setGrupoOpcionOriginal(this.getEntityGrupoOpcion("",entity.getGrupoOpcionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGrupoOpcions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public GrupoOpcion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GrupoOpcion entity = new GrupoOpcion();		  
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
	
	public  GrupoOpcion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GrupoOpcion entity = new GrupoOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoOpcion();
				
				if(conMapGenerico) {
					entity.inicializarMapGrupoOpcion();
					//entity.setMapGrupoOpcion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapGrupoOpcionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGrupoOpcion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA);         		
					entity=GrupoOpcionDataAccess.getEntityGrupoOpcion("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setGrupoOpcionOriginal( new GrupoOpcion());
					//entity.setGrupoOpcionOriginal(super.getEntity("",entity.getGrupoOpcionOriginal(),resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA));         		
					//entity.setGrupoOpcionOriginal(this.getEntityGrupoOpcion("",entity.getGrupoOpcionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseGrupoOpcion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static GrupoOpcion getEntityGrupoOpcion(String strPrefijo,GrupoOpcion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = GrupoOpcion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = GrupoOpcion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					GrupoOpcionDataAccess.setFieldReflectionGrupoOpcion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasGrupoOpcion=GrupoOpcionConstantesFunciones.getTodosTiposColumnasGrupoOpcion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasGrupoOpcion) {
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
							field = GrupoOpcion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = GrupoOpcion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						GrupoOpcionDataAccess.setFieldReflectionGrupoOpcion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionGrupoOpcion(Field field,String strPrefijo,String sColumn,GrupoOpcion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case GrupoOpcionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoOpcionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoOpcionConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoOpcionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoOpcionConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoOpcionConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case GrupoOpcionConstantesFunciones.ESTADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GrupoOpcion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<GrupoOpcion> entities = new  ArrayList<GrupoOpcion>();
		GrupoOpcion entity = new GrupoOpcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new GrupoOpcion();
					entity=super.getEntity("",entity,resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityGrupoOpcion("",entity,resultSet);
					
					entity.setGrupoOpcionOriginal( new GrupoOpcion());
					entity.setGrupoOpcionOriginal(super.getEntity("",entity.getGrupoOpcionOriginal(),resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA));         		
					entity.setGrupoOpcionOriginal(this.getEntityGrupoOpcion("",entity.getGrupoOpcionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseGrupoOpcions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoOpcion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GrupoOpcion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<GrupoOpcion> entities = new  ArrayList<GrupoOpcion>();
		GrupoOpcion entity = new GrupoOpcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<GrupoOpcion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoOpcion> entities = new  ArrayList<GrupoOpcion>();
		GrupoOpcion entity = new GrupoOpcion();		  
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
	
	public  List<GrupoOpcion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoOpcion> entities = new  ArrayList<GrupoOpcion>();
		GrupoOpcion entity = new GrupoOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoOpcion();
      	    	entity=super.getEntity("",entity,resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGrupoOpcion("",entity,resultSet);
      	    	
				entity.setGrupoOpcionOriginal( new GrupoOpcion());
      	    	entity.setGrupoOpcionOriginal(super.getEntity("",entity.getGrupoOpcionOriginal(),resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setGrupoOpcionOriginal(this.getEntityGrupoOpcion("",entity.getGrupoOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseGrupoOpcions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GrupoOpcion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoOpcion> entities = new  ArrayList<GrupoOpcion>();
		GrupoOpcion entity = new GrupoOpcion();		  
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
	
	public  List<GrupoOpcion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoOpcion> entities = new  ArrayList<GrupoOpcion>();
		GrupoOpcion entity = new GrupoOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoOpcion();
      	    	entity=super.getEntity("",entity,resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGrupoOpcion("",entity,resultSet);
      	    	
				entity.setGrupoOpcionOriginal( new GrupoOpcion());
      	    	entity.setGrupoOpcionOriginal(super.getEntity("",entity.getGrupoOpcionOriginal(),resultSet,GrupoOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setGrupoOpcionOriginal(this.getEntityGrupoOpcion("",entity.getGrupoOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGrupoOpcions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public GrupoOpcion getEntityGrupoOpcion(String strPrefijo,GrupoOpcion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_modulo(resultSet.getLong(strPrefijo+GrupoOpcionConstantesFunciones.IDMODULO));
				entity.setcodigo(resultSet.getString(strPrefijo+GrupoOpcionConstantesFunciones.CODIGO));
				entity.setnombre_principal(resultSet.getString(strPrefijo+GrupoOpcionConstantesFunciones.NOMBRE));
				entity.setorden(resultSet.getInt(strPrefijo+GrupoOpcionConstantesFunciones.ORDEN));
				entity.setestado(resultSet.getBoolean(strPrefijo+GrupoOpcionConstantesFunciones.ESTADO));
			} else {
				entity.setnombre_principal(resultSet.getString(strPrefijo+GrupoOpcionConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowGrupoOpcion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(GrupoOpcion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=GrupoOpcionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=GrupoOpcionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=GrupoOpcionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=GrupoOpcionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(GrupoOpcionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,GrupoOpcionDataAccess.TABLENAME,GrupoOpcionDataAccess.ISWITHSTOREPROCEDURES);
			
			GrupoOpcionDataAccess.setGrupoOpcionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Modulo getModulo(Connexion connexion,GrupoOpcion relgrupoopcion)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relgrupoopcion.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}


		
		public List<UsuarioOpcion> getUsuarioOpcions(Connexion connexion,GrupoOpcion grupoopcion)throws SQLException,Exception {

		List<UsuarioOpcion> usuarioopcions= new ArrayList<UsuarioOpcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+GrupoOpcionConstantesFunciones.SCHEMA+".grupo_opcion ON "+UsuarioOpcionConstantesFunciones.SCHEMA+".usuario_opcion.id_grupo_opcion="+GrupoOpcionConstantesFunciones.SCHEMA+".grupo_opcion.id WHERE "+GrupoOpcionConstantesFunciones.SCHEMA+".grupo_opcion.id="+String.valueOf(grupoopcion.getId());
			} else {
				sQuery=" INNER JOIN usuarioopcion.GrupoOpcion WHERE usuarioopcion.GrupoOpcion.id="+String.valueOf(grupoopcion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			UsuarioOpcionDataAccess usuarioopcionDataAccess=new UsuarioOpcionDataAccess();

			usuarioopcionDataAccess.setConnexionType(this.connexionType);
			usuarioopcionDataAccess.setParameterDbType(this.parameterDbType);
			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuarioopcions;

	}

	public List<Opcion> getOpcions(Connexion connexion,GrupoOpcion grupoopcion)throws SQLException,Exception {

		List<Opcion> opcions= new ArrayList<Opcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+GrupoOpcionConstantesFunciones.SCHEMA+".grupo_opcion ON "+OpcionConstantesFunciones.SCHEMA+".opcion.id_grupo_opcion="+GrupoOpcionConstantesFunciones.SCHEMA+".grupo_opcion.id WHERE "+GrupoOpcionConstantesFunciones.SCHEMA+".grupo_opcion.id="+String.valueOf(grupoopcion.getId());
			} else {
				sQuery=" INNER JOIN opcion.GrupoOpcion WHERE opcion.GrupoOpcion.id="+String.valueOf(grupoopcion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OpcionDataAccess opcionDataAccess=new OpcionDataAccess();

			opcionDataAccess.setConnexionType(this.connexionType);
			opcionDataAccess.setParameterDbType(this.parameterDbType);
			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return opcions;

	}

	public List<PerfilOpcion> getPerfilOpcions(Connexion connexion,GrupoOpcion grupoopcion)throws SQLException,Exception {

		List<PerfilOpcion> perfilopcions= new ArrayList<PerfilOpcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+GrupoOpcionConstantesFunciones.SCHEMA+".grupo_opcion ON "+PerfilOpcionConstantesFunciones.SCHEMA+".perfil_opcion.id_grupo_opcion="+GrupoOpcionConstantesFunciones.SCHEMA+".grupo_opcion.id WHERE "+GrupoOpcionConstantesFunciones.SCHEMA+".grupo_opcion.id="+String.valueOf(grupoopcion.getId());
			} else {
				sQuery=" INNER JOIN perfilopcion.GrupoOpcion WHERE perfilopcion.GrupoOpcion.id="+String.valueOf(grupoopcion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PerfilOpcionDataAccess perfilopcionDataAccess=new PerfilOpcionDataAccess();

			perfilopcionDataAccess.setConnexionType(this.connexionType);
			perfilopcionDataAccess.setParameterDbType(this.parameterDbType);
			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfilopcions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,GrupoOpcion grupoopcion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!grupoopcion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(grupoopcion.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(grupoopcion.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_principal=new ParameterValue<String>();
					parameterMaintenanceValuenombre_principal.setValue(grupoopcion.getnombre_principal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_principal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueorden=new ParameterValue<Integer>();
					parameterMaintenanceValueorden.setValue(grupoopcion.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueestado=new ParameterValue<Boolean>();
					parameterMaintenanceValueestado.setValue(grupoopcion.getestado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestado);
					parametersTemp.add(parameterMaintenance);
					
						if(!grupoopcion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(grupoopcion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(grupoopcion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(grupoopcion.getId());
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
	
	public void setIsNewIsChangedFalseGrupoOpcion(GrupoOpcion grupoopcion)throws Exception  {		
		grupoopcion.setIsNew(false);
		grupoopcion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseGrupoOpcions(List<GrupoOpcion> grupoopcions)throws Exception  {				
		for(GrupoOpcion grupoopcion:grupoopcions) {
			grupoopcion.setIsNew(false);
			grupoopcion.setIsChanged(false);
		}
	}
	
	public void generarExportarGrupoOpcion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
