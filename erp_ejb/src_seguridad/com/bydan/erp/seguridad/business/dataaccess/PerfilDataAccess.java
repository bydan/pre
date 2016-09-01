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
import com.bydan.erp.seguridad.util.*;//PerfilConstantesFunciones;










@SuppressWarnings("unused")
final public class PerfilDataAccess extends  PerfilDataAccessAdditional{ //PerfilDataAccessAdditional,DataAccessHelper<Perfil>
	//static Logger logger = Logger.getLogger(PerfilDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="perfil";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+"(version_row,id_sistema,codigo,nombre,nombre2,estado)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_sistema=?,codigo=?,nombre=?,nombre2=?,estado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select perfil from "+PerfilConstantesFunciones.SPERSISTENCENAME+" perfil";
	public static String QUERYSELECTNATIVE="select "+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".id,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".version_row,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".id_sistema,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".codigo,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".nombre,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".nombre2,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".estado from "+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME;//+" as "+PerfilConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".id,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".version_row,"+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+".nombre from "+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME;//+" as "+PerfilConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PerfilConstantesFunciones.SCHEMA+"."+PerfilConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_sistema=?,codigo=?,nombre=?,nombre2=?,estado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PERFIL_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PERFIL_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PERFIL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PERFIL_SELECT(?,?)";
	
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
	
	
	protected PerfilDataAccessAdditional perfilDataAccessAdditional=null;
	
	public PerfilDataAccessAdditional getPerfilDataAccessAdditional() {
		return this.perfilDataAccessAdditional;
	}
	
	public void setPerfilDataAccessAdditional(PerfilDataAccessAdditional perfilDataAccessAdditional) {
		try {
			this.perfilDataAccessAdditional=perfilDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PerfilDataAccess() {
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
		PerfilDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PerfilDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PerfilDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPerfilOriginal(Perfil perfil)throws Exception  {
		perfil.setPerfilOriginal((Perfil)perfil.clone());		
	}
	
	public void setPerfilsOriginal(List<Perfil> perfils)throws Exception  {
		
		for(Perfil perfil:perfils){
			perfil.setPerfilOriginal((Perfil)perfil.clone());
		}
	}
	
	public static void setPerfilOriginalStatic(Perfil perfil)throws Exception  {
		perfil.setPerfilOriginal((Perfil)perfil.clone());		
	}
	
	public static void setPerfilsOriginalStatic(List<Perfil> perfils)throws Exception  {
		
		for(Perfil perfil:perfils){
			perfil.setPerfilOriginal((Perfil)perfil.clone());
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
	
	public  Perfil getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Perfil entity = new Perfil();		
		
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
	
	public  Perfil getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Perfil entity = new Perfil();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.Perfil.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPerfilOriginal(new Perfil());
      	    	entity=super.getEntity("",entity,resultSet,PerfilDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPerfil("",entity,resultSet); 
				
				entity.setPerfilOriginal(super.getEntity("",entity.getPerfilOriginal(),resultSet,PerfilDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilOriginal(this.getEntityPerfil("",entity.getPerfilOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePerfil(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Perfil getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Perfil entity = new Perfil();
				
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
	
	public  Perfil getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Perfil entity = new Perfil();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Perfil.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPerfilOriginal(new Perfil());
      	    	entity=super.getEntity("",entity,resultSet,PerfilDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPerfil("",entity,resultSet);    
				
				entity.setPerfilOriginal(super.getEntity("",entity.getPerfilOriginal(),resultSet,PerfilDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilOriginal(this.getEntityPerfil("",entity.getPerfilOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePerfil(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Perfil
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Perfil entity = new Perfil();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Perfil.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePerfil(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Perfil> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Perfil> entities = new  ArrayList<Perfil>();
		Perfil entity = new Perfil();		  
		
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
	
	public  List<Perfil> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Perfil> entities = new  ArrayList<Perfil>();
		Perfil entity = new Perfil();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Perfil();
      	    	entity=super.getEntity("",entity,resultSet,PerfilDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfil("",entity,resultSet);
      	    	
				entity.setPerfilOriginal( new Perfil());
      	    	entity.setPerfilOriginal(super.getEntity("",entity.getPerfilOriginal(),resultSet,PerfilDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilOriginal(this.getEntityPerfil("",entity.getPerfilOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfils(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfil(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Perfil> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Perfil> entities = new  ArrayList<Perfil>();
		Perfil entity = new Perfil();		  
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
	
	public  List<Perfil> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Perfil> entities = new  ArrayList<Perfil>();
		Perfil entity = new Perfil();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Perfil();
				
				if(conMapGenerico) {
					entity.inicializarMapPerfil();
					//entity.setMapPerfil(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPerfilValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPerfil().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PerfilDataAccess.ISWITHSCHEMA);         		
					entity=PerfilDataAccess.getEntityPerfil("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setPerfilOriginal( new Perfil());
					//entity.setPerfilOriginal(super.getEntity("",entity.getPerfilOriginal(),resultSet,PerfilDataAccess.ISWITHSCHEMA));         		
					//entity.setPerfilOriginal(this.getEntityPerfil("",entity.getPerfilOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfils(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfil(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Perfil getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Perfil entity = new Perfil();		  
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
	
	public  Perfil getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Perfil entity = new Perfil();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Perfil();
				
				if(conMapGenerico) {
					entity.inicializarMapPerfil();
					//entity.setMapPerfil(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPerfilValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPerfil().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PerfilDataAccess.ISWITHSCHEMA);         		
					entity=PerfilDataAccess.getEntityPerfil("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setPerfilOriginal( new Perfil());
					//entity.setPerfilOriginal(super.getEntity("",entity.getPerfilOriginal(),resultSet,PerfilDataAccess.ISWITHSCHEMA));         		
					//entity.setPerfilOriginal(this.getEntityPerfil("",entity.getPerfilOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePerfil(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfil(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Perfil getEntityPerfil(String strPrefijo,Perfil entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Perfil.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Perfil.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PerfilDataAccess.setFieldReflectionPerfil(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPerfil=PerfilConstantesFunciones.getTodosTiposColumnasPerfil();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPerfil) {
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
							field = Perfil.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Perfil.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PerfilDataAccess.setFieldReflectionPerfil(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPerfil(Field field,String strPrefijo,String sColumn,Perfil entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PerfilConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PerfilConstantesFunciones.IDSISTEMA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PerfilConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PerfilConstantesFunciones.NOMBRE2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PerfilConstantesFunciones.ESTADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Perfil>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Perfil> entities = new  ArrayList<Perfil>();
		Perfil entity = new Perfil();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Perfil();
					entity=super.getEntity("",entity,resultSet,PerfilDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPerfil("",entity,resultSet);
					
					entity.setPerfilOriginal( new Perfil());
					entity.setPerfilOriginal(super.getEntity("",entity.getPerfilOriginal(),resultSet,PerfilDataAccess.ISWITHSCHEMA));         		
					entity.setPerfilOriginal(this.getEntityPerfil("",entity.getPerfilOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePerfils(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfil(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Perfil>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Perfil> entities = new  ArrayList<Perfil>();
		Perfil entity = new Perfil();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Perfil> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Perfil> entities = new  ArrayList<Perfil>();
		Perfil entity = new Perfil();		  
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
	
	public  List<Perfil> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Perfil> entities = new  ArrayList<Perfil>();
		Perfil entity = new Perfil();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Perfil();
      	    	entity=super.getEntity("",entity,resultSet,PerfilDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfil("",entity,resultSet);
      	    	
				entity.setPerfilOriginal( new Perfil());
      	    	entity.setPerfilOriginal(super.getEntity("",entity.getPerfilOriginal(),resultSet,PerfilDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilOriginal(this.getEntityPerfil("",entity.getPerfilOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePerfils(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfil(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Perfil> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Perfil> entities = new  ArrayList<Perfil>();
		Perfil entity = new Perfil();		  
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
	
	public  List<Perfil> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Perfil> entities = new  ArrayList<Perfil>();
		Perfil entity = new Perfil();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Perfil();
      	    	entity=super.getEntity("",entity,resultSet,PerfilDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfil("",entity,resultSet);
      	    	
				entity.setPerfilOriginal( new Perfil());
      	    	entity.setPerfilOriginal(super.getEntity("",entity.getPerfilOriginal(),resultSet,PerfilDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilOriginal(this.getEntityPerfil("",entity.getPerfilOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfils(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Perfil getEntityPerfil(String strPrefijo,Perfil entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_sistema(resultSet.getLong(strPrefijo+PerfilConstantesFunciones.IDSISTEMA));
				entity.setcodigo(resultSet.getString(strPrefijo+PerfilConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+PerfilConstantesFunciones.NOMBRE));
				entity.setnombre2(resultSet.getString(strPrefijo+PerfilConstantesFunciones.NOMBRE2));
				entity.setestado(resultSet.getBoolean(strPrefijo+PerfilConstantesFunciones.ESTADO));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+PerfilConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPerfil(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Perfil entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PerfilDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PerfilDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PerfilDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PerfilDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PerfilConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PerfilDataAccess.TABLENAME,PerfilDataAccess.ISWITHSTOREPROCEDURES);
			
			PerfilDataAccess.setPerfilOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Sistema getSistema(Connexion connexion,Perfil relperfil)throws SQLException,Exception {

		Sistema sistema= new Sistema();

		try {
			SistemaDataAccess sistemaDataAccess=new SistemaDataAccess();

			sistemaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sistemaDataAccess.setConnexionType(this.connexionType);
			sistemaDataAccess.setParameterDbType(this.parameterDbType);

			sistema=sistemaDataAccess.getEntity(connexion,relperfil.getid_sistema());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sistema;

	}


		
		public List<PerfilAccion> getPerfilAccions(Connexion connexion,Perfil perfil)throws SQLException,Exception {

		List<PerfilAccion> perfilaccions= new ArrayList<PerfilAccion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PerfilConstantesFunciones.SCHEMA+".perfil ON "+PerfilAccionConstantesFunciones.SCHEMA+".perfil_accion.id_perfil="+PerfilConstantesFunciones.SCHEMA+".perfil.id WHERE "+PerfilConstantesFunciones.SCHEMA+".perfil.id="+String.valueOf(perfil.getId());
			} else {
				sQuery=" INNER JOIN perfilaccion.Perfil WHERE perfilaccion.Perfil.id="+String.valueOf(perfil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PerfilAccionDataAccess perfilaccionDataAccess=new PerfilAccionDataAccess();

			perfilaccionDataAccess.setConnexionType(this.connexionType);
			perfilaccionDataAccess.setParameterDbType(this.parameterDbType);
			perfilaccions=perfilaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfilaccions;

	}

	public List<PerfilCampo> getPerfilCampos(Connexion connexion,Perfil perfil)throws SQLException,Exception {

		List<PerfilCampo> perfilcampos= new ArrayList<PerfilCampo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PerfilConstantesFunciones.SCHEMA+".perfil ON "+PerfilCampoConstantesFunciones.SCHEMA+".perfil_campo.id_perfil="+PerfilConstantesFunciones.SCHEMA+".perfil.id WHERE "+PerfilConstantesFunciones.SCHEMA+".perfil.id="+String.valueOf(perfil.getId());
			} else {
				sQuery=" INNER JOIN perfilcampo.Perfil WHERE perfilcampo.Perfil.id="+String.valueOf(perfil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PerfilCampoDataAccess perfilcampoDataAccess=new PerfilCampoDataAccess();

			perfilcampoDataAccess.setConnexionType(this.connexionType);
			perfilcampoDataAccess.setParameterDbType(this.parameterDbType);
			perfilcampos=perfilcampoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfilcampos;

	}

	public List<Accion> getAccions(Connexion connexion,Perfil perfil)throws SQLException,Exception {

		List<Accion> accions= new ArrayList<Accion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PerfilAccionConstantesFunciones.SCHEMA+".perfil_accion ON "+PerfilAccionConstantesFunciones.SCHEMA+".perfil_accion.id_accion="+AccionConstantesFunciones.SCHEMA+".accion.id INNER JOIN "+PerfilConstantesFunciones.SCHEMA+".perfil ON "+PerfilAccionConstantesFunciones.SCHEMA+".perfil_accion.id_perfil="+PerfilConstantesFunciones.SCHEMA+".perfil.id WHERE "+PerfilConstantesFunciones.SCHEMA+".perfil.id="+String.valueOf(perfil.getId());
			} else {
				sQuery=" INNER JOIN accion.PerfilAccions table2  INNER JOIN  table2.Perfil table3 WHERE table3.id="+String.valueOf(perfil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AccionDataAccess accionDataAccess=new AccionDataAccess();

			accionDataAccess.setConnexionType(this.connexionType);
			accionDataAccess.setParameterDbType(this.parameterDbType);
			accions=accionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return accions;

	}

	public List<PerfilOpcion> getPerfilOpcions(Connexion connexion,Perfil perfil)throws SQLException,Exception {

		List<PerfilOpcion> perfilopcions= new ArrayList<PerfilOpcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PerfilConstantesFunciones.SCHEMA+".perfil ON "+PerfilOpcionConstantesFunciones.SCHEMA+".perfil_opcion.id_perfil="+PerfilConstantesFunciones.SCHEMA+".perfil.id WHERE "+PerfilConstantesFunciones.SCHEMA+".perfil.id="+String.valueOf(perfil.getId());
			} else {
				sQuery=" INNER JOIN perfilopcion.Perfil WHERE perfilopcion.Perfil.id="+String.valueOf(perfil.getId());

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

	public List<PerfilUsuario> getPerfilUsuarios(Connexion connexion,Perfil perfil)throws SQLException,Exception {

		List<PerfilUsuario> perfilusuarios= new ArrayList<PerfilUsuario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PerfilConstantesFunciones.SCHEMA+".perfil ON "+PerfilUsuarioConstantesFunciones.SCHEMA+".perfil_usuario.id_perfil="+PerfilConstantesFunciones.SCHEMA+".perfil.id WHERE "+PerfilConstantesFunciones.SCHEMA+".perfil.id="+String.valueOf(perfil.getId());
			} else {
				sQuery=" INNER JOIN perfilusuario.Perfil WHERE perfilusuario.Perfil.id="+String.valueOf(perfil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PerfilUsuarioDataAccess perfilusuarioDataAccess=new PerfilUsuarioDataAccess();

			perfilusuarioDataAccess.setConnexionType(this.connexionType);
			perfilusuarioDataAccess.setParameterDbType(this.parameterDbType);
			perfilusuarios=perfilusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfilusuarios;

	}

	public List<Campo> getCampos(Connexion connexion,Perfil perfil)throws SQLException,Exception {

		List<Campo> campos= new ArrayList<Campo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PerfilCampoConstantesFunciones.SCHEMA+".perfil_campo ON "+PerfilCampoConstantesFunciones.SCHEMA+".perfil_campo.id_campo="+CampoConstantesFunciones.SCHEMA+".campo.id INNER JOIN "+PerfilConstantesFunciones.SCHEMA+".perfil ON "+PerfilCampoConstantesFunciones.SCHEMA+".perfil_campo.id_perfil="+PerfilConstantesFunciones.SCHEMA+".perfil.id WHERE "+PerfilConstantesFunciones.SCHEMA+".perfil.id="+String.valueOf(perfil.getId());
			} else {
				sQuery=" INNER JOIN campo.PerfilCampos table2  INNER JOIN  table2.Perfil table3 WHERE table3.id="+String.valueOf(perfil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CampoDataAccess campoDataAccess=new CampoDataAccess();

			campoDataAccess.setConnexionType(this.connexionType);
			campoDataAccess.setParameterDbType(this.parameterDbType);
			campos=campoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return campos;

	}

	public List<Usuario> getUsuarios(Connexion connexion,Perfil perfil)throws SQLException,Exception {

		List<Usuario> usuarios= new ArrayList<Usuario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PerfilUsuarioConstantesFunciones.SCHEMA+".perfil_usuario ON "+PerfilUsuarioConstantesFunciones.SCHEMA+".perfil_usuario.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id INNER JOIN "+PerfilConstantesFunciones.SCHEMA+".perfil ON "+PerfilUsuarioConstantesFunciones.SCHEMA+".perfil_usuario.id_perfil="+PerfilConstantesFunciones.SCHEMA+".perfil.id WHERE "+PerfilConstantesFunciones.SCHEMA+".perfil.id="+String.valueOf(perfil.getId());
			} else {
				sQuery=" INNER JOIN usuario.PerfilUsuarios table2  INNER JOIN  table2.Perfil table3 WHERE table3.id="+String.valueOf(perfil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);
			usuarios=usuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuarios;

	}

	public List<UsuarioOpcion> getUsuarioOpcions(Connexion connexion,Perfil perfil)throws SQLException,Exception {

		List<UsuarioOpcion> usuarioopcions= new ArrayList<UsuarioOpcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PerfilConstantesFunciones.SCHEMA+".perfil ON "+UsuarioOpcionConstantesFunciones.SCHEMA+".usuario_opcion.id_perfil="+PerfilConstantesFunciones.SCHEMA+".perfil.id WHERE "+PerfilConstantesFunciones.SCHEMA+".perfil.id="+String.valueOf(perfil.getId());
			} else {
				sQuery=" INNER JOIN usuarioopcion.Perfil WHERE usuarioopcion.Perfil.id="+String.valueOf(perfil.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Perfil perfil) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!perfil.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sistema=new ParameterValue<Long>();
					parameterMaintenanceValueid_sistema.setValue(perfil.getid_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(perfil.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(perfil.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre2=new ParameterValue<String>();
					parameterMaintenanceValuenombre2.setValue(perfil.getnombre2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueestado=new ParameterValue<Boolean>();
					parameterMaintenanceValueestado.setValue(perfil.getestado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestado);
					parametersTemp.add(parameterMaintenance);
					
						if(!perfil.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(perfil.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(perfil.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(perfil.getId());
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
	
	public void setIsNewIsChangedFalsePerfil(Perfil perfil)throws Exception  {		
		perfil.setIsNew(false);
		perfil.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePerfils(List<Perfil> perfils)throws Exception  {				
		for(Perfil perfil:perfils) {
			perfil.setIsNew(false);
			perfil.setIsChanged(false);
		}
	}
	
	public void generarExportarPerfil(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
