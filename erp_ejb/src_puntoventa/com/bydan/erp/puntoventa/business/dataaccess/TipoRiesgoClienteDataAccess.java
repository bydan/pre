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
package com.bydan.erp.puntoventa.business.dataaccess;

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

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//TipoRiesgoClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoRiesgoClienteDataAccess extends  TipoRiesgoClienteDataAccessAdditional{ //TipoRiesgoClienteDataAccessAdditional,DataAccessHelper<TipoRiesgoCliente>
	//static Logger logger = Logger.getLogger(TipoRiesgoClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_riesgo_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tiporiesgocliente from "+TipoRiesgoClienteConstantesFunciones.SPERSISTENCENAME+" tiporiesgocliente";
	public static String QUERYSELECTNATIVE="select "+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+".id,"+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+".version_row,"+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+".id_empresa,"+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+".nombre from "+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME;//+" as "+TipoRiesgoClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+".id,"+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+".version_row,"+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+".nombre from "+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME;//+" as "+TipoRiesgoClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoRiesgoClienteConstantesFunciones.SCHEMA+"."+TipoRiesgoClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPORIESGOCLIENTE_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPORIESGOCLIENTE_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPORIESGOCLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPORIESGOCLIENTE_SELECT(?,?)";
	
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
	
	
	protected TipoRiesgoClienteDataAccessAdditional tiporiesgoclienteDataAccessAdditional=null;
	
	public TipoRiesgoClienteDataAccessAdditional getTipoRiesgoClienteDataAccessAdditional() {
		return this.tiporiesgoclienteDataAccessAdditional;
	}
	
	public void setTipoRiesgoClienteDataAccessAdditional(TipoRiesgoClienteDataAccessAdditional tiporiesgoclienteDataAccessAdditional) {
		try {
			this.tiporiesgoclienteDataAccessAdditional=tiporiesgoclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoRiesgoClienteDataAccess() {
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
		TipoRiesgoClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoRiesgoClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoRiesgoClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoRiesgoClienteOriginal(TipoRiesgoCliente tiporiesgocliente)throws Exception  {
		tiporiesgocliente.setTipoRiesgoClienteOriginal((TipoRiesgoCliente)tiporiesgocliente.clone());		
	}
	
	public void setTipoRiesgoClientesOriginal(List<TipoRiesgoCliente> tiporiesgoclientes)throws Exception  {
		
		for(TipoRiesgoCliente tiporiesgocliente:tiporiesgoclientes){
			tiporiesgocliente.setTipoRiesgoClienteOriginal((TipoRiesgoCliente)tiporiesgocliente.clone());
		}
	}
	
	public static void setTipoRiesgoClienteOriginalStatic(TipoRiesgoCliente tiporiesgocliente)throws Exception  {
		tiporiesgocliente.setTipoRiesgoClienteOriginal((TipoRiesgoCliente)tiporiesgocliente.clone());		
	}
	
	public static void setTipoRiesgoClientesOriginalStatic(List<TipoRiesgoCliente> tiporiesgoclientes)throws Exception  {
		
		for(TipoRiesgoCliente tiporiesgocliente:tiporiesgoclientes){
			tiporiesgocliente.setTipoRiesgoClienteOriginal((TipoRiesgoCliente)tiporiesgocliente.clone());
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
	
	public  TipoRiesgoCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		
		
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
	
	public  TipoRiesgoCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.TipoRiesgoCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoRiesgoClienteOriginal(new TipoRiesgoCliente());
      	    	entity=super.getEntity("",entity,resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRiesgoCliente("",entity,resultSet); 
				
				//entity.setTipoRiesgoClienteOriginal(super.getEntity("",entity.getTipoRiesgoClienteOriginal(),resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRiesgoClienteOriginal(this.getEntityTipoRiesgoCliente("",entity.getTipoRiesgoClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRiesgoCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoRiesgoCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRiesgoCliente entity = new TipoRiesgoCliente();
				
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
	
	public  TipoRiesgoCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRiesgoCliente entity = new TipoRiesgoCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRiesgoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TipoRiesgoCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoRiesgoClienteOriginal(new TipoRiesgoCliente());
      	    	entity=super.getEntity("",entity,resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRiesgoCliente("",entity,resultSet);    
				
				//entity.setTipoRiesgoClienteOriginal(super.getEntity("",entity.getTipoRiesgoClienteOriginal(),resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRiesgoClienteOriginal(this.getEntityTipoRiesgoCliente("",entity.getTipoRiesgoClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRiesgoCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoRiesgoCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoRiesgoCliente entity = new TipoRiesgoCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRiesgoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TipoRiesgoCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoRiesgoCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoRiesgoCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRiesgoCliente> entities = new  ArrayList<TipoRiesgoCliente>();
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
		
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
	
	public  List<TipoRiesgoCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRiesgoCliente> entities = new  ArrayList<TipoRiesgoCliente>();
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRiesgoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRiesgoCliente();
      	    	entity=super.getEntity("",entity,resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRiesgoCliente("",entity,resultSet);
      	    	
				//entity.setTipoRiesgoClienteOriginal( new TipoRiesgoCliente());
      	    	//entity.setTipoRiesgoClienteOriginal(super.getEntity("",entity.getTipoRiesgoClienteOriginal(),resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRiesgoClienteOriginal(this.getEntityTipoRiesgoCliente("",entity.getTipoRiesgoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRiesgoClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRiesgoCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRiesgoCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRiesgoCliente> entities = new  ArrayList<TipoRiesgoCliente>();
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
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
	
	public  List<TipoRiesgoCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRiesgoCliente> entities = new  ArrayList<TipoRiesgoCliente>();
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRiesgoCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRiesgoCliente();
					//entity.setMapTipoRiesgoCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoRiesgoClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRiesgoCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA);         		
					entity=TipoRiesgoClienteDataAccess.getEntityTipoRiesgoCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRiesgoClienteOriginal( new TipoRiesgoCliente());
					////entity.setTipoRiesgoClienteOriginal(super.getEntity("",entity.getTipoRiesgoClienteOriginal(),resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRiesgoClienteOriginal(this.getEntityTipoRiesgoCliente("",entity.getTipoRiesgoClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRiesgoClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRiesgoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoRiesgoCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
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
	
	public  TipoRiesgoCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRiesgoCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRiesgoCliente();
					//entity.setMapTipoRiesgoCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoRiesgoClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRiesgoCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA);         		
					entity=TipoRiesgoClienteDataAccess.getEntityTipoRiesgoCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRiesgoClienteOriginal( new TipoRiesgoCliente());
					////entity.setTipoRiesgoClienteOriginal(super.getEntity("",entity.getTipoRiesgoClienteOriginal(),resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRiesgoClienteOriginal(this.getEntityTipoRiesgoCliente("",entity.getTipoRiesgoClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoRiesgoCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRiesgoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoRiesgoCliente getEntityTipoRiesgoCliente(String strPrefijo,TipoRiesgoCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoRiesgoCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoRiesgoCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoRiesgoClienteDataAccess.setFieldReflectionTipoRiesgoCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoRiesgoCliente=TipoRiesgoClienteConstantesFunciones.getTodosTiposColumnasTipoRiesgoCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoRiesgoCliente) {
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
							field = TipoRiesgoCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoRiesgoCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoRiesgoClienteDataAccess.setFieldReflectionTipoRiesgoCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoRiesgoCliente(Field field,String strPrefijo,String sColumn,TipoRiesgoCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoRiesgoClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRiesgoClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRiesgoClienteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRiesgoClienteConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRiesgoCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoRiesgoCliente> entities = new  ArrayList<TipoRiesgoCliente>();
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRiesgoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoRiesgoCliente();
					entity=super.getEntity("",entity,resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoRiesgoCliente("",entity,resultSet);
					
					//entity.setTipoRiesgoClienteOriginal( new TipoRiesgoCliente());
					//entity.setTipoRiesgoClienteOriginal(super.getEntity("",entity.getTipoRiesgoClienteOriginal(),resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoRiesgoClienteOriginal(this.getEntityTipoRiesgoCliente("",entity.getTipoRiesgoClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoRiesgoClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRiesgoCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRiesgoCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoRiesgoCliente> entities = new  ArrayList<TipoRiesgoCliente>();
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRiesgoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRiesgoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoRiesgoCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRiesgoCliente> entities = new  ArrayList<TipoRiesgoCliente>();
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
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
	
	public  List<TipoRiesgoCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRiesgoCliente> entities = new  ArrayList<TipoRiesgoCliente>();
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRiesgoCliente();
      	    	entity=super.getEntity("",entity,resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRiesgoCliente("",entity,resultSet);
      	    	
				//entity.setTipoRiesgoClienteOriginal( new TipoRiesgoCliente());
      	    	//entity.setTipoRiesgoClienteOriginal(super.getEntity("",entity.getTipoRiesgoClienteOriginal(),resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRiesgoClienteOriginal(this.getEntityTipoRiesgoCliente("",entity.getTipoRiesgoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoRiesgoClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRiesgoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRiesgoCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRiesgoCliente> entities = new  ArrayList<TipoRiesgoCliente>();
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
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
	
	public  List<TipoRiesgoCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRiesgoCliente> entities = new  ArrayList<TipoRiesgoCliente>();
		TipoRiesgoCliente entity = new TipoRiesgoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRiesgoCliente();
      	    	entity=super.getEntity("",entity,resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRiesgoCliente("",entity,resultSet);
      	    	
				//entity.setTipoRiesgoClienteOriginal( new TipoRiesgoCliente());
      	    	//entity.setTipoRiesgoClienteOriginal(super.getEntity("",entity.getTipoRiesgoClienteOriginal(),resultSet,TipoRiesgoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRiesgoClienteOriginal(this.getEntityTipoRiesgoCliente("",entity.getTipoRiesgoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRiesgoClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoRiesgoCliente getEntityTipoRiesgoCliente(String strPrefijo,TipoRiesgoCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoRiesgoClienteConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+TipoRiesgoClienteConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoRiesgoClienteConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoRiesgoCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoRiesgoCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoRiesgoClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoRiesgoClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoRiesgoClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoRiesgoClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoRiesgoClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoRiesgoClienteDataAccess.TABLENAME,TipoRiesgoClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoRiesgoClienteDataAccess.setTipoRiesgoClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoRiesgoCliente reltiporiesgocliente)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltiporiesgocliente.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoRiesgoCliente tiporiesgocliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tiporiesgocliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tiporiesgocliente.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tiporiesgocliente.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tiporiesgocliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tiporiesgocliente.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tiporiesgocliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tiporiesgocliente.getId());
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
	
	public void setIsNewIsChangedFalseTipoRiesgoCliente(TipoRiesgoCliente tiporiesgocliente)throws Exception  {		
		tiporiesgocliente.setIsNew(false);
		tiporiesgocliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoRiesgoClientes(List<TipoRiesgoCliente> tiporiesgoclientes)throws Exception  {				
		for(TipoRiesgoCliente tiporiesgocliente:tiporiesgoclientes) {
			tiporiesgocliente.setIsNew(false);
			tiporiesgocliente.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoRiesgoCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
