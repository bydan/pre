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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//TipoInteresTarjetaConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoInteresTarjetaDataAccess extends  DataAccessHelperSinIdGenerated<TipoInteresTarjeta>{ //TipoInteresTarjetaDataAccessAdditional,DataAccessHelper<TipoInteresTarjeta>
	//static Logger logger = Logger.getLogger(TipoInteresTarjetaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_interes_tarjeta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+"(id,version_row,nombre,descripcion)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipointerestarjeta from "+TipoInteresTarjetaConstantesFunciones.SPERSISTENCENAME+" tipointerestarjeta";
	public static String QUERYSELECTNATIVE="select "+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+".id,"+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+".version_row,"+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+".nombre,"+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+".descripcion from "+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME;//+" as "+TipoInteresTarjetaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+".id,"+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+".version_row,"+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+".nombre from "+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME;//+" as "+TipoInteresTarjetaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoInteresTarjetaConstantesFunciones.SCHEMA+"."+TipoInteresTarjetaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOINTERESTARJETA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOINTERESTARJETA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOINTERESTARJETA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOINTERESTARJETA_SELECT(?,?)";
	
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
	
	
	public TipoInteresTarjetaDataAccess() {
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
		TipoInteresTarjetaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoInteresTarjetaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoInteresTarjetaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoInteresTarjetaOriginal(TipoInteresTarjeta tipointerestarjeta)throws Exception  {
		tipointerestarjeta.setTipoInteresTarjetaOriginal((TipoInteresTarjeta)tipointerestarjeta.clone());		
	}
	
	public void setTipoInteresTarjetasOriginal(List<TipoInteresTarjeta> tipointerestarjetas)throws Exception  {
		
		for(TipoInteresTarjeta tipointerestarjeta:tipointerestarjetas){
			tipointerestarjeta.setTipoInteresTarjetaOriginal((TipoInteresTarjeta)tipointerestarjeta.clone());
		}
	}
	
	public static void setTipoInteresTarjetaOriginalStatic(TipoInteresTarjeta tipointerestarjeta)throws Exception  {
		tipointerestarjeta.setTipoInteresTarjetaOriginal((TipoInteresTarjeta)tipointerestarjeta.clone());		
	}
	
	public static void setTipoInteresTarjetasOriginalStatic(List<TipoInteresTarjeta> tipointerestarjetas)throws Exception  {
		
		for(TipoInteresTarjeta tipointerestarjeta:tipointerestarjetas){
			tipointerestarjeta.setTipoInteresTarjetaOriginal((TipoInteresTarjeta)tipointerestarjeta.clone());
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
	
	public  TipoInteresTarjeta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		
		
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
	
	public  TipoInteresTarjeta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.TipoInteresTarjeta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoInteresTarjetaOriginal(new TipoInteresTarjeta());
      	    	entity=super.getEntity("",entity,resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoInteresTarjeta("",entity,resultSet); 
				
				//entity.setTipoInteresTarjetaOriginal(super.getEntity("",entity.getTipoInteresTarjetaOriginal(),resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoInteresTarjetaOriginal(this.getEntityTipoInteresTarjeta("",entity.getTipoInteresTarjetaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoInteresTarjeta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoInteresTarjeta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoInteresTarjeta entity = new TipoInteresTarjeta();
				
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
	
	public  TipoInteresTarjeta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoInteresTarjeta entity = new TipoInteresTarjeta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoInteresTarjetaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TipoInteresTarjeta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoInteresTarjetaOriginal(new TipoInteresTarjeta());
      	    	entity=super.getEntity("",entity,resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoInteresTarjeta("",entity,resultSet);    
				
				//entity.setTipoInteresTarjetaOriginal(super.getEntity("",entity.getTipoInteresTarjetaOriginal(),resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoInteresTarjetaOriginal(this.getEntityTipoInteresTarjeta("",entity.getTipoInteresTarjetaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoInteresTarjeta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoInteresTarjeta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoInteresTarjeta entity = new TipoInteresTarjeta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoInteresTarjetaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TipoInteresTarjeta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoInteresTarjeta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoInteresTarjeta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoInteresTarjeta> entities = new  ArrayList<TipoInteresTarjeta>();
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		  
		
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
	
	public  List<TipoInteresTarjeta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoInteresTarjeta> entities = new  ArrayList<TipoInteresTarjeta>();
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoInteresTarjetaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoInteresTarjeta();
      	    	entity=super.getEntity("",entity,resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoInteresTarjeta("",entity,resultSet);
      	    	
				//entity.setTipoInteresTarjetaOriginal( new TipoInteresTarjeta());
      	    	//entity.setTipoInteresTarjetaOriginal(super.getEntity("",entity.getTipoInteresTarjetaOriginal(),resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoInteresTarjetaOriginal(this.getEntityTipoInteresTarjeta("",entity.getTipoInteresTarjetaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoInteresTarjetas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoInteresTarjeta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoInteresTarjeta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoInteresTarjeta> entities = new  ArrayList<TipoInteresTarjeta>();
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		  
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
	
	public  List<TipoInteresTarjeta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoInteresTarjeta> entities = new  ArrayList<TipoInteresTarjeta>();
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoInteresTarjeta();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoInteresTarjeta();
					//entity.setMapTipoInteresTarjeta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoInteresTarjetaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoInteresTarjeta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA);         		
					entity=TipoInteresTarjetaDataAccess.getEntityTipoInteresTarjeta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoInteresTarjetaOriginal( new TipoInteresTarjeta());
					////entity.setTipoInteresTarjetaOriginal(super.getEntity("",entity.getTipoInteresTarjetaOriginal(),resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoInteresTarjetaOriginal(this.getEntityTipoInteresTarjeta("",entity.getTipoInteresTarjetaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoInteresTarjetas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoInteresTarjeta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoInteresTarjeta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		  
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
	
	public  TipoInteresTarjeta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoInteresTarjeta();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoInteresTarjeta();
					//entity.setMapTipoInteresTarjeta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoInteresTarjetaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoInteresTarjeta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA);         		
					entity=TipoInteresTarjetaDataAccess.getEntityTipoInteresTarjeta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoInteresTarjetaOriginal( new TipoInteresTarjeta());
					////entity.setTipoInteresTarjetaOriginal(super.getEntity("",entity.getTipoInteresTarjetaOriginal(),resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoInteresTarjetaOriginal(this.getEntityTipoInteresTarjeta("",entity.getTipoInteresTarjetaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoInteresTarjeta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoInteresTarjeta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoInteresTarjeta getEntityTipoInteresTarjeta(String strPrefijo,TipoInteresTarjeta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoInteresTarjeta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoInteresTarjeta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoInteresTarjetaDataAccess.setFieldReflectionTipoInteresTarjeta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoInteresTarjeta=TipoInteresTarjetaConstantesFunciones.getTodosTiposColumnasTipoInteresTarjeta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoInteresTarjeta) {
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
							field = TipoInteresTarjeta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoInteresTarjeta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoInteresTarjetaDataAccess.setFieldReflectionTipoInteresTarjeta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoInteresTarjeta(Field field,String strPrefijo,String sColumn,TipoInteresTarjeta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoInteresTarjetaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoInteresTarjetaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoInteresTarjetaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoInteresTarjetaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoInteresTarjeta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoInteresTarjeta> entities = new  ArrayList<TipoInteresTarjeta>();
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoInteresTarjetaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoInteresTarjeta();
					entity=super.getEntity("",entity,resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoInteresTarjeta("",entity,resultSet);
					
					//entity.setTipoInteresTarjetaOriginal( new TipoInteresTarjeta());
					//entity.setTipoInteresTarjetaOriginal(super.getEntity("",entity.getTipoInteresTarjetaOriginal(),resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoInteresTarjetaOriginal(this.getEntityTipoInteresTarjeta("",entity.getTipoInteresTarjetaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoInteresTarjetas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoInteresTarjeta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoInteresTarjeta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoInteresTarjeta> entities = new  ArrayList<TipoInteresTarjeta>();
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoInteresTarjetaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoInteresTarjetaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoInteresTarjeta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoInteresTarjeta> entities = new  ArrayList<TipoInteresTarjeta>();
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		  
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
	
	public  List<TipoInteresTarjeta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoInteresTarjeta> entities = new  ArrayList<TipoInteresTarjeta>();
		TipoInteresTarjeta entity = new TipoInteresTarjeta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoInteresTarjeta();
      	    	entity=super.getEntity("",entity,resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoInteresTarjeta("",entity,resultSet);
      	    	
				//entity.setTipoInteresTarjetaOriginal( new TipoInteresTarjeta());
      	    	//entity.setTipoInteresTarjetaOriginal(super.getEntity("",entity.getTipoInteresTarjetaOriginal(),resultSet,TipoInteresTarjetaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoInteresTarjetaOriginal(this.getEntityTipoInteresTarjeta("",entity.getTipoInteresTarjetaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoInteresTarjetas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoInteresTarjeta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoInteresTarjeta getEntityTipoInteresTarjeta(String strPrefijo,TipoInteresTarjeta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoInteresTarjetaConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoInteresTarjetaConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoInteresTarjetaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoInteresTarjeta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoInteresTarjeta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoInteresTarjetaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoInteresTarjetaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoInteresTarjetaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoInteresTarjetaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoInteresTarjetaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoInteresTarjetaDataAccess.TABLENAME,TipoInteresTarjetaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoInteresTarjetaDataAccess.setTipoInteresTarjetaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas(Connexion connexion,TipoInteresTarjeta tipointerestarjeta)throws SQLException,Exception {

		List<FormaPagoPuntoVenta> formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoInteresTarjetaConstantesFunciones.SCHEMA+".tipo_interes_tarjeta ON "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+".forma_pago_punto_venta.id_tipo_interes_tarjeta="+TipoInteresTarjetaConstantesFunciones.SCHEMA+".tipo_interes_tarjeta.id WHERE "+TipoInteresTarjetaConstantesFunciones.SCHEMA+".tipo_interes_tarjeta.id="+String.valueOf(tipointerestarjeta.getId());
			} else {
				sQuery=" INNER JOIN formapagopuntoventa.TipoInteresTarjeta WHERE formapagopuntoventa.TipoInteresTarjeta.id="+String.valueOf(tipointerestarjeta.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoPuntoVentaDataAccess formapagopuntoventaDataAccess=new FormaPagoPuntoVentaDataAccess();

			formapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			formapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagopuntoventas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoInteresTarjeta tipointerestarjeta) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipointerestarjeta.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipointerestarjeta.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipointerestarjeta.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipointerestarjeta.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipointerestarjeta.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipointerestarjeta.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipointerestarjeta.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipointerestarjeta.getId());
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
	
	public void setIsNewIsChangedFalseTipoInteresTarjeta(TipoInteresTarjeta tipointerestarjeta)throws Exception  {		
		tipointerestarjeta.setIsNew(false);
		tipointerestarjeta.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoInteresTarjetas(List<TipoInteresTarjeta> tipointerestarjetas)throws Exception  {				
		for(TipoInteresTarjeta tipointerestarjeta:tipointerestarjetas) {
			tipointerestarjeta.setIsNew(false);
			tipointerestarjeta.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoInteresTarjeta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
