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
import com.bydan.erp.inventario.util.*;//TipoMensajeCorreoInvenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoMensajeCorreoInvenDataAccess extends  DataAccessHelper<TipoMensajeCorreoInven>{ //TipoMensajeCorreoInvenDataAccessAdditional,DataAccessHelper<TipoMensajeCorreoInven>
	//static Logger logger = Logger.getLogger(TipoMensajeCorreoInvenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_mensaje_correo_inven";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+"(version_row,id_modulo,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_modulo=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipomensajecorreoinven from "+TipoMensajeCorreoInvenConstantesFunciones.SPERSISTENCENAME+" tipomensajecorreoinven";
	public static String QUERYSELECTNATIVE="select "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".id,"+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".version_row,"+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_modulo,"+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".codigo,"+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".nombre from "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME;//+" as "+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".id,"+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".version_row,"+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+".codigo from "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME;//+" as "+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+TipoMensajeCorreoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_modulo=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOMENSAJECORREOINVEN_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOMENSAJECORREOINVEN_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOMENSAJECORREOINVEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOMENSAJECORREOINVEN_SELECT(?,?)";
	
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
	
	
	public TipoMensajeCorreoInvenDataAccess() {
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
		TipoMensajeCorreoInvenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoMensajeCorreoInvenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoMensajeCorreoInvenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoMensajeCorreoInvenOriginal(TipoMensajeCorreoInven tipomensajecorreoinven)throws Exception  {
		tipomensajecorreoinven.setTipoMensajeCorreoInvenOriginal((TipoMensajeCorreoInven)tipomensajecorreoinven.clone());		
	}
	
	public void setTipoMensajeCorreoInvensOriginal(List<TipoMensajeCorreoInven> tipomensajecorreoinvens)throws Exception  {
		
		for(TipoMensajeCorreoInven tipomensajecorreoinven:tipomensajecorreoinvens){
			tipomensajecorreoinven.setTipoMensajeCorreoInvenOriginal((TipoMensajeCorreoInven)tipomensajecorreoinven.clone());
		}
	}
	
	public static void setTipoMensajeCorreoInvenOriginalStatic(TipoMensajeCorreoInven tipomensajecorreoinven)throws Exception  {
		tipomensajecorreoinven.setTipoMensajeCorreoInvenOriginal((TipoMensajeCorreoInven)tipomensajecorreoinven.clone());		
	}
	
	public static void setTipoMensajeCorreoInvensOriginalStatic(List<TipoMensajeCorreoInven> tipomensajecorreoinvens)throws Exception  {
		
		for(TipoMensajeCorreoInven tipomensajecorreoinven:tipomensajecorreoinvens){
			tipomensajecorreoinven.setTipoMensajeCorreoInvenOriginal((TipoMensajeCorreoInven)tipomensajecorreoinven.clone());
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
	
	public  TipoMensajeCorreoInven getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		
		
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
	
	public  TipoMensajeCorreoInven getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.TipoMensajeCorreoInven.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoMensajeCorreoInvenOriginal(new TipoMensajeCorreoInven());
      	    	entity=super.getEntity("",entity,resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMensajeCorreoInven("",entity,resultSet); 
				
				//entity.setTipoMensajeCorreoInvenOriginal(super.getEntity("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMensajeCorreoInvenOriginal(this.getEntityTipoMensajeCorreoInven("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMensajeCorreoInven(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoMensajeCorreoInven getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();
				
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
	
	public  TipoMensajeCorreoInven getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoMensajeCorreoInven.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoMensajeCorreoInvenOriginal(new TipoMensajeCorreoInven());
      	    	entity=super.getEntity("",entity,resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMensajeCorreoInven("",entity,resultSet);    
				
				//entity.setTipoMensajeCorreoInvenOriginal(super.getEntity("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMensajeCorreoInvenOriginal(this.getEntityTipoMensajeCorreoInven("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMensajeCorreoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoMensajeCorreoInven
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoMensajeCorreoInven.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoMensajeCorreoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoMensajeCorreoInven> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMensajeCorreoInven> entities = new  ArrayList<TipoMensajeCorreoInven>();
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		  
		
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
	
	public  List<TipoMensajeCorreoInven> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMensajeCorreoInven> entities = new  ArrayList<TipoMensajeCorreoInven>();
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMensajeCorreoInven();
      	    	entity=super.getEntity("",entity,resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMensajeCorreoInven("",entity,resultSet);
      	    	
				//entity.setTipoMensajeCorreoInvenOriginal( new TipoMensajeCorreoInven());
      	    	//entity.setTipoMensajeCorreoInvenOriginal(super.getEntity("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMensajeCorreoInvenOriginal(this.getEntityTipoMensajeCorreoInven("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMensajeCorreoInvens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoMensajeCorreoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMensajeCorreoInven> entities = new  ArrayList<TipoMensajeCorreoInven>();
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		  
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
	
	public  List<TipoMensajeCorreoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMensajeCorreoInven> entities = new  ArrayList<TipoMensajeCorreoInven>();
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMensajeCorreoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMensajeCorreoInven();
					//entity.setMapTipoMensajeCorreoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoMensajeCorreoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMensajeCorreoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
					entity=TipoMensajeCorreoInvenDataAccess.getEntityTipoMensajeCorreoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMensajeCorreoInvenOriginal( new TipoMensajeCorreoInven());
					////entity.setTipoMensajeCorreoInvenOriginal(super.getEntity("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMensajeCorreoInvenOriginal(this.getEntityTipoMensajeCorreoInven("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMensajeCorreoInvens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoMensajeCorreoInven getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		  
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
	
	public  TipoMensajeCorreoInven getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMensajeCorreoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMensajeCorreoInven();
					//entity.setMapTipoMensajeCorreoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoMensajeCorreoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMensajeCorreoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
					entity=TipoMensajeCorreoInvenDataAccess.getEntityTipoMensajeCorreoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMensajeCorreoInvenOriginal( new TipoMensajeCorreoInven());
					////entity.setTipoMensajeCorreoInvenOriginal(super.getEntity("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMensajeCorreoInvenOriginal(this.getEntityTipoMensajeCorreoInven("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoMensajeCorreoInven(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoMensajeCorreoInven getEntityTipoMensajeCorreoInven(String strPrefijo,TipoMensajeCorreoInven entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoMensajeCorreoInven.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoMensajeCorreoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoMensajeCorreoInvenDataAccess.setFieldReflectionTipoMensajeCorreoInven(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoMensajeCorreoInven=TipoMensajeCorreoInvenConstantesFunciones.getTodosTiposColumnasTipoMensajeCorreoInven();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoMensajeCorreoInven) {
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
							field = TipoMensajeCorreoInven.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoMensajeCorreoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoMensajeCorreoInvenDataAccess.setFieldReflectionTipoMensajeCorreoInven(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoMensajeCorreoInven(Field field,String strPrefijo,String sColumn,TipoMensajeCorreoInven entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoMensajeCorreoInvenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMensajeCorreoInvenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMensajeCorreoInvenConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMensajeCorreoInvenConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMensajeCorreoInvenConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMensajeCorreoInven>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoMensajeCorreoInven> entities = new  ArrayList<TipoMensajeCorreoInven>();
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoMensajeCorreoInven();
					entity=super.getEntity("",entity,resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoMensajeCorreoInven("",entity,resultSet);
					
					//entity.setTipoMensajeCorreoInvenOriginal( new TipoMensajeCorreoInven());
					//entity.setTipoMensajeCorreoInvenOriginal(super.getEntity("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoMensajeCorreoInvenOriginal(this.getEntityTipoMensajeCorreoInven("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoMensajeCorreoInvens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMensajeCorreoInven>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoMensajeCorreoInven> entities = new  ArrayList<TipoMensajeCorreoInven>();
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoMensajeCorreoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMensajeCorreoInven> entities = new  ArrayList<TipoMensajeCorreoInven>();
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		  
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
	
	public  List<TipoMensajeCorreoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMensajeCorreoInven> entities = new  ArrayList<TipoMensajeCorreoInven>();
		TipoMensajeCorreoInven entity = new TipoMensajeCorreoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMensajeCorreoInven();
      	    	entity=super.getEntity("",entity,resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMensajeCorreoInven("",entity,resultSet);
      	    	
				//entity.setTipoMensajeCorreoInvenOriginal( new TipoMensajeCorreoInven());
      	    	//entity.setTipoMensajeCorreoInvenOriginal(super.getEntity("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet,TipoMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMensajeCorreoInvenOriginal(this.getEntityTipoMensajeCorreoInven("",entity.getTipoMensajeCorreoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoMensajeCorreoInvens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoMensajeCorreoInven getEntityTipoMensajeCorreoInven(String strPrefijo,TipoMensajeCorreoInven entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_modulo(resultSet.getLong(strPrefijo+TipoMensajeCorreoInvenConstantesFunciones.IDMODULO));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoMensajeCorreoInvenConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoMensajeCorreoInvenConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoMensajeCorreoInvenConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoMensajeCorreoInven(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoMensajeCorreoInven entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoMensajeCorreoInvenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoMensajeCorreoInvenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoMensajeCorreoInvenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoMensajeCorreoInvenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoMensajeCorreoInvenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoMensajeCorreoInvenDataAccess.TABLENAME,TipoMensajeCorreoInvenDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoMensajeCorreoInvenDataAccess.setTipoMensajeCorreoInvenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Modulo getModulo(Connexion connexion,TipoMensajeCorreoInven reltipomensajecorreoinven)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reltipomensajecorreoinven.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}


		
		public List<MensajeCorreoInven> getMensajeCorreoInvens(Connexion connexion,TipoMensajeCorreoInven tipomensajecorreoinven)throws SQLException,Exception {

		List<MensajeCorreoInven> mensajecorreoinvens= new ArrayList<MensajeCorreoInven>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+".tipo_mensaje_correo_inven ON "+MensajeCorreoInvenConstantesFunciones.SCHEMA+".mensaje_correo_inven.id_tipo_mensaje_correo_inven="+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+".tipo_mensaje_correo_inven.id WHERE "+TipoMensajeCorreoInvenConstantesFunciones.SCHEMA+".tipo_mensaje_correo_inven.id="+String.valueOf(tipomensajecorreoinven.getId());
			} else {
				sQuery=" INNER JOIN mensajecorreoinven.TipoMensajeCorreoInven WHERE mensajecorreoinven.TipoMensajeCorreoInven.id="+String.valueOf(tipomensajecorreoinven.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MensajeCorreoInvenDataAccess mensajecorreoinvenDataAccess=new MensajeCorreoInvenDataAccess();

			mensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			mensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			mensajecorreoinvens=mensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mensajecorreoinvens;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoMensajeCorreoInven tipomensajecorreoinven) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipomensajecorreoinven.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(tipomensajecorreoinven.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipomensajecorreoinven.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipomensajecorreoinven.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipomensajecorreoinven.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipomensajecorreoinven.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipomensajecorreoinven.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipomensajecorreoinven.getId());
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
	
	public void setIsNewIsChangedFalseTipoMensajeCorreoInven(TipoMensajeCorreoInven tipomensajecorreoinven)throws Exception  {		
		tipomensajecorreoinven.setIsNew(false);
		tipomensajecorreoinven.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoMensajeCorreoInvens(List<TipoMensajeCorreoInven> tipomensajecorreoinvens)throws Exception  {				
		for(TipoMensajeCorreoInven tipomensajecorreoinven:tipomensajecorreoinvens) {
			tipomensajecorreoinven.setIsNew(false);
			tipomensajecorreoinven.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoMensajeCorreoInven(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
