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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.*;//LunaSistemaSolarConstantesFunciones;










@SuppressWarnings("unused")
final public class LunaSistemaSolarDataAccess extends  LunaSistemaSolarDataAccessAdditional{ //LunaSistemaSolarDataAccessAdditional,DataAccessHelper<LunaSistemaSolar>
	//static Logger logger = Logger.getLogger(LunaSistemaSolarDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="luna_sistema_solar";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+"(id,version_row,id_tipo_valoracion,codigo,nombre,descripcion)values(?,current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_tipo_valoracion=?,codigo=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select lunasistemasolar from "+LunaSistemaSolarConstantesFunciones.SPERSISTENCENAME+" lunasistemasolar";
	public static String QUERYSELECTNATIVE="select "+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".id,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".version_row,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".id_tipo_valoracion,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".codigo,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".nombre,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".descripcion from "+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME;//+" as "+LunaSistemaSolarConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".id,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".version_row,"+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+".codigo from "+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME;//+" as "+LunaSistemaSolarConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+LunaSistemaSolarConstantesFunciones.SCHEMA+"."+LunaSistemaSolarConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_tipo_valoracion=?,codigo=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_LUNASISTEMASOLAR_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_LUNASISTEMASOLAR_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_LUNASISTEMASOLAR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_LUNASISTEMASOLAR_SELECT(?,?)";
	
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
	
	
	protected LunaSistemaSolarDataAccessAdditional lunasistemasolarDataAccessAdditional=null;
	
	public LunaSistemaSolarDataAccessAdditional getLunaSistemaSolarDataAccessAdditional() {
		return this.lunasistemasolarDataAccessAdditional;
	}
	
	public void setLunaSistemaSolarDataAccessAdditional(LunaSistemaSolarDataAccessAdditional lunasistemasolarDataAccessAdditional) {
		try {
			this.lunasistemasolarDataAccessAdditional=lunasistemasolarDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public LunaSistemaSolarDataAccess() {
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
		LunaSistemaSolarDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		LunaSistemaSolarDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		LunaSistemaSolarDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setLunaSistemaSolarOriginal(LunaSistemaSolar lunasistemasolar)throws Exception  {
		lunasistemasolar.setLunaSistemaSolarOriginal((LunaSistemaSolar)lunasistemasolar.clone());		
	}
	
	public void setLunaSistemaSolarsOriginal(List<LunaSistemaSolar> lunasistemasolars)throws Exception  {
		
		for(LunaSistemaSolar lunasistemasolar:lunasistemasolars){
			lunasistemasolar.setLunaSistemaSolarOriginal((LunaSistemaSolar)lunasistemasolar.clone());
		}
	}
	
	public static void setLunaSistemaSolarOriginalStatic(LunaSistemaSolar lunasistemasolar)throws Exception  {
		lunasistemasolar.setLunaSistemaSolarOriginal((LunaSistemaSolar)lunasistemasolar.clone());		
	}
	
	public static void setLunaSistemaSolarsOriginalStatic(List<LunaSistemaSolar> lunasistemasolars)throws Exception  {
		
		for(LunaSistemaSolar lunasistemasolar:lunasistemasolars){
			lunasistemasolar.setLunaSistemaSolarOriginal((LunaSistemaSolar)lunasistemasolar.clone());
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
	
	public  LunaSistemaSolar getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		LunaSistemaSolar entity = new LunaSistemaSolar();		
		
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
	
	public  LunaSistemaSolar getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		LunaSistemaSolar entity = new LunaSistemaSolar();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.LunaSistemaSolar.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setLunaSistemaSolarOriginal(new LunaSistemaSolar());
      	    	entity=super.getEntity("",entity,resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityLunaSistemaSolar("",entity,resultSet); 
				
				//entity.setLunaSistemaSolarOriginal(super.getEntity("",entity.getLunaSistemaSolarOriginal(),resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLunaSistemaSolarOriginal(this.getEntityLunaSistemaSolar("",entity.getLunaSistemaSolarOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseLunaSistemaSolar(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  LunaSistemaSolar getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		LunaSistemaSolar entity = new LunaSistemaSolar();
				
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
	
	public  LunaSistemaSolar getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		LunaSistemaSolar entity = new LunaSistemaSolar();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,LunaSistemaSolarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.LunaSistemaSolar.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setLunaSistemaSolarOriginal(new LunaSistemaSolar());
      	    	entity=super.getEntity("",entity,resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityLunaSistemaSolar("",entity,resultSet);    
				
				//entity.setLunaSistemaSolarOriginal(super.getEntity("",entity.getLunaSistemaSolarOriginal(),resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLunaSistemaSolarOriginal(this.getEntityLunaSistemaSolar("",entity.getLunaSistemaSolarOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseLunaSistemaSolar(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //LunaSistemaSolar
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		LunaSistemaSolar entity = new LunaSistemaSolar();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,LunaSistemaSolarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.LunaSistemaSolar.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseLunaSistemaSolar(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<LunaSistemaSolar> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<LunaSistemaSolar> entities = new  ArrayList<LunaSistemaSolar>();
		LunaSistemaSolar entity = new LunaSistemaSolar();		  
		
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
	
	public  List<LunaSistemaSolar> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<LunaSistemaSolar> entities = new  ArrayList<LunaSistemaSolar>();
		LunaSistemaSolar entity = new LunaSistemaSolar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,LunaSistemaSolarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LunaSistemaSolar();
      	    	entity=super.getEntity("",entity,resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLunaSistemaSolar("",entity,resultSet);
      	    	
				//entity.setLunaSistemaSolarOriginal( new LunaSistemaSolar());
      	    	//entity.setLunaSistemaSolarOriginal(super.getEntity("",entity.getLunaSistemaSolarOriginal(),resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLunaSistemaSolarOriginal(this.getEntityLunaSistemaSolar("",entity.getLunaSistemaSolarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLunaSistemaSolars(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLunaSistemaSolar(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<LunaSistemaSolar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<LunaSistemaSolar> entities = new  ArrayList<LunaSistemaSolar>();
		LunaSistemaSolar entity = new LunaSistemaSolar();		  
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
	
	public  List<LunaSistemaSolar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<LunaSistemaSolar> entities = new  ArrayList<LunaSistemaSolar>();
		LunaSistemaSolar entity = new LunaSistemaSolar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LunaSistemaSolar();
				
				if(conMapGenerico) {
					entity.inicializarMapLunaSistemaSolar();
					//entity.setMapLunaSistemaSolar(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapLunaSistemaSolarValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapLunaSistemaSolar().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA);         		
					entity=LunaSistemaSolarDataAccess.getEntityLunaSistemaSolar("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setLunaSistemaSolarOriginal( new LunaSistemaSolar());
					////entity.setLunaSistemaSolarOriginal(super.getEntity("",entity.getLunaSistemaSolarOriginal(),resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA));         		
					////entity.setLunaSistemaSolarOriginal(this.getEntityLunaSistemaSolar("",entity.getLunaSistemaSolarOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLunaSistemaSolars(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLunaSistemaSolar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public LunaSistemaSolar getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		LunaSistemaSolar entity = new LunaSistemaSolar();		  
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
	
	public  LunaSistemaSolar getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		LunaSistemaSolar entity = new LunaSistemaSolar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LunaSistemaSolar();
				
				if(conMapGenerico) {
					entity.inicializarMapLunaSistemaSolar();
					//entity.setMapLunaSistemaSolar(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapLunaSistemaSolarValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapLunaSistemaSolar().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA);         		
					entity=LunaSistemaSolarDataAccess.getEntityLunaSistemaSolar("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setLunaSistemaSolarOriginal( new LunaSistemaSolar());
					////entity.setLunaSistemaSolarOriginal(super.getEntity("",entity.getLunaSistemaSolarOriginal(),resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA));         		
					////entity.setLunaSistemaSolarOriginal(this.getEntityLunaSistemaSolar("",entity.getLunaSistemaSolarOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseLunaSistemaSolar(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLunaSistemaSolar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static LunaSistemaSolar getEntityLunaSistemaSolar(String strPrefijo,LunaSistemaSolar entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = LunaSistemaSolar.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = LunaSistemaSolar.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					LunaSistemaSolarDataAccess.setFieldReflectionLunaSistemaSolar(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasLunaSistemaSolar=LunaSistemaSolarConstantesFunciones.getTodosTiposColumnasLunaSistemaSolar();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasLunaSistemaSolar) {
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
							field = LunaSistemaSolar.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = LunaSistemaSolar.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						LunaSistemaSolarDataAccess.setFieldReflectionLunaSistemaSolar(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionLunaSistemaSolar(Field field,String strPrefijo,String sColumn,LunaSistemaSolar entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case LunaSistemaSolarConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LunaSistemaSolarConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LunaSistemaSolarConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LunaSistemaSolarConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LunaSistemaSolarConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<LunaSistemaSolar>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<LunaSistemaSolar> entities = new  ArrayList<LunaSistemaSolar>();
		LunaSistemaSolar entity = new LunaSistemaSolar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,LunaSistemaSolarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new LunaSistemaSolar();
					entity=super.getEntity("",entity,resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityLunaSistemaSolar("",entity,resultSet);
					
					//entity.setLunaSistemaSolarOriginal( new LunaSistemaSolar());
					//entity.setLunaSistemaSolarOriginal(super.getEntity("",entity.getLunaSistemaSolarOriginal(),resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA));         		
					//entity.setLunaSistemaSolarOriginal(this.getEntityLunaSistemaSolar("",entity.getLunaSistemaSolarOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseLunaSistemaSolars(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLunaSistemaSolar(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<LunaSistemaSolar>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<LunaSistemaSolar> entities = new  ArrayList<LunaSistemaSolar>();
		LunaSistemaSolar entity = new LunaSistemaSolar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LunaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,LunaSistemaSolarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<LunaSistemaSolar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LunaSistemaSolar> entities = new  ArrayList<LunaSistemaSolar>();
		LunaSistemaSolar entity = new LunaSistemaSolar();		  
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
	
	public  List<LunaSistemaSolar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LunaSistemaSolar> entities = new  ArrayList<LunaSistemaSolar>();
		LunaSistemaSolar entity = new LunaSistemaSolar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LunaSistemaSolar();
      	    	entity=super.getEntity("",entity,resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLunaSistemaSolar("",entity,resultSet);
      	    	
				//entity.setLunaSistemaSolarOriginal( new LunaSistemaSolar());
      	    	//entity.setLunaSistemaSolarOriginal(super.getEntity("",entity.getLunaSistemaSolarOriginal(),resultSet,LunaSistemaSolarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLunaSistemaSolarOriginal(this.getEntityLunaSistemaSolar("",entity.getLunaSistemaSolarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseLunaSistemaSolars(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLunaSistemaSolar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public LunaSistemaSolar getEntityLunaSistemaSolar(String strPrefijo,LunaSistemaSolar entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_tipo_valoracion(resultSet.getLong(strPrefijo+LunaSistemaSolarConstantesFunciones.IDTIPOVALORACION));
				entity.setcodigo(resultSet.getString(strPrefijo+LunaSistemaSolarConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+LunaSistemaSolarConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+LunaSistemaSolarConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+LunaSistemaSolarConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowLunaSistemaSolar(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(LunaSistemaSolar entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=LunaSistemaSolarDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=LunaSistemaSolarDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=LunaSistemaSolarDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=LunaSistemaSolarDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(LunaSistemaSolarConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,LunaSistemaSolarDataAccess.TABLENAME,LunaSistemaSolarDataAccess.ISWITHSTOREPROCEDURES);
			
			LunaSistemaSolarDataAccess.setLunaSistemaSolarOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public TipoValoracion getTipoValoracion(Connexion connexion,LunaSistemaSolar rellunasistemasolar)throws SQLException,Exception {

		TipoValoracion tipovaloracion= new TipoValoracion();

		try {
			TipoValoracionDataAccess tipovaloracionDataAccess=new TipoValoracionDataAccess();

			tipovaloracionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipovaloracionDataAccess.setConnexionType(this.connexionType);
			tipovaloracionDataAccess.setParameterDbType(this.parameterDbType);

			tipovaloracion=tipovaloracionDataAccess.getEntity(connexion,rellunasistemasolar.getid_tipo_valoracion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipovaloracion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,LunaSistemaSolar lunasistemasolar) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!lunasistemasolar.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(lunasistemasolar.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_valoracion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_valoracion.setValue(lunasistemasolar.getid_tipo_valoracion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_valoracion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(lunasistemasolar.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(lunasistemasolar.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(lunasistemasolar.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!lunasistemasolar.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(lunasistemasolar.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(lunasistemasolar.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(lunasistemasolar.getId());
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
	
	public void setIsNewIsChangedFalseLunaSistemaSolar(LunaSistemaSolar lunasistemasolar)throws Exception  {		
		lunasistemasolar.setIsNew(false);
		lunasistemasolar.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseLunaSistemaSolars(List<LunaSistemaSolar> lunasistemasolars)throws Exception  {				
		for(LunaSistemaSolar lunasistemasolar:lunasistemasolars) {
			lunasistemasolar.setIsNew(false);
			lunasistemasolar.setIsChanged(false);
		}
	}
	
	public void generarExportarLunaSistemaSolar(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
