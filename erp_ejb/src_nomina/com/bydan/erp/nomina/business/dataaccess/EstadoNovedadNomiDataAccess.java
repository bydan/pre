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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//EstadoNovedadNomiConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoNovedadNomiDataAccess extends  EstadoNovedadNomiDataAccessAdditional{ //EstadoNovedadNomiDataAccessAdditional,DataAccessHelper<EstadoNovedadNomi>
	//static Logger logger = Logger.getLogger(EstadoNovedadNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_novedad_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadonovedadnomi from "+EstadoNovedadNomiConstantesFunciones.SPERSISTENCENAME+" estadonovedadnomi";
	public static String QUERYSELECTNATIVE="select "+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+".id,"+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+".version_row,"+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+".codigo,"+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+".nombre from "+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME;//+" as "+EstadoNovedadNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+".id,"+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+".version_row,"+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+".codigo from "+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME;//+" as "+EstadoNovedadNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoNovedadNomiConstantesFunciones.SCHEMA+"."+EstadoNovedadNomiConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADONOVEDADNOMI_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADONOVEDADNOMI_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADONOVEDADNOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADONOVEDADNOMI_SELECT(?,?)";
	
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
	
	
	protected EstadoNovedadNomiDataAccessAdditional estadonovedadnomiDataAccessAdditional=null;
	
	public EstadoNovedadNomiDataAccessAdditional getEstadoNovedadNomiDataAccessAdditional() {
		return this.estadonovedadnomiDataAccessAdditional;
	}
	
	public void setEstadoNovedadNomiDataAccessAdditional(EstadoNovedadNomiDataAccessAdditional estadonovedadnomiDataAccessAdditional) {
		try {
			this.estadonovedadnomiDataAccessAdditional=estadonovedadnomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoNovedadNomiDataAccess() {
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
		EstadoNovedadNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoNovedadNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoNovedadNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoNovedadNomiOriginal(EstadoNovedadNomi estadonovedadnomi)throws Exception  {
		estadonovedadnomi.setEstadoNovedadNomiOriginal((EstadoNovedadNomi)estadonovedadnomi.clone());		
	}
	
	public void setEstadoNovedadNomisOriginal(List<EstadoNovedadNomi> estadonovedadnomis)throws Exception  {
		
		for(EstadoNovedadNomi estadonovedadnomi:estadonovedadnomis){
			estadonovedadnomi.setEstadoNovedadNomiOriginal((EstadoNovedadNomi)estadonovedadnomi.clone());
		}
	}
	
	public static void setEstadoNovedadNomiOriginalStatic(EstadoNovedadNomi estadonovedadnomi)throws Exception  {
		estadonovedadnomi.setEstadoNovedadNomiOriginal((EstadoNovedadNomi)estadonovedadnomi.clone());		
	}
	
	public static void setEstadoNovedadNomisOriginalStatic(List<EstadoNovedadNomi> estadonovedadnomis)throws Exception  {
		
		for(EstadoNovedadNomi estadonovedadnomi:estadonovedadnomis){
			estadonovedadnomi.setEstadoNovedadNomiOriginal((EstadoNovedadNomi)estadonovedadnomi.clone());
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
	
	public  EstadoNovedadNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		
		
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
	
	public  EstadoNovedadNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EstadoNovedadNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoNovedadNomiOriginal(new EstadoNovedadNomi());
      	    	entity=super.getEntity("",entity,resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoNovedadNomi("",entity,resultSet); 
				
				//entity.setEstadoNovedadNomiOriginal(super.getEntity("",entity.getEstadoNovedadNomiOriginal(),resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNovedadNomiOriginal(this.getEntityEstadoNovedadNomi("",entity.getEstadoNovedadNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoNovedadNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoNovedadNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoNovedadNomi entity = new EstadoNovedadNomi();
				
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
	
	public  EstadoNovedadNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoNovedadNomi entity = new EstadoNovedadNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EstadoNovedadNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoNovedadNomiOriginal(new EstadoNovedadNomi());
      	    	entity=super.getEntity("",entity,resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoNovedadNomi("",entity,resultSet);    
				
				//entity.setEstadoNovedadNomiOriginal(super.getEntity("",entity.getEstadoNovedadNomiOriginal(),resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNovedadNomiOriginal(this.getEntityEstadoNovedadNomi("",entity.getEstadoNovedadNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoNovedadNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoNovedadNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoNovedadNomi entity = new EstadoNovedadNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EstadoNovedadNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoNovedadNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoNovedadNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoNovedadNomi> entities = new  ArrayList<EstadoNovedadNomi>();
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
		
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
	
	public  List<EstadoNovedadNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoNovedadNomi> entities = new  ArrayList<EstadoNovedadNomi>();
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNovedadNomi();
      	    	entity=super.getEntity("",entity,resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoNovedadNomi("",entity,resultSet);
      	    	
				//entity.setEstadoNovedadNomiOriginal( new EstadoNovedadNomi());
      	    	//entity.setEstadoNovedadNomiOriginal(super.getEntity("",entity.getEstadoNovedadNomiOriginal(),resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNovedadNomiOriginal(this.getEntityEstadoNovedadNomi("",entity.getEstadoNovedadNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoNovedadNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoNovedadNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoNovedadNomi> entities = new  ArrayList<EstadoNovedadNomi>();
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
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
	
	public  List<EstadoNovedadNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoNovedadNomi> entities = new  ArrayList<EstadoNovedadNomi>();
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNovedadNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoNovedadNomi();
					//entity.setMapEstadoNovedadNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoNovedadNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoNovedadNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA);         		
					entity=EstadoNovedadNomiDataAccess.getEntityEstadoNovedadNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoNovedadNomiOriginal( new EstadoNovedadNomi());
					////entity.setEstadoNovedadNomiOriginal(super.getEntity("",entity.getEstadoNovedadNomiOriginal(),resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoNovedadNomiOriginal(this.getEntityEstadoNovedadNomi("",entity.getEstadoNovedadNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoNovedadNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoNovedadNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
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
	
	public  EstadoNovedadNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNovedadNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoNovedadNomi();
					//entity.setMapEstadoNovedadNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoNovedadNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoNovedadNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA);         		
					entity=EstadoNovedadNomiDataAccess.getEntityEstadoNovedadNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoNovedadNomiOriginal( new EstadoNovedadNomi());
					////entity.setEstadoNovedadNomiOriginal(super.getEntity("",entity.getEstadoNovedadNomiOriginal(),resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoNovedadNomiOriginal(this.getEntityEstadoNovedadNomi("",entity.getEstadoNovedadNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoNovedadNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoNovedadNomi getEntityEstadoNovedadNomi(String strPrefijo,EstadoNovedadNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoNovedadNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoNovedadNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoNovedadNomiDataAccess.setFieldReflectionEstadoNovedadNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoNovedadNomi=EstadoNovedadNomiConstantesFunciones.getTodosTiposColumnasEstadoNovedadNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoNovedadNomi) {
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
							field = EstadoNovedadNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoNovedadNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoNovedadNomiDataAccess.setFieldReflectionEstadoNovedadNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoNovedadNomi(Field field,String strPrefijo,String sColumn,EstadoNovedadNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoNovedadNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoNovedadNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoNovedadNomiConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoNovedadNomiConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoNovedadNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoNovedadNomi> entities = new  ArrayList<EstadoNovedadNomi>();
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoNovedadNomi();
					entity=super.getEntity("",entity,resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoNovedadNomi("",entity,resultSet);
					
					//entity.setEstadoNovedadNomiOriginal( new EstadoNovedadNomi());
					//entity.setEstadoNovedadNomiOriginal(super.getEntity("",entity.getEstadoNovedadNomiOriginal(),resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoNovedadNomiOriginal(this.getEntityEstadoNovedadNomi("",entity.getEstadoNovedadNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoNovedadNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoNovedadNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoNovedadNomi> entities = new  ArrayList<EstadoNovedadNomi>();
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoNovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoNovedadNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoNovedadNomi> entities = new  ArrayList<EstadoNovedadNomi>();
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
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
	
	public  List<EstadoNovedadNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoNovedadNomi> entities = new  ArrayList<EstadoNovedadNomi>();
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNovedadNomi();
      	    	entity=super.getEntity("",entity,resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoNovedadNomi("",entity,resultSet);
      	    	
				//entity.setEstadoNovedadNomiOriginal( new EstadoNovedadNomi());
      	    	//entity.setEstadoNovedadNomiOriginal(super.getEntity("",entity.getEstadoNovedadNomiOriginal(),resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNovedadNomiOriginal(this.getEntityEstadoNovedadNomi("",entity.getEstadoNovedadNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoNovedadNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoNovedadNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoNovedadNomi> entities = new  ArrayList<EstadoNovedadNomi>();
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
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
	
	public  List<EstadoNovedadNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoNovedadNomi> entities = new  ArrayList<EstadoNovedadNomi>();
		EstadoNovedadNomi entity = new EstadoNovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNovedadNomi();
      	    	entity=super.getEntity("",entity,resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoNovedadNomi("",entity,resultSet);
      	    	
				//entity.setEstadoNovedadNomiOriginal( new EstadoNovedadNomi());
      	    	//entity.setEstadoNovedadNomiOriginal(super.getEntity("",entity.getEstadoNovedadNomiOriginal(),resultSet,EstadoNovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNovedadNomiOriginal(this.getEntityEstadoNovedadNomi("",entity.getEstadoNovedadNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoNovedadNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoNovedadNomi getEntityEstadoNovedadNomi(String strPrefijo,EstadoNovedadNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoNovedadNomiConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoNovedadNomiConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoNovedadNomiConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoNovedadNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoNovedadNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoNovedadNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoNovedadNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoNovedadNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoNovedadNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoNovedadNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoNovedadNomiDataAccess.TABLENAME,EstadoNovedadNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoNovedadNomiDataAccess.setEstadoNovedadNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<NovedadNomi> getNovedadNomis(Connexion connexion,EstadoNovedadNomi estadonovedadnomi)throws SQLException,Exception {

		List<NovedadNomi> novedadnomis= new ArrayList<NovedadNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoNovedadNomiConstantesFunciones.SCHEMA+".estado_novedad_nomi ON "+NovedadNomiConstantesFunciones.SCHEMA+".novedad_nomi.id_estado_novedad_nomi="+EstadoNovedadNomiConstantesFunciones.SCHEMA+".estado_novedad_nomi.id WHERE "+EstadoNovedadNomiConstantesFunciones.SCHEMA+".estado_novedad_nomi.id="+String.valueOf(estadonovedadnomi.getId());
			} else {
				sQuery=" INNER JOIN novedadnomi.EstadoNovedadNomi WHERE novedadnomi.EstadoNovedadNomi.id="+String.valueOf(estadonovedadnomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NovedadNomiDataAccess novedadnomiDataAccess=new NovedadNomiDataAccess();

			novedadnomiDataAccess.setConnexionType(this.connexionType);
			novedadnomiDataAccess.setParameterDbType(this.parameterDbType);
			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadnomis;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoNovedadNomi estadonovedadnomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadonovedadnomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadonovedadnomi.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadonovedadnomi.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadonovedadnomi.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadonovedadnomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadonovedadnomi.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadonovedadnomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadonovedadnomi.getId());
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
	
	public void setIsNewIsChangedFalseEstadoNovedadNomi(EstadoNovedadNomi estadonovedadnomi)throws Exception  {		
		estadonovedadnomi.setIsNew(false);
		estadonovedadnomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoNovedadNomis(List<EstadoNovedadNomi> estadonovedadnomis)throws Exception  {				
		for(EstadoNovedadNomi estadonovedadnomi:estadonovedadnomis) {
			estadonovedadnomi.setIsNew(false);
			estadonovedadnomi.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoNovedadNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
