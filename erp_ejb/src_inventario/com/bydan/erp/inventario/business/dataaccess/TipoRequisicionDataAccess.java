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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//TipoRequisicionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TipoRequisicionDataAccess extends  TipoRequisicionDataAccessAdditional{ //TipoRequisicionDataAccessAdditional,DataAccessHelper<TipoRequisicion>
	//static Logger logger = Logger.getLogger(TipoRequisicionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_requisicion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,id_tipo_periodo,id_dia,hora)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,id_tipo_periodo=?,id_dia=?,hora=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tiporequisicion from "+TipoRequisicionConstantesFunciones.SPERSISTENCENAME+" tiporequisicion";
	public static String QUERYSELECTNATIVE="select "+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".id,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".version_row,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".id_empresa,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".codigo,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".nombre,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".id_tipo_periodo,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".id_dia,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".hora from "+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME;//+" as "+TipoRequisicionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".id,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".version_row,"+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+".nombre from "+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME;//+" as "+TipoRequisicionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoRequisicionConstantesFunciones.SCHEMA+"."+TipoRequisicionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,id_tipo_periodo=?,id_dia=?,hora=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOREQUISICION_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOREQUISICION_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOREQUISICION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOREQUISICION_SELECT(?,?)";
	
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
	
	
	protected TipoRequisicionDataAccessAdditional tiporequisicionDataAccessAdditional=null;
	
	public TipoRequisicionDataAccessAdditional getTipoRequisicionDataAccessAdditional() {
		return this.tiporequisicionDataAccessAdditional;
	}
	
	public void setTipoRequisicionDataAccessAdditional(TipoRequisicionDataAccessAdditional tiporequisicionDataAccessAdditional) {
		try {
			this.tiporequisicionDataAccessAdditional=tiporequisicionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoRequisicionDataAccess() {
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
		TipoRequisicionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoRequisicionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoRequisicionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoRequisicionOriginal(TipoRequisicion tiporequisicion)throws Exception  {
		tiporequisicion.setTipoRequisicionOriginal((TipoRequisicion)tiporequisicion.clone());		
	}
	
	public void setTipoRequisicionsOriginal(List<TipoRequisicion> tiporequisicions)throws Exception  {
		
		for(TipoRequisicion tiporequisicion:tiporequisicions){
			tiporequisicion.setTipoRequisicionOriginal((TipoRequisicion)tiporequisicion.clone());
		}
	}
	
	public static void setTipoRequisicionOriginalStatic(TipoRequisicion tiporequisicion)throws Exception  {
		tiporequisicion.setTipoRequisicionOriginal((TipoRequisicion)tiporequisicion.clone());		
	}
	
	public static void setTipoRequisicionsOriginalStatic(List<TipoRequisicion> tiporequisicions)throws Exception  {
		
		for(TipoRequisicion tiporequisicion:tiporequisicions){
			tiporequisicion.setTipoRequisicionOriginal((TipoRequisicion)tiporequisicion.clone());
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
	
	public  TipoRequisicion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRequisicion entity = new TipoRequisicion();		
		
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
	
	public  TipoRequisicion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRequisicion entity = new TipoRequisicion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.TipoRequisicion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoRequisicionOriginal(new TipoRequisicion());
      	    	entity=super.getEntity("",entity,resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRequisicion("",entity,resultSet); 
				
				//entity.setTipoRequisicionOriginal(super.getEntity("",entity.getTipoRequisicionOriginal(),resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRequisicionOriginal(this.getEntityTipoRequisicion("",entity.getTipoRequisicionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRequisicion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoRequisicion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRequisicion entity = new TipoRequisicion();
				
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
	
	public  TipoRequisicion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRequisicion entity = new TipoRequisicion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoRequisicion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoRequisicionOriginal(new TipoRequisicion());
      	    	entity=super.getEntity("",entity,resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRequisicion("",entity,resultSet);    
				
				//entity.setTipoRequisicionOriginal(super.getEntity("",entity.getTipoRequisicionOriginal(),resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRequisicionOriginal(this.getEntityTipoRequisicion("",entity.getTipoRequisicionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRequisicion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoRequisicion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoRequisicion entity = new TipoRequisicion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoRequisicion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoRequisicion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoRequisicion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRequisicion> entities = new  ArrayList<TipoRequisicion>();
		TipoRequisicion entity = new TipoRequisicion();		  
		
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
	
	public  List<TipoRequisicion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRequisicion> entities = new  ArrayList<TipoRequisicion>();
		TipoRequisicion entity = new TipoRequisicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRequisicion();
      	    	entity=super.getEntity("",entity,resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRequisicion("",entity,resultSet);
      	    	
				//entity.setTipoRequisicionOriginal( new TipoRequisicion());
      	    	//entity.setTipoRequisicionOriginal(super.getEntity("",entity.getTipoRequisicionOriginal(),resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRequisicionOriginal(this.getEntityTipoRequisicion("",entity.getTipoRequisicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRequisicions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRequisicion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRequisicion> entities = new  ArrayList<TipoRequisicion>();
		TipoRequisicion entity = new TipoRequisicion();		  
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
	
	public  List<TipoRequisicion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRequisicion> entities = new  ArrayList<TipoRequisicion>();
		TipoRequisicion entity = new TipoRequisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRequisicion();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRequisicion();
					//entity.setMapTipoRequisicion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoRequisicionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRequisicion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA);         		
					entity=TipoRequisicionDataAccess.getEntityTipoRequisicion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRequisicionOriginal( new TipoRequisicion());
					////entity.setTipoRequisicionOriginal(super.getEntity("",entity.getTipoRequisicionOriginal(),resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRequisicionOriginal(this.getEntityTipoRequisicion("",entity.getTipoRequisicionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRequisicions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoRequisicion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRequisicion entity = new TipoRequisicion();		  
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
	
	public  TipoRequisicion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRequisicion entity = new TipoRequisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRequisicion();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRequisicion();
					//entity.setMapTipoRequisicion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoRequisicionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRequisicion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA);         		
					entity=TipoRequisicionDataAccess.getEntityTipoRequisicion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRequisicionOriginal( new TipoRequisicion());
					////entity.setTipoRequisicionOriginal(super.getEntity("",entity.getTipoRequisicionOriginal(),resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRequisicionOriginal(this.getEntityTipoRequisicion("",entity.getTipoRequisicionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoRequisicion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoRequisicion getEntityTipoRequisicion(String strPrefijo,TipoRequisicion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoRequisicion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoRequisicion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoRequisicionDataAccess.setFieldReflectionTipoRequisicion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoRequisicion=TipoRequisicionConstantesFunciones.getTodosTiposColumnasTipoRequisicion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoRequisicion) {
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
							field = TipoRequisicion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoRequisicion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoRequisicionDataAccess.setFieldReflectionTipoRequisicion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoRequisicion(Field field,String strPrefijo,String sColumn,TipoRequisicion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoRequisicionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRequisicionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRequisicionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRequisicionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRequisicionConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRequisicionConstantesFunciones.IDTIPOPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRequisicionConstantesFunciones.IDDIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRequisicionConstantesFunciones.HORA:
					field.set(entity,resultSet.getTime(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRequisicion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoRequisicion> entities = new  ArrayList<TipoRequisicion>();
		TipoRequisicion entity = new TipoRequisicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoRequisicion();
					entity=super.getEntity("",entity,resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoRequisicion("",entity,resultSet);
					
					//entity.setTipoRequisicionOriginal( new TipoRequisicion());
					//entity.setTipoRequisicionOriginal(super.getEntity("",entity.getTipoRequisicionOriginal(),resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoRequisicionOriginal(this.getEntityTipoRequisicion("",entity.getTipoRequisicionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoRequisicions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRequisicion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoRequisicion> entities = new  ArrayList<TipoRequisicion>();
		TipoRequisicion entity = new TipoRequisicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoRequisicion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRequisicion> entities = new  ArrayList<TipoRequisicion>();
		TipoRequisicion entity = new TipoRequisicion();		  
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
	
	public  List<TipoRequisicion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRequisicion> entities = new  ArrayList<TipoRequisicion>();
		TipoRequisicion entity = new TipoRequisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRequisicion();
      	    	entity=super.getEntity("",entity,resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRequisicion("",entity,resultSet);
      	    	
				//entity.setTipoRequisicionOriginal( new TipoRequisicion());
      	    	//entity.setTipoRequisicionOriginal(super.getEntity("",entity.getTipoRequisicionOriginal(),resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRequisicionOriginal(this.getEntityTipoRequisicion("",entity.getTipoRequisicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoRequisicions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRequisicion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRequisicion> entities = new  ArrayList<TipoRequisicion>();
		TipoRequisicion entity = new TipoRequisicion();		  
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
	
	public  List<TipoRequisicion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRequisicion> entities = new  ArrayList<TipoRequisicion>();
		TipoRequisicion entity = new TipoRequisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRequisicion();
      	    	entity=super.getEntity("",entity,resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRequisicion("",entity,resultSet);
      	    	
				//entity.setTipoRequisicionOriginal( new TipoRequisicion());
      	    	//entity.setTipoRequisicionOriginal(super.getEntity("",entity.getTipoRequisicionOriginal(),resultSet,TipoRequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRequisicionOriginal(this.getEntityTipoRequisicion("",entity.getTipoRequisicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRequisicions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoRequisicion getEntityTipoRequisicion(String strPrefijo,TipoRequisicion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoRequisicionConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoRequisicionConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoRequisicionConstantesFunciones.NOMBRE));
				entity.setid_tipo_periodo(resultSet.getLong(strPrefijo+TipoRequisicionConstantesFunciones.IDTIPOPERIODO));
				entity.setid_dia(resultSet.getLong(strPrefijo+TipoRequisicionConstantesFunciones.IDDIA));
				entity.sethora(resultSet.getTime(strPrefijo+TipoRequisicionConstantesFunciones.HORA));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoRequisicionConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoRequisicion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoRequisicion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoRequisicionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoRequisicionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoRequisicionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoRequisicionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoRequisicionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoRequisicionDataAccess.TABLENAME,TipoRequisicionDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoRequisicionDataAccess.setTipoRequisicionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoRequisicion reltiporequisicion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltiporequisicion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoPeriodo getTipoPeriodo(Connexion connexion,TipoRequisicion reltiporequisicion)throws SQLException,Exception {

		TipoPeriodo tipoperiodo= new TipoPeriodo();

		try {
			TipoPeriodoDataAccess tipoperiodoDataAccess=new TipoPeriodoDataAccess();

			tipoperiodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoperiodoDataAccess.setConnexionType(this.connexionType);
			tipoperiodoDataAccess.setParameterDbType(this.parameterDbType);

			tipoperiodo=tipoperiodoDataAccess.getEntity(connexion,reltiporequisicion.getid_tipo_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoperiodo;

	}

	public Dia getDia(Connexion connexion,TipoRequisicion reltiporequisicion)throws SQLException,Exception {

		Dia dia= new Dia();

		try {
			DiaDataAccess diaDataAccess=new DiaDataAccess();

			diaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			diaDataAccess.setConnexionType(this.connexionType);
			diaDataAccess.setParameterDbType(this.parameterDbType);

			dia=diaDataAccess.getEntity(connexion,reltiporequisicion.getid_dia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return dia;

	}


		
		public List<Requisicion> getRequisicions(Connexion connexion,TipoRequisicion tiporequisicion)throws SQLException,Exception {

		List<Requisicion> requisicions= new ArrayList<Requisicion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRequisicionConstantesFunciones.SCHEMA+".tipo_requisicion ON "+RequisicionConstantesFunciones.SCHEMA+".requisicion.id_tipo_requisicion="+TipoRequisicionConstantesFunciones.SCHEMA+".tipo_requisicion.id WHERE "+TipoRequisicionConstantesFunciones.SCHEMA+".tipo_requisicion.id="+String.valueOf(tiporequisicion.getId());
			} else {
				sQuery=" INNER JOIN requisicion.TipoRequisicion WHERE requisicion.TipoRequisicion.id="+String.valueOf(tiporequisicion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RequisicionDataAccess requisicionDataAccess=new RequisicionDataAccess();

			requisicionDataAccess.setConnexionType(this.connexionType);
			requisicionDataAccess.setParameterDbType(this.parameterDbType);
			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return requisicions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoRequisicion tiporequisicion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tiporequisicion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tiporequisicion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tiporequisicion.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tiporequisicion.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_periodo.setValue(tiporequisicion.getid_tipo_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_dia=new ParameterValue<Long>();
					parameterMaintenanceValueid_dia.setValue(tiporequisicion.getid_dia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_dia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora=new ParameterValue<Time>();
					parameterMaintenanceValuehora.setValue(tiporequisicion.gethora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora);
					parametersTemp.add(parameterMaintenance);
					
						if(!tiporequisicion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tiporequisicion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tiporequisicion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tiporequisicion.getId());
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
	
	public void setIsNewIsChangedFalseTipoRequisicion(TipoRequisicion tiporequisicion)throws Exception  {		
		tiporequisicion.setIsNew(false);
		tiporequisicion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoRequisicions(List<TipoRequisicion> tiporequisicions)throws Exception  {				
		for(TipoRequisicion tiporequisicion:tiporequisicions) {
			tiporequisicion.setIsNew(false);
			tiporequisicion.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoRequisicion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
