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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//TransaccionIngresoEgresoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class TransaccionIngresoEgresoDataAccess extends  TransaccionIngresoEgresoDataAccessAdditional{ //TransaccionIngresoEgresoDataAccessAdditional,DataAccessHelper<TransaccionIngresoEgreso>
	//static Logger logger = Logger.getLogger(TransaccionIngresoEgresoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="transaccion_ingreso_egreso";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_modulo,id_transaccion,es_ingreso)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,id_transaccion=?,es_ingreso=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select transaccioningresoegreso from "+TransaccionIngresoEgresoConstantesFunciones.SPERSISTENCENAME+" transaccioningresoegreso";
	public static String QUERYSELECTNATIVE="select "+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".id,"+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".version_row,"+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".id_empresa,"+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".id_modulo,"+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".id_transaccion,"+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".es_ingreso from "+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME;//+" as "+TransaccionIngresoEgresoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".id,"+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".version_row from "+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME;//+" as "+TransaccionIngresoEgresoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,id_transaccion=?,es_ingreso=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TRANSACCIONINGRESOEGRESO_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TRANSACCIONINGRESOEGRESO_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TRANSACCIONINGRESOEGRESO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TRANSACCIONINGRESOEGRESO_SELECT(?,?)";
	
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
	
	
	protected TransaccionIngresoEgresoDataAccessAdditional transaccioningresoegresoDataAccessAdditional=null;
	
	public TransaccionIngresoEgresoDataAccessAdditional getTransaccionIngresoEgresoDataAccessAdditional() {
		return this.transaccioningresoegresoDataAccessAdditional;
	}
	
	public void setTransaccionIngresoEgresoDataAccessAdditional(TransaccionIngresoEgresoDataAccessAdditional transaccioningresoegresoDataAccessAdditional) {
		try {
			this.transaccioningresoegresoDataAccessAdditional=transaccioningresoegresoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TransaccionIngresoEgresoDataAccess() {
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
		TransaccionIngresoEgresoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TransaccionIngresoEgresoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TransaccionIngresoEgresoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTransaccionIngresoEgresoOriginal(TransaccionIngresoEgreso transaccioningresoegreso)throws Exception  {
		transaccioningresoegreso.setTransaccionIngresoEgresoOriginal((TransaccionIngresoEgreso)transaccioningresoegreso.clone());		
	}
	
	public void setTransaccionIngresoEgresosOriginal(List<TransaccionIngresoEgreso> transaccioningresoegresos)throws Exception  {
		
		for(TransaccionIngresoEgreso transaccioningresoegreso:transaccioningresoegresos){
			transaccioningresoegreso.setTransaccionIngresoEgresoOriginal((TransaccionIngresoEgreso)transaccioningresoegreso.clone());
		}
	}
	
	public static void setTransaccionIngresoEgresoOriginalStatic(TransaccionIngresoEgreso transaccioningresoegreso)throws Exception  {
		transaccioningresoegreso.setTransaccionIngresoEgresoOriginal((TransaccionIngresoEgreso)transaccioningresoegreso.clone());		
	}
	
	public static void setTransaccionIngresoEgresosOriginalStatic(List<TransaccionIngresoEgreso> transaccioningresoegresos)throws Exception  {
		
		for(TransaccionIngresoEgreso transaccioningresoegreso:transaccioningresoegresos){
			transaccioningresoegreso.setTransaccionIngresoEgresoOriginal((TransaccionIngresoEgreso)transaccioningresoegreso.clone());
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
	
	public  TransaccionIngresoEgreso getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		
		
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
	
	public  TransaccionIngresoEgreso getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.TransaccionIngresoEgreso.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTransaccionIngresoEgresoOriginal(new TransaccionIngresoEgreso());
      	    	entity=super.getEntity("",entity,resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransaccionIngresoEgreso("",entity,resultSet); 
				
				//entity.setTransaccionIngresoEgresoOriginal(super.getEntity("",entity.getTransaccionIngresoEgresoOriginal(),resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionIngresoEgresoOriginal(this.getEntityTransaccionIngresoEgreso("",entity.getTransaccionIngresoEgresoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTransaccionIngresoEgreso(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TransaccionIngresoEgreso getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();
				
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
	
	public  TransaccionIngresoEgreso getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionIngresoEgresoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TransaccionIngresoEgreso.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTransaccionIngresoEgresoOriginal(new TransaccionIngresoEgreso());
      	    	entity=super.getEntity("",entity,resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransaccionIngresoEgreso("",entity,resultSet);    
				
				//entity.setTransaccionIngresoEgresoOriginal(super.getEntity("",entity.getTransaccionIngresoEgresoOriginal(),resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionIngresoEgresoOriginal(this.getEntityTransaccionIngresoEgreso("",entity.getTransaccionIngresoEgresoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTransaccionIngresoEgreso(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TransaccionIngresoEgreso
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionIngresoEgresoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TransaccionIngresoEgreso.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTransaccionIngresoEgreso(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TransaccionIngresoEgreso> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TransaccionIngresoEgreso> entities = new  ArrayList<TransaccionIngresoEgreso>();
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
		
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
	
	public  List<TransaccionIngresoEgreso> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TransaccionIngresoEgreso> entities = new  ArrayList<TransaccionIngresoEgreso>();
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionIngresoEgresoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionIngresoEgreso();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccionIngresoEgreso("",entity,resultSet);
      	    	
				//entity.setTransaccionIngresoEgresoOriginal( new TransaccionIngresoEgreso());
      	    	//entity.setTransaccionIngresoEgresoOriginal(super.getEntity("",entity.getTransaccionIngresoEgresoOriginal(),resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionIngresoEgresoOriginal(this.getEntityTransaccionIngresoEgreso("",entity.getTransaccionIngresoEgresoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccionIngresoEgresos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionIngresoEgreso(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TransaccionIngresoEgreso> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TransaccionIngresoEgreso> entities = new  ArrayList<TransaccionIngresoEgreso>();
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
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
	
	public  List<TransaccionIngresoEgreso> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TransaccionIngresoEgreso> entities = new  ArrayList<TransaccionIngresoEgreso>();
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionIngresoEgreso();
				
				if(conMapGenerico) {
					entity.inicializarMapTransaccionIngresoEgreso();
					//entity.setMapTransaccionIngresoEgreso(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTransaccionIngresoEgresoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransaccionIngresoEgreso().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA);         		
					entity=TransaccionIngresoEgresoDataAccess.getEntityTransaccionIngresoEgreso("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransaccionIngresoEgresoOriginal( new TransaccionIngresoEgreso());
					////entity.setTransaccionIngresoEgresoOriginal(super.getEntity("",entity.getTransaccionIngresoEgresoOriginal(),resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA));         		
					////entity.setTransaccionIngresoEgresoOriginal(this.getEntityTransaccionIngresoEgreso("",entity.getTransaccionIngresoEgresoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccionIngresoEgresos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionIngresoEgreso(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TransaccionIngresoEgreso getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
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
	
	public  TransaccionIngresoEgreso getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionIngresoEgreso();
				
				if(conMapGenerico) {
					entity.inicializarMapTransaccionIngresoEgreso();
					//entity.setMapTransaccionIngresoEgreso(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTransaccionIngresoEgresoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransaccionIngresoEgreso().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA);         		
					entity=TransaccionIngresoEgresoDataAccess.getEntityTransaccionIngresoEgreso("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransaccionIngresoEgresoOriginal( new TransaccionIngresoEgreso());
					////entity.setTransaccionIngresoEgresoOriginal(super.getEntity("",entity.getTransaccionIngresoEgresoOriginal(),resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA));         		
					////entity.setTransaccionIngresoEgresoOriginal(this.getEntityTransaccionIngresoEgreso("",entity.getTransaccionIngresoEgresoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTransaccionIngresoEgreso(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionIngresoEgreso(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TransaccionIngresoEgreso getEntityTransaccionIngresoEgreso(String strPrefijo,TransaccionIngresoEgreso entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TransaccionIngresoEgreso.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TransaccionIngresoEgreso.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TransaccionIngresoEgresoDataAccess.setFieldReflectionTransaccionIngresoEgreso(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTransaccionIngresoEgreso=TransaccionIngresoEgresoConstantesFunciones.getTodosTiposColumnasTransaccionIngresoEgreso();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTransaccionIngresoEgreso) {
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
							field = TransaccionIngresoEgreso.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TransaccionIngresoEgreso.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TransaccionIngresoEgresoDataAccess.setFieldReflectionTransaccionIngresoEgreso(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTransaccionIngresoEgreso(Field field,String strPrefijo,String sColumn,TransaccionIngresoEgreso entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TransaccionIngresoEgresoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionIngresoEgresoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionIngresoEgresoConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionIngresoEgresoConstantesFunciones.ESINGRESO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TransaccionIngresoEgreso>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TransaccionIngresoEgreso> entities = new  ArrayList<TransaccionIngresoEgreso>();
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionIngresoEgresoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TransaccionIngresoEgreso();
					entity=super.getEntity("",entity,resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTransaccionIngresoEgreso("",entity,resultSet);
					
					//entity.setTransaccionIngresoEgresoOriginal( new TransaccionIngresoEgreso());
					//entity.setTransaccionIngresoEgresoOriginal(super.getEntity("",entity.getTransaccionIngresoEgresoOriginal(),resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA));         		
					//entity.setTransaccionIngresoEgresoOriginal(this.getEntityTransaccionIngresoEgreso("",entity.getTransaccionIngresoEgresoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTransaccionIngresoEgresos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionIngresoEgreso(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TransaccionIngresoEgreso>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TransaccionIngresoEgreso> entities = new  ArrayList<TransaccionIngresoEgreso>();
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionIngresoEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionIngresoEgresoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TransaccionIngresoEgreso> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionIngresoEgreso> entities = new  ArrayList<TransaccionIngresoEgreso>();
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
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
	
	public  List<TransaccionIngresoEgreso> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionIngresoEgreso> entities = new  ArrayList<TransaccionIngresoEgreso>();
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionIngresoEgreso();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccionIngresoEgreso("",entity,resultSet);
      	    	
				//entity.setTransaccionIngresoEgresoOriginal( new TransaccionIngresoEgreso());
      	    	//entity.setTransaccionIngresoEgresoOriginal(super.getEntity("",entity.getTransaccionIngresoEgresoOriginal(),resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionIngresoEgresoOriginal(this.getEntityTransaccionIngresoEgreso("",entity.getTransaccionIngresoEgresoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTransaccionIngresoEgresos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionIngresoEgreso(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TransaccionIngresoEgreso> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionIngresoEgreso> entities = new  ArrayList<TransaccionIngresoEgreso>();
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
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
	
	public  List<TransaccionIngresoEgreso> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionIngresoEgreso> entities = new  ArrayList<TransaccionIngresoEgreso>();
		TransaccionIngresoEgreso entity = new TransaccionIngresoEgreso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionIngresoEgreso();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccionIngresoEgreso("",entity,resultSet);
      	    	
				//entity.setTransaccionIngresoEgresoOriginal( new TransaccionIngresoEgreso());
      	    	//entity.setTransaccionIngresoEgresoOriginal(super.getEntity("",entity.getTransaccionIngresoEgresoOriginal(),resultSet,TransaccionIngresoEgresoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionIngresoEgresoOriginal(this.getEntityTransaccionIngresoEgreso("",entity.getTransaccionIngresoEgresoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccionIngresoEgresos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TransaccionIngresoEgreso getEntityTransaccionIngresoEgreso(String strPrefijo,TransaccionIngresoEgreso entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+TransaccionIngresoEgresoConstantesFunciones.IDMODULO));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION));
				entity.setes_ingreso(resultSet.getBoolean(strPrefijo+TransaccionIngresoEgresoConstantesFunciones.ESINGRESO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTransaccionIngresoEgreso(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TransaccionIngresoEgreso entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TransaccionIngresoEgresoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TransaccionIngresoEgresoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TransaccionIngresoEgresoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TransaccionIngresoEgresoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TransaccionIngresoEgresoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TransaccionIngresoEgresoDataAccess.TABLENAME,TransaccionIngresoEgresoDataAccess.ISWITHSTOREPROCEDURES);
			
			TransaccionIngresoEgresoDataAccess.setTransaccionIngresoEgresoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TransaccionIngresoEgreso reltransaccioningresoegreso)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltransaccioningresoegreso.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Modulo getModulo(Connexion connexion,TransaccionIngresoEgreso reltransaccioningresoegreso)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reltransaccioningresoegreso.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Transaccion getTransaccion(Connexion connexion,TransaccionIngresoEgreso reltransaccioningresoegreso)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,reltransaccioningresoegreso.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TransaccionIngresoEgreso transaccioningresoegreso) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!transaccioningresoegreso.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(transaccioningresoegreso.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(transaccioningresoegreso.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(transaccioningresoegreso.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_ingreso=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_ingreso.setValue(transaccioningresoegreso.getes_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_ingreso);
					parametersTemp.add(parameterMaintenance);
					
						if(!transaccioningresoegreso.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(transaccioningresoegreso.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(transaccioningresoegreso.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(transaccioningresoegreso.getId());
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
	
	public void setIsNewIsChangedFalseTransaccionIngresoEgreso(TransaccionIngresoEgreso transaccioningresoegreso)throws Exception  {		
		transaccioningresoegreso.setIsNew(false);
		transaccioningresoegreso.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTransaccionIngresoEgresos(List<TransaccionIngresoEgreso> transaccioningresoegresos)throws Exception  {				
		for(TransaccionIngresoEgreso transaccioningresoegreso:transaccioningresoegresos) {
			transaccioningresoegreso.setIsNew(false);
			transaccioningresoegreso.setIsChanged(false);
		}
	}
	
	public void generarExportarTransaccionIngresoEgreso(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
