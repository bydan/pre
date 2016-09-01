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
import com.bydan.erp.facturacion.util.*;//TipoDocumentoGeneralConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoDocumentoGeneralDataAccess extends  TipoDocumentoGeneralDataAccessAdditional{ //TipoDocumentoGeneralDataAccessAdditional,DataAccessHelper<TipoDocumentoGeneral>
	//static Logger logger = Logger.getLogger(TipoDocumentoGeneralDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_documento_general";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipodocumentogeneral from "+TipoDocumentoGeneralConstantesFunciones.SPERSISTENCENAME+" tipodocumentogeneral";
	public static String QUERYSELECTNATIVE="select "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+".id,"+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+".version_row,"+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+".codigo,"+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+".nombre from "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME;//+" as "+TipoDocumentoGeneralConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+".id,"+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+".version_row,"+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+".codigo from "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME;//+" as "+TipoDocumentoGeneralConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+"."+TipoDocumentoGeneralConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPODOCUMENTOGENERAL_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPODOCUMENTOGENERAL_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPODOCUMENTOGENERAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPODOCUMENTOGENERAL_SELECT(?,?)";
	
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
	
	
	protected TipoDocumentoGeneralDataAccessAdditional tipodocumentogeneralDataAccessAdditional=null;
	
	public TipoDocumentoGeneralDataAccessAdditional getTipoDocumentoGeneralDataAccessAdditional() {
		return this.tipodocumentogeneralDataAccessAdditional;
	}
	
	public void setTipoDocumentoGeneralDataAccessAdditional(TipoDocumentoGeneralDataAccessAdditional tipodocumentogeneralDataAccessAdditional) {
		try {
			this.tipodocumentogeneralDataAccessAdditional=tipodocumentogeneralDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoDocumentoGeneralDataAccess() {
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
		TipoDocumentoGeneralDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoDocumentoGeneralDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoDocumentoGeneralDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoDocumentoGeneralOriginal(TipoDocumentoGeneral tipodocumentogeneral)throws Exception  {
		tipodocumentogeneral.setTipoDocumentoGeneralOriginal((TipoDocumentoGeneral)tipodocumentogeneral.clone());		
	}
	
	public void setTipoDocumentoGeneralsOriginal(List<TipoDocumentoGeneral> tipodocumentogenerals)throws Exception  {
		
		for(TipoDocumentoGeneral tipodocumentogeneral:tipodocumentogenerals){
			tipodocumentogeneral.setTipoDocumentoGeneralOriginal((TipoDocumentoGeneral)tipodocumentogeneral.clone());
		}
	}
	
	public static void setTipoDocumentoGeneralOriginalStatic(TipoDocumentoGeneral tipodocumentogeneral)throws Exception  {
		tipodocumentogeneral.setTipoDocumentoGeneralOriginal((TipoDocumentoGeneral)tipodocumentogeneral.clone());		
	}
	
	public static void setTipoDocumentoGeneralsOriginalStatic(List<TipoDocumentoGeneral> tipodocumentogenerals)throws Exception  {
		
		for(TipoDocumentoGeneral tipodocumentogeneral:tipodocumentogenerals){
			tipodocumentogeneral.setTipoDocumentoGeneralOriginal((TipoDocumentoGeneral)tipodocumentogeneral.clone());
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
	
	public  TipoDocumentoGeneral getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		
		
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
	
	public  TipoDocumentoGeneral getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoDocumentoGeneral.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoDocumentoGeneralOriginal(new TipoDocumentoGeneral());
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDocumentoGeneral("",entity,resultSet); 
				
				//entity.setTipoDocumentoGeneralOriginal(super.getEntity("",entity.getTipoDocumentoGeneralOriginal(),resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoGeneralOriginal(this.getEntityTipoDocumentoGeneral("",entity.getTipoDocumentoGeneralOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDocumentoGeneral(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoDocumentoGeneral getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();
				
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
	
	public  TipoDocumentoGeneral getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoDocumentoGeneral.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoDocumentoGeneralOriginal(new TipoDocumentoGeneral());
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDocumentoGeneral("",entity,resultSet);    
				
				//entity.setTipoDocumentoGeneralOriginal(super.getEntity("",entity.getTipoDocumentoGeneralOriginal(),resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoGeneralOriginal(this.getEntityTipoDocumentoGeneral("",entity.getTipoDocumentoGeneralOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDocumentoGeneral(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoDocumentoGeneral
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoDocumentoGeneral.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoDocumentoGeneral(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoDocumentoGeneral> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDocumentoGeneral> entities = new  ArrayList<TipoDocumentoGeneral>();
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
		
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
	
	public  List<TipoDocumentoGeneral> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDocumentoGeneral> entities = new  ArrayList<TipoDocumentoGeneral>();
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumentoGeneral();
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDocumentoGeneral("",entity,resultSet);
      	    	
				//entity.setTipoDocumentoGeneralOriginal( new TipoDocumentoGeneral());
      	    	//entity.setTipoDocumentoGeneralOriginal(super.getEntity("",entity.getTipoDocumentoGeneralOriginal(),resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoGeneralOriginal(this.getEntityTipoDocumentoGeneral("",entity.getTipoDocumentoGeneralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDocumentoGenerals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumentoGeneral(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDocumentoGeneral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDocumentoGeneral> entities = new  ArrayList<TipoDocumentoGeneral>();
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
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
	
	public  List<TipoDocumentoGeneral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDocumentoGeneral> entities = new  ArrayList<TipoDocumentoGeneral>();
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumentoGeneral();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDocumentoGeneral();
					//entity.setMapTipoDocumentoGeneral(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoDocumentoGeneralValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDocumentoGeneral().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA);         		
					entity=TipoDocumentoGeneralDataAccess.getEntityTipoDocumentoGeneral("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDocumentoGeneralOriginal( new TipoDocumentoGeneral());
					////entity.setTipoDocumentoGeneralOriginal(super.getEntity("",entity.getTipoDocumentoGeneralOriginal(),resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDocumentoGeneralOriginal(this.getEntityTipoDocumentoGeneral("",entity.getTipoDocumentoGeneralOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDocumentoGenerals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumentoGeneral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoDocumentoGeneral getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
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
	
	public  TipoDocumentoGeneral getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumentoGeneral();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDocumentoGeneral();
					//entity.setMapTipoDocumentoGeneral(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoDocumentoGeneralValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDocumentoGeneral().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA);         		
					entity=TipoDocumentoGeneralDataAccess.getEntityTipoDocumentoGeneral("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDocumentoGeneralOriginal( new TipoDocumentoGeneral());
					////entity.setTipoDocumentoGeneralOriginal(super.getEntity("",entity.getTipoDocumentoGeneralOriginal(),resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDocumentoGeneralOriginal(this.getEntityTipoDocumentoGeneral("",entity.getTipoDocumentoGeneralOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoDocumentoGeneral(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumentoGeneral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoDocumentoGeneral getEntityTipoDocumentoGeneral(String strPrefijo,TipoDocumentoGeneral entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoDocumentoGeneral.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoDocumentoGeneral.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoDocumentoGeneralDataAccess.setFieldReflectionTipoDocumentoGeneral(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoDocumentoGeneral=TipoDocumentoGeneralConstantesFunciones.getTodosTiposColumnasTipoDocumentoGeneral();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoDocumentoGeneral) {
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
							field = TipoDocumentoGeneral.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoDocumentoGeneral.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoDocumentoGeneralDataAccess.setFieldReflectionTipoDocumentoGeneral(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoDocumentoGeneral(Field field,String strPrefijo,String sColumn,TipoDocumentoGeneral entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoDocumentoGeneralConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDocumentoGeneralConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDocumentoGeneralConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDocumentoGeneralConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDocumentoGeneral>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoDocumentoGeneral> entities = new  ArrayList<TipoDocumentoGeneral>();
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoDocumentoGeneral();
					entity=super.getEntity("",entity,resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoDocumentoGeneral("",entity,resultSet);
					
					//entity.setTipoDocumentoGeneralOriginal( new TipoDocumentoGeneral());
					//entity.setTipoDocumentoGeneralOriginal(super.getEntity("",entity.getTipoDocumentoGeneralOriginal(),resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoDocumentoGeneralOriginal(this.getEntityTipoDocumentoGeneral("",entity.getTipoDocumentoGeneralOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoDocumentoGenerals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumentoGeneral(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDocumentoGeneral>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoDocumentoGeneral> entities = new  ArrayList<TipoDocumentoGeneral>();
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDocumentoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoDocumentoGeneral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDocumentoGeneral> entities = new  ArrayList<TipoDocumentoGeneral>();
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
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
	
	public  List<TipoDocumentoGeneral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDocumentoGeneral> entities = new  ArrayList<TipoDocumentoGeneral>();
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumentoGeneral();
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDocumentoGeneral("",entity,resultSet);
      	    	
				//entity.setTipoDocumentoGeneralOriginal( new TipoDocumentoGeneral());
      	    	//entity.setTipoDocumentoGeneralOriginal(super.getEntity("",entity.getTipoDocumentoGeneralOriginal(),resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoGeneralOriginal(this.getEntityTipoDocumentoGeneral("",entity.getTipoDocumentoGeneralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoDocumentoGenerals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumentoGeneral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDocumentoGeneral> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDocumentoGeneral> entities = new  ArrayList<TipoDocumentoGeneral>();
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
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
	
	public  List<TipoDocumentoGeneral> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDocumentoGeneral> entities = new  ArrayList<TipoDocumentoGeneral>();
		TipoDocumentoGeneral entity = new TipoDocumentoGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumentoGeneral();
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDocumentoGeneral("",entity,resultSet);
      	    	
				//entity.setTipoDocumentoGeneralOriginal( new TipoDocumentoGeneral());
      	    	//entity.setTipoDocumentoGeneralOriginal(super.getEntity("",entity.getTipoDocumentoGeneralOriginal(),resultSet,TipoDocumentoGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoGeneralOriginal(this.getEntityTipoDocumentoGeneral("",entity.getTipoDocumentoGeneralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDocumentoGenerals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoDocumentoGeneral getEntityTipoDocumentoGeneral(String strPrefijo,TipoDocumentoGeneral entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDocumentoGeneralConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoDocumentoGeneralConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDocumentoGeneralConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoDocumentoGeneral(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoDocumentoGeneral entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoDocumentoGeneralDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoDocumentoGeneralDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoDocumentoGeneralDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoDocumentoGeneralDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoDocumentoGeneralConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoDocumentoGeneralDataAccess.TABLENAME,TipoDocumentoGeneralDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoDocumentoGeneralDataAccess.setTipoDocumentoGeneralOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<AutoriSri> getAutoriSris(Connexion connexion,TipoDocumentoGeneral tipodocumentogeneral)throws SQLException,Exception {

		List<AutoriSri> autorisris= new ArrayList<AutoriSri>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general ON "+AutoriSriConstantesFunciones.SCHEMA+".autori_sri.id_tipo_documento_general="+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general.id WHERE "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general.id="+String.valueOf(tipodocumentogeneral.getId());
			} else {
				sQuery=" INNER JOIN autorisri.TipoDocumentoGeneral WHERE autorisri.TipoDocumentoGeneral.id="+String.valueOf(tipodocumentogeneral.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriSriDataAccess autorisriDataAccess=new AutoriSriDataAccess();

			autorisriDataAccess.setConnexionType(this.connexionType);
			autorisriDataAccess.setParameterDbType(this.parameterDbType);
			autorisris=autorisriDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autorisris;

	}

	public List<ParametroGeneral> getParametroGenerals(Connexion connexion,TipoDocumentoGeneral tipodocumentogeneral)throws SQLException,Exception {

		List<ParametroGeneral> parametrogenerals= new ArrayList<ParametroGeneral>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general ON "+ParametroGeneralConstantesFunciones.SCHEMA+".parametro_general.id_tipo_documento_general="+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general.id WHERE "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general.id="+String.valueOf(tipodocumentogeneral.getId());
			} else {
				sQuery=" INNER JOIN parametrogeneral.TipoDocumentoGeneral WHERE parametrogeneral.TipoDocumentoGeneral.id="+String.valueOf(tipodocumentogeneral.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroGeneralDataAccess parametrogeneralDataAccess=new ParametroGeneralDataAccess();

			parametrogeneralDataAccess.setConnexionType(this.connexionType);
			parametrogeneralDataAccess.setParameterDbType(this.parameterDbType);
			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrogenerals;

	}

	public List<SecuencialUsuario> getSecuencialUsuarios(Connexion connexion,TipoDocumentoGeneral tipodocumentogeneral)throws SQLException,Exception {

		List<SecuencialUsuario> secuencialusuarios= new ArrayList<SecuencialUsuario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general ON "+SecuencialUsuarioConstantesFunciones.SCHEMA+".secuencial_usuario.id_tipo_documento_general="+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general.id WHERE "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general.id="+String.valueOf(tipodocumentogeneral.getId());
			} else {
				sQuery=" INNER JOIN secuencialusuario.TipoDocumentoGeneral WHERE secuencialusuario.TipoDocumentoGeneral.id="+String.valueOf(tipodocumentogeneral.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SecuencialUsuarioDataAccess secuencialusuarioDataAccess=new SecuencialUsuarioDataAccess();

			secuencialusuarioDataAccess.setConnexionType(this.connexionType);
			secuencialusuarioDataAccess.setParameterDbType(this.parameterDbType);
			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return secuencialusuarios;

	}

	public List<ParametroFactuSecuencial> getParametroFactuSecuencials(Connexion connexion,TipoDocumentoGeneral tipodocumentogeneral)throws SQLException,Exception {

		List<ParametroFactuSecuencial> parametrofactusecuencials= new ArrayList<ParametroFactuSecuencial>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general ON "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+".parametro_factu_secuencial.id_tipo_documento_general="+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general.id WHERE "+TipoDocumentoGeneralConstantesFunciones.SCHEMA+".tipo_documento_general.id="+String.valueOf(tipodocumentogeneral.getId());
			} else {
				sQuery=" INNER JOIN parametrofactusecuencial.TipoDocumentoGeneral WHERE parametrofactusecuencial.TipoDocumentoGeneral.id="+String.valueOf(tipodocumentogeneral.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoDocumentoGeneral tipodocumentogeneral) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipodocumentogeneral.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipodocumentogeneral.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipodocumentogeneral.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipodocumentogeneral.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipodocumentogeneral.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipodocumentogeneral.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipodocumentogeneral.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipodocumentogeneral.getId());
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
	
	public void setIsNewIsChangedFalseTipoDocumentoGeneral(TipoDocumentoGeneral tipodocumentogeneral)throws Exception  {		
		tipodocumentogeneral.setIsNew(false);
		tipodocumentogeneral.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoDocumentoGenerals(List<TipoDocumentoGeneral> tipodocumentogenerals)throws Exception  {				
		for(TipoDocumentoGeneral tipodocumentogeneral:tipodocumentogenerals) {
			tipodocumentogeneral.setIsNew(false);
			tipodocumentogeneral.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoDocumentoGeneral(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
