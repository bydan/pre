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
import com.bydan.erp.nomina.util.*;//EstadoGastoEmpleadoConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoGastoEmpleadoDataAccess extends  EstadoGastoEmpleadoDataAccessAdditional{ //EstadoGastoEmpleadoDataAccessAdditional,DataAccessHelper<EstadoGastoEmpleado>
	//static Logger logger = Logger.getLogger(EstadoGastoEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_gasto_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadogastoempleado from "+EstadoGastoEmpleadoConstantesFunciones.SPERSISTENCENAME+" estadogastoempleado";
	public static String QUERYSELECTNATIVE="select "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+".id,"+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+".version_row,"+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+".codigo,"+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+".nombre from "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME;//+" as "+EstadoGastoEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+".id,"+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+".version_row,"+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+".codigo from "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME;//+" as "+EstadoGastoEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+"."+EstadoGastoEmpleadoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOGASTOEMPLEADO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOGASTOEMPLEADO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOGASTOEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOGASTOEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected EstadoGastoEmpleadoDataAccessAdditional estadogastoempleadoDataAccessAdditional=null;
	
	public EstadoGastoEmpleadoDataAccessAdditional getEstadoGastoEmpleadoDataAccessAdditional() {
		return this.estadogastoempleadoDataAccessAdditional;
	}
	
	public void setEstadoGastoEmpleadoDataAccessAdditional(EstadoGastoEmpleadoDataAccessAdditional estadogastoempleadoDataAccessAdditional) {
		try {
			this.estadogastoempleadoDataAccessAdditional=estadogastoempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoGastoEmpleadoDataAccess() {
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
		EstadoGastoEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoGastoEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoGastoEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoGastoEmpleadoOriginal(EstadoGastoEmpleado estadogastoempleado)throws Exception  {
		estadogastoempleado.setEstadoGastoEmpleadoOriginal((EstadoGastoEmpleado)estadogastoempleado.clone());		
	}
	
	public void setEstadoGastoEmpleadosOriginal(List<EstadoGastoEmpleado> estadogastoempleados)throws Exception  {
		
		for(EstadoGastoEmpleado estadogastoempleado:estadogastoempleados){
			estadogastoempleado.setEstadoGastoEmpleadoOriginal((EstadoGastoEmpleado)estadogastoempleado.clone());
		}
	}
	
	public static void setEstadoGastoEmpleadoOriginalStatic(EstadoGastoEmpleado estadogastoempleado)throws Exception  {
		estadogastoempleado.setEstadoGastoEmpleadoOriginal((EstadoGastoEmpleado)estadogastoempleado.clone());		
	}
	
	public static void setEstadoGastoEmpleadosOriginalStatic(List<EstadoGastoEmpleado> estadogastoempleados)throws Exception  {
		
		for(EstadoGastoEmpleado estadogastoempleado:estadogastoempleados){
			estadogastoempleado.setEstadoGastoEmpleadoOriginal((EstadoGastoEmpleado)estadogastoempleado.clone());
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
	
	public  EstadoGastoEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		
		
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
	
	public  EstadoGastoEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EstadoGastoEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoGastoEmpleadoOriginal(new EstadoGastoEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoGastoEmpleado("",entity,resultSet); 
				
				//entity.setEstadoGastoEmpleadoOriginal(super.getEntity("",entity.getEstadoGastoEmpleadoOriginal(),resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoGastoEmpleadoOriginal(this.getEntityEstadoGastoEmpleado("",entity.getEstadoGastoEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoGastoEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoGastoEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();
				
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
	
	public  EstadoGastoEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoGastoEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EstadoGastoEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoGastoEmpleadoOriginal(new EstadoGastoEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoGastoEmpleado("",entity,resultSet);    
				
				//entity.setEstadoGastoEmpleadoOriginal(super.getEntity("",entity.getEstadoGastoEmpleadoOriginal(),resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoGastoEmpleadoOriginal(this.getEntityEstadoGastoEmpleado("",entity.getEstadoGastoEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoGastoEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoGastoEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoGastoEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EstadoGastoEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoGastoEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoGastoEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoGastoEmpleado> entities = new  ArrayList<EstadoGastoEmpleado>();
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
		
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
	
	public  List<EstadoGastoEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoGastoEmpleado> entities = new  ArrayList<EstadoGastoEmpleado>();
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoGastoEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoGastoEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoGastoEmpleado("",entity,resultSet);
      	    	
				//entity.setEstadoGastoEmpleadoOriginal( new EstadoGastoEmpleado());
      	    	//entity.setEstadoGastoEmpleadoOriginal(super.getEntity("",entity.getEstadoGastoEmpleadoOriginal(),resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoGastoEmpleadoOriginal(this.getEntityEstadoGastoEmpleado("",entity.getEstadoGastoEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoGastoEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoGastoEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoGastoEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoGastoEmpleado> entities = new  ArrayList<EstadoGastoEmpleado>();
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
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
	
	public  List<EstadoGastoEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoGastoEmpleado> entities = new  ArrayList<EstadoGastoEmpleado>();
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoGastoEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoGastoEmpleado();
					//entity.setMapEstadoGastoEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoGastoEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoGastoEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoGastoEmpleadoDataAccess.getEntityEstadoGastoEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoGastoEmpleadoOriginal( new EstadoGastoEmpleado());
					////entity.setEstadoGastoEmpleadoOriginal(super.getEntity("",entity.getEstadoGastoEmpleadoOriginal(),resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoGastoEmpleadoOriginal(this.getEntityEstadoGastoEmpleado("",entity.getEstadoGastoEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoGastoEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoGastoEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoGastoEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
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
	
	public  EstadoGastoEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoGastoEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoGastoEmpleado();
					//entity.setMapEstadoGastoEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoGastoEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoGastoEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoGastoEmpleadoDataAccess.getEntityEstadoGastoEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoGastoEmpleadoOriginal( new EstadoGastoEmpleado());
					////entity.setEstadoGastoEmpleadoOriginal(super.getEntity("",entity.getEstadoGastoEmpleadoOriginal(),resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoGastoEmpleadoOriginal(this.getEntityEstadoGastoEmpleado("",entity.getEstadoGastoEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoGastoEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoGastoEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoGastoEmpleado getEntityEstadoGastoEmpleado(String strPrefijo,EstadoGastoEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoGastoEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoGastoEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoGastoEmpleadoDataAccess.setFieldReflectionEstadoGastoEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoGastoEmpleado=EstadoGastoEmpleadoConstantesFunciones.getTodosTiposColumnasEstadoGastoEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoGastoEmpleado) {
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
							field = EstadoGastoEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoGastoEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoGastoEmpleadoDataAccess.setFieldReflectionEstadoGastoEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoGastoEmpleado(Field field,String strPrefijo,String sColumn,EstadoGastoEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoGastoEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoGastoEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoGastoEmpleadoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoGastoEmpleadoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoGastoEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoGastoEmpleado> entities = new  ArrayList<EstadoGastoEmpleado>();
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoGastoEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoGastoEmpleado();
					entity=super.getEntity("",entity,resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoGastoEmpleado("",entity,resultSet);
					
					//entity.setEstadoGastoEmpleadoOriginal( new EstadoGastoEmpleado());
					//entity.setEstadoGastoEmpleadoOriginal(super.getEntity("",entity.getEstadoGastoEmpleadoOriginal(),resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoGastoEmpleadoOriginal(this.getEntityEstadoGastoEmpleado("",entity.getEstadoGastoEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoGastoEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoGastoEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoGastoEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoGastoEmpleado> entities = new  ArrayList<EstadoGastoEmpleado>();
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoGastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoGastoEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoGastoEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoGastoEmpleado> entities = new  ArrayList<EstadoGastoEmpleado>();
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
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
	
	public  List<EstadoGastoEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoGastoEmpleado> entities = new  ArrayList<EstadoGastoEmpleado>();
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoGastoEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoGastoEmpleado("",entity,resultSet);
      	    	
				//entity.setEstadoGastoEmpleadoOriginal( new EstadoGastoEmpleado());
      	    	//entity.setEstadoGastoEmpleadoOriginal(super.getEntity("",entity.getEstadoGastoEmpleadoOriginal(),resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoGastoEmpleadoOriginal(this.getEntityEstadoGastoEmpleado("",entity.getEstadoGastoEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoGastoEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoGastoEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoGastoEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoGastoEmpleado> entities = new  ArrayList<EstadoGastoEmpleado>();
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
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
	
	public  List<EstadoGastoEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoGastoEmpleado> entities = new  ArrayList<EstadoGastoEmpleado>();
		EstadoGastoEmpleado entity = new EstadoGastoEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoGastoEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoGastoEmpleado("",entity,resultSet);
      	    	
				//entity.setEstadoGastoEmpleadoOriginal( new EstadoGastoEmpleado());
      	    	//entity.setEstadoGastoEmpleadoOriginal(super.getEntity("",entity.getEstadoGastoEmpleadoOriginal(),resultSet,EstadoGastoEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoGastoEmpleadoOriginal(this.getEntityEstadoGastoEmpleado("",entity.getEstadoGastoEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoGastoEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoGastoEmpleado getEntityEstadoGastoEmpleado(String strPrefijo,EstadoGastoEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoGastoEmpleadoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoGastoEmpleadoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoGastoEmpleadoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoGastoEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoGastoEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoGastoEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoGastoEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoGastoEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoGastoEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoGastoEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoGastoEmpleadoDataAccess.TABLENAME,EstadoGastoEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoGastoEmpleadoDataAccess.setEstadoGastoEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<GastoEmpleado> getGastoEmpleados(Connexion connexion,EstadoGastoEmpleado estadogastoempleado)throws SQLException,Exception {

		List<GastoEmpleado> gastoempleados= new ArrayList<GastoEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+".estado_gasto_empleado ON "+GastoEmpleadoConstantesFunciones.SCHEMA+".gasto_empleado.id_estado_gasto_empleado="+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+".estado_gasto_empleado.id WHERE "+EstadoGastoEmpleadoConstantesFunciones.SCHEMA+".estado_gasto_empleado.id="+String.valueOf(estadogastoempleado.getId());
			} else {
				sQuery=" INNER JOIN gastoempleado.EstadoGastoEmpleado WHERE gastoempleado.EstadoGastoEmpleado.id="+String.valueOf(estadogastoempleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GastoEmpleadoDataAccess gastoempleadoDataAccess=new GastoEmpleadoDataAccess();

			gastoempleadoDataAccess.setConnexionType(this.connexionType);
			gastoempleadoDataAccess.setParameterDbType(this.parameterDbType);
			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return gastoempleados;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoGastoEmpleado estadogastoempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadogastoempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadogastoempleado.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadogastoempleado.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadogastoempleado.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadogastoempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadogastoempleado.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadogastoempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadogastoempleado.getId());
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
	
	public void setIsNewIsChangedFalseEstadoGastoEmpleado(EstadoGastoEmpleado estadogastoempleado)throws Exception  {		
		estadogastoempleado.setIsNew(false);
		estadogastoempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoGastoEmpleados(List<EstadoGastoEmpleado> estadogastoempleados)throws Exception  {				
		for(EstadoGastoEmpleado estadogastoempleado:estadogastoempleados) {
			estadogastoempleado.setIsNew(false);
			estadogastoempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoGastoEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
