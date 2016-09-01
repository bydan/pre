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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//EstadoNovedadSeguimientoConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoNovedadSeguimientoDataAccess extends  DataAccessHelperSinIdGenerated<EstadoNovedadSeguimiento>{ //EstadoNovedadSeguimientoDataAccessAdditional,DataAccessHelper<EstadoNovedadSeguimiento>
	//static Logger logger = Logger.getLogger(EstadoNovedadSeguimientoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_novedad_seguimiento";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadonovedadseguimiento from "+EstadoNovedadSeguimientoConstantesFunciones.SPERSISTENCENAME+" estadonovedadseguimiento";
	public static String QUERYSELECTNATIVE="select "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+".id,"+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+".version_row,"+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+".codigo,"+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+".nombre from "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME;//+" as "+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+".id,"+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+".version_row,"+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+".codigo from "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME;//+" as "+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADONOVEDADSEGUIMIENTO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADONOVEDADSEGUIMIENTO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADONOVEDADSEGUIMIENTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADONOVEDADSEGUIMIENTO_SELECT(?,?)";
	
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
	
	
	public EstadoNovedadSeguimientoDataAccess() {
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
		EstadoNovedadSeguimientoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoNovedadSeguimientoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoNovedadSeguimientoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoNovedadSeguimientoOriginal(EstadoNovedadSeguimiento estadonovedadseguimiento)throws Exception  {
		estadonovedadseguimiento.setEstadoNovedadSeguimientoOriginal((EstadoNovedadSeguimiento)estadonovedadseguimiento.clone());		
	}
	
	public void setEstadoNovedadSeguimientosOriginal(List<EstadoNovedadSeguimiento> estadonovedadseguimientos)throws Exception  {
		
		for(EstadoNovedadSeguimiento estadonovedadseguimiento:estadonovedadseguimientos){
			estadonovedadseguimiento.setEstadoNovedadSeguimientoOriginal((EstadoNovedadSeguimiento)estadonovedadseguimiento.clone());
		}
	}
	
	public static void setEstadoNovedadSeguimientoOriginalStatic(EstadoNovedadSeguimiento estadonovedadseguimiento)throws Exception  {
		estadonovedadseguimiento.setEstadoNovedadSeguimientoOriginal((EstadoNovedadSeguimiento)estadonovedadseguimiento.clone());		
	}
	
	public static void setEstadoNovedadSeguimientosOriginalStatic(List<EstadoNovedadSeguimiento> estadonovedadseguimientos)throws Exception  {
		
		for(EstadoNovedadSeguimiento estadonovedadseguimiento:estadonovedadseguimientos){
			estadonovedadseguimiento.setEstadoNovedadSeguimientoOriginal((EstadoNovedadSeguimiento)estadonovedadseguimiento.clone());
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
	
	public  EstadoNovedadSeguimiento getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		
		
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
	
	public  EstadoNovedadSeguimiento getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.EstadoNovedadSeguimiento.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoNovedadSeguimientoOriginal(new EstadoNovedadSeguimiento());
      	    	entity=super.getEntity("",entity,resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoNovedadSeguimiento("",entity,resultSet); 
				
				//entity.setEstadoNovedadSeguimientoOriginal(super.getEntity("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNovedadSeguimientoOriginal(this.getEntityEstadoNovedadSeguimiento("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoNovedadSeguimiento(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoNovedadSeguimiento getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();
				
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
	
	public  EstadoNovedadSeguimiento getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNovedadSeguimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoNovedadSeguimiento.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoNovedadSeguimientoOriginal(new EstadoNovedadSeguimiento());
      	    	entity=super.getEntity("",entity,resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoNovedadSeguimiento("",entity,resultSet);    
				
				//entity.setEstadoNovedadSeguimientoOriginal(super.getEntity("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNovedadSeguimientoOriginal(this.getEntityEstadoNovedadSeguimiento("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoNovedadSeguimiento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoNovedadSeguimiento
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNovedadSeguimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoNovedadSeguimiento.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoNovedadSeguimiento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoNovedadSeguimiento> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoNovedadSeguimiento> entities = new  ArrayList<EstadoNovedadSeguimiento>();
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		  
		
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
	
	public  List<EstadoNovedadSeguimiento> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoNovedadSeguimiento> entities = new  ArrayList<EstadoNovedadSeguimiento>();
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNovedadSeguimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNovedadSeguimiento();
      	    	entity=super.getEntity("",entity,resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoNovedadSeguimiento("",entity,resultSet);
      	    	
				//entity.setEstadoNovedadSeguimientoOriginal( new EstadoNovedadSeguimiento());
      	    	//entity.setEstadoNovedadSeguimientoOriginal(super.getEntity("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNovedadSeguimientoOriginal(this.getEntityEstadoNovedadSeguimiento("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoNovedadSeguimientos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNovedadSeguimiento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoNovedadSeguimiento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoNovedadSeguimiento> entities = new  ArrayList<EstadoNovedadSeguimiento>();
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		  
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
	
	public  List<EstadoNovedadSeguimiento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoNovedadSeguimiento> entities = new  ArrayList<EstadoNovedadSeguimiento>();
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNovedadSeguimiento();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoNovedadSeguimiento();
					//entity.setMapEstadoNovedadSeguimiento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoNovedadSeguimientoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoNovedadSeguimiento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoNovedadSeguimientoDataAccess.getEntityEstadoNovedadSeguimiento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoNovedadSeguimientoOriginal( new EstadoNovedadSeguimiento());
					////entity.setEstadoNovedadSeguimientoOriginal(super.getEntity("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoNovedadSeguimientoOriginal(this.getEntityEstadoNovedadSeguimiento("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoNovedadSeguimientos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNovedadSeguimiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoNovedadSeguimiento getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		  
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
	
	public  EstadoNovedadSeguimiento getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNovedadSeguimiento();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoNovedadSeguimiento();
					//entity.setMapEstadoNovedadSeguimiento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoNovedadSeguimientoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoNovedadSeguimiento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoNovedadSeguimientoDataAccess.getEntityEstadoNovedadSeguimiento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoNovedadSeguimientoOriginal( new EstadoNovedadSeguimiento());
					////entity.setEstadoNovedadSeguimientoOriginal(super.getEntity("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoNovedadSeguimientoOriginal(this.getEntityEstadoNovedadSeguimiento("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoNovedadSeguimiento(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNovedadSeguimiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoNovedadSeguimiento getEntityEstadoNovedadSeguimiento(String strPrefijo,EstadoNovedadSeguimiento entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoNovedadSeguimiento.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoNovedadSeguimiento.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoNovedadSeguimientoDataAccess.setFieldReflectionEstadoNovedadSeguimiento(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoNovedadSeguimiento=EstadoNovedadSeguimientoConstantesFunciones.getTodosTiposColumnasEstadoNovedadSeguimiento();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoNovedadSeguimiento) {
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
							field = EstadoNovedadSeguimiento.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoNovedadSeguimiento.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoNovedadSeguimientoDataAccess.setFieldReflectionEstadoNovedadSeguimiento(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoNovedadSeguimiento(Field field,String strPrefijo,String sColumn,EstadoNovedadSeguimiento entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoNovedadSeguimientoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoNovedadSeguimientoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoNovedadSeguimientoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoNovedadSeguimientoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoNovedadSeguimiento>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoNovedadSeguimiento> entities = new  ArrayList<EstadoNovedadSeguimiento>();
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNovedadSeguimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoNovedadSeguimiento();
					entity=super.getEntity("",entity,resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoNovedadSeguimiento("",entity,resultSet);
					
					//entity.setEstadoNovedadSeguimientoOriginal( new EstadoNovedadSeguimiento());
					//entity.setEstadoNovedadSeguimientoOriginal(super.getEntity("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoNovedadSeguimientoOriginal(this.getEntityEstadoNovedadSeguimiento("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoNovedadSeguimientos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNovedadSeguimiento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoNovedadSeguimiento>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoNovedadSeguimiento> entities = new  ArrayList<EstadoNovedadSeguimiento>();
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoNovedadSeguimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoNovedadSeguimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoNovedadSeguimiento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoNovedadSeguimiento> entities = new  ArrayList<EstadoNovedadSeguimiento>();
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		  
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
	
	public  List<EstadoNovedadSeguimiento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoNovedadSeguimiento> entities = new  ArrayList<EstadoNovedadSeguimiento>();
		EstadoNovedadSeguimiento entity = new EstadoNovedadSeguimiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoNovedadSeguimiento();
      	    	entity=super.getEntity("",entity,resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoNovedadSeguimiento("",entity,resultSet);
      	    	
				//entity.setEstadoNovedadSeguimientoOriginal( new EstadoNovedadSeguimiento());
      	    	//entity.setEstadoNovedadSeguimientoOriginal(super.getEntity("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet,EstadoNovedadSeguimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoNovedadSeguimientoOriginal(this.getEntityEstadoNovedadSeguimiento("",entity.getEstadoNovedadSeguimientoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoNovedadSeguimientos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoNovedadSeguimiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoNovedadSeguimiento getEntityEstadoNovedadSeguimiento(String strPrefijo,EstadoNovedadSeguimiento entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoNovedadSeguimientoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoNovedadSeguimientoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoNovedadSeguimientoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoNovedadSeguimiento(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoNovedadSeguimiento entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoNovedadSeguimientoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoNovedadSeguimientoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoNovedadSeguimientoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoNovedadSeguimientoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoNovedadSeguimientoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoNovedadSeguimientoDataAccess.TABLENAME,EstadoNovedadSeguimientoDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoNovedadSeguimientoDataAccess.setEstadoNovedadSeguimientoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<NovedadSeguimiento> getNovedadSeguimientos(Connexion connexion,EstadoNovedadSeguimiento estadonovedadseguimiento)throws SQLException,Exception {

		List<NovedadSeguimiento> novedadseguimientos= new ArrayList<NovedadSeguimiento>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+".estado_novedad_seguimiento ON "+NovedadSeguimientoConstantesFunciones.SCHEMA+".novedad_seguimiento.id_estado_novedad_seguimiento="+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+".estado_novedad_seguimiento.id WHERE "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+".estado_novedad_seguimiento.id="+String.valueOf(estadonovedadseguimiento.getId());
			} else {
				sQuery=" INNER JOIN novedadseguimiento.EstadoNovedadSeguimiento WHERE novedadseguimiento.EstadoNovedadSeguimiento.id="+String.valueOf(estadonovedadseguimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NovedadSeguimientoDataAccess novedadseguimientoDataAccess=new NovedadSeguimientoDataAccess();

			novedadseguimientoDataAccess.setConnexionType(this.connexionType);
			novedadseguimientoDataAccess.setParameterDbType(this.parameterDbType);
			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadseguimientos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoNovedadSeguimiento estadonovedadseguimiento) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadonovedadseguimiento.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadonovedadseguimiento.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadonovedadseguimiento.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadonovedadseguimiento.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadonovedadseguimiento.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadonovedadseguimiento.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadonovedadseguimiento.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadonovedadseguimiento.getId());
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
	
	public void setIsNewIsChangedFalseEstadoNovedadSeguimiento(EstadoNovedadSeguimiento estadonovedadseguimiento)throws Exception  {		
		estadonovedadseguimiento.setIsNew(false);
		estadonovedadseguimiento.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoNovedadSeguimientos(List<EstadoNovedadSeguimiento> estadonovedadseguimientos)throws Exception  {				
		for(EstadoNovedadSeguimiento estadonovedadseguimiento:estadonovedadseguimientos) {
			estadonovedadseguimiento.setIsNew(false);
			estadonovedadseguimiento.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoNovedadSeguimiento(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
