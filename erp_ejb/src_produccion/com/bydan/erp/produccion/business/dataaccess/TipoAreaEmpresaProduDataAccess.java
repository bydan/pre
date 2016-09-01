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
import com.bydan.erp.produccion.util.*;//TipoAreaEmpresaProduConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoAreaEmpresaProduDataAccess extends  TipoAreaEmpresaProduDataAccessAdditional{ //TipoAreaEmpresaProduDataAccessAdditional,DataAccessHelper<TipoAreaEmpresaProdu>
	//static Logger logger = Logger.getLogger(TipoAreaEmpresaProduDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_area_empresa_produ";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,descripcion)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoareaempresaprodu from "+TipoAreaEmpresaProduConstantesFunciones.SPERSISTENCENAME+" tipoareaempresaprodu";
	public static String QUERYSELECTNATIVE="select "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".id,"+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".version_row,"+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".id_empresa,"+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".nombre,"+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".descripcion from "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME;//+" as "+TipoAreaEmpresaProduConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".id,"+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".version_row,"+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".nombre from "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME;//+" as "+TipoAreaEmpresaProduConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOAREAEMPRESAPRODU_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOAREAEMPRESAPRODU_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOAREAEMPRESAPRODU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOAREAEMPRESAPRODU_SELECT(?,?)";
	
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
	
	
	protected TipoAreaEmpresaProduDataAccessAdditional tipoareaempresaproduDataAccessAdditional=null;
	
	public TipoAreaEmpresaProduDataAccessAdditional getTipoAreaEmpresaProduDataAccessAdditional() {
		return this.tipoareaempresaproduDataAccessAdditional;
	}
	
	public void setTipoAreaEmpresaProduDataAccessAdditional(TipoAreaEmpresaProduDataAccessAdditional tipoareaempresaproduDataAccessAdditional) {
		try {
			this.tipoareaempresaproduDataAccessAdditional=tipoareaempresaproduDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoAreaEmpresaProduDataAccess() {
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
		TipoAreaEmpresaProduDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoAreaEmpresaProduDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoAreaEmpresaProduDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoAreaEmpresaProduOriginal(TipoAreaEmpresaProdu tipoareaempresaprodu)throws Exception  {
		tipoareaempresaprodu.setTipoAreaEmpresaProduOriginal((TipoAreaEmpresaProdu)tipoareaempresaprodu.clone());		
	}
	
	public void setTipoAreaEmpresaProdusOriginal(List<TipoAreaEmpresaProdu> tipoareaempresaprodus)throws Exception  {
		
		for(TipoAreaEmpresaProdu tipoareaempresaprodu:tipoareaempresaprodus){
			tipoareaempresaprodu.setTipoAreaEmpresaProduOriginal((TipoAreaEmpresaProdu)tipoareaempresaprodu.clone());
		}
	}
	
	public static void setTipoAreaEmpresaProduOriginalStatic(TipoAreaEmpresaProdu tipoareaempresaprodu)throws Exception  {
		tipoareaempresaprodu.setTipoAreaEmpresaProduOriginal((TipoAreaEmpresaProdu)tipoareaempresaprodu.clone());		
	}
	
	public static void setTipoAreaEmpresaProdusOriginalStatic(List<TipoAreaEmpresaProdu> tipoareaempresaprodus)throws Exception  {
		
		for(TipoAreaEmpresaProdu tipoareaempresaprodu:tipoareaempresaprodus){
			tipoareaempresaprodu.setTipoAreaEmpresaProduOriginal((TipoAreaEmpresaProdu)tipoareaempresaprodu.clone());
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
	
	public  TipoAreaEmpresaProdu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		
		
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
	
	public  TipoAreaEmpresaProdu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.TipoAreaEmpresaProdu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoAreaEmpresaProduOriginal(new TipoAreaEmpresaProdu());
      	    	entity=super.getEntity("",entity,resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoAreaEmpresaProdu("",entity,resultSet); 
				
				//entity.setTipoAreaEmpresaProduOriginal(super.getEntity("",entity.getTipoAreaEmpresaProduOriginal(),resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoAreaEmpresaProduOriginal(this.getEntityTipoAreaEmpresaProdu("",entity.getTipoAreaEmpresaProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoAreaEmpresaProdu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoAreaEmpresaProdu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();
				
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
	
	public  TipoAreaEmpresaProdu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoAreaEmpresaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoAreaEmpresaProdu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoAreaEmpresaProduOriginal(new TipoAreaEmpresaProdu());
      	    	entity=super.getEntity("",entity,resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoAreaEmpresaProdu("",entity,resultSet);    
				
				//entity.setTipoAreaEmpresaProduOriginal(super.getEntity("",entity.getTipoAreaEmpresaProduOriginal(),resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoAreaEmpresaProduOriginal(this.getEntityTipoAreaEmpresaProdu("",entity.getTipoAreaEmpresaProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoAreaEmpresaProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoAreaEmpresaProdu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoAreaEmpresaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoAreaEmpresaProdu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoAreaEmpresaProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoAreaEmpresaProdu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoAreaEmpresaProdu> entities = new  ArrayList<TipoAreaEmpresaProdu>();
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
		
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
	
	public  List<TipoAreaEmpresaProdu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoAreaEmpresaProdu> entities = new  ArrayList<TipoAreaEmpresaProdu>();
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoAreaEmpresaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoAreaEmpresaProdu();
      	    	entity=super.getEntity("",entity,resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoAreaEmpresaProdu("",entity,resultSet);
      	    	
				//entity.setTipoAreaEmpresaProduOriginal( new TipoAreaEmpresaProdu());
      	    	//entity.setTipoAreaEmpresaProduOriginal(super.getEntity("",entity.getTipoAreaEmpresaProduOriginal(),resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoAreaEmpresaProduOriginal(this.getEntityTipoAreaEmpresaProdu("",entity.getTipoAreaEmpresaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoAreaEmpresaProdus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoAreaEmpresaProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoAreaEmpresaProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoAreaEmpresaProdu> entities = new  ArrayList<TipoAreaEmpresaProdu>();
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
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
	
	public  List<TipoAreaEmpresaProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoAreaEmpresaProdu> entities = new  ArrayList<TipoAreaEmpresaProdu>();
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoAreaEmpresaProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoAreaEmpresaProdu();
					//entity.setMapTipoAreaEmpresaProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoAreaEmpresaProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoAreaEmpresaProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA);         		
					entity=TipoAreaEmpresaProduDataAccess.getEntityTipoAreaEmpresaProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoAreaEmpresaProduOriginal( new TipoAreaEmpresaProdu());
					////entity.setTipoAreaEmpresaProduOriginal(super.getEntity("",entity.getTipoAreaEmpresaProduOriginal(),resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoAreaEmpresaProduOriginal(this.getEntityTipoAreaEmpresaProdu("",entity.getTipoAreaEmpresaProduOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoAreaEmpresaProdus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoAreaEmpresaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoAreaEmpresaProdu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
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
	
	public  TipoAreaEmpresaProdu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoAreaEmpresaProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoAreaEmpresaProdu();
					//entity.setMapTipoAreaEmpresaProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoAreaEmpresaProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoAreaEmpresaProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA);         		
					entity=TipoAreaEmpresaProduDataAccess.getEntityTipoAreaEmpresaProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoAreaEmpresaProduOriginal( new TipoAreaEmpresaProdu());
					////entity.setTipoAreaEmpresaProduOriginal(super.getEntity("",entity.getTipoAreaEmpresaProduOriginal(),resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoAreaEmpresaProduOriginal(this.getEntityTipoAreaEmpresaProdu("",entity.getTipoAreaEmpresaProduOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoAreaEmpresaProdu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoAreaEmpresaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoAreaEmpresaProdu getEntityTipoAreaEmpresaProdu(String strPrefijo,TipoAreaEmpresaProdu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoAreaEmpresaProdu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoAreaEmpresaProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoAreaEmpresaProduDataAccess.setFieldReflectionTipoAreaEmpresaProdu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoAreaEmpresaProdu=TipoAreaEmpresaProduConstantesFunciones.getTodosTiposColumnasTipoAreaEmpresaProdu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoAreaEmpresaProdu) {
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
							field = TipoAreaEmpresaProdu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoAreaEmpresaProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoAreaEmpresaProduDataAccess.setFieldReflectionTipoAreaEmpresaProdu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoAreaEmpresaProdu(Field field,String strPrefijo,String sColumn,TipoAreaEmpresaProdu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoAreaEmpresaProduConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoAreaEmpresaProduConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoAreaEmpresaProduConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoAreaEmpresaProduConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoAreaEmpresaProdu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoAreaEmpresaProdu> entities = new  ArrayList<TipoAreaEmpresaProdu>();
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoAreaEmpresaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoAreaEmpresaProdu();
					entity=super.getEntity("",entity,resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoAreaEmpresaProdu("",entity,resultSet);
					
					//entity.setTipoAreaEmpresaProduOriginal( new TipoAreaEmpresaProdu());
					//entity.setTipoAreaEmpresaProduOriginal(super.getEntity("",entity.getTipoAreaEmpresaProduOriginal(),resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoAreaEmpresaProduOriginal(this.getEntityTipoAreaEmpresaProdu("",entity.getTipoAreaEmpresaProduOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoAreaEmpresaProdus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoAreaEmpresaProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoAreaEmpresaProdu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoAreaEmpresaProdu> entities = new  ArrayList<TipoAreaEmpresaProdu>();
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoAreaEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoAreaEmpresaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoAreaEmpresaProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoAreaEmpresaProdu> entities = new  ArrayList<TipoAreaEmpresaProdu>();
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
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
	
	public  List<TipoAreaEmpresaProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoAreaEmpresaProdu> entities = new  ArrayList<TipoAreaEmpresaProdu>();
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoAreaEmpresaProdu();
      	    	entity=super.getEntity("",entity,resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoAreaEmpresaProdu("",entity,resultSet);
      	    	
				//entity.setTipoAreaEmpresaProduOriginal( new TipoAreaEmpresaProdu());
      	    	//entity.setTipoAreaEmpresaProduOriginal(super.getEntity("",entity.getTipoAreaEmpresaProduOriginal(),resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoAreaEmpresaProduOriginal(this.getEntityTipoAreaEmpresaProdu("",entity.getTipoAreaEmpresaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoAreaEmpresaProdus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoAreaEmpresaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoAreaEmpresaProdu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoAreaEmpresaProdu> entities = new  ArrayList<TipoAreaEmpresaProdu>();
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
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
	
	public  List<TipoAreaEmpresaProdu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoAreaEmpresaProdu> entities = new  ArrayList<TipoAreaEmpresaProdu>();
		TipoAreaEmpresaProdu entity = new TipoAreaEmpresaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoAreaEmpresaProdu();
      	    	entity=super.getEntity("",entity,resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoAreaEmpresaProdu("",entity,resultSet);
      	    	
				//entity.setTipoAreaEmpresaProduOriginal( new TipoAreaEmpresaProdu());
      	    	//entity.setTipoAreaEmpresaProduOriginal(super.getEntity("",entity.getTipoAreaEmpresaProduOriginal(),resultSet,TipoAreaEmpresaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoAreaEmpresaProduOriginal(this.getEntityTipoAreaEmpresaProdu("",entity.getTipoAreaEmpresaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoAreaEmpresaProdus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoAreaEmpresaProdu getEntityTipoAreaEmpresaProdu(String strPrefijo,TipoAreaEmpresaProdu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+TipoAreaEmpresaProduConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoAreaEmpresaProduConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoAreaEmpresaProduConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoAreaEmpresaProdu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoAreaEmpresaProdu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoAreaEmpresaProduDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoAreaEmpresaProduDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoAreaEmpresaProduDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoAreaEmpresaProduDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoAreaEmpresaProduConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoAreaEmpresaProduDataAccess.TABLENAME,TipoAreaEmpresaProduDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoAreaEmpresaProduDataAccess.setTipoAreaEmpresaProduOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoAreaEmpresaProdu reltipoareaempresaprodu)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoareaempresaprodu.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<ProductoOrdenDetaProduMaquina> getProductoOrdenDetaProduMaquinas(Connexion connexion,TipoAreaEmpresaProdu tipoareaempresaprodu)throws SQLException,Exception {

		List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas= new ArrayList<ProductoOrdenDetaProduMaquina>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+".tipo_area_empresa_produ ON "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+".producto_orden_deta_produ_maquina.id_tipo_area_empresa_produ="+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+".tipo_area_empresa_produ.id WHERE "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+".tipo_area_empresa_produ.id="+String.valueOf(tipoareaempresaprodu.getId());
			} else {
				sQuery=" INNER JOIN productoordendetaprodumaquina.TipoAreaEmpresaProdu WHERE productoordendetaprodumaquina.TipoAreaEmpresaProdu.id="+String.valueOf(tipoareaempresaprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoOrdenDetaProduMaquinaDataAccess productoordendetaprodumaquinaDataAccess=new ProductoOrdenDetaProduMaquinaDataAccess();

			productoordendetaprodumaquinaDataAccess.setConnexionType(this.connexionType);
			productoordendetaprodumaquinaDataAccess.setParameterDbType(this.parameterDbType);
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoordendetaprodumaquinas;

	}

	public List<ProductoProduMaquina> getProductoProduMaquinas(Connexion connexion,TipoAreaEmpresaProdu tipoareaempresaprodu)throws SQLException,Exception {

		List<ProductoProduMaquina> productoprodumaquinas= new ArrayList<ProductoProduMaquina>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+".tipo_area_empresa_produ ON "+ProductoProduMaquinaConstantesFunciones.SCHEMA+".producto_produ_maquina.id_tipo_area_empresa_produ="+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+".tipo_area_empresa_produ.id WHERE "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+".tipo_area_empresa_produ.id="+String.valueOf(tipoareaempresaprodu.getId());
			} else {
				sQuery=" INNER JOIN productoprodumaquina.TipoAreaEmpresaProdu WHERE productoprodumaquina.TipoAreaEmpresaProdu.id="+String.valueOf(tipoareaempresaprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProduMaquinaDataAccess productoprodumaquinaDataAccess=new ProductoProduMaquinaDataAccess();

			productoprodumaquinaDataAccess.setConnexionType(this.connexionType);
			productoprodumaquinaDataAccess.setParameterDbType(this.parameterDbType);
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoprodumaquinas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoAreaEmpresaProdu tipoareaempresaprodu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoareaempresaprodu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoareaempresaprodu.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoareaempresaprodu.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipoareaempresaprodu.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoareaempresaprodu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoareaempresaprodu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoareaempresaprodu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoareaempresaprodu.getId());
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
	
	public void setIsNewIsChangedFalseTipoAreaEmpresaProdu(TipoAreaEmpresaProdu tipoareaempresaprodu)throws Exception  {		
		tipoareaempresaprodu.setIsNew(false);
		tipoareaempresaprodu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoAreaEmpresaProdus(List<TipoAreaEmpresaProdu> tipoareaempresaprodus)throws Exception  {				
		for(TipoAreaEmpresaProdu tipoareaempresaprodu:tipoareaempresaprodus) {
			tipoareaempresaprodu.setIsNew(false);
			tipoareaempresaprodu.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoAreaEmpresaProdu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
