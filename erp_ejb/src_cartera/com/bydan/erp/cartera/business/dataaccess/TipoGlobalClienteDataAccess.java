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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//TipoGlobalClienteConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class TipoGlobalClienteDataAccess extends  DataAccessHelperSinIdGenerated<TipoGlobalCliente>{ //TipoGlobalClienteDataAccessAdditional,DataAccessHelper<TipoGlobalCliente>
	//static Logger logger = Logger.getLogger(TipoGlobalClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_global_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoglobalcliente from "+TipoGlobalClienteConstantesFunciones.SPERSISTENCENAME+" tipoglobalcliente";
	public static String QUERYSELECTNATIVE="select "+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+".id,"+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+".version_row,"+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+".codigo,"+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+".nombre from "+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME;//+" as "+TipoGlobalClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+".id,"+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+".version_row,"+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+".codigo from "+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME;//+" as "+TipoGlobalClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoGlobalClienteConstantesFunciones.SCHEMA+"."+TipoGlobalClienteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOGLOBALCLIENTE_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOGLOBALCLIENTE_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOGLOBALCLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOGLOBALCLIENTE_SELECT(?,?)";
	
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
	
	
	public TipoGlobalClienteDataAccess() {
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
		TipoGlobalClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoGlobalClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoGlobalClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoGlobalClienteOriginal(TipoGlobalCliente tipoglobalcliente)throws Exception  {
		tipoglobalcliente.setTipoGlobalClienteOriginal((TipoGlobalCliente)tipoglobalcliente.clone());		
	}
	
	public void setTipoGlobalClientesOriginal(List<TipoGlobalCliente> tipoglobalclientes)throws Exception  {
		
		for(TipoGlobalCliente tipoglobalcliente:tipoglobalclientes){
			tipoglobalcliente.setTipoGlobalClienteOriginal((TipoGlobalCliente)tipoglobalcliente.clone());
		}
	}
	
	public static void setTipoGlobalClienteOriginalStatic(TipoGlobalCliente tipoglobalcliente)throws Exception  {
		tipoglobalcliente.setTipoGlobalClienteOriginal((TipoGlobalCliente)tipoglobalcliente.clone());		
	}
	
	public static void setTipoGlobalClientesOriginalStatic(List<TipoGlobalCliente> tipoglobalclientes)throws Exception  {
		
		for(TipoGlobalCliente tipoglobalcliente:tipoglobalclientes){
			tipoglobalcliente.setTipoGlobalClienteOriginal((TipoGlobalCliente)tipoglobalcliente.clone());
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
	
	public  TipoGlobalCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGlobalCliente entity = new TipoGlobalCliente();		
		
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
	
	public  TipoGlobalCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGlobalCliente entity = new TipoGlobalCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.TipoGlobalCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoGlobalClienteOriginal(new TipoGlobalCliente());
      	    	entity=super.getEntity("",entity,resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGlobalCliente("",entity,resultSet); 
				
				//entity.setTipoGlobalClienteOriginal(super.getEntity("",entity.getTipoGlobalClienteOriginal(),resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGlobalClienteOriginal(this.getEntityTipoGlobalCliente("",entity.getTipoGlobalClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGlobalCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoGlobalCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGlobalCliente entity = new TipoGlobalCliente();
				
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
	
	public  TipoGlobalCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGlobalCliente entity = new TipoGlobalCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGlobalClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoGlobalCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoGlobalClienteOriginal(new TipoGlobalCliente());
      	    	entity=super.getEntity("",entity,resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGlobalCliente("",entity,resultSet);    
				
				//entity.setTipoGlobalClienteOriginal(super.getEntity("",entity.getTipoGlobalClienteOriginal(),resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGlobalClienteOriginal(this.getEntityTipoGlobalCliente("",entity.getTipoGlobalClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGlobalCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoGlobalCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoGlobalCliente entity = new TipoGlobalCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGlobalClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoGlobalCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoGlobalCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoGlobalCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGlobalCliente> entities = new  ArrayList<TipoGlobalCliente>();
		TipoGlobalCliente entity = new TipoGlobalCliente();		  
		
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
	
	public  List<TipoGlobalCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGlobalCliente> entities = new  ArrayList<TipoGlobalCliente>();
		TipoGlobalCliente entity = new TipoGlobalCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGlobalClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGlobalCliente();
      	    	entity=super.getEntity("",entity,resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGlobalCliente("",entity,resultSet);
      	    	
				//entity.setTipoGlobalClienteOriginal( new TipoGlobalCliente());
      	    	//entity.setTipoGlobalClienteOriginal(super.getEntity("",entity.getTipoGlobalClienteOriginal(),resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGlobalClienteOriginal(this.getEntityTipoGlobalCliente("",entity.getTipoGlobalClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGlobalClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGlobalCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoGlobalCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGlobalCliente> entities = new  ArrayList<TipoGlobalCliente>();
		TipoGlobalCliente entity = new TipoGlobalCliente();		  
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
	
	public  List<TipoGlobalCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGlobalCliente> entities = new  ArrayList<TipoGlobalCliente>();
		TipoGlobalCliente entity = new TipoGlobalCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGlobalCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGlobalCliente();
					//entity.setMapTipoGlobalCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoGlobalClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGlobalCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA);         		
					entity=TipoGlobalClienteDataAccess.getEntityTipoGlobalCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGlobalClienteOriginal( new TipoGlobalCliente());
					////entity.setTipoGlobalClienteOriginal(super.getEntity("",entity.getTipoGlobalClienteOriginal(),resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGlobalClienteOriginal(this.getEntityTipoGlobalCliente("",entity.getTipoGlobalClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGlobalClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGlobalCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoGlobalCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGlobalCliente entity = new TipoGlobalCliente();		  
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
	
	public  TipoGlobalCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGlobalCliente entity = new TipoGlobalCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGlobalCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGlobalCliente();
					//entity.setMapTipoGlobalCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoGlobalClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGlobalCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA);         		
					entity=TipoGlobalClienteDataAccess.getEntityTipoGlobalCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGlobalClienteOriginal( new TipoGlobalCliente());
					////entity.setTipoGlobalClienteOriginal(super.getEntity("",entity.getTipoGlobalClienteOriginal(),resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGlobalClienteOriginal(this.getEntityTipoGlobalCliente("",entity.getTipoGlobalClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoGlobalCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGlobalCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoGlobalCliente getEntityTipoGlobalCliente(String strPrefijo,TipoGlobalCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoGlobalCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoGlobalCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoGlobalClienteDataAccess.setFieldReflectionTipoGlobalCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoGlobalCliente=TipoGlobalClienteConstantesFunciones.getTodosTiposColumnasTipoGlobalCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoGlobalCliente) {
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
							field = TipoGlobalCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoGlobalCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoGlobalClienteDataAccess.setFieldReflectionTipoGlobalCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoGlobalCliente(Field field,String strPrefijo,String sColumn,TipoGlobalCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoGlobalClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGlobalClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGlobalClienteConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGlobalClienteConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGlobalCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoGlobalCliente> entities = new  ArrayList<TipoGlobalCliente>();
		TipoGlobalCliente entity = new TipoGlobalCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGlobalClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoGlobalCliente();
					entity=super.getEntity("",entity,resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoGlobalCliente("",entity,resultSet);
					
					//entity.setTipoGlobalClienteOriginal( new TipoGlobalCliente());
					//entity.setTipoGlobalClienteOriginal(super.getEntity("",entity.getTipoGlobalClienteOriginal(),resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoGlobalClienteOriginal(this.getEntityTipoGlobalCliente("",entity.getTipoGlobalClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoGlobalClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGlobalCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGlobalCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoGlobalCliente> entities = new  ArrayList<TipoGlobalCliente>();
		TipoGlobalCliente entity = new TipoGlobalCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGlobalClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGlobalClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoGlobalCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGlobalCliente> entities = new  ArrayList<TipoGlobalCliente>();
		TipoGlobalCliente entity = new TipoGlobalCliente();		  
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
	
	public  List<TipoGlobalCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGlobalCliente> entities = new  ArrayList<TipoGlobalCliente>();
		TipoGlobalCliente entity = new TipoGlobalCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGlobalCliente();
      	    	entity=super.getEntity("",entity,resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGlobalCliente("",entity,resultSet);
      	    	
				//entity.setTipoGlobalClienteOriginal( new TipoGlobalCliente());
      	    	//entity.setTipoGlobalClienteOriginal(super.getEntity("",entity.getTipoGlobalClienteOriginal(),resultSet,TipoGlobalClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGlobalClienteOriginal(this.getEntityTipoGlobalCliente("",entity.getTipoGlobalClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoGlobalClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGlobalCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoGlobalCliente getEntityTipoGlobalCliente(String strPrefijo,TipoGlobalCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoGlobalClienteConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoGlobalClienteConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoGlobalClienteConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoGlobalCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoGlobalCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoGlobalClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoGlobalClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoGlobalClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoGlobalClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoGlobalClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoGlobalClienteDataAccess.TABLENAME,TipoGlobalClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoGlobalClienteDataAccess.setTipoGlobalClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<Definicion> getDefinicions(Connexion connexion,TipoGlobalCliente tipoglobalcliente)throws SQLException,Exception {

		List<Definicion> definicions= new ArrayList<Definicion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoGlobalClienteConstantesFunciones.SCHEMA+".tipo_global_cliente ON "+DefinicionConstantesFunciones.SCHEMA+".definicion.id_tipo_global_cliente="+TipoGlobalClienteConstantesFunciones.SCHEMA+".tipo_global_cliente.id WHERE "+TipoGlobalClienteConstantesFunciones.SCHEMA+".tipo_global_cliente.id="+String.valueOf(tipoglobalcliente.getId());
			} else {
				sQuery=" INNER JOIN definicion.TipoGlobalCliente WHERE definicion.TipoGlobalCliente.id="+String.valueOf(tipoglobalcliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DefinicionDataAccess definicionDataAccess=new DefinicionDataAccess();

			definicionDataAccess.setConnexionType(this.connexionType);
			definicionDataAccess.setParameterDbType(this.parameterDbType);
			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return definicions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoGlobalCliente tipoglobalcliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoglobalcliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoglobalcliente.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipoglobalcliente.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoglobalcliente.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoglobalcliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoglobalcliente.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoglobalcliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoglobalcliente.getId());
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
	
	public void setIsNewIsChangedFalseTipoGlobalCliente(TipoGlobalCliente tipoglobalcliente)throws Exception  {		
		tipoglobalcliente.setIsNew(false);
		tipoglobalcliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoGlobalClientes(List<TipoGlobalCliente> tipoglobalclientes)throws Exception  {				
		for(TipoGlobalCliente tipoglobalcliente:tipoglobalclientes) {
			tipoglobalcliente.setIsNew(false);
			tipoglobalcliente.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoGlobalCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
