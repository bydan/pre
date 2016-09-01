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
import com.bydan.erp.contabilidad.util.*;//TipoDetalleDocumentoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoDetalleDocumentoDataAccess extends  TipoDetalleDocumentoDataAccessAdditional{ //TipoDetalleDocumentoDataAccessAdditional,DataAccessHelper<TipoDetalleDocumento>
	//static Logger logger = Logger.getLogger(TipoDetalleDocumentoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_detalle_documento";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipodetalledocumento from "+TipoDetalleDocumentoConstantesFunciones.SPERSISTENCENAME+" tipodetalledocumento";
	public static String QUERYSELECTNATIVE="select "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".id,"+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".version_row,"+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".id_empresa,"+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".codigo,"+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".nombre from "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME;//+" as "+TipoDetalleDocumentoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".id,"+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".version_row,"+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+".codigo from "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME;//+" as "+TipoDetalleDocumentoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+"."+TipoDetalleDocumentoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPODETALLEDOCUMENTO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPODETALLEDOCUMENTO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPODETALLEDOCUMENTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPODETALLEDOCUMENTO_SELECT(?,?)";
	
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
	
	
	protected TipoDetalleDocumentoDataAccessAdditional tipodetalledocumentoDataAccessAdditional=null;
	
	public TipoDetalleDocumentoDataAccessAdditional getTipoDetalleDocumentoDataAccessAdditional() {
		return this.tipodetalledocumentoDataAccessAdditional;
	}
	
	public void setTipoDetalleDocumentoDataAccessAdditional(TipoDetalleDocumentoDataAccessAdditional tipodetalledocumentoDataAccessAdditional) {
		try {
			this.tipodetalledocumentoDataAccessAdditional=tipodetalledocumentoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoDetalleDocumentoDataAccess() {
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
		TipoDetalleDocumentoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoDetalleDocumentoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoDetalleDocumentoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoDetalleDocumentoOriginal(TipoDetalleDocumento tipodetalledocumento)throws Exception  {
		tipodetalledocumento.setTipoDetalleDocumentoOriginal((TipoDetalleDocumento)tipodetalledocumento.clone());		
	}
	
	public void setTipoDetalleDocumentosOriginal(List<TipoDetalleDocumento> tipodetalledocumentos)throws Exception  {
		
		for(TipoDetalleDocumento tipodetalledocumento:tipodetalledocumentos){
			tipodetalledocumento.setTipoDetalleDocumentoOriginal((TipoDetalleDocumento)tipodetalledocumento.clone());
		}
	}
	
	public static void setTipoDetalleDocumentoOriginalStatic(TipoDetalleDocumento tipodetalledocumento)throws Exception  {
		tipodetalledocumento.setTipoDetalleDocumentoOriginal((TipoDetalleDocumento)tipodetalledocumento.clone());		
	}
	
	public static void setTipoDetalleDocumentosOriginalStatic(List<TipoDetalleDocumento> tipodetalledocumentos)throws Exception  {
		
		for(TipoDetalleDocumento tipodetalledocumento:tipodetalledocumentos){
			tipodetalledocumento.setTipoDetalleDocumentoOriginal((TipoDetalleDocumento)tipodetalledocumento.clone());
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
	
	public  TipoDetalleDocumento getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		
		
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
	
	public  TipoDetalleDocumento getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoDetalleDocumento.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoDetalleDocumentoOriginal(new TipoDetalleDocumento());
      	    	entity=super.getEntity("",entity,resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDetalleDocumento("",entity,resultSet); 
				
				//entity.setTipoDetalleDocumentoOriginal(super.getEntity("",entity.getTipoDetalleDocumentoOriginal(),resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetalleDocumentoOriginal(this.getEntityTipoDetalleDocumento("",entity.getTipoDetalleDocumentoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDetalleDocumento(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoDetalleDocumento getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDetalleDocumento entity = new TipoDetalleDocumento();
				
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
	
	public  TipoDetalleDocumento getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDetalleDocumento entity = new TipoDetalleDocumento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetalleDocumentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoDetalleDocumento.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoDetalleDocumentoOriginal(new TipoDetalleDocumento());
      	    	entity=super.getEntity("",entity,resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDetalleDocumento("",entity,resultSet);    
				
				//entity.setTipoDetalleDocumentoOriginal(super.getEntity("",entity.getTipoDetalleDocumentoOriginal(),resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetalleDocumentoOriginal(this.getEntityTipoDetalleDocumento("",entity.getTipoDetalleDocumentoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDetalleDocumento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoDetalleDocumento
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoDetalleDocumento entity = new TipoDetalleDocumento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetalleDocumentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoDetalleDocumento.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoDetalleDocumento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoDetalleDocumento> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDetalleDocumento> entities = new  ArrayList<TipoDetalleDocumento>();
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
		
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
	
	public  List<TipoDetalleDocumento> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDetalleDocumento> entities = new  ArrayList<TipoDetalleDocumento>();
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetalleDocumentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetalleDocumento();
      	    	entity=super.getEntity("",entity,resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDetalleDocumento("",entity,resultSet);
      	    	
				//entity.setTipoDetalleDocumentoOriginal( new TipoDetalleDocumento());
      	    	//entity.setTipoDetalleDocumentoOriginal(super.getEntity("",entity.getTipoDetalleDocumentoOriginal(),resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetalleDocumentoOriginal(this.getEntityTipoDetalleDocumento("",entity.getTipoDetalleDocumentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDetalleDocumentos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetalleDocumento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDetalleDocumento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDetalleDocumento> entities = new  ArrayList<TipoDetalleDocumento>();
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
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
	
	public  List<TipoDetalleDocumento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDetalleDocumento> entities = new  ArrayList<TipoDetalleDocumento>();
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetalleDocumento();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDetalleDocumento();
					//entity.setMapTipoDetalleDocumento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoDetalleDocumentoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDetalleDocumento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA);         		
					entity=TipoDetalleDocumentoDataAccess.getEntityTipoDetalleDocumento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDetalleDocumentoOriginal( new TipoDetalleDocumento());
					////entity.setTipoDetalleDocumentoOriginal(super.getEntity("",entity.getTipoDetalleDocumentoOriginal(),resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDetalleDocumentoOriginal(this.getEntityTipoDetalleDocumento("",entity.getTipoDetalleDocumentoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDetalleDocumentos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetalleDocumento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoDetalleDocumento getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
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
	
	public  TipoDetalleDocumento getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetalleDocumento();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDetalleDocumento();
					//entity.setMapTipoDetalleDocumento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoDetalleDocumentoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDetalleDocumento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA);         		
					entity=TipoDetalleDocumentoDataAccess.getEntityTipoDetalleDocumento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDetalleDocumentoOriginal( new TipoDetalleDocumento());
					////entity.setTipoDetalleDocumentoOriginal(super.getEntity("",entity.getTipoDetalleDocumentoOriginal(),resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDetalleDocumentoOriginal(this.getEntityTipoDetalleDocumento("",entity.getTipoDetalleDocumentoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoDetalleDocumento(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetalleDocumento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoDetalleDocumento getEntityTipoDetalleDocumento(String strPrefijo,TipoDetalleDocumento entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoDetalleDocumento.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoDetalleDocumento.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoDetalleDocumentoDataAccess.setFieldReflectionTipoDetalleDocumento(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoDetalleDocumento=TipoDetalleDocumentoConstantesFunciones.getTodosTiposColumnasTipoDetalleDocumento();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoDetalleDocumento) {
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
							field = TipoDetalleDocumento.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoDetalleDocumento.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoDetalleDocumentoDataAccess.setFieldReflectionTipoDetalleDocumento(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoDetalleDocumento(Field field,String strPrefijo,String sColumn,TipoDetalleDocumento entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoDetalleDocumentoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDetalleDocumentoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDetalleDocumentoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDetalleDocumentoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDetalleDocumentoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDetalleDocumento>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoDetalleDocumento> entities = new  ArrayList<TipoDetalleDocumento>();
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetalleDocumentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoDetalleDocumento();
					entity=super.getEntity("",entity,resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoDetalleDocumento("",entity,resultSet);
					
					//entity.setTipoDetalleDocumentoOriginal( new TipoDetalleDocumento());
					//entity.setTipoDetalleDocumentoOriginal(super.getEntity("",entity.getTipoDetalleDocumentoOriginal(),resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoDetalleDocumentoOriginal(this.getEntityTipoDetalleDocumento("",entity.getTipoDetalleDocumentoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoDetalleDocumentos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetalleDocumento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDetalleDocumento>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoDetalleDocumento> entities = new  ArrayList<TipoDetalleDocumento>();
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDetalleDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetalleDocumentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoDetalleDocumento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDetalleDocumento> entities = new  ArrayList<TipoDetalleDocumento>();
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
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
	
	public  List<TipoDetalleDocumento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDetalleDocumento> entities = new  ArrayList<TipoDetalleDocumento>();
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetalleDocumento();
      	    	entity=super.getEntity("",entity,resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDetalleDocumento("",entity,resultSet);
      	    	
				//entity.setTipoDetalleDocumentoOriginal( new TipoDetalleDocumento());
      	    	//entity.setTipoDetalleDocumentoOriginal(super.getEntity("",entity.getTipoDetalleDocumentoOriginal(),resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetalleDocumentoOriginal(this.getEntityTipoDetalleDocumento("",entity.getTipoDetalleDocumentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoDetalleDocumentos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetalleDocumento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDetalleDocumento> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDetalleDocumento> entities = new  ArrayList<TipoDetalleDocumento>();
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
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
	
	public  List<TipoDetalleDocumento> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDetalleDocumento> entities = new  ArrayList<TipoDetalleDocumento>();
		TipoDetalleDocumento entity = new TipoDetalleDocumento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetalleDocumento();
      	    	entity=super.getEntity("",entity,resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDetalleDocumento("",entity,resultSet);
      	    	
				//entity.setTipoDetalleDocumentoOriginal( new TipoDetalleDocumento());
      	    	//entity.setTipoDetalleDocumentoOriginal(super.getEntity("",entity.getTipoDetalleDocumentoOriginal(),resultSet,TipoDetalleDocumentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetalleDocumentoOriginal(this.getEntityTipoDetalleDocumento("",entity.getTipoDetalleDocumentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDetalleDocumentos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoDetalleDocumento getEntityTipoDetalleDocumento(String strPrefijo,TipoDetalleDocumento entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoDetalleDocumentoConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDetalleDocumentoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoDetalleDocumentoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDetalleDocumentoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoDetalleDocumento(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoDetalleDocumento entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoDetalleDocumentoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoDetalleDocumentoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoDetalleDocumentoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoDetalleDocumentoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoDetalleDocumentoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoDetalleDocumentoDataAccess.TABLENAME,TipoDetalleDocumentoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoDetalleDocumentoDataAccess.setTipoDetalleDocumentoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoDetalleDocumento reltipodetalledocumento)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipodetalledocumento.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<DetalleDocumento> getDetalleDocumentos(Connexion connexion,TipoDetalleDocumento tipodetalledocumento)throws SQLException,Exception {

		List<DetalleDocumento> detalledocumentos= new ArrayList<DetalleDocumento>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+".tipo_detalle_documento ON "+DetalleDocumentoConstantesFunciones.SCHEMA+".detalle_documento.id_tipo_detalle_documento="+TipoDetalleDocumentoConstantesFunciones.SCHEMA+".tipo_detalle_documento.id WHERE "+TipoDetalleDocumentoConstantesFunciones.SCHEMA+".tipo_detalle_documento.id="+String.valueOf(tipodetalledocumento.getId());
			} else {
				sQuery=" INNER JOIN detalledocumento.TipoDetalleDocumento WHERE detalledocumento.TipoDetalleDocumento.id="+String.valueOf(tipodetalledocumento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleDocumentoDataAccess detalledocumentoDataAccess=new DetalleDocumentoDataAccess();

			detalledocumentoDataAccess.setConnexionType(this.connexionType);
			detalledocumentoDataAccess.setParameterDbType(this.parameterDbType);
			detalledocumentos=detalledocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalledocumentos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoDetalleDocumento tipodetalledocumento) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipodetalledocumento.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipodetalledocumento.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipodetalledocumento.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipodetalledocumento.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipodetalledocumento.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipodetalledocumento.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipodetalledocumento.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipodetalledocumento.getId());
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
	
	public void setIsNewIsChangedFalseTipoDetalleDocumento(TipoDetalleDocumento tipodetalledocumento)throws Exception  {		
		tipodetalledocumento.setIsNew(false);
		tipodetalledocumento.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoDetalleDocumentos(List<TipoDetalleDocumento> tipodetalledocumentos)throws Exception  {				
		for(TipoDetalleDocumento tipodetalledocumento:tipodetalledocumentos) {
			tipodetalledocumento.setIsNew(false);
			tipodetalledocumento.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoDetalleDocumento(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
