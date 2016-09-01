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
import com.bydan.erp.seguridad.util.*;//PlanetaSistemaSolarConstantesFunciones;










@SuppressWarnings("unused")
final public class PlanetaSistemaSolarDataAccess extends  PlanetaSistemaSolarDataAccessAdditional{ //PlanetaSistemaSolarDataAccessAdditional,DataAccessHelper<PlanetaSistemaSolar>
	//static Logger logger = Logger.getLogger(PlanetaSistemaSolarDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="planeta_sistema_solar";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+"(id,version_row,id_tipo_valoracion,codigo,nombre,descripcion)values(?,current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_tipo_valoracion=?,codigo=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select planetasistemasolar from "+PlanetaSistemaSolarConstantesFunciones.SPERSISTENCENAME+" planetasistemasolar";
	public static String QUERYSELECTNATIVE="select "+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".id,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".version_row,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".id_tipo_valoracion,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".codigo,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".nombre,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".descripcion from "+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME;//+" as "+PlanetaSistemaSolarConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".id,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".version_row,"+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+".codigo from "+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME;//+" as "+PlanetaSistemaSolarConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PlanetaSistemaSolarConstantesFunciones.SCHEMA+"."+PlanetaSistemaSolarConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_tipo_valoracion=?,codigo=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PLANETASISTEMASOLAR_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PLANETASISTEMASOLAR_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PLANETASISTEMASOLAR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PLANETASISTEMASOLAR_SELECT(?,?)";
	
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
	
	
	protected PlanetaSistemaSolarDataAccessAdditional planetasistemasolarDataAccessAdditional=null;
	
	public PlanetaSistemaSolarDataAccessAdditional getPlanetaSistemaSolarDataAccessAdditional() {
		return this.planetasistemasolarDataAccessAdditional;
	}
	
	public void setPlanetaSistemaSolarDataAccessAdditional(PlanetaSistemaSolarDataAccessAdditional planetasistemasolarDataAccessAdditional) {
		try {
			this.planetasistemasolarDataAccessAdditional=planetasistemasolarDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PlanetaSistemaSolarDataAccess() {
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
		PlanetaSistemaSolarDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PlanetaSistemaSolarDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PlanetaSistemaSolarDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPlanetaSistemaSolarOriginal(PlanetaSistemaSolar planetasistemasolar)throws Exception  {
		planetasistemasolar.setPlanetaSistemaSolarOriginal((PlanetaSistemaSolar)planetasistemasolar.clone());		
	}
	
	public void setPlanetaSistemaSolarsOriginal(List<PlanetaSistemaSolar> planetasistemasolars)throws Exception  {
		
		for(PlanetaSistemaSolar planetasistemasolar:planetasistemasolars){
			planetasistemasolar.setPlanetaSistemaSolarOriginal((PlanetaSistemaSolar)planetasistemasolar.clone());
		}
	}
	
	public static void setPlanetaSistemaSolarOriginalStatic(PlanetaSistemaSolar planetasistemasolar)throws Exception  {
		planetasistemasolar.setPlanetaSistemaSolarOriginal((PlanetaSistemaSolar)planetasistemasolar.clone());		
	}
	
	public static void setPlanetaSistemaSolarsOriginalStatic(List<PlanetaSistemaSolar> planetasistemasolars)throws Exception  {
		
		for(PlanetaSistemaSolar planetasistemasolar:planetasistemasolars){
			planetasistemasolar.setPlanetaSistemaSolarOriginal((PlanetaSistemaSolar)planetasistemasolar.clone());
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
	
	public  PlanetaSistemaSolar getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		
		
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
	
	public  PlanetaSistemaSolar getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.PlanetaSistemaSolar.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPlanetaSistemaSolarOriginal(new PlanetaSistemaSolar());
      	    	entity=super.getEntity("",entity,resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPlanetaSistemaSolar("",entity,resultSet); 
				
				//entity.setPlanetaSistemaSolarOriginal(super.getEntity("",entity.getPlanetaSistemaSolarOriginal(),resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlanetaSistemaSolarOriginal(this.getEntityPlanetaSistemaSolar("",entity.getPlanetaSistemaSolarOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePlanetaSistemaSolar(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PlanetaSistemaSolar getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();
				
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
	
	public  PlanetaSistemaSolar getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PlanetaSistemaSolarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.PlanetaSistemaSolar.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPlanetaSistemaSolarOriginal(new PlanetaSistemaSolar());
      	    	entity=super.getEntity("",entity,resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPlanetaSistemaSolar("",entity,resultSet);    
				
				//entity.setPlanetaSistemaSolarOriginal(super.getEntity("",entity.getPlanetaSistemaSolarOriginal(),resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlanetaSistemaSolarOriginal(this.getEntityPlanetaSistemaSolar("",entity.getPlanetaSistemaSolarOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePlanetaSistemaSolar(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PlanetaSistemaSolar
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PlanetaSistemaSolarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.PlanetaSistemaSolar.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePlanetaSistemaSolar(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PlanetaSistemaSolar> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PlanetaSistemaSolar> entities = new  ArrayList<PlanetaSistemaSolar>();
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		  
		
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
	
	public  List<PlanetaSistemaSolar> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PlanetaSistemaSolar> entities = new  ArrayList<PlanetaSistemaSolar>();
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PlanetaSistemaSolarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlanetaSistemaSolar();
      	    	entity=super.getEntity("",entity,resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPlanetaSistemaSolar("",entity,resultSet);
      	    	
				//entity.setPlanetaSistemaSolarOriginal( new PlanetaSistemaSolar());
      	    	//entity.setPlanetaSistemaSolarOriginal(super.getEntity("",entity.getPlanetaSistemaSolarOriginal(),resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlanetaSistemaSolarOriginal(this.getEntityPlanetaSistemaSolar("",entity.getPlanetaSistemaSolarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePlanetaSistemaSolars(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlanetaSistemaSolar(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PlanetaSistemaSolar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PlanetaSistemaSolar> entities = new  ArrayList<PlanetaSistemaSolar>();
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		  
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
	
	public  List<PlanetaSistemaSolar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PlanetaSistemaSolar> entities = new  ArrayList<PlanetaSistemaSolar>();
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlanetaSistemaSolar();
				
				if(conMapGenerico) {
					entity.inicializarMapPlanetaSistemaSolar();
					//entity.setMapPlanetaSistemaSolar(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPlanetaSistemaSolarValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPlanetaSistemaSolar().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA);         		
					entity=PlanetaSistemaSolarDataAccess.getEntityPlanetaSistemaSolar("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPlanetaSistemaSolarOriginal( new PlanetaSistemaSolar());
					////entity.setPlanetaSistemaSolarOriginal(super.getEntity("",entity.getPlanetaSistemaSolarOriginal(),resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA));         		
					////entity.setPlanetaSistemaSolarOriginal(this.getEntityPlanetaSistemaSolar("",entity.getPlanetaSistemaSolarOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePlanetaSistemaSolars(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlanetaSistemaSolar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PlanetaSistemaSolar getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		  
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
	
	public  PlanetaSistemaSolar getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlanetaSistemaSolar();
				
				if(conMapGenerico) {
					entity.inicializarMapPlanetaSistemaSolar();
					//entity.setMapPlanetaSistemaSolar(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPlanetaSistemaSolarValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPlanetaSistemaSolar().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA);         		
					entity=PlanetaSistemaSolarDataAccess.getEntityPlanetaSistemaSolar("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPlanetaSistemaSolarOriginal( new PlanetaSistemaSolar());
					////entity.setPlanetaSistemaSolarOriginal(super.getEntity("",entity.getPlanetaSistemaSolarOriginal(),resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA));         		
					////entity.setPlanetaSistemaSolarOriginal(this.getEntityPlanetaSistemaSolar("",entity.getPlanetaSistemaSolarOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePlanetaSistemaSolar(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlanetaSistemaSolar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PlanetaSistemaSolar getEntityPlanetaSistemaSolar(String strPrefijo,PlanetaSistemaSolar entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PlanetaSistemaSolar.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PlanetaSistemaSolar.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PlanetaSistemaSolarDataAccess.setFieldReflectionPlanetaSistemaSolar(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPlanetaSistemaSolar=PlanetaSistemaSolarConstantesFunciones.getTodosTiposColumnasPlanetaSistemaSolar();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPlanetaSistemaSolar) {
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
							field = PlanetaSistemaSolar.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PlanetaSistemaSolar.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PlanetaSistemaSolarDataAccess.setFieldReflectionPlanetaSistemaSolar(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPlanetaSistemaSolar(Field field,String strPrefijo,String sColumn,PlanetaSistemaSolar entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PlanetaSistemaSolarConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlanetaSistemaSolarConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlanetaSistemaSolarConstantesFunciones.IDTIPOVALORACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlanetaSistemaSolarConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlanetaSistemaSolarConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlanetaSistemaSolarConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PlanetaSistemaSolar>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PlanetaSistemaSolar> entities = new  ArrayList<PlanetaSistemaSolar>();
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PlanetaSistemaSolarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PlanetaSistemaSolar();
					entity=super.getEntity("",entity,resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPlanetaSistemaSolar("",entity,resultSet);
					
					//entity.setPlanetaSistemaSolarOriginal( new PlanetaSistemaSolar());
					//entity.setPlanetaSistemaSolarOriginal(super.getEntity("",entity.getPlanetaSistemaSolarOriginal(),resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA));         		
					//entity.setPlanetaSistemaSolarOriginal(this.getEntityPlanetaSistemaSolar("",entity.getPlanetaSistemaSolarOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePlanetaSistemaSolars(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlanetaSistemaSolar(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PlanetaSistemaSolar>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PlanetaSistemaSolar> entities = new  ArrayList<PlanetaSistemaSolar>();
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlanetaSistemaSolarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PlanetaSistemaSolarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PlanetaSistemaSolar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlanetaSistemaSolar> entities = new  ArrayList<PlanetaSistemaSolar>();
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		  
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
	
	public  List<PlanetaSistemaSolar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlanetaSistemaSolar> entities = new  ArrayList<PlanetaSistemaSolar>();
		PlanetaSistemaSolar entity = new PlanetaSistemaSolar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlanetaSistemaSolar();
      	    	entity=super.getEntity("",entity,resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPlanetaSistemaSolar("",entity,resultSet);
      	    	
				//entity.setPlanetaSistemaSolarOriginal( new PlanetaSistemaSolar());
      	    	//entity.setPlanetaSistemaSolarOriginal(super.getEntity("",entity.getPlanetaSistemaSolarOriginal(),resultSet,PlanetaSistemaSolarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlanetaSistemaSolarOriginal(this.getEntityPlanetaSistemaSolar("",entity.getPlanetaSistemaSolarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePlanetaSistemaSolars(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlanetaSistemaSolar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public PlanetaSistemaSolar getEntityPlanetaSistemaSolar(String strPrefijo,PlanetaSistemaSolar entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_tipo_valoracion(resultSet.getLong(strPrefijo+PlanetaSistemaSolarConstantesFunciones.IDTIPOVALORACION));
				entity.setcodigo(resultSet.getString(strPrefijo+PlanetaSistemaSolarConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+PlanetaSistemaSolarConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+PlanetaSistemaSolarConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+PlanetaSistemaSolarConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPlanetaSistemaSolar(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PlanetaSistemaSolar entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PlanetaSistemaSolarDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PlanetaSistemaSolarDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PlanetaSistemaSolarDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PlanetaSistemaSolarDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PlanetaSistemaSolarConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,PlanetaSistemaSolarDataAccess.TABLENAME,PlanetaSistemaSolarDataAccess.ISWITHSTOREPROCEDURES);
			
			PlanetaSistemaSolarDataAccess.setPlanetaSistemaSolarOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public TipoValoracion getTipoValoracion(Connexion connexion,PlanetaSistemaSolar relplanetasistemasolar)throws SQLException,Exception {

		TipoValoracion tipovaloracion= new TipoValoracion();

		try {
			TipoValoracionDataAccess tipovaloracionDataAccess=new TipoValoracionDataAccess();

			tipovaloracionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipovaloracionDataAccess.setConnexionType(this.connexionType);
			tipovaloracionDataAccess.setParameterDbType(this.parameterDbType);

			tipovaloracion=tipovaloracionDataAccess.getEntity(connexion,relplanetasistemasolar.getid_tipo_valoracion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipovaloracion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PlanetaSistemaSolar planetasistemasolar) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!planetasistemasolar.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(planetasistemasolar.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_valoracion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_valoracion.setValue(planetasistemasolar.getid_tipo_valoracion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_valoracion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(planetasistemasolar.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(planetasistemasolar.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(planetasistemasolar.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!planetasistemasolar.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(planetasistemasolar.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(planetasistemasolar.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(planetasistemasolar.getId());
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
	
	public void setIsNewIsChangedFalsePlanetaSistemaSolar(PlanetaSistemaSolar planetasistemasolar)throws Exception  {		
		planetasistemasolar.setIsNew(false);
		planetasistemasolar.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePlanetaSistemaSolars(List<PlanetaSistemaSolar> planetasistemasolars)throws Exception  {				
		for(PlanetaSistemaSolar planetasistemasolar:planetasistemasolars) {
			planetasistemasolar.setIsNew(false);
			planetasistemasolar.setIsChanged(false);
		}
	}
	
	public void generarExportarPlanetaSistemaSolar(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
