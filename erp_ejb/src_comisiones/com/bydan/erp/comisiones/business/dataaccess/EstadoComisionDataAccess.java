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
package com.bydan.erp.comisiones.business.dataaccess;

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

import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.comisiones.util.*;//EstadoComisionConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoComisionDataAccess extends  EstadoComisionDataAccessAdditional{ //EstadoComisionDataAccessAdditional,DataAccessHelper<EstadoComision>
	//static Logger logger = Logger.getLogger(EstadoComisionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_comision";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadocomision from "+EstadoComisionConstantesFunciones.SPERSISTENCENAME+" estadocomision";
	public static String QUERYSELECTNATIVE="select "+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+".id,"+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+".version_row,"+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+".codigo,"+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+".nombre from "+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME;//+" as "+EstadoComisionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+".id,"+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+".version_row,"+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+".codigo from "+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME;//+" as "+EstadoComisionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOCOMISION_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOCOMISION_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOCOMISION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOCOMISION_SELECT(?,?)";
	
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
	
	
	protected EstadoComisionDataAccessAdditional estadocomisionDataAccessAdditional=null;
	
	public EstadoComisionDataAccessAdditional getEstadoComisionDataAccessAdditional() {
		return this.estadocomisionDataAccessAdditional;
	}
	
	public void setEstadoComisionDataAccessAdditional(EstadoComisionDataAccessAdditional estadocomisionDataAccessAdditional) {
		try {
			this.estadocomisionDataAccessAdditional=estadocomisionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoComisionDataAccess() {
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
		EstadoComisionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoComisionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoComisionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoComisionOriginal(EstadoComision estadocomision)throws Exception  {
		estadocomision.setEstadoComisionOriginal((EstadoComision)estadocomision.clone());		
	}
	
	public void setEstadoComisionsOriginal(List<EstadoComision> estadocomisions)throws Exception  {
		
		for(EstadoComision estadocomision:estadocomisions){
			estadocomision.setEstadoComisionOriginal((EstadoComision)estadocomision.clone());
		}
	}
	
	public static void setEstadoComisionOriginalStatic(EstadoComision estadocomision)throws Exception  {
		estadocomision.setEstadoComisionOriginal((EstadoComision)estadocomision.clone());		
	}
	
	public static void setEstadoComisionsOriginalStatic(List<EstadoComision> estadocomisions)throws Exception  {
		
		for(EstadoComision estadocomision:estadocomisions){
			estadocomision.setEstadoComisionOriginal((EstadoComision)estadocomision.clone());
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
	
	public  EstadoComision getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoComision entity = new EstadoComision();		
		
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
	
	public  EstadoComision getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoComision entity = new EstadoComision();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Comisiones.EstadoComision.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoComisionOriginal(new EstadoComision());
      	    	entity=super.getEntity("",entity,resultSet,EstadoComisionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoComision("",entity,resultSet); 
				
				//entity.setEstadoComisionOriginal(super.getEntity("",entity.getEstadoComisionOriginal(),resultSet,EstadoComisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoComisionOriginal(this.getEntityEstadoComision("",entity.getEstadoComisionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoComision(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoComision getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoComision entity = new EstadoComision();
				
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
	
	public  EstadoComision getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoComision entity = new EstadoComision();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoComisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.EstadoComision.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoComisionOriginal(new EstadoComision());
      	    	entity=super.getEntity("",entity,resultSet,EstadoComisionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoComision("",entity,resultSet);    
				
				//entity.setEstadoComisionOriginal(super.getEntity("",entity.getEstadoComisionOriginal(),resultSet,EstadoComisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoComisionOriginal(this.getEntityEstadoComision("",entity.getEstadoComisionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoComision(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoComision
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoComision entity = new EstadoComision();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoComisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.EstadoComision.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoComision(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoComision> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoComision> entities = new  ArrayList<EstadoComision>();
		EstadoComision entity = new EstadoComision();		  
		
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
	
	public  List<EstadoComision> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoComision> entities = new  ArrayList<EstadoComision>();
		EstadoComision entity = new EstadoComision();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoComisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoComision();
      	    	entity=super.getEntity("",entity,resultSet,EstadoComisionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoComision("",entity,resultSet);
      	    	
				//entity.setEstadoComisionOriginal( new EstadoComision());
      	    	//entity.setEstadoComisionOriginal(super.getEntity("",entity.getEstadoComisionOriginal(),resultSet,EstadoComisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoComisionOriginal(this.getEntityEstadoComision("",entity.getEstadoComisionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoComisions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoComision(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoComision> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoComision> entities = new  ArrayList<EstadoComision>();
		EstadoComision entity = new EstadoComision();		  
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
	
	public  List<EstadoComision> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoComision> entities = new  ArrayList<EstadoComision>();
		EstadoComision entity = new EstadoComision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoComision();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoComision();
					//entity.setMapEstadoComision(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoComisionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoComision().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoComisionDataAccess.ISWITHSCHEMA);         		
					entity=EstadoComisionDataAccess.getEntityEstadoComision("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoComisionOriginal( new EstadoComision());
					////entity.setEstadoComisionOriginal(super.getEntity("",entity.getEstadoComisionOriginal(),resultSet,EstadoComisionDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoComisionOriginal(this.getEntityEstadoComision("",entity.getEstadoComisionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoComisions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoComision(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoComision getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoComision entity = new EstadoComision();		  
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
	
	public  EstadoComision getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoComision entity = new EstadoComision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoComision();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoComision();
					//entity.setMapEstadoComision(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoComisionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoComision().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoComisionDataAccess.ISWITHSCHEMA);         		
					entity=EstadoComisionDataAccess.getEntityEstadoComision("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoComisionOriginal( new EstadoComision());
					////entity.setEstadoComisionOriginal(super.getEntity("",entity.getEstadoComisionOriginal(),resultSet,EstadoComisionDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoComisionOriginal(this.getEntityEstadoComision("",entity.getEstadoComisionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoComision(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoComision(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoComision getEntityEstadoComision(String strPrefijo,EstadoComision entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoComision.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoComision.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoComisionDataAccess.setFieldReflectionEstadoComision(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoComision=EstadoComisionConstantesFunciones.getTodosTiposColumnasEstadoComision();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoComision) {
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
							field = EstadoComision.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoComision.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoComisionDataAccess.setFieldReflectionEstadoComision(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoComision(Field field,String strPrefijo,String sColumn,EstadoComision entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoComisionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoComisionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoComisionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoComisionConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoComision>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoComision> entities = new  ArrayList<EstadoComision>();
		EstadoComision entity = new EstadoComision();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoComisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoComision();
					entity=super.getEntity("",entity,resultSet,EstadoComisionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoComision("",entity,resultSet);
					
					//entity.setEstadoComisionOriginal( new EstadoComision());
					//entity.setEstadoComisionOriginal(super.getEntity("",entity.getEstadoComisionOriginal(),resultSet,EstadoComisionDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoComisionOriginal(this.getEntityEstadoComision("",entity.getEstadoComisionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoComisions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoComision(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoComision>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoComision> entities = new  ArrayList<EstadoComision>();
		EstadoComision entity = new EstadoComision();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoComisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoComisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoComision> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoComision> entities = new  ArrayList<EstadoComision>();
		EstadoComision entity = new EstadoComision();		  
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
	
	public  List<EstadoComision> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoComision> entities = new  ArrayList<EstadoComision>();
		EstadoComision entity = new EstadoComision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoComision();
      	    	entity=super.getEntity("",entity,resultSet,EstadoComisionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoComision("",entity,resultSet);
      	    	
				//entity.setEstadoComisionOriginal( new EstadoComision());
      	    	//entity.setEstadoComisionOriginal(super.getEntity("",entity.getEstadoComisionOriginal(),resultSet,EstadoComisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoComisionOriginal(this.getEntityEstadoComision("",entity.getEstadoComisionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoComisions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoComision(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoComision> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoComision> entities = new  ArrayList<EstadoComision>();
		EstadoComision entity = new EstadoComision();		  
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
	
	public  List<EstadoComision> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoComision> entities = new  ArrayList<EstadoComision>();
		EstadoComision entity = new EstadoComision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoComision();
      	    	entity=super.getEntity("",entity,resultSet,EstadoComisionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoComision("",entity,resultSet);
      	    	
				//entity.setEstadoComisionOriginal( new EstadoComision());
      	    	//entity.setEstadoComisionOriginal(super.getEntity("",entity.getEstadoComisionOriginal(),resultSet,EstadoComisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoComisionOriginal(this.getEntityEstadoComision("",entity.getEstadoComisionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoComisions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoComision getEntityEstadoComision(String strPrefijo,EstadoComision entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoComisionConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoComisionConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoComisionConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoComision(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoComision entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoComisionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoComisionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoComisionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoComisionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoComisionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoComisionDataAccess.TABLENAME,EstadoComisionDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoComisionDataAccess.setEstadoComisionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<ComisionCate> getComisionCates(Connexion connexion,EstadoComision estadocomision)throws SQLException,Exception {

		List<ComisionCate> comisioncates= new ArrayList<ComisionCate>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision ON "+ComisionCateConstantesFunciones.SCHEMA+".comision_cate.id_estado_comision="+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision.id WHERE "+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision.id="+String.valueOf(estadocomision.getId());
			} else {
				sQuery=" INNER JOIN comisioncate.EstadoComision WHERE comisioncate.EstadoComision.id="+String.valueOf(estadocomision.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionCateDataAccess comisioncateDataAccess=new ComisionCateDataAccess();

			comisioncateDataAccess.setConnexionType(this.connexionType);
			comisioncateDataAccess.setParameterDbType(this.parameterDbType);
			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisioncates;

	}

	public List<ComisionMarca> getComisionMarcas(Connexion connexion,EstadoComision estadocomision)throws SQLException,Exception {

		List<ComisionMarca> comisionmarcas= new ArrayList<ComisionMarca>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision ON "+ComisionMarcaConstantesFunciones.SCHEMA+".comision_marca.id_estado_comision="+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision.id WHERE "+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision.id="+String.valueOf(estadocomision.getId());
			} else {
				sQuery=" INNER JOIN comisionmarca.EstadoComision WHERE comisionmarca.EstadoComision.id="+String.valueOf(estadocomision.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionMarcaDataAccess comisionmarcaDataAccess=new ComisionMarcaDataAccess();

			comisionmarcaDataAccess.setConnexionType(this.connexionType);
			comisionmarcaDataAccess.setParameterDbType(this.parameterDbType);
			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionmarcas;

	}

	public List<ComisionLinea> getComisionLineas(Connexion connexion,EstadoComision estadocomision)throws SQLException,Exception {

		List<ComisionLinea> comisionlineas= new ArrayList<ComisionLinea>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision ON "+ComisionLineaConstantesFunciones.SCHEMA+".comision_linea.id_estado_comision="+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision.id WHERE "+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision.id="+String.valueOf(estadocomision.getId());
			} else {
				sQuery=" INNER JOIN comisionlinea.EstadoComision WHERE comisionlinea.EstadoComision.id="+String.valueOf(estadocomision.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionLineaDataAccess comisionlineaDataAccess=new ComisionLineaDataAccess();

			comisionlineaDataAccess.setConnexionType(this.connexionType);
			comisionlineaDataAccess.setParameterDbType(this.parameterDbType);
			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionlineas;

	}

	public List<ComisionGrupo> getComisionGrupos(Connexion connexion,EstadoComision estadocomision)throws SQLException,Exception {

		List<ComisionGrupo> comisiongrupos= new ArrayList<ComisionGrupo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision ON "+ComisionGrupoConstantesFunciones.SCHEMA+".comision_grupo.id_estado_comision="+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision.id WHERE "+EstadoComisionConstantesFunciones.SCHEMA+".estado_comision.id="+String.valueOf(estadocomision.getId());
			} else {
				sQuery=" INNER JOIN comisiongrupo.EstadoComision WHERE comisiongrupo.EstadoComision.id="+String.valueOf(estadocomision.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionGrupoDataAccess comisiongrupoDataAccess=new ComisionGrupoDataAccess();

			comisiongrupoDataAccess.setConnexionType(this.connexionType);
			comisiongrupoDataAccess.setParameterDbType(this.parameterDbType);
			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisiongrupos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoComision estadocomision) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadocomision.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadocomision.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadocomision.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadocomision.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadocomision.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadocomision.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadocomision.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadocomision.getId());
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
	
	public void setIsNewIsChangedFalseEstadoComision(EstadoComision estadocomision)throws Exception  {		
		estadocomision.setIsNew(false);
		estadocomision.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoComisions(List<EstadoComision> estadocomisions)throws Exception  {				
		for(EstadoComision estadocomision:estadocomisions) {
			estadocomision.setIsNew(false);
			estadocomision.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoComision(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
