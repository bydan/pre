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
import com.bydan.erp.produccion.util.*;//TipoManoProduEmpresaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoManoProduEmpresaDataAccess extends  TipoManoProduEmpresaDataAccessAdditional{ //TipoManoProduEmpresaDataAccessAdditional,DataAccessHelper<TipoManoProduEmpresa>
	//static Logger logger = Logger.getLogger(TipoManoProduEmpresaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_mano_produ_empresa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,descripcion)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipomanoproduempresa from "+TipoManoProduEmpresaConstantesFunciones.SPERSISTENCENAME+" tipomanoproduempresa";
	public static String QUERYSELECTNATIVE="select "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".id,"+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".descripcion from "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoManoProduEmpresaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".id,"+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+".nombre from "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoManoProduEmpresaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoManoProduEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOMANOPRODUEMPRESA_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOMANOPRODUEMPRESA_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOMANOPRODUEMPRESA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOMANOPRODUEMPRESA_SELECT(?,?)";
	
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
	
	
	protected TipoManoProduEmpresaDataAccessAdditional tipomanoproduempresaDataAccessAdditional=null;
	
	public TipoManoProduEmpresaDataAccessAdditional getTipoManoProduEmpresaDataAccessAdditional() {
		return this.tipomanoproduempresaDataAccessAdditional;
	}
	
	public void setTipoManoProduEmpresaDataAccessAdditional(TipoManoProduEmpresaDataAccessAdditional tipomanoproduempresaDataAccessAdditional) {
		try {
			this.tipomanoproduempresaDataAccessAdditional=tipomanoproduempresaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoManoProduEmpresaDataAccess() {
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
		TipoManoProduEmpresaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoManoProduEmpresaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoManoProduEmpresaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoManoProduEmpresaOriginal(TipoManoProduEmpresa tipomanoproduempresa)throws Exception  {
		tipomanoproduempresa.setTipoManoProduEmpresaOriginal((TipoManoProduEmpresa)tipomanoproduempresa.clone());		
	}
	
	public void setTipoManoProduEmpresasOriginal(List<TipoManoProduEmpresa> tipomanoproduempresas)throws Exception  {
		
		for(TipoManoProduEmpresa tipomanoproduempresa:tipomanoproduempresas){
			tipomanoproduempresa.setTipoManoProduEmpresaOriginal((TipoManoProduEmpresa)tipomanoproduempresa.clone());
		}
	}
	
	public static void setTipoManoProduEmpresaOriginalStatic(TipoManoProduEmpresa tipomanoproduempresa)throws Exception  {
		tipomanoproduempresa.setTipoManoProduEmpresaOriginal((TipoManoProduEmpresa)tipomanoproduempresa.clone());		
	}
	
	public static void setTipoManoProduEmpresasOriginalStatic(List<TipoManoProduEmpresa> tipomanoproduempresas)throws Exception  {
		
		for(TipoManoProduEmpresa tipomanoproduempresa:tipomanoproduempresas){
			tipomanoproduempresa.setTipoManoProduEmpresaOriginal((TipoManoProduEmpresa)tipomanoproduempresa.clone());
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
	
	public  TipoManoProduEmpresa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		
		
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
	
	public  TipoManoProduEmpresa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.TipoManoProduEmpresa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoManoProduEmpresaOriginal(new TipoManoProduEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoManoProduEmpresa("",entity,resultSet); 
				
				//entity.setTipoManoProduEmpresaOriginal(super.getEntity("",entity.getTipoManoProduEmpresaOriginal(),resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoManoProduEmpresaOriginal(this.getEntityTipoManoProduEmpresa("",entity.getTipoManoProduEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoManoProduEmpresa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoManoProduEmpresa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();
				
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
	
	public  TipoManoProduEmpresa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoManoProduEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoManoProduEmpresa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoManoProduEmpresaOriginal(new TipoManoProduEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoManoProduEmpresa("",entity,resultSet);    
				
				//entity.setTipoManoProduEmpresaOriginal(super.getEntity("",entity.getTipoManoProduEmpresaOriginal(),resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoManoProduEmpresaOriginal(this.getEntityTipoManoProduEmpresa("",entity.getTipoManoProduEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoManoProduEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoManoProduEmpresa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoManoProduEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoManoProduEmpresa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoManoProduEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoManoProduEmpresa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoManoProduEmpresa> entities = new  ArrayList<TipoManoProduEmpresa>();
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
		
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
	
	public  List<TipoManoProduEmpresa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoManoProduEmpresa> entities = new  ArrayList<TipoManoProduEmpresa>();
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoManoProduEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoManoProduEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoManoProduEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoManoProduEmpresaOriginal( new TipoManoProduEmpresa());
      	    	//entity.setTipoManoProduEmpresaOriginal(super.getEntity("",entity.getTipoManoProduEmpresaOriginal(),resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoManoProduEmpresaOriginal(this.getEntityTipoManoProduEmpresa("",entity.getTipoManoProduEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoManoProduEmpresas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoManoProduEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoManoProduEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoManoProduEmpresa> entities = new  ArrayList<TipoManoProduEmpresa>();
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
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
	
	public  List<TipoManoProduEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoManoProduEmpresa> entities = new  ArrayList<TipoManoProduEmpresa>();
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoManoProduEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoManoProduEmpresa();
					//entity.setMapTipoManoProduEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoManoProduEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoManoProduEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoManoProduEmpresaDataAccess.getEntityTipoManoProduEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoManoProduEmpresaOriginal( new TipoManoProduEmpresa());
					////entity.setTipoManoProduEmpresaOriginal(super.getEntity("",entity.getTipoManoProduEmpresaOriginal(),resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoManoProduEmpresaOriginal(this.getEntityTipoManoProduEmpresa("",entity.getTipoManoProduEmpresaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoManoProduEmpresas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoManoProduEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoManoProduEmpresa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
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
	
	public  TipoManoProduEmpresa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoManoProduEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoManoProduEmpresa();
					//entity.setMapTipoManoProduEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoManoProduEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoManoProduEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoManoProduEmpresaDataAccess.getEntityTipoManoProduEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoManoProduEmpresaOriginal( new TipoManoProduEmpresa());
					////entity.setTipoManoProduEmpresaOriginal(super.getEntity("",entity.getTipoManoProduEmpresaOriginal(),resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoManoProduEmpresaOriginal(this.getEntityTipoManoProduEmpresa("",entity.getTipoManoProduEmpresaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoManoProduEmpresa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoManoProduEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoManoProduEmpresa getEntityTipoManoProduEmpresa(String strPrefijo,TipoManoProduEmpresa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoManoProduEmpresa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoManoProduEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoManoProduEmpresaDataAccess.setFieldReflectionTipoManoProduEmpresa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoManoProduEmpresa=TipoManoProduEmpresaConstantesFunciones.getTodosTiposColumnasTipoManoProduEmpresa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoManoProduEmpresa) {
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
							field = TipoManoProduEmpresa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoManoProduEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoManoProduEmpresaDataAccess.setFieldReflectionTipoManoProduEmpresa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoManoProduEmpresa(Field field,String strPrefijo,String sColumn,TipoManoProduEmpresa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoManoProduEmpresaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoManoProduEmpresaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoManoProduEmpresaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoManoProduEmpresaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoManoProduEmpresaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoManoProduEmpresa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoManoProduEmpresa> entities = new  ArrayList<TipoManoProduEmpresa>();
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoManoProduEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoManoProduEmpresa();
					entity=super.getEntity("",entity,resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoManoProduEmpresa("",entity,resultSet);
					
					//entity.setTipoManoProduEmpresaOriginal( new TipoManoProduEmpresa());
					//entity.setTipoManoProduEmpresaOriginal(super.getEntity("",entity.getTipoManoProduEmpresaOriginal(),resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoManoProduEmpresaOriginal(this.getEntityTipoManoProduEmpresa("",entity.getTipoManoProduEmpresaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoManoProduEmpresas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoManoProduEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoManoProduEmpresa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoManoProduEmpresa> entities = new  ArrayList<TipoManoProduEmpresa>();
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoManoProduEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoManoProduEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoManoProduEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoManoProduEmpresa> entities = new  ArrayList<TipoManoProduEmpresa>();
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
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
	
	public  List<TipoManoProduEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoManoProduEmpresa> entities = new  ArrayList<TipoManoProduEmpresa>();
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoManoProduEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoManoProduEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoManoProduEmpresaOriginal( new TipoManoProduEmpresa());
      	    	//entity.setTipoManoProduEmpresaOriginal(super.getEntity("",entity.getTipoManoProduEmpresaOriginal(),resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoManoProduEmpresaOriginal(this.getEntityTipoManoProduEmpresa("",entity.getTipoManoProduEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoManoProduEmpresas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoManoProduEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoManoProduEmpresa> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoManoProduEmpresa> entities = new  ArrayList<TipoManoProduEmpresa>();
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
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
	
	public  List<TipoManoProduEmpresa> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoManoProduEmpresa> entities = new  ArrayList<TipoManoProduEmpresa>();
		TipoManoProduEmpresa entity = new TipoManoProduEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoManoProduEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoManoProduEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoManoProduEmpresaOriginal( new TipoManoProduEmpresa());
      	    	//entity.setTipoManoProduEmpresaOriginal(super.getEntity("",entity.getTipoManoProduEmpresaOriginal(),resultSet,TipoManoProduEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoManoProduEmpresaOriginal(this.getEntityTipoManoProduEmpresa("",entity.getTipoManoProduEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoManoProduEmpresas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoManoProduEmpresa getEntityTipoManoProduEmpresa(String strPrefijo,TipoManoProduEmpresa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoManoProduEmpresaConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+TipoManoProduEmpresaConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoManoProduEmpresaConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoManoProduEmpresaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoManoProduEmpresa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoManoProduEmpresa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoManoProduEmpresaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoManoProduEmpresaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoManoProduEmpresaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoManoProduEmpresaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoManoProduEmpresaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoManoProduEmpresaDataAccess.TABLENAME,TipoManoProduEmpresaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoManoProduEmpresaDataAccess.setTipoManoProduEmpresaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoManoProduEmpresa reltipomanoproduempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipomanoproduempresa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<ProductoProduMano> getProductoProduManos(Connexion connexion,TipoManoProduEmpresa tipomanoproduempresa)throws SQLException,Exception {

		List<ProductoProduMano> productoprodumanos= new ArrayList<ProductoProduMano>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+".tipo_mano_produ_empresa ON "+ProductoProduManoConstantesFunciones.SCHEMA+".producto_produ_mano.id_tipo_mano_produ_empresa="+TipoManoProduEmpresaConstantesFunciones.SCHEMA+".tipo_mano_produ_empresa.id WHERE "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+".tipo_mano_produ_empresa.id="+String.valueOf(tipomanoproduempresa.getId());
			} else {
				sQuery=" INNER JOIN productoprodumano.TipoManoProduEmpresa WHERE productoprodumano.TipoManoProduEmpresa.id="+String.valueOf(tipomanoproduempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProduManoDataAccess productoprodumanoDataAccess=new ProductoProduManoDataAccess();

			productoprodumanoDataAccess.setConnexionType(this.connexionType);
			productoprodumanoDataAccess.setParameterDbType(this.parameterDbType);
			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoprodumanos;

	}

	public List<ProductoOrdenDetaProduMano> getProductoOrdenDetaProduManos(Connexion connexion,TipoManoProduEmpresa tipomanoproduempresa)throws SQLException,Exception {

		List<ProductoOrdenDetaProduMano> productoordendetaprodumanos= new ArrayList<ProductoOrdenDetaProduMano>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+".tipo_mano_produ_empresa ON "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+".producto_orden_deta_produ_mano.id_tipo_mano_produ_empresa="+TipoManoProduEmpresaConstantesFunciones.SCHEMA+".tipo_mano_produ_empresa.id WHERE "+TipoManoProduEmpresaConstantesFunciones.SCHEMA+".tipo_mano_produ_empresa.id="+String.valueOf(tipomanoproduempresa.getId());
			} else {
				sQuery=" INNER JOIN productoordendetaprodumano.TipoManoProduEmpresa WHERE productoordendetaprodumano.TipoManoProduEmpresa.id="+String.valueOf(tipomanoproduempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoOrdenDetaProduManoDataAccess productoordendetaprodumanoDataAccess=new ProductoOrdenDetaProduManoDataAccess();

			productoordendetaprodumanoDataAccess.setConnexionType(this.connexionType);
			productoordendetaprodumanoDataAccess.setParameterDbType(this.parameterDbType);
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoordendetaprodumanos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoManoProduEmpresa tipomanoproduempresa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipomanoproduempresa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipomanoproduempresa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipomanoproduempresa.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipomanoproduempresa.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipomanoproduempresa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipomanoproduempresa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipomanoproduempresa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipomanoproduempresa.getId());
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
	
	public void setIsNewIsChangedFalseTipoManoProduEmpresa(TipoManoProduEmpresa tipomanoproduempresa)throws Exception  {		
		tipomanoproduempresa.setIsNew(false);
		tipomanoproduempresa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoManoProduEmpresas(List<TipoManoProduEmpresa> tipomanoproduempresas)throws Exception  {				
		for(TipoManoProduEmpresa tipomanoproduempresa:tipomanoproduempresas) {
			tipomanoproduempresa.setIsNew(false);
			tipomanoproduempresa.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoManoProduEmpresa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
