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
import com.bydan.erp.nomina.util.*;//AsistenciaPorCentroCostoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class AsistenciaPorCentroCostoDataAccess extends  AsistenciaPorCentroCostoDataAccessAdditional{ //AsistenciaPorCentroCostoDataAccessAdditional,DataAccessHelper<AsistenciaPorCentroCosto>
	//static Logger logger = Logger.getLogger(AsistenciaPorCentroCostoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="asistencia_por_centro_costo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_centro_costo,id_empleado,fecha,porcentaje,valor_hora,permiso)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_centro_costo=?,id_empleado=?,fecha=?,porcentaje=?,valor_hora=?,permiso=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select asistenciaporcentrocosto from "+AsistenciaPorCentroCostoConstantesFunciones.SPERSISTENCENAME+" asistenciaporcentrocosto";
	public static String QUERYSELECTNATIVE="select "+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".id,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".version_row,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".id_empresa,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".id_centro_costo,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".id_empleado,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".fecha,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".porcentaje,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".valor_hora,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".permiso from "+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME;//+" as "+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".id,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".version_row from "+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME;//+" as "+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_centro_costo=?,id_empleado=?,fecha=?,porcentaje=?,valor_hora=?,permiso=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ASISTENCIAPORCENTROCOSTO_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ASISTENCIAPORCENTROCOSTO_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ASISTENCIAPORCENTROCOSTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ASISTENCIAPORCENTROCOSTO_SELECT(?,?)";
	
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
	
	
	protected AsistenciaPorCentroCostoDataAccessAdditional asistenciaporcentrocostoDataAccessAdditional=null;
	
	public AsistenciaPorCentroCostoDataAccessAdditional getAsistenciaPorCentroCostoDataAccessAdditional() {
		return this.asistenciaporcentrocostoDataAccessAdditional;
	}
	
	public void setAsistenciaPorCentroCostoDataAccessAdditional(AsistenciaPorCentroCostoDataAccessAdditional asistenciaporcentrocostoDataAccessAdditional) {
		try {
			this.asistenciaporcentrocostoDataAccessAdditional=asistenciaporcentrocostoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AsistenciaPorCentroCostoDataAccess() {
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
		AsistenciaPorCentroCostoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AsistenciaPorCentroCostoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AsistenciaPorCentroCostoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAsistenciaPorCentroCostoOriginal(AsistenciaPorCentroCosto asistenciaporcentrocosto)throws Exception  {
		asistenciaporcentrocosto.setAsistenciaPorCentroCostoOriginal((AsistenciaPorCentroCosto)asistenciaporcentrocosto.clone());		
	}
	
	public void setAsistenciaPorCentroCostosOriginal(List<AsistenciaPorCentroCosto> asistenciaporcentrocostos)throws Exception  {
		
		for(AsistenciaPorCentroCosto asistenciaporcentrocosto:asistenciaporcentrocostos){
			asistenciaporcentrocosto.setAsistenciaPorCentroCostoOriginal((AsistenciaPorCentroCosto)asistenciaporcentrocosto.clone());
		}
	}
	
	public static void setAsistenciaPorCentroCostoOriginalStatic(AsistenciaPorCentroCosto asistenciaporcentrocosto)throws Exception  {
		asistenciaporcentrocosto.setAsistenciaPorCentroCostoOriginal((AsistenciaPorCentroCosto)asistenciaporcentrocosto.clone());		
	}
	
	public static void setAsistenciaPorCentroCostosOriginalStatic(List<AsistenciaPorCentroCosto> asistenciaporcentrocostos)throws Exception  {
		
		for(AsistenciaPorCentroCosto asistenciaporcentrocosto:asistenciaporcentrocostos){
			asistenciaporcentrocosto.setAsistenciaPorCentroCostoOriginal((AsistenciaPorCentroCosto)asistenciaporcentrocosto.clone());
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
	
	public  AsistenciaPorCentroCosto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		
		
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
	
	public  AsistenciaPorCentroCosto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.AsistenciaPorCentroCosto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAsistenciaPorCentroCostoOriginal(new AsistenciaPorCentroCosto());
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAsistenciaPorCentroCosto("",entity,resultSet); 
				
				//entity.setAsistenciaPorCentroCostoOriginal(super.getEntity("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaPorCentroCostoOriginal(this.getEntityAsistenciaPorCentroCosto("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAsistenciaPorCentroCosto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AsistenciaPorCentroCosto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();
				
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
	
	public  AsistenciaPorCentroCosto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaPorCentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.AsistenciaPorCentroCosto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAsistenciaPorCentroCostoOriginal(new AsistenciaPorCentroCosto());
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAsistenciaPorCentroCosto("",entity,resultSet);    
				
				//entity.setAsistenciaPorCentroCostoOriginal(super.getEntity("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaPorCentroCostoOriginal(this.getEntityAsistenciaPorCentroCosto("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAsistenciaPorCentroCosto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AsistenciaPorCentroCosto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaPorCentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.AsistenciaPorCentroCosto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAsistenciaPorCentroCosto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AsistenciaPorCentroCosto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AsistenciaPorCentroCosto> entities = new  ArrayList<AsistenciaPorCentroCosto>();
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
		
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
	
	public  List<AsistenciaPorCentroCosto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AsistenciaPorCentroCosto> entities = new  ArrayList<AsistenciaPorCentroCosto>();
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaPorCentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaPorCentroCosto();
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsistenciaPorCentroCosto("",entity,resultSet);
      	    	
				//entity.setAsistenciaPorCentroCostoOriginal( new AsistenciaPorCentroCosto());
      	    	//entity.setAsistenciaPorCentroCostoOriginal(super.getEntity("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaPorCentroCostoOriginal(this.getEntityAsistenciaPorCentroCosto("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsistenciaPorCentroCostos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaPorCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AsistenciaPorCentroCosto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AsistenciaPorCentroCosto> entities = new  ArrayList<AsistenciaPorCentroCosto>();
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
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
	
	public  List<AsistenciaPorCentroCosto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AsistenciaPorCentroCosto> entities = new  ArrayList<AsistenciaPorCentroCosto>();
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaPorCentroCosto();
				
				if(conMapGenerico) {
					entity.inicializarMapAsistenciaPorCentroCosto();
					//entity.setMapAsistenciaPorCentroCosto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAsistenciaPorCentroCostoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAsistenciaPorCentroCosto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA);         		
					entity=AsistenciaPorCentroCostoDataAccess.getEntityAsistenciaPorCentroCosto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAsistenciaPorCentroCostoOriginal( new AsistenciaPorCentroCosto());
					////entity.setAsistenciaPorCentroCostoOriginal(super.getEntity("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA));         		
					////entity.setAsistenciaPorCentroCostoOriginal(this.getEntityAsistenciaPorCentroCosto("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsistenciaPorCentroCostos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaPorCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AsistenciaPorCentroCosto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
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
	
	public  AsistenciaPorCentroCosto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaPorCentroCosto();
				
				if(conMapGenerico) {
					entity.inicializarMapAsistenciaPorCentroCosto();
					//entity.setMapAsistenciaPorCentroCosto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAsistenciaPorCentroCostoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAsistenciaPorCentroCosto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA);         		
					entity=AsistenciaPorCentroCostoDataAccess.getEntityAsistenciaPorCentroCosto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAsistenciaPorCentroCostoOriginal( new AsistenciaPorCentroCosto());
					////entity.setAsistenciaPorCentroCostoOriginal(super.getEntity("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA));         		
					////entity.setAsistenciaPorCentroCostoOriginal(this.getEntityAsistenciaPorCentroCosto("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAsistenciaPorCentroCosto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaPorCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AsistenciaPorCentroCosto getEntityAsistenciaPorCentroCosto(String strPrefijo,AsistenciaPorCentroCosto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AsistenciaPorCentroCosto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AsistenciaPorCentroCosto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AsistenciaPorCentroCostoDataAccess.setFieldReflectionAsistenciaPorCentroCosto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAsistenciaPorCentroCosto=AsistenciaPorCentroCostoConstantesFunciones.getTodosTiposColumnasAsistenciaPorCentroCosto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAsistenciaPorCentroCosto) {
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
							field = AsistenciaPorCentroCosto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AsistenciaPorCentroCosto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AsistenciaPorCentroCostoDataAccess.setFieldReflectionAsistenciaPorCentroCosto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAsistenciaPorCentroCosto(Field field,String strPrefijo,String sColumn,AsistenciaPorCentroCosto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AsistenciaPorCentroCostoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaPorCentroCostoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsistenciaPorCentroCostoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AsistenciaPorCentroCostoConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaPorCentroCostoConstantesFunciones.VALORHORA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsistenciaPorCentroCostoConstantesFunciones.PERMISO:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AsistenciaPorCentroCosto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AsistenciaPorCentroCosto> entities = new  ArrayList<AsistenciaPorCentroCosto>();
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaPorCentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AsistenciaPorCentroCosto();
					entity=super.getEntity("",entity,resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAsistenciaPorCentroCosto("",entity,resultSet);
					
					//entity.setAsistenciaPorCentroCostoOriginal( new AsistenciaPorCentroCosto());
					//entity.setAsistenciaPorCentroCostoOriginal(super.getEntity("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA));         		
					//entity.setAsistenciaPorCentroCostoOriginal(this.getEntityAsistenciaPorCentroCosto("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAsistenciaPorCentroCostos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaPorCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AsistenciaPorCentroCosto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AsistenciaPorCentroCosto> entities = new  ArrayList<AsistenciaPorCentroCosto>();
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsistenciaPorCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsistenciaPorCentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AsistenciaPorCentroCosto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaPorCentroCosto> entities = new  ArrayList<AsistenciaPorCentroCosto>();
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
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
	
	public  List<AsistenciaPorCentroCosto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaPorCentroCosto> entities = new  ArrayList<AsistenciaPorCentroCosto>();
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaPorCentroCosto();
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsistenciaPorCentroCosto("",entity,resultSet);
      	    	
				//entity.setAsistenciaPorCentroCostoOriginal( new AsistenciaPorCentroCosto());
      	    	//entity.setAsistenciaPorCentroCostoOriginal(super.getEntity("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaPorCentroCostoOriginal(this.getEntityAsistenciaPorCentroCosto("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAsistenciaPorCentroCostos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsistenciaPorCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AsistenciaPorCentroCosto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaPorCentroCosto> entities = new  ArrayList<AsistenciaPorCentroCosto>();
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
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
	
	public  List<AsistenciaPorCentroCosto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsistenciaPorCentroCosto> entities = new  ArrayList<AsistenciaPorCentroCosto>();
		AsistenciaPorCentroCosto entity = new AsistenciaPorCentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsistenciaPorCentroCosto();
      	    	entity=super.getEntity("",entity,resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsistenciaPorCentroCosto("",entity,resultSet);
      	    	
				//entity.setAsistenciaPorCentroCostoOriginal( new AsistenciaPorCentroCosto());
      	    	//entity.setAsistenciaPorCentroCostoOriginal(super.getEntity("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet,AsistenciaPorCentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsistenciaPorCentroCostoOriginal(this.getEntityAsistenciaPorCentroCosto("",entity.getAsistenciaPorCentroCostoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsistenciaPorCentroCostos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AsistenciaPorCentroCosto getEntityAsistenciaPorCentroCosto(String strPrefijo,AsistenciaPorCentroCosto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_empleado(resultSet.getLong(strPrefijo+AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+AsistenciaPorCentroCostoConstantesFunciones.FECHA).getTime()));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+AsistenciaPorCentroCostoConstantesFunciones.PORCENTAJE));
				entity.setvalor_hora(resultSet.getDouble(strPrefijo+AsistenciaPorCentroCostoConstantesFunciones.VALORHORA));
				entity.setpermiso(resultSet.getDouble(strPrefijo+AsistenciaPorCentroCostoConstantesFunciones.PERMISO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAsistenciaPorCentroCosto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AsistenciaPorCentroCosto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AsistenciaPorCentroCostoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AsistenciaPorCentroCostoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AsistenciaPorCentroCostoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AsistenciaPorCentroCostoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AsistenciaPorCentroCostoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AsistenciaPorCentroCostoDataAccess.TABLENAME,AsistenciaPorCentroCostoDataAccess.ISWITHSTOREPROCEDURES);
			
			AsistenciaPorCentroCostoDataAccess.setAsistenciaPorCentroCostoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,AsistenciaPorCentroCosto relasistenciaporcentrocosto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relasistenciaporcentrocosto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public CentroCosto getCentroCosto(Connexion connexion,AsistenciaPorCentroCosto relasistenciaporcentrocosto)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relasistenciaporcentrocosto.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Empleado getEmpleado(Connexion connexion,AsistenciaPorCentroCosto relasistenciaporcentrocosto)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relasistenciaporcentrocosto.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AsistenciaPorCentroCosto asistenciaporcentrocosto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!asistenciaporcentrocosto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(asistenciaporcentrocosto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(asistenciaporcentrocosto.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(asistenciaporcentrocosto.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(asistenciaporcentrocosto.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(asistenciaporcentrocosto.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_hora=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_hora.setValue(asistenciaporcentrocosto.getvalor_hora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_hora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuepermiso=new ParameterValue<Double>();
					parameterMaintenanceValuepermiso.setValue(asistenciaporcentrocosto.getpermiso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepermiso);
					parametersTemp.add(parameterMaintenance);
					
						if(!asistenciaporcentrocosto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(asistenciaporcentrocosto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(asistenciaporcentrocosto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(asistenciaporcentrocosto.getId());
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
	
	public void setIsNewIsChangedFalseAsistenciaPorCentroCosto(AsistenciaPorCentroCosto asistenciaporcentrocosto)throws Exception  {		
		asistenciaporcentrocosto.setIsNew(false);
		asistenciaporcentrocosto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAsistenciaPorCentroCostos(List<AsistenciaPorCentroCosto> asistenciaporcentrocostos)throws Exception  {				
		for(AsistenciaPorCentroCosto asistenciaporcentrocosto:asistenciaporcentrocostos) {
			asistenciaporcentrocosto.setIsNew(false);
			asistenciaporcentrocosto.setIsChanged(false);
		}
	}
	
	public void generarExportarAsistenciaPorCentroCosto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
