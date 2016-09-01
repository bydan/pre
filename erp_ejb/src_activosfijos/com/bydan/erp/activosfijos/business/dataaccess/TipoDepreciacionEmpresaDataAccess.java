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
package com.bydan.erp.activosfijos.business.dataaccess;

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

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//TipoDepreciacionEmpresaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;




@SuppressWarnings("unused")
final public class TipoDepreciacionEmpresaDataAccess extends  DataAccessHelper<TipoDepreciacionEmpresa>{ //TipoDepreciacionEmpresaDataAccessAdditional,DataAccessHelper<TipoDepreciacionEmpresa>
	//static Logger logger = Logger.getLogger(TipoDepreciacionEmpresaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_depreciacion_empresa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,es_linea_recta,es_mensual)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,es_linea_recta=?,es_mensual=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipodepreciacionempresa from "+TipoDepreciacionEmpresaConstantesFunciones.SPERSISTENCENAME+" tipodepreciacionempresa";
	public static String QUERYSELECTNATIVE="select "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".id,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".codigo,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".es_linea_recta,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".es_mensual from "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".id,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".codigo from "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,es_linea_recta=?,es_mensual=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPODEPRECIACIONEMPRESA_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPODEPRECIACIONEMPRESA_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPODEPRECIACIONEMPRESA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPODEPRECIACIONEMPRESA_SELECT(?,?)";
	
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
	
	
	public TipoDepreciacionEmpresaDataAccess() {
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
		TipoDepreciacionEmpresaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoDepreciacionEmpresaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoDepreciacionEmpresaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoDepreciacionEmpresaOriginal(TipoDepreciacionEmpresa tipodepreciacionempresa)throws Exception  {
		tipodepreciacionempresa.setTipoDepreciacionEmpresaOriginal((TipoDepreciacionEmpresa)tipodepreciacionempresa.clone());		
	}
	
	public void setTipoDepreciacionEmpresasOriginal(List<TipoDepreciacionEmpresa> tipodepreciacionempresas)throws Exception  {
		
		for(TipoDepreciacionEmpresa tipodepreciacionempresa:tipodepreciacionempresas){
			tipodepreciacionempresa.setTipoDepreciacionEmpresaOriginal((TipoDepreciacionEmpresa)tipodepreciacionempresa.clone());
		}
	}
	
	public static void setTipoDepreciacionEmpresaOriginalStatic(TipoDepreciacionEmpresa tipodepreciacionempresa)throws Exception  {
		tipodepreciacionempresa.setTipoDepreciacionEmpresaOriginal((TipoDepreciacionEmpresa)tipodepreciacionempresa.clone());		
	}
	
	public static void setTipoDepreciacionEmpresasOriginalStatic(List<TipoDepreciacionEmpresa> tipodepreciacionempresas)throws Exception  {
		
		for(TipoDepreciacionEmpresa tipodepreciacionempresa:tipodepreciacionempresas){
			tipodepreciacionempresa.setTipoDepreciacionEmpresaOriginal((TipoDepreciacionEmpresa)tipodepreciacionempresa.clone());
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
	
	public  TipoDepreciacionEmpresa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		
		
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
	
	public  TipoDepreciacionEmpresa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.TipoDepreciacionEmpresa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoDepreciacionEmpresaOriginal(new TipoDepreciacionEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDepreciacionEmpresa("",entity,resultSet); 
				
				//entity.setTipoDepreciacionEmpresaOriginal(super.getEntity("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDepreciacionEmpresaOriginal(this.getEntityTipoDepreciacionEmpresa("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDepreciacionEmpresa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoDepreciacionEmpresa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();
				
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
	
	public  TipoDepreciacionEmpresa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDepreciacionEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.TipoDepreciacionEmpresa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoDepreciacionEmpresaOriginal(new TipoDepreciacionEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDepreciacionEmpresa("",entity,resultSet);    
				
				//entity.setTipoDepreciacionEmpresaOriginal(super.getEntity("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDepreciacionEmpresaOriginal(this.getEntityTipoDepreciacionEmpresa("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDepreciacionEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoDepreciacionEmpresa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDepreciacionEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.TipoDepreciacionEmpresa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoDepreciacionEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoDepreciacionEmpresa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDepreciacionEmpresa> entities = new  ArrayList<TipoDepreciacionEmpresa>();
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		  
		
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
	
	public  List<TipoDepreciacionEmpresa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDepreciacionEmpresa> entities = new  ArrayList<TipoDepreciacionEmpresa>();
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDepreciacionEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDepreciacionEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDepreciacionEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoDepreciacionEmpresaOriginal( new TipoDepreciacionEmpresa());
      	    	//entity.setTipoDepreciacionEmpresaOriginal(super.getEntity("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDepreciacionEmpresaOriginal(this.getEntityTipoDepreciacionEmpresa("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDepreciacionEmpresas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDepreciacionEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDepreciacionEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDepreciacionEmpresa> entities = new  ArrayList<TipoDepreciacionEmpresa>();
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		  
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
	
	public  List<TipoDepreciacionEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDepreciacionEmpresa> entities = new  ArrayList<TipoDepreciacionEmpresa>();
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDepreciacionEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDepreciacionEmpresa();
					//entity.setMapTipoDepreciacionEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoDepreciacionEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDepreciacionEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoDepreciacionEmpresaDataAccess.getEntityTipoDepreciacionEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDepreciacionEmpresaOriginal( new TipoDepreciacionEmpresa());
					////entity.setTipoDepreciacionEmpresaOriginal(super.getEntity("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDepreciacionEmpresaOriginal(this.getEntityTipoDepreciacionEmpresa("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDepreciacionEmpresas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDepreciacionEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoDepreciacionEmpresa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		  
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
	
	public  TipoDepreciacionEmpresa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDepreciacionEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDepreciacionEmpresa();
					//entity.setMapTipoDepreciacionEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoDepreciacionEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDepreciacionEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoDepreciacionEmpresaDataAccess.getEntityTipoDepreciacionEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDepreciacionEmpresaOriginal( new TipoDepreciacionEmpresa());
					////entity.setTipoDepreciacionEmpresaOriginal(super.getEntity("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDepreciacionEmpresaOriginal(this.getEntityTipoDepreciacionEmpresa("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoDepreciacionEmpresa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDepreciacionEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoDepreciacionEmpresa getEntityTipoDepreciacionEmpresa(String strPrefijo,TipoDepreciacionEmpresa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoDepreciacionEmpresa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoDepreciacionEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoDepreciacionEmpresaDataAccess.setFieldReflectionTipoDepreciacionEmpresa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoDepreciacionEmpresa=TipoDepreciacionEmpresaConstantesFunciones.getTodosTiposColumnasTipoDepreciacionEmpresa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoDepreciacionEmpresa) {
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
							field = TipoDepreciacionEmpresa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoDepreciacionEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoDepreciacionEmpresaDataAccess.setFieldReflectionTipoDepreciacionEmpresa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoDepreciacionEmpresa(Field field,String strPrefijo,String sColumn,TipoDepreciacionEmpresa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoDepreciacionEmpresaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDepreciacionEmpresaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDepreciacionEmpresaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDepreciacionEmpresaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDepreciacionEmpresaConstantesFunciones.ESLINEARECTA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoDepreciacionEmpresaConstantesFunciones.ESMENSUAL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDepreciacionEmpresa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoDepreciacionEmpresa> entities = new  ArrayList<TipoDepreciacionEmpresa>();
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDepreciacionEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoDepreciacionEmpresa();
					entity=super.getEntity("",entity,resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoDepreciacionEmpresa("",entity,resultSet);
					
					//entity.setTipoDepreciacionEmpresaOriginal( new TipoDepreciacionEmpresa());
					//entity.setTipoDepreciacionEmpresaOriginal(super.getEntity("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoDepreciacionEmpresaOriginal(this.getEntityTipoDepreciacionEmpresa("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoDepreciacionEmpresas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDepreciacionEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDepreciacionEmpresa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoDepreciacionEmpresa> entities = new  ArrayList<TipoDepreciacionEmpresa>();
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDepreciacionEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDepreciacionEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoDepreciacionEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDepreciacionEmpresa> entities = new  ArrayList<TipoDepreciacionEmpresa>();
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		  
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
	
	public  List<TipoDepreciacionEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDepreciacionEmpresa> entities = new  ArrayList<TipoDepreciacionEmpresa>();
		TipoDepreciacionEmpresa entity = new TipoDepreciacionEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDepreciacionEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDepreciacionEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoDepreciacionEmpresaOriginal( new TipoDepreciacionEmpresa());
      	    	//entity.setTipoDepreciacionEmpresaOriginal(super.getEntity("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet,TipoDepreciacionEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDepreciacionEmpresaOriginal(this.getEntityTipoDepreciacionEmpresa("",entity.getTipoDepreciacionEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoDepreciacionEmpresas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDepreciacionEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoDepreciacionEmpresa getEntityTipoDepreciacionEmpresa(String strPrefijo,TipoDepreciacionEmpresa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDepreciacionEmpresaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoDepreciacionEmpresaConstantesFunciones.NOMBRE));
				entity.setes_linea_recta(resultSet.getBoolean(strPrefijo+TipoDepreciacionEmpresaConstantesFunciones.ESLINEARECTA));
				entity.setes_mensual(resultSet.getBoolean(strPrefijo+TipoDepreciacionEmpresaConstantesFunciones.ESMENSUAL));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDepreciacionEmpresaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoDepreciacionEmpresa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoDepreciacionEmpresa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoDepreciacionEmpresaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoDepreciacionEmpresaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoDepreciacionEmpresaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoDepreciacionEmpresaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoDepreciacionEmpresaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoDepreciacionEmpresaDataAccess.TABLENAME,TipoDepreciacionEmpresaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoDepreciacionEmpresaDataAccess.setTipoDepreciacionEmpresaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoDepreciacionEmpresa reltipodepreciacionempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipodepreciacionempresa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<DetalleActivoFijo> getDetalleActivoFijos(Connexion connexion,TipoDepreciacionEmpresa tipodepreciacionempresa)throws SQLException,Exception {

		List<DetalleActivoFijo> detalleactivofijos= new ArrayList<DetalleActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+".tipo_depreciacion_empresa ON "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id_tipo_depreciacion_empresa="+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+".tipo_depreciacion_empresa.id WHERE "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+".tipo_depreciacion_empresa.id="+String.valueOf(tipodepreciacionempresa.getId());
			} else {
				sQuery=" INNER JOIN detalleactivofijo.TipoDepreciacionEmpresa WHERE detalleactivofijo.TipoDepreciacionEmpresa.id="+String.valueOf(tipodepreciacionempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijos;

	}

	public List<DepreciacionActivoFijo> getDepreciacionActivoFijos(Connexion connexion,TipoDepreciacionEmpresa tipodepreciacionempresa)throws SQLException,Exception {

		List<DepreciacionActivoFijo> depreciacionactivofijos= new ArrayList<DepreciacionActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+".tipo_depreciacion_empresa ON "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+".depreciacion_activo_fijo.id_tipo_depreciacion_empresa="+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+".tipo_depreciacion_empresa.id WHERE "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+".tipo_depreciacion_empresa.id="+String.valueOf(tipodepreciacionempresa.getId());
			} else {
				sQuery=" INNER JOIN depreciacionactivofijo.TipoDepreciacionEmpresa WHERE depreciacionactivofijo.TipoDepreciacionEmpresa.id="+String.valueOf(tipodepreciacionempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DepreciacionActivoFijoDataAccess depreciacionactivofijoDataAccess=new DepreciacionActivoFijoDataAccess();

			depreciacionactivofijoDataAccess.setConnexionType(this.connexionType);
			depreciacionactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return depreciacionactivofijos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoDepreciacionEmpresa tipodepreciacionempresa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipodepreciacionempresa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipodepreciacionempresa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipodepreciacionempresa.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipodepreciacionempresa.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_linea_recta=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_linea_recta.setValue(tipodepreciacionempresa.getes_linea_recta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_linea_recta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_mensual=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_mensual.setValue(tipodepreciacionempresa.getes_mensual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_mensual);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipodepreciacionempresa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipodepreciacionempresa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipodepreciacionempresa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipodepreciacionempresa.getId());
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
	
	public void setIsNewIsChangedFalseTipoDepreciacionEmpresa(TipoDepreciacionEmpresa tipodepreciacionempresa)throws Exception  {		
		tipodepreciacionempresa.setIsNew(false);
		tipodepreciacionempresa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoDepreciacionEmpresas(List<TipoDepreciacionEmpresa> tipodepreciacionempresas)throws Exception  {				
		for(TipoDepreciacionEmpresa tipodepreciacionempresa:tipodepreciacionempresas) {
			tipodepreciacionempresa.setIsNew(false);
			tipodepreciacionempresa.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoDepreciacionEmpresa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
