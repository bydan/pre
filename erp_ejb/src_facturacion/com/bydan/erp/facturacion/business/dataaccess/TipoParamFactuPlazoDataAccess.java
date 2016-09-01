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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//TipoParamFactuPlazoConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoParamFactuPlazoDataAccess extends  TipoParamFactuPlazoDataAccessAdditional{ //TipoParamFactuPlazoDataAccessAdditional,DataAccessHelper<TipoParamFactuPlazo>
	//static Logger logger = Logger.getLogger(TipoParamFactuPlazoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_param_factu_plazo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoparamfactuplazo from "+TipoParamFactuPlazoConstantesFunciones.SPERSISTENCENAME+" tipoparamfactuplazo";
	public static String QUERYSELECTNATIVE="select "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+".id,"+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuPlazoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+".id,"+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuPlazoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+"."+TipoParamFactuPlazoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPARAMFACTUPLAZO_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPARAMFACTUPLAZO_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPARAMFACTUPLAZO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPARAMFACTUPLAZO_SELECT(?,?)";
	
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
	
	
	protected TipoParamFactuPlazoDataAccessAdditional tipoparamfactuplazoDataAccessAdditional=null;
	
	public TipoParamFactuPlazoDataAccessAdditional getTipoParamFactuPlazoDataAccessAdditional() {
		return this.tipoparamfactuplazoDataAccessAdditional;
	}
	
	public void setTipoParamFactuPlazoDataAccessAdditional(TipoParamFactuPlazoDataAccessAdditional tipoparamfactuplazoDataAccessAdditional) {
		try {
			this.tipoparamfactuplazoDataAccessAdditional=tipoparamfactuplazoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoParamFactuPlazoDataAccess() {
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
		TipoParamFactuPlazoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoParamFactuPlazoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoParamFactuPlazoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoParamFactuPlazoOriginal(TipoParamFactuPlazo tipoparamfactuplazo)throws Exception  {
		tipoparamfactuplazo.setTipoParamFactuPlazoOriginal((TipoParamFactuPlazo)tipoparamfactuplazo.clone());		
	}
	
	public void setTipoParamFactuPlazosOriginal(List<TipoParamFactuPlazo> tipoparamfactuplazos)throws Exception  {
		
		for(TipoParamFactuPlazo tipoparamfactuplazo:tipoparamfactuplazos){
			tipoparamfactuplazo.setTipoParamFactuPlazoOriginal((TipoParamFactuPlazo)tipoparamfactuplazo.clone());
		}
	}
	
	public static void setTipoParamFactuPlazoOriginalStatic(TipoParamFactuPlazo tipoparamfactuplazo)throws Exception  {
		tipoparamfactuplazo.setTipoParamFactuPlazoOriginal((TipoParamFactuPlazo)tipoparamfactuplazo.clone());		
	}
	
	public static void setTipoParamFactuPlazosOriginalStatic(List<TipoParamFactuPlazo> tipoparamfactuplazos)throws Exception  {
		
		for(TipoParamFactuPlazo tipoparamfactuplazo:tipoparamfactuplazos){
			tipoparamfactuplazo.setTipoParamFactuPlazoOriginal((TipoParamFactuPlazo)tipoparamfactuplazo.clone());
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
	
	public  TipoParamFactuPlazo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		
		
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
	
	public  TipoParamFactuPlazo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoParamFactuPlazo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoParamFactuPlazoOriginal(new TipoParamFactuPlazo());
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoParamFactuPlazo("",entity,resultSet); 
				
				//entity.setTipoParamFactuPlazoOriginal(super.getEntity("",entity.getTipoParamFactuPlazoOriginal(),resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuPlazoOriginal(this.getEntityTipoParamFactuPlazo("",entity.getTipoParamFactuPlazoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoParamFactuPlazo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoParamFactuPlazo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();
				
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
	
	public  TipoParamFactuPlazo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuPlazoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoParamFactuPlazo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoParamFactuPlazoOriginal(new TipoParamFactuPlazo());
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoParamFactuPlazo("",entity,resultSet);    
				
				//entity.setTipoParamFactuPlazoOriginal(super.getEntity("",entity.getTipoParamFactuPlazoOriginal(),resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuPlazoOriginal(this.getEntityTipoParamFactuPlazo("",entity.getTipoParamFactuPlazoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoParamFactuPlazo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoParamFactuPlazo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuPlazoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoParamFactuPlazo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoParamFactuPlazo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoParamFactuPlazo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoParamFactuPlazo> entities = new  ArrayList<TipoParamFactuPlazo>();
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
		
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
	
	public  List<TipoParamFactuPlazo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoParamFactuPlazo> entities = new  ArrayList<TipoParamFactuPlazo>();
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuPlazoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuPlazo();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuPlazo("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuPlazoOriginal( new TipoParamFactuPlazo());
      	    	//entity.setTipoParamFactuPlazoOriginal(super.getEntity("",entity.getTipoParamFactuPlazoOriginal(),resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuPlazoOriginal(this.getEntityTipoParamFactuPlazo("",entity.getTipoParamFactuPlazoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuPlazos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuPlazo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoParamFactuPlazo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoParamFactuPlazo> entities = new  ArrayList<TipoParamFactuPlazo>();
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
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
	
	public  List<TipoParamFactuPlazo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoParamFactuPlazo> entities = new  ArrayList<TipoParamFactuPlazo>();
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuPlazo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoParamFactuPlazo();
					//entity.setMapTipoParamFactuPlazo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoParamFactuPlazoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoParamFactuPlazo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA);         		
					entity=TipoParamFactuPlazoDataAccess.getEntityTipoParamFactuPlazo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoParamFactuPlazoOriginal( new TipoParamFactuPlazo());
					////entity.setTipoParamFactuPlazoOriginal(super.getEntity("",entity.getTipoParamFactuPlazoOriginal(),resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoParamFactuPlazoOriginal(this.getEntityTipoParamFactuPlazo("",entity.getTipoParamFactuPlazoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuPlazos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuPlazo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoParamFactuPlazo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
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
	
	public  TipoParamFactuPlazo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuPlazo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoParamFactuPlazo();
					//entity.setMapTipoParamFactuPlazo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoParamFactuPlazoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoParamFactuPlazo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA);         		
					entity=TipoParamFactuPlazoDataAccess.getEntityTipoParamFactuPlazo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoParamFactuPlazoOriginal( new TipoParamFactuPlazo());
					////entity.setTipoParamFactuPlazoOriginal(super.getEntity("",entity.getTipoParamFactuPlazoOriginal(),resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoParamFactuPlazoOriginal(this.getEntityTipoParamFactuPlazo("",entity.getTipoParamFactuPlazoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuPlazo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuPlazo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoParamFactuPlazo getEntityTipoParamFactuPlazo(String strPrefijo,TipoParamFactuPlazo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoParamFactuPlazo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoParamFactuPlazo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoParamFactuPlazoDataAccess.setFieldReflectionTipoParamFactuPlazo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoParamFactuPlazo=TipoParamFactuPlazoConstantesFunciones.getTodosTiposColumnasTipoParamFactuPlazo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoParamFactuPlazo) {
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
							field = TipoParamFactuPlazo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoParamFactuPlazo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoParamFactuPlazoDataAccess.setFieldReflectionTipoParamFactuPlazo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoParamFactuPlazo(Field field,String strPrefijo,String sColumn,TipoParamFactuPlazo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoParamFactuPlazoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoParamFactuPlazoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoParamFactuPlazoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoParamFactuPlazo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoParamFactuPlazo> entities = new  ArrayList<TipoParamFactuPlazo>();
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuPlazoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoParamFactuPlazo();
					entity=super.getEntity("",entity,resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoParamFactuPlazo("",entity,resultSet);
					
					//entity.setTipoParamFactuPlazoOriginal( new TipoParamFactuPlazo());
					//entity.setTipoParamFactuPlazoOriginal(super.getEntity("",entity.getTipoParamFactuPlazoOriginal(),resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoParamFactuPlazoOriginal(this.getEntityTipoParamFactuPlazo("",entity.getTipoParamFactuPlazoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoParamFactuPlazos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuPlazo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoParamFactuPlazo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoParamFactuPlazo> entities = new  ArrayList<TipoParamFactuPlazo>();
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuPlazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuPlazoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoParamFactuPlazo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuPlazo> entities = new  ArrayList<TipoParamFactuPlazo>();
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
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
	
	public  List<TipoParamFactuPlazo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuPlazo> entities = new  ArrayList<TipoParamFactuPlazo>();
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuPlazo();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuPlazo("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuPlazoOriginal( new TipoParamFactuPlazo());
      	    	//entity.setTipoParamFactuPlazoOriginal(super.getEntity("",entity.getTipoParamFactuPlazoOriginal(),resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuPlazoOriginal(this.getEntityTipoParamFactuPlazo("",entity.getTipoParamFactuPlazoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoParamFactuPlazos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuPlazo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoParamFactuPlazo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuPlazo> entities = new  ArrayList<TipoParamFactuPlazo>();
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
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
	
	public  List<TipoParamFactuPlazo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuPlazo> entities = new  ArrayList<TipoParamFactuPlazo>();
		TipoParamFactuPlazo entity = new TipoParamFactuPlazo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuPlazo();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuPlazo("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuPlazoOriginal( new TipoParamFactuPlazo());
      	    	//entity.setTipoParamFactuPlazoOriginal(super.getEntity("",entity.getTipoParamFactuPlazoOriginal(),resultSet,TipoParamFactuPlazoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuPlazoOriginal(this.getEntityTipoParamFactuPlazo("",entity.getTipoParamFactuPlazoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuPlazos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoParamFactuPlazo getEntityTipoParamFactuPlazo(String strPrefijo,TipoParamFactuPlazo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoParamFactuPlazoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoParamFactuPlazoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoParamFactuPlazo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoParamFactuPlazo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoParamFactuPlazoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoParamFactuPlazoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoParamFactuPlazoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoParamFactuPlazoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoParamFactuPlazoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoParamFactuPlazoDataAccess.TABLENAME,TipoParamFactuPlazoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoParamFactuPlazoDataAccess.setTipoParamFactuPlazoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<ParametroFactuSecuencial> getParametroFactuSecuencials(Connexion connexion,TipoParamFactuPlazo tipoparamfactuplazo)throws SQLException,Exception {

		List<ParametroFactuSecuencial> parametrofactusecuencials= new ArrayList<ParametroFactuSecuencial>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+".tipo_param_factu_plazo ON "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+".parametro_factu_secuencial.id_tipo_param_factu_plazo="+TipoParamFactuPlazoConstantesFunciones.SCHEMA+".tipo_param_factu_plazo.id WHERE "+TipoParamFactuPlazoConstantesFunciones.SCHEMA+".tipo_param_factu_plazo.id="+String.valueOf(tipoparamfactuplazo.getId());
			} else {
				sQuery=" INNER JOIN parametrofactusecuencial.TipoParamFactuPlazo WHERE parametrofactusecuencial.TipoParamFactuPlazo.id="+String.valueOf(tipoparamfactuplazo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFactuSecuencialDataAccess parametrofactusecuencialDataAccess=new ParametroFactuSecuencialDataAccess();

			parametrofactusecuencialDataAccess.setConnexionType(this.connexionType);
			parametrofactusecuencialDataAccess.setParameterDbType(this.parameterDbType);
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofactusecuencials;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoParamFactuPlazo tipoparamfactuplazo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoparamfactuplazo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoparamfactuplazo.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoparamfactuplazo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoparamfactuplazo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoparamfactuplazo.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoparamfactuplazo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoparamfactuplazo.getId());
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
	
	public void setIsNewIsChangedFalseTipoParamFactuPlazo(TipoParamFactuPlazo tipoparamfactuplazo)throws Exception  {		
		tipoparamfactuplazo.setIsNew(false);
		tipoparamfactuplazo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoParamFactuPlazos(List<TipoParamFactuPlazo> tipoparamfactuplazos)throws Exception  {				
		for(TipoParamFactuPlazo tipoparamfactuplazo:tipoparamfactuplazos) {
			tipoparamfactuplazo.setIsNew(false);
			tipoparamfactuplazo.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoParamFactuPlazo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
