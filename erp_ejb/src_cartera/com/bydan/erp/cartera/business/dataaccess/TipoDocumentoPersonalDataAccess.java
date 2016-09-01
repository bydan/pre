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
import com.bydan.erp.cartera.util.*;//TipoDocumentoPersonalConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoDocumentoPersonalDataAccess extends  DataAccessHelperSinIdGenerated<TipoDocumentoPersonal>{ //TipoDocumentoPersonalDataAccessAdditional,DataAccessHelper<TipoDocumentoPersonal>
	//static Logger logger = Logger.getLogger(TipoDocumentoPersonalDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_documento_personal";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+"(id,version_row,id_pais,codigo,nombre)values(?,current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_pais=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipodocumentopersonal from "+TipoDocumentoPersonalConstantesFunciones.SPERSISTENCENAME+" tipodocumentopersonal";
	public static String QUERYSELECTNATIVE="select "+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".id,"+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".version_row,"+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".id_pais,"+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".codigo,"+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".nombre from "+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME;//+" as "+TipoDocumentoPersonalConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".id,"+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".version_row,"+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".codigo from "+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME;//+" as "+TipoDocumentoPersonalConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_pais=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPODOCUMENTOPERSONAL_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPODOCUMENTOPERSONAL_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPODOCUMENTOPERSONAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPODOCUMENTOPERSONAL_SELECT(?,?)";
	
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
	
	
	public TipoDocumentoPersonalDataAccess() {
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
		TipoDocumentoPersonalDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoDocumentoPersonalDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoDocumentoPersonalDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoDocumentoPersonalOriginal(TipoDocumentoPersonal tipodocumentopersonal)throws Exception  {
		tipodocumentopersonal.setTipoDocumentoPersonalOriginal((TipoDocumentoPersonal)tipodocumentopersonal.clone());		
	}
	
	public void setTipoDocumentoPersonalsOriginal(List<TipoDocumentoPersonal> tipodocumentopersonals)throws Exception  {
		
		for(TipoDocumentoPersonal tipodocumentopersonal:tipodocumentopersonals){
			tipodocumentopersonal.setTipoDocumentoPersonalOriginal((TipoDocumentoPersonal)tipodocumentopersonal.clone());
		}
	}
	
	public static void setTipoDocumentoPersonalOriginalStatic(TipoDocumentoPersonal tipodocumentopersonal)throws Exception  {
		tipodocumentopersonal.setTipoDocumentoPersonalOriginal((TipoDocumentoPersonal)tipodocumentopersonal.clone());		
	}
	
	public static void setTipoDocumentoPersonalsOriginalStatic(List<TipoDocumentoPersonal> tipodocumentopersonals)throws Exception  {
		
		for(TipoDocumentoPersonal tipodocumentopersonal:tipodocumentopersonals){
			tipodocumentopersonal.setTipoDocumentoPersonalOriginal((TipoDocumentoPersonal)tipodocumentopersonal.clone());
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
	
	public  TipoDocumentoPersonal getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		
		
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
	
	public  TipoDocumentoPersonal getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.TipoDocumentoPersonal.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoDocumentoPersonalOriginal(new TipoDocumentoPersonal());
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDocumentoPersonal("",entity,resultSet); 
				
				//entity.setTipoDocumentoPersonalOriginal(super.getEntity("",entity.getTipoDocumentoPersonalOriginal(),resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoPersonalOriginal(this.getEntityTipoDocumentoPersonal("",entity.getTipoDocumentoPersonalOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDocumentoPersonal(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoDocumentoPersonal getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();
				
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
	
	public  TipoDocumentoPersonal getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoDocumentoPersonal.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoDocumentoPersonalOriginal(new TipoDocumentoPersonal());
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDocumentoPersonal("",entity,resultSet);    
				
				//entity.setTipoDocumentoPersonalOriginal(super.getEntity("",entity.getTipoDocumentoPersonalOriginal(),resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoPersonalOriginal(this.getEntityTipoDocumentoPersonal("",entity.getTipoDocumentoPersonalOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDocumentoPersonal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoDocumentoPersonal
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoDocumentoPersonal.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoDocumentoPersonal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoDocumentoPersonal> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDocumentoPersonal> entities = new  ArrayList<TipoDocumentoPersonal>();
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		  
		
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
	
	public  List<TipoDocumentoPersonal> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDocumentoPersonal> entities = new  ArrayList<TipoDocumentoPersonal>();
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumentoPersonal();
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDocumentoPersonal("",entity,resultSet);
      	    	
				//entity.setTipoDocumentoPersonalOriginal( new TipoDocumentoPersonal());
      	    	//entity.setTipoDocumentoPersonalOriginal(super.getEntity("",entity.getTipoDocumentoPersonalOriginal(),resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoPersonalOriginal(this.getEntityTipoDocumentoPersonal("",entity.getTipoDocumentoPersonalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDocumentoPersonals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumentoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDocumentoPersonal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDocumentoPersonal> entities = new  ArrayList<TipoDocumentoPersonal>();
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		  
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
	
	public  List<TipoDocumentoPersonal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDocumentoPersonal> entities = new  ArrayList<TipoDocumentoPersonal>();
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumentoPersonal();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDocumentoPersonal();
					//entity.setMapTipoDocumentoPersonal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoDocumentoPersonalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDocumentoPersonal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA);         		
					entity=TipoDocumentoPersonalDataAccess.getEntityTipoDocumentoPersonal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDocumentoPersonalOriginal( new TipoDocumentoPersonal());
					////entity.setTipoDocumentoPersonalOriginal(super.getEntity("",entity.getTipoDocumentoPersonalOriginal(),resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDocumentoPersonalOriginal(this.getEntityTipoDocumentoPersonal("",entity.getTipoDocumentoPersonalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDocumentoPersonals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumentoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoDocumentoPersonal getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		  
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
	
	public  TipoDocumentoPersonal getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumentoPersonal();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDocumentoPersonal();
					//entity.setMapTipoDocumentoPersonal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoDocumentoPersonalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDocumentoPersonal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA);         		
					entity=TipoDocumentoPersonalDataAccess.getEntityTipoDocumentoPersonal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDocumentoPersonalOriginal( new TipoDocumentoPersonal());
					////entity.setTipoDocumentoPersonalOriginal(super.getEntity("",entity.getTipoDocumentoPersonalOriginal(),resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDocumentoPersonalOriginal(this.getEntityTipoDocumentoPersonal("",entity.getTipoDocumentoPersonalOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoDocumentoPersonal(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumentoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoDocumentoPersonal getEntityTipoDocumentoPersonal(String strPrefijo,TipoDocumentoPersonal entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoDocumentoPersonal.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoDocumentoPersonal.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoDocumentoPersonalDataAccess.setFieldReflectionTipoDocumentoPersonal(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoDocumentoPersonal=TipoDocumentoPersonalConstantesFunciones.getTodosTiposColumnasTipoDocumentoPersonal();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoDocumentoPersonal) {
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
							field = TipoDocumentoPersonal.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoDocumentoPersonal.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoDocumentoPersonalDataAccess.setFieldReflectionTipoDocumentoPersonal(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoDocumentoPersonal(Field field,String strPrefijo,String sColumn,TipoDocumentoPersonal entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoDocumentoPersonalConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDocumentoPersonalConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDocumentoPersonalConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDocumentoPersonalConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDocumentoPersonalConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDocumentoPersonal>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoDocumentoPersonal> entities = new  ArrayList<TipoDocumentoPersonal>();
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoDocumentoPersonal();
					entity=super.getEntity("",entity,resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoDocumentoPersonal("",entity,resultSet);
					
					//entity.setTipoDocumentoPersonalOriginal( new TipoDocumentoPersonal());
					//entity.setTipoDocumentoPersonalOriginal(super.getEntity("",entity.getTipoDocumentoPersonalOriginal(),resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoDocumentoPersonalOriginal(this.getEntityTipoDocumentoPersonal("",entity.getTipoDocumentoPersonalOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoDocumentoPersonals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumentoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDocumentoPersonal>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoDocumentoPersonal> entities = new  ArrayList<TipoDocumentoPersonal>();
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDocumentoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoDocumentoPersonal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDocumentoPersonal> entities = new  ArrayList<TipoDocumentoPersonal>();
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		  
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
	
	public  List<TipoDocumentoPersonal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDocumentoPersonal> entities = new  ArrayList<TipoDocumentoPersonal>();
		TipoDocumentoPersonal entity = new TipoDocumentoPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumentoPersonal();
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDocumentoPersonal("",entity,resultSet);
      	    	
				//entity.setTipoDocumentoPersonalOriginal( new TipoDocumentoPersonal());
      	    	//entity.setTipoDocumentoPersonalOriginal(super.getEntity("",entity.getTipoDocumentoPersonalOriginal(),resultSet,TipoDocumentoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoPersonalOriginal(this.getEntityTipoDocumentoPersonal("",entity.getTipoDocumentoPersonalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoDocumentoPersonals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumentoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoDocumentoPersonal getEntityTipoDocumentoPersonal(String strPrefijo,TipoDocumentoPersonal entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pais(resultSet.getLong(strPrefijo+TipoDocumentoPersonalConstantesFunciones.IDPAIS));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDocumentoPersonalConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoDocumentoPersonalConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDocumentoPersonalConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoDocumentoPersonal(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoDocumentoPersonal entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoDocumentoPersonalDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoDocumentoPersonalDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoDocumentoPersonalDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoDocumentoPersonalDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoDocumentoPersonalConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoDocumentoPersonalDataAccess.TABLENAME,TipoDocumentoPersonalDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoDocumentoPersonalDataAccess.setTipoDocumentoPersonalOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Pais getPais(Connexion connexion,TipoDocumentoPersonal reltipodocumentopersonal)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,reltipodocumentopersonal.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoDocumentoPersonal tipodocumentopersonal) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipodocumentopersonal.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipodocumentopersonal.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(tipodocumentopersonal.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipodocumentopersonal.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipodocumentopersonal.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipodocumentopersonal.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipodocumentopersonal.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipodocumentopersonal.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipodocumentopersonal.getId());
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
	
	public void setIsNewIsChangedFalseTipoDocumentoPersonal(TipoDocumentoPersonal tipodocumentopersonal)throws Exception  {		
		tipodocumentopersonal.setIsNew(false);
		tipodocumentopersonal.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoDocumentoPersonals(List<TipoDocumentoPersonal> tipodocumentopersonals)throws Exception  {				
		for(TipoDocumentoPersonal tipodocumentopersonal:tipodocumentopersonals) {
			tipodocumentopersonal.setIsNew(false);
			tipodocumentopersonal.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoDocumentoPersonal(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
