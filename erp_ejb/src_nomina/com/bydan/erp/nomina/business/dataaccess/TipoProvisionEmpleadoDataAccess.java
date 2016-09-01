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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//TipoProvisionEmpleadoConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoProvisionEmpleadoDataAccess extends  TipoProvisionEmpleadoDataAccessAdditional{ //TipoProvisionEmpleadoDataAccessAdditional,DataAccessHelper<TipoProvisionEmpleado>
	//static Logger logger = Logger.getLogger(TipoProvisionEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_provision_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoprovisionempleado from "+TipoProvisionEmpleadoConstantesFunciones.SPERSISTENCENAME+" tipoprovisionempleado";
	public static String QUERYSELECTNATIVE="select "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+".id,"+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+".codigo,"+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+".nombre from "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME;//+" as "+TipoProvisionEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+".id,"+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+".codigo from "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME;//+" as "+TipoProvisionEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+"."+TipoProvisionEmpleadoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPROVISIONEMPLEADO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPROVISIONEMPLEADO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPROVISIONEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPROVISIONEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected TipoProvisionEmpleadoDataAccessAdditional tipoprovisionempleadoDataAccessAdditional=null;
	
	public TipoProvisionEmpleadoDataAccessAdditional getTipoProvisionEmpleadoDataAccessAdditional() {
		return this.tipoprovisionempleadoDataAccessAdditional;
	}
	
	public void setTipoProvisionEmpleadoDataAccessAdditional(TipoProvisionEmpleadoDataAccessAdditional tipoprovisionempleadoDataAccessAdditional) {
		try {
			this.tipoprovisionempleadoDataAccessAdditional=tipoprovisionempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoProvisionEmpleadoDataAccess() {
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
		TipoProvisionEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoProvisionEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoProvisionEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoProvisionEmpleadoOriginal(TipoProvisionEmpleado tipoprovisionempleado)throws Exception  {
		tipoprovisionempleado.setTipoProvisionEmpleadoOriginal((TipoProvisionEmpleado)tipoprovisionempleado.clone());		
	}
	
	public void setTipoProvisionEmpleadosOriginal(List<TipoProvisionEmpleado> tipoprovisionempleados)throws Exception  {
		
		for(TipoProvisionEmpleado tipoprovisionempleado:tipoprovisionempleados){
			tipoprovisionempleado.setTipoProvisionEmpleadoOriginal((TipoProvisionEmpleado)tipoprovisionempleado.clone());
		}
	}
	
	public static void setTipoProvisionEmpleadoOriginalStatic(TipoProvisionEmpleado tipoprovisionempleado)throws Exception  {
		tipoprovisionempleado.setTipoProvisionEmpleadoOriginal((TipoProvisionEmpleado)tipoprovisionempleado.clone());		
	}
	
	public static void setTipoProvisionEmpleadosOriginalStatic(List<TipoProvisionEmpleado> tipoprovisionempleados)throws Exception  {
		
		for(TipoProvisionEmpleado tipoprovisionempleado:tipoprovisionempleados){
			tipoprovisionempleado.setTipoProvisionEmpleadoOriginal((TipoProvisionEmpleado)tipoprovisionempleado.clone());
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
	
	public  TipoProvisionEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		
		
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
	
	public  TipoProvisionEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.TipoProvisionEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoProvisionEmpleadoOriginal(new TipoProvisionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoProvisionEmpleado("",entity,resultSet); 
				
				//entity.setTipoProvisionEmpleadoOriginal(super.getEntity("",entity.getTipoProvisionEmpleadoOriginal(),resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProvisionEmpleadoOriginal(this.getEntityTipoProvisionEmpleado("",entity.getTipoProvisionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoProvisionEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoProvisionEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();
				
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
	
	public  TipoProvisionEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoProvisionEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoProvisionEmpleadoOriginal(new TipoProvisionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoProvisionEmpleado("",entity,resultSet);    
				
				//entity.setTipoProvisionEmpleadoOriginal(super.getEntity("",entity.getTipoProvisionEmpleadoOriginal(),resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProvisionEmpleadoOriginal(this.getEntityTipoProvisionEmpleado("",entity.getTipoProvisionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoProvisionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoProvisionEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoProvisionEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoProvisionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoProvisionEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoProvisionEmpleado> entities = new  ArrayList<TipoProvisionEmpleado>();
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
		
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
	
	public  List<TipoProvisionEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoProvisionEmpleado> entities = new  ArrayList<TipoProvisionEmpleado>();
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProvisionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoProvisionEmpleado("",entity,resultSet);
      	    	
				//entity.setTipoProvisionEmpleadoOriginal( new TipoProvisionEmpleado());
      	    	//entity.setTipoProvisionEmpleadoOriginal(super.getEntity("",entity.getTipoProvisionEmpleadoOriginal(),resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProvisionEmpleadoOriginal(this.getEntityTipoProvisionEmpleado("",entity.getTipoProvisionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoProvisionEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoProvisionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoProvisionEmpleado> entities = new  ArrayList<TipoProvisionEmpleado>();
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
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
	
	public  List<TipoProvisionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoProvisionEmpleado> entities = new  ArrayList<TipoProvisionEmpleado>();
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProvisionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoProvisionEmpleado();
					//entity.setMapTipoProvisionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoProvisionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoProvisionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=TipoProvisionEmpleadoDataAccess.getEntityTipoProvisionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoProvisionEmpleadoOriginal( new TipoProvisionEmpleado());
					////entity.setTipoProvisionEmpleadoOriginal(super.getEntity("",entity.getTipoProvisionEmpleadoOriginal(),resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoProvisionEmpleadoOriginal(this.getEntityTipoProvisionEmpleado("",entity.getTipoProvisionEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoProvisionEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoProvisionEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
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
	
	public  TipoProvisionEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProvisionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoProvisionEmpleado();
					//entity.setMapTipoProvisionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoProvisionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoProvisionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=TipoProvisionEmpleadoDataAccess.getEntityTipoProvisionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoProvisionEmpleadoOriginal( new TipoProvisionEmpleado());
					////entity.setTipoProvisionEmpleadoOriginal(super.getEntity("",entity.getTipoProvisionEmpleadoOriginal(),resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoProvisionEmpleadoOriginal(this.getEntityTipoProvisionEmpleado("",entity.getTipoProvisionEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoProvisionEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoProvisionEmpleado getEntityTipoProvisionEmpleado(String strPrefijo,TipoProvisionEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoProvisionEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoProvisionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoProvisionEmpleadoDataAccess.setFieldReflectionTipoProvisionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoProvisionEmpleado=TipoProvisionEmpleadoConstantesFunciones.getTodosTiposColumnasTipoProvisionEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoProvisionEmpleado) {
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
							field = TipoProvisionEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoProvisionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoProvisionEmpleadoDataAccess.setFieldReflectionTipoProvisionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoProvisionEmpleado(Field field,String strPrefijo,String sColumn,TipoProvisionEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoProvisionEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoProvisionEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoProvisionEmpleadoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoProvisionEmpleadoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoProvisionEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoProvisionEmpleado> entities = new  ArrayList<TipoProvisionEmpleado>();
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoProvisionEmpleado();
					entity=super.getEntity("",entity,resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoProvisionEmpleado("",entity,resultSet);
					
					//entity.setTipoProvisionEmpleadoOriginal( new TipoProvisionEmpleado());
					//entity.setTipoProvisionEmpleadoOriginal(super.getEntity("",entity.getTipoProvisionEmpleadoOriginal(),resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoProvisionEmpleadoOriginal(this.getEntityTipoProvisionEmpleado("",entity.getTipoProvisionEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoProvisionEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoProvisionEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoProvisionEmpleado> entities = new  ArrayList<TipoProvisionEmpleado>();
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoProvisionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoProvisionEmpleado> entities = new  ArrayList<TipoProvisionEmpleado>();
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
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
	
	public  List<TipoProvisionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoProvisionEmpleado> entities = new  ArrayList<TipoProvisionEmpleado>();
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProvisionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoProvisionEmpleado("",entity,resultSet);
      	    	
				//entity.setTipoProvisionEmpleadoOriginal( new TipoProvisionEmpleado());
      	    	//entity.setTipoProvisionEmpleadoOriginal(super.getEntity("",entity.getTipoProvisionEmpleadoOriginal(),resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProvisionEmpleadoOriginal(this.getEntityTipoProvisionEmpleado("",entity.getTipoProvisionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoProvisionEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoProvisionEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoProvisionEmpleado> entities = new  ArrayList<TipoProvisionEmpleado>();
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
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
	
	public  List<TipoProvisionEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoProvisionEmpleado> entities = new  ArrayList<TipoProvisionEmpleado>();
		TipoProvisionEmpleado entity = new TipoProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProvisionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoProvisionEmpleado("",entity,resultSet);
      	    	
				//entity.setTipoProvisionEmpleadoOriginal( new TipoProvisionEmpleado());
      	    	//entity.setTipoProvisionEmpleadoOriginal(super.getEntity("",entity.getTipoProvisionEmpleadoOriginal(),resultSet,TipoProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProvisionEmpleadoOriginal(this.getEntityTipoProvisionEmpleado("",entity.getTipoProvisionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoProvisionEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoProvisionEmpleado getEntityTipoProvisionEmpleado(String strPrefijo,TipoProvisionEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoProvisionEmpleadoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoProvisionEmpleadoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoProvisionEmpleadoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoProvisionEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoProvisionEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoProvisionEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoProvisionEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoProvisionEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoProvisionEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoProvisionEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoProvisionEmpleadoDataAccess.TABLENAME,TipoProvisionEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoProvisionEmpleadoDataAccess.setTipoProvisionEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<ProvisionEmpleado> getProvisionEmpleados(Connexion connexion,TipoProvisionEmpleado tipoprovisionempleado)throws SQLException,Exception {

		List<ProvisionEmpleado> provisionempleados= new ArrayList<ProvisionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+".tipo_provision_empleado ON "+ProvisionEmpleadoConstantesFunciones.SCHEMA+".provision_empleado.id_tipo_provision_empleado="+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+".tipo_provision_empleado.id WHERE "+TipoProvisionEmpleadoConstantesFunciones.SCHEMA+".tipo_provision_empleado.id="+String.valueOf(tipoprovisionempleado.getId());
			} else {
				sQuery=" INNER JOIN provisionempleado.TipoProvisionEmpleado WHERE provisionempleado.TipoProvisionEmpleado.id="+String.valueOf(tipoprovisionempleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProvisionEmpleadoDataAccess provisionempleadoDataAccess=new ProvisionEmpleadoDataAccess();

			provisionempleadoDataAccess.setConnexionType(this.connexionType);
			provisionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return provisionempleados;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoProvisionEmpleado tipoprovisionempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoprovisionempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoprovisionempleado.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipoprovisionempleado.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoprovisionempleado.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoprovisionempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoprovisionempleado.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoprovisionempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoprovisionempleado.getId());
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
	
	public void setIsNewIsChangedFalseTipoProvisionEmpleado(TipoProvisionEmpleado tipoprovisionempleado)throws Exception  {		
		tipoprovisionempleado.setIsNew(false);
		tipoprovisionempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoProvisionEmpleados(List<TipoProvisionEmpleado> tipoprovisionempleados)throws Exception  {				
		for(TipoProvisionEmpleado tipoprovisionempleado:tipoprovisionempleados) {
			tipoprovisionempleado.setIsNew(false);
			tipoprovisionempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoProvisionEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
