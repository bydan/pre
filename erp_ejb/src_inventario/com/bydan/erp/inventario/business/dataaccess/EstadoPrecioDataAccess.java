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
import com.bydan.erp.inventario.util.*;//EstadoPrecioConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoPrecioDataAccess extends  EstadoPrecioDataAccessAdditional{ //EstadoPrecioDataAccessAdditional,DataAccessHelper<EstadoPrecio>
	//static Logger logger = Logger.getLogger(EstadoPrecioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_precio";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadoprecio from "+EstadoPrecioConstantesFunciones.SPERSISTENCENAME+" estadoprecio";
	public static String QUERYSELECTNATIVE="select "+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+".id,"+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+".version_row,"+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+".codigo,"+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+".nombre from "+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME;//+" as "+EstadoPrecioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+".id,"+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+".version_row,"+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+".codigo from "+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME;//+" as "+EstadoPrecioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoPrecioConstantesFunciones.SCHEMA+"."+EstadoPrecioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOPRECIO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOPRECIO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOPRECIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOPRECIO_SELECT(?,?)";
	
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
	
	
	protected EstadoPrecioDataAccessAdditional estadoprecioDataAccessAdditional=null;
	
	public EstadoPrecioDataAccessAdditional getEstadoPrecioDataAccessAdditional() {
		return this.estadoprecioDataAccessAdditional;
	}
	
	public void setEstadoPrecioDataAccessAdditional(EstadoPrecioDataAccessAdditional estadoprecioDataAccessAdditional) {
		try {
			this.estadoprecioDataAccessAdditional=estadoprecioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoPrecioDataAccess() {
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
		EstadoPrecioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoPrecioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoPrecioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoPrecioOriginal(EstadoPrecio estadoprecio)throws Exception  {
		estadoprecio.setEstadoPrecioOriginal((EstadoPrecio)estadoprecio.clone());		
	}
	
	public void setEstadoPreciosOriginal(List<EstadoPrecio> estadoprecios)throws Exception  {
		
		for(EstadoPrecio estadoprecio:estadoprecios){
			estadoprecio.setEstadoPrecioOriginal((EstadoPrecio)estadoprecio.clone());
		}
	}
	
	public static void setEstadoPrecioOriginalStatic(EstadoPrecio estadoprecio)throws Exception  {
		estadoprecio.setEstadoPrecioOriginal((EstadoPrecio)estadoprecio.clone());		
	}
	
	public static void setEstadoPreciosOriginalStatic(List<EstadoPrecio> estadoprecios)throws Exception  {
		
		for(EstadoPrecio estadoprecio:estadoprecios){
			estadoprecio.setEstadoPrecioOriginal((EstadoPrecio)estadoprecio.clone());
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
	
	public  EstadoPrecio getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoPrecio entity = new EstadoPrecio();		
		
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
	
	public  EstadoPrecio getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoPrecio entity = new EstadoPrecio();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.EstadoPrecio.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoPrecioOriginal(new EstadoPrecio());
      	    	entity=super.getEntity("",entity,resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoPrecio("",entity,resultSet); 
				
				//entity.setEstadoPrecioOriginal(super.getEntity("",entity.getEstadoPrecioOriginal(),resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPrecioOriginal(this.getEntityEstadoPrecio("",entity.getEstadoPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoPrecio(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoPrecio getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoPrecio entity = new EstadoPrecio();
				
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
	
	public  EstadoPrecio getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoPrecio entity = new EstadoPrecio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoPrecio.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoPrecioOriginal(new EstadoPrecio());
      	    	entity=super.getEntity("",entity,resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoPrecio("",entity,resultSet);    
				
				//entity.setEstadoPrecioOriginal(super.getEntity("",entity.getEstadoPrecioOriginal(),resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPrecioOriginal(this.getEntityEstadoPrecio("",entity.getEstadoPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoPrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoPrecio
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoPrecio entity = new EstadoPrecio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoPrecio.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoPrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoPrecio> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoPrecio> entities = new  ArrayList<EstadoPrecio>();
		EstadoPrecio entity = new EstadoPrecio();		  
		
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
	
	public  List<EstadoPrecio> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoPrecio> entities = new  ArrayList<EstadoPrecio>();
		EstadoPrecio entity = new EstadoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoPrecio("",entity,resultSet);
      	    	
				//entity.setEstadoPrecioOriginal( new EstadoPrecio());
      	    	//entity.setEstadoPrecioOriginal(super.getEntity("",entity.getEstadoPrecioOriginal(),resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPrecioOriginal(this.getEntityEstadoPrecio("",entity.getEstadoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoPrecios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoPrecio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoPrecio> entities = new  ArrayList<EstadoPrecio>();
		EstadoPrecio entity = new EstadoPrecio();		  
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
	
	public  List<EstadoPrecio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoPrecio> entities = new  ArrayList<EstadoPrecio>();
		EstadoPrecio entity = new EstadoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPrecio();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoPrecio();
					//entity.setMapEstadoPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=EstadoPrecioDataAccess.getEntityEstadoPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoPrecioOriginal( new EstadoPrecio());
					////entity.setEstadoPrecioOriginal(super.getEntity("",entity.getEstadoPrecioOriginal(),resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoPrecioOriginal(this.getEntityEstadoPrecio("",entity.getEstadoPrecioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoPrecios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoPrecio getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoPrecio entity = new EstadoPrecio();		  
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
	
	public  EstadoPrecio getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoPrecio entity = new EstadoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPrecio();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoPrecio();
					//entity.setMapEstadoPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=EstadoPrecioDataAccess.getEntityEstadoPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoPrecioOriginal( new EstadoPrecio());
					////entity.setEstadoPrecioOriginal(super.getEntity("",entity.getEstadoPrecioOriginal(),resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoPrecioOriginal(this.getEntityEstadoPrecio("",entity.getEstadoPrecioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoPrecio(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoPrecio getEntityEstadoPrecio(String strPrefijo,EstadoPrecio entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoPrecio.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoPrecio.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoPrecioDataAccess.setFieldReflectionEstadoPrecio(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoPrecio=EstadoPrecioConstantesFunciones.getTodosTiposColumnasEstadoPrecio();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoPrecio) {
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
							field = EstadoPrecio.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoPrecio.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoPrecioDataAccess.setFieldReflectionEstadoPrecio(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoPrecio(Field field,String strPrefijo,String sColumn,EstadoPrecio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoPrecioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoPrecioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoPrecioConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoPrecioConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoPrecio>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoPrecio> entities = new  ArrayList<EstadoPrecio>();
		EstadoPrecio entity = new EstadoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoPrecio();
					entity=super.getEntity("",entity,resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoPrecio("",entity,resultSet);
					
					//entity.setEstadoPrecioOriginal( new EstadoPrecio());
					//entity.setEstadoPrecioOriginal(super.getEntity("",entity.getEstadoPrecioOriginal(),resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoPrecioOriginal(this.getEntityEstadoPrecio("",entity.getEstadoPrecioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoPrecios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoPrecio>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoPrecio> entities = new  ArrayList<EstadoPrecio>();
		EstadoPrecio entity = new EstadoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoPrecio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPrecio> entities = new  ArrayList<EstadoPrecio>();
		EstadoPrecio entity = new EstadoPrecio();		  
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
	
	public  List<EstadoPrecio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPrecio> entities = new  ArrayList<EstadoPrecio>();
		EstadoPrecio entity = new EstadoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoPrecio("",entity,resultSet);
      	    	
				//entity.setEstadoPrecioOriginal( new EstadoPrecio());
      	    	//entity.setEstadoPrecioOriginal(super.getEntity("",entity.getEstadoPrecioOriginal(),resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPrecioOriginal(this.getEntityEstadoPrecio("",entity.getEstadoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoPrecios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoPrecio> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPrecio> entities = new  ArrayList<EstadoPrecio>();
		EstadoPrecio entity = new EstadoPrecio();		  
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
	
	public  List<EstadoPrecio> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPrecio> entities = new  ArrayList<EstadoPrecio>();
		EstadoPrecio entity = new EstadoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoPrecio("",entity,resultSet);
      	    	
				//entity.setEstadoPrecioOriginal( new EstadoPrecio());
      	    	//entity.setEstadoPrecioOriginal(super.getEntity("",entity.getEstadoPrecioOriginal(),resultSet,EstadoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPrecioOriginal(this.getEntityEstadoPrecio("",entity.getEstadoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoPrecios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoPrecio getEntityEstadoPrecio(String strPrefijo,EstadoPrecio entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoPrecioConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoPrecioConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoPrecioConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoPrecio(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoPrecio entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoPrecioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoPrecioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoPrecioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoPrecioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoPrecioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoPrecioDataAccess.TABLENAME,EstadoPrecioDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoPrecioDataAccess.setEstadoPrecioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<Precio> getPrecios(Connexion connexion,EstadoPrecio estadoprecio)throws SQLException,Exception {

		List<Precio> precios= new ArrayList<Precio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoPrecioConstantesFunciones.SCHEMA+".estado_precio ON "+PrecioConstantesFunciones.SCHEMA+".precio.id_estado_precio="+EstadoPrecioConstantesFunciones.SCHEMA+".estado_precio.id WHERE "+EstadoPrecioConstantesFunciones.SCHEMA+".estado_precio.id="+String.valueOf(estadoprecio.getId());
			} else {
				sQuery=" INNER JOIN precio.EstadoPrecio WHERE precio.EstadoPrecio.id="+String.valueOf(estadoprecio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PrecioDataAccess precioDataAccess=new PrecioDataAccess();

			precioDataAccess.setConnexionType(this.connexionType);
			precioDataAccess.setParameterDbType(this.parameterDbType);
			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return precios;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoPrecio estadoprecio) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadoprecio.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadoprecio.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadoprecio.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadoprecio.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadoprecio.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadoprecio.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadoprecio.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadoprecio.getId());
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
	
	public void setIsNewIsChangedFalseEstadoPrecio(EstadoPrecio estadoprecio)throws Exception  {		
		estadoprecio.setIsNew(false);
		estadoprecio.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoPrecios(List<EstadoPrecio> estadoprecios)throws Exception  {				
		for(EstadoPrecio estadoprecio:estadoprecios) {
			estadoprecio.setIsNew(false);
			estadoprecio.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoPrecio(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
