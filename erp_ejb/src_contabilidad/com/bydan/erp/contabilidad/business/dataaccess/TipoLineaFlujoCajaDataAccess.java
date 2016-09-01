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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//TipoLineaFlujoCajaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoLineaFlujoCajaDataAccess extends  TipoLineaFlujoCajaDataAccessAdditional{ //TipoLineaFlujoCajaDataAccessAdditional,DataAccessHelper<TipoLineaFlujoCaja>
	//static Logger logger = Logger.getLogger(TipoLineaFlujoCajaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_linea_flujo_caja";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,codigo_sri)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,codigo_sri=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipolineaflujocaja from "+TipoLineaFlujoCajaConstantesFunciones.SPERSISTENCENAME+" tipolineaflujocaja";
	public static String QUERYSELECTNATIVE="select "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".id,"+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".id_empresa,"+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".nombre,"+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".codigo_sri from "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+TipoLineaFlujoCajaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".id,"+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+".nombre from "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+TipoLineaFlujoCajaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+"."+TipoLineaFlujoCajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,codigo_sri=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOLINEAFLUJOCAJA_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOLINEAFLUJOCAJA_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOLINEAFLUJOCAJA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOLINEAFLUJOCAJA_SELECT(?,?)";
	
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
	
	
	protected TipoLineaFlujoCajaDataAccessAdditional tipolineaflujocajaDataAccessAdditional=null;
	
	public TipoLineaFlujoCajaDataAccessAdditional getTipoLineaFlujoCajaDataAccessAdditional() {
		return this.tipolineaflujocajaDataAccessAdditional;
	}
	
	public void setTipoLineaFlujoCajaDataAccessAdditional(TipoLineaFlujoCajaDataAccessAdditional tipolineaflujocajaDataAccessAdditional) {
		try {
			this.tipolineaflujocajaDataAccessAdditional=tipolineaflujocajaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoLineaFlujoCajaDataAccess() {
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
		TipoLineaFlujoCajaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoLineaFlujoCajaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoLineaFlujoCajaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoLineaFlujoCajaOriginal(TipoLineaFlujoCaja tipolineaflujocaja)throws Exception  {
		tipolineaflujocaja.setTipoLineaFlujoCajaOriginal((TipoLineaFlujoCaja)tipolineaflujocaja.clone());		
	}
	
	public void setTipoLineaFlujoCajasOriginal(List<TipoLineaFlujoCaja> tipolineaflujocajas)throws Exception  {
		
		for(TipoLineaFlujoCaja tipolineaflujocaja:tipolineaflujocajas){
			tipolineaflujocaja.setTipoLineaFlujoCajaOriginal((TipoLineaFlujoCaja)tipolineaflujocaja.clone());
		}
	}
	
	public static void setTipoLineaFlujoCajaOriginalStatic(TipoLineaFlujoCaja tipolineaflujocaja)throws Exception  {
		tipolineaflujocaja.setTipoLineaFlujoCajaOriginal((TipoLineaFlujoCaja)tipolineaflujocaja.clone());		
	}
	
	public static void setTipoLineaFlujoCajasOriginalStatic(List<TipoLineaFlujoCaja> tipolineaflujocajas)throws Exception  {
		
		for(TipoLineaFlujoCaja tipolineaflujocaja:tipolineaflujocajas){
			tipolineaflujocaja.setTipoLineaFlujoCajaOriginal((TipoLineaFlujoCaja)tipolineaflujocaja.clone());
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
	
	public  TipoLineaFlujoCaja getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		
		
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
	
	public  TipoLineaFlujoCaja getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoLineaFlujoCaja.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoLineaFlujoCajaOriginal(new TipoLineaFlujoCaja());
      	    	entity=super.getEntity("",entity,resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoLineaFlujoCaja("",entity,resultSet); 
				
				//entity.setTipoLineaFlujoCajaOriginal(super.getEntity("",entity.getTipoLineaFlujoCajaOriginal(),resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoLineaFlujoCajaOriginal(this.getEntityTipoLineaFlujoCaja("",entity.getTipoLineaFlujoCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoLineaFlujoCaja(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoLineaFlujoCaja getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();
				
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
	
	public  TipoLineaFlujoCaja getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoLineaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoLineaFlujoCaja.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoLineaFlujoCajaOriginal(new TipoLineaFlujoCaja());
      	    	entity=super.getEntity("",entity,resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoLineaFlujoCaja("",entity,resultSet);    
				
				//entity.setTipoLineaFlujoCajaOriginal(super.getEntity("",entity.getTipoLineaFlujoCajaOriginal(),resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoLineaFlujoCajaOriginal(this.getEntityTipoLineaFlujoCaja("",entity.getTipoLineaFlujoCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoLineaFlujoCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoLineaFlujoCaja
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoLineaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoLineaFlujoCaja.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoLineaFlujoCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoLineaFlujoCaja> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoLineaFlujoCaja> entities = new  ArrayList<TipoLineaFlujoCaja>();
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
		
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
	
	public  List<TipoLineaFlujoCaja> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoLineaFlujoCaja> entities = new  ArrayList<TipoLineaFlujoCaja>();
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoLineaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoLineaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoLineaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setTipoLineaFlujoCajaOriginal( new TipoLineaFlujoCaja());
      	    	//entity.setTipoLineaFlujoCajaOriginal(super.getEntity("",entity.getTipoLineaFlujoCajaOriginal(),resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoLineaFlujoCajaOriginal(this.getEntityTipoLineaFlujoCaja("",entity.getTipoLineaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoLineaFlujoCajas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoLineaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoLineaFlujoCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoLineaFlujoCaja> entities = new  ArrayList<TipoLineaFlujoCaja>();
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
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
	
	public  List<TipoLineaFlujoCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoLineaFlujoCaja> entities = new  ArrayList<TipoLineaFlujoCaja>();
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoLineaFlujoCaja();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoLineaFlujoCaja();
					//entity.setMapTipoLineaFlujoCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoLineaFlujoCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoLineaFlujoCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=TipoLineaFlujoCajaDataAccess.getEntityTipoLineaFlujoCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoLineaFlujoCajaOriginal( new TipoLineaFlujoCaja());
					////entity.setTipoLineaFlujoCajaOriginal(super.getEntity("",entity.getTipoLineaFlujoCajaOriginal(),resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoLineaFlujoCajaOriginal(this.getEntityTipoLineaFlujoCaja("",entity.getTipoLineaFlujoCajaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoLineaFlujoCajas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoLineaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoLineaFlujoCaja getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
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
	
	public  TipoLineaFlujoCaja getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoLineaFlujoCaja();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoLineaFlujoCaja();
					//entity.setMapTipoLineaFlujoCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoLineaFlujoCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoLineaFlujoCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=TipoLineaFlujoCajaDataAccess.getEntityTipoLineaFlujoCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoLineaFlujoCajaOriginal( new TipoLineaFlujoCaja());
					////entity.setTipoLineaFlujoCajaOriginal(super.getEntity("",entity.getTipoLineaFlujoCajaOriginal(),resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoLineaFlujoCajaOriginal(this.getEntityTipoLineaFlujoCaja("",entity.getTipoLineaFlujoCajaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoLineaFlujoCaja(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoLineaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoLineaFlujoCaja getEntityTipoLineaFlujoCaja(String strPrefijo,TipoLineaFlujoCaja entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoLineaFlujoCaja.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoLineaFlujoCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoLineaFlujoCajaDataAccess.setFieldReflectionTipoLineaFlujoCaja(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoLineaFlujoCaja=TipoLineaFlujoCajaConstantesFunciones.getTodosTiposColumnasTipoLineaFlujoCaja();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoLineaFlujoCaja) {
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
							field = TipoLineaFlujoCaja.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoLineaFlujoCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoLineaFlujoCajaDataAccess.setFieldReflectionTipoLineaFlujoCaja(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoLineaFlujoCaja(Field field,String strPrefijo,String sColumn,TipoLineaFlujoCaja entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoLineaFlujoCajaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoLineaFlujoCajaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoLineaFlujoCajaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoLineaFlujoCaja>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoLineaFlujoCaja> entities = new  ArrayList<TipoLineaFlujoCaja>();
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoLineaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoLineaFlujoCaja();
					entity=super.getEntity("",entity,resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoLineaFlujoCaja("",entity,resultSet);
					
					//entity.setTipoLineaFlujoCajaOriginal( new TipoLineaFlujoCaja());
					//entity.setTipoLineaFlujoCajaOriginal(super.getEntity("",entity.getTipoLineaFlujoCajaOriginal(),resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoLineaFlujoCajaOriginal(this.getEntityTipoLineaFlujoCaja("",entity.getTipoLineaFlujoCajaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoLineaFlujoCajas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoLineaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoLineaFlujoCaja>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoLineaFlujoCaja> entities = new  ArrayList<TipoLineaFlujoCaja>();
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoLineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoLineaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoLineaFlujoCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoLineaFlujoCaja> entities = new  ArrayList<TipoLineaFlujoCaja>();
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
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
	
	public  List<TipoLineaFlujoCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoLineaFlujoCaja> entities = new  ArrayList<TipoLineaFlujoCaja>();
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoLineaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoLineaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setTipoLineaFlujoCajaOriginal( new TipoLineaFlujoCaja());
      	    	//entity.setTipoLineaFlujoCajaOriginal(super.getEntity("",entity.getTipoLineaFlujoCajaOriginal(),resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoLineaFlujoCajaOriginal(this.getEntityTipoLineaFlujoCaja("",entity.getTipoLineaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoLineaFlujoCajas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoLineaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoLineaFlujoCaja> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoLineaFlujoCaja> entities = new  ArrayList<TipoLineaFlujoCaja>();
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
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
	
	public  List<TipoLineaFlujoCaja> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoLineaFlujoCaja> entities = new  ArrayList<TipoLineaFlujoCaja>();
		TipoLineaFlujoCaja entity = new TipoLineaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoLineaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoLineaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setTipoLineaFlujoCajaOriginal( new TipoLineaFlujoCaja());
      	    	//entity.setTipoLineaFlujoCajaOriginal(super.getEntity("",entity.getTipoLineaFlujoCajaOriginal(),resultSet,TipoLineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoLineaFlujoCajaOriginal(this.getEntityTipoLineaFlujoCaja("",entity.getTipoLineaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoLineaFlujoCajas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoLineaFlujoCaja getEntityTipoLineaFlujoCaja(String strPrefijo,TipoLineaFlujoCaja entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+TipoLineaFlujoCajaConstantesFunciones.NOMBRE));
				entity.setcodigo_sri(resultSet.getString(strPrefijo+TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoLineaFlujoCajaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoLineaFlujoCaja(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoLineaFlujoCaja entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoLineaFlujoCajaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoLineaFlujoCajaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoLineaFlujoCajaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoLineaFlujoCajaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoLineaFlujoCajaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoLineaFlujoCajaDataAccess.TABLENAME,TipoLineaFlujoCajaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoLineaFlujoCajaDataAccess.setTipoLineaFlujoCajaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoLineaFlujoCaja reltipolineaflujocaja)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipolineaflujocaja.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<LineaFlujoCaja> getLineaFlujoCajas(Connexion connexion,TipoLineaFlujoCaja tipolineaflujocaja)throws SQLException,Exception {

		List<LineaFlujoCaja> lineaflujocajas= new ArrayList<LineaFlujoCaja>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+".tipo_linea_flujo_caja ON "+LineaFlujoCajaConstantesFunciones.SCHEMA+".linea_flujo_caja.id_tipo_linea_flujo_caja="+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+".tipo_linea_flujo_caja.id WHERE "+TipoLineaFlujoCajaConstantesFunciones.SCHEMA+".tipo_linea_flujo_caja.id="+String.valueOf(tipolineaflujocaja.getId());
			} else {
				sQuery=" INNER JOIN lineaflujocaja.TipoLineaFlujoCaja WHERE lineaflujocaja.TipoLineaFlujoCaja.id="+String.valueOf(tipolineaflujocaja.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			LineaFlujoCajaDataAccess lineaflujocajaDataAccess=new LineaFlujoCajaDataAccess();

			lineaflujocajaDataAccess.setConnexionType(this.connexionType);
			lineaflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return lineaflujocajas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoLineaFlujoCaja tipolineaflujocaja) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipolineaflujocaja.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipolineaflujocaja.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipolineaflujocaja.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_sri=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_sri.setValue(tipolineaflujocaja.getcodigo_sri());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_sri);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipolineaflujocaja.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipolineaflujocaja.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipolineaflujocaja.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipolineaflujocaja.getId());
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
	
	public void setIsNewIsChangedFalseTipoLineaFlujoCaja(TipoLineaFlujoCaja tipolineaflujocaja)throws Exception  {		
		tipolineaflujocaja.setIsNew(false);
		tipolineaflujocaja.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoLineaFlujoCajas(List<TipoLineaFlujoCaja> tipolineaflujocajas)throws Exception  {				
		for(TipoLineaFlujoCaja tipolineaflujocaja:tipolineaflujocajas) {
			tipolineaflujocaja.setIsNew(false);
			tipolineaflujocaja.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoLineaFlujoCaja(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
