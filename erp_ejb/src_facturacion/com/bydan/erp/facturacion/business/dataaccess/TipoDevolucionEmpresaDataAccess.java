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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//TipoDevolucionEmpresaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoDevolucionEmpresaDataAccess extends  TipoDevolucionEmpresaDataAccessAdditional{ //TipoDevolucionEmpresaDataAccessAdditional,DataAccessHelper<TipoDevolucionEmpresa>
	//static Logger logger = Logger.getLogger(TipoDevolucionEmpresaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_devolucion_empresa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,esta_activo)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipodevolucionempresa from "+TipoDevolucionEmpresaConstantesFunciones.SPERSISTENCENAME+" tipodevolucionempresa";
	public static String QUERYSELECTNATIVE="select "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".id,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".codigo,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".esta_activo from "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoDevolucionEmpresaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".id,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+".nombre from "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoDevolucionEmpresaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+"."+TipoDevolucionEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPODEVOLUCIONEMPRESA_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPODEVOLUCIONEMPRESA_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPODEVOLUCIONEMPRESA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPODEVOLUCIONEMPRESA_SELECT(?,?)";
	
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
	
	
	protected TipoDevolucionEmpresaDataAccessAdditional tipodevolucionempresaDataAccessAdditional=null;
	
	public TipoDevolucionEmpresaDataAccessAdditional getTipoDevolucionEmpresaDataAccessAdditional() {
		return this.tipodevolucionempresaDataAccessAdditional;
	}
	
	public void setTipoDevolucionEmpresaDataAccessAdditional(TipoDevolucionEmpresaDataAccessAdditional tipodevolucionempresaDataAccessAdditional) {
		try {
			this.tipodevolucionempresaDataAccessAdditional=tipodevolucionempresaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoDevolucionEmpresaDataAccess() {
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
		TipoDevolucionEmpresaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoDevolucionEmpresaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoDevolucionEmpresaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoDevolucionEmpresaOriginal(TipoDevolucionEmpresa tipodevolucionempresa)throws Exception  {
		tipodevolucionempresa.setTipoDevolucionEmpresaOriginal((TipoDevolucionEmpresa)tipodevolucionempresa.clone());		
	}
	
	public void setTipoDevolucionEmpresasOriginal(List<TipoDevolucionEmpresa> tipodevolucionempresas)throws Exception  {
		
		for(TipoDevolucionEmpresa tipodevolucionempresa:tipodevolucionempresas){
			tipodevolucionempresa.setTipoDevolucionEmpresaOriginal((TipoDevolucionEmpresa)tipodevolucionempresa.clone());
		}
	}
	
	public static void setTipoDevolucionEmpresaOriginalStatic(TipoDevolucionEmpresa tipodevolucionempresa)throws Exception  {
		tipodevolucionempresa.setTipoDevolucionEmpresaOriginal((TipoDevolucionEmpresa)tipodevolucionempresa.clone());		
	}
	
	public static void setTipoDevolucionEmpresasOriginalStatic(List<TipoDevolucionEmpresa> tipodevolucionempresas)throws Exception  {
		
		for(TipoDevolucionEmpresa tipodevolucionempresa:tipodevolucionempresas){
			tipodevolucionempresa.setTipoDevolucionEmpresaOriginal((TipoDevolucionEmpresa)tipodevolucionempresa.clone());
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
	
	public  TipoDevolucionEmpresa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		
		
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
	
	public  TipoDevolucionEmpresa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoDevolucionEmpresa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoDevolucionEmpresaOriginal(new TipoDevolucionEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDevolucionEmpresa("",entity,resultSet); 
				
				//entity.setTipoDevolucionEmpresaOriginal(super.getEntity("",entity.getTipoDevolucionEmpresaOriginal(),resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDevolucionEmpresaOriginal(this.getEntityTipoDevolucionEmpresa("",entity.getTipoDevolucionEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDevolucionEmpresa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoDevolucionEmpresa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();
				
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
	
	public  TipoDevolucionEmpresa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDevolucionEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoDevolucionEmpresa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoDevolucionEmpresaOriginal(new TipoDevolucionEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDevolucionEmpresa("",entity,resultSet);    
				
				//entity.setTipoDevolucionEmpresaOriginal(super.getEntity("",entity.getTipoDevolucionEmpresaOriginal(),resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDevolucionEmpresaOriginal(this.getEntityTipoDevolucionEmpresa("",entity.getTipoDevolucionEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDevolucionEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoDevolucionEmpresa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDevolucionEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoDevolucionEmpresa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoDevolucionEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoDevolucionEmpresa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDevolucionEmpresa> entities = new  ArrayList<TipoDevolucionEmpresa>();
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
		
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
	
	public  List<TipoDevolucionEmpresa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDevolucionEmpresa> entities = new  ArrayList<TipoDevolucionEmpresa>();
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDevolucionEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDevolucionEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDevolucionEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoDevolucionEmpresaOriginal( new TipoDevolucionEmpresa());
      	    	//entity.setTipoDevolucionEmpresaOriginal(super.getEntity("",entity.getTipoDevolucionEmpresaOriginal(),resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDevolucionEmpresaOriginal(this.getEntityTipoDevolucionEmpresa("",entity.getTipoDevolucionEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDevolucionEmpresas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDevolucionEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDevolucionEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDevolucionEmpresa> entities = new  ArrayList<TipoDevolucionEmpresa>();
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
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
	
	public  List<TipoDevolucionEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDevolucionEmpresa> entities = new  ArrayList<TipoDevolucionEmpresa>();
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDevolucionEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDevolucionEmpresa();
					//entity.setMapTipoDevolucionEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoDevolucionEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDevolucionEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoDevolucionEmpresaDataAccess.getEntityTipoDevolucionEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDevolucionEmpresaOriginal( new TipoDevolucionEmpresa());
					////entity.setTipoDevolucionEmpresaOriginal(super.getEntity("",entity.getTipoDevolucionEmpresaOriginal(),resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDevolucionEmpresaOriginal(this.getEntityTipoDevolucionEmpresa("",entity.getTipoDevolucionEmpresaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDevolucionEmpresas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDevolucionEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoDevolucionEmpresa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
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
	
	public  TipoDevolucionEmpresa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDevolucionEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDevolucionEmpresa();
					//entity.setMapTipoDevolucionEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoDevolucionEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDevolucionEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoDevolucionEmpresaDataAccess.getEntityTipoDevolucionEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDevolucionEmpresaOriginal( new TipoDevolucionEmpresa());
					////entity.setTipoDevolucionEmpresaOriginal(super.getEntity("",entity.getTipoDevolucionEmpresaOriginal(),resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDevolucionEmpresaOriginal(this.getEntityTipoDevolucionEmpresa("",entity.getTipoDevolucionEmpresaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoDevolucionEmpresa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDevolucionEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoDevolucionEmpresa getEntityTipoDevolucionEmpresa(String strPrefijo,TipoDevolucionEmpresa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoDevolucionEmpresa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoDevolucionEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoDevolucionEmpresaDataAccess.setFieldReflectionTipoDevolucionEmpresa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoDevolucionEmpresa=TipoDevolucionEmpresaConstantesFunciones.getTodosTiposColumnasTipoDevolucionEmpresa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoDevolucionEmpresa) {
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
							field = TipoDevolucionEmpresa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoDevolucionEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoDevolucionEmpresaDataAccess.setFieldReflectionTipoDevolucionEmpresa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoDevolucionEmpresa(Field field,String strPrefijo,String sColumn,TipoDevolucionEmpresa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoDevolucionEmpresaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDevolucionEmpresaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDevolucionEmpresaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDevolucionEmpresaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDevolucionEmpresaConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDevolucionEmpresa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoDevolucionEmpresa> entities = new  ArrayList<TipoDevolucionEmpresa>();
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDevolucionEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoDevolucionEmpresa();
					entity=super.getEntity("",entity,resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoDevolucionEmpresa("",entity,resultSet);
					
					//entity.setTipoDevolucionEmpresaOriginal( new TipoDevolucionEmpresa());
					//entity.setTipoDevolucionEmpresaOriginal(super.getEntity("",entity.getTipoDevolucionEmpresaOriginal(),resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoDevolucionEmpresaOriginal(this.getEntityTipoDevolucionEmpresa("",entity.getTipoDevolucionEmpresaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoDevolucionEmpresas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDevolucionEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDevolucionEmpresa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoDevolucionEmpresa> entities = new  ArrayList<TipoDevolucionEmpresa>();
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDevolucionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDevolucionEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoDevolucionEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDevolucionEmpresa> entities = new  ArrayList<TipoDevolucionEmpresa>();
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
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
	
	public  List<TipoDevolucionEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDevolucionEmpresa> entities = new  ArrayList<TipoDevolucionEmpresa>();
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDevolucionEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDevolucionEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoDevolucionEmpresaOriginal( new TipoDevolucionEmpresa());
      	    	//entity.setTipoDevolucionEmpresaOriginal(super.getEntity("",entity.getTipoDevolucionEmpresaOriginal(),resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDevolucionEmpresaOriginal(this.getEntityTipoDevolucionEmpresa("",entity.getTipoDevolucionEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoDevolucionEmpresas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDevolucionEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDevolucionEmpresa> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDevolucionEmpresa> entities = new  ArrayList<TipoDevolucionEmpresa>();
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
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
	
	public  List<TipoDevolucionEmpresa> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDevolucionEmpresa> entities = new  ArrayList<TipoDevolucionEmpresa>();
		TipoDevolucionEmpresa entity = new TipoDevolucionEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDevolucionEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDevolucionEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoDevolucionEmpresaOriginal( new TipoDevolucionEmpresa());
      	    	//entity.setTipoDevolucionEmpresaOriginal(super.getEntity("",entity.getTipoDevolucionEmpresaOriginal(),resultSet,TipoDevolucionEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDevolucionEmpresaOriginal(this.getEntityTipoDevolucionEmpresa("",entity.getTipoDevolucionEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDevolucionEmpresas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoDevolucionEmpresa getEntityTipoDevolucionEmpresa(String strPrefijo,TipoDevolucionEmpresa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoDevolucionEmpresaConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDevolucionEmpresaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoDevolucionEmpresaConstantesFunciones.NOMBRE));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+TipoDevolucionEmpresaConstantesFunciones.ESTAACTIVO));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoDevolucionEmpresaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoDevolucionEmpresa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoDevolucionEmpresa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoDevolucionEmpresaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoDevolucionEmpresaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoDevolucionEmpresaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoDevolucionEmpresaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoDevolucionEmpresaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoDevolucionEmpresaDataAccess.TABLENAME,TipoDevolucionEmpresaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoDevolucionEmpresaDataAccess.setTipoDevolucionEmpresaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoDevolucionEmpresa reltipodevolucionempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipodevolucionempresa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<DetaNotaCredito> getDetaNotaCreditos(Connexion connexion,TipoDevolucionEmpresa tipodevolucionempresa)throws SQLException,Exception {

		List<DetaNotaCredito> detanotacreditos= new ArrayList<DetaNotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+".tipo_devolucion_empresa ON "+DetaNotaCreditoConstantesFunciones.SCHEMA+".deta_nota_credito.id_tipo_devolucion_empresa="+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+".tipo_devolucion_empresa.id WHERE "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+".tipo_devolucion_empresa.id="+String.valueOf(tipodevolucionempresa.getId());
			} else {
				sQuery=" INNER JOIN detanotacredito.TipoDevolucionEmpresa WHERE detanotacredito.TipoDevolucionEmpresa.id="+String.valueOf(tipodevolucionempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaNotaCreditoDataAccess detanotacreditoDataAccess=new DetaNotaCreditoDataAccess();

			detanotacreditoDataAccess.setConnexionType(this.connexionType);
			detanotacreditoDataAccess.setParameterDbType(this.parameterDbType);
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detanotacreditos;

	}

	public List<DetaNotaCreditoSoli> getDetaNotaCreditoSolis(Connexion connexion,TipoDevolucionEmpresa tipodevolucionempresa)throws SQLException,Exception {

		List<DetaNotaCreditoSoli> detanotacreditosolis= new ArrayList<DetaNotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+".tipo_devolucion_empresa ON "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+".deta_nota_credito_soli.id_tipo_devolucion_empresa="+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+".tipo_devolucion_empresa.id WHERE "+TipoDevolucionEmpresaConstantesFunciones.SCHEMA+".tipo_devolucion_empresa.id="+String.valueOf(tipodevolucionempresa.getId());
			} else {
				sQuery=" INNER JOIN detanotacreditosoli.TipoDevolucionEmpresa WHERE detanotacreditosoli.TipoDevolucionEmpresa.id="+String.valueOf(tipodevolucionempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaNotaCreditoSoliDataAccess detanotacreditosoliDataAccess=new DetaNotaCreditoSoliDataAccess();

			detanotacreditosoliDataAccess.setConnexionType(this.connexionType);
			detanotacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detanotacreditosolis;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoDevolucionEmpresa tipodevolucionempresa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipodevolucionempresa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipodevolucionempresa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipodevolucionempresa.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipodevolucionempresa.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(tipodevolucionempresa.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipodevolucionempresa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipodevolucionempresa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipodevolucionempresa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipodevolucionempresa.getId());
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
	
	public void setIsNewIsChangedFalseTipoDevolucionEmpresa(TipoDevolucionEmpresa tipodevolucionempresa)throws Exception  {		
		tipodevolucionempresa.setIsNew(false);
		tipodevolucionempresa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoDevolucionEmpresas(List<TipoDevolucionEmpresa> tipodevolucionempresas)throws Exception  {				
		for(TipoDevolucionEmpresa tipodevolucionempresa:tipodevolucionempresas) {
			tipodevolucionempresa.setIsNew(false);
			tipodevolucionempresa.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoDevolucionEmpresa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
