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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//TipoCargaFamiConstantesFunciones;


import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class TipoCargaFamiDataAccess extends  TipoCargaFamiDataAccessAdditional{ //TipoCargaFamiDataAccessAdditional,DataAccessHelper<TipoCargaFami>
	//static Logger logger = Logger.getLogger(TipoCargaFamiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_carga_fami";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocargafami from "+TipoCargaFamiConstantesFunciones.SPERSISTENCENAME+" tipocargafami";
	public static String QUERYSELECTNATIVE="select "+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+".id,"+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+".version_row,"+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+".codigo,"+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+".nombre from "+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME;//+" as "+TipoCargaFamiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+".id,"+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+".version_row,"+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+".codigo from "+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME;//+" as "+TipoCargaFamiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCARGAFAMI_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCARGAFAMI_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCARGAFAMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCARGAFAMI_SELECT(?,?)";
	
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
	
	
	protected TipoCargaFamiDataAccessAdditional tipocargafamiDataAccessAdditional=null;
	
	public TipoCargaFamiDataAccessAdditional getTipoCargaFamiDataAccessAdditional() {
		return this.tipocargafamiDataAccessAdditional;
	}
	
	public void setTipoCargaFamiDataAccessAdditional(TipoCargaFamiDataAccessAdditional tipocargafamiDataAccessAdditional) {
		try {
			this.tipocargafamiDataAccessAdditional=tipocargafamiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoCargaFamiDataAccess() {
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
		TipoCargaFamiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoCargaFamiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoCargaFamiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoCargaFamiOriginal(TipoCargaFami tipocargafami)throws Exception  {
		tipocargafami.setTipoCargaFamiOriginal((TipoCargaFami)tipocargafami.clone());		
	}
	
	public void setTipoCargaFamisOriginal(List<TipoCargaFami> tipocargafamis)throws Exception  {
		
		for(TipoCargaFami tipocargafami:tipocargafamis){
			tipocargafami.setTipoCargaFamiOriginal((TipoCargaFami)tipocargafami.clone());
		}
	}
	
	public static void setTipoCargaFamiOriginalStatic(TipoCargaFami tipocargafami)throws Exception  {
		tipocargafami.setTipoCargaFamiOriginal((TipoCargaFami)tipocargafami.clone());		
	}
	
	public static void setTipoCargaFamisOriginalStatic(List<TipoCargaFami> tipocargafamis)throws Exception  {
		
		for(TipoCargaFami tipocargafami:tipocargafamis){
			tipocargafami.setTipoCargaFamiOriginal((TipoCargaFami)tipocargafami.clone());
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
	
	public  TipoCargaFami getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCargaFami entity = new TipoCargaFami();		
		
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
	
	public  TipoCargaFami getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCargaFami entity = new TipoCargaFami();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.TipoCargaFami.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoCargaFamiOriginal(new TipoCargaFami());
      	    	entity=super.getEntity("",entity,resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCargaFami("",entity,resultSet); 
				
				//entity.setTipoCargaFamiOriginal(super.getEntity("",entity.getTipoCargaFamiOriginal(),resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCargaFamiOriginal(this.getEntityTipoCargaFami("",entity.getTipoCargaFamiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCargaFami(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoCargaFami getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCargaFami entity = new TipoCargaFami();
				
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
	
	public  TipoCargaFami getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCargaFami entity = new TipoCargaFami();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCargaFamiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoCargaFami.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoCargaFamiOriginal(new TipoCargaFami());
      	    	entity=super.getEntity("",entity,resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCargaFami("",entity,resultSet);    
				
				//entity.setTipoCargaFamiOriginal(super.getEntity("",entity.getTipoCargaFamiOriginal(),resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCargaFamiOriginal(this.getEntityTipoCargaFami("",entity.getTipoCargaFamiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCargaFami(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoCargaFami
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoCargaFami entity = new TipoCargaFami();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCargaFamiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoCargaFami.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoCargaFami(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoCargaFami> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCargaFami> entities = new  ArrayList<TipoCargaFami>();
		TipoCargaFami entity = new TipoCargaFami();		  
		
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
	
	public  List<TipoCargaFami> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCargaFami> entities = new  ArrayList<TipoCargaFami>();
		TipoCargaFami entity = new TipoCargaFami();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCargaFamiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCargaFami();
      	    	entity=super.getEntity("",entity,resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCargaFami("",entity,resultSet);
      	    	
				//entity.setTipoCargaFamiOriginal( new TipoCargaFami());
      	    	//entity.setTipoCargaFamiOriginal(super.getEntity("",entity.getTipoCargaFamiOriginal(),resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCargaFamiOriginal(this.getEntityTipoCargaFami("",entity.getTipoCargaFamiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCargaFamis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCargaFami(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCargaFami> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCargaFami> entities = new  ArrayList<TipoCargaFami>();
		TipoCargaFami entity = new TipoCargaFami();		  
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
	
	public  List<TipoCargaFami> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCargaFami> entities = new  ArrayList<TipoCargaFami>();
		TipoCargaFami entity = new TipoCargaFami();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCargaFami();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCargaFami();
					//entity.setMapTipoCargaFami(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoCargaFamiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCargaFami().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA);         		
					entity=TipoCargaFamiDataAccess.getEntityTipoCargaFami("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCargaFamiOriginal( new TipoCargaFami());
					////entity.setTipoCargaFamiOriginal(super.getEntity("",entity.getTipoCargaFamiOriginal(),resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCargaFamiOriginal(this.getEntityTipoCargaFami("",entity.getTipoCargaFamiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCargaFamis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCargaFami(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoCargaFami getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCargaFami entity = new TipoCargaFami();		  
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
	
	public  TipoCargaFami getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCargaFami entity = new TipoCargaFami();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCargaFami();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCargaFami();
					//entity.setMapTipoCargaFami(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoCargaFamiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCargaFami().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA);         		
					entity=TipoCargaFamiDataAccess.getEntityTipoCargaFami("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCargaFamiOriginal( new TipoCargaFami());
					////entity.setTipoCargaFamiOriginal(super.getEntity("",entity.getTipoCargaFamiOriginal(),resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCargaFamiOriginal(this.getEntityTipoCargaFami("",entity.getTipoCargaFamiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoCargaFami(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCargaFami(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoCargaFami getEntityTipoCargaFami(String strPrefijo,TipoCargaFami entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoCargaFami.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoCargaFami.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoCargaFamiDataAccess.setFieldReflectionTipoCargaFami(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoCargaFami=TipoCargaFamiConstantesFunciones.getTodosTiposColumnasTipoCargaFami();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoCargaFami) {
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
							field = TipoCargaFami.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoCargaFami.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoCargaFamiDataAccess.setFieldReflectionTipoCargaFami(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoCargaFami(Field field,String strPrefijo,String sColumn,TipoCargaFami entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoCargaFamiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCargaFamiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCargaFamiConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCargaFamiConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCargaFami>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoCargaFami> entities = new  ArrayList<TipoCargaFami>();
		TipoCargaFami entity = new TipoCargaFami();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCargaFamiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoCargaFami();
					entity=super.getEntity("",entity,resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoCargaFami("",entity,resultSet);
					
					//entity.setTipoCargaFamiOriginal( new TipoCargaFami());
					//entity.setTipoCargaFamiOriginal(super.getEntity("",entity.getTipoCargaFamiOriginal(),resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoCargaFamiOriginal(this.getEntityTipoCargaFami("",entity.getTipoCargaFamiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoCargaFamis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCargaFami(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCargaFami>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoCargaFami> entities = new  ArrayList<TipoCargaFami>();
		TipoCargaFami entity = new TipoCargaFami();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCargaFamiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCargaFamiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoCargaFami> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCargaFami> entities = new  ArrayList<TipoCargaFami>();
		TipoCargaFami entity = new TipoCargaFami();		  
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
	
	public  List<TipoCargaFami> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCargaFami> entities = new  ArrayList<TipoCargaFami>();
		TipoCargaFami entity = new TipoCargaFami();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCargaFami();
      	    	entity=super.getEntity("",entity,resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCargaFami("",entity,resultSet);
      	    	
				//entity.setTipoCargaFamiOriginal( new TipoCargaFami());
      	    	//entity.setTipoCargaFamiOriginal(super.getEntity("",entity.getTipoCargaFamiOriginal(),resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCargaFamiOriginal(this.getEntityTipoCargaFami("",entity.getTipoCargaFamiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoCargaFamis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCargaFami(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCargaFami> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCargaFami> entities = new  ArrayList<TipoCargaFami>();
		TipoCargaFami entity = new TipoCargaFami();		  
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
	
	public  List<TipoCargaFami> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCargaFami> entities = new  ArrayList<TipoCargaFami>();
		TipoCargaFami entity = new TipoCargaFami();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCargaFami();
      	    	entity=super.getEntity("",entity,resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCargaFami("",entity,resultSet);
      	    	
				//entity.setTipoCargaFamiOriginal( new TipoCargaFami());
      	    	//entity.setTipoCargaFamiOriginal(super.getEntity("",entity.getTipoCargaFamiOriginal(),resultSet,TipoCargaFamiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCargaFamiOriginal(this.getEntityTipoCargaFami("",entity.getTipoCargaFamiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCargaFamis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoCargaFami getEntityTipoCargaFami(String strPrefijo,TipoCargaFami entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCargaFamiConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoCargaFamiConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCargaFamiConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoCargaFami(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoCargaFami entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoCargaFamiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoCargaFamiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoCargaFamiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoCargaFamiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoCargaFamiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoCargaFamiDataAccess.TABLENAME,TipoCargaFamiDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoCargaFamiDataAccess.setTipoCargaFamiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<CargaFamiliar_NM> getCargaFamiliar_NMs(Connexion connexion,TipoCargaFami tipocargafami)throws SQLException,Exception {

		List<CargaFamiliar_NM> cargafamiliar_nms= new ArrayList<CargaFamiliar_NM>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCargaFamiConstantesFunciones.SCHEMA+".tipo_carga_fami ON "+CargaFamiliar_NMConstantesFunciones.SCHEMA+".carga_familiar__n_m.id_tipo_carga_fami="+TipoCargaFamiConstantesFunciones.SCHEMA+".tipo_carga_fami.id WHERE "+TipoCargaFamiConstantesFunciones.SCHEMA+".tipo_carga_fami.id="+String.valueOf(tipocargafami.getId());
			} else {
				sQuery=" INNER JOIN cargafamiliar_nm.TipoCargaFami WHERE cargafamiliar_nm.TipoCargaFami.id="+String.valueOf(tipocargafami.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CargaFamiliar_NMDataAccess cargafamiliar_nmDataAccess=new CargaFamiliar_NMDataAccess();

			cargafamiliar_nmDataAccess.setConnexionType(this.connexionType);
			cargafamiliar_nmDataAccess.setParameterDbType(this.parameterDbType);
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargafamiliar_nms;

	}

	public List<CargaFamiliar> getCargaFamiliars(Connexion connexion,TipoCargaFami tipocargafami)throws SQLException,Exception {

		List<CargaFamiliar> cargafamiliars= new ArrayList<CargaFamiliar>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCargaFamiConstantesFunciones.SCHEMA+".tipo_carga_fami ON "+CargaFamiliarConstantesFunciones.SCHEMA+".carga_familiar.id_tipo_carga_fami="+TipoCargaFamiConstantesFunciones.SCHEMA+".tipo_carga_fami.id WHERE "+TipoCargaFamiConstantesFunciones.SCHEMA+".tipo_carga_fami.id="+String.valueOf(tipocargafami.getId());
			} else {
				sQuery=" INNER JOIN cargafamiliar.TipoCargaFami WHERE cargafamiliar.TipoCargaFami.id="+String.valueOf(tipocargafami.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CargaFamiliarDataAccess cargafamiliarDataAccess=new CargaFamiliarDataAccess();

			cargafamiliarDataAccess.setConnexionType(this.connexionType);
			cargafamiliarDataAccess.setParameterDbType(this.parameterDbType);
			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargafamiliars;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoCargaFami tipocargafami) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocargafami.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipocargafami.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipocargafami.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipocargafami.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocargafami.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocargafami.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocargafami.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocargafami.getId());
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
	
	public void setIsNewIsChangedFalseTipoCargaFami(TipoCargaFami tipocargafami)throws Exception  {		
		tipocargafami.setIsNew(false);
		tipocargafami.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoCargaFamis(List<TipoCargaFami> tipocargafamis)throws Exception  {				
		for(TipoCargaFami tipocargafami:tipocargafamis) {
			tipocargafami.setIsNew(false);
			tipocargafami.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoCargaFami(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
