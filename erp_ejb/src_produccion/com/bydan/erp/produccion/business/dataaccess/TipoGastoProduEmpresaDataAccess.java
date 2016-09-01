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
package com.bydan.erp.produccion.business.dataaccess;

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

import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.produccion.util.*;//TipoGastoProduEmpresaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoGastoProduEmpresaDataAccess extends  TipoGastoProduEmpresaDataAccessAdditional{ //TipoGastoProduEmpresaDataAccessAdditional,DataAccessHelper<TipoGastoProduEmpresa>
	//static Logger logger = Logger.getLogger(TipoGastoProduEmpresaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_gasto_produ_empresa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,descripcion)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipogastoproduempresa from "+TipoGastoProduEmpresaConstantesFunciones.SPERSISTENCENAME+" tipogastoproduempresa";
	public static String QUERYSELECTNATIVE="select "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".id,"+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".descripcion from "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoGastoProduEmpresaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".id,"+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".nombre from "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoGastoProduEmpresaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOGASTOPRODUEMPRESA_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOGASTOPRODUEMPRESA_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOGASTOPRODUEMPRESA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOGASTOPRODUEMPRESA_SELECT(?,?)";
	
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
	
	
	protected TipoGastoProduEmpresaDataAccessAdditional tipogastoproduempresaDataAccessAdditional=null;
	
	public TipoGastoProduEmpresaDataAccessAdditional getTipoGastoProduEmpresaDataAccessAdditional() {
		return this.tipogastoproduempresaDataAccessAdditional;
	}
	
	public void setTipoGastoProduEmpresaDataAccessAdditional(TipoGastoProduEmpresaDataAccessAdditional tipogastoproduempresaDataAccessAdditional) {
		try {
			this.tipogastoproduempresaDataAccessAdditional=tipogastoproduempresaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoGastoProduEmpresaDataAccess() {
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
		TipoGastoProduEmpresaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoGastoProduEmpresaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoGastoProduEmpresaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoGastoProduEmpresaOriginal(TipoGastoProduEmpresa tipogastoproduempresa)throws Exception  {
		tipogastoproduempresa.setTipoGastoProduEmpresaOriginal((TipoGastoProduEmpresa)tipogastoproduempresa.clone());		
	}
	
	public void setTipoGastoProduEmpresasOriginal(List<TipoGastoProduEmpresa> tipogastoproduempresas)throws Exception  {
		
		for(TipoGastoProduEmpresa tipogastoproduempresa:tipogastoproduempresas){
			tipogastoproduempresa.setTipoGastoProduEmpresaOriginal((TipoGastoProduEmpresa)tipogastoproduempresa.clone());
		}
	}
	
	public static void setTipoGastoProduEmpresaOriginalStatic(TipoGastoProduEmpresa tipogastoproduempresa)throws Exception  {
		tipogastoproduempresa.setTipoGastoProduEmpresaOriginal((TipoGastoProduEmpresa)tipogastoproduempresa.clone());		
	}
	
	public static void setTipoGastoProduEmpresasOriginalStatic(List<TipoGastoProduEmpresa> tipogastoproduempresas)throws Exception  {
		
		for(TipoGastoProduEmpresa tipogastoproduempresa:tipogastoproduempresas){
			tipogastoproduempresa.setTipoGastoProduEmpresaOriginal((TipoGastoProduEmpresa)tipogastoproduempresa.clone());
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
	
	public  TipoGastoProduEmpresa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		
		
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
	
	public  TipoGastoProduEmpresa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.TipoGastoProduEmpresa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoGastoProduEmpresaOriginal(new TipoGastoProduEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGastoProduEmpresa("",entity,resultSet); 
				
				//entity.setTipoGastoProduEmpresaOriginal(super.getEntity("",entity.getTipoGastoProduEmpresaOriginal(),resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGastoProduEmpresaOriginal(this.getEntityTipoGastoProduEmpresa("",entity.getTipoGastoProduEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGastoProduEmpresa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoGastoProduEmpresa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();
				
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
	
	public  TipoGastoProduEmpresa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGastoProduEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoGastoProduEmpresa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoGastoProduEmpresaOriginal(new TipoGastoProduEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGastoProduEmpresa("",entity,resultSet);    
				
				//entity.setTipoGastoProduEmpresaOriginal(super.getEntity("",entity.getTipoGastoProduEmpresaOriginal(),resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGastoProduEmpresaOriginal(this.getEntityTipoGastoProduEmpresa("",entity.getTipoGastoProduEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGastoProduEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoGastoProduEmpresa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGastoProduEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoGastoProduEmpresa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoGastoProduEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoGastoProduEmpresa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGastoProduEmpresa> entities = new  ArrayList<TipoGastoProduEmpresa>();
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
		
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
	
	public  List<TipoGastoProduEmpresa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGastoProduEmpresa> entities = new  ArrayList<TipoGastoProduEmpresa>();
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGastoProduEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGastoProduEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGastoProduEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoGastoProduEmpresaOriginal( new TipoGastoProduEmpresa());
      	    	//entity.setTipoGastoProduEmpresaOriginal(super.getEntity("",entity.getTipoGastoProduEmpresaOriginal(),resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGastoProduEmpresaOriginal(this.getEntityTipoGastoProduEmpresa("",entity.getTipoGastoProduEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGastoProduEmpresas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGastoProduEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoGastoProduEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGastoProduEmpresa> entities = new  ArrayList<TipoGastoProduEmpresa>();
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
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
	
	public  List<TipoGastoProduEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGastoProduEmpresa> entities = new  ArrayList<TipoGastoProduEmpresa>();
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGastoProduEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGastoProduEmpresa();
					//entity.setMapTipoGastoProduEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoGastoProduEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGastoProduEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoGastoProduEmpresaDataAccess.getEntityTipoGastoProduEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGastoProduEmpresaOriginal( new TipoGastoProduEmpresa());
					////entity.setTipoGastoProduEmpresaOriginal(super.getEntity("",entity.getTipoGastoProduEmpresaOriginal(),resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGastoProduEmpresaOriginal(this.getEntityTipoGastoProduEmpresa("",entity.getTipoGastoProduEmpresaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGastoProduEmpresas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGastoProduEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoGastoProduEmpresa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
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
	
	public  TipoGastoProduEmpresa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGastoProduEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGastoProduEmpresa();
					//entity.setMapTipoGastoProduEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoGastoProduEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGastoProduEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoGastoProduEmpresaDataAccess.getEntityTipoGastoProduEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGastoProduEmpresaOriginal( new TipoGastoProduEmpresa());
					////entity.setTipoGastoProduEmpresaOriginal(super.getEntity("",entity.getTipoGastoProduEmpresaOriginal(),resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGastoProduEmpresaOriginal(this.getEntityTipoGastoProduEmpresa("",entity.getTipoGastoProduEmpresaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoGastoProduEmpresa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGastoProduEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoGastoProduEmpresa getEntityTipoGastoProduEmpresa(String strPrefijo,TipoGastoProduEmpresa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoGastoProduEmpresa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoGastoProduEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoGastoProduEmpresaDataAccess.setFieldReflectionTipoGastoProduEmpresa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoGastoProduEmpresa=TipoGastoProduEmpresaConstantesFunciones.getTodosTiposColumnasTipoGastoProduEmpresa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoGastoProduEmpresa) {
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
							field = TipoGastoProduEmpresa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoGastoProduEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoGastoProduEmpresaDataAccess.setFieldReflectionTipoGastoProduEmpresa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoGastoProduEmpresa(Field field,String strPrefijo,String sColumn,TipoGastoProduEmpresa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoGastoProduEmpresaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoProduEmpresaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoProduEmpresaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGastoProduEmpresaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGastoProduEmpresa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoGastoProduEmpresa> entities = new  ArrayList<TipoGastoProduEmpresa>();
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGastoProduEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoGastoProduEmpresa();
					entity=super.getEntity("",entity,resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoGastoProduEmpresa("",entity,resultSet);
					
					//entity.setTipoGastoProduEmpresaOriginal( new TipoGastoProduEmpresa());
					//entity.setTipoGastoProduEmpresaOriginal(super.getEntity("",entity.getTipoGastoProduEmpresaOriginal(),resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoGastoProduEmpresaOriginal(this.getEntityTipoGastoProduEmpresa("",entity.getTipoGastoProduEmpresaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoGastoProduEmpresas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGastoProduEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGastoProduEmpresa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoGastoProduEmpresa> entities = new  ArrayList<TipoGastoProduEmpresa>();
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGastoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGastoProduEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoGastoProduEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGastoProduEmpresa> entities = new  ArrayList<TipoGastoProduEmpresa>();
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
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
	
	public  List<TipoGastoProduEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGastoProduEmpresa> entities = new  ArrayList<TipoGastoProduEmpresa>();
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGastoProduEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGastoProduEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoGastoProduEmpresaOriginal( new TipoGastoProduEmpresa());
      	    	//entity.setTipoGastoProduEmpresaOriginal(super.getEntity("",entity.getTipoGastoProduEmpresaOriginal(),resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGastoProduEmpresaOriginal(this.getEntityTipoGastoProduEmpresa("",entity.getTipoGastoProduEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoGastoProduEmpresas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGastoProduEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoGastoProduEmpresa> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGastoProduEmpresa> entities = new  ArrayList<TipoGastoProduEmpresa>();
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
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
	
	public  List<TipoGastoProduEmpresa> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGastoProduEmpresa> entities = new  ArrayList<TipoGastoProduEmpresa>();
		TipoGastoProduEmpresa entity = new TipoGastoProduEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGastoProduEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGastoProduEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoGastoProduEmpresaOriginal( new TipoGastoProduEmpresa());
      	    	//entity.setTipoGastoProduEmpresaOriginal(super.getEntity("",entity.getTipoGastoProduEmpresaOriginal(),resultSet,TipoGastoProduEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGastoProduEmpresaOriginal(this.getEntityTipoGastoProduEmpresa("",entity.getTipoGastoProduEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGastoProduEmpresas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoGastoProduEmpresa getEntityTipoGastoProduEmpresa(String strPrefijo,TipoGastoProduEmpresa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+TipoGastoProduEmpresaConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoGastoProduEmpresaConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoGastoProduEmpresaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoGastoProduEmpresa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoGastoProduEmpresa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoGastoProduEmpresaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoGastoProduEmpresaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoGastoProduEmpresaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoGastoProduEmpresaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoGastoProduEmpresaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoGastoProduEmpresaDataAccess.TABLENAME,TipoGastoProduEmpresaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoGastoProduEmpresaDataAccess.setTipoGastoProduEmpresaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoGastoProduEmpresa reltipogastoproduempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipogastoproduempresa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<ProductoOrdenDetaProduGasto> getProductoOrdenDetaProduGastos(Connexion connexion,TipoGastoProduEmpresa tipogastoproduempresa)throws SQLException,Exception {

		List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos= new ArrayList<ProductoOrdenDetaProduGasto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+".tipo_gasto_produ_empresa ON "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+".producto_orden_deta_produ_gasto.id_tipo_gasto_produ_empresa="+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+".tipo_gasto_produ_empresa.id WHERE "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+".tipo_gasto_produ_empresa.id="+String.valueOf(tipogastoproduempresa.getId());
			} else {
				sQuery=" INNER JOIN productoordendetaprodugasto.TipoGastoProduEmpresa WHERE productoordendetaprodugasto.TipoGastoProduEmpresa.id="+String.valueOf(tipogastoproduempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoOrdenDetaProduGastoDataAccess productoordendetaprodugastoDataAccess=new ProductoOrdenDetaProduGastoDataAccess();

			productoordendetaprodugastoDataAccess.setConnexionType(this.connexionType);
			productoordendetaprodugastoDataAccess.setParameterDbType(this.parameterDbType);
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoordendetaprodugastos;

	}

	public List<ProductoProduGasto> getProductoProduGastos(Connexion connexion,TipoGastoProduEmpresa tipogastoproduempresa)throws SQLException,Exception {

		List<ProductoProduGasto> productoprodugastos= new ArrayList<ProductoProduGasto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+".tipo_gasto_produ_empresa ON "+ProductoProduGastoConstantesFunciones.SCHEMA+".producto_produ_gasto.id_tipo_gasto_produ_empresa="+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+".tipo_gasto_produ_empresa.id WHERE "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+".tipo_gasto_produ_empresa.id="+String.valueOf(tipogastoproduempresa.getId());
			} else {
				sQuery=" INNER JOIN productoprodugasto.TipoGastoProduEmpresa WHERE productoprodugasto.TipoGastoProduEmpresa.id="+String.valueOf(tipogastoproduempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProduGastoDataAccess productoprodugastoDataAccess=new ProductoProduGastoDataAccess();

			productoprodugastoDataAccess.setConnexionType(this.connexionType);
			productoprodugastoDataAccess.setParameterDbType(this.parameterDbType);
			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoprodugastos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoGastoProduEmpresa tipogastoproduempresa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipogastoproduempresa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipogastoproduempresa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipogastoproduempresa.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipogastoproduempresa.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipogastoproduempresa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipogastoproduempresa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipogastoproduempresa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipogastoproduempresa.getId());
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
	
	public void setIsNewIsChangedFalseTipoGastoProduEmpresa(TipoGastoProduEmpresa tipogastoproduempresa)throws Exception  {		
		tipogastoproduempresa.setIsNew(false);
		tipogastoproduempresa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoGastoProduEmpresas(List<TipoGastoProduEmpresa> tipogastoproduempresas)throws Exception  {				
		for(TipoGastoProduEmpresa tipogastoproduempresa:tipogastoproduempresas) {
			tipogastoproduempresa.setIsNew(false);
			tipogastoproduempresa.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoGastoProduEmpresa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
