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
package com.bydan.erp.nomina.business.dataaccess;

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

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//TipoRasgoPersonalConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoRasgoPersonalDataAccess extends  TipoRasgoPersonalDataAccessAdditional{ //TipoRasgoPersonalDataAccessAdditional,DataAccessHelper<TipoRasgoPersonal>
	//static Logger logger = Logger.getLogger(TipoRasgoPersonalDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_rasgo_personal";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tiporasgopersonal from "+TipoRasgoPersonalConstantesFunciones.SPERSISTENCENAME+" tiporasgopersonal";
	public static String QUERYSELECTNATIVE="select "+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".id,"+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".version_row,"+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".id_empresa,"+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".codigo,"+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".nombre from "+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME;//+" as "+TipoRasgoPersonalConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".id,"+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".version_row,"+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+".codigo from "+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME;//+" as "+TipoRasgoPersonalConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoRasgoPersonalConstantesFunciones.SCHEMA+"."+TipoRasgoPersonalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPORASGOPERSONAL_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPORASGOPERSONAL_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPORASGOPERSONAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPORASGOPERSONAL_SELECT(?,?)";
	
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
	
	
	protected TipoRasgoPersonalDataAccessAdditional tiporasgopersonalDataAccessAdditional=null;
	
	public TipoRasgoPersonalDataAccessAdditional getTipoRasgoPersonalDataAccessAdditional() {
		return this.tiporasgopersonalDataAccessAdditional;
	}
	
	public void setTipoRasgoPersonalDataAccessAdditional(TipoRasgoPersonalDataAccessAdditional tiporasgopersonalDataAccessAdditional) {
		try {
			this.tiporasgopersonalDataAccessAdditional=tiporasgopersonalDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoRasgoPersonalDataAccess() {
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
		TipoRasgoPersonalDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoRasgoPersonalDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoRasgoPersonalDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoRasgoPersonalOriginal(TipoRasgoPersonal tiporasgopersonal)throws Exception  {
		tiporasgopersonal.setTipoRasgoPersonalOriginal((TipoRasgoPersonal)tiporasgopersonal.clone());		
	}
	
	public void setTipoRasgoPersonalsOriginal(List<TipoRasgoPersonal> tiporasgopersonals)throws Exception  {
		
		for(TipoRasgoPersonal tiporasgopersonal:tiporasgopersonals){
			tiporasgopersonal.setTipoRasgoPersonalOriginal((TipoRasgoPersonal)tiporasgopersonal.clone());
		}
	}
	
	public static void setTipoRasgoPersonalOriginalStatic(TipoRasgoPersonal tiporasgopersonal)throws Exception  {
		tiporasgopersonal.setTipoRasgoPersonalOriginal((TipoRasgoPersonal)tiporasgopersonal.clone());		
	}
	
	public static void setTipoRasgoPersonalsOriginalStatic(List<TipoRasgoPersonal> tiporasgopersonals)throws Exception  {
		
		for(TipoRasgoPersonal tiporasgopersonal:tiporasgopersonals){
			tiporasgopersonal.setTipoRasgoPersonalOriginal((TipoRasgoPersonal)tiporasgopersonal.clone());
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
	
	public  TipoRasgoPersonal getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		
		
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
	
	public  TipoRasgoPersonal getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.TipoRasgoPersonal.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoRasgoPersonalOriginal(new TipoRasgoPersonal());
      	    	entity=super.getEntity("",entity,resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRasgoPersonal("",entity,resultSet); 
				
				//entity.setTipoRasgoPersonalOriginal(super.getEntity("",entity.getTipoRasgoPersonalOriginal(),resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRasgoPersonalOriginal(this.getEntityTipoRasgoPersonal("",entity.getTipoRasgoPersonalOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRasgoPersonal(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoRasgoPersonal getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRasgoPersonal entity = new TipoRasgoPersonal();
				
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
	
	public  TipoRasgoPersonal getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRasgoPersonal entity = new TipoRasgoPersonal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRasgoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoRasgoPersonal.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoRasgoPersonalOriginal(new TipoRasgoPersonal());
      	    	entity=super.getEntity("",entity,resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRasgoPersonal("",entity,resultSet);    
				
				//entity.setTipoRasgoPersonalOriginal(super.getEntity("",entity.getTipoRasgoPersonalOriginal(),resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRasgoPersonalOriginal(this.getEntityTipoRasgoPersonal("",entity.getTipoRasgoPersonalOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRasgoPersonal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoRasgoPersonal
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoRasgoPersonal entity = new TipoRasgoPersonal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRasgoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoRasgoPersonal.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoRasgoPersonal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoRasgoPersonal> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRasgoPersonal> entities = new  ArrayList<TipoRasgoPersonal>();
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
		
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
	
	public  List<TipoRasgoPersonal> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRasgoPersonal> entities = new  ArrayList<TipoRasgoPersonal>();
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRasgoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRasgoPersonal();
      	    	entity=super.getEntity("",entity,resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRasgoPersonal("",entity,resultSet);
      	    	
				//entity.setTipoRasgoPersonalOriginal( new TipoRasgoPersonal());
      	    	//entity.setTipoRasgoPersonalOriginal(super.getEntity("",entity.getTipoRasgoPersonalOriginal(),resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRasgoPersonalOriginal(this.getEntityTipoRasgoPersonal("",entity.getTipoRasgoPersonalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRasgoPersonals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRasgoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRasgoPersonal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRasgoPersonal> entities = new  ArrayList<TipoRasgoPersonal>();
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
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
	
	public  List<TipoRasgoPersonal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRasgoPersonal> entities = new  ArrayList<TipoRasgoPersonal>();
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRasgoPersonal();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRasgoPersonal();
					//entity.setMapTipoRasgoPersonal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoRasgoPersonalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRasgoPersonal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA);         		
					entity=TipoRasgoPersonalDataAccess.getEntityTipoRasgoPersonal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRasgoPersonalOriginal( new TipoRasgoPersonal());
					////entity.setTipoRasgoPersonalOriginal(super.getEntity("",entity.getTipoRasgoPersonalOriginal(),resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRasgoPersonalOriginal(this.getEntityTipoRasgoPersonal("",entity.getTipoRasgoPersonalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRasgoPersonals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRasgoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoRasgoPersonal getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
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
	
	public  TipoRasgoPersonal getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRasgoPersonal();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRasgoPersonal();
					//entity.setMapTipoRasgoPersonal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoRasgoPersonalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRasgoPersonal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA);         		
					entity=TipoRasgoPersonalDataAccess.getEntityTipoRasgoPersonal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRasgoPersonalOriginal( new TipoRasgoPersonal());
					////entity.setTipoRasgoPersonalOriginal(super.getEntity("",entity.getTipoRasgoPersonalOriginal(),resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRasgoPersonalOriginal(this.getEntityTipoRasgoPersonal("",entity.getTipoRasgoPersonalOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoRasgoPersonal(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRasgoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoRasgoPersonal getEntityTipoRasgoPersonal(String strPrefijo,TipoRasgoPersonal entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoRasgoPersonal.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoRasgoPersonal.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoRasgoPersonalDataAccess.setFieldReflectionTipoRasgoPersonal(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoRasgoPersonal=TipoRasgoPersonalConstantesFunciones.getTodosTiposColumnasTipoRasgoPersonal();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoRasgoPersonal) {
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
							field = TipoRasgoPersonal.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoRasgoPersonal.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoRasgoPersonalDataAccess.setFieldReflectionTipoRasgoPersonal(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoRasgoPersonal(Field field,String strPrefijo,String sColumn,TipoRasgoPersonal entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoRasgoPersonalConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRasgoPersonalConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRasgoPersonalConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRasgoPersonalConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRasgoPersonalConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRasgoPersonal>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoRasgoPersonal> entities = new  ArrayList<TipoRasgoPersonal>();
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRasgoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoRasgoPersonal();
					entity=super.getEntity("",entity,resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoRasgoPersonal("",entity,resultSet);
					
					//entity.setTipoRasgoPersonalOriginal( new TipoRasgoPersonal());
					//entity.setTipoRasgoPersonalOriginal(super.getEntity("",entity.getTipoRasgoPersonalOriginal(),resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoRasgoPersonalOriginal(this.getEntityTipoRasgoPersonal("",entity.getTipoRasgoPersonalOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoRasgoPersonals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRasgoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRasgoPersonal>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoRasgoPersonal> entities = new  ArrayList<TipoRasgoPersonal>();
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRasgoPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoRasgoPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoRasgoPersonal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRasgoPersonal> entities = new  ArrayList<TipoRasgoPersonal>();
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
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
	
	public  List<TipoRasgoPersonal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRasgoPersonal> entities = new  ArrayList<TipoRasgoPersonal>();
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRasgoPersonal();
      	    	entity=super.getEntity("",entity,resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRasgoPersonal("",entity,resultSet);
      	    	
				//entity.setTipoRasgoPersonalOriginal( new TipoRasgoPersonal());
      	    	//entity.setTipoRasgoPersonalOriginal(super.getEntity("",entity.getTipoRasgoPersonalOriginal(),resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRasgoPersonalOriginal(this.getEntityTipoRasgoPersonal("",entity.getTipoRasgoPersonalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoRasgoPersonals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRasgoPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRasgoPersonal> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRasgoPersonal> entities = new  ArrayList<TipoRasgoPersonal>();
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
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
	
	public  List<TipoRasgoPersonal> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRasgoPersonal> entities = new  ArrayList<TipoRasgoPersonal>();
		TipoRasgoPersonal entity = new TipoRasgoPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRasgoPersonal();
      	    	entity=super.getEntity("",entity,resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRasgoPersonal("",entity,resultSet);
      	    	
				//entity.setTipoRasgoPersonalOriginal( new TipoRasgoPersonal());
      	    	//entity.setTipoRasgoPersonalOriginal(super.getEntity("",entity.getTipoRasgoPersonalOriginal(),resultSet,TipoRasgoPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRasgoPersonalOriginal(this.getEntityTipoRasgoPersonal("",entity.getTipoRasgoPersonalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRasgoPersonals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoRasgoPersonal getEntityTipoRasgoPersonal(String strPrefijo,TipoRasgoPersonal entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoRasgoPersonalConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoRasgoPersonalConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoRasgoPersonalConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoRasgoPersonalConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoRasgoPersonal(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoRasgoPersonal entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoRasgoPersonalDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoRasgoPersonalDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoRasgoPersonalDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoRasgoPersonalDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoRasgoPersonalConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoRasgoPersonalDataAccess.TABLENAME,TipoRasgoPersonalDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoRasgoPersonalDataAccess.setTipoRasgoPersonalOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoRasgoPersonal reltiporasgopersonal)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltiporasgopersonal.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<RasgoPersonal> getRasgoPersonals(Connexion connexion,TipoRasgoPersonal tiporasgopersonal)throws SQLException,Exception {

		List<RasgoPersonal> rasgopersonals= new ArrayList<RasgoPersonal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRasgoPersonalConstantesFunciones.SCHEMA+".tipo_rasgo_personal ON "+RasgoPersonalConstantesFunciones.SCHEMA+".rasgo_personal.id_tipo_rasgo_personal="+TipoRasgoPersonalConstantesFunciones.SCHEMA+".tipo_rasgo_personal.id WHERE "+TipoRasgoPersonalConstantesFunciones.SCHEMA+".tipo_rasgo_personal.id="+String.valueOf(tiporasgopersonal.getId());
			} else {
				sQuery=" INNER JOIN rasgopersonal.TipoRasgoPersonal WHERE rasgopersonal.TipoRasgoPersonal.id="+String.valueOf(tiporasgopersonal.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RasgoPersonalDataAccess rasgopersonalDataAccess=new RasgoPersonalDataAccess();

			rasgopersonalDataAccess.setConnexionType(this.connexionType);
			rasgopersonalDataAccess.setParameterDbType(this.parameterDbType);
			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rasgopersonals;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoRasgoPersonal tiporasgopersonal) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tiporasgopersonal.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tiporasgopersonal.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tiporasgopersonal.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tiporasgopersonal.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tiporasgopersonal.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tiporasgopersonal.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tiporasgopersonal.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tiporasgopersonal.getId());
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
	
	public void setIsNewIsChangedFalseTipoRasgoPersonal(TipoRasgoPersonal tiporasgopersonal)throws Exception  {		
		tiporasgopersonal.setIsNew(false);
		tiporasgopersonal.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoRasgoPersonals(List<TipoRasgoPersonal> tiporasgopersonals)throws Exception  {				
		for(TipoRasgoPersonal tiporasgopersonal:tiporasgopersonals) {
			tiporasgopersonal.setIsNew(false);
			tiporasgopersonal.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoRasgoPersonal(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
