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
package com.bydan.erp.tesoreria.business.dataaccess;

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

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//EstadoPagoAutoConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoPagoAutoDataAccess extends  DataAccessHelperSinIdGenerated<EstadoPagoAuto>{ //EstadoPagoAutoDataAccessAdditional,DataAccessHelper<EstadoPagoAuto>
	//static Logger logger = Logger.getLogger(EstadoPagoAutoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_pago_auto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadopagoauto from "+EstadoPagoAutoConstantesFunciones.SPERSISTENCENAME+" estadopagoauto";
	public static String QUERYSELECTNATIVE="select "+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+".id,"+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+".version_row,"+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+".nombre from "+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME;//+" as "+EstadoPagoAutoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+".id,"+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+".version_row,"+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+".nombre from "+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME;//+" as "+EstadoPagoAutoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoPagoAutoConstantesFunciones.SCHEMA+"."+EstadoPagoAutoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOPAGOAUTO_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOPAGOAUTO_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOPAGOAUTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOPAGOAUTO_SELECT(?,?)";
	
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
	
	
	public EstadoPagoAutoDataAccess() {
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
		EstadoPagoAutoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoPagoAutoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoPagoAutoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoPagoAutoOriginal(EstadoPagoAuto estadopagoauto)throws Exception  {
		estadopagoauto.setEstadoPagoAutoOriginal((EstadoPagoAuto)estadopagoauto.clone());		
	}
	
	public void setEstadoPagoAutosOriginal(List<EstadoPagoAuto> estadopagoautos)throws Exception  {
		
		for(EstadoPagoAuto estadopagoauto:estadopagoautos){
			estadopagoauto.setEstadoPagoAutoOriginal((EstadoPagoAuto)estadopagoauto.clone());
		}
	}
	
	public static void setEstadoPagoAutoOriginalStatic(EstadoPagoAuto estadopagoauto)throws Exception  {
		estadopagoauto.setEstadoPagoAutoOriginal((EstadoPagoAuto)estadopagoauto.clone());		
	}
	
	public static void setEstadoPagoAutosOriginalStatic(List<EstadoPagoAuto> estadopagoautos)throws Exception  {
		
		for(EstadoPagoAuto estadopagoauto:estadopagoautos){
			estadopagoauto.setEstadoPagoAutoOriginal((EstadoPagoAuto)estadopagoauto.clone());
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
	
	public  EstadoPagoAuto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoPagoAuto entity = new EstadoPagoAuto();		
		
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
	
	public  EstadoPagoAuto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoPagoAuto entity = new EstadoPagoAuto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.EstadoPagoAuto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoPagoAutoOriginal(new EstadoPagoAuto());
      	    	entity=super.getEntity("",entity,resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoPagoAuto("",entity,resultSet); 
				
				//entity.setEstadoPagoAutoOriginal(super.getEntity("",entity.getEstadoPagoAutoOriginal(),resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPagoAutoOriginal(this.getEntityEstadoPagoAuto("",entity.getEstadoPagoAutoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoPagoAuto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoPagoAuto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoPagoAuto entity = new EstadoPagoAuto();
				
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
	
	public  EstadoPagoAuto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoPagoAuto entity = new EstadoPagoAuto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPagoAutoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.EstadoPagoAuto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoPagoAutoOriginal(new EstadoPagoAuto());
      	    	entity=super.getEntity("",entity,resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoPagoAuto("",entity,resultSet);    
				
				//entity.setEstadoPagoAutoOriginal(super.getEntity("",entity.getEstadoPagoAutoOriginal(),resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPagoAutoOriginal(this.getEntityEstadoPagoAuto("",entity.getEstadoPagoAutoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoPagoAuto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoPagoAuto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoPagoAuto entity = new EstadoPagoAuto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPagoAutoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.EstadoPagoAuto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoPagoAuto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoPagoAuto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoPagoAuto> entities = new  ArrayList<EstadoPagoAuto>();
		EstadoPagoAuto entity = new EstadoPagoAuto();		  
		
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
	
	public  List<EstadoPagoAuto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoPagoAuto> entities = new  ArrayList<EstadoPagoAuto>();
		EstadoPagoAuto entity = new EstadoPagoAuto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPagoAutoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPagoAuto();
      	    	entity=super.getEntity("",entity,resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoPagoAuto("",entity,resultSet);
      	    	
				//entity.setEstadoPagoAutoOriginal( new EstadoPagoAuto());
      	    	//entity.setEstadoPagoAutoOriginal(super.getEntity("",entity.getEstadoPagoAutoOriginal(),resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPagoAutoOriginal(this.getEntityEstadoPagoAuto("",entity.getEstadoPagoAutoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoPagoAutos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPagoAuto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoPagoAuto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoPagoAuto> entities = new  ArrayList<EstadoPagoAuto>();
		EstadoPagoAuto entity = new EstadoPagoAuto();		  
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
	
	public  List<EstadoPagoAuto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoPagoAuto> entities = new  ArrayList<EstadoPagoAuto>();
		EstadoPagoAuto entity = new EstadoPagoAuto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPagoAuto();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoPagoAuto();
					//entity.setMapEstadoPagoAuto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoPagoAutoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoPagoAuto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoPagoAutoDataAccess.getEntityEstadoPagoAuto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoPagoAutoOriginal( new EstadoPagoAuto());
					////entity.setEstadoPagoAutoOriginal(super.getEntity("",entity.getEstadoPagoAutoOriginal(),resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoPagoAutoOriginal(this.getEntityEstadoPagoAuto("",entity.getEstadoPagoAutoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoPagoAutos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPagoAuto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoPagoAuto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoPagoAuto entity = new EstadoPagoAuto();		  
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
	
	public  EstadoPagoAuto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoPagoAuto entity = new EstadoPagoAuto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPagoAuto();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoPagoAuto();
					//entity.setMapEstadoPagoAuto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoPagoAutoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoPagoAuto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoPagoAutoDataAccess.getEntityEstadoPagoAuto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoPagoAutoOriginal( new EstadoPagoAuto());
					////entity.setEstadoPagoAutoOriginal(super.getEntity("",entity.getEstadoPagoAutoOriginal(),resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoPagoAutoOriginal(this.getEntityEstadoPagoAuto("",entity.getEstadoPagoAutoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoPagoAuto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPagoAuto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoPagoAuto getEntityEstadoPagoAuto(String strPrefijo,EstadoPagoAuto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoPagoAuto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoPagoAuto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoPagoAutoDataAccess.setFieldReflectionEstadoPagoAuto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoPagoAuto=EstadoPagoAutoConstantesFunciones.getTodosTiposColumnasEstadoPagoAuto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoPagoAuto) {
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
							field = EstadoPagoAuto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoPagoAuto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoPagoAutoDataAccess.setFieldReflectionEstadoPagoAuto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoPagoAuto(Field field,String strPrefijo,String sColumn,EstadoPagoAuto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoPagoAutoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoPagoAutoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoPagoAutoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoPagoAuto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoPagoAuto> entities = new  ArrayList<EstadoPagoAuto>();
		EstadoPagoAuto entity = new EstadoPagoAuto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPagoAutoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoPagoAuto();
					entity=super.getEntity("",entity,resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoPagoAuto("",entity,resultSet);
					
					//entity.setEstadoPagoAutoOriginal( new EstadoPagoAuto());
					//entity.setEstadoPagoAutoOriginal(super.getEntity("",entity.getEstadoPagoAutoOriginal(),resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoPagoAutoOriginal(this.getEntityEstadoPagoAuto("",entity.getEstadoPagoAutoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoPagoAutos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPagoAuto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoPagoAuto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoPagoAuto> entities = new  ArrayList<EstadoPagoAuto>();
		EstadoPagoAuto entity = new EstadoPagoAuto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPagoAutoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPagoAutoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoPagoAuto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPagoAuto> entities = new  ArrayList<EstadoPagoAuto>();
		EstadoPagoAuto entity = new EstadoPagoAuto();		  
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
	
	public  List<EstadoPagoAuto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPagoAuto> entities = new  ArrayList<EstadoPagoAuto>();
		EstadoPagoAuto entity = new EstadoPagoAuto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPagoAuto();
      	    	entity=super.getEntity("",entity,resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoPagoAuto("",entity,resultSet);
      	    	
				//entity.setEstadoPagoAutoOriginal( new EstadoPagoAuto());
      	    	//entity.setEstadoPagoAutoOriginal(super.getEntity("",entity.getEstadoPagoAutoOriginal(),resultSet,EstadoPagoAutoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPagoAutoOriginal(this.getEntityEstadoPagoAuto("",entity.getEstadoPagoAutoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoPagoAutos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPagoAuto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoPagoAuto getEntityEstadoPagoAuto(String strPrefijo,EstadoPagoAuto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+EstadoPagoAutoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+EstadoPagoAutoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoPagoAuto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoPagoAuto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoPagoAutoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoPagoAutoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoPagoAutoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoPagoAutoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoPagoAutoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoPagoAutoDataAccess.TABLENAME,EstadoPagoAutoDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoPagoAutoDataAccess.setEstadoPagoAutoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<PagoAuto> getPagoAutos(Connexion connexion,EstadoPagoAuto estadopagoauto)throws SQLException,Exception {

		List<PagoAuto> pagoautos= new ArrayList<PagoAuto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoPagoAutoConstantesFunciones.SCHEMA+".estado_pago_auto ON "+PagoAutoConstantesFunciones.SCHEMA+".pago_auto.id_estado_pago_auto="+EstadoPagoAutoConstantesFunciones.SCHEMA+".estado_pago_auto.id WHERE "+EstadoPagoAutoConstantesFunciones.SCHEMA+".estado_pago_auto.id="+String.valueOf(estadopagoauto.getId());
			} else {
				sQuery=" INNER JOIN pagoauto.EstadoPagoAuto WHERE pagoauto.EstadoPagoAuto.id="+String.valueOf(estadopagoauto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PagoAutoDataAccess pagoautoDataAccess=new PagoAutoDataAccess();

			pagoautoDataAccess.setConnexionType(this.connexionType);
			pagoautoDataAccess.setParameterDbType(this.parameterDbType);
			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pagoautos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoPagoAuto estadopagoauto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadopagoauto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadopagoauto.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadopagoauto.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadopagoauto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadopagoauto.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadopagoauto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadopagoauto.getId());
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
	
	public void setIsNewIsChangedFalseEstadoPagoAuto(EstadoPagoAuto estadopagoauto)throws Exception  {		
		estadopagoauto.setIsNew(false);
		estadopagoauto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoPagoAutos(List<EstadoPagoAuto> estadopagoautos)throws Exception  {				
		for(EstadoPagoAuto estadopagoauto:estadopagoautos) {
			estadopagoauto.setIsNew(false);
			estadopagoauto.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoPagoAuto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
